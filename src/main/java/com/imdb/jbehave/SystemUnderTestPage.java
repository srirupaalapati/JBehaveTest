package com.imdb.jbehave;


import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SystemUnderTestPage {
	
	WebDriver driver;
	

	   public void start() throws Exception {
		   driver =  new ChromeDriver();
			driver.manage().window().maximize();
			//Loading URL
		 	
	   }

	   public void stop() {
	      driver.quit();
	   }

	   public void open() {
		   driver.get("http://www.imdb.com/");
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     
	   }
   
	   public void search(String param) {
		   
		   WebElement searchTxt=driver.findElement(By.id("navbar-query"));
			
			searchTxt.sendKeys(param);
			WebElement searchBtn=driver.findElement(By.id("navbar-submit-button"));
			searchBtn.click();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//WebElement title=driver.findElement(By.partialLinkText("Star Wars: Episode I - The Phantom Menace"));
			WebElement title=driver.findElement(By.partialLinkText(param));
			title.click();
	     
	   }
   
 public void listCrew() {
		   
	 WebElement castEle;
		
		try{
			castEle = driver.findElement(By.linkText("FULL CAST AND CREW"));
			
		}
		
		catch(NoSuchElementException e){
			
			castEle = driver.findElement(By.linkText("See full cast and crew"));
			
		}
		castEle.click();
				
	     
	   }
   
 public void assertFinalMsg(String name, String msg) {
	   
	 WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement jimName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(name)));
		Assert.assertEquals(name, jimName.getText());
		
		WebElement thanksMsg = jimName.findElement(By.xpath("../../td[3]"));
		Assert.assertEquals(msg, thanksMsg.getText());
   
 }


}
