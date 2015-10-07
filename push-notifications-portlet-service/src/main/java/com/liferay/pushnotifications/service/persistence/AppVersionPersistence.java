package com.liferay.pushnotifications.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.pushnotifications.model.AppVersion;

/**
 * The persistence interface for the app version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Farache
 * @see AppVersionPersistenceImpl
 * @see AppVersionUtil
 * @generated
 */
public interface AppVersionPersistence extends BasePersistence<AppVersion> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AppVersionUtil} to access the app version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the app versions where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the matching app versions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.pushnotifications.model.AppVersion> findByApplicationId(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.pushnotifications.model.AppVersion> findByApplicationId(
        long applicationId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.pushnotifications.model.AppVersion> findByApplicationId(
        long applicationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first app version in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching app version
    * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a matching app version could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.AppVersion findByApplicationId_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException;

    /**
    * Returns the first app version in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching app version, or <code>null</code> if a matching app version could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.AppVersion fetchByApplicationId_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last app version in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching app version
    * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a matching app version could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.AppVersion findByApplicationId_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException;

    /**
    * Returns the last app version in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching app version, or <code>null</code> if a matching app version could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.AppVersion fetchByApplicationId_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.pushnotifications.model.AppVersion[] findByApplicationId_PrevAndNext(
        long appVersionId, long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException;

    /**
    * Removes all the app versions where applicationId = &#63; from the database.
    *
    * @param applicationId the application ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByApplicationId(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of app versions where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the number of matching app versions
    * @throws SystemException if a system exception occurred
    */
    public int countByApplicationId(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the app versions where applicationId = &#63; and appVersionKey = &#63;.
    *
    * @param applicationId the application ID
    * @param appVersionKey the app version key
    * @return the matching app versions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.pushnotifications.model.AppVersion> findByApplicationIdAndVersion(
        long applicationId, java.lang.String appVersionKey)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.pushnotifications.model.AppVersion> findByApplicationIdAndVersion(
        long applicationId, java.lang.String appVersionKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.pushnotifications.model.AppVersion> findByApplicationIdAndVersion(
        long applicationId, java.lang.String appVersionKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.pushnotifications.model.AppVersion findByApplicationIdAndVersion_First(
        long applicationId, java.lang.String appVersionKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException;

    /**
    * Returns the first app version in the ordered set where applicationId = &#63; and appVersionKey = &#63;.
    *
    * @param applicationId the application ID
    * @param appVersionKey the app version key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching app version, or <code>null</code> if a matching app version could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.AppVersion fetchByApplicationIdAndVersion_First(
        long applicationId, java.lang.String appVersionKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.pushnotifications.model.AppVersion findByApplicationIdAndVersion_Last(
        long applicationId, java.lang.String appVersionKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException;

    /**
    * Returns the last app version in the ordered set where applicationId = &#63; and appVersionKey = &#63;.
    *
    * @param applicationId the application ID
    * @param appVersionKey the app version key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching app version, or <code>null</code> if a matching app version could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.AppVersion fetchByApplicationIdAndVersion_Last(
        long applicationId, java.lang.String appVersionKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.pushnotifications.model.AppVersion[] findByApplicationIdAndVersion_PrevAndNext(
        long appVersionId, long applicationId, java.lang.String appVersionKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException;

    /**
    * Removes all the app versions where applicationId = &#63; and appVersionKey = &#63; from the database.
    *
    * @param applicationId the application ID
    * @param appVersionKey the app version key
    * @throws SystemException if a system exception occurred
    */
    public void removeByApplicationIdAndVersion(long applicationId,
        java.lang.String appVersionKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of app versions where applicationId = &#63; and appVersionKey = &#63;.
    *
    * @param applicationId the application ID
    * @param appVersionKey the app version key
    * @return the number of matching app versions
    * @throws SystemException if a system exception occurred
    */
    public int countByApplicationIdAndVersion(long applicationId,
        java.lang.String appVersionKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the app version in the entity cache if it is enabled.
    *
    * @param appVersion the app version
    */
    public void cacheResult(
        com.liferay.pushnotifications.model.AppVersion appVersion);

    /**
    * Caches the app versions in the entity cache if it is enabled.
    *
    * @param appVersions the app versions
    */
    public void cacheResult(
        java.util.List<com.liferay.pushnotifications.model.AppVersion> appVersions);

    /**
    * Creates a new app version with the primary key. Does not add the app version to the database.
    *
    * @param appVersionId the primary key for the new app version
    * @return the new app version
    */
    public com.liferay.pushnotifications.model.AppVersion create(
        long appVersionId);

    /**
    * Removes the app version with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param appVersionId the primary key of the app version
    * @return the app version that was removed
    * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a app version with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.AppVersion remove(
        long appVersionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException;

    public com.liferay.pushnotifications.model.AppVersion updateImpl(
        com.liferay.pushnotifications.model.AppVersion appVersion)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the app version with the primary key or throws a {@link com.liferay.pushnotifications.NoSuchAppVersionException} if it could not be found.
    *
    * @param appVersionId the primary key of the app version
    * @return the app version
    * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a app version with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.AppVersion findByPrimaryKey(
        long appVersionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchAppVersionException;

    /**
    * Returns the app version with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param appVersionId the primary key of the app version
    * @return the app version, or <code>null</code> if a app version with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.AppVersion fetchByPrimaryKey(
        long appVersionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the app versions.
    *
    * @return the app versions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.pushnotifications.model.AppVersion> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.pushnotifications.model.AppVersion> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.pushnotifications.model.AppVersion> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the app versions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of app versions.
    *
    * @return the number of app versions
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
