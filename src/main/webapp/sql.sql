create table jdbc_member
(
	id varchar2(50),
	pw varchar2(50) not null,
	nick varchar2(50) not null,
	
	constraint jdbc_id_pk primary key(id)
);

