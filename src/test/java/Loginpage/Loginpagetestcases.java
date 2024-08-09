package Loginpage;

import org.testng.annotations.Test;

import Utilities.LoginExcel;
import magento.Resources.Browserlaunch;
import pageObjects.login;

public class Loginpagetestcases extends Browserlaunch {

	@Test(dataProvider = "loginData", dataProviderClass = LoginExcel.class)
	public void login(String username, String password) {
		login login = new login(driver);
		login.login(username, password);
	}

}
