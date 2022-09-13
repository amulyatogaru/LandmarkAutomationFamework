package com.landmark.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.landmark.qa.base.BasePage;
import com.landmark.qa.util.ElementUtil;
import com.landmark.qa.util.JavaScriptUtil;

public class CurrentMapsPage extends BasePage {
	private WebDriver driver;
	private By dxftestcompany = By.xpath("//span[@data-test='treeview-node-text'][text()=' _Org.Justins DXF Testing Company ']");
	private By dxftestcompanymapname = By.cssSelector("#mapName");
	private By dxftestcompanymapreference = By.cssSelector("#mapReference");
	private By dxftestcompanysavebutton = By.xpath("//button[@id='primay-button'][@type='submit']");
	//private By dxftestcompanymapreference = By.cssSelector("#mapReference");
	public CurrentMapsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		javaScriptUtil = new JavaScriptUtil(this.driver);
		
	}
	public String getCurrentMapsPageUrl() {
		elementUtil.waitForUrl("https://int-ui.promap.co.uk/#/savecurrentmaps", 50);
		return driver.getCurrentUrl();   		
	}
	
	public OrderHistoryPage saveCurrentMaps() throws InterruptedException {
		elementUtil.clickWhenReady(dxftestcompany, 50);
		elementUtil.doSendKeys(dxftestcompanymapname, elementUtil.generateRandomString(5)+""+elementUtil.generateRandomString(5));
		elementUtil.doSendKeys(dxftestcompanymapreference, "MapReference");
		javaScriptUtil.scrollPageDown();
		Thread.sleep(500);
		elementUtil.waitForElementToBeClickable(dxftestcompanysavebutton, 20);
		javaScriptUtil.clickElementByJS(dxftestcompanysavebutton);
		return new OrderHistoryPage(driver);
	}
}
