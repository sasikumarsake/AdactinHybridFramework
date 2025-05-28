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
public class AdactinHotelTC113 extends BaseTest{
	
	@Test(description = "Verify Selected data is same in the book hotel page.")
	public void adactinHotelTestTC113()
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
        
        String hotelName = bookhotelPage.getHotelName();
        String location = bookhotelPage.getLocation();
        String roomType = bookhotelPage.getRoomType();
        String roomNumber = bookhotelPage.getRoomNumber();
        
        // ✅ Print to console
        System.out.println("Hotel Name: " + hotelName);
        System.out.println("Location: " + location);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Rooms: " + roomNumber);
        
        Assert.assertEquals(bookhotelPage.getHotelName(), "Hotel Creek");
        Assert.assertEquals(bookhotelPage.getLocation(), "Sydney");
        Assert.assertEquals(bookhotelPage.getRoomType(), "Standard");
        Assert.assertEquals(bookhotelPage.getRoomNumber(), "2 Room(s)");
        
        
	}

}
