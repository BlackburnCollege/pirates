/*
 * Author:  lucas.burdell
 * Created: Mar 21, 2017
 */

/*
TUTORIAL STARTS AT ID 1
*/
# INSERT INTO aceobject(id, acetype) VALUES (1, 'event');
INSERT INTO event(id, text, backgroundname, music) VALUES (1, 
'My name is $PLAYER_NAME$. I awake from a deep slumber. I had the nightmare again. The one where I was kidnapped by pirates. I am a humble fisherman, living with my wife and child living on the quiet island of Summer Shore. Summer Shore has been my home since the incident where I lost all my memory. I get out of bed and head downstairs...', 'summershore_0', 'LIVING_VOYAGE');

INSERT INTO choice(id, eventid, text, actionid) VALUES (2, 1, 'next', 3);

INSERT INTO actions(id) VALUES (3);

INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (3, 4, 0);

insert into event(id, text, backgroundname) values(4,'As I go downstairs, I see my $SPOUSE_MARITAL_TITLE$, $SPOUSE_NAME$. $SPOUSE_NAME$ looks absolutely beautiful, sitting in $SPOUSE_POSESSIVE$ cozy chair sipping green tea while watching the sunrise.  I greet them...', '');

insert into choice(id, eventid, text, actionid) values (5, 4, '“Hello, my darling.” I kneel down and gently kiss $SPOUSE_POSESSIVE$ forehead.', 6);

insert into actions(id) values (6);

insert into actionsevent (actionid, eventid, eventposition) values (6, 7, 0);

insert into event(id, text) values(7,'“Hello love. How did you sleep?”');

insert into choice(id, eventid, text, actionid) values (8, 7, ' “I slept well, thank you." you lie; not wanting to talk about your nightmares.', 9);

insert into actions(id, text) values (9, '“That’s great, dear” $SPOUSE_PRONOUN$ gives a thin smile. $SPOUSE_PRONOUN$ knows you lied.');

insert into actionsevent (actionid, eventid, eventposition) values (9, 19, 0);

insert into choice(id, eventid, text, actionid) values (10, 7, '“I didn’t sleep well last night; I had that nightmare again.” I grimace at the thought of it.', 11);

insert into actions(id, text) values (11, '“I’m sorry to hear that, dear. I wish there were something I could do to help...”');

insert into actionsevent (actionid, eventid, eventposition) values (11, 19, 0);

insert into choice(id, eventid, text, actionid) values (12, 4, 'I stand back and stare at $SPOUSE_NAME$.', 13);

insert into actions(id) values (13);

insert into actionsevent (actionid, eventid, eventposition) values (13, 14, 0);

insert into actionsevent (actionid, eventid, eventposition) values (11, 14, 0);

insert into event(id, text) values(14,'$SPOUSE_PRONOUN$ continues to sip $SPOUSE_POSESSIVE$ tea while staring at the sunset. Gently flowing in the breeze is $SPOUSE_POSESSIVE$ beautiful, black hair. ');

insert into choice(id, eventid, text, actionid) values (15, 14, 'I greet $SPOUSE_NAME$...', 16);

insert into actions(id) values (16);

insert into actionsevent (actionid, eventid, eventposition) values (16, 7, 0);

insert into choice(id, eventid, text, actionid) values (17, 14, 'Continue staring.', 18);

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

insert into actions(id, text) values (24, 'I bid my family goodbye and walk out the door. ');

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

INSERT INTO event(id, text) VALUES (32, 'I caught a great amount of fish today! I might have enough to surprise $SPOUSE_NAME$ with a gift.');

insert into choice(id, eventid, text, actionid) values (34, 32, 'Return to shore' , 35);

insert into actions(id, text) values (35, 'I sell your catch for the day, and even manage to barter for an adorable sea-shell necklace while still buying food for the week.');

insert into actionsevent (actionid, eventid, eventposition) values (35, 38, 0);

INSERT INTO event(id, text) VALUES (33, 'I didn’t quite get enough fish today, but it’ll do. ');

insert into choice(id, eventid, text, actionid) values (36, 33, 'return to shore' , 37);

insert into actions(id, text) values (37, 'I sell what I caught for the day, and manage to get enough money to buy a week''s worth of food.');

insert into actionsevent (actionid, eventid, eventposition) values (37, 38, 0);

INSERT INTO event(id, backgroundname, text, music) VALUES (38,'wolf','While walking back home from the docks, I notice that the birds are not chirping as they were in the morning. It seems quieter than usual. The bushes to my left begin rustling and growling; a hungry wolf jumps out! ', 'CORRUPTION');

insert into choice(id, eventid, text, actionid) values (39, 38, 'ready yourself' , 40);

insert into actions(id, challengeid) values (40, 41);

insert into actionsevent (actionid, eventid, eventposition) values (40, 43, 0);

insert into actionsevent (actionid, eventid, eventposition) values (40, 42, 1);

insert into challenge(challengeid, challengename, challengetype) values (41, 'wolf', 'combat');

INSERT INTO event(id, text, music) VALUES (42, 'I deliver one final blow to the wolf, and it quickly runs back into the forest yelping in pain.', 'LIVING_VOYAGE');

insert into choice(id, eventid, text, actionid) values (44, 42, 'I gather my things and head back home.' , 46);

insert into actions(id) values (46);

insert into actionsevent (actionid, eventid, eventposition) values (46, 49, 0);

INSERT INTO event(id, text, music) VALUES (43, 'The wolf knocks me to the ground. It stands above me, its face twisted with a nasty snarl. As I close my eyes and brace myself, I feel it jump off my body. When I get up, I notice that it ran off with my knapsack. The food I had brought for tonight’s dinner is gone, but I am at least I am still alive.', 'LIVING_VOYAGE');

