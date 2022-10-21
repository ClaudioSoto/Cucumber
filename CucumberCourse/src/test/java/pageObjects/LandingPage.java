package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	//CLASE Y OBJETO QUE INICIALIZA VARIABLES Y METODOS QUE PERTENECEN A LA PANTALLA DE LANDINGPAGE
	
	public WebDriver driver;
	public By search = By.xpath("//input[@type='search']");
	public By tomatoProduct = By.xpath("//h4[contains(text(),'Tomato - 1 Kg')]");
	public By CarrotProduct = By.xpath("//h4[contains(text(),'Carrot - 1 Kg')]");
	public By searchProductName = By.xpath("//h4[@class='product-name']");
	public By failedSearchMessage = By.xpath("//h2[contains(text(),'Sorry, no products matched your search!')]");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String verifyLandingPageTittle() {
		return driver.getTitle();
	}
	
	public void searchItem(String pattern) {
		driver.findElement(search).sendKeys(pattern);
	}
	
	public boolean getProductVisibility(String productName) {
		String searchProduct = driver.findElement(searchProductName).getText();
		if(searchProduct.contains(productName)) {
			return true;
		}
		return false;
	}
	
	public boolean getFailedSearchErrorVisibility() {
		return driver.findElement(failedSearchMessage).isDisplayed();
	}
	

}
