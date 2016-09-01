create table if not exists seguridad."luna_sistema_solar"
(
	"id" bigint  NOT NULL ,
	"version_row" timestamp with time zone NOT NULL default current_timestamp ,
	"id_tipo_valoracion" bigint not null default (1) ,
	"codigo" varchar(50) not null default ' ' ,
	"nombre" varchar(150) not null default ' ' ,
	"descripcion" varchar(150) not null default ' ' ,
	constraint PK_Xluna_sistema_solar primary key (id)
);

/*BLOQUE*/


/*FALTA IMPLEMENTAR GetDropIndicesTablasClases()*/



create index luna_sistema_solar_FK_IdTipoValoracion on seguridad."luna_sistema_solar"
(
	"id_tipo_valoracion"
);

/*BLOQUE*/



alter table seguridad."luna_sistema_solar" add constraint FK_Xluna_sistema_solar_tipo_valoracion foreign key ("id_tipo_valoracion")
references seguridad."tipo_valoracion" (id);