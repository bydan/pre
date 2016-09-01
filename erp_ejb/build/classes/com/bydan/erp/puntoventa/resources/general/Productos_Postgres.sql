select 
	(select nombre from inventario.producto p where id=d.id_producto)as nombre_producto,
	f.fecha,
	count(*) as cantidad,
	d.id_producto
		
from puntoventa.factura_punto_venta f inner join puntoventa.detalle_factura_punto_venta d
	on f.id=d.id_factura_punto_venta

--where

group by fecha,id_producto