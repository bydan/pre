select 
		(select codigo from contabilidad.cuenta_contable c where c.id=d.id_cuenta_contable)as codigo_cuenta,
		d.codigo,
		d.nombre,
		(select nombre from seguridad.modulo where id=d.id_modulo)as nombre_modulo,
		0.0 as valor1,
		0.0 as valor2,
		0.0 as valor3,
		0.0 as valor4,
		0.0 as valor5,
		0.0 as valor6,
		0.0 as valor7,
		0.0 as valor8,
		0.0 as valor9,
		0.0 as valor10,
		0.0 as valor11,
		0.0 as valor12,
		0.0 as total
		
from cartera.grupo_cliente d 
--where1

union

select 
		distinct((select codigo from contabilidad.cuenta_contable c where c.id=d.id_cuenta_contable))as codigo_cuenta,
		(select nombre from tesoreria.forma_pago f where f.id=r.id_forma_pago)as codigo,
		'005' as nombre,
		'3' as nombre_modulo,
		0.0 as valor1,
		0.0 as valor2,
		0.0 as valor3,
		0.0 as valor4,
		0.0 as valor5,
		0.0 as valor6,
		0.0 as valor7,
		0.0 as valor8,
		0.0 as valor9,
		0.0 as valor10,
		0.0 as valor11,
		0.0 as valor12,
		0.0 as total
 
from contabilidad.detalle_asiento_contable d inner join tesoreria.registro_forma_pago_banco r --contabilidad.detalle_asiento_contable d
		on r.id_asiento_contable=d.id_asiento_contable
--where2	