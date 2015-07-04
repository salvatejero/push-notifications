package com.liferay.pushnotifications.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for PushNotificationsDevice. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Bruno Farache
 * @see PushNotificationsDeviceServiceUtil
 * @see com.liferay.pushnotifications.service.base.PushNotificationsDeviceServiceBaseImpl
 * @see com.liferay.pushnotifications.service.impl.PushNotificationsDeviceServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PushNotificationsDeviceService extends BaseService,
    InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PushNotificationsDeviceServiceUtil} to access the push notifications device remote service. Add custom service methods to {@link com.liferay.pushnotifications.service.impl.PushNotificationsDeviceServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

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

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public com.liferay.pushnotifications.model.PushNotificationsDevice addPushNotificationsDevice(
        java.lang.String token, java.lang.String platform)
        throws com.liferay.portal.kernel.exception.PortalException;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public com.liferay.pushnotifications.model.PushNotificationsDevice addPushNotificationsDevice(
        java.lang.String token, java.lang.String platform,
        java.lang.String model, java.lang.String osVersion, long appId,
        java.lang.String appVersion)
        throws com.liferay.portal.kernel.exception.PortalException;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public com.liferay.pushnotifications.model.PushNotificationsDevice deletePushNotificationsDevice(
        java.lang.String token)
        throws com.liferay.portal.kernel.exception.PortalException;

    public void sendPushNotification(long[] toUserIds, java.lang.String payload)
        throws com.liferay.portal.kernel.exception.PortalException;

    public void sendPushNotification(java.lang.String platform,
        java.util.List<java.lang.String> tokens, java.lang.String payload)
        throws com.liferay.portal.kernel.exception.PortalException;
}
