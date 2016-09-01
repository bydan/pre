 select 
		r.nombre_banco, 
		r.nombre_girador, 
		r.fecha_vencimiento, 
		r.numero_cuenta, 
		r.numero_cheque, 
		r.valor_monto,
		dp.valor,
		a.numero_mayor,
		a.codigo,
		r.fecha_vencimiento_original,
		r.numero_cambio
	
from contabilidad.asiento_contable a inner join tesoreria.registro_forma_pago_banco r
		on r.id_asiento_contable=a.id
		
inner join facturacion.detalle_pago dp
		on dp.id_asiento_contable=r.id_asiento_contable
		
--where