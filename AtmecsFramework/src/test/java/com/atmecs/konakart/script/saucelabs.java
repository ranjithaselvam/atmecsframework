package com.atmecs.konakart.script;

import java.io.IOException;

import org.openqa.selenium.By;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.konakart.base.Base;
import com.atmecs.konakart.constants.Constants;
import com.atmecs.konakart.utility.Utility;


public class saucelabs extends Base {
	 Base base=new Base();
		@BeforeClass
		public void launchBrowser() throws Exception ,IOException{
			base.getBrowser();
			base.getUrl();
		}
		@Test
		public void validation() throws IOException, Exception
		{
			
			//base.clickOnWebElement(driver, Utility.propertyRead(Constants.productLoc_file, "loc_click"));
			//WebElement button = driver.findElement(By.xpath("//span[@class='lever']"));
			//String classes = button.getAttribute("class");
			//boolean isDisabled = classes.contains("default");
			
			String text = driver.findElement(By.xpath("(//p[@class='plan-billing'])[1]")).getText();
			System.out.println(text+  "yes, by default in annually");
			if(text.contentEquals("19/Month Billed annually"))
			{
				
			base.clickOnWebElement(driver, Utility.propertyRead(Constants.productLoc_file, "loc_click"));
			
			String annual = driver.findElement(By.xpath("(//p[@class='plan-billing'])[1]")).getText();
			System.out.println(annual+  "swith to monthly");
			
			}
			
			
			
			

			
		}
		

}
