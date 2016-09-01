select 
	(select user_name from seguridad.usuario where id=a.id_usuario) as user_name_usuario,
	(select nombre from seguridad.modulo where id=a.id_modulo) as nombre_modulo,
	a.codigo,
	a.beneficiario,
	a.detalle,
	a.fecha_emision,
	(select codigo from contabilidad.tipo_movimiento where id=a.id_tipo_movimiento) as codigo_tipo_movimiento,
	a.numero_mayor as numero_mayor_dato,
	(select nombre from contabilidad.cuenta_contable where id=d.id_cuenta_contable) as nombre_cuenta_contable,
	d.debito_local,
	d.credito_local,
	(select codigo from contabilidad.cuenta_contable where id=d.id_cuenta_contable) as codigo_cuenta_contable
from contabilidad.asiento_contable a
inner join contabilidad.detalle_asiento_contable d on d.id_asiento_contable=a.id
--where