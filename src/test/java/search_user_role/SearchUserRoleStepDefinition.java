package search_user_role;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import search.SearchPageObject;
import utils.CommonMethods;
import utils.Setup;
import utils.WaitMethods;

public class SearchUserRoleStepDefinition {
	private WebDriver driver;
	private SearchUserRolePageObject searchUserRolePageObject = new SearchUserRolePageObject();
	private WaitMethods wait = new WaitMethods();
	private CommonMethods communMethods = new CommonMethods();

	public SearchUserRoleStepDefinition() {
		driver = Setup.driver;
		PageFactory.initElements(driver, SearchUserRolePageObject.class);
	}

	@When("je choisis le role {string}")
	public void je_choisis_le_role(String role) {
		wait.explicitWaitUntilButtonIsClickableXpath(driver, SearchUserRolePageObject.UserRole_XPATH, 10);
		searchUserRolePageObject.selectUserRole();
		if (role.contentEquals("Admin")) {
			wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, SearchUserRolePageObject.UserRole_AdminXPATH,
					10);
			searchUserRolePageObject.adminSelect();
		}
		if (role.equals("ESS")) {
			wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, SearchUserRolePageObject.UserRole_ESSXPATH,
					10);
			searchUserRolePageObject.essSelect();

		}

	}

	@Then("je vérifie que seulement {string} existe  dans le tableau")
	public void je_vérifie_que_seulement_existe_dans_le_tableau(String resultatAttendu) {
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, SearchUserRolePageObject.RESULT_TABLE_XPATH, 10);
		System.out.println("la taille du tab est "+SearchUserRolePageObject.tableResult.size());

		for (int i = 1; i <= SearchUserRolePageObject.tableResult.size(); i++) {

			String resultatObtenu = searchUserRolePageObject.getElement(i, driver).getText();
			String [] ligne= resultatObtenu.split("\n");
	
		Assert.assertTrue(ligne[1].contains(resultatAttendu));
			System.out.println("vérificatin role avec " + i + "OK");
			System.out.println("attendu:=" + resultatAttendu);
			System.out.println(ligne[1]);
			System.out.println("attendu ======= obtenu");
			

			
		}

	}
}
