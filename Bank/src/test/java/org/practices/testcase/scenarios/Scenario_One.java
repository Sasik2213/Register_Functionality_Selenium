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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_One {
	@Test
	public void Scenario1() throws Exception {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[@class=\"caret\"]")).click();
		List<WebElement> dropDown = driver.findElements(By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right\"]"));
//		for(WebElement x:dropDown) {
//			System.out.println(x.getText());
//		}
		WebElement selectDropdown = dropDown.stream().filter(drop->drop.findElement(By.xpath("//a[normalize-space()=\"Register\"]")).getText().equalsIgnoreCase("Register")).findFirst().orElse(null);
		selectDropdown.click();
//		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//input[@id=\"input-firstname\"]")).sendKeys("Sasi");
		driver.findElement(By.xpath("//input[@id=\"input-lastname\"]")).sendKeys("kiran");
		driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys("sasik12345@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"input-telephone\"]")).sendKeys("48195");
		driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys("Hello@123");
		driver.findElement(By.xpath("//input[@id=\"input-confirm\"]")).sendKeys("Hello@123");
		driver.findElement(By.xpath("//input[@value=\"0\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
		WebElement testSt = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));
		System.out.println(testSt.getText());
		
		String successPage = driver.getCurrentUrl();
		System.out.println(successPage);
		
		
		Assert.assertTrue("Previously Your Accouont Already Created!!Please Check...",successPage==driver.getCurrentUrl());
	}

}
