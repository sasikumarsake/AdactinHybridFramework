package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class BookAHotelPage extends BasePage {

	@FindBy(xpath = "//input[@name='total_price_dis']")
	WebElement totalPrice;

	@FindBy(xpath = "//input[@name='gst_dis']")
	WebElement gstPrice;

	@FindBy(xpath = "//input[@name='final_price_dis']")
	WebElement finalPrice;

	public String getTotalPrice() {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.visibilityOf(totalPrice));
		return totalPrice.getAttribute("value").replaceAll("[^0-9.]", ""); // 250
	}

	public String getGST() {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.visibilityOf(gstPrice));
		return gstPrice.getAttribute("value").replaceAll("[^0-9.]", ""); // 25
	}

	public String getFinalPrice() {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.visibilityOf(finalPrice));
		return finalPrice.getAttribute("value").replaceAll("[^0-9.]", ""); // 275
	}

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstNameField;

	public void firstNameField(String text) {
		type(firstNameField, text);
	}

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastNameField;

	public void lastNameField(String text) {
		type(lastNameField, text);
	}

	@FindBy(xpath = "//textarea[@name='address']")
	WebElement addressField;

	public void adressField(String text) {
		type(addressField, text);
	}

	@FindBy(xpath = "//input[@name='cc_num']")
	WebElement ccNum;

	public void ccNumberField(String text) {
		type(ccNum, text);
	}

	@FindBy(xpath = "//select[@name='cc_type']")
	WebElement ccType;

	public void cctypeField(String option) {
		selectOptionFromDropdown(ccType, option);
	}

	@FindBy(xpath = "//select[@name='cc_exp_month']")
	WebElement ccExpMonth;

	public void ccExpMonthField(String option) {
		selectOptionFromDropdown(ccExpMonth, option);
	}

	@FindBy(xpath = "//select[@name='cc_exp_year']")
	WebElement ccExpyear;

	public void ccExpYearField(String option) {
		selectOptionFromDropdown(ccExpyear, option);
	}

	@FindBy(xpath = "//input[@name='cc_cvv']")
	WebElement cvvNumber;

	public void cvvNumberField(String text) {
		type(cvvNumber, text);
	}

	@FindBy(xpath = "//input[@name='book_now']")
	WebElement clickBookNowButton;

	public void clickBookNowbutton() {
		click(clickBookNowButton);
	}

	@FindBy(xpath = "//input[@name='logout']")
	WebElement logOut;

	public void clickLogOut() {
		click(logOut);
	}

	@FindBy(xpath = "//input[@name='hotel_name_dis']")
	WebElement hotel_name_dis;

	public String getHotelName() {
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		myWait.until(ExpectedConditions.visibilityOf(hotel_name_dis));
		return hotel_name_dis.getAttribute("value");
		
	}

	@FindBy(xpath = "//input[@name='location_dis']")
	WebElement location_dis;

	public String getLocation() {
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		myWait.until(ExpectedConditions.visibilityOf(location_dis));
		return location_dis.getAttribute("value");
	}
	
	@FindBy(xpath = "//input[@name='room_type_dis']")
	WebElement room_type_dis;

	public String getRoomType() {
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		myWait.until(ExpectedConditions.visibilityOf(room_type_dis));
		return room_type_dis.getAttribute("value");
	}
	
	@FindBy(xpath = "//input[@name='room_num_dis']")
	WebElement room_num_dis;

	public String getRoomNumber() {
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		myWait.until(ExpectedConditions.visibilityOf(room_num_dis));
		return room_num_dis.getAttribute("value");
	}
	
	@FindBy(xpath = "//input[@name='order_no']")
	WebElement orderNumberField;

	public String getOrderNumber() {
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		myWait.until(ExpectedConditions.attributeToBeNotEmpty(orderNumberField, "value"));
		String orderNumber = orderNumberField.getAttribute("value");
		return orderNumber;
	}
	
	
	
	
	
}
