select 
	e.codigo as codigo_dato,
	e.nombre_completo,
	sum(e.sueldo) as sueldo,
	sum(c.valor_conocimiento) as valor_conocimiento,
	sum(c.valor_eficiencia) as valor_eficiencia,
	sum(c.valor_obtenido) as valor_obtenido,
	sum(c.valor_peso) as valor_peso,
	0.0 as bonificacion
from nomina.empleado e
inner join nomina.evaluacion_empleado v on v.id_empleado=e.id
inner join nomina.calificacion_empleado c on c.id_evaluacion_empleado=v.id
--where
 group by 
		e.codigo,
		e.nombre_completo