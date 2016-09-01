select 
	(select nombre from seguridad.modulo where id=a.id_modulo) as nombre_modulo,
	(select nombre from contabilidad.tipo_comprobante where id=l.id_tipo_comprobante) as nombre_tipo_comprobante,
	l.numero_documento,
	l.fecha_emision,
	l.fecha_registro_contable,
	l.numero_serie,
	l.total_iva,
	l.monto_iva,
	l.numero_documento_contable,
	(select nombre from contabilidad.cuenta_contable where id=r.id_cuenta_contable_retencion) as nombre_cuenta_contable_retencion,
	r.porcentaje,
	r.valor,
	r.nombre_benef
from contabilidad.asiento_contable a
inner join sris.transaccion_local l on l.id_asiento_contable=a.id
inner join facturacion.retencion r on l.id_asiento_contable=r.id_asiento_contable
--where