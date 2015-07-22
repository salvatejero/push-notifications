package com.liferay.pushnotifications.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ApplicationPreferencesLocalService}.
 *
 * @author Bruno Farache
 * @see ApplicationPreferencesLocalService
 * @generated
 */
public class ApplicationPreferencesLocalServiceWrapper
    implements ApplicationPreferencesLocalService,
        ServiceWrapper<ApplicationPreferencesLocalService> {
    private ApplicationPreferencesLocalService _applicationPreferencesLocalService;

    public ApplicationPreferencesLocalServiceWrapper(
        ApplicationPreferencesLocalService applicationPreferencesLocalService) {
        _applicationPreferencesLocalService = applicationPreferencesLocalService;
    }

    /**
    * Adds the application preferences to the database. Also notifies the appropriate model listeners.
    *
    * @param applicationPreferences the application preferences
    * @return the application preferences that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.pushnotifications.model.ApplicationPreferences addApplicationPreferences(
        com.liferay.pushnotifications.model.ApplicationPreferences applicationPreferences)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationPreferencesLocalService.addApplicationPreferences(applicationPreferences);
    }

    /**
    * Creates a new application preferences with the primary key. Does not add the application preferences to the database.
    *
    * @param applicationPreferencesPK the primary key for the new application preferences
    * @return the new application preferences
    */
    @Override
    public com.liferay.pushnotifications.model.ApplicationPreferences createApplicationPreferences(
        com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK applicationPreferencesPK) {
        return _applicationPreferencesLocalService.createApplicationPreferences(applicationPreferencesPK);
    }

    /**
    * Deletes the application preferences with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicationPreferencesPK the primary key of the application preferences
    * @return the application preferences that was removed
    * @throws PortalException if a application preferences with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.pushnotifications.model.ApplicationPreferences deleteApplicationPreferences(
        com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK applicationPreferencesPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _applicationPreferencesLocalService.deleteApplicationPreferences(applicationPreferencesPK);
    }

    /**
    * Deletes the application preferences from the database. Also notifies the appropriate model listeners.
    *
    * @param applicationPreferences the application preferences
    * @return the application preferences that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.pushnotifications.model.ApplicationPreferences deleteApplicationPreferences(
        com.liferay.pushnotifications.model.ApplicationPreferences applicationPreferences)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationPreferencesLocalService.deleteApplicationPreferences(applicationPreferences);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _applicationPreferencesLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationPreferencesLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.ApplicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationPreferencesLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.ApplicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationPreferencesLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationPreferencesLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationPreferencesLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.liferay.pushnotifications.model.ApplicationPreferences fetchApplicationPreferences(
        com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK applicationPreferencesPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationPreferencesLocalService.fetchApplicationPreferences(applicationPreferencesPK);
    }

    /**
    * Returns the application preferences with the primary key.
    *
    * @param applicationPreferencesPK the primary key of the application preferences
    * @return the application preferences
    * @throws PortalException if a application preferences with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.pushnotifications.model.ApplicationPreferences getApplicationPreferences(
        com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK applicationPreferencesPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _applicationPreferencesLocalService.getApplicationPreferences(applicationPreferencesPK);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _applicationPreferencesLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the application preferenceses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.ApplicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of application preferenceses
    * @param end the upper bound of the range of application preferenceses (not inclusive)
    * @return the range of application preferenceses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.liferay.pushnotifications.model.ApplicationPreferences> getApplicationPreferenceses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationPreferencesLocalService.getApplicationPreferenceses(start,
            end);
    }

    /**
    * Returns the number of application preferenceses.
    *
    * @return the number of application preferenceses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getApplicationPreferencesesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationPreferencesLocalService.getApplicationPreferencesesCount();
    }

    /**
    * Updates the application preferences in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param applicationPreferences the application preferences
    * @return the application preferences that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.pushnotifications.model.ApplicationPreferences updateApplicationPreferences(
        com.liferay.pushnotifications.model.ApplicationPreferences applicationPreferences)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationPreferencesLocalService.updateApplicationPreferences(applicationPreferences);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _applicationPreferencesLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _applicationPreferencesLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _applicationPreferencesLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.liferay.pushnotifications.model.ApplicationPreferences findApplicationPreferenceByApplicationId(
        long applicationId) {
        return _applicationPreferencesLocalService.findApplicationPreferenceByApplicationId(applicationId);
    }

    @Override
    public com.liferay.pushnotifications.model.ApplicationPreferences addApplicationPreferences(
        long appId, com.liferay.portal.model.User user,
        java.lang.String androidApiKey, long androidRetries,
        java.lang.String iosPasswordCertificated, long iosProdCert,
        long iosSandBoxCert, java.lang.String iosPasswordSandBoxCertificated) {
        return _applicationPreferencesLocalService.addApplicationPreferences(appId,
            user, androidApiKey, androidRetries, iosPasswordCertificated,
            iosProdCert, iosSandBoxCert, iosPasswordSandBoxCertificated);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ApplicationPreferencesLocalService getWrappedApplicationPreferencesLocalService() {
        return _applicationPreferencesLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedApplicationPreferencesLocalService(
        ApplicationPreferencesLocalService applicationPreferencesLocalService) {
        _applicationPreferencesLocalService = applicationPreferencesLocalService;
    }

    @Override
    public ApplicationPreferencesLocalService getWrappedService() {
        return _applicationPreferencesLocalService;
    }

    @Override
    public void setWrappedService(
        ApplicationPreferencesLocalService applicationPreferencesLocalService) {
        _applicationPreferencesLocalService = applicationPreferencesLocalService;
    }
}
