package com.framework.keywords;



import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords {
	public static RemoteWebDriver driver;
	static WebDriverWait wait;
	private static final Logger LOG = Logger.getLogger(Keywords.class);
	/**
	 * This method will open browser in maximized mode
	 * @param browserName
	 * <ul>
	 * <li>Chrome</li>
	 * <li>Firefox</li>
	 * <li>Internet Explorer</li>
	 * </ul>
	 */
	public static void openBrower(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("Internet Explorer")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}else {
			//System.err.println("Invalid brower");
			LOG.error("Invalid brower");
		}
		LOG.info("Browser:"+browserName);
		driver.manage().window().maximize();
	}
	public static void launchUrl(String url) {
		driver.get(url);
	}
	/**
	 * 
	 * @param locatorType
	 * @param locatorValue
	 * @throws InterruptedException 
	 */
	public static void click(String locatorType, String locatorValue) throws InterruptedException {
		WebElement e=getWebElement(locatorType,locatorValue);
		e.click();
	}
	public static void waitFor(long sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	public static WebElement getWebElement(String locatorType,String locatorValue) {
		if(locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locatorValue));
		}else if(locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(locatorValue));
		}else if(locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locatorValue));
		}else
			return null;		
	}
	public static void enterText(String locatorType,String locatorValue,String text) {
		WebElement e=getWebElement(locatorType,locatorValue);
		e.sendKeys(text);
	}
	/**
	 * ScrollDown
	 */
	public static void scrollDownTest() {
		//waitFor();
		System.out.println("scrollDown");
		driver.executeScript("window.scrollBy(0,2500)");
	}
	public static void scrollUpTest() {
		//waitFor();
		System.out.println("scrollUp");
		driver.executeScript("window.scrollBy(0,-2500)");
	}
	public static void selectElement(String locatorType,String locatorValue) {
		WebElement e=getWebElement(locatorType,locatorValue);
		e.submit();
	}
}
