package com.bydan.framework.erp.business.logic;

public class ErpSql {
	public static String GetGeneralSqlWhere(Boolean conWhere,Long idEmpresa,Long idSucursal,Long idUsuario) {
		String sFinalQuery="";
		
		if(conWhere) {
			sFinalQuery+=" where ";
		}
		
		sFinalQuery+=" id_empresa="+idEmpresa + " and id_sucursal="+idSucursal + " and id_usuario="+idUsuario;
		
		return sFinalQuery;
	}
	
	public static String GetGeneralSqlWhere(Long idBodega,Long idProducto,Long idEmpresa,Long idSucursal) {
		String sFinalQuery="";
		
		sFinalQuery=" where id_bodega="+idBodega+" and id_producto="+idProducto;		
		sFinalQuery+=" and id_empresa="+idEmpresa+" and id_sucursal="+idSucursal;
		sFinalQuery+=" order by id desc limit 1 ";
		
		return sFinalQuery;
	}
}
