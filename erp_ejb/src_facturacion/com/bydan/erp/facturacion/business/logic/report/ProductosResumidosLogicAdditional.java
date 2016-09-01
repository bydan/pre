










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.facturacion.business.logic.report;

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
import com.bydan.erp.facturacion.util.report.ProductosResumidosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;
////import com.bydan.erp.facturacion.business.interfaces.ProductosResumidosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ProductosResumidosLogicAdditional extends ProductosResumidosLogic{		
	
	public  ProductosResumidosLogicAdditional(Connexion connexion)throws Exception {
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
	public  ProductosResumidosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProductosResumidosToSave(ProductosResumidos productosresumidos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProductosResumidosToSave(ProductosResumidos productosresumidos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProductosResumidosToSaveAfter(ProductosResumidos productosresumidos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProductosResumidosToSaves(List<ProductosResumidos> productosresumidoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProductosResumidosToSaves(List<ProductosResumidos> productosresumidoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProductosResumidosToSavesAfter(List<ProductosResumidos> productosresumidoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProductosResumidosToGet(ProductosResumidos productosresumidos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProductosResumidosToGets(List<ProductosResumidos> productosresumidoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProductosResumidosToSave(ProductosResumidos productosresumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProductosResumidosToGet(ProductosResumidos productosresumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProductosResumidosActions(String sTipoJsonResponse,JSONObject jsonObjectProductosResumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProductosResumidosDataTable(String sTipoJsonResponse,ProductosResumidos productosresumidos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProductosResumidossDataTable(String sTipoJsonResponse,List<ProductosResumidos> productosresumidoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProductosResumidosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProductosResumidossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProductosResumidossColumns;
	}
	
	public static void updateJSONArrayProductosResumidosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProductosResumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosProductosResumidos(ProductosResumidos productosresumidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productosresumidos.setnombre_unidad(productosresumidos.getnombre_unidad().trim());
		productosresumidos.setnombre_producto(productosresumidos.getnombre_producto().trim());
		productosresumidos.setcodigo_producto(productosresumidos.getcodigo_producto().trim());
		productosresumidos.settipo(productosresumidos.gettipo().trim());
	}
	
	public static void quitarEspaciosProductosResumidoss(List<ProductosResumidos> productosresumidoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductosResumidos productosresumidos: productosresumidoss) {
			productosresumidos.setnombre_unidad(productosresumidos.getnombre_unidad().trim());
			productosresumidos.setnombre_producto(productosresumidos.getnombre_producto().trim());
			productosresumidos.setcodigo_producto(productosresumidos.getcodigo_producto().trim());
			productosresumidos.settipo(productosresumidos.gettipo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosResumidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ProductosResumidosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ProductosResumidosConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductosResumidos> productosresumidoss,ProductosResumidos productosresumidos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductosResumidos productosresumidosAux: productosresumidoss) {
			if((productosresumidosAux.getId()==null && productosresumidos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(productosresumidosAux.getId()!=null && productosresumidos.getId()!=null){
				if(productosresumidosAux.getId().equals(productosresumidos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductosResumidos(List<ProductosResumidos> productosresumidoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
	
		for(ProductosResumidos productosresumidos: productosresumidoss) {			
			montoTotal+=productosresumidos.getmonto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosResumidosConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(ProductosResumidosConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
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