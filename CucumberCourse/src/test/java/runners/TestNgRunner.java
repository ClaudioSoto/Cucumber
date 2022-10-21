package runners;

//import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features", //the package where feature files are
		glue = "stepDefinitions",// the package where steps definitions are
		monochrome = true,
		//tags = "@order",
		//tags = "@search",
		plugin = {"html:target/cucumber.html","rerun:target/failed_scenarios.txt"}
		)

//rerun: manda una lista de los escenarios fallidos a un archivo para localizarlos mas facil

public class TestNgRunner extends AbstractTestNGCucumberTests{
	
	//this is to run the scenarios parallely
	/*
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	 */
	
}
