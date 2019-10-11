package com.atmecs.framework.objectRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class RepositoryParser {

      public static WebDriver driver;

		private FileInputStream stream;
		private String RepositoryFile;
		private static Properties propertyFile = new Properties();

		public RepositoryParser(String fileName) throws IOException
		{
			this.RepositoryFile = fileName;
			stream = new FileInputStream(RepositoryFile);
			propertyFile.load(stream);
		}

		public static String getbjectLocator(String locatorName)
		{
			String locatorProperty = propertyFile.getProperty(locatorName);
			System.out.println(locatorProperty.toString());
			String locatorType = locatorProperty.split(":")[0];
			String locatorValue = locatorProperty.split(":")[1];

			WebElement locator;
			switch(locatorType)
			{
			case "Id":
				locator =  driver.findElement(By.id(locatorValue));
				break;
			case "Name":
				locator = driver.findElement(By.name(locatorValue));
				break;
			case "CssSelector":
				locator = driver.findElement(By.cssSelector(locatorValue));
				break;
			case "LinkText":
				locator = driver.findElement(By.linkText(locatorValue));
				break;
			case "PartialLinkText":
				locator = driver.findElement(By.partialLinkText(locatorValue));
				break;
			case "TagName":
				locator = driver.findElement(By.tagName(locatorValue));
				break;
			case "Xpath":
				locator = driver.findElement(By.xpath(locatorValue));
				break;
			}
			return locatorType;
		}
	}