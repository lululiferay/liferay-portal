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

package com.liferay.portalweb.plugins.testevent.portletec.addportletec;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewPortletECTest extends BaseTestCase {
	public void testViewPortletEC() throws Exception {
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Event Consumer Test Page",
			RuntimeVariables.replace("Event Consumer Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible("//section"));
		assertEquals(RuntimeVariables.replace("Event Consumer"),
			selenium.getText("//span[@class='portlet-title-text']"));
		assertTrue(selenium.isVisible("//span[@title='Options']/ul/li/strong/a"));
		assertTrue(selenium.isVisible("//img[@title='Minimize']"));
		assertTrue(selenium.isVisible("//img[@title='Maximize']"));
		assertTrue(selenium.isVisible("//img[@title='Remove']"));
	}
}