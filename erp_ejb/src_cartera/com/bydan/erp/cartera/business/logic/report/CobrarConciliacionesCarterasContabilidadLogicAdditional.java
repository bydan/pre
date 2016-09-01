










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
import com.bydan.erp.cartera.util.report.CobrarConciliacionesCarterasContabilidadConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.CobrarConciliacionesCarterasContabilidadAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class CobrarConciliacionesCarterasContabilidadLogicAdditional extends CobrarConciliacionesCarterasContabilidadLogic{		
	
	public  CobrarConciliacionesCarterasContabilidadLogicAdditional(Connexion connexion)throws Exception {
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
	public  CobrarConciliacionesCarterasContabilidadLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCobrarConciliacionesCarterasContabilidadToSave(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCobrarConciliacionesCarterasContabilidadToSave(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCobrarConciliacionesCarterasContabilidadToSaveAfter(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCobrarConciliacionesCarterasContabilidadToSaves(List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCobrarConciliacionesCarterasContabilidadToSaves(List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCobrarConciliacionesCarterasContabilidadToSavesAfter(List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCobrarConciliacionesCarterasContabilidadToGet(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCobrarConciliacionesCarterasContabilidadToGets(List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCobrarConciliacionesCarterasContabilidadToSave(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCobrarConciliacionesCarterasContabilidadToGet(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCobrarConciliacionesCarterasContabilidadActions(String sTipoJsonResponse,JSONObject jsonObjectCobrarConciliacionesCarterasContabilidad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCobrarConciliacionesCarterasContabilidadDataTable(String sTipoJsonResponse,CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCobrarConciliacionesCarterasContabilidadsDataTable(String sTipoJsonResponse,List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCobrarConciliacionesCarterasContabilidadColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCobrarConciliacionesCarterasContabilidadsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCobrarConciliacionesCarterasContabilidadsColumns;
	}
	
	public static void updateJSONArrayCobrarConciliacionesCarterasContabilidadActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCobrarConciliacionesCarterasContabilidad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCobrarConciliacionesCarterasContabilidad(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarconciliacionescarterascontabilidad.setcodigo(cobrarconciliacionescarterascontabilidad.getcodigo().trim());
		cobrarconciliacionescarterascontabilidad.setcodigo_tipo_movimiento(cobrarconciliacionescarterascontabilidad.getcodigo_tipo_movimiento().trim());
		cobrarconciliacionescarterascontabilidad.setnumero_mayor(cobrarconciliacionescarterascontabilidad.getnumero_mayor().trim());
	}
	
	public static void quitarEspaciosCobrarConciliacionesCarterasContabilidads(List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad: cobrarconciliacionescarterascontabilidads) {
			cobrarconciliacionescarterascontabilidad.setcodigo(cobrarconciliacionescarterascontabilidad.getcodigo().trim());
			cobrarconciliacionescarterascontabilidad.setcodigo_tipo_movimiento(cobrarconciliacionescarterascontabilidad.getcodigo_tipo_movimiento().trim());
			cobrarconciliacionescarterascontabilidad.setnumero_mayor(cobrarconciliacionescarterascontabilidad.getnumero_mayor().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarConciliacionesCarterasContabilidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CobrarConciliacionesCarterasContabilidadConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads,CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidadAux: cobrarconciliacionescarterascontabilidads) {
			if((cobrarconciliacionescarterascontabilidadAux.getId()==null && cobrarconciliacionescarterascontabilidad.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cobrarconciliacionescarterascontabilidadAux.getId()!=null && cobrarconciliacionescarterascontabilidad.getId()!=null){
				if(cobrarconciliacionescarterascontabilidadAux.getId().equals(cobrarconciliacionescarterascontabilidad.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarConciliacionesCarterasContabilidad(List<CobrarConciliacionesCarterasContabilidad> cobrarconciliacionescarterascontabilidads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_asientoTotal=0.0;
		Double credito_asientoTotal=0.0;
		Double debito_cuentasTotal=0.0;
		Double credito_cuentasTotal=0.0;
	
		for(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad: cobrarconciliacionescarterascontabilidads) {			
			debito_asientoTotal+=cobrarconciliacionescarterascontabilidad.getdebito_asiento();
			credito_asientoTotal+=cobrarconciliacionescarterascontabilidad.getcredito_asiento();
			debito_cuentasTotal+=cobrarconciliacionescarterascontabilidad.getdebito_cuentas();
			credito_cuentasTotal+=cobrarconciliacionescarterascontabilidad.getcredito_cuentas();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOASIENTO);
		datoGeneral.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_DEBITOASIENTO);
		datoGeneral.setdValorDouble(debito_asientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOASIENTO);
		datoGeneral.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CREDITOASIENTO);
		datoGeneral.setdValorDouble(credito_asientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.DEBITOCUENTAS);
		datoGeneral.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_DEBITOCUENTAS);
		datoGeneral.setdValorDouble(debito_cuentasTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarConciliacionesCarterasContabilidadConstantesFunciones.CREDITOCUENTAS);
		datoGeneral.setsDescripcion(CobrarConciliacionesCarterasContabilidadConstantesFunciones.LABEL_CREDITOCUENTAS);
		datoGeneral.setdValorDouble(credito_cuentasTotal);
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