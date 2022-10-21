package stepDefinitions;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import common.TestContextSetUp;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public TestContextSetUp testContextSetUp;
	
	public Hooks(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}
	

	@After
	public void closeBrowser() throws IOException {
		//con el objeto context set up puedo manipular el webdriver manager
		testContextSetUp.testBase.WebDriverManager().quit();
	}
	
	/*
	//se ejecuta despues de cada paso en el test case
	//saca un screenshot si falla un paso en el caso de prueba
	//es necesario apache common io dependencia de maven
	@AfterStep
	public void addScreenShot(Scenario scenario) throws IOException {
		WebDriver driver = testContextSetUp.testBase.WebDriverManager();
		if(scenario.isFailed()) {
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte [] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "img/png", "image");
		}
	}
	*/
}
