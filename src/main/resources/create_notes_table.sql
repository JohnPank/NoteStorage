create table notes
(
	id serial not null
		constraint notes_pk
			primary key,
	user_id int not null,
	content text,
	creation_date timestamp,
	ident_icon bytea
);