select 
	(select nombre from seguridad.region where id=c.id_region) as nombre_region,
	(select nombre from seguridad.provincia where id=c.id_provincia) as nombre_provincia,
	(select nombre from seguridad.ciudad where id=c.id_ciudad) as nombre_ciudad,
	(select nombre from seguridad.zona where id=c.id_zona) as nombre_zona,
	(select nombre from cartera.ruta where id=c.id_ruta) as nombre_ruta,
	(select nombre from comisiones.vendedor where id=c.id_vendedor) as nombre_vendedor,
	c.codigo,
	c.nombre,
	c.apellido,
	(select max(direccion) from cartera.direccion where id_cliente=c.id) as direccion_direccion,
	(select string_agg(telefono,',') from cartera.telefono where id_cliente=c.id) as telefono_telefono
from cartera.cliente c
--where