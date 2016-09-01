select 
		(select codigo from contabilidad.cuenta_contable where id=c.id_cuenta_contable)as codigo_cuenta,
		(select nombre from tesoreria.banco where id=(select id_banco from contabilidad.cuenta_contable where id=c.id_cuenta_contable)) as nombre_banco,
		c.numero_cuenta,
		(select nombre from contabilidad.moneda where id=a.id_moneda)as nombre_moneda,
		sum(d.debito_local - d.credito_local) as saldo_anterior,
		0.0 as deposito, 
		0.0 as nc, 
		0.0 as ch_girados, 
		0.0 as nd, 
		c.procedencia,
		c.destino   
		
from contabilidad.asiento_contable a inner join contabilidad.detalle_asiento_contable d
		on d.id_asiento_contable=a.id 
	
inner join tesoreria.cuenta_banco c
		on c.id_cuenta_contable=d.id_cuenta_contable
--where1

group by codigo_cuenta,nombre_banco,numero_cuenta,nombre_moneda,procedencia,destino

union

select 
		(select codigo from contabilidad.cuenta_contable where id=c.id_cuenta_contable)as codigo_cuenta,
		(select nombre from tesoreria.banco where id=(select id_banco from contabilidad.cuenta_contable where id=c.id_cuenta_contable)) as nombre_banco,
		c.numero_cuenta,
		(select nombre from contabilidad.moneda where id=a.id_moneda)as nombre_moneda,
		0.0 as saldo_anterior,
		sum(d.debito_local - d.credito_local) as deposito, 
		0.0 as nc, 
		0.0 as ch_girados, 
		0.0 as nd, 
		c.procedencia,
		c.destino
       
from contabilidad.asiento_contable a inner join contabilidad.detalle_asiento_contable d
		on d.id_asiento_contable=a.id 
		
inner join tesoreria.cuenta_banco c
		on c.id_cuenta_contable=d.id_cuenta_contable
--where2

group by codigo_cuenta,nombre_banco,numero_cuenta,nombre_moneda,procedencia,destino

union

select 
		(select codigo from contabilidad.cuenta_contable where id=c.id_cuenta_contable)as codigo_cuenta,
		(select nombre from tesoreria.banco where id=(select id_banco from contabilidad.cuenta_contable where id=c.id_cuenta_contable)) as nombre_banco,
		c.numero_cuenta,
		(select nombre from contabilidad.moneda where id=a.id_moneda)as nombre_moneda,
		0.0 as saldo_anterior,
		0.0 asdeposito, 
		sum(debito_local)as nc, 
		0.0 asch_girados, 
		0.0 asnd, 
		c.procedencia,
		c.destino
       
from contabilidad.asiento_contable a inner join contabilidad.detalle_asiento_contable d
		on d.id_asiento_contable=a.id 
		
inner join tesoreria.cuenta_banco c
		on c.id_cuenta_contable=d.id_cuenta_contable
--where3

group by codigo_cuenta,nombre_banco,numero_cuenta,nombre_moneda,procedencia,destino

union

select 
		(select codigo from contabilidad.cuenta_contable where id=c.id_cuenta_contable)as codigo_cuenta,
		(select nombre from tesoreria.banco where id=(select id_banco from contabilidad.cuenta_contable where id=c.id_cuenta_contable)) as nombre_banco,
		c.numero_cuenta,
		(select nombre from contabilidad.moneda where id=a.id_moneda)as nombre_moneda,
		0.0 as saldo_anterior,
		0.0 asdeposito, 
		0.0 asnc, 
		sum(d.debito_local - d.credito_local) asch_girados, 
		0.0 asnd, 
		c.procedencia,
		c.destino
       
from contabilidad.asiento_contable a inner join contabilidad.detalle_asiento_contable d
		on d.id_asiento_contable=a.id 
		
inner join tesoreria.cuenta_banco c
		on c.id_cuenta_contable=d.id_cuenta_contable
--where4

group by codigo_cuenta,nombre_banco,numero_cuenta,nombre_moneda,procedencia,destino

union

select 
		(select codigo from contabilidad.cuenta_contable where id=c.id_cuenta_contable)as codigo_cuenta,
		(select nombre from tesoreria.banco where id=(select id_banco from contabilidad.cuenta_contable where id=c.id_cuenta_contable)) as nombre_banco,
		c.numero_cuenta,
		(select nombre from contabilidad.moneda where id=a.id_moneda)as nombre_moneda,
		0.0 as saldo_anterior,
		0.0 as deposito, 
		0.0 as nc, 
		0.0 as ch_girados, 
		sum(d.credito_local)as nd, 
		c.procedencia,
		c.destino
       
from contabilidad.asiento_contable a inner join contabilidad.detalle_asiento_contable d
		on d.id_asiento_contable=a.id 
		
inner join tesoreria.cuenta_banco c
		on c.id_cuenta_contable=d.id_cuenta_contable
--where5

group by codigo_cuenta,nombre_banco,numero_cuenta,nombre_moneda,procedencia,destino