 select a.fecha,
		(select nombre from contabilidad.tipo_movimiento t where t.id=a.id_tipo_movimiento ) as tipo_movimiento,
		a.codigo,
		a.beneficiario,
		dc.beneficiario as beneficiario_cheque,
		a.detalle,
		dc.valor as valor_cheque,
		(select nombre from seguridad.empresa where id=a.id_empresa)as nombre_empresa,
		(select direccion from seguridad.empresa where id=a.id_empresa)as direccion_empresa,
		(select ruc from seguridad.empresa where id=a.id_empresa)as ruc_empresa,
		(select nombre from seguridad.sucursal where id=a.id_empresa)as nombre_sucursal,
		a.valor,
		a.numero_mayor, 	     
		a.fecha_emision,
		a.fecha_finalizacion,
		(select nombre from seguridad.usuario where id=a.id_usuario)as nombre_usuario,		
		dc.numero_cheque as numero_cheque          
       
from contabilidad.asiento_contable a inner join tesoreria.detalle_cheque_girado dc
		on dc.id_asiento_contable=a.id
		
--where