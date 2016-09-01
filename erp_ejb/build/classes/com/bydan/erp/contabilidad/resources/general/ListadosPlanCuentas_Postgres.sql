select 
	(select nombre from contabilidad.moneda where id=c.id_moneda) as nombre_moneda,
	c.codigo,
	c.nombre,
	(select nombre from contabilidad.nivel_cuenta where id=c.id_nivel_cuenta) as nombre_nivel_cuenta,
	c.es_movimiento,
	c.es_centro_costo,
	c.es_centro_actividad,
	c.es_para_f52,
	c.orden
from contabilidad.cuenta_contable c
--where
