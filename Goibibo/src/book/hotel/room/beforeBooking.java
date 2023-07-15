package book.hotel.room;
import java.time.Duration;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.object.GenericPageObject;



public class beforeBooking {
	WebDriver driver;
    WebDriverWait wait;
	@BeforeMethod
	public void launchbrowser() {
		
	String exePath = "C:\\Users\\rahul\\eclipse-workspace\\Goibibo\\Driver\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", exePath);
	driver = new ChromeDriver();

	//Navigate to the given URL https://www.flipkart.com/
	driver.get("https://www.goibibo.com/");

	//maximizing window
	driver.manage().window().maximize();
	
	//implicit wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	
	@Test
	public void bookingforone() {
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		GenericPageObject gc = new GenericPageObject(driver);
		gc.clickLoginModalCloseBTN();
		gc.clickHotelBTN();
		
	}
	
	@AfterMethod
	public void closeBrowser() {
	driver.close();
	driver.quit();
}
}
