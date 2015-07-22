package com.liferay.pushnotifications.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.pushnotifications.model.ApplicationPreferences;

import java.util.List;

/**
 * The persistence utility for the application preferences service. This utility wraps {@link ApplicationPreferencesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Farache
 * @see ApplicationPreferencesPersistence
 * @see ApplicationPreferencesPersistenceImpl
 * @generated
 */
public class ApplicationPreferencesUtil {
    private static ApplicationPreferencesPersistence _persistence;

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
    public static void clearCache(ApplicationPreferences applicationPreferences) {
        getPersistence().clearCache(applicationPreferences);
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
    public static List<ApplicationPreferences> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ApplicationPreferences> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ApplicationPreferences> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static ApplicationPreferences update(
        ApplicationPreferences applicationPreferences)
        throws SystemException {
        return getPersistence().update(applicationPreferences);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static ApplicationPreferences update(
        ApplicationPreferences applicationPreferences,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(applicationPreferences, serviceContext);
    }

    /**
    * Returns all the application preferenceses where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the matching application preferenceses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.ApplicationPreferences> findByApplicationId(
        long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByApplicationId(applicationId);
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
    public static java.util.List<com.liferay.pushnotifications.model.ApplicationPreferences> findByApplicationId(
        long applicationId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByApplicationId(applicationId, start, end);
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
    public static java.util.List<com.liferay.pushnotifications.model.ApplicationPreferences> findByApplicationId(
        long applicationId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByApplicationId(applicationId, start, end,
            orderByComparator);
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
    public static com.liferay.pushnotifications.model.ApplicationPreferences findByApplicationId_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchApplicationPreferencesException {
        return getPersistence()
                   .findByApplicationId_First(applicationId, orderByComparator);
    }

    /**
    * Returns the first application preferences in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching application preferences, or <code>null</code> if a matching application preferences could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.ApplicationPreferences fetchByApplicationId_First(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByApplicationId_First(applicationId, orderByComparator);
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
    public static com.liferay.pushnotifications.model.ApplicationPreferences findByApplicationId_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchApplicationPreferencesException {
        return getPersistence()
                   .findByApplicationId_Last(applicationId, orderByComparator);
    }

    /**
    * Returns the last application preferences in the ordered set where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching application preferences, or <code>null</code> if a matching application preferences could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.ApplicationPreferences fetchByApplicationId_Last(
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByApplicationId_Last(applicationId, orderByComparator);
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
    public static com.liferay.pushnotifications.model.ApplicationPreferences[] findByApplicationId_PrevAndNext(
        com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK applicationPreferencesPK,
        long applicationId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchApplicationPreferencesException {
        return getPersistence()
                   .findByApplicationId_PrevAndNext(applicationPreferencesPK,
            applicationId, orderByComparator);
    }

    /**
    * Removes all the application preferenceses where applicationId = &#63; from the database.
    *
    * @param applicationId the application ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByApplicationId(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByApplicationId(applicationId);
    }

    /**
    * Returns the number of application preferenceses where applicationId = &#63;.
    *
    * @param applicationId the application ID
    * @return the number of matching application preferenceses
    * @throws SystemException if a system exception occurred
    */
    public static int countByApplicationId(long applicationId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByApplicationId(applicationId);
    }

    /**
    * Caches the application preferences in the entity cache if it is enabled.
    *
    * @param applicationPreferences the application preferences
    */
    public static void cacheResult(
        com.liferay.pushnotifications.model.ApplicationPreferences applicationPreferences) {
        getPersistence().cacheResult(applicationPreferences);
    }

    /**
    * Caches the application preferenceses in the entity cache if it is enabled.
    *
    * @param applicationPreferenceses the application preferenceses
    */
    public static void cacheResult(
        java.util.List<com.liferay.pushnotifications.model.ApplicationPreferences> applicationPreferenceses) {
        getPersistence().cacheResult(applicationPreferenceses);
    }

    /**
    * Creates a new application preferences with the primary key. Does not add the application preferences to the database.
    *
    * @param applicationPreferencesPK the primary key for the new application preferences
    * @return the new application preferences
    */
    public static com.liferay.pushnotifications.model.ApplicationPreferences create(
        com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK applicationPreferencesPK) {
        return getPersistence().create(applicationPreferencesPK);
    }

    /**
    * Removes the application preferences with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param applicationPreferencesPK the primary key of the application preferences
    * @return the application preferences that was removed
    * @throws com.liferay.pushnotifications.NoSuchApplicationPreferencesException if a application preferences with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.ApplicationPreferences remove(
        com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK applicationPreferencesPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchApplicationPreferencesException {
        return getPersistence().remove(applicationPreferencesPK);
    }

    public static com.liferay.pushnotifications.model.ApplicationPreferences updateImpl(
        com.liferay.pushnotifications.model.ApplicationPreferences applicationPreferences)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(applicationPreferences);
    }

    /**
    * Returns the application preferences with the primary key or throws a {@link com.liferay.pushnotifications.NoSuchApplicationPreferencesException} if it could not be found.
    *
    * @param applicationPreferencesPK the primary key of the application preferences
    * @return the application preferences
    * @throws com.liferay.pushnotifications.NoSuchApplicationPreferencesException if a application preferences with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.ApplicationPreferences findByPrimaryKey(
        com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK applicationPreferencesPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.pushnotifications.NoSuchApplicationPreferencesException {
        return getPersistence().findByPrimaryKey(applicationPreferencesPK);
    }

    /**
    * Returns the application preferences with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param applicationPreferencesPK the primary key of the application preferences
    * @return the application preferences, or <code>null</code> if a application preferences with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.pushnotifications.model.ApplicationPreferences fetchByPrimaryKey(
        com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK applicationPreferencesPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(applicationPreferencesPK);
    }

    /**
    * Returns all the application preferenceses.
    *
    * @return the application preferenceses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.pushnotifications.model.ApplicationPreferences> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.liferay.pushnotifications.model.ApplicationPreferences> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.liferay.pushnotifications.model.ApplicationPreferences> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the application preferenceses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of application preferenceses.
    *
    * @return the number of application preferenceses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ApplicationPreferencesPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ApplicationPreferencesPersistence) PortletBeanLocatorUtil.locate(com.liferay.pushnotifications.service.ClpSerializer.getServletContextName(),
                    ApplicationPreferencesPersistence.class.getName());

            ReferenceRegistry.registerReference(ApplicationPreferencesUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(ApplicationPreferencesPersistence persistence) {
    }
}
