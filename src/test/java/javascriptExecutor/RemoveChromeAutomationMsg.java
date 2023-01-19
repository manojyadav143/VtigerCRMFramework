package javascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;

public class RemoveChromeAutomationMsg 
{
public static void main(String[] args) {
	
	ChromeOptions option=new ChromeOptions();
	
	//	option.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
	 
	WebDriver driver= new ChromeDriver(option);	
}
}
