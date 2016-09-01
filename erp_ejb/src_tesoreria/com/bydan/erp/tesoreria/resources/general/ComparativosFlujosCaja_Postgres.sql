select 
		(select nombre from contabilidad.centro_actividad where id=d.id_centro_actividad)as nombre_centro_actividad,
		(select nombre from contabilidad.tipo_movimiento t where t.id=(select id_tipo_movimiento from contabilidad.centro_actividad where id=d.id_centro_actividad) ) as tipo_movimiento,
		0.000 saldo_actual,   
        0.000 saldo_acumulado,   
        0.000 saldo_pres_actual,   
        0.000 saldo_pres_acumulado ,
        d.id_centro_actividad 
        
from contabilidad.asiento_contable a inner join contabilidad.detalle_asiento_contable d
		on d.id_asiento_contable=a.id
--where1

group by d.id_centro_actividad,   
         tipo_movimiento  

         
union


select 
		ca.nombre as nombre_centro_actividad,
		(select nombre from contabilidad.tipo_movimiento t where t.id=ca.id_tipo_movimiento) as tipo_movimiento,
		0.000 saldo_actual,   
        0.000 saldo_acumulado,   
        0.000 saldo_pres_actual,   
        0.000 saldo_pres_acumulado,
        ca.id
        
from contabilidad.centro_actividad ca inner join tesoreria.presupuesto_flujo_caja_tsr d
		on d.id_centro_actividad=ca.id
--where2

group by ca.id,
		 tipo_movimiento