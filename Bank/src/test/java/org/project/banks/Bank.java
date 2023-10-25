package org.project.banks;

import java.time.Duration;

import java.util.Arrays;
import java.util.List;

//import org.bank.methods.Home;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bank {

	public WebDriver driver;
	public WebDriverManager manager;

	@Test
	public void bankOperations() throws Exception {

		WebDriverManager.chromedriver().arch64().setup();
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(4000));
		driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-lg[ng-click=\"manager()\"]")).click();
		wt.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"center\"]")));
		driver.findElement(By.xpath("//button[normalize-space()=\"Add Customer\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]")).sendKeys("hi");
		driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]")).sendKeys("hello");
		driver.findElement(By.xpath("//input[@placeholder=\"Post Code\"]")).sendKeys("231234");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.switchTo().alert().accept();
		wt.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//button[normalize-space()='Open Account'])[1]")));
		driver.findElement(By.xpath("(//button[normalize-space()='Open Account'])[1]")).click();
		WebElement selectOptn = driver.findElement(By.xpath("//select[@id='userSelect']"));
		Select select = new Select(selectOptn);
		select.selectByVisibleText("Hermoine Granger");
		WebElement moneySelect = driver.findElement(By.xpath("//select[@id='currency']"));
		Select moneySelection = new Select(moneySelect);
		moneySelection.selectByVisibleText("Rupee");
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		driver.switchTo().alert().accept();
		wt.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-lg tab btn-primary']")));
		driver.findElement(By.xpath("(//button[normalize-space()='Customers'])[1]")).click();

	}

}
