package com.cn.cnpayment.service;

import com.cn.cnpayment.dal.PaymentDetailsDAL;
import com.cn.cnpayment.entity.PaymentDetails;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaymentDetailsService {

    // Auto-wire the PaymentDetailsDAL object
	@Autowired
    PaymentDetailsDAL paymentDetailsDAL;


    public PaymentDetails getPaymentDetailsById(int id) {
        // 1. This method fetches PaymentDetails for the given id.
        // 2. If no paymentDetails is found by the given id then it throws NotFoundException with custom message.
    	PaymentDetails paymentDetails = paymentDetailsDAL.getById(id);
        
        if(paymentDetails == null) {
        	throw new NotFoundException("Payment Details Not Found");
        }
        
        return paymentDetails;
    }


    public List<PaymentDetails> getAllPaymentDetails() {
        // 1. This method fetches the list of all PaymentDetails from the database.
        // 2. If the no paymentDetails data is found then it throws NotFoundException with custom message.
    	List<PaymentDetails> res = paymentDetailsDAL.getAllPaymentDetails();
    	
        return res;
    }


    @Transactional
    public void savePaymentDetails(PaymentDetails newPaymentDetails) {
    // 1. It first checks whether the given paymentDetails object exists in the database or not.
    // 2. If the given paymentDetails already exist in the database, then it throws ElementAlreadyExistException.
    // 3. If the given paymentDetails doesn't exist, it saves the new PaymentDetails into the database.
    	PaymentDetails previousPaymentDetails = paymentDetailsDAL.getById(newPaymentDetails.getId());
    	if(previousPaymentDetails != null) {
    		throw new ElementAlreadyExistException("This Element already exists");
    	}
    	paymentDetailsDAL.save(newPaymentDetails);
    }


    @Transactional
    public void delete(int id) {
    // 1. It deletes a paymentDetails for the given id from the database.
    	PaymentDetails paymentDetails = paymentDetailsDAL.getById(id);
    	paymentDetailsDAL.delete(id);
    }


    @Transactional
    public void update(PaymentDetails paymentDetails) {
    // 1. It first checks if the given paymentDetails exists in the database or not.
    // 2. If the given paymentDetails object exists in the database, then it is simply updated.
    // 3. If not found, then it throws NotFoundException with custom message.
    	PaymentDetails previousPaymentDetails = paymentDetailsDAL.getById(paymentDetails.getId());
    	if(previousPaymentDetails == null) {
    		throw new NotFoundException("Payment Details Not Found");
    	}
    	paymentDetailsDAL.update(paymentDetails);
    }

    @Transactional
    public List<PaymentDetails> getByCurrency(String currency) {
        // 1. It fetches the list of all PaymentDetails from the database for the given id.
        // 2. It supports the following given currency only with any format i.e. UpperCase/LoweCase:
        // 3. "INR", "Rupee", "Dollar", "Yen", "Pound", "USD"
        // 4. It throws InvalidInputException if a currency different from the mentioned above is passed.
    	List<String> lst = Arrays.asList("INR","Rupee","Dollar","Yen","Pound","USD");
		boolean validCurrency = false;
		for(String s : lst) {
			if(currency.equalsIgnoreCase(s)) {
				validCurrency = true;
				break;
			}
		}
		
		if(!validCurrency) {
			throw new InvalidInputException("Invalid Currency");
		}
		
		
    	List<PaymentDetails> res = paymentDetailsDAL.getByCurrency(currency);
    	if (res == null || res.isEmpty()) {
			throw new NotFoundException("No payments found having currency: " + currency);
			}
    	
    	return res;
    }
}
