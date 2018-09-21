INSERT INTO users (email, given_name, family_name, image_url) VALUES
    ('kinder-native@gmail.com', 'János', 'Kinder', 'image.com/images'), --1
    ('csanadH@gmail.com', 'Csanád', 'Hegedűs', 'image.com/csanad'), --2
    ('herczeg.kenya2@gmail.com', 'Kenéz', 'Herczeg', 'image.com/kenez'); --3

INSERT INTO profiles (user_id,gender,age,target_gender) VALUES
( 1,'MALE',50,'FEMALE' ), --1
( 2,'MALE',21,'FEMALE' ), --2
( 3,'MALE',20,'FEMALE' ); --3

INSERT INTO images (profile_id,image_url) VALUES
(1,'image_url.com/url/kinder'), --1
(2,'image_url.com/url/csanad'), --2
(3,'image_url.com/url/kenez'); --3


INSERT INTO connections (user_from,user_to,status) VALUES
(1,2,'TRUE'), --1
(2,1,'FALSE'), --2
(3,2,'TRUE'), --3
(2,3,'TRUE'); --4

INSERT INTO messages (sender,receiver,message,time_stamp) VALUES
(2,3,'HElÓ',null),
(3,2,'CSÁ',null);


