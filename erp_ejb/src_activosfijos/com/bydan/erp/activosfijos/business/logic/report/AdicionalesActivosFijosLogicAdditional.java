










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
import com.bydan.erp.activosfijos.util.report.AdicionalesActivosFijosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;
////import com.bydan.erp.activosfijos.business.interfaces.AdicionalesActivosFijosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class AdicionalesActivosFijosLogicAdditional extends AdicionalesActivosFijosLogic{		
	
	public  AdicionalesActivosFijosLogicAdditional(Connexion connexion)throws Exception {
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
	public  AdicionalesActivosFijosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkAdicionalesActivosFijosToSave(AdicionalesActivosFijos adicionalesactivosfijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkAdicionalesActivosFijosToSave(AdicionalesActivosFijos adicionalesactivosfijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkAdicionalesActivosFijosToSaveAfter(AdicionalesActivosFijos adicionalesactivosfijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkAdicionalesActivosFijosToSaves(List<AdicionalesActivosFijos> adicionalesactivosfijoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkAdicionalesActivosFijosToSaves(List<AdicionalesActivosFijos> adicionalesactivosfijoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkAdicionalesActivosFijosToSavesAfter(List<AdicionalesActivosFijos> adicionalesactivosfijoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkAdicionalesActivosFijosToGet(AdicionalesActivosFijos adicionalesactivosfijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkAdicionalesActivosFijosToGets(List<AdicionalesActivosFijos> adicionalesactivosfijoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateAdicionalesActivosFijosToSave(AdicionalesActivosFijos adicionalesactivosfijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateAdicionalesActivosFijosToGet(AdicionalesActivosFijos adicionalesactivosfijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectAdicionalesActivosFijosActions(String sTipoJsonResponse,JSONObject jsonObjectAdicionalesActivosFijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonAdicionalesActivosFijosDataTable(String sTipoJsonResponse,AdicionalesActivosFijos adicionalesactivosfijos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonAdicionalesActivosFijossDataTable(String sTipoJsonResponse,List<AdicionalesActivosFijos> adicionalesactivosfijoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayAdicionalesActivosFijosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayAdicionalesActivosFijossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayAdicionalesActivosFijossColumns;
	}
	
	public static void updateJSONArrayAdicionalesActivosFijosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectAdicionalesActivosFijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosAdicionalesActivosFijos(AdicionalesActivosFijos adicionalesactivosfijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		adicionalesactivosfijos.setcodigo_sub_grupo(adicionalesactivosfijos.getcodigo_sub_grupo().trim());
		adicionalesactivosfijos.setnombre_sub_grupo(adicionalesactivosfijos.getnombre_sub_grupo().trim());
		adicionalesactivosfijos.setcodigo_detalle_grupo(adicionalesactivosfijos.getcodigo_detalle_grupo().trim());
		adicionalesactivosfijos.setnombre_detalle_grupo(adicionalesactivosfijos.getnombre_detalle_grupo().trim());
		adicionalesactivosfijos.setclave(adicionalesactivosfijos.getclave().trim());
		adicionalesactivosfijos.setnombre(adicionalesactivosfijos.getnombre().trim());
	}
	
	public static void quitarEspaciosAdicionalesActivosFijoss(List<AdicionalesActivosFijos> adicionalesactivosfijoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AdicionalesActivosFijos adicionalesactivosfijos: adicionalesactivosfijoss) {
			adicionalesactivosfijos.setcodigo_sub_grupo(adicionalesactivosfijos.getcodigo_sub_grupo().trim());
			adicionalesactivosfijos.setnombre_sub_grupo(adicionalesactivosfijos.getnombre_sub_grupo().trim());
			adicionalesactivosfijos.setcodigo_detalle_grupo(adicionalesactivosfijos.getcodigo_detalle_grupo().trim());
			adicionalesactivosfijos.setnombre_detalle_grupo(adicionalesactivosfijos.getnombre_detalle_grupo().trim());
			adicionalesactivosfijos.setclave(adicionalesactivosfijos.getclave().trim());
			adicionalesactivosfijos.setnombre(adicionalesactivosfijos.getnombre().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAdicionalesActivosFijos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(AdicionalesActivosFijosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AdicionalesActivosFijos> adicionalesactivosfijoss,AdicionalesActivosFijos adicionalesactivosfijos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AdicionalesActivosFijos adicionalesactivosfijosAux: adicionalesactivosfijoss) {
			if((adicionalesactivosfijosAux.getId()==null && adicionalesactivosfijos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(adicionalesactivosfijosAux.getId()!=null && adicionalesactivosfijos.getId()!=null){
				if(adicionalesactivosfijosAux.getId().equals(adicionalesactivosfijos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAdicionalesActivosFijos(List<AdicionalesActivosFijos> adicionalesactivosfijoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
	
		for(AdicionalesActivosFijos adicionalesactivosfijos: adicionalesactivosfijoss) {			
			vida_utilTotal+=adicionalesactivosfijos.getvida_util();
			costo_de_compraTotal+=adicionalesactivosfijos.getcosto_de_compra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AdicionalesActivosFijosConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(AdicionalesActivosFijosConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AdicionalesActivosFijosConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(AdicionalesActivosFijosConstantesFunciones.LABEL_COSTODECOMPRA);
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