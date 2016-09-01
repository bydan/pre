select 
	(select nombre from seguridad.zona where id=c.id_zona) as nombre_zona,
	(select nombre_completo from cartera.cliente where id=f.id_cliente) as nombre_completo_cliente,
	(select nombre from contabilidad.tipo_factura where id=f.id_tipo_factura) as nombre_tipo_factura,
	f.fecha_emision,
	f.fecha_vencimiento,
	f.numero_pre_impreso,
	f.total_descuento,
	f.total_otro,
	f.sub_total,
	f.total,
	f.iva
from cartera.cliente c
inner join facturacion.factura f on f.id_cliente=c.id
--where