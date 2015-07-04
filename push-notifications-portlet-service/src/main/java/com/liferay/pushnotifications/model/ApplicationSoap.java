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
public class ApplicationSoap implements Serializable {
    private long _applicationId;
    private String _applicationName;
    private Date _createdDate;
    private Date _modificatedDate;
    private long _userId;

    public ApplicationSoap() {
    }

    public static ApplicationSoap toSoapModel(Application model) {
        ApplicationSoap soapModel = new ApplicationSoap();

        soapModel.setApplicationId(model.getApplicationId());
        soapModel.setApplicationName(model.getApplicationName());
        soapModel.setCreatedDate(model.getCreatedDate());
        soapModel.setModificatedDate(model.getModificatedDate());
        soapModel.setUserId(model.getUserId());

        return soapModel;
    }

    public static ApplicationSoap[] toSoapModels(Application[] models) {
        ApplicationSoap[] soapModels = new ApplicationSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ApplicationSoap[][] toSoapModels(Application[][] models) {
        ApplicationSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ApplicationSoap[models.length][models[0].length];
        } else {
            soapModels = new ApplicationSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ApplicationSoap[] toSoapModels(List<Application> models) {
        List<ApplicationSoap> soapModels = new ArrayList<ApplicationSoap>(models.size());

        for (Application model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ApplicationSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _applicationId;
    }

    public void setPrimaryKey(long pk) {
        setApplicationId(pk);
    }

    public long getApplicationId() {
        return _applicationId;
    }

    public void setApplicationId(long applicationId) {
        _applicationId = applicationId;
    }

    public String getApplicationName() {
        return _applicationName;
    }

    public void setApplicationName(String applicationName) {
        _applicationName = applicationName;
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
