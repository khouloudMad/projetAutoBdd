package authentification;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.Setup;
import utils.WaitMethods;

public class AuthentifcationStepDefinition {

	// on doit créer un constructeur pour définir les webdriver ..
	//1.on déclare un objet de type webdriver (les instances)
	private WebDriver driver;
	private WaitMethods wait = new WaitMethods();;
	
	//instanciation de pageObject
	private AuthentifcationPageObject auth_Page_Object = new AuthentifcationPageObject();
	private CommonMethods communMethods= new CommonMethods();
	
	//constructeur avec (en général toujours copier colller
	public AuthentifcationStepDefinition()
	// setup est la classe qui fait l interfacage entre factory et test
	{  driver = Setup.driver;
	//pattern qui est déja définit en selenium 
	PageFactory.initElements(driver,AuthentifcationPageObject.class );
	}

	// importer les annotations
	//appel des methodes
	@Given("je me connecte sur l application")
	public void je_me_connecte_sur_l_application() throws IOException {
		communMethods.openURLWithConfigFile("url");
		//url du fichier 

	}

	@When("je saisie le nom {string}")
	public void je_saisie_le_nom(String userame) throws InterruptedException {
		
		WebElement userNameElement= wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, AuthentifcationPageObject.USERNAME_XPATH, 10);
		auth_Page_Object.saisirUserName(userame);
		//System.out.println("saisie username ok");

	}

	@When("je saisie le mot de passe {string}")
	public void je_saisie_le_mot_de_passe(String password) {
		WebElement userPasswordElement= wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, AuthentifcationPageObject.PASSWORD_XPATH, 10);
		auth_Page_Object.saisirpasword(password);
		//System.out.println("saisie password ok");

	}

	@When("je clique sur le bouton login")
	public void je_clique_sur_le_bouton_login() {
		WebElement btnLogin = wait.explicitWaitUntilButtonIsClickableXpath(driver, AuthentifcationPageObject.BTN_LOGIN_XPATH, 10);
		auth_Page_Object.cliqueBouton();
		//System.out.println("appuie bouton ok");
	}

	@Then("je me redirige vers la page d acceuil et {string} s affiche")
	public void je_me_redirige_vers_la_page_d_acceuil_et_s_affiche(String msgAttendu) {
		System.out.println(msgAttendu);
		WebElement resultatAttenduElement= wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, AuthentifcationPageObject.MSG_OBTENU_XPATH, 10);
		String msgObtenu=auth_Page_Object.verfierMsgObtenu();
		Assert.assertEquals(msgAttendu, msgObtenu);
		System.out.println("test OK");
	}

}
