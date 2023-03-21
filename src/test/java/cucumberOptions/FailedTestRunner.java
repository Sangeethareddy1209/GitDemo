package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failed_scenarios.txt",glue="stepDefinitions",
     plugin= {"html:target/cucumber.html","json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
    		 ,monochrome=true)
public class FailedTestRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();//super means we are asking to execute the method present in the parent class(AbstractTestNGCucumberTests)
	    // in that class there is a method called scenarios which helps to run all scenarios parallelly
		//super keyword helps to call methods from parent class
		//since we are using same method name as in parent class we use override annotation
	}
	
 
}
