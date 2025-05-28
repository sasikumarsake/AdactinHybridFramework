package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseTest;

public class BookedItinerary extends BaseTest{
	
	@FindBy(xpath = "//input[@name='hotel_name_1293657']")
    WebElement hotelName;

    @FindBy(xpath = "//input[@name='location_1293657']")
    WebElement locationField;

    // Method to check if Hotel Name is editable
    public boolean isHotelNameEditable() {
        return hotelName.isEnabled() && hotelName.getAttribute("readonly") == null;
    }

    // Method to check if Location is editable
    public boolean isLocationEditable() {
        return locationField.isEnabled() && locationField.getAttribute("readonly") == null;
    }
	
	
}
