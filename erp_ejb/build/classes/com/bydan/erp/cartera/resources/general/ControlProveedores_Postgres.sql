select 		
		(select nombre from seguridad.zona where id=c.id_zona)as nombre_zona,
		(select nombre from seguridad.ciudad where id=c.id_ciudad)as nombre_ciudad,	
		(select nombre from cartera.grupo_cliente where id=c.id_grupo_cliente)as nombre_grupo_cliente,
		c.codigo,	
		c.nombre_completo as nombre_cliente,	
		c.ruc,	
		(select string_agg(telefono,',') from cartera.telefono where id_cliente=c.id_ciudad)as telefonos,
		(select string_agg(direccion,',') from cartera.direccion where id_cliente=c.id_ciudad)as direcciones,
		(select string_agg(e_mail,',') from cartera.e_mail where id_cliente=c.id_ciudad)as emails,
		(select numero_pre_impreso from facturacion.factura where id=m.id_factura)as numero_factura,
		min(m.fecha_emision) as fecha_emision,
		max(m.fecha_venta) as fecha_venta,
		sum(m.debito_mone_local) - sum(m.credito_mone_local) as saldo,
		sum(m.debito_mone_local) as debito_mone_local,
		sum(m.credito_mone_local) as credito_mone_local
	
from cartera.cliente c inner join cartera.detalle_prove m 
		on m.id_cliente=c.id

--where

group by c.codigo,	
	 nombre_cliente,	
	 c.ruc,
	 c.id_zona,
	 c.id_ciudad,
	 c.id_grupo_cliente,
	 m.id_factura

having sum(m.debito_mone_local - m.credito_mone_local) != 0