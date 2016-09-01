













/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.util.Funciones;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.puntoventa.util.DepositoBancoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
//import com.bydan.erp.puntoventa.business.interfaces.DepositoBancoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DepositoBancoLogicAdditional extends DepositoBancoLogic { // implements DepositoBancoAdditionable{
	public  DepositoBancoLogicAdditional(Connexion connexion)throws Exception {
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
	public  DepositoBancoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDepositoBancoToSave(DepositoBanco depositobanco,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDepositoBancoToSave(DepositoBanco depositobanco,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDepositoBancoToSaveAfter(DepositoBanco depositobanco,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDepositoBancoToSaves(List<DepositoBanco> depositobancos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDepositoBancoToSaves(List<DepositoBanco> depositobancos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDepositoBancoToSavesAfter(List<DepositoBanco> depositobancos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDepositoBancoToGet(DepositoBanco depositobanco,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDepositoBancoToGets(List<DepositoBanco> depositobancos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDepositoBancoToSave(DepositoBanco depositobanco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDepositoBancoToGet(DepositoBanco depositobanco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDepositoBancoActions(String sTipoJsonResponse,JSONObject jsonObjectDepositoBanco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDepositoBancoDataTable(String sTipoJsonResponse,DepositoBanco depositobanco,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDepositoBancosDataTable(String sTipoJsonResponse,List<DepositoBanco> depositobancos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDepositoBancoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDepositoBancosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDepositoBancosColumns;
	}
	
	public static void updateJSONArrayDepositoBancoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDepositoBanco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDepositoBanco(DepositoBanco depositobanco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		depositobanco.setdescripcion(depositobanco.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDepositoBancos(List<DepositoBanco> depositobancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DepositoBanco depositobanco: depositobancos) {
			depositobanco.setdescripcion(depositobanco.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDepositoBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DepositoBancoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DepositoBancoConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(DepositoBancoConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DepositoBanco> depositobancos,DepositoBanco depositobanco,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DepositoBanco depositobancoAux: depositobancos) {
			if((depositobancoAux.getId()==null && depositobanco.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(depositobancoAux.getId()!=null && depositobanco.getId()!=null){
				if(depositobancoAux.getId().equals(depositobanco.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDepositoBanco(List<DepositoBanco> depositobancos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_efectivoTotal=0.0;
		Double valor_chequeTotal=0.0;
	
		for(DepositoBanco depositobanco: depositobancos) {			
			valor_efectivoTotal+=depositobanco.getvalor_efectivo();
			valor_chequeTotal+=depositobanco.getvalor_cheque();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepositoBancoConstantesFunciones.VALOREFECTIVO);
		datoGeneral.setsDescripcion(DepositoBancoConstantesFunciones.LABEL_VALOREFECTIVO);
		datoGeneral.setdValorDouble(valor_efectivoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepositoBancoConstantesFunciones.VALORCHEQUE);
		datoGeneral.setsDescripcion(DepositoBancoConstantesFunciones.LABEL_VALORCHEQUE);
		datoGeneral.setdValorDouble(valor_chequeTotal);
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