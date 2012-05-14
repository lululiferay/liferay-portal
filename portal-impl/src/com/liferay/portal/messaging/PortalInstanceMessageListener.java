package com.liferay.portal.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.servlet.ServletContextPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.util.PortalInstances;
import com.liferay.portal.util.PortalUtil;

import javax.servlet.ServletContext;
public class PortalInstanceMessageListener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		try {

			String webId = GetterUtil.getString(message.getString("webId"));

			String portalServletContextName = PortalUtil.getPathContext();

				ServletContext portalServletContext =
					ServletContextPool.get(portalServletContextName);

			PortalInstances.initCompany(portalServletContext, webId);

		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to init company"
					);
			}
		}

	}

	private static Log _log = LogFactoryUtil.getLog(
			PortalInstanceMessageListener.class);
}