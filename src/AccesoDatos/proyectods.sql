DROP TABLE IF EXISTS USUARIO, ACCESO CASCADE;

CREATE TABLE USUARIO (
identificacion varchar(20) NOT NULL PRIMARY KEY,
tipo_id varchar (20) NOT NULL,
P_nombre varchar (10) NOT NULL,
S_nombre varchar (10),
p_apellido varchar (10) NOT NULL,
S_apellido varchar (10),
empleo bool NOT NULL,
cargo varchar (20) NOT NULL

);

CREATE TABLE ACCESO (

    username varchar(20) NOT NULL PRIMARY KEY,
    password varchar(30) NOT NULL,
    estado bool NOT NULL,
    identificacion varchar(20) NOT NULL,

    CONSTRAINT identificacion_fk FOREIGN KEY (identificacion)
    REFERENCES USUARIO(identificacion)

);
