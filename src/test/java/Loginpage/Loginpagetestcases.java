package Loginpage;

import org.testng.annotations.Test;

import magento.Resources.Browserlaunch;
import pageObjects.login;

public class Loginpagetestcases extends Browserlaunch{
	
	@Test
	public void login()
	{
		login login=new login(driver);
		login.login("ChandubhanuPrakash123@gmail.com", "Bhanu@07");
	}

}
