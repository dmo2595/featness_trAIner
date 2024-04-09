create table user
(
    user_id                         integer not null auto_increment primary key,
    username                        varchar(100) not null unique,
    password                        varchar(100) not null,
    nickname                        varchar(50) not null unique,
    height                          integer,
    weight                          integer,
    age                             integer,
    role                            varchar(50),
    spicy_preference                integer,
    meat_consumption                bool,
    taste_preference                varchar(50),
    activity_level                  integer,
    preference_type_food            varchar(50)


);


INSERT INTO user (username, password, nickname, role)
VALUES ('admin_username', 'strong_password', 'Admin', 'admin');