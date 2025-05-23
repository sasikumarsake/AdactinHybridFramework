package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	@FindBy(xpath = "//input[@id='location_0']")
	WebElement displayedLocation;

	// WebElement helloUsernameText;
	public void getDisplayedLocation(String text) {
		verifyTextPresentAsValue(displayedLocation, text);
	}

	@FindBy(xpath = "//input[@id='arr_date_0']")
	WebElement arrivalDate;

	public void verifyArrivalDate(String expectedValue) {
		String actualValue= arrivalDate.getAttribute("value");
		verifyTextPresentAsValue(arrivalDate, expectedValue);
		test.log(Status.INFO, "Room No value verified. Expected: '" + expectedValue + "', Actual: '" + actualValue + "'");
	}
	
	@FindBy(xpath = "//input[@id='rooms_0']") WebElement roomNo;
	public void verifyRoomNoValue(String expectedValue) {
	    String actualValue = roomNo.getAttribute("value");
	    verifyTextPresentAsValue(roomNo, expectedValue);
	    test.log(Status.INFO, "Room No value verified. Expected: '" + expectedValue + "', Actual: '" + actualValue + "'");
	}
	
	@FindBy(xpath = "//input[@id='room_type_0']") WebElement roomType;
	
	public void verifyRoomType(String expectedValue) {
	    String actualValue = roomType.getAttribute("value");
	    verifyTextPresentAsValue(roomType, expectedValue);
	    test.log(Status.INFO, "Room Type value verified. Expected: '" + expectedValue + "', Actual: '" + actualValue + "'");
	}
}
