










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
import com.bydan.erp.activosfijos.util.report.ListadoActivosFijosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;
////import com.bydan.erp.activosfijos.business.interfaces.ListadoActivosFijosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ListadoActivosFijosLogicAdditional extends ListadoActivosFijosLogic{		
	
	public  ListadoActivosFijosLogicAdditional(Connexion connexion)throws Exception {
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
	public  ListadoActivosFijosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkListadoActivosFijosToSave(ListadoActivosFijos listadoactivosfijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkListadoActivosFijosToSave(ListadoActivosFijos listadoactivosfijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkListadoActivosFijosToSaveAfter(ListadoActivosFijos listadoactivosfijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkListadoActivosFijosToSaves(List<ListadoActivosFijos> listadoactivosfijoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkListadoActivosFijosToSaves(List<ListadoActivosFijos> listadoactivosfijoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkListadoActivosFijosToSavesAfter(List<ListadoActivosFijos> listadoactivosfijoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkListadoActivosFijosToGet(ListadoActivosFijos listadoactivosfijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkListadoActivosFijosToGets(List<ListadoActivosFijos> listadoactivosfijoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateListadoActivosFijosToSave(ListadoActivosFijos listadoactivosfijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateListadoActivosFijosToGet(ListadoActivosFijos listadoactivosfijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectListadoActivosFijosActions(String sTipoJsonResponse,JSONObject jsonObjectListadoActivosFijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonListadoActivosFijosDataTable(String sTipoJsonResponse,ListadoActivosFijos listadoactivosfijos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonListadoActivosFijossDataTable(String sTipoJsonResponse,List<ListadoActivosFijos> listadoactivosfijoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayListadoActivosFijosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayListadoActivosFijossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayListadoActivosFijossColumns;
	}
	
	public static void updateJSONArrayListadoActivosFijosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectListadoActivosFijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosListadoActivosFijos(ListadoActivosFijos listadoactivosfijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		listadoactivosfijos.setcodigo_sub_grupo(listadoactivosfijos.getcodigo_sub_grupo().trim());
		listadoactivosfijos.setnombre_sub_grupo(listadoactivosfijos.getnombre_sub_grupo().trim());
		listadoactivosfijos.setcodigo_detalle_grupo(listadoactivosfijos.getcodigo_detalle_grupo().trim());
		listadoactivosfijos.setnombre_detalle_grupo(listadoactivosfijos.getnombre_detalle_grupo().trim());
		listadoactivosfijos.setclave(listadoactivosfijos.getclave().trim());
		listadoactivosfijos.setnombre(listadoactivosfijos.getnombre().trim());
	}
	
	public static void quitarEspaciosListadoActivosFijoss(List<ListadoActivosFijos> listadoactivosfijoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ListadoActivosFijos listadoactivosfijos: listadoactivosfijoss) {
			listadoactivosfijos.setcodigo_sub_grupo(listadoactivosfijos.getcodigo_sub_grupo().trim());
			listadoactivosfijos.setnombre_sub_grupo(listadoactivosfijos.getnombre_sub_grupo().trim());
			listadoactivosfijos.setcodigo_detalle_grupo(listadoactivosfijos.getcodigo_detalle_grupo().trim());
			listadoactivosfijos.setnombre_detalle_grupo(listadoactivosfijos.getnombre_detalle_grupo().trim());
			listadoactivosfijos.setclave(listadoactivosfijos.getclave().trim());
			listadoactivosfijos.setnombre(listadoactivosfijos.getnombre().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesListadoActivosFijos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ListadoActivosFijosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ListadoActivosFijos> listadoactivosfijoss,ListadoActivosFijos listadoactivosfijos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ListadoActivosFijos listadoactivosfijosAux: listadoactivosfijoss) {
			if((listadoactivosfijosAux.getId()==null && listadoactivosfijos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(listadoactivosfijosAux.getId()!=null && listadoactivosfijos.getId()!=null){
				if(listadoactivosfijosAux.getId().equals(listadoactivosfijos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaListadoActivosFijos(List<ListadoActivosFijos> listadoactivosfijoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
	
		for(ListadoActivosFijos listadoactivosfijos: listadoactivosfijoss) {			
			vida_utilTotal+=listadoactivosfijos.getvida_util();
			costo_de_compraTotal+=listadoactivosfijos.getcosto_de_compra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadoActivosFijosConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(ListadoActivosFijosConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadoActivosFijosConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(ListadoActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA);
		datoGeneral.setdValorDouble(costo_de_compraTotal);
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