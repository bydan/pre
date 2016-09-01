select 
	(select nombre_completo from cartera.cliente where id=p.id_cliente) as nombre_completo_cliente,
	p.numero,
	p.numero_autorizacion,
	p.numero_fue,
	f.numero_pre_impreso,
	f.numero_dau,
	f.numero_referendo,
	f.fecha_referendo,
	f.aforo_referendo
from facturacion.pedido p
inner join facturacion.factura f on f.id_pedido=p.id
--where