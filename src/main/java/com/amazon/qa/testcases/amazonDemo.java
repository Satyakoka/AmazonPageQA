package com.amazon.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.qa.pages.amazonPO;
import com.amazon.qa.config.constants;

public class amazonDemo {
	

	amazonPO a = new amazonPO();
	constants c = new constants();
	WebDriver driver;
	String url =c.Url;
	String text=c.text;
	int opt=c.option;
	@BeforeTest()
	public void launch() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/Users/ksv/Downloads/chromedriver");
	
	 driver = new ChromeDriver();
	
	 driver.get(url);
	driver.manage().window().maximize();
	Thread.sleep(2000);
	}
	
	@Test
	public void testcase() throws InterruptedException
	{
	String price =a.search_results(driver, text);
	a.validateaddToCart_price(driver, opt, price);
	a.validateCheckout_price(driver, price);
	}
	
	@AfterTest
	public void close()
	{
		driver.quit();
	}

}
