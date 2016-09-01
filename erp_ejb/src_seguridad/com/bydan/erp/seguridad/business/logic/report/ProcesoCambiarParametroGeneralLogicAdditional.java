









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

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.seguridad.util.report.ProcesoCambiarParametroGeneralConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.business.entity.report.*;
////import com.bydan.erp.seguridad.business.interfaces.ProcesoCambiarParametroGeneralAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.business.logic.ParametroGeneralUsuarioLogic;


@SuppressWarnings("unused")
final public class ProcesoCambiarParametroGeneralLogicAdditional extends ProcesoCambiarParametroGeneralLogic{		
	
	public  ProcesoCambiarParametroGeneralLogicAdditional(Connexion connexion)throws Exception {
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
	public  ProcesoCambiarParametroGeneralLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProcesoCambiarParametroGeneralToSave(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProcesoCambiarParametroGeneralToSave(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProcesoCambiarParametroGeneralToSaveAfter(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProcesoCambiarParametroGeneralToSaves(List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProcesoCambiarParametroGeneralToSaves(List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProcesoCambiarParametroGeneralToSavesAfter(List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProcesoCambiarParametroGeneralToGet(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProcesoCambiarParametroGeneralToGets(List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProcesoCambiarParametroGeneralToSave(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProcesoCambiarParametroGeneralToGet(ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProcesoCambiarParametroGeneralActions(String sTipoJsonResponse,JSONObject jsonObjectProcesoCambiarParametroGeneral,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProcesoCambiarParametroGeneralDataTable(String sTipoJsonResponse,ProcesoCambiarParametroGeneral procesocambiarparametrogeneral,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProcesoCambiarParametroGeneralsDataTable(String sTipoJsonResponse,List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProcesoCambiarParametroGeneralColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProcesoCambiarParametroGeneralsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProcesoCambiarParametroGeneralsColumns;
	}
	
	public static void updateJSONArrayProcesoCambiarParametroGeneralActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProcesoCambiarParametroGeneral,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals) throws Exception  {
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
	
	
	

	public void BusquedaProcesoCambiarParametroGeneral(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_tipo_visual,Boolean con_mensaje_confirmacion,Boolean con_botones_tool_bar,
			Long id_tipo_fondo,Long id_tipo_fondo_borde,Long id_tipo_fondo_control,Long id_tipo_tamanio_control,Long id_tipo_exportar,Long id_tipo_delimiter,Boolean con_exportar_cabecera,String path_exportar)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;

		System.out.println("BusquedaProcesoCambiarParametroGeneral");
		ParametroGeneralUsuarioLogic parametrogeneralusuarioLogic=new ParametroGeneralUsuarioLogic();
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();

			parametrogeneralusuarioLogic.setConnexion(this.connexion);
			
			parametrogeneralusuarioLogic.getEntity(parametroGeneralUsuario.getId());
			parametroGeneralUsuario=parametrogeneralusuarioLogic.getParametroGeneralUsuario();
			
				
			parametroGeneralUsuario.setcon_botones_tool_bar(con_botones_tool_bar);
			parametroGeneralUsuario.setcon_mensaje_confirmacion(con_mensaje_confirmacion);
			parametroGeneralUsuario.setid_tipo_visual(id_tipo_visual);
			
			parametroGeneralUsuario.setid_tipo_fondo(id_tipo_fondo);
			parametroGeneralUsuario.setid_tipo_fondo_borde(id_tipo_fondo_borde);
			parametroGeneralUsuario.setid_tipo_fondo_control(id_tipo_fondo_control);
			parametroGeneralUsuario.setid_tipo_tamanio_control_normal(id_tipo_tamanio_control);
			
			parametroGeneralUsuario.setid_tipo_delimiter(id_tipo_delimiter);
			parametroGeneralUsuario.setid_tipo_exportar(id_tipo_exportar);
			parametroGeneralUsuario.setcon_exportar_cabecera(con_exportar_cabecera);
			parametroGeneralUsuario.setpath_exportar(path_exportar);
			
			parametrogeneralusuarioLogic.setParametroGeneralUsuario(parametroGeneralUsuario);
			parametrogeneralusuarioLogic.saveParametroGeneralUsuario();
				
			
			this.connexion.commit();
		} catch(Exception e) {
			this.connexion.rollback();
			//Funciones.manageException(logger,e);
			throw e;
		} finally {
			this.connexion.close();
		}
		
		/*
		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				
			}
		}
		*/
	}
	
	
	public Boolean ProcesarInformacionProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals,String sTipoBusqueda,Long id_tipo_visualBusquedaProcesoCambiarParametroGeneral,Boolean con_mensaje_confirmacionBusquedaProcesoCambiarParametroGeneral,Boolean con_botones_tool_barBusquedaProcesoCambiarParametroGeneral,
																	Long id_tipo_fondo,Long id_tipo_fondo_borde,Long id_tipo_fondo_control,Long id_tipo_tamanio_control,Long id_tipo_exportarBusquedaProcesoCambiarParametroGeneral,Long id_tipo_delimiterBusquedaProcesoCambiarParametroGeneral,Boolean con_exportar_cabeceraBusquedaProcesoCambiarParametroGeneral,String path_exportarBusquedaProcesoCambiarParametroGeneral) throws Exception {
		Boolean procesado=false;

		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();

			System.out.println("ProcesarInformacionProcesoCambiarParametroGeneral");
			
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

	public static GeneralEntityParameterReturnGeneral ProcesarInformacionProcesoCambiarParametroGeneral(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,GeneralEntityLogic generalEntityLogic,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,String sTipoBusqueda,Long id_tipo_visualBusquedaProcesoCambiarParametroGeneral,Boolean con_mensaje_confirmacionBusquedaProcesoCambiarParametroGeneral,Boolean con_botones_tool_barBusquedaProcesoCambiarParametroGeneral,Long id_tipo_fondoBusquedaProcesoCambiarParametroGeneral,Long id_tipo_fondo_bordeBusquedaProcesoCambiarParametroGeneral,Long id_tipo_fondo_controlBusquedaProcesoCambiarParametroGeneral,Long id_tipo_tamanio_controlBusquedaProcesoCambiarParametroGeneral,Long id_tipo_exportarBusquedaProcesoCambiarParametroGeneral,Long id_tipo_delimiterBusquedaProcesoCambiarParametroGeneral,Boolean con_exportar_cabeceraBusquedaProcesoCambiarParametroGeneral,String path_exportarBusquedaProcesoCambiarParametroGeneral) throws Exception {

		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}

		return generalEntityReturnGeneral;
	}
	//CONTROL_FUNCION1
	
	
	
	
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