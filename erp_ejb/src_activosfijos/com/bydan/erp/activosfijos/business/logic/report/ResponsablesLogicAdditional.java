










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.activosfijos.business.logic.report;

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
import com.bydan.erp.activosfijos.util.report.ResponsablesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;
////import com.bydan.erp.activosfijos.business.interfaces.ResponsablesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ResponsablesLogicAdditional extends ResponsablesLogic{		
	
	public  ResponsablesLogicAdditional(Connexion connexion)throws Exception {
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
	public  ResponsablesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkResponsablesToSave(Responsables responsables,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkResponsablesToSave(Responsables responsables,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkResponsablesToSaveAfter(Responsables responsables,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkResponsablesToSaves(List<Responsables> responsabless,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkResponsablesToSaves(List<Responsables> responsabless,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkResponsablesToSavesAfter(List<Responsables> responsabless,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkResponsablesToGet(Responsables responsables,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkResponsablesToGets(List<Responsables> responsabless,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateResponsablesToSave(Responsables responsables,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateResponsablesToGet(Responsables responsables,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectResponsablesActions(String sTipoJsonResponse,JSONObject jsonObjectResponsables,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonResponsablesDataTable(String sTipoJsonResponse,Responsables responsables,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonResponsablessDataTable(String sTipoJsonResponse,List<Responsables> responsabless,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayResponsablesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayResponsablessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayResponsablessColumns;
	}
	
	public static void updateJSONArrayResponsablesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectResponsables,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosResponsables(Responsables responsables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		responsables.setcodigo_empleado(responsables.getcodigo_empleado().trim());
		responsables.setnombre_empleado(responsables.getnombre_empleado().trim());
		responsables.setapellido_empleado(responsables.getapellido_empleado().trim());
		responsables.setnombre_estructura(responsables.getnombre_estructura().trim());
		responsables.setubicacion(responsables.getubicacion().trim());
		responsables.setdescripcion(responsables.getdescripcion().trim());
		responsables.setnombre(responsables.getnombre().trim());
		responsables.setclave(responsables.getclave().trim());
		responsables.setcodigo_sub_grupo(responsables.getcodigo_sub_grupo().trim());
		responsables.setnombre_sub_grupo(responsables.getnombre_sub_grupo().trim());
		responsables.setcodigo_detalle_grupo(responsables.getcodigo_detalle_grupo().trim());
		responsables.setnombre_detalle_grupo(responsables.getnombre_detalle_grupo().trim());
	}
	
	public static void quitarEspaciosResponsabless(List<Responsables> responsabless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Responsables responsables: responsabless) {
			responsables.setcodigo_empleado(responsables.getcodigo_empleado().trim());
			responsables.setnombre_empleado(responsables.getnombre_empleado().trim());
			responsables.setapellido_empleado(responsables.getapellido_empleado().trim());
			responsables.setnombre_estructura(responsables.getnombre_estructura().trim());
			responsables.setubicacion(responsables.getubicacion().trim());
			responsables.setdescripcion(responsables.getdescripcion().trim());
			responsables.setnombre(responsables.getnombre().trim());
			responsables.setclave(responsables.getclave().trim());
			responsables.setcodigo_sub_grupo(responsables.getcodigo_sub_grupo().trim());
			responsables.setnombre_sub_grupo(responsables.getnombre_sub_grupo().trim());
			responsables.setcodigo_detalle_grupo(responsables.getcodigo_detalle_grupo().trim());
			responsables.setnombre_detalle_grupo(responsables.getnombre_detalle_grupo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesResponsables(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ResponsablesConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Responsables> responsabless,Responsables responsables,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Responsables responsablesAux: responsabless) {
			if((responsablesAux.getId()==null && responsables.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(responsablesAux.getId()!=null && responsables.getId()!=null){
				if(responsablesAux.getId().equals(responsables.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaResponsables(List<Responsables> responsabless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Responsables responsables: responsabless) {			
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