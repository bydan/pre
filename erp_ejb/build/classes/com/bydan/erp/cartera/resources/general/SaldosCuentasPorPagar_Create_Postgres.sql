create temporary table "saldos_cuentas_por_pagar"
(
	"id" bigserial  NOT NULL ,
	"version_row" timestamp with time zone NOT NULL default current_timestamp ,
	"codigo" varchar(50) not null default ' ' ,
	"nombre_completo" varchar(150) not null default ' ' ,
	"debito_mone_local" decimal(18,2) not null default (0.0) ,
	"credito_mone_local" decimal(18,2) not null default (0.0) ,
	"saldo_anterior" decimal(18,2) not null default (0.0) ,
	"saldo_debito" decimal(18,2) not null default (0.0) ,
	"saldo_credito" decimal(18,2) not null default (0.0) ,
	constraint PK_Xsaldos_cuentas_por_pagar primary key (id)
)on commit drop;