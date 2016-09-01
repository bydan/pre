select 
	(select nombre from seguridad.provincia where id=c.id_provincia) as nombre_provincia,
	(select nombre from seguridad.ciudad where id=c.id_ciudad) as nombre_ciudad,
	(select nombre from seguridad.zona where id=c.id_zona) as nombre_zona,
	(select nombre from cartera.grupo_cliente where id=c.id_grupo_cliente) as nombre_grupo_cliente,
	(select nombre from comisiones.vendedor where id=c.id_vendedor) as nombre_vendedor,
	c.codigo,
	c.nombre_completo,
	p.numero,
	p.numero_autorizacion,
	p.total,
	p.fecha_emision
from cartera.cliente c
inner join facturacion.pedido p on p.id_cliente=c.id
--where