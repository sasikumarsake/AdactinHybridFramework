package regression;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.BookAHotelPage;
import pages.LoginPage;
import pages.SearchHotelPage;
import pages.SelectHotel;
import utils.MyTestNGListener;

@Listeners(MyTestNGListener.class)
public class AdactinHotelTC110 extends BaseTest{
	
	@Test
	public void adactinHotelTestTC110()
	{
		LoginPage loginpage=new LoginPage();
		loginpage.usernameTextbox("Sashikumar");
		loginpage.passwordTextbox("Sashikumar@47");
		loginpage.loginButton();
		
		
		SearchHotelPage searchhotelpage=new SearchHotelPage();
		searchhotelpage.locationDropdown("Melbourne");
		searchhotelpage.hotelDropdown("Hotel Creek");
		searchhotelpage.roomTypeDropdown("Standard");
		searchhotelpage.roomNoDropdown("2 - Two");
		searchhotelpage.datePickIn("26/05/2025");
		searchhotelpage.datePickOut("27/05/2025");
		searchhotelpage.clickSubmit();
		
		// After clicking Submit, you should land on the Select Hotel page
        SelectHotel selectHotelPage = new SelectHotel();

        selectHotelPage.radioButto();
        selectHotelPage.continueButtonClick();
        

     // After selectHotelPage.continueButtonClick();

        BookAHotelPage bookHotelPage = new BookAHotelPage();

        int expectedTotalPrice = 125 * 2 * 1; // pricePerNight * rooms * days
        int expectedGST = expectedTotalPrice / 10; // 10%
        int expectedFinalPrice = expectedTotalPrice + expectedGST;

        int actualTotalPrice = Integer.parseInt(bookHotelPage.getTotalPrice());
        int actualGST = Integer.parseInt(bookHotelPage.getGST());
        int actualFinalPrice = Integer.parseInt(bookHotelPage.getFinalPrice());

        assertEquals(actualTotalPrice, expectedTotalPrice, "Total price mismatch");
        assertEquals(actualGST, expectedGST, "GST mismatch");
        assertEquals(actualFinalPrice, expectedFinalPrice, "Final billed price mismatch");

        //bookHotelPage.clickBookNowbutton();
       
        //bookHotelPage.clickLogOut();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
