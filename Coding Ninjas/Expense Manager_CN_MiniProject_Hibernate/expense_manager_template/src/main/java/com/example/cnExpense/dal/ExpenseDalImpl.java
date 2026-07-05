package com.example.cnExpense.dal;

import com.example.cnExpense.entity.Expense;
import com.example.cnExpense.entity.User;
//import com.example.cnExpense.exception.ExceedingBudgetLimit;
import com.example.cnExpense.exception.NotFoundException;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ExpenseDalImpl implements ExpenseDal {

    @Autowired
    EntityManager entityManager;

    @Override
    public Expense saveExpense(Long userId, Expense expense) {
    	Session session = entityManager.unwrap(Session.class);
    	
    	User user = session.get(User.class, userId);
    	
    	if(user == null) {
    		throw new NotFoundException("User not found");
    	}
    	
    	if (user.isBudgetSet()) {

            Double totalExpense = session.createQuery(
                    "SELECT SUM(e.amount) FROM Expense e WHERE e.user.id = :userId",
                    Double.class)
                    .setParameter("userId", userId)
                    .uniqueResult();

            if (totalExpense == null) {
                totalExpense = 0.0;
            }

            // Existing expenses + new expense should not exceed budget
            if (totalExpense + expense.getAmount() > user.getBudget()) {
                throw new RuntimeException("Expense exceeds the set budget.");
            }
        }
    	
    	expense.setUser(user);
    	
    	user.getExpenses().add(expense);
    	
    	session.save(expense);
    	
    	return expense;
    }

    @Override
    public Expense getExpenseById(Long expenseId) {
    	Session session = entityManager.unwrap(Session.class);
    	
    	Expense expense = session.get(Expense.class, expenseId);
    	
    	return expense;
     
    }
}


