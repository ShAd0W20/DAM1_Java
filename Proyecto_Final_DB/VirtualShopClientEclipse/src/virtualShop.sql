--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: bills; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bills (
    userid character varying(9) NOT NULL,
    billid character varying(20) NOT NULL,
    billdate date DEFAULT CURRENT_DATE NOT NULL
);


ALTER TABLE public.bills OWNER TO postgres;

--
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id character varying(9) NOT NULL,
    name character varying(20) NOT NULL,
    stock integer NOT NULL,
    price double precision NOT NULL,
    iva integer NOT NULL
);


ALTER TABLE public.products OWNER TO postgres;

--
-- Name: shoppingcart; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.shoppingcart (
    productid character varying(9) NOT NULL,
    productquantity integer NOT NULL,
    billid character varying(20) NOT NULL
);


ALTER TABLE public.shoppingcart OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    dni character varying(9) NOT NULL,
    name character varying(10) NOT NULL,
    password character varying(255) NOT NULL,
    email character varying(100) NOT NULL,
    phone character varying(9) NOT NULL,
    address character varying(120) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Data for Name: bills; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bills (userid, billid, billdate) FROM stdin;
49184487E	49184487E42	2022-05-26
49184487E	49184487E8076	2022-05-26
49184487E	49184487E1157	2022-05-26
49184487E	49184487E2661	2022-05-26
49184487E	49184487E8525	2022-05-26
49184487E	49184487E865	2022-05-26
49184487E	49184487E8382	2022-05-26
49184487E	49184487E819	2022-05-26
99689848M	99689848M9974	2022-05-26
49184487E	49184487E4058	2022-05-26
49184487E	49184487E6950	2022-05-26
49184487E	49184487E7070	2022-05-26
89261392W	89261392W9478	2022-05-26
89261392W	89261392W2058	2022-05-26
89261392W	89261392W4172	2022-05-26
\.


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.products (id, name, stock, price, iva) FROM stdin;
PCP1	Rape	13	24	10
PRC1	Pechuga	5	1.2	5
PRF1	Pera	16	0.5	9
PRF2	Manzana	3	0.2	3
PRL1	Leche	20	2	8
PRL2	Yogur	9	0.8	4
PRP2	Salmon	7	2.3	12
PRF3	Piña	5	1.3	15
PRC2	Ternera	32	5.3	21
PRL3	Queso de Cabra	12	1.3	13
\.


--
-- Data for Name: shoppingcart; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.shoppingcart (productid, productquantity, billid) FROM stdin;
PRF2	10	49184487E42
PRF1	2	49184487E8076
PCP1	4	49184487E1157
PRC1	7	49184487E2661
PRF2	3	49184487E8382
PRF1	3	49184487E8382
PCP1	4	49184487E819
PRF2	5	99689848M9974
PCP1	1	99689848M9974
PCP1	4	49184487E4058
PRC1	3	49184487E6950
PRF2	2	49184487E7070
PCP1	4	89261392W9478
PRF2	5	89261392W2058
PRC1	2	89261392W4172
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (dni, name, password, email, phone, address) FROM stdin;
49184487E	Pol	$2y$10$DchcHnOM.vgKiQjqC8zbF./uN2JWyYw4yEXEcMM0YGloK121Apn7O	pol@gmail.com	678436798	Av. Meridiana 65
99689848M	Pepe	$2y$10$MECHLRqa/xmHvwDW.p5teeVfe2aoqDPF4rI26v5GEkb7A6uR4eJSu	pepe@pepe.com	678543246	Av. Mi casita 22
89261392W	Irene	$2y$10$fF3ckGiF3CUWsRaNurQxlecL1PHU/dQGWQQ0r4xVPub4wmJOwSXRm	irene12@gmail.com	634588164	Madrid
79886959R	Marta	$2y$10$MECHLRqa/xmHvwDW.p5teeVfe2aoqDPF4rI26v5GEkb7A6uR4eJSu	mmarta@xtec.cat	697202875	Puerta del sol,15
\.


--
-- Name: bills billid; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT billid UNIQUE (billid);


--
-- Name: bills bills_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bills
    ADD CONSTRAINT bills_pkey PRIMARY KEY (userid, billid);


--
-- Name: products product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: users user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT user_pkey PRIMARY KEY (dni);


--
-- Name: shoppingcart FK_bill_bill_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shoppingcart
    ADD CONSTRAINT "FK_bill_bill_id" FOREIGN KEY (billid) REFERENCES public.bills(billid) NOT VALID;


--
-- Name: shoppingcart FK_product_product_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shoppingcart
    ADD CONSTRAINT "FK_product_product_id" FOREIGN KEY (productid) REFERENCES public.products(id);


--
-- PostgreSQL database dump complete
--

