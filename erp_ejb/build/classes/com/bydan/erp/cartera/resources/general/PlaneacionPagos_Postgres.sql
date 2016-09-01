select 
		(select nombre_completo from cartera.cliente where id=m.id_cliente) as nombre_cliente,
		(select numero_pre_impreso from facturacion.factura where id=m.id_factura)as numero_factura,
		min(m.fecha_emision) as fecha_emision,
		max(m.fecha_venta) as fecha_venta,
		max(m.fecha_pago) as fecha_pago,
		sum(m.debito_mone_local) - sum(m.credito_mone_local) as saldo,
		m.id_factura,
		m.id_cliente

from cartera.cliente c inner join cartera.detalle_prove m
		on m.id_cliente=c.id

--where

group by m.id_factura,
	 	 m.id_cliente
	
having abs(sum(m.debito_mone_local - m.credito_mone_local))!=0