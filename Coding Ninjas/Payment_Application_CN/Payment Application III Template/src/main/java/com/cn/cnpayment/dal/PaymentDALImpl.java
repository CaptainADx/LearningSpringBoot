package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.Payment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
		if (allPayments == null || allPayments.isEmpty()) {
			return null;
			}
		return allPayments;
	}

	@Override
	public List<Payment> getByPaymentType(String paymentType){
		List<Payment> allPayments=getAllPayments();
		List<Payment> paymentsByPaymentType = new ArrayList<>();
		for(Payment payment : allPayments)
		{
			if(payment.getPaymentType().equalsIgnoreCase(paymentType))
			{
				paymentsByPaymentType.add(payment);
			}
		}
		return paymentsByPaymentType;
	}

	@Override
	public List<Payment> getByPaymentDescription(String keyword){
		List<Payment> allPayments=getAllPayments();
		List<Payment> paymentsByDescription = new ArrayList<>();
		for(Payment payment : allPayments)
		{
			if(payment.getDescription().contains(keyword))
			{
				paymentsByDescription.add(payment);
			}
		}
		return paymentsByDescription;
	}

	@Override
	public void addPayment(Payment payment){
		Session session=entityManager.unwrap(Session.class);
		session.save(payment);
	}

	@Override
	public void delete(int paymentId) {
		Session session = entityManager.unwrap(Session.class);
		Payment payment = getById(paymentId);
		session.delete(payment);

	}

	@Override
	public void update(Payment updatePayment) {
		Session session = entityManager.unwrap(Session.class);

		if(updatePayment == null ) return;
		Payment currentPayment = getById(updatePayment.getId());
		if(currentPayment != null) {
			currentPayment.setDescription(updatePayment.getDescription());
			currentPayment.setPaymentType(updatePayment.getPaymentType());
			session.update(currentPayment);
		}
		
	}

	@Override
	public void updateDescription(int paymentId,String description) {
		Session session = entityManager.unwrap(Session.class);
		Payment currentPayment =  getById(paymentId);
		currentPayment.setDescription(description);
		session.update(currentPayment);
	}

	

	// Override getAllPaymentsByCurrency and write the logic to fetch the list of all
	//  payments by the given currency.
	@Override
	public List<Payment> getAllPaymentsByCurrency(String currency) {
		Session session = entityManager.unwrap(Session.class);
		
		List<Payment> res = session.createQuery("From Payment p Where p.paymentDetails.currency = :currency", Payment.class).setParameter("currency", currency).getResultList();
		return res;
	}

}
