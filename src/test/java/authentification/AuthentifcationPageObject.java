package authentification;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthentifcationPageObject {
	// Identification des selecteyrs de chaque element web utilisé dans ce cas de test
	/*
	 * il faut toujours consulter le document feature pour vérifier les étapes et
	 * extraires les web element et les actions pour chaque element
	 */
	final static String USERNAME_XPATH = "//input[@name=\"username\"]";
	final  static String PASSWORD_XPATH = "//input[@name=\"password\"]";
	final static String BTN_LOGIN_XPATH = "//button[@type=\"submit\"]";
	final static String MSG_OBTENU_XPATH = "/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6";
	
	// déclaration des éléments web par l'annotation findBy
	// HOW??
	@FindBy (how = How.XPATH, using = USERNAME_XPATH)
	public static WebElement userName;
	@FindBy (how = How.XPATH, using= PASSWORD_XPATH)
	public static WebElement passWord;
	@FindBy (how=How.XPATH, using= BTN_LOGIN_XPATH)
	public static WebElement btn_Login;
	@FindBy (how=How.XPATH, using=MSG_OBTENU_XPATH)
	public static  WebElement msgObtenu;
		
	// Création des méthodes (1 méthode par action)
	//saisir username
	public void saisirUserName(String nom)
	{
		userName.sendKeys(nom);
		
	}
	public void saisirpasword(String password)
	{
	  passWord.sendKeys(password);
		
	}
	public void cliqueBouton()
	{
		btn_Login.click();
	}
	public String verfierMsgObtenu()
	{
		String msg;
		//System.out.println(MSG_OBTENU_XPATH);
		msg=msgObtenu.getText();
		return msg;
				
	}
	
	
	
	
}
