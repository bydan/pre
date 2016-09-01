select 
	c.codigo,
	c.nombre_completo,
	c.nombre_comercial,
	c.nombre_garantia,
	c.limite_credito,
	
	(select sum(flete + otro + total +iva - descuento_valor) from facturacion.pedido p where p.id_cliente=c.id and
			p.id_empresa=IDEMPRESA and p.id_sucursal=IDSUCURSAL and p.fecha='FECHA_EMISION_HASTA' group by p.id_cliente) as total_pedidos,

	(select sum(debito_mone_local - credito_mone_local) from cartera.detalle_cliente d where d.id_cliente=c.id and
			d.id_empresa=IDEMPRESA and d.id_sucursal=IDSUCURSAL and d.id_ejercicio=ID_EJERCICIO and d.fecha_emision='FECHA_EMISION_HASTA' group by d.id_cliente) as total_saldos,
			
	(select sum(dp.valor)	from tesoreria.registro_forma_pago_banco r inner join facturacion.detalle_pago dp
										on dp.id_asiento_contable=r.id_asiento_contable
			where r.fecha_vencimiento<='FECHA_EMISION_HASTA' and dp.id_empresa=IDEMPRESA and dp.id_sucursal=IDSUCURSAL and r.id_cliente=c.id group by r.id_cliente) as total_cheques
			
from cartera.cliente c

where c.id_empresa=IDEMPRESA and c.id_sucursal=IDSUCURSAL