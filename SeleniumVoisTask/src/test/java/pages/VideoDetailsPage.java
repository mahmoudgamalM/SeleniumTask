package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoDetailsPage {

	WebDriver driver;
	WebElement videoTitleDetailsScreen;
	public VideoDetailsPage (WebDriver driver){

		this.driver = driver;
	}

	public String GetVideoDetailsTitle() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		videoTitleDetailsScreen =driver.findElement(By.xpath("//*[@id=\"container\"]/h1"));
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(videoTitleDetailsScreen));
		String videoDetailsTitleStr =videoTitleDetailsScreen.getText();
		return videoDetailsTitleStr;
	}

}
