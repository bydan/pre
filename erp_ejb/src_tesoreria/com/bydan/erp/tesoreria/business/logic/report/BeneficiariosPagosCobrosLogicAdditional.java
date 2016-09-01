










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
import com.bydan.erp.tesoreria.util.report.BeneficiariosPagosCobrosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;
////import com.bydan.erp.tesoreria.business.interfaces.BeneficiariosPagosCobrosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class BeneficiariosPagosCobrosLogicAdditional extends BeneficiariosPagosCobrosLogic{		
	
	public  BeneficiariosPagosCobrosLogicAdditional(Connexion connexion)throws Exception {
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
	public  BeneficiariosPagosCobrosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkBeneficiariosPagosCobrosToSave(BeneficiariosPagosCobros beneficiariospagoscobros,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkBeneficiariosPagosCobrosToSave(BeneficiariosPagosCobros beneficiariospagoscobros,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkBeneficiariosPagosCobrosToSaveAfter(BeneficiariosPagosCobros beneficiariospagoscobros,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkBeneficiariosPagosCobrosToSaves(List<BeneficiariosPagosCobros> beneficiariospagoscobross,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkBeneficiariosPagosCobrosToSaves(List<BeneficiariosPagosCobros> beneficiariospagoscobross,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkBeneficiariosPagosCobrosToSavesAfter(List<BeneficiariosPagosCobros> beneficiariospagoscobross,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkBeneficiariosPagosCobrosToGet(BeneficiariosPagosCobros beneficiariospagoscobros,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkBeneficiariosPagosCobrosToGets(List<BeneficiariosPagosCobros> beneficiariospagoscobross,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateBeneficiariosPagosCobrosToSave(BeneficiariosPagosCobros beneficiariospagoscobros,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateBeneficiariosPagosCobrosToGet(BeneficiariosPagosCobros beneficiariospagoscobros,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectBeneficiariosPagosCobrosActions(String sTipoJsonResponse,JSONObject jsonObjectBeneficiariosPagosCobros,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonBeneficiariosPagosCobrosDataTable(String sTipoJsonResponse,BeneficiariosPagosCobros beneficiariospagoscobros,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonBeneficiariosPagosCobrossDataTable(String sTipoJsonResponse,List<BeneficiariosPagosCobros> beneficiariospagoscobross,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayBeneficiariosPagosCobrosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayBeneficiariosPagosCobrossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayBeneficiariosPagosCobrossColumns;
	}
	
	public static void updateJSONArrayBeneficiariosPagosCobrosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectBeneficiariosPagosCobros,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosBeneficiariosPagosCobros(BeneficiariosPagosCobros beneficiariospagoscobros,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		beneficiariospagoscobros.setcodigo_cuenta_contable(beneficiariospagoscobros.getcodigo_cuenta_contable().trim());
		beneficiariospagoscobros.setnombre_cuenta_contable(beneficiariospagoscobros.getnombre_cuenta_contable().trim());
		beneficiariospagoscobros.setnumero_mayor(beneficiariospagoscobros.getnumero_mayor().trim());
		beneficiariospagoscobros.setnumero_cheque(beneficiariospagoscobros.getnumero_cheque().trim());
		beneficiariospagoscobros.setbeneficiario(beneficiariospagoscobros.getbeneficiario().trim());
		beneficiariospagoscobros.setdetalle(beneficiariospagoscobros.getdetalle().trim());
		beneficiariospagoscobros.settipo_movimiento(beneficiariospagoscobros.gettipo_movimiento().trim());
		beneficiariospagoscobros.setcuenta(beneficiariospagoscobros.getcuenta().trim());
		beneficiariospagoscobros.setbeneficiario_asiento(beneficiariospagoscobros.getbeneficiario_asiento().trim());
	}
	
	public static void quitarEspaciosBeneficiariosPagosCobross(List<BeneficiariosPagosCobros> beneficiariospagoscobross,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(BeneficiariosPagosCobros beneficiariospagoscobros: beneficiariospagoscobross) {
			beneficiariospagoscobros.setcodigo_cuenta_contable(beneficiariospagoscobros.getcodigo_cuenta_contable().trim());
			beneficiariospagoscobros.setnombre_cuenta_contable(beneficiariospagoscobros.getnombre_cuenta_contable().trim());
			beneficiariospagoscobros.setnumero_mayor(beneficiariospagoscobros.getnumero_mayor().trim());
			beneficiariospagoscobros.setnumero_cheque(beneficiariospagoscobros.getnumero_cheque().trim());
			beneficiariospagoscobros.setbeneficiario(beneficiariospagoscobros.getbeneficiario().trim());
			beneficiariospagoscobros.setdetalle(beneficiariospagoscobros.getdetalle().trim());
			beneficiariospagoscobros.settipo_movimiento(beneficiariospagoscobros.gettipo_movimiento().trim());
			beneficiariospagoscobros.setcuenta(beneficiariospagoscobros.getcuenta().trim());
			beneficiariospagoscobros.setbeneficiario_asiento(beneficiariospagoscobros.getbeneficiario_asiento().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBeneficiariosPagosCobros(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(BeneficiariosPagosCobrosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(BeneficiariosPagosCobrosConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(BeneficiariosPagosCobrosConstantesFunciones.IDEJERCICIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<BeneficiariosPagosCobros> beneficiariospagoscobross,BeneficiariosPagosCobros beneficiariospagoscobros,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(BeneficiariosPagosCobros beneficiariospagoscobrosAux: beneficiariospagoscobross) {
			if((beneficiariospagoscobrosAux.getId()==null && beneficiariospagoscobros.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(beneficiariospagoscobrosAux.getId()!=null && beneficiariospagoscobros.getId()!=null){
				if(beneficiariospagoscobrosAux.getId().equals(beneficiariospagoscobros.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBeneficiariosPagosCobros(List<BeneficiariosPagosCobros> beneficiariospagoscobross) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
		Double valorTotal=0.0;
	
		for(BeneficiariosPagosCobros beneficiariospagoscobros: beneficiariospagoscobross) {			
			debito_localTotal+=beneficiariospagoscobros.getdebito_local();
			credito_localTotal+=beneficiariospagoscobros.getcredito_local();
			valorTotal+=beneficiariospagoscobros.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
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