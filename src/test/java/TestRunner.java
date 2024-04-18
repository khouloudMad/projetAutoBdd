
//definir les parametres d execution

import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
 
@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/spec/features" }, plugin = { "pretty", "html:target/cucumber-report.html",
		"json:target/cucumber-reports.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, tags = ("@searchUserByRole"),
		// camelcase avoir les méthodes sans espace rattaché avec maj
		snippets = SnippetType.CAMELCASE,
		// apres chaque execution j aurai le necessaire au niveau log
		monochrome = true)
public class TestRunner {

}
