create table AppVersion (
	appVersionId LONG not null primary key,
	appVersionKey VARCHAR(75) null,
	structure VARCHAR(75) null,
	sandbox BOOLEAN,
	createdDate DATE null,
	modifiedDate DATE null,
	userId LONG,
	applicationId LONG
);

create table Application (
	applicationId LONG not null primary key,
	applicationName VARCHAR(75) null,
	createdDate DATE null,
	modificatedDate DATE null,
	userId LONG
);

create table ApplicationPreferences (
	applicationPreferenceId LONG not null,
	applicationId LONG not null,
	androidApiKey VARCHAR(75) null,
	androidRetries LONG,
	iosPasswordCertificated VARCHAR(75) null,
	iosPasswordSandBoxCertificated VARCHAR(75) null,
	iosSandBoxCert LONG,
	iosProdCert LONG,
	createdDate DATE null,
	modificatedDate DATE null,
	userId LONG,
	primary key (applicationPreferenceId, applicationId)
);

create table Applications_AppVersions (
	appVersionId LONG not null,
	applicationId LONG not null,
	primary key (appVersionId, applicationId)
);

create table PushNotificationsDevice (
	pushNotificationsDeviceId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	platform VARCHAR(75) null,
	token STRING null,
	model VARCHAR(75) null,
	OSVersion VARCHAR(75) null,
	appId LONG,
	appVersion VARCHAR(75) null
);