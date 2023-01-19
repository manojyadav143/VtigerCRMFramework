package propertiesfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginScriptforactitime 
{
public static void main(String[] args) throws InterruptedException, IOException 
{
//step 1: convert physical file into java readable object
	FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
	//step 2: Create an instance for Properties class
	//Properties class is available in java.util.package
	Properties p=new Properties();
	//step 3:Load all the key value pairs to property object 
	p.load(fis);//IOException
	//java concept involved is map interface-HashTable
	//step 4:Read data
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(p.getProperty("url1"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(p.getProperty("timeouts"))));
	driver.findElement(By.id("username")).sendKeys(p.getProperty("user"));
	driver.findElement(By.name("password")).sendKeys(p.getProperty("password"));
	driver.findElement(By.id("loginButton")).click();
	Thread.sleep(3000);
	if(driver.getTitle().contains("Enter"))
		System.out.println("pass");
	else
		System.out.println("fail");
	driver.quit();
	
	
			
}
}
