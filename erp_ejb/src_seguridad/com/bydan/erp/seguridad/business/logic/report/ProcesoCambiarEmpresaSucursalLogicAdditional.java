










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
import com.bydan.erp.seguridad.util.report.ProcesoCambiarEmpresaSucursalConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.business.entity.report.*;
////import com.bydan.erp.seguridad.business.interfaces.ProcesoCambiarEmpresaSucursalAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.business.logic.ParametroGeneralUsuarioLogic;


@SuppressWarnings("unused")
final public class ProcesoCambiarEmpresaSucursalLogicAdditional extends ProcesoCambiarEmpresaSucursalLogic{		
	
	public  ProcesoCambiarEmpresaSucursalLogicAdditional(Connexion connexion)throws Exception {
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
	public  ProcesoCambiarEmpresaSucursalLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProcesoCambiarEmpresaSucursalToSave(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProcesoCambiarEmpresaSucursalToSave(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProcesoCambiarEmpresaSucursalToSaveAfter(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProcesoCambiarEmpresaSucursalToSaves(List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProcesoCambiarEmpresaSucursalToSaves(List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProcesoCambiarEmpresaSucursalToSavesAfter(List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProcesoCambiarEmpresaSucursalToGet(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProcesoCambiarEmpresaSucursalToGets(List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProcesoCambiarEmpresaSucursalToSave(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProcesoCambiarEmpresaSucursalToGet(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProcesoCambiarEmpresaSucursalActions(String sTipoJsonResponse,JSONObject jsonObjectProcesoCambiarEmpresaSucursal,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProcesoCambiarEmpresaSucursalDataTable(String sTipoJsonResponse,ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProcesoCambiarEmpresaSucursalsDataTable(String sTipoJsonResponse,List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProcesoCambiarEmpresaSucursalColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProcesoCambiarEmpresaSucursalsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProcesoCambiarEmpresaSucursalsColumns;
	}
	
	public static void updateJSONArrayProcesoCambiarEmpresaSucursalActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProcesoCambiarEmpresaSucursal,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	

	//BusquedaProcesoCambiarEmpresaSucursal(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_empresa,Long id_sucursal)throws Exception {
	
	public void BusquedaProcesoCambiarEmpresaSucursal(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_empresaBusquedaProcesoCambiarEmpresaSucursal,Long id_sucursalBusquedaProcesoCambiarEmpresaSucursal)throws Exception {
		String sTipoBusqueda="NONE";
		
		this.ProcesarInformacionProcesoCambiarEmpresaSucursal(parametroGeneralUsuario, moduloActual, opcionActual, usuarioActual, procesocambiarempresasucursals, sTipoBusqueda, id_empresaBusquedaProcesoCambiarEmpresaSucursal, id_sucursalBusquedaProcesoCambiarEmpresaSucursal);
	}
	
	public Boolean ProcesarInformacionProcesoCambiarEmpresaSucursal(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,String sTipoBusqueda,Long id_empresaBusquedaProcesoCambiarEmpresaSucursal,Long id_sucursalBusquedaProcesoCambiarEmpresaSucursal)throws Exception {
		ParametroGeneralUsuarioLogic parametrogeneralusuarioLogic=new ParametroGeneralUsuarioLogic();
		Boolean procesado=false;
		
		try {
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			parametrogeneralusuarioLogic.setConnexion(this.connexion);
			
			parametrogeneralusuarioLogic.getEntity(parametroGeneralUsuario.getId());
			parametroGeneralUsuario=parametrogeneralusuarioLogic.getParametroGeneralUsuario();
			
			
			parametroGeneralUsuario.setid_empresa(id_empresaBusquedaProcesoCambiarEmpresaSucursal);
			parametroGeneralUsuario.setid_sucursal(id_sucursalBusquedaProcesoCambiarEmpresaSucursal);
			
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
	
	public static GeneralEntityParameterReturnGeneral ProcesarInformacionProcesoCambiarEmpresaSucursal(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,GeneralEntityLogic generalEntityLogic,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,String sTipoBusqueda,Long id_empresaBusquedaProcesoCambiarEmpresaSucursal,Long id_sucursalBusquedaProcesoCambiarEmpresaSucursal) throws Exception {

		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}

		return generalEntityReturnGeneral;
	}

	//CONTROL_FUNCION1
	
	
	
	
	
	public static void quitarEspaciosProcesoCambiarEmpresaSucursal(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoCambiarEmpresaSucursals(List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal: procesocambiarempresasucursals) {
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCambiarEmpresaSucursal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ProcesoCambiarEmpresaSucursalConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ProcesoCambiarEmpresaSucursalConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals,ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursalAux: procesocambiarempresasucursals) {
			if((procesocambiarempresasucursalAux.getId()==null && procesocambiarempresasucursal.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(procesocambiarempresasucursalAux.getId()!=null && procesocambiarempresasucursal.getId()!=null){
				if(procesocambiarempresasucursalAux.getId().equals(procesocambiarempresasucursal.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoCambiarEmpresaSucursal(List<ProcesoCambiarEmpresaSucursal> procesocambiarempresasucursals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoCambiarEmpresaSucursal procesocambiarempresasucursal: procesocambiarempresasucursals) {			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCambiarEmpresaSucursal() throws Exception  {
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