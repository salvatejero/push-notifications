package com.liferay.pushnotifications.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.pushnotifications.model.AppVersion;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AppVersion in entity cache.
 *
 * @author Bruno Farache
 * @see AppVersion
 * @generated
 */
public class AppVersionCacheModel implements CacheModel<AppVersion>,
    Externalizable {
    public long appVersionId;
    public String appVersionKey;
    public String structure;
    public boolean sandbox;
    public long createdDate;
    public long modifiedDate;
    public long userId;
    public long applicationId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{appVersionId=");
        sb.append(appVersionId);
        sb.append(", appVersionKey=");
        sb.append(appVersionKey);
        sb.append(", structure=");
        sb.append(structure);
        sb.append(", sandbox=");
        sb.append(sandbox);
        sb.append(", createdDate=");
        sb.append(createdDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", applicationId=");
        sb.append(applicationId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AppVersion toEntityModel() {
        AppVersionImpl appVersionImpl = new AppVersionImpl();

        appVersionImpl.setAppVersionId(appVersionId);

        if (appVersionKey == null) {
            appVersionImpl.setAppVersionKey(StringPool.BLANK);
        } else {
            appVersionImpl.setAppVersionKey(appVersionKey);
        }

        if (structure == null) {
            appVersionImpl.setStructure(StringPool.BLANK);
        } else {
            appVersionImpl.setStructure(structure);
        }

        appVersionImpl.setSandbox(sandbox);

        if (createdDate == Long.MIN_VALUE) {
            appVersionImpl.setCreatedDate(null);
        } else {
            appVersionImpl.setCreatedDate(new Date(createdDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            appVersionImpl.setModifiedDate(null);
        } else {
            appVersionImpl.setModifiedDate(new Date(modifiedDate));
        }

        appVersionImpl.setUserId(userId);
        appVersionImpl.setApplicationId(applicationId);

        appVersionImpl.resetOriginalValues();

        return appVersionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        appVersionId = objectInput.readLong();
        appVersionKey = objectInput.readUTF();
        structure = objectInput.readUTF();
        sandbox = objectInput.readBoolean();
        createdDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        userId = objectInput.readLong();
        applicationId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(appVersionId);

        if (appVersionKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(appVersionKey);
        }

        if (structure == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(structure);
        }

        objectOutput.writeBoolean(sandbox);
        objectOutput.writeLong(createdDate);
        objectOutput.writeLong(modifiedDate);
        objectOutput.writeLong(userId);
        objectOutput.writeLong(applicationId);
    }
}
