package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.BaseClass;

public class HomePage extends BaseClass {

	// WebDriver driver;

	@Test
	public void google() {
		driver.get("https://www.google.com");

		WebElement searchInput = driver.findElement(By.name("q"));
		searchInput.sendKeys("Selenium WebDriver");

		driver.navigate().to("https://www.wynisco.com/apply.html#");

		driver.findElement(By.id("First_Name")).sendKeys("test");
		System.out.println("Entered FirstName");

		driver.findElement(By.id("Last_Name")).sendKeys("test");
		System.out.println("Entered LastName");

		driver.findElement(By.id("Email")).sendKeys("test@gmail.com");
		System.out.println("Entered Email");

		driver.findElement(By.xpath("//*[@id='Mobile']")).sendKeys("7894561230");
		System.out.println("Entered Phone");

		Select ServiceRequired = new Select(driver.findElement(By.name("LEADCF9")));
		ServiceRequired.selectByValue("Group Training");
		System.out.println("Selected Group Training");

		// Select countryDropdown = new
		// Select(driver.findElement(By.className("zcwf_col_fld_slt")));

		Select countryDropdown = new Select(driver.findElement(By.xpath("(//select[@class='zcwf_col_fld_slt'])[2]")));
		countryDropdown.selectByIndex(3);
		System.out.println("Selected Country as India");
		System.out.println("Didn't click on Submit");

		// driver.switchTo().frame("_hjSafeContext_53412039");

		// WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 10
		// seconds
		// WebElement iframeElement = wait.until(
		// ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[7]//div[2]/div/section/button")));

		// driver.switchTo().defaultContent();
		// System.out.println("closed popup");

		// Close the browser
		driver.quit();
	}

}
