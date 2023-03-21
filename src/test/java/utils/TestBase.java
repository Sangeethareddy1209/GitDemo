package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
public class TestBase {
	public WebDriver driver;
	public WebDriver WebDriverManager() throws IOException
	{
		//converting properties file into input stream format
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("QAUrl");
		String browserProperties=prop.getProperty("browser");
		String browserMaven=System.getProperty("browser");//this will return browser value what we passed from command prompt
		//browser from command prompt cannot take priority directly so we have to write code
		
		String browser=browserMaven!=null ? browserMaven :browserProperties;
		if(driver==null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
		       System.setProperty("webdriver.chrome.driver","C://Program Files//chromedriver_win32//chromedriver.exe" );
	           //WebDriver driver=new ChromeDriver();
		       ChromeOptions options=new ChromeOptions();
		       options.addArguments("--remote-allow-origins=*");
		       options.addArguments("--disable-blink-features=AutomationControlled");
		       driver=new ChromeDriver(options);//driver gets the life here
			}
			if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"src//test//resources//geckodriver.exe");
				FirefoxOptions options=new FirefoxOptions();
			    options.addArguments("--remote-allow-origins=*");
				driver=new FirefoxDriver(options);
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   driver.get(url);
	    }
		return driver;
	}

}
