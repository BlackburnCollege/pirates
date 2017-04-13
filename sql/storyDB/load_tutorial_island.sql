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

INSERT INTO choice(id, eventid, text, actionid) VALUES (2, 1, 'next', 3);

INSERT INTO actions(id) VALUES (3);

INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (3, 4, 0);

insert into event(id, text, backgroundname) values(4,'As I go downstairs, I see my wife, Marjorie. She’s in a beautiful summer dress, sitting in her cozy chair sipping green tea while watching the sunrise.  I greet her...', '');

insert into choice(id, eventid, text, actionid) values (5, 4, '“Hello, my darling.” I kneel down and gently kiss her forehead.', 6);

insert into actions(id) values (6);

insert into actionsevent (actionid, eventid, eventposition) values (6, 7, 0);

insert into event(id, text) values(7,'“Hello love. How did you sleep?”');

insert into choice(id, eventid, text, actionid) values (8, 7, ' “I slept well, thank you." you lie; not wanting to talk about your nightmares.', 9);

insert into actions(id, text) values (9, '“That’s great, dear” she gives a thin smile. She knows you lied.');

insert into actionsevent (actionid, eventid, eventposition) values (9, 19, 0);

insert into choice(id, eventid, text, actionid) values (10, 7, '“I didn’t sleep well last night; I had that nightmare again.” You grimace at the thought of it.', 11);

insert into actions(id, text) values (11, '“I’m sorry to hear that, dear. I wish there were something I could do to help...”');

insert into actionsevent (actionid, eventid, eventposition) values (11, 19, 0);

insert into choice(id, eventid, text, actionid) values (12, 4, 'I stand back and stare at her.', 13);

insert into actions(id) values (13);

insert into actionsevent (actionid, eventid, eventposition) values (13, 14, 0);

insert into actionsevent (actionid, eventid, eventposition) values (11, 14, 0);

insert into event(id, text) values(14,'She continues to sip her tea while staring at the sunset. Her beautiful, black hair gently flowing in the slight breeze. ');

insert into choice(id, eventid, text, actionid) values (15, 14, 'I greet her...', 16);

insert into actions(id) values (16);

insert into actionsevent (actionid, eventid, eventposition) values (16, 7, 0);

insert into choice(id, eventid, text, actionid) values (17, 14, 'Continue staring.', 16);

insert into actions(id) values (18);

insert into actionsevent (actionid, eventid, eventposition) values (18, 19, 0);

INSERT INTO event(id, text) VALUES (19, 'I hear the patter of small, excited feet coming down the stairs. “You’re awake!” Little Benjamin; while not my real son, he’s the closest thing I have to one. ');

insert into choice(id, eventid, text, actionid) values (20, 19, '“Good morning Ben!”' , 21);

insert into actions(id) values (21);

insert into actionsevent (actionid, eventid, eventposition) values (21, 99, 0);

INSERT INTO event(id, text) VALUES (99, '“Good morning"');

insert into choice(id, eventid, text, actionid) values (98, 99, 'Hug Ben' , 97);

insert into actions(id) values (97);

insert into actionsevent (actionid, eventid, eventposition) values (97, 22, 0);

INSERT INTO event(id, text) VALUES (22, 'It’s already past sunrise. I’ve dawdled for too long; those fish won’t catch themselves!');

insert into choice(id, eventid, text, actionid) values (23, 22, 'Go to docks.' , 24);

insert into actions(id, text) values (24, 'You bid your family goodbye and walk out the door. ');

insert into actionsevent (actionid, eventid, eventposition) values (24, 25, 0);

INSERT INTO event(id, text) VALUES (25, 'It’s a fairly pleasant morning. birds are chirping as they awake from their sleep. The trees rustle with the ocean breeze. On the way to the docks, I passed the usual crowd of fellow early-bird islanders heading to their daily activities. I wave and say hello to my friends.');

insert into choice(id, eventid, text, actionid) values (26, 25, 'Continue to docks' , 27);

insert into actions(id, text) values (27, 'I continue walking down the path to the docks.');

insert into actionsevent (actionid, eventid, eventposition) values (27, 28, 0);

INSERT INTO event(id, text) VALUES (28, 'I board and begin undocking my fishing boat. Once it is on the sea, I begin paddling out to my favorite fishing spot: a small inlet on the far side of the island.There is usually a big school of bluefin tunas swimming nearby.');

