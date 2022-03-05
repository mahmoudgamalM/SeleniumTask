package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YoutubeHomePage {

	WebDriver driver;

	@FindBy(how = How.NAME,using ="search_query")WebElement searchET;

	public YoutubeHomePage (WebDriver driver){
		this.driver = driver;
	}


	public void searchVideo (String searchKeyword){
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(searchET));
		searchET.sendKeys(searchKeyword);
		searchET.submit();

	}

	public void clearSearchET() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(searchET));
		searchET= driver.findElement(By.name("search_query"));
		searchET.clear();
	}	



}
