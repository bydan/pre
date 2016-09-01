select 
	(select user_name from seguridad.usuario where id=n.id_usuario) as user_name_usuario,
	(select nombre_completo from cartera.cliente where id=n.id_cliente) as nombre_completo_cliente,
	n.numero,
	n.fecha_emision,
	(select nombre from inventario.bodega where id=d.id_bodega) as nombre_bodega,
	(select nombre from inventario.producto where id=d.id_producto) as nombre_producto,
	(select nombre from facturacion.tipo_devolucion_empresa where id=d.id_tipo_devolucion_empresa) as nombre_tipo_devolucion_empresa,
	d.cantidad,
	(select codigo from inventario.producto where id=d.id_producto) as codigo_producto
from facturacion.nota_credito n
inner join facturacion.deta_nota_credito d on d.id_nota_credito=n.id
--where