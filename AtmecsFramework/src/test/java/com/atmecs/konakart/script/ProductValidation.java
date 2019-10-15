package com.atmecs.konakart.script;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.konakart.base.Base;
import com.atmecs.konakart.constants.Constants;
import com.atmecs.konakart.utility.Utility;

/**
 * Validate the content correctness in all the tabs (Product
 * description,specifications and Customer reviews). Perform sort with all the
 * combinations available and validate the correctness based on the sort
 * performed.(In customer reviews tab).
 * 
 * @author ranjitha.selvam
 *
 */


public class ProductValidation extends Base {
	 Base base=new Base();
		@BeforeClass
		public void launchBrowser() throws Exception ,IOException{
			base.getBrowser();
			base.getUrl();
		}
		
		@DataProvider
		public Object[][] imgPath() throws Exception {
			Object[][] data = Utility.getExcel(Constants.heroImageLoc_file, "Sheet1");
			return data;
		}

		@Test(dataProvider = "imgPath")
		public void contentCorrectness(String path, String textpath) throws Exception {
        base.clickOnWebElement(driver, Utility.propertyRead(Constants.productLoc_file, "loc_picture"));
        base.clickOnWebElement(driver, Utility.propertyRead(Constants.heroImageLoc_file, path));
        Base.getText(driver, Utility.propertyRead(Constants.heroImageLoc_file, textpath));
        
        
		

		}

		



		@AfterClass
		public void closeBrwser() throws Exception {
			base.driverClose(driver);

		}

	}

	
	
	


