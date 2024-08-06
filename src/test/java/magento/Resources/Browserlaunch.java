package magento.Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Browserlaunch {
	public static WebDriver driver;

	public WebDriver basetest() throws IOException {
		String file = System.getProperty("user.dir")
				+ "\\src\\test\\java\\magento\\Resources\\browserselectionproperties.properties";
		FileInputStream fis = new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fis);
		String Browsername=System.getProperty("browser")!=null?System.getProperty("browser")
				:prop.getProperty("browser");
		if(Browsername.contains("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			if(Browsername.contains("headless"))
			{
			options.addArguments("headless");
		}
		driver=new ChromeDriver(options);
		}
		else if(Browsername.contains("edge"))
		{
			EdgeOptions options=new EdgeOptions();
			if(Browsername.contains("edge"))
			{
				options.addArguments("edge");
			}
			driver=new EdgeDriver(options);
		}
		else if(Browsername.contains("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browsername.contains("edge"))
		{
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod
	public void launch() throws IOException
	{
		driver=basetest();
		driver.get("https://magento.softwaretestingboard.com/customer/account/login");
		
	}
	
	@AfterMethod
	public void logout()
	{
		if(driver!=null)
			driver.close();
		
	}
	}

