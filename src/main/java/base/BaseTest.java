package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import java.lang.reflect.Method;

import exceptions.InvalidBrowserException;
import utils.ExtentManager;

public class BaseTest {

	public static WebDriver driver;

	public static FileInputStream fis1;
	public static Properties configProp;
	
	public static FileInputStream fis2;
	public static Properties locatorsProp;
	public static ExtentReports reports;
	public static ExtentTest test;

	@BeforeTest
	public void beforeTest() {
		try {
			fis1 = new FileInputStream("Properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		configProp = new Properties();
		try {
			configProp.load(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fis2 = new FileInputStream("Properties\\locators.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		locatorsProp = new Properties();
		try {
			locatorsProp.load(fis2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reports=ExtentManager.getReports();
	}

	@BeforeMethod
	public void setUp(Method method) {
		
		test=reports.createTest(method.getName());
		
		String browserName = configProp.getProperty("browser");
		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();
			test.log(Status.INFO, browserName+"browser is started..");
			
			break;
		case "firefox":
			driver = new FirefoxDriver();
			test.log(Status.INFO, browserName+"browser is started..");
			break;

		case "edge":
			driver = new EdgeDriver();
			test.log(Status.INFO, browserName+"browser is started..");
			break;

		default:
			try {
				throw new InvalidBrowserException();
			} catch (InvalidBrowserException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		driver.get(configProp.getProperty("url"));
		test.log(Status.INFO, "App lauched using url.."+configProp.getProperty("url"));
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitwait"))));
	}

	@AfterMethod
	public void tearDown() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();
		test.log(Status.INFO, "browser is closed..");
	}
	
	@AfterTest
	public void reportsEnd()
	{
		reports.flush();
	}
}
