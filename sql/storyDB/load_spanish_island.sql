/*
 SPANISH STORY STARTS AT ID 300
*/
-----------------------------------------Arrival-------------------------------------
INSERT INTO event (id, text, backgroundname, music) VALUES (300, 'I set sail towards the Spain controlled island, El Puerto Espadaña.', 'spanish_island_0', 'LORD_OF_THE_LAND');
--
--Choice-1-1
INSERT INTO choice (id, eventid, text, actionid) VALUES (301, 300, 'next', 302);
INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (414, 301, 'mappiece2found', 0);
INSERT INTO actions (id) VALUES (302);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (302, 304, 0);
--
--Choice-1-2
INSERT INTO choice (id, eventid, text, actionid) VALUES (415, 300, 'Perhaps I should go back, I don`t think things have died down here just yet...', 1500);
INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (417, 415, 'mappiece2found', 1);
-------------------------------------------------------------------------------------
INSERT INTO event (id, text) VALUES (304, 'Guard: "¡Indica su nombre y asunto!"');
INSERT INTO choice (id, eventid, text, actionid) VALUES (305, 304, 'I`m sorry? I`m just here to visit the port.', 306);
INSERT INTO actions (id) VALUES (306);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (306, 308, 0);
-------------------------------------------------------------------------------------
INSERT INTO event (id, text) VALUES (308, 'Guard: "Do you have documentation?"
$PLAYER_NAME$: *It sure is convenient that they know English*');

--Choice-1
INSERT INTO choice (id, eventid, text, actionid) VALUES (309, 308, 'Show licenses and documentention', 310);
INSERT INTO actions (id, text) VALUES (310, 'Licenses? I`m a pirate! I don`t need a license. I`ll have to negotiate my way out');
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (310, 313, 0);

--Choice-2
INSERT INTO choice (id, eventid, text, actionid) VALUES (311, 308, 'Negotiate', 312);
INSERT INTO actions (id) VALUES (312);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (312, 313, 0);

-------------------------------------------------------------------------------------
INSERT INTO event (id, text) VALUES (313, 'I`m going to have to negotiate my way through this, I better be careful what I say...');
--
--Choice-1
INSERT INTO choice (id, eventid, text, actionid) VALUES (314, 313, 'Come on, can`t you just let us through?', 315);
INSERT INTO actions (id, text) VALUES (315, 'Guard: "Absolutely not, Leave."');
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (315, 313, 0);
--
--Choice-2
INSERT INTO choice (id, eventid, text, actionid) VALUES (316, 313, 'We just need to get supplies to be on our way.', 317);
INSERT INTO actions (id, text) VALUES (317, 'Guard: "Fine, continue on. But keep to yourself and make it fast. If you do anything to interrupt Governor Gutierrez`s party you`ll be sent to jail without hesitation."
$PLAYER_NAME$: *I liked it better when I didn`t understand them*');
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (317, 318, 0);
--------------------------------------Plaza------------------------------------------
INSERT INTO event (id, text) VALUES (318, 'This is the plaza of El Puerto Espadaña');
--
--Choice-1
INSERT INTO choice (id, eventid, text, actionid) VALUES (319, 318, 'Visit Bell Tower Rock', 320);
INSERT INTO actions (id) VALUES (320);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (320, 325, 0);
--
--Choice-2-1
INSERT INTO choice (id, eventid, text, actionid) VALUES (321, 318, 'Visit alleyway', 322);
INSERT INTO actions (id) VALUES (322);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (322, 328, 0);
--
--Choice-2-2
INSERT INTO choice (id, eventid, text, actionid) VALUES (392, 318, 'Visit alleyway', 393);
INSERT INTO actions (id) VALUES (393);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (393, 331, 0);
--
--Conditionals
INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (391, 321, 'alleyarrival', 0);
INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (394, 392, 'alleyarrival', 1);
--
--Choice-3-1
INSERT INTO choice (id, eventid, text, actionid) VALUES (404, 318, 'Visit Governor`s house', 405);
--INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (406, 404, 'outfit', 0);
INSERT INTO actions (id) VALUES (405);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (405, 352, 0);
--
--Choice-3-2
--INSERT INTO choice (id, eventid, text, actionid) VALUES (323, 318, 'Visit Governor`s house', 324);
--INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (407, 323, 'outfit', 1);
--INSERT INTO actions (id) VALUES (324);
--INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (324, 355, 0);

-----------------------------------Bell-Tower-Rock-----------------------------------
INSERT INTO event (id, text) VALUES (325, 'There`s an engraving here in both English and Spanish, I`ll just read the English though.
"This rock has been here for since its discovery. Its shape reminded early settlers of a Church`s bell tower or steeple, thus the island was named after it"');
INSERT INTO choice (id, eventid, text, actionid) VALUES (326, 325, 'Return to plaza', 327);
INSERT INTO actions (id, text) VALUES (327, 'I guess I`ll head back.');
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (327, 318, 0);
---------------------------------------Alleyway--------------------------------------
INSERT INTO event (id, text, backgroundname) VALUES (328, 'Gossiper: "¿Has oído hablar de la fiesta del gobernador?"
Black-Market seller: "¿Quieres decir el que está mostrando su "tesoro"? Sí, la vendí. Él piensa que es una especie de reliquia antigua, es sólo un pedazo de un mapa."
Gossiper: "Interesante..."
$PLAYER_NAME$: *Someone took the time to write this, so it must be important. If only I understood Spanish...*', 'alleyway_0');
INSERT INTO choice (id, eventid, text, actionid) VALUES (329, 328, 'next', 330);
INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (399, 330, 'alleyarrival', 1);
INSERT INTO actions (id) VALUES (330);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (330, 331, 0);
-------------------------------------------------------------------------------------
INSERT INTO event (id, text) VALUES (331, 'I arrive at a dark alleyway. There appears to be some ruckus going, however there`s also something on the ground');
--
--Choice-1-1
INSERT INTO choice (id, eventid, text, actionid) VALUES (332, 331, 'Checkout the ruckus', 333);
INSERT INTO actions (id) VALUES (333);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (333, 336, 0);
--
--Choice-1-2
--INSERT INTO choice (id, eventid, text, actionid) VALUES (395, 331, 'Checkout the ruckus', 396);
--INSERT INTO actions (id) VALUES (396);
--INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (396, 777, 0);
--Conditionals
--INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (398, 332, 'outfit', 0);
--INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (397, 395, 'outfit', 1);
--
--Choice-2-1
INSERT INTO choice (id, eventid, text, actionid) VALUES (334, 331, 'Inspect item on ground', 335);
--INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (400, 334, 'invitation', 0);
INSERT INTO actions (id) VALUES (335);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (335, 349, 0);
--
--Choice-2-2
--INSERT INTO choice (id, eventid, text, actionid) VALUES (401, 331, 'Inspect item on ground', 402);
--INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (403, 401, 'invitation', 1);
--INSERT INTO actions (id) VALUES (402);
--INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (402, 777, 0);
--
--Choice-3
INSERT INTO choice (id, eventid, text, actionid) VALUES (344, 331, 'Return to plaza', 345);
INSERT INTO actions (id) VALUES (345);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (345, 318, 0);
-------------------------------------------------------------------------------------
INSERT INTO event (id, text) VALUES (336, 'Noble: "I *hic* was supposed to be visiting the governor and y-*belch* you`re going to treat me like this?"
Bar worker: "You`re disturbing my other patrons, come back when you`ve sobered up a bit."
$PLAYER_NAME$: *Hm, that drunken noble has some nice clothes, I might need those to get into the party*');
--
--Choice-1
INSERT INTO choice (id, eventid, text, actionid) VALUES (337, 336, 'Steal the noble`s outfit', 338);
INSERT INTO actions (id) VALUES (338);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (338, 341, 0);
--
--Choice-2
INSERT INTO choice (id, eventid, text, actionid) VALUES (339, 336, 'Talk to the noble', 340);
INSERT INTO actions (id) VALUES (340);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (340, 346, 0);
-------------------------------------------------------------------------------------
INSERT INTO event (id, text) VALUES (341, 'I watch the noble waiting for the perfect chance to steal their clothes only to witness them stumbling into a side alley and pass out.
Seeing this oppotunity I steal their clothes leaving them with nothing but their undergarments.');
INSERT INTO choice (id, eventid, text, actionid) VALUES (342, 341, 'next', 343);
INSERT INTO actions (id) VALUES (343);
--INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (418, 343, 'outfit', 1);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (343, 331, 0);
-------------------------------------------------------------------------------------
INSERT INTO event (id, text) VALUES (346, '$PLAYER_NAME$: "Hey, nice clothes. I`ll get you a drink if you give them to me."
Noble: "Woah, you`re *hic* a pirate? I always wanted to be a pirate!"
$PLAYER_NAME$: "Really? Then how about we trade outfits, you`d get to dress like a pirate"
Noble: "Deal!"');
INSERT INTO choice (id, eventid, text, actionid) VALUES (347, 346, 'next', 348);
INSERT INTO actions (id, text) VALUES (348, 'With this new outfit I should be able to get into the party');
--INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (419, 348, 'outfit', 1);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (348, 331, 0);
-------------------------------------------------------------------------------------
INSERT INTO event (id, text) VALUES (349, 'I look at the item on the ground. It`s a bit dirty but it would seem some noble dropped their invitation to the governor`s party. In other news it seems some pirate became a noble recently');
INSERT INTO choice (id, eventid, text, actionid) VALUES (350, 349, 'next', 351);
INSERT INTO actions (id) VALUES (351);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (351, 331, 0);
-------------------------------Governor's-House--------------------------------------
--CONDITIONAL-Doesn't have outfit
--INSERT INTO event (id, text) VALUES (352, 'Guard: "¡Fuera de aquí, pirata, o tendrá que ser atado en cadenas para el resto de sus días!"
--$PLAYER_NAME$: *They sounded angry, maybe I should come back later*');
--INSERT INTO choice (id, eventid, text, actionid) VALUES (353, 352, 'next', 354);
--INSERT INTO actions (id, text) VALUES (354 , 'It might help if I didn`t look like a pirate. I`ll need some new clothes');
--INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (354, 318, 0);
-------------------------------------------------------------------------------------
INSERT INTO event (id, text) VALUES (355, 'Guard: "Invitación, por favor."
$PLAYER_NAME$: "Uhh? I don`t understand..."
Guard: "*sigh* You must be the English noble, do you have your invitation?"
$PLAYER_NAME$: "Oh"');
--
--Choice-1-1
--INSERT INTO choice (id, eventid, text, actionid) VALUES (408, 355, 'Present Invitation', 409);
--INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (410, 408, 'invitation', 0);
--INSERT INTO actions (id, text) VALUES (409, 'I don't have an invitation and it's too late to sneak, I`ll have to convince the guard');
--INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (409, 363, 0);
--
--Choice-1-2
INSERT INTO choice (id, eventid, text, actionid) VALUES (356, 355, 'Present Invitation', 357);
--INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (411, 365, 'invitation', 0);
INSERT INTO actions (id) VALUES (357);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (357, 360, 0);
--
--Choice-2
INSERT INTO choice (id, eventid, text, actionid) VALUES (358, 355, 'Convince guard', 359);
INSERT INTO actions (id) VALUES (359);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (359, 363, 0);
--
--Choice-3
INSERT INTO choice (id, eventid, text, actionid) VALUES (366, 355, 'Sneak in', 367);
INSERT INTO actions (id) VALUES (367);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (367, 368, 0);
-------------------------------------------------------------------------------------
INSERT INTO event (id, text) VALUES (360, '$PLAYER_NAME$: "Yes, here is the invitation, may I go in now?"
Guard: "Of course, be on your way now."');
INSERT INTO choice (id, eventid, text, actionid) VALUES (361, 360, 'Enter the party', 362);
INSERT INTO actions (id) VALUES (362);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (362, 371, 0);
-------------------------------------------------------------------------------------
INSERT INTO event (id, text) VALUES (363, 'PLAYER: "My invitation was stolen from me by some pirate in the back alleys, can`t you let me through?"
Guard: "We have been having problems with pirates this year... Very well, you may enter, but don`t tell anyone I let you in."');
INSERT INTO choice (id, eventid, text, actionid) VALUES (364, 363, 'Enter the party', 365);
INSERT INTO actions (id) VALUES (365);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (365, 371, 0);
-------------------------------------------------------------------------------------
INSERT INTO event (id, text) VALUES (368, '$PLAYER_NAME$: "Look, it`s the inquisition!"
*the guard runs in the direction I had point to"
Guard: "¡Espera, no empieces sin mí!"
$PLAYER_NAME$: "Hah, nobody expects the Spanish Inquisition"');
INSERT INTO choice (id, eventid, text, actionid) VALUES (369, 368, 'Enter the party', 370);
INSERT INTO actions (id) VALUES (370);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (370, 371, 0);
-------------------------------Governor's-Party--------------------------------------
INSERT INTO event (id, text) VALUES (371, 'I entered the governor`s party, now I just need to find where the map piece is hidden. It will probably be locked away in a back room');
INSERT INTO choice (id, eventid, text, actionid) VALUES (372, 371, 'Look for the back room', 373);
INSERT INTO actions (id) VALUES (373);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (373, 374, 0);
-------------------------------------------------------------------------------------
--Guard fight here maybe?
-------------------------------------------------------------------------------------
INSERT INTO event (id, text) VALUES (374, 'I went looking for the back room and found a suspicious looking door. There are a series of switches next to the door and some number on the door itself. Perhaps the map piece is stored here');
INSERT INTO choice (id, eventid, text, actionid) VALUES (375, 374, 'Solve this puzzle', 376);
INSERT INTO actions (id, challengeid) VALUES (376, 377);
INSERT INTO challenge (challengeid, challengename, challengetype) VALUES (377, 'binary', 'puzzle');
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (376, 391, 0);--fail
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (376, 378, 1);--success
--fail
INSERT INTO event (id, text) VALUES (391, 'I can`t give in. I have to do this fast before they come to get the map piece.');
INSERT INTO choice (id, eventid, text, actionid) VALUES (379, 391, 'Try again', 376);
--success
INSERT INTO event (id, text) VALUES (378, 'Good, I`ve got the map piece now. Maybe I should get out of here');
--
--Choice-1
INSERT INTO choice (id, eventid, text, actionid) VALUES (380, 378, 'Leave', 381);
INSERT INTO actions (id, text) VALUES (381, '*I`d better leave the island before someone notices*');
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (381, 388, 0);
INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (412, 381, 'mappiece2found', 1);
--
--Choice-2
INSERT INTO choice (id, eventid, text, actionid) VALUES (383, 378, 'See what Happens', 384);
INSERT INTO actions (id, text) VALUES (384, 'I`ll make my way back to the main hall and see what happens');
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (384, 385, 0);
INSERT INTO conditional (id, attachedid, flag, flagstate) VALUES (413, 384, 'mappiece2found', 1);
-------------------------------------------------------------------------------------
INSERT INTO event (id, text) VALUES (385, 'Governor: "¡Ahora para el acontecimiento principal, el pergamino del mundo antiguo!"
*the governor pulls back the curtain and reveals the case is empty*
Governor: " *gasp* ¡GUARDAS, MI RELÍQUICA HA SIDO ROBADA! ¡ESTÉ EN LA ALERTA PARA INDIVIDUALES SUSPICIOSOS!"
$PLAYER_NAME$: "That was fun while it lasted, but it looks as if I`ve overstayed my welcome. I better leave."');
INSERT INTO choice (id, eventid, text, actionid) VALUES (386, 385, 'Leave', 387);
INSERT INTO actions (id) VALUES (387);
INSERT INTO actionsevent (actionid, eventid, eventposition) VALUES (387, 388, 0);
----------------------------------Docks----------------------------------------------
INSERT INTO event (id, text) VALUES (388, 'Guard: "Is that a new outfit?"
$PLAYER_NAME$: "Yeah, I thought I`d change up my style. Anyway, we need to be going now"
Guard: "Wait, don`t you need supplies!"
*I quickly board the ship and motion to my crew to sail out*
$PLAYER_NAME$: "We`ll manage!"
*I faintly hear the guard muttering something*
Guard(aside): "Wait! Uf, esos malditos ingleses..."');
INSERT INTO choice (id, eventid, text, actionid) VALUES (389, 388, 'Set sail!', 1500);
-------------------------------------------------------------------------------------
