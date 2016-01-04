package com.imdb.jbehave;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PureSeleniumTest {
	
WebDriver driver;
	
	@Before
	public void beforeTest(){
				 
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
		//Loading URL
	 	driver.get("http://www.imdb.com/");
	}
	
	
	@Test
	public void appTest(){
	
		
		WebElement searchTxt=driver.findElement(By.id("navbar-query"));
		
		searchTxt.sendKeys("Star Wars: Episode I");
		WebElement searchBtn=driver.findElement(By.id("navbar-submit-button"));
		searchBtn.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement title=driver.findElement(By.linkText("Star Wars: Episode I - The Phantom Menace"));
		title.click();
					
		WebElement castEle;
			
		try{
			castEle = driver.findElement(By.linkText("FULL CAST AND CREW"));
			
		}
		
		catch(NoSuchElementException e){
			
			castEle = driver.findElement(By.linkText("See full cast and crew"));
			
		}
		castEle.click();
				
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement jimName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Jim Morris")));
		Assert.assertEquals("Jim Morris", jimName.getText());
		
		WebElement thanksMsg = jimName.findElement(By.xpath("../../td[3]"));
		Assert.assertEquals("special thanks", thanksMsg.getText());
		
				
	}
	
	@After()
	public void afterClose(){
		
		driver.quit();
	}

}
