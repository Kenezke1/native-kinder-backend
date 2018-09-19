DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS connections;
DROP TABLE IF EXISTS images;
DROP TABLE IF EXISTS profiles;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	id SERIAL NOT NULL PRIMARY KEY,
	email TEXT NOT NULL UNIQUE,
	given_name TEXT NOT NULL,
	family_name TEXT NOT NULL,
	image_url TEXT NOT NULL,
	CONSTRAINT email_not_empty CHECK (email <> ''),
	CONSTRAINT given_name_not_empty CHECK (given_name <> ''),
	CONSTRAINT family_name_not_empty CHECK (family_name <> ''),
	CONSTRAINT image_not_empty CHECK (image_url <> '')
);

CREATE TABLE profiles (
	id SERIAL NOT NULL PRIMARY KEY,
	user_id INTEGER NOT NULL,
	gender TEXT NOT NULL,
	age INTEGER NOT NULL,
	target_gender TEXT NOT NULL,
	age_limit_min INTEGER DEFAULT 18,
	age_limit_max INTEGER DEFAULT 30,
	FOREIGN KEY (user_id) REFERENCES users(id),
	CONSTRAINT gender_not_empty CHECK (gender <> ''),
	CONSTRAINT age_correct CHECK (age > 14 AND age <= 120)
);


CREATE TABLE images (
	id SERIAL NOT NULL PRIMARY KEY,
	profile_id INTEGER NOT NULL,
	image_url TEXT NOT NULL,
	FOREIGN KEY (profile_id) REFERENCES profiles(id),
	CONSTRAINT image_not_empty CHECK (image_url <> '')
);


CREATE TABLE connections (
	id SERIAL NOT NULL PRIMARY KEY,
	user_from INTEGER NOT NULL,
	user_to INTEGER NOT NULL,
	status TEXT NOT NULL
);

CREATE TABLE messages (
	id SERIAL NOT NULL PRIMARY KEY,
	sender INTEGER NOT NULL,
	connection_id INTEGER NOT NULL,
	message TEXT NOT NULL,
	time_stamp TIMESTAMP NOT NULL,
	FOREIGN KEY (connection_id) REFERENCES connections(id),
	CONSTRAINT message_not_empty CHECK (message <> '')
);