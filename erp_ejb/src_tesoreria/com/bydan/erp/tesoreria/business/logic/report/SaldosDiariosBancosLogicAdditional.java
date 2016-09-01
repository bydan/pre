










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
import com.bydan.erp.tesoreria.util.report.SaldosDiariosBancosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;
////import com.bydan.erp.tesoreria.business.interfaces.SaldosDiariosBancosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class SaldosDiariosBancosLogicAdditional extends SaldosDiariosBancosLogic{		
	
	public  SaldosDiariosBancosLogicAdditional(Connexion connexion)throws Exception {
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
	public  SaldosDiariosBancosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkSaldosDiariosBancosToSave(SaldosDiariosBancos saldosdiariosbancos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkSaldosDiariosBancosToSave(SaldosDiariosBancos saldosdiariosbancos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkSaldosDiariosBancosToSaveAfter(SaldosDiariosBancos saldosdiariosbancos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkSaldosDiariosBancosToSaves(List<SaldosDiariosBancos> saldosdiariosbancoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkSaldosDiariosBancosToSaves(List<SaldosDiariosBancos> saldosdiariosbancoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkSaldosDiariosBancosToSavesAfter(List<SaldosDiariosBancos> saldosdiariosbancoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkSaldosDiariosBancosToGet(SaldosDiariosBancos saldosdiariosbancos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkSaldosDiariosBancosToGets(List<SaldosDiariosBancos> saldosdiariosbancoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateSaldosDiariosBancosToSave(SaldosDiariosBancos saldosdiariosbancos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateSaldosDiariosBancosToGet(SaldosDiariosBancos saldosdiariosbancos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectSaldosDiariosBancosActions(String sTipoJsonResponse,JSONObject jsonObjectSaldosDiariosBancos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonSaldosDiariosBancosDataTable(String sTipoJsonResponse,SaldosDiariosBancos saldosdiariosbancos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonSaldosDiariosBancossDataTable(String sTipoJsonResponse,List<SaldosDiariosBancos> saldosdiariosbancoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArraySaldosDiariosBancosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArraySaldosDiariosBancossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArraySaldosDiariosBancossColumns;
	}
	
	public static void updateJSONArraySaldosDiariosBancosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectSaldosDiariosBancos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosSaldosDiariosBancos(SaldosDiariosBancos saldosdiariosbancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		saldosdiariosbancos.setcodigo_cuenta(saldosdiariosbancos.getcodigo_cuenta().trim());
		saldosdiariosbancos.setnombre_banco(saldosdiariosbancos.getnombre_banco().trim());
		saldosdiariosbancos.setnumero_cuenta(saldosdiariosbancos.getnumero_cuenta().trim());
		saldosdiariosbancos.setnombre_moneda(saldosdiariosbancos.getnombre_moneda().trim());
		saldosdiariosbancos.setprocedencia(saldosdiariosbancos.getprocedencia().trim());
		saldosdiariosbancos.setdestino(saldosdiariosbancos.getdestino().trim());
	}
	
	public static void quitarEspaciosSaldosDiariosBancoss(List<SaldosDiariosBancos> saldosdiariosbancoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SaldosDiariosBancos saldosdiariosbancos: saldosdiariosbancoss) {
			saldosdiariosbancos.setcodigo_cuenta(saldosdiariosbancos.getcodigo_cuenta().trim());
			saldosdiariosbancos.setnombre_banco(saldosdiariosbancos.getnombre_banco().trim());
			saldosdiariosbancos.setnumero_cuenta(saldosdiariosbancos.getnumero_cuenta().trim());
			saldosdiariosbancos.setnombre_moneda(saldosdiariosbancos.getnombre_moneda().trim());
			saldosdiariosbancos.setprocedencia(saldosdiariosbancos.getprocedencia().trim());
			saldosdiariosbancos.setdestino(saldosdiariosbancos.getdestino().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSaldosDiariosBancos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(SaldosDiariosBancosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(SaldosDiariosBancosConstantesFunciones.IDEJERCICIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SaldosDiariosBancos> saldosdiariosbancoss,SaldosDiariosBancos saldosdiariosbancos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SaldosDiariosBancos saldosdiariosbancosAux: saldosdiariosbancoss) {
			if((saldosdiariosbancosAux.getId()==null && saldosdiariosbancos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(saldosdiariosbancosAux.getId()!=null && saldosdiariosbancos.getId()!=null){
				if(saldosdiariosbancosAux.getId().equals(saldosdiariosbancos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSaldosDiariosBancos(List<SaldosDiariosBancos> saldosdiariosbancoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldo_anteriorTotal=0.0;
		Double depositoTotal=0.0;
		Double ncTotal=0.0;
		Double ch_giradosTotal=0.0;
		Double ndTotal=0.0;
	
		for(SaldosDiariosBancos saldosdiariosbancos: saldosdiariosbancoss) {			
			saldo_anteriorTotal+=saldosdiariosbancos.getsaldo_anterior();
			depositoTotal+=saldosdiariosbancos.getdeposito();
			ncTotal+=saldosdiariosbancos.getnc();
			ch_giradosTotal+=saldosdiariosbancos.getch_girados();
			ndTotal+=saldosdiariosbancos.getnd();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosDiariosBancosConstantesFunciones.SALDOANTERIOR);
		datoGeneral.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_SALDOANTERIOR);
		datoGeneral.setdValorDouble(saldo_anteriorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosDiariosBancosConstantesFunciones.DEPOSITO);
		datoGeneral.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_DEPOSITO);
		datoGeneral.setdValorDouble(depositoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosDiariosBancosConstantesFunciones.NC);
		datoGeneral.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_NC);
		datoGeneral.setdValorDouble(ncTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosDiariosBancosConstantesFunciones.CHGIRADOS);
		datoGeneral.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_CHGIRADOS);
		datoGeneral.setdValorDouble(ch_giradosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosDiariosBancosConstantesFunciones.ND);
		datoGeneral.setsDescripcion(SaldosDiariosBancosConstantesFunciones.LABEL_ND);
		datoGeneral.setdValorDouble(ndTotal);
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