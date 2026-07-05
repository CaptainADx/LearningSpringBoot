package com.example.cnExpense.dal;

import com.example.cnExpense.entity.Income;
import com.example.cnExpense.entity.User;
import com.example.cnExpense.exception.NotFoundException;
import com.example.cnExpense.service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class IncomeDalImpl implements IncomeDal {

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserService userService;

    @Override
    public Income getIncomeById(Long incomeId) {
      Session session = entityManager.unwrap(Session.class);
      
      Income income = session.get(Income.class, incomeId);
      
      return income;
    }

    @Override
    public Income saveIncome(User user, Income newIncome) {
       Session session = entityManager.unwrap(Session.class);
       
       User newUser = session.get(User.class, user.getId());
       
       if(newUser == null) {
    	   throw new NotFoundException("User not found");
       }
       
       newIncome.setUser(newUser);
       
       newUser.getIncomes().add(newIncome);
       
       session.save(newIncome);
       
       return newIncome;
       
    }

    @Override
    public Income updateIncome(Long incomeId, Income income) {
    	Session session = entityManager.unwrap(Session.class);
    	
    	Income existingIncome = session.get(Income.class, incomeId);
    	
    	if(existingIncome == null) {
    		throw new NotFoundException("Income not found");
    	}
    	
    	existingIncome.setAmount(income.getAmount());
    	existingIncome.setDate(income.getDate());
    	if(income.getDescription() != null) existingIncome.setDescription(income.getDescription());
    	if(income.getIncomeType() != null) existingIncome.setIncomeType(income.getIncomeType());
    	existingIncome.setUser(income.getUser());
    	
    	
    	return existingIncome;
    }

}


