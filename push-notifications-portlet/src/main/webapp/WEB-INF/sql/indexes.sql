create index IX_D66BFB5 on PushNotificationsDevice (appVersion);
create index IX_7758D8B1 on PushNotificationsDevice (platform);
create index IX_7CC663B3 on PushNotificationsDevice (platform, OSVersion);
create index IX_24F7E63B on PushNotificationsDevice (platform, soVersion);
create unique index IX_2F3EDC9F on PushNotificationsDevice (token);
create index IX_EA80F8C4 on PushNotificationsDevice (userId);
create index IX_44F866EF on PushNotificationsDevice (userId, appVersion);
create index IX_2FBF066B on PushNotificationsDevice (userId, platform);