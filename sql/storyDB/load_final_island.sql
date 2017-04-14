/**
 * FINAL ISLAND STARTS AT ID 1100
 *
 * @author Drew Hans
 * @created: April 14, 2017
 */

# INSERT INTO aceobject(id, acetype) VALUES (1, 'event');
# INSERT INTO event(id, text, backgroundname, music) VALUES (1100, 'TEXTGOESHERE', 'cave', 'LIVING_VOYAGE');
# INSERT INTO choice(id, eventid, text, actionid) VALUES (1101, 1100, 'next', 1102);
# INSERT INTO actions(id) VALUES (1102);
# INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1102, 1103, 0);
#
# INSERT INTO event(id, text, backgroundname) values(1103,'TEXTGOESHERE', '');
# INSERT INTO choice(id, eventid, text, actionid) values (1104, 1103, 'TEXTGOESHERE', 6);
# INSERT INTO actions(id) values (1105);
# INSERT INTO actionsevent (actionid, eventid, eventposition) values (1105, 1106, 0);
