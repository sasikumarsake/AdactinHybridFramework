package regression;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
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
public class AdactinHotelTC112 extends BaseTest{
	
	@Test
	public void adactinHotelTestTC112()
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
        
        
        double totalPrice = Double.parseDouble(bookhotelPage.getTotalPrice());  // 250.0
        double gst = Double.parseDouble(bookhotelPage.getGST());                // 25.0
        double expectedGST = totalPrice * 0.10;
        Assert.assertEquals(gst, expectedGST, "GST is not calculated correctly.");

        double finalPrice = Double.parseDouble(bookhotelPage.getFinalPrice());  // 275.0
        double expectedFinalPrice = totalPrice + gst;
        Assert.assertEquals(finalPrice, expectedFinalPrice, "Final price is not correct.");
        
        System.out.println("The final price is "+expectedFinalPrice);
	}

}
