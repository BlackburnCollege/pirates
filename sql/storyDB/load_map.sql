/*
 * Author:  lucas.burdell
 * Created: Apr 17, 2017
 */

/*
    SQL for the map
*/
/*
INSERT INTO event(id, text, backgroundname, music) VALUES (1500, 'As the crew prepares $SHIP_NAME$ for departure, I go to my cabin to plot our next move.', 'new-pirate-ship', 'LIVING_VOYAGE');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1501, 1500, 'next', 1502);

tutorial, english, spanish, pirates, tribe, cave, final

*/
INSERT INTO actions(id, challengeid, text) VALUES (1500, 1501, 'As the crew prepares $SHIP_NAME$ for departure, I go to my cabin to plot our next move.');
INSERT INTO challenge(challengeid, challengename, challengetype) VALUES (1501, 'map', 'other');
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1500, 79, 0);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1500, 100, 1);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1500, 300, 2);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1500, 500, 3);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1500, 700, 4);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1500, 900, 5);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1500, 1100, 6);
