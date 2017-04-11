/*
 * Author:  lucas.burdell
 * Created: Mar 21, 2017
 */

INSERT INTO aceobject(id, acetype) VALUES (1, 'event');
INSERT INTO event(id, text, backgroundname, music) VALUES (1, 
'I awake from a deep slumber. I had the nightmare again. The one where I was 
kidnapped by pirates. I am a humble fisherman, living with my wife and child 
living on the quiet island of Summer Shore. Summer Shore has been my home since 
the incident where I lost all my memory. I get out of bed and head downstairs...',
'cave', 'LIVING_VOYAGE');

INSERT INTO aceobject(id, acetype) VALUES (2, 'choice');
INSERT INTO choice(id, eventid, text, actionid) VALUES (2, 1, 'I greet my wife.', 3);

INSERT INTO aceobject(id, acetype) VALUES (3, 'action');
INSERT INTO actions(id, text) VALUES (3, 'She greets me back.');

INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (3, 1, 0);


CREATE TABLE choice (
    id integer not null primary key,
    eventid integer not null,
    text varchar(1024) not null,
    actionid integer not null
);


