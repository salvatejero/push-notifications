package com.liferay.pushnotifications.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.pushnotifications.model.ApplicationPreferences;
import com.liferay.pushnotifications.model.ApplicationPreferencesModel;
import com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ApplicationPreferences service. Represents a row in the &quot;ApplicationPreferences&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.pushnotifications.model.ApplicationPreferencesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ApplicationPreferencesImpl}.
 * </p>
 *
 * @author Bruno Farache
 * @see ApplicationPreferencesImpl
 * @see com.liferay.pushnotifications.model.ApplicationPreferences
 * @see com.liferay.pushnotifications.model.ApplicationPreferencesModel
 * @generated
 */
public class ApplicationPreferencesModelImpl extends BaseModelImpl<ApplicationPreferences>
    implements ApplicationPreferencesModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a application preferences model instance should use the {@link com.liferay.pushnotifications.model.ApplicationPreferences} interface instead.
     */
    public static final String TABLE_NAME = "ApplicationPreferences";
    public static final Object[][] TABLE_COLUMNS = {
            { "applicationPreferenceId", Types.BIGINT },
            { "applicationId", Types.BIGINT },
            { "androidApiKey", Types.VARCHAR },
            { "androidRetries", Types.BIGINT },
            { "iosPasswordCertificated", Types.VARCHAR },
            { "iosPasswordSandBoxCertificated", Types.VARCHAR },
            { "iosSandBoxCert", Types.BIGINT },
            { "iosProdCert", Types.BIGINT },
            { "createdDate", Types.TIMESTAMP },
            { "modificatedDate", Types.TIMESTAMP },
            { "userId", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table ApplicationPreferences (applicationPreferenceId LONG not null,applicationId LONG not null,androidApiKey VARCHAR(75) null,androidRetries LONG,iosPasswordCertificated VARCHAR(75) null,iosPasswordSandBoxCertificated VARCHAR(75) null,iosSandBoxCert LONG,iosProdCert LONG,createdDate DATE null,modificatedDate DATE null,userId LONG,primary key (applicationPreferenceId, applicationId))";
    public static final String TABLE_SQL_DROP = "drop table ApplicationPreferences";
    public static final String ORDER_BY_JPQL = " ORDER BY applicationPreferences.id.applicationPreferenceId ASC, applicationPreferences.id.applicationId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY ApplicationPreferences.applicationPreferenceId ASC, ApplicationPreferences.applicationId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.liferay.pushnotifications.model.ApplicationPreferences"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.liferay.pushnotifications.model.ApplicationPreferences"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.liferay.pushnotifications.model.ApplicationPreferences"),
            true);
    public static long APPLICATIONID_COLUMN_BITMASK = 1L;
    public static long APPLICATIONPREFERENCEID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.liferay.pushnotifications.model.ApplicationPreferences"));
    private static ClassLoader _classLoader = ApplicationPreferences.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            ApplicationPreferences.class
        };
    private long _applicationPreferenceId;
    private long _applicationId;
    private long _originalApplicationId;
    private boolean _setOriginalApplicationId;
    private String _androidApiKey;
    private long _androidRetries;
    private String _iosPasswordCertificated;
    private String _iosPasswordSandBoxCertificated;
    private long _iosSandBoxCert;
    private long _iosProdCert;
    private Date _createdDate;
    private Date _modificatedDate;
    private long _userId;
    private String _userUuid;
    private long _columnBitmask;
    private ApplicationPreferences _escapedModel;

    public ApplicationPreferencesModelImpl() {
    }

    @Override
    public ApplicationPreferencesPK getPrimaryKey() {
        return new ApplicationPreferencesPK(_applicationPreferenceId,
            _applicationId);
    }

    @Override
    public void setPrimaryKey(ApplicationPreferencesPK primaryKey) {
        setApplicationPreferenceId(primaryKey.applicationPreferenceId);
        setApplicationId(primaryKey.applicationId);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return new ApplicationPreferencesPK(_applicationPreferenceId,
            _applicationId);
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((ApplicationPreferencesPK) primaryKeyObj);
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

    @Override
    public long getApplicationPreferenceId() {
        return _applicationPreferenceId;
    }

    @Override
    public void setApplicationPreferenceId(long applicationPreferenceId) {
        _applicationPreferenceId = applicationPreferenceId;
    }

    @Override
    public long getApplicationId() {
        return _applicationId;
    }

    @Override
    public void setApplicationId(long applicationId) {
        _columnBitmask |= APPLICATIONID_COLUMN_BITMASK;

        if (!_setOriginalApplicationId) {
            _setOriginalApplicationId = true;

            _originalApplicationId = _applicationId;
        }

        _applicationId = applicationId;
    }

    public long getOriginalApplicationId() {
        return _originalApplicationId;
    }

    @Override
    public String getAndroidApiKey() {
        if (_androidApiKey == null) {
            return StringPool.BLANK;
        } else {
            return _androidApiKey;
        }
    }

    @Override
    public void setAndroidApiKey(String androidApiKey) {
        _androidApiKey = androidApiKey;
    }

    @Override
    public long getAndroidRetries() {
        return _androidRetries;
    }

    @Override
    public void setAndroidRetries(long androidRetries) {
        _androidRetries = androidRetries;
    }

    @Override
    public String getIosPasswordCertificated() {
        if (_iosPasswordCertificated == null) {
            return StringPool.BLANK;
        } else {
            return _iosPasswordCertificated;
        }
    }

    @Override
    public void setIosPasswordCertificated(String iosPasswordCertificated) {
        _iosPasswordCertificated = iosPasswordCertificated;
    }

    @Override
    public String getIosPasswordSandBoxCertificated() {
        if (_iosPasswordSandBoxCertificated == null) {
            return StringPool.BLANK;
        } else {
            return _iosPasswordSandBoxCertificated;
        }
    }

    @Override
    public void setIosPasswordSandBoxCertificated(
        String iosPasswordSandBoxCertificated) {
        _iosPasswordSandBoxCertificated = iosPasswordSandBoxCertificated;
    }

    @Override
    public long getIosSandBoxCert() {
        return _iosSandBoxCert;
    }

    @Override
    public void setIosSandBoxCert(long iosSandBoxCert) {
        _iosSandBoxCert = iosSandBoxCert;
    }

    @Override
    public long getIosProdCert() {
        return _iosProdCert;
    }

    @Override
    public void setIosProdCert(long iosProdCert) {
        _iosProdCert = iosProdCert;
    }

    @Override
    public Date getCreatedDate() {
        return _createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;
    }

    @Override
    public Date getModificatedDate() {
        return _modificatedDate;
    }

    @Override
    public void setModificatedDate(Date modificatedDate) {
        _modificatedDate = modificatedDate;
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ApplicationPreferences toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (ApplicationPreferences) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ApplicationPreferencesImpl applicationPreferencesImpl = new ApplicationPreferencesImpl();

        applicationPreferencesImpl.setApplicationPreferenceId(getApplicationPreferenceId());
        applicationPreferencesImpl.setApplicationId(getApplicationId());
        applicationPreferencesImpl.setAndroidApiKey(getAndroidApiKey());
        applicationPreferencesImpl.setAndroidRetries(getAndroidRetries());
        applicationPreferencesImpl.setIosPasswordCertificated(getIosPasswordCertificated());
        applicationPreferencesImpl.setIosPasswordSandBoxCertificated(getIosPasswordSandBoxCertificated());
        applicationPreferencesImpl.setIosSandBoxCert(getIosSandBoxCert());
        applicationPreferencesImpl.setIosProdCert(getIosProdCert());
        applicationPreferencesImpl.setCreatedDate(getCreatedDate());
        applicationPreferencesImpl.setModificatedDate(getModificatedDate());
        applicationPreferencesImpl.setUserId(getUserId());

        applicationPreferencesImpl.resetOriginalValues();

        return applicationPreferencesImpl;
    }

    @Override
    public int compareTo(ApplicationPreferences applicationPreferences) {
        ApplicationPreferencesPK primaryKey = applicationPreferences.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ApplicationPreferences)) {
            return false;
        }

        ApplicationPreferences applicationPreferences = (ApplicationPreferences) obj;

        ApplicationPreferencesPK primaryKey = applicationPreferences.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public void resetOriginalValues() {
        ApplicationPreferencesModelImpl applicationPreferencesModelImpl = this;

        applicationPreferencesModelImpl._originalApplicationId = applicationPreferencesModelImpl._applicationId;

        applicationPreferencesModelImpl._setOriginalApplicationId = false;

        applicationPreferencesModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ApplicationPreferences> toCacheModel() {
        ApplicationPreferencesCacheModel applicationPreferencesCacheModel = new ApplicationPreferencesCacheModel();

        applicationPreferencesCacheModel.applicationPreferenceId = getApplicationPreferenceId();

        applicationPreferencesCacheModel.applicationId = getApplicationId();

        applicationPreferencesCacheModel.androidApiKey = getAndroidApiKey();

        String androidApiKey = applicationPreferencesCacheModel.androidApiKey;

        if ((androidApiKey != null) && (androidApiKey.length() == 0)) {
            applicationPreferencesCacheModel.androidApiKey = null;
        }

        applicationPreferencesCacheModel.androidRetries = getAndroidRetries();

        applicationPreferencesCacheModel.iosPasswordCertificated = getIosPasswordCertificated();

        String iosPasswordCertificated = applicationPreferencesCacheModel.iosPasswordCertificated;

        if ((iosPasswordCertificated != null) &&
                (iosPasswordCertificated.length() == 0)) {
            applicationPreferencesCacheModel.iosPasswordCertificated = null;
        }

        applicationPreferencesCacheModel.iosPasswordSandBoxCertificated = getIosPasswordSandBoxCertificated();

        String iosPasswordSandBoxCertificated = applicationPreferencesCacheModel.iosPasswordSandBoxCertificated;

        if ((iosPasswordSandBoxCertificated != null) &&
                (iosPasswordSandBoxCertificated.length() == 0)) {
            applicationPreferencesCacheModel.iosPasswordSandBoxCertificated = null;
        }

        applicationPreferencesCacheModel.iosSandBoxCert = getIosSandBoxCert();

        applicationPreferencesCacheModel.iosProdCert = getIosProdCert();

        Date createdDate = getCreatedDate();

        if (createdDate != null) {
            applicationPreferencesCacheModel.createdDate = createdDate.getTime();
        } else {
            applicationPreferencesCacheModel.createdDate = Long.MIN_VALUE;
        }

        Date modificatedDate = getModificatedDate();

        if (modificatedDate != null) {
            applicationPreferencesCacheModel.modificatedDate = modificatedDate.getTime();
        } else {
            applicationPreferencesCacheModel.modificatedDate = Long.MIN_VALUE;
        }

        applicationPreferencesCacheModel.userId = getUserId();

        return applicationPreferencesCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{applicationPreferenceId=");
        sb.append(getApplicationPreferenceId());
        sb.append(", applicationId=");
        sb.append(getApplicationId());
        sb.append(", androidApiKey=");
        sb.append(getAndroidApiKey());
        sb.append(", androidRetries=");
        sb.append(getAndroidRetries());
        sb.append(", iosPasswordCertificated=");
        sb.append(getIosPasswordCertificated());
        sb.append(", iosPasswordSandBoxCertificated=");
        sb.append(getIosPasswordSandBoxCertificated());
        sb.append(", iosSandBoxCert=");
        sb.append(getIosSandBoxCert());
        sb.append(", iosProdCert=");
        sb.append(getIosProdCert());
        sb.append(", createdDate=");
        sb.append(getCreatedDate());
        sb.append(", modificatedDate=");
        sb.append(getModificatedDate());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(37);

        sb.append("<model><model-name>");
        sb.append("com.liferay.pushnotifications.model.ApplicationPreferences");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>applicationPreferenceId</column-name><column-value><![CDATA[");
        sb.append(getApplicationPreferenceId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>applicationId</column-name><column-value><![CDATA[");
        sb.append(getApplicationId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>androidApiKey</column-name><column-value><![CDATA[");
        sb.append(getAndroidApiKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>androidRetries</column-name><column-value><![CDATA[");
        sb.append(getAndroidRetries());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>iosPasswordCertificated</column-name><column-value><![CDATA[");
        sb.append(getIosPasswordCertificated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>iosPasswordSandBoxCertificated</column-name><column-value><![CDATA[");
        sb.append(getIosPasswordSandBoxCertificated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>iosSandBoxCert</column-name><column-value><![CDATA[");
        sb.append(getIosSandBoxCert());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>iosProdCert</column-name><column-value><![CDATA[");
        sb.append(getIosProdCert());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createdDate</column-name><column-value><![CDATA[");
        sb.append(getCreatedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modificatedDate</column-name><column-value><![CDATA[");
        sb.append(getModificatedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
