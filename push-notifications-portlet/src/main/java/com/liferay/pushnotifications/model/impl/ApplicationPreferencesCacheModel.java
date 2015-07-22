package com.liferay.pushnotifications.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.pushnotifications.model.ApplicationPreferences;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ApplicationPreferences in entity cache.
 *
 * @author Bruno Farache
 * @see ApplicationPreferences
 * @generated
 */
public class ApplicationPreferencesCacheModel implements CacheModel<ApplicationPreferences>,
    Externalizable {
    public long applicationPreferenceId;
    public long applicationId;
    public String androidApiKey;
    public long androidRetries;
    public String iosPasswordCertificated;
    public String iosPasswordSandBoxCertificated;
    public long iosSandBoxCert;
    public long iosProdCert;
    public long createdDate;
    public long modificatedDate;
    public long userId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{applicationPreferenceId=");
        sb.append(applicationPreferenceId);
        sb.append(", applicationId=");
        sb.append(applicationId);
        sb.append(", androidApiKey=");
        sb.append(androidApiKey);
        sb.append(", androidRetries=");
        sb.append(androidRetries);
        sb.append(", iosPasswordCertificated=");
        sb.append(iosPasswordCertificated);
        sb.append(", iosPasswordSandBoxCertificated=");
        sb.append(iosPasswordSandBoxCertificated);
        sb.append(", iosSandBoxCert=");
        sb.append(iosSandBoxCert);
        sb.append(", iosProdCert=");
        sb.append(iosProdCert);
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
    public ApplicationPreferences toEntityModel() {
        ApplicationPreferencesImpl applicationPreferencesImpl = new ApplicationPreferencesImpl();

        applicationPreferencesImpl.setApplicationPreferenceId(applicationPreferenceId);
        applicationPreferencesImpl.setApplicationId(applicationId);

        if (androidApiKey == null) {
            applicationPreferencesImpl.setAndroidApiKey(StringPool.BLANK);
        } else {
            applicationPreferencesImpl.setAndroidApiKey(androidApiKey);
        }

        applicationPreferencesImpl.setAndroidRetries(androidRetries);

        if (iosPasswordCertificated == null) {
            applicationPreferencesImpl.setIosPasswordCertificated(StringPool.BLANK);
        } else {
            applicationPreferencesImpl.setIosPasswordCertificated(iosPasswordCertificated);
        }

        if (iosPasswordSandBoxCertificated == null) {
            applicationPreferencesImpl.setIosPasswordSandBoxCertificated(StringPool.BLANK);
        } else {
            applicationPreferencesImpl.setIosPasswordSandBoxCertificated(iosPasswordSandBoxCertificated);
        }

        applicationPreferencesImpl.setIosSandBoxCert(iosSandBoxCert);
        applicationPreferencesImpl.setIosProdCert(iosProdCert);

        if (createdDate == Long.MIN_VALUE) {
            applicationPreferencesImpl.setCreatedDate(null);
        } else {
            applicationPreferencesImpl.setCreatedDate(new Date(createdDate));
        }

        if (modificatedDate == Long.MIN_VALUE) {
            applicationPreferencesImpl.setModificatedDate(null);
        } else {
            applicationPreferencesImpl.setModificatedDate(new Date(
                    modificatedDate));
        }

        applicationPreferencesImpl.setUserId(userId);

        applicationPreferencesImpl.resetOriginalValues();

        return applicationPreferencesImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        applicationPreferenceId = objectInput.readLong();
        applicationId = objectInput.readLong();
        androidApiKey = objectInput.readUTF();
        androidRetries = objectInput.readLong();
        iosPasswordCertificated = objectInput.readUTF();
        iosPasswordSandBoxCertificated = objectInput.readUTF();
        iosSandBoxCert = objectInput.readLong();
        iosProdCert = objectInput.readLong();
        createdDate = objectInput.readLong();
        modificatedDate = objectInput.readLong();
        userId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(applicationPreferenceId);
        objectOutput.writeLong(applicationId);

        if (androidApiKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(androidApiKey);
        }

        objectOutput.writeLong(androidRetries);

        if (iosPasswordCertificated == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(iosPasswordCertificated);
        }

        if (iosPasswordSandBoxCertificated == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(iosPasswordSandBoxCertificated);
        }

        objectOutput.writeLong(iosSandBoxCert);
        objectOutput.writeLong(iosProdCert);
        objectOutput.writeLong(createdDate);
        objectOutput.writeLong(modificatedDate);
        objectOutput.writeLong(userId);
    }
}
