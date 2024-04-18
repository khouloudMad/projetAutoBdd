package search_user_role;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchUserRolePageObject {
	// identification des sélécteurs

	public final static String ADMIN_BTN_XPATH = "//*[text() = 'Admin']";
	public final static String UserRole_XPATH = "/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]";
	public final static String UserRole_AdminXPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/span";
	public final static String UserRole_ESSXPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[3]/span";
	public final static String SEARCH_BTN_XPATH = "//button[@type=\"submit\"]";
	public final static String ROW_TABLE_CLASSNAME = "oxd-table-card";
	public final static String RESULT_TABLE_XPATH =  "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div";
	                                                 
	public final static String FIRST_PART_ROLEXPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[";
	public final static String SECOND_PART_ROLEXPATH = "]/span";

	// WebElement FindBY
	@FindBy(how = How.XPATH, using = ADMIN_BTN_XPATH)
	public static WebElement adminBtn;
	@FindBy(how = How.XPATH, using = UserRole_XPATH)
	public static WebElement userRole;
	@FindBy(how = How.XPATH, using = UserRole_AdminXPATH)
	public static WebElement userRoleAdmin;
	@FindBy(how = How.XPATH, using = UserRole_ESSXPATH)
	public static WebElement userRoleEss;
	@FindBy(how = How.XPATH, using = SEARCH_BTN_XPATH)
	public static WebElement searchBtn;
	@FindBy(how = How.CLASS_NAME ,using = ROW_TABLE_CLASSNAME)
	public static List<WebElement> tableResult;

	// methods
	public void clickAdminBtn() {
		adminBtn.click();
	}

	public void selectUserRole() {

		userRole.click();

	;
	}
	public void adminSelect()
	{
		userRoleAdmin.click();
	}
	public void essSelect()
	{
		userRoleEss.click();
	}

	public void clickbtnSearch() {
		searchBtn.click();
		// System.out.println("appuie bouton search OK");
	}



	public WebElement getElement(int i, WebDriver driver) {
		String FIRST_PART_XPATH = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[";
		String SECOND_PART_XPATH = "]/div";
		WebElement element = driver.findElement(By.xpath(FIRST_PART_XPATH + i + SECOND_PART_XPATH));
		//System.out.println("element: " + element);
		return element;
	}

	public WebElement getRoleXpath(int indice, WebDriver driver) {
		
		WebElement element = driver.findElement(By.xpath(FIRST_PART_ROLEXPATH + indice + SECOND_PART_ROLEXPATH));
		return element;
	}


}
