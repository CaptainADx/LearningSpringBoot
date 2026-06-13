package com.example.CarService.Controller;

import com.example.CarService.domain.Car;
import com.example.CarService.domain.Vehicle;
import com.example.CarService.service.CarRegistrationService;
import com.example.CarService.service.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    Registration registration;

    @RequestMapping("/register")
    public String getRegistrationPage(Model carModel){
        Vehicle vehicle=registration.getNewCar();
        carModel.addAttribute("Vehicle",vehicle);
        return "carregister";
    }

    
    @RequestMapping("/done")
    public ModelAndView getResponsePage(@ModelAttribute("Vehicle") Car car){
    	int id = registration.registerCar(car.getRegisterationNumber(),car.getCarName(),car.getCarDetails(), car.getCarWork());
    	
    	if(id != -1){
    		return new ModelAndView("redirect:success?id=" + id);
            
        }
        else{
        	ModelAndView mv = new ModelAndView();
        	mv.setViewName("carregister");
        	Vehicle vehicle = registration.getNewCar();
        	mv.addObject("Vehicle",vehicle);
        	return mv;
        }
    }
    

    /** 
     1. The method getSuccessPage returns string "success" for success page.
     2. Also, the method accepts id of type string.(Use @RequestParam Annotation)
    **/
    @RequestMapping(value="/success")
    public String getSuccessPage(@RequestParam("id") String id, Model model) {
        model.addAttribute("id", id);
        return "success";
    }
}
