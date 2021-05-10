package com.amazon.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class amazonPO {
	
	WebElement ele;
	
	
	
	public String search_results(WebDriver driver,String text) throws InterruptedException
	{
		ele=driver.findElement(By.id("twotabsearchtextbox"));
		ele.sendKeys(text);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);
		WebElement co = driver.findElement(By.xpath("(//span[@class='a-price']/span)[1]"));
		Thread.sleep(2000);
		String cost=co.getText();
		System.out.println(cost);
		return cost;
		
	}
	
	public void validateaddToCart_price(WebDriver driver,int opt,String price) throws InterruptedException
	{
		//List <WebElement> res=driver.findElements(By.xpath("//div[@class='a-section a-spacing-none']/span/a"));
		//for(WebElement a:res)
			//System.out.println(a.getText());
		//res.get(opt).click();
		driver.findElement(By.xpath("(//a[@class='a-link-normal a-text-normal'])[1]")).click();
		Thread.sleep(2000);
		String cost =driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]")).getText();
		System.out.println(cost);
		Assert.assertEquals(cost, price);
		Thread.sleep(2000);
		
		
	}
	
	public void validateCheckout_price(WebDriver driver,String price) throws InterruptedException
	{
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(2000);
		List <WebElement> costn=driver.findElements(By.xpath("//span[@class='a-color-price hlb-price a-inline-block a-text-bold']"));
		for(WebElement c:costn)
		{
			//Assert.assertEquals(c.getText(), price);
			System.out.println(c.getText());
			
		}
		
		driver.findElement(By.xpath("(//a[contains(text(),'Proceed to checkout')])[1]")).click();
		Thread.sleep(2000);
	}
	
}