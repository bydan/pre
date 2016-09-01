select 
	distinct(c.codigo),
	c.nombre_completo,
	(select numero_pre_impreso from facturacion.factura where id=d.id_factura) as numero_pre_impreso_factura,
	sum(d.debito_mone_local - d.credito_mone_local) as saldo_vencido,
	0.0 as saldo_vencer
from cartera.cliente c inner join cartera.detalle_cliente d on d.id_cliente=c.id

where d.id_empresa=IDEMPRESA and (select max(fecha_vence) from cartera.detalle_cliente where id_empresa=d.id_empresa and id_cliente=d.id_cliente and id_factura=d.id_factura) <= 'FECHA_VENCE'

group by c.codigo,
	 c.nombre_completo,
	 d.id_factura

union 


select 
	distinct(c.codigo),
	c.nombre_completo,
	(select numero_pre_impreso from facturacion.factura where id=d.id_factura) as numero_pre_impreso_factura,
	0.0 as saldo_vencido,
	sum(d.debito_mone_local - d.credito_mone_local) as saldo_vencer	
from cartera.cliente c inner join cartera.detalle_cliente d on d.id_cliente=c.id

where d.id_empresa=IDEMPRESA and (select max(fecha_vence) from cartera.detalle_cliente where id_empresa=d.id_empresa and id_cliente=d.id_cliente and id_factura=d.id_factura) > 'FECHA_VENCE'


group by c.codigo,
	 c.nombre_completo,
	 d.id_factura