package com.keywords.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import static com.framework.keywords.Keywords.*;
import com.framework.constants.locatorType;

public class ZoomDemo extends BaseFramework{
	private static final Logger LOG = Logger.getLogger(ZoomDemo.class);
	@Test(priority=1)
	public void verifySignUpPageTest() {
		try {
			click(locatorType.css,"a[class$='free']");
			LOG.info("1st click");
			waitFor(2);
			click(locatorType.css,"span[aria-label$='month']");
			click(locatorType.xpath,"//span[contains(text(),'Mar')]/following-sibling::span");
			waitFor(2);
			click(locatorType.css,"span[aria-label$='day']");
			click(locatorType.css,"dd[aria-label='11']");
			waitFor(2);
			click(locatorType.css,"span[aria-label$='year']");
			click(locatorType.css,"dd[aria-label='1995']");
			LOG.info("CLicked on year button");
			waitFor(2);
			click(locatorType.css,"button.continue_button ");
			LOG.info("CLicked on continue button");
			waitFor(2);
			enterText(locatorType.css, "input[name='email']", "itnotes2021@gmail.com");
			LOG.info("email entered successfully");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
