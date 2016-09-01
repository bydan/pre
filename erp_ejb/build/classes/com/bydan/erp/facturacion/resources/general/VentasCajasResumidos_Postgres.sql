select 
	c.codigo,
	c.nombre_completo,
	f.fecha_emision,
	f.numero_pre_impreso,
	f.numero_documento,
	(select f.total_sin_iva + f.total_iva + f.iva + f.total_flete + f.total_otro - f.total_descuento) as total,
	(select sum(valor) from facturacion.deta_forma_pago d where d.id_factura=f.id and 
				(select id_tipo_grupo_forma_pago from facturacion.tipo_forma_pago where id=d.id_tipo_forma_pago)=1) as efectivo,
				
	(select sum(valor) from facturacion.deta_forma_pago d where d.id_factura=f.id and 
				(select id_tipo_grupo_forma_pago from facturacion.tipo_forma_pago where id=d.id_tipo_forma_pago)=3) as tarjeta,			

	(select sum(valor) from facturacion.deta_forma_pago d where d.id_factura=f.id and 
				(select id_tipo_grupo_forma_pago from facturacion.tipo_forma_pago where id=d.id_tipo_forma_pago)=4) as credito			
	
from cartera.cliente c
inner join facturacion.factura f on f.id_cliente=c.id
