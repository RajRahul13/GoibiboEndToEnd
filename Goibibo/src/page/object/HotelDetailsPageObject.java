package page.object;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelDetailsPageObject {
	WebDriver driver;
	Logger logger=Logger.getLogger("HotelDetailsPageObject");
	
	@FindBy(xpath = "//a[@href='#rooms']")
	WebElement RoomOptions;
	
	@FindBy(xpath = "//a[@href='#amenities']")
	WebElement amenities;
	
	@FindBy(xpath = "//a[@href='#guest-reviews']")
	WebElement guestReview;
	
	@FindBy(xpath = "//a[@href='#hotel-policies']")
	WebElement propertyPolicies;
	
	@FindBy(xpath = "//a[@href='#location']")
	WebElement location;
	
	@FindBy(xpath = "//a[@href='#QnA']")
	WebElement QnA;
	
	public HotelDetailsPageObject(WebDriver d){
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void RoomOptionsBTN() {
		RoomOptions.click();
		logger.info(RoomOptions.getText());
	}
	
	public void amenitiesBTN() {
		amenities.click();
		logger.info(amenities.getText());
	}
	
	public void guestReviewBTN() {
		guestReview.click();
		logger.info(guestReview.getText());
	}
	
	public void propertyPoliciesBTN() {
		propertyPolicies.click();
		logger.info(propertyPolicies.getText());
	}
	
	public void locationBTN() {
		location.click();
		logger.info(location.getText());
	}
	
	public void QnA() {
		QnA.click();
		logger.info(QnA.getText());
	}
}

