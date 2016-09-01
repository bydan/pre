select  a.fecha,
		(select nombre from contabilidad.tipo_movimiento t where t.id=a.id_tipo_movimiento ) as tipo_movimiento,
		a.numero_mayor,
		dc.numero_factura,
		(select nombre_completo from cartera.cliente c where id=dc.id_cliente)as nombre_cliente,
		(select siglas from facturacion.tipo_forma_pago where id=dp.id_tipo_forma_pago)as siglas_pago,
		(select nombre from facturacion.tipo_forma_pago where id=dp.id_tipo_forma_pago)as nombre_pago,
		a.codigo,
		dc.credito_mone_local
	
from contabilidad.asiento_contable a inner join cartera.detalle_cliente dc 
		on dc.id_asiento_contable=a.id 
		
inner join facturacion.detalle_pago dp
		on dc.id_asiento_contable=dp.id_asiento_contable	
		
inner join tesoreria.registro_forma_pago_banco r
		on r.id_asiento_contable=dp.id_asiento_contable
		
--where