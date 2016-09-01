select  m.numero_documento,
        m.causa, 
        m.referencia, 
        m.taller, 
        m.fecha_inicio, 
        m.fecha_entrega, 
        m.costo, 
        m.responsable, 
        m.observacion, 
        (select nombre from contabilidad.tipo_movimiento t where t.id=m.id_tipo_movimiento ) as tipo_movimiento,              
		a.clave,
		a.nombre,
		(select codigo from activosfijos.detalle_grupo_activo_fijo where id=a.id_detalle_grupo_activo_fijo)as codigo_detalle_grupo,
		(select nombre from activosfijos.detalle_grupo_activo_fijo where id=a.id_detalle_grupo_activo_fijo)as nombre_detalle_grupo
		
from activosfijos.detalle_activo_fijo a inner join activosfijos.mantenimiento_activo_fijo m 
		on m.id_detalle_activo_fijo=a.id

--where