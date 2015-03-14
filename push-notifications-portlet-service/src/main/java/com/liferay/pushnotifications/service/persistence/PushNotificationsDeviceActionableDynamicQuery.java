package com.liferay.pushnotifications.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.pushnotifications.model.PushNotificationsDevice;
import com.liferay.pushnotifications.service.PushNotificationsDeviceLocalServiceUtil;

/**
 * @author Bruno Farache
 * @generated
 */
public abstract class PushNotificationsDeviceActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public PushNotificationsDeviceActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(PushNotificationsDeviceLocalServiceUtil.getService());
        setClass(PushNotificationsDevice.class);

        setClassLoader(com.liferay.pushnotifications.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("pushNotificationsDeviceId");
    }
}
