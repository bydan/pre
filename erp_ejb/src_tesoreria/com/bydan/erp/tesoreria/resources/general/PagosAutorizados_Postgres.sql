 select 
		(select nombre_completo from cartera.cliente c where id=p.id_cliente)as nombre_cliente,	
		p.numero_factura, 
		p.fecha_emision, 
		p.fecha_vencimiento, 
		(select nombre from tesoreria.banco where id=(select id_banco from tesoreria.cuenta_banco where id=p.id_cuenta_banco)) as nombre_banco,	 
	    p.valor_por_pagar, 
	    p.valor_cancelado, 
	    (select numero_cuenta from tesoreria.cuenta_banco where id=p.id_cuenta_banco) as numero_cuenta,
	    p.esta_autorizado, 
	    p.descripcion,
	    p.fecha_corte as fecha_corte_dato,
	    (select nombre from tesoreria.estado_pago_auto where id=p.id_estado_pago_auto)as estado,
		(select codigo from contabilidad.cuenta_contable c where c.id=(select id_cuenta_contable from cartera.cliente where id=p.id_cliente))as codigo_cuentacon_cliente,
		(select codigo from contabilidad.cuenta_contable c where c.id=(select id_cuenta_contable from tesoreria.cuenta_banco where id=p.id_cuenta_banco))as codigo_cuentacon_banco

from tesoreria.pago_auto p 

--where