insert into choice(id, eventid, text, actionid) values (29, 28, 'Paddle to the inlet' , 30);

insert into actions(id, challengeid) values (30, 31);

insert into actionsevent (actionid, eventid, eventposition) values (30, 32, 1);

insert into actionsevent (actionid, eventid, eventposition) values (30, 33, 0);

insert into challenge(challengeid, challengename, challengetype) values (31, 'fish', 'puzzle');

INSERT INTO event(id, text) VALUES (32, 'I caught a great amount of fish today! I might have enough to surprise Marjorie with a gift.');

insert into choice(id, eventid, text, actionid) values (34, 32, 'Return to shore' , 35);

insert into actions(id, text) values (35, 'You sell your catch for the day, and even manage to barter for an adorable sea-shell necklace while still buying food for the week.');

insert into actionsevent (actionid, eventid, eventposition) values (35, 38, 0);

INSERT INTO event(id, text) VALUES (33, 'I didn’t quite get enough fish today, but it’ll do. ');

insert into choice(id, eventid, text, actionid) values (36, 33, 'return to shore' , 37);

insert into actions(id, text) values (37, 'You sell what you caught for the day, and manage to get enough money to buy food for the day.');

insert into actionsevent (actionid, eventid, eventposition) values (37, 38, 0);

INSERT INTO event(id, text) VALUES (38, 'While walking back home from the docks, I notice that the birds are not chirping as they were in the morning. It seems quieter than usual. The bushes to my left begin rustling and growling; a hungry wolf jumps out! ');

insert into choice(id, eventid, text, actionid) values (39, 38, 'ready yourself' , 40);

insert into actions(id) values (40);

insert into actionsevent (actionid, eventid, eventposition) values (40, 43, 0);

insert into actionsevent (actionid, eventid, eventposition) values (40, 42, 1);

insert into challenge(challengeid, challengename, challengetype) values (41, 'wolf', 'combat');

INSERT INTO event(id, text) VALUES (42, 'I deliver one final blow to the wolf, and it quickly runs back into the forest yelping in pain.');

insert into choice(id, eventid, text, actionid) values (44, 42, 'I gather my things and head back home.' , 45);

insert into actions(id) values (46);

insert into actionsevent (actionid, eventid, eventposition) values (46, 49, 0);

INSERT INTO event(id, text) VALUES (43, 'The wolf knocks me to the ground. It stands above me, its face twisted with a nasty snarl. As I close my eyes and brace myself, I feel it jump off my body. When I get up, I notice that it ran off with my knapsack. The food I had brought for tonight’s dinner is gone, but I am at least I am still alive.');

insert into choice(id, eventid, text, actionid) values (47, 43, 'I dust myself off and continue home.' , 48);

insert into actions(id) values (48);

insert into actionsevent (actionid, eventid, eventposition) values (48, 49, 0);

INSERT INTO event(id, text) VALUES (49, 'When I arrive home, I notice the house is eerily dark and quiet. The door is left ajar. Sensing something is wrong, I rush inside to look for my family. The house is a mess: furniture is strewn about, the floor and walls torn up as if someone were looking for something.');

insert into choice(id, eventid, text, actionid) values (50, 49, 'rush upstairs' , 51);

insert into actions(id, text) values (51, 'I rush upstairs, yelling. 
“MARJORIE??”
“BEN?!?”
No answer. I find no one. On the desk lay a lit candle and a handwritten note laying atop a journal.');

insert into actionsevent (actionid, eventid, eventposition) values (51, 54, 0);

insert into choice(id, eventid, text, actionid) values (52, 49, 'creep upstairs' , 53);

insert into actions(id, text) values (53, 'As quietly as I can manage, I sneak up the stairs. My dagger at the ready for anything or anyone. 
The door to the master bedroom is cracked open; I peer into the room. Everything is still the same as it was, except on the desk is a lit candle and a handwritten note laying atop a journal.'); 

insert into actionsevent (actionid, eventid, eventposition) values (53, 54, 0);

INSERT INTO event(id, text) VALUES (49, 'When I arrive home, I notice the house is eerily dark and quiet. The door is left ajar. Sensing something is wrong, I rush inside to look for my family. The house is a mess: furniture is strewn about, the floor and walls torn up as if someone were looking for something.');


