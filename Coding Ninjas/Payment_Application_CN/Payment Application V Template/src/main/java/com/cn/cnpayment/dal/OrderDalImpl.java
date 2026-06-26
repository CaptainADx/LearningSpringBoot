 package com.cn.cnpayment.dal;

 import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnpayment.entity.Orders;
import com.cn.cnpayment.entity.Payment;
import com.cn.cnpayment.exception.NotFoundException;

import jakarta.persistence.EntityManager;

 /**
  Complete the OrderDalImpl implementation class as mentioned below:

  a. Autowire EntityManager.

  b. Override the following methods:

  1. getById(int id): This method fetches an Order from the database for a specific Id.

  2. save(Orders order): This method saves an Order into the database.

  3. delete(int id): This method deletes an Order from the database for a specific Id.

  4. getAllOrders(): This method fetches the list of Orders from the database.
  **/


@Repository
public class OrderDalImpl implements OrderDal
{
	 //Autowire the EntityManager object.
	
	@Autowired
	EntityManager entityManager; 
	
	@Autowired
	PaymentDAL paymentDal;

	@Override
	public Orders getById(int id) {
		Session session = entityManager.unwrap(Session.class);
	    Orders order = session.get(Orders.class, id);
	    if (order == null) {
	        throw new NotFoundException("No Orders found for id: "+id);
	    }
	    return order;
	}

	@Override
	public void save(Orders order) {
		Session session = entityManager.unwrap(Session.class);
		
		
		Orders newOrder = new Orders();
		newOrder.setAmount(order.getAmount());
		newOrder.setCategory(order.getCategory());
		newOrder.setName(order.getName());
		
		List<Payment> newPayments = new ArrayList<Payment>();
		
		for(Payment payment : order.getPayments()) {
			Payment currPayment = paymentDal.getById(payment.getId());
			newPayments.add(currPayment);
		}
		newOrder.setPayments(newPayments);
		
		newOrder.setQuantity(order.getQuantity());
	
		
		session.persist(newOrder);
	}

	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Orders order = session.get(Orders.class, id);
		if(order == null) {
			throw new NotFoundException("No Orders found for id: "+id);
		}
		session.remove(order);
	}

	@Override
	public List<Orders> getAllOrders() {
		Session session = entityManager.unwrap(Session.class);
		List<Orders> result = session.createQuery("From Orders o", Orders.class).getResultList();
		return result;
	}
       
}
