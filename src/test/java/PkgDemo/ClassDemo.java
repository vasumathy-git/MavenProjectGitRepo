package PkgDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.event.HyperlinkListener;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.core.exec.ListSecretsCmdExec;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassDemo {
	
	public static Logger log;

	public static void main(String[] args) throws InterruptedException, IOException {
		
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\BrowserDrivers\\chromedriver.exe");
		
				
		ChromeOptions options = new ChromeOptions();
		// Disable the "automation" flag so bot detection isn't triggered
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		options.setExperimentalOption("useAutomationExtension", false);
		// Add arguments to prevent detection
		options.addArguments("--disable-blink-features=AutomationControlled");
		options.addArguments("--disable-infobars");
		options.addArguments("--window-size=1920,1080");
		
		options.setAcceptInsecureCerts(true);
		// Optional: Arguments to ignore common SSL/TLS errors
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--ignore-ssl-errors=yes");

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver cd = new ChromeDriver(options);
		
		//cd.get("https://expired.badssl.com/");
		/*
		 * String username="admin"; String password="admin";
		 * cd.get("https://"+username+":"+password+
		 * "@the-internet.herokuapp.com/basic_auth");
		 */
		/*
		 * FileWriter fr = new FileWriter(System.getProperty("user.dir")+
		 * "\\src\\test\\resources\\Properties\\testdata.txt"); BufferedWriter br = new
		 * BufferedWriter(fr); br.write("Using buffered writer"); br.newLine();
		 * br.write("test"); br.close();
		 */
		/*
		 * FileWriter fw = new FileWriter(System.getProperty("user.dir")+
		 * "\\src\\test\\resources\\Properties\\testdata.csv"); BufferedWriter bw = new
		 * BufferedWriter(fw); bw.write("Name,Age,Occupation"); bw.newLine();
		 * bw.write("John Doe,30,Software Engineer"); bw.close();
		 */
		
		/*
		 * FileReader fr = new FileReader(System.getProperty("user.dir")+
		 * "\\src\\test\\resources\\Properties\\testdata.csv"); BufferedReader br = new
		 * BufferedReader(fr); String line; while((line= br.readLine())!= null) {
		 * System.out.println(line); }
		 */
		
		/*
		 * XSSFWorkbook wb = new XSSFWorkbook(); XSSFSheet sh = wb.createSheet(); Row r=
		 * sh.createRow(0); Cell c = r.createCell(0); c.setCellValue("Name");
		 * r.createCell(1).setCellValue("Age");
		 * r.createCell(2).setCellValue("Occupation"); Row r1=sh.createRow(1);
		 * r1.createCell(0).setCellValue("John Doe");
		 * r1.createCell(1).setCellValue("30");
		 * r1.createCell(2).setCellValue("Software Engineer"); FileOutputStream fos =
		 * new FileOutputStream(System.getProperty("user.dir")+
		 * "\\src\\test\\resources\\Properties\\testdata.xls"); wb.write(fos);
		 * fos.close(); wb.close();
		 */
		
		/*
		 * FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
		 * "\\src\\test\\resources\\Properties\\testdata.xls"); Workbook wb =
		 * WorkbookFactory.create(fis); Sheet sh = wb.getSheetAt(0); for(Row r : sh) {
		 * for(Cell c :r) { switch (c.getCellType()) { case STRING:
		 * System.out.print(c.getStringCellValue()); break; case NUMERIC:
		 * System.out.print(c.getNumericCellValue()); break; default: break; }
		 * System.out.print("\t"); } System.out.println("\n"); }
		 * 
		 * wb.close(); fis.close();
		 */	
		
		/*
		 * Properties p = new Properties();; FileInputStream fis = new FileInputStream(
		 * "C:\\Users\\vasud\\eclipse-workspace\\MavenProject\\src\\test\\resources\\Properties\\testdata.properties"
		 * ); p.load(fis); String url = p.getProperty("url"); System.out.println(url);
		 * String browser = p.getProperty("browser"); System.out.println(browser);
		 * FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+
		 * "\\src\\\\test\\\\resources\\\\Properties\\\\testdata.properties");
		 * p.setProperty("testkey", "testvalue"); p.store(fos, "test comments");
		 */
		
		/*
		 * cd.get("https://www.ebay.com"); cd.manage().window().maximize();
		 * 
		 * cd.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("mobile");
		 * cd.findElement(By.id("gh-search-btn")).click(); String winH
		 * =cd.getWindowHandle(); System.out.println(winH); //
		 * cd.navigate().to("https://www.google.com");
		 * 
		 * 
		 * //cd.switchTo().newWindow(WindowType.WINDOW);
		 * cd.switchTo().newWindow(WindowType.TAB); cd.get("https://www.google.com");
		 * 
		 * Set<String> winHs = cd.getWindowHandles(); System.out.println(winHs);
		 * cd.switchTo().window(winH);
		 */
		// cd.close();
		/*
		 * cd.get("https://kitchen.applitools.com/ingredients/select");
		 * cd.manage().window().maximize();
		 * 
		 * WebElement weddl = cd.findElement(By.id("spices-select-single")); Select ddl
		 * = new Select(weddl); // ddl.selectByIndex(2); //
		 * ddl.selectByVisibleText("Garlic"); ddl.selectByValue("paprika"); WebElement
		 * eddl = cd.findElement(By.id("spices-select-multi")); Select multiddl = new
		 * Select(eddl); multiddl.selectByIndex(0); multiddl.selectByValue("paprika");
		 * multiddl.selectByVisibleText("Garlic");
		 * 
		 * List<WebElement> lst = multiddl.getAllSelectedOptions();
		 * System.out.println(lst.size()); multiddl.deselectByIndex(0);
		 * multiddl.deselectAll();
		 */
		//cd.get("https://www.ebay.com");
		//cd.manage().window().maximize();
		/*
		 * WebElement actEle
		 * =cd.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/a"));
		 * 
		 * Actions actions = new Actions(cd); actions.moveToElement(actEle).perform();
		 * cd.findElement(By.xpath("//*[@id="+"'vl-flyout-nav'"+
		 * "]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[3]/a")).click();
		 */
		//cd.findElement(By.id("gh-cat")).click();
		/*
		 * WebElement weddl = cd.findElement(By.id("gh-cat")); Select ddl = new
		 * Select(weddl); ddl.selectByValue("2984");
		 * cd.findElement(By.id("gh-search-btn")).click();
		 */
		/*
		 * List<WebElement> lst =cd.findElements(By.tagName("a"));
		 * System.out.println(lst.get(3).getAttribute("href"));
		 * System.out.println(lst.get(3).getText()); System.out.println(lst.size());
		 */
		/*
		 * Actions act = new Actions(cd); WebElement we =
		 * cd.findElement(By.xpath("//*[@id=\"gh\"]/nav/div[2]/div[2]/span/a"));
		 * act.contextClick(we).perform();
		 */
		//cd.get("https://www.cleartrip.com/");
		//cd.get("https://www.nseindia.com/");
		//cd.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		//cd.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		//cd.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");	
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions a = new Actions(cd);
		
		String customName = "TestRun_" + System.currentTimeMillis();
		// Set the system property used in log4j2 xml
		System.setProperty("logFileName", customName);
		log = LogManager.getLogger(ClassDemo.class);
		String url ="https://www.google.com/";
		log.info("Navigating to URL: " + url);
		cd.get(url);
		log.debug("Testing debug");
		if(cd.getTitle().equals("Google")) {
		    log.info("Title match successful.");
		} else {
		    log.error("Title mismatch!");
		}
		/*
		 * System.out.println(cd.getTitle()); cd.findElement(By.xpath(
		 * "/html/body/div[2]/div/div/div/div/div[2]/div/div[1]/div[2]")).click();
		 * cd.findElement(By.id("roundtrip")).click(); WebElement from
		 * =cd.findElement(By.xpath("//*[@id="+"'__next'"+
		 * "]/div/main/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[1]/input"
		 * )); from.sendKeys("Chennai"); Thread.sleep(1000); //WebDriverWait wait = new
		 * WebDriverWait(cd, Duration.ofSeconds(100)); //not working
		 * 
		 * WebElement element =cd.findElement(By.xpath("//*[@id="+"'__next'"+
		 * "]/div/main/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[1]/div[2]/ul[1]/li/div"
		 * )); // 2. Wait for the element to be clickable not working //WebElement
		 * element =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id="+
		 * "'__next'"+
		 * "]/div/main/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[1]/div[2]/ul[1]"
		 * ))); Actions a = new Actions(cd);
		 * a.moveToElement(element).click().build().perform();
		 * //a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		 * //from.sendKeys(Keys.ARROW_DOWN); //from.sendKeys(Keys.ENTER); //cd.close();
		 * WebElement to =cd.findElement(By.xpath("//*[@id="+"'__next'"+
		 * "]/div/main/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[3]/input"
		 * )); to.sendKeys("Mumbai"); Thread.sleep(1000); WebElement toelement
		 * =cd.findElement(By.xpath("//*[@id="+"'__next'"+
		 * "]/div/main/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/div[2]/div/div[3]/div[2]/ul[1]/li/div/div[2]"
		 * )); a.moveToElement(toelement).click().build().perform();
		 * 
		 * //toCalender cd.findElement(By.xpath(
		 * "//*[@id=\"__next\"]/div/main/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/div[4]/div/div/div/div[3]"
		 * )).click(); cd.findElement(By.xpath(
		 * "//*[@id=\"__next\"]/div/main/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/div[4]/div/div/div/div[4]/div[3]/div/div[2]/div[1]/div[3]/div[5]/div[1]"
		 * )).click();
		 */
		/*
		 * WebElement checkbox=cd.findElement(By.xpath("//*[@id="+"'__next'"+
		 * "]/div/main/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/div[5]/div/div[1]/div/div/div/div[1]/input"
		 * )); a.moveToElement(checkbox).perform();
		 * System.out.println(checkbox.isSelected()); checkbox.click();//popup to login
		 * is displayed System.out.println(checkbox.isSelected());
		 */
		//search
		/*
		 * cd.findElement(By.xpath("//*[@id="+"'__next'"+
		 * "]/div/main/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/div[7]/button")).
		 * click(); Thread.sleep(3000); cd.findElement(By.xpath("//*[@id="+"'__next'"+
		 * "]/div/main/div[3]/div/div[2]/div[3]/div[1]/div[2]/div[2]/button")).click();
		 * 
		 * Thread.sleep(3000); WebElement selBtn = cd.findElement(By.xpath(
		 * "/html/body/div[5]/div/div/div[2]/div/div[3]/div/button"));
		 * Thread.sleep(3000); selBtn.click(); Thread.sleep(3000); selBtn.click();
		 * WebDriverWait wait = new WebDriverWait(cd, Duration.ofSeconds(10));
		 */
		
		// Wait until the Review Itinerary page heading is visible
		//WebElement reviewHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(
		//    By.xpath("//h2[contains(text(), 'Review your itinerary')]")
		//));
		/*
		WebElement body = cd.findElement(By.tagName("body"));
		int centerX = body.getSize().getWidth() / 2;
		int centerY = body.getSize().getHeight() / 2;
		a.moveToElement(body, centerX, centerY).click().build().perform();
		
		
		 * String pageUrl = cd.getCurrentUrl();
		 * if(pageUrl.contains("https://www.cleartrip.com/flights/itinerary/")) {
		 * WebElement secureBtn =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//div[3]/div/label/div/div/input")));
		 * a.scrollToElement(secureBtn).click().build().perform(); Wait<WebDriver>
		 * fluWait = new
		 * FluentWait<WebDriver>(cd).withTimeout(Duration.ofSeconds(10)).pollingEvery(
		 * Duration.ofSeconds(2))
		 * .withMessage("Test Wait").ignoring(NoSuchElementException.class);
		 * fluWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "input[@type='radio']")));
		 * a.scrollToElement(secureBtn).click().build().perform(); }
		 */
		//cd.switchTo().parentFrame();
		
		/*
		 * WebElement we = cd.findElement(By.className("market_turnover"));
		 * a.moveToElement(we).perform(); List<WebElement> rows =
		 * cd.findElements(By.xpath(
		 * "//*[@id='midBody']/div[3]/div/div/div[2]/div/div[2]/table/tbody/tr")); int
		 * rSize = rows.size(); List<WebElement> columns = cd.findElements(By.xpath(
		 * "//*[@id='midBody']/div[3]/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td"));
		 * int cSize = columns.size(); for(int i=1;i<=rSize;i++) { for(int
		 * j=1;j<=cSize;j++) { System.out.print(cd.findElement(By.xpath(
		 * "//*[@id='midBody']/div[3]/div/div/div[2]/div/div[2]/table/tbody/tr["+i+
		 * "]/td["+j+"]")).getText()+" "); } System.out.println(); }
		 */
		
		/*
		 * WebElement frame = cd.findElement(By.id("iframeResult"));
		 * cd.switchTo().frame(frame);
		 * cd.findElement(By.xpath("/html/body/button")).click();
		 * cd.switchTo().alert().sendKeys("Vasu"); cd.switchTo().alert().accept();
		 * //cd.switchTo().alert().dismiss(); JavascriptExecutor jsExe
		 * =(JavascriptExecutor) cd; String script =
		 * "return document.getElementById('demo').innerHTML"; String title =
		 * (String)jsExe.executeScript(script); System.out.println(title);
		 * 
		 * Date date = new Date(); String currentDate = date.toString().replace(" ",
		 * "_").replace(":", "_"); File sshot =
		 * ((TakesScreenshot)cd).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(sshot, new File(".//ScreenShot//"+ currentDate+".png"));
		 */
	}

}
