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
public class AdactinHotelTC108 extends BaseTest{
	
	@Test
	public void adactinHotelTestTC108()
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
		searchhotelpage.datePickIn("26/05/2025");
		searchhotelpage.datePickOut("27/05/2025");
		searchhotelpage.clickSubmit();
		
		// After clicking Submit, you should land on the Select Hotel page
        SelectHotel selectHotelPage = new SelectHotel();

        selectHotelPage.radioButto();
        selectHotelPage.continueButtonClick();
        

     // After selectHotelPage.continueButtonClick();

        BookAHotelPage bookHotelPage = new BookAHotelPage();

        String priceFromSelectPageStr = selectHotelPage.getTotalPrice();  // e.g., "AUD $135"
        String priceFromBookPageStr = bookHotelPage.getTotalPrice();      // e.g., "AUD $135"

        // Clean strings to compare numbers only
        int priceFromSelectPage = Integer.parseInt(priceFromSelectPageStr.replaceAll("[^\\d]", ""));
        int priceFromBookPage = Integer.parseInt(priceFromBookPageStr.replaceAll("[^\\d]", ""));

        // Assertion
        assertEquals(priceFromBookPage, priceFromSelectPage, "Total price on Book A Hotel page does not match Select Hotel page");

        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
