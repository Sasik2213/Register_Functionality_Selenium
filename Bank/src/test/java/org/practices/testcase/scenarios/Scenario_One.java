package org.practices.testcase.scenarios;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testcases.scenarios.mainFiles.Login;
//import org.testcases.scenarios.mainFiles.Home;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_One {
	@Test
	public void Scenario1() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Login login = new Login(driver);
		driver.get("http://tutorialsninja.com/demo");
		login.performDropDown();
		List<WebElement> dropDown = driver.findElements(By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right\"]"));

		WebElement selectDropdown = dropDown.stream().filter(drop -> drop
				.findElement(By.xpath("//a[normalize-space()=\"Register\"]")).getText().equalsIgnoreCase("Register"))
				.findFirst().orElse(null);
		selectDropdown.click();
		login.Your_Personal_Details("Sasi", "test", "test111.sasi@gmail.com", "254912");
		login.Your_Password("Sasik@123", "Sasik@123");
		driver.findElement(By.xpath("//input[@value=\"0\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		driver.findElement(By.linkText("Edit your account information")).click();
		

	}
	
	@Test
	public void Scenario2() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://tutorialsninja.com/demo");
		Login login = new Login(driver);
		login.performDropDown();
		login.performRegisterOperation();
		login.PerformSubmit();
	}
	@Test
	public void Scenario3() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://tutorialsninja.com/demo");
		Login login = new Login(driver);
		login.performDropDown();
		login.performRegisterOperation();
		login.Your_Personal_Details("test","ing", "test568@gmail.com", "787986");
		login.Your_Password("Sasik@#", "");
		login.AgreeRacha();
		login.PerformSubmit();
		
		
	}

}
