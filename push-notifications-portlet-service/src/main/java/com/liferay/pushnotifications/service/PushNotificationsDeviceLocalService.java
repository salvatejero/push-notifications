package com.liferay.pushnotifications.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for PushNotificationsDevice. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Bruno Farache
 * @see PushNotificationsDeviceLocalServiceUtil
 * @see com.liferay.pushnotifications.service.base.PushNotificationsDeviceLocalServiceBaseImpl
 * @see com.liferay.pushnotifications.service.impl.PushNotificationsDeviceLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PushNotificationsDeviceLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PushNotificationsDeviceLocalServiceUtil} to access the push notifications device local service. Add custom service methods to {@link com.liferay.pushnotifications.service.impl.PushNotificationsDeviceLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the push notifications device to the database. Also notifies the appropriate model listeners.
    *
    * @param pushNotificationsDevice the push notifications device
    * @return the push notifications device that was added
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.liferay.pushnotifications.model.PushNotificationsDevice addPushNotificationsDevice(
        com.liferay.pushnotifications.model.PushNotificationsDevice pushNotificationsDevice)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new push notifications device with the primary key. Does not add the push notifications device to the database.
    *
    * @param pushNotificationsDeviceId the primary key for the new push notifications device
    * @return the new push notifications device
    */
    public com.liferay.pushnotifications.model.PushNotificationsDevice createPushNotificationsDevice(
        long pushNotificationsDeviceId);

    /**
    * Deletes the push notifications device with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param pushNotificationsDeviceId the primary key of the push notifications device
    * @return the push notifications device that was removed
    * @throws PortalException if a push notifications device with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.liferay.pushnotifications.model.PushNotificationsDevice deletePushNotificationsDevice(
        long pushNotificationsDeviceId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the push notifications device from the database. Also notifies the appropriate model listeners.
    *
    * @param pushNotificationsDevice the push notifications device
    * @return the push notifications device that was removed
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
    public com.liferay.pushnotifications.model.PushNotificationsDevice deletePushNotificationsDevice(
        com.liferay.pushnotifications.model.PushNotificationsDevice pushNotificationsDevice)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.pushnotifications.model.PushNotificationsDevice fetchPushNotificationsDevice(
        long pushNotificationsDeviceId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the push notifications device with the primary key.
    *
    * @param pushNotificationsDeviceId the primary key of the push notifications device
    * @return the push notifications device
    * @throws PortalException if a push notifications device with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.pushnotifications.model.PushNotificationsDevice getPushNotificationsDevice(
        long pushNotificationsDeviceId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> getPushNotificationsDevices(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of push notifications devices.
    *
    * @return the number of push notifications devices
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPushNotificationsDevicesCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the push notifications device in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param pushNotificationsDevice the push notifications device
    * @return the push notifications device that was updated
    * @throws SystemException if a system exception occurred
    */
    @com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
    public com.liferay.pushnotifications.model.PushNotificationsDevice updatePushNotificationsDevice(
        com.liferay.pushnotifications.model.PushNotificationsDevice pushNotificationsDevice)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public com.liferay.pushnotifications.model.PushNotificationsDevice addPushNotificationsDevice(
        long userId, java.lang.String platform, java.lang.String token);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> getPushNotificationsDeviceByComparator(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> getUserDevices(
        long userId, int start, int end);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getUserDevicesCount(long userId);

    public com.liferay.pushnotifications.model.PushNotificationsDevice addPushNotificationsDevice(
        long userId, java.lang.String platform, java.lang.String token,
        java.lang.String model, java.lang.String version, long appId,
        java.lang.String appVersion);

    public com.liferay.pushnotifications.model.PushNotificationsDevice deletePushNotificationsDevice(
        java.lang.String token)
        throws com.liferay.portal.kernel.exception.PortalException;

    public void resetPushNotificationSenders();

    public void sendPushNotification(long[] toUserIds,
        com.liferay.portal.kernel.json.JSONObject payloadJSONObject)
        throws com.liferay.portal.kernel.exception.PortalException;

    public void sendPushNotification(java.lang.String platform,
        java.util.List<java.lang.String> tokens,
        com.liferay.portal.kernel.json.JSONObject payloadJSONObject)
        throws com.liferay.portal.kernel.exception.PortalException;
}
