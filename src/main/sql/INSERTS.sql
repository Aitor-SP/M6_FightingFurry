CREATE TABLE carta
(
	id_carta integer PRIMARY KEY,
	nombre character varying(30) NOT NULL,
	descripcion character varying(30),
	imagen character varying(30) NOT NULL,
	coste_mana integer NOT NULL
);


CREATE TABLE personaje
(
	id_personaje integer PRIMARY KEY,
	nombre character varying(30) NOT NULL,
	vida integer NOT NULL,
	mana integer NOT NULL,
	sprite character varying(30) NOT NULL,
	categoria character varying(30) NOT NULL
);


CREATE TABLE mazo
(
	id_mazo integer PRIMARY KEY,
	fk_personaje integer REFERENCES Personaje(id_personaje),
	fk_carta integer REFERENCES Carta(id_carta)
);


CREATE TABLE mano
(
    id_mano integer PRIMARY KEY,
	fk_personaje integer REFERENCES Personaje(id_personaje),
	fk_carta integer REFERENCES Carta(id_carta)
);

CREATE TABLE ataque
(
	valor_ataque integer NOT NULL
) INHERITS (Carta);


CREATE TABLE defensa
(
	valor_defensa integer NOT NULL
) INHERITS (Carta);


CREATE TABLE curacion
(
	valor_curacion integer NOT NULL
) INHERITS (Carta);


CREATE TABLE especial
(
	valor_especial integer NOT NULL
) INHERITS (Carta);


