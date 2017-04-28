/* 
TRIBAL ISLAND STARTS AT ID 700
*
* @author Jessica Cramer
* @created: April 24, 2017 
*/

-- 
INSERT INTO event(id, text, music) VALUES (700, 'I arrive at the island of the Kalinago Tribe.', 'CHEE_ZEE_JUNGLE');

-- Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (723, 700, 'next', 725);
--
-- Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (724, 700, 'I have no need to be here, set sail!', 1500);

INSERT INTO conditional(id, attachedid, flag, flagstate) VALUES (726, 723, 'mappiece3found', 0);
INSERT INTO conditional(id, attachedid, flag, flagstate) VALUES (728, 724, 'mappiece3found', 1);

  INSERT INTO actions(id) VALUES (727);
  INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (727, 820, 1);
  INSERT INTO actions(id) VALUES (725);
  INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (725, 701, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (701, 'Robert Knight said that the Kalinago people, who live on this island, were most likely to have the map. 
I should be careful though, because they are known to be unkind to outsiders.');
--
-- Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (799, 701, 'Sneak into the village', 750);
  INSERT INTO actions(id, text) VALUES (750, 'I decide to sneak into the village through the woods');
  INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (750, 702, 0);
--
-- Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (798, 701, 'Ask the Kalinago for the map piece', 751); 
  INSERT INTO actions(id, text) VALUES (751, 'I decide that the best way to get the map is to talk to the leader of the tribe.');
  INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (751, 709, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
  INSERT INTO event(id,text) VALUES (702, 'As I approach the village quietly, I see the villagers dancing and celebrating in the center of the village. 
  the left side of the village appears to be a temple and to the right is a cluster of huts.');
--
-- Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (780, 702, 'Go Left', 752);
  INSERT INTO actions(id) VALUES (752);
  INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (752, 703, 0);
--
-- Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (807, 702, 'Go Right', 753); 
  INSERT INTO actions(id) VALUES (753);
  INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (753, 708, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (703, 'You walk towards the temple and you footsteps coming from the right.');
--
--Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (797, 703, 'Duck into a hut', 754);
  INSERT INTO actions(id) VALUES (754);
  INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (754, 704, 0);
--
--Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (796, 703, 'Hide behind the hut', 755);
  INSERT INTO actions(id) VALUES (755);
  INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (755, 705, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (704, 'I duck into the nearest hut, but the footsteps keep getting closer until a Kalingo man enters the hut. 
‘What are you doing here?!’
He drags me outside and the leader of the village is waiting for me.');
INSERT INTO choice(id,eventid, text, actionid) VALUES (795, 704, 'next', 756);
INSERT INTO actions(id) VALUES (756);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (756, 709, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (705, 'You quickly move behind the nearest hut until you hear the footsteps disappear into the hut. You go into the temple and a shrine to Mabouya, the evil spirit that the Kalinago worship, is in the center. You see that one of the items in the shrine is a map piece! 
You grab the piece and hurry out of the temple. Halfway back to the boat, you start to hear shouts and turn to see a group of Kalinago coming toward you.');
--
--Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (794, 705, 'Run!', 757);
  INSERT INTO actions(id) VALUES (757);
  INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (757, 706, 0);
--
--Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (793, 705, 'Explain yourself to the Kalinago', 758);
  INSERT INTO actions(id) VALUES (758);
  INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (758, 707, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (706, 'I start running as quickly as I can and I make it back to the ship and start sailing seconds before the Kalingo catch up. But I am already on my way with the map.');
INSERT INTO choice(id, eventid, text, actionid) VALUES (792, 706, 'next', 759);
INSERT INTO actions(id) VALUES (759);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (759, 715, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (707, 'I decide that I should stop and explain why I took the map to the Kalingo.');
INSERT INTO choice(id,eventid,text, actionid) VALUES (791, 707, 'next', 760);
INSERT INTO actions(id) VALUES (760);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (760, 709, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (708, 'I turn right and start sneaking into the village, but I immediately run into an angry villager, who takes me to the leader of the village.');
INSERT INTO choice(id,eventid,text, actionid) VALUES (790, 708, 'next', 761);
INSERT INTO actions(id) VALUES (761);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (761, 709, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (709, 'As I get close to the village, I hear a rustling in the woods. All of the sudden, I am surrounded by the Kalinago people. Their shaman speaks to me: 
"Outsiders are not welcome on our island. Why do you trespass?"
"I am looking for an important map piece."
"Mabouya will be unhappy that outsiders are here."');
--
--Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (789, 709, 'I can help Mabouya, though', 762);
  INSERT INTO actions(id) VALUES (762);
  INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (762, 710, 0);
--
--Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (788, 709, 'Demand they hand over the maps', 763);
  INSERT INTO actions(id) VALUES (763);
  INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (763, 712, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (710, 'I can help Mabouya, though!” The men look at each other and the leader of the group finally speaks: 
“There is one thing that you can do to help us. There is a flower called the Pagua that grows on the top of the mountain on this island. It is a white flower with a heavenly scent. It’s bloom is very rare, but if you can capture one, we will give you your map piece."');
--
--Choice 1
  INSERT INTO choice(id, eventid, text, actionid) VALUES (787, 710, 'Agree to find the flower', 764);
  INSERT INTO actions(id) VALUES (764);
  INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (764, 711, 0);
--
--Choice 2
  INSERT INTO choice(id, eventid, text, actionid) VALUES (786, 710, 'Refuse their trivial quest', 765);
  INSERT INTO actions(id) VALUES (765);
  INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (765, 712, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (711, 'I agree to search for the Pagua Flower and follow the villagers direction to a mountain on the island');
INSERT INTO choice(id,eventid,text,actionid) VALUES (771, 711, 'Head to the mountain to search', 772);
--INSERT INTO actions(id, challengeid) VALUES (772, 730);
INSERT INTO actions(id) VALUES (772);
insert into actionsevent (actionid, eventid, eventposition) values (772, 720, 0);
--INSERT INTO challenge(challengeid, challengename, challengetype) values (730, 'flower', 'puzzle');
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text, music) VALUES (712, 'If you aren’t going to give me the map, I’m going to have to take it!', 'CHEE_ZEE_CAVE');
INSERT INTO choice(id,eventid,text,actionid) VALUES (784, 712, '', 767);
INSERT INTO actions(id, challengeid) VALUES (767, 731);
insert into actionsevent (actionid, eventid, eventposition) values (767, 713, 1);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (767, 714, 0);
INSERT INTO challenge(challengeid, challengename, challengetype) values (731, '', 'combat');
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text, music) VALUES (713, 'I manage to fight my way to the map, grab it, and I run back to my boat. I take off, hearing the angry tribesmen yelling behind me.', 'CHEE_ZEE_JUNGLE');
INSERT INTO choice (id, eventid, text, actionid) VALUES (782, 713, 'next', 769);
INSERT INTO actions(id) VALUES (769);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (769, 715, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text, music) VALUES (714, 'After losing the fight, I manage to flee and lose them. I’m going to have to sneak through the woods to find the map piece.', 'CHEE_ZEE_JUNGLE');
INSERT INTO choice (id, eventid, text, actionid) VALUES (806, 714, 'next', 770);
INSERT INTO actions(id) VALUES (770);
INSERT INTO actionsevent(actionid, eventid, eventposition) VALUES (770, 702, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (715, 'I have the map, and I’ll be happy to never visit the Kalinago ever again.');
INSERT INTO choice (id, eventid, text, actionid) VALUES (808, 715, 'next', 804);
INSERT INTO actions (id) VALUES (804);
INSERT INTO conditional(id, attachedid, flag, flagstate) VALUES (721, 804, 'mappiece3found', 1);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (804, 800, 0);
--
------------------------------------------------------------------------------------------------------------------------
--
INSERT INTO event(id, text) VALUES (716, 'This is infamously the island of the unfriendly Kalinago tribe. The journal doesn’t mention anything about a map piece here. I don’t want to waste time.');
INSERT INTO choice (id, eventid, text, actionid) VALUES (781, 716, 'Go back to the map', 1500);
--
------------------------------------------------------------------------------------------------------------------------
-- 
INSERT INTO event(id, text) VALUES (720, 'I find the flower and bring it to the Kalinago. They give me the map piece and I head back to my ship as quickly as I can. I have the map, and I will be happy to never visit the Kalinago ever again.');
INSERT INTO choice (id, eventid, text, actionid) VALUES (805, 720, 'next', 801);
INSERT INTO actions (id) VALUES (801);
INSERT INTO conditional(id, attachedid, flag, flagstate) VALUES (802, 801, 'mappiece3found', 1);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (801, 800, 0);
--
------------------------------------------------------------------------------------------------------------------------
-- 
INSERT INTO event (id, text) VALUES (800, 'Map piece in hand I set sail for the next island');
INSERT INTO choice (id, eventid, text, actionid) VALUES (803, 800, 'Set sail!', 1500);
--
------------------------------------------------------------------------------------------------------------------------
-- 