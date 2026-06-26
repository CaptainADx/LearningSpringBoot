package com.cn.cnpayment.service;

import jakarta.transaction.Transactional;

import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.cnpayment.dal.PaymentReviewDAL;
import com.cn.cnpayment.entity.PaymentReview;
import java.util.List;

@Service
public class PaymentReviewService {

	@Autowired
	PaymentReviewDAL paymentReviewDAL;

	@Transactional
	public PaymentReview getPaymentReviewById(int id) {
		PaymentReview paymentReview=paymentReviewDAL.getById(id);
		if(paymentReview==null)
		{
			throw new NotFoundException("No paymentReview found with id:  "+id);
		}
		return paymentReview;
	}

	@Transactional
	public List<PaymentReview> getAllPaymentReviews() {
		return paymentReviewDAL.getAllPaymentReview();
		
	}

	@Transactional
	public void savePaymentReview(PaymentReview newPaymentReview) {

		if (newPaymentReview.getId() == 0) {
				paymentReviewDAL.save(newPaymentReview);
				return;

		}
		
		if(paymentReviewDAL.getById(newPaymentReview.getId()) == null ) {
			paymentReviewDAL.save(newPaymentReview);
			return;
		} else {
			throw new ElementAlreadyExistException("Element with Id: " + newPaymentReview.getId() + " already exists" );
		}
		

	}

	@Transactional
	public void delete(int id) {
		PaymentReview paymentReview = paymentReviewDAL.getById(id);
		if (paymentReview != null) {
			paymentReviewDAL.delete(id);
		} else {
			throw new NotFoundException("No paymentReview found with id: " + id);
		}

	}

	@Transactional
	public List<PaymentReview> getPaymentReviewByQueryType(String queryType){
		List<PaymentReview> reviewsByQueryType = paymentReviewDAL.getByQueryType(queryType);

		if (reviewsByQueryType.isEmpty()){
			throw new InvalidInputException("Invalid Query");
		}
		return reviewsByQueryType;
	}

}
