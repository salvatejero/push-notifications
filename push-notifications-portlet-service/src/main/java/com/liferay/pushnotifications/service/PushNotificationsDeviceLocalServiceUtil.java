package com.liferay.pushnotifications.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for PushNotificationsDevice. This utility wraps
 * {@link com.liferay.pushnotifications.service.impl.PushNotificationsDeviceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Bruno Farache
 * @see PushNotificationsDeviceLocalService
 * @see com.liferay.pushnotifications.service.base.PushNotificationsDeviceLocalServiceBaseImpl
 * @see com.liferay.pushnotifications.service.impl.PushNotificationsDeviceLocalServiceImpl
 * @generated
 */
public class PushNotificationsDeviceLocalServiceUtil {
    private static PushNotificationsDeviceLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.pushnotifications.service.impl.PushNotificationsDeviceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the push notifications device to the database. Also notifies the appropriate model listeners.
    *
    * @param pushNotificationsDevice the push notifications device
    * @return the push notifications device that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice addPushNotificationsDevice(
        com.liferay.pushnotifications.model.PushNotificationsDevice pushNotificationsDevice)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addPushNotificationsDevice(pushNotificationsDevice);
    }

    /**
    * Creates a new push notifications device with the primary key. Does not add the push notifications device to the database.
    *
    * @param pushNotificationsDeviceId the primary key for the new push notifications device
    * @return the new push notifications device
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice createPushNotificationsDevice(
        long pushNotificationsDeviceId) {
        return getService()
                   .createPushNotificationsDevice(pushNotificationsDeviceId);
    }

    /**
    * Deletes the push notifications device with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param pushNotificationsDeviceId the primary key of the push notifications device
    * @return the push notifications device that was removed
    * @throws PortalException if a push notifications device with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice deletePushNotificationsDevice(
        long pushNotificationsDeviceId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .deletePushNotificationsDevice(pushNotificationsDeviceId);
    }

    /**
    * Deletes the push notifications device from the database. Also notifies the appropriate model listeners.
    *
    * @param pushNotificationsDevice the push notifications device
    * @return the push notifications device that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice deletePushNotificationsDevice(
        com.liferay.pushnotifications.model.PushNotificationsDevice pushNotificationsDevice)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .deletePushNotificationsDevice(pushNotificationsDevice);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

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

    public static com.liferay.pushnotifications.model.PushNotificationsDevice fetchPushNotificationsDevice(
        long pushNotificationsDeviceId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .fetchPushNotificationsDevice(pushNotificationsDeviceId);
    }

    /**
    * Returns the push notifications device with the primary key.
    *
    * @param pushNotificationsDeviceId the primary key of the push notifications device
    * @return the push notifications device
    * @throws PortalException if a push notifications device with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice getPushNotificationsDevice(
        long pushNotificationsDeviceId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPushNotificationsDevice(pushNotificationsDeviceId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> getPushNotificationsDevices(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPushNotificationsDevices(start, end);
    }

    /**
    * Returns the number of push notifications devices.
    *
    * @return the number of push notifications devices
    * @throws SystemException if a system exception occurred
    */
    public static int getPushNotificationsDevicesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPushNotificationsDevicesCount();
    }

    /**
    * Updates the push notifications device in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param pushNotificationsDevice the push notifications device
    * @return the push notifications device that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.PushNotificationsDevice updatePushNotificationsDevice(
        com.liferay.pushnotifications.model.PushNotificationsDevice pushNotificationsDevice)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updatePushNotificationsDevice(pushNotificationsDevice);
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

    public static com.liferay.pushnotifications.model.PushNotificationsDevice addPushNotificationsDevice(
        long userId, java.lang.String platform, java.lang.String token) {
        return getService().addPushNotificationsDevice(userId, platform, token);
    }

    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> getPushNotificationsDeviceByComparator(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
        return getService()
                   .getPushNotificationsDeviceByComparator(start, end,
            orderByComparator);
    }

    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> getPushNotificationsDeviceByAppIdByComparator(
        long appId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
        return getService()
                   .getPushNotificationsDeviceByAppIdByComparator(appId, start,
            end, orderByComparator);
    }

    public static java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> getUserDevices(
        long userId, int start, int end) {
        return getService().getUserDevices(userId, start, end);
    }

    public static int getUserDevicesCount(long userId) {
        return getService().getUserDevicesCount(userId);
    }

    public static int getAppDevicesCount(long appId) {
        return getService().getAppDevicesCount(appId);
    }

    public static com.liferay.pushnotifications.model.PushNotificationsDevice addPushNotificationsDevice(
        long userId, java.lang.String platform, java.lang.String token,
        java.lang.String model, java.lang.String version, long appId,
        java.lang.String appVersion) {
        return getService()
                   .addPushNotificationsDevice(userId, platform, token, model,
            version, appId, appVersion);
    }

    public static com.liferay.pushnotifications.model.PushNotificationsDevice deletePushNotificationsDevice(
        java.lang.String token)
        throws com.liferay.portal.kernel.exception.PortalException {
        return getService().deletePushNotificationsDevice(token);
    }

    public static void resetPushNotificationSenders() {
        getService().resetPushNotificationSenders();
    }

    public static void sendPushNotification(long[] toUserIds,
        com.liferay.portal.kernel.json.JSONObject payloadJSONObject)
        throws com.liferay.portal.kernel.exception.PortalException {
        getService().sendPushNotification(toUserIds, payloadJSONObject);
    }

    public static void sendPushNotification(
        com.liferay.pushnotifications.sender.PushNotificationsSender pushNotificationsSender,
        java.lang.String platform,
        java.util.List<com.liferay.pushnotifications.model.PushNotificationsDevice> devices,
        com.liferay.portal.kernel.json.JSONObject payloadJSONObject)
        throws com.liferay.portal.kernel.exception.PortalException {
        getService()
            .sendPushNotification(pushNotificationsSender, platform, devices,
            payloadJSONObject);
    }

    public static void sendPushNotification(java.lang.String platform,
        java.util.List<java.lang.String> tokens,
        com.liferay.portal.kernel.json.JSONObject payloadJSONObject)
        throws com.liferay.portal.kernel.exception.PortalException {
        getService().sendPushNotification(platform, tokens, payloadJSONObject);
    }

    public static void clearService() {
        _service = null;
    }

    public static PushNotificationsDeviceLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PushNotificationsDeviceLocalService.class.getName());

            if (invokableLocalService instanceof PushNotificationsDeviceLocalService) {
                _service = (PushNotificationsDeviceLocalService) invokableLocalService;
            } else {
                _service = new PushNotificationsDeviceLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(PushNotificationsDeviceLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(PushNotificationsDeviceLocalService service) {
    }
}
