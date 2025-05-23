package regression;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;

public class AdactinHotelTC103 extends BaseTest{
	
	@Test
	public void adactinHotelTestTC103()
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
		searchhotelpage.datePickIn("16/05/2025");
		searchhotelpage.datePickOut("18/05/2025");
		searchhotelpage.clickSubmit();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String actualMessag=searchhotelpage.getDateErrorMessage();
		assertEquals(actualMessag, "Check-In Date should be either Today or Later Date");
		
		
	}

}
