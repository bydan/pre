select  a.clave,
		a.nombre,
		a.fecha_compra,
		a.vida_util,
		a.costo_de_compra,
		a.fecha_mantenimiento,
		a.fecha_depreciacion,
		d.id_anio,
		(select codigo from activosfijos.sub_grupo_activo_fijo where id=a.id_sub_grupo_activo_fijo)as codigo_sub_grupo,
		(select nombre from activosfijos.sub_grupo_activo_fijo where id=a.id_sub_grupo_activo_fijo)as nombre_sub_grupo,
		(select codigo from activosfijos.detalle_grupo_activo_fijo where id=a.id_detalle_grupo_activo_fijo)as codigo_detalle_grupo,
		(select nombre from activosfijos.detalle_grupo_activo_fijo where id=a.id_detalle_grupo_activo_fijo)as nombre_detalle_grupo,
		d.valor_acumulado,
		d.valor_gasto,
		d.id_mes

from activosfijos.detalle_activo_fijo a inner join activosfijos.depreciacion_activo_fijo d
		on d.id_detalle_activo_fijo=a.id

--where