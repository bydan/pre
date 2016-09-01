select  a.clave,
		a.nombre,
		a.fecha_compra,
		a.vida_util,
		a.costo_de_compra,
		a.marca,
		a.modelo,
		v.numero_matricula,
		v.numero_motor,
		v.numero_chasis,
		v.numero_placa,
		v.valor_comercial,
		(select nombre from activosfijos.sub_grupo_activo_fijo where id=a.id_sub_grupo_activo_fijo)as nombre_sub_grupo,
		(select nombre from activosfijos.detalle_grupo_activo_fijo where id=a.id_detalle_grupo_activo_fijo)as nombre_detalle_grupo

from activosfijos.detalle_activo_fijo a inner join activosfijos.vehiculo v 
		on v.id_detalle_activo_fijo=a.id

--where