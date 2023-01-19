package javascriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DiabledElementPracticeTest
{
public static void main(String[] args)
{
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("file:///C:/Users/manoj/Desktop/sri.html");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement textfield =driver.findElement(By.id("abc"));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].value=arguments[1]", textfield,"abc");
}
}
