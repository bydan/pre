select 
	(select nombre from contabilidad.centro_actividad where id=d.id_centro_actividad) as nombre_centro_actividad,
	(select codigo from contabilidad.centro_actividad where id=d.id_centro_actividad) as codigo_centro_actividad,
	sum(d.debito_local - d.credito_local) as mensual,
	0.0 as acumulado,
	'1' as estado
from contabilidad.asiento_contable a
inner join contabilidad.detalle_asiento_contable d on d.id_asiento_contable=a.id
--where1
group by d.id_centro_actividad

having sum(d.debito_local - d.credito_local) <> 0


union


select 
	(select nombre from contabilidad.centro_actividad where id=d.id_centro_actividad) as nombre_centro_actividad,
	(select codigo from contabilidad.centro_actividad where id=d.id_centro_actividad) as codigo_centro_actividad,
	0.0 as mensual,
	0.0 as acumulado,
	'0' as estado
from contabilidad.asiento_contable a
inner join contabilidad.detalle_asiento_contable d on d.id_asiento_contable=a.id
--where2
group by d.id_centro_actividad

having sum(d.debito_local - d.credito_local) <> 0