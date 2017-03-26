CREATE TABLE event (
    eventID INTEGER NOT NULL Primary Key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    eventname varchar(64) not null,
    text varchar(64) not null,
    backgroundname varchar(64),
    music varchar(64)
);

CREATE TABLE choice (
    choiceid integer not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    choicename varchar(64) not null,
    eventid integer not null,
    text varchar(64) not null,
    actionid integer not null
);

CREATE TABLE actions (
    actionid integer not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    text varchar(64)
);

CREATE TABLE conditional(
    conditionalid integer not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    objectid integer not null,
    flag varchar(64) not null,
    flagstate integer not null,
    actionid integer not null
);

CREATE TABLE challenge(
    challengeid integer not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    challengename varchar(64) not null,
    challengetype varchar(64) not null
);

CREATE TABLE actionsevent(
    actionid integer not null,
    eventid integer not null
);

ALTER TABLE actionsevent
    add constraint ae_pk primary key (
        actionid,
        eventid
    );