package com.liferay.pushnotifications.model;

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
public class AppVersionSoap implements Serializable {
    private long _appVersionId;
    private String _appVersionKey;
    private String _structure;
    private boolean _sandbox;
    private Date _createdDate;
    private Date _modifiedDate;
    private long _userId;
    private long _applicationId;

    public AppVersionSoap() {
    }

    public static AppVersionSoap toSoapModel(AppVersion model) {
        AppVersionSoap soapModel = new AppVersionSoap();

        soapModel.setAppVersionId(model.getAppVersionId());
        soapModel.setAppVersionKey(model.getAppVersionKey());
        soapModel.setStructure(model.getStructure());
        soapModel.setSandbox(model.getSandbox());
        soapModel.setCreatedDate(model.getCreatedDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setUserId(model.getUserId());
        soapModel.setApplicationId(model.getApplicationId());

        return soapModel;
    }

    public static AppVersionSoap[] toSoapModels(AppVersion[] models) {
        AppVersionSoap[] soapModels = new AppVersionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AppVersionSoap[][] toSoapModels(AppVersion[][] models) {
        AppVersionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AppVersionSoap[models.length][models[0].length];
        } else {
            soapModels = new AppVersionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AppVersionSoap[] toSoapModels(List<AppVersion> models) {
        List<AppVersionSoap> soapModels = new ArrayList<AppVersionSoap>(models.size());

        for (AppVersion model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AppVersionSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _appVersionId;
    }

    public void setPrimaryKey(long pk) {
        setAppVersionId(pk);
    }

    public long getAppVersionId() {
        return _appVersionId;
    }

    public void setAppVersionId(long appVersionId) {
        _appVersionId = appVersionId;
    }

    public String getAppVersionKey() {
        return _appVersionKey;
    }

    public void setAppVersionKey(String appVersionKey) {
        _appVersionKey = appVersionKey;
    }

    public String getStructure() {
        return _structure;
    }

    public void setStructure(String structure) {
        _structure = structure;
    }

    public boolean getSandbox() {
        return _sandbox;
    }

    public boolean isSandbox() {
        return _sandbox;
    }

    public void setSandbox(boolean sandbox) {
        _sandbox = sandbox;
    }

    public Date getCreatedDate() {
        return _createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public long getApplicationId() {
        return _applicationId;
    }

    public void setApplicationId(long applicationId) {
        _applicationId = applicationId;
    }
}
