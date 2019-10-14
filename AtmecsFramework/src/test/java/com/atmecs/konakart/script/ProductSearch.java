package com.atmecs.konakart.script;


import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.konakart.base.Base;
import com.atmecs.konakart.constants.Constants;
import com.atmecs.konakart.utility.Utility;

public class ProductSearch {
	/**
	 * In the search list box select any of the value from the drop down and perform
	 * searches.(positive and negative test)
	 * 
	 * @author ranjitha.selvam
	 * @throws Exception 
	 *
	 */

	
	@BeforeClass
	public void launchBrowser() throws Exception
	{
		Base.getBrowser();
		Base.getUrl();
	}
	
	 @DataProvider
	  public Object[][] positiveSearch() throws Exception 
     { 
		  Object data[][] = Utility.getExcel(Constants.positiveSearchData_file, "Sheet1");
	 
	  
	 return data;
	 }
	 @Test(dataProvider="positiveSearch")
	  
	  //positive searches
	  public void positiveSearches(String categories,String selectitem,String product) throws IOException, Exception  {
	
		
		Base.inputValuesToTheWebelement(Utility.propertyRead(Constants.productLoc_file, "all"),categories );
		Base.inputValuesToTheWebelement(Utility.propertyRead(Constants.productLoc_file,"searchText" ),selectitem);
	    Base.clickOnWebElement(Utility.propertyRead(Constants.productLoc_file, "searchButton"));
	   
		}
	 @DataProvider
	  public Object[][] negativetiveSearch() throws Exception 
    { 
		  Object data[][] = Utility.getExcel(Constants.negativeSearch_file, "Sheet1");
	 
	  
	 return data;
	 }
	 @Test(dataProvider="negativeSearch")
	  
	  //negative searches
	  public void negativeSearches(String categories,String select,String product) throws IOException, Exception  {
		    Base.inputValuesToTheWebelement(Utility.propertyRead(Constants.productLoc_file, "all"),categories );
			Base.inputValuesToTheWebelement(Utility.propertyRead(Constants.productLoc_file,"searchText" ),select);
		    Base.clickOnWebElement(Utility.propertyRead(Constants.productLoc_file, "searchButton"));
		 
	 }
	
	
	@AfterClass
	public void closeBrwser() throws Exception
	{
	Base.driverClose();
		
	}

}
