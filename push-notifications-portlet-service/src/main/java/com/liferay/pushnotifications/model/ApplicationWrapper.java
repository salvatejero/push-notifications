package com.liferay.pushnotifications.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Application}.
 * </p>
 *
 * @author Bruno Farache
 * @see Application
 * @generated
 */
public class ApplicationWrapper implements Application,
    ModelWrapper<Application> {
    private Application _application;

    public ApplicationWrapper(Application application) {
        _application = application;
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

    /**
    * Returns the primary key of this application.
    *
    * @return the primary key of this application
    */
    @Override
    public long getPrimaryKey() {
        return _application.getPrimaryKey();
    }

    /**
    * Sets the primary key of this application.
    *
    * @param primaryKey the primary key of this application
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _application.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the application ID of this application.
    *
    * @return the application ID of this application
    */
    @Override
    public long getApplicationId() {
        return _application.getApplicationId();
    }

    /**
    * Sets the application ID of this application.
    *
    * @param applicationId the application ID of this application
    */
    @Override
    public void setApplicationId(long applicationId) {
        _application.setApplicationId(applicationId);
    }

    /**
    * Returns the application name of this application.
    *
    * @return the application name of this application
    */
    @Override
    public java.lang.String getApplicationName() {
        return _application.getApplicationName();
    }

    /**
    * Sets the application name of this application.
    *
    * @param applicationName the application name of this application
    */
    @Override
    public void setApplicationName(java.lang.String applicationName) {
        _application.setApplicationName(applicationName);
    }

    /**
    * Returns the created date of this application.
    *
    * @return the created date of this application
    */
    @Override
    public java.util.Date getCreatedDate() {
        return _application.getCreatedDate();
    }

    /**
    * Sets the created date of this application.
    *
    * @param createdDate the created date of this application
    */
    @Override
    public void setCreatedDate(java.util.Date createdDate) {
        _application.setCreatedDate(createdDate);
    }

    /**
    * Returns the modificated date of this application.
    *
    * @return the modificated date of this application
    */
    @Override
    public java.util.Date getModificatedDate() {
        return _application.getModificatedDate();
    }

    /**
    * Sets the modificated date of this application.
    *
    * @param modificatedDate the modificated date of this application
    */
    @Override
    public void setModificatedDate(java.util.Date modificatedDate) {
        _application.setModificatedDate(modificatedDate);
    }

    /**
    * Returns the user ID of this application.
    *
    * @return the user ID of this application
    */
    @Override
    public long getUserId() {
        return _application.getUserId();
    }

    /**
    * Sets the user ID of this application.
    *
    * @param userId the user ID of this application
    */
    @Override
    public void setUserId(long userId) {
        _application.setUserId(userId);
    }

    /**
    * Returns the user uuid of this application.
    *
    * @return the user uuid of this application
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _application.getUserUuid();
    }

    /**
    * Sets the user uuid of this application.
    *
    * @param userUuid the user uuid of this application
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _application.setUserUuid(userUuid);
    }

    @Override
    public boolean isNew() {
        return _application.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _application.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _application.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _application.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _application.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _application.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _application.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _application.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _application.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _application.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _application.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ApplicationWrapper((Application) _application.clone());
    }

    @Override
    public int compareTo(
        com.liferay.pushnotifications.model.Application application) {
        return _application.compareTo(application);
    }

    @Override
    public int hashCode() {
        return _application.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay.pushnotifications.model.Application> toCacheModel() {
        return _application.toCacheModel();
    }

    @Override
    public com.liferay.pushnotifications.model.Application toEscapedModel() {
        return new ApplicationWrapper(_application.toEscapedModel());
    }

    @Override
    public com.liferay.pushnotifications.model.Application toUnescapedModel() {
        return new ApplicationWrapper(_application.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _application.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _application.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _application.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ApplicationWrapper)) {
            return false;
        }

        ApplicationWrapper applicationWrapper = (ApplicationWrapper) obj;

        if (Validator.equals(_application, applicationWrapper._application)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Application getWrappedApplication() {
        return _application;
    }

    @Override
    public Application getWrappedModel() {
        return _application;
    }

    @Override
    public void resetOriginalValues() {
        _application.resetOriginalValues();
    }
}
