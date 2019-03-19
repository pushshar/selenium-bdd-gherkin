package com.capgemini.redbus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RedBusSteps {
	
	
		WebDriver driver = new ChromeDriver();
	
	
	@Given("^that the user want to travel \"([^\"]*)\" to \"([^\"]*)\"$")
	public void that_the_user_want_to_travel_to(String arg1, String arg2) throws Throwable {
	    
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");
		Thread.sleep(1000);

		WebElement source=driver.findElement(By.id("src"));
		source.click();
		source.sendKeys(arg1);
		Thread.sleep(1000);
	
		WebElement destination=driver.findElement(By.id("dest"));
		destination.click();
		destination.sendKeys(arg2);
		Thread.sleep(1000);
	}

	@When("^it is the day of \"([^\"]*)\"$")
	public void it_is_the_day_of(String arg1) throws Throwable {
		driver.findElement(By.xpath("//*[@class='fl search-box date-box gtm-onwardCalendar']")).click();       
	    String month=arg1.substring(3);        
	    String date=arg1.substring(0, 2);       
	    String getMonth=driver.findElement(By.xpath("//div[@class='rb-calendar']//td[@class='monthTitle']")).getText();         
	    
	         
	      while(true)   
	      {             
	      if(!(getMonth.equalsIgnoreCase(month))) 
	            {
	                driver.findElement(By.xpath("//div[@class='rb-calendar']/*//td[@class='next']")).click();
	                break;      
	            }       
	      }         
	      driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody//td[text()='"+month+"']/../..//td[text()='"+date+"']")).click();   
	}

	@Then("^user is given with list of buses available$")
	public void user_is_given_with_list_of_buses_available() throws Throwable {

		driver.findElement(By.id("search_btn")).click();
	}



}
