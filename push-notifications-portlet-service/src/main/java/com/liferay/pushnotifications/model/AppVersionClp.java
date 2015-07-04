package com.liferay.pushnotifications.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.pushnotifications.service.AppVersionLocalServiceUtil;
import com.liferay.pushnotifications.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class AppVersionClp extends BaseModelImpl<AppVersion>
    implements AppVersion {
    private long _appVersionId;
    private String _appVersionKey;
    private String _structure;
    private Date _createdDate;
    private Date _modifiedDate;
    private long _userId;
    private String _userUuid;
    private long _applicationId;
    private BaseModel<?> _appVersionRemoteModel;
    private Class<?> _clpSerializerClass = com.liferay.pushnotifications.service.ClpSerializer.class;

    public AppVersionClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return AppVersion.class;
    }

    @Override
    public String getModelClassName() {
        return AppVersion.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _appVersionId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setAppVersionId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _appVersionId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("appVersionId", getAppVersionId());
        attributes.put("appVersionKey", getAppVersionKey());
        attributes.put("structure", getStructure());
        attributes.put("createdDate", getCreatedDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("userId", getUserId());
        attributes.put("applicationId", getApplicationId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long appVersionId = (Long) attributes.get("appVersionId");

        if (appVersionId != null) {
            setAppVersionId(appVersionId);
        }

        String appVersionKey = (String) attributes.get("appVersionKey");

        if (appVersionKey != null) {
            setAppVersionKey(appVersionKey);
        }

        String structure = (String) attributes.get("structure");

        if (structure != null) {
            setStructure(structure);
        }

        Date createdDate = (Date) attributes.get("createdDate");

        if (createdDate != null) {
            setCreatedDate(createdDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Long applicationId = (Long) attributes.get("applicationId");

        if (applicationId != null) {
            setApplicationId(applicationId);
        }
    }

    @Override
    public long getAppVersionId() {
        return _appVersionId;
    }

    @Override
    public void setAppVersionId(long appVersionId) {
        _appVersionId = appVersionId;

        if (_appVersionRemoteModel != null) {
            try {
                Class<?> clazz = _appVersionRemoteModel.getClass();

                Method method = clazz.getMethod("setAppVersionId", long.class);

                method.invoke(_appVersionRemoteModel, appVersionId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAppVersionKey() {
        return _appVersionKey;
    }

    @Override
    public void setAppVersionKey(String appVersionKey) {
        _appVersionKey = appVersionKey;

        if (_appVersionRemoteModel != null) {
            try {
                Class<?> clazz = _appVersionRemoteModel.getClass();

                Method method = clazz.getMethod("setAppVersionKey", String.class);

                method.invoke(_appVersionRemoteModel, appVersionKey);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStructure() {
        return _structure;
    }

    @Override
    public void setStructure(String structure) {
        _structure = structure;

        if (_appVersionRemoteModel != null) {
            try {
                Class<?> clazz = _appVersionRemoteModel.getClass();

                Method method = clazz.getMethod("setStructure", String.class);

                method.invoke(_appVersionRemoteModel, structure);
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

        if (_appVersionRemoteModel != null) {
            try {
                Class<?> clazz = _appVersionRemoteModel.getClass();

                Method method = clazz.getMethod("setCreatedDate", Date.class);

                method.invoke(_appVersionRemoteModel, createdDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_appVersionRemoteModel != null) {
            try {
                Class<?> clazz = _appVersionRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_appVersionRemoteModel, modifiedDate);
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

        if (_appVersionRemoteModel != null) {
            try {
                Class<?> clazz = _appVersionRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_appVersionRemoteModel, userId);
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

    @Override
    public long getApplicationId() {
        return _applicationId;
    }

    @Override
    public void setApplicationId(long applicationId) {
        _applicationId = applicationId;

        if (_appVersionRemoteModel != null) {
            try {
                Class<?> clazz = _appVersionRemoteModel.getClass();

                Method method = clazz.getMethod("setApplicationId", long.class);

                method.invoke(_appVersionRemoteModel, applicationId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAppVersionRemoteModel() {
        return _appVersionRemoteModel;
    }

    public void setAppVersionRemoteModel(BaseModel<?> appVersionRemoteModel) {
        _appVersionRemoteModel = appVersionRemoteModel;
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

        Class<?> remoteModelClass = _appVersionRemoteModel.getClass();

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

        Object returnValue = method.invoke(_appVersionRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AppVersionLocalServiceUtil.addAppVersion(this);
        } else {
            AppVersionLocalServiceUtil.updateAppVersion(this);
        }
    }

    @Override
    public AppVersion toEscapedModel() {
        return (AppVersion) ProxyUtil.newProxyInstance(AppVersion.class.getClassLoader(),
            new Class[] { AppVersion.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AppVersionClp clone = new AppVersionClp();

        clone.setAppVersionId(getAppVersionId());
        clone.setAppVersionKey(getAppVersionKey());
        clone.setStructure(getStructure());
        clone.setCreatedDate(getCreatedDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setUserId(getUserId());
        clone.setApplicationId(getApplicationId());

        return clone;
    }

    @Override
    public int compareTo(AppVersion appVersion) {
        long primaryKey = appVersion.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AppVersionClp)) {
            return false;
        }

        AppVersionClp appVersion = (AppVersionClp) obj;

        long primaryKey = appVersion.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
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
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{appVersionId=");
        sb.append(getAppVersionId());
        sb.append(", appVersionKey=");
        sb.append(getAppVersionKey());
        sb.append(", structure=");
        sb.append(getStructure());
        sb.append(", createdDate=");
        sb.append(getCreatedDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", applicationId=");
        sb.append(getApplicationId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.liferay.pushnotifications.model.AppVersion");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>appVersionId</column-name><column-value><![CDATA[");
        sb.append(getAppVersionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>appVersionKey</column-name><column-value><![CDATA[");
        sb.append(getAppVersionKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>structure</column-name><column-value><![CDATA[");
        sb.append(getStructure());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createdDate</column-name><column-value><![CDATA[");
        sb.append(getCreatedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>applicationId</column-name><column-value><![CDATA[");
        sb.append(getApplicationId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
