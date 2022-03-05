package pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
	WebDriver driver;
	String xpath;
	By filterBT = By.xpath("//*[@id=\"container\"]/ytd-toggle-button-renderer");
	By videoLink = By.linkText("Video");


	/* another Way to declare webelement
	@FindBy(how = How.XPATH,using ="//*[@id=\"container\"]/ytd-toggle-button-renderer") WebElement filterBtn;
	@FindBy(how = How.LINK_TEXT,using ="Video")WebElement videoLink1;
	 */


	public SearchResultsPage (WebDriver driver){

		this.driver = driver;
	}


	public void FilterByVideo () {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(filterBT));
		driver.findElement(filterBT).click();

		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(videoLink));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(videoLink).click();
	}


	public String GetVideoTitleBypoistion (int postion){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement>videoTitles= driver.findElements(By.xpath("//*[@id=\"video-title\"]"));
		String titleTxt = videoTitles.get(postion).getText();
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(videoTitles.get(postion)));
		videoTitles.get(postion).click();
		return titleTxt;
	}


}
