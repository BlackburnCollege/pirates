/**
 * SAVE FAMILY STARTS AT ID 1100
 *
 * @author Drew Hans
 * @created: April 27, 2017
 */

-------------------------------------- SQL Insert Statements Below -----------------------------------------------------
--
-- Display Text with "Next" Choice only (set background and music)
INSERT INTO event(id, text, backgroundname, music) VALUES (1347, '"I see you have found the treasure."', 'conrad_template', 'CORRUPTION');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1348, 1347, 'next', 1349);
INSERT INTO actions(id) VALUES (1349);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1349, 1350, 0);  -- jump to 1350
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1350, 'You turn and see a person.  You recognize him.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1351, 1350, 'next', 1352);
INSERT INTO actions(id) VALUES (1352);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1352, 1353, 0);  -- jump to 1353
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1353, '"Conrad. I should have known you were behind all of this.", I say.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1354, 1353, 'next', 1355);
INSERT INTO actions(id) VALUES (1355);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1355, 1356, 0);  -- jump to 1356
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1356, '"You know why I''m here.  Where''s the treasure?", he says.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1357, 1356, 'next', 1358);
INSERT INTO actions(id) VALUES (1358);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1358, 1359, 0);  -- jump to 1359
--
------------------------------------------------------------------------------------------------------------------------
--
-- MAJOR CHOICE!!! Give first-mate the treasure or fight him?
   INSERT INTO event(id, text) VALUES (1359, 'I need to decide what to do.');
--
-- Choice 1 - Give first-mate the treasure
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1360, 1359, 'Give him the treasure and beg for your family to be returned.', 1361);
   INSERT INTO actions(id, text) VALUES (1361, 'You decide to give him the treasure room passphrase and beg for my family to be returned.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1361, 1362, 0);  -- jump to 1362
---- Choice 1 Results - NEUTRAL END ROUTE
     INSERT INTO event(id, text) VALUES (1362, '"Smart choice.", he says.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1363, 1362, 'next', 1364);
     INSERT INTO actions(id) VALUES (1364);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1364, 1365, 0);  -- jump to 1365

     INSERT INTO event(id, text) VALUES (1365, 'After giving him the information he turns and waves at someone in the distance.  You look in that direction and see a group of pirates coming your way.  Behind them you see $SPOUSE_NAME$ and Ben!');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1366, 1365, 'next', 1367);
     INSERT INTO actions(id) VALUES (1367);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1367, 1368, 0);  -- jump to 1368
     
     INSERT INTO event(id, text) VALUES (1368, '"Don''t worry, they are safe.  I''m a man of my word.", he says.  After the group of pirates arrive they release your family and they run into your arms.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1369, 1368, 'next', 1370);
     INSERT INTO actions(id) VALUES (1370);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1370, 1371, 0);  -- jump to 1368
     
     INSERT INTO event(id, text) VALUES (1371, '"Now leave before I change my mind.", Conrad says.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1372, 1371, 'next', 1373);
     INSERT INTO actions(id) VALUES (1373);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1373, 1374, 0);  -- jump to 1374
     
     INSERT INTO event(id, text) VALUES (1374, 'It is too dangerous to fight with your family present.  You decide to return to $SHIP_NAME$ and sail home.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1375, 1374, 'next', 1376);
     INSERT INTO actions(id) VALUES (1376);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1376, 1377, 0);  -- jump to 1377

     INSERT INTO event(id, text) VALUES (1377, 'GAME OVER - You reached the normal end.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1378, 1377, 'See credits screen.', 1379);
     INSERT INTO actions(id, challengeid) VALUES (1379, 1380);
     INSERT INTO challenge(challengeid, challengename, challengetype) VALUES (1380, 'credits', 'other');
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1379, 1381, 0);  -- jump to 1381
     INSERT INTO event(id, text) VALUES (1381, 'Blank event - roll credits');
