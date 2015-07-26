package com.liferay.pushnotifications.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.pushnotifications.NoSuchDeviceException;
import com.liferay.pushnotifications.model.PushNotificationsDevice;
import com.liferay.pushnotifications.model.impl.PushNotificationsDeviceImpl;
import com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl;
import com.liferay.pushnotifications.service.persistence.PushNotificationsDevicePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the push notifications device service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Farache
 * @see PushNotificationsDevicePersistence
 * @see PushNotificationsDeviceUtil
 * @generated
 */
public class PushNotificationsDevicePersistenceImpl extends BasePersistenceImpl<PushNotificationsDevice>
    implements PushNotificationsDevicePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link PushNotificationsDeviceUtil} to access the push notifications device persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = PushNotificationsDeviceImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_TOKEN = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByToken", new String[] { String.class.getName() },
            PushNotificationsDeviceModelImpl.TOKEN_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TOKEN = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByToken",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_TOKEN_TOKEN_1 = "pushNotificationsDevice.token IS NULL";
    private static final String _FINDER_COLUMN_TOKEN_TOKEN_2 = "pushNotificationsDevice.token = ?";
    private static final String _FINDER_COLUMN_TOKEN_TOKEN_3 = "(pushNotificationsDevice.token IS NULL OR pushNotificationsDevice.token = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_P = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_P",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_P = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_P",
            new String[] { Long.class.getName(), String.class.getName() },
            PushNotificationsDeviceModelImpl.USERID_COLUMN_BITMASK |
            PushNotificationsDeviceModelImpl.PLATFORM_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_U_P = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_P",
            new String[] { Long.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_U_P = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByU_P",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_U_P_USERID_2 = "pushNotificationsDevice.userId = ? AND ";
    private static final String _FINDER_COLUMN_U_P_USERID_5 = "(" +
        removeConjunction(_FINDER_COLUMN_U_P_USERID_2) + ")";
    private static final String _FINDER_COLUMN_U_P_PLATFORM_1 = "pushNotificationsDevice.platform IS NULL";
    private static final String _FINDER_COLUMN_U_P_PLATFORM_2 = "pushNotificationsDevice.platform = ?";
    private static final String _FINDER_COLUMN_U_P_PLATFORM_3 = "(pushNotificationsDevice.platform IS NULL OR pushNotificationsDevice.platform = '')";
    private static final String _FINDER_COLUMN_U_P_PLATFORM_4 = "(" +
        removeConjunction(_FINDER_COLUMN_U_P_PLATFORM_1) + ")";
    private static final String _FINDER_COLUMN_U_P_PLATFORM_5 = "(" +
        removeConjunction(_FINDER_COLUMN_U_P_PLATFORM_2) + ")";
    private static final String _FINDER_COLUMN_U_P_PLATFORM_6 = "(" +
        removeConjunction(_FINDER_COLUMN_U_P_PLATFORM_3) + ")";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU",
            new String[] { Long.class.getName() },
            PushNotificationsDeviceModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_U = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_U = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByU",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_U_USERID_2 = "pushNotificationsDevice.userId = ?";
    private static final String _FINDER_COLUMN_U_USERID_5 = "(" +
        removeConjunction(_FINDER_COLUMN_U_USERID_2) + ")";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_AV = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_AV",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_AV = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_AV",
            new String[] { Long.class.getName(), String.class.getName() },
            PushNotificationsDeviceModelImpl.USERID_COLUMN_BITMASK |
            PushNotificationsDeviceModelImpl.APPVERSION_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_U_AV = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_AV",
            new String[] { Long.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_U_AV = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByU_AV",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_U_AV_USERID_2 = "pushNotificationsDevice.userId = ? AND ";
    private static final String _FINDER_COLUMN_U_AV_USERID_5 = "(" +
        removeConjunction(_FINDER_COLUMN_U_AV_USERID_2) + ")";
    private static final String _FINDER_COLUMN_U_AV_APPVERSION_1 = "pushNotificationsDevice.appVersion IS NULL";
    private static final String _FINDER_COLUMN_U_AV_APPVERSION_2 = "pushNotificationsDevice.appVersion = ?";
    private static final String _FINDER_COLUMN_U_AV_APPVERSION_3 = "(pushNotificationsDevice.appVersion IS NULL OR pushNotificationsDevice.appVersion = '')";
    private static final String _FINDER_COLUMN_U_AV_APPVERSION_4 = "(" +
        removeConjunction(_FINDER_COLUMN_U_AV_APPVERSION_1) + ")";
    private static final String _FINDER_COLUMN_U_AV_APPVERSION_5 = "(" +
        removeConjunction(_FINDER_COLUMN_U_AV_APPVERSION_2) + ")";
    private static final String _FINDER_COLUMN_U_AV_APPVERSION_6 = "(" +
        removeConjunction(_FINDER_COLUMN_U_AV_APPVERSION_3) + ")";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPVERSION =
        new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAppVersion",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPVERSION =
        new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAppVersion",
            new String[] { String.class.getName() },
            PushNotificationsDeviceModelImpl.APPVERSION_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_APPVERSION = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAppVersion",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_APPVERSION_APPVERSION_1 = "pushNotificationsDevice.appVersion IS NULL";
    private static final String _FINDER_COLUMN_APPVERSION_APPVERSION_2 = "pushNotificationsDevice.appVersion = ?";
    private static final String _FINDER_COLUMN_APPVERSION_APPVERSION_3 = "(pushNotificationsDevice.appVersion IS NULL OR pushNotificationsDevice.appVersion = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PLATFORM = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPlatform",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLATFORM =
        new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPlatform",
            new String[] { String.class.getName() },
            PushNotificationsDeviceModelImpl.PLATFORM_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PLATFORM = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPlatform",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_PLATFORM_PLATFORM_1 = "pushNotificationsDevice.platform IS NULL";
    private static final String _FINDER_COLUMN_PLATFORM_PLATFORM_2 = "pushNotificationsDevice.platform = ?";
    private static final String _FINDER_COLUMN_PLATFORM_PLATFORM_3 = "(pushNotificationsDevice.platform IS NULL OR pushNotificationsDevice.platform = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPID = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAppId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAppId",
            new String[] { Long.class.getName() },
            PushNotificationsDeviceModelImpl.APPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_APPID = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAppId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_APPID_APPID_2 = "pushNotificationsDevice.appId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_P_OSV = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_OSV",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_OSV = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_OSV",
            new String[] { String.class.getName(), String.class.getName() },
            PushNotificationsDeviceModelImpl.PLATFORM_COLUMN_BITMASK |
            PushNotificationsDeviceModelImpl.OSVERSION_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_P_OSV = new FinderPath(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_OSV",
            new String[] { String.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_P_OSV_PLATFORM_1 = "pushNotificationsDevice.platform IS NULL AND ";
    private static final String _FINDER_COLUMN_P_OSV_PLATFORM_2 = "pushNotificationsDevice.platform = ? AND ";
    private static final String _FINDER_COLUMN_P_OSV_PLATFORM_3 = "(pushNotificationsDevice.platform IS NULL OR pushNotificationsDevice.platform = '') AND ";
    private static final String _FINDER_COLUMN_P_OSV_OSVERSION_1 = "pushNotificationsDevice.OSVersion IS NULL";
    private static final String _FINDER_COLUMN_P_OSV_OSVERSION_2 = "pushNotificationsDevice.OSVersion = ?";
    private static final String _FINDER_COLUMN_P_OSV_OSVERSION_3 = "(pushNotificationsDevice.OSVersion IS NULL OR pushNotificationsDevice.OSVersion = '')";
    private static final String _SQL_SELECT_PUSHNOTIFICATIONSDEVICE = "SELECT pushNotificationsDevice FROM PushNotificationsDevice pushNotificationsDevice";
    private static final String _SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE = "SELECT pushNotificationsDevice FROM PushNotificationsDevice pushNotificationsDevice WHERE ";
    private static final String _SQL_COUNT_PUSHNOTIFICATIONSDEVICE = "SELECT COUNT(pushNotificationsDevice) FROM PushNotificationsDevice pushNotificationsDevice";
    private static final String _SQL_COUNT_PUSHNOTIFICATIONSDEVICE_WHERE = "SELECT COUNT(pushNotificationsDevice) FROM PushNotificationsDevice pushNotificationsDevice WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "pushNotificationsDevice.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PushNotificationsDevice exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PushNotificationsDevice exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(PushNotificationsDevicePersistenceImpl.class);
    private static PushNotificationsDevice _nullPushNotificationsDevice = new PushNotificationsDeviceImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<PushNotificationsDevice> toCacheModel() {
                return _nullPushNotificationsDeviceCacheModel;
            }
        };

    private static CacheModel<PushNotificationsDevice> _nullPushNotificationsDeviceCacheModel =
        new CacheModel<PushNotificationsDevice>() {
            @Override
            public PushNotificationsDevice toEntityModel() {
                return _nullPushNotificationsDevice;
            }
        };

    public PushNotificationsDevicePersistenceImpl() {
        setModelClass(PushNotificationsDevice.class);
    }

    /**
     * Returns the push notifications device where token = &#63; or throws a {@link com.liferay.pushnotifications.NoSuchDeviceException} if it could not be found.
     *
     * @param token the token
     * @return the matching push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByToken(String token)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByToken(token);

        if (pushNotificationsDevice == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("token=");
            msg.append(token);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchDeviceException(msg.toString());
        }

        return pushNotificationsDevice;
    }

    /**
     * Returns the push notifications device where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param token the token
     * @return the matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByToken(String token)
        throws SystemException {
        return fetchByToken(token, true);
    }

    /**
     * Returns the push notifications device where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param token the token
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByToken(String token,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { token };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TOKEN,
                    finderArgs, this);
        }

        if (result instanceof PushNotificationsDevice) {
            PushNotificationsDevice pushNotificationsDevice = (PushNotificationsDevice) result;

            if (!Validator.equals(token, pushNotificationsDevice.getToken())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

            boolean bindToken = false;

            if (token == null) {
                query.append(_FINDER_COLUMN_TOKEN_TOKEN_1);
            } else if (token.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TOKEN_TOKEN_3);
            } else {
                bindToken = true;

                query.append(_FINDER_COLUMN_TOKEN_TOKEN_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindToken) {
                    qPos.add(token);
                }

                List<PushNotificationsDevice> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
                        finderArgs, list);
                } else {
                    PushNotificationsDevice pushNotificationsDevice = list.get(0);

                    result = pushNotificationsDevice;

                    cacheResult(pushNotificationsDevice);

                    if ((pushNotificationsDevice.getToken() == null) ||
                            !pushNotificationsDevice.getToken().equals(token)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
                            finderArgs, pushNotificationsDevice);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (PushNotificationsDevice) result;
        }
    }

    /**
     * Removes the push notifications device where token = &#63; from the database.
     *
     * @param token the token
     * @return the push notifications device that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice removeByToken(String token)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = findByToken(token);

        return remove(pushNotificationsDevice);
    }

    /**
     * Returns the number of push notifications devices where token = &#63;.
     *
     * @param token the token
     * @return the number of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByToken(String token) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TOKEN;

        Object[] finderArgs = new Object[] { token };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PUSHNOTIFICATIONSDEVICE_WHERE);

            boolean bindToken = false;

            if (token == null) {
                query.append(_FINDER_COLUMN_TOKEN_TOKEN_1);
            } else if (token.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TOKEN_TOKEN_3);
            } else {
                bindToken = true;

                query.append(_FINDER_COLUMN_TOKEN_TOKEN_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindToken) {
                    qPos.add(token);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the push notifications devices where userId = &#63; and platform = &#63;.
     *
     * @param userId the user ID
     * @param platform the platform
     * @return the matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU_P(long userId, String platform)
        throws SystemException {
        return findByU_P(userId, platform, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the push notifications devices where userId = &#63; and platform = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param platform the platform
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @return the range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU_P(long userId,
        String platform, int start, int end) throws SystemException {
        return findByU_P(userId, platform, start, end, null);
    }

    /**
     * Returns an ordered range of all the push notifications devices where userId = &#63; and platform = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param platform the platform
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU_P(long userId,
        String platform, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_P;
            finderArgs = new Object[] { userId, platform };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_P;
            finderArgs = new Object[] {
                    userId, platform,
                    
                    start, end, orderByComparator
                };
        }

        List<PushNotificationsDevice> list = (List<PushNotificationsDevice>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (PushNotificationsDevice pushNotificationsDevice : list) {
                if ((userId != pushNotificationsDevice.getUserId()) ||
                        !Validator.equals(platform,
                            pushNotificationsDevice.getPlatform())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

            query.append(_FINDER_COLUMN_U_P_USERID_2);

            boolean bindPlatform = false;

            if (platform == null) {
                query.append(_FINDER_COLUMN_U_P_PLATFORM_1);
            } else if (platform.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_U_P_PLATFORM_3);
            } else {
                bindPlatform = true;

                query.append(_FINDER_COLUMN_U_P_PLATFORM_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (bindPlatform) {
                    qPos.add(platform);
                }

                if (!pagination) {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PushNotificationsDevice>(list);
                } else {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first push notifications device in the ordered set where userId = &#63; and platform = &#63;.
     *
     * @param userId the user ID
     * @param platform the platform
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByU_P_First(long userId,
        String platform, OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByU_P_First(userId,
                platform, orderByComparator);

        if (pushNotificationsDevice != null) {
            return pushNotificationsDevice;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", platform=");
        msg.append(platform);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDeviceException(msg.toString());
    }

    /**
     * Returns the first push notifications device in the ordered set where userId = &#63; and platform = &#63;.
     *
     * @param userId the user ID
     * @param platform the platform
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByU_P_First(long userId,
        String platform, OrderByComparator orderByComparator)
        throws SystemException {
        List<PushNotificationsDevice> list = findByU_P(userId, platform, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last push notifications device in the ordered set where userId = &#63; and platform = &#63;.
     *
     * @param userId the user ID
     * @param platform the platform
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByU_P_Last(long userId, String platform,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByU_P_Last(userId,
                platform, orderByComparator);

        if (pushNotificationsDevice != null) {
            return pushNotificationsDevice;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", platform=");
        msg.append(platform);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDeviceException(msg.toString());
    }

    /**
     * Returns the last push notifications device in the ordered set where userId = &#63; and platform = &#63;.
     *
     * @param userId the user ID
     * @param platform the platform
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByU_P_Last(long userId,
        String platform, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByU_P(userId, platform);

        if (count == 0) {
            return null;
        }

        List<PushNotificationsDevice> list = findByU_P(userId, platform,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the push notifications devices before and after the current push notifications device in the ordered set where userId = &#63; and platform = &#63;.
     *
     * @param pushNotificationsDeviceId the primary key of the current push notifications device
     * @param userId the user ID
     * @param platform the platform
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice[] findByU_P_PrevAndNext(
        long pushNotificationsDeviceId, long userId, String platform,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = findByPrimaryKey(pushNotificationsDeviceId);

        Session session = null;

        try {
            session = openSession();

            PushNotificationsDevice[] array = new PushNotificationsDeviceImpl[3];

            array[0] = getByU_P_PrevAndNext(session, pushNotificationsDevice,
                    userId, platform, orderByComparator, true);

            array[1] = pushNotificationsDevice;

            array[2] = getByU_P_PrevAndNext(session, pushNotificationsDevice,
                    userId, platform, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected PushNotificationsDevice getByU_P_PrevAndNext(Session session,
        PushNotificationsDevice pushNotificationsDevice, long userId,
        String platform, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

        query.append(_FINDER_COLUMN_U_P_USERID_2);

        boolean bindPlatform = false;

        if (platform == null) {
            query.append(_FINDER_COLUMN_U_P_PLATFORM_1);
        } else if (platform.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_U_P_PLATFORM_3);
        } else {
            bindPlatform = true;

            query.append(_FINDER_COLUMN_U_P_PLATFORM_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (bindPlatform) {
            qPos.add(platform);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(pushNotificationsDevice);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<PushNotificationsDevice> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the push notifications devices where userId = any &#63; and platform = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userIds the user IDs
     * @param platform the platform
     * @return the matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU_P(long[] userIds,
        String platform) throws SystemException {
        return findByU_P(userIds, platform, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the push notifications devices where userId = any &#63; and platform = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userIds the user IDs
     * @param platform the platform
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @return the range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU_P(long[] userIds,
        String platform, int start, int end) throws SystemException {
        return findByU_P(userIds, platform, start, end, null);
    }

    /**
     * Returns an ordered range of all the push notifications devices where userId = any &#63; and platform = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userIds the user IDs
     * @param platform the platform
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU_P(long[] userIds,
        String platform, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        if ((userIds != null) && (userIds.length == 1)) {
            return findByU_P(userIds[0], platform, start, end, orderByComparator);
        }

        boolean pagination = true;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderArgs = new Object[] { StringUtil.merge(userIds), platform };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(userIds), platform,
                    
                    start, end, orderByComparator
                };
        }

        List<PushNotificationsDevice> list = (List<PushNotificationsDevice>) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_U_P,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (PushNotificationsDevice pushNotificationsDevice : list) {
                if (!ArrayUtil.contains(userIds,
                            pushNotificationsDevice.getUserId()) ||
                        !Validator.equals(platform,
                            pushNotificationsDevice.getPlatform())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

            boolean conjunctionable = false;

            if ((userIds == null) || (userIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < userIds.length; i++) {
                    query.append(_FINDER_COLUMN_U_P_USERID_5);

                    if ((i + 1) < userIds.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            boolean bindPlatform = false;

            if (platform == null) {
                query.append(_FINDER_COLUMN_U_P_PLATFORM_4);
            } else if (platform.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_U_P_PLATFORM_6);
            } else {
                bindPlatform = true;

                query.append(_FINDER_COLUMN_U_P_PLATFORM_5);
            }

            conjunctionable = true;

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userIds != null) {
                    qPos.add(userIds);
                }

                if (bindPlatform) {
                    qPos.add(platform);
                }

                if (!pagination) {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PushNotificationsDevice>(list);
                } else {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_U_P,
                    finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_U_P,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the push notifications devices where userId = &#63; and platform = &#63; from the database.
     *
     * @param userId the user ID
     * @param platform the platform
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByU_P(long userId, String platform)
        throws SystemException {
        for (PushNotificationsDevice pushNotificationsDevice : findByU_P(
                userId, platform, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(pushNotificationsDevice);
        }
    }

    /**
     * Returns the number of push notifications devices where userId = &#63; and platform = &#63;.
     *
     * @param userId the user ID
     * @param platform the platform
     * @return the number of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByU_P(long userId, String platform)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_U_P;

        Object[] finderArgs = new Object[] { userId, platform };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_PUSHNOTIFICATIONSDEVICE_WHERE);

            query.append(_FINDER_COLUMN_U_P_USERID_2);

            boolean bindPlatform = false;

            if (platform == null) {
                query.append(_FINDER_COLUMN_U_P_PLATFORM_1);
            } else if (platform.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_U_P_PLATFORM_3);
            } else {
                bindPlatform = true;

                query.append(_FINDER_COLUMN_U_P_PLATFORM_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (bindPlatform) {
                    qPos.add(platform);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of push notifications devices where userId = any &#63; and platform = &#63;.
     *
     * @param userIds the user IDs
     * @param platform the platform
     * @return the number of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByU_P(long[] userIds, String platform)
        throws SystemException {
        Object[] finderArgs = new Object[] { StringUtil.merge(userIds), platform };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_U_P,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_PUSHNOTIFICATIONSDEVICE_WHERE);

            boolean conjunctionable = false;

            if ((userIds == null) || (userIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < userIds.length; i++) {
                    query.append(_FINDER_COLUMN_U_P_USERID_5);

                    if ((i + 1) < userIds.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            boolean bindPlatform = false;

            if (platform == null) {
                query.append(_FINDER_COLUMN_U_P_PLATFORM_4);
            } else if (platform.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_U_P_PLATFORM_6);
            } else {
                bindPlatform = true;

                query.append(_FINDER_COLUMN_U_P_PLATFORM_5);
            }

            conjunctionable = true;

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userIds != null) {
                    qPos.add(userIds);
                }

                if (bindPlatform) {
                    qPos.add(platform);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_U_P,
                    finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_U_P,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the push notifications devices where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU(long userId)
        throws SystemException {
        return findByU(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the push notifications devices where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @return the range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU(long userId, int start, int end)
        throws SystemException {
        return findByU(userId, start, end, null);
    }

    /**
     * Returns an ordered range of all the push notifications devices where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU(long userId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<PushNotificationsDevice> list = (List<PushNotificationsDevice>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (PushNotificationsDevice pushNotificationsDevice : list) {
                if ((userId != pushNotificationsDevice.getUserId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

            query.append(_FINDER_COLUMN_U_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PushNotificationsDevice>(list);
                } else {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first push notifications device in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByU_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByU_First(userId,
                orderByComparator);

        if (pushNotificationsDevice != null) {
            return pushNotificationsDevice;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDeviceException(msg.toString());
    }

    /**
     * Returns the first push notifications device in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByU_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<PushNotificationsDevice> list = findByU(userId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last push notifications device in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByU_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByU_Last(userId,
                orderByComparator);

        if (pushNotificationsDevice != null) {
            return pushNotificationsDevice;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDeviceException(msg.toString());
    }

    /**
     * Returns the last push notifications device in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByU_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByU(userId);

        if (count == 0) {
            return null;
        }

        List<PushNotificationsDevice> list = findByU(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the push notifications devices before and after the current push notifications device in the ordered set where userId = &#63;.
     *
     * @param pushNotificationsDeviceId the primary key of the current push notifications device
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice[] findByU_PrevAndNext(
        long pushNotificationsDeviceId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = findByPrimaryKey(pushNotificationsDeviceId);

        Session session = null;

        try {
            session = openSession();

            PushNotificationsDevice[] array = new PushNotificationsDeviceImpl[3];

            array[0] = getByU_PrevAndNext(session, pushNotificationsDevice,
                    userId, orderByComparator, true);

            array[1] = pushNotificationsDevice;

            array[2] = getByU_PrevAndNext(session, pushNotificationsDevice,
                    userId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected PushNotificationsDevice getByU_PrevAndNext(Session session,
        PushNotificationsDevice pushNotificationsDevice, long userId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

        query.append(_FINDER_COLUMN_U_USERID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(pushNotificationsDevice);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<PushNotificationsDevice> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the push notifications devices where userId = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userIds the user IDs
     * @return the matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU(long[] userIds)
        throws SystemException {
        return findByU(userIds, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the push notifications devices where userId = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userIds the user IDs
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @return the range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU(long[] userIds, int start,
        int end) throws SystemException {
        return findByU(userIds, start, end, null);
    }

    /**
     * Returns an ordered range of all the push notifications devices where userId = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userIds the user IDs
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU(long[] userIds, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        if ((userIds != null) && (userIds.length == 1)) {
            return findByU(userIds[0], start, end, orderByComparator);
        }

        boolean pagination = true;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderArgs = new Object[] { StringUtil.merge(userIds) };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(userIds),
                    
                    start, end, orderByComparator
                };
        }

        List<PushNotificationsDevice> list = (List<PushNotificationsDevice>) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_U,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (PushNotificationsDevice pushNotificationsDevice : list) {
                if (!ArrayUtil.contains(userIds,
                            pushNotificationsDevice.getUserId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

            boolean conjunctionable = false;

            if ((userIds == null) || (userIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < userIds.length; i++) {
                    query.append(_FINDER_COLUMN_U_USERID_5);

                    if ((i + 1) < userIds.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userIds != null) {
                    qPos.add(userIds);
                }

                if (!pagination) {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PushNotificationsDevice>(list);
                } else {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_U,
                    finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_U,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the push notifications devices where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByU(long userId) throws SystemException {
        for (PushNotificationsDevice pushNotificationsDevice : findByU(userId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(pushNotificationsDevice);
        }
    }

    /**
     * Returns the number of push notifications devices where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByU(long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_U;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PUSHNOTIFICATIONSDEVICE_WHERE);

            query.append(_FINDER_COLUMN_U_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of push notifications devices where userId = any &#63;.
     *
     * @param userIds the user IDs
     * @return the number of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByU(long[] userIds) throws SystemException {
        Object[] finderArgs = new Object[] { StringUtil.merge(userIds) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_U,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_PUSHNOTIFICATIONSDEVICE_WHERE);

            boolean conjunctionable = false;

            if ((userIds == null) || (userIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < userIds.length; i++) {
                    query.append(_FINDER_COLUMN_U_USERID_5);

                    if ((i + 1) < userIds.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userIds != null) {
                    qPos.add(userIds);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_U,
                    finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_U,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the push notifications devices where userId = &#63; and appVersion = &#63;.
     *
     * @param userId the user ID
     * @param appVersion the app version
     * @return the matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU_AV(long userId,
        String appVersion) throws SystemException {
        return findByU_AV(userId, appVersion, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the push notifications devices where userId = &#63; and appVersion = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param appVersion the app version
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @return the range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU_AV(long userId,
        String appVersion, int start, int end) throws SystemException {
        return findByU_AV(userId, appVersion, start, end, null);
    }

    /**
     * Returns an ordered range of all the push notifications devices where userId = &#63; and appVersion = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param appVersion the app version
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU_AV(long userId,
        String appVersion, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_AV;
            finderArgs = new Object[] { userId, appVersion };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_AV;
            finderArgs = new Object[] {
                    userId, appVersion,
                    
                    start, end, orderByComparator
                };
        }

        List<PushNotificationsDevice> list = (List<PushNotificationsDevice>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (PushNotificationsDevice pushNotificationsDevice : list) {
                if ((userId != pushNotificationsDevice.getUserId()) ||
                        !Validator.equals(appVersion,
                            pushNotificationsDevice.getAppVersion())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

            query.append(_FINDER_COLUMN_U_AV_USERID_2);

            boolean bindAppVersion = false;

            if (appVersion == null) {
                query.append(_FINDER_COLUMN_U_AV_APPVERSION_1);
            } else if (appVersion.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_U_AV_APPVERSION_3);
            } else {
                bindAppVersion = true;

                query.append(_FINDER_COLUMN_U_AV_APPVERSION_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (bindAppVersion) {
                    qPos.add(appVersion);
                }

                if (!pagination) {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PushNotificationsDevice>(list);
                } else {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first push notifications device in the ordered set where userId = &#63; and appVersion = &#63;.
     *
     * @param userId the user ID
     * @param appVersion the app version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByU_AV_First(long userId,
        String appVersion, OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByU_AV_First(userId,
                appVersion, orderByComparator);

        if (pushNotificationsDevice != null) {
            return pushNotificationsDevice;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", appVersion=");
        msg.append(appVersion);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDeviceException(msg.toString());
    }

    /**
     * Returns the first push notifications device in the ordered set where userId = &#63; and appVersion = &#63;.
     *
     * @param userId the user ID
     * @param appVersion the app version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByU_AV_First(long userId,
        String appVersion, OrderByComparator orderByComparator)
        throws SystemException {
        List<PushNotificationsDevice> list = findByU_AV(userId, appVersion, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last push notifications device in the ordered set where userId = &#63; and appVersion = &#63;.
     *
     * @param userId the user ID
     * @param appVersion the app version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByU_AV_Last(long userId,
        String appVersion, OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByU_AV_Last(userId,
                appVersion, orderByComparator);

        if (pushNotificationsDevice != null) {
            return pushNotificationsDevice;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", appVersion=");
        msg.append(appVersion);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDeviceException(msg.toString());
    }

    /**
     * Returns the last push notifications device in the ordered set where userId = &#63; and appVersion = &#63;.
     *
     * @param userId the user ID
     * @param appVersion the app version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByU_AV_Last(long userId,
        String appVersion, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByU_AV(userId, appVersion);

        if (count == 0) {
            return null;
        }

        List<PushNotificationsDevice> list = findByU_AV(userId, appVersion,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the push notifications devices before and after the current push notifications device in the ordered set where userId = &#63; and appVersion = &#63;.
     *
     * @param pushNotificationsDeviceId the primary key of the current push notifications device
     * @param userId the user ID
     * @param appVersion the app version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice[] findByU_AV_PrevAndNext(
        long pushNotificationsDeviceId, long userId, String appVersion,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = findByPrimaryKey(pushNotificationsDeviceId);

        Session session = null;

        try {
            session = openSession();

            PushNotificationsDevice[] array = new PushNotificationsDeviceImpl[3];

            array[0] = getByU_AV_PrevAndNext(session, pushNotificationsDevice,
                    userId, appVersion, orderByComparator, true);

            array[1] = pushNotificationsDevice;

            array[2] = getByU_AV_PrevAndNext(session, pushNotificationsDevice,
                    userId, appVersion, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected PushNotificationsDevice getByU_AV_PrevAndNext(Session session,
        PushNotificationsDevice pushNotificationsDevice, long userId,
        String appVersion, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

        query.append(_FINDER_COLUMN_U_AV_USERID_2);

        boolean bindAppVersion = false;

        if (appVersion == null) {
            query.append(_FINDER_COLUMN_U_AV_APPVERSION_1);
        } else if (appVersion.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_U_AV_APPVERSION_3);
        } else {
            bindAppVersion = true;

            query.append(_FINDER_COLUMN_U_AV_APPVERSION_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (bindAppVersion) {
            qPos.add(appVersion);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(pushNotificationsDevice);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<PushNotificationsDevice> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the push notifications devices where userId = any &#63; and appVersion = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userIds the user IDs
     * @param appVersion the app version
     * @return the matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU_AV(long[] userIds,
        String appVersion) throws SystemException {
        return findByU_AV(userIds, appVersion, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the push notifications devices where userId = any &#63; and appVersion = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userIds the user IDs
     * @param appVersion the app version
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @return the range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU_AV(long[] userIds,
        String appVersion, int start, int end) throws SystemException {
        return findByU_AV(userIds, appVersion, start, end, null);
    }

    /**
     * Returns an ordered range of all the push notifications devices where userId = any &#63; and appVersion = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userIds the user IDs
     * @param appVersion the app version
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByU_AV(long[] userIds,
        String appVersion, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        if ((userIds != null) && (userIds.length == 1)) {
            return findByU_AV(userIds[0], appVersion, start, end,
                orderByComparator);
        }

        boolean pagination = true;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderArgs = new Object[] { StringUtil.merge(userIds), appVersion };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(userIds), appVersion,
                    
                    start, end, orderByComparator
                };
        }

        List<PushNotificationsDevice> list = (List<PushNotificationsDevice>) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_U_AV,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (PushNotificationsDevice pushNotificationsDevice : list) {
                if (!ArrayUtil.contains(userIds,
                            pushNotificationsDevice.getUserId()) ||
                        !Validator.equals(appVersion,
                            pushNotificationsDevice.getAppVersion())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

            boolean conjunctionable = false;

            if ((userIds == null) || (userIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < userIds.length; i++) {
                    query.append(_FINDER_COLUMN_U_AV_USERID_5);

                    if ((i + 1) < userIds.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            boolean bindAppVersion = false;

            if (appVersion == null) {
                query.append(_FINDER_COLUMN_U_AV_APPVERSION_4);
            } else if (appVersion.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_U_AV_APPVERSION_6);
            } else {
                bindAppVersion = true;

                query.append(_FINDER_COLUMN_U_AV_APPVERSION_5);
            }

            conjunctionable = true;

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userIds != null) {
                    qPos.add(userIds);
                }

                if (bindAppVersion) {
                    qPos.add(appVersion);
                }

                if (!pagination) {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PushNotificationsDevice>(list);
                } else {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_U_AV,
                    finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_U_AV,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the push notifications devices where userId = &#63; and appVersion = &#63; from the database.
     *
     * @param userId the user ID
     * @param appVersion the app version
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByU_AV(long userId, String appVersion)
        throws SystemException {
        for (PushNotificationsDevice pushNotificationsDevice : findByU_AV(
                userId, appVersion, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(pushNotificationsDevice);
        }
    }

    /**
     * Returns the number of push notifications devices where userId = &#63; and appVersion = &#63;.
     *
     * @param userId the user ID
     * @param appVersion the app version
     * @return the number of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByU_AV(long userId, String appVersion)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_U_AV;

        Object[] finderArgs = new Object[] { userId, appVersion };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_PUSHNOTIFICATIONSDEVICE_WHERE);

            query.append(_FINDER_COLUMN_U_AV_USERID_2);

            boolean bindAppVersion = false;

            if (appVersion == null) {
                query.append(_FINDER_COLUMN_U_AV_APPVERSION_1);
            } else if (appVersion.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_U_AV_APPVERSION_3);
            } else {
                bindAppVersion = true;

                query.append(_FINDER_COLUMN_U_AV_APPVERSION_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (bindAppVersion) {
                    qPos.add(appVersion);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of push notifications devices where userId = any &#63; and appVersion = &#63;.
     *
     * @param userIds the user IDs
     * @param appVersion the app version
     * @return the number of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByU_AV(long[] userIds, String appVersion)
        throws SystemException {
        Object[] finderArgs = new Object[] { StringUtil.merge(userIds), appVersion };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_U_AV,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_PUSHNOTIFICATIONSDEVICE_WHERE);

            boolean conjunctionable = false;

            if ((userIds == null) || (userIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < userIds.length; i++) {
                    query.append(_FINDER_COLUMN_U_AV_USERID_5);

                    if ((i + 1) < userIds.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            boolean bindAppVersion = false;

            if (appVersion == null) {
                query.append(_FINDER_COLUMN_U_AV_APPVERSION_4);
            } else if (appVersion.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_U_AV_APPVERSION_6);
            } else {
                bindAppVersion = true;

                query.append(_FINDER_COLUMN_U_AV_APPVERSION_5);
            }

            conjunctionable = true;

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userIds != null) {
                    qPos.add(userIds);
                }

                if (bindAppVersion) {
                    qPos.add(appVersion);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_U_AV,
                    finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_U_AV,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the push notifications devices where appVersion = &#63;.
     *
     * @param appVersion the app version
     * @return the matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByAppVersion(String appVersion)
        throws SystemException {
        return findByAppVersion(appVersion, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the push notifications devices where appVersion = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param appVersion the app version
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @return the range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByAppVersion(String appVersion,
        int start, int end) throws SystemException {
        return findByAppVersion(appVersion, start, end, null);
    }

    /**
     * Returns an ordered range of all the push notifications devices where appVersion = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param appVersion the app version
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByAppVersion(String appVersion,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPVERSION;
            finderArgs = new Object[] { appVersion };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPVERSION;
            finderArgs = new Object[] { appVersion, start, end, orderByComparator };
        }

        List<PushNotificationsDevice> list = (List<PushNotificationsDevice>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (PushNotificationsDevice pushNotificationsDevice : list) {
                if (!Validator.equals(appVersion,
                            pushNotificationsDevice.getAppVersion())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

            boolean bindAppVersion = false;

            if (appVersion == null) {
                query.append(_FINDER_COLUMN_APPVERSION_APPVERSION_1);
            } else if (appVersion.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_APPVERSION_APPVERSION_3);
            } else {
                bindAppVersion = true;

                query.append(_FINDER_COLUMN_APPVERSION_APPVERSION_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindAppVersion) {
                    qPos.add(appVersion);
                }

                if (!pagination) {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PushNotificationsDevice>(list);
                } else {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first push notifications device in the ordered set where appVersion = &#63;.
     *
     * @param appVersion the app version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByAppVersion_First(String appVersion,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByAppVersion_First(appVersion,
                orderByComparator);

        if (pushNotificationsDevice != null) {
            return pushNotificationsDevice;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("appVersion=");
        msg.append(appVersion);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDeviceException(msg.toString());
    }

    /**
     * Returns the first push notifications device in the ordered set where appVersion = &#63;.
     *
     * @param appVersion the app version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByAppVersion_First(String appVersion,
        OrderByComparator orderByComparator) throws SystemException {
        List<PushNotificationsDevice> list = findByAppVersion(appVersion, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last push notifications device in the ordered set where appVersion = &#63;.
     *
     * @param appVersion the app version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByAppVersion_Last(String appVersion,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByAppVersion_Last(appVersion,
                orderByComparator);

        if (pushNotificationsDevice != null) {
            return pushNotificationsDevice;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("appVersion=");
        msg.append(appVersion);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDeviceException(msg.toString());
    }

    /**
     * Returns the last push notifications device in the ordered set where appVersion = &#63;.
     *
     * @param appVersion the app version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByAppVersion_Last(String appVersion,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByAppVersion(appVersion);

        if (count == 0) {
            return null;
        }

        List<PushNotificationsDevice> list = findByAppVersion(appVersion,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the push notifications devices before and after the current push notifications device in the ordered set where appVersion = &#63;.
     *
     * @param pushNotificationsDeviceId the primary key of the current push notifications device
     * @param appVersion the app version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice[] findByAppVersion_PrevAndNext(
        long pushNotificationsDeviceId, String appVersion,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = findByPrimaryKey(pushNotificationsDeviceId);

        Session session = null;

        try {
            session = openSession();

            PushNotificationsDevice[] array = new PushNotificationsDeviceImpl[3];

            array[0] = getByAppVersion_PrevAndNext(session,
                    pushNotificationsDevice, appVersion, orderByComparator, true);

            array[1] = pushNotificationsDevice;

            array[2] = getByAppVersion_PrevAndNext(session,
                    pushNotificationsDevice, appVersion, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected PushNotificationsDevice getByAppVersion_PrevAndNext(
        Session session, PushNotificationsDevice pushNotificationsDevice,
        String appVersion, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

        boolean bindAppVersion = false;

        if (appVersion == null) {
            query.append(_FINDER_COLUMN_APPVERSION_APPVERSION_1);
        } else if (appVersion.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_APPVERSION_APPVERSION_3);
        } else {
            bindAppVersion = true;

            query.append(_FINDER_COLUMN_APPVERSION_APPVERSION_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindAppVersion) {
            qPos.add(appVersion);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(pushNotificationsDevice);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<PushNotificationsDevice> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the push notifications devices where appVersion = &#63; from the database.
     *
     * @param appVersion the app version
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAppVersion(String appVersion) throws SystemException {
        for (PushNotificationsDevice pushNotificationsDevice : findByAppVersion(
                appVersion, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(pushNotificationsDevice);
        }
    }

    /**
     * Returns the number of push notifications devices where appVersion = &#63;.
     *
     * @param appVersion the app version
     * @return the number of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByAppVersion(String appVersion) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_APPVERSION;

        Object[] finderArgs = new Object[] { appVersion };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PUSHNOTIFICATIONSDEVICE_WHERE);

            boolean bindAppVersion = false;

            if (appVersion == null) {
                query.append(_FINDER_COLUMN_APPVERSION_APPVERSION_1);
            } else if (appVersion.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_APPVERSION_APPVERSION_3);
            } else {
                bindAppVersion = true;

                query.append(_FINDER_COLUMN_APPVERSION_APPVERSION_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindAppVersion) {
                    qPos.add(appVersion);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the push notifications devices where platform = &#63;.
     *
     * @param platform the platform
     * @return the matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByPlatform(String platform)
        throws SystemException {
        return findByPlatform(platform, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the push notifications devices where platform = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param platform the platform
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @return the range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByPlatform(String platform,
        int start, int end) throws SystemException {
        return findByPlatform(platform, start, end, null);
    }

    /**
     * Returns an ordered range of all the push notifications devices where platform = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param platform the platform
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByPlatform(String platform,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLATFORM;
            finderArgs = new Object[] { platform };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PLATFORM;
            finderArgs = new Object[] { platform, start, end, orderByComparator };
        }

        List<PushNotificationsDevice> list = (List<PushNotificationsDevice>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (PushNotificationsDevice pushNotificationsDevice : list) {
                if (!Validator.equals(platform,
                            pushNotificationsDevice.getPlatform())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

            boolean bindPlatform = false;

            if (platform == null) {
                query.append(_FINDER_COLUMN_PLATFORM_PLATFORM_1);
            } else if (platform.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PLATFORM_PLATFORM_3);
            } else {
                bindPlatform = true;

                query.append(_FINDER_COLUMN_PLATFORM_PLATFORM_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindPlatform) {
                    qPos.add(platform);
                }

                if (!pagination) {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PushNotificationsDevice>(list);
                } else {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first push notifications device in the ordered set where platform = &#63;.
     *
     * @param platform the platform
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByPlatform_First(String platform,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByPlatform_First(platform,
                orderByComparator);

        if (pushNotificationsDevice != null) {
            return pushNotificationsDevice;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("platform=");
        msg.append(platform);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDeviceException(msg.toString());
    }

    /**
     * Returns the first push notifications device in the ordered set where platform = &#63;.
     *
     * @param platform the platform
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByPlatform_First(String platform,
        OrderByComparator orderByComparator) throws SystemException {
        List<PushNotificationsDevice> list = findByPlatform(platform, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last push notifications device in the ordered set where platform = &#63;.
     *
     * @param platform the platform
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByPlatform_Last(String platform,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByPlatform_Last(platform,
                orderByComparator);

        if (pushNotificationsDevice != null) {
            return pushNotificationsDevice;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("platform=");
        msg.append(platform);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDeviceException(msg.toString());
    }

    /**
     * Returns the last push notifications device in the ordered set where platform = &#63;.
     *
     * @param platform the platform
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByPlatform_Last(String platform,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPlatform(platform);

        if (count == 0) {
            return null;
        }

        List<PushNotificationsDevice> list = findByPlatform(platform,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the push notifications devices before and after the current push notifications device in the ordered set where platform = &#63;.
     *
     * @param pushNotificationsDeviceId the primary key of the current push notifications device
     * @param platform the platform
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice[] findByPlatform_PrevAndNext(
        long pushNotificationsDeviceId, String platform,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = findByPrimaryKey(pushNotificationsDeviceId);

        Session session = null;

        try {
            session = openSession();

            PushNotificationsDevice[] array = new PushNotificationsDeviceImpl[3];

            array[0] = getByPlatform_PrevAndNext(session,
                    pushNotificationsDevice, platform, orderByComparator, true);

            array[1] = pushNotificationsDevice;

            array[2] = getByPlatform_PrevAndNext(session,
                    pushNotificationsDevice, platform, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected PushNotificationsDevice getByPlatform_PrevAndNext(
        Session session, PushNotificationsDevice pushNotificationsDevice,
        String platform, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

        boolean bindPlatform = false;

        if (platform == null) {
            query.append(_FINDER_COLUMN_PLATFORM_PLATFORM_1);
        } else if (platform.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_PLATFORM_PLATFORM_3);
        } else {
            bindPlatform = true;

            query.append(_FINDER_COLUMN_PLATFORM_PLATFORM_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindPlatform) {
            qPos.add(platform);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(pushNotificationsDevice);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<PushNotificationsDevice> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the push notifications devices where platform = &#63; from the database.
     *
     * @param platform the platform
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPlatform(String platform) throws SystemException {
        for (PushNotificationsDevice pushNotificationsDevice : findByPlatform(
                platform, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(pushNotificationsDevice);
        }
    }

    /**
     * Returns the number of push notifications devices where platform = &#63;.
     *
     * @param platform the platform
     * @return the number of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPlatform(String platform) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PLATFORM;

        Object[] finderArgs = new Object[] { platform };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PUSHNOTIFICATIONSDEVICE_WHERE);

            boolean bindPlatform = false;

            if (platform == null) {
                query.append(_FINDER_COLUMN_PLATFORM_PLATFORM_1);
            } else if (platform.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PLATFORM_PLATFORM_3);
            } else {
                bindPlatform = true;

                query.append(_FINDER_COLUMN_PLATFORM_PLATFORM_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindPlatform) {
                    qPos.add(platform);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the push notifications devices where appId = &#63;.
     *
     * @param appId the app ID
     * @return the matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByAppId(long appId)
        throws SystemException {
        return findByAppId(appId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the push notifications devices where appId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param appId the app ID
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @return the range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByAppId(long appId, int start,
        int end) throws SystemException {
        return findByAppId(appId, start, end, null);
    }

    /**
     * Returns an ordered range of all the push notifications devices where appId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param appId the app ID
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByAppId(long appId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID;
            finderArgs = new Object[] { appId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPID;
            finderArgs = new Object[] { appId, start, end, orderByComparator };
        }

        List<PushNotificationsDevice> list = (List<PushNotificationsDevice>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (PushNotificationsDevice pushNotificationsDevice : list) {
                if ((appId != pushNotificationsDevice.getAppId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

            query.append(_FINDER_COLUMN_APPID_APPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(appId);

                if (!pagination) {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PushNotificationsDevice>(list);
                } else {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first push notifications device in the ordered set where appId = &#63;.
     *
     * @param appId the app ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByAppId_First(long appId,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByAppId_First(appId,
                orderByComparator);

        if (pushNotificationsDevice != null) {
            return pushNotificationsDevice;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("appId=");
        msg.append(appId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDeviceException(msg.toString());
    }

    /**
     * Returns the first push notifications device in the ordered set where appId = &#63;.
     *
     * @param appId the app ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByAppId_First(long appId,
        OrderByComparator orderByComparator) throws SystemException {
        List<PushNotificationsDevice> list = findByAppId(appId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last push notifications device in the ordered set where appId = &#63;.
     *
     * @param appId the app ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByAppId_Last(long appId,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByAppId_Last(appId,
                orderByComparator);

        if (pushNotificationsDevice != null) {
            return pushNotificationsDevice;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("appId=");
        msg.append(appId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDeviceException(msg.toString());
    }

    /**
     * Returns the last push notifications device in the ordered set where appId = &#63;.
     *
     * @param appId the app ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByAppId_Last(long appId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByAppId(appId);

        if (count == 0) {
            return null;
        }

        List<PushNotificationsDevice> list = findByAppId(appId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the push notifications devices before and after the current push notifications device in the ordered set where appId = &#63;.
     *
     * @param pushNotificationsDeviceId the primary key of the current push notifications device
     * @param appId the app ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice[] findByAppId_PrevAndNext(
        long pushNotificationsDeviceId, long appId,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = findByPrimaryKey(pushNotificationsDeviceId);

        Session session = null;

        try {
            session = openSession();

            PushNotificationsDevice[] array = new PushNotificationsDeviceImpl[3];

            array[0] = getByAppId_PrevAndNext(session, pushNotificationsDevice,
                    appId, orderByComparator, true);

            array[1] = pushNotificationsDevice;

            array[2] = getByAppId_PrevAndNext(session, pushNotificationsDevice,
                    appId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected PushNotificationsDevice getByAppId_PrevAndNext(Session session,
        PushNotificationsDevice pushNotificationsDevice, long appId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

        query.append(_FINDER_COLUMN_APPID_APPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(appId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(pushNotificationsDevice);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<PushNotificationsDevice> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the push notifications devices where appId = &#63; from the database.
     *
     * @param appId the app ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAppId(long appId) throws SystemException {
        for (PushNotificationsDevice pushNotificationsDevice : findByAppId(
                appId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(pushNotificationsDevice);
        }
    }

    /**
     * Returns the number of push notifications devices where appId = &#63;.
     *
     * @param appId the app ID
     * @return the number of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByAppId(long appId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_APPID;

        Object[] finderArgs = new Object[] { appId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PUSHNOTIFICATIONSDEVICE_WHERE);

            query.append(_FINDER_COLUMN_APPID_APPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(appId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the push notifications devices where platform = &#63; and OSVersion = &#63;.
     *
     * @param platform the platform
     * @param OSVersion the o s version
     * @return the matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByP_OSV(String platform,
        String OSVersion) throws SystemException {
        return findByP_OSV(platform, OSVersion, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the push notifications devices where platform = &#63; and OSVersion = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param platform the platform
     * @param OSVersion the o s version
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @return the range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByP_OSV(String platform,
        String OSVersion, int start, int end) throws SystemException {
        return findByP_OSV(platform, OSVersion, start, end, null);
    }

    /**
     * Returns an ordered range of all the push notifications devices where platform = &#63; and OSVersion = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param platform the platform
     * @param OSVersion the o s version
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findByP_OSV(String platform,
        String OSVersion, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_OSV;
            finderArgs = new Object[] { platform, OSVersion };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_P_OSV;
            finderArgs = new Object[] {
                    platform, OSVersion,
                    
                    start, end, orderByComparator
                };
        }

        List<PushNotificationsDevice> list = (List<PushNotificationsDevice>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (PushNotificationsDevice pushNotificationsDevice : list) {
                if (!Validator.equals(platform,
                            pushNotificationsDevice.getPlatform()) ||
                        !Validator.equals(OSVersion,
                            pushNotificationsDevice.getOSVersion())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

            boolean bindPlatform = false;

            if (platform == null) {
                query.append(_FINDER_COLUMN_P_OSV_PLATFORM_1);
            } else if (platform.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_P_OSV_PLATFORM_3);
            } else {
                bindPlatform = true;

                query.append(_FINDER_COLUMN_P_OSV_PLATFORM_2);
            }

            boolean bindOSVersion = false;

            if (OSVersion == null) {
                query.append(_FINDER_COLUMN_P_OSV_OSVERSION_1);
            } else if (OSVersion.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_P_OSV_OSVERSION_3);
            } else {
                bindOSVersion = true;

                query.append(_FINDER_COLUMN_P_OSV_OSVERSION_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindPlatform) {
                    qPos.add(platform);
                }

                if (bindOSVersion) {
                    qPos.add(OSVersion);
                }

                if (!pagination) {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PushNotificationsDevice>(list);
                } else {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first push notifications device in the ordered set where platform = &#63; and OSVersion = &#63;.
     *
     * @param platform the platform
     * @param OSVersion the o s version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByP_OSV_First(String platform,
        String OSVersion, OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByP_OSV_First(platform,
                OSVersion, orderByComparator);

        if (pushNotificationsDevice != null) {
            return pushNotificationsDevice;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("platform=");
        msg.append(platform);

        msg.append(", OSVersion=");
        msg.append(OSVersion);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDeviceException(msg.toString());
    }

    /**
     * Returns the first push notifications device in the ordered set where platform = &#63; and OSVersion = &#63;.
     *
     * @param platform the platform
     * @param OSVersion the o s version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByP_OSV_First(String platform,
        String OSVersion, OrderByComparator orderByComparator)
        throws SystemException {
        List<PushNotificationsDevice> list = findByP_OSV(platform, OSVersion,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last push notifications device in the ordered set where platform = &#63; and OSVersion = &#63;.
     *
     * @param platform the platform
     * @param OSVersion the o s version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByP_OSV_Last(String platform,
        String OSVersion, OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByP_OSV_Last(platform,
                OSVersion, orderByComparator);

        if (pushNotificationsDevice != null) {
            return pushNotificationsDevice;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("platform=");
        msg.append(platform);

        msg.append(", OSVersion=");
        msg.append(OSVersion);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDeviceException(msg.toString());
    }

    /**
     * Returns the last push notifications device in the ordered set where platform = &#63; and OSVersion = &#63;.
     *
     * @param platform the platform
     * @param OSVersion the o s version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching push notifications device, or <code>null</code> if a matching push notifications device could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByP_OSV_Last(String platform,
        String OSVersion, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByP_OSV(platform, OSVersion);

        if (count == 0) {
            return null;
        }

        List<PushNotificationsDevice> list = findByP_OSV(platform, OSVersion,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the push notifications devices before and after the current push notifications device in the ordered set where platform = &#63; and OSVersion = &#63;.
     *
     * @param pushNotificationsDeviceId the primary key of the current push notifications device
     * @param platform the platform
     * @param OSVersion the o s version
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice[] findByP_OSV_PrevAndNext(
        long pushNotificationsDeviceId, String platform, String OSVersion,
        OrderByComparator orderByComparator)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = findByPrimaryKey(pushNotificationsDeviceId);

        Session session = null;

        try {
            session = openSession();

            PushNotificationsDevice[] array = new PushNotificationsDeviceImpl[3];

            array[0] = getByP_OSV_PrevAndNext(session, pushNotificationsDevice,
                    platform, OSVersion, orderByComparator, true);

            array[1] = pushNotificationsDevice;

            array[2] = getByP_OSV_PrevAndNext(session, pushNotificationsDevice,
                    platform, OSVersion, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected PushNotificationsDevice getByP_OSV_PrevAndNext(Session session,
        PushNotificationsDevice pushNotificationsDevice, String platform,
        String OSVersion, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE_WHERE);

        boolean bindPlatform = false;

        if (platform == null) {
            query.append(_FINDER_COLUMN_P_OSV_PLATFORM_1);
        } else if (platform.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_P_OSV_PLATFORM_3);
        } else {
            bindPlatform = true;

            query.append(_FINDER_COLUMN_P_OSV_PLATFORM_2);
        }

        boolean bindOSVersion = false;

        if (OSVersion == null) {
            query.append(_FINDER_COLUMN_P_OSV_OSVERSION_1);
        } else if (OSVersion.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_P_OSV_OSVERSION_3);
        } else {
            bindOSVersion = true;

            query.append(_FINDER_COLUMN_P_OSV_OSVERSION_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindPlatform) {
            qPos.add(platform);
        }

        if (bindOSVersion) {
            qPos.add(OSVersion);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(pushNotificationsDevice);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<PushNotificationsDevice> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the push notifications devices where platform = &#63; and OSVersion = &#63; from the database.
     *
     * @param platform the platform
     * @param OSVersion the o s version
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByP_OSV(String platform, String OSVersion)
        throws SystemException {
        for (PushNotificationsDevice pushNotificationsDevice : findByP_OSV(
                platform, OSVersion, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(pushNotificationsDevice);
        }
    }

    /**
     * Returns the number of push notifications devices where platform = &#63; and OSVersion = &#63;.
     *
     * @param platform the platform
     * @param OSVersion the o s version
     * @return the number of matching push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByP_OSV(String platform, String OSVersion)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_P_OSV;

        Object[] finderArgs = new Object[] { platform, OSVersion };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_PUSHNOTIFICATIONSDEVICE_WHERE);

            boolean bindPlatform = false;

            if (platform == null) {
                query.append(_FINDER_COLUMN_P_OSV_PLATFORM_1);
            } else if (platform.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_P_OSV_PLATFORM_3);
            } else {
                bindPlatform = true;

                query.append(_FINDER_COLUMN_P_OSV_PLATFORM_2);
            }

            boolean bindOSVersion = false;

            if (OSVersion == null) {
                query.append(_FINDER_COLUMN_P_OSV_OSVERSION_1);
            } else if (OSVersion.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_P_OSV_OSVERSION_3);
            } else {
                bindOSVersion = true;

                query.append(_FINDER_COLUMN_P_OSV_OSVERSION_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindPlatform) {
                    qPos.add(platform);
                }

                if (bindOSVersion) {
                    qPos.add(OSVersion);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the push notifications device in the entity cache if it is enabled.
     *
     * @param pushNotificationsDevice the push notifications device
     */
    @Override
    public void cacheResult(PushNotificationsDevice pushNotificationsDevice) {
        EntityCacheUtil.putResult(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            pushNotificationsDevice.getPrimaryKey(), pushNotificationsDevice);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
            new Object[] { pushNotificationsDevice.getToken() },
            pushNotificationsDevice);

        pushNotificationsDevice.resetOriginalValues();
    }

    /**
     * Caches the push notifications devices in the entity cache if it is enabled.
     *
     * @param pushNotificationsDevices the push notifications devices
     */
    @Override
    public void cacheResult(
        List<PushNotificationsDevice> pushNotificationsDevices) {
        for (PushNotificationsDevice pushNotificationsDevice : pushNotificationsDevices) {
            if (EntityCacheUtil.getResult(
                        PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
                        PushNotificationsDeviceImpl.class,
                        pushNotificationsDevice.getPrimaryKey()) == null) {
                cacheResult(pushNotificationsDevice);
            } else {
                pushNotificationsDevice.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all push notifications devices.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(PushNotificationsDeviceImpl.class.getName());
        }

        EntityCacheUtil.clearCache(PushNotificationsDeviceImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the push notifications device.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(PushNotificationsDevice pushNotificationsDevice) {
        EntityCacheUtil.removeResult(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            pushNotificationsDevice.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(pushNotificationsDevice);
    }

    @Override
    public void clearCache(
        List<PushNotificationsDevice> pushNotificationsDevices) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (PushNotificationsDevice pushNotificationsDevice : pushNotificationsDevices) {
            EntityCacheUtil.removeResult(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
                PushNotificationsDeviceImpl.class,
                pushNotificationsDevice.getPrimaryKey());

            clearUniqueFindersCache(pushNotificationsDevice);
        }
    }

    protected void cacheUniqueFindersCache(
        PushNotificationsDevice pushNotificationsDevice) {
        if (pushNotificationsDevice.isNew()) {
            Object[] args = new Object[] { pushNotificationsDevice.getToken() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TOKEN, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN, args,
                pushNotificationsDevice);
        } else {
            PushNotificationsDeviceModelImpl pushNotificationsDeviceModelImpl = (PushNotificationsDeviceModelImpl) pushNotificationsDevice;

            if ((pushNotificationsDeviceModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_TOKEN.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { pushNotificationsDevice.getToken() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TOKEN, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN, args,
                    pushNotificationsDevice);
            }
        }
    }

    protected void clearUniqueFindersCache(
        PushNotificationsDevice pushNotificationsDevice) {
        PushNotificationsDeviceModelImpl pushNotificationsDeviceModelImpl = (PushNotificationsDeviceModelImpl) pushNotificationsDevice;

        Object[] args = new Object[] { pushNotificationsDevice.getToken() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOKEN, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN, args);

        if ((pushNotificationsDeviceModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_TOKEN.getColumnBitmask()) != 0) {
            args = new Object[] {
                    pushNotificationsDeviceModelImpl.getOriginalToken()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOKEN, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN, args);
        }
    }

    /**
     * Creates a new push notifications device with the primary key. Does not add the push notifications device to the database.
     *
     * @param pushNotificationsDeviceId the primary key for the new push notifications device
     * @return the new push notifications device
     */
    @Override
    public PushNotificationsDevice create(long pushNotificationsDeviceId) {
        PushNotificationsDevice pushNotificationsDevice = new PushNotificationsDeviceImpl();

        pushNotificationsDevice.setNew(true);
        pushNotificationsDevice.setPrimaryKey(pushNotificationsDeviceId);

        return pushNotificationsDevice;
    }

    /**
     * Removes the push notifications device with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param pushNotificationsDeviceId the primary key of the push notifications device
     * @return the push notifications device that was removed
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice remove(long pushNotificationsDeviceId)
        throws NoSuchDeviceException, SystemException {
        return remove((Serializable) pushNotificationsDeviceId);
    }

    /**
     * Removes the push notifications device with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the push notifications device
     * @return the push notifications device that was removed
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice remove(Serializable primaryKey)
        throws NoSuchDeviceException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PushNotificationsDevice pushNotificationsDevice = (PushNotificationsDevice) session.get(PushNotificationsDeviceImpl.class,
                    primaryKey);

            if (pushNotificationsDevice == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchDeviceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(pushNotificationsDevice);
        } catch (NoSuchDeviceException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected PushNotificationsDevice removeImpl(
        PushNotificationsDevice pushNotificationsDevice)
        throws SystemException {
        pushNotificationsDevice = toUnwrappedModel(pushNotificationsDevice);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(pushNotificationsDevice)) {
                pushNotificationsDevice = (PushNotificationsDevice) session.get(PushNotificationsDeviceImpl.class,
                        pushNotificationsDevice.getPrimaryKeyObj());
            }

            if (pushNotificationsDevice != null) {
                session.delete(pushNotificationsDevice);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (pushNotificationsDevice != null) {
            clearCache(pushNotificationsDevice);
        }

        return pushNotificationsDevice;
    }

    @Override
    public PushNotificationsDevice updateImpl(
        com.liferay.pushnotifications.model.PushNotificationsDevice pushNotificationsDevice)
        throws SystemException {
        pushNotificationsDevice = toUnwrappedModel(pushNotificationsDevice);

        boolean isNew = pushNotificationsDevice.isNew();

        PushNotificationsDeviceModelImpl pushNotificationsDeviceModelImpl = (PushNotificationsDeviceModelImpl) pushNotificationsDevice;

        Session session = null;

        try {
            session = openSession();

            if (pushNotificationsDevice.isNew()) {
                session.save(pushNotificationsDevice);

                pushNotificationsDevice.setNew(false);
            } else {
                session.merge(pushNotificationsDevice);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !PushNotificationsDeviceModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((pushNotificationsDeviceModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_P.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        pushNotificationsDeviceModelImpl.getOriginalUserId(),
                        pushNotificationsDeviceModelImpl.getOriginalPlatform()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_P, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_P,
                    args);

                args = new Object[] {
                        pushNotificationsDeviceModelImpl.getUserId(),
                        pushNotificationsDeviceModelImpl.getPlatform()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_P, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_P,
                    args);
            }

            if ((pushNotificationsDeviceModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        pushNotificationsDeviceModelImpl.getOriginalUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U,
                    args);

                args = new Object[] { pushNotificationsDeviceModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U,
                    args);
            }

            if ((pushNotificationsDeviceModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_AV.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        pushNotificationsDeviceModelImpl.getOriginalUserId(),
                        pushNotificationsDeviceModelImpl.getOriginalAppVersion()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_AV, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_AV,
                    args);

                args = new Object[] {
                        pushNotificationsDeviceModelImpl.getUserId(),
                        pushNotificationsDeviceModelImpl.getAppVersion()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_AV, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_AV,
                    args);
            }

            if ((pushNotificationsDeviceModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPVERSION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        pushNotificationsDeviceModelImpl.getOriginalAppVersion()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPVERSION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPVERSION,
                    args);

                args = new Object[] {
                        pushNotificationsDeviceModelImpl.getAppVersion()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPVERSION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPVERSION,
                    args);
            }

            if ((pushNotificationsDeviceModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLATFORM.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        pushNotificationsDeviceModelImpl.getOriginalPlatform()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PLATFORM, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLATFORM,
                    args);

                args = new Object[] {
                        pushNotificationsDeviceModelImpl.getPlatform()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PLATFORM, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLATFORM,
                    args);
            }

            if ((pushNotificationsDeviceModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        pushNotificationsDeviceModelImpl.getOriginalAppId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID,
                    args);

                args = new Object[] { pushNotificationsDeviceModelImpl.getAppId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID,
                    args);
            }

            if ((pushNotificationsDeviceModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_OSV.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        pushNotificationsDeviceModelImpl.getOriginalPlatform(),
                        pushNotificationsDeviceModelImpl.getOriginalOSVersion()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_OSV, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_OSV,
                    args);

                args = new Object[] {
                        pushNotificationsDeviceModelImpl.getPlatform(),
                        pushNotificationsDeviceModelImpl.getOSVersion()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_OSV, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_OSV,
                    args);
            }
        }

        EntityCacheUtil.putResult(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
            PushNotificationsDeviceImpl.class,
            pushNotificationsDevice.getPrimaryKey(), pushNotificationsDevice);

        clearUniqueFindersCache(pushNotificationsDevice);
        cacheUniqueFindersCache(pushNotificationsDevice);

        return pushNotificationsDevice;
    }

    protected PushNotificationsDevice toUnwrappedModel(
        PushNotificationsDevice pushNotificationsDevice) {
        if (pushNotificationsDevice instanceof PushNotificationsDeviceImpl) {
            return pushNotificationsDevice;
        }

        PushNotificationsDeviceImpl pushNotificationsDeviceImpl = new PushNotificationsDeviceImpl();

        pushNotificationsDeviceImpl.setNew(pushNotificationsDevice.isNew());
        pushNotificationsDeviceImpl.setPrimaryKey(pushNotificationsDevice.getPrimaryKey());

        pushNotificationsDeviceImpl.setPushNotificationsDeviceId(pushNotificationsDevice.getPushNotificationsDeviceId());
        pushNotificationsDeviceImpl.setUserId(pushNotificationsDevice.getUserId());
        pushNotificationsDeviceImpl.setCreateDate(pushNotificationsDevice.getCreateDate());
        pushNotificationsDeviceImpl.setPlatform(pushNotificationsDevice.getPlatform());
        pushNotificationsDeviceImpl.setToken(pushNotificationsDevice.getToken());
        pushNotificationsDeviceImpl.setModel(pushNotificationsDevice.getModel());
        pushNotificationsDeviceImpl.setOSVersion(pushNotificationsDevice.getOSVersion());
        pushNotificationsDeviceImpl.setAppId(pushNotificationsDevice.getAppId());
        pushNotificationsDeviceImpl.setAppVersion(pushNotificationsDevice.getAppVersion());

        return pushNotificationsDeviceImpl;
    }

    /**
     * Returns the push notifications device with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the push notifications device
     * @return the push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByPrimaryKey(Serializable primaryKey)
        throws NoSuchDeviceException, SystemException {
        PushNotificationsDevice pushNotificationsDevice = fetchByPrimaryKey(primaryKey);

        if (pushNotificationsDevice == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchDeviceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return pushNotificationsDevice;
    }

    /**
     * Returns the push notifications device with the primary key or throws a {@link com.liferay.pushnotifications.NoSuchDeviceException} if it could not be found.
     *
     * @param pushNotificationsDeviceId the primary key of the push notifications device
     * @return the push notifications device
     * @throws com.liferay.pushnotifications.NoSuchDeviceException if a push notifications device with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice findByPrimaryKey(
        long pushNotificationsDeviceId)
        throws NoSuchDeviceException, SystemException {
        return findByPrimaryKey((Serializable) pushNotificationsDeviceId);
    }

    /**
     * Returns the push notifications device with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the push notifications device
     * @return the push notifications device, or <code>null</code> if a push notifications device with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        PushNotificationsDevice pushNotificationsDevice = (PushNotificationsDevice) EntityCacheUtil.getResult(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
                PushNotificationsDeviceImpl.class, primaryKey);

        if (pushNotificationsDevice == _nullPushNotificationsDevice) {
            return null;
        }

        if (pushNotificationsDevice == null) {
            Session session = null;

            try {
                session = openSession();

                pushNotificationsDevice = (PushNotificationsDevice) session.get(PushNotificationsDeviceImpl.class,
                        primaryKey);

                if (pushNotificationsDevice != null) {
                    cacheResult(pushNotificationsDevice);
                } else {
                    EntityCacheUtil.putResult(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
                        PushNotificationsDeviceImpl.class, primaryKey,
                        _nullPushNotificationsDevice);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(PushNotificationsDeviceModelImpl.ENTITY_CACHE_ENABLED,
                    PushNotificationsDeviceImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return pushNotificationsDevice;
    }

    /**
     * Returns the push notifications device with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param pushNotificationsDeviceId the primary key of the push notifications device
     * @return the push notifications device, or <code>null</code> if a push notifications device with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public PushNotificationsDevice fetchByPrimaryKey(
        long pushNotificationsDeviceId) throws SystemException {
        return fetchByPrimaryKey((Serializable) pushNotificationsDeviceId);
    }

    /**
     * Returns all the push notifications devices.
     *
     * @return the push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the push notifications devices.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @return the range of push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the push notifications devices.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.PushNotificationsDeviceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of push notifications devices
     * @param end the upper bound of the range of push notifications devices (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<PushNotificationsDevice> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<PushNotificationsDevice> list = (List<PushNotificationsDevice>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PUSHNOTIFICATIONSDEVICE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PUSHNOTIFICATIONSDEVICE;

                if (pagination) {
                    sql = sql.concat(PushNotificationsDeviceModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<PushNotificationsDevice>(list);
                } else {
                    list = (List<PushNotificationsDevice>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the push notifications devices from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (PushNotificationsDevice pushNotificationsDevice : findAll()) {
            remove(pushNotificationsDevice);
        }
    }

    /**
     * Returns the number of push notifications devices.
     *
     * @return the number of push notifications devices
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_PUSHNOTIFICATIONSDEVICE);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the push notifications device persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.pushnotifications.model.PushNotificationsDevice")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PushNotificationsDevice>> listenersList = new ArrayList<ModelListener<PushNotificationsDevice>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PushNotificationsDevice>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(PushNotificationsDeviceImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
