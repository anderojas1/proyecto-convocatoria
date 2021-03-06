DROP TABLE IF EXISTS USUARIO, ACCESO, CONVOCATORIA, ASPIRANTECONVOCATORIA, ASPIRANTE, ASPIRANTE_HABLA, IDIOMA, CONOCIMIENTOS_ESPECIFICOS, DocumentosPrePos, IDIOMA, FormacionTic, CONOCIMIENTOS_ESPECIFICOS, EXPFORMADORTIC CASCADE;


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

    CONSTRAINT usuario_fk FOREIGN KEY (identificacion)
    REFERENCES USUARIO (identificacion)

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
	codigo varchar (10) NOT NULL,
	puntajetotal double precision NOT NULL,
	calificado bool NOT NULL,

	CONSTRAINT apirante_convocatoria_pk PRIMARY KEY (identificacion, codigo), 

	CONSTRAINT identificacion_fk FOREIGN KEY (identificacion)
        REFERENCES Aspirante (identificacion),

	CONSTRAINT codigo_fk FOREIGN KEY (codigo)
        REFERENCES CONVOCATORIA (codigo)
);

CREATE TABLE DocumentosPrePos(

id_aspirante VARCHAR(20) NOT NULL,
doctor VARCHAR(100) NOT NULL,
doctorTic VARCHAR(100) NOT NULL,
maestria VARCHAR(100) NOT NULL,
maestriaTic VARCHAR(100) NOT NULL,
especia VARCHAR(100) NOT NULL,
especiaTic VARCHAR(100) NOT NULL,
licen VARCHAR(100) NOT NULL,
puntaje DOUBLE PRECISION NOT NULL,
cod_convocatoria VARCHAR(15) NOT NULL,


CONSTRAINT documentosPrePos_pk PRIMARY KEY (id_aspirante, cod_convocatoria), 

CONSTRAINT aspirante_fk FOREIGN KEY (id_aspirante)
REFERENCES Aspirante (identificacion),

CONSTRAINT cod_convocatoria_fk FOREIGN KEY (cod_convocatoria)
REFERENCES CONVOCATORIA (codigo)

);

CREATE TABLE FormacionTic(
	identificacion VARCHAR(20) NOT NULL,
	codigo_convocatoria varchar(10) NOT NULL,
	titulo VARCHAR(80) NOT NULL,
	consecutivo int NOT NULL,
	soporte VARCHAR(100),
	puntaje int,
	calificado bool NOT NULL,

	CONSTRAINT formacionTic_pk PRIMARY KEY(identificacion, codigo_convocatoria, titulo, consecutivo),

	CONSTRAINT aspirante_fk FOREIGN KEY(identificacion)
	REFERENCES Aspirante(identificacion),

	CONSTRAINT convocatoria_fk FOREIGN KEY(codigo_convocatoria)
	REFERENCES Convocatoria(codigo)
	
);

CREATE TABLE EXPFORMADORTIC(
	identificacion VARCHAR(20) NOT NULL,
	exp_estudiante VARCHAR(80) NOT NULL,
        exp_profesor VARCHAR(80) NOT NULL,
        exp_formador VARCHAR(80) NOT NULL,
	soporte_estudiante VARCHAR(500),
        soporte_profesor VARCHAR(500),
        soporte_formador VARCHAR(500),
	puntaje_estudiante INTEGER NOT NULL,
        puntaje_profesor INTEGER NOT NULL,
        puntaje_formador INTEGER NOT NULL,
        puntaje_total INTEGER NOT NULL,
        cod_convocatoria VARCHAR (10) NOT NULL,

	CONSTRAINT expformadortic_pk PRIMARY KEY(identificacion, cod_convocatoria),

        CONSTRAINT convocatoria_fk FOREIGN KEY(cod_convocatoria)
	REFERENCES Convocatoria(codigo),

	CONSTRAINT aspirante_fk FOREIGN KEY(identificacion)
	REFERENCES Aspirante(identificacion)
        ON UPDATE CASCADE ON DELETE NO ACTION
	
);


CREATE TABLE IDIOMA (

    nombre varchar(30) NOT NULL,
    codigo_idioma char(2) NOT NULL PRIMARY KEY

);


