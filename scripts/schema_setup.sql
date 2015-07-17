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
