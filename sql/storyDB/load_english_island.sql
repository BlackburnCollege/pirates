/*
 ENGLISH STORY STARTS AT 100
*/
--------------------------------------------------------------INTRO----------------------------------------------------
INSERT INTO event (id, text, backgroundname, music) VALUES (100, 'After a few days at sea you can finally see Knightstone in the distance. 
You sail past warships bearing an english crest as they eye your ship. As you sail into the port of the island you can see it’s full of merchants, 
fisherman, and soldiers.','english_island_0', 'CRUSADE');
INSERT INTO choice(id, eventid, text, actionid) VALUES (101, 100, 'next', 102);
INSERT INTO choice(id, eventid, text, actionid) VALUES (295, 100, 'next', 1500);
INSERT INTO conditional(id, attachedid, flag, flagstate) VALUES (293, 101, 'mappiece1found', 0);
INSERT INTO conditional(id, attachedid, flag, flagstate) VALUES (294, 295, 'mappiece1found', 1);

INSERT INTO actions(id) VALUES (102);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (102, 103, 0);

INSERT INTO event(id, text, backgroundname) VALUES (103, 'As I dock $SHIP_NAME$ a Lieutenant flanked by two guards approaches me. The Lieutenant asks "Who is in charge of this vessel?"', 'new-pirate-ship');

  INSERT INTO choice(id, eventid, text, actionid) VALUES (104, 103, 'That would be me.', 105);
  INSERT INTO actions(id) VALUES (105);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (105, 106, 0);  


INSERT INTO event(id, text) VALUES (106, '“Ah, Welcome to Knightstone. It’s my job to inform all inbound ships of the docking tax. You will pay 10 gold shillings for each day you are docked here.”');
--
-- Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (107, 106, '“Fair enough, I’ll pay when I’m ready to depart.”', 108);
  INSERT INTO actions(id) VALUES (108);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (108, 111, 0);  -- jump to 111
--
-- Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (109, 106, '“I’m not paying any tax.”', 110);
  INSERT INTO actions(id) VALUES (110);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (110, 111, 0);  -- jump to 111
--
------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------DOCKS---------------------------------------------------
INSERT INTO event(id, text) VALUES (111, '“Very well, your ship will placed under guard until you return to pay the tax.” The Lieutenant orders the men with him to guard your ship, he turns and marches off towards the next docked ship.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (112, 111, 'next', 113);
INSERT INTO actions(id) VALUES (113);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (113, 116, 0);  

INSERT INTO event(id, text) VALUES (116, 'As I watch the Lieutenant march off my first mate approaches me and asks “So Cap’n what will ye be needin’ of us while we’re anchored?”');
INSERT INTO choice(id, eventid, text, actionid) VALUES (117, 116, '"Go and gather some supplies while I go and take care of some business."', 119);
INSERT INTO actions(id) VALUES (119);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (119, 120, 0);  

INSERT INTO event(id, text) VALUES (120, '“Ah Cap’n and how should we go about acquiring these supplies?”');
--
-- Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (121, 120, 'I toss a bag of gold at them. “Here’s some gold get some food and gear for the crew.”', 122);
  INSERT INTO actions(id) VALUES (122);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (122, 125, 0);  -- jump to 111
--
-- Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (123, 120, 'I smirk, “How about we collect our own “tax” from these soldiers.”', 124);
  INSERT INTO actions(id) VALUES (124);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (124, 125, 0);  -- jump to 111

INSERT INTO event(id, text) VALUES (125, 'I open the journal and look for any clues to where the map piece may be on Knightstone. However, you’re unable to find anything specific. Frustrated, you leave the crew with their task and head off to find the nearest tavern.
');
INSERT INTO choice(id, eventid, text, actionid) VALUES (126, 125, 'next', 127);
INSERT INTO actions(id) VALUES (127);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (127, 128, 0);  
------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------TAVERN------------------------------------------------
INSERT INTO event(id, text, music) VALUES (128, 'I walk through the town and arrive at a local Tavern called the Golden Oak. The tavern is bustling with all sorts of people. You approach the bartender and order a drink. You overhear a group of sailors laughing and shouting in the back about some crazy old pirate trying to sell some scrap of a map to the local Dockmaster.', 'LORD_OF_THE_LAND');

-- Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (129, 128, 'Approach the group.', 130);
  INSERT INTO actions(id) VALUES (130);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (130, 140, 0);  -- jump to 140 || COMBAT PATH
--
-- Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (131, 128, 'Finish my drink and look for the Dockmaster.', 132);
  INSERT INTO actions(id) VALUES (132);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (132, 160, 0);  -- jump to 150
  ------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------TAVERN COMBAT-------------------------------------------
INSERT INTO event(id, backgroundname, text) VALUES (140,'Drunken Sailor','As I approach the table one of drunken sailors notices you and shouts “Oi! What’re you lookin at you salty old mutt!”');
  INSERT INTO choice(id, eventid, text, actionid) VALUES (141, 140, '“Tell me about this crazy old pirate you were talking about.”', 142);
  INSERT INTO actions(id) VALUES (142);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (142, 143, 0);  -- jump to 143 || COMBAT

INSERT INTO event(id, text, music) VALUES (143, '“We ain’t tellin you nothin you washed up whale!” One of them breaks a bottle and attacks you.', 'CORRUPTION');
insert into choice(id, eventid, text, actionid) values (144, 143, 'It’s a brawl!' , 145);
insert into actions(id, challengeid) values (145, 146);

insert into actionsevent (actionid, eventid, eventposition) values (145, 148, 0);

insert into actionsevent (actionid, eventid, eventposition) values (145, 147, 1);

insert into challenge(challengeid, challengename, challengetype) values (146, 'Drunken Sailor', 'combat');

INSERT INTO event(id, text, music) VALUES (147, 'The town guards burst in as I knock the drunken sailor out. The last thing I remember seeing is the guards shouting as they rush at me and feeling one of them hit me over the head with his rifle.', 'LIVING_VOYAGE');
  INSERT INTO choice(id, eventid, text, actionid) VALUES (151, 148, 'next', 152);
  INSERT INTO actions(id) VALUES (152);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (152, 190, 0);  -- jump to 190

INSERT INTO event(id, text, music) VALUES (148, 'I feel the Sailor throw one final punch that throws me to the ground.', 'LIVING_VOYAGE');
  INSERT INTO choice(id, eventid, text, actionid) VALUES (150, 147, 'next', 153);
  INSERT INTO actions(id) VALUES (153);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (153, 190, 0);  -- jump to 190

--------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------DOCKS-----------------------------------------------
INSERT INTO event (id, text, backgroundname, music) VALUES (160, 'I leave the tavern and head back towards the dock intent on questioning the Dockmaster.','new-pirate-ship','CRUSADE');
INSERT INTO choice(id, eventid, text, actionid) VALUES (161, 160, 'next', 162);
INSERT INTO actions(id) VALUES (162);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (162, 163, 0);

INSERT INTO event(id, text) VALUES (163, 'I survey the docks and spot the Lieutenant from earlier. I approach the Lieutenant and ask about the crazy old pirate I had overheard about. The Lieutenant states that he was dragged off to jail for being unable to pay the Harbour tax. He reminds me that I still need to pay before I’ll be allowed to depart and returns to his business.');

  INSERT INTO choice(id, eventid, text, actionid) VALUES (164, 163, 'Leave the Dockmaster to his papers and head off back into town looking for the jail.', 165);
  INSERT INTO actions(id) VALUES (165);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (165, 170, 0);  
  ------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------ALLEY-----------------------------------------------
INSERT INTO event(id, text, backgroundname) VALUES (170, 'As I make my way through town I feel a hard tug on my bag and notice somebody sprint off into an alley.', 'alleyway_0');

  INSERT INTO choice(id, eventid, text, actionid) VALUES (171, 170, 'Sprint after the thief.', 172);
  INSERT INTO actions(id) VALUES (172);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (172, 173, 0);  

INSERT INTO event(id, text) VALUES (173, 'As I catch up to the thief he drops my bag and turns around brandishing a knife. Looks like I’ll have to reclaim my property by force.');

  INSERT INTO choice(id, eventid, text, actionid) VALUES (174, 173, 'It’s on!', 175);
insert into actions(id, challengeid) values (175, 176);

insert into actionsevent (actionid, eventid, eventposition) values (175, 178, 0);

insert into actionsevent (actionid, eventid, eventposition) values (175, 177, 1);

insert into challenge(challengeid, challengename, challengetype) values (176, 'Thief', 'combat');

INSERT INTO event(id, text, music) VALUES (177, 'As the thief falls to the ground he shouts out “Help I’m being robbed!” The Town guard surrounds me and demands that I “Get away from the Governor’s son!” A smug look appears on the thief’s face as they clasp me in irons and drag me off to jail while I protested loudly.', 'LIVING_VOYAGE');
  INSERT INTO choice(id, eventid, text, actionid) VALUES (181, 178, 'next', 182);
  INSERT INTO actions(id) VALUES (182);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (182, 190, 0);  -- jump to 190

INSERT INTO event(id, text, music) VALUES (178, 'The Thief hits my head hard with the hilt of his blade. The Town guard must have spotted me unconscious in the alley and dragged me to jail assuming that I was drunk.', 'LIVING_VOYAGE');
  INSERT INTO choice(id, eventid, text, actionid) VALUES (180, 177, 'next', 183);
  INSERT INTO actions(id) VALUES (183);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (183, 190, 0);  -- jump to 190
--------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------JAIL-------------------------------------------------
INSERT INTO event(id, text, backgroundname) VALUES (190, 'I wake up in a dusty old cell and sigh and chuckle to myself as I came realize where I am. “So much for keeping a low profile” I think to myself. I look around my new surroundings and I see a young guard reading the journal from my bag with enthusiasm. I also notice a decrepit old man in the corner of my cell.', 'Jail');

  INSERT INTO choice(id, eventid, text, actionid) VALUES (191, 190, 'I ask the old man if he’s the old pirate I heard about in the Tavern.', 192);
  INSERT INTO actions(id) VALUES (192);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (192, 193, 0);

INSERT INTO event(id, text) VALUES (193, 'The old man looks up at me and nods. He says “I lost most of my possessions to some other pirates and barely managed to get away with my life.”  The man sighs and states that he had hoped to trade part of a map he believed to be of great value in exchange for repairs. I thank the man for the information and turn my attention to the guard reading my journal.');

  INSERT INTO choice(id, eventid, text, actionid) VALUES (194, 193, 'I shout at the guard "Hey! That’s my journal!', 195);
  INSERT INTO actions(id) VALUES (195);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (195, 196, 0);

INSERT INTO event(id, text) VALUES (196, 'I appear to have startled the young guard as he proclaims “S-Sorry! I couldn’t help it I always wondered about if all pirates were as heartless as my father always told me they were.” He gets a curious look on his face as he asks me what I’m doing in a place like this as a pirate.');
  INSERT INTO choice(id, eventid, text, actionid) VALUES (197, 196, '"Well jail seems to be standard for most pirates, we must love this dreary aroma of dust" I joked, and explained to him that I wouldn’t be here if not for some bastard kidnapping my family and demanding that I find some mystical treasure.', 198);
  INSERT INTO actions(id) VALUES (198);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (198, 199, 0); 


INSERT INTO event(id, text, music) VALUES (199, 'The Guard expresses his sympathy for me and says “Look I can understand your position and I can’t say I wouldn’t do the same for my family if I were in your shoes.” He looks around the jail before he looks me in the eyes and states “But I’m a member of the English Colonial Guard and I’m not allowed to tell you that part of the map you’re looking for is in our safe” he winks at you. He approaches you and unlocks your cell and says “and I certainly didn’t know you had a lockpick hidden on your person. I’m leaving you completely locked up and taking my lunch break.” He leaves the room with your journal on his desk next to the contraband safe.', 'NOTHING');
insert into choice(id, eventid, text, actionid) values (200, 199, 'Begin puzzle challenge.' , 201);
insert into actions(id, challengeid) values (201, 202);
insert into challenge(challengeid, challengename, challengetype) values (202, 'safecrack', 'puzzle');
insert into actionsevent (actionid, eventid, eventposition) values (201, 207, 0);  -- jump to 207 on puzzle fail
insert into actionsevent (actionid, eventid, eventposition) values (201, 208, 1);  -- jump to 208 on puzzle solve

INSERT INTO event(id, text, music) VALUES (208, 'I successfully open the safe and spot some gold and the map piece that I’ve been hearing so much about. I grab the map piece and gold and lock the safe. I leave the jail and head back to the Docks.', 'LIVING_VOYAGE');
  INSERT INTO choice(id, eventid, text, actionid) VALUES (211, 208, 'next', 212);
  INSERT INTO actions(id) VALUES (212);
  INSERT INTO conditional(id, attachedid, flag, flagstate) VALUES (214, 212, 'mappiece1found', 1);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (212, 220, 0);  


INSERT INTO event(id, text, music) VALUES (207, 'I fail to crack the safe. Frustrated I search around and spot some tools inside the desk and force my way inside the safe. "Safe cracking indeed!" I laugh to myself as the old man covers his face with his palm.', 'LIVING_VOYAGE');
  INSERT INTO choice(id, eventid, text, actionid) VALUES (210, 207, 'next', 213);
  INSERT INTO actions(id) VALUES (213);
  INSERT INTO conditional(id, attachedid, flag, flagstate) VALUES (215, 213, 'mappiece1found', 1);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (213, 220, 0);  
--------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------DEPARTURE--------------------------------------------
INSERT INTO event(id, text, backgroundname) VALUES (220, 'As I walk back towards $SHIP_NAME$ I spot my crew finishing loading up some supplies. My first mate meets me “We acquired those supplies ye asked us to get Cap’n, are we ready to weigh anchor?” I nod at him as the Dockmaster approaches you.', 'new-pirate-ship');

  INSERT INTO choice(id, eventid, text, actionid) VALUES (221, 220, 'next', 222);
  INSERT INTO actions(id) VALUES (222);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (222, 223, 0);  

INSERT INTO event(id, text) VALUES (223, 'The Lieutenant states “I hope you weren’t planning on going anywhere without paying the Harbor tax.” ');

-- Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (224, 223, 'I sigh and say “Of course I was always going to pay your tax.” I toss him some of the gold I collected from the jail. "It is technically theirs after all" I joke to my crew.', 225);
  INSERT INTO actions(id) VALUES (225);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (225, 250, 0);  -- jump to 250
--
-- Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (226, 223, 'I laugh and whistle to my crew. My crew and I push the guards into the bay and jump onto our ship. “I ain’t giving no Redcoat my money! Give the greedy old King my regards would ye?” ', 227);
  INSERT INTO actions(id) VALUES (227);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (227, 250, 0);  -- jump to 250

INSERT INTO event(id, text) VALUES (250, '"Let’s sail lads!"');

insert into choice(id, eventid, text, actionid) values (240, 250, 'set sail', 1500);


--------------------------------------------------------------------------------------------------------------------------
