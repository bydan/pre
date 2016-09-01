










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.cartera.business.logic.report;

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
import com.bydan.erp.cartera.util.report.CobrarClientesNovedadesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.CobrarClientesNovedadesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class CobrarClientesNovedadesLogicAdditional extends CobrarClientesNovedadesLogic{		
	
	public  CobrarClientesNovedadesLogicAdditional(Connexion connexion)throws Exception {
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
	public  CobrarClientesNovedadesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCobrarClientesNovedadesToSave(CobrarClientesNovedades cobrarclientesnovedades,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCobrarClientesNovedadesToSave(CobrarClientesNovedades cobrarclientesnovedades,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCobrarClientesNovedadesToSaveAfter(CobrarClientesNovedades cobrarclientesnovedades,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCobrarClientesNovedadesToSaves(List<CobrarClientesNovedades> cobrarclientesnovedadess,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCobrarClientesNovedadesToSaves(List<CobrarClientesNovedades> cobrarclientesnovedadess,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCobrarClientesNovedadesToSavesAfter(List<CobrarClientesNovedades> cobrarclientesnovedadess,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCobrarClientesNovedadesToGet(CobrarClientesNovedades cobrarclientesnovedades,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCobrarClientesNovedadesToGets(List<CobrarClientesNovedades> cobrarclientesnovedadess,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCobrarClientesNovedadesToSave(CobrarClientesNovedades cobrarclientesnovedades,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCobrarClientesNovedadesToGet(CobrarClientesNovedades cobrarclientesnovedades,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCobrarClientesNovedadesActions(String sTipoJsonResponse,JSONObject jsonObjectCobrarClientesNovedades,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCobrarClientesNovedadesDataTable(String sTipoJsonResponse,CobrarClientesNovedades cobrarclientesnovedades,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCobrarClientesNovedadessDataTable(String sTipoJsonResponse,List<CobrarClientesNovedades> cobrarclientesnovedadess,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCobrarClientesNovedadesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCobrarClientesNovedadessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCobrarClientesNovedadessColumns;
	}
	
	public static void updateJSONArrayCobrarClientesNovedadesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCobrarClientesNovedades,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCobrarClientesNovedades(CobrarClientesNovedades cobrarclientesnovedades,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarclientesnovedades.setcodigo(cobrarclientesnovedades.getcodigo().trim());
		cobrarclientesnovedades.setnombre(cobrarclientesnovedades.getnombre().trim());
		cobrarclientesnovedades.setapellido(cobrarclientesnovedades.getapellido().trim());
		cobrarclientesnovedades.setaccion_tomada(cobrarclientesnovedades.getaccion_tomada().trim());
		cobrarclientesnovedades.setdescripcion(cobrarclientesnovedades.getdescripcion().trim());
	}
	
	public static void quitarEspaciosCobrarClientesNovedadess(List<CobrarClientesNovedades> cobrarclientesnovedadess,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarClientesNovedades cobrarclientesnovedades: cobrarclientesnovedadess) {
			cobrarclientesnovedades.setcodigo(cobrarclientesnovedades.getcodigo().trim());
			cobrarclientesnovedades.setnombre(cobrarclientesnovedades.getnombre().trim());
			cobrarclientesnovedades.setapellido(cobrarclientesnovedades.getapellido().trim());
			cobrarclientesnovedades.setaccion_tomada(cobrarclientesnovedades.getaccion_tomada().trim());
			cobrarclientesnovedades.setdescripcion(cobrarclientesnovedades.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesNovedades(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CobrarClientesNovedadesConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(CobrarClientesNovedadesConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarClientesNovedades> cobrarclientesnovedadess,CobrarClientesNovedades cobrarclientesnovedades,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarClientesNovedades cobrarclientesnovedadesAux: cobrarclientesnovedadess) {
			if((cobrarclientesnovedadesAux.getId()==null && cobrarclientesnovedades.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cobrarclientesnovedadesAux.getId()!=null && cobrarclientesnovedades.getId()!=null){
				if(cobrarclientesnovedadesAux.getId().equals(cobrarclientesnovedades.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarClientesNovedades(List<CobrarClientesNovedades> cobrarclientesnovedadess) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CobrarClientesNovedades cobrarclientesnovedades: cobrarclientesnovedadess) {			
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