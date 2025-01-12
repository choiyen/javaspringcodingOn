create database codingon default character set utf8 default collate utf8_general_ci;
use codingon;

create table users (
	id bigint auto_increment primary key,
    username varchar(50) not null,
    email varchar(100) not null,
    created_at timestamp default current_timestamp
);

insert into users(username, email) values('john_doe', 'john.doe@example.com'),
										 ('jane_smith', 'jane_smith@example.com'),
                                         ('bob_johnson', 'bob_johnson@example.com');


