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
public class AdactinHotelTC109 extends BaseTest{
	
	@Test
	public void adactinHotelTestTC109()
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

        selectHotelPage.radioButto();
        selectHotelPage.continueButtonClick();
        

     // After selectHotelPage.continueButtonClick();

        BookAHotelPage bookHotelPage = new BookAHotelPage();
        bookHotelPage.firstNameField("Sasikumar");
        bookHotelPage.lastNameField("Kujmaerajhg");
        bookHotelPage.adressField("hagjgsjgkfsghsjhiuwiuahkgjhkjshkjghjghjahjkahgj");
        bookHotelPage.ccNumberField("12345678900987654321");
        bookHotelPage.cctypeField("American Express");
        bookHotelPage.ccExpMonthField("May");
        bookHotelPage.ccExpYearField("2013");
        bookHotelPage.cvvNumberField("8098");
        bookHotelPage.clickBookNowbutton();
       
        bookHotelPage.clickLogOut();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
