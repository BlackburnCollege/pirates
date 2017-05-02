/*
 CAVE STARTS AT ID 900
*/

INSERT INTO event (id, text, backgroundname) VALUES (900, 'On the horizon I see a forested island.', 'ettin_cave_0');

insert into choice(id, eventid, text, actionid) values (901, 900, 'Proceed to island' , 902);

insert into conditional(id, attachedid, flag, flagstate) VALUES (903, 901, 'mappiece4found', 0);

insert into actions(id) values (902);

insert into actionsevent (actionid, eventid, eventposition) values (902, 907, 0);

insert into choice(id, eventid, text, actionid) values (904, 900, 'I already have the map piece I came for, there is nothing left in that strange place for me.', 1500);

insert into conditional(id, attachedid, flag, flagstate) VALUES (906, 904, 'mappiece4found', 1);


INSERT INTO event (id, text) VALUES (907, 'I take a small ship to the island of the cave that supposedly houses a map fragment.  I land on the beach, and quickly take in the scope of this island. The island is densely forested, but small so the cave will not be too hard to find. If not for the note in the journal and my extreme scrutiny of the sea, I may not have even found this island. The journal entry had one other thing to note, beware of the strange inhabitants of the cave. Unsure of what that is supposed to mean, I quickly make way to find the cave.');

insert into choice(id, eventid, text, actionid) values (908, 907, 'next' , 909);

insert into actions(id) values (909);

insert into actionsevent (actionid, eventid, eventposition) values (909, 910, 0);

INSERT INTO event (id, text) VALUES (910, 'Within the hour I find the mouth of the cave, lightly obscured with brush that I quickly set aside. I can’t see very far into the cave, but the smell hits me hard. Rotting flesh and the most horrific body odor one could imagine. I hurriedly move a cloth to cover my nose in fear of losing my lunch. I make a torch out of a stick and some jungle brush and proceed inside.I slowly follow the winding tunnel of this cave, wary of anything. After a few minutes, I turn a corner and quickly retreat at the sight of movement. There was a large humanoid creature moving around a campfire. I snuff out my makeshift torch so that I do not give away my position. I stealthily peak around the corner once more to gain a better understanding of what I face. There is a large green-grey man facing away from me, leaning over the fire. Odd, 1 man yet I hear 2 voices yelling and bickering. I look around once more but there is nobody else in the cave. However, I do see a cage farther back wreathed in shadow. I can make the form of one more creature curled up inside, but I cannot make out any distinct features. Perhaps this is where the second voice is coming from.');

insert into choice(id, eventid, text, actionid) values (911, 910, 'next' , 912);

insert into actions(id) values (912);

insert into actionsevent (actionid, eventid, eventposition) values (912, 913, 0);

INSERT INTO event (id, text) VALUES (913, 'I pull back around the corner to ready my weapons, but as I do I knock a piece of the wall loose which clatters to the floor. I immediately stop, hoping the beast did not hear. “Who goes there?” I hear heavy footfalls moving in my direction, I guess a bit of luck was too much to hope for. I turn the corner and level my pistol, but freeze at the sight of what I see. This large man was no man at all, but two. Two heads set upon the one body, snarling and drooling in my direction. I’ve heard of such creatures before, I believe they were called ettins.');

insert into choice(id, eventid, text, actionid) values (914, 913, 'I snap out of my momentary confusion and pull the trigger.' , 915);

insert into actions(id, challengeid) values (915, 918);

insert into actionsevent (actionid, eventid, eventposition) values (915, 916, 0);

insert into actionsevent (actionid, eventid, eventposition) values (915, 917, 1);

insert into challenge(challengeid, challengename, challengetype) values (918, 'Kevin-Josh the Ettin', 'combat');

INSERT INTO event (id, text) VALUES (917, 'The ettin falls with a loud thud that shakes the walls of the cave, followed by faint clapping from the back of the cave. I strain to see what might be back there. All I can see is faint movement from the cage.');

insert into choice(id, eventid, text, actionid) values (956, 917, 'I move in to get a closer look.' , 919);

insert into actions(id, text) values (919, 'In the cage there is yet another ettin, but smaller. Other than it''s smaller size there is something different about it...one of the heads is smiling curiously.');

insert into actionsevent (actionid, eventid, eventposition) values (919, 920, 0);

INSERT INTO event (id, text) VALUES (916, 'With one final blow from the ettin I fall unconscious. I wake up sometime later in the cage I saw before. I look outside and see the ettin fast asleep by the fire. I turn around and immediately ready myself to fight. In the cage with me is another ettin. I find myself without my pistol or sword and fear the worst. I’m also aware of a very awkward smile on one of the ettin’s faces.');

insert into choice(id, eventid, text, actionid) values (921, 916, 'next', 922);

insert into actions(id) values (922);

insert into actionsevent (actionid, eventid, eventposition) values (922, 920, 0);

INSERT INTO event (id, text) VALUES (920, 'The smiling ettin immediately jumps up,“Hello! My name’s Tim!” He continues to awkwardly smile. The other ettin rolls her eyes, “Oh will you shut up.” Then under her breath, “What a stupid name.” She turns to see the smile, “And wipe that stupid smile off your face.');

insert into choice(id, eventid, text, actionid) values (923, 920, '“Why are you in here”', 924);

