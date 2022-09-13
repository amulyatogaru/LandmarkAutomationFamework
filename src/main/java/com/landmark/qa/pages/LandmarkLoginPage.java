package com.landmark.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.landmark.qa.base.BasePage;
import com.landmark.qa.util.ElementUtil;

public class LandmarkLoginPage extends BasePage {
	
	WebDriver driver;
	
	By Acceptcookies = By.cssSelector("button[id='onetrust-accept-btn-handler']");
	By userName = By.cssSelector("input[id='userName']");
	By passWord = By.cssSelector("input[id='pssword']");
	By loginButton = By.cssSelector("button[id='loginBtn']");
	By homepageTitle = By.cssSelector(" div.left-logo-inner-div > img");
	
	public LandmarkLoginPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public HomePage dologinLandmark(String username, String password){
		
		/*
		 * if(driver.findElement(By.cssSelector(
		 * "button[id='onetrust-accept-btn-handler']")).isDisplayed()==true) {
		 * elementUtil.clickWhenReady(Acceptcookies, 15); }
		 */
		elementUtil.clickWhenReady(Acceptcookies, 15);
		elementUtil.doSendKeys(userName, username);
		elementUtil.doSendKeys(passWord,password );
		elementUtil.doClick(loginButton);	
		//elementUtil.waitForUrl("https://int-ui.promap.co.uk/#/", 15);
		//String homepage = elementUtil.doGetText(homepageTitle);
		return new HomePage(driver);

	}

	private Object findElement(By cssSelector) {
		// TODO Auto-generated method stub
		return null;
	}	
}
