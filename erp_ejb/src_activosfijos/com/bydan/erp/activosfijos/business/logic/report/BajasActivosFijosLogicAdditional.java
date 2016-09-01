










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
import com.bydan.erp.activosfijos.util.report.BajasActivosFijosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;
////import com.bydan.erp.activosfijos.business.interfaces.BajasActivosFijosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class BajasActivosFijosLogicAdditional extends BajasActivosFijosLogic{		
	
	public  BajasActivosFijosLogicAdditional(Connexion connexion)throws Exception {
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
	public  BajasActivosFijosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkBajasActivosFijosToSave(BajasActivosFijos bajasactivosfijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkBajasActivosFijosToSave(BajasActivosFijos bajasactivosfijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkBajasActivosFijosToSaveAfter(BajasActivosFijos bajasactivosfijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkBajasActivosFijosToSaves(List<BajasActivosFijos> bajasactivosfijoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkBajasActivosFijosToSaves(List<BajasActivosFijos> bajasactivosfijoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkBajasActivosFijosToSavesAfter(List<BajasActivosFijos> bajasactivosfijoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkBajasActivosFijosToGet(BajasActivosFijos bajasactivosfijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkBajasActivosFijosToGets(List<BajasActivosFijos> bajasactivosfijoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateBajasActivosFijosToSave(BajasActivosFijos bajasactivosfijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateBajasActivosFijosToGet(BajasActivosFijos bajasactivosfijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectBajasActivosFijosActions(String sTipoJsonResponse,JSONObject jsonObjectBajasActivosFijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonBajasActivosFijosDataTable(String sTipoJsonResponse,BajasActivosFijos bajasactivosfijos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonBajasActivosFijossDataTable(String sTipoJsonResponse,List<BajasActivosFijos> bajasactivosfijoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayBajasActivosFijosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayBajasActivosFijossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayBajasActivosFijossColumns;
	}
	
	public static void updateJSONArrayBajasActivosFijosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectBajasActivosFijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosBajasActivosFijos(BajasActivosFijos bajasactivosfijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		bajasactivosfijos.setcodigo_sub_grupo(bajasactivosfijos.getcodigo_sub_grupo().trim());
		bajasactivosfijos.setnombre_sub_grupo(bajasactivosfijos.getnombre_sub_grupo().trim());
		bajasactivosfijos.setcodigo_detalle_grupo(bajasactivosfijos.getcodigo_detalle_grupo().trim());
		bajasactivosfijos.setnombre_detalle_grupo(bajasactivosfijos.getnombre_detalle_grupo().trim());
		bajasactivosfijos.setclave(bajasactivosfijos.getclave().trim());
		bajasactivosfijos.setnombre(bajasactivosfijos.getnombre().trim());
	}
	
	public static void quitarEspaciosBajasActivosFijoss(List<BajasActivosFijos> bajasactivosfijoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(BajasActivosFijos bajasactivosfijos: bajasactivosfijoss) {
			bajasactivosfijos.setcodigo_sub_grupo(bajasactivosfijos.getcodigo_sub_grupo().trim());
			bajasactivosfijos.setnombre_sub_grupo(bajasactivosfijos.getnombre_sub_grupo().trim());
			bajasactivosfijos.setcodigo_detalle_grupo(bajasactivosfijos.getcodigo_detalle_grupo().trim());
			bajasactivosfijos.setnombre_detalle_grupo(bajasactivosfijos.getnombre_detalle_grupo().trim());
			bajasactivosfijos.setclave(bajasactivosfijos.getclave().trim());
			bajasactivosfijos.setnombre(bajasactivosfijos.getnombre().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBajasActivosFijos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(BajasActivosFijosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<BajasActivosFijos> bajasactivosfijoss,BajasActivosFijos bajasactivosfijos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(BajasActivosFijos bajasactivosfijosAux: bajasactivosfijoss) {
			if((bajasactivosfijosAux.getId()==null && bajasactivosfijos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(bajasactivosfijosAux.getId()!=null && bajasactivosfijos.getId()!=null){
				if(bajasactivosfijosAux.getId().equals(bajasactivosfijos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBajasActivosFijos(List<BajasActivosFijos> bajasactivosfijoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
	
		for(BajasActivosFijos bajasactivosfijos: bajasactivosfijoss) {			
			vida_utilTotal+=bajasactivosfijos.getvida_util();
			costo_de_compraTotal+=bajasactivosfijos.getcosto_de_compra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BajasActivosFijosConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(BajasActivosFijosConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BajasActivosFijosConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(BajasActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA);
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