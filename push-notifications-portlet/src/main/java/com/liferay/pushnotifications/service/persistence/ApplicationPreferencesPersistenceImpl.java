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

import com.liferay.pushnotifications.NoSuchApplicationPreferencesException;
import com.liferay.pushnotifications.model.ApplicationPreferences;
import com.liferay.pushnotifications.model.impl.ApplicationPreferencesImpl;
import com.liferay.pushnotifications.model.impl.ApplicationPreferencesModelImpl;
import com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the application preferences service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Farache
 * @see ApplicationPreferencesPersistence
 * @see ApplicationPreferencesUtil
 * @generated
 */
public class ApplicationPreferencesPersistenceImpl extends BasePersistenceImpl<ApplicationPreferences>
    implements ApplicationPreferencesPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ApplicationPreferencesUtil} to access the application preferences persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ApplicationPreferencesImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApplicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationPreferencesModelImpl.FINDER_CACHE_ENABLED,
            ApplicationPreferencesImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApplicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationPreferencesModelImpl.FINDER_CACHE_ENABLED,
            ApplicationPreferencesImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApplicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationPreferencesModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICATIONID =
        new FinderPath(ApplicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationPreferencesModelImpl.FINDER_CACHE_ENABLED,
            ApplicationPreferencesImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApplicationId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONID =
        new FinderPath(ApplicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationPreferencesModelImpl.FINDER_CACHE_ENABLED,
            ApplicationPreferencesImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByApplicationId",
            new String[] { Long.class.getName() },
            ApplicationPreferencesModelImpl.APPLICATIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_APPLICATIONID = new FinderPath(ApplicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationPreferencesModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByApplicationId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2 = "applicationPreferences.id.applicationId = ?";
    private static final String _SQL_SELECT_APPLICATIONPREFERENCES = "SELECT applicationPreferences FROM ApplicationPreferences applicationPreferences";
    private static final String _SQL_SELECT_APPLICATIONPREFERENCES_WHERE = "SELECT applicationPreferences FROM ApplicationPreferences applicationPreferences WHERE ";
    private static final String _SQL_COUNT_APPLICATIONPREFERENCES = "SELECT COUNT(applicationPreferences) FROM ApplicationPreferences applicationPreferences";
    private static final String _SQL_COUNT_APPLICATIONPREFERENCES_WHERE = "SELECT COUNT(applicationPreferences) FROM ApplicationPreferences applicationPreferences WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "applicationPreferences.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ApplicationPreferences exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ApplicationPreferences exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ApplicationPreferencesPersistenceImpl.class);
    private static ApplicationPreferences _nullApplicationPreferences = new ApplicationPreferencesImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ApplicationPreferences> toCacheModel() {
                return _nullApplicationPreferencesCacheModel;
            }
        };

    private static CacheModel<ApplicationPreferences> _nullApplicationPreferencesCacheModel =
        new CacheModel<ApplicationPreferences>() {
            @Override
            public ApplicationPreferences toEntityModel() {
                return _nullApplicationPreferences;
            }
        };

    public ApplicationPreferencesPersistenceImpl() {
        setModelClass(ApplicationPreferences.class);
    }

    /**
     * Returns all the application preferenceses where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @return the matching application preferenceses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ApplicationPreferences> findByApplicationId(long applicationId)
        throws SystemException {
        return findByApplicationId(applicationId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the application preferenceses where applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.ApplicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param applicationId the application ID
     * @param start the lower bound of the range of application preferenceses
     * @param end the upper bound of the range of application preferenceses (not inclusive)
     * @return the range of matching application preferenceses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ApplicationPreferences> findByApplicationId(
        long applicationId, int start, int end) throws SystemException {
        return findByApplicationId(applicationId, start, end, null);
    }

    /**
     * Returns an ordered range of all the application preferenceses where applicationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.ApplicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param applicationId the application ID
     * @param start the lower bound of the range of application preferenceses
     * @param end the upper bound of the range of application preferenceses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching application preferenceses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ApplicationPreferences> findByApplicationId(
        long applicationId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
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

        List<ApplicationPreferences> list = (List<ApplicationPreferences>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ApplicationPreferences applicationPreferences : list) {
                if ((applicationId != applicationPreferences.getApplicationId())) {
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

            query.append(_SQL_SELECT_APPLICATIONPREFERENCES_WHERE);

            query.append(_FINDER_COLUMN_APPLICATIONID_APPLICATIONID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ApplicationPreferencesModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(applicationId);

                if (!pagination) {
                    list = (List<ApplicationPreferences>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ApplicationPreferences>(list);
                } else {
                    list = (List<ApplicationPreferences>) QueryUtil.list(q,
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
     * Returns the first application preferences in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application preferences
     * @throws com.liferay.pushnotifications.NoSuchApplicationPreferencesException if a matching application preferences could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApplicationPreferences findByApplicationId_First(
        long applicationId, OrderByComparator orderByComparator)
        throws NoSuchApplicationPreferencesException, SystemException {
        ApplicationPreferences applicationPreferences = fetchByApplicationId_First(applicationId,
                orderByComparator);

        if (applicationPreferences != null) {
            return applicationPreferences;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationPreferencesException(msg.toString());
    }

    /**
     * Returns the first application preferences in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching application preferences, or <code>null</code> if a matching application preferences could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApplicationPreferences fetchByApplicationId_First(
        long applicationId, OrderByComparator orderByComparator)
        throws SystemException {
        List<ApplicationPreferences> list = findByApplicationId(applicationId,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last application preferences in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application preferences
     * @throws com.liferay.pushnotifications.NoSuchApplicationPreferencesException if a matching application preferences could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApplicationPreferences findByApplicationId_Last(long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationPreferencesException, SystemException {
        ApplicationPreferences applicationPreferences = fetchByApplicationId_Last(applicationId,
                orderByComparator);

        if (applicationPreferences != null) {
            return applicationPreferences;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("applicationId=");
        msg.append(applicationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicationPreferencesException(msg.toString());
    }

    /**
     * Returns the last application preferences in the ordered set where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching application preferences, or <code>null</code> if a matching application preferences could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApplicationPreferences fetchByApplicationId_Last(
        long applicationId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByApplicationId(applicationId);

        if (count == 0) {
            return null;
        }

        List<ApplicationPreferences> list = findByApplicationId(applicationId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the application preferenceses before and after the current application preferences in the ordered set where applicationId = &#63;.
     *
     * @param applicationPreferencesPK the primary key of the current application preferences
     * @param applicationId the application ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next application preferences
     * @throws com.liferay.pushnotifications.NoSuchApplicationPreferencesException if a application preferences with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApplicationPreferences[] findByApplicationId_PrevAndNext(
        ApplicationPreferencesPK applicationPreferencesPK, long applicationId,
        OrderByComparator orderByComparator)
        throws NoSuchApplicationPreferencesException, SystemException {
        ApplicationPreferences applicationPreferences = findByPrimaryKey(applicationPreferencesPK);

        Session session = null;

        try {
            session = openSession();

            ApplicationPreferences[] array = new ApplicationPreferencesImpl[3];

            array[0] = getByApplicationId_PrevAndNext(session,
                    applicationPreferences, applicationId, orderByComparator,
                    true);

            array[1] = applicationPreferences;

            array[2] = getByApplicationId_PrevAndNext(session,
                    applicationPreferences, applicationId, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ApplicationPreferences getByApplicationId_PrevAndNext(
        Session session, ApplicationPreferences applicationPreferences,
        long applicationId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPLICATIONPREFERENCES_WHERE);

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
            query.append(ApplicationPreferencesModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(applicationId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(applicationPreferences);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ApplicationPreferences> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the application preferenceses where applicationId = &#63; from the database.
     *
     * @param applicationId the application ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByApplicationId(long applicationId)
        throws SystemException {
        for (ApplicationPreferences applicationPreferences : findByApplicationId(
                applicationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(applicationPreferences);
        }
    }

    /**
     * Returns the number of application preferenceses where applicationId = &#63;.
     *
     * @param applicationId the application ID
     * @return the number of matching application preferenceses
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

            query.append(_SQL_COUNT_APPLICATIONPREFERENCES_WHERE);

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
     * Caches the application preferences in the entity cache if it is enabled.
     *
     * @param applicationPreferences the application preferences
     */
    @Override
    public void cacheResult(ApplicationPreferences applicationPreferences) {
        EntityCacheUtil.putResult(ApplicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationPreferencesImpl.class,
            applicationPreferences.getPrimaryKey(), applicationPreferences);

        applicationPreferences.resetOriginalValues();
    }

    /**
     * Caches the application preferenceses in the entity cache if it is enabled.
     *
     * @param applicationPreferenceses the application preferenceses
     */
    @Override
    public void cacheResult(
        List<ApplicationPreferences> applicationPreferenceses) {
        for (ApplicationPreferences applicationPreferences : applicationPreferenceses) {
            if (EntityCacheUtil.getResult(
                        ApplicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
                        ApplicationPreferencesImpl.class,
                        applicationPreferences.getPrimaryKey()) == null) {
                cacheResult(applicationPreferences);
            } else {
                applicationPreferences.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all application preferenceses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ApplicationPreferencesImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ApplicationPreferencesImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the application preferences.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ApplicationPreferences applicationPreferences) {
        EntityCacheUtil.removeResult(ApplicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationPreferencesImpl.class,
            applicationPreferences.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(
        List<ApplicationPreferences> applicationPreferenceses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ApplicationPreferences applicationPreferences : applicationPreferenceses) {
            EntityCacheUtil.removeResult(ApplicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
                ApplicationPreferencesImpl.class,
                applicationPreferences.getPrimaryKey());
        }
    }

    /**
     * Creates a new application preferences with the primary key. Does not add the application preferences to the database.
     *
     * @param applicationPreferencesPK the primary key for the new application preferences
     * @return the new application preferences
     */
    @Override
    public ApplicationPreferences create(
        ApplicationPreferencesPK applicationPreferencesPK) {
        ApplicationPreferences applicationPreferences = new ApplicationPreferencesImpl();

        applicationPreferences.setNew(true);
        applicationPreferences.setPrimaryKey(applicationPreferencesPK);

        return applicationPreferences;
    }

    /**
     * Removes the application preferences with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param applicationPreferencesPK the primary key of the application preferences
     * @return the application preferences that was removed
     * @throws com.liferay.pushnotifications.NoSuchApplicationPreferencesException if a application preferences with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApplicationPreferences remove(
        ApplicationPreferencesPK applicationPreferencesPK)
        throws NoSuchApplicationPreferencesException, SystemException {
        return remove((Serializable) applicationPreferencesPK);
    }

    /**
     * Removes the application preferences with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the application preferences
     * @return the application preferences that was removed
     * @throws com.liferay.pushnotifications.NoSuchApplicationPreferencesException if a application preferences with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApplicationPreferences remove(Serializable primaryKey)
        throws NoSuchApplicationPreferencesException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ApplicationPreferences applicationPreferences = (ApplicationPreferences) session.get(ApplicationPreferencesImpl.class,
                    primaryKey);

            if (applicationPreferences == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchApplicationPreferencesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(applicationPreferences);
        } catch (NoSuchApplicationPreferencesException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ApplicationPreferences removeImpl(
        ApplicationPreferences applicationPreferences)
        throws SystemException {
        applicationPreferences = toUnwrappedModel(applicationPreferences);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(applicationPreferences)) {
                applicationPreferences = (ApplicationPreferences) session.get(ApplicationPreferencesImpl.class,
                        applicationPreferences.getPrimaryKeyObj());
            }

            if (applicationPreferences != null) {
                session.delete(applicationPreferences);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (applicationPreferences != null) {
            clearCache(applicationPreferences);
        }

        return applicationPreferences;
    }

    @Override
    public ApplicationPreferences updateImpl(
        com.liferay.pushnotifications.model.ApplicationPreferences applicationPreferences)
        throws SystemException {
        applicationPreferences = toUnwrappedModel(applicationPreferences);

        boolean isNew = applicationPreferences.isNew();

        ApplicationPreferencesModelImpl applicationPreferencesModelImpl = (ApplicationPreferencesModelImpl) applicationPreferences;

        Session session = null;

        try {
            session = openSession();

            if (applicationPreferences.isNew()) {
                session.save(applicationPreferences);

                applicationPreferences.setNew(false);
            } else {
                session.merge(applicationPreferences);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ApplicationPreferencesModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((applicationPreferencesModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        applicationPreferencesModelImpl.getOriginalApplicationId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONID,
                    args);

                args = new Object[] {
                        applicationPreferencesModelImpl.getApplicationId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ApplicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationPreferencesImpl.class,
            applicationPreferences.getPrimaryKey(), applicationPreferences);

        return applicationPreferences;
    }

    protected ApplicationPreferences toUnwrappedModel(
        ApplicationPreferences applicationPreferences) {
        if (applicationPreferences instanceof ApplicationPreferencesImpl) {
            return applicationPreferences;
        }

        ApplicationPreferencesImpl applicationPreferencesImpl = new ApplicationPreferencesImpl();

        applicationPreferencesImpl.setNew(applicationPreferences.isNew());
        applicationPreferencesImpl.setPrimaryKey(applicationPreferences.getPrimaryKey());

        applicationPreferencesImpl.setApplicationPreferenceId(applicationPreferences.getApplicationPreferenceId());
        applicationPreferencesImpl.setApplicationId(applicationPreferences.getApplicationId());
        applicationPreferencesImpl.setAndroidApiKey(applicationPreferences.getAndroidApiKey());
        applicationPreferencesImpl.setAndroidRetries(applicationPreferences.getAndroidRetries());
        applicationPreferencesImpl.setIosPasswordCertificated(applicationPreferences.getIosPasswordCertificated());
        applicationPreferencesImpl.setIosPasswordSandBoxCertificated(applicationPreferences.getIosPasswordSandBoxCertificated());
        applicationPreferencesImpl.setIosSandBoxCert(applicationPreferences.getIosSandBoxCert());
        applicationPreferencesImpl.setIosProdCert(applicationPreferences.getIosProdCert());
        applicationPreferencesImpl.setCreatedDate(applicationPreferences.getCreatedDate());
        applicationPreferencesImpl.setModificatedDate(applicationPreferences.getModificatedDate());
        applicationPreferencesImpl.setUserId(applicationPreferences.getUserId());

        return applicationPreferencesImpl;
    }

    /**
     * Returns the application preferences with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the application preferences
     * @return the application preferences
     * @throws com.liferay.pushnotifications.NoSuchApplicationPreferencesException if a application preferences with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApplicationPreferences findByPrimaryKey(Serializable primaryKey)
        throws NoSuchApplicationPreferencesException, SystemException {
        ApplicationPreferences applicationPreferences = fetchByPrimaryKey(primaryKey);

        if (applicationPreferences == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchApplicationPreferencesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return applicationPreferences;
    }

    /**
     * Returns the application preferences with the primary key or throws a {@link com.liferay.pushnotifications.NoSuchApplicationPreferencesException} if it could not be found.
     *
     * @param applicationPreferencesPK the primary key of the application preferences
     * @return the application preferences
     * @throws com.liferay.pushnotifications.NoSuchApplicationPreferencesException if a application preferences with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApplicationPreferences findByPrimaryKey(
        ApplicationPreferencesPK applicationPreferencesPK)
        throws NoSuchApplicationPreferencesException, SystemException {
        return findByPrimaryKey((Serializable) applicationPreferencesPK);
    }

    /**
     * Returns the application preferences with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the application preferences
     * @return the application preferences, or <code>null</code> if a application preferences with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApplicationPreferences fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ApplicationPreferences applicationPreferences = (ApplicationPreferences) EntityCacheUtil.getResult(ApplicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
                ApplicationPreferencesImpl.class, primaryKey);

        if (applicationPreferences == _nullApplicationPreferences) {
            return null;
        }

        if (applicationPreferences == null) {
            Session session = null;

            try {
                session = openSession();

                applicationPreferences = (ApplicationPreferences) session.get(ApplicationPreferencesImpl.class,
                        primaryKey);

                if (applicationPreferences != null) {
                    cacheResult(applicationPreferences);
                } else {
                    EntityCacheUtil.putResult(ApplicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
                        ApplicationPreferencesImpl.class, primaryKey,
                        _nullApplicationPreferences);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ApplicationPreferencesModelImpl.ENTITY_CACHE_ENABLED,
                    ApplicationPreferencesImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return applicationPreferences;
    }

    /**
     * Returns the application preferences with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param applicationPreferencesPK the primary key of the application preferences
     * @return the application preferences, or <code>null</code> if a application preferences with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ApplicationPreferences fetchByPrimaryKey(
        ApplicationPreferencesPK applicationPreferencesPK)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) applicationPreferencesPK);
    }

    /**
     * Returns all the application preferenceses.
     *
     * @return the application preferenceses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ApplicationPreferences> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the application preferenceses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.ApplicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of application preferenceses
     * @param end the upper bound of the range of application preferenceses (not inclusive)
     * @return the range of application preferenceses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ApplicationPreferences> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the application preferenceses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.ApplicationPreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of application preferenceses
     * @param end the upper bound of the range of application preferenceses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of application preferenceses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ApplicationPreferences> findAll(int start, int end,
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

        List<ApplicationPreferences> list = (List<ApplicationPreferences>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_APPLICATIONPREFERENCES);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_APPLICATIONPREFERENCES;

                if (pagination) {
                    sql = sql.concat(ApplicationPreferencesModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ApplicationPreferences>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ApplicationPreferences>(list);
                } else {
                    list = (List<ApplicationPreferences>) QueryUtil.list(q,
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
     * Removes all the application preferenceses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ApplicationPreferences applicationPreferences : findAll()) {
            remove(applicationPreferences);
        }
    }

    /**
     * Returns the number of application preferenceses.
     *
     * @return the number of application preferenceses
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

                Query q = session.createQuery(_SQL_COUNT_APPLICATIONPREFERENCES);

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
     * Initializes the application preferences persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.pushnotifications.model.ApplicationPreferences")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ApplicationPreferences>> listenersList = new ArrayList<ModelListener<ApplicationPreferences>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ApplicationPreferences>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ApplicationPreferencesImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
