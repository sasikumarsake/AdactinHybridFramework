package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class BasePage extends BaseTest {
	
	public BasePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void type(WebElement element, String text)
	{
		waitForElementPresence(element);
		element.sendKeys(text);
		test.log(Status.INFO, "Entered Text"+text+"into the textbox..");
	}

	private void waitForElementPresence(WebElement element) {
		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(configProp.getProperty("explicitWait"))));
		myWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void click(WebElement element)
	{
		waitForElementPresence(element);
		element.click();
		test.log(Status.INFO, "Clicked the button..");
	}
	
	public void selectOptionFromDropdown(WebElement element, String option)
	{
		waitForElementPresence(element);
		new Select(element).selectByVisibleText(option);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	
	public void verifyTextPresentAsValue(WebElement element,String text)
	{
		assertTrue(element.getAttribute("value").contains(text));
	}
	
	public void verifyTitle(String expTitle)
	{
		assertEquals(getTitle(), expTitle);
		test.log(Status.PASS, "Title is matched as expected..");
	}
}
