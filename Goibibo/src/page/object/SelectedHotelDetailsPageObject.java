package page.object;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectedHotelDetailsPageObject {
	WebDriver driver;
	Logger logger=Logger.getLogger("HotelSearchPageObject");
	
	@FindBy(xpath ="//div//span[contains(text(),'VIEW')]")
	WebElement RoomOptionBTN;
	
	@FindBy(xpath ="(//button[@data-testid='selectRoomBtn'])[1]")
	WebElement selectRoomBTN;
	
	@FindBy(xpath = "//INPUT[@placeholder='Enter First Name']")
	WebElement FirstNameIPBOX;
	
	@FindBy(xpath = "//INPUT[@placeholder='Enter Last Name']")
	WebElement LastNameIPBOX;
	
	@FindBy(xpath = "//INPUT[@placeholder='Enter Email Address']")
	WebElement emailIPBOX;
	
	@FindBy(xpath = "//INPUT[@placeholder='Enter Phone Number']")
	WebElement phoneIPBOX;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[1]/div[3]/div/div[2]/div/span/b")
	WebElement confirmCHKBOX;
	
	@FindBy(xpath ="//span[contains(text(),'Proceed To Payment Options')]")
	WebElement proceedPaymentBTN;
	
	@FindBy(xpath = "(//span[@class='font16 semiBold lineHeight24 appendBottom4'])[2]")
	WebElement creditDetailsBTN;
	
	@FindBy(xpath = "//input[@name='cardNumber']")
	WebElement enterCardNo;
	
	@FindBy(xpath = "//input[@name='expiryMonth']")
	WebElement expiryMonth;
	
	@FindBy(xpath = "//input[@name='expiryYear']")
	WebElement expiryYear;
	
	@FindBy(xpath = "//input[@name='cardCvv']")
	WebElement cardCvv;
	
	@FindBy(xpath = "//input[@name='nameOnCard']")
	WebElement nameOnCard;
	
	public SelectedHotelDetailsPageObject(WebDriver d){
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void RoomOptionBTNclick() {
		RoomOptionBTN.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectRoomBTNtext() {
		selectRoomBTN.click();
	}
	
	public void FirstNameIPBOXtext(String fname) {
		FirstNameIPBOX.sendKeys(fname);
	}
	
	public void LastNameIPBOXtext(String lname) {
		LastNameIPBOX.sendKeys(lname);
	}
	
	public void emailIPBOXtext(String email) {
		emailIPBOX.sendKeys(email);
	}
	
	public void phoneIPBOX(String phone) {
		phoneIPBOX.sendKeys(phone);
	}
	
	public void confirmCHKBOXcheck() {
		confirmCHKBOX.click();
	}
	
	public void proceedPaymentBTNclick() {
		proceedPaymentBTN.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void creditDetailsBTNclick() {
		creditDetailsBTN.click();
	}
	
	public void enterCardNotext(String cardNum) {
		enterCardNo.sendKeys(cardNum);
	}
	
	public void expiryMonth() {
		expiryMonth.click();
		driver.findElement(By.xpath("//li[contains(text(),'02')]")).click();
	}
	
	public void expiryYear() {
		expiryYear.click();
		driver.findElement(By.xpath("//li[contains(text(),'2025')]")).click();
	}
	
	public void cardCvv(String cvv) {
		cardCvv.sendKeys(cvv);
	}
	
	public void nameOnCard(String name) {
		nameOnCard.sendKeys(name);
	}
}
