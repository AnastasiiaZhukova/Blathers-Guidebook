CREATE DATABASE  IF NOT EXISTS app_database;
USE app_database;

DROP TABLE IF EXISTS user;

CREATE TABLE user (
  user_id int NOT NULL AUTO_INCREMENT,
  user_name varchar(30) NOT NULL UNIQUE,
  password varchar(255) NOT NULL,
  
  PRIMARY KEY (user_id)
);

SELECT * FROM user;

DROP TABLE IF EXISTS collectable;

CREATE TABLE collectable (
  collectable_id int NOT NULL AUTO_INCREMENT,
  collectable_name varchar(255) NOT NULL UNIQUE,
  type VARCHAR(255) NOT NULL,
  location VARCHAR(255) NOT NULL,
  time VARCHAR(255) NOT NULL,
  months VARCHAR(255) NOT NULL,
  is_collected BOOLEAN DEFAULT FALSE,
  
  PRIMARY KEY (collectable_id)
);

/* data taken from: www.polygon.com/animal-crossing-new-horizons-switch-acnh-guide*/
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Bitterling', 'fish', 'River', 'All day', 'November-March (Northern) / May-September (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Pale Chub', 'fish', 'River', '9 a.m. - 4 p.m.', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Crucian Carp', 'fish', 'River', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Dace', 'fish', 'River', '4 p.m. - 9 a.m.', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Carp', 'fish', 'Pond', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Koi', 'fish', 'Pond', '4 p.m. - 9 a.m.', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Goldfish', 'fish', 'Pond', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Pop-eyed Goldfish', 'fish', 'Pond', '9 a.m. - 4 p.m.', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Ranchu Goldfish', 'fish', 'Pond', '9 a.m. - 4 p.m.', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Killifish', 'fish', 'Pond', 'All day', 'April-August (Northern) / October-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Crawfish', 'fish', 'Pond', 'All day', 'April-September (Northern) / October-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Soft-shelled Turtle', 'fish', 'River', '4 p.m. - 9 a.m.', 'August-September (Northern) / February-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Snapping Turtle', 'fish', 'River', '9 p.m. - 4 a.m.', 'April-October (Northern) / October-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Tadpole', 'fish', 'Pond', 'All day', 'March-July (Northern) / September-January (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Frog', 'fish', 'Pond', 'All day', 'May-August (Northern) / November-Feburary (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Freshwater Goby', 'fish', 'River', '4 p.m. - 9 a.m.', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Loach', 'fish', 'River', 'All day', 'March-May (Northern) / September-November (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Catfish', 'fish', 'Pond', '4 p.m. - 9 a.m.', 'May-October (Northern) / November-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Giant Snakehead', 'fish', 'Pond', '9 a.m. - 4 p.m.', 'June-August (Northern) / December-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Bluegill', 'fish', 'River', '9 a.m. - 4 p.m.', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Yellow Perch', 'fish', 'River', 'All day', 'October-March (Northern) / April-September (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Black Bass', 'fish', 'River', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Tilapia', 'fish', 'River', 'All day', 'June-October (Northern) / December-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Pike', 'fish', 'River', 'All day', 'September-December (Northern) / March-June (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Pond Smelt', 'fish', 'River', 'All day', 'December-February (Northern) / June-August (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Sweetfish', 'fish', 'River', 'All day', 'July-September (Northern) / January-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Cherry Salmon', 'fish', 'River (Clifftop)', '4 p.m. - 9 a.m.', 'March-June, September-November (Northern) / March-May, September-December (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Char', 'fish', 'River (Clifftop)', '4 p.m. - 9 a.m.', 'March-June, September-November (Northern) / March-May, September-December (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Golden Trout', 'fish', 'River (Clifftop)', '4 p.m. - 9 a.m.', 'March-May, September-November (Northern) / March-May, September-November (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Stringfish', 'fish', 'River (Clifftop)', '4 p.m. - 9 a.m.', 'December-March (Northern) / June-September (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Salmon', 'fish', 'River (mouth)', 'All day', 'September (Northern) / March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('King Salmon', 'fish', 'River (mouth)', 'All day', 'September (Northern) / March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Mitten Crab', 'fish', 'River', '4 p.m. - 9 a.m.', 'September-November (Northern) / March-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Guppy', 'fish', 'River', '9 a.m. - 4 p.m.', 'April-November (Northern) / October-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Nibble Fish', 'fish', 'River', '9 a.m. - 4 p.m.', 'May-September (Northern) / November-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Angelfish', 'fish', 'River', '4 p.m. - 9 a.m.', 'May-October (Northern) / November-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Betta', 'fish', 'River', '9 a.m. - 4 p.m.', 'May-October (Northern) / November-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Neon Tetra', 'fish', 'River', '9 a.m. - 4 p.m.', 'April-November (Northern) / October-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Rainbowfish', 'fish', 'River', '9 a.m. - 4 p.m.', 'May-October (Northern) / November-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Piranha', 'fish', 'River', '9 a.m. - 4 p.m., 9 p.m. - 4 a.m.', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Arowana', 'fish', 'River', '4 p.m. - 9 a.m.', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Dorado', 'fish', 'River', '4 a.m. - 9 p.m.', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Gar', 'fish', 'Pond', '4 p.m. - 9 a.m.', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Arapaima', 'fish', 'River', '4 p.m. - 9 a.m.', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Saddled Bichir', 'fish', 'River', '9 p.m. - 4 a.m.', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Sturgeon', 'fish', 'River (mouth)', 'All day', 'September-March (Northern) / March-September (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Sea Butterfly', 'fish', 'Sea', 'All day', 'December-March (Northern) / June-September (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Sea Horse', 'fish', 'Sea', 'All day', 'April-November (Northern) / October-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Clown Fish', 'fish', 'Sea', 'All day', 'April-September (Northern) / October-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Surgeonfish', 'fish', 'Sea', 'All day', 'April-September (Northern) / October-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Butterfly Fish', 'fish', 'Sea', 'All day', 'April-September (Northern) / October-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Napoleonfish', 'fish', 'Sea', '4 a.m. - 9 p.m.', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Zebra Turkeyfish', 'fish', 'Sea', 'All day', 'April-November (Northern) / October-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Blowfish', 'fish', 'Sea', '9 p.m. - 4 a.m.', 'November-February (Northern) / May-August (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Puffer Fish', 'fish', 'Sea', 'All day', 'July-September (Northern) / January-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Anchovy', 'fish', 'Sea', '4 a.m. - 9 p.m.', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Horse Mackerel', 'fish', 'Sea', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Barred Knifejaw', 'fish', 'Sea', 'All day', 'March-November (Northern) / September-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Sea Bass', 'fish', 'Sea', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Red Snapper', 'fish', 'Sea', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Dab', 'fish', 'Sea', 'All day', 'October-April (Northern) / April-October (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Olive Flounder', 'fish', 'Sea', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Squid', 'fish', 'Sea', 'All day', 'December-August (Northern) / June-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Moray Eel', 'fish', 'Sea', 'All day', 'August-October (Northern) / February-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Ribbon Eel', 'fish', 'Sea', 'All day', 'June-October (Northern) / December-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Tuna', 'fish', 'Pier', 'All day', 'November-April (Northern) / May-October (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Blue Marlin', 'fish', 'Pier', 'All day', 'July-September, November-April (Northern) / January-March, May-November (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Giant Trevally', 'fish', 'Pier', 'All day', 'May-October (Northern) / November-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Mahi-mahi', 'fish', 'Pier', 'All day', 'May-October (Northern) / November-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Ocean Sunfish', 'fish', 'Sea', '4 a.m. - 9 p.m.', 'July-September (Northern) / January-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Ray', 'fish', 'Sea', '4 a.m. - 9 p.m.', 'August-November (Northern) / February-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Saw Shark', 'fish', 'Sea', '4 p.m. - 9 a.m.', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Hammerhead Shark', 'fish', 'Sea', '4 p.m. - 9 a.m.', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Great White Shark', 'fish', 'Sea', '4 p.m. - 9 a.m.', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Whale Shark', 'fish', 'Sea', 'All day', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Suckerfish', 'fish', 'Sea', 'All day', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Football Fish', 'fish', 'Sea', '4 p.m. - 9 a.m.', 'November-March (Northern) / May-September (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Oarfish', 'fish', 'Sea', 'All day', 'December-May (Northern) / June-November (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Barreleye', 'fish', 'Sea', '9 p.m. - 4 a.m.', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Coelacanth', 'fish', 'Sea (rainy days)', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Seaweed', 'sea creature', 'Sea', 'All day', 'October-July (Northern) / April-January (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Sea grapes', 'sea creature', 'Sea', 'All day', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Sea cucumber', 'sea creature', 'Sea', 'All day', 'November-April (Northern) / May-October (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Sea pig', 'sea creature', 'Sea', '4 p.m. - 9 a.m.', 'November-February (Northern) / May-August (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Sea star', 'sea creature', 'Sea', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Sea urchin', 'sea creature', 'Sea', 'All day', 'May-September (Northern) / November-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Slate pencil urchin', 'sea creature', 'Sea', '4 p.m. - 9 a.m.', 'May-September (Northern) / November-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Sea anemone', 'sea creature', 'Sea', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Moon jellyfish', 'sea creature', 'Sea', 'All day', 'July-September (Northern) / January-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Sea slug', 'sea creature', 'Sea', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Pearl oyster', 'sea creature', 'Sea', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Mussel', 'sea creature', 'Sea', 'All day', 'June-December (Northern) / December-June (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Oyster', 'sea creature', 'Sea', 'All day', 'September-February (Northern) / March-August (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Scallop', 'sea creature', 'Sea', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Whelk', 'sea creature', 'Sea', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Turban shell', 'sea creature', 'Sea', 'All day', 'March-May, September-December (Northern) / March-June, September-November (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Abalone', 'sea creature', 'Sea', '4 p.m. - 9 a.m.', 'June-January (Northern) / December-July (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Gigas giant clam', 'sea creature', 'Sea', 'All day', 'May-September (Northern) / November-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Chambered nautilus', 'sea creature', 'Sea', '4 p.m. - 9 a.m.', 'March-June, September-November (Northern) / September-December, March-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Octopus', 'sea creature', 'Sea', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Umbrella octopus', 'sea creature', 'Sea', 'All day', 'March-May, September-November (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Vampire squid', 'sea creature', 'Sea', '4 p.m. - 9 a.m.', 'May-August (Northern) / November-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Firefly squid', 'sea creature', 'Sea', '9 p.m. - 4 a.m.', 'March-June (Northern) / September-December (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Gazami crab', 'sea creature', 'Sea', 'All day', 'June-November (Northern) / December-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Dungeoness crab', 'sea creature', 'Sea', 'All day', 'November-May (Northern) / May-November (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Snow crab', 'sea creature', 'Sea', 'All day', 'November-April (Northern) / May-October (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Red king crab', 'sea creature', 'Sea', 'All day', 'November-March (Northern) / May-September (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Acorn barnacle', 'sea creature', 'Sea', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Spider crab', 'sea creature', 'Sea', 'All day', 'March-April (Northern) / September-October (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Tiger prawn', 'sea creature', 'Sea', '4 p.m. - 9 a.m.', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Sweet shrimp', 'sea creature', 'Sea', '4 p.m. - 9 a.m.', 'September-February (Northern) / March-August (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Mantis shrimp', 'sea creature', 'Sea', '4 p.m. - 9 a.m.', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Spiny Lobster', 'sea creature', 'Sea', '9 p.m. - 4 a.m.', 'October-December (Northern) / April-June (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Lobster', 'sea creature', 'Sea', 'All day', 'April-June, December-January (Northern) / October-December, June-July (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Giant isopod', 'sea creature', 'Sea', '9 a.m. - 4 p.m., 9 p.m. - 4 a.m.', 'July-October (Northern) / January-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Horseshoe crab', 'sea creature', 'Sea', '9 p.m. - 4 a.m.', 'July-September (Northern) / January-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Sea pineapple', 'sea creature', 'Sea', 'All day', 'April-August (Northern) / December-July (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Spotted garden eel', 'sea creature', 'Sea', '4 a.m. - 9 p.m.', 'May-October (Northern) / November-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Flatworm', 'sea creature', 'Sea', '4 p.m. - 9 a.m.', 'August-September (Northern) / February-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Venus flower basket', 'sea creature', 'Sea', 'All day', 'October-February (Northern) / April-August (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Common Butterfly', 'bug', 'Flying', '4 a.m. - 7 p.m.', 'September-June (Northern) / March-December (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Yellow Butterfly', 'bug', 'Flying', '4 a.m. - 7 p.m.', 'March-June, September-October (Northern) / March-April, September-December (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Tiger Butterfly', 'bug', 'Flying', '4 a.m. - 7 p.m.', 'March-September (Northern) / September-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Peacock Butterfly', 'bug', 'Flying by hybrid flowers', '4 a.m. - 7 p.m.', 'March-June (Northern) / September-December (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Common Bluebottle', 'bug', 'Flying', '4 a.m. - 7 p.m.', 'April-August (Northern) / October-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Paper Kite Butterfly', 'bug', 'Flying', '8 a.m. - 7 p.m.', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Great Purple Emperor', 'bug', 'Flying', '4 a.m. - 7 p.m.', 'May-August (Northern) / November-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Monach Butterfly', 'bug', 'Flying', '4 a.m. - 5 p.m.', 'September-November (Northern) / March-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Emperor Butterfly', 'bug', 'Flying', '5 p.m. - 8 a.m.', 'June-September, December-March (Northern) / December-March, June-September (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Agrias Butterfly', 'bug', 'Flying', '8 a.m. - 5 p.m.', 'April-September (Northern) / November-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Raja Brooke''s Birdwing', 'bug', 'Flying by purple flowers', '8 a.m. - 5 p.m.', 'April-September, December-February (Northern) / November-March, June-August (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Queen Alexandra''s Birdwing', 'bug', 'Flying', '8 a.m. - 4 p.m.', 'May-September (Northern) / November-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Moth', 'bug', 'Flying by light', '7 p.m. - 4 a.m.', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Atlas Moth', 'bug', 'On trees', '7 p.m. - 4 a.m.', 'April-September (Northern) / October-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Madagascan Sunset Moth', 'bug', 'Flying', '8 a.m. - 4 p.m.', 'April-September (Northern) / October-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Long Locust', 'bug', 'On ground', '8 a.m. - 7 p.m.', 'April-November (Northern) / November-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Migratory Locust', 'bug', 'On ground', '8 a.m. - 7 p.m.', 'August-November (Northern) / February-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Rice Grasshopper', 'bug', 'On ground', '8 a.m. - 7 p.m.', 'August-November (Northern) / February-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Grasshopper', 'bug', 'On ground', '8 a.m. - 5 p.m.', 'July-September (Northern) / January-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Cricket', 'bug', 'On ground', '5 p.m. - 8 a.m.', 'September-November (Northern) / March-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Bell Cricket', 'bug', 'On ground', '5 p.m. - 8 a.m.', 'September-October (Northern) / March-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Mantis', 'bug', 'On flowers', '8 a.m. - 5 p.m.', 'March-November (Northern) / September-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Orchid Mantis', 'bug', 'On white flowers', '8 a.m. - 5 p.m.', 'March-November (Northern) / September-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Honeybee', 'bug', 'Flying', '8 a.m. - 5 p.m.', 'March-July (Northern) / September-January (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Wasp', 'bug', 'Falls from shaking trees', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Brown Cicada', 'bug', 'On trees', '8 a.m. - 5 p.m.', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Robust Cicada', 'bug', 'On trees', '8 a.m. - 5 p.m.', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Giant Cicada', 'bug', 'On trees', '8 a.m. - 5 p.m.', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Walker Cicada', 'bug', 'On trees', '8 a.m. - 5 p.m.', 'August-September (Northern) / February-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Evening Cicada', 'bug', 'On trees', '4 a.m. - 8 a.m., 4 p.m. - 7 p.m.', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Cicada Shell', 'bug', 'On trees', 'All day', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Red Dragonfly', 'bug', 'Flying', '8 a.m. - 7 p.m.', 'September-October (Northern) / March-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Darner Dragonfly', 'bug', 'Flying', '8 a.m. - 5 p.m.', 'April-October (Northern) / October-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Banded Dragonfly', 'bug', 'Flying', '8 a.m. - 5 p.m.', 'May-October (Northern) / November-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Damselfly', 'bug', 'Flying', 'All day', 'November-February (Northern) / May-August (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Firefly', 'bug', 'Flying', '7 p.m. - 4 a.m.', 'June (Northern) / December (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Mole Cricket', 'bug', 'Underground', 'All day', 'November-May (Northern) / May-November (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Pondskater', 'bug', 'Ponds', '8 a.m. - 7 p.m.', 'May-September (Northern) / November-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Diving Beetle', 'bug', 'Ponds and rivers', '8 a.m. - 7 p.m.', 'May-September (Northern) / November-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Giant Water Bug', 'bug', 'Ponds and rivers', '7 p.m. - 8 a.m.', 'April-September (Northern) / October-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Stinkbug', 'bug', 'On flowers', 'All day', 'March-October (Northern) / September-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Man-faced Stink Bug', 'bug', 'On flowers', '7 p.m. - 8 a.m.', 'March-October (Northern) / September-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Ladybug', 'bug', 'On flowers', '8 a.m. - 5 p.m.', 'March-June, October (Northern) / September-December, April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Tiger Beetle', 'bug', 'On ground', 'All day', 'February-November (Northern) / August-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Jewel Beetle', 'bug', 'On tree stumps', 'All day', 'April-August (Northern) / October-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Violin Beetle', 'bug', 'On tree stumps', 'All day', 'May-June, September-November (Northern) / November-December, March-April (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Citrus Long-horned Beetle', 'bug', 'On tree stumps', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Rosalia Batesi Beetle', 'bug', 'On tree stumps', 'All day', 'May-September (Northern) / November-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Blue Weevil Beetle', 'bug', 'On coconut trees', 'All day', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Dung Beetle', 'bug', 'Pushing snowballs', 'All day', 'December-February (Northern) / June-August (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Earth-boring Dung Beetle', 'bug', 'On ground', 'All day', 'July-September (Northern) / January-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Scarab Beetle', 'bug', 'On trees', '11 p.m. - 8 a.m.', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Drone Beetle', 'bug', 'On trees', 'All day', 'June-August (Northern) / December-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Goliath Beetle', 'bug', 'On coconut trees', '5 p.m. - 8 a.m.', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Saw Stag', 'bug', 'On trees', 'All day', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Miyama Stag', 'bug', 'On trees', 'All day', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Giant Stag', 'bug', 'On trees', '11 p.m. - 8 a.m.', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Rainbow Stag', 'bug', 'On trees', '7 p.m. - 8 a.m.', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Cyclommatus Stag', 'bug', 'On coconut trees', '5 p.m. - 8 a.m.', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Golden Stag', 'bug', 'On coconut trees', '5 p.m. - 8 a.m.', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Giraffe Stag', 'bug', 'On coconut trees', '5 p.m. - 8 a.m.', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Horned Dynastid', 'bug', 'On trees', '5 p.m. - 8 a.m.', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Horned Atlas', 'bug', 'On coconut trees', '5 p.m. - 8 a.m.', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Horned Elephant', 'bug', 'On coconut trees', '5 p.m. - 8 a.m.', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Horned Hercules', 'bug', 'On coconut trees', '5 p.m. - 8 a.m.', 'July-August (Northern) / January-February (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Walking Stick', 'bug', 'On trees', '4 a.m. - 8 a.m., 5 p.m. - 7 p.m.', 'July-November (Northern) / January-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Walking Leaf', 'bug', 'Near trees, disguised as furniture leaf', 'All day', 'July-August (Northern) / January-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Bagworm', 'bug', 'Falls from shaking trees', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Ant', 'bug', 'On rotten food', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Hermit Crab', 'bug', 'Beach', '7 p.m. - 8 a.m.', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Wharf Roach', 'bug', 'On rocks at beach', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Fly', 'bug', 'On trash items', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Mosquito', 'bug', 'Flying', '5 p.m. - 4 a.m.', 'June-September (Northern) / December-March (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Flea', 'bug', 'On villagers', 'All day', 'April-November (Northern) / October-May (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Snail', 'bug', 'On rocks (raining)', 'All day', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Pill Bug', 'bug', 'Hit rocks', '11 p.m. - 4 p.m.', 'September-June (Northern) / March-December (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Centipede', 'bug', 'Hit rocks', '4 p.m. - 11 p.m.', 'September-June (Northern) / March-December (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Spider', 'bug', 'Falls from shaking trees', '7 p.m. - 8 a.m.', 'Year-round (Northern and Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Tarantula', 'bug', 'On ground', '7 p.m. - 4 a.m.', 'November-April (Northern) / May-October (Southern)', FALSE);
INSERT INTO collectable (collectable_name, type, location, time, months, is_collected) VALUES ('Scorpion', 'bug', 'On ground', '7 p.m. - 4 a.m.', 'May-October (Northern) / November-April (Southern)', FALSE);

SELECT * FROM collectable;
