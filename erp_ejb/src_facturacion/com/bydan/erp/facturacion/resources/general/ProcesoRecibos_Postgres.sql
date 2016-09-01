select 
	(select nombre from seguridad.provincia where id=c.id_provincia) as nombre_provincia,
	(select nombre from seguridad.ciudad where id=c.id_ciudad) as nombre_ciudad,
	(select nombre from seguridad.zona where id=c.id_zona) as nombre_zona,
	(select nombre from cartera.grupo_cliente where id=c.id_grupo_cliente) as nombre_grupo_cliente,
	(select nombre from comisiones.vendedor where id=c.id_vendedor) as nombre_vendedor,
	c.codigo,
	c.nombre_completo,
	'1' as codigo_asiento,
	'1' as numero_mayor
from cartera.cliente c
--where