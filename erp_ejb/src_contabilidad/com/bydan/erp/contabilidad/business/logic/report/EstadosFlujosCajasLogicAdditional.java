










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
import com.bydan.erp.contabilidad.util.report.EstadosFlujosCajasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
////import com.bydan.erp.contabilidad.business.interfaces.EstadosFlujosCajasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class EstadosFlujosCajasLogicAdditional extends EstadosFlujosCajasLogic{		
	
	public  EstadosFlujosCajasLogicAdditional(Connexion connexion)throws Exception {
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
	public  EstadosFlujosCajasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkEstadosFlujosCajasToSave(EstadosFlujosCajas estadosflujoscajas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkEstadosFlujosCajasToSave(EstadosFlujosCajas estadosflujoscajas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkEstadosFlujosCajasToSaveAfter(EstadosFlujosCajas estadosflujoscajas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkEstadosFlujosCajasToSaves(List<EstadosFlujosCajas> estadosflujoscajass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkEstadosFlujosCajasToSaves(List<EstadosFlujosCajas> estadosflujoscajass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkEstadosFlujosCajasToSavesAfter(List<EstadosFlujosCajas> estadosflujoscajass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkEstadosFlujosCajasToGet(EstadosFlujosCajas estadosflujoscajas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkEstadosFlujosCajasToGets(List<EstadosFlujosCajas> estadosflujoscajass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateEstadosFlujosCajasToSave(EstadosFlujosCajas estadosflujoscajas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateEstadosFlujosCajasToGet(EstadosFlujosCajas estadosflujoscajas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectEstadosFlujosCajasActions(String sTipoJsonResponse,JSONObject jsonObjectEstadosFlujosCajas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonEstadosFlujosCajasDataTable(String sTipoJsonResponse,EstadosFlujosCajas estadosflujoscajas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonEstadosFlujosCajassDataTable(String sTipoJsonResponse,List<EstadosFlujosCajas> estadosflujoscajass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayEstadosFlujosCajasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayEstadosFlujosCajassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayEstadosFlujosCajassColumns;
	}
	
	public static void updateJSONArrayEstadosFlujosCajasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectEstadosFlujosCajas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosEstadosFlujosCajas(EstadosFlujosCajas estadosflujoscajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadosflujoscajas.setnombre_centro_actividad(estadosflujoscajas.getnombre_centro_actividad().trim());
		estadosflujoscajas.setcodigo_centro_actividad(estadosflujoscajas.getcodigo_centro_actividad().trim());
	}
	
	public static void quitarEspaciosEstadosFlujosCajass(List<EstadosFlujosCajas> estadosflujoscajass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadosFlujosCajas estadosflujoscajas: estadosflujoscajass) {
			estadosflujoscajas.setnombre_centro_actividad(estadosflujoscajas.getnombre_centro_actividad().trim());
			estadosflujoscajas.setcodigo_centro_actividad(estadosflujoscajas.getcodigo_centro_actividad().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadosFlujosCajas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(EstadosFlujosCajasConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(EstadosFlujosCajasConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(EstadosFlujosCajasConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadosFlujosCajas> estadosflujoscajass,EstadosFlujosCajas estadosflujoscajas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadosFlujosCajas estadosflujoscajasAux: estadosflujoscajass) {
			if((estadosflujoscajasAux.getId()==null && estadosflujoscajas.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(estadosflujoscajasAux.getId()!=null && estadosflujoscajas.getId()!=null){
				if(estadosflujoscajasAux.getId().equals(estadosflujoscajas.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadosFlujosCajas(List<EstadosFlujosCajas> estadosflujoscajass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double mensualTotal=0.0;
		Double acumuladoTotal=0.0;
	
		for(EstadosFlujosCajas estadosflujoscajas: estadosflujoscajass) {			
			mensualTotal+=estadosflujoscajas.getmensual();
			acumuladoTotal+=estadosflujoscajas.getacumulado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstadosFlujosCajasConstantesFunciones.MENSUAL);
		datoGeneral.setsDescripcion(EstadosFlujosCajasConstantesFunciones.LABEL_MENSUAL);
		datoGeneral.setdValorDouble(mensualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EstadosFlujosCajasConstantesFunciones.ACUMULADO);
		datoGeneral.setsDescripcion(EstadosFlujosCajasConstantesFunciones.LABEL_ACUMULADO);
		datoGeneral.setdValorDouble(acumuladoTotal);
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