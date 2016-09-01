










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
import com.bydan.erp.inventario.util.report.ProductosServiciosExistenciasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;
////import com.bydan.erp.inventario.business.interfaces.ProductosServiciosExistenciasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ProductosServiciosExistenciasLogicAdditional extends ProductosServiciosExistenciasLogic{		
	
	public  ProductosServiciosExistenciasLogicAdditional(Connexion connexion)throws Exception {
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
	public  ProductosServiciosExistenciasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProductosServiciosExistenciasToSave(ProductosServiciosExistencias productosserviciosexistencias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProductosServiciosExistenciasToSave(ProductosServiciosExistencias productosserviciosexistencias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProductosServiciosExistenciasToSaveAfter(ProductosServiciosExistencias productosserviciosexistencias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProductosServiciosExistenciasToSaves(List<ProductosServiciosExistencias> productosserviciosexistenciass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProductosServiciosExistenciasToSaves(List<ProductosServiciosExistencias> productosserviciosexistenciass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProductosServiciosExistenciasToSavesAfter(List<ProductosServiciosExistencias> productosserviciosexistenciass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProductosServiciosExistenciasToGet(ProductosServiciosExistencias productosserviciosexistencias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProductosServiciosExistenciasToGets(List<ProductosServiciosExistencias> productosserviciosexistenciass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProductosServiciosExistenciasToSave(ProductosServiciosExistencias productosserviciosexistencias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProductosServiciosExistenciasToGet(ProductosServiciosExistencias productosserviciosexistencias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProductosServiciosExistenciasActions(String sTipoJsonResponse,JSONObject jsonObjectProductosServiciosExistencias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProductosServiciosExistenciasDataTable(String sTipoJsonResponse,ProductosServiciosExistencias productosserviciosexistencias,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProductosServiciosExistenciassDataTable(String sTipoJsonResponse,List<ProductosServiciosExistencias> productosserviciosexistenciass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProductosServiciosExistenciasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProductosServiciosExistenciassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProductosServiciosExistenciassColumns;
	}
	
	public static void updateJSONArrayProductosServiciosExistenciasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProductosServiciosExistencias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosProductosServiciosExistencias(ProductosServiciosExistencias productosserviciosexistencias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productosserviciosexistencias.setnombre_sucursal(productosserviciosexistencias.getnombre_sucursal().trim());
		productosserviciosexistencias.setnombre_linea(productosserviciosexistencias.getnombre_linea().trim());
		productosserviciosexistencias.setnombre_linea_grupo(productosserviciosexistencias.getnombre_linea_grupo().trim());
		productosserviciosexistencias.setnombre_linea_categoria(productosserviciosexistencias.getnombre_linea_categoria().trim());
		productosserviciosexistencias.setnombre_linea_marca(productosserviciosexistencias.getnombre_linea_marca().trim());
		productosserviciosexistencias.setcodigo(productosserviciosexistencias.getcodigo().trim());
		productosserviciosexistencias.setnombre(productosserviciosexistencias.getnombre().trim());
		productosserviciosexistencias.setnombre_tipo_producto_servicio(productosserviciosexistencias.getnombre_tipo_producto_servicio().trim());
		productosserviciosexistencias.setnombre_bodega(productosserviciosexistencias.getnombre_bodega().trim());
		productosserviciosexistencias.setnombre_unidad(productosserviciosexistencias.getnombre_unidad().trim());
	}
	
	public static void quitarEspaciosProductosServiciosExistenciass(List<ProductosServiciosExistencias> productosserviciosexistenciass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductosServiciosExistencias productosserviciosexistencias: productosserviciosexistenciass) {
			productosserviciosexistencias.setnombre_sucursal(productosserviciosexistencias.getnombre_sucursal().trim());
			productosserviciosexistencias.setnombre_linea(productosserviciosexistencias.getnombre_linea().trim());
			productosserviciosexistencias.setnombre_linea_grupo(productosserviciosexistencias.getnombre_linea_grupo().trim());
			productosserviciosexistencias.setnombre_linea_categoria(productosserviciosexistencias.getnombre_linea_categoria().trim());
			productosserviciosexistencias.setnombre_linea_marca(productosserviciosexistencias.getnombre_linea_marca().trim());
			productosserviciosexistencias.setcodigo(productosserviciosexistencias.getcodigo().trim());
			productosserviciosexistencias.setnombre(productosserviciosexistencias.getnombre().trim());
			productosserviciosexistencias.setnombre_tipo_producto_servicio(productosserviciosexistencias.getnombre_tipo_producto_servicio().trim());
			productosserviciosexistencias.setnombre_bodega(productosserviciosexistencias.getnombre_bodega().trim());
			productosserviciosexistencias.setnombre_unidad(productosserviciosexistencias.getnombre_unidad().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosServiciosExistencias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ProductosServiciosExistenciasConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ProductosServiciosExistenciasConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductosServiciosExistencias> productosserviciosexistenciass,ProductosServiciosExistencias productosserviciosexistencias,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductosServiciosExistencias productosserviciosexistenciasAux: productosserviciosexistenciass) {
			if((productosserviciosexistenciasAux.getId()==null && productosserviciosexistencias.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(productosserviciosexistenciasAux.getId()!=null && productosserviciosexistencias.getId()!=null){
				if(productosserviciosexistenciasAux.getId().equals(productosserviciosexistencias.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductosServiciosExistencias(List<ProductosServiciosExistencias> productosserviciosexistenciass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cantidad_reservadaTotal=0.0;
		Double cantidad_pedidaTotal=0.0;
		Double total_egresoTotal=0.0;
		Double total_compraTotal=0.0;
		Double total_devueltoTotal=0.0;
	
		for(ProductosServiciosExistencias productosserviciosexistencias: productosserviciosexistenciass) {			
			cantidad_reservadaTotal+=productosserviciosexistencias.getcantidad_reservada();
			cantidad_pedidaTotal+=productosserviciosexistencias.getcantidad_pedida();
			total_egresoTotal+=productosserviciosexistencias.gettotal_egreso();
			total_compraTotal+=productosserviciosexistencias.gettotal_compra();
			total_devueltoTotal+=productosserviciosexistencias.gettotal_devuelto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.CANTIDADRESERVADA);
		datoGeneral.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADRESERVADA);
		datoGeneral.setdValorDouble(cantidad_reservadaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.CANTIDADPEDIDA);
		datoGeneral.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_CANTIDADPEDIDA);
		datoGeneral.setdValorDouble(cantidad_pedidaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.TOTALEGRESO);
		datoGeneral.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALEGRESO);
		datoGeneral.setdValorDouble(total_egresoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.TOTALCOMPRA);
		datoGeneral.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALCOMPRA);
		datoGeneral.setdValorDouble(total_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosExistenciasConstantesFunciones.TOTALDEVUELTO);
		datoGeneral.setsDescripcion(ProductosServiciosExistenciasConstantesFunciones.LABEL_TOTALDEVUELTO);
		datoGeneral.setdValorDouble(total_devueltoTotal);
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