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
       (select nombre from puntoventa.caja c where id=f.id_caja)as nombre_caja,    
       'EFECTIVO'as tipo,
       fe.valor,
       fe.fecha as fecha_forma_pago,
       '' as numero_cuenta,
       '' as numero_cheque,
       '' as girador,
       0 as numero_dias_plazo,
       '' as numero_tarjeta,
       '' as autorizacion,
       '' as lote,
       f.id_cliente,
       f.id_caja
       
from puntoventa.factura_punto_venta f inner join puntoventa.forma_pago_efectivo_pun_ven fe
		on f.id=fe.id_factura_punto_venta
--where1

 union

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
       (select nombre from puntoventa.caja c where id=f.id_caja)as nombre_caja,    
       'CHEQUE'as tipo,
       fc.valor,
       fc.fecha as fecha_forma_pago,
       fc.numero_cuenta,  
       fc.numero_cheque,  
       fc.girador,
       0 as numero_dias_plazo, 
       '' as numero_tarjeta,
       '' as autorizacion,
       '' as lote,   
       f.id_cliente,
       f.id_caja
       
from puntoventa.factura_punto_venta f inner join puntoventa.forma_pago_cheque_pun_ven fc
		on f.id=fc.id_factura_punto_venta
--where2

  union
 
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
       (select nombre from puntoventa.caja c where id=f.id_caja)as nombre_caja,    
       'CREDITO'as tipo,
       fc.valor,
       fc.fecha as fecha_forma_pago,
       '' as numero_cuenta,
       '' as numero_cheque,
       '' as girador,
       fc.numero_dias_plazo,
       '' as numero_tarjeta,
       '' as autorizacion,
       '' as lote,       
       f.id_cliente,
       f.id_caja
       
from puntoventa.factura_punto_venta f inner join puntoventa.forma_pago_credito_pun_ven fc
		on f.id=fc.id_factura_punto_venta
--where3

 union	

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
       (select nombre from puntoventa.caja c where id=f.id_caja)as nombre_caja,    
       'TARJETA'as tipo,
       ft.valor,
       ft.fecha as fecha_forma_pago,
       '' as numero_cuenta,
       '' as numero_cheque,
       '' as girador,
       0 as numero_dias_plazo,
       ft.numero as numero_tarjeta,
       autorizacion,
       lote,
       f.id_cliente,
       f.id_caja
       
from puntoventa.factura_punto_venta f inner join puntoventa.forma_pago_tarjeta_pun_ven ft
		on f.id=ft.id_factura_punto_venta
  --where4