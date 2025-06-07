package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseTest;

public class BookedItinerary extends BaseTest {

    public BookedItinerary() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@name,'hotel_name_')]")
    WebElement hotelName;

    @FindBy(xpath = "//input[contains(@name,'location_')]")
    WebElement locationField;

    @FindBy(xpath = "//input[@name='order_id_text']")
    WebElement searchOrderID;
    
    @FindBy(xpath = "//input[@name='search_hotel_id']")
    WebElement goButton;
    
    
    public boolean isHotelNameEditable() {
        // Considered editable only if it's enabled AND not readonly
        return hotelName.isEnabled() && hotelName.getAttribute("readonly") == null;
    }

    public boolean isLocationEditable() {
        return locationField.isEnabled() && locationField.getAttribute("readonly") == null;
    }
    
   
    public void clickGOButton()
    {
    	goButton.click();
    }
    @FindBy(xpath = "//input[contains(@name,'first_name_')]")
    WebElement firstName;

    @FindBy(xpath = "//input[contains(@name,'last_name_')]")
    WebElement lastName;

    public void enterOrderID(String orderID) {
       
        searchOrderID.sendKeys(orderID);
    }

    public String getHotelName() {
        return hotelName.getAttribute("value");
    }

    public String getLocation() {
        return locationField.getAttribute("value");
    }

    public String getFirstName() {
        return firstName.getAttribute("value");
    }

    public String getLastName() {
        return lastName.getAttribute("value");
    }
    
    @FindBy(xpath = "(//table[contains(@class,'content')]//input[starts-with(@name,'order_id_')])[2]")
    WebElement firstOrderIdField;

    public String getFirstOrderId() {
        return firstOrderIdField.getAttribute("value");
    }
    
    
}
