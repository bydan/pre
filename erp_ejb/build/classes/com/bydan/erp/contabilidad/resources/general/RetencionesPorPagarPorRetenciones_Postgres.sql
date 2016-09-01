select 
	a.fecha_emision,
	(select nombre from contabilidad.tipo_movimiento where id=a.id_tipo_movimiento) as nombre_tipo_movimiento,
	a.numero_mayor,
	(select nombre from contabilidad.cuenta_contable where id=r.id_cuenta_contable_retencion) as nombre_cuenta_contable_retencion,
	(select numero_pre_impreso from facturacion.factura where id=r.id_factura) as numero_pre_impreso_factura,
	r.porcentaje,
	r.base_imponible,
	r.valor,
	r.numero,
	r.nombre_benef,
	r.ruc_benef,
	(select nombre from contabilidad.cuenta_contable where id=tr.id_cuenta_contable) as nombre_cuenta_contable,
	(select nombre from contabilidad.cuenta_contable where id=tr.id_cuenta_contable_credito) as nombre_cuenta_contable_credito,
	tr.es_debito as es_debito_dato
from contabilidad.asiento_contable a
inner join facturacion.retencion r on r.id_asiento_contable=a.id
inner join tesoreria.tipo_retencion_fuente_iva tr on r.id_tipo_retencion_fuente_iva=tr.id
--where