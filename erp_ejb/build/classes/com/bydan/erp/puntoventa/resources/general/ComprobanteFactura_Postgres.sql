select f.fecha,
       f.secuencial, 
       f.codigo_cliente, 
       f.nombre_cliente,
       f.subtotal, 
       f.iva, 
       f.descuento, 
       f.financiamiento, 
       f.flete, 
       f.ice, 
       f.total,  
	       ((select count(*) from puntoventa.forma_pago_efectivo_pun_ven fe where fe.id_factura_punto_venta=f.id)+ 
		(select count(*) from puntoventa.forma_pago_cheque_pun_ven fe where fe.id_factura_punto_venta=f.id) +
		(select count(*) from puntoventa.forma_pago_tarjeta_pun_ven fe where fe.id_factura_punto_venta=f.id) +
		(select count(*) from puntoventa.forma_pago_credito_pun_ven fe where fe.id_factura_punto_venta=f.id)
	       )as cantidad_formas_pago,
       (select sum((cantidad * precio)-((cantidad * precio)*(descuento/100)) * (descuento/100)) from puntoventa.detalle_factura_punto_venta) as descuento_real,
       (select nombre from puntoventa.caja c where id=f.id_caja)as nombre_caja,      
       f.id_cliente,
       f.id_caja
       
from puntoventa.factura_punto_venta f   
  --where