package com.liferay.pushnotifications.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.pushnotifications.service.PushNotificationsDeviceServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.pushnotifications.service.PushNotificationsDeviceServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.pushnotifications.model.PushNotificationsDeviceSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.pushnotifications.model.PushNotificationsDevice}, that is translated to a
 * {@link com.liferay.pushnotifications.model.PushNotificationsDeviceSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Bruno Farache
 * @see PushNotificationsDeviceServiceHttp
 * @see com.liferay.pushnotifications.model.PushNotificationsDeviceSoap
 * @see com.liferay.pushnotifications.service.PushNotificationsDeviceServiceUtil
 * @generated
 */
public class PushNotificationsDeviceServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(PushNotificationsDeviceServiceSoap.class);

    public static com.liferay.pushnotifications.model.PushNotificationsDeviceSoap addPushNotificationsDevice(
        java.lang.String token, java.lang.String platform)
        throws RemoteException {
        try {
            com.liferay.pushnotifications.model.PushNotificationsDevice returnValue =
                PushNotificationsDeviceServiceUtil.addPushNotificationsDevice(token,
                    platform);

            return com.liferay.pushnotifications.model.PushNotificationsDeviceSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.pushnotifications.model.PushNotificationsDeviceSoap deletePushNotificationsDevice(
        java.lang.String token) throws RemoteException {
        try {
            com.liferay.pushnotifications.model.PushNotificationsDevice returnValue =
                PushNotificationsDeviceServiceUtil.deletePushNotificationsDevice(token);

            return com.liferay.pushnotifications.model.PushNotificationsDeviceSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void sendPushNotification(long[] toUserIds,
        java.lang.String payload) throws RemoteException {
        try {
            PushNotificationsDeviceServiceUtil.sendPushNotification(toUserIds,
                payload);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void sendPushNotification(java.lang.String platform,
        java.util.List<java.lang.String> tokens, java.lang.String payload)
        throws RemoteException {
        try {
            PushNotificationsDeviceServiceUtil.sendPushNotification(platform,
                tokens, payload);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
