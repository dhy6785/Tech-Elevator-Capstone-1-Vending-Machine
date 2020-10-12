package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinkTest {

	private Drink pepsi;
	
	@Before
	public void setUp() {
		pepsi = new Drink("Y1", "Pepsi", 0.50, "Drink");
	}
	
	@Test
	public void drink_dispense_message_test() {
		Assert.assertEquals("Glug, Glug, Yum!", pepsi.dispenseMessage());
	}
}

