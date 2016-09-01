










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
import com.bydan.erp.tesoreria.util.report.HistorialConciliacionesBancariasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;
////import com.bydan.erp.tesoreria.business.interfaces.HistorialConciliacionesBancariasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class HistorialConciliacionesBancariasLogicAdditional extends HistorialConciliacionesBancariasLogic{		
	
	public  HistorialConciliacionesBancariasLogicAdditional(Connexion connexion)throws Exception {
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
	public  HistorialConciliacionesBancariasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkHistorialConciliacionesBancariasToSave(HistorialConciliacionesBancarias historialconciliacionesbancarias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkHistorialConciliacionesBancariasToSave(HistorialConciliacionesBancarias historialconciliacionesbancarias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkHistorialConciliacionesBancariasToSaveAfter(HistorialConciliacionesBancarias historialconciliacionesbancarias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkHistorialConciliacionesBancariasToSaves(List<HistorialConciliacionesBancarias> historialconciliacionesbancariass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkHistorialConciliacionesBancariasToSaves(List<HistorialConciliacionesBancarias> historialconciliacionesbancariass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkHistorialConciliacionesBancariasToSavesAfter(List<HistorialConciliacionesBancarias> historialconciliacionesbancariass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkHistorialConciliacionesBancariasToGet(HistorialConciliacionesBancarias historialconciliacionesbancarias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkHistorialConciliacionesBancariasToGets(List<HistorialConciliacionesBancarias> historialconciliacionesbancariass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateHistorialConciliacionesBancariasToSave(HistorialConciliacionesBancarias historialconciliacionesbancarias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateHistorialConciliacionesBancariasToGet(HistorialConciliacionesBancarias historialconciliacionesbancarias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectHistorialConciliacionesBancariasActions(String sTipoJsonResponse,JSONObject jsonObjectHistorialConciliacionesBancarias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonHistorialConciliacionesBancariasDataTable(String sTipoJsonResponse,HistorialConciliacionesBancarias historialconciliacionesbancarias,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonHistorialConciliacionesBancariassDataTable(String sTipoJsonResponse,List<HistorialConciliacionesBancarias> historialconciliacionesbancariass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayHistorialConciliacionesBancariasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayHistorialConciliacionesBancariassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayHistorialConciliacionesBancariassColumns;
	}
	
	public static void updateJSONArrayHistorialConciliacionesBancariasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectHistorialConciliacionesBancarias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosHistorialConciliacionesBancarias(HistorialConciliacionesBancarias historialconciliacionesbancarias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		historialconciliacionesbancarias.setnumero_cheque(historialconciliacionesbancarias.getnumero_cheque().trim());
		historialconciliacionesbancarias.setcodigo(historialconciliacionesbancarias.getcodigo().trim());
		historialconciliacionesbancarias.setbeneficiario(historialconciliacionesbancarias.getbeneficiario().trim());
		historialconciliacionesbancarias.setdetalle(historialconciliacionesbancarias.getdetalle().trim());
		historialconciliacionesbancarias.setcuenta(historialconciliacionesbancarias.getcuenta().trim());
		historialconciliacionesbancarias.settipo_documento(historialconciliacionesbancarias.gettipo_documento().trim());
		historialconciliacionesbancarias.setnumero_mayor(historialconciliacionesbancarias.getnumero_mayor().trim());
		historialconciliacionesbancarias.settipo_movimiento(historialconciliacionesbancarias.gettipo_movimiento().trim());
		historialconciliacionesbancarias.setnumero_cuenta(historialconciliacionesbancarias.getnumero_cuenta().trim());
		historialconciliacionesbancarias.setnombre_cuenta_contable(historialconciliacionesbancarias.getnombre_cuenta_contable().trim());
	}
	
	public static void quitarEspaciosHistorialConciliacionesBancariass(List<HistorialConciliacionesBancarias> historialconciliacionesbancariass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(HistorialConciliacionesBancarias historialconciliacionesbancarias: historialconciliacionesbancariass) {
			historialconciliacionesbancarias.setnumero_cheque(historialconciliacionesbancarias.getnumero_cheque().trim());
			historialconciliacionesbancarias.setcodigo(historialconciliacionesbancarias.getcodigo().trim());
			historialconciliacionesbancarias.setbeneficiario(historialconciliacionesbancarias.getbeneficiario().trim());
			historialconciliacionesbancarias.setdetalle(historialconciliacionesbancarias.getdetalle().trim());
			historialconciliacionesbancarias.setcuenta(historialconciliacionesbancarias.getcuenta().trim());
			historialconciliacionesbancarias.settipo_documento(historialconciliacionesbancarias.gettipo_documento().trim());
			historialconciliacionesbancarias.setnumero_mayor(historialconciliacionesbancarias.getnumero_mayor().trim());
			historialconciliacionesbancarias.settipo_movimiento(historialconciliacionesbancarias.gettipo_movimiento().trim());
			historialconciliacionesbancarias.setnumero_cuenta(historialconciliacionesbancarias.getnumero_cuenta().trim());
			historialconciliacionesbancarias.setnombre_cuenta_contable(historialconciliacionesbancarias.getnombre_cuenta_contable().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesHistorialConciliacionesBancarias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(HistorialConciliacionesBancariasConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<HistorialConciliacionesBancarias> historialconciliacionesbancariass,HistorialConciliacionesBancarias historialconciliacionesbancarias,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(HistorialConciliacionesBancarias historialconciliacionesbancariasAux: historialconciliacionesbancariass) {
			if((historialconciliacionesbancariasAux.getId()==null && historialconciliacionesbancarias.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(historialconciliacionesbancariasAux.getId()!=null && historialconciliacionesbancarias.getId()!=null){
				if(historialconciliacionesbancariasAux.getId().equals(historialconciliacionesbancarias.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaHistorialConciliacionesBancarias(List<HistorialConciliacionesBancarias> historialconciliacionesbancariass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
		Double saldo_librosTotal=0.0;
		Double anteriorTotal=0.0;
	
		for(HistorialConciliacionesBancarias historialconciliacionesbancarias: historialconciliacionesbancariass) {			
			debito_localTotal+=historialconciliacionesbancarias.getdebito_local();
			credito_localTotal+=historialconciliacionesbancarias.getcredito_local();
			saldo_librosTotal+=historialconciliacionesbancarias.getsaldo_libros();
			anteriorTotal+=historialconciliacionesbancarias.getanterior();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.SALDOLIBROS);
		datoGeneral.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_SALDOLIBROS);
		datoGeneral.setdValorDouble(saldo_librosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(HistorialConciliacionesBancariasConstantesFunciones.ANTERIOR);
		datoGeneral.setsDescripcion(HistorialConciliacionesBancariasConstantesFunciones.LABEL_ANTERIOR);
		datoGeneral.setdValorDouble(anteriorTotal);
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