CREATE TABLE ASPIRANTE_HABLA (
    
    id_aspirante varchar(20) NOT NULL,
    cod_idioma char(2) NOT NULL,
    hablar varchar(15) NOT NULL,
    leer varchar(15) NOT NULL,
    escribir varchar(15) NOT NULL,
    puntaje double precision NOT NULL,
    cod_convocatoria VARCHAR(15) NOT NULL,
    escoger boolean NOT NULL,

    CONSTRAINT aspirante_habla_pk PRIMARY KEY (id_aspirante, cod_idioma),

    CONSTRAINT aspirante_fk FOREIGN KEY (id_aspirante)
    REFERENCES ASPIRANTE (identificacion),

    CONSTRAINT cod_idioma_fk FOREIGN KEY (cod_idioma)
    REFERENCES IDIOMA (codigo_idioma),

    CONSTRAINT cod_convocatoria_fk FOREIGN KEY (cod_convocatoria)
    REFERENCES CONVOCATORIA (codigo)
);

CREATE TABLE CONOCIMIENTOS_ESPECIFICOS (

	id_aspirante varchar(20) NOT NULL,
	herram_Ofimatic varchar(10) NOT NULL,
    	herram_Web2 varchar(10) NOT NULL,
    	herram_edic_multi varchar(10) NOT NULL,
    	exp_des_cont_edu_dig varchar(10) NOT NULL,
    	exp_des_lib_dig varchar(10) NOT NULL,
    	exp_proc_elearning varchar(10) NOT NULL, 
    	exp_gest_proy_TIC varchar(10) NOT NULL,
   	exp_des_elemnts_eval_comp varchar(10) NOT NULL,
	puntuacion real NOT NULL,

	CONSTRAINT cono_esp_pk PRIMARY KEY (id_aspirante),

	CONSTRAINT aspirante_fk FOREIGN KEY (id_aspirante)
	REFERENCES ASPIRANTE (identificacion)
	ON UPDATE CASCADE ON DELETE NO ACTION

);


    

INSERT INTO IDIOMA VALUES ('Afrikaans', 'AF'),
('Albanés', 'SQ'),
('Alemán', 'DE'),
('Árabe', 'AR'),
('Bosnio', 'BS'),
('Búlgaro', 'BG'),
('Catalán','CA'),
('Checo', 'CS'),
('Chino', 'ZH'),
('Coreano', 'KO'),
('Croata', 'HR'),
('Danés', 'DA'),
('Español', 'ES'),
('Esperanto','EO'),
('Finlandés', 'FI'),
('Francés', 'FR'),
('Griego', 'EL'),
('Hebreo','HE'),
('Hindu','HI'),
('Holandés','NL'),
('Húngaro','HU'),
('Indonesio','ID'),
('Inglés','EN'),
('Irlandés','GA'),
('Islandés','IS'),
('Italiano','IT'),
('Japonés','JA'),
('Latín','LA'),
('Noruego','NO'),
('Polaco','PL'),
('Portugués','PT'),
('Rumano','RO'),
('Ruso','RU'),
('Serbio','SR'),
('Suajili','SW'),
('Sueco','TL'),
('Tailandés','TH'),
('Turco','TR'),
('Ucraniano','UK');



INSERT INTO USUARIO VALUES ('1', 'Cedula Ciudadania', 'kellys', 'andrea', 'santa', 'gutierrez', true, 'Administrador');


INSERT INTO USUARIO VALUES ('2', 'Cedula Ciudadania', 'andre', 'fabia', 'lopez', 'gutierrez', true, 'Digitador');

INSERT INTO USUARIO VALUES ('3', 'Cedula Ciudadania', 'jhon', 'will', 'smith', 'gutierrez', true, 'Supervisor');


INSERT INTO ACCESO VALUES ('kellys', 'kellys', false , '1');
INSERT INTO ACCESO VALUES ('andre', 'andre', false , '2');
INSERT INTO ACCESO VALUES ('jhon', 'jhon', false , '3');

INSERT INTO CONVOCATORIA VALUES('1',  'convocatoria-1', 'la convocatoria-1', '2014-11-28', '2015-11-28', 'abierta', 'kellys');


