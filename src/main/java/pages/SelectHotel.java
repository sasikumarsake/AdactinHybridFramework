package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class SelectHotel extends BasePage {

	public SelectHotel() {
		// PageFactory.initElements(driver, this);
		super();
	}
	// @FindBy(xpath = "//input[@id='location_0']") WebElement displayedLocation;

//	public String getDisplayedLocation() {
//	    return displayedLocation.getText(); // for normal visible text
//	}

	@FindBy(xpath = "//select[@id='location']")
	WebElement displayedLocation;

	// WebElement helloUsernameText;
	public void getDisplayedLocation(String text) {
		verifyTextPresentAsValue(displayedLocation, text);
	}

	@FindBy(xpath = "//input[@id='arr_date_0']")
	WebElement arrivalDate;

	public void verifyArrivalDate(String expectedValue) {
		String actualValue = arrivalDate.getAttribute("value");
		verifyTextPresentAsValue(arrivalDate, expectedValue);
		test.log(Status.INFO,
				"Room No value verified. Expected: '" + expectedValue + "', Actual: '" + actualValue + "'");
	}

	@FindBy(xpath = "//input[@id='rooms_0']")
	WebElement roomNo;

	public void verifyRoomNoValue(String expectedValue) {
		String actualValue = roomNo.getAttribute("value");
		verifyTextPresentAsValue(roomNo, expectedValue);
		test.log(Status.INFO,
				"Room No value verified. Expected: '" + expectedValue + "', Actual: '" + actualValue + "'");
	}

	@FindBy(xpath = "//input[@id='room_type_0']")
	WebElement roomType;

	public void verifyRoomType(String expectedValue) {
		String actualValue = roomType.getAttribute("value");
		verifyTextPresentAsValue(roomType, expectedValue);
		test.log(Status.INFO,
				"Room Type value verified. Expected: '" + expectedValue + "', Actual: '" + actualValue + "'");
	}

	@FindBy(xpath = "//input[@id='radiobutton_0']")
	WebElement radioButton;

	public void radioButto() {
		click(radioButton);
	}

	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueButtonClick;

	public void continueButtonClick() {
		click(continueButtonClick);
	}

	@FindBy(xpath = "//*[@id='total_price_0']")
	WebElement totalPrice;

	public String getTotalPrice() {
		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.visibilityOf(totalPrice));
	    return totalPrice.getAttribute("value");
	}
	
}
