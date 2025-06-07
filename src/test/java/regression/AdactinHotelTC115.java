package regression;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.BookAHotelPage;
import pages.BookedItinerary;
import pages.LoginPage;
import pages.SearchHotelPage;
import pages.SelectHotel;
import utils.MyTestNGListener;

@Listeners(MyTestNGListener.class)
public class AdactinHotelTC115 extends BaseTest{
	
	@Test(description = "User should not be able to edit the booked itinerary")
	public void adactinHotelTestTC115()
	{
		LoginPage loginpage=new LoginPage();
		loginpage.usernameTextbox("Sashikumar");
		loginpage.passwordTextbox("Sashikumar@47");
		loginpage.loginButton();
		
		
		SearchHotelPage searchhotelpage=new SearchHotelPage();
		searchhotelpage.locationDropdown("Sydney");
		searchhotelpage.hotelDropdown("Hotel Creek");
		searchhotelpage.roomTypeDropdown("Standard");
		searchhotelpage.roomNoDropdown("2 - Two");
		searchhotelpage.datePickIn("27/05/2025");
		searchhotelpage.datePickOut("28/05/2025");
		searchhotelpage.clickSubmit();
		
		// After clicking Submit, you should land on the Select Hotel page
        SelectHotel selectHotelPage = new SelectHotel();
        selectHotelPage.radioButto();
        selectHotelPage.continueButtonClick();
        
        
        BookAHotelPage bookhotelPage = new BookAHotelPage();
        
        bookhotelPage.firstNameField("Kumar");
        bookhotelPage.lastNameField("keSA");
        bookhotelPage.adressField("4-148, VINAYAK NAGAR, BATHALAPALLI, BATHALAPALLI, SRI SATHYA SAI, ANDHRA PRADESH - 515661");
        bookhotelPage.ccNumberField("12345678900987654321");
        bookhotelPage.cctypeField("American Express");
        bookhotelPage.ccExpMonthField("May");
        bookhotelPage.ccExpYearField("2019");
        bookhotelPage.cvvNumberField("123");
        bookhotelPage.clickBookNowbutton();        
        bookhotelPage.clickMyIternararyButton();

        BookedItinerary bookItinerary = new BookedItinerary();
        
        // Now assert fields are NOT editable
        Assert.assertFalse(bookItinerary.isHotelNameEditable(), "Hotel Name should not be editable");
        Assert.assertFalse(bookItinerary.isLocationEditable(), "Location should not be editable");
        
                 
	}

}
