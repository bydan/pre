select 	
		c.codigo,	
		c.nombre_completo as nombre_cliente,	
		c.ruc,
		0 as total_facturas,
		sum(m.credito_mone_local) as total_abonos,
		0 as total_facturas_actual,
		0.00001 abonos_anterior,   
	    0.00001 abonos_actual
		
from cartera.cliente c inner join cartera.detalle_prove m 
		on m.id_cliente=c.id
--where1

group by c.codigo,	
	 	 nombre_cliente,	
	 	 c.ruc

union

select 	
		c.codigo,	
		c.nombre_completo as nombre_cliente,	
		c.ruc,
		sum(m.debito_mone_local) as total_facturas,
		0 as total_abonos,
		0 as total_facturas_actual,
		0.00001 abonos_anterior,   
	    0.00001 abonos_actual 
	
from cartera.cliente c inner join cartera.detalle_prove m 
		on m.id_cliente=c.id
--where2

group by c.codigo,	
	 	 nombre_cliente,	
	 	 c.ruc

union

select 	
		c.codigo,	
		c.nombre_completo as nombre_cliente,	
		c.ruc,
		0 as total_facturas,
		0 as total_abonos,
		sum(m.credito_mone_local) as total_facturas_actual,
		0.00001 abonos_anterior,   
	    0.00001 abonos_actual 
		
from cartera.cliente c inner join cartera.detalle_prove m 
		on m.id_cliente=c.id
--where3

group by c.codigo,	
	 	 nombre_cliente,	
	 	 c.ruc