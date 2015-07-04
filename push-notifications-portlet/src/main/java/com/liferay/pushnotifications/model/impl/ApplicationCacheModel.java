package com.liferay.pushnotifications.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.pushnotifications.model.Application;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Application in entity cache.
 *
 * @author Bruno Farache
 * @see Application
 * @generated
 */
public class ApplicationCacheModel implements CacheModel<Application>,
    Externalizable {
    public long applicationId;
    public String applicationName;
    public long createdDate;
    public long modificatedDate;
    public long userId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{applicationId=");
        sb.append(applicationId);
        sb.append(", applicationName=");
        sb.append(applicationName);
        sb.append(", createdDate=");
        sb.append(createdDate);
        sb.append(", modificatedDate=");
        sb.append(modificatedDate);
        sb.append(", userId=");
        sb.append(userId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Application toEntityModel() {
        ApplicationImpl applicationImpl = new ApplicationImpl();

        applicationImpl.setApplicationId(applicationId);

        if (applicationName == null) {
            applicationImpl.setApplicationName(StringPool.BLANK);
        } else {
            applicationImpl.setApplicationName(applicationName);
        }

        if (createdDate == Long.MIN_VALUE) {
            applicationImpl.setCreatedDate(null);
        } else {
            applicationImpl.setCreatedDate(new Date(createdDate));
        }

        if (modificatedDate == Long.MIN_VALUE) {
            applicationImpl.setModificatedDate(null);
        } else {
            applicationImpl.setModificatedDate(new Date(modificatedDate));
        }

        applicationImpl.setUserId(userId);

        applicationImpl.resetOriginalValues();

        return applicationImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        applicationId = objectInput.readLong();
        applicationName = objectInput.readUTF();
        createdDate = objectInput.readLong();
        modificatedDate = objectInput.readLong();
        userId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(applicationId);

        if (applicationName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(applicationName);
        }

        objectOutput.writeLong(createdDate);
        objectOutput.writeLong(modificatedDate);
        objectOutput.writeLong(userId);
    }
}
