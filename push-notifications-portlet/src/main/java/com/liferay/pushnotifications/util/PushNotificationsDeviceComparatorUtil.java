package com.liferay.pushnotifications.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.pushnotifications.comparators.AppNameComparator;
import com.liferay.pushnotifications.comparators.AppVersionComparator;
import com.liferay.pushnotifications.comparators.ModelComparator;
import com.liferay.pushnotifications.comparators.OSVersionComparator;
import com.liferay.pushnotifications.comparators.PlatformComparator;

public class PushNotificationsDeviceComparatorUtil {

	public static OrderByComparator getPushNotificationOrderByComparator(String orderByCol, String orderByType){
		
		boolean orderByAsc = false;

        if (orderByType.equals("asc")) {
        	orderByAsc = true;
        }
		
        OrderByComparator orderByComparator = null;
        
        if("platform".equals(orderByCol)){
        	orderByComparator = new PlatformComparator(orderByAsc);
        }else if("OSVersion".equals(orderByCol)){
        	orderByComparator = new OSVersionComparator(orderByAsc);
        }else if("model".equals(orderByCol)){
        	orderByComparator = new ModelComparator(orderByAsc);
        }else if("appVersion".equals(orderByCol)){
        	orderByComparator = new AppVersionComparator(orderByAsc);
        }else if("applicationName".equals(orderByCol)){
        	orderByComparator = new AppNameComparator(orderByAsc);
        }
        
		return orderByComparator;
	}

}
