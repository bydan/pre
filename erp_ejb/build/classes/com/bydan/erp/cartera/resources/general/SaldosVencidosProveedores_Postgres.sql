select 
		(select numero_pre_impreso from facturacion.factura where id=m.id_factura)as numero_factura,
		min(m.fecha_emision)as fecha_emision,
		max(m.fecha_venta) as fecha_venta,
		(select nombre from contabilidad.moneda where id=m.id_moneda)as nombre_moneda,
		sum(m.debito_mone_local) - sum(m.credito_mone_local) as saldo,
		sum(m.debito_mone_extra) - sum(m.credito_mone_extra) as saldo_extra,
		(select nombre_completo from cartera.cliente where id=m.id_cliente)as nombre_cliente,	
		(select nombre from cartera.grupo_cliente where id=(select id_grupo_cliente from cartera.cliente where id=m.id_cliente))as nombre_grupo_cliente,
		m.id_factura,
		m.id_moneda,
		m.id_cliente
		
from cartera.cliente c inner join cartera.detalle_prove m
		on m.id_cliente=c.id

--where

group by m.id_factura,
		 m.id_moneda,
		 m.id_cliente,
		 nombre_grupo_cliente

having sum(m.debito_mone_local) <> sum(m.credito_mone_local)