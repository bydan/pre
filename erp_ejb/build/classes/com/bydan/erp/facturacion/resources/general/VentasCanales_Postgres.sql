select 
	(select nombre from cartera.titulo_cliente where id=c.id_titulo_cliente) as nombre_titulo_cliente,
	sum(d.monto) as monto,
	(select codigo from cartera.titulo_cliente where id=c.id_titulo_cliente) as codigo_titulo_cliente,
	0.0 as notas_credito,
	0.0 as venta_neta,
	0.0 as porcentaje,
	0.0 as acumulado,
	'0' as tipo
from cartera.cliente c inner join facturacion.factura f
	on f.id_cliente=c.id
inner join facturacion.detalle_factura d on d.id_factura=f.id
--where1
group by c.id_titulo_cliente,
	 tipo

union

select 
	(select nombre from cartera.titulo_cliente where id=c.id_titulo_cliente) as nombre_titulo_cliente,
	0.0 as monto,
	(select codigo from cartera.titulo_cliente where id=c.id_titulo_cliente) as codigo_titulo_cliente,
	sum(d.monto) as notas_credito,
	0.0 as venta_neta,
	0.0 as porcentaje,
	0.0 as acumulado,
	'1' as tipo
	
from cartera.cliente c inner join facturacion.nota_credito f
	on f.id_cliente=c.id
inner join facturacion.deta_nota_credito d on d.id_nota_credito=f.id
--where2
group by c.id_titulo_cliente,
	 tipo
	