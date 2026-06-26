package PkgDemo;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ClassListeners implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		Reporter.log("Mtd name is "+result.getName());;
		System.out.println("Listener Start ");
	}
	
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Status is "+result.getStatus());
		System.out.println("Listener Success");
	}
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Status is "+result.getStatus());
		System.out.println("Listener Skipped ");
	}
	public void onTestFailure(ITestResult result) {
		Reporter.log("Status is "+result.getStatus());
		System.out.println("Listener Failure ");
		Object ins =result.getInstance();
		WebDriver cd =((TestNgSelenium)ins).getDriver();
		Date date = new Date(); 
		String currentDate = date.toString().replace(" ","_").replace(":", "_");
		File sshot =((TakesScreenshot)cd).getScreenshotAs(OutputType.FILE);
	    try {
			FileUtils.copyFile(sshot, new File(".//ScreenShot//"+ currentDate+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				 
	}
	public void onFinish(ITestResult result) {
		System.out.println("Listener Finish ");
	}
}
