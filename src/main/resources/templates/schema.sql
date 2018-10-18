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
	birth_date TEXT NOT NULL,
	target_gender TEXT NOT NULL,
	age_limit_min INTEGER NOT NULL,
	age_limit_max INTEGER NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users(id),
	CONSTRAINT gender_not_empty CHECK (gender <> ''),
	CONSTRAINT birth_date_not_empty CHECK (birth_date <> '')
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
	time_stamp BIGINT NOT NULL ,
	CONSTRAINT message_not_empty CHECK (message <> ''),
	FOREIGN KEY (sender) REFERENCES users(id),
	FOREIGN KEY (connection_id) REFERENCES connections(id)

);
