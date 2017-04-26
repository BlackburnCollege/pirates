/**
 * FINAL ISLAND STARTS AT ID 1100
 *
 * @author Drew Hans
 * @created: April 14, 2017
 */

-------------------------------------- SQL Insert Statements Below -----------------------------------------------------
--
-- Display Text with "Next" Choice only (set background and music)
INSERT INTO event(id, text, backgroundname, music) VALUES (1100, 'You set sail towards the final island and thinking back on your journey so far.', 'cave', 'LIVING_VOYAGE');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1101, 1100, 'next', 1102);
INSERT INTO actions(id) VALUES (1102);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1102, 1103, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1103, 'You have come so far and now you are closer to the treasure than ever before.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1104, 1103, 'next', 1105);
INSERT INTO actions(id) VALUES (1105);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1105, 1106, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1106, 'After sailing for some time you start to see land in the distance.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1107, 1106, 'next', 1108);
INSERT INTO actions(id) VALUES (1108);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1108, 1109, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1109, 'As your ship gets closer you begin to see green spanning the land mass.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1110, 1109, 'next', 1111);
INSERT INTO actions(id) VALUES (1111);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1111, 1112, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1112, 'As you get closer you start to discern the features of the land.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1113, 1112, 'next', 1114);
INSERT INTO actions(id) VALUES (1114);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1114, 1115, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1115, 'The land mass appears to be a large island covered in jungle trees.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1116, 1115, 'next', 1117);
INSERT INTO actions(id) VALUES (1117);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1117, 1118, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1118, 'Something about this island feels familiar but you can’t quite figure out why.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1119, 1118, 'next', 1120);
INSERT INTO actions(id) VALUES (1120);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1120, 1121, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1121, 'You check the coordinantes on the map with the current location of the ship.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1122, 1121, 'next', 1123);
INSERT INTO actions(id) VALUES (1123);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1123, 1124, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1124, 'The coordinantes match up.  This must be the island!');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1125, 1124, 'next', 1126);
INSERT INTO actions(id) VALUES (1126);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1126, 1127, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1127, 'You sail $SHIP_NAME$ to the island.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1128, 1127, 'next', 1129);
INSERT INTO actions(id) VALUES (1129);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1129, 1130, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with two Choices that both lead to same event (do not change background or music)
-- Question Text 
INSERT INTO event(id, text) VALUES (1130, 'Once you arrive you step onto the beach and look around.  You see what appears to be a path into the jungle.');
--
-- Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (1131, 1130, 'Look around some more.', 1132);
  INSERT INTO actions(id, text) VALUES (1132, 'You look around some more but there appears to be nothing significant on the beach.  You decide to follow the path to see where it leads.');
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1132, 1135, 0);  -- jump to 1135
--
-- Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (1133, 1130, 'Follow the path.', 1134);
  INSERT INTO actions(id, text) VALUES (1134, 'You decide to follow the path to see where it leads.');
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1134, 1135, 0);  -- jump to 1135
--
------------------------------------------------------------------------------------------------------------------------
--
-- Jungle Maze - 1st Fork In The Path
INSERT INTO event(id, text) VALUES (1135, 'After a few minutes you come across a fork in the path.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1136, 1135, 'next', 1137);
INSERT INTO actions(id) VALUES (1137);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1137, 1138, 0);  -- jump to 1138
--
-- The Sign Between The Fork
INSERT INTO event(id, text) VALUES (1138, 
'Between the fork is a sign.
+---------+
| <- M    |
|         |
|    Z -> |
+---------+');
--
-- Choice 1
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1139, 1138, 'Go right (down the path labeled Z)', 1140);
   INSERT INTO actions(id, text) VALUES (1140, 'You follow the path labeled Z.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1140, 1141, 0);  -- jump to 1141
--
---- Choice 1 Results (Dead End Path)
     INSERT INTO event(id, text) VALUES (1141, 'After following the path for some time you end up at a beach different from the one you started at.  You look around but nothing is here.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1142, 1141, 'next', 1143);
     INSERT INTO actions(id) VALUES (1143);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1143, 1144, 0);  -- jump to 1144

     INSERT INTO event(id, text) VALUES (1144, 'You can see $SHIP_NAME$ off in the distance.  You decide to go back to the previous fork in the path.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1145, 1144, 'next', 1146);
     INSERT INTO actions(id) VALUES (1146);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1146, 1149, 0);  -- jump to 1149
----
-- Choice 2
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1147, 1138, 'Go left (down the path labeled M)', 1148);
   INSERT INTO actions(id, text) VALUES (1148, 'You follow the path labeled M.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1148, 1149, 0);  -- jump to 1149
--
------------------------------------------------------------------------------------------------------------------------
--
-- Jungle Maze - 2nd Fork In The Path
INSERT INTO event(id, text) VALUES (1149, 'After following the M path for some time you reach another fork in the path.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1150, 1149, 'next', 1151);
INSERT INTO actions(id) VALUES (1151);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1151, 1152, 0);  -- jump to 1152
--
-- The Sign Between The Fork
INSERT INTO event(id, text) VALUES (1152, 
'Between the fork is a sign. 
+---------+
| <- Y    |
|         |
|    A -> |
+---------+');
--
-- Choice 1
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1153, 1152, 'Go left (down the path labeled Y)', 1154);
   INSERT INTO actions(id, text) VALUES (1154, 'You follow the path labeled Y.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1154, 1155, 0);  -- jump to 1155
--
---- Choice 1 Results (Dead End Path)
     INSERT INTO event(id, text) VALUES (1155, 'After following the path for some time you end up at a beach different from the one you started at.  You look around but nothing is here.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1156, 1155, 'next', 1157);
     INSERT INTO actions(id) VALUES (1157);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1157, 1158, 0);  -- jump to 1158

     INSERT INTO event(id, text) VALUES (1158, 'You can see $SHIP_NAME$ off in the distance.  You decide to go back to the previous fork in the path.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1159, 1158, 'next', 1160);
     INSERT INTO actions(id) VALUES (1160);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1160, 1163, 0);  -- jump to 1163
----
-- Choice 2
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1161, 1152, 'Go right (down the path labeled A)', 1162);
   INSERT INTO actions(id, text) VALUES (1162, 'You follow the path labeled A.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1162, 1163, 0);  -- jump to 1163
--
------------------------------------------------------------------------------------------------------------------------
--
-- Jungle Maze - 3th Fork In The Path
INSERT INTO event(id, text) VALUES (1163, 'After following the A path for some time you reach another fork in the path.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1164, 1163, 'next', 1165);
INSERT INTO actions(id) VALUES (1165);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1165, 1166, 0);  -- jump to 1166
--
-- The Sign Between The Fork
INSERT INTO event(id, text) VALUES (1166, 
'Between the fork is a sign. 
+---------+
| <- R    |
|         |
|    X -> |
+---------+');
--
-- Choice 1
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1167, 1166, 'Go right (down the path labeled X)', 1168);
   INSERT INTO actions(id, text) VALUES (1168, 'You follow the path labeled X.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1168, 1169, 0);  -- jump to 1169
--
---- Choice 1 Results (Dead End Path)
     INSERT INTO event(id, text) VALUES (1169, 'After following the path for some time you end up at a beach different from the one you started at.  You look around but nothing is here.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1170, 1169, 'next', 1171);
     INSERT INTO actions(id) VALUES (1171);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1171, 1172, 0);  -- jump to 1172

     INSERT INTO event(id, text) VALUES (1172, 'You can see $SHIP_NAME$ off in the distance.  You decide to go back to the previous fork in the path.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1173, 1172, 'next', 1174);
     INSERT INTO actions(id) VALUES (1174);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1174, 1177, 0);  -- jump to 1177
----
-- Choice 2
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1175, 1166, 'Go left (down the path labeled R)', 1176);
   INSERT INTO actions(id, text) VALUES (1176, 'You follow the path labeled R.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1176, 1177, 0);  -- jump to 1177
--
------------------------------------------------------------------------------------------------------------------------
--
-- Jungle Maze - 4th Fork In The Path
INSERT INTO event(id, text) VALUES (1177, 'After following the R path for some time you reach another fork in the path.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1178, 1177, 'next', 1179);
INSERT INTO actions(id) VALUES (1179);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1179, 1180, 0);  -- jump to 1180
--
-- The Sign Between The Fork
INSERT INTO event(id, text) VALUES (1180, 
'Between the fork is a sign. 
+---------+
| <- G    |
|         |
|    W -> |
+---------+');
--
-- Choice 1
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1181, 1180, 'Go right (down the path labeled W)', 1182);
   INSERT INTO actions(id, text) VALUES (1182, 'You follow the path labeled W.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1182, 1183, 0);  -- jump to 1183
--
---- Choice 1 Results (Dead End Path)
     INSERT INTO event(id, text) VALUES (1183, 'After following the path for some time you end up at a beach different from the one you started at.  You look around but nothing is here.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1184, 1183, 'next', 1185);
     INSERT INTO actions(id) VALUES (1185);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1185, 1186, 0);  -- jump to 1186

     INSERT INTO event(id, text) VALUES (1186, 'You can see $SHIP_NAME$ off in the distance.  You decide to go back to the previous fork in the path.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1187, 1186, 'next', 1188);
     INSERT INTO actions(id) VALUES (1188);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1188, 1191, 0);  -- jump to 1191
----
-- Choice 2
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1189, 1180, 'Go left (down the path labeled G)', 1190);
   INSERT INTO actions(id, text) VALUES (1190, 'You follow the path labeled G.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1190, 1191, 0);  -- jump to 1191
--
------------------------------------------------------------------------------------------------------------------------
--
-- Jungle Maze - 5th Fork In The Path
INSERT INTO event(id, text) VALUES (1191, 'After following the G path for some time you reach another fork in the path.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1192, 1191, 'next', 1193);
INSERT INTO actions(id) VALUES (1193);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1193, 1194, 0);  -- jump to 1194
--
-- The Sign Between The Fork
INSERT INTO event(id, text) VALUES (1194, 
'Between the fork is a sign. 
+---------+
| <- V    |
|         |
|    E -> |
+---------+');
--
-- Choice 1
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1195, 1194, 'Go left (down the path labeled V)', 1196);
   INSERT INTO actions(id, text) VALUES (1196, 'You follow the path labeled V.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1196, 1197, 0);  -- jump to 1197
--
---- Choice 1 Results (Dead End Path)
     INSERT INTO event(id, text) VALUES (1197, 'After following the path for some time you end up at a beach different from the one you started at.  You look around but nothing is here.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1198, 1197, 'next', 1199);
     INSERT INTO actions(id) VALUES (1199);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1199, 1200, 0);  -- jump to 1200

     INSERT INTO event(id, text) VALUES (1200, 'You can see $SHIP_NAME$ off in the distance.  You decide to go back to the previous fork in the path.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1201, 1200, 'next', 1202);
     INSERT INTO actions(id) VALUES (1202);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1202, 1205, 0);  -- jump to 1205
----
-- Choice 2
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1203, 1194, 'Go right (down the path labeled E)', 1204);
   INSERT INTO actions(id, text) VALUES (1204, 'You follow the path labeled E.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1204, 1205, 0);  -- jump to 1205
--
------------------------------------------------------------------------------------------------------------------------
--
-- Jungle Maze - 6th Fork In The Path
INSERT INTO event(id, text) VALUES (1205, 'After following the E path for some time you reach another fork in the path.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1206, 1205, 'next', 1207);
INSERT INTO actions(id) VALUES (1207);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1207, 1208, 0);  -- jump to 1208
--
-- The Sign Between The Fork
INSERT INTO event(id, text) VALUES (1208, 
'Between the fork is a sign. 
+---------+
| <- R    |
|         |
|    U -> |
+---------+');
--
-- Choice 1
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1209, 1208, 'Go right (down the path labeled U)', 1210);
   INSERT INTO actions(id, text) VALUES (1210, 'You follow the path labeled U.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1210, 1211, 0);  -- jump to 1211
--
---- Choice 1 Results (Dead End Path)
     INSERT INTO event(id, text) VALUES (1211, 'After following the path for some time you end up at a beach different from the one you started at.  You look around but nothing is here.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1212, 1211, 'next', 1213);
     INSERT INTO actions(id) VALUES (1213);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1213, 1214, 0);  -- jump to 1214

     INSERT INTO event(id, text) VALUES (1214, 'You can see $SHIP_NAME$ off in the distance.  You decide to go back to the previous fork in the path.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1215, 1214, 'next', 1216);
     INSERT INTO actions(id) VALUES (1216);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1216, 1219, 0);  -- jump to 1219
----
-- Choice 2
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1217, 1208, 'Go left (down the path labeled R)', 1218);
   INSERT INTO actions(id, text) VALUES (1218, 'You follow the path labeled R.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1218, 1219, 0);  -- jump to 1219
--
------------------------------------------------------------------------------------------------------------------------
--
-- Jungle Maze - 7th Fork In The Path
INSERT INTO event(id, text) VALUES (1219, 'After following the R path for some time you reach another fork in the path.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1220, 1219, 'next', 1221);
INSERT INTO actions(id) VALUES (1221);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1221, 1222, 0);  -- jump to 1222
--
-- The Sign Between The Fork
INSERT INTO event(id, text) VALUES (1222, 
'Between the fork is a sign. 
+---------+
| <- T    |
|         |
|    Y -> |
+---------+');
--
-- Choice 1
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1223, 1222, 'Go left (down the path labeled T)', 1224);
   INSERT INTO actions(id, text) VALUES (1224, 'You follow the path labeled T.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1224, 1225, 0);  -- jump to 1225
--
---- Choice 1 Results (Dead End Path)
     INSERT INTO event(id, text) VALUES (1225, 'After following the path for some time you end up at a beach different from the one you started at.  You look around but nothing is here.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1226, 1225, 'next', 1227);
     INSERT INTO actions(id) VALUES (1227);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1227, 1228, 0);  -- jump to 1228

     INSERT INTO event(id, text) VALUES (1228, 'You can see $SHIP_NAME$ off in the distance.  You decide to go back to the previous fork in the path.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1229, 1228, 'next', 1230);
     INSERT INTO actions(id) VALUES (1230);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1230, 1233, 0);  -- jump to 1233
----
-- Choice 2
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1231, 1222, 'Go right (down the path labeled Y)', 1232);
   INSERT INTO actions(id, text) VALUES (1232, 'You follow the path labeled Y.');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1232, 1233, 0);  -- jump to 1233
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with two Choices that both lead to same event (do not change background or music)
-- Question Text 
INSERT INTO event(id, text) VALUES (1233, 'After following the Y path for some time you reach what appears to be a cave entrance.');
--
-- Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (1234, 1233, 'Look around some more.', 1235);
  INSERT INTO actions(id, text) VALUES (1235, 'You look around some more but there appears to be nothing significant outside the cave entrance.  You decide to light a torch and enter the cave to see what’s inside.');
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1235, 1238, 0);  -- jump to 1238
--
-- Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (1236, 1233, 'Light a torch and enter the cave.', 1237);
  INSERT INTO actions(id, text) VALUES (1237, 'You decide to light a torch and enter the cave to see what’s inside.');
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1237, 1238, 0);  -- jump to 1238
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1238, 'You hear the wet gravel crunch under your feet as you walk into the cave.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1239, 1238, 'next', 1240);
INSERT INTO actions(id) VALUES (1240);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1240, 1241, 0);  -- jump to 1241
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1241, 'The torch lights up the walls and ceiling inside the darkness and you can see that there is a rock path leading deeper into the cave.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1242, 1241, 'next', 1243);
INSERT INTO actions(id) VALUES (1243);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1243, 1244, 0);  -- jump to 1244
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1244, 'As you go deeper into the cave the walls and ceiling start to narrow.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1245, 1244, 'next', 1246);
INSERT INTO actions(id) VALUES (1246);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1246, 1247, 0);  -- jump to 1247
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1247, 'After several minutes the ceiling is in arm’s reach and the walls are slightly further apart than shoulder length.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1248, 1247, 'next', 1249);
INSERT INTO actions(id) VALUES (1249);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1249, 1250, 0);  -- jump to 1250
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1250, 'When you reach the deepest depths of the cave you see a solid steel door.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1251, 1250, 'next', 1252);
INSERT INTO actions(id) VALUES (1252);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1252, 1253, 0);  -- jump to 1253
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with two Choices that both lead to same event (do not change background or music)
-- Question Text 
INSERT INTO event(id, text) VALUES (1253, 'You approach the door.');
--
-- Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (1254, 1253, 'Try to open the door.', 1255);
  INSERT INTO actions(id, text) VALUES (1255, 'You try to open the door but it doesn’t budge.  ');
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1255, 1258, 0);  -- jump to 1258
--
-- Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (1256, 1253, 'Inspect the door.', 1257);
  INSERT INTO actions(id, text) VALUES (1257, 'You decided to inspect the door.');
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1257, 1258, 0);  -- jump to 1258
--
------------------------------------------------------------------------------------------------------------------------
--
-- Final Puzzle Challenge
INSERT INTO event(id, text) VALUES (1258, 'You inspect the door and see that there are 7 rusty wheels with letters from the alphabet on them.  There doesn’t appear to be any keyholes so these wheels must have something to do with unlocking the door.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1259, 1258, 'Begin puzzle challenge.', 1260);
INSERT INTO actions(id, challengeid) VALUES (1260, 1261);
INSERT INTO challenge(challengeid, challengename, challengetype) VALUES (1261, 'final', 'puzzle');
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1260, 1262, 0);  -- jump to 1262 on puzzle fail
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1260, 1263, 1);  -- jump to 1263 on puzzle solve
--
-- On Puzzle Fail
   INSERT INTO event(id, text) VALUES (1262, 'After attempting to decode the passpharse you give up.  There has to be something you are missing.  You remember the signs on the path you took through the forest had letters on them.  Maybe they hold a clue.');
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1264, 1262, 'next', 1265);
   INSERT INTO actions(id) VALUES (1265);
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1265, 1258, 0);  -- jump back to 1258 and try puzzle again
--
-- On Puzzle Solve
   INSERT INTO event(id, text) VALUES (1263, 'The passphrase Margery unlocks the door and it starts to slide open.');
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1266, 1263, 'next', 1267);
   INSERT INTO actions(id) VALUES (1267);
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1267, 1268, 0);  -- jump to 1268
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1268, '“Margery… why is the name of my wife the passphrase?  Is it coincidence?  No, it can’t be.  Think…”');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1269, 1268, 'next', 1270);
INSERT INTO actions(id) VALUES (1270);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1270, 1271, 0);  -- jump to 1271
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1271, 'As the door slides open the light from the torch illuminates the room.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1272, 1271, 'next', 1273);
INSERT INTO actions(id) VALUES (1273);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1273, 1274, 0);  -- jump to 1274
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1274, 'Suddenly your memories of the past come rushing back.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1275, 1274, 'next', 1276);
INSERT INTO actions(id) VALUES (1276);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1276, 1277, 0);  -- jump to 1277
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1277, '“The treasure… I remember now… “');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1278, 1277, 'next', 1279);
INSERT INTO actions(id) VALUES (1279);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1279, 1280, 0);  -- jump to 1280
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1280, 'You recall your life before the <accident>... your life as <Legendary Pirate name here>.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1281, 1280, 'next', 1282);
INSERT INTO actions(id) VALUES (1282);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1282, 1283, 0);  -- jump to 1283
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1283, 'You remember the ship battles, the treasure hunts, the rum, your crew, and your first-mate.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1284, 1283, 'next', 1285);
INSERT INTO actions(id) VALUES (1285);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1285, 1286, 0);  -- jump to 1286
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1286, 'You remember your origin starting out with a small crew on a small ship and the trill of stealing your first big treasure... the trill of getting away with it.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1287, 1286, 'next', 1288);
INSERT INTO actions(id) VALUES (1288);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1288, 1289, 0);  -- jump to 1289
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1289, 'You remember becoming notorious <Legendary Pirate name here>.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1290, 1289, 'next', 1291);
INSERT INTO actions(id) VALUES (1291);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1291, 1292, 0);  -- jump to 1292
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1292, 'You remember meeting your love, Margery…');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1293, 1292, 'next', 1294);
INSERT INTO actions(id) VALUES (1294);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1294, 1295, 0);  -- jump to 1295
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1295, 'You remember hiding the treasure on this obscure island.  You remember tearing up the map.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1296, 1295, 'next', 1297);
INSERT INTO actions(id) VALUES (1297);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1297, 1298, 0);  -- jump to 1298
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1298, 'You remember telling Conrad you were leaving.  You remember the arguing, the fighting, and waking up in the hospital with no memory of yourself afterward.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1299, 1298, 'next', 1300);
INSERT INTO actions(id) VALUES (1300);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1300, 1301, 0);  -- jump to 1301
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1301, 'You look past the unlocked door and see a room filled with gold treasure.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1302, 1301, 'next', 1303);
INSERT INTO actions(id) VALUES (1303);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1303, 1304, 0);  -- jump to 1304
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1304, 'There is so much gold that a person could live two life-times over and not spend it all.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1305, 1304, 'next', 1306);
INSERT INTO actions(id) VALUES (1306);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1306, 1307, 0);  -- jump to 1307
--
------------------------------------------------------------------------------------------------------------------------
--
-- Display Text with "Next" Choice only (do not change background and music)
INSERT INTO event(id, text) VALUES (1307, 'You remember hiding the treasure here for safe-keeping because there was no other place large enough to hold it.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (1308, 1307, 'next', 1309);
INSERT INTO actions(id) VALUES (1309);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1309, 1310, 0);  -- jump to 1310
--
------------------------------------------------------------------------------------------------------------------------
--
-- MAJOR CHOICE!!! Save your family or abandon them!
   INSERT INTO event(id, text) VALUES (1310 '"What am I suppose to do now?" you wonder.');
