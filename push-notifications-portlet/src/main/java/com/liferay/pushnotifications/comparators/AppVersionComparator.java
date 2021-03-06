package com.liferay.pushnotifications.comparators;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.pushnotifications.model.PushNotificationsDevice;
/**
 * 
 * @author Salva Tejero
 *
 */
public class AppVersionComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_DESC = "appVersion DESC";

	public static String ORDER_BY_ASC = "appVersion ASC";

	private boolean _ascending;

	public AppVersionComparator(boolean asc){
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
		
		int result = dev1.getAppVersion().compareToIgnoreCase(dev2.getAppVersion());
		return (_ascending)?result:(-1)*result;
	}

}
