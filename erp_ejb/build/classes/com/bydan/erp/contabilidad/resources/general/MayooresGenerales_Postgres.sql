select 
	(select nombre from seguridad.sucursal where id=a.id_sucursal) as nombre_sucursal,
	a.codigo,
	a.beneficiario,
	a.detalle,
	a.fecha_emision,
	(select codigo from contabilidad.tipo_movimiento where id=a.id_tipo_movimiento) as codigo_tipo_movimiento,
	a.numero_mayor,
	(select nombre from contabilidad.cuenta_contable where id=d.id_cuenta_contable) as nombre_cuenta_contable,
	sum(d.debito_local) as debito_local,
	sum(d.credito_local) as credito_local,
	d.detalle as detalle_detalle_asiento_contable,
	(select codigo from contabilidad.cuenta_contable where id=d.id_cuenta_contable) as codigo_cuenta_contable,
	0.0 as saldo
from contabilidad.asiento_contable a
inner join contabilidad.detalle_asiento_contable d on d.id_asiento_contable=a.id
--where
 group by 
		a.id_sucursal,
		a.codigo,
		a.beneficiario,
		a.detalle,
		a.fecha_emision,
		a.id_tipo_movimiento,
		a.numero_mayor,
		d.id_cuenta_contable,
		d.detalle