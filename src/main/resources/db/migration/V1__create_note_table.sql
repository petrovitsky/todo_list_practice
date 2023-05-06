CREATE TABLE public.note
(
    id bigserial,
    title character varying(255) NOT NULL,
    content character varying(2048) NOT NULL,
    PRIMARY KEY (id)
);