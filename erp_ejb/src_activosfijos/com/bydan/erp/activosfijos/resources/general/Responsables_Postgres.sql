select  
		(select codigo from nomina.empleado where id=r.id_empleado)as codigo_empleado,
		(select nombre from nomina.empleado where id=r.id_empleado)as nombre_empleado,
		(select apellido from nomina.empleado where id=r.id_empleado)as apellido_empleado,
		(select nombre from nomina.estructura where id=r.id_estructura)as nombre_estructura,	
		r.ubicacion,
		r.fecha,
		r.descripcion,
		a.nombre,
		a.clave,	
		(select codigo from activosfijos.sub_grupo_activo_fijo where id=a.id_sub_grupo_activo_fijo)as codigo_sub_grupo,
		(select nombre from activosfijos.sub_grupo_activo_fijo where id=a.id_sub_grupo_activo_fijo)as nombre_sub_grupo,
		(select codigo from activosfijos.detalle_grupo_activo_fijo where id=a.id_detalle_grupo_activo_fijo)as codigo_detalle_grupo,
		(select nombre from activosfijos.detalle_grupo_activo_fijo where id=a.id_detalle_grupo_activo_fijo)as nombre_detalle_grupo

from activosfijos.detalle_activo_fijo a inner join activosfijos.responsable_activo_fijo r 
		on r.id_detalle_activo_fijo=a.id
		
--where