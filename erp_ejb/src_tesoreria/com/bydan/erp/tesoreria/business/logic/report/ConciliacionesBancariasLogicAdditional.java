










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.tesoreria.business.logic.report;

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
import com.bydan.erp.tesoreria.util.report.ConciliacionesBancariasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;
////import com.bydan.erp.tesoreria.business.interfaces.ConciliacionesBancariasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ConciliacionesBancariasLogicAdditional extends ConciliacionesBancariasLogic{		
	
	public  ConciliacionesBancariasLogicAdditional(Connexion connexion)throws Exception {
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
	public  ConciliacionesBancariasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkConciliacionesBancariasToSave(ConciliacionesBancarias conciliacionesbancarias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkConciliacionesBancariasToSave(ConciliacionesBancarias conciliacionesbancarias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkConciliacionesBancariasToSaveAfter(ConciliacionesBancarias conciliacionesbancarias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkConciliacionesBancariasToSaves(List<ConciliacionesBancarias> conciliacionesbancariass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkConciliacionesBancariasToSaves(List<ConciliacionesBancarias> conciliacionesbancariass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkConciliacionesBancariasToSavesAfter(List<ConciliacionesBancarias> conciliacionesbancariass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkConciliacionesBancariasToGet(ConciliacionesBancarias conciliacionesbancarias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkConciliacionesBancariasToGets(List<ConciliacionesBancarias> conciliacionesbancariass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateConciliacionesBancariasToSave(ConciliacionesBancarias conciliacionesbancarias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateConciliacionesBancariasToGet(ConciliacionesBancarias conciliacionesbancarias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectConciliacionesBancariasActions(String sTipoJsonResponse,JSONObject jsonObjectConciliacionesBancarias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonConciliacionesBancariasDataTable(String sTipoJsonResponse,ConciliacionesBancarias conciliacionesbancarias,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonConciliacionesBancariassDataTable(String sTipoJsonResponse,List<ConciliacionesBancarias> conciliacionesbancariass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayConciliacionesBancariasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayConciliacionesBancariassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayConciliacionesBancariassColumns;
	}
	
	public static void updateJSONArrayConciliacionesBancariasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectConciliacionesBancarias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosConciliacionesBancarias(ConciliacionesBancarias conciliacionesbancarias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		conciliacionesbancarias.setnumero_mayor(conciliacionesbancarias.getnumero_mayor().trim());
		conciliacionesbancarias.setcodigo_cuenta(conciliacionesbancarias.getcodigo_cuenta().trim());
		conciliacionesbancarias.setnombre_cuenta(conciliacionesbancarias.getnombre_cuenta().trim());
		conciliacionesbancarias.setnumero_deposito(conciliacionesbancarias.getnumero_deposito().trim());
		conciliacionesbancarias.setdetalle(conciliacionesbancarias.getdetalle().trim());
		conciliacionesbancarias.setbeneficiario(conciliacionesbancarias.getbeneficiario().trim());
	}
	
	public static void quitarEspaciosConciliacionesBancariass(List<ConciliacionesBancarias> conciliacionesbancariass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ConciliacionesBancarias conciliacionesbancarias: conciliacionesbancariass) {
			conciliacionesbancarias.setnumero_mayor(conciliacionesbancarias.getnumero_mayor().trim());
			conciliacionesbancarias.setcodigo_cuenta(conciliacionesbancarias.getcodigo_cuenta().trim());
			conciliacionesbancarias.setnombre_cuenta(conciliacionesbancarias.getnombre_cuenta().trim());
			conciliacionesbancarias.setnumero_deposito(conciliacionesbancarias.getnumero_deposito().trim());
			conciliacionesbancarias.setdetalle(conciliacionesbancarias.getdetalle().trim());
			conciliacionesbancarias.setbeneficiario(conciliacionesbancarias.getbeneficiario().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConciliacionesBancarias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ConciliacionesBancariasConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ConciliacionesBancarias> conciliacionesbancariass,ConciliacionesBancarias conciliacionesbancarias,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ConciliacionesBancarias conciliacionesbancariasAux: conciliacionesbancariass) {
			if((conciliacionesbancariasAux.getId()==null && conciliacionesbancarias.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(conciliacionesbancariasAux.getId()!=null && conciliacionesbancarias.getId()!=null){
				if(conciliacionesbancariasAux.getId().equals(conciliacionesbancarias.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConciliacionesBancarias(List<ConciliacionesBancarias> conciliacionesbancariass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
		Double debito_extranTotal=0.0;
		Double credito_extranTotal=0.0;
	
		for(ConciliacionesBancarias conciliacionesbancarias: conciliacionesbancariass) {			
			debito_localTotal+=conciliacionesbancarias.getdebito_local();
			credito_localTotal+=conciliacionesbancarias.getcredito_local();
			debito_extranTotal+=conciliacionesbancarias.getdebito_extran();
			credito_extranTotal+=conciliacionesbancarias.getcredito_extran();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConciliacionesBancariasConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConciliacionesBancariasConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConciliacionesBancariasConstantesFunciones.DEBITOEXTRAN);
		datoGeneral.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_DEBITOEXTRAN);
		datoGeneral.setdValorDouble(debito_extranTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConciliacionesBancariasConstantesFunciones.CREDITOEXTRAN);
		datoGeneral.setsDescripcion(ConciliacionesBancariasConstantesFunciones.LABEL_CREDITOEXTRAN);
		datoGeneral.setdValorDouble(credito_extranTotal);
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