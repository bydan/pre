










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.inventario.business.logic.report;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.inventario.util.report.ProductosServiciosProductosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;
////import com.bydan.erp.inventario.business.interfaces.ProductosServiciosProductosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ProductosServiciosProductosLogicAdditional extends ProductosServiciosProductosLogic{		
	
	public  ProductosServiciosProductosLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19


			return generalEntityReturnGeneral;

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;

		} finally {

		}
	}

	//CONTROL_INICIO
	public  ProductosServiciosProductosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProductosServiciosProductosToSave(ProductosServiciosProductos productosserviciosproductos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProductosServiciosProductosToSave(ProductosServiciosProductos productosserviciosproductos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProductosServiciosProductosToSaveAfter(ProductosServiciosProductos productosserviciosproductos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProductosServiciosProductosToSaves(List<ProductosServiciosProductos> productosserviciosproductoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProductosServiciosProductosToSaves(List<ProductosServiciosProductos> productosserviciosproductoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProductosServiciosProductosToSavesAfter(List<ProductosServiciosProductos> productosserviciosproductoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProductosServiciosProductosToGet(ProductosServiciosProductos productosserviciosproductos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProductosServiciosProductosToGets(List<ProductosServiciosProductos> productosserviciosproductoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProductosServiciosProductosToSave(ProductosServiciosProductos productosserviciosproductos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProductosServiciosProductosToGet(ProductosServiciosProductos productosserviciosproductos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProductosServiciosProductosActions(String sTipoJsonResponse,JSONObject jsonObjectProductosServiciosProductos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProductosServiciosProductosDataTable(String sTipoJsonResponse,ProductosServiciosProductos productosserviciosproductos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProductosServiciosProductossDataTable(String sTipoJsonResponse,List<ProductosServiciosProductos> productosserviciosproductoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProductosServiciosProductosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProductosServiciosProductossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProductosServiciosProductossColumns;
	}
	
	public static void updateJSONArrayProductosServiciosProductosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProductosServiciosProductos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosProductosServiciosProductos(ProductosServiciosProductos productosserviciosproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productosserviciosproductos.setnombre_sucursal(productosserviciosproductos.getnombre_sucursal().trim());
		productosserviciosproductos.setnombre_linea(productosserviciosproductos.getnombre_linea().trim());
		productosserviciosproductos.setnombre_linea_grupo(productosserviciosproductos.getnombre_linea_grupo().trim());
		productosserviciosproductos.setnombre_linea_categoria(productosserviciosproductos.getnombre_linea_categoria().trim());
		productosserviciosproductos.setnombre_linea_marca(productosserviciosproductos.getnombre_linea_marca().trim());
		productosserviciosproductos.setcodigo(productosserviciosproductos.getcodigo().trim());
		productosserviciosproductos.setnombre(productosserviciosproductos.getnombre().trim());
		productosserviciosproductos.setnombre_tipo_producto_servicio(productosserviciosproductos.getnombre_tipo_producto_servicio().trim());
		productosserviciosproductos.setnombre_bodega(productosserviciosproductos.getnombre_bodega().trim());
		productosserviciosproductos.setnombre_unidad(productosserviciosproductos.getnombre_unidad().trim());
	}
	
	public static void quitarEspaciosProductosServiciosProductoss(List<ProductosServiciosProductos> productosserviciosproductoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductosServiciosProductos productosserviciosproductos: productosserviciosproductoss) {
			productosserviciosproductos.setnombre_sucursal(productosserviciosproductos.getnombre_sucursal().trim());
			productosserviciosproductos.setnombre_linea(productosserviciosproductos.getnombre_linea().trim());
			productosserviciosproductos.setnombre_linea_grupo(productosserviciosproductos.getnombre_linea_grupo().trim());
			productosserviciosproductos.setnombre_linea_categoria(productosserviciosproductos.getnombre_linea_categoria().trim());
			productosserviciosproductos.setnombre_linea_marca(productosserviciosproductos.getnombre_linea_marca().trim());
			productosserviciosproductos.setcodigo(productosserviciosproductos.getcodigo().trim());
			productosserviciosproductos.setnombre(productosserviciosproductos.getnombre().trim());
			productosserviciosproductos.setnombre_tipo_producto_servicio(productosserviciosproductos.getnombre_tipo_producto_servicio().trim());
			productosserviciosproductos.setnombre_bodega(productosserviciosproductos.getnombre_bodega().trim());
			productosserviciosproductos.setnombre_unidad(productosserviciosproductos.getnombre_unidad().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosServiciosProductos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ProductosServiciosProductosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ProductosServiciosProductosConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductosServiciosProductos> productosserviciosproductoss,ProductosServiciosProductos productosserviciosproductos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductosServiciosProductos productosserviciosproductosAux: productosserviciosproductoss) {
			if((productosserviciosproductosAux.getId()==null && productosserviciosproductos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(productosserviciosproductosAux.getId()!=null && productosserviciosproductos.getId()!=null){
				if(productosserviciosproductosAux.getId().equals(productosserviciosproductos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductosServiciosProductos(List<ProductosServiciosProductos> productosserviciosproductoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProductosServiciosProductos productosserviciosproductos: productosserviciosproductoss) {			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	//PARA ACCIONES NORMALES
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {
		try {

			//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();


			return generalEntityReturnGeneral;

		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;

		} finally {

		}
	}

	//CONTROL_FUNCION2
}