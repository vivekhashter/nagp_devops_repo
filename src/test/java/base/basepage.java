package base;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.ExtentManager;
import utilities.PropertiesFile;
import utilities.ScreenShots;



public class basepage {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	//private static Logger logger = LogManager.getLogger(basepage.class);
	public void setup() throws IOException {
        if (PropertiesFile.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty(PropertiesFile.getProperty("chromeProperty"),
            		(PropertiesFile.getProperty("chromeDriver")));
                    
            driver = new ChromeDriver();
        } else if (PropertiesFile.getProperty("browser").equalsIgnoreCase("chromeHeadless")) {
            System.setProperty(PropertiesFile.getProperty("chromeProperty"),
            		(PropertiesFile.getProperty("chromeDriver")));
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (PropertiesFile.getProperty("browser").equalsIgnoreCase("firefox")) {
            System.setProperty(PropertiesFile.getProperty("firefoxProperty"),
            		(PropertiesFile.getProperty("firefoxDriver")));
            driver = new FirefoxDriver();
        }else if (PropertiesFile.getProperty("browser").equalsIgnoreCase("firefoxHeadless")) {
            System.setProperty(PropertiesFile.getProperty("firefoxProperty"),
            		(PropertiesFile.getProperty("firefoxDriver")));
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            driver = new FirefoxDriver(options);
        }else if (PropertiesFile.getProperty("browser").equalsIgnoreCase("edge")) {
            System.setProperty(PropertiesFile.getProperty("msedgeProperty"),
            		(PropertiesFile.getProperty("msedgeDriver")));
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get(PropertiesFile.getProperty("Url"));
       // logger.info("driver launched");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }



   @BeforeSuite
    public void init() throws Exception {
        extent = ExtentManager.getInstance("reports/ExtentReports.html");
    }



   @BeforeMethod
    public void startTest(Method method) throws Exception {
        test = extent.startTest(method.getName());
    }



   @AfterMethod

   public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS)
			test.log(LogStatus.PASS, "Test case got passed");
		else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
			String screenshotPath = ScreenShots.takeScreenShot(driver, result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP)
			test.log(LogStatus.SKIP, result.getThrowable());
		extent.endTest(test);
		extent.flush();
	}
   @AfterMethod
   public void teardown()
   {
       driver.close();
    
   }



   @AfterSuite
    public void reportFlush() {
        extent.flush();
    }
}

