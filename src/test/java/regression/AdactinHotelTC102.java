package regression;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;

public class AdactinHotelTC102 extends BaseTest {

    @Test(description = "Verify error when Check-In Date is after Check-Out Date")
    public void adactinHotelTestTC102() {

        
        LoginPage loginpage = new LoginPage();
        loginpage.usernameTextbox("Sashikumar");
        loginpage.passwordTextbox("Sashikumar@47");
        loginpage.loginButton();

        SearchHotelPage searchhotelpage = new SearchHotelPage();
        searchhotelpage.locationDropdown("Sydney");
        searchhotelpage.hotelDropdown("Hotel Creek");
        searchhotelpage.roomTypeDropdown("Standard");
        searchhotelpage.roomNoDropdown("1 - One");
        searchhotelpage.datePickIn("28/05/2025");
        searchhotelpage.datePickOut("26/05/2025");
        searchhotelpage.clickSubmit();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actualMessage = searchhotelpage.getDateErrorMessage();
        assertEquals(actualMessage, "Check-In Date shall be before than Check-Out Date");
    }
}
