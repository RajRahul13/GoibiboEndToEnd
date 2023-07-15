package book.hotel.room;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.object.HotelSearchPageObject;
import page.object.SelectedHotelDetailsPageObject;


public class BookForOneAdultOoty {
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
		hs.slectHotelandmoveToChildWinHandle();
		Thread.sleep(4000);
		hs.verifyHotel();
		
		SelectedHotelDetailsPageObject so =new SelectedHotelDetailsPageObject(driver);
		so.RoomOptionBTNclick();
		so.selectRoomBTNtext();
		so.FirstNameIPBOXtext("test");
		so.LastNameIPBOXtext("test");
		so.emailIPBOXtext("test@test.in");
		so.phoneIPBOX("1234123423");
		so.confirmCHKBOXcheck();
		so.proceedPaymentBTNclick();
		
		so.creditDetailsBTNclick();
		so.enterCardNotext("123456789123456789");
		so.expiryMonth();
		so.expiryYear();
		so.cardCvv("2344");
		so.nameOnCard("test");
		Thread.sleep(4000);
		
		
		

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}


