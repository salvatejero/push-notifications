package com.liferay.pushnotifications.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author Bruno Farache
 * @generated
 */
public class PushNotificationsDeviceServiceClp
    implements PushNotificationsDeviceService {
    private InvokableService _invokableService;
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;

    public PushNotificationsDeviceServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "addPushNotificationsDevice";

        _methodParameterTypes3 = new String[] {
                "java.lang.String", "java.lang.String"
            };

        _methodName4 = "addPushNotificationsDevice";

        _methodParameterTypes4 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "long", "java.lang.String"
            };

        _methodName5 = "deletePushNotificationsDevice";

        _methodParameterTypes5 = new String[] { "java.lang.String" };

        _methodName6 = "sendPushNotification";

        _methodParameterTypes6 = new String[] { "long[][]", "java.lang.String" };

        _methodName7 = "sendPushNotification";

        _methodParameterTypes7 = new String[] {
                "java.lang.String", "java.util.List", "java.lang.String"
            };
    }

    @Override
    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName0,
                    _methodParameterTypes0, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        try {
            _invokableService.invokeMethod(_methodName1,
                _methodParameterTypes1,
                new Object[] { ClpSerializer.translateInput(beanIdentifier) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        throw new UnsupportedOperationException();
    }

    @Override
    public com.liferay.pushnotifications.model.PushNotificationsDevice addPushNotificationsDevice(
        java.lang.String token, java.lang.String platform)
        throws com.liferay.portal.kernel.exception.PortalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3,
                    new Object[] {
                        ClpSerializer.translateInput(token),
                        
                    ClpSerializer.translateInput(platform)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.pushnotifications.model.PushNotificationsDevice) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.liferay.pushnotifications.model.PushNotificationsDevice addPushNotificationsDevice(
        java.lang.String token, java.lang.String platform,
        java.lang.String model, java.lang.String osVersion, long appId,
        java.lang.String appVersion)
        throws com.liferay.portal.kernel.exception.PortalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName4,
                    _methodParameterTypes4,
                    new Object[] {
                        ClpSerializer.translateInput(token),
                        
                    ClpSerializer.translateInput(platform),
                        
                    ClpSerializer.translateInput(model),
                        
                    ClpSerializer.translateInput(osVersion),
                        
                    appId,
                        
                    ClpSerializer.translateInput(appVersion)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.pushnotifications.model.PushNotificationsDevice) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.liferay.pushnotifications.model.PushNotificationsDevice deletePushNotificationsDevice(
        java.lang.String token)
        throws com.liferay.portal.kernel.exception.PortalException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
                    new Object[] { ClpSerializer.translateInput(token) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.pushnotifications.model.PushNotificationsDevice) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void sendPushNotification(long[] toUserIds, java.lang.String payload)
        throws com.liferay.portal.kernel.exception.PortalException {
        try {
            _invokableService.invokeMethod(_methodName6,
                _methodParameterTypes6,
                new Object[] {
                    ClpSerializer.translateInput(toUserIds),
                    
                ClpSerializer.translateInput(payload)
                });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void sendPushNotification(java.lang.String platform,
        java.util.List<java.lang.String> tokens, java.lang.String payload)
        throws com.liferay.portal.kernel.exception.PortalException {
        try {
            _invokableService.invokeMethod(_methodName7,
                _methodParameterTypes7,
                new Object[] {
                    ClpSerializer.translateInput(platform),
                    
                ClpSerializer.translateInput(tokens),
                    
                ClpSerializer.translateInput(payload)
                });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }
}
