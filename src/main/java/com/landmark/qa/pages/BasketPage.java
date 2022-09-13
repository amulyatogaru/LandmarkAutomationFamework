package com.landmark.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.landmark.qa.base.BasePage;
import com.landmark.qa.util.ElementUtil;
import com.landmark.qa.util.JavaScriptUtil;

public class BasketPage extends BasePage {
	
	private WebDriver driver;
	private By projectref = By.cssSelector("input[id*=projRef_100]");
	private By purchaseorderref = By.cssSelector("input[id*=poRef_100]");
	private By submitorder = By.cssSelector("div.basket-price-placeholder-ext > button");
	private By newfolder = By.xpath("//button[text()=' New folder ']");
	private By savebutton = By.cssSelector("#primay-button");

	public BasketPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		javaScriptUtil = new JavaScriptUtil(this.driver);
	}

	public String getCheckoutPageURL() {
		String carturl = driver.getCurrentUrl();
		return carturl;
	}

	public CurrentMapsPage submitOrder(String projectRef, String purchaseOrderRef) {
		elementUtil.doSendKeys(this.projectref,projectRef );
		elementUtil.doSendKeys(this.purchaseorderref,purchaseOrderRef );
		elementUtil.doClick(submitorder);	
		return new CurrentMapsPage(driver);
	}

}
