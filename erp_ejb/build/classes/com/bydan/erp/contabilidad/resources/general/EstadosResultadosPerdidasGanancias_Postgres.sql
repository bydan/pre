select 
	c.codigo,
	c.nombre,
	(select nombre from contabilidad.nivel_cuenta where id=c.id_nivel_cuenta) as nombre_nivel_cuenta,
	0.0 as debito_inicial,
	0.0 as credito_inicial,
	sum(s.debito_inicial - s.credito_inicial) as saldo_inicial
from contabilidad.cuenta_contable c
inner join contabilidad.saldo_contable s on s.id_cuenta_contable=c.id
where 
	c.id_empresa=IDEMPRESA and 
	s.id_ejercicio=ID_EJERCICIO and
	s.id_periodo=ID_PERIODO and
	c.id_nivel_cuenta=ID_NIVEL_CUENTA and
	
	(s.debito_inicial!=0 or s.credito_inicial!=0) and 
	
	(c.id=(select id_cuenta_contable_ingreso from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_ingreso!=null) or 
	 c.id=(select id_cuenta_contable_ingreso1 from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_ingreso1!=null) or 
	 c.id=(select id_cuenta_contable_ingreso2 from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_ingreso2!=null) or 
	 c.id=(select id_cuenta_contable_ingreso3 from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_ingreso3!=null) or

	 c.id=(select id_cuenta_contable_egreso from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_egreso!=null) or
	 c.id=(select id_cuenta_contable_egreso1 from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_egreso1!=null) or
	 c.id=(select id_cuenta_contable_egreso2 from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_egreso2!=null) or
	 c.id=(select id_cuenta_contable_egreso3 from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_egreso3!=null) 
	)	
	

group by c.codigo,
	 c.nombre,
	 c.id_nivel_cuenta

having sum(s.debito_inicial - s.credito_inicial) <> 0


union

select 
	c.codigo,
	c.nombre,
	(select nombre from contabilidad.nivel_cuenta where id=c.id_nivel_cuenta) as nombre_nivel_cuenta,
	s.debito_inicial as debito_inicial,
	s.credito_inicial as credito_inicial,
	0.0 as saldo_inicial
	
from contabilidad.cuenta_contable c
inner join contabilidad.saldo_contable s on s.id_cuenta_contable=c.id
where 
	c.id_empresa=IDEMPRESA and 
	s.id_ejercicio=ID_EJERCICIO and
	s.id_periodo=ID_PERIODO and
	c.id_nivel_cuenta=ID_NIVEL_CUENTA and
	(s.debito_inicial!=0 or s.credito_inicial!=0) and 
	
	(c.id=(select id_cuenta_contable_ingreso from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_ingreso!=null) or 
	 c.id=(select id_cuenta_contable_ingreso1 from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_ingreso1!=null) or 
	 c.id=(select id_cuenta_contable_ingreso2 from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_ingreso2!=null) or 
	 c.id=(select id_cuenta_contable_ingreso3 from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_ingreso3!=null) or

	 c.id=(select id_cuenta_contable_egreso from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_egreso!=null) or
	 c.id=(select id_cuenta_contable_egreso1 from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_egreso1!=null) or
	 c.id=(select id_cuenta_contable_egreso2 from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_egreso2!=null) or
	 c.id=(select id_cuenta_contable_egreso3 from contabilidad.parametro_conta where id_empresa=c.id_empresa and id_cuenta_contable_egreso3!=null) 
	)	
	




