package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GumTest {

	private Gum bigRed;
	
	@Before
	public void setUp() {
		bigRed = new Gum("Y1", "Big Red", 0.50, "Gum");
	}
	
	@Test
	public void gum_dispense_message_test() {
		Assert.assertEquals("Chew, Chew, Yum!", bigRed.dispenseMessage());
	}
}
