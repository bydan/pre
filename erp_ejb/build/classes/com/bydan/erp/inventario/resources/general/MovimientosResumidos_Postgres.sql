select 
	(select nombre from seguridad.sucursal where id=m.id_sucursal) as nombre_sucursal,
	(select nombre_completo from cartera.cliente where id=m.id_cliente) as nombre_completo_cliente,
	(select nombre from tesoreria.transaccion where id=m.id_transaccion) as nombre_transaccion,
	m.numero_comprobante,
	m.numero_factura,
	m.total,
	m.iva,
	m.numero_secuencial,
	m.fecha_emision,
	m.total_descuento,
	m.ice,
	m.retencion,
	m.total_otro
from inventario.movimiento_inventario m
--where