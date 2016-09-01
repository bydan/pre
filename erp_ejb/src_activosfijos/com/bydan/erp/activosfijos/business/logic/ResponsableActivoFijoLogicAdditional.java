














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.activosfijos.business.logic;

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
import com.bydan.erp.activosfijos.util.ResponsableActivoFijoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
//import com.bydan.erp.activosfijos.business.interfaces.ResponsableActivoFijoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class ResponsableActivoFijoLogicAdditional extends ResponsableActivoFijoLogic { // implements ResponsableActivoFijoAdditionable{
	
	public  ResponsableActivoFijoLogicAdditional(Connexion connexion)throws Exception {
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
	public  ResponsableActivoFijoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkResponsableActivoFijoToSave(ResponsableActivoFijo responsableactivofijo,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkResponsableActivoFijoToSave(ResponsableActivoFijo responsableactivofijo,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkResponsableActivoFijoToSaveAfter(ResponsableActivoFijo responsableactivofijo,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkResponsableActivoFijoToSaves(List<ResponsableActivoFijo> responsableactivofijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkResponsableActivoFijoToSaves(List<ResponsableActivoFijo> responsableactivofijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkResponsableActivoFijoToSavesAfter(List<ResponsableActivoFijo> responsableactivofijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkResponsableActivoFijoToGet(ResponsableActivoFijo responsableactivofijo,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkResponsableActivoFijoToGets(List<ResponsableActivoFijo> responsableactivofijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateResponsableActivoFijoToSave(ResponsableActivoFijo responsableactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateResponsableActivoFijoToGet(ResponsableActivoFijo responsableactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectResponsableActivoFijoActions(String sTipoJsonResponse,JSONObject jsonObjectResponsableActivoFijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonResponsableActivoFijoDataTable(String sTipoJsonResponse,ResponsableActivoFijo responsableactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonResponsableActivoFijosDataTable(String sTipoJsonResponse,List<ResponsableActivoFijo> responsableactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayResponsableActivoFijoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayResponsableActivoFijosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayResponsableActivoFijosColumns;
	}
	
	public static void updateJSONArrayResponsableActivoFijoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectResponsableActivoFijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosResponsableActivoFijo(ResponsableActivoFijo responsableactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		responsableactivofijo.setubicacion(responsableactivofijo.getubicacion().trim());
		responsableactivofijo.setdescripcion(responsableactivofijo.getdescripcion().trim());
	}
	
	public static void quitarEspaciosResponsableActivoFijos(List<ResponsableActivoFijo> responsableactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ResponsableActivoFijo responsableactivofijo: responsableactivofijos) {
			responsableactivofijo.setubicacion(responsableactivofijo.getubicacion().trim());
			responsableactivofijo.setdescripcion(responsableactivofijo.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesResponsableActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ResponsableActivoFijoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ResponsableActivoFijoConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ResponsableActivoFijo> responsableactivofijos,ResponsableActivoFijo responsableactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ResponsableActivoFijo responsableactivofijoAux: responsableactivofijos) {
			if((responsableactivofijoAux.getId()==null && responsableactivofijo.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(responsableactivofijoAux.getId()!=null && responsableactivofijo.getId()!=null){
				if(responsableactivofijoAux.getId().equals(responsableactivofijo.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaResponsableActivoFijo(List<ResponsableActivoFijo> responsableactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ResponsableActivoFijo responsableactivofijo: responsableactivofijos) {			
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