package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.basepage;
import pages.ShoppingPage;
import utilities.PropertiesFile;


public class ShoppingTest extends basepage {
	ShoppingPage lp;

	private static Logger logger = LogManager.getLogger(ShoppingTest.class);

	public ShoppingTest() {
		super();
	}

	@BeforeMethod
	public void Setup() throws IOException {
		setup();
		lp = new ShoppingPage(null);
	}

	@Test(priority = 6)
	public void Searchh() throws Exception {

		driver.findElement(ShoppingPage.btn_Search).sendKeys(PropertiesFile.prop.getProperty("Search"));
		driver.findElement(ShoppingPage.btn_Submit).click();
		Thread.sleep(2000);
		logger.info("Searched Successfully");
		Assert.assertEquals(driver.getTitle(), "GreenKart - veg and fruits kart");

	}

	@Test(priority = 7)
	public void FailedAddToCart() throws Exception {

		driver.findElement(ShoppingPage.btn_Search).sendKeys(PropertiesFile.prop.getProperty("Search"));
		driver.findElement(ShoppingPage.btn_Submit).click();
		logger.info("Searched Successfully");
		Thread.sleep(2000);
		driver.findElement(ShoppingPage.btn_IncreaseQuantity).click();
		driver.findElement(ShoppingPage.btn_AddToCart).click();
		driver.findElement(ShoppingPage.btn_lockCLick).click();
		logger.info("Failed to add to cart");
		driver.findElement(ShoppingPage.btn_FailedProceedToCheckout).click();
		Thread.sleep(2000);

	}

	@Test(priority = 8)
	public void AddToCart() throws Exception {

		driver.findElement(ShoppingPage.btn_Search).sendKeys(PropertiesFile.prop.getProperty("Search"));
		driver.findElement(ShoppingPage.btn_Submit).click();
		logger.info("Searched Successfully");
		Thread.sleep(2000);
		driver.findElement(ShoppingPage.btn_IncreaseQuantity).click();
		driver.findElement(ShoppingPage.btn_AddToCart).click();
		driver.findElement(ShoppingPage.btn_lockCLick).click();
		driver.findElement(ShoppingPage.btn_ProceedToCheckout).click();
		logger.info("Proceed to Checkout Successfully");
		Thread.sleep(2000);
		logger.info("Added To Cart");
		Assert.assertEquals(driver.getTitle(), "GreenKart - veg and fruits kart");

	}

	@Test(priority = 9)
	public void PlaceOrder() throws Exception {

		driver.findElement(ShoppingPage.btn_Search).sendKeys(PropertiesFile.prop.getProperty("Search"));
		driver.findElement(ShoppingPage.btn_Submit).click();
		logger.info("Searched Successfully");
		Thread.sleep(2000);
		driver.findElement(ShoppingPage.btn_IncreaseQuantity).click();
		driver.findElement(ShoppingPage.btn_AddToCart).click();
		driver.findElement(ShoppingPage.btn_lockCLick).click();
		driver.findElement(ShoppingPage.btn_ProceedToCheckout).click();
		logger.info("Proceed to Checkout Successfully");
		Thread.sleep(2000);
		driver.findElement(ShoppingPage.btn_PlaceeOrder).click();
		Thread.sleep(2000);
		driver.findElement(ShoppingPage.btn_Country).sendKeys(PropertiesFile.prop.getProperty("Country"));
		driver.findElement(ShoppingPage.Click_Box).click();
		driver.findElement(ShoppingPage.btn_Proceed).click();
		Thread.sleep(2000);
		logger.info("Placed Order Successfully");
		Assert.assertEquals(driver.getTitle(), "GreenKart - veg and fruits kart");

	}

	@Test(priority = 10)
	public void FailedPlaceOrder() throws Exception {

		driver.findElement(ShoppingPage.btn_Search).sendKeys(PropertiesFile.prop.getProperty("Search"));
		driver.findElement(ShoppingPage.btn_Submit).click();
		Thread.sleep(2000);
		driver.findElement(ShoppingPage.btn_IncreaseQuantity).click();
		driver.findElement(ShoppingPage.btn_AddToCart).click();
		driver.findElement(ShoppingPage.btn_lockCLick).click();
		driver.findElement(ShoppingPage.btn_ProceedToCheckout).click();
		Thread.sleep(2000);
		driver.findElement(ShoppingPage.btn_PlaceeOrder).click();
		Thread.sleep(2000);
		driver.findElement(ShoppingPage.btn_Country).sendKeys(PropertiesFile.prop.getProperty("Country"));
		driver.findElement(ShoppingPage.Click_Box).click();
		logger.info("Failed to place order");
		driver.findElement(ShoppingPage.btn_FailedProceed).click();

	}

}
