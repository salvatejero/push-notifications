package com.liferay.pushnotifications.comparators;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.pushnotifications.model.Application;
import com.liferay.pushnotifications.model.PushNotificationsDevice;
import com.liferay.pushnotifications.service.ApplicationLocalServiceUtil;
/**
 * 
 * @author Salva Tejero
 *
 */
public class AppNameComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_DESC = "appVersion DESC";

	public static String ORDER_BY_ASC = "appVersion ASC";

	private boolean _ascending;

	public AppNameComparator(boolean asc){
		_ascending = asc;
	}
	
	@Override
	public String getOrderBy() {

		if (_ascending) {
			return ORDER_BY_ASC;
		} else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		
		PushNotificationsDevice dev1 = (PushNotificationsDevice)arg0;
		PushNotificationsDevice dev2 = (PushNotificationsDevice)arg1;
		
		Application app1 = null;
		Application app2 = null;
		try {
			app1 = ApplicationLocalServiceUtil.getApplication(dev1.getAppId());
			app2 = ApplicationLocalServiceUtil.getApplication(dev2.getAppId());
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		int result = 0;
		if(app1 != null && app2 != null){
			result = app1.getApplicationName().compareToIgnoreCase(app2.getApplicationName());
		}
		return (_ascending)?result:(-1)*result;
	}

}
