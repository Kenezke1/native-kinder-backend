INSERT INTO users (email, given_name, family_name, image_url) VALUES
    ('kinder-native@gmail.com', 'János', 'Kinder', 'https://d2m3klzcmjgreb.cloudfront.net/wp-content/uploads/2016/12/51i-bj8s3vl-656x349.jpg'), --1
    ('hegedus.csanad96@gmail.com', 'Csanád', 'Hegedűs', 'https://starschanges.com/wp-content/uploads/2016/04/blake-lively-celebrity-weight-height-and-birthDate.jpg'), --2
    ('herczeg.kenya2@gmail.com', 'Kenéz', 'Herczeg', 'http://www.viranyosklinika.hu/wp-content/uploads/2015/02/horvath-kenez-225x272.jpg'), --3
    ('noProfile@gmail.com', 'NO', 'PROFILE', 'image.com/no_proifle'), --4
    ('linda.malinda@gmail.com', 'Linda', 'Osvald', 'https://pbs.twimg.com/profile_images/741740319176151040/oxeiYuBH.jpg'), --5
    ('krista.novona@gmail.com', 'Krista', 'Novona', 'https://pbs.twimg.com/profile_images/646723529698844673/NkzUwnr3_400x400.jpg'), --6
    ('kristen.stewart@gmail.com', 'Kristen', 'Stewart', 'https://images.hellogiggles.com/uploads/2016/11/11061339/4202612-kristen-stewart-2009-twilight-new-moon-normal5.4.jpg'), --7
    ('jennifer.lawrence@gmail.com', 'Jennifer', 'Lawrence', 'https://static.independent.co.uk/s3fs-public/thumbnails/image/2015/12/16/09/jenniferlawrence.jpg?w968'); --8


INSERT INTO profiles (user_id,gender,birth_date,target_gender,age_limit_min,age_limit_max) VALUES
    (1, 'MALE', '1950-01-01T23:00:00.000Z', 'FEMALE', 30, 40), --1
    (2, 'MALE', '1996-11-12T23:00:00.000Z', 'FEMALE', 18, 22), --2
    (3, 'MALE', '1998-07-23T23:00:00.000Z', 'FEMALE', 18, 22), --3
    (4, 'FEMALE', '1998-07-23T23:00:00.000Z', 'MALE', 18, 22), --4
    (5, 'FEMALE', '1998-07-23T23:00:00.000Z', 'MALE', 18, 22), --5
    (6, 'FEMALE', '1998-07-23T23:00:00.000Z', 'MALE', 18, 22), --6
    (7, 'FEMALE', '1998-07-23T23:00:00.000Z', 'MALE', 18, 22), --7
    (8, 'FEMALE', '1998-07-23T23:00:00.000Z', 'MALE', 18, 22); --8

INSERT INTO images (profile_id,image_url) VALUES
    (2, 'image_url.com/url/csanad'), --1
    (3, 'image_url.com/url/kenez'); --2


INSERT INTO connections (user_from,user_to,status) VALUES
    (1, 2, 'LEFT'), --1
    (2, 1, 'RIGHT'), --2
    (3, 2, 'RIGHT'), --3
    (2, 3, 'RIGHT'), --4
    (3, 1, 'RIGHT'), --5
    (1, 3, 'RIGHT'), --6
    (2, 4, 'LEFT'), --7
    (4, 2, 'LEFT'), --8
    (2, 5, 'RIGHT'), --9
    (5, 2, 'RIGHT'), --10
    (2, 6, 'RIGHT'), --11
    (6, 2, 'RIGHT'), --12
    (2, 7, 'RIGHT'), --13
    (7, 2, 'SUPER'), --14
    (2, 8, 'RIGHT'), --15
    (8, 2, 'RIGHT'); --16

INSERT INTO messages (connection_id,sender,message,time_stamp) VALUES
    (9,5,'HElÓ',1538642555942),
    (9,2,'CSÁ',1538642555946),
    (11,2,'ÖÖÖ Hi!',1538642555901);






