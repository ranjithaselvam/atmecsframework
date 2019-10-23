package com.atmecs.konakart.script;


import java.io.IOException;


import org.testng.annotations.AfterClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.konakart.base.Base;
import com.atmecs.konakart.config.Constants;
import com.atmecs.konakart.utility.Utility;


public class ProductSearch extends Base {
	/**
	 * In the search list box select any of the value from the drop down and perform
	 * searches.(positive and negative test)
	 * 
	 * @author ranjitha.selvam
	 * @throws Exception
	 *
	 */
    Base base=new Base();
   

	//@BeforeClass
	//public void launchBrowser() throws Exception ,IOException{
		//base.getBrowser();
		//base.getUrl();
	//}
	
	 @DataProvider
	 public Object[][] positiveSearch() throws Exception,IOException
	 {
	 Object data[][] = Utility.getExcel(Constants.positiveSearchData_file, "Sheet1");
	 return data;
      }
	 
	@Test(dataProvider="positiveSearch",priority=1)

	 //positive searches
	
	public void positiveSearches(String dropdown,String select,String product) throws IOException, Exception {
		
		
		base.inputValuesToTheWebelement(driver, Utility.propertyRead(Constants.home_page_loc_file, "loc_all"), dropdown);
		base.inputValuesToTheWebelement(driver, Utility.propertyRead(Constants.home_page_loc_file, "loc_searchText"), select);
		base.clickOnWebElement(driver, Utility.propertyRead(Constants.home_page_loc_file, "loc_searchButton"));
		String actualProduct = Base.getText(driver, Utility.propertyRead(Constants.home_page_loc_file, "loc_product1Text"));
		base.clickOnWebElement(driver, Utility.propertyRead(Constants.home_page_loc_file, "loc_homepage"));
		Base.pageValidation(actualProduct,product);
		
	}
	 @DataProvider
	 public Object[][] negativeSearch() throws Exception 
	 {
	 Object data[][] = Utility.getExcel(Constants.negativeSearchData_file, "Sheet1");
	 return data;
      }
	 
	@Test(dataProvider="negativeSearch",priority=2)

	// negative searches
	public void negativeSearches(String categories,String select,String product) throws IOException, Exception {
		base.inputValuesToTheWebelement(driver, Utility.propertyRead(Constants.home_page_loc_file, "loc_all"), categories);
		base.inputValuesToTheWebelement(driver, Utility.propertyRead(Constants.home_page_loc_file, "loc_searchText"), select);
		base.clickOnWebElement(driver, Utility.propertyRead(Constants.home_page_loc_file, "loc_searchButton"));
		String actualnegProduct = Base.getText(driver, Utility.propertyRead(Constants.home_page_loc_file, "loc_product2Text"));
		base.clickOnWebElement(driver, Utility.propertyRead(Constants.home_page_loc_file, "loc_homepage"));
		Base.pageValidation(actualnegProduct,product);
		
		
			}


	@AfterClass
	public void closeBrwser() throws Exception {
		base.driverClose(driver);

	}

}
