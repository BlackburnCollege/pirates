/*
 ENGLISH STORY STARTS AT 100
*/

INSERT INTO event (id, text, backgroundname, music) VALUES (100, 'After a few days at sea you can finally see Knightstone in the distance. 
You sail past warships bearing an english crest as they eye your ship. As you sail into the port of the island you can see it’s full of merchants, 
fisherman, and soldiers. As you dock $SHIP_NAME$ a Lieutenant flanked by two guards approaches you.','english_island_0', 'CRUSADE');
INSERT INTO choice(id, eventid, text, actionid) VALUES (101, 100, 'next', 102);
INSERT INTO actions(id) VALUES (102);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (102, 103, 0);

INSERT INTO event(id, text, backgroundname) VALUES (103, 'The Lieutenant asks "Who is in charge of this vessel?"', 'pirate_ship');

  INSERT INTO choice(id, eventid, text, actionid) VALUES (104, 103, 'That would be me.', 105);
  INSERT INTO actions(id) VALUES (105);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (105, 106, 0);  


INSERT INTO event(id, text) VALUES (106, '“Ah, Welcome to Knightstone. It’s my job to inform all inbound ships of the docking tax.
 You will pay 10 gold shillings for each day you are docked here.”');
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

INSERT INTO event(id, text) VALUES (128, 'You arrive at a local Tavern called the Golden Oak. The tavern is bustling with all sorts of people. You approach the bartender and order a drink. You overhear a group of sailors laughing and shouting in the back about some crazy old pirate trying to sell some scrap of a map to the local Dockmaster.');

-- Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (129, 128, 'Approach the group.', 130);
  INSERT INTO actions(id) VALUES (130);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (130, 140, 0);  -- jump to 140
--
-- Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (131, 128, 'Finish your drink and look for the Dockmaster.', 132);
  INSERT INTO actions(id) VALUES (132);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (132, 150, 0);  -- jump to 150