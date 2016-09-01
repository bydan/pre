select 
	(select nombre_completo from cartera.cliente where id=f.id_cliente) as nombre_completo_cliente,
	f.numero_pre_impreso,
	(select nombre from tesoreria.transaccion where id=d.id_transaccion) as nombre_transaccion,
	d.fecha_emision,
	d.monto_mone_local
from facturacion.factura f
inner join cartera.detalle_cliente d on d.id_factura=f.id
--where