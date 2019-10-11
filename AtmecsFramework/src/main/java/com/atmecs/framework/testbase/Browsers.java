package com.atmecs.framework.testbase;



import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.atmecs.framework.constants.Constants;
import com.atmecs.framework.objectRepository.RepositoryParser;




public class Browsers {
	private RepositoryParser parser;
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		
		parser = new RepositoryParser("config.properties");
		


		switch (RepositoryParser.getbjectLocator("browserName")) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", Constants.chrome_file);
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", Constants.fireFox_file);
			driver = new FirefoxDriver();
			break;
		case "INTERNETEXPLORER":
			System.setProperty("webdriver.ie.driver", Constants.internetExplorer_file);
			driver = new InternetExplorerDriver();

			break;

		}
		driver.get(RepositoryParser.getbjectLocator("url") );
		

		driver.manage().window().maximize();
	}

@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}


