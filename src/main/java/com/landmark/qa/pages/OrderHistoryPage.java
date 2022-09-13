package com.landmark.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.landmark.qa.base.BasePage;
import com.landmark.qa.util.ElementUtil;
import com.landmark.qa.util.JavaScriptUtil;

public class OrderHistoryPage extends BasePage {
	private WebDriver driver;
	private By downloadfile = By.cssSelector("div.ng-scope > div:nth-child(2) > div:nth-child(2) > div > button");
	private By continuebutton = By.xpath("//button[@data-test='confirm-btn']");
	private By editprint = By.cssSelector("button[id*='btneditprint']");
	
	public OrderHistoryPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		javaScriptUtil = new JavaScriptUtil(this.driver);
	}
	public String getHistoryPageUrl() {
		elementUtil.waitForUrl("https://int-ui.promap.co.uk/#/orderhistory", 50);
		return driver.getCurrentUrl();   	
	}	
		public String downloadFile() throws InterruptedException
		{
			
			elementUtil.waitForElementPresent(downloadfile, 30);
			elementUtil.waitForElementToBeClickable(downloadfile, 50);
			Thread.sleep(1000);
			javaScriptUtil.clickElementByJS(downloadfile);
			//elementUtil.doClick(downloadfile);
			elementUtil.waitForElementToBeClickable(continuebutton, 50);
			elementUtil.doClick(continuebutton);
			elementUtil.waitForElementPresent(editprint, 30);
			return elementUtil.doGetText(editprint);
			
			
		}
	}
	

