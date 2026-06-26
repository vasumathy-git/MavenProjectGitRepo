package PkgDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners(ClassListeners.class)
public class TestNgSelenium {
	
	public WebDriver getDriver() {
	WebDriverManager.chromedriver().setup();
	WebDriver cd = new ChromeDriver();
	cd.manage().window().maximize();
	return cd;
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void titleTest() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		// Disable the "automation" flag so bot detection isn't triggered
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		options.setExperimentalOption("useAutomationExtension", false);
		// Add arguments to prevent detection
		options.addArguments("--disable-blink-features=AutomationControlled");
		options.addArguments("--disable-infobars");
		ChromeDriver cd = new ChromeDriver(options);
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/*
		 * cd.get("https://www.google.com"); String actualTitle = cd.getTitle(); String
		 * expTitle = "Google"; System.out.println(actualTitle);
		 * Assert.assertEquals(actualTitle, expTitle);
		 */
		cd.get("https://www.ebay.com/");
		String expTxt = "Search";
		String SearchBtn = cd.findElement(By.id("gh-search-btn")).getAttribute("value");
		Assert.assertTrue(false);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(SearchBtn, expTxt,"Title verification failed");
		sa.assertAll();
		cd.close(); 
	}
}
