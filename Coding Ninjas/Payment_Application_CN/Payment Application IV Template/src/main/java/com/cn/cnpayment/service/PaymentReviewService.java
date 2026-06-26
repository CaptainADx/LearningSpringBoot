package com.cn.cnpayment.service;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnpayment.dal.PaymentReviewDAL;
import com.cn.cnpayment.entity.PaymentReview;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentReviewService {

// Autowire the PaymentReviewDAL object.
	@Autowired
	PaymentReviewDAL paymentReviewDAL;

	@Transactional
	public PaymentReview getPaymentReviewById(int id) {
		/**
		   1. This method fetches PaymentReview for a specific id.
		   2. If no paymentReview is found then it throws NotFoundException.
		**/
		
		PaymentReview review =  paymentReviewDAL.getById(id);
		if(review == null) {
			throw new NotFoundException("No reviews found for id: " + id);
		}
		
		return review;
	}

	@Transactional
	public List<PaymentReview> getAllPaymentReviews() {
		/**
		 1. This method fetches the list of all PaymentReviews.
		 2. If no paymentReview is found then it throws NotFoundException.
		 **/
		
		List<PaymentReview> review = paymentReviewDAL.getAllPaymentReview();
		if(review.isEmpty()) {
			throw new NotFoundException("No Reviews Found");
		}
		
		return review;
	}

	@Transactional
	public void savePaymentReview(PaymentReview newPaymentReview) {
		/**
		 1. This method first checks if the given paymentReview exists or not.
		 2. If the given paymentReview is not found, then it saves the PaymentReview entity into the database.
		 3. If found then it throws ElementAlreadyExistException.
		 **/
		if(newPaymentReview.getId() != 0 && paymentReviewDAL.getById(newPaymentReview.getId()) != null) {
			throw new ElementAlreadyExistException("This review with id: " + newPaymentReview.getId() + " already exists.");
		}
		paymentReviewDAL.save(newPaymentReview);
		
	}

	@Transactional
	public void delete(int id) {
		/**
		 1. This method deletes PaymentReview for a specific id.
		 2. If no paymentReview is found for the given id, then it throws NotFoundException.
		 **/
		PaymentReview review = getPaymentReviewById(id);
		if(review == null) {
			throw new NotFoundException("No payments found having id: "+ id);
		}
		
		paymentReviewDAL.delete(id);
		
		
	}

	public List<PaymentReview> getPaymentReviewByQueryType(String queryType) {
//		if (queryType == null || queryType.trim().isEmpty()) {
//		throw new InvalidInputException("Query Type is Invalid");
//		}
//
//		// Collapse all internal whitespace to single spaces
//		String normalized = queryType.trim().replaceAll("\\s+", " ");
//
//		if ("Payment Issue".equalsIgnoreCase(normalized) ||
//		    "Bank Issue".equalsIgnoreCase(normalized) ||
//		    "Merchant Issue".equalsIgnoreCase(normalized)) {
//		    return paymentReviewDAL.getByQueryType(normalized);
//		} else {
//		    throw new InvalidInputException("Query Type is Invalid");
//		}
		
		List<PaymentReview> result = paymentReviewDAL.getByQueryType(queryType);
		if(result.isEmpty()) {
			throw new InvalidInputException("Invalid Query");
		}
		
		return result;

		
	}
}