----
-- Choice 2 - Fight first-mate
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1382, 1359, 'Refuse to give him the treasure and fight him for your family.', 1383);
   INSERT INTO actions(id, text) VALUES (1383, 'I refuse to give him the treasure and decide to take back my family by force!');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1383, 1384, 0);  -- jump to 1384

     INSERT INTO event(id, text) VALUES (1384, '"I can''t trust you Conrad and I won''t let you hurt anymore people."');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1385, 1384, 'next', 1386);
     INSERT INTO actions(id) VALUES (1386);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1386, 1387, 0);  -- jump to 1387
     
     INSERT INTO event(id, text) VALUES (1387, '"Then you will meet an early death!", Conrad yells.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1388, 1387, 'Begin combat challenge', 1389);
     INSERT INTO actions(id, challengeid) VALUES (1389, 1390);
     INSERT INTO challenge(challengeid, challengename, challengetype) VALUES (1390, 'Drunken Sailor', 'combat');
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1389, 1391, 0);  -- jump to 1391 on combat lose
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1389, 1XXX, 1);  -- jump to 1XXX on combat win

---- Choice 2 Result On Lose
     INSERT INTO event(id, text) VALUES (1391, 'You lose the fight.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1392, 1391, 'next', 1393);
     INSERT INTO actions(id) VALUES (1393);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1393, 1394, 0);  -- jump to 1394

     INSERT INTO event(id, text) VALUES (1394, '"Did you really think you could beat me in combat?", Conrad smirks.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1395, 1394, 'next', 1396);
     INSERT INTO actions(id) VALUES (1396);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1396, 1397, 0);  -- jump to 1397

     INSERT INTO event(id, text) VALUES (1397, 'After gloating he turns and waves at someone in the distance.  You look in that direction and see a group of pirates coming your way.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1398, 1397, 'next', 1399);
     INSERT INTO actions(id) VALUES (1399);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1399, 1400, 0);  -- jump to 1400

     INSERT INTO event(id, text) VALUES (1400, 'The gang of pirates beat the treasure room passphrase out of me and then tie me up.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1401, 1400, 'next', 1402);
     INSERT INTO actions(id) VALUES (1402);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1402, 1403, 0);  -- jump to 1403

     INSERT INTO event(id, text) VALUES (1403, 'After plundering the treasure room they drag me back to their ship and tie me to the ship''s figurehead.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1404, 1404, 'next', 1405);
     INSERT INTO actions(id) VALUES (1405);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1405, 1406, 0);  -- jump to 1406

     INSERT INTO event(id, text) VALUES (1406, 'The ship sails for half a day before coming to a stop.  A small island can be seen starboard.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1407, 1406, 'next', 1408);
     INSERT INTO actions(id) VALUES (1408);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1408, 1409, 0);  -- jump to 1409

     INSERT INTO event(id, text) VALUES (1409, 'Conrad cuts the rope that binds me and I fall into the water.  When I swim to the surface I hear him yell, "Enjoy spending the rest of your life starving on that God-forsaken rock you traitor."');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1410, 1409, 'next', 1411);
     INSERT INTO actions(id) VALUES (1411);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1411, 1412, 0);  -- jump to 1412

     INSERT INTO event(id, text) VALUES (1412, 'The ship starts sailing away and I swim after it but quickly realize that I cannot keep up.  I turn towards the island and swim to shore.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1413, 1402, 'next', 1414);
     INSERT INTO actions(id) VALUES (1414);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1414, 1415, 0);  -- jump to 1415

     INSERT INTO event(id, text) VALUES (1415, 'The island has no food or fresh water.  There doesn''t appear to be another island as far as the eyes can see.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1416, 1415, 'next', 1417);
     INSERT INTO actions(id) VALUES (1417);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1417, 1418, 0);  -- jump to 1418

     INSERT INTO event(id, text) VALUES (1418, 'As I await certain death I wonder if my family is still alive.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1419, 1418, 'next', 1420);
     INSERT INTO actions(id) VALUES (1420);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1420, 1421, 0);  -- jump to 1421

     INSERT INTO event(id, text) VALUES (1421, 'GAME OVER - You reached the bad end.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1422, 1421, 'See credits screen.', 1423);
     INSERT INTO actions(id, challengeid) VALUES (1423, 1424);
     INSERT INTO challenge(challengeid, challengename, challengetype) VALUES (1424, 'credits', 'other');
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1423, 1425, 0);  -- jump to 1425
     INSERT INTO event(id, text) VALUES (1425, 'Blank event - roll credits');

---- Choice 2 Result On Win


----
------------------------------------------------------------------------------------------------------------------------