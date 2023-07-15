package page.object;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HotelSearchPageObject {
	WebDriver driver;
	Logger logger=Logger.getLogger("HotelSearchPageObject");
	String HotelTitle;
	String HotelName;

	@FindBy(xpath="(//input[@name='CountryType'])[1]")
	WebElement countryRadioBTN;

	@FindBy(id="downshift-1-input")
	WebElement inputPlaceTXTBOX;

	@FindBy(xpath="(//h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-10 SearchBlockUIstyles__CheckInDateWrapDiv-sc-fity7j-15 kJLbNT gbNkLl'])[1]")
	WebElement checkinDATE;

	@FindBy(xpath="(//h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-10 SearchBlockUIstyles__CheckInDateWrapDiv-sc-fity7j-15 kJLbNT gbNkLl'])[2]")
	WebElement checkoutDATE;

	@FindBy(xpath="//input[@type='text']")
	WebElement guestBTN;

	@FindBy(xpath="//span[@data-testid='button-adult-dec']")
	WebElement adultdecreaseBTN;

	@FindBy(xpath="//button[@aria-label='button-pax-home']")
	WebElement doneBTN;

	@FindBy(xpath="//button[@data-testid='searchHotelBtn']")
	WebElement searchBTN;

	@FindBy(xpath="//h4[@itemprop='name']")
	WebElement hotelTITLE;

	public HotelSearchPageObject(WebDriver d){
		driver=d;
		PageFactory.initElements(d, this);
	}

	public void countryRadioBTNclick() {
		countryRadioBTN.click();
	}

	public void inputPlaceTXTBOXtext(String place) {
		inputPlaceTXTBOX.sendKeys(place);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		inputPlaceTXTBOX.sendKeys(Keys.ARROW_DOWN);
		inputPlaceTXTBOX.sendKeys(Keys.ENTER);	
	}

	public void checkinDATEchoose() {
		checkinDATE.click();
		driver.findElement(By.xpath("//span[@data-testid='date_26_6_2023']")).click();
	}

	public void checkoutDATEchoose() {
		driver.findElement(By.xpath("//span[@data-testid='date_28_6_2023']")).click();	
	}

	public void guestBTNclick() {
		guestBTN.click();
	}

	public void adultdecreaseBTNclick() {
		adultdecreaseBTN.click();
	}

	public void doneBTNclick() {
		doneBTN.click();
	}

	public void searchBTNclick() {
		searchBTN.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void hotelTITLE() {
		driver.findElement(By.xpath("//a[@class='close']")).click();
		List<WebElement> availablehotels = driver.findElements(By.xpath("//h4[@itemprop='name']"));
		HotelTitle = availablehotels.get(0).getText();
		int totalhotel = availablehotels.size();
		logger.info(HotelTitle);
		logger.info("total number of hotel :"+totalhotel);
	}
	
	public void slectHotel() {
		List<WebElement> availablehotels = driver.findElements(By.xpath("//h4[@itemprop='name']"));
		availablehotels.get(0).click();
	}
	
	public void slectHotelandmoveToChildWinHandle() {
		List<WebElement> availablehotels = driver.findElements(By.xpath("//h4[@itemprop='name']"));
		Set<String> windowHandles = driver.getWindowHandles();
		availablehotels.get(0).click();
		
		Set<String> updatedWindowHandles = driver.getWindowHandles();
	    updatedWindowHandles.removeAll(windowHandles);
	    for (String window: updatedWindowHandles) {
	        driver.switchTo().window(window);
	    	}
	}
	public void verifyHotel() {
		HotelName = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
		try {
		Assert.assertEquals(HotelTitle, HotelName);
		}catch (AssertionError e) {
			e.printStackTrace();
		}
	}
}
