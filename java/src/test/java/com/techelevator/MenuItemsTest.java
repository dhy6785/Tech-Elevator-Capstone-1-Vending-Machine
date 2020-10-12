package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MenuItemsTest {

	
	@Test
	public void menu_items_test() {
		MenuItems tester = new MenuItems("A5", "Funyuns", 1.00, "Chip");
		Assert.assertEquals("A5", tester.getSnackID());
		Assert.assertEquals("Funyuns", tester.getSnackName());
		Assert.assertEquals(1.00, tester.getSnackPrice(), 0.00);
		Assert.assertEquals("Chip", tester.getSnackType());
	}
	
}
