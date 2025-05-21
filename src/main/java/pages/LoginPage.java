package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	//WebElements or variables
	
	public LoginPage()
	{
		//PageFactory.initElements(driver, this);
		super();
	}
	
	//we use page factory
	// WebElement usernameTextbox =driver.findElement(By.xpath("//input[@name='username']")
	@FindBy(xpath="//input[@name='username']") WebElement usernameTextbox ;
	
	@FindBy(xpath="//input[@name='password']") WebElement passwordTextbox ;
	
	@FindBy(xpath="//input[@name='login']") WebElement loginButton ;
	
	public void usernameTextbox(String text)
	{
		//usernameTextbox.sendKeys(text);
		type(usernameTextbox, text);
	}
	
	
	public void passwordTextbox(String text)
	{
		//usernameTextbox.sendKeys(text);
		type(passwordTextbox, text);
	}
	
	
	public void loginButton()
	{
		//usernameTextbox.click();
		click(loginButton);
	}
	
	
	
	//Methods
}
