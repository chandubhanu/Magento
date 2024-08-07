package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
	public WebDriver driver;

	public login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	    
	}
	
	@FindBy(id="email")
	WebElement email;
	@FindBy(id="pass")
	WebElement Password;
	@FindBy(xpath="//button[@class='action login primary']")
	WebElement signinButton;
	
	
	public void login(String Username,String password)
	{
		email.sendKeys(Username);
		Password.sendKeys(password);
		signinButton.click();
		
	}
}
