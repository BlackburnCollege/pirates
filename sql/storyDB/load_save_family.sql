/**
 * SAVE FAMILY STARTS AT ID 1100
 *
 * @author Drew Hans
 * @created: April 27, 2017
 */

-------------------------------------- SQL Insert Statements Below -----------------------------------------------------
--
-- Display Text with "Next" Choice only (set background and music)
INSERT INTO event(id, text, backgroundname, music) VALUES (1346, '"I see you have found the treasure."', 'conrad_template', 'MUS_CORRUPTION');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1347, 1346, 'next', 1348);
INSERT INTO actions(id) VALUES (1348);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1348, 1349, 0);  -- jump to 1349
--
------------------------------------------------------------------------------------------------------------------------
