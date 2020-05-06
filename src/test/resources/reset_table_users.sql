drop table users;

create table users
(
	id serial not null
		constraint users_pk
			primary key,
	login varchar(100) not null,
	password varchar(100),
	email varchar(100),
	reg_date timestamp
);

create unique index users_email_uindex
	on users (email);
