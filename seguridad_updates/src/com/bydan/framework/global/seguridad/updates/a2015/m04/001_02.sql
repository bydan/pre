create table seguridad."update"
(
	"id" bigint  NOT NULL ,
	"version_row" timestamp with time zone NOT NULL default current_timestamp ,
	"id_anio" bigint not null default (1) ,
	"id_mes" bigint not null default (1) ,
	"codigo" varchar(50) not null default ' ' ,
	"descripcion" varchar(250) not null default ' ' ,
	"fecha" date not null default ('1900-01-01') ,
	"orden" int not null default (0) ,
	"ejecutado" bool not null default (false) ,
	"esta_activo" bool not null default (false) ,
	constraint PK_Xupdate primary key (id)
);

/*CREATE TABLE update_detalle UpdateDetalle*/
create table seguridad."update_detalle"
(
	"id" bigint  NOT NULL ,
	"version_row" timestamp with time zone NOT NULL default current_timestamp ,
	"id_update" bigint not null default (1) ,
	"id_anio" bigint not null default (1) ,
	"id_mes" bigint not null default (1) ,
	"codigo" varchar(50) not null default ' ' ,
	"descripcion" varchar(200) not null default ' ' ,
	"fecha" date not null default ('1900-01-01') ,
	"orden" int not null default (0) ,
	"ejecutado" bool not null default (false) ,
	"esta_activo" bool not null default (false) ,
	constraint PK_Xupdate_detalle primary key (id)
);


/*FALTA IMPLEMENTAR GetDropIndicesTablasClases()*/



create index update_FK_IdAnio on seguridad."update"
(
	"id_anio"
);

create index update_FK_IdMes on seguridad."update"
(
	"id_mes"
);

create index update_detalle_FK_IdAnio on seguridad."update_detalle"
(
	"id_anio"
);

create index update_detalle_FK_IdMes on seguridad."update_detalle"
(
	"id_mes"
);

create index update_detalle_FK_IdUpdate on seguridad."update_detalle"
(
	"id_update"
);



alter table seguridad."update" add constraint FK_Xupdate_anio foreign key ("id_anio")
references seguridad."anio" (id);


alter table seguridad."update" add constraint FK_Xupdate_mes foreign key ("id_mes")
references seguridad."mes" (id);


alter table seguridad."update_detalle" add constraint FK_Xupdate_detalle_update foreign key ("id_update")
references seguridad."update" (id);


alter table seguridad."update_detalle" add constraint FK_Xupdate_detalle_anio foreign key ("id_anio")
references seguridad."anio" (id);


alter table seguridad."update_detalle" add constraint FK_Xupdate_detalle_mes foreign key ("id_mes")
references seguridad."mes" (id);