insert into choice(id, eventid, text, actionid) values (47, 43, 'I dust myself off and continue home.' , 48);

insert into actions(id) values (48);

insert into actionsevent (actionid, eventid, eventposition) values (48, 49, 0);

INSERT INTO event(id, backgroundname, text) VALUES (49, 'summershore_0', 'When I arrive home, I notice the house is eerily dark and quiet. The door is left ajar. Sensing something is wrong, I rush inside to look for my family. The house is a mess: furniture is strewn about, the floor and walls torn up as if someone were looking for something.');

insert into choice(id, eventid, text, actionid) values (50, 49, 'rush upstairs' , 51);

insert into actions(id, text) values (51, 'I rush upstairs in a panic, crashing loudly through the bedroom doorway.

I find no one. On the desk lay a lit candle and a handwritten note laying atop a journal.');

insert into actionsevent (actionid, eventid, eventposition) values (51, 54, 0);

insert into choice(id, eventid, text, actionid) values (52, 49, 'creep upstairs' , 53);

insert into actions(id, text) values (53, 'As quietly as I can manage, I sneak up the stairs. My dagger at the ready for anything or anyone. 
The door to the master bedroom is cracked open; I peer into the room. Everything is still the same as it was, except on the desk is a lit candle and a handwritten note laying atop a journal.'); 

insert into actionsevent (actionid, eventid, eventposition) values (53, 54, 0);

INSERT INTO event(id, text) VALUES (54, '"I have taken your family. They will be kept in good hands, but if you wish to see them again, you will find the legendary treasure of the greyhaven keys. I know where it is - this journal will remind you. If not, figure it out. PS: you might need what’s in the bundle on the bed. Don’t ever say I didn’t do anything for you."');

insert into choice(id, eventid, text, actionid) values (55, 54, 'Look in the bundle' , 56);

insert into actions(id, text) values (56, 'Unwrapping the linen, I find a dull cutlass and a rusty flintlock pistol. I return to examine the journal.'); 

insert into actionsevent (actionid, eventid, eventposition) values (56, 57, 0);

INSERT INTO event(id, text) VALUES (57, 'I skim through the journal, finding references to hidden map pieces among stories of plundering, pillaging and outright debauchery. The closest piece seems to be on the island of Knightstone. I’ll need a ship and crew to get there. I’ll also need money; luckily, I’ve been saving for emergencies. I’d say this qualifies.');

insert into choice(id, eventid, text, actionid) values (58, 57, 'gather savings.' , 59);

insert into actions(id) values (59); 

insert into actionsevent (actionid, eventid, eventposition) values (59, 60, 0);

INSERT INTO event(id, text) VALUES (60, 'I go outside and open a secret compartment within the outhouse to retrieve my savings for the past few years. This should be enough for a small sloop and enough crew and supplies to get to Knightstone. ');

insert into choice(id, eventid, text, actionid) values (61, 60, 'I head to the tavern to hire some crew.', 62);

insert into actions(id) values (62); 

insert into actionsevent (actionid, eventid, eventposition) values (62, 63, 0);

INSERT INTO event(id, text) VALUES (63, 'If you’re going to find a crew for a ship, this would be the place to find it. I find a group of men who say they’ll help me for a price.');

insert into choice(id, eventid, text, actionid) values (64, 63, 'sign on a crew.', 65);

insert into actions(id) values (65); 

insert into actionsevent (actionid, eventid, eventposition) values (65, 66, 0);

INSERT INTO event(id, text) VALUES (66, 'I sign up a bunch of young lads; they seem trustworthy and able to handle themselves on the sea. Now to get a ship.');

insert into choice(id, eventid, text, actionid) values (67, 66, 'go to the docks.', 68);

insert into actions(id) values (68); 

insert into actionsevent (actionid, eventid, eventposition) values (68, 69, 0);

INSERT INTO event(id, text) VALUES (69, ' I manage to find the shipwright; he’s a little disgruntled that I’ve caught him while he’s about to close shop, but this is important. 
“Do you have anything I can have today?” I ask, hoping for a yes.
“Well, I have this old fishing schooner…”');

insert into choice(id, eventid, text, actionid) values (70, 69, '“I’ll take it!”', 71);

insert into actions(id) values (71);

insert into actionsevent (actionid, eventid, eventposition) values (71, 72, 0);

INSERT INTO event(id, text) VALUES (72, 'I and your crew step onto your ship; it’s old, crusty and poorly maintained, but still seaworthy. 
A crew member walks up to you.
“Cap’n, she needs a name!”');

insert into choice(id, eventid, text, actionid) values (73, 72, '“Aye. I’ll call her…”', 74);

insert into actions(id, challengeid) values (74, 76);

insert into actionsevent (actionid, eventid, eventposition) values (74, 75, 0);

insert into challenge(challengeid, challengename, challengetype) values (76, 'shipname', 'other');

INSERT INTO event(id, text) VALUES (75, '"Aye cap’n, ''$SHIP_NAME$'' be a fine name. We be ready now."');

insert into choice(id, eventid, text, actionid) values (77, 75, 'set sail', 81);

insert into actions(id) values (81);

insert into actionsevent (actionid, eventid, eventposition) values (81, 1500, 0);

/*

insert into actions(id) values (78);

insert into actionsevent (actionid, eventid, eventposition) values (78, 1500, 0);
*/

insert into event(id, text) values (79, 'I return to my home port, but it just doesn''t feel the same without my family.');

insert into choice(id, eventid, text, actionid) values (80, 79, 'set sail', 1500);

