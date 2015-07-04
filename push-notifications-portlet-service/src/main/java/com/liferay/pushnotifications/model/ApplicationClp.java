package com.liferay.pushnotifications.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.pushnotifications.service.ApplicationLocalServiceUtil;
import com.liferay.pushnotifications.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ApplicationClp extends BaseModelImpl<Application>
    implements Application {
    private long _applicationId;
    private String _applicationName;
    private Date _createdDate;
    private Date _modificatedDate;
    private long _userId;
    private String _userUuid;
    private BaseModel<?> _applicationRemoteModel;
    private Class<?> _clpSerializerClass = com.liferay.pushnotifications.service.ClpSerializer.class;

    public ApplicationClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Application.class;
    }

    @Override
    public String getModelClassName() {
        return Application.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _applicationId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setApplicationId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _applicationId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("applicationId", getApplicationId());
        attributes.put("applicationName", getApplicationName());
        attributes.put("createdDate", getCreatedDate());
        attributes.put("modificatedDate", getModificatedDate());
        attributes.put("userId", getUserId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long applicationId = (Long) attributes.get("applicationId");

        if (applicationId != null) {
            setApplicationId(applicationId);
        }

        String applicationName = (String) attributes.get("applicationName");

        if (applicationName != null) {
            setApplicationName(applicationName);
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
    public long getApplicationId() {
        return _applicationId;
    }

    @Override
    public void setApplicationId(long applicationId) {
        _applicationId = applicationId;

        if (_applicationRemoteModel != null) {
            try {
                Class<?> clazz = _applicationRemoteModel.getClass();

                Method method = clazz.getMethod("setApplicationId", long.class);

                method.invoke(_applicationRemoteModel, applicationId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getApplicationName() {
        return _applicationName;
    }

    @Override
    public void setApplicationName(String applicationName) {
        _applicationName = applicationName;

        if (_applicationRemoteModel != null) {
            try {
                Class<?> clazz = _applicationRemoteModel.getClass();

                Method method = clazz.getMethod("setApplicationName",
                        String.class);

                method.invoke(_applicationRemoteModel, applicationName);
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

        if (_applicationRemoteModel != null) {
            try {
                Class<?> clazz = _applicationRemoteModel.getClass();

                Method method = clazz.getMethod("setCreatedDate", Date.class);

                method.invoke(_applicationRemoteModel, createdDate);
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

        if (_applicationRemoteModel != null) {
            try {
                Class<?> clazz = _applicationRemoteModel.getClass();

                Method method = clazz.getMethod("setModificatedDate", Date.class);

                method.invoke(_applicationRemoteModel, modificatedDate);
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

        if (_applicationRemoteModel != null) {
            try {
                Class<?> clazz = _applicationRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_applicationRemoteModel, userId);
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

    public BaseModel<?> getApplicationRemoteModel() {
        return _applicationRemoteModel;
    }

    public void setApplicationRemoteModel(BaseModel<?> applicationRemoteModel) {
        _applicationRemoteModel = applicationRemoteModel;
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

        Class<?> remoteModelClass = _applicationRemoteModel.getClass();

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

        Object returnValue = method.invoke(_applicationRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ApplicationLocalServiceUtil.addApplication(this);
        } else {
            ApplicationLocalServiceUtil.updateApplication(this);
        }
    }

    @Override
    public Application toEscapedModel() {
        return (Application) ProxyUtil.newProxyInstance(Application.class.getClassLoader(),
            new Class[] { Application.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ApplicationClp clone = new ApplicationClp();

        clone.setApplicationId(getApplicationId());
        clone.setApplicationName(getApplicationName());
        clone.setCreatedDate(getCreatedDate());
        clone.setModificatedDate(getModificatedDate());
        clone.setUserId(getUserId());

        return clone;
    }

    @Override
    public int compareTo(Application application) {
        long primaryKey = application.getPrimaryKey();

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

        if (!(obj instanceof ApplicationClp)) {
            return false;
        }

        ApplicationClp application = (ApplicationClp) obj;

        long primaryKey = application.getPrimaryKey();

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
        StringBundler sb = new StringBundler(11);

        sb.append("{applicationId=");
        sb.append(getApplicationId());
        sb.append(", applicationName=");
        sb.append(getApplicationName());
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
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.liferay.pushnotifications.model.Application");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>applicationId</column-name><column-value><![CDATA[");
        sb.append(getApplicationId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>applicationName</column-name><column-value><![CDATA[");
        sb.append(getApplicationName());
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
