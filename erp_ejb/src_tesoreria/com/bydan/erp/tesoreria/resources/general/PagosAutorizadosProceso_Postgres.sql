select 
	(select nombre from contabilidad.tipo_documento where id=a.id_tipo_documento) as nombre_tipo_documento,
	a.codigo,
	a.beneficiario,
	a.fecha,
	a.fecha_emision,
	(select codigo from contabilidad.tipo_movimiento_modulo where id=a.id_tipo_movimiento_modulo) as codigo_tipo_movimiento_modulo,
	a.numero_mayor,
	a.valor,
	(select codigo from tesoreria.cuenta_banco where id=d.id_cuenta_banco) as codigo_cuenta_banco,
	d.numero_cheque,
	d.beneficiario as beneficiario_detalle_cheque_girado
from contabilidad.asiento_contable a
inner join tesoreria.detalle_cheque_girado d on d.id_asiento_contable=a.id
--where