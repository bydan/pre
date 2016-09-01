package com.bydan.erp.inventario.util;

import com.bydan.erp.inventario.business.entity.Bodega;
import com.bydan.erp.inventario.business.entity.Producto;
import com.bydan.erp.inventario.util.BodegaProductoConstantesFunciones;
import com.bydan.erp.inventario.util.CostoConstantesFunciones;

public class InventarioSql {
	public static String GetBodegaProductoSqlWhere(Long idEmpresa,Long idBodega,Long idProducto) {
		String sFinalQuery="";
		
		sFinalQuery=" where "+BodegaProductoConstantesFunciones.IDEMPRESA+"="+idEmpresa+" and "+BodegaProductoConstantesFunciones.IDBODEGA+"="+idBodega+" and "+BodegaProductoConstantesFunciones.IDPRODUCTO+"="+idProducto;		
		
		
		return sFinalQuery;
	}
	
	
	public static String GetCostoSqlWhere(Long idBodega,Long idProducto,Long idEmpresa,Long idSucursal) {
		String sFinalQuery="";
		
		sFinalQuery=" where "+CostoConstantesFunciones.IDBODEGA+"="+idBodega+" and "+CostoConstantesFunciones.IDPRODUCTO+"="+idProducto;		
		sFinalQuery+=" and "+CostoConstantesFunciones.IDEMPRESA+"="+idEmpresa+" and "+CostoConstantesFunciones.IDSUCURSAL+"="+idSucursal;
		sFinalQuery+=" order by id desc limit 1 ";
		
		return sFinalQuery;
	}
	
	public static String GetDefinicionSqlWhere(Long idTransaccion) {
		String sFinalQuery="";
		
		sFinalQuery=" where id_transaccion="+idTransaccion;
		
		return sFinalQuery;
	}
	
	public static String GetTransaccionSqlWhere(Long id_empresa,Long id_sucursal,String sTipo) throws Exception {
		String sFinalQuery="";
		String sTipoFinalQuery="";
		
		
		if(sTipo=="COMPRA") {
			sTipoFinalQuery=" and id_modulo=5 and id_tipo_transaccion_modulo=36 ";
			
		} else if(sTipo=="PEDIDO_COMPRA") {
			sTipoFinalQuery=" and id_modulo=5 and id_tipo_transaccion_modulo=50 ";
			
		}  else if(sTipo=="ORDEN_COMPRA") {
			sTipoFinalQuery=" and id_modulo=5 and id_tipo_transaccion_modulo=7 ";
			
		} else if(sTipo=="REQUISICION_BODEGA") {
			sTipoFinalQuery=" and id_modulo=5 and id_tipo_transaccion_modulo=51 ";
		
		} else if(sTipo=="REQUISICION") {
			sTipoFinalQuery=" and id_modulo=5 and id_tipo_transaccion_modulo=52 ";
		
		} else if(sTipo=="TRANSFERENCIA") {
			sTipoFinalQuery=" and id_modulo=5 and id_tipo_transaccion_modulo=40 ";
		
		} else {
			throw new Exception("TIPO INEXISTENTE: "+sTipo);
		}
			
		
		sFinalQuery=" where id_empresa=" + id_empresa + " and id_sucursal=" + id_sucursal + sTipoFinalQuery;
		
		return sFinalQuery;
	}
	
	public static String GetFormatoSqlWhere(Long id_empresa,String sTipo) throws Exception {
		String sFinalQuery="";
		String sTipoFinalQuery="";
		
		
		if(sTipo=="COMPRA") {
			sTipoFinalQuery=" and id_modulo=5 and id_tipo_formato=6 ";
			
		} else if(sTipo=="PEDIDO_COMPRA") {
			sTipoFinalQuery=" and id_modulo=5 and id_tipo_formato=37 ";
			
		} else if(sTipo=="ORDEN_COMPRA") {
			sTipoFinalQuery=" and id_modulo=5 and id_tipo_formato=30 ";
			
		} else if(sTipo=="REQUISICION_BODEGA") {
			sTipoFinalQuery=" and id_modulo=5 and id_tipo_formato=41 ";
		
		} else if(sTipo=="REQUISICION") {
			sTipoFinalQuery=" and id_modulo=5 and id_tipo_formato=42 ";
		
		} else if(sTipo=="TRANSFERENCIA") {
			sTipoFinalQuery=" and id_modulo=5 and id_tipo_formato=39 ";
			
		} else if(sTipo=="FACTURA_PUNTO_VENTA") {
			sTipoFinalQuery=" and id_modulo=3 and id_tipo_formato=13 ";
		
		} else if(sTipo=="NOTA_VENTA_PUNTO_VENTA") {
			sTipoFinalQuery=" and id_modulo=3 and id_tipo_formato=26 ";
		
		} else if(sTipo=="NOTA_CREDITO_PUNTO_VENTA") {
			sTipoFinalQuery=" and id_modulo=3 and id_tipo_formato=28 ";
		
		} else {
			throw new Exception("TIPO INEXISTENTE "+sTipo);
		}
		
		sFinalQuery=" where id_empresa=" + id_empresa + sTipoFinalQuery;
		
		return sFinalQuery;
	}
	
	public static String GetPrecioSqlWhere(Long idBodega,Long idProducto,Long idEmpresa,Long idSucursal,Long idTipoPrecio) {
		String sFinalQuery="";
		
		sFinalQuery=" where id_bodega="+idBodega+" and id_producto="+idProducto;		
		sFinalQuery+=" and id_empresa="+idEmpresa+" and id_sucursal="+idSucursal;
		sFinalQuery+=" and id_tipo_precio="+idTipoPrecio;
		//sFinalQuery+=" order by id desc limit 1 ";
		
		return sFinalQuery;
	}
	
	public static String GetQueryProductoFromBodega(Bodega bodegaLocal) {
		String sFinalQuery="  inner join inventario.bodega_producto on producto.id=bodega_producto.id_producto WHERE  bodega_producto.id_bodega="+bodegaLocal.getId();
		
		return sFinalQuery;
	}
	
	public static String GetQueryUnidadFromBodegaYProducto(Producto productoLocal,Long id_bodega) {
		String sFinalQuery="  inner join inventario.bodega_producto on unidad.id=bodega_producto.id_unidad WHERE bodega_producto.id_bodega="+id_bodega +" and bodega_producto.id_producto="+productoLocal.getId();
		
		return sFinalQuery;
	}
}
