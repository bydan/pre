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
       (select nombre from puntoventa.tarjeta_credito where id=ft.id_tarjeta_credito)as nombre_tarjeta,
       (select nombre from tesoreria.banco where id=(select id_banco from puntoventa.tarjeta_credito where id=ft.id_tarjeta_credito))as nombre_banco,
       (select nombre from contabilidad.tipo_retencion where id=(select id_tipo_retencion from puntoventa.tarjeta_credito where id=ft.id_tarjeta_credito))as nombre_retencion,
       ft.valor,
       ft.fecha as fecha_forma_pago,
       ft.numero,
       ft.tarjeta_habiente,
       ft.autorizacion,
       ft.voucher,
       ft.lote,
       f.id_cliente,
       f.id_caja
       
  from puntoventa.factura_punto_venta f inner join puntoventa.forma_pago_tarjeta_pun_ven ft
  		on f.id=ft.id_factura_punto_venta
  --where