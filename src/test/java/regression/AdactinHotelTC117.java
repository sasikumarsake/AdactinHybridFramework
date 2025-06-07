package regression;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.*;

@Listeners(utils.MyTestNGListener.class)
public class AdactinHotelTC117 extends BaseTest {

    @Test(description = "Display the relevent Order ID")
    public void adactinHotelTestTC117() {



        // Login
        LoginPage loginPage = new LoginPage();
        loginPage.usernameTextbox("Sashikumar");
        loginPage.passwordTextbox("Sashikumar@47");
        loginPage.loginButton();

        //SearchHotelPage
        SearchHotelPage searchHotel=new SearchHotelPage();
        searchHotel.clickMyIternararyButton();
                
        // Booked Itinerary
        BookedItinerary itinerary = new BookedItinerary();
        String orderId = itinerary.getFirstOrderId();  // Gets first Order ID
        itinerary.enterOrderID(orderId);                   // Clicks GO
        itinerary.clickGOButton();

        
    }
}
