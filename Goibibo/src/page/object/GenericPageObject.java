package page.object;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenericPageObject {
	WebDriver driver;
	
	@FindBy(xpath="//span[@role='presentation']")
	WebElement LoginModalCloseBTN;
	
	@FindBy(xpath ="//a[@href='/hotels/']")
	WebElement HotelBTN;
	
	public GenericPageObject(WebDriver d){
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void clickLoginModalCloseBTN() {
		LoginModalCloseBTN.click();
	}
	
	public void clickHotelBTN() {
		HotelBTN.click();
	}
	
}
