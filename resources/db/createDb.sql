create table SYS_PROPERTIES (
	ID varchar(36) not null,
	NAME varchar(225) not null,
	VALUE longvarchar,
	EXCHANGE_RATE numeric,
	-----
	primary key (ID)
)^

create table SYS_CURRENCY (
	ID varchar(36) not null,
	CURRENCY_ID varchar(6),
	NAME varchar(5),
	DESCRIPTION varchar(255),
	EXCHANGE_RATE numeric,
	-----
	primary key (ID)
)^

create table DATA_CATEGORY (
	ID varchar(36) not null,
	NAME varchar(255),
	-----
	primary key (ID)
)^

create table DATA_OPERATION (
	ID varchar(36) not null,
	DATE_TS timestamp,
	OPERATION_VALUE numeric,
	DESCRIPTION varchar(255),
	DATA_CATEGORY_ID varchar(36) not null,
	-----
	primary key (ID),
	constraint DATA_OPERATION_CATEGORY foreign key (DATA_CATEGORY_ID) references DATA_CATEGORY(ID)
)^

create table DATA_CONVERSION (
	ID varchar(36) not null,
	DATE_TS timestamp,
	DESCRIPTION varchar(255),
	CONVERSION_VALUE numeric,
	CURRENCY_FROM_ID varchar(36) not null,
	CURRENCY_TO_ID varchar(36) not null,
	EXCHANGE_RATE numeric,
	-----
	primary key (ID),
	constraint DATA_CONVERSION_CURRENCY_FROM foreign key (CURRENCY_FROM_ID) references SYS_CURRENCY(ID),
	constraint DATA_CONVERSION_CURRENCY_TO foreign key (CURRENCY_TO_ID) references SYS_CURRENCY(ID)
)^

------------------------------------------------------------------------------------------------------------

create function NEWID() returns varchar(36)
   return uuid(uuid());

------------------------------------------------------------------------------------------------------------

INSERT INTO SYS_CURRENCY (ID, CURRENCY_ID, NAME, DESCRIPTION, EXCHANGE_RATE) VALUES (newid(), 'R01235', 'USD', 'Доллар США', 0);
INSERT INTO SYS_CURRENCY (ID, CURRENCY_ID,  NAME, DESCRIPTION, EXCHANGE_RATE) VALUES (newid(), 'R01239', 'EUR', 'Евро', 0);
