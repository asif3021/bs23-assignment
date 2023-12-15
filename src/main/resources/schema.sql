CREATE TABLE IF NOT EXISTS users (
    id int auto_increment not null,
    first_name   varchar(255) not null,
    last_name varchar(255),
    age int,
    primary key (id)
    );

-- insert into users (id, first_name, last_name, age) values
--                                          (1, 'Asif', 'Ahmed', 28);
