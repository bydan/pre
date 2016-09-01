










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
import com.bydan.erp.inventario.util.report.ProductosBodegasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;
////import com.bydan.erp.inventario.business.interfaces.ProductosBodegasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ProductosBodegasLogicAdditional extends ProductosBodegasLogic{		
	
	public  ProductosBodegasLogicAdditional(Connexion connexion)throws Exception {
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
	public  ProductosBodegasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProductosBodegasToSave(ProductosBodegas productosbodegas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProductosBodegasToSave(ProductosBodegas productosbodegas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProductosBodegasToSaveAfter(ProductosBodegas productosbodegas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProductosBodegasToSaves(List<ProductosBodegas> productosbodegass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProductosBodegasToSaves(List<ProductosBodegas> productosbodegass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProductosBodegasToSavesAfter(List<ProductosBodegas> productosbodegass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProductosBodegasToGet(ProductosBodegas productosbodegas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProductosBodegasToGets(List<ProductosBodegas> productosbodegass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProductosBodegasToSave(ProductosBodegas productosbodegas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProductosBodegasToGet(ProductosBodegas productosbodegas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProductosBodegasActions(String sTipoJsonResponse,JSONObject jsonObjectProductosBodegas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProductosBodegasDataTable(String sTipoJsonResponse,ProductosBodegas productosbodegas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProductosBodegassDataTable(String sTipoJsonResponse,List<ProductosBodegas> productosbodegass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProductosBodegasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProductosBodegassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProductosBodegassColumns;
	}
	
	public static void updateJSONArrayProductosBodegasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProductosBodegas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosProductosBodegas(ProductosBodegas productosbodegas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productosbodegas.setnombre_sucursal(productosbodegas.getnombre_sucursal().trim());
		productosbodegas.setnombre_linea(productosbodegas.getnombre_linea().trim());
		productosbodegas.setnombre_linea_grupo(productosbodegas.getnombre_linea_grupo().trim());
		productosbodegas.setnombre_linea_categoria(productosbodegas.getnombre_linea_categoria().trim());
		productosbodegas.setnombre_linea_marca(productosbodegas.getnombre_linea_marca().trim());
		productosbodegas.setcodigo(productosbodegas.getcodigo().trim());
		productosbodegas.setnombre(productosbodegas.getnombre().trim());
		productosbodegas.setnombre_bodega(productosbodegas.getnombre_bodega().trim());
	}
	
	public static void quitarEspaciosProductosBodegass(List<ProductosBodegas> productosbodegass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductosBodegas productosbodegas: productosbodegass) {
			productosbodegas.setnombre_sucursal(productosbodegas.getnombre_sucursal().trim());
			productosbodegas.setnombre_linea(productosbodegas.getnombre_linea().trim());
			productosbodegas.setnombre_linea_grupo(productosbodegas.getnombre_linea_grupo().trim());
			productosbodegas.setnombre_linea_categoria(productosbodegas.getnombre_linea_categoria().trim());
			productosbodegas.setnombre_linea_marca(productosbodegas.getnombre_linea_marca().trim());
			productosbodegas.setcodigo(productosbodegas.getcodigo().trim());
			productosbodegas.setnombre(productosbodegas.getnombre().trim());
			productosbodegas.setnombre_bodega(productosbodegas.getnombre_bodega().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosBodegas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ProductosBodegasConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ProductosBodegasConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductosBodegas> productosbodegass,ProductosBodegas productosbodegas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductosBodegas productosbodegasAux: productosbodegass) {
			if((productosbodegasAux.getId()==null && productosbodegas.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(productosbodegasAux.getId()!=null && productosbodegas.getId()!=null){
				if(productosbodegasAux.getId().equals(productosbodegas.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductosBodegas(List<ProductosBodegas> productosbodegass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProductosBodegas productosbodegas: productosbodegass) {			
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