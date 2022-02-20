package com.keywords.tests;
import com.framework.constants.*;
import org.testng.annotations.Test;

import static com.framework.keywords.Keywords.*;

public class pythonSite extends BaseFramework{
	@Test(priority=1)
	public void verifyGoogleHomePage() throws InterruptedException {
		waitFor(20);
		enterText(locatorType.css,"input[title='Search']","Python");
		waitFor(20);
		click(locatorType.css,"input[value*='Search']");
	}
	@Test(priority=2)
	public void verifyPythonHomePage() throws InterruptedException {
		click(locatorType.xpath,"//h3[text()='Welcome to Python.org']");
		waitFor(30);
		scrollDownTest();
		scrollUpTest();
		waitFor(2);
		click("css","li#documentation>a[href*='/doc/']");
		click("css","a[title*='Job']");
		waitFor(20);
		enterText("css","input#id-search-field","QA");
		click("css","button#submit");
	}
	
}
