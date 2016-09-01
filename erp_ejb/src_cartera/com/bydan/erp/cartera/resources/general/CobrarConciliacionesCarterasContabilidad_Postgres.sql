select 
	a.codigo,
	(select codigo from contabilidad.tipo_movimiento where id=a.id_tipo_movimiento) as codigo_tipo_movimiento,
	a.numero_mayor,
	sum(d.debito_local) as debito_asiento,
	sum(d.credito_local) as credito_asiento,
	(select sum(debito_mone_local) from cartera.detalle_cliente where id_asiento_contable=a.id) as debito_cuentas,
	(select sum(credito_mone_local) from cartera.detalle_cliente where id_asiento_contable=a.id) as credito_cuentas
	
from contabilidad.asiento_contable a inner join contabilidad.detalle_asiento_contable d 
	on d.id_asiento_contable=a.id
--where

group by a.codigo,
		 a.id_tipo_movimiento,
		 a.numero_mayor,
		 a.id