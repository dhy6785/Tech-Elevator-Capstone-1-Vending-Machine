package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyTest {

	private Candy sprees;
	
	@Before
	public void setUp() {
		sprees = new Candy("Y1", "Sprees", 0.50, "Candy");
	}
	
	@Test
	public void candy_dispense_message_test() {
		Assert.assertEquals("Munch, Munch, Yum!", sprees.dispenseMessage());
	}
}

