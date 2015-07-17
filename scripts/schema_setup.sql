create table movie (
movie_id INT UNSIGNED primary key,
movieName varchar(100),
duration INT,
director varchar(100),
contentRating varchar(50) default 'U',
genre varchar(50) default 'Drama',
numberOfRatings INT default 0,
sumOfRatings INT default 0,
description TEXT
);

create table user (
user_id INT UNSIGNED primary key,
userName varchar(50),
email varchar(100),
password varchar(30),
dateOfJoining DATE
);

create table review (
user_id INT UNSIGNED NOT NULL references user(user_id),
movie_id INT UNSIGNED NOT NULL references movie(movie_id),
rating INT,
review TEXT,
reviewDateTime DATE,
primary key(movie_id, user_id)
);
