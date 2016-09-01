select 
	(select nombre_completo from cartera.cliente where id=p.id_cliente) as nombre_completo_cliente,
	(select nombre from contabilidad.moneda where id=p.id_moneda) as nombre_moneda,
	(select nombre from seguridad.zona where id=p.id_zona) as nombre_zona,
	p.numero,
	p.iva,
	p.descuento_valor,
	p.otro,
	p.total,
	p.fecha_vencimiento,
	p.fecha_emision
from facturacion.pedido p
--where
