package com.liferay.pushnotifications.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ApplicationPreferences}.
 * </p>
 *
 * @author Bruno Farache
 * @see ApplicationPreferences
 * @generated
 */
public class ApplicationPreferencesWrapper implements ApplicationPreferences,
    ModelWrapper<ApplicationPreferences> {
    private ApplicationPreferences _applicationPreferences;

    public ApplicationPreferencesWrapper(
        ApplicationPreferences applicationPreferences) {
        _applicationPreferences = applicationPreferences;
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

    /**
    * Returns the primary key of this application preferences.
    *
    * @return the primary key of this application preferences
    */
    @Override
    public com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK getPrimaryKey() {
        return _applicationPreferences.getPrimaryKey();
    }

    /**
    * Sets the primary key of this application preferences.
    *
    * @param primaryKey the primary key of this application preferences
    */
    @Override
    public void setPrimaryKey(
        com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK primaryKey) {
        _applicationPreferences.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the application preference ID of this application preferences.
    *
    * @return the application preference ID of this application preferences
    */
    @Override
    public long getApplicationPreferenceId() {
        return _applicationPreferences.getApplicationPreferenceId();
    }

    /**
    * Sets the application preference ID of this application preferences.
    *
    * @param applicationPreferenceId the application preference ID of this application preferences
    */
    @Override
    public void setApplicationPreferenceId(long applicationPreferenceId) {
        _applicationPreferences.setApplicationPreferenceId(applicationPreferenceId);
    }

    /**
    * Returns the application ID of this application preferences.
    *
    * @return the application ID of this application preferences
    */
    @Override
    public long getApplicationId() {
        return _applicationPreferences.getApplicationId();
    }

    /**
    * Sets the application ID of this application preferences.
    *
    * @param applicationId the application ID of this application preferences
    */
    @Override
    public void setApplicationId(long applicationId) {
        _applicationPreferences.setApplicationId(applicationId);
    }

    /**
    * Returns the android api key of this application preferences.
    *
    * @return the android api key of this application preferences
    */
    @Override
    public java.lang.String getAndroidApiKey() {
        return _applicationPreferences.getAndroidApiKey();
    }

    /**
    * Sets the android api key of this application preferences.
    *
    * @param androidApiKey the android api key of this application preferences
    */
    @Override
    public void setAndroidApiKey(java.lang.String androidApiKey) {
        _applicationPreferences.setAndroidApiKey(androidApiKey);
    }

    /**
    * Returns the android retries of this application preferences.
    *
    * @return the android retries of this application preferences
    */
    @Override
    public long getAndroidRetries() {
        return _applicationPreferences.getAndroidRetries();
    }

    /**
    * Sets the android retries of this application preferences.
    *
    * @param androidRetries the android retries of this application preferences
    */
    @Override
    public void setAndroidRetries(long androidRetries) {
        _applicationPreferences.setAndroidRetries(androidRetries);
    }

    /**
    * Returns the ios password certificated of this application preferences.
    *
    * @return the ios password certificated of this application preferences
    */
    @Override
    public java.lang.String getIosPasswordCertificated() {
        return _applicationPreferences.getIosPasswordCertificated();
    }

    /**
    * Sets the ios password certificated of this application preferences.
    *
    * @param iosPasswordCertificated the ios password certificated of this application preferences
    */
    @Override
    public void setIosPasswordCertificated(
        java.lang.String iosPasswordCertificated) {
        _applicationPreferences.setIosPasswordCertificated(iosPasswordCertificated);
    }

    /**
    * Returns the ios password sand box certificated of this application preferences.
    *
    * @return the ios password sand box certificated of this application preferences
    */
    @Override
    public java.lang.String getIosPasswordSandBoxCertificated() {
        return _applicationPreferences.getIosPasswordSandBoxCertificated();
    }

    /**
    * Sets the ios password sand box certificated of this application preferences.
    *
    * @param iosPasswordSandBoxCertificated the ios password sand box certificated of this application preferences
    */
    @Override
    public void setIosPasswordSandBoxCertificated(
        java.lang.String iosPasswordSandBoxCertificated) {
        _applicationPreferences.setIosPasswordSandBoxCertificated(iosPasswordSandBoxCertificated);
    }

    /**
    * Returns the ios sand box cert of this application preferences.
    *
    * @return the ios sand box cert of this application preferences
    */
    @Override
    public long getIosSandBoxCert() {
        return _applicationPreferences.getIosSandBoxCert();
    }

    /**
    * Sets the ios sand box cert of this application preferences.
    *
    * @param iosSandBoxCert the ios sand box cert of this application preferences
    */
    @Override
    public void setIosSandBoxCert(long iosSandBoxCert) {
        _applicationPreferences.setIosSandBoxCert(iosSandBoxCert);
    }

    /**
    * Returns the ios prod cert of this application preferences.
    *
    * @return the ios prod cert of this application preferences
    */
    @Override
    public long getIosProdCert() {
        return _applicationPreferences.getIosProdCert();
    }

    /**
    * Sets the ios prod cert of this application preferences.
    *
    * @param iosProdCert the ios prod cert of this application preferences
    */
    @Override
    public void setIosProdCert(long iosProdCert) {
        _applicationPreferences.setIosProdCert(iosProdCert);
    }

    /**
    * Returns the created date of this application preferences.
    *
    * @return the created date of this application preferences
    */
    @Override
    public java.util.Date getCreatedDate() {
        return _applicationPreferences.getCreatedDate();
    }

    /**
    * Sets the created date of this application preferences.
    *
    * @param createdDate the created date of this application preferences
    */
    @Override
    public void setCreatedDate(java.util.Date createdDate) {
        _applicationPreferences.setCreatedDate(createdDate);
    }

    /**
    * Returns the modificated date of this application preferences.
    *
    * @return the modificated date of this application preferences
    */
    @Override
    public java.util.Date getModificatedDate() {
        return _applicationPreferences.getModificatedDate();
    }

    /**
    * Sets the modificated date of this application preferences.
    *
    * @param modificatedDate the modificated date of this application preferences
    */
    @Override
    public void setModificatedDate(java.util.Date modificatedDate) {
        _applicationPreferences.setModificatedDate(modificatedDate);
    }

    /**
    * Returns the user ID of this application preferences.
    *
    * @return the user ID of this application preferences
    */
    @Override
    public long getUserId() {
        return _applicationPreferences.getUserId();
    }

    /**
    * Sets the user ID of this application preferences.
    *
    * @param userId the user ID of this application preferences
    */
    @Override
    public void setUserId(long userId) {
        _applicationPreferences.setUserId(userId);
    }

    /**
    * Returns the user uuid of this application preferences.
    *
    * @return the user uuid of this application preferences
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _applicationPreferences.getUserUuid();
    }

    /**
    * Sets the user uuid of this application preferences.
    *
    * @param userUuid the user uuid of this application preferences
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _applicationPreferences.setUserUuid(userUuid);
    }

    @Override
    public boolean isNew() {
        return _applicationPreferences.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _applicationPreferences.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _applicationPreferences.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _applicationPreferences.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _applicationPreferences.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _applicationPreferences.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _applicationPreferences.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _applicationPreferences.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _applicationPreferences.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _applicationPreferences.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _applicationPreferences.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ApplicationPreferencesWrapper((ApplicationPreferences) _applicationPreferences.clone());
    }

    @Override
    public int compareTo(
        com.liferay.pushnotifications.model.ApplicationPreferences applicationPreferences) {
        return _applicationPreferences.compareTo(applicationPreferences);
    }

    @Override
    public int hashCode() {
        return _applicationPreferences.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay.pushnotifications.model.ApplicationPreferences> toCacheModel() {
        return _applicationPreferences.toCacheModel();
    }

    @Override
    public com.liferay.pushnotifications.model.ApplicationPreferences toEscapedModel() {
        return new ApplicationPreferencesWrapper(_applicationPreferences.toEscapedModel());
    }

    @Override
    public com.liferay.pushnotifications.model.ApplicationPreferences toUnescapedModel() {
        return new ApplicationPreferencesWrapper(_applicationPreferences.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _applicationPreferences.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _applicationPreferences.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _applicationPreferences.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ApplicationPreferencesWrapper)) {
            return false;
        }

        ApplicationPreferencesWrapper applicationPreferencesWrapper = (ApplicationPreferencesWrapper) obj;

        if (Validator.equals(_applicationPreferences,
                    applicationPreferencesWrapper._applicationPreferences)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ApplicationPreferences getWrappedApplicationPreferences() {
        return _applicationPreferences;
    }

    @Override
    public ApplicationPreferences getWrappedModel() {
        return _applicationPreferences;
    }

    @Override
    public void resetOriginalValues() {
        _applicationPreferences.resetOriginalValues();
    }
}
