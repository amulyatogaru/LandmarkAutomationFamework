package com.landmark.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.landmark.qa.base.BaseTest;

public class CheckOutPageTest extends BaseTest{
	
	@Test(priority = 1) 
	public void verifyTest() throws InterruptedException { 
		homePage.addPrintProductToBasket("Portsmouth");
		Assert.assertTrue(homePage.checkOneProductAddedToTheBasket());
		homePage.gotoBasketpage();
		basketPage.submitOrder("Test", "AmulyaTest");
		String mapspageurl = currentMapsPage.getCurrentMapsPageUrl();
		System.out.println("Map page url" + mapspageurl);
		Assert.assertEquals(mapspageurl, "https://int-ui.promap.co.uk/#/savecurrentmaps");
		currentMapsPage.saveCurrentMaps();
		String historypageurl =orderHistoryPage.getHistoryPageUrl();
		System.out.println("History page url" + historypageurl);
		Assert.assertEquals(historypageurl, "https://int-ui.promap.co.uk/#/orderhistory");
		String editprint = orderHistoryPage.downloadFile();
		System.out.println("download text="+editprint);
		Assert.assertEquals(editprint, "Edit Print");
	}
	
}
