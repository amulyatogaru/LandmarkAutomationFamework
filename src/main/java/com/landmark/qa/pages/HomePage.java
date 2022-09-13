package com.landmark.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.landmark.qa.base.BasePage;
import com.landmark.qa.util.ElementUtil;
import com.landmark.qa.util.JavaScriptUtil;

public class HomePage extends BasePage {

	private WebDriver driver;

	// 1. By Locators:
	private By homepageTitle = By.cssSelector("div.left-logo-inner-div>img");
	private By searchBar = By.cssSelector("input[data-test='location-search-box']");
	private By selectsearcheditem = By.xpath("//span[text()=' Portsmouth, City of Portsmouth ']");
	private By print = By.xpath("(//span[text()='Print'])[2]");
	private By addtobasket = By.cssSelector("button.ng-binding.btn-warningwidth");
	private By numberofitemsinthebasket = By.xpath("//span[text()='1']");
	private By basketbutton = By.cssSelector("//button[@data-test='basket-icon']");
	private By viewbasketbutton = By.cssSelector("button.btn.btn-xs.pull-right.m-r-1.ng-binding.btn-warningwidth.btn-active.btn-view-basket");
	
	//2.Constructor of the page class

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		javaScriptUtil = new JavaScriptUtil(this.driver);
	}

	//3. page actions: features of the page in the form methods

	public String getHomepageUrl() {
		String homepageurl = driver.getCurrentUrl();
		return homepageurl;
	}
	public boolean getHomepageTitle() {
		return elementUtil.doIsDisplayed(homepageTitle);
		//return title;
	}
	public void searchAddressUsingSearchbar(String address) {

		//elementUtil.clickWhenReady(searchBar,30);
		elementUtil.doSendKeys(searchBar,address);
	}

	public void selectSearchedITem() {
		elementUtil.clickWhenReady(selectsearcheditem, 20);
	}

	public void addPrintProductToBasket(String address) throws InterruptedException {
		searchAddressUsingSearchbar(address);
		selectSearchedITem();
		elementUtil.waitForElementToBeClickable(print, 20);
		javaScriptUtil.clickElementByJS(print);
		elementUtil.waitForElementToBeClickable(addtobasket, 50);
		Thread.sleep(500);
		//javaScriptUtil.clickElementByJS(addtobasket);
		elementUtil.doClick(addtobasket);
	}
	public boolean checkOneProductAddedToTheBasket()	{
		elementUtil.waitForElementPresent(numberofitemsinthebasket, 30);
		return elementUtil.doIsDisplayed(numberofitemsinthebasket); 
		
	}
	public BasketPage gotoBasketpage() {
		elementUtil.waitForElementPresent(viewbasketbutton, 40);
		  elementUtil.clickWhenReady(viewbasketbutton, 20);
		 return new BasketPage(driver); }

}
