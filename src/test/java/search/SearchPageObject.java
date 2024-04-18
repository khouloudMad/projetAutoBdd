package search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPageObject {

	public final static String ADMIN_BTN_XPATH = "//*[text() = 'Admin']";
	// final static String USERNAME_XPATH =
	// "/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input";
	final static String USERNAME_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input";
	public final static String SEARCH_BTN_XPATH = "//button[@type=\"submit\"]";
	// public final static String SEARCH_BTN_className ="oxd-input
	// oxd-input--active";

	// public final static String msg_Obtenu_XPATH =
	// "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div";
	public final static String MSG_OBTENU_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div";
	// public final static String TABLERSLT_ClassName ="orangehrm-container";
	public final static String FIRST_PART_XPATH = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[";
	public final static String SECOND_PART_XPATH = "]/div/div[2]/div";
	public final static String TABLE_CLASSNAME = "oxd-table-card";

	// declaration par les element web avec l'annotation FINDBY
	// HOW: classe prédefinie "comment"
	@FindBy(how = How.XPATH, using = USERNAME_XPATH)
	public static WebElement username;
	@FindBy(how = How.XPATH, using = ADMIN_BTN_XPATH)
	public static WebElement adminBtn;
	@FindBy(how = How.XPATH, using = SEARCH_BTN_XPATH)
	public static WebElement searchBtn;

	@FindBy(how = How.CLASS_NAME, using = TABLE_CLASSNAME)
	public static List<WebElement> tableRslt;

	@FindBy(how = How.XPATH, using = MSG_OBTENU_XPATH)
	public static WebElement msgObtenu;

	// Création des méthodes (1 méthode par action)
	public void saisirUsername(String user) {
		username.sendKeys(user);
	}

	public void clickAdminBtn() {
		adminBtn.click();
	}


	public void clickbtnSearch() {
		searchBtn.click();
	}

	public String verf() {

		String resultatObtenu = msgObtenu.getText();
		return resultatObtenu;

	}


	public WebElement getElement(int i,WebDriver driver) {
		return driver.findElement(By.xpath(FIRST_PART_XPATH + i + SECOND_PART_XPATH));
	}

}
