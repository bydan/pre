select 
	c.nombre_completo,
	(select nombre from comisiones.vendedor where id=f.id_vendedor) as nombre_vendedor,
	(select nombre from contabilidad.tipo_factura where id=f.id_tipo_factura) as nombre_tipo_factura,
	f.fecha_emision,
	f.fecha_vencimiento,
	f.numero_pre_impreso,
	f.total_iva,
	f.total_sin_iva,
	f.total_descuento,
	f.total_otro,
	f.sub_total,
	f.total,
	f.iva,
	f.descripcion
from cartera.cliente c
inner join facturacion.factura f on f.id_cliente=c.id
--where