package PkgDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestStaticAccess {

	public static WebDriver wd;
	
	@BeforeTest
	public void setup() {		
		WebDriverManager.chromedriver().setup();
		wd=new ChromeDriver();
		
	}
	
	@AfterTest
	public static void tearDown() {
		wd.close();
	}
}
