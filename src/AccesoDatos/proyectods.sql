DROP TABLE IF EXISTS USUARIO, ACCESO, CONVOCATORIA, ASPIRANTECONVOCATORIA CASCADE;
DROP TABLE IF EXISTS Aspirante;

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





CREATE TABLE CONVOCATORIA (

    codigo varchar(10) NOT NULL PRIMARY KEY,
    nombre varchar(50) NOT NULL,
    descripcion varchar(1000) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_cierre DATE NOT NULL,
    estado varchar(20) NOT NULL,
    creador varchar(20) NOT NULL,


    CONSTRAINT creador_fk FOREIGN KEY (creador)
    REFERENCES ACCESO (username)

);



CREATE TABLE Aspirante (

identificacion varchar (20) PRIMARY KEY,
tipo_id varchar (50) NOT NULL,
p_nombre varchar (10) NOT NULL,
s_nombre varchar (10),
p_apellido varchar (10) NOT NULL,
s_apellido varchar (10),
municipio_trabaja varchar (20) NOT NULL,
sexo varchar (10) NOT NULL,
jornada varchar (50) NOT NULL,
lugar_residencia varchar (50),
fecha_nacimiento varchar(10) NOT NULL,
lugar_nacimiento varchar (50) NOT NULL,
tel varchar (20),
estado bool NOT NULL
);

CREATE TABLE AspiranteConvocatoria(
	identificacion varchar (20) NOT NULL,
	codigo varchar (20) NOT NULL,
	puntajetotal int NOT NULL,
	calificado bool NOT NULL,

	CONSTRAINT apirante_convocatoria_pk PRIMARY KEY (identificacion, codigo), 

	CONSTRAINT identificacion_fk FOREIGN KEY (identificacion)
        REFERENCES Aspirante (identificacion),

	CONSTRAINT codigo_fk FOREIGN KEY (codigo)
        REFERENCES Convocatoria (codigo)
);




INSERT INTO USUARIO VALUES ('1', 'Cedula Ciudadania', 'kellys', 'andrea', 'santa', 'gutierrez', true, 'Administrador');


INSERT INTO USUARIO VALUES ('2', 'Cedula Ciudadania', 'andre', 'fabia', 'lopez', 'gutierrez', true, 'Digitador');

INSERT INTO USUARIO VALUES ('3', 'Cedula Ciudadania', 'jhon', 'will', 'smith', 'gutierrez', true, 'Supervisor');


INSERT INTO ACCESO VALUES ('kellys', 'kellys', false , '1');
INSERT INTO ACCESO VALUES ('andre', 'andre', false , '2');
INSERT INTO ACCESO VALUES ('jhon', 'jhon', false , '3');

INSERT INTO CONVOCATORIA VALUES('convo-1',  'convocatoria-1', 'la convocatoria-1', '2014/11/28', '2015/11/28', 'abierta', 'kellys');


