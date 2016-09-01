














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.SolicitudReemplazoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
//import com.bydan.erp.nomina.business.interfaces.SolicitudReemplazoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class SolicitudReemplazoLogicAdditional extends SolicitudReemplazoLogic { // implements SolicitudReemplazoAdditionable{
	public  SolicitudReemplazoLogicAdditional(Connexion connexion)throws Exception {
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
	public  SolicitudReemplazoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkSolicitudReemplazoToSave(SolicitudReemplazo solicitudreemplazo,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkSolicitudReemplazoToSave(SolicitudReemplazo solicitudreemplazo,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkSolicitudReemplazoToSaveAfter(SolicitudReemplazo solicitudreemplazo,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkSolicitudReemplazoToSaves(List<SolicitudReemplazo> solicitudreemplazos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkSolicitudReemplazoToSaves(List<SolicitudReemplazo> solicitudreemplazos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkSolicitudReemplazoToSavesAfter(List<SolicitudReemplazo> solicitudreemplazos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkSolicitudReemplazoToGet(SolicitudReemplazo solicitudreemplazo,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkSolicitudReemplazoToGets(List<SolicitudReemplazo> solicitudreemplazos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateSolicitudReemplazoToSave(SolicitudReemplazo solicitudreemplazo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateSolicitudReemplazoToGet(SolicitudReemplazo solicitudreemplazo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectSolicitudReemplazoActions(String sTipoJsonResponse,JSONObject jsonObjectSolicitudReemplazo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonSolicitudReemplazoDataTable(String sTipoJsonResponse,SolicitudReemplazo solicitudreemplazo,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonSolicitudReemplazosDataTable(String sTipoJsonResponse,List<SolicitudReemplazo> solicitudreemplazos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArraySolicitudReemplazoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArraySolicitudReemplazosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArraySolicitudReemplazosColumns;
	}
	
	public static void updateJSONArraySolicitudReemplazoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectSolicitudReemplazo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosSolicitudReemplazo(SolicitudReemplazo solicitudreemplazo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		solicitudreemplazo.setsecuencial(solicitudreemplazo.getsecuencial().trim());
		solicitudreemplazo.setdescripcion(solicitudreemplazo.getdescripcion().trim());
	}
	
	public static void quitarEspaciosSolicitudReemplazos(List<SolicitudReemplazo> solicitudreemplazos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SolicitudReemplazo solicitudreemplazo: solicitudreemplazos) {
			solicitudreemplazo.setsecuencial(solicitudreemplazo.getsecuencial().trim());
			solicitudreemplazo.setdescripcion(solicitudreemplazo.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSolicitudReemplazo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(SolicitudReemplazoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(SolicitudReemplazoConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SolicitudReemplazo> solicitudreemplazos,SolicitudReemplazo solicitudreemplazo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SolicitudReemplazo solicitudreemplazoAux: solicitudreemplazos) {
			if((solicitudreemplazoAux.getId()==null && solicitudreemplazo.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(solicitudreemplazoAux.getId()!=null && solicitudreemplazo.getId()!=null){
				if(solicitudreemplazoAux.getId().equals(solicitudreemplazo.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSolicitudReemplazo(List<SolicitudReemplazo> solicitudreemplazos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(SolicitudReemplazo solicitudreemplazo: solicitudreemplazos) {			
			costo_unitarioTotal+=solicitudreemplazo.getcosto_unitario();
			costo_totalTotal+=solicitudreemplazo.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SolicitudReemplazoConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SolicitudReemplazoConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(SolicitudReemplazoConstantesFunciones.LABEL_COSTOTOTAL);
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