select 
      (select nombre from contabilidad.tipo_movimiento t where t.id=a.id_tipo_movimiento ) as tipo_movimiento,
      a.valor,
      a.numero_mayor, 
      a.beneficiario,
      a.fecha,
      a.fecha_emision,
      a.fecha_finalizacion,
      (select nombre from seguridad.usuario where id=a.id_usuario)as nombre_usuario,
      a.detalle,	
      dc.numero_cheque as numero_cheque,
      (select nombre from seguridad.empresa where id=a.id_empresa)as nombre_empresa,
      (select ruc from seguridad.empresa where id=a.id_empresa)as ruc_empresa           
       
from contabilidad.asiento_contable a inner join tesoreria.detalle_cheque_girado dc
		on dc.id_asiento_contable=a.id
		
--where