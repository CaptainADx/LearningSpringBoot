package com.cn.cnpayment.dal;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnpayment.entity.PaymentDetails;

import jakarta.persistence.EntityManager;

/**
 # Complete the PaymentDetailsDALImpl class as mentioned below:

 	a. Autowire EntityManager.

 	b. Override the following methods:

 		1. getById(int id): This method fetches PaymentDetails for a specific id from the database.

	 	2. getAllPaymentDetails(): This method fetches the list of PaymentDetails from the database.

	 	3. save(PaymentDetails paymentDetails): This method saves the PaymentDetails entity into the database.

	 	4. delete(int id): This method deletes the PaymentDetails entity for a specific id.

	 	5. update(PaymentDetails paymentDetails): This method updates paymentDetails.

	 	6. getByCurrency(String currency): This method fetches the list of PaymentDetails from the database for
                                           a specific currency.
 **/


@Repository
public class PaymentDetailsDALImpl implements PaymentDetailsDAL {
	
	// Auto-wire the EntityManager object
	@Autowired
	EntityManager entityManager;
	
		

	@Override
	public PaymentDetails getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(PaymentDetails.class, id);
	}

	@Override
	public void save(PaymentDetails paymentDetails) {
		// TODO Auto-generated method stub

		Session session = entityManager.unwrap(Session.class);
		session.save(paymentDetails);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

		Session session = entityManager.unwrap(Session.class);
		PaymentDetails paymentDetails = session.get(PaymentDetails.class, id);
		session.delete(paymentDetails);
		
	}

	@Override
	public List<PaymentDetails> getAllPaymentDetails() {
		// TODO Auto-generated method stub

		Session session = entityManager.unwrap(Session.class);
		List<PaymentDetails> res = session.createQuery("FROM PaymentDetails pd", PaymentDetails.class).getResultList();
		return res;
	}

	@Override
	public void update(PaymentDetails paymentDetails) {
		// TODO Auto-generated method stub

		Session session = entityManager.unwrap(Session.class);
		if(paymentDetails == null ) return;
		PaymentDetails previousPaymentDetails = session.get(PaymentDetails.class, paymentDetails.getId());
		
		if(previousPaymentDetails != null) {
			previousPaymentDetails.setAmount(paymentDetails.getAmount());
			previousPaymentDetails.setCreditAccount(paymentDetails.getCreditAccount());
			previousPaymentDetails.setCurrency(paymentDetails.getCurrency());
			previousPaymentDetails.setDebitAccount(paymentDetails.getDebitAccount());
			previousPaymentDetails.setPayment(paymentDetails.getPayment());
		}
		
		session.update(previousPaymentDetails);
		
	}

	@Override
	public List<PaymentDetails> getByCurrency(String currency) {
		
		Session session = entityManager.unwrap(Session.class);
		List<PaymentDetails> res = session.createQuery("From PaymentDetails pd Where pd.currency = :currency", PaymentDetails.class).setParameter("currency", currency).getResultList();
		return res;
	}

	
	


}
