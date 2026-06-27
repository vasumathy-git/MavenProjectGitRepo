package PkgDemo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JenkinsDemoClass {
	
	@Test
	public void JenkinsMtd() {
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		ChromeDriver cd = new ChromeDriver(options);
		cd.get("https://www.google.com");
		cd.manage().window().maximize();
	}

}
