package com.cn.cnpayment.dal;


import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnpayment.entity.PaymentReview;

import jakarta.persistence.EntityManager;



@Repository
public class PaymentReviewDALImpl implements PaymentReviewDAL {

/**

 Complete the PaymentReviewDALImpl implementation class as mentioned below:

 	a. Autowire EntityManager.

 	b. Override the following methods:

 		1. getById(int id): This method fetches PaymentReview for a specific id.

 		2. getAllPaymentReview(): This method fetches the list of all PaymentReview from the database.

 		3. save(PaymentReview paymentReview): This method saves the PaymentReview entity into the database.

 		4. delete(int id): This method deletes the PaymentReview entity from the database for a specific id.

 		5. getByQueryType(String queryType): This method fetches the list of PaymentReview based on the
                                             queryType received.

 **/
	@Autowired
	EntityManager entityManager;

	@Override
	public PaymentReview getById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		return session.get(PaymentReview.class, id);
	}
	
	@Override
	public void save(PaymentReview paymentDetails) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		session.save(paymentDetails);
		
	}
	
	@Override
	public void delete(int id) {

		Session session = entityManager.unwrap(Session.class);
		PaymentReview paymentReview = session.get(PaymentReview.class, id);
		if(paymentReview != null) {
			session.remove(paymentReview);
		}
	}
	
	@Override
	public List<PaymentReview> getAllPaymentReview() {
		Session session = entityManager.unwrap(Session.class);
		
		return session.createQuery("SELECT pr from PaymentReview pr", PaymentReview.class).getResultList();
	}
	
	@Override
	public List<PaymentReview> getByQueryType(String queryType) {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("Select pr from PaymentReview pr WHERE LOWER(pr.queryType) = LOWER(:queryType)", PaymentReview.class).setParameter("queryType", queryType ).getResultList();
	}

}
