select  
		(select nombre from seguridad.empresa where id=a.id_empresa)as nombre_empresa,	
		(select nombre from seguridad.sucursal where id=a.id_sucursal)as nombre_sucursal,
		a.clave,
		a.nombre,
		a.fecha_compra,
		a.vida_util,
		a.costo_de_compra,
		a.cantidad,
		(select codigo from activosfijos.sub_grupo_activo_fijo where id=a.id_sub_grupo_activo_fijo)as codigo_sub_grupo,
		(select nombre from activosfijos.sub_grupo_activo_fijo where id=a.id_sub_grupo_activo_fijo)as nombre_sub_grupo,
		(select codigo from activosfijos.detalle_grupo_activo_fijo where id=a.id_detalle_grupo_activo_fijo)as codigo_detalle_grupo,
		(select nombre from activosfijos.detalle_grupo_activo_fijo where id=a.id_detalle_grupo_activo_fijo)as nombre_detalle_grupo

from activosfijos.detalle_activo_fijo a

--where