package com.liferay.pushnotifications.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.pushnotifications.model.Application;
import com.liferay.pushnotifications.service.base.ApplicationLocalServiceBaseImpl;

/**
 * The implementation of the application local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.pushnotifications.service.ApplicationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Bruno Farache
 * @see com.liferay.pushnotifications.service.base.ApplicationLocalServiceBaseImpl
 * @see com.liferay.pushnotifications.service.ApplicationLocalServiceUtil
 */
public class ApplicationLocalServiceImpl extends ApplicationLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.pushnotifications.service.ApplicationLocalServiceUtil} to access the application local service.
     */
	
	
	public Application addApplication(String appName, User user){
		
		long appId = 0;
		try {
			appId = counterLocalService.increment();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		Application app = applicationLocalService.createApplication(appId);
		app.setApplicationName(appName);
		app.setUserId(user.getUserId());
		try {
			app.setUserUuid(user.getUserUuid());
		
			app.setCreatedDate(new Date());
			app.setModificatedDate(new Date());
		
			app = applicationLocalService.addApplication(app);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return app;
	}
}
