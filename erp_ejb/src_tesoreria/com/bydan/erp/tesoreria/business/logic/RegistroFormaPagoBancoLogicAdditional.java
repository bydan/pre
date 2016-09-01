













/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.RegistroFormaPagoBancoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
//import com.bydan.erp.tesoreria.business.interfaces.RegistroFormaPagoBancoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class RegistroFormaPagoBancoLogicAdditional extends RegistroFormaPagoBancoLogic { // implements RegistroFormaPagoBancoAdditionable{
	
	public  RegistroFormaPagoBancoLogicAdditional(Connexion connexion)throws Exception {
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


	public static Boolean validarSaveRelaciones(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_20
		Boolean validado=true;

		return validado;	
	}


	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}

	//CONTROL_INICIO
	public  RegistroFormaPagoBancoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkRegistroFormaPagoBancoToSave(RegistroFormaPagoBanco registroformapagobanco,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkRegistroFormaPagoBancoToSave(RegistroFormaPagoBanco registroformapagobanco,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkRegistroFormaPagoBancoToSaveAfter(RegistroFormaPagoBanco registroformapagobanco,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkRegistroFormaPagoBancoToSaves(List<RegistroFormaPagoBanco> registroformapagobancos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkRegistroFormaPagoBancoToSaves(List<RegistroFormaPagoBanco> registroformapagobancos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkRegistroFormaPagoBancoToSavesAfter(List<RegistroFormaPagoBanco> registroformapagobancos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkRegistroFormaPagoBancoToGet(RegistroFormaPagoBanco registroformapagobanco,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkRegistroFormaPagoBancoToGets(List<RegistroFormaPagoBanco> registroformapagobancos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateRegistroFormaPagoBancoToSave(RegistroFormaPagoBanco registroformapagobanco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateRegistroFormaPagoBancoToGet(RegistroFormaPagoBanco registroformapagobanco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectRegistroFormaPagoBancoActions(String sTipoJsonResponse,JSONObject jsonObjectRegistroFormaPagoBanco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonRegistroFormaPagoBancoDataTable(String sTipoJsonResponse,RegistroFormaPagoBanco registroformapagobanco,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonRegistroFormaPagoBancosDataTable(String sTipoJsonResponse,List<RegistroFormaPagoBanco> registroformapagobancos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayRegistroFormaPagoBancoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayRegistroFormaPagoBancosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayRegistroFormaPagoBancosColumns;
	}
	
	public static void updateJSONArrayRegistroFormaPagoBancoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectRegistroFormaPagoBanco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosRegistroFormaPagoBanco(RegistroFormaPagoBanco registroformapagobanco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		registroformapagobanco.setnombre_banco(registroformapagobanco.getnombre_banco().trim());
		registroformapagobanco.setnombre_girador(registroformapagobanco.getnombre_girador().trim());
		registroformapagobanco.setnumero_cuenta(registroformapagobanco.getnumero_cuenta().trim());
		registroformapagobanco.setnumero_cheque(registroformapagobanco.getnumero_cheque().trim());
	}
	
	public static void quitarEspaciosRegistroFormaPagoBancos(List<RegistroFormaPagoBanco> registroformapagobancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RegistroFormaPagoBanco registroformapagobanco: registroformapagobancos) {
			registroformapagobanco.setnombre_banco(registroformapagobanco.getnombre_banco().trim());
			registroformapagobanco.setnombre_girador(registroformapagobanco.getnombre_girador().trim());
			registroformapagobanco.setnumero_cuenta(registroformapagobanco.getnumero_cuenta().trim());
			registroformapagobanco.setnumero_cheque(registroformapagobanco.getnumero_cheque().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRegistroFormaPagoBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(RegistroFormaPagoBancoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(RegistroFormaPagoBancoConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(RegistroFormaPagoBancoConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(RegistroFormaPagoBancoConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RegistroFormaPagoBanco> registroformapagobancos,RegistroFormaPagoBanco registroformapagobanco,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RegistroFormaPagoBanco registroformapagobancoAux: registroformapagobancos) {
			if((registroformapagobancoAux.getId()==null && registroformapagobanco.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(registroformapagobancoAux.getId()!=null && registroformapagobanco.getId()!=null){
				if(registroformapagobancoAux.getId().equals(registroformapagobanco.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRegistroFormaPagoBanco(List<RegistroFormaPagoBanco> registroformapagobancos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_montoTotal=0.0;
	
		for(RegistroFormaPagoBanco registroformapagobanco: registroformapagobancos) {			
			valor_montoTotal+=registroformapagobanco.getvalor_monto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.VALORMONTO);
		datoGeneral.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_VALORMONTO);
		datoGeneral.setdValorDouble(valor_montoTotal);
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