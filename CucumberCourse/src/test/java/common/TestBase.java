package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	//ESTA CLASE SIRVE PARA MANIFUPLAR LA PRIMERA CREACION DE DRIVER, ESTE DRIVER ES EL QUE SE PASARA EN TODOS LOS TESTS
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		
		//EN VEZ DE HARDCODEAR LAS PROPIEDADES, SE CREA UN OBJETROM DE PROPIEDADES QUE LLAMA LAS PROPIEDADES DEL ARCHIVO EN RESOURCES
		
		FileInputStream propFile = null;
		propFile = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(propFile);
		
		String URL = prop.getProperty("QaUrl");
		String browser_properties = prop.getProperty("browser");
		
		//ESTA LINEA SIRVE PARA QUE CUANDO SE EJECUTE EN TERMINAL LA SUITE
		//LE DE PRIORIDAD AL PARAMETRO DEL BROWSER, ES DECIR, SI EN TERMINAL
		//PASO FIREFOX, ESE ES EL QUE SE VA A EJECUTAR
		String browser_maven_terminal = System.getProperty("browser");
		
		//SE SELECCIONA EL VALOR SI EL VALOR EN MAVEN NO ES NULO
		String browser = terminalBrowserCheck(browser_maven_terminal, browser_properties);
		
		
		if(driver == null) {
			//antes
		
			/*
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\claudio.sotoayala\\Downloads\\chromedriver_new\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		*/
		
			//ahora
			if(browser.contentEquals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			
			if(browser.contentEquals("firefox")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			driver.get(URL);
		}
		return driver;
	}
	
	
	public String terminalBrowserCheck(String terminalBrowser, String propertiesBrowser) {
		return terminalBrowser != null ? terminalBrowser : propertiesBrowser;
	}

}
