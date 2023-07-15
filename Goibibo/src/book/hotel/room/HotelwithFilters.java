package book.hotel.room;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.object.HotelDetailsPageObject;
import page.object.HotelSearchPageObject;
import page.object.HotelwithFiltersObjectPage;

public class HotelwithFilters {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void launchbrowser() {

		String exePath = "C:\\Users\\rahul\\eclipse-workspace\\Goibibo\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();

		driver.get("https://www.goibibo.com/hotels/");

		//maximizing window
		driver.manage().window().maximize();
	}

	@Test
	public void bookingforone() throws InterruptedException {
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

		HotelSearchPageObject hs = new HotelSearchPageObject(driver);
		hs.countryRadioBTNclick();
		hs.inputPlaceTXTBOXtext("ooty");
		hs.checkinDATEchoose();
		hs.checkoutDATEchoose();
		hs.guestBTNclick();
		hs.adultdecreaseBTNclick();
		hs.doneBTNclick();
		hs.searchBTNclick();
		hs.hotelTITLE();
		
		HotelwithFiltersObjectPage hp = new HotelwithFiltersObjectPage(driver);
		hp.BookatZeroCHKBOX();
		hp.PriceRangeCHKBOX();
		hp.RatingCHKBOX();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}


