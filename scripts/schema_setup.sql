create table movie (
movie_id INT UNSIGNED primary key,
movieName varchar(100),
duration INT,
director varchar(100),
contentRating varchar(50),
genre varchar(50),
numberOfRatings INT,
sumOfRatings INT,
description TEXT
);

create table user (
user_id INT UNSIGNED primary key,
userName varchar(50),
email varchar(100),
password varchar(30),
dateOfJoining DATE,
);

create table review (
user_id INT UNSIGNED NOT NULL,
movie_id INT UNSIGNED NOT NULL,
rating INT,
review TEXT,
reviewDateTime DATE,
primary key(movie_id, user_id)
);
