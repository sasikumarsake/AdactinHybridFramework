package regression;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.*;

@Listeners(utils.MyTestNGListener.class)
public class AdactinHotelTC116 extends BaseTest {

    @Test(description = "Book hotel -> validate itinerary details match using Order ID")
    public void adactinHotelTestTC116() {

        // Test data
        String expectedHotelName = "Hotel Creek";
        String expectedLocation = "Sydney";
        String expectedFirstName = "Neekeddhukura Ivanni ";
        String expectedLastName = "Sarele Malli Chusukundham";

        // Login
        LoginPage loginPage = new LoginPage();
        loginPage.usernameTextbox("Sashikumar");
        loginPage.passwordTextbox("Sashikumar@47");
        loginPage.loginButton();

        // Search Hotel
        SearchHotelPage searchHotelPage = new SearchHotelPage();
        searchHotelPage.locationDropdown(expectedLocation);
        searchHotelPage.hotelDropdown(expectedHotelName);
        searchHotelPage.roomTypeDropdown("Standard");
        searchHotelPage.roomNoDropdown("2 - Two");
        searchHotelPage.datePickIn("27/05/2025");
        searchHotelPage.datePickOut("28/05/2025");
        searchHotelPage.clickSubmit();

        // Select Hotel
        SelectHotel selectHotel = new SelectHotel();
        selectHotel.radioButto();
        selectHotel.continueButtonClick();

        // Book Hotel
        BookAHotelPage bookHotel = new BookAHotelPage();
        bookHotel.firstNameField(expectedFirstName);
        bookHotel.lastNameField(expectedLastName);
        bookHotel.adressField("SRI SATHYA SAI, ANDHRA PRADESH - 515661");
        bookHotel.ccNumberField("1111111111111111");
        bookHotel.cctypeField("American Express");
        bookHotel.ccExpMonthField("May");
        bookHotel.ccExpYearField("2026");
        bookHotel.cvvNumberField("123");
        bookHotel.clickBookNowbutton();

        // Wait & Get Order ID
        String orderID = bookHotel.getOrderNumber();
        bookHotel.clickMyIternararyButton();

        // Booked Itinerary
        BookedItinerary itinerary = new BookedItinerary();
        itinerary.enterOrderID(orderID);
        itinerary.clickGOButton();

        // Assertions
        Assert.assertEquals(itinerary.getHotelName(), expectedHotelName, "Hotel Name mismatch");
        Assert.assertEquals(itinerary.getLocation(), expectedLocation, "Location mismatch");
        Assert.assertEquals(itinerary.getFirstName(), expectedFirstName, "First Name mismatch");
        Assert.assertEquals(itinerary.getLastName(), expectedLastName, "Last Name mismatch");
    }
}
