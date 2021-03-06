














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.importaciones.business.logic;

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
import com.bydan.erp.importaciones.util.ContenedorConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;
//import com.bydan.erp.importaciones.business.interfaces.ContenedorAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class ContenedorLogicAdditional extends ContenedorLogic { // implements ContenedorAdditionable{
	public  ContenedorLogicAdditional(Connexion connexion)throws Exception {
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
	public  ContenedorLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkContenedorToSave(Contenedor contenedor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkContenedorToSave(Contenedor contenedor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkContenedorToSaveAfter(Contenedor contenedor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkContenedorToSaves(List<Contenedor> contenedors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkContenedorToSaves(List<Contenedor> contenedors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkContenedorToSavesAfter(List<Contenedor> contenedors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkContenedorToGet(Contenedor contenedor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkContenedorToGets(List<Contenedor> contenedors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateContenedorToSave(Contenedor contenedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateContenedorToGet(Contenedor contenedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectContenedorActions(String sTipoJsonResponse,JSONObject jsonObjectContenedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonContenedorDataTable(String sTipoJsonResponse,Contenedor contenedor,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonContenedorsDataTable(String sTipoJsonResponse,List<Contenedor> contenedors,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayContenedorColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayContenedorsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayContenedorsColumns;
	}
	
	public static void updateJSONArrayContenedorActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectContenedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosContenedor(Contenedor contenedor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		contenedor.setnumero(contenedor.getnumero().trim());
		contenedor.setnumero_bl(contenedor.getnumero_bl().trim());
		contenedor.setdescripcion(contenedor.getdescripcion().trim());
	}
	
	public static void quitarEspaciosContenedors(List<Contenedor> contenedors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Contenedor contenedor: contenedors) {
			contenedor.setnumero(contenedor.getnumero().trim());
			contenedor.setnumero_bl(contenedor.getnumero_bl().trim());
			contenedor.setdescripcion(contenedor.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesContenedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ContenedorConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ContenedorConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Contenedor> contenedors,Contenedor contenedor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Contenedor contenedorAux: contenedors) {
			if((contenedorAux.getId()==null && contenedor.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(contenedorAux.getId()!=null && contenedor.getId()!=null){
				if(contenedorAux.getId().equals(contenedor.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaContenedor(List<Contenedor> contenedors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Contenedor contenedor: contenedors) {			
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