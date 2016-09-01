select 
	(select nombre from contabilidad.moneda where id=d.id_moneda) as nombre_moneda,
	(select nombre_completo from cartera.cliente where id=d.id_cliente) as nombre_completo_cliente,
	(select numero_pre_impreso from facturacion.factura where id=d.id_factura) as numero_pre_impreso_factura,
	max(d.fecha_emision) as fecha_emision,
	max(d.fecha_pago) as fecha_pago,
	max(d.fecha_vencimiento) as fecha_vencimiento,
	sum(d.debito_mone_local) as debito_mone_local,
	sum(d.debito_mone_extra) as debito_mone_extra
from cartera.detalle_prove d
--where
 group by 
		d.id_moneda,
		d.id_cliente,
		d.id_factura,
		d.fecha_emision,
		d.fecha_pago,
		d.fecha_vencimiento
		
having sum(d.debito_mone_local) - sum(d.credito_mone_local)<>0