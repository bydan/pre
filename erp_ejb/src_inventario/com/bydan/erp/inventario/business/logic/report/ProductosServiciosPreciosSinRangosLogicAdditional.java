










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
import com.bydan.erp.inventario.util.report.ProductosServiciosPreciosSinRangosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;
////import com.bydan.erp.inventario.business.interfaces.ProductosServiciosPreciosSinRangosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ProductosServiciosPreciosSinRangosLogicAdditional extends ProductosServiciosPreciosSinRangosLogic{		
	
	public  ProductosServiciosPreciosSinRangosLogicAdditional(Connexion connexion)throws Exception {
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
	public  ProductosServiciosPreciosSinRangosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProductosServiciosPreciosSinRangosToSave(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProductosServiciosPreciosSinRangosToSave(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProductosServiciosPreciosSinRangosToSaveAfter(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProductosServiciosPreciosSinRangosToSaves(List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProductosServiciosPreciosSinRangosToSaves(List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProductosServiciosPreciosSinRangosToSavesAfter(List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProductosServiciosPreciosSinRangosToGet(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProductosServiciosPreciosSinRangosToGets(List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProductosServiciosPreciosSinRangosToSave(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProductosServiciosPreciosSinRangosToGet(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProductosServiciosPreciosSinRangosActions(String sTipoJsonResponse,JSONObject jsonObjectProductosServiciosPreciosSinRangos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProductosServiciosPreciosSinRangosDataTable(String sTipoJsonResponse,ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProductosServiciosPreciosSinRangossDataTable(String sTipoJsonResponse,List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProductosServiciosPreciosSinRangosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProductosServiciosPreciosSinRangossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProductosServiciosPreciosSinRangossColumns;
	}
	
	public static void updateJSONArrayProductosServiciosPreciosSinRangosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProductosServiciosPreciosSinRangos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosProductosServiciosPreciosSinRangos(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productosserviciospreciossinrangos.setnombre_sucursal(productosserviciospreciossinrangos.getnombre_sucursal().trim());
		productosserviciospreciossinrangos.setcodigo(productosserviciospreciossinrangos.getcodigo().trim());
		productosserviciospreciossinrangos.setnombre(productosserviciospreciossinrangos.getnombre().trim());
		productosserviciospreciossinrangos.setnombre_bodega(productosserviciospreciossinrangos.getnombre_bodega().trim());
		productosserviciospreciossinrangos.setnombre_unidad(productosserviciospreciossinrangos.getnombre_unidad().trim());
		productosserviciospreciossinrangos.setcodigo_tipo_precio(productosserviciospreciossinrangos.getcodigo_tipo_precio().trim());
	}
	
	public static void quitarEspaciosProductosServiciosPreciosSinRangoss(List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos: productosserviciospreciossinrangoss) {
			productosserviciospreciossinrangos.setnombre_sucursal(productosserviciospreciossinrangos.getnombre_sucursal().trim());
			productosserviciospreciossinrangos.setcodigo(productosserviciospreciossinrangos.getcodigo().trim());
			productosserviciospreciossinrangos.setnombre(productosserviciospreciossinrangos.getnombre().trim());
			productosserviciospreciossinrangos.setnombre_bodega(productosserviciospreciossinrangos.getnombre_bodega().trim());
			productosserviciospreciossinrangos.setnombre_unidad(productosserviciospreciossinrangos.getnombre_unidad().trim());
			productosserviciospreciossinrangos.setcodigo_tipo_precio(productosserviciospreciossinrangos.getcodigo_tipo_precio().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosServiciosPreciosSinRangos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ProductosServiciosPreciosSinRangosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ProductosServiciosPreciosSinRangosConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss,ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangosAux: productosserviciospreciossinrangoss) {
			if((productosserviciospreciossinrangosAux.getId()==null && productosserviciospreciossinrangos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(productosserviciospreciossinrangosAux.getId()!=null && productosserviciospreciossinrangos.getId()!=null){
				if(productosserviciospreciossinrangosAux.getId().equals(productosserviciospreciossinrangos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductosServiciosPreciosSinRangos(List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
	
		for(ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos: productosserviciospreciossinrangoss) {			
			precioTotal+=productosserviciospreciossinrangos.getprecio();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosPreciosSinRangosConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(ProductosServiciosPreciosSinRangosConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
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