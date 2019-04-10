--
-- PostgreSQL database dump
--

-- Dumped from database version 10.7 (Ubuntu 10.7-1.pgdg18.04+1)
-- Dumped by pg_dump version 10.7 (Ubuntu 10.7-1.pgdg18.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: maps2go; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE maps2go WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'es_MX.UTF-8' LC_CTYPE = 'es_MX.UTF-8';


ALTER DATABASE maps2go OWNER TO postgres;

\connect maps2go

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: comentario; Type: TABLE; Schema: public; Owner: maave
--

CREATE TABLE public.comentario (
    num_comentario integer NOT NULL,
    contenido text NOT NULL,
    likes integer NOT NULL,
    dislikes integer NOT NULL,
    num_marcador integer NOT NULL,
    id_usuario integer NOT NULL
);


ALTER TABLE public.comentario OWNER TO maave;

--
-- Name: comentario_num_comentario_seq; Type: SEQUENCE; Schema: public; Owner: maave
--

CREATE SEQUENCE public.comentario_num_comentario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comentario_num_comentario_seq OWNER TO maave;

--
-- Name: comentario_num_comentario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: maave
--

ALTER SEQUENCE public.comentario_num_comentario_seq OWNED BY public.comentario.num_comentario;


--
-- Name: marcador; Type: TABLE; Schema: public; Owner: maave
--

CREATE TABLE public.marcador (
    num_marcador integer NOT NULL,
    descripcion text NOT NULL,
    datos_utiles text,
    longitud double precision NOT NULL,
    latitud double precision NOT NULL,
    tipo_tema text NOT NULL
);


ALTER TABLE public.marcador OWNER TO maave;

--
-- Name: marcador_num_marcador_seq; Type: SEQUENCE; Schema: public; Owner: maave
--

CREATE SEQUENCE public.marcador_num_marcador_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.marcador_num_marcador_seq OWNER TO maave;

--
-- Name: marcador_num_marcador_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: maave
--

ALTER SEQUENCE public.marcador_num_marcador_seq OWNED BY public.marcador.num_marcador;


--
-- Name: tema; Type: TABLE; Schema: public; Owner: maave
--

CREATE TABLE public.tema (
    tipo_tema text NOT NULL,
    color text NOT NULL,
    id_usuario integer NOT NULL
);


ALTER TABLE public.tema OWNER TO maave;

--
-- Name: usuario; Type: TABLE; Schema: public; Owner: maave
--

CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    nombre_usuario text NOT NULL,
    contrasenia text NOT NULL,
    correo text NOT NULL,
    rol integer NOT NULL
);


ALTER TABLE public.usuario OWNER TO maave;

--
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: maave
--

CREATE SEQUENCE public.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_usuario_seq OWNER TO maave;

--
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: maave
--

ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;


--
-- Name: comentario num_comentario; Type: DEFAULT; Schema: public; Owner: maave
--

ALTER TABLE ONLY public.comentario ALTER COLUMN num_comentario SET DEFAULT nextval('public.comentario_num_comentario_seq'::regclass);


--
-- Name: marcador num_marcador; Type: DEFAULT; Schema: public; Owner: maave
--

ALTER TABLE ONLY public.marcador ALTER COLUMN num_marcador SET DEFAULT nextval('public.marcador_num_marcador_seq'::regclass);


--
-- Name: usuario id_usuario; Type: DEFAULT; Schema: public; Owner: maave
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);


--
-- Data for Name: comentario; Type: TABLE DATA; Schema: public; Owner: maave
--

