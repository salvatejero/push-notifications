package com.liferay.pushnotifications.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.pushnotifications.model.AppVersion;
import com.liferay.pushnotifications.model.Application;
import com.liferay.pushnotifications.service.base.AppVersionLocalServiceBaseImpl;

/**
 * The implementation of the app version local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.pushnotifications.service.AppVersionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Bruno Farache
 * @see com.liferay.pushnotifications.service.base.AppVersionLocalServiceBaseImpl
 * @see com.liferay.pushnotifications.service.AppVersionLocalServiceUtil
 */
public class AppVersionLocalServiceImpl extends AppVersionLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.pushnotifications.service.AppVersionLocalServiceUtil} to access the app version local service.
     */
	
	public List<AppVersion> findAppVerionByAppId(long applicationId){
		try {
			return appVersionPersistence.findByApplicationId(applicationId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<AppVersion>();
	}
	
	public List<AppVersion> findAppVerionByAppId(long applicationId, int start, int end){
		try {
			return appVersionPersistence.findByApplicationId(applicationId, start, end);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<AppVersion>();
	}
	
	public AppVersion addAppVersion(String versionKey, String structure, User user, Long appId){
		
		long appVersionId = 0;
		try {
			appVersionId = counterLocalService.increment();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		AppVersion appVersion = appVersionLocalService.createAppVersion(appVersionId);
		appVersion.setAppVersionKey(versionKey);
		appVersion.setStructure(structure);
		appVersion.setApplicationId(appId);
		appVersion.setUserId(user.getUserId());
		try {
			appVersion.setUserUuid(user.getUserUuid());
		
			appVersion.setCreatedDate(new Date());
			appVersion.setModifiedDate(new Date());
		
			appVersion = appVersionLocalService.addAppVersion(appVersion);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return appVersion;
	}
	
}
