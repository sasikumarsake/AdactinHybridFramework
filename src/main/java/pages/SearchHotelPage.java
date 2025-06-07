package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import freemarker.core.ReturnInstruction.Return;

public class SearchHotelPage extends BasePage {

	public SearchHotelPage() {
		// PageFactory.initElements(driver, this);
		super();
	}

	@FindBy(xpath = "//input[@id='username_show']")
	WebElement helloUsernameText;

	// WebElement helloUsernameText;
	public void helloUsernameText(String username) {
		// helloUsernameText.getText().concat(username);
		verifyTextPresentAsValue(helloUsernameText, username);
	}

	@FindBy(xpath = "//select[@id='location']")
	WebElement locationDropdown;

	public void locationDropdown(String visibleText) {
		Select select = new Select(locationDropdown);
		select.selectByVisibleText(visibleText);
	}

	@FindBy(xpath = "//select[@id='hotels']")
	WebElement hotelDropdown;

	public void hotelDropdown(String visibleText) {
		Select select = new Select(hotelDropdown);
		select.selectByVisibleText(visibleText);
	}

	@FindBy(xpath = "//select[@id='room_type']")
	WebElement roomTypeDrodpwn;

	public void roomTypeDropdown(String visibleText) {
		Select select = new Select(roomTypeDrodpwn);
		select.selectByVisibleText(visibleText);
	}

	@FindBy(xpath = "//select[@id='room_nos']")
	WebElement roomNoDropdown;

	public void roomNoDropdown(String visibleText) {
		Select select = new Select(roomNoDropdown);
		select.selectByVisibleText(visibleText);

	}

	@FindBy(xpath = "//input[@id='datepick_in']")
	WebElement datePickIn;

	public void datePickIn(String text) {
		datePickIn.clear();
		datePickIn.sendKeys(text);
	}

	@FindBy(xpath = "//input[@id='datepick_out']")
	WebElement datePickOut;

	public void datePickOut(String text) {
		datePickOut.clear();
		datePickOut.sendKeys(text);
	}

	@FindBy(xpath = "//input[@id='Submit']")
	WebElement clickSubmit;

	public void clickSubmit() {
		click(clickSubmit);
	}

	@FindBy(xpath = "//span[@id='checkin_span']")
	WebElement dateErrorMessage;

	public String getDateErrorMessage() {
		return dateErrorMessage.getText();
	}

	@FindBy(xpath = "//input[@id='location_0']")
	WebElement selectedElement;

	private String selectedLocation;
	public String getSelectedLocation() {
	    return selectedLocation;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Booked Itinerary')]") WebElement clickMyIternarary;
	public void clickMyIternararyButton()
	{
		click(clickMyIternarary);
	}
}
