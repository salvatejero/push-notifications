package com.liferay.pushnotifications.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.pushnotifications.model.PushNotificationsDevice;

import java.util.List;

/**
 * The persistence utility for the push notifications device service. This utility wraps {@link PushNotificationsDevicePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Farache
 * @see PushNotificationsDevicePersistence
 * @see PushNotificationsDevicePersistenceImpl
 * @generated
 */
public class PushNotificationsDeviceUtil {
    private static PushNotificationsDevicePersistence _persistence;

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
    public static void clearCache(
        PushNotificationsDevice pushNotificationsDevice) {
        getPersistence().clearCache(pushNotificationsDevice);
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
    public static List<PushNotificationsDevice> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<PushNotificationsDevice> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<PushNotificationsDevice> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static PushNotificationsDevice update(
        PushNotificationsDevice pushNotificationsDevice)
        throws SystemException {
        return getPersistence().update(pushNotificationsDevice);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static PushNotificationsDevice update(
        PushNotificationsDevice pushNotificationsDevice,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(pushNotificationsDevice, serviceContext);
    }

    /**
    * Returns the push notifications device where token = &#63; or throws a {@link com.liferay.pushnotifications.NoSuchDeviceException} if it could not be found.
    *
    * @param token the token
    * @return the matching push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByToken(
        java.lang.String token)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence().findByToken(token);
    }

    /**
    * Returns the push notifications device where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param token the token
    * @return the matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByToken(
        java.lang.String token)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByToken(token);
    }

    /**
    * Returns the push notifications device where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param token the token
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByToken(
        java.lang.String token, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByToken(token, retrieveFromCache);
    }

    /**
    * Removes the push notifications device where token = &#63; from the database.
    *
    * @param token the token
    * @return the push notifications device that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice removeByToken(
        java.lang.String token)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence().removeByToken(token);
    }

    /**
    * Returns the number of push notifications devices where token = &#63;.
    *
    * @param token the token
    * @return the number of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static int countByToken(java.lang.String token)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByToken(token);
    }

    /**
    * Returns all the push notifications devices where userId = &#63; and platform = &#63;.
    *
    * @param userId the user ID
    * @param platform the platform
    * @return the matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU_P(
        long userId, java.lang.String platform)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU_P(userId, platform);
    }

    /**
    * Returns a range of all the push notifications devices where userId = &#63; and platform = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param platform the platform
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @return the range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU_P(
        long userId, java.lang.String platform, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU_P(userId, platform, start, end);
    }

    /**
    * Returns an ordered range of all the push notifications devices where userId = &#63; and platform = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param platform the platform
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU_P(
        long userId, java.lang.String platform, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByU_P(userId, platform, start, end, orderByComparator);
    }

    /**
    * Returns the first push notifications device in the ordered set where userId = &#63; and platform = &#63;.
    *
    * @param userId the user ID
    * @param platform the platform
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByU_P_First(
        long userId, java.lang.String platform,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence()
                   .findByU_P_First(userId, platform, orderByComparator);
    }

    /**
    * Returns the first push notifications device in the ordered set where userId = &#63; and platform = &#63;.
    *
    * @param userId the user ID
    * @param platform the platform
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByU_P_First(
        long userId, java.lang.String platform,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByU_P_First(userId, platform, orderByComparator);
    }

    /**
    * Returns the last push notifications device in the ordered set where userId = &#63; and platform = &#63;.
    *
    * @param userId the user ID
    * @param platform the platform
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByU_P_Last(
        long userId, java.lang.String platform,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence()
                   .findByU_P_Last(userId, platform, orderByComparator);
    }

    /**
    * Returns the last push notifications device in the ordered set where userId = &#63; and platform = &#63;.
    *
    * @param userId the user ID
    * @param platform the platform
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByU_P_Last(
        long userId, java.lang.String platform,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByU_P_Last(userId, platform, orderByComparator);
    }

    /**
    * Returns the push notifications devices before and after the current push notifications device in the ordered set where userId = &#63; and platform = &#63;.
    *
    * @param pushNotificationsDeviceId the primary key of the current push notifications device
    * @param userId the user ID
    * @param platform the platform
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice[] findByU_P_PrevAndNext(
        long pushNotificationsDeviceId, long userId, java.lang.String platform,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence()
                   .findByU_P_PrevAndNext(pushNotificationsDeviceId, userId,
            platform, orderByComparator);
    }

    /**
    * Returns all the push notifications devices where userId = any &#63; and platform = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userIds the user IDs
    * @param platform the platform
    * @return the matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU_P(
        long[] userIds, java.lang.String platform)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU_P(userIds, platform);
    }

    /**
    * Returns a range of all the push notifications devices where userId = any &#63; and platform = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userIds the user IDs
    * @param platform the platform
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @return the range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU_P(
        long[] userIds, java.lang.String platform, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU_P(userIds, platform, start, end);
    }

    /**
    * Returns an ordered range of all the push notifications devices where userId = any &#63; and platform = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userIds the user IDs
    * @param platform the platform
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU_P(
        long[] userIds, java.lang.String platform, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByU_P(userIds, platform, start, end, orderByComparator);
    }

    /**
    * Removes all the push notifications devices where userId = &#63; and platform = &#63; from the database.
    *
    * @param userId the user ID
    * @param platform the platform
    * @throws SystemException if a system exception occurred
    */
    public static void removeByU_P(long userId, java.lang.String platform)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByU_P(userId, platform);
    }

    /**
    * Returns the number of push notifications devices where userId = &#63; and platform = &#63;.
    *
    * @param userId the user ID
    * @param platform the platform
    * @return the number of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static int countByU_P(long userId, java.lang.String platform)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByU_P(userId, platform);
    }

    /**
    * Returns the number of push notifications devices where userId = any &#63; and platform = &#63;.
    *
    * @param userIds the user IDs
    * @param platform the platform
    * @return the number of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static int countByU_P(long[] userIds, java.lang.String platform)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByU_P(userIds, platform);
    }

    /**
    * Returns all the push notifications devices where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU(userId);
    }

    /**
    * Returns a range of all the push notifications devices where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @return the range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU(userId, start, end);
    }

    /**
    * Returns an ordered range of all the push notifications devices where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first push notifications device in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByU_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence().findByU_First(userId, orderByComparator);
    }

    /**
    * Returns the first push notifications device in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByU_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByU_First(userId, orderByComparator);
    }

    /**
    * Returns the last push notifications device in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByU_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence().findByU_Last(userId, orderByComparator);
    }

    /**
    * Returns the last push notifications device in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByU_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByU_Last(userId, orderByComparator);
    }

    /**
    * Returns the push notifications devices before and after the current push notifications device in the ordered set where userId = &#63;.
    *
    * @param pushNotificationsDeviceId the primary key of the current push notifications device
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice[] findByU_PrevAndNext(
        long pushNotificationsDeviceId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence()
                   .findByU_PrevAndNext(pushNotificationsDeviceId, userId,
            orderByComparator);
    }

    /**
    * Returns all the push notifications devices where userId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userIds the user IDs
    * @return the matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU(
        long[] userIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU(userIds);
    }

    /**
    * Returns a range of all the push notifications devices where userId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userIds the user IDs
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @return the range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU(
        long[] userIds, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU(userIds, start, end);
    }

    /**
    * Returns an ordered range of all the push notifications devices where userId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userIds the user IDs
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU(
        long[] userIds, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU(userIds, start, end, orderByComparator);
    }

    /**
    * Removes all the push notifications devices where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByU(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByU(userId);
    }

    /**
    * Returns the number of push notifications devices where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static int countByU(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByU(userId);
    }

    /**
    * Returns the number of push notifications devices where userId = any &#63;.
    *
    * @param userIds the user IDs
    * @return the number of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static int countByU(long[] userIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByU(userIds);
    }

    /**
    * Returns all the push notifications devices where userId = &#63; and appVersion = &#63;.
    *
    * @param userId the user ID
    * @param appVersion the app version
    * @return the matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU_AV(
        long userId, java.lang.String appVersion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU_AV(userId, appVersion);
    }

    /**
    * Returns a range of all the push notifications devices where userId = &#63; and appVersion = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param appVersion the app version
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @return the range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU_AV(
        long userId, java.lang.String appVersion, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU_AV(userId, appVersion, start, end);
    }

    /**
    * Returns an ordered range of all the push notifications devices where userId = &#63; and appVersion = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param appVersion the app version
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU_AV(
        long userId, java.lang.String appVersion, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByU_AV(userId, appVersion, start, end, orderByComparator);
    }

    /**
    * Returns the first push notifications device in the ordered set where userId = &#63; and appVersion = &#63;.
    *
    * @param userId the user ID
    * @param appVersion the app version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByU_AV_First(
        long userId, java.lang.String appVersion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence()
                   .findByU_AV_First(userId, appVersion, orderByComparator);
    }

    /**
    * Returns the first push notifications device in the ordered set where userId = &#63; and appVersion = &#63;.
    *
    * @param userId the user ID
    * @param appVersion the app version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByU_AV_First(
        long userId, java.lang.String appVersion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByU_AV_First(userId, appVersion, orderByComparator);
    }

    /**
    * Returns the last push notifications device in the ordered set where userId = &#63; and appVersion = &#63;.
    *
    * @param userId the user ID
    * @param appVersion the app version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByU_AV_Last(
        long userId, java.lang.String appVersion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence()
                   .findByU_AV_Last(userId, appVersion, orderByComparator);
    }

    /**
    * Returns the last push notifications device in the ordered set where userId = &#63; and appVersion = &#63;.
    *
    * @param userId the user ID
    * @param appVersion the app version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByU_AV_Last(
        long userId, java.lang.String appVersion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByU_AV_Last(userId, appVersion, orderByComparator);
    }

    /**
    * Returns the push notifications devices before and after the current push notifications device in the ordered set where userId = &#63; and appVersion = &#63;.
    *
    * @param pushNotificationsDeviceId the primary key of the current push notifications device
    * @param userId the user ID
    * @param appVersion the app version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice[] findByU_AV_PrevAndNext(
        long pushNotificationsDeviceId, long userId,
        java.lang.String appVersion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence()
                   .findByU_AV_PrevAndNext(pushNotificationsDeviceId, userId,
            appVersion, orderByComparator);
    }

    /**
    * Returns all the push notifications devices where userId = any &#63; and appVersion = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userIds the user IDs
    * @param appVersion the app version
    * @return the matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU_AV(
        long[] userIds, java.lang.String appVersion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU_AV(userIds, appVersion);
    }

    /**
    * Returns a range of all the push notifications devices where userId = any &#63; and appVersion = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userIds the user IDs
    * @param appVersion the app version
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @return the range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU_AV(
        long[] userIds, java.lang.String appVersion, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU_AV(userIds, appVersion, start, end);
    }

    /**
    * Returns an ordered range of all the push notifications devices where userId = any &#63; and appVersion = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userIds the user IDs
    * @param appVersion the app version
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByU_AV(
        long[] userIds, java.lang.String appVersion, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByU_AV(userIds, appVersion, start, end,
            orderByComparator);
    }

    /**
    * Removes all the push notifications devices where userId = &#63; and appVersion = &#63; from the database.
    *
    * @param userId the user ID
    * @param appVersion the app version
    * @throws SystemException if a system exception occurred
    */
    public static void removeByU_AV(long userId, java.lang.String appVersion)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByU_AV(userId, appVersion);
    }

