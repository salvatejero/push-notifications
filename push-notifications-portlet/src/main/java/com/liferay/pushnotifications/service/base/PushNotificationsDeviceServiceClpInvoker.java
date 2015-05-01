package com.liferay.pushnotifications.service.base;

import com.liferay.pushnotifications.service.PushNotificationsDeviceServiceUtil;

import java.util.Arrays;

/**
 * @author Bruno Farache
 * @generated
 */
public class PushNotificationsDeviceServiceClpInvoker {
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;
    private String _methodName26;
    private String[] _methodParameterTypes26;
    private String _methodName27;
    private String[] _methodParameterTypes27;
    private String _methodName28;
    private String[] _methodParameterTypes28;

    public PushNotificationsDeviceServiceClpInvoker() {
        _methodName18 = "getBeanIdentifier";

        _methodParameterTypes18 = new String[] {  };

        _methodName19 = "setBeanIdentifier";

        _methodParameterTypes19 = new String[] { "java.lang.String" };

        _methodName24 = "addPushNotificationsDevice";

        _methodParameterTypes24 = new String[] {
                "java.lang.String", "java.lang.String"
            };

        _methodName25 = "addPushNotificationsDevice";

        _methodParameterTypes25 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String"
            };

        _methodName26 = "deletePushNotificationsDevice";

        _methodParameterTypes26 = new String[] { "java.lang.String" };

        _methodName27 = "sendPushNotification";

        _methodParameterTypes27 = new String[] { "long[][]", "java.lang.String" };

        _methodName28 = "sendPushNotification";

        _methodParameterTypes28 = new String[] {
                "java.lang.String", "java.util.List", "java.lang.String"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            return PushNotificationsDeviceServiceUtil.getBeanIdentifier();
        }

        if (_methodName19.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
            PushNotificationsDeviceServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            return PushNotificationsDeviceServiceUtil.addPushNotificationsDevice((java.lang.String) arguments[0],
                (java.lang.String) arguments[1]);
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            return PushNotificationsDeviceServiceUtil.addPushNotificationsDevice((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3], (java.lang.String) arguments[4]);
        }

        if (_methodName26.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
            return PushNotificationsDeviceServiceUtil.deletePushNotificationsDevice((java.lang.String) arguments[0]);
        }

        if (_methodName27.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
            PushNotificationsDeviceServiceUtil.sendPushNotification((long[]) arguments[0],
                (java.lang.String) arguments[1]);

            return null;
        }

        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            PushNotificationsDeviceServiceUtil.sendPushNotification((java.lang.String) arguments[0],
                (java.util.List<java.lang.String>) arguments[1],
                (java.lang.String) arguments[2]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
