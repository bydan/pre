







/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.contabilidad.business.logic.report;

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

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.contabilidad.util.report.ProcesoCierrePeriodoConstantesFunciones;
//import com.bydan.erp.contabilidad.util.report.ProcesoCierrePeriodoReturnGeneral;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
import com.bydan.erp.contabilidad.business.logic.PeriodoLogic;
////import com.bydan.erp.contabilidad.business.interfaces.ProcesoCierrePeriodoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ProcesoCierrePeriodoLogicAdditional extends ProcesoCierrePeriodoLogic{		
	
	public  ProcesoCierrePeriodoLogicAdditional(Connexion connexion)throws Exception {
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
	public  ProcesoCierrePeriodoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProcesoCierrePeriodoToSave(ProcesoCierrePeriodo procesocierreperiodo,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProcesoCierrePeriodoToSave(ProcesoCierrePeriodo procesocierreperiodo,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProcesoCierrePeriodoToSaveAfter(ProcesoCierrePeriodo procesocierreperiodo,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProcesoCierrePeriodoToSaves(List<ProcesoCierrePeriodo> procesocierreperiodos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProcesoCierrePeriodoToSaves(List<ProcesoCierrePeriodo> procesocierreperiodos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProcesoCierrePeriodoToSavesAfter(List<ProcesoCierrePeriodo> procesocierreperiodos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProcesoCierrePeriodoToGet(ProcesoCierrePeriodo procesocierreperiodo,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProcesoCierrePeriodoToGets(List<ProcesoCierrePeriodo> procesocierreperiodos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProcesoCierrePeriodoToSave(ProcesoCierrePeriodo procesocierreperiodo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProcesoCierrePeriodoToGet(ProcesoCierrePeriodo procesocierreperiodo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProcesoCierrePeriodoActions(String sTipoJsonResponse,JSONObject jsonObjectProcesoCierrePeriodo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProcesoCierrePeriodoDataTable(String sTipoJsonResponse,ProcesoCierrePeriodo procesocierreperiodo,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProcesoCierrePeriodosDataTable(String sTipoJsonResponse,List<ProcesoCierrePeriodo> procesocierreperiodos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProcesoCierrePeriodoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProcesoCierrePeriodosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProcesoCierrePeriodosColumns;
	}
	
	public static void updateJSONArrayProcesoCierrePeriodoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProcesoCierrePeriodo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	//PARA ACCIONES ADDITIONAL
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<ProcesoCierrePeriodo> procesocierreperiodos) throws Exception  {
		//CONTROL_16
		Boolean esProcesado=true;
		
		try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
		
			this.connexion.commit();
			
		} catch(Exception e) {
			this.connexion.rollback();			
			
			//Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		this.connexion.close();			
		}
		
		return esProcesado;
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
			;
		}
	}
	
	
	
	
	public Boolean ProcesarInformacionProcesoCierrePeriodo(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoCierrePeriodo> procesocierreperiodos,String sTipoBusqueda,Long id_ejercicioBusquedaPorIdEjercicioPorIdPeriodoPorEstado,Long id_periodoBusquedaPorIdEjercicioPorIdPeriodoPorEstado,Long id_estado_periodoBusquedaPorIdEjercicioPorIdPeriodoPorEstado) throws Exception {
		Boolean procesado=false;

		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();

			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			//Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}

		return procesado;
	}

	public static GeneralEntityParameterReturnGeneral ProcesarInformacionProcesoCierrePeriodo(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,GeneralEntityLogic generalEntityLogic,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,String sTipoBusqueda,Long id_ejercicioBusquedaPorIdEjercicioPorIdPeriodoPorEstado,Long id_periodoBusquedaPorIdEjercicioPorIdPeriodoPorEstado,Long id_estado_periodoBusquedaPorIdEjercicioPorIdPeriodoPorEstado) throws Exception {
		String sFinalQuery="";
		
		try {
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(generalEntityLogic.getConnexion());
			
			sFinalQuery=" where id_ejercicio="+id_ejercicioBusquedaPorIdEjercicioPorIdPeriodoPorEstado +" and id="+id_periodoBusquedaPorIdEjercicioPorIdPeriodoPorEstado;
			
			periodoLogic.getEntity(sFinalQuery);
			
			if(!periodoLogic.getPeriodo().getid_estado_periodo().equals(id_estado_periodoBusquedaPorIdEjercicioPorIdPeriodoPorEstado)) {
				periodoLogic.getPeriodo().setid_estado_periodo(id_estado_periodoBusquedaPorIdEjercicioPorIdPeriodoPorEstado);
				
				periodoLogic.savePeriodo();
				
			} else {
				throw new Exception("YA SE ENCUENTRA EL PERIODO EN EL ESTADO SELECCIONADO");
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}

		return generalEntityReturnGeneral;
	}
	//CONTROL_FUNCION1
	
	
	
	
	//CONTROL_FUNCION2
}