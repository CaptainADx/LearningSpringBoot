package com.example.CarService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.CarService.domain.Car;
import com.example.CarService.service.Registration;

@Controller
public class RegisterController{
	
	@Autowired
	Registration registration;

/**
 1. Modify the below funtion.
 2. getRegistrationPage method accepts Model as argument.
**/

    @RequestMapping("/register")
    public String getRegistrationPage(Model model){
        
    	model.addAttribute("car", registration.getNewCar());
    	return "carregister";
    }


  /*
   1. getResponsePage method uses registerCar() method to register the car submitted from carregsiter.jsp.
   2. It should return "success" if registerCar() return true else it should return "carregister".
   3. getResponsePage method uses @ModelAttribute annotation to bind data with reference to car domain.
  */
    @RequestMapping("/done")
    public String getResponsePage(@ModelAttribute("car") Car car){
    	if(car.getRegisterationNumber() == null ||
    		       car.getRegisterationNumber().trim().isEmpty() ||

    		       car.getCarName() == null ||
    		       car.getCarName().trim().isEmpty() ||

    		       car.getCarDetails() == null ||
    		       car.getCarDetails().trim().isEmpty() ||

    		       car.getCarWork() == null ||
    		       car.getCarWork().trim().isEmpty()) {

    		        return "carregister";
    		    }

    		    boolean result = registration.registerCar(
    		            car.getRegisterationNumber(),
    		            car.getCarName(),
    		            car.getCarDetails(),
    		            car.getCarWork());

    		    if(result){
    		        return "success";
    		    }

    		    return "carregister";
        
    }
}
