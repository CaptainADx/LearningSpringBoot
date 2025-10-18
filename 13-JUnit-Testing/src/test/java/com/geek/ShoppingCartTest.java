package com.geek;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ShoppingCartTest {
	ShoppingCart cart = null;
	
	@BeforeEach
	void init() {
		cart = new ShoppingCart();
		cart.addItems("Pen", 10);
		cart.addItems("Notebook", 40);
	}
	
	@Test
	@Order(1)
	void testAddItems() {
//		fail("Not yet implemented");
		
		//Syntax is assertEquals(expected, actual)
		assertEquals(2, cart.itemCount());
		Map<String, Float> items =   cart.getCart();
		assertEquals(10 ,  items.get("Pen"));
		assertEquals(40, items.get("Notebook"));
		
	}

	@Test
	@Order(2)
	void testTotalPrice() {
//		fail("Not yet implemented");
		double totalPrice = cart.totalPrice();
		assertEquals(50, totalPrice);
	}

	@Test
	@Order(3)
	void testItemCount() {
//		fail("Not yet implemented");
		assertEquals(2, cart.itemCount());
	}

	@Test
	@Order(4)
	void testGetPrice() {
		assertEquals(10, cart.getPrice("Pen"));
	}

	@Test
	@Order(5)
	void testClearCart() {
		cart.clearCart();
		assertEquals(0, cart.itemCount());
	}
	
	@Test
	void testAddItemNegativeItems() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->cart.addItems("", 0));
		assertEquals("Price must be greater than 0", ex.getMessage());
	}
	
	@Test
	void testGetPriceNegative() {
		IllegalArgumentException ex=  assertThrows(IllegalArgumentException.class, ()->cart.getPrice("xyz"));
		assertEquals("Item Not Found", ex.getMessage());
	}

}
