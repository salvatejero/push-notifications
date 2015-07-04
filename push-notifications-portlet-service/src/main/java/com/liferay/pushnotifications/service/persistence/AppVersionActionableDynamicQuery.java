package com.liferay.pushnotifications.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.pushnotifications.model.AppVersion;
import com.liferay.pushnotifications.service.AppVersionLocalServiceUtil;

/**
 * @author Bruno Farache
 * @generated
 */
public abstract class AppVersionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AppVersionActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AppVersionLocalServiceUtil.getService());
        setClass(AppVersion.class);

        setClassLoader(com.liferay.pushnotifications.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("appVersionId");
    }
}
