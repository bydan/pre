














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.produccion.business.logic;

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
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduGastoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;
//import com.bydan.erp.produccion.business.interfaces.ProductoOrdenDetaProduGastoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class ProductoOrdenDetaProduGastoLogicAdditional extends ProductoOrdenDetaProduGastoLogic { // implements ProductoOrdenDetaProduGastoAdditionable{
	public  ProductoOrdenDetaProduGastoLogicAdditional(Connexion connexion)throws Exception {
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


	public static Boolean validarSaveRelaciones(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_20
		Boolean validado=true;

		return validado;	
	}


	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}

	//CONTROL_INICIO
	public  ProductoOrdenDetaProduGastoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProductoOrdenDetaProduGastoToSave(ProductoOrdenDetaProduGasto productoordendetaprodugasto,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProductoOrdenDetaProduGastoToSave(ProductoOrdenDetaProduGasto productoordendetaprodugasto,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProductoOrdenDetaProduGastoToSaveAfter(ProductoOrdenDetaProduGasto productoordendetaprodugasto,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProductoOrdenDetaProduGastoToSaves(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProductoOrdenDetaProduGastoToSaves(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProductoOrdenDetaProduGastoToSavesAfter(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProductoOrdenDetaProduGastoToGet(ProductoOrdenDetaProduGasto productoordendetaprodugasto,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProductoOrdenDetaProduGastoToGets(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProductoOrdenDetaProduGastoToSave(ProductoOrdenDetaProduGasto productoordendetaprodugasto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProductoOrdenDetaProduGastoToGet(ProductoOrdenDetaProduGasto productoordendetaprodugasto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProductoOrdenDetaProduGastoActions(String sTipoJsonResponse,JSONObject jsonObjectProductoOrdenDetaProduGasto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProductoOrdenDetaProduGastoDataTable(String sTipoJsonResponse,ProductoOrdenDetaProduGasto productoordendetaprodugasto,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProductoOrdenDetaProduGastosDataTable(String sTipoJsonResponse,List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProductoOrdenDetaProduGastoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProductoOrdenDetaProduGastosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProductoOrdenDetaProduGastosColumns;
	}
	
	public static void updateJSONArrayProductoOrdenDetaProduGastoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProductoOrdenDetaProduGasto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosProductoOrdenDetaProduGasto(ProductoOrdenDetaProduGasto productoordendetaprodugasto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoordendetaprodugasto.setdescripcion(productoordendetaprodugasto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoOrdenDetaProduGastos(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoOrdenDetaProduGasto productoordendetaprodugasto: productoordendetaprodugastos) {
			productoordendetaprodugasto.setdescripcion(productoordendetaprodugasto.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoOrdenDetaProduGasto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos,ProductoOrdenDetaProduGasto productoordendetaprodugasto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoOrdenDetaProduGasto productoordendetaprodugastoAux: productoordendetaprodugastos) {
			if((productoordendetaprodugastoAux.getId()==null && productoordendetaprodugasto.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(productoordendetaprodugastoAux.getId()!=null && productoordendetaprodugasto.getId()!=null){
				if(productoordendetaprodugastoAux.getId().equals(productoordendetaprodugasto.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoOrdenDetaProduGasto(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(ProductoOrdenDetaProduGasto productoordendetaprodugasto: productoordendetaprodugastos) {			
			costoTotal+=productoordendetaprodugasto.getcosto();
			costo_totalTotal+=productoordendetaprodugasto.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduGastoConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduGastoConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduGastoConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
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