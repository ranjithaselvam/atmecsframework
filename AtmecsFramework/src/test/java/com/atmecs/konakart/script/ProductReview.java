package com.atmecs.konakart.script;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.konakart.base.Base;
import com.atmecs.konakart.config.Constants;
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


public class ProductReview extends Base {
	 Base base=new Base();
		//@BeforeClass
		//public void launchBrowser() throws Exception ,IOException{
			//base.getBrowser();
			//base.getUrl();
		//}

		@Test(priority=1)
		public void contentCorrectness() throws Exception 
		{
			base.getUrl();
        base.clickOnWebElement(driver, Utility.propertyRead(Constants.home_page_loc_file, "loc_picture"));
        base.clickOnWebElement(driver, Utility.propertyRead(Constants.review_page_loc_file, "loc_description"));
        Base.getText(driver, Utility.propertyRead(Constants.review_page_loc_file, "loc_destext"));
        base.clickOnWebElement(driver, Utility.propertyRead(Constants.review_page_loc_file, "loc_specification"));
        Base.getText(driver, Utility.propertyRead(Constants.review_page_loc_file, "loc_spetext"));
        base.clickOnWebElement(driver, Utility.propertyRead(Constants.review_page_loc_file, "loc_customerreview"));
        Base.getText(driver, Utility.propertyRead(Constants.review_page_loc_file, "loc_custext"));
       }

		
		
		  @DataProvider 
		  public Object[][] sortReview() throws Exception
		  {
			  Object[][]data = Utility.getExcel(Constants.customerReviewData_file, "Sheet1"); 
		  return data; 
		  }
		  
		  @Test(dataProvider="sortReview",priority=2) public void
		  customerReview(String categories,String review) throws Exception 
		  {
			 
		  base.clickOnWebElement(driver, Utility.propertyRead(Constants.home_page_loc_file, "loc_picture"));
		  Utility.logInfo("image clicked");
		  base.clickOnWebElement(driver, Utility.propertyRead(Constants.review_page_loc_file, "loc_customerreview"));
		  base.inputValuesToTheWebelement(driver,Utility.propertyRead(Constants.review_page_loc_file, "loc_sort"),categories);
		  Base.getText(driver, Utility.propertyRead(Constants.review_page_loc_file,"loc_review"));
		  base.scrollToBottomOfThePage(driver);
		  
		  }
		   
		


		@AfterClass
		public void closeBrwser() throws Exception {
			base.driverClose(driver);

		}

	}

	
	
	


