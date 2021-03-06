package com.liferay.pushnotifications.service.base;

import com.liferay.pushnotifications.service.ApplicationPreferencesLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Bruno Farache
 * @generated
 */
public class ApplicationPreferencesLocalServiceClpInvoker {
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
    private String _methodName46;
    private String[] _methodParameterTypes46;
    private String _methodName47;
    private String[] _methodParameterTypes47;
    private String _methodName52;
    private String[] _methodParameterTypes52;
    private String _methodName53;
    private String[] _methodParameterTypes53;

    public ApplicationPreferencesLocalServiceClpInvoker() {
        _methodName0 = "addApplicationPreferences";

        _methodParameterTypes0 = new String[] {
                "com.liferay.pushnotifications.model.ApplicationPreferences"
            };

        _methodName1 = "createApplicationPreferences";

        _methodParameterTypes1 = new String[] {
                "com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK"
            };

        _methodName2 = "deleteApplicationPreferences";

        _methodParameterTypes2 = new String[] {
                "com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK"
            };

        _methodName3 = "deleteApplicationPreferences";

        _methodParameterTypes3 = new String[] {
                "com.liferay.pushnotifications.model.ApplicationPreferences"
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

        _methodName10 = "fetchApplicationPreferences";

        _methodParameterTypes10 = new String[] {
                "com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK"
            };

        _methodName11 = "getApplicationPreferences";

        _methodParameterTypes11 = new String[] {
                "com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK"
            };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getApplicationPreferenceses";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getApplicationPreferencesesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateApplicationPreferences";

        _methodParameterTypes15 = new String[] {
                "com.liferay.pushnotifications.model.ApplicationPreferences"
            };

        _methodName46 = "getBeanIdentifier";

        _methodParameterTypes46 = new String[] {  };

        _methodName47 = "setBeanIdentifier";

        _methodParameterTypes47 = new String[] { "java.lang.String" };

        _methodName52 = "findApplicationPreferenceByApplicationId";

        _methodParameterTypes52 = new String[] { "long" };

        _methodName53 = "addApplicationPreferences";

        _methodParameterTypes53 = new String[] {
                "long", "com.liferay.portal.model.User", "java.lang.String",
                "long", "java.lang.String", "long", "long", "java.lang.String"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.addApplicationPreferences((com.liferay.pushnotifications.model.ApplicationPreferences) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.createApplicationPreferences((com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK) arguments[0]);
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.deleteApplicationPreferences((com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK) arguments[0]);
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.deleteApplicationPreferences((com.liferay.pushnotifications.model.ApplicationPreferences) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.fetchApplicationPreferences((com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK) arguments[0]);
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.getApplicationPreferences((com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.getApplicationPreferenceses(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.getApplicationPreferencesesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.updateApplicationPreferences((com.liferay.pushnotifications.model.ApplicationPreferences) arguments[0]);
        }

        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            ApplicationPreferencesLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.findApplicationPreferenceByApplicationId(((Long) arguments[0]).longValue());
        }

        if (_methodName53.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
            return ApplicationPreferencesLocalServiceUtil.addApplicationPreferences(((Long) arguments[0]).longValue(),
                (com.liferay.portal.model.User) arguments[1],
                (java.lang.String) arguments[2],
                ((Long) arguments[3]).longValue(),
                (java.lang.String) arguments[4],
                ((Long) arguments[5]).longValue(),
                ((Long) arguments[6]).longValue(),
                (java.lang.String) arguments[7]);
        }

        throw new UnsupportedOperationException();
    }
}
