package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends  BasePage {
	
	public SearchHotelPage()
	{
		//PageFactory.initElements(driver, this);
		super();
	}
	@FindBy(xpath="//input[@id='username_show']") WebElement helloUsernameText;
	//WebElement helloUsernameText;
	public void helloUsernameText(String username)
	{
		//helloUsernameText.getText().concat(username);
		verifyTextPresentAsValue(helloUsernameText, username);
	}

}
