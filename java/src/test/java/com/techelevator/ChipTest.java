package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChipTest {

	private Chip pringles;
	
	@Before
	public void setUp() {
		pringles = new Chip("Y1", "Pringles", 0.50, "Chip");
	}
	
	@Test
	public void chip_dispense_message_test() {
		Assert.assertEquals("Crunch, Crunch, Yum!", pringles.dispenseMessage());
	}
}

