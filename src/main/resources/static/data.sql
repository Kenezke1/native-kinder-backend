INSERT INTO users (email, given_name, family_name, image_url) VALUES
    ('kinder-native@gmail.com', 'János', 'Kinder', 'image.com/images'), --1
    ('hegedus.csanad96@gmail.com', 'Csanád', 'Hegedűs', 'https://starschanges.com/wp-content/uploads/2016/04/blake-lively-celebrity-weight-height-and-birthDate.jpg'), --2
    ('herczeg.kenya2@gmail.com', 'Kenéz', 'Herczeg', 'image.com/kenez'), --3
    ('noProfile@gmail.com', 'NO', 'PROFILE', 'image.com/no_proifle'); --4


INSERT INTO profiles (user_id,gender,birth_date,target_gender,age_limit_min,age_limit_max) VALUES
( 1,'MALE',50,'FEMALE',30,40 ), --1
( 2,'MALE',21,'FEMALE', 18,22 ), --2
( 3,'MALE',20,'FEMALE',18,22 ); --3

INSERT INTO images (profile_id,image_url) VALUES
(2,'image_url.com/url/csanad'), --1
(3,'image_url.com/url/kenez'); --2


INSERT INTO connections (user_from,user_to,status) VALUES
(1,2,'TRUE'), --1
(2,1,'FALSE'), --2
(3,2,'TRUE'), --3
(2,3,'TRUE'); --4

INSERT INTO messages (sender,receiver,message) VALUES
(2,3,'HElÓ'),
(3,2,'CSÁ');


