select 
	(select codigo from nomina.cargo where id=e.id_cargo) as codigo_cargo,
	(select nombre from nomina.estructura where id=e.id_estructura) as nombre_estructura,
	e.codigo as codigo_dato,
	e.nombre_completo,
	e.sueldo,
	a.fecha,
	a.valor,
	a.valor_adicional,
	a.valor_prestamo,
	0.0 as total
from nomina.empleado e
inner join facturacion.anticipo_cliente a on a.id_empleado=e.id
--where