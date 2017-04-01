
/* schema file for story database
    authors: Lucas Burdell and Timothy Francis
*/

CREATE TABLE event (
    id INTEGER NOT NULL Primary Key,
    text varchar(64) not null,
    backgroundname varchar(64),
    music varchar(64)
);

ALTER TABLE event add foreign key (id) references aceobject (id);

CREATE TABLE choice (
    id integer not null primary key,
    eventid integer not null,
    text varchar(512) not null,
    actionid integer not null
);

ALTER TABLE choice add foreign key (id) references aceobject (id);

CREATE TABLE actions (
    id integer not null primary key,
    text varchar(512),
    eventid integer not null
);

ALTER TABLE actions add foreign key (id) references aceobject (id);

CREATE TABLE conditional(
    id integer not null primary key,
    attachedid integer not null,
    flag varchar(64) not null,
    flagstate integer not null,
);

CREATE TABLE challenge(
    challengeid integer not null primary key,
    challengename varchar(64) not null,
    challengetype varchar(64) not null
);


CREATE TABLE aceobject(
    id integer not null primary key,
    acetype varchar(64) not null
)
