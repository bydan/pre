select a.numero_mayor, 
       (select codigo from contabilidad.cuenta_contable where id=d.id_cuenta_contable)as codigo_cuenta,
       (select nombre from contabilidad.cuenta_contable where id=d.id_cuenta_contable)as nombre_cuenta,
       d.debito_local, 
       d.credito_local,
       d.numero_deposito,
       d.debito_extran, 
       d.credito_extran,
       a.fecha,
       a.detalle,
       a.beneficiario    
       
from contabilidad.asiento_contable a inner join contabilidad.detalle_asiento_contable d
		on d.id_asiento_contable=a.id
		
--where