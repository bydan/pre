select 
	(select nombre from comisiones.vendedor where id=f.id_vendedor) as nombre_vendedor,
	(select nombre_completo from cartera.cliente where id=f.id_cliente) as nombre_completo_cliente,
	f.fecha_emision,
	f.numero_pre_impreso as numero_pre_impreso_dato,
	f.total,
	(select nombre from inventario.unidad where id=d.id_unidad) as nombre_unidad,
	(select nombre from inventario.bodega where id=d.id_bodega) as nombre_bodega,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	d.cantidad,
	d.precio,
	d.descuento
from facturacion.factura f
inner join facturacion.detalle_factura d on d.id_factura=f.id
--where
