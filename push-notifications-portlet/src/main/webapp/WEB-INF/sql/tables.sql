create table PushNotificationsDevice (
	pushNotificationsDeviceId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	platform VARCHAR(75) null,
	token STRING null,
	model VARCHAR(75) null,
	OSVersion VARCHAR(75) null,
	appVersion VARCHAR(75) null
);