package search;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import authentification.AuthentifcationPageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.Setup;
import utils.WaitMethods;

public class SearchStepDefinition {

	private WebDriver driver;
	private SearchPageObject searchPageObject = new SearchPageObject();
	private WaitMethods wait = new WaitMethods();
	private CommonMethods communMethods = new CommonMethods();

	public SearchStepDefinition() {
		driver = Setup.driver;
		PageFactory.initElements(driver, SearchPageObject.class);
	}

	@Given("je me connecte sur l'application")
	public void je_me_connecte_sur_l_application() throws IOException {

		communMethods.openURLWithConfigFile("url");
	}

	@When("je clique sur le bouton Admin")
	public void je_clique_sur_le_bouton_admin() {
		wait.explicitWaitUntilButtonIsClickableXpath(driver, SearchPageObject.ADMIN_BTN_XPATH, 20);
		searchPageObject.clickAdminBtn();
		System.out.println("bouton admin ok");
	}

	@When("je saisie le username {string}")
	public void je_saisie_le_username(String username) {

		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, SearchPageObject.USERNAME_XPATH, 20);
		searchPageObject.saisirUsername(username);
	}

	@When("je clique sur le bouton search")
	public void je_clique_sur_le_bouton_search() {
		wait.explicitWaitUntilButtonIsClickableXpath(driver, SearchPageObject.SEARCH_BTN_XPATH, 10);
		searchPageObject.clickbtnSearch();

	}

	@Then("je vérifie que {string} existe dans le tableau")
	public void je_vérifie_que_existe_dans_le_tableau(String resultatAttendu) {
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, SearchPageObject.MSG_OBTENU_XPATH, 10);
	System.out.println(SearchPageObject.tableRslt.size());
		for (int i=1; i<SearchPageObject.tableRslt.size();i++)
		{ 
			
		    
			String resultatObtenu=searchPageObject.getElement(i, driver) .getText() ;	
			Assert.assertTrue(resultatObtenu.contains(resultatAttendu));
			System.out.println("Test tableau OK");
		//String resultatObtenu = searchPageObject.verf();
		//Assert.assertTrue(resultatObtenu.contains(resultatAttendu));
		}
	}

}
