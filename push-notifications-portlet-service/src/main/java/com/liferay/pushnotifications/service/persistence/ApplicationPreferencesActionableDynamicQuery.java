package com.liferay.pushnotifications.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.pushnotifications.model.ApplicationPreferences;
import com.liferay.pushnotifications.service.ApplicationPreferencesLocalServiceUtil;

/**
 * @author Bruno Farache
 * @generated
 */
public abstract class ApplicationPreferencesActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ApplicationPreferencesActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(ApplicationPreferencesLocalServiceUtil.getService());
        setClass(ApplicationPreferences.class);

        setClassLoader(com.liferay.pushnotifications.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("primaryKey.applicationPreferenceId");
    }
}
