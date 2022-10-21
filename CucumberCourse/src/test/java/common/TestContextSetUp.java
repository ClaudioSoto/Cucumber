package common;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetUp {

	//EN ESTA CLASE SE CONTROLA EL CONTEXTO DE LA EJECUCION Y OBJECTOS, TODOS LOS OBJECTOS DE APOYO SE VAN A INICIALIZAR AQUI
	
	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	
	public TestContextSetUp() throws IOException {
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		genericUtils = new GenericUtils(testBase.WebDriverManager());
	}
}
