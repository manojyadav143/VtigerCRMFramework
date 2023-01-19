package genericlibraries;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




/**
 * This class contains all reusable methods of wedDriver
 * @author manoj
 *
 */
public class webDiverutility 
{
	public WebDriver driver;
	/**
	 * This method is used to launch browser
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser)
	{
		switch(browser)
		{
		
		case "chrome":
			driver= new ChromeDriver();break;
		case "firefox":
			driver=new FirefoxDriver();break;
		case "edge":
			driver=new EdgeDriver(); break;
		default:
			System.out.println("invalid browser");
			break;
		}
		return driver;
		
		}
	/**
	 * This method is used to maximize browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to navigate to application
	 * @param url
	 */
	
	 public void navigateToApplication(String url)
	 {
		 driver.get(url);
	}
	/**
	 * This method is used to wait till web page is loaded
	 * @patam time
	 */
	 public void waitTillPageLoad(long time)
	 {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		 
	 }
	 public void explicitwait( long time,WebElement element) {
	
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(time));
	 wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 /**
	  * This method is used to mouse hover on an element
	  * @param element
	  */
	 public void mouseHover(WebElement element) {
		 Actions a= new Actions(driver);
		 a.moveToElement(element).perform();
	 }
	 /**
	  * This method is used to double click on an element
	  * @param element
	  */
	 public void doubleClickOnElement(WebElement element) {
		 Actions a= new Actions(driver);
		 a.doubleClick(element).perform();
	 }
	 /**
	  * This method is used to right click on an element
	  * @param element
	  */
	 public void rightClick(WebElement element)
	 {
		 Actions a= new Actions(driver);
		 a.contextClick(element).perform();
	 }
	 /**
	  * This method is used to drag and drop an element
	  * @param src
	  * @param dest
	  */
	 public void dragAnddrop(WebElement src,WebElement dest) {
		 Actions a= new Actions(driver);
		 a.dragAndDrop(src, dest).perform();
	 }
	 
	 public void dropdown(WebElement element, int index) {
		 Select s= new Select (element);
		 s.selectByIndex(index);

	 }
	 /**
	  * This method is used to select an element  from drop down based on index
	  * @param value
	  * @param element
	  */
	 public void dropdown(String value, WebElement element) {
		 Select s = new Select (element);
		 s.selectByValue(value);
     }
	 /**
	  * This method is used to select an element from drop down based on text
	  * @param element
	  * @param text
	  */
	 public void dropdown(WebElement element, String text) {
	 
		 Select s= new Select(element);
		 s.selectByVisibleText(text);
	 }
	 public String getParentWindowId() {
		 return driver.getWindowHandle();
	 }
	 public void chidBrowserPopp()
	 {
		 Set<String> set = driver.getWindowHandles();
		 for(String window : set) {
			 driver.switchTo().window(window);
		 }
	 }
	 public void switchToFrame(String index) {
		 driver.switchTo().frame(index);
	 }
	 /**
	  * This method is used to switch to frame based on element
	  * @param element
	  */
	 public void switchToframe(WebElement element) {
		 driver.switchTo().frame(element);
	 }
	 /**
	  * This method is used to handle alert pop up by clicking 'ok'
	  */
	 public void alertok() {
		 driver.switchTo().alert().accept();
	 }
	 /**
	  * This method is used to handle alert by clicking 'cancel'
	  */
	 public void alertcancel()
	 {
		 driver.switchTo().alert().dismiss();
	 }
	 /**
	  * This method is used to disable browser notifications
	  */
	 
	 public ChromeOptions disableNotification() {
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 return options;
	 }
	 /**
	  * This method is used to fetch the screenshot of the web page
	  * @param classname
	  * @param javaUtil
	  * @return
	  */
	
	 public String getScreenshot(String classname, JavaUtility javaUtil)
	 {
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 String currentTime = javaUtil.getCurrentTime();
		 File src= ts.getScreenshotAs(OutputType.FILE);
		 File dest= new File ("./Screenshot/"+classname+"_"+currentTime+".png");
		 try {
			 FileUtils.copyFile(src, dest);
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
		 return dest.getAbsolutePath();
	 }
	 /**
	  * This method is used to fetch the screenshot based on Base64 format
	  * @return
	  */
	 public String getScreenshot() {
		 TakesScreenshot ts= (TakesScreenshot)driver;
		 return ts.getScreenshotAs(OutputType.BASE64);
	 }
	 public void scrolTillElement(WebElement element) {
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 
		js.executeScript("argument[0].scrollIntoview(true)", element);
	 }
	 /**
	  * This method is used to close current window
	  */
	 public void closeCurrenwindow() {
		 driver.close();
	 }
	 /**
	  * This method is used to close all the windows and exit browser
	  */
	 public void closewindow()
	 {
		 driver.quit();
	 }
	 
}
		 
		 
	 

