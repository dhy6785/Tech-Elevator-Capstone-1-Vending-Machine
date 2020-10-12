package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class TransactionTest {

	Transaction transaction = new Transaction();
	@Test
	public void add_money_test() {
		transaction.addMoney(20.00);
		Assert.assertEquals(20.00, transaction.balance(), 0.00);
	}
	
	@Test
	public void total_cost_test() {
		transaction.totalCost(25.00);
		Assert.assertEquals(-25.00, transaction.balance(), 0.00);
	}
	
//	@Test
//	public void make_change_test() {
//		transaction.addMoney(5);
//		Assert.assertEquals(20, transaction.makeChange());
//	}
}
