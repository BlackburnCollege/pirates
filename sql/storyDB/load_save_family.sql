/**
 * SAVE FAMILY STARTS AT ID 1100
 *
 * @author Drew Hans
 * @created: April 27, 2017
 */

-------------------------------------- SQL Insert Statements Below -----------------------------------------------------
--
-- Display Text with "Next" Choice only (set background and music)
INSERT INTO event(id, text, backgroundname, music) VALUES (1347, '"I see you have found the treasure."', 'conrad_template', 'MUS_CORRUPTION');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1348, 1347, 'next', 1349);
INSERT INTO actions(id) VALUES (1349);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1349, 1350, 0);  -- jump to 1350
--
------------------------------------------------------------------------------------------------------------------------

















------------------------------------------------------------------------------------------------------------------------
--
-- MAJOR CHOICE!!! Give first-mate the treasure or fight him?
   INSERT INTO event(id, text) VALUES (1310, 'I need to decide what to do.');
--
-- Choice 1 - Give first-mate the treasure
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1311, 1310, '', 1312);
   INSERT INTO actions(id, text) VALUES (1312, 'You decide to abandon your worthless family.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1312, 1313, 0);  -- jump to 1313
---- Choice 1 Results - NEUTRAL END ROUTE
     INSERT INTO event(id, text) VALUES (1313, 'You return to the ship and order most of your crew to follow you into the island.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1314, 1313, 'next', 1315);
     INSERT INTO actions(id) VALUES (1315);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1315, 1316, 0);  -- jump to 1316

     INSERT INTO event(id, text) VALUES (1316, 'After arriving at the treasure room you unlock the door and order your crew to load up the ship with the treasure.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1317, 1316, 'next', 1318);
     INSERT INTO actions(id) VALUES (1318);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1318, 1319, 0);  -- jump to 1319
     
     INSERT INTO event(id, text) VALUES (1319, 'It takes many hours but eventually your crew empties the room and stores all the treasure in the hull below the lower deck.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1320, 1319, 'next', 1321);
     INSERT INTO actions(id) VALUES (1321);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1321, 1322, 0);  -- jump to 1322

     INSERT INTO event(id, text) VALUES (1322, 'When you’re sure the ship is ready to leave you give the order to set sail for the Pirate Den.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1323, 1322, 'next', 1324);
     INSERT INTO actions(id) VALUES (1324);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1324, 1325, 0);  -- jump to 1325

     INSERT INTO event(id, text) VALUES (1325, 'Once you’re out at sea the sails catch the wind and the ship approaches top-speed.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1326, 1325, 'next', 1327);
     INSERT INTO actions(id) VALUES (1327);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1327, 1328, 0);  -- jump to 1328

     INSERT INTO event(id, text) VALUES (1328, 'As the ship sails into the sunset you notice that the upper-deck is closer to the water than normal.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1329, 1328, 'next', 1330);
     INSERT INTO actions(id) VALUES (1330);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1330, 1331, 0);  -- jump to 1331

     INSERT INTO event(id, text) VALUES (1331, 'It’s probably because of the treasure’s weight, you think to yourself.  But still, it appears to get closer and closer until finally the water spills over the deck and the ship begins to sink…');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1332, 1331, 'next', 1333);
     INSERT INTO actions(id) VALUES (1333);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1333, 1334, 0);  -- jump to 1334

     INSERT INTO event(id, text) VALUES (1334, 'GAME OVER - You reached the bad end.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1335, 1334, 'See credits screen.', 1336);
     INSERT INTO actions(id, challengeid) VALUES (1336, 1337);
     INSERT INTO challenge(challengeid, challengename, challengetype) VALUES (1337, 'credits', 'other');
----
-- Choice 2 - Fight first-mate



---- Choice 2 Result On Lose
---- Choice 2 Result On Win
----
------------------------------------------------------------------------------------------------------------------------