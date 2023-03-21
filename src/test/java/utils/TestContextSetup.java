package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;//this is the main driver where everyone gets life
	public String homePageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	public TestContextSetup() throws IOException//constructor
	{
		testBase=new TestBase();//we are creating object for testBase class which contains the actual driver
		pageObjectManager=new PageObjectManager(testBase.WebDriverManager());//we are sending the driver to pageobjectManager class
		genericUtils=new GenericUtils(testBase.WebDriverManager());//and also genericUtils class
		
	}
}
