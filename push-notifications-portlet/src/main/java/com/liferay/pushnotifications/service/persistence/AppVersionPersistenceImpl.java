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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.pushnotifications.NoSuchAppVersionException;
import com.liferay.pushnotifications.model.AppVersion;
import com.liferay.pushnotifications.model.impl.AppVersionImpl;
import com.liferay.pushnotifications.model.impl.AppVersionModelImpl;
import com.liferay.pushnotifications.service.persistence.AppVersionPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the app version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Farache
 * @see AppVersionPersistence
 * @see AppVersionUtil
 * @generated
 */
public class AppVersionPersistenceImpl extends BasePersistenceImpl<AppVersion>
    implements AppVersionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link AppVersionUtil} to access the app version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = AppVersionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AppVersionModelImpl.ENTITY_CACHE_ENABLED,
            AppVersionModelImpl.FINDER_CACHE_ENABLED, AppVersionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AppVersionModelImpl.ENTITY_CACHE_ENABLED,
            AppVersionModelImpl.FINDER_CACHE_ENABLED, AppVersionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AppVersionModelImpl.ENTITY_CACHE_ENABLED,
            AppVersionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICATIONID =
        new FinderPath(AppVersionModelImpl.ENTITY_CACHE_ENABLED,
            AppVersionModelImpl.FINDER_CACHE_ENABLED, AppVersionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApplicationId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONID =
        new FinderPath(AppVersionModelImpl.ENTITY_CACHE_ENABLED,
            AppVersionModelImpl.FINDER_CACHE_ENABLED, AppVersionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByApplicationId",
            new String[] { Long.class.getName() },
            AppVersionModelImpl.APPLICATIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_APPLICATIONID = new FinderPath(AppVersionModelImpl.ENTITY_CACHE_ENABLED,
            AppVersionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByApplicationId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2 = "appVersion.applicationId = ?";
    private static final String _SQL_SELECT_APPVERSION = "SELECT appVersion FROM AppVersion appVersion";
    private static final String _SQL_SELECT_APPVERSION_WHERE = "SELECT appVersion FROM AppVersion appVersion WHERE ";
    private static final String _SQL_COUNT_APPVERSION = "SELECT COUNT(appVersion) FROM AppVersion appVersion";
    private static final String _SQL_COUNT_APPVERSION_WHERE = "SELECT COUNT(appVersion) FROM AppVersion appVersion WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "appVersion.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AppVersion exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AppVersion exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AppVersionPersistenceImpl.class);
    private static AppVersion _nullAppVersion = new AppVersionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<AppVersion> toCacheModel() {
                return _nullAppVersionCacheModel;
            }
        };

    private static CacheModel<AppVersion> _nullAppVersionCacheModel = new CacheModel<AppVersion>() {
            @Override
            public AppVersion toEntityModel() {
                return _nullAppVersion;
            }
        };

    public AppVersionPersistenceImpl() {
        setModelClass(AppVersion.class);
    }

    /**
     * Returns all the app versions where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @return the matching app versions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AppVersion> findByApplicationId(long applicationId)
        throws SystemException {
        return findByApplicationId(applicationId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the app versions where applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.AppVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param applicationId the application ID
     * @param start the lower bound of the range of app versions
     * @param end the upper bound of the range of app versions (not inclusive)
     * @return the range of matching app versions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AppVersion> findByApplicationId(long applicationId, int start,
        int end) throws SystemException {
        return findByApplicationId(applicationId, start, end, null);
    }

    /**
     * Returns an ordered range of all the app versions where applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.AppVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param applicationId the application ID
     * @param start the lower bound of the range of app versions
     * @param end the upper bound of the range of app versions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching app versions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AppVersion> findByApplicationId(long applicationId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONID;
            finderArgs = new Object[] { applicationId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICATIONID;
            finderArgs = new Object[] {
                    applicationId,
                    
                    start, end, orderByComparator
                };
        }

        List<AppVersion> list = (List<AppVersion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (AppVersion appVersion : list) {
                if ((applicationId != appVersion.getApplicationId())) {
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

            query.append(_SQL_SELECT_APPVERSION_WHERE);

            query.append(_FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(AppVersionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(applicationId);

                if (!pagination) {
                    list = (List<AppVersion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AppVersion>(list);
                } else {
                    list = (List<AppVersion>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first app version in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching app version
     * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a matching app version could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AppVersion findByApplicationId_First(long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchAppVersionException, SystemException {
        AppVersion appVersion = fetchByApplicationId_First(applicationId,
                orderByComparator);

        if (appVersion != null) {
            return appVersion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAppVersionException(msg.toString());
    }

    /**
     * Returns the first app version in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching app version, or <code>null</code> if a matching app version could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AppVersion fetchByApplicationId_First(long applicationId,
        OrderByComparator orderByComparator) throws SystemException {
        List<AppVersion> list = findByApplicationId(applicationId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last app version in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching app version
     * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a matching app version could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AppVersion findByApplicationId_Last(long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchAppVersionException, SystemException {
        AppVersion appVersion = fetchByApplicationId_Last(applicationId,
                orderByComparator);

        if (appVersion != null) {
            return appVersion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAppVersionException(msg.toString());
    }

    /**
     * Returns the last app version in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching app version, or <code>null</code> if a matching app version could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AppVersion fetchByApplicationId_Last(long applicationId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByApplicationId(applicationId);

        if (count == 0) {
            return null;
        }

        List<AppVersion> list = findByApplicationId(applicationId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the app versions before and after the current app version in the ordered set where applicationId = &#63;.
     *
     * @param appVersionId the primary key of the current app version
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next app version
     * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a app version with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AppVersion[] findByApplicationId_PrevAndNext(long appVersionId,
        long applicationId, OrderByComparator orderByComparator)
        throws NoSuchAppVersionException, SystemException {
        AppVersion appVersion = findByPrimaryKey(appVersionId);

        Session session = null;

        try {
            session = openSession();

            AppVersion[] array = new AppVersionImpl[3];

            array[0] = getByApplicationId_PrevAndNext(session, appVersion,
                    applicationId, orderByComparator, true);

            array[1] = appVersion;

            array[2] = getByApplicationId_PrevAndNext(session, appVersion,
                    applicationId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected AppVersion getByApplicationId_PrevAndNext(Session session,
        AppVersion appVersion, long applicationId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPVERSION_WHERE);

        query.append(_FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2);

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
            query.append(AppVersionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(applicationId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(appVersion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<AppVersion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the app versions where applicationId = &#63; from the database.
     *
     * @param applicationId the application ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByApplicationId(long applicationId)
        throws SystemException {
        for (AppVersion appVersion : findByApplicationId(applicationId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(appVersion);
        }
    }

    /**
     * Returns the number of app versions where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @return the number of matching app versions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByApplicationId(long applicationId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICATIONID;

        Object[] finderArgs = new Object[] { applicationId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_APPVERSION_WHERE);

            query.append(_FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(applicationId);

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
     * Caches the app version in the entity cache if it is enabled.
     *
     * @param appVersion the app version
     */
    @Override
    public void cacheResult(AppVersion appVersion) {
        EntityCacheUtil.putResult(AppVersionModelImpl.ENTITY_CACHE_ENABLED,
            AppVersionImpl.class, appVersion.getPrimaryKey(), appVersion);

        appVersion.resetOriginalValues();
    }

    /**
     * Caches the app versions in the entity cache if it is enabled.
     *
     * @param appVersions the app versions
     */
    @Override
    public void cacheResult(List<AppVersion> appVersions) {
        for (AppVersion appVersion : appVersions) {
            if (EntityCacheUtil.getResult(
                        AppVersionModelImpl.ENTITY_CACHE_ENABLED,
                        AppVersionImpl.class, appVersion.getPrimaryKey()) == null) {
                cacheResult(appVersion);
            } else {
                appVersion.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all app versions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AppVersionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AppVersionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the app version.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(AppVersion appVersion) {
        EntityCacheUtil.removeResult(AppVersionModelImpl.ENTITY_CACHE_ENABLED,
            AppVersionImpl.class, appVersion.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<AppVersion> appVersions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (AppVersion appVersion : appVersions) {
            EntityCacheUtil.removeResult(AppVersionModelImpl.ENTITY_CACHE_ENABLED,
                AppVersionImpl.class, appVersion.getPrimaryKey());
        }
    }

    /**
     * Creates a new app version with the primary key. Does not add the app version to the database.
     *
     * @param appVersionId the primary key for the new app version
     * @return the new app version
     */
    @Override
    public AppVersion create(long appVersionId) {
        AppVersion appVersion = new AppVersionImpl();

        appVersion.setNew(true);
        appVersion.setPrimaryKey(appVersionId);

        return appVersion;
    }

    /**
     * Removes the app version with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param appVersionId the primary key of the app version
     * @return the app version that was removed
     * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a app version with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AppVersion remove(long appVersionId)
        throws NoSuchAppVersionException, SystemException {
        return remove((Serializable) appVersionId);
    }

    /**
     * Removes the app version with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the app version
     * @return the app version that was removed
     * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a app version with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AppVersion remove(Serializable primaryKey)
        throws NoSuchAppVersionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AppVersion appVersion = (AppVersion) session.get(AppVersionImpl.class,
                    primaryKey);

            if (appVersion == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAppVersionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(appVersion);
        } catch (NoSuchAppVersionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected AppVersion removeImpl(AppVersion appVersion)
        throws SystemException {
        appVersion = toUnwrappedModel(appVersion);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(appVersion)) {
                appVersion = (AppVersion) session.get(AppVersionImpl.class,
                        appVersion.getPrimaryKeyObj());
            }

            if (appVersion != null) {
                session.delete(appVersion);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (appVersion != null) {
            clearCache(appVersion);
        }

        return appVersion;
    }

    @Override
    public AppVersion updateImpl(
        com.liferay.pushnotifications.model.AppVersion appVersion)
        throws SystemException {
        appVersion = toUnwrappedModel(appVersion);

        boolean isNew = appVersion.isNew();

        AppVersionModelImpl appVersionModelImpl = (AppVersionModelImpl) appVersion;

        Session session = null;

        try {
            session = openSession();

            if (appVersion.isNew()) {
                session.save(appVersion);

                appVersion.setNew(false);
            } else {
                session.merge(appVersion);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !AppVersionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((appVersionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        appVersionModelImpl.getOriginalApplicationId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONID,
                    args);

                args = new Object[] { appVersionModelImpl.getApplicationId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONID,
                    args);
            }
        }

        EntityCacheUtil.putResult(AppVersionModelImpl.ENTITY_CACHE_ENABLED,
            AppVersionImpl.class, appVersion.getPrimaryKey(), appVersion);

        return appVersion;
    }

    protected AppVersion toUnwrappedModel(AppVersion appVersion) {
        if (appVersion instanceof AppVersionImpl) {
            return appVersion;
        }

        AppVersionImpl appVersionImpl = new AppVersionImpl();

        appVersionImpl.setNew(appVersion.isNew());
        appVersionImpl.setPrimaryKey(appVersion.getPrimaryKey());

        appVersionImpl.setAppVersionId(appVersion.getAppVersionId());
        appVersionImpl.setAppVersionKey(appVersion.getAppVersionKey());
        appVersionImpl.setStructure(appVersion.getStructure());
        appVersionImpl.setSandbox(appVersion.isSandbox());
        appVersionImpl.setCreatedDate(appVersion.getCreatedDate());
        appVersionImpl.setModifiedDate(appVersion.getModifiedDate());
        appVersionImpl.setUserId(appVersion.getUserId());
        appVersionImpl.setApplicationId(appVersion.getApplicationId());

        return appVersionImpl;
    }

    /**
     * Returns the app version with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the app version
     * @return the app version
     * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a app version with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AppVersion findByPrimaryKey(Serializable primaryKey)
        throws NoSuchAppVersionException, SystemException {
        AppVersion appVersion = fetchByPrimaryKey(primaryKey);

        if (appVersion == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchAppVersionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return appVersion;
    }

    /**
     * Returns the app version with the primary key or throws a {@link com.liferay.pushnotifications.NoSuchAppVersionException} if it could not be found.
     *
     * @param appVersionId the primary key of the app version
     * @return the app version
     * @throws com.liferay.pushnotifications.NoSuchAppVersionException if a app version with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AppVersion findByPrimaryKey(long appVersionId)
        throws NoSuchAppVersionException, SystemException {
        return findByPrimaryKey((Serializable) appVersionId);
    }

    /**
     * Returns the app version with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the app version
     * @return the app version, or <code>null</code> if a app version with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AppVersion fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        AppVersion appVersion = (AppVersion) EntityCacheUtil.getResult(AppVersionModelImpl.ENTITY_CACHE_ENABLED,
                AppVersionImpl.class, primaryKey);

        if (appVersion == _nullAppVersion) {
            return null;
        }

        if (appVersion == null) {
            Session session = null;

            try {
                session = openSession();

                appVersion = (AppVersion) session.get(AppVersionImpl.class,
                        primaryKey);

                if (appVersion != null) {
                    cacheResult(appVersion);
                } else {
                    EntityCacheUtil.putResult(AppVersionModelImpl.ENTITY_CACHE_ENABLED,
                        AppVersionImpl.class, primaryKey, _nullAppVersion);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(AppVersionModelImpl.ENTITY_CACHE_ENABLED,
                    AppVersionImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return appVersion;
    }

    /**
     * Returns the app version with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param appVersionId the primary key of the app version
     * @return the app version, or <code>null</code> if a app version with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AppVersion fetchByPrimaryKey(long appVersionId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) appVersionId);
    }

    /**
     * Returns all the app versions.
     *
     * @return the app versions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AppVersion> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the app versions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.AppVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of app versions
     * @param end the upper bound of the range of app versions (not inclusive)
     * @return the range of app versions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AppVersion> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the app versions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.AppVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of app versions
     * @param end the upper bound of the range of app versions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of app versions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AppVersion> findAll(int start, int end,
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

        List<AppVersion> list = (List<AppVersion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_APPVERSION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_APPVERSION;

                if (pagination) {
                    sql = sql.concat(AppVersionModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<AppVersion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AppVersion>(list);
                } else {
                    list = (List<AppVersion>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes all the app versions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (AppVersion appVersion : findAll()) {
            remove(appVersion);
        }
    }

    /**
     * Returns the number of app versions.
     *
     * @return the number of app versions
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

                Query q = session.createQuery(_SQL_COUNT_APPVERSION);

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
     * Initializes the app version persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.pushnotifications.model.AppVersion")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<AppVersion>> listenersList = new ArrayList<ModelListener<AppVersion>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<AppVersion>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AppVersionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