    /**
    * Returns the number of push notifications devices where userId = &#63; and appVersion = &#63;.
    *
    * @param userId the user ID
    * @param appVersion the app version
    * @return the number of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static int countByU_AV(long userId, java.lang.String appVersion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByU_AV(userId, appVersion);
    }

    /**
    * Returns the number of push notifications devices where userId = any &#63; and appVersion = &#63;.
    *
    * @param userIds the user IDs
    * @param appVersion the app version
    * @return the number of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static int countByU_AV(long[] userIds, java.lang.String appVersion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByU_AV(userIds, appVersion);
    }

    /**
    * Returns all the push notifications devices where appVersion = &#63;.
    *
    * @param appVersion the app version
    * @return the matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByAppVersion(
        java.lang.String appVersion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAppVersion(appVersion);
    }

    /**
    * Returns a range of all the push notifications devices where appVersion = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param appVersion the app version
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @return the range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByAppVersion(
        java.lang.String appVersion, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAppVersion(appVersion, start, end);
    }

    /**
    * Returns an ordered range of all the push notifications devices where appVersion = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param appVersion the app version
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByAppVersion(
        java.lang.String appVersion, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAppVersion(appVersion, start, end, orderByComparator);
    }

    /**
    * Returns the first push notifications device in the ordered set where appVersion = &#63;.
    *
    * @param appVersion the app version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByAppVersion_First(
        java.lang.String appVersion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence()
                   .findByAppVersion_First(appVersion, orderByComparator);
    }

    /**
    * Returns the first push notifications device in the ordered set where appVersion = &#63;.
    *
    * @param appVersion the app version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByAppVersion_First(
        java.lang.String appVersion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAppVersion_First(appVersion, orderByComparator);
    }

    /**
    * Returns the last push notifications device in the ordered set where appVersion = &#63;.
    *
    * @param appVersion the app version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByAppVersion_Last(
        java.lang.String appVersion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence()
                   .findByAppVersion_Last(appVersion, orderByComparator);
    }

    /**
    * Returns the last push notifications device in the ordered set where appVersion = &#63;.
    *
    * @param appVersion the app version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByAppVersion_Last(
        java.lang.String appVersion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAppVersion_Last(appVersion, orderByComparator);
    }

    /**
    * Returns the push notifications devices before and after the current push notifications device in the ordered set where appVersion = &#63;.
    *
    * @param pushNotificationsDeviceId the primary key of the current push notifications device
    * @param appVersion the app version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice[] findByAppVersion_PrevAndNext(
        long pushNotificationsDeviceId, java.lang.String appVersion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence()
                   .findByAppVersion_PrevAndNext(pushNotificationsDeviceId,
            appVersion, orderByComparator);
    }

    /**
    * Removes all the push notifications devices where appVersion = &#63; from the database.
    *
    * @param appVersion the app version
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAppVersion(java.lang.String appVersion)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByAppVersion(appVersion);
    }

    /**
    * Returns the number of push notifications devices where appVersion = &#63;.
    *
    * @param appVersion the app version
    * @return the number of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static int countByAppVersion(java.lang.String appVersion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByAppVersion(appVersion);
    }

    /**
    * Returns all the push notifications devices where platform = &#63;.
    *
    * @param platform the platform
    * @return the matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByPlatform(
        java.lang.String platform)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPlatform(platform);
    }

    /**
    * Returns a range of all the push notifications devices where platform = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param platform the platform
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @return the range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByPlatform(
        java.lang.String platform, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPlatform(platform, start, end);
    }

    /**
    * Returns an ordered range of all the push notifications devices where platform = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param platform the platform
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByPlatform(
        java.lang.String platform, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPlatform(platform, start, end, orderByComparator);
    }

    /**
    * Returns the first push notifications device in the ordered set where platform = &#63;.
    *
    * @param platform the platform
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByPlatform_First(
        java.lang.String platform,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence().findByPlatform_First(platform, orderByComparator);
    }

    /**
    * Returns the first push notifications device in the ordered set where platform = &#63;.
    *
    * @param platform the platform
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByPlatform_First(
        java.lang.String platform,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPlatform_First(platform, orderByComparator);
    }

    /**
    * Returns the last push notifications device in the ordered set where platform = &#63;.
    *
    * @param platform the platform
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByPlatform_Last(
        java.lang.String platform,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence().findByPlatform_Last(platform, orderByComparator);
    }

    /**
    * Returns the last push notifications device in the ordered set where platform = &#63;.
    *
    * @param platform the platform
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByPlatform_Last(
        java.lang.String platform,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPlatform_Last(platform, orderByComparator);
    }

    /**
    * Returns the push notifications devices before and after the current push notifications device in the ordered set where platform = &#63;.
    *
    * @param pushNotificationsDeviceId the primary key of the current push notifications device
    * @param platform the platform
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice[] findByPlatform_PrevAndNext(
        long pushNotificationsDeviceId, java.lang.String platform,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence()
                   .findByPlatform_PrevAndNext(pushNotificationsDeviceId,
            platform, orderByComparator);
    }

    /**
    * Removes all the push notifications devices where platform = &#63; from the database.
    *
    * @param platform the platform
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPlatform(java.lang.String platform)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPlatform(platform);
    }

    /**
    * Returns the number of push notifications devices where platform = &#63;.
    *
    * @param platform the platform
    * @return the number of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static int countByPlatform(java.lang.String platform)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPlatform(platform);
    }

    /**
    * Returns all the push notifications devices where appId = &#63;.
    *
    * @param appId the app ID
    * @return the matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByAppId(
        long appId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAppId(appId);
    }

    /**
    * Returns a range of all the push notifications devices where appId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param appId the app ID
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @return the range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByAppId(
        long appId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAppId(appId, start, end);
    }

    /**
    * Returns an ordered range of all the push notifications devices where appId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param appId the app ID
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByAppId(
        long appId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAppId(appId, start, end, orderByComparator);
    }

    /**
    * Returns the first push notifications device in the ordered set where appId = &#63;.
    *
    * @param appId the app ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByAppId_First(
        long appId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence().findByAppId_First(appId, orderByComparator);
    }

    /**
    * Returns the first push notifications device in the ordered set where appId = &#63;.
    *
    * @param appId the app ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByAppId_First(
        long appId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByAppId_First(appId, orderByComparator);
    }

    /**
    * Returns the last push notifications device in the ordered set where appId = &#63;.
    *
    * @param appId the app ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByAppId_Last(
        long appId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence().findByAppId_Last(appId, orderByComparator);
    }

    /**
    * Returns the last push notifications device in the ordered set where appId = &#63;.
    *
    * @param appId the app ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByAppId_Last(
        long appId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByAppId_Last(appId, orderByComparator);
    }

    /**
    * Returns the push notifications devices before and after the current push notifications device in the ordered set where appId = &#63;.
    *
    * @param pushNotificationsDeviceId the primary key of the current push notifications device
    * @param appId the app ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice[] findByAppId_PrevAndNext(
        long pushNotificationsDeviceId, long appId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence()
                   .findByAppId_PrevAndNext(pushNotificationsDeviceId, appId,
            orderByComparator);
    }

    /**
    * Removes all the push notifications devices where appId = &#63; from the database.
    *
    * @param appId the app ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAppId(long appId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByAppId(appId);
    }

    /**
    * Returns the number of push notifications devices where appId = &#63;.
    *
    * @param appId the app ID
    * @return the number of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static int countByAppId(long appId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByAppId(appId);
    }

    /**
    * Returns all the push notifications devices where platform = &#63; and OSVersion = &#63;.
    *
    * @param platform the platform
    * @param OSVersion the o s version
    * @return the matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByP_OSV(
        java.lang.String platform, java.lang.String OSVersion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByP_OSV(platform, OSVersion);
    }

    /**
    * Returns a range of all the push notifications devices where platform = &#63; and OSVersion = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param platform the platform
    * @param OSVersion the o s version
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @return the range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByP_OSV(
        java.lang.String platform, java.lang.String OSVersion, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByP_OSV(platform, OSVersion, start, end);
    }

    /**
    * Returns an ordered range of all the push notifications devices where platform = &#63; and OSVersion = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param platform the platform
    * @param OSVersion the o s version
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findByP_OSV(
        java.lang.String platform, java.lang.String OSVersion, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByP_OSV(platform, OSVersion, start, end,
            orderByComparator);
    }

    /**
    * Returns the first push notifications device in the ordered set where platform = &#63; and OSVersion = &#63;.
    *
    * @param platform the platform
    * @param OSVersion the o s version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByP_OSV_First(
        java.lang.String platform, java.lang.String OSVersion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence()
                   .findByP_OSV_First(platform, OSVersion, orderByComparator);
    }

    /**
    * Returns the first push notifications device in the ordered set where platform = &#63; and OSVersion = &#63;.
    *
    * @param platform the platform
    * @param OSVersion the o s version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByP_OSV_First(
        java.lang.String platform, java.lang.String OSVersion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByP_OSV_First(platform, OSVersion, orderByComparator);
    }

    /**
    * Returns the last push notifications device in the ordered set where platform = &#63; and OSVersion = &#63;.
    *
    * @param platform the platform
    * @param OSVersion the o s version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByP_OSV_Last(
        java.lang.String platform, java.lang.String OSVersion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence()
                   .findByP_OSV_Last(platform, OSVersion, orderByComparator);
    }

    /**
    * Returns the last push notifications device in the ordered set where platform = &#63; and OSVersion = &#63;.
    *
    * @param platform the platform
    * @param OSVersion the o s version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByP_OSV_Last(
        java.lang.String platform, java.lang.String OSVersion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByP_OSV_Last(platform, OSVersion, orderByComparator);
    }

    /**
    * Returns the push notifications devices before and after the current push notifications device in the ordered set where platform = &#63; and OSVersion = &#63;.
    *
    * @param pushNotificationsDeviceId the primary key of the current push notifications device
    * @param platform the platform
    * @param OSVersion the o s version
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice[] findByP_OSV_PrevAndNext(
        long pushNotificationsDeviceId, java.lang.String platform,
        java.lang.String OSVersion,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence()
                   .findByP_OSV_PrevAndNext(pushNotificationsDeviceId,
            platform, OSVersion, orderByComparator);
    }

    /**
    * Removes all the push notifications devices where platform = &#63; and OSVersion = &#63; from the database.
    *
    * @param platform the platform
    * @param OSVersion the o s version
    * @throws SystemException if a system exception occurred
    */
    public static void removeByP_OSV(java.lang.String platform,
        java.lang.String OSVersion)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByP_OSV(platform, OSVersion);
    }

    /**
    * Returns the number of push notifications devices where platform = &#63; and OSVersion = &#63;.
    *
    * @param platform the platform
    * @param OSVersion the o s version
    * @return the number of matching push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static int countByP_OSV(java.lang.String platform,
        java.lang.String OSVersion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByP_OSV(platform, OSVersion);
    }

    /**
    * Caches the push notifications device in the entity cache if it is enabled.
    *
    * @param pushNotificationsDevice the push notifications device
    */
    public static void cacheResult(
        com.liferay.pushnotifications.model.PushNotificationsDevice pushNotificationsDevice) {
        getPersistence().cacheResult(pushNotificationsDevice);
    }

    /**
    * Caches the push notifications devices in the entity cache if it is enabled.
    *
    * @param pushNotificationsDevices the push notifications devices
    */
    public static void cacheResult(
        java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> pushNotificationsDevices) {
        getPersistence().cacheResult(pushNotificationsDevices);
    }

    /**
    * Creates a new push notifications device with the primary key. Does not add the push notifications device to the database.
    *
    * @param pushNotificationsDeviceId the primary key for the new push notifications device
    * @return the new push notifications device
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice create(
        long pushNotificationsDeviceId) {
        return getPersistence().create(pushNotificationsDeviceId);
    }

    /**
    * Removes the push notifications device with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param pushNotificationsDeviceId the primary key of the push notifications device
    * @return the push notifications device that was removed
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice remove(
        long pushNotificationsDeviceId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence().remove(pushNotificationsDeviceId);
    }

    public static com.liferay.pushnotifications.model.PushNotificationsDevice updateImpl(
        com.liferay.pushnotifications.model.PushNotificationsDevice pushNotificationsDevice)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(pushNotificationsDevice);
    }

    /**
    * Returns the push notifications device with the primary key or throws a {@link com.liferay.pushnotifications.NoSuchDeviceException} if it could not be found.
    *
    * @param pushNotificationsDeviceId the primary key of the push notifications device
    * @return the push notifications device
    * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice findByPrimaryKey(
        long pushNotificationsDeviceId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchDeviceException {
        return getPersistence().findByPrimaryKey(pushNotificationsDeviceId);
    }

    /**
    * Returns the push notifications device with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param pushNotificationsDeviceId the primary key of the push notifications device
    * @return the push notifications device, or <code>null</code> if a push notifications device with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchByPrimaryKey(
        long pushNotificationsDeviceId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(pushNotificationsDeviceId);
    }

    /**
    * Returns all the push notifications devices.
    *
    * @return the push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the push notifications devices.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @return the range of push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the push notifications devices.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of push notifications devices
    * @param end the upper bound of the range of push notifications devices (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the push notifications devices from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of push notifications devices.
    *
    * @return the number of push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static PushNotificationsDevicePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (PushNotificationsDevicePersistence) PortletBeanLocatorUtil.locate(com.liferay.pushnotifications.service.ClpSerializer.getServletContextName(),
                    PushNotificationsDevicePersistence.class.getName());

            ReferenceRegistry.registerReference(PushNotificationsDeviceUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(PushNotificationsDevicePersistence persistence) {
    }
}
