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

package com.liferay.portalweb.socialofficeprofile.profile.souseditadditionalemailaddressnullprofile;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SOUs_EditAdditionalEmailAddressNullProfileTest extends BaseTestCase {
	public void testSOUs_EditAdditionalEmailAddressNullProfile()
		throws Exception {
		selenium.open("/web/socialoffice01/so/profile");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//div[@class='lfr-contact-name']/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace("Social01 Office01 User01"),
			selenium.getText("//div[@class='lfr-contact-name']/a"));
		assertEquals(RuntimeVariables.replace("Additional Email Addresses:"),
			selenium.getText(
				"//div[@data-title='Additional Email Addresses']/h3"));
		assertEquals(RuntimeVariables.replace("Email Address"),
			selenium.getText(
				"//div[@data-title='Additional Email Addresses']/ul/li/span"));
		assertEquals(RuntimeVariables.replace("socialoffice02@liferay.com"),
			selenium.getText(
				"//div[@data-title='Additional Email Addresses']/ul/li/span[2]/a"));
		selenium.clickAt("//div[@data-title='Additional Email Addresses']",
			RuntimeVariables.replace("Edit"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//span[contains(.,'Email Address')]/span/input")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"//script[contains(@src,'/liferay/auto_fields.js')]")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.type("//span[contains(.,'Email Address')]/span/input",
			RuntimeVariables.replace(""));
		selenium.clickAt("//input[contains(@id,'emailAddressPrimary')]",
			RuntimeVariables.replace("Primary"));
		Thread.sleep(5000);
		selenium.clickAt("//input[@value='Save']",
			RuntimeVariables.replace("Save"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//li[@data-title='Additional Email Addresses']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertTrue(selenium.isVisible(
				"//li[@data-title='Additional Email Addresses']"));
		assertFalse(selenium.isTextPresent("Additional Email Addresses:"));
		assertFalse(selenium.isTextPresent("socialoffice02@liferay.com"));
	}
}