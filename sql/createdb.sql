DROP TABLE APP.ADDRESS IF EXISTS;
CREATE TABLE APP.ADDRESS (

	ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT ADDRESS_PK PRIMARY KEY,
	PLZ VARCHAR(10),
	GKZ VARCHAR(10),
	STR VARCHAR(255),
	NRV VARCHAR(10),
	NRB VARCHAR(10),
	STG VARCHAR(10),
	TOP VARCHAR(10),
	ORT VARCHAR(255),
	POL VARCHAR(255)

);