create index IX_5EC0953E on AppVersion (applicationId);
create index IX_9D8D124 on AppVersion (applicationId, appVersionId);
create index IX_315F211A on AppVersion (applicationId, appVersionKey);

create index IX_699B9D54 on ApplicationPreferences (appVersionId);
create index IX_468BFD4D on ApplicationPreferences (applicationId);

create index IX_5A58906C on Applications_AppVersions (appVersionId);
create index IX_6D6D6D35 on Applications_AppVersions (applicationId);

create index IX_4416E502 on PushNotificationsDevice (appId);
create index IX_D66BFB5 on PushNotificationsDevice (appVersion);
create index IX_7758D8B1 on PushNotificationsDevice (platform);
create index IX_7CC663B3 on PushNotificationsDevice (platform, OSVersion);
create index IX_24F7E63B on PushNotificationsDevice (platform, soVersion);
create unique index IX_2F3EDC9F on PushNotificationsDevice (token);
create index IX_EA80F8C4 on PushNotificationsDevice (userId);
create index IX_44F866EF on PushNotificationsDevice (userId, appVersion);
create index IX_2FBF066B on PushNotificationsDevice (userId, platform);