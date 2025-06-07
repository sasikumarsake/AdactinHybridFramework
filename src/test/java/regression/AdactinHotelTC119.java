package regression;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.*;

@Listeners(utils.MyTestNGListener.class)
public class AdactinHotelTC119 extends BaseTest {

	@Test(description = "Verify Order gets cancelled after click on cancel order button.")
	public void adactinHotelTestTC119() {

		// Login
		LoginPage loginPage = new LoginPage();
		loginPage.usernameTextbox("Sashikumar");
		loginPage.passwordTextbox("Sashikumar@47");
		loginPage.loginButton();

		// SearchHotelPage
		SearchHotelPage searchhotelpage = new SearchHotelPage();
		searchhotelpage.locationDropdown("Sydney");
		searchhotelpage.hotelDropdown("Hotel Creek");
		searchhotelpage.roomTypeDropdown("Standard");
		searchhotelpage.roomNoDropdown("2 - Two");
		searchhotelpage.datePickIn("28/05/2025");
		searchhotelpage.datePickOut("29/05/2025");
		searchhotelpage.clickSubmit();

		// selectHotel
		SelectHotel selectHotel = new SelectHotel();
		selectHotel.radioButto();
		selectHotel.continueButtonClick();

		BookAHotelPage bookhotelPage = new BookAHotelPage();

		bookhotelPage.firstNameField("Saskumar");
		bookhotelPage.lastNameField("Sake");
		bookhotelPage.adressField(
				"4-148, VINAYAK NAGAR, BATHALAPALLI, BATHALAPALLI, SRI SATHYA SAI, ANDHRA PRADESH - 515661");
		bookhotelPage.ccNumberField("12345678900987654321");
		bookhotelPage.cctypeField("American Express");
		bookhotelPage.ccExpMonthField("May");
		bookhotelPage.ccExpYearField("2019");
		bookhotelPage.cvvNumberField("123");
		bookhotelPage.clickBookNowbutton();
		bookhotelPage.clickMyIternararyButton();
		
		
		// Booked Itinerary
		BookedItinerary itinerary = new BookedItinerary();
		String orderId = itinerary.getFirstOrderId(); // Gets first Order ID
		itinerary.enterOrderID(orderId); // Clicks GO
		itinerary.clickGOButton();

	}
}
