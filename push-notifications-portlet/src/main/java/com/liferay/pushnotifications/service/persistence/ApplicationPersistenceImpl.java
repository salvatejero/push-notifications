package com.liferay.pushnotifications.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.pushnotifications.NoSuchApplicationException;
import com.liferay.pushnotifications.model.Application;
import com.liferay.pushnotifications.model.impl.ApplicationImpl;
import com.liferay.pushnotifications.model.impl.ApplicationModelImpl;
import com.liferay.pushnotifications.service.persistence.ApplicationPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the application service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Farache
 * @see ApplicationPersistence
 * @see ApplicationUtil
 * @generated
 */
public class ApplicationPersistenceImpl extends BasePersistenceImpl<Application>
    implements ApplicationPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ApplicationUtil} to access the application persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ApplicationImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, ApplicationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_APPLICATION = "SELECT application FROM Application application";
    private static final String _SQL_COUNT_APPLICATION = "SELECT COUNT(application) FROM Application application";
    private static final String _ORDER_BY_ENTITY_ALIAS = "application.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Application exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ApplicationPersistenceImpl.class);
    private static Application _nullApplication = new ApplicationImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Application> toCacheModel() {
                return _nullApplicationCacheModel;
            }
        };

    private static CacheModel<Application> _nullApplicationCacheModel = new CacheModel<Application>() {
            @Override
            public Application toEntityModel() {
                return _nullApplication;
            }
        };

    public ApplicationPersistenceImpl() {
        setModelClass(Application.class);
    }

    /**
     * Caches the application in the entity cache if it is enabled.
     *
     * @param application the application
     */
    @Override
    public void cacheResult(Application application) {
        EntityCacheUtil.putResult(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationImpl.class, application.getPrimaryKey(), application);

        application.resetOriginalValues();
    }

    /**
     * Caches the applications in the entity cache if it is enabled.
     *
     * @param applications the applications
     */
    @Override
    public void cacheResult(List<Application> applications) {
        for (Application application : applications) {
            if (EntityCacheUtil.getResult(
                        ApplicationModelImpl.ENTITY_CACHE_ENABLED,
                        ApplicationImpl.class, application.getPrimaryKey()) == null) {
                cacheResult(application);
            } else {
                application.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all applications.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ApplicationImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ApplicationImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the application.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Application application) {
        EntityCacheUtil.removeResult(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationImpl.class, application.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Application> applications) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Application application : applications) {
            EntityCacheUtil.removeResult(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
                ApplicationImpl.class, application.getPrimaryKey());
        }
    }

    /**
     * Creates a new application with the primary key. Does not add the application to the database.
     *
     * @param applicationId the primary key for the new application
     * @return the new application
     */
    @Override
    public Application create(long applicationId) {
        Application application = new ApplicationImpl();

        application.setNew(true);
        application.setPrimaryKey(applicationId);

        return application;
    }

    /**
     * Removes the application with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param applicationId the primary key of the application
     * @return the application that was removed
     * @throws com.liferay.pushnotifications.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Application remove(long applicationId)
        throws NoSuchApplicationException, SystemException {
        return remove((Serializable) applicationId);
    }

    /**
     * Removes the application with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the application
     * @return the application that was removed
     * @throws com.liferay.pushnotifications.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Application remove(Serializable primaryKey)
        throws NoSuchApplicationException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Application application = (Application) session.get(ApplicationImpl.class,
                    primaryKey);

            if (application == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchApplicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(application);
        } catch (NoSuchApplicationException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Application removeImpl(Application application)
        throws SystemException {
        application = toUnwrappedModel(application);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(application)) {
                application = (Application) session.get(ApplicationImpl.class,
                        application.getPrimaryKeyObj());
            }

            if (application != null) {
                session.delete(application);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (application != null) {
            clearCache(application);
        }

        return application;
    }

    @Override
    public Application updateImpl(
        com.liferay.pushnotifications.model.Application application)
        throws SystemException {
        application = toUnwrappedModel(application);

        boolean isNew = application.isNew();

        Session session = null;

        try {
            session = openSession();

            if (application.isNew()) {
                session.save(application);

                application.setNew(false);
            } else {
                session.merge(application);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
            ApplicationImpl.class, application.getPrimaryKey(), application);

        return application;
    }

    protected Application toUnwrappedModel(Application application) {
        if (application instanceof ApplicationImpl) {
            return application;
        }

        ApplicationImpl applicationImpl = new ApplicationImpl();

        applicationImpl.setNew(application.isNew());
        applicationImpl.setPrimaryKey(application.getPrimaryKey());

        applicationImpl.setApplicationId(application.getApplicationId());
        applicationImpl.setApplicationName(application.getApplicationName());
        applicationImpl.setCreatedDate(application.getCreatedDate());
        applicationImpl.setModificatedDate(application.getModificatedDate());
        applicationImpl.setUserId(application.getUserId());

        return applicationImpl;
    }

    /**
     * Returns the application with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the application
     * @return the application
     * @throws com.liferay.pushnotifications.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Application findByPrimaryKey(Serializable primaryKey)
        throws NoSuchApplicationException, SystemException {
        Application application = fetchByPrimaryKey(primaryKey);

        if (application == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchApplicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return application;
    }

    /**
     * Returns the application with the primary key or throws a {@link com.liferay.pushnotifications.NoSuchApplicationException} if it could not be found.
     *
     * @param applicationId the primary key of the application
     * @return the application
     * @throws com.liferay.pushnotifications.NoSuchApplicationException if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Application findByPrimaryKey(long applicationId)
        throws NoSuchApplicationException, SystemException {
        return findByPrimaryKey((Serializable) applicationId);
    }

    /**
     * Returns the application with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the application
     * @return the application, or <code>null</code> if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Application fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Application application = (Application) EntityCacheUtil.getResult(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
                ApplicationImpl.class, primaryKey);

        if (application == _nullApplication) {
            return null;
        }

        if (application == null) {
            Session session = null;

            try {
                session = openSession();

                application = (Application) session.get(ApplicationImpl.class,
                        primaryKey);

                if (application != null) {
                    cacheResult(application);
                } else {
                    EntityCacheUtil.putResult(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
                        ApplicationImpl.class, primaryKey, _nullApplication);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ApplicationModelImpl.ENTITY_CACHE_ENABLED,
                    ApplicationImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return application;
    }

    /**
     * Returns the application with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param applicationId the primary key of the application
     * @return the application, or <code>null</code> if a application with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Application fetchByPrimaryKey(long applicationId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) applicationId);
    }

    /**
     * Returns all the applications.
     *
     * @return the applications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Application> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the applications.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.ApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @return the range of applications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Application> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the applications.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pushnotifications.model.impl.ApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of applications
     * @param end the upper bound of the range of applications (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of applications
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Application> findAll(int start, int end,
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

        List<Application> list = (List<Application>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_APPLICATION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_APPLICATION;

                if (pagination) {
                    sql = sql.concat(ApplicationModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Application>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Application>(list);
                } else {
                    list = (List<Application>) QueryUtil.list(q, getDialect(),
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
     * Removes all the applications from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Application application : findAll()) {
            remove(application);
        }
    }

    /**
     * Returns the number of applications.
     *
     * @return the number of applications
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

                Query q = session.createQuery(_SQL_COUNT_APPLICATION);

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
     * Initializes the application persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.pushnotifications.model.Application")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Application>> listenersList = new ArrayList<ModelListener<Application>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Application>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ApplicationImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
