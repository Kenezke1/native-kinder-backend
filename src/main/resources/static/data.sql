INSERT INTO users (email, given_name, family_name, image_url) VALUES
    ('kinder-native@gmail.com', 'János', 'Kinder', 'https://d2m3klzcmjgreb.cloudfront.net/wp-content/uploads/2016/12/51i-bj8s3vl-656x349.jpg'), --1
    ('hegedus.csanad96@gmail.com', 'Csanád', 'Hegedűs', 'https://media.vanityfair.com/photos/564f575b0e42b20e5429f635/master/w_768,c_limit/chris-hemsworth-bruce-weber-january-2016-holiday-cover-vf-05.jpg'), --2
    ('herczeg.kenya2@gmail.com', 'Kenéz', 'Herczeg', 'http://www.viranyosklinika.hu/wp-content/uploads/2015/02/horvath-kenez-225x272.jpg'), --3
    ('mia.khalifa@gmail.com', 'Mia', 'Khalifa', 'https://i2-prod.mirror.co.uk/incoming/article11324932.ece/ALTERNATES/s615b/Mia-Khalifa.jpg'), --4
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
    (2, 'https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTU0ODUwMjQ0NjIwNzI0MDAx/chris-hemsworth-poses-during-a-photo-call-for-thor-ragnarok-on-october-15-2017-in-sydney-australia-photo-by-mark-metcalfe_getty-images-for-disney-square.jpg'), --1
	(2, 'https://www.gannett-cdn.com/-mm-/96cf23d6fa408f3fbc643241338476d3606ab114/c=3-0-2603-1955/local/-/media/2018/05/14/INGroup/Indianapolis/636618613317700528-HEMSWORTHMAIN-1-.jpg?width=534&height=401&fit=crop'), --2
	(2, 'https://www.etonline.com/sites/default/files/styles/max_970x546/public/images/2018-03/chris_hemsworth_gettyimages-902412080_1280.jpg?itok=Tgoov9s6&h=c673cd1c'), --3
	(2, 'https://pixel.nymag.com/imgs/fashion/daily/2017/07/25/Chris-Hemsworth/25-Chris-Hemsworth.w330.h412.jpg'), --4
	(2, 'https://postmediavancouversun2.files.wordpress.com/2018/03/pj9msbjlpr66zliqrltio4-jpg.jpg?quality=80&strip=all&w=840&h=630&crop=1'), --5
    (3, 'image_url.com/url/kenez'); --6


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
    (7, 2, 'RIGHT'), --14
    (2, 8, 'RIGHT'), --15
    (8, 2, 'RIGHT'); --16

INSERT INTO messages (sender,receiver,message) VALUES
    (2,3,'HElÓ'),
    (3,2,'CSÁ');


