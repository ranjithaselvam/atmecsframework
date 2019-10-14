package com.atmecs.konakart.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.konakart.constants.Constants;
import com.atmecs.konakart.utility.Utility;

public class Base {

	public static WebDriver driver;
	static WebElement webElement;
//browser setup
	public static WebDriver getBrowser() throws Exception {
		try {
		    String browserName = Utility.propertyRead(Constants.config_file,"browserName");
	        if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", Constants.chrome_file);
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", Constants.fireFox_file);
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("internetExplorer")) {
				System.setProperty("webdriver.ie.driver", Constants.internetExplorer_file);
				driver=new InternetExplorerDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
//launch url
	public static void getUrl() throws Exception {
		try {
			String url = Utility.propertyRead(Constants.config_file,"url");
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
//explicit wait
	public static void waitForElementVisibility(WebElement element) throws Exception {

		try {
			WebDriverWait wb = new WebDriverWait(driver, 60);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
//verify element is displayed or not
	public static boolean elementIsDisplayed(WebElement element) throws Exception {
		try {
			boolean displayed = element.isDisplayed();

			return displayed;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}
//check whether element enable or not
	public static boolean elementIsEnabled(WebElement element) throws Exception {
		try {
			boolean enabled = element.isEnabled();
			return enabled;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static boolean elementIsSelected(WebElement element) throws Exception {
		try {
			boolean selected = element.isSelected();
			return selected;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}
//pass input values in text box
	public static void inputValuesToTheWebelement(String element, String values) throws Exception {
		try {
			
			webElement=Utility.getbjectLocator(element);
			webElement.sendKeys(values);
			Utility.logInfo("value passed");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Utility.logInfo("value not passed");
		}
	}
//element click
	public static void clickOnWebElement(String element) throws Exception {
		try {
			webElement=Utility.getbjectLocator(element);
			webElement.click();
			Utility.logInfo("element is clicked");	
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Utility.logInfo("element not clickable");
			
		}
	}

	public static void driverClose() throws Exception {
		try {
			driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void mouseOverToElement(WebElement element) throws Exception {
		try {
			waitForElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void selectDropDown(WebElement element, String value, String option) throws Exception {
		try {
			waitForElementVisibility(element);
			Select sc = new Select(element);
			if (option.equalsIgnoreCase("value")) {
				sc.selectByValue(value);
			} else if (option.equalsIgnoreCase("visibletext")) {
				sc.deselectByVisibleText(value);
			} else if (option.equalsIgnoreCase("index")) {
				sc.selectByIndex(Integer.parseInt(value));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void scrollToWebelement(WebElement element) throws Exception {
		try {
			waitForElementVisibility(element);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("argument[0].scrollInttoView();", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void scrollUsingPixels(int width, int height) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("windows.scrollBy(" + width + "," + height + ")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void scrollToBottomOfThePage() throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("windows.scrollTo(0,document.body.scrollHeight)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void dragAndDrop(WebElement src, WebElement tar) throws Exception {
		try {
			waitForElementVisibility(src);
			Actions ac = new Actions(driver);
			ac.dragAndDrop(src, tar).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void doubleClickOnTheElement(WebElement element) throws Exception {
		try {
			waitForElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.doubleClick(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}

	}

	public static void rightClickOnTheElement(WebElement element) throws Exception {
		try {
			waitForElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.contextClick(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void alertAccept() throws Exception {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}

	}

	public static void alertDismiss() throws Exception {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void alertSendKeys(String value) throws Exception {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(value);
			alert.accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void switchToDefaultContent() throws Exception {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static String getTextFromTheElement(WebElement element) throws Exception {
		try {
			waitForElementVisibility(element);
			String text = element.getText();
			return text;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static String getAttributeFromTheWebElement(WebElement element, String attKey) throws Exception {
		try {
			waitForElementVisibility(element);
			String attribute = element.getAttribute(attKey);
			return attribute;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();

		}
	}

	public static void switchToFrame(WebElement element) throws Exception {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void ScreenShotOnTheWebPage(String filename) throws Exception {
		try {
			File des = new File("");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, des);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void switchToWindowHandle(String windowTitle) throws Exception {
		try {
			String fId = driver.getWindowHandle();
			Set<String> pId = driver.getWindowHandles();
			for (String x : pId) {
				driver.switchTo().window(x);
				String title = driver.getTitle();
				if (title.equals(windowTitle)) {
					driver.switchTo().window(x);

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void driverQuit() throws Exception {
		try {
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static String getTitle() throws Exception {
		try {
			String title = driver.getTitle();
			return title;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static String getCurrentUrl() throws Exception {
		try {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void navigateToUrl(String url) throws Exception {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public void navigateCommands(String option) throws Exception {
		try {
			if (option.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			} else if (option.equalsIgnoreCase("backward")) {
				driver.navigate().back();
			} else if (option.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static List<String> fetchDynamicContentFromWebTable(String header) throws Exception {
		try {
			List<String> li = new ArrayList<>();
			WebElement table = driver.findElement(By.tagName("//table"));
			List<WebElement> trow = table.findElements(By.tagName("tr"));
			for (int i = 0; i < trow.size(); i++) {
				List<WebElement> thead = trow.get(i).findElements(By.tagName("th"));
				for (int j = 0; j < thead.size(); j++) {
					String text = thead.get(j).getText();
					if (text.equals(header)) {
						List<WebElement> tdata = trow.get(i).findElements(By.tagName("td"));
						for (int k = 0; k < tdata.size(); k++) {
							String tdataContent = tdata.get(k).getText();
							li.add(tdataContent);
						}
					}
				}
			}
			return li;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}
}