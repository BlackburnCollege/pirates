/*
 ENGLISH STORY STARTS AT 100
*/

INSERT INTO event (id, text, backgroundname, music) VALUES (100, 'After a few days at sea you can finally see Knightstone in the distance. 
You sail past warships bearing an english crest as they eye your ship. As you sail into the port of the island you can see it’s full of merchants, 
fisherman, and soldiers. As you dock $SHIP_NAME$ a Lieutenant flanked by two guards approaches you.','english_island_0', 'CRUSADE');
INSERT INTO choice(id, eventid, text, actionid) VALUES (101, 100, 'next', 102);
INSERT INTO actions(id) VALUES (102);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (102, 103, 0);

INSERT INTO event(id, text, backgroundname) VALUES (103, 'The Lieutenant asks "Who is in charge of this vessel?"', 'new-pirate-ship');

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
INSERT INTO event(id, text) VALUES (111, '“Very well, your ship will placed under guard until you return to pay the tax.” The Lieutenant orders the men with him to guard your ship, he turns and marches off towards the next docked ship.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (112, 111, 'next', 113);
INSERT INTO actions(id) VALUES (113);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (113, 116, 0);  

INSERT INTO event(id, text) VALUES (116, 'As you watch the Lieutenant march off your first mate approaches you and asks “So Cap’n what will ye be needin’ of us while we’re anchored?”');
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

INSERT INTO event(id, text) VALUES (125, 'You open the journal and look for any clues to where the map piece may be on Knightstone. However, you’re unable to find anything specific. Frustrated, you leave the crew with their task and head off to find the nearest tavern.
');
INSERT INTO choice(id, eventid, text, actionid) VALUES (126, 125, 'next', 127);
INSERT INTO actions(id) VALUES (127);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (127, 128, 0);  

INSERT INTO event(id, text, music) VALUES (128, 'You arrive at a local Tavern called the Golden Oak. The tavern is bustling with all sorts of people. You approach the bartender and order a drink. You overhear a group of sailors laughing and shouting in the back about some crazy old pirate trying to sell some scrap of a map to the local Dockmaster.', 'LORD_OF_THE_LAND');

-- Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (129, 128, 'Approach the group.', 130);
  INSERT INTO actions(id) VALUES (130);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (130, 140, 0);  -- jump to 140 || COMBAT PATH
--
-- Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (131, 128, 'Finish your drink and look for the Dockmaster.', 132);
  INSERT INTO actions(id) VALUES (132);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (132, 150, 0);  -- jump to 150

INSERT INTO event(id, backgroundname, text) VALUES (140,'Drunken Sailor','As you approach the table one of drunken sailors notices you and shouts “Oi! What’re you lookin at you salty old mutt!”');
  INSERT INTO choice(id, eventid, text, actionid) VALUES (141, 140, '“Tell me about this crazy old pirate you were talking about.”', 142);
  INSERT INTO actions(id) VALUES (142);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (142, 143, 0);  -- jump to 143 || COMBAT

INSERT INTO event(id, text, music) VALUES (143, '“We ain’t tellin you nothin you washed up whale!” One of them breaks a bottle and attacks you.', 'CORRUPTION');
insert into choice(id, eventid, text, actionid) values (144, 143, 'It’s a brawl!' , 145);
insert into actions(id, challengeid) values (145, 146);

insert into actionsevent (actionid, eventid, eventposition) values (145, 147, 0);

insert into actionsevent (actionid, eventid, eventposition) values (145, 148, 1);

insert into challenge(challengeid, challengename, challengetype) values (146, 'Drunken Sailor', 'combat');

INSERT INTO event(id, text, music) VALUES (148, 'The town guards burst in as you knock the drunken sailor out. They shout as they rush at you and drag you off to jail.', 'LIVING_VOYAGE');

INSERT INTO event(id, text, music) VALUES (147, 'The Sailor throws one final punch that throws you to the ground. You wake up sometime later in jail.', 'LIVING_VOYAGE');

INSERT INTO event (id, text, backgroundname, music) VALUES (150, 'You depart the tavern and head back towards the dock intent on questioning the Dockmaster.','new-pirate-ship','CRUSADE');
INSERT INTO choice(id, eventid, text, actionid) VALUES (151, 150, 'next', 152);
INSERT INTO actions(id) VALUES (152);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (152, 153, 0);

INSERT INTO event(id, text) VALUES (153, 'You survey the docks and spot the Lieutenant from earlier. You approach the Lieutenant and ask about the crazy old pirate you overheard about. The Lieutenant states that he was dragged off to jail for being unable to pay the Harbour tax. He reminds you that you still need to pay before you’ll be allowed to depart and returns to his business.');

  INSERT INTO choice(id, eventid, text, actionid) VALUES (154, 153, 'You leave the Dockmaster to his papers and head off back into town looking for the jail.', 155);
  INSERT INTO actions(id) VALUES (155);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (155, 156, 0);  
