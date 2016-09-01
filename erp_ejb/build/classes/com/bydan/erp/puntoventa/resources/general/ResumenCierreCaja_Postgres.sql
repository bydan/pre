select 
	'EFECTIVO'as tipo_pago,
	fe.valor,
	f.total,
	(select nombre from seguridad.usuario where id=f.id_usuario)as nombre_usuario,
	(select nombre from puntoventa.caja c where id=f.id_caja)as nombre_caja,
	f.id_caja,
	f.id_usuario
from  puntoventa.factura_punto_venta f inner join puntoventa.forma_pago_efectivo_pun_ven fe
	on f.id=fe.id_factura_punto_venta
--where1

union

select 
	'CHEQUE'as tipo_pago,
	fc.valor,
	f.total,
	(select nombre from seguridad.usuario where id=f.id_usuario)as nombre_usuario,
	(select nombre from puntoventa.caja c where id=f.id_caja)as nombre_caja,
	f.id_caja,
	f.id_usuario
from puntoventa.factura_punto_venta f inner join puntoventa.forma_pago_cheque_pun_ven fc
	on f.id=fc.id_factura_punto_venta  
--where2

union

select 
	'TARJETA DE CREDITO'as tipo_pago,
	ft.valor,
	f.total,
	(select nombre from seguridad.usuario where id=f.id_usuario)as nombre_usuario,
	(select nombre from puntoventa.caja c where id=f.id_caja)as nombre_caja,
	f.id_caja,
	f.id_usuario
from puntoventa.factura_punto_venta f inner join puntoventa.forma_pago_tarjeta_pun_ven ft
	on f.id=ft.id_factura_punto_venta  
--where3

union

select 
	'CREDITO'as tipo_pago,
	fc.valor,
	f.total,
	(select nombre from seguridad.usuario where id=f.id_usuario)as nombre_usuario,
	(select nombre from puntoventa.caja c where id=f.id_caja)as nombre_caja,
	f.id_caja,
	f.id_usuario
from puntoventa.factura_punto_venta f inner join puntoventa.forma_pago_credito_pun_ven fc
	on f.id=fc.id_factura_punto_venta  
--where4