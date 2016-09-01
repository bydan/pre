SELECT   
		a.id as id_asiento_contable,
		a.numero_mayor,   
         (select codigo from contabilidad.cuenta_contable c where c.id=d.id_cuenta_contable)as codigo,            
         (select nombre from contabilidad.cuenta_contable c where c.id=d.id_cuenta_contable)as nombre,
         d.debito_local,   
         d.credito_local,   
         d.debito_extran,   
         d.credito_extran,   
         a.codigo as codigo_asiento,   
         a.fecha,   
         d.detalle,
         (select nombre from contabilidad.tipo_movimiento t where t.id=a.id_tipo_movimiento ) as tipo_movimiento,
	 	 (select nombre from contabilidad.estado_asiento_contable e where e.id=a.id_estado_asiento_contable) as nombre_estado
    FROM contabilidad.asiento_contable a inner join contabilidad.detalle_asiento_contable d on
	 a.id=d.id_asiento_contable