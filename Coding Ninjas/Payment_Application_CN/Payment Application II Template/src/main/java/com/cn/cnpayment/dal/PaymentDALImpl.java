package com.cn.cnpayment.dal;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cn.cnpayment.entity.Payment;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class PaymentDALImpl implements PaymentDAL{

	@Autowired
	EntityManager entityManager;


	@Override
	public Payment getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Payment payment = session.get(Payment.class, id);
		return payment;
	}

	@Override
	public List<Payment> getAllPayments() {
		Session session = entityManager.unwrap(Session.class);
		List<Payment> allPayments= session.createQuery(
				"SELECT p FROM Payment p", Payment.class).getResultList();
		return allPayments;
	}

	@Override
	public List<Payment> getByPaymentType(String paymentType){
		Session session = entityManager.unwrap(Session.class);
		List<Payment> paymentsByPaymentType =  session.createQuery(
	            "FROM Payment p WHERE p.paymentType LIKE :paymentType",Payment.class).setParameter("paymentType", "%"+paymentType+"%").getResultList();
		return paymentsByPaymentType;
	}

	@Override
	public List<Payment> getByPaymentDescription(String keyword){
		Session session = entityManager.unwrap(Session.class);
		List<Payment> paymentsByDescription = session.createQuery(
				"FROM Payment p where p.description LIKE :description", Payment.class).setParameter("description", "%"+keyword + "%").getResultList();
		return paymentsByDescription;
	}

	@Override
	public void addPayment(Payment payment){
		Session session=entityManager.unwrap(Session.class);
		
		session.save(payment);
	}


	/**

	 1. Override the methods of PaymentDal Interface.
	 2. Add proper annotations for methods.

	 **/
	

	@Override
	public void delete(int paymentId) {
		
		Session session = entityManager.unwrap(Session.class);
		Payment payment = session.get(Payment.class, paymentId);
		
		session.remove(payment);
		
	}

	@Override
	public void update(Payment updatePayment) {
		Session session = entityManager.unwrap(Session.class);
		Payment payment = session.get(Payment.class, updatePayment.getId());
		
		payment.setPaymentType(updatePayment.getPaymentType());
		payment.setDescription(updatePayment.getDescription());
		payment.setId(updatePayment.getId());
		session.update(payment);
		
	}

	@Override
	public void updateDescription(int paymentId, String description) {
		Session session = entityManager.unwrap(Session.class);
		Payment payment = session.get(Payment.class, paymentId);
		
		payment.setDescription(description);
		session.update(payment);
	}
}
