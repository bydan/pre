select 
	(select nombre_completo from cartera.cliente where id=n.id_cliente) as nombre_completo_cliente,
	(select numero_pre_impreso from facturacion.factura where id=n.id_factura) as numero_pre_impreso_factura,
	n.numero,
	n.fecha_emision,
	n.fecha_vencimiento,
	n.iva,
	n.descuento_valor,
	n.otro_valor,
	n.sub_total,
	n.total,
	(select nombre from facturacion.estado_nota_credito where id=n.id_estado_nota_credito) as nombre_estado_nota_credito
from facturacion.nota_credito n
--where