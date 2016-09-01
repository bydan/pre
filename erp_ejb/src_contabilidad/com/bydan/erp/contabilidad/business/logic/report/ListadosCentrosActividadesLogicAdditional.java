










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
import com.bydan.erp.contabilidad.util.report.ListadosCentrosActividadesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
////import com.bydan.erp.contabilidad.business.interfaces.ListadosCentrosActividadesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ListadosCentrosActividadesLogicAdditional extends ListadosCentrosActividadesLogic{		
	
	public  ListadosCentrosActividadesLogicAdditional(Connexion connexion)throws Exception {
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
	public  ListadosCentrosActividadesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkListadosCentrosActividadesToSave(ListadosCentrosActividades listadoscentrosactividades,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkListadosCentrosActividadesToSave(ListadosCentrosActividades listadoscentrosactividades,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkListadosCentrosActividadesToSaveAfter(ListadosCentrosActividades listadoscentrosactividades,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkListadosCentrosActividadesToSaves(List<ListadosCentrosActividades> listadoscentrosactividadess,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkListadosCentrosActividadesToSaves(List<ListadosCentrosActividades> listadoscentrosactividadess,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkListadosCentrosActividadesToSavesAfter(List<ListadosCentrosActividades> listadoscentrosactividadess,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkListadosCentrosActividadesToGet(ListadosCentrosActividades listadoscentrosactividades,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkListadosCentrosActividadesToGets(List<ListadosCentrosActividades> listadoscentrosactividadess,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateListadosCentrosActividadesToSave(ListadosCentrosActividades listadoscentrosactividades,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateListadosCentrosActividadesToGet(ListadosCentrosActividades listadoscentrosactividades,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectListadosCentrosActividadesActions(String sTipoJsonResponse,JSONObject jsonObjectListadosCentrosActividades,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonListadosCentrosActividadesDataTable(String sTipoJsonResponse,ListadosCentrosActividades listadoscentrosactividades,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonListadosCentrosActividadessDataTable(String sTipoJsonResponse,List<ListadosCentrosActividades> listadoscentrosactividadess,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayListadosCentrosActividadesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayListadosCentrosActividadessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayListadosCentrosActividadessColumns;
	}
	
	public static void updateJSONArrayListadosCentrosActividadesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectListadosCentrosActividades,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosListadosCentrosActividades(ListadosCentrosActividades listadoscentrosactividades,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		listadoscentrosactividades.setcodigo(listadoscentrosactividades.getcodigo().trim());
		listadoscentrosactividades.setnombre(listadoscentrosactividades.getnombre().trim());
	}
	
	public static void quitarEspaciosListadosCentrosActividadess(List<ListadosCentrosActividades> listadoscentrosactividadess,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ListadosCentrosActividades listadoscentrosactividades: listadoscentrosactividadess) {
			listadoscentrosactividades.setcodigo(listadoscentrosactividades.getcodigo().trim());
			listadoscentrosactividades.setnombre(listadoscentrosactividades.getnombre().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesListadosCentrosActividades(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ListadosCentrosActividadesConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ListadosCentrosActividades> listadoscentrosactividadess,ListadosCentrosActividades listadoscentrosactividades,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ListadosCentrosActividades listadoscentrosactividadesAux: listadoscentrosactividadess) {
			if((listadoscentrosactividadesAux.getId()==null && listadoscentrosactividades.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(listadoscentrosactividadesAux.getId()!=null && listadoscentrosactividades.getId()!=null){
				if(listadoscentrosactividadesAux.getId().equals(listadoscentrosactividades.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaListadosCentrosActividades(List<ListadosCentrosActividades> listadoscentrosactividadess) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ListadosCentrosActividades listadoscentrosactividades: listadoscentrosactividadess) {			
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