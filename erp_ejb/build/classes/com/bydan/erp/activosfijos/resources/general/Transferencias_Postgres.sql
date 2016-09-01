select 
       (select nombre from seguridad.empresa where id=m.id_empresa_origen)as empresa_origen,	
       (select nombre from seguridad.sucursal where id=m.id_sucursal_origen)as sucursal_origen,
       (select nombre from activosfijos.sub_grupo_activo_fijo where id=(select id_sub_grupo_activo_fijo from activosfijos.detalle_activo_fijo where id=m.id_detalle_activo_fijo_origen))as subgrupo_origen,
       (select nombre from activosfijos.detalle_grupo_activo_fijo where id=(select id_detalle_grupo_activo_fijo from activosfijos.detalle_activo_fijo where id=m.id_detalle_activo_fijo_origen))as grupo_origen,
       (select nombre from activosfijos.detalle_activo_fijo where id=m.id_detalle_activo_fijo_origen)as activo_origen,
       (select nombre from seguridad.empresa where id=m.id_empresa_destino)as empresa_destino,	
       (select nombre from seguridad.sucursal where id=m.id_sucursal_destino)as sucursal_destino,
       (select nombre from activosfijos.sub_grupo_activo_fijo where id=(select id_sub_grupo_activo_fijo from activosfijos.detalle_activo_fijo where id=m.id_detalle_activo_fijo_destino))as subgrupo_destino,
       (select nombre from activosfijos.detalle_grupo_activo_fijo where id=(select id_detalle_grupo_activo_fijo from activosfijos.detalle_activo_fijo where id=m.id_detalle_activo_fijo_destino))as grupo_destino,
       (select nombre from activosfijos.detalle_activo_fijo where id=m.id_detalle_activo_fijo_destino)as activo_destino,
       m.secuencial, 
       m.fecha, 
       m.numero_documento, 
       m.costo, 
       m.depreciacion, 
       m.costo_origen, 
       m.depreciacion_origen, 
       m.razon,
       'ACTIVOS ENVIADOS' as tipo
       
from activosfijos.movimiento_activo_fijo m
--where1

union

select 
       (select nombre from seguridad.empresa where id=m.id_empresa_origen)as empresa_origen,	
       (select nombre from seguridad.sucursal where id=m.id_sucursal_origen)as sucursal_origen,
       (select nombre from activosfijos.sub_grupo_activo_fijo where id=(select id_sub_grupo_activo_fijo from activosfijos.detalle_activo_fijo where id=m.id_detalle_activo_fijo_origen))as subgrupo_origen,
       (select nombre from activosfijos.detalle_grupo_activo_fijo where id=(select id_detalle_grupo_activo_fijo from activosfijos.detalle_activo_fijo where id=m.id_detalle_activo_fijo_origen))as grupo_origen,
       (select nombre from activosfijos.detalle_activo_fijo where id=m.id_detalle_activo_fijo_origen)as activo_origen,
       (select nombre from seguridad.empresa where id=m.id_empresa_destino)as empresa_destino,	
       (select nombre from seguridad.sucursal where id=m.id_sucursal_destino)as sucursal_destino,
       (select nombre from activosfijos.sub_grupo_activo_fijo where id=(select id_sub_grupo_activo_fijo from activosfijos.detalle_activo_fijo where id=m.id_detalle_activo_fijo_destino))as subgrupo_destino,
       (select nombre from activosfijos.detalle_grupo_activo_fijo where id=(select id_detalle_grupo_activo_fijo from activosfijos.detalle_activo_fijo where id=m.id_detalle_activo_fijo_destino))as grupo_destino,
       (select nombre from activosfijos.detalle_activo_fijo where id=m.id_detalle_activo_fijo_destino)as activo_destino,
       secuencial, 
       fecha, 
       numero_documento, 
       costo, 
       depreciacion, 
       costo_origen, 
       depreciacion_origen, 
       razon,
       'ACTIVOS ENVIADOS' as tipo
       
from activosfijos.movimiento_activo_fijo m
--where2