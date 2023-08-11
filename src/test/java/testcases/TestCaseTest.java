package testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.basepage;
import pages.TestCasePage;





public class TestCaseTest extends basepage {
	TestCasePage lp;
	private static Logger logger = LogManager.getLogger(TestCaseTest.class);

	public TestCaseTest() {
		super();
	}

	@BeforeMethod
	public void Setup() throws IOException {
		setup();
		lp = new TestCasePage(null);
	}

	@Test(priority = 1)
	public void TopDealss() throws Exception {

		driver.findElement(TestCasePage.btn_topdeals).click();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(2000);
		logger.info("Successfully Opened Top Deals Page");
		Assert.assertEquals(driver.getTitle(), "GreenKart - veg and fruits kart");
		logger.info("Assertion passed Successfully");
	}
}
