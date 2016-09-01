select 
	(select nombre from seguridad.provincia where id=c.id_provincia) as nombre_provincia,
	(select nombre from seguridad.ciudad where id=c.id_ciudad) as nombre_ciudad,
	(select nombre from seguridad.zona where id=c.id_zona) as nombre_zona,
	(select nombre from cartera.grupo_cliente where id=c.id_grupo_cliente) as nombre_grupo_cliente,
	c.codigo as codigo_dato,
	c.nombre_completo as nombre_completo_dato,
	(select numero_pre_impreso from facturacion.factura where id=t.id_factura) as numero_pre_impreso_factura,
	(select nombre from inventario.producto where id=t.id_producto) as nombre_producto,
	(select nombre from inventario.unidad where id=t.id_unidad) as nombre_unidad,
	t.precio,
	t.tarea
from cartera.cliente c
inner join facturacion.tarea_cliente t on t.id_cliente=c.id
--where