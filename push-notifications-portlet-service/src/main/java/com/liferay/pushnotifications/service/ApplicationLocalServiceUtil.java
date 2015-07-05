package com.liferay.pushnotifications.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Application. This utility wraps
 * {@link com.liferay.pushnotifications.service.impl.ApplicationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Bruno Farache
 * @see ApplicationLocalService
 * @see com.liferay.pushnotifications.service.base.ApplicationLocalServiceBaseImpl
 * @see com.liferay.pushnotifications.service.impl.ApplicationLocalServiceImpl
 * @generated
 */
public class ApplicationLocalServiceUtil {
    private static ApplicationLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.pushnotifications.service.impl.ApplicationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the application to the database. Also notifies the appropriate model listeners.
    *
    * @param application the application
    * @return the application that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.Application addApplication(
        com.liferay.pushnotifications.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addApplication(application);
    }

    /**
    * Creates a new application with the primary key. Does not add the application to the database.
    *
    * @param applicationId the primary key for the new application
    * @return the new application
    */
    public static com.liferay.pushnotifications.model.Application createApplication(
        long applicationId) {
        return getService().createApplication(applicationId);
    }

    /**
    * Deletes the application with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicationId the primary key of the application
    * @return the application that was removed
    * @throws PortalException if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.Application deleteApplication(
        long applicationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteApplication(applicationId);
    }

    /**
    * Deletes the application from the database. Also notifies the appropriate model listeners.
    *
    * @param application the application
    * @return the application that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.Application deleteApplication(
        com.liferay.pushnotifications.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteApplication(application);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.ApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.ApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.liferay.pushnotifications.model.Application fetchApplication(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchApplication(applicationId);
    }

    /**
    * Returns the application with the primary key.
    *
    * @param applicationId the primary key of the application
    * @return the application
    * @throws PortalException if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.Application getApplication(
        long applicationId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplication(applicationId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the applications.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.ApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of applications
    * @param end the upper bound of the range of applications (not inclusive)
    * @return the range of applications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.Application> getApplications(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplications(start, end);
    }

    /**
    * Returns the number of applications.
    *
    * @return the number of applications
    * @throws SystemException if a system exception occurred
    */
    public static int getApplicationsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getApplicationsCount();
    }

    /**
    * Updates the application in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param application the application
    * @return the application that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.Application updateApplication(
        com.liferay.pushnotifications.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateApplication(application);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.liferay.pushnotifications.model.Application updateApplication(
        java.lang.String appName, com.liferay.portal.model.User user) {
        return getService().updateApplication(appName, user);
    }

    public static void clearService() {
        _service = null;
    }

    public static ApplicationLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ApplicationLocalService.class.getName());

            if (invokableLocalService instanceof ApplicationLocalService) {
                _service = (ApplicationLocalService) invokableLocalService;
            } else {
                _service = new ApplicationLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ApplicationLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ApplicationLocalService service) {
    }
}
