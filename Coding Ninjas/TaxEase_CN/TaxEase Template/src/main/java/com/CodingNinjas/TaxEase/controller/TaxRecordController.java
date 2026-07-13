package com.CodingNinjas.TaxEase.controller;

import com.CodingNinjas.TaxEase.dto.TaxRecordDto;
import com.CodingNinjas.TaxEase.model.TaxRecord;
import com.CodingNinjas.TaxEase.service.TaxRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tax")
public class TaxRecordController {

    /*
        This is the controller class for TaxRecord, you need to complete the class by doing the following:
        a. Use appropriate annotations.
        b. Based on the endpoints mentioned in the problem statement complete the methods given below.
        c. Autowire the necessary dependencies.
    */
	
	@Autowired
	TaxRecordService service;
	
    //  1. API: GET "/api/tax/{id}": This api allows user to get a tax Record by sending the record id.
	@GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('NORMAL')")
    public TaxRecord getTaxRecordById(@PathVariable Long id){
        return service.getTaxRecordById(id);
    }


    // 2. API: GET "/api/tax/all": This api allows user to fetch all the list of tax Records from the database.
	@GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('NORMAL')")
    public List<TaxRecord> getALlTaxRecords(){
        return service.getAllRecords();
    }


    // 3. API: POST "/api/tax": This api allows user to create a tax Record by sending TaxRecordDto as the @ResponseBody.
	@PostMapping
    @ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('NORMAL')")
    public void createTaxRecord(@RequestBody TaxRecordDto taxRecordDto){
		service.createTaxRecord(taxRecordDto);
    }


    // 4. API: PUT "/api/tax/{id}": This api allows user to update a tax Record by sending the record id as a pathVariable and TaxRecordDto as a RequestBody.
	@PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('NORMAL')")
    public void updateTaxRecord(@RequestBody TaxRecordDto taxRecordDto, @PathVariable Long id){
		service.updateTaxRecord(taxRecordDto, id);
    }


    // 5. API: DELETE "/api/tax/{id}": This api allows user to delete a tax Record by sending the record id as a pathVariable.
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('NORMAL')")
    public void deleteTaxRecord(@PathVariable Long id){
		service.deleteTaxRecord(id);
    }


    // 6. API: GET "/api/tax": This api allows user to fetch all the tax Records by sending the username as a requestParam.
	@GetMapping
    @ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('NORMAL')")
    public List<TaxRecord> getTaxRecordsByUserName(@RequestParam String userName){
        return service.getRecordsByName(userName);
    }



    // 7. API: POST "/api/tax/approve/{id}": This api allows user to approve a tax Record by sending the record id as a pathVariable.
	@PostMapping("/approve/{id}")
    @ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('ADMIN')")
    public void approveTaxFiling(@PathVariable Long id){
		service.approveTaxFiling(id);
    }


    // 8. API: POST "/api/tax/reject/{id}": This api allows user to reject a tax Record by sending the record id as a pathVariable.
	@PostMapping("/reject/{id}")
    @ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('ADMIN')")
    public void rejectTaxFiling(@PathVariable Long id){
		service.rejectTaxFiling(id);
    }


}
