select 
	(select nombre_completo from cartera.cliente where id=g.id_cliente) as nombre_completo_cliente,
	(select numero_pre_impreso from facturacion.factura where id=g.id_factura) as numero_pre_impreso_factura,
	g.secuencial,
	g.fecha_emision,
	g.fecha_vencimiento,
	(select nombre from cartera.tipo_transporte where id=g.id_tipo_transporte) as nombre_tipo_transporte,
	(select sum(((d.porcentaje_iva / 100) * (d.cantidad * d.precio)) - ((d.porcentaje_descuento / 100) * (d.cantidad * d.precio))) from facturacion.detalle_guia_remision d where d.id_guia_remision=g.id) as iva,
	(select sum((d.porcentaje_descuento / 100) * (d.cantidad * d.precio)) from facturacion.detalle_guia_remision d where d.id_guia_remision=g.id) as descuento,
	g.otro as otro,
	(select sum((d.cantidad * d.precio)) from facturacion.detalle_guia_remision d where d.id_guia_remision=g.id) as total
from facturacion.guia_remision g
--where