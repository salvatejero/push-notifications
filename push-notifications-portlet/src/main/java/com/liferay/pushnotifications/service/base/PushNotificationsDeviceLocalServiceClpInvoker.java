package com.liferay.pushnotifications.service.base;

import com.liferay.pushnotifications.service.PushNotificationsDeviceLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Bruno Farache
 * @generated
 */
public class PushNotificationsDeviceLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName42;
    private String[] _methodParameterTypes42;
    private String _methodName43;
    private String[] _methodParameterTypes43;
    private String _methodName48;
    private String[] _methodParameterTypes48;
    private String _methodName49;
    private String[] _methodParameterTypes49;
    private String _methodName50;
    private String[] _methodParameterTypes50;
    private String _methodName51;
    private String[] _methodParameterTypes51;
    private String _methodName52;
    private String[] _methodParameterTypes52;
    private String _methodName53;
    private String[] _methodParameterTypes53;
    private String _methodName54;
    private String[] _methodParameterTypes54;
    private String _methodName55;
    private String[] _methodParameterTypes55;
    private String _methodName56;
    private String[] _methodParameterTypes56;

    public PushNotificationsDeviceLocalServiceClpInvoker() {
        _methodName0 = "addPushNotificationsDevice";

        _methodParameterTypes0 = new String[] {
                "com.liferay.pushnotifications.model.PushNotificationsDevice"
            };

        _methodName1 = "createPushNotificationsDevice";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deletePushNotificationsDevice";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deletePushNotificationsDevice";

        _methodParameterTypes3 = new String[] {
                "com.liferay.pushnotifications.model.PushNotificationsDevice"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchPushNotificationsDevice";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPushNotificationsDevice";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getPushNotificationsDevices";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getPushNotificationsDevicesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updatePushNotificationsDevice";

        _methodParameterTypes15 = new String[] {
                "com.liferay.pushnotifications.model.PushNotificationsDevice"
            };

        _methodName42 = "getBeanIdentifier";

        _methodParameterTypes42 = new String[] {  };

        _methodName43 = "setBeanIdentifier";

        _methodParameterTypes43 = new String[] { "java.lang.String" };

        _methodName48 = "addPushNotificationsDevice";

        _methodParameterTypes48 = new String[] {
                "long", "java.lang.String", "java.lang.String"
            };

        _methodName49 = "getPushNotificationsDeviceByComparator";

        _methodParameterTypes49 = new String[] {
                "int", "int", "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName50 = "getUserDevices";

        _methodParameterTypes50 = new String[] { "long", "int", "int" };

        _methodName51 = "getUserDevicesCount";

        _methodParameterTypes51 = new String[] { "long" };

        _methodName52 = "addPushNotificationsDevice";

        _methodParameterTypes52 = new String[] {
                "long", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "long",
                "java.lang.String"
            };

        _methodName53 = "deletePushNotificationsDevice";

        _methodParameterTypes53 = new String[] { "java.lang.String" };

        _methodName54 = "resetPushNotificationSenders";

        _methodParameterTypes54 = new String[] {  };

        _methodName55 = "sendPushNotification";

        _methodParameterTypes55 = new String[] {
                "long[][]", "com.liferay.portal.kernel.json.JSONObject"
            };

        _methodName56 = "sendPushNotification";

        _methodParameterTypes56 = new String[] {
                "java.lang.String", "java.util.List",
                "com.liferay.portal.kernel.json.JSONObject"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.addPushNotificationsDevice((com.liferay.pushnotifications.model.PushNotificationsDevice) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.createPushNotificationsDevice(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.deletePushNotificationsDevice(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.deletePushNotificationsDevice((com.liferay.pushnotifications.model.PushNotificationsDevice) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.fetchPushNotificationsDevice(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.getPushNotificationsDevice(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.getPushNotificationsDevices(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.getPushNotificationsDevicesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.updatePushNotificationsDevice((com.liferay.pushnotifications.model.PushNotificationsDevice) arguments[0]);
        }

        if (_methodName42.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName43.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
            PushNotificationsDeviceLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName48.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.addPushNotificationsDevice(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1], (java.lang.String) arguments[2]);
        }

        if (_methodName49.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.getPushNotificationsDeviceByComparator(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[2]);
        }

        if (_methodName50.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.getUserDevices(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName51.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.getUserDevicesCount(((Long) arguments[0]).longValue());
        }

        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.addPushNotificationsDevice(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                ((Long) arguments[5]).longValue(),
                (java.lang.String) arguments[6]);
        }

        if (_methodName53.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
            return PushNotificationsDeviceLocalServiceUtil.deletePushNotificationsDevice((java.lang.String) arguments[0]);
        }

        if (_methodName54.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
            PushNotificationsDeviceLocalServiceUtil.resetPushNotificationSenders();

            return null;
        }

        if (_methodName55.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
            PushNotificationsDeviceLocalServiceUtil.sendPushNotification((long[]) arguments[0],
                (com.liferay.portal.kernel.json.JSONObject) arguments[1]);

            return null;
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            PushNotificationsDeviceLocalServiceUtil.sendPushNotification((java.lang.String) arguments[0],
                (java.util.List<java.lang.String>) arguments[1],
                (com.liferay.portal.kernel.json.JSONObject) arguments[2]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
