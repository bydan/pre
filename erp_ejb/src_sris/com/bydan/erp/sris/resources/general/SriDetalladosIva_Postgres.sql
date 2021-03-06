select 
	(select nombre from contabilidad.tipo_comprobante where id=l.id_tipo_comprobante) as nombre_tipo_comprobante,
	l.ruc as ruc_dato,
	l.numero_documento,
	l.fecha_emision,
	l.fecha_registro_contable,
	l.numero_serie,
	l.total_iva,
	l.total_sin_iva,
	(select id from contabilidad.tipo_iva where id=l.id_tipo_iva) as id_tipo_iva,
	(select id from contabilidad.tipo_retencion_iva where id=l.id_tipo_retencion_iva) as id_tipo_retencion_iva,
	l.transfe_iva_retenido,
	(select id from contabilidad.tipo_retencion_iva where id=l.id_tipo_retencion_iva_presta) as id_tipo_retencion_iva_presta,
	l.presta_iva_retenido
from sris.transaccion_local l
--where