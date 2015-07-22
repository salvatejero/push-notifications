package com.liferay.pushnotifications.model;

import com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Bruno Farache
 * @generated
 */
public class ApplicationPreferencesSoap implements Serializable {
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

    public ApplicationPreferencesSoap() {
    }

    public static ApplicationPreferencesSoap toSoapModel(
        ApplicationPreferences model) {
        ApplicationPreferencesSoap soapModel = new ApplicationPreferencesSoap();

        soapModel.setApplicationPreferenceId(model.getApplicationPreferenceId());
        soapModel.setApplicationId(model.getApplicationId());
        soapModel.setAndroidApiKey(model.getAndroidApiKey());
        soapModel.setAndroidRetries(model.getAndroidRetries());
        soapModel.setIosPasswordCertificated(model.getIosPasswordCertificated());
        soapModel.setIosPasswordSandBoxCertificated(model.getIosPasswordSandBoxCertificated());
        soapModel.setIosSandBoxCert(model.getIosSandBoxCert());
        soapModel.setIosProdCert(model.getIosProdCert());
        soapModel.setCreatedDate(model.getCreatedDate());
        soapModel.setModificatedDate(model.getModificatedDate());
        soapModel.setUserId(model.getUserId());

        return soapModel;
    }

    public static ApplicationPreferencesSoap[] toSoapModels(
        ApplicationPreferences[] models) {
        ApplicationPreferencesSoap[] soapModels = new ApplicationPreferencesSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ApplicationPreferencesSoap[][] toSoapModels(
        ApplicationPreferences[][] models) {
        ApplicationPreferencesSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ApplicationPreferencesSoap[models.length][models[0].length];
        } else {
            soapModels = new ApplicationPreferencesSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ApplicationPreferencesSoap[] toSoapModels(
        List<ApplicationPreferences> models) {
        List<ApplicationPreferencesSoap> soapModels = new ArrayList<ApplicationPreferencesSoap>(models.size());

        for (ApplicationPreferences model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ApplicationPreferencesSoap[soapModels.size()]);
    }

    public ApplicationPreferencesPK getPrimaryKey() {
        return new ApplicationPreferencesPK(_applicationPreferenceId,
            _applicationId);
    }

    public void setPrimaryKey(ApplicationPreferencesPK pk) {
        setApplicationPreferenceId(pk.applicationPreferenceId);
        setApplicationId(pk.applicationId);
    }

    public long getApplicationPreferenceId() {
        return _applicationPreferenceId;
    }

    public void setApplicationPreferenceId(long applicationPreferenceId) {
        _applicationPreferenceId = applicationPreferenceId;
    }

    public long getApplicationId() {
        return _applicationId;
    }

    public void setApplicationId(long applicationId) {
        _applicationId = applicationId;
    }

    public String getAndroidApiKey() {
        return _androidApiKey;
    }

    public void setAndroidApiKey(String androidApiKey) {
        _androidApiKey = androidApiKey;
    }

    public long getAndroidRetries() {
        return _androidRetries;
    }

    public void setAndroidRetries(long androidRetries) {
        _androidRetries = androidRetries;
    }

    public String getIosPasswordCertificated() {
        return _iosPasswordCertificated;
    }

    public void setIosPasswordCertificated(String iosPasswordCertificated) {
        _iosPasswordCertificated = iosPasswordCertificated;
    }

    public String getIosPasswordSandBoxCertificated() {
        return _iosPasswordSandBoxCertificated;
    }

    public void setIosPasswordSandBoxCertificated(
        String iosPasswordSandBoxCertificated) {
        _iosPasswordSandBoxCertificated = iosPasswordSandBoxCertificated;
    }

    public long getIosSandBoxCert() {
        return _iosSandBoxCert;
    }

    public void setIosSandBoxCert(long iosSandBoxCert) {
        _iosSandBoxCert = iosSandBoxCert;
    }

    public long getIosProdCert() {
        return _iosProdCert;
    }

    public void setIosProdCert(long iosProdCert) {
        _iosProdCert = iosProdCert;
    }

    public Date getCreatedDate() {
        return _createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;
    }

    public Date getModificatedDate() {
        return _modificatedDate;
    }

    public void setModificatedDate(Date modificatedDate) {
        _modificatedDate = modificatedDate;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }
}
