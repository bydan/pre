select 
	c.codigo,
	c.nombre_completo,
	f.fecha_emision,
	f.numero_pre_impreso,
	f.numero_documento,
	(select f.total_sin_iva + f.total_iva + f.iva + f.total_flete + f.total_otro - f.total_descuento) as total,
	(select sum(valor) from facturacion.deta_forma_pago d where d.id_factura=f.id)  as efectivo
from cartera.cliente c
inner join facturacion.factura f on f.id_cliente=c.id
--where