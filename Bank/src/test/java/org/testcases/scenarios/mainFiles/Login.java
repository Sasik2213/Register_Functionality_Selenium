package org.testcases.scenarios.mainFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
//	driver.findElement(By.xpath("//input[@id=\"input-firstname\"]")).sendKeys("Sasi");
//	driver.findElement(By.xpath("//input[@id=\"input-lastname\"]")).sendKeys("kiran");
//	(//a[normalize-space()='Register'])[1]
	//input[@name="agree"]
	//input[@value="Continue"]
//	btn btn-primary
	public WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/* Your_Personal_Details*/
	By firstName = By.xpath("//input[@id=\"input-firstname\"]");
	By lastName = By.xpath("//input[@id=\"input-lastname\"]");
	By email = By.xpath("//input[@id=\"input-email\"]");
	By tPhone = By.xpath("//input[@id=\"input-telephone\"]");
	
	/* Your_Password */
	
	By password = By.xpath("//input[@id=\"input-password\"]");
	By confirm_password = By.xpath("//input[@id=\"input-confirm\"]");
	
	By dropDown = By.xpath("//span[@class=\"caret\"]");
	
	@FindBy(css = "input[value=\"Continue\"]")
	WebElement KickSubmit;
	
	@FindBy(xpath = "(//a[normalize-space()='Register'])[1]")
	WebElement RegOp;
	@FindBy(name = "agree")
	WebElement Agree;
	
	@FindBy(id = "input-firstname")
	WebElement Name;
	@FindBy(id = "input-lastname")
	WebElement LName;
	@FindBy(id = "input-email")
	WebElement Email;
	@FindBy(id = "input-telephone")
	WebElement TelePhone;
	
	@FindBy(id = "input-password")
	WebElement input_Password;
	@FindBy(id = "input-confirm")
	WebElement input_confirm;
	
	@FindBy(className = "caret")
	WebElement Caret;
	
	
	public void Your_Personal_Details(String name,String lname,String email_id,String telephone) {
		Name.sendKeys(name);
		LName.sendKeys(lname);
		Email.sendKeys(email_id);
		TelePhone.sendKeys(telephone);
		
	}
	public void Your_Password(String input_password,String input_cnfrm) {
		input_Password.sendKeys(input_password);
		input_confirm.sendKeys(input_cnfrm);
	}
	public void performDropDown() {
		Caret.click();
	}
	public void performRegisterOperation() {
		RegOp.click();
	}
	public void PerformSubmit() {
		KickSubmit.click();
	}
}
