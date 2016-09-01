select 
	e.codigo,
	e.nombre,
	v.fecha,
	v.valor,
	(select nombre from nomina.rubro_emplea where id=v.id_rubro_emplea) as nombre_rubro_emplea
from nomina.empleado e
inner join nomina.valor_rubro_variable v on v.id_empleado=e.id
--where