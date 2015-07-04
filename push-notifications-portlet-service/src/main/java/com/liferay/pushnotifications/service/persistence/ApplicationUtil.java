package com.liferay.pushnotifications.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.pushnotifications.model.Application;

import java.util.List;

/**
 * The persistence utility for the application service. This utility wraps {@link ApplicationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Farache
 * @see ApplicationPersistence
 * @see ApplicationPersistenceImpl
 * @generated
 */
public class ApplicationUtil {
    private static ApplicationPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Application application) {
        getPersistence().clearCache(application);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Application> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Application> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Application> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Application update(Application application)
        throws SystemException {
        return getPersistence().update(application);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Application update(Application application,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(application, serviceContext);
    }

    /**
    * Caches the application in the entity cache if it is enabled.
    *
    * @param application the application
    */
    public static void cacheResult(
        com.liferay.pushnotifications.model.Application application) {
        getPersistence().cacheResult(application);
    }

    /**
    * Caches the applications in the entity cache if it is enabled.
    *
    * @param applications the applications
    */
    public static void cacheResult(
        java.util.List<com.liferay.pushnotifications.model.Application> applications) {
        getPersistence().cacheResult(applications);
    }

    /**
    * Creates a new application with the primary key. Does not add the application to the database.
    *
    * @param applicationId the primary key for the new application
    * @return the new application
    */
    public static com.liferay.pushnotifications.model.Application create(
        long applicationId) {
        return getPersistence().create(applicationId);
    }

    /**
    * Removes the application with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicationId the primary key of the application
    * @return the application that was removed
    * @throws com.liferay.pushnotifications.NoSuchApplicationException if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.Application remove(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchApplicationException {
        return getPersistence().remove(applicationId);
    }

    public static com.liferay.pushnotifications.model.Application updateImpl(
        com.liferay.pushnotifications.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(application);
    }

    /**
    * Returns the application with the primary key or throws a {@link com.liferay.pushnotifications.NoSuchApplicationException} if it could not be found.
    *
    * @param applicationId the primary key of the application
    * @return the application
    * @throws com.liferay.pushnotifications.NoSuchApplicationException if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.Application findByPrimaryKey(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchApplicationException {
        return getPersistence().findByPrimaryKey(applicationId);
    }

    /**
    * Returns the application with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param applicationId the primary key of the application
    * @return the application, or <code>null</code> if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.Application fetchByPrimaryKey(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(applicationId);
    }

    /**
    * Returns all the applications.
    *
    * @return the applications
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.Application> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.liferay.pushnotifications.model.Application> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.liferay.pushnotifications.model.Application> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the applications from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of applications.
    *
    * @return the number of applications
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ApplicationPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ApplicationPersistence) PortletBeanLocatorUtil.locate(com.liferay.pushnotifications.service.ClpSerializer.getServletContextName(),
                    ApplicationPersistence.class.getName());

            ReferenceRegistry.registerReference(ApplicationUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ApplicationPersistence persistence) {
    }
}
