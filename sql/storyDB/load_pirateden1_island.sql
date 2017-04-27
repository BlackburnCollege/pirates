/*
 PIRATE DEN 1 STARTS AT ID 500
*/

INSERT INTO event(id, text, backgroundname, music) VALUES (500, 'The journal mentioned an old friend of 
Robin Bones named Robert Knight. The journal also mentioned that Robert Knight 
runs this pirate den. I’ve never been here before, because it’s infamously 
dangerous and full of pirates. I’ll need to be careful.”
“I get off of the boat and ask the first person that I see where to find Robert 
Knight. He gives me a nervous look and whispers ‘how long has it been since you 
been here? Robert Knight was overthrown by David Davies years ago. He’s 
been in hiding ever since.’ “
“This is going to be harder than I thought. I’d better get looking for him.', 'pirate_den_island_0', 'LORD_OF_THE_LAND');
--
--Choice 1
INSERT INTO choice(id, eventid, text, actionid) VALUES (599, 500, 'Search the black market', 550);
INSERT INTO actions(id) VALUES (550);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (550, 502, 0);
--
--Choice 2
INSERT INTO choice(id, eventid, text, actionid) VALUES (598, 500, 'Search the wrecked ships', 551);
INSERT INTO actions(id) VALUES (551);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (551, 508, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (502, 'There is a black market for pirates 
here. Maybe the map piece ended up there somehow.”
“As I walk through the alleyways that holds the various shops that make up the 
pirate black market, I notice that everyone’s eyes are on me. I definitely look 
like an outsider with my fisherman’s clothing. A large and angry looking pirate 
with only one arm confronts me, “You aren’t  from around here, are you? Why are 
you here?”');
--
--Choice 1
INSERT INTO choice(id, eventid, text, actionid) VALUES (597, 502, 'I am looking 
for Robert Knight', 552);
INSERT INTO actions(id) VALUES (552);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (552, 503, 0);
--
--Choice 2
INSERT INTO choice(id, eventid, text, actionid) VALUES (596, 502, 'I am just 
trying to find my family and I am looking for a map piece.', 553);
INSERT INTO actions(id) VALUES (553);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (553, 506, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (503, '"Robert Knight was overthrown more 
than 2 years ago." the pirate growls, “We don’t take very kindly to friends of 
Robert Knight."');
INSERT INTO choice (id, eventid, text, actionid) VALUES (595, 503, 'Fight him!', 554);
INSERT INTO actions(id, challengeid) VALUES (554, 512);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (554, 504, 1);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (554, 505, 0);
INSERT INTO challenge(challengeid, challengename, challengetype) VALUES (512, 'INSERTNAMEHERE', combat);

--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id,text) VALUES (504, '"Alright!," the pirate roars, "you win! 
I know where Robert Knight is! He hangs out in the crows nest in the wrecked 
ships."');
INSERT INTO choice (id, eventid, text, actionid) VALUES(593, 504, 'next', 556);
INSERT INTO actions (id) VALUES (556);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (556, 508, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id,text) VALUES (505, 'The pirate and bunch of his buddies 
throw you back onto your boat and ban you from coming back. As you prepare you 
leave, you are startled by an strange man sitting in the middle of your boat. 
‘I heard you were looking for the map.’ ‘Who are you??,’ I exclaim. ‘You don’t 
recognize me? It’s Robert Knight. You gave me that map piece all those years 
ago.’ ‘I’m not Robin Bones. I just have a journal.’ ‘Oh...my old eyes must be 
fooling me, I suppose. But it doesn’t matter anyway. When I was overthrown, 
the map piece was stolen by another pirate, David Davies. His boat was attacked 
near the Kalinago Island. Good luck.’ Robert Knight stumbles off of my boat');
INSERT INTO choice (id, eventid, text, actionid) VALUES(592, 505, 'next', 557);
INSERT INTO actions (id) VALUES (557);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (557, 510, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (506, 'The pirates snarl turns into a grin. 
That explains why a guy like you could be here. I wish I could help you, but the 
only guy that I know with a map piece was Robert Knight and he was overthrown 
more than 2 years ago. He hangs out in the crows nest at the wrecked ships.');
INSERT INTO choice (id, eventid, text, actionid) VALUES(591, 506, 'next', 558);
INSERT INTO actions (id) VALUES (558);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (558, 508, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (507, 'Maybe I can still find Robert Knight 
somewhere. I’ll check the wrecked ships that a lot of the old pirates have taken 
over as their homes.');
--
--Choice 1
INSERT INTO choice (id, eventid, text, actionid) VALUES(590, 507, 'Go Left', 559);
INSERT INTO actions (id) VALUES (559);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (559, 508, 0);
--
--Choice 2
INSERT INTO choice (id, eventid, text, actionid) VALUES(589, 507, 'Go Right', 560);
INSERT INTO actions (id) VALUES (560);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (560, 509, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (508, 'I head through the maze of old docks 
with half-sunken old ships. After searching a couple of abandoned ships, I am 
about to give up. But then I hear someone yelling and I look up. In the crow’s 
nest of the old ship I am on is a strange looking man. ‘Who are you?,’ I ask. 
‘You don’t recognize me? It’s Robert Knight. You gave me that map piece all those 
years ago.’ ‘I’m not Robin Bones. I just have a journal.’ ‘Oh...my old eyes must 
be fooling me, I suppose. But it doesn’t matter anyway. When I was overthrown, 
the map piece was stolen by another pirate, David Davies. His boat was attacked 
near the Kalinago Island.’ Finding this map is going to be harder than I thought. 
I thank Robert Knight for his troubles as I head back to my ship.');
INSERT INTO choice (id, eventid, text, actionid) VALUES(588, 508, 'next', 561);
INSERT INTO actions (id) VALUES (561);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (561, 510, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (509, 'I walk right and search a few of the 
old ships, but I see no sign of Robert Knight anywhere. I should go back and 
try the other direction.');
INSERT INTO choice (id, eventid, text, actionid) VALUES(587, 509, 'next', 562);
INSERT INTO actions (id) VALUES (562);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (562, 511, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (510, 'It seems like I will have to go to the 
Kalinago Island to find the map piece.');
INSERT INTO choice (id, eventid, text, actionid) VALUES(586, 510, 'Go to the map', 1500);
/*
INSERT INTO actions (id) VALUES (563);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (563, 1500, 0);
*/
/*
    todo: add conditional to set "piratedencompleted" to true (1) so that map works
*/