package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PlaceOrderPage {
	
	//CLASE Y OBJETO QUE INICIALIZA VARIABLES Y METODOS QUE PERTENECEN A LA PANTALLA DE PLACEORDERPAGE
	
	public WebDriver driver;
	public By cartImage = By.xpath("//img[@alt='Cart']");
	public By addCartButton = By.xpath("//button[contains(text(),'ADD TO CART')]");
	public By proceedCehckoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	public By CheckoutProductName = By.xpath("//p[@class='product-name']");
	public By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
	public By addIconProducts = By.xpath("//a[contains(text(),'+')]");
	public By countryDropDown = By.xpath("//select[@style='width: 200px;']");
	public By termsCheckBox = By.xpath("//input[@type='checkbox']");
	public By finishOrderButton = By.xpath("//button[contains(text(),'Proceed')]");

	public PlaceOrderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addProductCart() {
		driver.findElement(addCartButton).click();
	}
	
	public void proceedCheckout() {
		driver.findElement(cartImage).click();
		driver.findElement(proceedCehckoutButton).click();
	}
	
	public void placeTheOrder() {
		driver.findElement(placeOrderButton).click();
	}
	
	public void selectNumberOfProducts(int numberOfProducts) {
		for(int i=0; i<numberOfProducts; i++) {
			driver.findElement(addIconProducts).click();
		}
	}
	
	public Boolean verifyProductNameInCheckoutPage(String productName) {
		String checkoutPorductName = driver.findElement(CheckoutProductName).getText();
		if(checkoutPorductName.contains(productName)) {
			return true;
		}
		return false;
	}
	
	public void filltermsAndFinishOrder(String countryName) {
    	//Para seleccionar el pais
        WebElement staticDrowpdown = driver.findElement(countryDropDown);
		Select dropDown = new Select(staticDrowpdown);
		dropDown.selectByValue(countryName);
		
		//Para aceptar los terminos
		driver.findElement(termsCheckBox).click();
		
		//Para proceder
		driver.findElement(finishOrderButton).click();
	}
	
	public boolean verifyHomePageVisibility() {
		return driver.findElement(cartImage).isDisplayed();
	}

}
