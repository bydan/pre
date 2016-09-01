select 
	e.codigo as codigo_dato,
	e.nombre_completo,
	(select id from nomina.formato_nomi_pregunta_nomi where id=c.id_formato_nomi_pregunta_nomi) as id_formato_nomi_pregunta_nomi,
	c.valor_conocimiento,
	c.valor_eficiencia,
	c.valor_obtenido,
	0.0 as promedio
from nomina.empleado e
inner join nomina.evaluacion_empleado v on v.id_empleado=e.id
inner join nomina.calificacion_empleado c on c.id_evaluacion_empleado=v.id
--where