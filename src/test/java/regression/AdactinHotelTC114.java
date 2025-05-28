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
public class AdactinHotelTC114 extends BaseTest{
	
	@Test(description = "Verify Order NUmber is generedated in Book Hotel Page")
	public void adactinHotelTestTC114()
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
        
        bookhotelPage.firstNameField("Saskumar");
        bookhotelPage.lastNameField("Sake");
        bookhotelPage.adressField("4-148, VINAYAK NAGAR, BATHALAPALLI, BATHALAPALLI, SRI SATHYA SAI, ANDHRA PRADESH - 515661");
        bookhotelPage.ccNumberField("12345678900987654321");
        bookhotelPage.cctypeField("American Express");
        bookhotelPage.ccExpMonthField("May");
        bookhotelPage.ccExpYearField("2019");
        bookhotelPage.cvvNumberField("123");
        bookhotelPage.clickBookNowbutton();
        
        String orderNumber = bookhotelPage.getOrderNumber();
        Assert.assertNotNull(orderNumber, "Order Number should not be null");
        Assert.assertFalse(orderNumber.trim().isEmpty(), "Order Number should not be empty");

        System.out.println("Generated Order Number: " + orderNumber);


        
	}

}
