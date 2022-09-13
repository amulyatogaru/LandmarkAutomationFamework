package com.landmark.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.landmark.qa.base.BaseTest;

public class LandmarkHomePageTest extends BaseTest{
	
	@Test(priority = 1) 
	public void verifyPrintProductAddedToBasketTest() throws InterruptedException { 
		homePage.addPrintProductToBasket("Portsmouth");
		Assert.assertTrue(homePage.checkOneProductAddedToTheBasket());
	}

}
