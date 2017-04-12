
/* schema file for story database
    authors: Lucas Burdell and Timothy Francis
*/

DROP TABLE event;
DROP TABLE choice;
DROP TABLE actions;
DROP TABLE conditional;
DROP TABLE challenge;
DROP TABLE aceobject;
DROP TABLE actionsevent;

CREATE TABLE aceobject(
    id integer not null primary key,
    acetype varchar(64) not null
);

CREATE TABLE event (
    id INTEGER NOT NULL Primary Key,
    text varchar(2048) not null,
    backgroundname varchar(64),
    music varchar(64)
);


CREATE TABLE choice (
    id integer not null primary key,
    eventid integer not null,
    text varchar(1024) not null,
    actionid integer not null
);


CREATE TABLE actions (
    id integer not null primary key,
    challengeid integer,
    text varchar(1024)
);


CREATE TABLE conditional(
    id integer not null primary key,
    attachedid integer not null,
    flag varchar(64) not null,
    flagstate integer not null
);

CREATE TABLE actionsevent(
    actionid integer not null,
    eventid integer not null,
    eventposition integer not null
);

ALTER TABLE actionsevent
   ADD CONSTRAINT actionsevent_pk Primary Key (
      actionid,
      eventid);

CREATE TABLE challenge(
    challengeid integer not null primary key,
    challengename varchar(64) not null,
    challengetype varchar(64) not null
);

CREATE TRIGGER EVENTTRIG AFTER INSERT ON event REFERENCING NEW AS UPDATEDROW FOR EACH ROW INSERT INTO aceobject VALUES (UPDATEDROW.id, 'event');
CREATE TRIGGER ACTIONTRIG AFTER INSERT ON actions REFERENCING NEW AS UPDATEDROW FOR EACH ROW INSERT INTO aceobject VALUES (UPDATEDROW.id, 'action');
CREATE TRIGGER CHOICETRIG AFTER INSERT ON choice REFERENCING NEW AS UPDATEDROW FOR EACH ROW INSERT INTO aceobject VALUES (UPDATEDROW.id, 'choice');
CREATE TRIGGER CHALLENGETRIG AFTER INSERT ON challenge REFERENCING NEW AS UPDATEDROW FOR EACH ROW INSERT INTO aceobject VALUES (UPDATEDROW.challengeid, 'challenge');
CREATE TRIGGER CONDITIONALTRIG AFTER INSERT ON conditional REFERENCING NEW AS UPDATEDROW FOR EACH ROW INSERT INTO aceobject VALUES (UPDATEDROW.id, 'conditional');