insert into actions(id, text) values (924, 'Tim immediately jumps up again, “The boss didn’t like me and Jess talking so much” The opposite hand immediately comes up and hits him, “And who’s fault is that you rambling idiot?” His smile immediately fades away. He looks down at the floor and remains silent.');

insert into actionsevent (actionid, eventid, eventposition) values (924, 925, 0);

insert into choice(id, eventid, text, actionid) values (926, 920, '“Well I know his name, what’s yours?”', 927);

insert into actions(id, text) values (927, '“Her name is J-,” WHAM! A fist slams into his face. “I can speak for myself, you overeager child.” She turns to me, “My name is Jess,” then she points to the ettin outside, “that there is Josh and Kevin.”');

insert into actionsevent (actionid, eventid, eventposition) values (927, 925, 0);

INSERT INTO event (id, text) VALUES (925, '“Now no more wasting time, we need to get out of here before the boss wakes up,” Jess says, handing me small slivers of bone, “Are you able to pick locks?”');

insert into choice(id, eventid, text, actionid) values (928, 925, '“Yes”', 929);

insert into actions(id, text) values (929, 'I quickly go to work on the lock of the cage. The slivers of bone make the lockpicking difficult, but I eventually hear the lock click, and the cage door swings open.');

insert into actionsevent (actionid, eventid, eventposition) values (929, 930, 0);

INSERT INTO event (id, text) VALUES (930, 'I sneak over to my gear and then head farther into the cave. Within a few minutes, I find my way blocked by a huge boulder. This thing must weigh several hundred pounds, there is no way that I could move that. As I am about to turn around I hear, “Do you need us to move that?” Once again Tim is standing there with his toothy grin. “We could move that for you!” Another quick slap, “No we can’t. Not until you answer our riddles.”');

insert into choice(id, eventid, text, actionid) values (931, 930, '“Riddles? Why do I have to answer riddles?”', 932);

insert into actions(id, text) values (932, '“It''s the rules,” Tim says. Jess agrees, “As stupid as he may be, Tim is right, it is ettin tradition.” I respond, “Fine I will answer your stupid riddle.”  Jess corrects me, “Riddles. Three to be exact.”');

insert into actionsevent (actionid, eventid, eventposition) values (932, 933, 0);


INSERT INTO event (id, text) VALUES (933, '"Alright then. What word becomes shorter when you add two letters to it?"');

insert into choice(id, eventid, text, actionid) values (934, 933, '“small”', 938);

insert into choice(id, eventid, text, actionid) values (935, 933, '“short”', 939);

insert into choice(id, eventid, text, actionid) values (936, 933, '“tiny”', 938);

insert into choice(id, eventid, text, actionid) values (937, 933, '“less”', 938);

insert into actions(id, text) values (938, '"Wrong! Try again!"');

insert into actionsevent (actionid, eventid, eventposition) values (938, 933, 0);

insert into actions(id, text) values (939, '"Yay! You did it," bellows Tim. "Keep your voice down you blabbering idiot," Jess replies.');

insert into actionsevent (actionid, eventid, eventposition) values (939, 940, 0);


INSERT INTO event (id, text) VALUES (940, '"Well done. Next riddle, What is harder to catch the faster you run?"');

insert into choice(id, eventid, text, actionid) values (941, 940, '“easily scared creatures”', 945);

insert into choice(id, eventid, text, actionid) values (942, 940, '“time”', 945);

insert into choice(id, eventid, text, actionid) values (943, 940, '“a bandit”', 945);

insert into choice(id, eventid, text, actionid) values (944, 940, '“your breath”', 946);

insert into actions(id, text) values (945, '"Wrong again, I thought you were smarter..."');

insert into actionsevent (actionid, eventid, eventposition) values (945, 940, 0);

insert into actions(id, text) values (946, '"Good job!," whispers Tim, quite obviously leaning away from Jess in a futile attempt to avoid being hit.');

insert into actionsevent (actionid, eventid, eventposition) values (946, 947, 0);


INSERT INTO event (id, text) VALUES (947, '"Just one more. What belongs to you, but others use it more than you do?"');

insert into choice(id, eventid, text, actionid) values (948, 947, '“your name”', 953);

insert into choice(id, eventid, text, actionid) values (949, 947, '“your ship”', 952);

insert into choice(id, eventid, text, actionid) values (950, 947, '“your bed”', 952);

insert into choice(id, eventid, text, actionid) values (951, 947, '“your sword”', 952);

insert into actions(id, text) values (952, '"Just answer this last one right and we can all move on. Try again."');

insert into actionsevent (actionid, eventid, eventposition) values (952, 947, 0);

insert into actions(id, text) values (953, '"We can move the rock now!," Tim moves jovially towards the boulder. Jess adds, "but quietly"');

insert into conditional(id, attachedid, flag, flagstate) VALUES (999, 953, 'mappiece4found', 1);

insert into actionsevent (actionid, eventid, eventposition) values (953, 954, 0);


INSERT INTO event (id, text) VALUES (954, 'Inside the room, there are various things lining the wall. Anything from random junk to shiny treasure, but at the center of it all a piece of parchment lies on a table. The map fragment. I quickly retrieve the piece and start to head back out of the cave. I carefully sneak past the ettin still snoring by the fire. Jess and Tim walk with me all the way to the entrance of the cave. I give a courteous nod and continue to the beach, Tim waving vigorously. I reach the ship and return to my quarters.');

insert into choice(id, eventid, text, actionid) values (955, 954, 'next', 1500);

