select 
		(select codigo from cartera.cliente where id=g.id_cliente)as codigo_cliente,
		(select nombre_completo from cartera.cliente where id=g.id_cliente)as nombre_cliente,
		f.numero_factura,
		f.fecha_emision,
		f.total,
		g.numero_pre_impreso,
		g.fecha
		
from facturacion.guia_remision g inner join contabilidad.factura_proveedor f
		on f.numero_factura=g.numero_pre_impreso

--where