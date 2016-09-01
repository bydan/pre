select 
		(select nombre_completo from cartera.cliente c where id=dc.id_cliente)as nombre_cliente,
		dc.numero_factura,
		dc.debito_mone_local,
		dch.fecha,
		(select nombre from tesoreria.banco where id=(select id_banco from tesoreria.cuenta_banco where id=dch.id_cuenta_banco))as nombre_banco,
		dch.valor,
		dch.numero_cheque,
		(select numero_cuenta from tesoreria.cuenta_banco where id=dch.id_cuenta_banco) as numero_cuenta

from tesoreria.detalle_cheque_girado dch inner join cartera.detalle_cliente dc
		on dc.id_asiento_contable=dch.id_asiento_contable
		
--where