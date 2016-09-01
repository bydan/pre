select 
	e.codigo,
	e.nombre_completo,
	(select codigo from nomina.tipo_prestamo where id=p.id_tipo_prestamo) as codigo_tipo_prestamo,
	p.codigo as codigo_prestamo,
	a.numero,
	a.monto_capital,
	a.monto_interes,
	a.valor,
	0.0 as saldo
from nomina.empleado e
inner join nomina.prestamo p on p.id_empleado=e.id
inner join nomina.abono_prestamo a on a.id_prestamo=p.id
--where