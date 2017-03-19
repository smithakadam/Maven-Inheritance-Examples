package Bank;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

	WebDriver driver;
	
	@BeforeSuite
	public void beforeLogin(){
		System.out.println("Enter the login Details from file....");
	}
	
	@Test
	public void loginDetails() throws IOException{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Selenium\\MavenApps\\Credit\\appProp.properties");
		
		prop.load(fis);
		System.out.println(prop.getProperty("username")); // username is the filed defined in paramsFile.properties file
		
		if(prop.getProperty("browser").equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:/Selenium/geckodriver-v0.13.0-win64/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver_win32/chromedriver.exe");
			driver= new ChromeDriver();
		
		}else{
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_x64_3.0.0\\iedriverserver.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("url"));
		System.out.println(driver.getTitle());
		System.out.println(prop.getProperty("url"));
	}

	@AfterSuite
	public void afterLogin(){
		System.out.println("Login details fed from file");
	}
}
