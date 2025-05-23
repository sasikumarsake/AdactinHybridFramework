package regression;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;
import pages.SelectHotel;

public class AdactinHotelTC106 extends BaseTest{
	
	@Test
	public void adactinHotelTestTC106()
	{
		LoginPage loginpage=new LoginPage();
		loginpage.usernameTextbox("Sashikumar");
		loginpage.passwordTextbox("Sashikumar@47");
		loginpage.loginButton();
		
		
		SearchHotelPage searchhotelpage=new SearchHotelPage();
		searchhotelpage.locationDropdown("Sydney");
		searchhotelpage.hotelDropdown("Hotel Creek");
		searchhotelpage.roomTypeDropdown("Standard");
		searchhotelpage.roomNoDropdown("1 - One");
		searchhotelpage.datePickIn("22/05/2025");
		searchhotelpage.datePickOut("23/05/2025");
		searchhotelpage.clickSubmit();
		
		// After clicking Submit, you should land on the Select Hotel page
        SelectHotel selectHotelPage = new SelectHotel();
        selectHotelPage.verifyRoomNoValue("1 Rooms");
	}

}
