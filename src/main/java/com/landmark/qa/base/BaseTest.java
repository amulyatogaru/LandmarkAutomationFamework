package com.landmark.qa.base;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.landmark.qa.pages.BasketPage;
import com.landmark.qa.pages.CurrentMapsPage;
import com.landmark.qa.pages.HomePage;
import com.landmark.qa.pages.LandmarkLoginPage;
import com.landmark.qa.pages.OrderHistoryPage;

public class BaseTest extends BasePage{
	public BasePage basePage;
	public LandmarkLoginPage landmarkLoginPage;
	public HomePage homePage;
	public BasketPage basketPage;
	public CurrentMapsPage currentMapsPage ;
	public OrderHistoryPage orderHistoryPage;
	public WebDriver driver;
	public Properties prop;

	@BeforeClass
	public void setup(){
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		landmarkLoginPage = new LandmarkLoginPage(driver);	
		landmarkLoginPage.dologinLandmark(prop.getProperty("Username"), prop.getProperty("Password"));
		homePage = new HomePage(driver);
		basketPage = new BasketPage(driver);
		currentMapsPage = new CurrentMapsPage(driver);
		orderHistoryPage = new OrderHistoryPage(driver);
	}	

	@AfterClass
	
	  public void tearDown() 
	{ 
		driver.quit(); 
		}
	 
	/*public void appTearDown(ITestResult result) throws IOException{

		if (ITestResult.FAILURE == result.getStatus())
		{
			System.out.println("screenshot name is: " +result.getName());
			//Screen_Shot.captureScreenshot(BrowserLaunch.driver, result.getName());
			result.getMethod().getMethodName();
			driver.quit();
		}
		else
		{
			result.getMethod().getMethodName();
			driver.quit();
		}
	}	*/

}

