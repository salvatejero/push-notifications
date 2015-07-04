package com.liferay.pushnotifications.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.pushnotifications.model.Application;

/**
 * The persistence interface for the application service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Farache
 * @see ApplicationPersistenceImpl
 * @see ApplicationUtil
 * @generated
 */
public interface ApplicationPersistence extends BasePersistence<Application> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ApplicationUtil} to access the application persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the application in the entity cache if it is enabled.
    *
    * @param application the application
    */
    public void cacheResult(
        com.liferay.pushnotifications.model.Application application);

    /**
    * Caches the applications in the entity cache if it is enabled.
    *
    * @param applications the applications
    */
    public void cacheResult(
        java.util.List<com.liferay.pushnotifications.model.Application> applications);

    /**
    * Creates a new application with the primary key. Does not add the application to the database.
    *
    * @param applicationId the primary key for the new application
    * @return the new application
    */
    public com.liferay.pushnotifications.model.Application create(
        long applicationId);

    /**
    * Removes the application with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicationId the primary key of the application
    * @return the application that was removed
    * @throws com.liferay.pushnotifications.NoSuchApplicationException if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.Application remove(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchApplicationException;

    public com.liferay.pushnotifications.model.Application updateImpl(
        com.liferay.pushnotifications.model.Application application)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the application with the primary key or throws a {@link com.liferay.pushnotifications.NoSuchApplicationException} if it could not be found.
    *
    * @param applicationId the primary key of the application
    * @return the application
    * @throws com.liferay.pushnotifications.NoSuchApplicationException if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.Application findByPrimaryKey(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchApplicationException;

    /**
    * Returns the application with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param applicationId the primary key of the application
    * @return the application, or <code>null</code> if a application with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.Application fetchByPrimaryKey(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the applications.
    *
    * @return the applications
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.pushnotifications.model.Application> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.pushnotifications.model.Application> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.pushnotifications.model.Application> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the applications from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of applications.
    *
    * @return the number of applications
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
