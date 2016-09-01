














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
import com.bydan.erp.produccion.util.ProductoProduConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;
//import com.bydan.erp.produccion.business.interfaces.ProductoProduAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class ProductoProduLogicAdditional extends ProductoProduLogic { // implements ProductoProduAdditionable{
	public  ProductoProduLogicAdditional(Connexion connexion)throws Exception {
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
	public  ProductoProduLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProductoProduToSave(ProductoProdu productoprodu,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProductoProduToSave(ProductoProdu productoprodu,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProductoProduToSaveAfter(ProductoProdu productoprodu,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProductoProduToSaves(List<ProductoProdu> productoprodus,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProductoProduToSaves(List<ProductoProdu> productoprodus,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProductoProduToSavesAfter(List<ProductoProdu> productoprodus,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProductoProduToGet(ProductoProdu productoprodu,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProductoProduToGets(List<ProductoProdu> productoprodus,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProductoProduToSave(ProductoProdu productoprodu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProductoProduToGet(ProductoProdu productoprodu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProductoProduActions(String sTipoJsonResponse,JSONObject jsonObjectProductoProdu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProductoProduDataTable(String sTipoJsonResponse,ProductoProdu productoprodu,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProductoProdusDataTable(String sTipoJsonResponse,List<ProductoProdu> productoprodus,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProductoProduColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProductoProdusColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProductoProdusColumns;
	}
	
	public static void updateJSONArrayProductoProduActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProductoProdu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosProductoProdu(ProductoProdu productoprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoprodu.setdescripcion(productoprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoProdus(List<ProductoProdu> productoprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoProdu productoprodu: productoprodus) {
			productoprodu.setdescripcion(productoprodu.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoProdu> productoprodus,ProductoProdu productoprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoProdu productoproduAux: productoprodus) {
			if((productoproduAux.getId()==null && productoprodu.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(productoproduAux.getId()!=null && productoprodu.getId()!=null){
				if(productoproduAux.getId().equals(productoprodu.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoProdu(List<ProductoProdu> productoprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double costoTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(ProductoProdu productoprodu: productoprodus) {			
			porcentajeTotal+=productoprodu.getporcentaje();
			costoTotal+=productoprodu.getcosto();
			costo_totalTotal+=productoprodu.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProduConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ProductoProduConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProduConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(ProductoProduConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoProduConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProductoProduConstantesFunciones.LABEL_COSTOTOTAL);
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