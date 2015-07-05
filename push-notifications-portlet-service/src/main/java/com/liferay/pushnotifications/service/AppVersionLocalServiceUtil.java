package com.liferay.pushnotifications.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for AppVersion. This utility wraps
 * {@link com.liferay.pushnotifications.service.impl.AppVersionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Bruno Farache
 * @see AppVersionLocalService
 * @see com.liferay.pushnotifications.service.base.AppVersionLocalServiceBaseImpl
 * @see com.liferay.pushnotifications.service.impl.AppVersionLocalServiceImpl
 * @generated
 */
public class AppVersionLocalServiceUtil {
    private static AppVersionLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.pushnotifications.service.impl.AppVersionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the app version to the database. Also notifies the appropriate model listeners.
    *
    * @param appVersion the app version
    * @return the app version that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion addAppVersion(
        com.liferay.pushnotifications.model.AppVersion appVersion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addAppVersion(appVersion);
    }

    /**
    * Creates a new app version with the primary key. Does not add the app version to the database.
    *
    * @param appVersionId the primary key for the new app version
    * @return the new app version
    */
    public static com.liferay.pushnotifications.model.AppVersion createAppVersion(
        long appVersionId) {
        return getService().createAppVersion(appVersionId);
    }

    /**
    * Deletes the app version with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param appVersionId the primary key of the app version
    * @return the app version that was removed
    * @throws PortalException if a app version with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion deleteAppVersion(
        long appVersionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAppVersion(appVersionId);
    }

    /**
    * Deletes the app version from the database. Also notifies the appropriate model listeners.
    *
    * @param appVersion the app version
    * @return the app version that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion deleteAppVersion(
        com.liferay.pushnotifications.model.AppVersion appVersion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteAppVersion(appVersion);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.AppVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.AppVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.liferay.pushnotifications.model.AppVersion fetchAppVersion(
        long appVersionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchAppVersion(appVersionId);
    }

    /**
    * Returns the app version with the primary key.
    *
    * @param appVersionId the primary key of the app version
    * @return the app version
    * @throws PortalException if a app version with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion getAppVersion(
        long appVersionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getAppVersion(appVersionId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the app versions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.AppVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of app versions
    * @param end the upper bound of the range of app versions (not inclusive)
    * @return the range of app versions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.AppVersion> getAppVersions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAppVersions(start, end);
    }

    /**
    * Returns the number of app versions.
    *
    * @return the number of app versions
    * @throws SystemException if a system exception occurred
    */
    public static int getAppVersionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAppVersionsCount();
    }

    /**
    * Updates the app version in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param appVersion the app version
    * @return the app version that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion updateAppVersion(
        com.liferay.pushnotifications.model.AppVersion appVersion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateAppVersion(appVersion);
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

    public static java.util.List<com.liferay.pushnotifications.model.AppVersion> findAppVerionByAppId(
        long applicationId) {
        return getService().findAppVerionByAppId(applicationId);
    }

    public static java.util.List<com.liferay.pushnotifications.model.AppVersion> findAppVerionByAppId(
        long applicationId, int start, int end) {
        return getService().findAppVerionByAppId(applicationId, start, end);
    }

    public static com.liferay.pushnotifications.model.AppVersion addAppVersion(
        java.lang.String versionKey, java.lang.String structure,
        com.liferay.portal.model.User user, java.lang.Long appId) {
        return getService().addAppVersion(versionKey, structure, user, appId);
    }

    public static void clearService() {
        _service = null;
    }

    public static AppVersionLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    AppVersionLocalService.class.getName());

            if (invokableLocalService instanceof AppVersionLocalService) {
                _service = (AppVersionLocalService) invokableLocalService;
            } else {
                _service = new AppVersionLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(AppVersionLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(AppVersionLocalService service) {
    }
}
