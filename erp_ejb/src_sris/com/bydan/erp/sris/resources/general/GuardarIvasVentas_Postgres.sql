select 
	(select codigo from contabilidad.estado_asiento_contable where id=a.id_estado_asiento_contable) as codigo_estado_asiento_contable,
	(select nombre from contabilidad.periodo where id=r.id_periodo) as nombre_periodo,
	(select nombre from tesoreria.tipo_retencion_fuente_iva where id=r.id_tipo_retencion_fuente_iva) as nombre_tipo_retencion_fuente_iva,
	r.porcentaje,
	r.base_imponible,
	r.valor,
	r.numero,
	r.ruc_benef
from contabilidad.asiento_contable a
inner join facturacion.retencion r on r.id_asiento_contable=a.id
--where