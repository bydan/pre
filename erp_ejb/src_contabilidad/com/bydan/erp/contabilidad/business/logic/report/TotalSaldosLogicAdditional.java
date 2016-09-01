










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
import com.bydan.erp.contabilidad.util.report.TotalSaldosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
////import com.bydan.erp.contabilidad.business.interfaces.TotalSaldosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class TotalSaldosLogicAdditional extends TotalSaldosLogic{		
	
	public  TotalSaldosLogicAdditional(Connexion connexion)throws Exception {
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
	public  TotalSaldosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkTotalSaldosToSave(TotalSaldos totalsaldos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkTotalSaldosToSave(TotalSaldos totalsaldos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkTotalSaldosToSaveAfter(TotalSaldos totalsaldos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkTotalSaldosToSaves(List<TotalSaldos> totalsaldoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkTotalSaldosToSaves(List<TotalSaldos> totalsaldoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkTotalSaldosToSavesAfter(List<TotalSaldos> totalsaldoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkTotalSaldosToGet(TotalSaldos totalsaldos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkTotalSaldosToGets(List<TotalSaldos> totalsaldoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateTotalSaldosToSave(TotalSaldos totalsaldos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateTotalSaldosToGet(TotalSaldos totalsaldos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectTotalSaldosActions(String sTipoJsonResponse,JSONObject jsonObjectTotalSaldos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonTotalSaldosDataTable(String sTipoJsonResponse,TotalSaldos totalsaldos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonTotalSaldossDataTable(String sTipoJsonResponse,List<TotalSaldos> totalsaldoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayTotalSaldosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayTotalSaldossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayTotalSaldossColumns;
	}
	
	public static void updateJSONArrayTotalSaldosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectTotalSaldos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosTotalSaldos(TotalSaldos totalsaldos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosTotalSaldoss(List<TotalSaldos> totalsaldoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TotalSaldos totalsaldos: totalsaldoss) {
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTotalSaldos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TotalSaldos> totalsaldoss,TotalSaldos totalsaldos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TotalSaldos totalsaldosAux: totalsaldoss) {
			if((totalsaldosAux.getId()==null && totalsaldos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(totalsaldosAux.getId()!=null && totalsaldos.getId()!=null){
				if(totalsaldosAux.getId().equals(totalsaldos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTotalSaldos(List<TotalSaldos> totalsaldoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_debitoTotal=0.0;
		Double total_creditoTotal=0.0;
		Double total_debito_extranjeroTotal=0.0;
		Double total_credito_extranjeroTotal=0.0;
	
		for(TotalSaldos totalsaldos: totalsaldoss) {			
			total_debitoTotal+=totalsaldos.gettotal_debito();
			total_creditoTotal+=totalsaldos.gettotal_credito();
			total_debito_extranjeroTotal+=totalsaldos.gettotal_debito_extranjero();
			total_credito_extranjeroTotal+=totalsaldos.gettotal_credito_extranjero();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TotalSaldosConstantesFunciones.TOTALDEBITO);
		datoGeneral.setsDescripcion(TotalSaldosConstantesFunciones.LABEL_TOTALDEBITO);
		datoGeneral.setdValorDouble(total_debitoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TotalSaldosConstantesFunciones.TOTALCREDITO);
		datoGeneral.setsDescripcion(TotalSaldosConstantesFunciones.LABEL_TOTALCREDITO);
		datoGeneral.setdValorDouble(total_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TotalSaldosConstantesFunciones.TOTALDEBITOEXTRANJERO);
		datoGeneral.setsDescripcion(TotalSaldosConstantesFunciones.LABEL_TOTALDEBITOEXTRANJERO);
		datoGeneral.setdValorDouble(total_debito_extranjeroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TotalSaldosConstantesFunciones.TOTALCREDITOEXTRANJERO);
		datoGeneral.setsDescripcion(TotalSaldosConstantesFunciones.LABEL_TOTALCREDITOEXTRANJERO);
		datoGeneral.setdValorDouble(total_credito_extranjeroTotal);
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