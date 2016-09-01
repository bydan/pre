














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
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMermaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;
//import com.bydan.erp.produccion.business.interfaces.ProductoOrdenDetaProduMermaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class ProductoOrdenDetaProduMermaLogicAdditional extends ProductoOrdenDetaProduMermaLogic { // implements ProductoOrdenDetaProduMermaAdditionable{
	public  ProductoOrdenDetaProduMermaLogicAdditional(Connexion connexion)throws Exception {
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
	public  ProductoOrdenDetaProduMermaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProductoOrdenDetaProduMermaToSave(ProductoOrdenDetaProduMerma productoordendetaprodumerma,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProductoOrdenDetaProduMermaToSave(ProductoOrdenDetaProduMerma productoordendetaprodumerma,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProductoOrdenDetaProduMermaToSaveAfter(ProductoOrdenDetaProduMerma productoordendetaprodumerma,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProductoOrdenDetaProduMermaToSaves(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProductoOrdenDetaProduMermaToSaves(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProductoOrdenDetaProduMermaToSavesAfter(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProductoOrdenDetaProduMermaToGet(ProductoOrdenDetaProduMerma productoordendetaprodumerma,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProductoOrdenDetaProduMermaToGets(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProductoOrdenDetaProduMermaToSave(ProductoOrdenDetaProduMerma productoordendetaprodumerma,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProductoOrdenDetaProduMermaToGet(ProductoOrdenDetaProduMerma productoordendetaprodumerma,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProductoOrdenDetaProduMermaActions(String sTipoJsonResponse,JSONObject jsonObjectProductoOrdenDetaProduMerma,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProductoOrdenDetaProduMermaDataTable(String sTipoJsonResponse,ProductoOrdenDetaProduMerma productoordendetaprodumerma,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProductoOrdenDetaProduMermasDataTable(String sTipoJsonResponse,List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProductoOrdenDetaProduMermaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProductoOrdenDetaProduMermasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProductoOrdenDetaProduMermasColumns;
	}
	
	public static void updateJSONArrayProductoOrdenDetaProduMermaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProductoOrdenDetaProduMerma,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosProductoOrdenDetaProduMerma(ProductoOrdenDetaProduMerma productoordendetaprodumerma,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoordendetaprodumerma.setdescripcion(productoordendetaprodumerma.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoOrdenDetaProduMermas(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoOrdenDetaProduMerma productoordendetaprodumerma: productoordendetaprodumermas) {
			productoordendetaprodumerma.setdescripcion(productoordendetaprodumerma.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoOrdenDetaProduMerma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas,ProductoOrdenDetaProduMerma productoordendetaprodumerma,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoOrdenDetaProduMerma productoordendetaprodumermaAux: productoordendetaprodumermas) {
			if((productoordendetaprodumermaAux.getId()==null && productoordendetaprodumerma.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(productoordendetaprodumermaAux.getId()!=null && productoordendetaprodumerma.getId()!=null){
				if(productoordendetaprodumermaAux.getId().equals(productoordendetaprodumerma.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoOrdenDetaProduMerma(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(ProductoOrdenDetaProduMerma productoordendetaprodumerma: productoordendetaprodumermas) {			
			costoTotal+=productoordendetaprodumerma.getcosto();
			costo_totalTotal+=productoordendetaprodumerma.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduMermaConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduMermaConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduMermaConstantesFunciones.LABEL_COSTOTOTAL);
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