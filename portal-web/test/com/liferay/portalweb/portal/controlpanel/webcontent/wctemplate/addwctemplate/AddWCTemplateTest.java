/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portal.controlpanel.webcontent.wctemplate.addwctemplate;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWCTemplateTest extends BaseTestCase {
	public void testAddWCTemplate() throws Exception {
		selenium.open("/web/guest/home/");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Control Panel")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Web Content",
			RuntimeVariables.replace("Web Content"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Templates", RuntimeVariables.replace("Templates"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Template']",
			RuntimeVariables.replace("Add Template"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_15_name_en_US']",
			RuntimeVariables.replace("WC Template Name"));
		selenium.type("//textarea[@id='_15_description_en_US']",
			RuntimeVariables.replace("WC Template Description"));
		selenium.clickAt("//input[@id='_15_editorButton']",
			RuntimeVariables.replace("Launch Editor"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//iframe[@id='_15_xslContentIFrame']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.selectFrame("//iframe[@id='_15_xslContentIFrame']");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (!RuntimeVariables.replace("")
										 .equals(selenium.getValue(
								"//textarea[@id='_15_plainEditorField']"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.type("//textarea[@id='_15_plainEditorField']",
			RuntimeVariables.replace("<h3>$text.getData()</h3>"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//input[@value='Update']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click("//input[@value='Update']");
		selenium.selectFrame("relative=top");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (!selenium.isVisible("//iframe[@id='_15_xslContentIFrame']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertFalse(selenium.isVisible("//iframe[@id='_15_xslContentIFrame']"));
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertTrue(selenium.isVisible("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("WC Template Name"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("WC Template Description"),
			selenium.getText("//td[4]/a"));
	}
}