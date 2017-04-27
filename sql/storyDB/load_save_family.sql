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
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1360, 1359, 'Refuse to give him the treasure and fight him.', 1361);
   INSERT INTO actions(id, text) VALUES (1361, 'You decide to give him the treasure room passphrase and beg for my family to be returned.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1361, 1362, 0);  -- jump to 1362


---- Choice 2 Result On Lose
---- Choice 2 Result On Win
----
------------------------------------------------------------------------------------------------------------------------