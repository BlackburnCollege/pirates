/*
 * Author:  lucas.burdell
 * Created: Mar 21, 2017
 */

/*
TUTORIAL STARTS AT ID 1
*/
# INSERT INTO aceobject(id, acetype) VALUES (1, 'event');
INSERT INTO event(id, text, backgroundname, music) VALUES (1, 
'I awake from a deep slumber. I had the nightmare again. The one where I was kidnapped by pirates. I am a humble fisherman, living with my wife and child living on the quiet island of Summer Shore. Summer Shore has been my home since the incident where I lost all my memory. I get out of bed and head downstairs...','cave', 'LIVING_VOYAGE');

INSERT INTO choice(id, eventid, text, actionid) VALUES (2, 1, 'I greet my wife.', 3);

INSERT INTO actions(id, text) VALUES (3, 'She greets me back.');

INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (3, 4, 0);

insert into aceobject(id, actype) values (4, 'event');
insert into event(id, text, backgroundname) values(4,'As I go downstairs, I see my wife, Marjorie. She’s in a beautiful summer dress, sitting in her cozy chair sipping green tea while watching the sunrise.  I greet her...', '');

insert into aceobject(id, acetype) values (5, 'choice');
insert into choice(id, eventid, text, actionid) values (5, 4, '“Hello, my darling.” I kneel down and gently kiss her forehead.', 6);

insert into aceobject(id, acetype) values (6, 'action');
insert into actions(id) values (6);

insert into aceobject(id, actype) values (7, 'event');
insert into event(id, text) values(7,'“Hello love. How did you sleep?”');

insert into aceobject(id, acetype) values (8, 'choice');
insert into choice(id, eventid, text, actionid) values (8, 7, ' “I slept well, thank you." you lie; not wanting to talk about your nightmares.', 9);

insert into aceobject(id, acetype) values (9, 'action');
insert into actions(id, text) values (6, '“That’s great, dear” she gives a thin smile. She knows you lied.');

insert into actionsevent (actionid, eventid, eventposition) values (9, 18, 0);

insert into aceobject(id, acetype) values (10, 'choice');
insert into choice(id, eventid, text, actionid) values (10, 7, '“I didn’t sleep well last night; I had that nightmare again.” You grimace at the thought of it.', 11);

insert into aceobject(id, acetype) values (11, 'action');
insert into actions(id, text) values (11, '“I’m sorry to hear that, dear. I wish there were something I could do to help...”');

insert into actionsevent (actionid, eventid, eventposition) values (11, 19, 0);

insert into aceobject(id, acetype) values (12, 'choice');
insert into choice(id, eventid, text, actionid) values (12, 4, 'I stand back and stare at her.', 13);

insert into aceobject(id, acetype) values (13, 'action');
insert into actions(id) values (13);

insert into actionsevent (actionid, eventid, eventposition) values (11, 14, 0);

insert into aceobject(id, actype) values (14, 'event');
insert into event(id, text) values(14,'She continues to sip her tea while staring at the sunset. Her beautiful, black hair gently flowing in the slight breeze. ');

insert into aceobject(id, acetype) values (15, 'choice');
insert into choice(id, eventid, text, actionid) values (15, 14, 'I greet her...', 16);

insert into aceobject(id, acetype) values (16, 'action');
insert into actions(id) values (16);

insert into actionsevent (actionid, eventid, eventposition) values (16, 7, 0);

insert into aceobject(id, acetype) values (17, 'choice');
insert into choice(id, eventid, text, actionid) values (17, 14, 'Continue staring.', 16);

insert into aceobject(id, acetype) values (18, 'action');
insert into actions(id) values (18);

insert into actionsevent (actionid, eventid, eventposition) values (18, 19, 0);

INSERT INTO aceobject(id, acetype) VALUES (19, 'event');
INSERT INTO event(id, text, backgroundname, music) VALUES (19, 'I hear the patter of small, excited feet coming down the stairs. “You’re awake!” Little Benjamin; while not my real son, he’s the closest thing I have to one. ');

insert into aceobject(id, acetype) values (20, 'choice');
insert into choice(id, eventid, text, actionid) values (20, 19, '“Good morning Ben!”' , 21);

insert into aceobject(id, acetype) values (21, 'action');
insert into actions(id, text) values (21, 'Hug child');

insert into actionsevent (actionid, eventid, eventposition) values (21, 22, 0);

INSERT INTO aceobject(id, acetype) VALUES (19, 'event');
INSERT INTO event(id, text, backgroundname, music) VALUES (19, 'It’s already past sunrise. I’ve dawdled for too long; those fish won’t catch themselves!');

insert into aceobject(id, acetype) values (20, 'choice');
insert into choice(id, eventid, text, actionid) values (20, 19, '“Good morning Ben!”' , 21);

