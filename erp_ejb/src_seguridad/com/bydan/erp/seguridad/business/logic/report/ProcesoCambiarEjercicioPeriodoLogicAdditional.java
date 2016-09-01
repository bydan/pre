










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.seguridad.business.logic.report;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;
import java.sql.Timestamp;

import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.Funciones;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.contabilidad.business.logic.EjercicioLogic;
import com.bydan.erp.contabilidad.business.logic.PeriodoLogic;
import com.bydan.erp.seguridad.util.report.ProcesoCambiarEjercicioPeriodoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.business.entity.report.*;
////import com.bydan.erp.seguridad.business.interfaces.ProcesoCambiarEjercicioPeriodoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.business.logic.ParametroGeneralUsuarioLogic;


@SuppressWarnings("unused")
final public class ProcesoCambiarEjercicioPeriodoLogicAdditional extends ProcesoCambiarEjercicioPeriodoLogic{		
	
	public  ProcesoCambiarEjercicioPeriodoLogicAdditional(Connexion connexion)throws Exception {
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
	public  ProcesoCambiarEjercicioPeriodoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProcesoCambiarEjercicioPeriodoToSave(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProcesoCambiarEjercicioPeriodoToSave(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProcesoCambiarEjercicioPeriodoToSaveAfter(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProcesoCambiarEjercicioPeriodoToSaves(List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProcesoCambiarEjercicioPeriodoToSaves(List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProcesoCambiarEjercicioPeriodoToSavesAfter(List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProcesoCambiarEjercicioPeriodoToGet(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProcesoCambiarEjercicioPeriodoToGets(List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProcesoCambiarEjercicioPeriodoToSave(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProcesoCambiarEjercicioPeriodoToGet(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProcesoCambiarEjercicioPeriodoActions(String sTipoJsonResponse,JSONObject jsonObjectProcesoCambiarEjercicioPeriodo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProcesoCambiarEjercicioPeriodoDataTable(String sTipoJsonResponse,ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProcesoCambiarEjercicioPeriodosDataTable(String sTipoJsonResponse,List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProcesoCambiarEjercicioPeriodoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProcesoCambiarEjercicioPeriodosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProcesoCambiarEjercicioPeriodosColumns;
	}
	
	public static void updateJSONArrayProcesoCambiarEjercicioPeriodoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProcesoCambiarEjercicioPeriodo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	
	//BusquedaProcesoCambiarEjercicioPeriodo(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_sistema)throws Exception {
	
	public void BusquedaProcesoCambiarEjercicioPeriodo(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Date fecha_sistemaBusquedaProcesoCambiarEjercicioPeriodo)throws Exception {
		String sTipoBusqueda="";
		
		this.ProcesarInformacionProcesoCambiarEjercicioPeriodo(parametroGeneralUsuario, moduloActual, opcionActual, usuarioActual, procesocambiarejercicioperiodos, sTipoBusqueda, fecha_sistemaBusquedaProcesoCambiarEjercicioPeriodo);
	}
	
	public Boolean ProcesarInformacionProcesoCambiarEjercicioPeriodo(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,String sTipoBusqueda,Date fecha_sistemaBusquedaProcesoCambiarEjercicioPeriodo)throws Exception {
		//procesocambiarejercicioperiodos,sTipoBusqueda,fecha_sistemaBusquedaProcesoCambiarEjercicioPeriodo
		
		String sWhereQuery="";
		Boolean procesado=false;
		
		EjercicioLogic ejercicioLogic=new EjercicioLogic();
		PeriodoLogic periodoLogic=new PeriodoLogic();
		ParametroGeneralUsuarioLogic parametrogeneralusuarioLogic=new ParametroGeneralUsuarioLogic();
		
		try {
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			ejercicioLogic.setConnexion(this.connexion);
			periodoLogic.setConnexion(this.connexion);
			parametrogeneralusuarioLogic.setConnexion(this.connexion);
			
			
			if(connexionType.equals(ConnexionType.HIBERNATE)) {
	
			} else if(connexionType.equals(ConnexionType.JDBC32)) {
				if(parameterDbType.equals(ParameterDbType.MYSQL)) {
	
				} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {					
					sWhereQuery=" where '"+Funciones2.getStringPostgresDate(fecha_sistemaBusquedaProcesoCambiarEjercicioPeriodo) + "' between fecha_inicio and fecha_fin";										
				}
			}
		
			
			ejercicioLogic.getEntity(sWhereQuery);			
			periodoLogic.getEntity(sWhereQuery);
			
			
			parametrogeneralusuarioLogic.getEntity(parametroGeneralUsuario.getId());
			parametroGeneralUsuario=parametrogeneralusuarioLogic.getParametroGeneralUsuario();
			
			parametroGeneralUsuario.setid_ejercicio(ejercicioLogic.getEjercicio().getId());
			parametroGeneralUsuario.setid_periodo(periodoLogic.getPeriodo().getId());
			parametroGeneralUsuario.setfecha_sistema(fecha_sistemaBusquedaProcesoCambiarEjercicioPeriodo);
			parametroGeneralUsuario.setid_anio(ejercicioLogic.getEjercicio().getid_anio());
			parametroGeneralUsuario.setid_mes(periodoLogic.getPeriodo().getid_mes());
			
			parametrogeneralusuarioLogic.setParametroGeneralUsuario(parametroGeneralUsuario);
			parametrogeneralusuarioLogic.saveParametroGeneralUsuario();
			
			this.connexion.commit();
			
			procesado=true;
		
		} catch(Exception e) {
			this.connexion.rollback();
			
			//Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		this.connexion.close();				
		}
		
		return procesado;
	}
	
	public static GeneralEntityParameterReturnGeneral ProcesarInformacionProcesoCambiarEjercicioPeriodo(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,GeneralEntityLogic generalEntityLogic,Object objects,GeneralEntityParameterReturnGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,String sTipoBusqueda,Date fecha_sistemaBusquedaProcesoCambiarEjercicioPeriodo) throws Exception {

		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}

		return generalEntityReturnGeneral;
	}
	//CONTROL_FUNCION1
	
	
	
	
	
	public static void quitarEspaciosProcesoCambiarEjercicioPeriodo(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoCambiarEjercicioPeriodos(List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo: procesocambiarejercicioperiodos) {
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCambiarEjercicioPeriodo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos,ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodoAux: procesocambiarejercicioperiodos) {
			if((procesocambiarejercicioperiodoAux.getId()==null && procesocambiarejercicioperiodo.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(procesocambiarejercicioperiodoAux.getId()!=null && procesocambiarejercicioperiodo.getId()!=null){
				if(procesocambiarejercicioperiodoAux.getId().equals(procesocambiarejercicioperiodo.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoCambiarEjercicioPeriodo(List<ProcesoCambiarEjercicioPeriodo> procesocambiarejercicioperiodos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo: procesocambiarejercicioperiodos) {			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCambiarEjercicioPeriodo() throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		
		return arrTiposSeleccionarTodos;
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