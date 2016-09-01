select 
		(select nombre from tesoreria.transaccion where id=m.id_transaccion)as nombre_transaccion,
		m.fecha_emision,
		m.fecha_venta,
		m.numero_comprobante,
		(select numero_pre_impreso from facturacion.factura where id=m.id_factura)as numero_factura,
		(select nombre_completo from cartera.cliente where id=m.id_cliente)as nombre_cliente,	
		m.debito_mone_local,
		m.credito_mone_local,
		m.descripcion

from cartera.detalle_prove m

--where