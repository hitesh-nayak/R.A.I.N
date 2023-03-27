create table Rain_Doctor (
	employeeId LONG not null primary key,
	groupId LONG,
	surname VARCHAR(75) null,
	firstName VARCHAR(75) null,
	department VARCHAR(75) null,
	govtId VARCHAR(75) null,
	nationality VARCHAR(75) null,
	payGroup VARCHAR(75) null,
	email VARCHAR(75) null,
	contactNumber VARCHAR(75) null
);

create table Rain_Patient (
	govtId LONG not null primary key,
	groupId LONG,
	surname VARCHAR(75) null,
	firstName VARCHAR(75) null,
	nationality VARCHAR(75) null,
	age LONG,
	isAdult BOOLEAN,
	email VARCHAR(75) null,
	contactNumber VARCHAR(75) null,
	insuranceId VARCHAR(75) null,
	primaryDoctor LONG
);