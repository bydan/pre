select 
	e.codigo,
	e.nombre_completo,
	(select codigo from tesoreria.tipo_cuenta_banco_global where id=e.id_tipo_cuenta_banco_global) as codigo_tipo_cuenta_banco_global,
	e.numero_cuenta,
	(select codigo from facturacion.estado_anti_cliente where id=a.id_estado_anti_cliente) as codigo_estado_anti_cliente,
	a.fecha,
	a.valor,
	a.valor_adicional,
	(select nombre from facturacion.tipo_grupo_forma_pago where id=a.id_tipo_grupo_forma_pago) as nombre_tipo_grupo_forma_pago,
	0.0 as total
from nomina.empleado e
inner join facturacion.anticipo_cliente a on a.id_empleado=e.id
--where