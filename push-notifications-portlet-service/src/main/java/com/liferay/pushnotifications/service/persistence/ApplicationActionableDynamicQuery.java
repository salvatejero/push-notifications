package com.liferay.pushnotifications.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.pushnotifications.model.Application;
import com.liferay.pushnotifications.service.ApplicationLocalServiceUtil;

/**
 * @author Bruno Farache
 * @generated
 */
public abstract class ApplicationActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ApplicationActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ApplicationLocalServiceUtil.getService());
        setClass(Application.class);

        setClassLoader(com.liferay.pushnotifications.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("applicationId");
    }
}
