package com.liferay.pushnotifications.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AppVersion}.
 * </p>
 *
 * @author Bruno Farache
 * @see AppVersion
 * @generated
 */
public class AppVersionWrapper implements AppVersion, ModelWrapper<AppVersion> {
    private AppVersion _appVersion;

    public AppVersionWrapper(AppVersion appVersion) {
        _appVersion = appVersion;
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

    /**
    * Returns the primary key of this app version.
    *
    * @return the primary key of this app version
    */
    @Override
    public long getPrimaryKey() {
        return _appVersion.getPrimaryKey();
    }

    /**
    * Sets the primary key of this app version.
    *
    * @param primaryKey the primary key of this app version
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _appVersion.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the app version ID of this app version.
    *
    * @return the app version ID of this app version
    */
    @Override
    public long getAppVersionId() {
        return _appVersion.getAppVersionId();
    }

    /**
    * Sets the app version ID of this app version.
    *
    * @param appVersionId the app version ID of this app version
    */
    @Override
    public void setAppVersionId(long appVersionId) {
        _appVersion.setAppVersionId(appVersionId);
    }

    /**
    * Returns the app version key of this app version.
    *
    * @return the app version key of this app version
    */
    @Override
    public java.lang.String getAppVersionKey() {
        return _appVersion.getAppVersionKey();
    }

    /**
    * Sets the app version key of this app version.
    *
    * @param appVersionKey the app version key of this app version
    */
    @Override
    public void setAppVersionKey(java.lang.String appVersionKey) {
        _appVersion.setAppVersionKey(appVersionKey);
    }

    /**
    * Returns the structure of this app version.
    *
    * @return the structure of this app version
    */
    @Override
    public java.lang.String getStructure() {
        return _appVersion.getStructure();
    }

    /**
    * Sets the structure of this app version.
    *
    * @param structure the structure of this app version
    */
    @Override
    public void setStructure(java.lang.String structure) {
        _appVersion.setStructure(structure);
    }

    /**
    * Returns the created date of this app version.
    *
    * @return the created date of this app version
    */
    @Override
    public java.util.Date getCreatedDate() {
        return _appVersion.getCreatedDate();
    }

    /**
    * Sets the created date of this app version.
    *
    * @param createdDate the created date of this app version
    */
    @Override
    public void setCreatedDate(java.util.Date createdDate) {
        _appVersion.setCreatedDate(createdDate);
    }

    /**
    * Returns the modified date of this app version.
    *
    * @return the modified date of this app version
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _appVersion.getModifiedDate();
    }

    /**
    * Sets the modified date of this app version.
    *
    * @param modifiedDate the modified date of this app version
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _appVersion.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the user ID of this app version.
    *
    * @return the user ID of this app version
    */
    @Override
    public long getUserId() {
        return _appVersion.getUserId();
    }

    /**
    * Sets the user ID of this app version.
    *
    * @param userId the user ID of this app version
    */
    @Override
    public void setUserId(long userId) {
        _appVersion.setUserId(userId);
    }

    /**
    * Returns the user uuid of this app version.
    *
    * @return the user uuid of this app version
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _appVersion.getUserUuid();
    }

    /**
    * Sets the user uuid of this app version.
    *
    * @param userUuid the user uuid of this app version
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _appVersion.setUserUuid(userUuid);
    }

    /**
    * Returns the application ID of this app version.
    *
    * @return the application ID of this app version
    */
    @Override
    public long getApplicationId() {
        return _appVersion.getApplicationId();
    }

    /**
    * Sets the application ID of this app version.
    *
    * @param applicationId the application ID of this app version
    */
    @Override
    public void setApplicationId(long applicationId) {
        _appVersion.setApplicationId(applicationId);
    }

    @Override
    public boolean isNew() {
        return _appVersion.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _appVersion.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _appVersion.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _appVersion.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _appVersion.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _appVersion.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _appVersion.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _appVersion.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _appVersion.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _appVersion.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _appVersion.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AppVersionWrapper((AppVersion) _appVersion.clone());
    }

    @Override
    public int compareTo(
        com.liferay.pushnotifications.model.AppVersion appVersion) {
        return _appVersion.compareTo(appVersion);
    }

    @Override
    public int hashCode() {
        return _appVersion.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay.pushnotifications.model.AppVersion> toCacheModel() {
        return _appVersion.toCacheModel();
    }

    @Override
    public com.liferay.pushnotifications.model.AppVersion toEscapedModel() {
        return new AppVersionWrapper(_appVersion.toEscapedModel());
    }

    @Override
    public com.liferay.pushnotifications.model.AppVersion toUnescapedModel() {
        return new AppVersionWrapper(_appVersion.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _appVersion.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _appVersion.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _appVersion.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AppVersionWrapper)) {
            return false;
        }

        AppVersionWrapper appVersionWrapper = (AppVersionWrapper) obj;

        if (Validator.equals(_appVersion, appVersionWrapper._appVersion)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public AppVersion getWrappedAppVersion() {
        return _appVersion;
    }

    @Override
    public AppVersion getWrappedModel() {
        return _appVersion;
    }

    @Override
    public void resetOriginalValues() {
        _appVersion.resetOriginalValues();
    }
}
