














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
import com.bydan.erp.produccion.util.OrdenDetaProduConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;
//import com.bydan.erp.produccion.business.interfaces.OrdenDetaProduAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class OrdenDetaProduLogicAdditional extends OrdenDetaProduLogic { // implements OrdenDetaProduAdditionable{
	public  OrdenDetaProduLogicAdditional(Connexion connexion)throws Exception {
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
	public  OrdenDetaProduLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkOrdenDetaProduToSave(OrdenDetaProdu ordendetaprodu,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkOrdenDetaProduToSave(OrdenDetaProdu ordendetaprodu,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkOrdenDetaProduToSaveAfter(OrdenDetaProdu ordendetaprodu,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkOrdenDetaProduToSaves(List<OrdenDetaProdu> ordendetaprodus,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkOrdenDetaProduToSaves(List<OrdenDetaProdu> ordendetaprodus,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkOrdenDetaProduToSavesAfter(List<OrdenDetaProdu> ordendetaprodus,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkOrdenDetaProduToGet(OrdenDetaProdu ordendetaprodu,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkOrdenDetaProduToGets(List<OrdenDetaProdu> ordendetaprodus,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateOrdenDetaProduToSave(OrdenDetaProdu ordendetaprodu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateOrdenDetaProduToGet(OrdenDetaProdu ordendetaprodu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectOrdenDetaProduActions(String sTipoJsonResponse,JSONObject jsonObjectOrdenDetaProdu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonOrdenDetaProduDataTable(String sTipoJsonResponse,OrdenDetaProdu ordendetaprodu,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonOrdenDetaProdusDataTable(String sTipoJsonResponse,List<OrdenDetaProdu> ordendetaprodus,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayOrdenDetaProduColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayOrdenDetaProdusColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayOrdenDetaProdusColumns;
	}
	
	public static void updateJSONArrayOrdenDetaProduActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectOrdenDetaProdu,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosOrdenDetaProdu(OrdenDetaProdu ordendetaprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ordendetaprodu.setdescripcion(ordendetaprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosOrdenDetaProdus(List<OrdenDetaProdu> ordendetaprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(OrdenDetaProdu ordendetaprodu: ordendetaprodus) {
			ordendetaprodu.setdescripcion(ordendetaprodu.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesOrdenDetaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(OrdenDetaProduConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(OrdenDetaProduConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(OrdenDetaProduConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(OrdenDetaProduConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<OrdenDetaProdu> ordendetaprodus,OrdenDetaProdu ordendetaprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(OrdenDetaProdu ordendetaproduAux: ordendetaprodus) {
			if((ordendetaproduAux.getId()==null && ordendetaprodu.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(ordendetaproduAux.getId()!=null && ordendetaprodu.getId()!=null){
				if(ordendetaproduAux.getId().equals(ordendetaprodu.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaOrdenDetaProdu(List<OrdenDetaProdu> ordendetaprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(OrdenDetaProdu ordendetaprodu: ordendetaprodus) {			
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