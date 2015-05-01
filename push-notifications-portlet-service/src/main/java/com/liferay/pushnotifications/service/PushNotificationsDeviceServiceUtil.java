package com.liferay.pushnotifications.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for PushNotificationsDevice. This utility wraps
 * {@link com.liferay.pushnotifications.service.impl.PushNotificationsDeviceServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Bruno Farache
 * @see PushNotificationsDeviceService
 * @see com.liferay.pushnotifications.service.base.PushNotificationsDeviceServiceBaseImpl
 * @see com.liferay.pushnotifications.service.impl.PushNotificationsDeviceServiceImpl
 * @generated
 */
public class PushNotificationsDeviceServiceUtil {
    private static PushNotificationsDeviceService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.pushnotifications.service.impl.PushNotificationsDeviceServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

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
        java.lang.String token, java.lang.String platform)
        throws com.liferay.portal.kernel.exception.PortalException {
        return getService().addPushNotificationsDevice(token, platform);
    }

    public static com.liferay.pushnotifications.model.PushNotificationsDevice addPushNotificationsDevice(
        java.lang.String token, java.lang.String platform,
        java.lang.String model, java.lang.String osVersion,
        java.lang.String appVersion)
        throws com.liferay.portal.kernel.exception.PortalException {
        return getService()
                   .addPushNotificationsDevice(token, platform, model,
            osVersion, appVersion);
    }

    public static com.liferay.pushnotifications.model.PushNotificationsDevice deletePushNotificationsDevice(
        java.lang.String token)
        throws com.liferay.portal.kernel.exception.PortalException {
        return getService().deletePushNotificationsDevice(token);
    }

    public static void sendPushNotification(long[] toUserIds,
        java.lang.String payload)
        throws com.liferay.portal.kernel.exception.PortalException {
        getService().sendPushNotification(toUserIds, payload);
    }

    public static void sendPushNotification(java.lang.String platform,
        java.util.List<java.lang.String> tokens, java.lang.String payload)
        throws com.liferay.portal.kernel.exception.PortalException {
        getService().sendPushNotification(platform, tokens, payload);
    }

    public static void clearService() {
        _service = null;
    }

    public static PushNotificationsDeviceService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PushNotificationsDeviceService.class.getName());

            if (invokableService instanceof PushNotificationsDeviceService) {
                _service = (PushNotificationsDeviceService) invokableService;
            } else {
                _service = new PushNotificationsDeviceServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(PushNotificationsDeviceServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(PushNotificationsDeviceService service) {
    }
}
