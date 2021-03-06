package com.liferay.pushnotifications.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.pushnotifications.model.Application;
import com.liferay.pushnotifications.model.ApplicationModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Application service. Represents a row in the &quot;Application&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.pushnotifications.model.ApplicationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ApplicationImpl}.
 * </p>
 *
 * @author Bruno Farache
 * @see ApplicationImpl
 * @see com.liferay.pushnotifications.model.Application
 * @see com.liferay.pushnotifications.model.ApplicationModel
 * @generated
 */
public class ApplicationModelImpl extends BaseModelImpl<Application>
    implements ApplicationModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a application model instance should use the {@link com.liferay.pushnotifications.model.Application} interface instead.
     */
    public static final String TABLE_NAME = "Application";
    public static final Object[][] TABLE_COLUMNS = {
            { "applicationId", Types.BIGINT },
            { "applicationName", Types.VARCHAR },
            { "createdDate", Types.TIMESTAMP },
            { "modificatedDate", Types.TIMESTAMP },
            { "userId", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table Application (applicationId LONG not null primary key,applicationName VARCHAR(75) null,createdDate DATE null,modificatedDate DATE null,userId LONG)";
    public static final String TABLE_SQL_DROP = "drop table Application";
    public static final String ORDER_BY_JPQL = " ORDER BY application.applicationId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY Application.applicationId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.liferay.pushnotifications.model.Application"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.liferay.pushnotifications.model.Application"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.liferay.pushnotifications.model.Application"));
    private static ClassLoader _classLoader = Application.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            Application.class
        };
    private long _applicationId;
    private String _applicationName;
    private Date _createdDate;
    private Date _modificatedDate;
    private long _userId;
    private String _userUuid;
    private Application _escapedModel;

    public ApplicationModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _applicationId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setApplicationId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _applicationId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Application.class;
    }

    @Override
    public String getModelClassName() {
        return Application.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("applicationId", getApplicationId());
        attributes.put("applicationName", getApplicationName());
        attributes.put("createdDate", getCreatedDate());
        attributes.put("modificatedDate", getModificatedDate());
        attributes.put("userId", getUserId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long applicationId = (Long) attributes.get("applicationId");

        if (applicationId != null) {
            setApplicationId(applicationId);
        }

        String applicationName = (String) attributes.get("applicationName");

        if (applicationName != null) {
            setApplicationName(applicationName);
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
    public long getApplicationId() {
        return _applicationId;
    }

    @Override
    public void setApplicationId(long applicationId) {
        _applicationId = applicationId;
    }

    @Override
    public String getApplicationName() {
        if (_applicationName == null) {
            return StringPool.BLANK;
        } else {
            return _applicationName;
        }
    }

    @Override
    public void setApplicationName(String applicationName) {
        _applicationName = applicationName;
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

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            Application.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Application toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Application) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ApplicationImpl applicationImpl = new ApplicationImpl();

        applicationImpl.setApplicationId(getApplicationId());
        applicationImpl.setApplicationName(getApplicationName());
        applicationImpl.setCreatedDate(getCreatedDate());
        applicationImpl.setModificatedDate(getModificatedDate());
        applicationImpl.setUserId(getUserId());

        applicationImpl.resetOriginalValues();

        return applicationImpl;
    }

    @Override
    public int compareTo(Application application) {
        long primaryKey = application.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Application)) {
            return false;
        }

        Application application = (Application) obj;

        long primaryKey = application.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
    }

    @Override
    public CacheModel<Application> toCacheModel() {
        ApplicationCacheModel applicationCacheModel = new ApplicationCacheModel();

        applicationCacheModel.applicationId = getApplicationId();

        applicationCacheModel.applicationName = getApplicationName();

        String applicationName = applicationCacheModel.applicationName;

        if ((applicationName != null) && (applicationName.length() == 0)) {
            applicationCacheModel.applicationName = null;
        }

        Date createdDate = getCreatedDate();

        if (createdDate != null) {
            applicationCacheModel.createdDate = createdDate.getTime();
        } else {
            applicationCacheModel.createdDate = Long.MIN_VALUE;
        }

        Date modificatedDate = getModificatedDate();

        if (modificatedDate != null) {
            applicationCacheModel.modificatedDate = modificatedDate.getTime();
        } else {
            applicationCacheModel.modificatedDate = Long.MIN_VALUE;
        }

        applicationCacheModel.userId = getUserId();

        return applicationCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{applicationId=");
        sb.append(getApplicationId());
        sb.append(", applicationName=");
        sb.append(getApplicationName());
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
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.liferay.pushnotifications.model.Application");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>applicationId</column-name><column-value><![CDATA[");
        sb.append(getApplicationId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>applicationName</column-name><column-value><![CDATA[");
        sb.append(getApplicationName());
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
