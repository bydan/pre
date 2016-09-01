select 
	a.codigo,
	a.fecha_emision,
	(select codigo from contabilidad.tipo_movimiento where id=a.id_tipo_movimiento) as codigo_tipo_movimiento,
	a.numero_mayor,
	(select nombre from contabilidad.cuenta_contable where id=d.id_cuenta_contable) as nombre_cuenta_contable,
	d.debito_local,
	d.credito_local,
	d.detalle,
	(select codigo from contabilidad.cuenta_contable where id=d.id_cuenta_contable) as codigo_cuenta_contable
from contabilidad.asiento_contable a
inner join contabilidad.detalle_asiento_contable d on d.id_asiento_contable=a.id
--where