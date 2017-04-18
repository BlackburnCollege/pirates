/**
 * FINAL ISLAND STARTS AT ID 1100
 *
 * @author Drew Hans
 * @created: April 14, 2017
 */

------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (set background and music)
-- INSERT INTO event(id, text, backgroundname, music) VALUES (11AA, 'TEXTGOESHERE', 'cave', 'LIVING_VOYAGE');
-- INSERT INTO choice(id, eventid, text, actionid) VALUES (11BB, 11AA, 'next', 11CC);
-- INSERT INTO actions(id) VALUES (11CC);
-- INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (11CC, 11DD, 0); -- jump to event with id 11DD
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
-- INSERT INTO event(id, text) VALUES (11AA, 'TEXTGOESHERE');
-- INSERT INTO choice(id, eventid, text, actionid) VALUES (11BB, 11AA, 'next', 11CC);
-- INSERT INTO actions(id) VALUES (11CC);
-- INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (11CC, 11DD, 0);  -- jump to event with id 11DD
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with two Choices (do not change background or music)
--
-- Question Text 
-- INSERT INTO event(id, text) VALUES (11AA, 'QUESTION');
--
-- Choice 1
-- INSERT INTO choice(id, eventid, text, actionid) VALUES (11BB, 11AA, 'Choice #1', 11CC);
-- INSERT INTO actions(id, text) VALUES (11CC, 'ChoiceResult1');
-- INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (11CC, 11YY, 0);  -- jump to 11YY
--
-- Choice 2
-- INSERT INTO choice(id, eventid, text, actionid) VALUES (11DD, 11AA, 'Choice #2', 11EE);
-- INSERT INTO actions(id, text) VALUES (11EE, 'ChoiceResult2');
-- INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (11EE, 11ZZ, 0);  -- jump to 11ZZ
--
------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
-------------------------------------- SQL Insert Statements Below -----------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (set background and music)
INSERT INTO event(id, text, backgroundname, music) VALUES (1100, 'You set sail towards the final island and thinking back on your journey so far.', 'cave', 'LIVING_VOYAGE');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1101, 1100, 'next', 1102);
INSERT INTO actions(id) VALUES (1102);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1102, 1103, 0);
--
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1103, 'You have come so far and now you are closer to the treasure than ever before.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1104, 1103, 'next', 1105);
INSERT INTO actions(id) VALUES (1105);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1105, 1106, 0);
--
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1106, 'After sailing for some time you start to see land in the distance.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1107, 1106, 'next', 1108);
INSERT INTO actions(id) VALUES (1108);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1108, 1109, 0);
--
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1109, 'As your ship gets closer you begin to see green spanning the land mass.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1110, 1109, 'next', 1111);
INSERT INTO actions(id) VALUES (1111);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1111, 1112, 0);
--
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1112, 'As you get closer you start to discern the features of the land.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1113, 1112, 'next', 1114);
INSERT INTO actions(id) VALUES (1114);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1114, 1115, 0);
--
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1115, 'The land mass appears to be a large island covered in jungle trees.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1116, 1115, 'next', 1117);
INSERT INTO actions(id) VALUES (1117);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1117, 1118, 0);
--
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1118, 'Something about this island feels familiar but you can’t quite figure out why.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1119, 1118, 'next', 1120);
INSERT INTO actions(id) VALUES (1120);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1120, 1121, 0);
--
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1121, 'You check the coordinantes on the map with the current location of the ship.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1122, 1121, 'next', 1123);
INSERT INTO actions(id) VALUES (1123);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1123, 1124, 0);
--
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1124, 'The coordinantes match up.  This must be the island!');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1125, 1124, 'next', 1126);
INSERT INTO actions(id) VALUES (1126);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1126, 1127, 0);
--
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1127, 'You sail $SHIP_NAME$ to the island.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1128, 1127, 'next', 1129);
INSERT INTO actions(id) VALUES (1129);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1129, 1130, 0);
--
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with two Choices (do not change background or music)
-- Question Text 
-- INSERT INTO event(id, text) VALUES (11AA, 'QUESTION');
--
-- Choice 1
-- INSERT INTO choice(id, eventid, text, actionid) VALUES (11BB, 11AA, 'Choice #1', 11CC);
-- INSERT INTO actions(id, text) VALUES (11CC, 'ChoiceResult1');
-- INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (11CC, 11YY, 0);  -- jump to 11YY
--
-- Choice 2
-- INSERT INTO choice(id, eventid, text, actionid) VALUES (11DD, 11AA, 'Choice #2', 11EE);
-- INSERT INTO actions(id, text) VALUES (11EE, 'ChoiceResult2');
-- INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (11EE, 11ZZ, 0);  -- jump to 11ZZ
--
------------------------------------------------------------------------------------------------------------------------
