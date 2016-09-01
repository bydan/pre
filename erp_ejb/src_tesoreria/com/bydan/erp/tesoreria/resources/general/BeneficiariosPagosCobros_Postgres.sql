select 
       (select codigo from contabilidad.cuenta_contable where id=d.id_cuenta_contable)as codigo_cuenta_contable,
       (select nombre from contabilidad.cuenta_contable where id=d.id_cuenta_contable)as nombre_cuenta_contable,
       a.numero_mayor, 
       (select numero_cheque from tesoreria.detalle_cheque_girado where id_asiento_contable=a.id) as numero_cheque,
       (select beneficiario from tesoreria.detalle_cheque_girado where id_asiento_contable=a.id) as beneficiario,
       d.debito_local, 
       d.credito_local,
       d.detalle,
       (select nombre from contabilidad.tipo_movimiento where id=a.id_tipo_movimiento) as tipo_movimiento,
       (select valor from tesoreria.detalle_cheque_girado where id_asiento_contable=a.id) as valor,
       (select cuenta from tesoreria.detalle_cheque_girado where id_asiento_contable=a.id) as cuenta,
       a.fecha,      
       a.beneficiario as beneficiario_asiento   
       
from contabilidad.asiento_contable a inner join contabilidad.detalle_asiento_contable d
		on d.id_asiento_contable=a.id
	
--where