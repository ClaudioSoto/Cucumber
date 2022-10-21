package pageObjects;

import org.openqa.selenium.WebDriver;

//This class is to implement the factory design pattern
public class PageObjectManager {

	//ESTA CLASE MANEJA LOS OBJETOS INSTANCIADOS DE LAS CLASES DE CADA PAGINA, EL OBJETO DE ESTA CLASE SE INICIALIZA EN TESTCONTEXT
	
	//page objects
	public LandingPage landingPage;
	public PlaceOrderPage placeOrderPage;
	
	//web driver object
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	public PlaceOrderPage getPlaceOrderObject() {
		placeOrderPage = new PlaceOrderPage(driver);
		return placeOrderPage;
	}
}
