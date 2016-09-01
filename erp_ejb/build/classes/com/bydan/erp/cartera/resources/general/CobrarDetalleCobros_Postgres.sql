select 
	(select nombre from comisiones.vendedor where id=c.id_vendedor) as nombre_vendedor,
	c.codigo,
	c.nombre,
	c.apellido,
	0.0 as total_facturas,
	sum(d.credito_mone_local) as total_abonos,
	0.0 as total_facturas_actual,
	0.0 as abonos_anterior,
	0.0 as abonos_actual
	
from cartera.cliente c inner join cartera.detalle_cliente d 
	on d.id_cliente=c.id

where c.id_empresa=IDEMPRESA and c.id_pais=ID_PAIS and c.id_ciudad=ID_CIUDAD and c.id_zona=ID_ZONA and c.id_grupo_cliente=ID_GRUPO_CLIENTE and c.id_vendedor=ID_VENDEDOR and
      d.fecha_emision<'FECHA_EMISION_HASTA'

group by c.id_vendedor,
		 c.codigo,
		 c.nombre,
		 c.apellido

union

select 
	(select nombre from comisiones.vendedor where id=c.id_vendedor) as nombre_vendedor,
	c.codigo,
	c.nombre,
	c.apellido,
	sum(d.debito_mone_local) as total_facturas,
	0.0 as total_abonos,
	0.0 as total_facturas_actual,
	0.0 as abonos_anterior,
	0.0 as abonos_actual
	
from cartera.cliente c inner join cartera.detalle_cliente d 
	on d.id_cliente=c.id

where c.id_empresa=IDEMPRESA and c.id_pais=ID_PAIS and c.id_ciudad=ID_CIUDAD and c.id_zona=ID_ZONA and c.id_grupo_cliente=ID_GRUPO_CLIENTE and c.id_vendedor=ID_VENDEDOR and
      d.fecha_emision<'FECHA_EMISION_HASTA'
      
group by c.id_vendedor,
		 c.codigo,
		 c.nombre,
		 c.apellido

union

select 
	(select nombre from comisiones.vendedor where id=c.id_vendedor) as nombre_vendedor,
	c.codigo,
	c.nombre,
	c.apellido,
	0.0 as total_facturas,
	0.0 as total_abonos,
	sum(d.credito_mone_local) as total_facturas_actual,
	0.0 as abonos_anterior,
	0.0 as abonos_actual
	
from cartera.cliente c inner join cartera.detalle_cliente d 
	on d.id_cliente=c.id

where c.id_empresa=IDEMPRESA and c.id_pais=ID_PAIS and c.id_ciudad=ID_CIUDAD and c.id_zona=ID_ZONA and c.id_grupo_cliente=ID_GRUPO_CLIENTE and c.id_vendedor=ID_VENDEDOR and
      d.fecha_emision between 'FECHA_EMISION_DESDE' and 'FECHA_EMISION_HASTA'
      
group by c.id_vendedor,
		 c.codigo,
		 c.nombre,
		 c.apellido