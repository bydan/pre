










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
import com.bydan.erp.contabilidad.util.report.ListadosCentrosCostosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
////import com.bydan.erp.contabilidad.business.interfaces.ListadosCentrosCostosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ListadosCentrosCostosLogicAdditional extends ListadosCentrosCostosLogic{		
	
	public  ListadosCentrosCostosLogicAdditional(Connexion connexion)throws Exception {
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
	public  ListadosCentrosCostosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkListadosCentrosCostosToSave(ListadosCentrosCostos listadoscentroscostos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkListadosCentrosCostosToSave(ListadosCentrosCostos listadoscentroscostos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkListadosCentrosCostosToSaveAfter(ListadosCentrosCostos listadoscentroscostos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkListadosCentrosCostosToSaves(List<ListadosCentrosCostos> listadoscentroscostoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkListadosCentrosCostosToSaves(List<ListadosCentrosCostos> listadoscentroscostoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkListadosCentrosCostosToSavesAfter(List<ListadosCentrosCostos> listadoscentroscostoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkListadosCentrosCostosToGet(ListadosCentrosCostos listadoscentroscostos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkListadosCentrosCostosToGets(List<ListadosCentrosCostos> listadoscentroscostoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateListadosCentrosCostosToSave(ListadosCentrosCostos listadoscentroscostos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateListadosCentrosCostosToGet(ListadosCentrosCostos listadoscentroscostos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectListadosCentrosCostosActions(String sTipoJsonResponse,JSONObject jsonObjectListadosCentrosCostos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonListadosCentrosCostosDataTable(String sTipoJsonResponse,ListadosCentrosCostos listadoscentroscostos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonListadosCentrosCostossDataTable(String sTipoJsonResponse,List<ListadosCentrosCostos> listadoscentroscostoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayListadosCentrosCostosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayListadosCentrosCostossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayListadosCentrosCostossColumns;
	}
	
	public static void updateJSONArrayListadosCentrosCostosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectListadosCentrosCostos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosListadosCentrosCostos(ListadosCentrosCostos listadoscentroscostos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		listadoscentroscostos.setcodigo(listadoscentroscostos.getcodigo().trim());
		listadoscentroscostos.setnombre(listadoscentroscostos.getnombre().trim());
	}
	
	public static void quitarEspaciosListadosCentrosCostoss(List<ListadosCentrosCostos> listadoscentroscostoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ListadosCentrosCostos listadoscentroscostos: listadoscentroscostoss) {
			listadoscentroscostos.setcodigo(listadoscentroscostos.getcodigo().trim());
			listadoscentroscostos.setnombre(listadoscentroscostos.getnombre().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesListadosCentrosCostos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ListadosCentrosCostosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ListadosCentrosCostos> listadoscentroscostoss,ListadosCentrosCostos listadoscentroscostos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ListadosCentrosCostos listadoscentroscostosAux: listadoscentroscostoss) {
			if((listadoscentroscostosAux.getId()==null && listadoscentroscostos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(listadoscentroscostosAux.getId()!=null && listadoscentroscostos.getId()!=null){
				if(listadoscentroscostosAux.getId().equals(listadoscentroscostos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaListadosCentrosCostos(List<ListadosCentrosCostos> listadoscentroscostoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double valorTotal=0.0;
	
		for(ListadosCentrosCostos listadoscentroscostos: listadoscentroscostoss) {			
			porcentajeTotal+=listadoscentroscostos.getporcentaje();
			valorTotal+=listadoscentroscostos.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadosCentrosCostosConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ListadosCentrosCostosConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadosCentrosCostosConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ListadosCentrosCostosConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
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