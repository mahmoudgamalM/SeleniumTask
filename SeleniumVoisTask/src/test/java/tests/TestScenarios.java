package tests;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.SearchResultsPage;
import pages.VideoDetailsPage;
import pages.YoutubeHomePage;
import utils.ExcelUtils;

public class TestScenarios extends TestBase{

	SearchResultsPage objResult;
	YoutubeHomePage objHome;
	VideoDetailsPage objVideoDetails;
	ExcelUtils excelobj;

	String videoTitle;
	String videoDetailsTitle;

	String projectPath=System.getProperty("user.dir");
	String searchKeyWord ;





	@Test 
	public void TestScenario1 () {
		System.out.println("Test SC 01 is on: "+Thread.currentThread().getId());
		extentTest = extent.createTest("Youtube Test Scenario1");
		extentTest.log(Status.INFO, "Starting Test Case");

		excelobj= new ExcelUtils(projectPath+"/excel/TestData.xlsx","Sheet1");
		searchKeyWord= excelobj.getCellData(1, 0);

		//		objHome= new YoutubeHomePage(driver);
		objHome=PageFactory.initElements(driver, YoutubeHomePage.class);

		objHome.clearSearchET();
		objHome.searchVideo(searchKeyWord);



		//		objResult= new SearchResultsPage(driver);
		objResult =PageFactory.initElements(driver,SearchResultsPage.class);

		objResult.FilterByVideo();
		//		videoTitle =objResult.SetPositionAndGetVideoTitle(3);
		videoTitle =objResult.GetVideoTitleBypoistion(3);
		System.out.println(videoTitle);


		//		objVideoDetails=new VideoDetailsPage(driver);
		objVideoDetails=PageFactory.initElements(driver,VideoDetailsPage.class);

		videoDetailsTitle= objVideoDetails.GetVideoDetailsTitle();
		//		System.out.println("Video details Title is:"+videoDetailsTitle);
		Assert.assertEquals(videoTitle, videoDetailsTitle);
		extentTest.pass("Test Passed");
	}


	@Test 
	public void TestScenario2 () {
		System.out.println("Test SC 02 is on: "+Thread.currentThread().getId());
		extentTest = extent.createTest("Youtube Test Scenario2");
		extentTest.log(Status.INFO, "Starting Test Case");

		excelobj= new ExcelUtils(projectPath+"/excel/TestData.xlsx","Sheet1");
		searchKeyWord= excelobj.getCellData(2,0);

		//		objHome= new YoutubeHomePage(driver);
		objHome=PageFactory.initElements(driver, YoutubeHomePage.class);

		objHome.clearSearchET();
		objHome.searchVideo(searchKeyWord);


		//		objResult= new SearchResultsPage(driver);
		objResult =PageFactory.initElements(driver,SearchResultsPage.class);


		objResult.FilterByVideo();
		//		videoTitle =objResult.SetPositionAndGetVideoTitle(3);
		videoTitle =objResult.GetVideoTitleBypoistion(3);
		System.out.println(videoTitle);


		//		objVideoDetails=new VideoDetailsPage(driver);
		objVideoDetails=PageFactory.initElements(driver,VideoDetailsPage.class);

		videoDetailsTitle= objVideoDetails.GetVideoDetailsTitle();
		//				System.out.println("Video detaails Title is:"+videoDetailsTitle);

		Assert.assertEquals(videoTitle, videoDetailsTitle);
		extentTest.pass("Test Case Passed is passTest");

	}


	@Test 
	public void TestScenario3 () {
		System.out.println("Test SC 03 is on: "+Thread.currentThread().getId());
		extentTest = extent.createTest("Youtube Test Scenario3");
		extentTest.log(Status.INFO, "Starting Test Case");

		excelobj= new ExcelUtils(projectPath+"/excel/TestData.xlsx","Sheet1");
		searchKeyWord= excelobj.getCellData(1, 0);

		//		objHome= new YoutubeHomePage(driver);
		objHome=PageFactory.initElements(driver, YoutubeHomePage.class);

		objHome.clearSearchET();
		objHome.searchVideo("Selenium Tutorial");


		//		objResult= new SearchResultsPage(driver);
		objResult =PageFactory.initElements(driver,SearchResultsPage.class);

		objResult.FilterByVideo();
		//		videoTitle =objResult.SetPositionAndGetVideoTitle(10);
		videoTitle =objResult.GetVideoTitleBypoistion(10);

		System.out.println(videoTitle);

		//		objVideoDetails=new VideoDetailsPage(driver);
		objVideoDetails=PageFactory.initElements(driver,VideoDetailsPage.class);


		videoDetailsTitle= objVideoDetails.GetVideoDetailsTitle();
		//		System.out.println("Video detaails Title is:"+videoDetailsTitle);

		Assert.assertEquals(videoTitle, videoDetailsTitle);

		extentTest.pass("Test Case Passed is passTest");
	}



}