COPY public.comentario (num_comentario, contenido, likes, dislikes, num_marcador, id_usuario) FROM stdin;
2	1er comentario	0	0	1	7
3	1er comentario	0	0	1	7
4	otro comentario	0	0	1	8
5	otro comentario	0	0	1	8
1	asdfghjklñ{	0	0	1	7
\.


--
-- Data for Name: marcador; Type: TABLE DATA; Schema: public; Owner: maave
--

COPY public.marcador (num_marcador, descripcion, datos_utiles, longitud, latitud, tipo_tema) FROM stdin;
1	contaminacion alta	causa:autos	-105.437918999999994	25.4279130000000002	Contaminacion
2	contaminacion extra-alta	causa:autos fabricas	-99.0219009999999997	19.3365609999999997	Contaminacion
3	Goshi Express	En Goshi Exprés sirven un buffet de sushi y ramen buenísimo, por solo $115.	-99.1798969999999969	19.3712680000000006	Bufettes por menos de 200 pesos
4	Concepto Pizaa	En el buffet se sirven 38 diferentes sabores de pizza, entre saladas y dulces	-99.1778419999999983	19.3748460000000016	Bufettes por menos de 200 pesos
\.


--
-- Data for Name: tema; Type: TABLE DATA; Schema: public; Owner: maave
--

COPY public.tema (tipo_tema, color, id_usuario) FROM stdin;
Contaminacion	http://maps.google.com/mapfiles/ms/micons/blue-dot.png	6
Bufettes por menos de 200 pesos	http://maps.google.com/mapfiles/ms/micons/yellow-dot.png	6
Harry Potter	2200ff	13
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: maave
--

COPY public.usuario (id_usuario, nombre_usuario, contrasenia, correo, rol) FROM stdin;
2	maave	maave	maave@mail.com	1
6	vale	contraseña	vale@mail.com	2
8	vale12	contraseña	vale.garcia.landa@gmail.com	3
9	angela	iruXe009QUP	angelajanin@gmail.com	2
11	Daniela	123456	danycape19@gmail.com	3
13	Jonathan	iCcmK4FMMtn	jobaji09@gmail.com	2
7	mauricio666	contraseña	maudrummer36@gmail.com	3
\.


--
-- Name: comentario_num_comentario_seq; Type: SEQUENCE SET; Schema: public; Owner: maave
--

SELECT pg_catalog.setval('public.comentario_num_comentario_seq', 6, true);


--
-- Name: marcador_num_marcador_seq; Type: SEQUENCE SET; Schema: public; Owner: maave
--

SELECT pg_catalog.setval('public.marcador_num_marcador_seq', 4, true);


--
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: maave
--

SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 13, true);


--
-- Name: tema color_unique; Type: CONSTRAINT; Schema: public; Owner: maave
--

ALTER TABLE ONLY public.tema
    ADD CONSTRAINT color_unique UNIQUE (color);


--
-- Name: comentario comentario_pk; Type: CONSTRAINT; Schema: public; Owner: maave
--

ALTER TABLE ONLY public.comentario
    ADD CONSTRAINT comentario_pk PRIMARY KEY (num_comentario);


--
-- Name: usuario correo_unique; Type: CONSTRAINT; Schema: public; Owner: maave
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT correo_unique UNIQUE (correo);


--
-- Name: marcador marcador_pk; Type: CONSTRAINT; Schema: public; Owner: maave
--

ALTER TABLE ONLY public.marcador
    ADD CONSTRAINT marcador_pk PRIMARY KEY (num_marcador);


--
-- Name: tema tema_pk; Type: CONSTRAINT; Schema: public; Owner: maave
--

ALTER TABLE ONLY public.tema
    ADD CONSTRAINT tema_pk PRIMARY KEY (tipo_tema);


--
-- Name: usuario usuario_pk; Type: CONSTRAINT; Schema: public; Owner: maave
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY (id_usuario);


--
-- Name: comentario comentario_fk_marcador; Type: FK CONSTRAINT; Schema: public; Owner: maave
--

ALTER TABLE ONLY public.comentario
    ADD CONSTRAINT comentario_fk_marcador FOREIGN KEY (num_marcador) REFERENCES public.marcador(num_marcador) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: comentario comentario_fk_usuario; Type: FK CONSTRAINT; Schema: public; Owner: maave
--

ALTER TABLE ONLY public.comentario
    ADD CONSTRAINT comentario_fk_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: marcador marcador_fk; Type: FK CONSTRAINT; Schema: public; Owner: maave
--

ALTER TABLE ONLY public.marcador
    ADD CONSTRAINT marcador_fk FOREIGN KEY (tipo_tema) REFERENCES public.tema(tipo_tema) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: tema tema_fk; Type: FK CONSTRAINT; Schema: public; Owner: maave
--

ALTER TABLE ONLY public.tema
    ADD CONSTRAINT tema_fk FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

