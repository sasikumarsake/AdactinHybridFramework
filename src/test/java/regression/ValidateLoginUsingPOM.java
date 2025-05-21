package regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;

public class ValidateLoginUsingPOM  extends BaseTest{

	@Test
	public void validateLoginTest()
	{
		//initialize login page
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.usernameTextbox("Sashikumar");
		loginPage.passwordTextbox("Sashikumar@47");
		loginPage.loginButton();
		
		
		//initialize  search hotel page
		SearchHotelPage searchHotelPage=PageFactory.initElements(driver, SearchHotelPage.class);
		searchHotelPage.verifyTitle("Adactin.com - Search Hotel");
		
		searchHotelPage.helloUsernameText("sashikumar");
	}
}