--
-- Choice 1 - Abandon your family.
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1311, 1310, 'Abandon your family.  You can buy a better one with this much gold.', 1312);
   INSERT INTO actions(id, text) VALUES (1312, '...');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1312, 1313, 0);  -- jump to 1313
---- Choice 1 Results - BAD END ROUTE
     INSERT INTO event(id, text) VALUES (1313, 'You decide to abandon your worthless family.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1314, 1313, 'next', 1315);
     INSERT INTO actions(id) VALUES (1315);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1315, 1316, 0);  -- jump to 1316

     INSERT INTO event(id, text) VALUES (1316, 'You return to the ship and order most of your crew to follow you into the island.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1317, 1316, 'next', 1318);
     INSERT INTO actions(id) VALUES (1318);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1318, 1319, 0);  -- jump to 1319
     
     INSERT INTO event(id, text) VALUES (1319, 'After arriving at the treasure room you unlock the door and order your crew to load up the ship with the treasure.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1320, 1319, 'next', 1321);
     INSERT INTO actions(id) VALUES (1321);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1321, 1322, 0);  -- jump to 1322

     INSERT INTO event(id, text) VALUES (1322, 'It takes many hours but eventually your crew empties the room and stores all the treasure in the hull below the lower deck.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1323, 1322, 'next', 1324);
     INSERT INTO actions(id) VALUES (1324);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1324, 1325, 0);  -- jump to 1325

     INSERT INTO event(id, text) VALUES (1325, 'When you’re sure the ship is ready to leave you give the order to set sail for the Pirate Den.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1326, 1325, 'next', 1327);
     INSERT INTO actions(id) VALUES (1327);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1327, 1328, 0);  -- jump to 1328

     INSERT INTO event(id, text) VALUES (1328, 'Once you’re out at sea the sails catch the wind and the ship approaches top-speed.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1329, 1328, 'next', 1330);
     INSERT INTO actions(id) VALUES (1330);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1330, 1331, 0);  -- jump to 1331

     INSERT INTO event(id, text) VALUES (1331, 'As the ship sails into the sunset you notice that the upper-deck is closer to the water than normal.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1332, 1331, 'next', 1333);
     INSERT INTO actions(id) VALUES (1333);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1333, 1334, 0);  -- jump to 1334

     INSERT INTO event(id, text) VALUES (1334, 'It’s probably because of the treasure’s weight, you think to yourself.  But still, it appears to get closer and closer until finally the water spills over the deck and the ship begins to sink…');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1335, 1334, 'next', 1336);
     INSERT INTO actions(id) VALUES (1336);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1336, 1337, 0);  -- jump to 1337

     INSERT INTO event(id, text) VALUES (1337, 'GAME OVER - You reached the bad end.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1338, 1337, 'next', 1339);
     INSERT INTO actions(id) VALUES (1339);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1339, 1340, 0);  -- jump to 1340
----
-- Choice 2 - Save your family.
   INSERT INTO choice(id, eventid, text, actionid) VALUES (1341, 1310, 'Save your family.  No amount of gold is worth their lives.', 1342);
   INSERT INTO actions(id, text) VALUES (1342, '...');
   INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1342, 1343, 0);  -- jump to 1343
---- Choice 2 Results - Lead to first-mate confrontation.
     INSERT INTO event(id, text) VALUES (1343, 'You decide to save your family.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1344, 1343, 'next', 1345);
     INSERT INTO actions(id) VALUES (1345);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1345, 1346, 0);  -- jump to 1346

     INSERT INTO event(id, text) VALUES (1346, 'You take a piece of gold from the room as proof that you found the treasure, shut and scramble the lock, and then prepare to return to your docked ship.');
     INSERT INTO choice(id, eventid, text, actionid) VALUES (1347, 1346, 'next', 1348);
     INSERT INTO actions(id) VALUES (1348);
     INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (1348, 1349, 0);  -- jump to 1349
----
------------------------------------------------------------------------------------------------------------------------
-- Note:  1337 should lead to GAME OVER screen and then the game should end
-- Note:  1349 shoudl lead to the final confrontation scene
