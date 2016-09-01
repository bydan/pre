select 
		(select nombre_completo from cartera.cliente c where id=f.id_cliente)as nombre_cliente,
		count(distinct f.numero_factura) as cantidad_facturas,
		sum(d.cantidad * d.costo_unitario) as total_valor,
		date_part('hour',f.fecha_emision)as mes

from contabilidad.factura_proveedor f inner join contabilidad.detalle_factura_proveedor d
		on d.id_factura_proveedor=f.id

--where

group by nombre_cliente,
	 	 mes