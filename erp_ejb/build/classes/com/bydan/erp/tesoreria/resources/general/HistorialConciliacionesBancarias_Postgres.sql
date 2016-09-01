select  d.debito_local, 
		d.credito_local,
		(select max(numero_cheque) from tesoreria.detalle_cheque_girado where id_asiento_contable=a.id) as numero_cheque,
		a.codigo,
		(select max(beneficiario) from tesoreria.detalle_cheque_girado where id_asiento_contable=a.id) as beneficiario,
		d.detalle,
		(select max(cuenta) from tesoreria.detalle_cheque_girado where id_asiento_contable=a.id) as cuenta,
		(select nombre from contabilidad.tipo_documento where id=a.id_tipo_documento) as tipo_documento,
		a.numero_mayor, 
		a.fecha_finalizacion,
		(select nombre from contabilidad.tipo_movimiento t where t.id=a.id_tipo_movimiento ) as tipo_movimiento,
		0.0 saldo_libros, 
		a.fecha,
		(select max(numero_cuenta) from tesoreria.cuenta_banco where id_cuenta_contable=d.id_cuenta_contable) as numero_cuenta, 
		(select max(nombre) from contabilidad.cuenta_contable c where c.id=d.id_cuenta_contable)as nombre_cuenta_contable,
		0.0 anterior
       
from contabilidad.asiento_contable a inner join contabilidad.detalle_asiento_contable d
		on d.id_asiento_contable=a.id
		
--where