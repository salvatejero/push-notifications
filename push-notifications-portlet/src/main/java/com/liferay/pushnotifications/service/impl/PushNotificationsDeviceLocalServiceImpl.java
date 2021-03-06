package com.liferay.pushnotifications.service.impl;

import com.liferay.pushnotifications.service.AppVersionLocalServiceUtil;
import com.liferay.pushnotifications.service.base.PushNotificationsDeviceLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.pushnotifications.PushNotificationsException;
import com.liferay.pushnotifications.model.AppVersion;
import com.liferay.pushnotifications.model.PushNotificationsDevice;
import com.liferay.pushnotifications.sender.PushNotificationsSender;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * The implementation of the push notifications device local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.pushnotifications.service.PushNotificationsDeviceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Bruno Farache
 * @author Salva Tejero
 * @see com.liferay.pushnotifications.service.base.PushNotificationsDeviceLocalServiceBaseImpl
 * @see com.liferay.pushnotifications.service.PushNotificationsDeviceLocalServiceUtil
 */
public class PushNotificationsDeviceLocalServiceImpl
    extends PushNotificationsDeviceLocalServiceBaseImpl {
    

	@Override
	public PushNotificationsDevice addPushNotificationsDevice(
		long userId, String platform, String token) {

		long pushNotificationsDeviceId = 0;
		try {
			pushNotificationsDeviceId = counterLocalService.increment();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PushNotificationsDevice pushNotificationsDevice =
			pushNotificationsDevicePersistence.create(
				pushNotificationsDeviceId);

		pushNotificationsDevice.setUserId(userId);
		pushNotificationsDevice.setCreateDate(new Date());
		pushNotificationsDevice.setPlatform(platform);
		pushNotificationsDevice.setToken(token);

		try {
			pushNotificationsDevicePersistence.update(pushNotificationsDevice);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pushNotificationsDevice;
	}

	@Override
	public List<PushNotificationsDevice> getPushNotificationsDeviceByComparator(int start, int end, OrderByComparator orderByComparator){
		
		try {
			return pushNotificationsDevicePersistence.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ArrayList<PushNotificationsDevice>();
	}
	
	@Override
	public List<PushNotificationsDevice> getPushNotificationsDeviceByAppIdByComparator(long appId, int start, int end, OrderByComparator orderByComparator){
		
		try {
			if(appId == 0){
				return pushNotificationsDevicePersistence.findAll(start, end, orderByComparator);
			}else{
			
				return pushNotificationsDevicePersistence.findByAppId(appId, start, end, orderByComparator);
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<PushNotificationsDevice>();
	}
	
	
	@Override
	public List<PushNotificationsDevice> getUserDevices(long userId, int start, int end){
		
		try {
			return pushNotificationsDevicePersistence.findByU(userId, start, end);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ArrayList<PushNotificationsDevice>();
	}
	
	@Override
	public int getUserDevicesCount(long userId){
		
		try {
			return pushNotificationsDevicePersistence.countByU(userId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int getAppDevicesCount(long appId){
		
		try {
			if ( appId > 0){
				return pushNotificationsDevicePersistence.countByAppId(appId);
			}else{
				return pushNotificationsDevicePersistence.countAll();
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public PushNotificationsDevice addPushNotificationsDevice(
		long userId, String platform, String token, String model, String version, long appId, String appVersion) {

		long pushNotificationsDeviceId = 0;
		try {
			pushNotificationsDeviceId = counterLocalService.increment();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PushNotificationsDevice pushNotificationsDevice =
			pushNotificationsDevicePersistence.create(
				pushNotificationsDeviceId);

		pushNotificationsDevice.setUserId(userId);
		pushNotificationsDevice.setCreateDate(new Date());
		pushNotificationsDevice.setPlatform(platform);
		pushNotificationsDevice.setToken(token);
		pushNotificationsDevice.setModel(model);
		pushNotificationsDevice.setOSVersion(version);
		pushNotificationsDevice.setAppId(appId);
		pushNotificationsDevice.setAppVersion(appVersion);
		
		try {
			pushNotificationsDevicePersistence.update(pushNotificationsDevice);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pushNotificationsDevice;
	}
	
	@Override
	public PushNotificationsDevice deletePushNotificationsDevice(String token)
		throws PortalException {

		PushNotificationsDevice pushNotificationsDevice = null;
		try {
			pushNotificationsDevice = pushNotificationsDevicePersistence.findByToken(token);
			pushNotificationsDevicePersistence.remove(pushNotificationsDevice);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		return pushNotificationsDevice;
	}

	@Override
	public void resetPushNotificationSenders() {
		for (Map.Entry<String, PushNotificationsSender> entry :
				_pushNotificationsSenders.entrySet()) {

			PushNotificationsSender pushNotificationsSender = entry.getValue();

			pushNotificationsSender.reset();
		}
	}

	
	
	@Override
	public void sendPushNotification(
			long[] toUserIds, JSONObject payloadJSONObject)
		throws PortalException {

		for (String platform : _pushNotificationsSenders.keySet()) {
			List<PushNotificationsDevice> tokens = new ArrayList<PushNotificationsDevice>();

			List<PushNotificationsDevice> pushNotificationsDevices = null;
			try {
				pushNotificationsDevices = pushNotificationsDevicePersistence.findByU_P(
					toUserIds, platform, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (PushNotificationsDevice pushNotificationsDevice :
					pushNotificationsDevices) {

				tokens.add(pushNotificationsDevice);
			}

			if (tokens.isEmpty()) {
				continue;
			}

			sendPushNotification(null, platform, tokens, payloadJSONObject);
		}
	}

	@Override
	public void sendPushNotification(PushNotificationsSender pushNotificationsSender, String platform,
			List<PushNotificationsDevice> devices, JSONObject payloadJSONObject) throws PortalException{

		Long appIdAux = 0L;
		String appVersionKeyAux = "";
		Long appId = 0L;
		String appVersionKey = "";
		JSONObject newPayLoad = JSONFactoryUtil.createJSONObject();
		List<String> tokens = new ArrayList<String>();
		List<String> tokensEmpty = new ArrayList<String>();
		for(int i = 0 ; i< devices.size(); i++){
			PushNotificationsDevice device = devices.get(i);
			appId = device.getAppId();
			appVersionKey = device.getAppVersion();
			if(i==0){
				appIdAux = device.getAppId();
				appVersionKeyAux = device.getAppVersion();
			}
			
			if(appId.longValue() != appIdAux.longValue() || !appVersionKey.equals(appVersionKeyAux)){
				AppVersion appVersion = AppVersionLocalServiceUtil.findAppVerionByAppIdAndVersion(appId, device.getAppVersion());
				if(appVersion == null){
					tokensEmpty.add(device.getToken());
				}else{
					appIdAux = appId;
					appVersionKeyAux = appVersionKey;
					try {
						pushNotificationsSender.send(platform, tokens, newPayLoad);
					} catch (Exception e) {
						e.printStackTrace();
					}
					tokens = new ArrayList<String>();
					tokens.add(device.getToken());
					newPayLoad = JSONFactoryUtil.createJSONObject();
				
					JSONObject structure = JSONFactoryUtil.createJSONObject(appVersion.getStructure());
					Iterator<String> it = structure.keys(); 
					while(it.hasNext()){
						String key = it.next();
						newPayLoad.put(key, payloadJSONObject.getString(key));
						
					}
				}
			}else{
				tokensEmpty.add(device.getToken());
			}
		}
		if(tokensEmpty.size() >0){
			try {
				pushNotificationsSender.send(platform, tokensEmpty, payloadJSONObject);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void sendPushNotification(
			String platform, List<String> tokens, JSONObject payloadJSONObject)
		throws PortalException {

		PushNotificationsSender pushNotificationsSender =
			_pushNotificationsSenders.get(platform);

		if (pushNotificationsSender == null) {
			return;
		}
		List<PushNotificationsDevice> devices = new ArrayList<PushNotificationsDevice>();
		for(String token:tokens){
			try {
				devices.add(pushNotificationsDevicePersistence.findByToken(token));
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		try {
			sendPushNotification(pushNotificationsSender, platform, devices, payloadJSONObject);
		}
		catch (PushNotificationsException pne) {
			if (_log.isWarnEnabled()) {
				_log.warn(pne.getMessage());
			}
		}
		catch (PortalException pe) {
			throw pe;
		}
		catch (Exception e) {
			throw new PortalException(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		PushNotificationsDeviceLocalServiceImpl.class);

	@BeanReference(name = "pushNotificationsSenders")
	private Map<String, PushNotificationsSender> _pushNotificationsSenders;
	
}