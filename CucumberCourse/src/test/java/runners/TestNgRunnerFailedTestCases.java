package runners;

//import org.testng.annotations.DataProvider;

//ESTE RUNNER EJECUTA NUEVAMENTE LOS SCENARIOS QUE FALLARON SI QUEDARON REGRISTRADOS EN EL TXT
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "@target/failed_scenarios.txt", //the package where feature files are
		glue = "stepDefinitions",// the package where steps definitions are
		monochrome = true,
		plugin = {"html:target/cucumber.html"}
		)

//rerun: manda una lista de los escenarios fallidos a un archivo para localizarlos mas facil

public class TestNgRunnerFailedTestCases extends AbstractTestNGCucumberTests{
	
	//this is to run the scenarios parallely
	/*
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	 */
	
}
