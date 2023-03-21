package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	public WebDriver driver;
	TestContextSetup testContextSetup;
	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
//it executes after each and every scenario
	
	@After
	public void afterScenario() throws IOException
	{
		testContextSetup.testBase.WebDriverManager().quit();
	}
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException//after step executes after each and every step in a scenario
	{
		WebDriver driver=testContextSetup.testBase.WebDriverManager();//assigning driver to variable driver
		if(scenario.isFailed())
		{
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//this is file format
			byte[] fileContent=FileUtils.readFileToByteArray(file);
			//as the input to attach method is byte format we have to use apache.commons.io package fileutils so that it converts file to byte format
			scenario.attach(fileContent, "image/png", "image");//we have to attach our screenshot file to scenario so that extent reports can access it from scenario and display screenshot in reports
		}
	}
	
}
