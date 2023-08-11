package testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.basepage;
import pages.HomePage;
import utilities.PropertiesFile;


public class HomeTest extends basepage{
	HomePage lp;
	private static Logger logger = LogManager.getLogger(HomeTest.class);

	public HomeTest() {
		super();
	}

	@BeforeMethod
	public void Setup() throws IOException {
		setup();
		lp = new HomePage(null);
	}
	@Test(priority = 2)
	public void FLightBookings() throws Exception {

		driver.findElement(HomePage.btn_FlightBooking).click();
		logger.info("Successfully Opened Flight Booking Page");
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		logger.info("Assertion passed Successfully");
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		
		
	}
	@Test(priority = 3)
	public void FLightBookings1() throws Exception {
		
		driver.findElement(HomePage.btn_FlightBooking).click();
		logger.info("Successfully Opened Flight Booking Page");
		Thread.sleep(3000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(2000);
		driver.findElement(HomePage.Box_Country).sendKeys(PropertiesFile.prop.getProperty("Country"));
		driver.findElement(HomePage.departure_city).sendKeys(PropertiesFile.prop.getProperty("Departure_City"));;
		Thread.sleep(2000);
		driver.findElement(HomePage.arrival_city).sendKeys(PropertiesFile.prop.getProperty("Arrival_City"));
		driver.findElement(HomePage.btn_Date).click();
		driver.findElement(HomePage.btn_Submit).click();
		logger.info("Searched Successfully");
		//Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		logger.info("Assertion passed Successfully");
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		

	}
	@Test(priority = 4)
	public void Hotels() throws Exception {
		driver.findElement(HomePage.btn_FlightBooking).click();
		logger.info("Successfully Opened Flight Booking Page");
		Thread.sleep(3000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(2000);
		driver.findElement(HomePage.Box_Country).sendKeys(PropertiesFile.prop.getProperty("Country"));
		driver.findElement(HomePage.btn_Flight).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		logger.info("Assertion passed Successfully");
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		
	}
	
	@Test(priority = 5)
	public void HolidayPackage() throws Exception {
		driver.findElement(HomePage.btn_FlightBooking).click();
		logger.info("Successfully Opened Flight Booking Page");
		Thread.sleep(3000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(2000);
		driver.findElement(HomePage.Box_Country).sendKeys(PropertiesFile.prop.getProperty("Country"));
		driver.findElement(HomePage.btn_HolidayPackage).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		logger.info("Assertion passed Successfully");
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		
	}
	
	

}
