select 
      (select nombre from contabilidad.tipo_documento where id=a.id_tipo_documento) as tipo_documento,
      a.detalle,	
      (select codigo from contabilidad.cuenta_contable where id=d.id_cuenta_contable)as codigo_cuenta,
      (select nombre from contabilidad.cuenta_contable where id=d.id_cuenta_contable)as nombre_cuenta,
      a.numero_mayor, 
      d.debito_local, 
      d.credito_local,
      (select nombre from contabilidad.tipo_movimiento where id=a.id_tipo_movimiento) as tipo_movimiento,
      a.fecha_emision,
      a.fecha, 
      a.beneficiario    
       
from contabilidad.asiento_contable a inner join contabilidad.detalle_asiento_contable d
		on d.id_asiento_contable=a.id

inner join contabilidad.cuenta_contable c
		on d.id_cuenta_contable=c.id
		
--where