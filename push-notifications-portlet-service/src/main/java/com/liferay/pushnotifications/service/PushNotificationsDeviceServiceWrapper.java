package com.liferay.pushnotifications.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PushNotificationsDeviceService}.
 *
 * @author Bruno Farache
 * @see PushNotificationsDeviceService
 * @generated
 */
public class PushNotificationsDeviceServiceWrapper
    implements PushNotificationsDeviceService,
        ServiceWrapper<PushNotificationsDeviceService> {
    private PushNotificationsDeviceService _pushNotificationsDeviceService;

    public PushNotificationsDeviceServiceWrapper(
        PushNotificationsDeviceService pushNotificationsDeviceService) {
        _pushNotificationsDeviceService = pushNotificationsDeviceService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _pushNotificationsDeviceService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _pushNotificationsDeviceService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _pushNotificationsDeviceService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.liferay.pushnotifications.model.PushNotificationsDevice addPushNotificationsDevice(
        java.lang.String token, java.lang.String platform)
        throws com.liferay.portal.kernel.exception.PortalException {
        return _pushNotificationsDeviceService.addPushNotificationsDevice(token,
            platform);
    }

    @Override
    public com.liferay.pushnotifications.model.PushNotificationsDevice deletePushNotificationsDevice(
        java.lang.String token)
        throws com.liferay.portal.kernel.exception.PortalException {
        return _pushNotificationsDeviceService.deletePushNotificationsDevice(token);
    }

    @Override
    public void sendPushNotification(long[] toUserIds, java.lang.String payload)
        throws com.liferay.portal.kernel.exception.PortalException {
        _pushNotificationsDeviceService.sendPushNotification(toUserIds, payload);
    }

    @Override
    public void sendPushNotification(java.lang.String platform,
        java.util.List<java.lang.String> tokens, java.lang.String payload)
        throws com.liferay.portal.kernel.exception.PortalException {
        _pushNotificationsDeviceService.sendPushNotification(platform, tokens,
            payload);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public PushNotificationsDeviceService getWrappedPushNotificationsDeviceService() {
        return _pushNotificationsDeviceService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedPushNotificationsDeviceService(
        PushNotificationsDeviceService pushNotificationsDeviceService) {
        _pushNotificationsDeviceService = pushNotificationsDeviceService;
    }

    @Override
    public PushNotificationsDeviceService getWrappedService() {
        return _pushNotificationsDeviceService;
    }

    @Override
    public void setWrappedService(
        PushNotificationsDeviceService pushNotificationsDeviceService) {
        _pushNotificationsDeviceService = pushNotificationsDeviceService;
    }
}
