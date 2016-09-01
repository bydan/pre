select 
	c.codigo,
	c.nombre,
	c.apellido,
	n.feha_atencion,
	n.hora_atencion,
	n.accion_tomada,
	n.descripcion,
	n.esta_activo
from cartera.cliente c
inner join cartera.novedad n on n.id_cliente=c.id
--where