package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static String baseUrl="https://www.youtube.com/";

	ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest ;

	@BeforeSuite
	public void BeforeSuite () {
		htmlReporter = new ExtentHtmlReporter("extentReports.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}


	@Parameters("browserName")
	@BeforeTest
	public void Setup(String browserName ) {
		System.out.println("browser Name is:"+browserName);
		System.out.println("Before Test is on"+Thread.currentThread().getId());


		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(baseUrl);

		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(baseUrl);
		}


		/*
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(baseUrl);
		 */
	} 


	@AfterMethod
	public void AfterMethod(ITestResult result) {

		if (result.getStatus()== ITestResult.FAILURE) {

			extentTest.log(Status.FAIL, "Test Case Failed is "+result.getMethod().getMethodName());
			extentTest.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			extentTest.log(Status.SKIP, "Test Case Skipped is "+result.getMethod().getMethodName());
		}

	}


	@AfterSuite
	public void CloseDriver() {
		System.out.println("after Test is on"+Thread.currentThread().getId());
		extent.flush();
		driver.quit();
	}

}
