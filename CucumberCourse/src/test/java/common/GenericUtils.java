package common;

import org.openqa.selenium.WebDriver;

public class GenericUtils {

	//ESTA CLASE SIRVE PARA PONER TODO CODIGO QUE USE DRIVER Y QUE SEA GENERICO O DE USO COMUN
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
}
