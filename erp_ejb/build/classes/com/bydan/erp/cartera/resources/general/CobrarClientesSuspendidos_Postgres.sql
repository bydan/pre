select 
	(select nombre from seguridad.ciudad where id=c.id_ciudad) as nombre_ciudad,
	c.codigo,
	c.nombre_completo,
	c.nombre_comercial,
	c.ruc,
	c.detalle_estado,
	(select max(direccion) from cartera.direccion where id_cliente=c.id) as direccion_direccion,
	(select string_agg(telefono,',') from cartera.telefono where id_cliente=c.id) as telefono_telefono,
	(select sum(debito_mone_local-credito_mone_local) from cartera.detalle_cliente d where d.id_cliente=c.id) as saldo
from cartera.cliente c
--where