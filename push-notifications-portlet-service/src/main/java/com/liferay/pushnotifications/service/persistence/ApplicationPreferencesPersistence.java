package com.liferay.pushnotifications.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.pushnotifications.model.ApplicationPreferences;

/**
 * The persistence interface for the application preferences service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Farache
 * @see ApplicationPreferencesPersistenceImpl
 * @see ApplicationPreferencesUtil
 * @generated
 */
public interface ApplicationPreferencesPersistence extends BasePersistence<ApplicationPreferences> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ApplicationPreferencesUtil} to access the application preferences persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the application preferenceses where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the matching application preferenceses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.pushnotifications.model.ApplicationPreferences> findByApplicationId(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.pushnotifications.model.ApplicationPreferences> findByApplicationId(
        long applicationId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.pushnotifications.model.ApplicationPreferences> findByApplicationId(
        long applicationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first application preferences in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application preferences
    * @throws com.liferay.pushnotifications.NoSuchApplicationPreferencesException if a matching application preferences could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.ApplicationPreferences findByApplicationId_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchApplicationPreferencesException;

    /**
    * Returns the first application preferences in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application preferences, or <code>null</code> if a matching application preferences could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.ApplicationPreferences fetchByApplicationId_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last application preferences in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application preferences
    * @throws com.liferay.pushnotifications.NoSuchApplicationPreferencesException if a matching application preferences could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.ApplicationPreferences findByApplicationId_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchApplicationPreferencesException;

    /**
    * Returns the last application preferences in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application preferences, or <code>null</code> if a matching application preferences could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.ApplicationPreferences fetchByApplicationId_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.pushnotifications.model.ApplicationPreferences[] findByApplicationId_PrevAndNext(
        com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK applicationPreferencesPK,
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchApplicationPreferencesException;

    /**
    * Removes all the application preferenceses where applicationId = &#63; from the database.
    *
    * @param applicationId the application ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByApplicationId(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of application preferenceses where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the number of matching application preferenceses
    * @throws SystemException if a system exception occurred
    */
    public int countByApplicationId(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the application preferences in the entity cache if it is enabled.
    *
    * @param applicationPreferences the application preferences
    */
    public void cacheResult(
        com.liferay.pushnotifications.model.ApplicationPreferences applicationPreferences);

    /**
    * Caches the application preferenceses in the entity cache if it is enabled.
    *
    * @param applicationPreferenceses the application preferenceses
    */
    public void cacheResult(
        java.util.List<com.liferay.pushnotifications.model.ApplicationPreferences> applicationPreferenceses);

    /**
    * Creates a new application preferences with the primary key. Does not add the application preferences to the database.
    *
    * @param applicationPreferencesPK the primary key for the new application preferences
    * @return the new application preferences
    */
    public com.liferay.pushnotifications.model.ApplicationPreferences create(
        com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK applicationPreferencesPK);

    /**
    * Removes the application preferences with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicationPreferencesPK the primary key of the application preferences
    * @return the application preferences that was removed
    * @throws com.liferay.pushnotifications.NoSuchApplicationPreferencesException if a application preferences with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.ApplicationPreferences remove(
        com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK applicationPreferencesPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchApplicationPreferencesException;

    public com.liferay.pushnotifications.model.ApplicationPreferences updateImpl(
        com.liferay.pushnotifications.model.ApplicationPreferences applicationPreferences)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the application preferences with the primary key or throws a {@link com.liferay.pushnotifications.NoSuchApplicationPreferencesException} if it could not be found.
    *
    * @param applicationPreferencesPK the primary key of the application preferences
    * @return the application preferences
    * @throws com.liferay.pushnotifications.NoSuchApplicationPreferencesException if a application preferences with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.ApplicationPreferences findByPrimaryKey(
        com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK applicationPreferencesPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchApplicationPreferencesException;

    /**
    * Returns the application preferences with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param applicationPreferencesPK the primary key of the application preferences
    * @return the application preferences, or <code>null</code> if a application preferences with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.pushnotifications.model.ApplicationPreferences fetchByPrimaryKey(
        com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK applicationPreferencesPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the application preferenceses.
    *
    * @return the application preferenceses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.pushnotifications.model.ApplicationPreferences> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.pushnotifications.model.ApplicationPreferences> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.pushnotifications.model.ApplicationPreferences> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the application preferenceses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of application preferenceses.
    *
    * @return the number of application preferenceses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
