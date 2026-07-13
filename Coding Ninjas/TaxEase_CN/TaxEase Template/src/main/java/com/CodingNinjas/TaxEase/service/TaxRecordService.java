package com.CodingNinjas.TaxEase.service;

import com.CodingNinjas.TaxEase.dto.TaxRecordDto;
import com.CodingNinjas.TaxEase.exception.TaxRecordNotFoundException;
import com.CodingNinjas.TaxEase.model.TaxRecord;
import com.CodingNinjas.TaxEase.repository.TaxRecordRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxRecordService {

    /*
        This is the service class for TaxRecord, you need to complete the class by doing the following:

            a. Use appropriate annotations.
            b. Complete the methods given below.
            c. Autowire the necessary dependencies.
     */
	
	@Autowired
	TaxRecordRepository taxRecordRepo;


    // This is the service method for the api which allows user to get a tax Record by sending the record id
    public TaxRecord getTaxRecordById(Long id) {
    	return taxRecordRepo.findById(id).orElseThrow(() -> new TaxRecordNotFoundException("No tax record found for id: " + id));
    	
    }


    // This is the service method for the api which allows user fetch all tax Records
    public List<TaxRecord> getAllRecords() {
    	return taxRecordRepo.findAll();
    }


    // This is the service method for the api which allows user to create a tax Record by sending TaxRecordDto as the @ResponseBody
    public void createTaxRecord(TaxRecordDto taxRecordDto) {
    	TaxRecord tr = new TaxRecord();
    	tr.setIncome(taxRecordDto.getIncome());
    	tr.setDeductions(taxRecordDto.getDeductions());
    	tr.setTaxYear(taxRecordDto.getTaxYear());
    	tr.setUserName(taxRecordDto.getUserName());
    	
    	taxRecordRepo.save(tr);
    }


    // This is the service method for the api which allows user to update a tax Record by sending the record id as a pathVariable and TaxRecordDto as a RequestBody
    public void updateTaxRecord(TaxRecordDto taxRecordDto, Long id) {
    	TaxRecord tr = getTaxRecordById(id);
    	
    	if(tr != null) {
	    	tr.setIncome(taxRecordDto.getIncome());
	    	tr.setDeductions(taxRecordDto.getDeductions());
	    	tr.setTaxYear(taxRecordDto.getTaxYear());
	    	tr.setUserName(taxRecordDto.getUserName());
	    	
	    	taxRecordRepo.save(tr);
    	} else {
	    	throw new TaxRecordNotFoundException("No tax record found for id: " + id);
    	}
    	
    }


    // This is the service method for the api which allows user to delete a tax Record by sending the record id as a pathVariable
    public void deleteTaxRecord(Long id) {
    	TaxRecord tr = getTaxRecordById(id);
    	if(tr != null) {
    		taxRecordRepo.delete(tr);
    	} else {
        	throw new TaxRecordNotFoundException("No tax record found for id: " + id);
        
    	}
    }


    // This is the service method for the api which allows user to fetch all the tax Records by sending the username as a requestParam
    public List<TaxRecord> getRecordsByName(String userName) {
        return taxRecordRepo.findByUserName(userName);
    }


    // This is the service method for the api which allows user to approve a tax Record by sending the record id as a pathVariable
    public void approveTaxFiling(Long id) {
    	TaxRecord tr = getTaxRecordById(id);
    	if(tr != null) {
    		tr.setFilingApproved(true);
    		taxRecordRepo.save(tr);
    	} else {
        	throw new TaxRecordNotFoundException("No tax record found for id: " + id);
        	
    	}
    }


    // This is the service method for the api which allows user to reject a tax Record by sending the record id as a pathVariable
    public void rejectTaxFiling(Long id) {
    	TaxRecord tr = getTaxRecordById(id);
    	if(tr != null) {
    		tr.setFilingApproved(false);
    		taxRecordRepo.save(tr);
    	} else {
    		throw new TaxRecordNotFoundException("No tax record found for id: " + id);
    	}
    }
}
