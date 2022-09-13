package com.landmark.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.landmark.qa.base.BasePage;
import com.landmark.qa.base.BaseTest;
import com.landmark.qa.pages.HomePage;
import com.landmark.qa.pages.LandmarkLoginPage;

public class LandmarkLoginPageTest extends BaseTest {

	private WebDriver driver;

	@Test(priority = 1)
	public void verifyUserloginTest(){

		Assert.assertTrue(homePage.getHomepageTitle());
	}

}	

