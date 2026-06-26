package com.cn.cnpayment.service;

import jakarta.transaction.Transactional;
import com.cn.cnpayment.dal.PaymentDAL;
import com.cn.cnpayment.dal.PaymentReviewDAL;
import com.cn.cnpayment.entity.PaymentReview;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.cnpayment.entity.Payment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PaymentService {

	@Autowired
	PaymentDAL paymentDAL;
	
	@Autowired
	PaymentReviewDAL paymentReviewDal;

	@Transactional
	public Payment getPaymentById(int id) {

		Payment payment=paymentDAL.getById(id);

		if(payment==null)
		{
			throw new NotFoundException("No payment found with id:  "+id);
		}
		return payment;
	}

	@Transactional
	public List<Payment> getPaymentByPaymentType(String paymentType) {

		ArrayList<String> validPayments = new ArrayList<String>() {{
			add("Cash");
			add("Debit");
			add("Credit");
		}};
		Boolean isValidPayment=false;
		for(String validPayment : validPayments)
		{
			if(validPayment.equalsIgnoreCase(paymentType))
			{
				isValidPayment=true;
				break;
			}
		}
		if(!isValidPayment)
		{
			throw new InvalidInputException("Payment type "+ paymentType + "is incorrect");
		}
		List<Payment> payment = paymentDAL.getByPaymentType(paymentType);

		if(payment.isEmpty())
		{
			throw new NotFoundException("No payments found having paymentType: "+paymentType);
		}
		return payment;
	}


	@Transactional
	public List<Payment> getPaymentByDescriptionKeyword(String keyword) {

		List<Payment> payments = paymentDAL.getByPaymentDescription(keyword);
		if(payments.isEmpty())
		{
			throw new NotFoundException("No payments found, with description having keyword: "+keyword);
		}
		return payments;
	}

	@Transactional
	public List<Payment> getAllPaymentsByCurrency(String currency) {
		List<String> validCurrencies = new ArrayList<>();
		Collections.addAll(validCurrencies,"INR","Rupee","Dollar","Yen","Pound","USD");
		boolean isValidCurrency=false;
		for(String validCurrency : validCurrencies)
		{
			if(validCurrency.equalsIgnoreCase(currency))
			{
				isValidCurrency=true;
				break;
			}
		}
		if(!isValidCurrency)
		{
			throw new InvalidInputException("Currency "+ currency + "is invalid.");
		}
		List<Payment> payment = paymentDAL.getAllPaymentsByCurrency(currency);

		if(payment.isEmpty())
		{
			throw new NotFoundException("No payments found having currency : "+currency);
		}
		return payment;
	}

	@Transactional
	public List<Payment> getAllPayments() {

		List<Payment> payment = paymentDAL.getAllPayments();
		if(payment.isEmpty())
		{
			throw new NotFoundException("No payments found.");
		}
		return payment;
	}

	@Transactional
	public void addPayment(Payment payment)  {
		if (paymentDAL.getById(payment.getId())!=null){
			throw new ElementAlreadyExistException("Payment already exists");
		}
		paymentDAL.addPayment(payment);
	}

	@Transactional
	public void update(Payment updatePayment) {
		paymentDAL.update(updatePayment);
	}

	@Transactional
	public void updateDescription(int id, String description) {
		paymentDAL.updateDescription(id,description);
	}

	@Transactional
	public void delete(int id) {
		paymentDAL.delete(id);
	}


	@Transactional
	public List<PaymentReview> getPaymentReviews(int paymentId) {

	    List<PaymentReview> reviews =
	            paymentDAL.getPaymentReviews(paymentId);

	    if(reviews.isEmpty()) {
	        throw new NotFoundException("No reviews found.");
	    }

	    return reviews;
	}

	@Transactional
	public List<Payment> getAllPaymentsByQueryType(String queryType) {
    /**
		1. This method fetches the list of all Payment for the given queryType.
	    2. Only the following query types are allowed if invalid type are passed the method throws InvalidInputException.
	    3. "Payment Issue","Bank Issue","Merchant Issue" : Both Lowercase and Uppercase formats are accepted.
	**/
		if("Payment Issue".equalsIgnoreCase(queryType) || 
			"Bank Issue".equalsIgnoreCase(queryType) ||
			"Merchant Issue".equalsIgnoreCase(queryType)
		) {
			List<Payment> result = paymentDAL.getAllPaymentsByQueryType(queryType);
			
			if(result.isEmpty() ){
				return new ArrayList<Payment>();
			}
			return result;
			
			
 		} else throw new InvalidInputException("The input is invalid");
		
		
	}

}

