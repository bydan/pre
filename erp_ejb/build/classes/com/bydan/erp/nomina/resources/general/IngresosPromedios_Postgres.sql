select 
	(select codigo from nomina.cargo where id=e.id_cargo) as codigo_cargo,
	e.codigo as codigo_dato,
	e.nombre,
	p.valor_pago,
	(select nombre from nomina.rubro_emplea where id=p.id_rubro_emplea) as nombre_rubro_emplea
from nomina.empleado e
inner join nomina.empleado_pago_rubro p on p.id_empleado=e.id
--where