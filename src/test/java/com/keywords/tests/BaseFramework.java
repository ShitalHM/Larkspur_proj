package com.keywords.tests;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import static com.framework.keywords.Keywords.*;
public class BaseFramework {
	@Parameters({"browserName","url"})
	@BeforeClass
	public void setUp(String browserName,String url) {
		openBrower(browserName);
		launchUrl(url);
	}
	@AfterClass
	public void tearDown() {
		waitFor(20);
		driver.quit();
	}
}
