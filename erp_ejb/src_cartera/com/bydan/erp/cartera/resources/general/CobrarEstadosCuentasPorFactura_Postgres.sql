select 
	(select nombre from contabilidad.cuenta_contable where id=g.id_cuenta_contable) as nombre_cuenta_contable,
	(select nombre from seguridad.ciudad where id=c.id_ciudad) as nombre_ciudad,
	(select nombre from seguridad.zona where id=c.id_zona) as nombre_zona,
	c.nombre_completo,
	c.ruc,
	c.representante,
	c.dia_pago,
	c.hora_pago,
	c.observacion,
	(select nombre from tesoreria.transaccion where id=d.id_transaccion) as nombre_transaccion,
	d.fecha_vence,
	d.fecha_emision,
	d.numero_comprobante,
	d.numero_factura,
	d.debito_mone_local,
	d.credito_mone_local,
	(select max(direccion) from cartera.direccion where id_cliente=c.id) as direccion_direccion,
	(select string_agg(telefono,',') from cartera.telefono where id_cliente=c.id) as telefono_telefono
from cartera.grupo_cliente g
inner join cartera.cliente c on c.id_grupo_cliente=g.id
inner join cartera.detalle_cliente d on d.id_cliente=c.id
--where
