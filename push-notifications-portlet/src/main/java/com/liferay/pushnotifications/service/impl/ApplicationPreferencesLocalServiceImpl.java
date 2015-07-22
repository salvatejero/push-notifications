package com.liferay.pushnotifications.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.pushnotifications.model.ApplicationPreferences;
import com.liferay.pushnotifications.service.base.ApplicationPreferencesLocalServiceBaseImpl;
import com.liferay.pushnotifications.service.persistence.ApplicationPreferencesPK;

/**
 * The implementation of the application preferences local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.pushnotifications.service.ApplicationPreferencesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Bruno Farache
 * @see com.liferay.pushnotifications.service.base.ApplicationPreferencesLocalServiceBaseImpl
 * @see com.liferay.pushnotifications.service.ApplicationPreferencesLocalServiceUtil
 */
public class ApplicationPreferencesLocalServiceImpl
    extends ApplicationPreferencesLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.pushnotifications.service.ApplicationPreferencesLocalServiceUtil} to access the application preferences local service.
     */
	
	public ApplicationPreferences findApplicationPreferenceByApplicationId(long applicationId){
		
		List<ApplicationPreferences> applicationPreferences = null;
		ApplicationPreferences applicationPreference = null;
		try{
			applicationPreferences = applicationPreferencesPersistence.findByApplicationId(applicationId);
			if(applicationPreferences != null && applicationPreferences.size() > 0){
				applicationPreference = applicationPreferences.get(0);
			}
		}catch(Exception e){
			
		}
		return applicationPreference;
	}
	
	public ApplicationPreferences addApplicationPreferences(long appId, User user, String androidApiKey, long androidRetries,
			String iosPasswordCertificated, long iosProdCert, long iosSandBoxCert, String iosPasswordSandBoxCertificated){
		
		long appPreferencesId = 0;
		try {
			appPreferencesId = counterLocalService.increment();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		ApplicationPreferencesPK pk = new ApplicationPreferencesPK();
		pk.setApplicationId(appId);
		pk.setApplicationPreferenceId(appPreferencesId);
		
		ApplicationPreferences appPreferences = applicationPreferencesLocalService.createApplicationPreferences(pk);
		appPreferences.setApplicationId(appId);
		appPreferences.setUserId(user.getUserId());
		try {
			appPreferences.setUserUuid(user.getUserUuid());
		
			appPreferences.setCreatedDate(new Date());
			appPreferences.setModificatedDate(new Date());
			appPreferences.setAndroidApiKey(androidApiKey);
			appPreferences.setAndroidRetries(androidRetries);
			appPreferences.setIosPasswordCertificated(iosPasswordCertificated);
			appPreferences.setIosPasswordSandBoxCertificated(iosPasswordSandBoxCertificated);
			appPreferences.setIosProdCert(iosProdCert);
			appPreferences.setIosSandBoxCert(iosSandBoxCert);
			appPreferences = applicationPreferencesLocalService.addApplicationPreferences(appPreferences);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return appPreferences;
	}
	
	/*
	public List<ApplicationPreferences> findApplicationPreferencesByAppId(long applicationId){
		
		try{
			return applicationPreferencesLocalService.findApplicationPreferencesByAppId(applicationId);
		}catch(Exception e){
			
		}
		return new ArrayList<ApplicationPreferences>();
	}
	
	public List<ApplicationPreferences> findApplicationPreferencesByAppId(long applicationId, int start, int end){
		try{
			return applicationPreferencesLocalService.findApplicationPreferencesByAppId(applicationId, start, end);
		}catch(Exception e){
			
		}
		return new ArrayList<ApplicationPreferences>();
	}*/
	
}
