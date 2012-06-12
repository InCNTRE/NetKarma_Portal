CREATE DATABASE portal_db;

use portal_db;

CREATE TABLE experiments
   (exp_id int not null primary key auto_increment,
   name varchar(30) not null,
   creator varchar(30),
   creator_email varchar(60),
   creation_date datetime);


CREATE TABLE handles
    (hand_id int not null primary key auto_increment,
     handle_name varchar(30),
     handle_type varchar(3),
     exp_id int,
     FOREIGN KEY (exp_id) REFERENCES experiments(exp_id));

GRANT ALL PRIVILEGES ON portal_db.* TO 'karma'@'localhost';
     
