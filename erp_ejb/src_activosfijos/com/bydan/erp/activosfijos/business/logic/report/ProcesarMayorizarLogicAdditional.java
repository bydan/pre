










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
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.Funciones;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.activosfijos.util.report.ProcesarMayorizarConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;
////import com.bydan.erp.activosfijos.business.interfaces.ProcesarMayorizarAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ProcesarMayorizarLogicAdditional extends ProcesarMayorizarLogic{		
	
	public  ProcesarMayorizarLogicAdditional(Connexion connexion)throws Exception {
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
	public  ProcesarMayorizarLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProcesarMayorizarToSave(ProcesarMayorizar procesarmayorizar,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProcesarMayorizarToSave(ProcesarMayorizar procesarmayorizar,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProcesarMayorizarToSaveAfter(ProcesarMayorizar procesarmayorizar,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProcesarMayorizarToSaves(List<ProcesarMayorizar> procesarmayorizars,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProcesarMayorizarToSaves(List<ProcesarMayorizar> procesarmayorizars,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProcesarMayorizarToSavesAfter(List<ProcesarMayorizar> procesarmayorizars,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProcesarMayorizarToGet(ProcesarMayorizar procesarmayorizar,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProcesarMayorizarToGets(List<ProcesarMayorizar> procesarmayorizars,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProcesarMayorizarToSave(ProcesarMayorizar procesarmayorizar,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProcesarMayorizarToGet(ProcesarMayorizar procesarmayorizar,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProcesarMayorizarActions(String sTipoJsonResponse,JSONObject jsonObjectProcesarMayorizar,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProcesarMayorizarDataTable(String sTipoJsonResponse,ProcesarMayorizar procesarmayorizar,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProcesarMayorizarsDataTable(String sTipoJsonResponse,List<ProcesarMayorizar> procesarmayorizars,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProcesarMayorizarColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProcesarMayorizarsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProcesarMayorizarsColumns;
	}
	
	public static void updateJSONArrayProcesarMayorizarActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProcesarMayorizar,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	

	public void BusquedaProcesarMayorizar(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_anio,Long id_mes,Long id_tipo_documento)throws Exception {
		String sQuerySelect="";
		String sFinalQueryLocal="";
		Boolean existeWhere=false;
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			
			sQuerySelect="select id,version_row,codigo,nombre from activosfijos.detalle_grupo_activo_fijo where id_empresa="+parametroGeneralUsuario.getid_empresa();
			
			this.getEntities(sQuerySelect, sFinalQueryLocal);
					
			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			//Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}		
	}
	
	
	public Boolean ProcesarInformacionProcesarMayorizar(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesarMayorizar> procesarmayorizars,String sTipoBusqueda,Long id_anioBusquedaProcesarMayorizar,Long id_mesBusquedaProcesarMayorizar,Long id_tipo_documentoBusquedaProcesarMayorizar) throws Exception {
		Boolean procesado=false;

		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();

			for(ProcesarMayorizar procesarmayorizar:procesarmayorizars) {
				if(procesarmayorizar.getIsSelected()) {
					System.out.println(procesarmayorizar.getId());
				}
			}
			
			connexion.commit();
		} catch(Exception e) {
			connexion.rollback();
			//Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}

		return procesado;
	}


	public static GeneralEntityParameterReturnGeneral ProcesarInformacionProcesarMayorizar(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,GeneralEntityLogic generalEntityLogic,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,String sTipoBusqueda,Long id_anioBusquedaProcesarMayorizar,Long id_mesBusquedaProcesarMayorizar,Long id_tipo_documentoBusquedaProcesarMayorizar) throws Exception {

		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}

		return generalEntityReturnGeneral;
	}
	//CONTROL_FUNCION1
	
	
	
	
	
	public static void quitarEspaciosProcesarMayorizar(ProcesarMayorizar procesarmayorizar,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		procesarmayorizar.setcodigo(procesarmayorizar.getcodigo().trim());
		procesarmayorizar.setnombre(procesarmayorizar.getnombre().trim());
	}
	
	public static void quitarEspaciosProcesarMayorizars(List<ProcesarMayorizar> procesarmayorizars,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesarMayorizar procesarmayorizar: procesarmayorizars) {
			procesarmayorizar.setcodigo(procesarmayorizar.getcodigo().trim());
			procesarmayorizar.setnombre(procesarmayorizar.getnombre().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesarMayorizar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesarMayorizar> procesarmayorizars,ProcesarMayorizar procesarmayorizar,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesarMayorizar procesarmayorizarAux: procesarmayorizars) {
			if((procesarmayorizarAux.getId()==null && procesarmayorizar.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(procesarmayorizarAux.getId()!=null && procesarmayorizar.getId()!=null){
				if(procesarmayorizarAux.getId().equals(procesarmayorizar.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesarMayorizar(List<ProcesarMayorizar> procesarmayorizars) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesarMayorizar procesarmayorizar: procesarmayorizars) {			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesarMayorizar() throws Exception  {
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