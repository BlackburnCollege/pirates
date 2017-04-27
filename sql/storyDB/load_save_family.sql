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
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1389, 1426, 1);  -- jump to 1426 on combat win

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
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1404, 1403, 'next', 1405);
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
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1413, 1412, 'next', 1414);
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
     INSERT INTO event(id, text) VALUES (1426, 'You win the fight.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1427, 1426, 'next', 1428);
     INSERT INTO actions(id) VALUES (1428);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1428, 1429, 0);  -- jump to 1429

     INSERT INTO event(id, text) VALUES (1429, '"It''s over Conrad.  You''re not going to be hurting anyone else again.  Now where is my family?", I yell.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1430, 1429, 'next', 1431);
     INSERT INTO actions(id) VALUES (1431);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1431, 1432, 0);  -- jump to 1432

     INSERT INTO event(id, text) VALUES (1432, '"They are being held my my men.  I will return them to you just please don''t kill me.", Conrad pleads.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1433, 1432, 'next', 1434);
     INSERT INTO actions(id) VALUES (1434);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1434, 1435, 0);  -- jump to 1435

     INSERT INTO event(id, text) VALUES (1435, 'Conrad gestures at someone over in the distance and then yells, "Let them go then go back to the ship."');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1436, 1435, 'next', 1437);
     INSERT INTO actions(id) VALUES (1437);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1437, 1438, 0);  -- jump to 1438

     INSERT INTO event(id, text) VALUES (1438, 'You hear footsteps and then see $SPOUSE_NAME$ and Ben.  They run into your arms and you hug them tightly.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1439, 1438, 'next', 1440);
     INSERT INTO actions(id) VALUES (1440);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1440, 1441, 0);  -- jump to 1441

     INSERT INTO event(id, text) VALUES (1441, '"What are you going to do with me now?", Conrad asks.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1442, 1441, 'next', 1443);
     INSERT INTO actions(id) VALUES (1443);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1443, 1444, 0);  -- jump to 1444

     INSERT INTO event(id, text) VALUES (1444, '"You''re going to jail", I say.  I tie up Conrad''s hands and we return to $SHIP_NAME$.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1445, 1444, 'next', 1446);
     INSERT INTO actions(id) VALUES (1446);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1446, 1447, 0);  -- jump to 1447

     INSERT INTO event(id, text) VALUES (1447, 'We set sail for Knightstone.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1448, 1447, 'next', 1449);
     INSERT INTO actions(id) VALUES (1449);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1449, 1450, 0);  -- jump to 1450

     INSERT INTO event(id, text) VALUES (1450, 'When we arrive at Knighstone I turn Conrad over to the constable.  My family and I then return home and live happily ever after.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1451, 1450, 'next', 1452);
     INSERT INTO actions(id) VALUES (1452);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1452, 1453, 0);  -- jump to 1453

     INSERT INTO event(id, text) VALUES (1453, 'GAME OVER - You reached the good end.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1454, 1453, 'See credits screen.', 1455);
     INSERT INTO actions(id, challengeid) VALUES (1455, 1456);
     INSERT INTO challenge(challengeid, challengename, challengetype) VALUES (1456, 'credits', 'other');
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1455, 1457, 0);  -- jump to 1457
     INSERT INTO event(id, text) VALUES (1457, 'Blank event - roll credits');
----
------------------------------------------------------------------------------------------------------------------------