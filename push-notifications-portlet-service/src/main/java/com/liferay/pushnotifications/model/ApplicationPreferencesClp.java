package com.liferay.pushnotifications.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.pushnotifications.service.ApplicationPreferencesLocalServiceUtil;
import com.liferay.pushnotifications.service.ClpSerializer;
import com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ApplicationPreferencesClp extends BaseModelImpl<ApplicationPreferences>
    implements ApplicationPreferences {
    private long _applicationPreferenceId;
    private long _applicationId;
    private String _androidApiKey;
    private long _androidRetries;
    private String _iosPasswordCertificated;
    private String _iosPasswordSandBoxCertificated;
    private long _iosSandBoxCert;
    private long _iosProdCert;
    private Date _createdDate;
    private Date _modificatedDate;
    private long _userId;
    private String _userUuid;
    private BaseModel<?> _applicationPreferencesRemoteModel;
    private Class<?> _clpSerializerClass = com.liferay.pushnotifications.service.ClpSerializer.class;

    public ApplicationPreferencesClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return ApplicationPreferences.class;
    }

    @Override
    public String getModelClassName() {
        return ApplicationPreferences.class.getName();
    }

    @Override
    public ApplicationPreferencesPK getPrimaryKey() {
        return new ApplicationPreferencesPK(_applicationPreferenceId,
            _applicationId);
    }

    @Override
    public void setPrimaryKey(ApplicationPreferencesPK primaryKey) {
        setApplicationPreferenceId(primaryKey.applicationPreferenceId);
        setApplicationId(primaryKey.applicationId);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new ApplicationPreferencesPK(_applicationPreferenceId,
            _applicationId);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((ApplicationPreferencesPK) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("applicationPreferenceId", getApplicationPreferenceId());
        attributes.put("applicationId", getApplicationId());
        attributes.put("androidApiKey", getAndroidApiKey());
        attributes.put("androidRetries", getAndroidRetries());
        attributes.put("iosPasswordCertificated", getIosPasswordCertificated());
        attributes.put("iosPasswordSandBoxCertificated",
            getIosPasswordSandBoxCertificated());
        attributes.put("iosSandBoxCert", getIosSandBoxCert());
        attributes.put("iosProdCert", getIosProdCert());
        attributes.put("createdDate", getCreatedDate());
        attributes.put("modificatedDate", getModificatedDate());
        attributes.put("userId", getUserId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long applicationPreferenceId = (Long) attributes.get(
                "applicationPreferenceId");

        if (applicationPreferenceId != null) {
            setApplicationPreferenceId(applicationPreferenceId);
        }

        Long applicationId = (Long) attributes.get("applicationId");

        if (applicationId != null) {
            setApplicationId(applicationId);
        }

        String androidApiKey = (String) attributes.get("androidApiKey");

        if (androidApiKey != null) {
            setAndroidApiKey(androidApiKey);
        }

        Long androidRetries = (Long) attributes.get("androidRetries");

        if (androidRetries != null) {
            setAndroidRetries(androidRetries);
        }

        String iosPasswordCertificated = (String) attributes.get(
                "iosPasswordCertificated");

        if (iosPasswordCertificated != null) {
            setIosPasswordCertificated(iosPasswordCertificated);
        }

        String iosPasswordSandBoxCertificated = (String) attributes.get(
                "iosPasswordSandBoxCertificated");

        if (iosPasswordSandBoxCertificated != null) {
            setIosPasswordSandBoxCertificated(iosPasswordSandBoxCertificated);
        }

        Long iosSandBoxCert = (Long) attributes.get("iosSandBoxCert");

        if (iosSandBoxCert != null) {
            setIosSandBoxCert(iosSandBoxCert);
        }

        Long iosProdCert = (Long) attributes.get("iosProdCert");

        if (iosProdCert != null) {
            setIosProdCert(iosProdCert);
        }

        Date createdDate = (Date) attributes.get("createdDate");

        if (createdDate != null) {
            setCreatedDate(createdDate);
        }

        Date modificatedDate = (Date) attributes.get("modificatedDate");

        if (modificatedDate != null) {
            setModificatedDate(modificatedDate);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }
    }

    @Override
    public long getApplicationPreferenceId() {
        return _applicationPreferenceId;
    }

    @Override
    public void setApplicationPreferenceId(long applicationPreferenceId) {
        _applicationPreferenceId = applicationPreferenceId;

        if (_applicationPreferencesRemoteModel != null) {
            try {
                Class<?> clazz = _applicationPreferencesRemoteModel.getClass();

                Method method = clazz.getMethod("setApplicationPreferenceId",
                        long.class);

                method.invoke(_applicationPreferencesRemoteModel,
                    applicationPreferenceId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getApplicationId() {
        return _applicationId;
    }

    @Override
    public void setApplicationId(long applicationId) {
        _applicationId = applicationId;

        if (_applicationPreferencesRemoteModel != null) {
            try {
                Class<?> clazz = _applicationPreferencesRemoteModel.getClass();

                Method method = clazz.getMethod("setApplicationId", long.class);

                method.invoke(_applicationPreferencesRemoteModel, applicationId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAndroidApiKey() {
        return _androidApiKey;
    }

    @Override
    public void setAndroidApiKey(String androidApiKey) {
        _androidApiKey = androidApiKey;

        if (_applicationPreferencesRemoteModel != null) {
            try {
                Class<?> clazz = _applicationPreferencesRemoteModel.getClass();

                Method method = clazz.getMethod("setAndroidApiKey", String.class);

                method.invoke(_applicationPreferencesRemoteModel, androidApiKey);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getAndroidRetries() {
        return _androidRetries;
    }

    @Override
    public void setAndroidRetries(long androidRetries) {
        _androidRetries = androidRetries;

        if (_applicationPreferencesRemoteModel != null) {
            try {
                Class<?> clazz = _applicationPreferencesRemoteModel.getClass();

                Method method = clazz.getMethod("setAndroidRetries", long.class);

                method.invoke(_applicationPreferencesRemoteModel, androidRetries);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getIosPasswordCertificated() {
        return _iosPasswordCertificated;
    }

    @Override
    public void setIosPasswordCertificated(String iosPasswordCertificated) {
        _iosPasswordCertificated = iosPasswordCertificated;

        if (_applicationPreferencesRemoteModel != null) {
            try {
                Class<?> clazz = _applicationPreferencesRemoteModel.getClass();

                Method method = clazz.getMethod("setIosPasswordCertificated",
                        String.class);

                method.invoke(_applicationPreferencesRemoteModel,
                    iosPasswordCertificated);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getIosPasswordSandBoxCertificated() {
        return _iosPasswordSandBoxCertificated;
    }

    @Override
    public void setIosPasswordSandBoxCertificated(
        String iosPasswordSandBoxCertificated) {
        _iosPasswordSandBoxCertificated = iosPasswordSandBoxCertificated;

        if (_applicationPreferencesRemoteModel != null) {
            try {
                Class<?> clazz = _applicationPreferencesRemoteModel.getClass();

                Method method = clazz.getMethod("setIosPasswordSandBoxCertificated",
                        String.class);

                method.invoke(_applicationPreferencesRemoteModel,
                    iosPasswordSandBoxCertificated);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getIosSandBoxCert() {
        return _iosSandBoxCert;
    }

    @Override
    public void setIosSandBoxCert(long iosSandBoxCert) {
        _iosSandBoxCert = iosSandBoxCert;

        if (_applicationPreferencesRemoteModel != null) {
            try {
                Class<?> clazz = _applicationPreferencesRemoteModel.getClass();

                Method method = clazz.getMethod("setIosSandBoxCert", long.class);

                method.invoke(_applicationPreferencesRemoteModel, iosSandBoxCert);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getIosProdCert() {
        return _iosProdCert;
    }

    @Override
    public void setIosProdCert(long iosProdCert) {
        _iosProdCert = iosProdCert;

        if (_applicationPreferencesRemoteModel != null) {
            try {
                Class<?> clazz = _applicationPreferencesRemoteModel.getClass();

                Method method = clazz.getMethod("setIosProdCert", long.class);

                method.invoke(_applicationPreferencesRemoteModel, iosProdCert);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreatedDate() {
        return _createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;

        if (_applicationPreferencesRemoteModel != null) {
            try {
                Class<?> clazz = _applicationPreferencesRemoteModel.getClass();

                Method method = clazz.getMethod("setCreatedDate", Date.class);

                method.invoke(_applicationPreferencesRemoteModel, createdDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModificatedDate() {
        return _modificatedDate;
    }

    @Override
    public void setModificatedDate(Date modificatedDate) {
        _modificatedDate = modificatedDate;

        if (_applicationPreferencesRemoteModel != null) {
            try {
                Class<?> clazz = _applicationPreferencesRemoteModel.getClass();

                Method method = clazz.getMethod("setModificatedDate", Date.class);

                method.invoke(_applicationPreferencesRemoteModel,
                    modificatedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_applicationPreferencesRemoteModel != null) {
            try {
                Class<?> clazz = _applicationPreferencesRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_applicationPreferencesRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    public BaseModel<?> getApplicationPreferencesRemoteModel() {
        return _applicationPreferencesRemoteModel;
    }

    public void setApplicationPreferencesRemoteModel(
        BaseModel<?> applicationPreferencesRemoteModel) {
        _applicationPreferencesRemoteModel = applicationPreferencesRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _applicationPreferencesRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_applicationPreferencesRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ApplicationPreferencesLocalServiceUtil.addApplicationPreferences(this);
        } else {
            ApplicationPreferencesLocalServiceUtil.updateApplicationPreferences(this);
        }
    }

    @Override
    public ApplicationPreferences toEscapedModel() {
        return (ApplicationPreferences) ProxyUtil.newProxyInstance(ApplicationPreferences.class.getClassLoader(),
            new Class[] { ApplicationPreferences.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ApplicationPreferencesClp clone = new ApplicationPreferencesClp();

        clone.setApplicationPreferenceId(getApplicationPreferenceId());
        clone.setApplicationId(getApplicationId());
        clone.setAndroidApiKey(getAndroidApiKey());
        clone.setAndroidRetries(getAndroidRetries());
        clone.setIosPasswordCertificated(getIosPasswordCertificated());
        clone.setIosPasswordSandBoxCertificated(getIosPasswordSandBoxCertificated());
        clone.setIosSandBoxCert(getIosSandBoxCert());
        clone.setIosProdCert(getIosProdCert());
        clone.setCreatedDate(getCreatedDate());
        clone.setModificatedDate(getModificatedDate());
        clone.setUserId(getUserId());

        return clone;
    }

    @Override
    public int compareTo(ApplicationPreferences applicationPreferences) {
        ApplicationPreferencesPK primaryKey = applicationPreferences.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ApplicationPreferencesClp)) {
            return false;
        }

        ApplicationPreferencesClp applicationPreferences = (ApplicationPreferencesClp) obj;

        ApplicationPreferencesPK primaryKey = applicationPreferences.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{applicationPreferenceId=");
        sb.append(getApplicationPreferenceId());
        sb.append(", applicationId=");
        sb.append(getApplicationId());
        sb.append(", androidApiKey=");
        sb.append(getAndroidApiKey());
        sb.append(", androidRetries=");
        sb.append(getAndroidRetries());
        sb.append(", iosPasswordCertificated=");
        sb.append(getIosPasswordCertificated());
        sb.append(", iosPasswordSandBoxCertificated=");
        sb.append(getIosPasswordSandBoxCertificated());
        sb.append(", iosSandBoxCert=");
        sb.append(getIosSandBoxCert());
        sb.append(", iosProdCert=");
        sb.append(getIosProdCert());
        sb.append(", createdDate=");
        sb.append(getCreatedDate());
        sb.append(", modificatedDate=");
        sb.append(getModificatedDate());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(37);

        sb.append("<model><model-name>");
        sb.append("com.liferay.pushnotifications.model.ApplicationPreferences");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>applicationPreferenceId</column-name><column-value><![CDATA[");
        sb.append(getApplicationPreferenceId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>applicationId</column-name><column-value><![CDATA[");
        sb.append(getApplicationId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>androidApiKey</column-name><column-value><![CDATA[");
        sb.append(getAndroidApiKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>androidRetries</column-name><column-value><![CDATA[");
        sb.append(getAndroidRetries());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>iosPasswordCertificated</column-name><column-value><![CDATA[");
        sb.append(getIosPasswordCertificated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>iosPasswordSandBoxCertificated</column-name><column-value><![CDATA[");
        sb.append(getIosPasswordSandBoxCertificated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>iosSandBoxCert</column-name><column-value><![CDATA[");
        sb.append(getIosSandBoxCert());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>iosProdCert</column-name><column-value><![CDATA[");
        sb.append(getIosProdCert());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createdDate</column-name><column-value><![CDATA[");
        sb.append(getCreatedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modificatedDate</column-name><column-value><![CDATA[");
        sb.append(getModificatedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
