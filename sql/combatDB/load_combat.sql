/*
 * Author:  lucas.burdell
 * Created: Mar 21, 2017
 */



INSERT INTO entitydata (ENTITY_NAME, HEALTH, MELEE_MODIFIER, 
RANGED_MODIFIER, VERBAL_MODIFIER, INSULT_IMMUNITY) VALUES (
    'wolf', 
    100, 
    6.25, 
    0.0, 
    0.0,
    true
);
INSERT INTO entitydata (ENTITY_NAME, HEALTH, MELEE_MODIFIER, 
RANGED_MODIFIER, VERBAL_MODIFIER, INSULT_IMMUNITY) VALUES (
    'PLAYER', 
    100, 
    2.5, 
    6.25, 
    0.0,
    false
);
INSERT INTO entitydata (ENTITY_NAME, HEALTH, MELEE_MODIFIER, 
RANGED_MODIFIER, VERBAL_MODIFIER, INSULT_IMMUNITY) VALUES (
    'Drunken Sailor', 
    100, 
    2.5, 
    6.25, 
    0.0,
    false
);
INSERT INTO entitydata (ENTITY_NAME, HEALTH, MELEE_MODIFIER, 
RANGED_MODIFIER, VERBAL_MODIFIER, INSULT_IMMUNITY) VALUES (
    'Conrad', 
    100, 
    2.5, 
    6.25, 
    0.0,
    false
);

INSERT INTO insults (INSULT) VALUES(
    'Go VERB yourself, you ADJECTIVE NOUN'
)