package com.liferay.pushnotifications.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.pushnotifications.model.PushNotificationsDevice;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PushNotificationsDevice in entity cache.
 *
 * @author Bruno Farache
 * @see PushNotificationsDevice
 * @generated
 */
public class PushNotificationsDeviceCacheModel implements CacheModel<PushNotificationsDevice>,
    Externalizable {
    public long pushNotificationsDeviceId;
    public long userId;
    public long createDate;
    public String platform;
    public String token;
    public String model;
    public String OSVersion;
    public long appId;
    public String appVersion;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{pushNotificationsDeviceId=");
        sb.append(pushNotificationsDeviceId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", platform=");
        sb.append(platform);
        sb.append(", token=");
        sb.append(token);
        sb.append(", model=");
        sb.append(model);
        sb.append(", OSVersion=");
        sb.append(OSVersion);
        sb.append(", appId=");
        sb.append(appId);
        sb.append(", appVersion=");
        sb.append(appVersion);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public PushNotificationsDevice toEntityModel() {
        PushNotificationsDeviceImpl pushNotificationsDeviceImpl = new PushNotificationsDeviceImpl();

        pushNotificationsDeviceImpl.setPushNotificationsDeviceId(pushNotificationsDeviceId);
        pushNotificationsDeviceImpl.setUserId(userId);

        if (createDate == Long.MIN_VALUE) {
            pushNotificationsDeviceImpl.setCreateDate(null);
        } else {
            pushNotificationsDeviceImpl.setCreateDate(new Date(createDate));
        }

        if (platform == null) {
            pushNotificationsDeviceImpl.setPlatform(StringPool.BLANK);
        } else {
            pushNotificationsDeviceImpl.setPlatform(platform);
        }

        if (token == null) {
            pushNotificationsDeviceImpl.setToken(StringPool.BLANK);
        } else {
            pushNotificationsDeviceImpl.setToken(token);
        }

        if (model == null) {
            pushNotificationsDeviceImpl.setModel(StringPool.BLANK);
        } else {
            pushNotificationsDeviceImpl.setModel(model);
        }

        if (OSVersion == null) {
            pushNotificationsDeviceImpl.setOSVersion(StringPool.BLANK);
        } else {
            pushNotificationsDeviceImpl.setOSVersion(OSVersion);
        }

        pushNotificationsDeviceImpl.setAppId(appId);

        if (appVersion == null) {
            pushNotificationsDeviceImpl.setAppVersion(StringPool.BLANK);
        } else {
            pushNotificationsDeviceImpl.setAppVersion(appVersion);
        }

        pushNotificationsDeviceImpl.resetOriginalValues();

        return pushNotificationsDeviceImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        pushNotificationsDeviceId = objectInput.readLong();
        userId = objectInput.readLong();
        createDate = objectInput.readLong();
        platform = objectInput.readUTF();
        token = objectInput.readUTF();
        model = objectInput.readUTF();
        OSVersion = objectInput.readUTF();
        appId = objectInput.readLong();
        appVersion = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(pushNotificationsDeviceId);
        objectOutput.writeLong(userId);
        objectOutput.writeLong(createDate);

        if (platform == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(platform);
        }

        if (token == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(token);
        }

        if (model == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(model);
        }

        if (OSVersion == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(OSVersion);
        }

        objectOutput.writeLong(appId);

        if (appVersion == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(appVersion);
        }
    }
}
