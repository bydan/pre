/*CREATE TABLE planeta_sistema_solar PlanetaSistemaSolar*/
create table seguridad."planeta_sistema_solar"
(
	"id" bigint  NOT NULL ,
	"version_row" timestamp with time zone NOT NULL default current_timestamp ,
	"id_tipo_valoracion" bigint not null default (1) ,
	"codigo" varchar(50) not null default ' ' ,
	"nombre" varchar(150) not null default ' ' ,
	"descripcion" varchar(150) not null default ' ' ,
	constraint PK_Xplaneta_sistema_solar primary key (id)
);

/*BLOQUE*/

create index planeta_sistema_solar_BusquedaPorCodigo on seguridad."planeta_sistema_solar"
(
	"codigo"
);

/*BLOQUE*/

create index planeta_sistema_solar_FK_IdTipoValoracion on seguridad."planeta_sistema_solar"
(
	"id_tipo_valoracion"
);

/*BLOQUE*/



alter table seguridad."planeta_sistema_solar" add constraint FK_Xplaneta_sistema_solar_tipo_valoracion foreign key ("id_tipo_valoracion")
references seguridad."tipo_valoracion" (id);



