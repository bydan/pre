select 
	(select codigo from contabilidad.asiento_contable where id=fp.id_asiento_contable) as codigo_asiento_contable,
	(select codigo from puntoventa.tarjeta_credito where id=fp.id_tarjeta_credito) as codigo_tarjeta_credito,
	(select nombre from puntoventa.tipo_interes_tarjeta where id=fp.id_tipo_interes_tarjeta) as nombre_tipo_interes_tarjeta,
	(select nombre from puntoventa.conexion where id=fp.id_conexion) as nombre_conexion,
	(select nombre from seguridad.mes where id=fp.id_mes) as nombre_mes,
	fp.numero,
	fp.lote,
	fp.valor,
	fp.valor_retencion,
	fp.valor_comision,
	fp.valor_calculado,
	fp.valor_cancelado,
	fp.valor_difiere,
	fp.numero_retencion,
	fp.numero_liquidacion,
	fp.fecha
from puntoventa.factura_punto_venta f
inner join puntoventa.forma_pago_tarjeta_pun_ven fp on fp.id_factura_punto_venta=f.id
--where
