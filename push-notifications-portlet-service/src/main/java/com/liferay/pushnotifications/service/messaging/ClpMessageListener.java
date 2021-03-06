package com.liferay.pushnotifications.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.liferay.pushnotifications.service.AppVersionLocalServiceUtil;
import com.liferay.pushnotifications.service.ApplicationLocalServiceUtil;
import com.liferay.pushnotifications.service.ApplicationPreferencesLocalServiceUtil;
import com.liferay.pushnotifications.service.ClpSerializer;
import com.liferay.pushnotifications.service.PushNotificationsDeviceLocalServiceUtil;
import com.liferay.pushnotifications.service.PushNotificationsDeviceServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            ApplicationLocalServiceUtil.clearService();

            ApplicationPreferencesLocalServiceUtil.clearService();

            AppVersionLocalServiceUtil.clearService();

            PushNotificationsDeviceLocalServiceUtil.clearService();

            PushNotificationsDeviceServiceUtil.clearService();
        }
    }
}
