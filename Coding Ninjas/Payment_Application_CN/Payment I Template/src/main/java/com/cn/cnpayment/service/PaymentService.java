package com.cn.cnpayment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnpayment.dal.PaymentDAL;
import com.cn.cnpayment.entity.Payment;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;

import jakarta.transaction.Transactional;

import java.util.List;

				/**
				 Complete the PaymentService class as mentioned below:

				 Tasks:-

				 a. Autowire PaymentDAL.

				 b. Complete the following methods:

				 1. getPaymentById(int id): This method fetches payment from the dal
				 layer for a specific id.

				 2. getPaymentByPaymentType(String paymentType): This method
				 fetches a list of Payment from the dal layer based on the paymentType received.

				 3. getPaymentByDescriptionKeyword(String keyword): This method
				 fetches a list of payments from the dal layer based on the keyword received.

				 4. getAllPayments(): This method fetches a list of payments
				 from the dal layer.

				 5. addPayment(Payment payment): This method saves payment entity into the
				 database using the dal layer.

				 **/

@Service
public class PaymentService {

	// Auto-wire necessary DAl layer object;
	@Autowired
	PaymentDAL paymentDAL;
	
	
	@Transactional
	public Payment getPaymentById(int id) {
	//	1. Complete the method body for getting a payment object by id.
	//	2. add proper annotation for registering this method as a Transaction
		Payment payment = paymentDAL.getById(id);
		if(payment == null) {
			throw new NotFoundException(
					"Payment with id " + id + " not found"
			);
			
		}
		return payment;
	}
	
	@Transactional
	public List<Payment> getPaymentByPaymentType(String paymentType) {
	//	1. Complete the method body for getting all payment objects by payment type.
	//	2. add proper annotation for registering this method as a Transaction
		if(paymentType == null || (!paymentType.equals("Credit") && !paymentType.equals("Debit") && !paymentType.equals("Cash"))) {
			throw new InvalidInputException(
					"Invalid payment type. Allowed values are Credit, Debit and Cash"
			);
		}
		return paymentDAL.getByPaymentType(paymentType);
	}
	
	@Transactional
	public List<Payment> getPaymentByDescriptionKeyword(String keyword) {
	//	1. Complete the method body for getting all payment objects by description keyword.
	//	2. add proper annotation for registering this method as a Transaction
		return paymentDAL.getByPaymentDescription(keyword);
	}

	@Transactional
	public List<Payment> getAllPayments() {
	// 1. Complete the method body for getting all payment objects from database.
	// 2. add proper annotation for registering this method as a Transaction.
		return paymentDAL.getAllPayments();
	}

	@Transactional
	public void addPayment(Payment payment)  {
	// 1. Complete the method body for adding a payment entity in the database.
	// 2. add proper annotation for registering this method as a Transaction.
		if(paymentDAL.getById(payment.getId()) != null) {
			throw new ElementAlreadyExistException(
				"Payment with id " + payment.getId() + " already exists"
			);
		}
		
		 
		
		paymentDAL.addPayment(payment);
	}

}

