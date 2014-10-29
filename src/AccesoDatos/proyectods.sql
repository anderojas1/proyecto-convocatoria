DROP TABLE IF EXISTS USUARIO;

CREATE TABLE USUARIO (
identificacion varchar(20) NOT NULL,
tipo_id varchar (20) NOT NULL,
P_nombre varchar (10) NOT NULL,
S_nombre varchar (10),
p_apellido varchar (10) NOT NULL,
S_apellido varchar (10),
username varchar (20) NOT NULL,
password varchar (30) NOT NULL,
estado bool NOT NULL,
empleo bool NOT NULL,
cargo varchar (20) NOT NULL,

CONSTRAINT usuario_pk PRIMARY KEY (identificacion, username)

);
