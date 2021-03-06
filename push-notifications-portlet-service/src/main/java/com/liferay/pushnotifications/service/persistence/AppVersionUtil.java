package com.liferay.pushnotifications.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.pushnotifications.model.AppVersion;

import java.util.List;

/**
 * The persistence utility for the app version service. This utility wraps {@link AppVersionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Farache
 * @see AppVersionPersistence
 * @see AppVersionPersistenceImpl
 * @generated
 */
public class AppVersionUtil {
    private static AppVersionPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(AppVersion appVersion) {
        getPersistence().clearCache(appVersion);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<AppVersion> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<AppVersion> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<AppVersion> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static AppVersion update(AppVersion appVersion)
        throws SystemException {
        return getPersistence().update(appVersion);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static AppVersion update(AppVersion appVersion,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(appVersion, serviceContext);
    }

    /**
    * Returns all the app versions where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the matching app versions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.AppVersion> findByApplicationId(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByApplicationId(applicationId);
    }

    /**
    * Returns a range of all the app versions where applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.AppVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param applicationId the application ID
    * @param start the lower bound of the range of app versions
    * @param end the upper bound of the range of app versions (not inclusive)
    * @return the range of matching app versions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.AppVersion> findByApplicationId(
        long applicationId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByApplicationId(applicationId, start, end);
    }

    /**
    * Returns an ordered range of all the app versions where applicationId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.AppVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param applicationId the application ID
    * @param start the lower bound of the range of app versions
    * @param end the upper bound of the range of app versions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching app versions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.AppVersion> findByApplicationId(
        long applicationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByApplicationId(applicationId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first app version in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching app version
    * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a matching app version could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion findByApplicationId_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException {
        return getPersistence()
                   .findByApplicationId_First(applicationId, orderByComparator);
    }

    /**
    * Returns the first app version in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching app version, or <code>null</code> if a matching app version could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion fetchByApplicationId_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByApplicationId_First(applicationId, orderByComparator);
    }

    /**
    * Returns the last app version in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching app version
    * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a matching app version could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion findByApplicationId_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException {
        return getPersistence()
                   .findByApplicationId_Last(applicationId, orderByComparator);
    }

    /**
    * Returns the last app version in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching app version, or <code>null</code> if a matching app version could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion fetchByApplicationId_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByApplicationId_Last(applicationId, orderByComparator);
    }

    /**
    * Returns the app versions before and after the current app version in the ordered set where applicationId = &#63;.
    *
    * @param appVersionId the primary key of the current app version
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next app version
    * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a app version with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion[] findByApplicationId_PrevAndNext(
        long appVersionId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException {
        return getPersistence()
                   .findByApplicationId_PrevAndNext(appVersionId,
            applicationId, orderByComparator);
    }

    /**
    * Removes all the app versions where applicationId = &#63; from the database.
    *
    * @param applicationId the application ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByApplicationId(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByApplicationId(applicationId);
    }

    /**
    * Returns the number of app versions where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the number of matching app versions
    * @throws SystemException if a system exception occurred
    */
    public static int countByApplicationId(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByApplicationId(applicationId);
    }

    /**
    * Returns all the app versions where applicationId = &#63; and appVersionKey = &#63;.
    *
    * @param applicationId the application ID
    * @param appVersionKey the app version key
    * @return the matching app versions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.AppVersion> findByApplicationIdAndVersion(
        long applicationId, java.lang.String appVersionKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByApplicationIdAndVersion(applicationId, appVersionKey);
    }

    /**
    * Returns a range of all the app versions where applicationId = &#63; and appVersionKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.AppVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param applicationId the application ID
    * @param appVersionKey the app version key
    * @param start the lower bound of the range of app versions
    * @param end the upper bound of the range of app versions (not inclusive)
    * @return the range of matching app versions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.AppVersion> findByApplicationIdAndVersion(
        long applicationId, java.lang.String appVersionKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByApplicationIdAndVersion(applicationId, appVersionKey,
            start, end);
    }

    /**
    * Returns an ordered range of all the app versions where applicationId = &#63; and appVersionKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.AppVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param applicationId the application ID
    * @param appVersionKey the app version key
    * @param start the lower bound of the range of app versions
    * @param end the upper bound of the range of app versions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching app versions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.AppVersion> findByApplicationIdAndVersion(
        long applicationId, java.lang.String appVersionKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByApplicationIdAndVersion(applicationId, appVersionKey,
            start, end, orderByComparator);
    }

    /**
    * Returns the first app version in the ordered set where applicationId = &#63; and appVersionKey = &#63;.
    *
    * @param applicationId the application ID
    * @param appVersionKey the app version key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching app version
    * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a matching app version could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion findByApplicationIdAndVersion_First(
        long applicationId, java.lang.String appVersionKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException {
        return getPersistence()
                   .findByApplicationIdAndVersion_First(applicationId,
            appVersionKey, orderByComparator);
    }

    /**
    * Returns the first app version in the ordered set where applicationId = &#63; and appVersionKey = &#63;.
    *
    * @param applicationId the application ID
    * @param appVersionKey the app version key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching app version, or <code>null</code> if a matching app version could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion fetchByApplicationIdAndVersion_First(
        long applicationId, java.lang.String appVersionKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByApplicationIdAndVersion_First(applicationId,
            appVersionKey, orderByComparator);
    }

    /**
    * Returns the last app version in the ordered set where applicationId = &#63; and appVersionKey = &#63;.
    *
    * @param applicationId the application ID
    * @param appVersionKey the app version key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching app version
    * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a matching app version could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion findByApplicationIdAndVersion_Last(
        long applicationId, java.lang.String appVersionKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException {
        return getPersistence()
                   .findByApplicationIdAndVersion_Last(applicationId,
            appVersionKey, orderByComparator);
    }

    /**
    * Returns the last app version in the ordered set where applicationId = &#63; and appVersionKey = &#63;.
    *
    * @param applicationId the application ID
    * @param appVersionKey the app version key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching app version, or <code>null</code> if a matching app version could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion fetchByApplicationIdAndVersion_Last(
        long applicationId, java.lang.String appVersionKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByApplicationIdAndVersion_Last(applicationId,
            appVersionKey, orderByComparator);
    }

    /**
    * Returns the app versions before and after the current app version in the ordered set where applicationId = &#63; and appVersionKey = &#63;.
    *
    * @param appVersionId the primary key of the current app version
    * @param applicationId the application ID
    * @param appVersionKey the app version key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next app version
    * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a app version with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion[] findByApplicationIdAndVersion_PrevAndNext(
        long appVersionId, long applicationId, java.lang.String appVersionKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException {
        return getPersistence()
                   .findByApplicationIdAndVersion_PrevAndNext(appVersionId,
            applicationId, appVersionKey, orderByComparator);
    }

    /**
    * Removes all the app versions where applicationId = &#63; and appVersionKey = &#63; from the database.
    *
    * @param applicationId the application ID
    * @param appVersionKey the app version key
    * @throws SystemException if a system exception occurred
    */
    public static void removeByApplicationIdAndVersion(long applicationId,
        java.lang.String appVersionKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByApplicationIdAndVersion(applicationId, appVersionKey);
    }

    /**
    * Returns the number of app versions where applicationId = &#63; and appVersionKey = &#63;.
    *
    * @param applicationId the application ID
    * @param appVersionKey the app version key
    * @return the number of matching app versions
    * @throws SystemException if a system exception occurred
    */
    public static int countByApplicationIdAndVersion(long applicationId,
        java.lang.String appVersionKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByApplicationIdAndVersion(applicationId, appVersionKey);
    }

    /**
    * Caches the app version in the entity cache if it is enabled.
    *
    * @param appVersion the app version
    */
    public static void cacheResult(
        com.liferay.pushnotifications.model.AppVersion appVersion) {
        getPersistence().cacheResult(appVersion);
    }

    /**
    * Caches the app versions in the entity cache if it is enabled.
    *
    * @param appVersions the app versions
    */
    public static void cacheResult(
        java.util.List<com.liferay.pushnotifications.model.AppVersion> appVersions) {
        getPersistence().cacheResult(appVersions);
    }

    /**
    * Creates a new app version with the primary key. Does not add the app version to the database.
    *
    * @param appVersionId the primary key for the new app version
    * @return the new app version
    */
    public static com.liferay.pushnotifications.model.AppVersion create(
        long appVersionId) {
        return getPersistence().create(appVersionId);
    }

    /**
    * Removes the app version with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param appVersionId the primary key of the app version
    * @return the app version that was removed
    * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a app version with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion remove(
        long appVersionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException {
        return getPersistence().remove(appVersionId);
    }

    public static com.liferay.pushnotifications.model.AppVersion updateImpl(
        com.liferay.pushnotifications.model.AppVersion appVersion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(appVersion);
    }

    /**
    * Returns the app version with the primary key or throws a {@link com.liferay.pushnotifications.NoSuchAppVersionException} if it could not be found.
    *
    * @param appVersionId the primary key of the app version
    * @return the app version
    * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a app version with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion findByPrimaryKey(
        long appVersionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException {
        return getPersistence().findByPrimaryKey(appVersionId);
    }

    /**
    * Returns the app version with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param appVersionId the primary key of the app version
    * @return the app version, or <code>null</code> if a app version with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.AppVersion fetchByPrimaryKey(
        long appVersionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(appVersionId);
    }

    /**
    * Returns all the app versions.
    *
    * @return the app versions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.AppVersion> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.liferay.pushnotifications.model.AppVersion> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the app versions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.AppVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of app versions
    * @param end the upper bound of the range of app versions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of app versions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.AppVersion> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the app versions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of app versions.
    *
    * @return the number of app versions
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static AppVersionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AppVersionPersistence) PortletBeanLocatorUtil.locate(com.liferay.pushnotifications.service.ClpSerializer.getServletContextName(),
                    AppVersionPersistence.class.getName());

            ReferenceRegistry.registerReference(AppVersionUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(AppVersionPersistence persistence) {
    }
}
