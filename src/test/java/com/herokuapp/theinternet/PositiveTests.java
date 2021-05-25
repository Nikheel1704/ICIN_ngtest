package com.herokuapp.theinternet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {
	
	@Test
	public void loginTest() throws InterruptedException {
		
		System.out.println("start login test");
//		create driver
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8086/ICIN-BANK/");
	//	sleep for 3 seconds
		Thread.sleep(3000);
		
		/*
		 * driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
		 * driver.findElement(By.xpath(
		 * "/html/body/app-root/app-login/div/form/div[1]/input")).sendKeys("ankesh123")
		 * ; driver.findElement(By.xpath(
		 * "/html/body/app-root/app-login/div/form/div[2]/input")).sendKeys("ankesh");
		 * driver.findElement(By.xpath(
		 * "/html/body/app-root/app-login/div/form/div[1]/button")).click();
		 * 
		 * try { WebDriverWait wait = new WebDriverWait(driver, 14);
		 * wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
		 * "http://localhost:8088/ICIN-BANK/"))); } catch (Exception e) {
		 * System.out.println("login succesful"); } Thread.sleep(5000); driver.quit(); }
		 */
//		maximize browser window
		
		driver.manage().window().maximize();
//		open test page
		String url = "http://localhost:8088/ICIN-BANK/";
		driver.get(url);
		System.out.println("page is opened");
		
		sleep(4000);
//		enter user name
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("nikheel");
		
		//		enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("raj");
//		click login button
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();
		
		sleep(4000);
		
//		verfications
//		new url
		String expectdUrl="http://localhost:8086/ICIN-BANK/";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,expectdUrl,"Actual page url is not same as ecpected");
//		
//		logout button is visible
		WebElement logOutButton = driver.findElement(By.xpath("//a[@class=' button secondary radius']"));
		Assert.assertTrue(logOutButton.isDisplayed(),"Log out Button is not visible");
		//		scccesful login message
		WebElement successMessage = driver.findElement(By.xpath("//div[@id='flash']"));
		String expectedMessage = "you logged into a secure area!";
		String actualMessage = successMessage.getText();
		Assert.assertTrue(actualMessage.contains(expectedMessage),"Actual message does not conatain message."
				+ "\n Actual Message : " + actualMessage +
				"\n Expected Message : " + expectedMessage);
//		close browser
		driver.quit();
		
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
