/*DROP TABLE IF EXISTS USUARIO, ACCESO, CONVOCATORIA CASCADE;

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

*/

DROP TABLE IF EXISTS CONVOCATORIA CASCADE;

CREATE TABLE CONVOCATORIA (

    codigo varchar(10) NOT NULL PRIMARY KEY,
    nombre varchar(50) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_cierre DATE NOT NULL,
    estado varchar(20) NOT NULL,
    creador varchar(20) NOT NULL,

    CONSTRAINT creador_fk FOREIGN KEY (creador)
    REFERENCES ACCESO (username)

);