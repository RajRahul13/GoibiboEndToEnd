package page.object;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelwithFiltersObjectPage {
	WebDriver driver;
	Logger logger=Logger.getLogger("HotelwithFiltersObjectPage");
	
	@FindBy(xpath ="(//span[@class='CheckBoxListstyles__CheckBoxListText-sc-mib0do-9 dOjhCj'])[2]")
	WebElement BookatZero;
	
	@FindBy(xpath ="(//span[@class='CheckBoxListstyles__CheckBoxListText-sc-mib0do-9 dOjhCj'])[7]")
	WebElement PriceRange;
	
	@FindBy(xpath ="(//span[@class='CheckBoxListstyles__CheckBoxListText-sc-mib0do-9 dOjhCj'])[10]")
	WebElement Rating;
	
	public HotelwithFiltersObjectPage(WebDriver d){
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void BookatZeroCHKBOX() {
		BookatZero.click();
		Boolean verification = BookatZero.isSelected();
		logger.info("verification of filter :" + verification);
	}
	
	public void PriceRangeCHKBOX() {
		PriceRange.click();
		Boolean verification = PriceRange.isSelected();
		logger.info("verification of filter :" + verification);
	}
	
	public void RatingCHKBOX() {
		Rating.click();
		Boolean verification = Rating.isSelected();
		logger.info("verification of filter :" + verification);
	}
}
