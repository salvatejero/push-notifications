package com.liferay.pushnotifications.service.base;

import com.liferay.pushnotifications.service.PushNotificationsDeviceServiceUtil;

import java.util.Arrays;

/**
 * @author Bruno Farache
 * @generated
 */
public class PushNotificationsDeviceServiceClpInvoker {
    private String _methodName26;
    private String[] _methodParameterTypes26;
    private String _methodName27;
    private String[] _methodParameterTypes27;
    private String _methodName32;
    private String[] _methodParameterTypes32;
    private String _methodName33;
    private String[] _methodParameterTypes33;
    private String _methodName34;
    private String[] _methodParameterTypes34;
    private String _methodName35;
    private String[] _methodParameterTypes35;
    private String _methodName36;
    private String[] _methodParameterTypes36;

    public PushNotificationsDeviceServiceClpInvoker() {
        _methodName26 = "getBeanIdentifier";

        _methodParameterTypes26 = new String[] {  };

        _methodName27 = "setBeanIdentifier";

        _methodParameterTypes27 = new String[] { "java.lang.String" };

        _methodName32 = "addPushNotificationsDevice";

        _methodParameterTypes32 = new String[] {
                "java.lang.String", "java.lang.String"
            };

        _methodName33 = "addPushNotificationsDevice";

        _methodParameterTypes33 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "long", "java.lang.String"
            };

        _methodName34 = "deletePushNotificationsDevice";

        _methodParameterTypes34 = new String[] { "java.lang.String" };

        _methodName35 = "sendPushNotification";

        _methodParameterTypes35 = new String[] { "long[][]", "java.lang.String" };

        _methodName36 = "sendPushNotification";

        _methodParameterTypes36 = new String[] {
                "java.lang.String", "java.util.List", "java.lang.String"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName26.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
            return PushNotificationsDeviceServiceUtil.getBeanIdentifier();
        }

        if (_methodName27.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
            PushNotificationsDeviceServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName32.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
            return PushNotificationsDeviceServiceUtil.addPushNotificationsDevice((java.lang.String) arguments[0],
                (java.lang.String) arguments[1]);
        }

        if (_methodName33.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
            return PushNotificationsDeviceServiceUtil.addPushNotificationsDevice((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                ((Long) arguments[4]).longValue(),
                (java.lang.String) arguments[5]);
        }

        if (_methodName34.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
            return PushNotificationsDeviceServiceUtil.deletePushNotificationsDevice((java.lang.String) arguments[0]);
        }

        if (_methodName35.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
            PushNotificationsDeviceServiceUtil.sendPushNotification((long[]) arguments[0],
                (java.lang.String) arguments[1]);

            return null;
        }

        if (_methodName36.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
            PushNotificationsDeviceServiceUtil.sendPushNotification((java.lang.String) arguments[0],
                (java.util.List<java.lang.String>) arguments[1],
                (java.lang.String) arguments[2]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
