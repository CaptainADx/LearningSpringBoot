package com.example.cnExpense.dal;

//import com.example.cnExpense.entity.Expense;
//import com.example.cnExpense.entity.Income;
import com.example.cnExpense.entity.User;
import com.example.cnExpense.exception.NotFoundException;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
//import java.util.List;

@Repository
public class UserDalImpl implements UserDal {

    @Autowired
    EntityManager entityManager;

    @Override
    public User getUserById(Long id) {
      Session session = entityManager.unwrap(Session.class);
      
      User user = session.get(User.class, id);
      
      return user;
    }

    @Override
    public User saveUser(User user) {
    	Session session = entityManager.unwrap(Session.class);
    	session.save(user);
    	return user;
    }

    @Override
    public User updateUser(Long userId, User user) {
    	Session session = entityManager.unwrap(Session.class);
    	User existingUser = session.get(User.class, userId);
    	
    	if(existingUser == null) {
    		throw new NotFoundException("User not found");
    	}
    	
    	
    	if(user.getAddress() != null) existingUser.setAddress(user.getAddress());
    	
    	existingUser.setBudget(user.getBudget());
    	
    	existingUser.setBudgetSet(user.isBudgetSet());
    	
    	if(user.getEmail() != null )existingUser.setEmail(user.getEmail());
    	
    	if (user.getExpenses() != null && !user.getExpenses().isEmpty()) {
            existingUser.setExpenses(user.getExpenses());
        }

        if (user.getIncomes() != null && !user.getIncomes().isEmpty()) {
            existingUser.setIncomes(user.getIncomes());
        }
    	
    	if(user.getNickname() != null) existingUser.setNickname(user.getNickname());
    	
    	if(user.getUsername() != null) existingUser.setUsername(user.getUsername());
    	
    	return existingUser;
    	
    	
    }

    @Override
    public User setBudget(Long userId, double budget) {
        Session session = entityManager.unwrap(Session.class);
        
        User user = session.get(User.class, userId);
        
        if(user == null) {
        	throw new NotFoundException("User not found");
        }
        
        user.setBudget(budget);
        user.setBudgetSet(true);
        
        session.update(user);
        
        return user;
        

        
        
    }

    @Override
    public double getTotalExpense(Long userId) {
    	
    	Session session = entityManager.unwrap(Session.class);
    	
    	User user = session.get(User.class, userId);
    	
    	if(user == null) {
    		throw new NotFoundException("User not found");
    	}
    	
    	Double totalExpense = session.createQuery(
    			"Select SUM(e.amount) FROM Expense e WHERE e.user.id = :userId", 
    			Double.class)
    			.setParameter("userId", userId)
    			.uniqueResult();
    	
    	return totalExpense;
    	
    	
      
    }

    @Override
    public double getQuotation(Long userId) {
    	//It calculates the remaining amount of money after deducting total expenses from the total income of a user.
    	//Use double as the return type for this API.
    	
    	Session session = entityManager.unwrap(Session.class);
    	
    	User user = session.get(User.class, userId);

    	if (user == null) {
    	    throw new NotFoundException("User not found");
    	}

    	Double totalIncome = (Double) session.createQuery("SELECT SUM(i.amount) FROM Income i WHERE i.user.userId = :userId")
    	        .setParameter("userId", userId)
    	        .uniqueResult();

    	Double totalExpense = (Double) session.createQuery("SELECT SUM(e.amount) FROM Expense e WHERE e.user.userId = :userId")
    	        .setParameter("userId", userId)
    	        .uniqueResult();

    	if (totalIncome == null) {
    	    totalIncome = 0.0;
    	}
    	if (totalExpense == null) {
    	    totalExpense = 0.0;
    	}

    	return totalIncome - totalExpense;
    }

    
    @Override
    public double getAvgExpenseData(Long userId) {
    	
    	Session session = entityManager.unwrap(Session.class);
    	
    	User user = session.get(User.class, userId);
    	
    	if(user == null) {
    		throw new NotFoundException("User not found");
    	}
    	
    	double totalExpensesCount = user.getExpenses().size();
    	
    	Double totalExpenses = session.createQuery(
    			"Select SUM(e.amount) from Expense e where e.user.id = :user_id", 
    			Double.class)
    			.setParameter("user_id", userId)
    			.uniqueResult();
    	
    	return totalExpenses/totalExpensesCount;
    }
}


