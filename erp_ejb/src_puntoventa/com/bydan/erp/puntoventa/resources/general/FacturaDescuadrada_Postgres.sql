select f.fecha,
       f.secuencial, 
       f.subtotal, 
       f.iva, 
       f.descuento, 
       f.financiamiento, 
       f.flete, 
       f.ice, 
       coalesce(round(f.total,2),0.0) as total,  
	       coalesce(round(((select sum(valor) from puntoventa.forma_pago_efectivo_pun_ven fe where fe.id_factura_punto_venta=f.id)+ 
		(select sum(valor) from puntoventa.forma_pago_cheque_pun_ven fc where fc.id_factura_punto_venta=f.id) +
		(select sum(valor) from puntoventa.forma_pago_tarjeta_pun_ven ft where ft.id_factura_punto_venta=f.id) +
		(select sum(valor) from puntoventa.forma_pago_credito_pun_ven fcr where fcr.id_factura_punto_venta=f.id)
	       ),2),0.0)as total_formas_pago,
       (select sum((cantidad * precio)-((cantidad * precio)*(descuento/100)) * (descuento/100)) from puntoventa.detalle_factura_punto_venta) as descuento_real

from puntoventa.factura_punto_venta f 

where coalesce(round(f.total,2),0.0) != coalesce(round(((select sum(valor) from puntoventa.forma_pago_efectivo_pun_ven fe where fe.id_factura_punto_venta=f.id)+ 
		(select sum(valor) from puntoventa.forma_pago_cheque_pun_ven fc where fc.id_factura_punto_venta=f.id) +
		(select sum(valor) from puntoventa.forma_pago_tarjeta_pun_ven ft where ft.id_factura_punto_venta=f.id) +
		(select sum(valor) from puntoventa.forma_pago_credito_pun_ven fcr where fcr.id_factura_punto_venta=f.id)
	       ),2),0.0)
--where	    