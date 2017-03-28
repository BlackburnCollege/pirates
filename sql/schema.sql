CREATE TABLE event (
    eventID INTEGER NOT NULL Primary Key,
    text varchar(64) not null,
    backgroundname varchar(64),
    music varchar(64)
);

CREATE TABLE choice (
    choiceid integer not null primary key,
    eventid integer not null,
    text varchar(512) not null,
    actionid integer not null
);

CREATE TABLE actions (
    actionid integer not null primary key,
    text varchar(512)
);

CREATE TABLE conditional(
    conditionalid integer not null primary key,
    aceid integer not null,
    flag varchar(64) not null,
    flagstate integer not null,
    actionid integer not null
);

CREATE TABLE challenge(
    challengeid integer not null primary key,
    challengename varchar(64) not null,
    challengetype varchar(64) not null
);

CREATE TABLE actionsevent(
    aceid integer not null primary key,
    actionid integer not null,
    eventid integer not null
);

ALTER TABLE actionsevent
    add constraint ae_pk primary key (
        actionid,
        eventid
    );