










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
import com.bydan.erp.tesoreria.util.report.ChequesPagosAutorizadosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;
////import com.bydan.erp.tesoreria.business.interfaces.ChequesPagosAutorizadosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ChequesPagosAutorizadosLogicAdditional extends ChequesPagosAutorizadosLogic{		
	
	public  ChequesPagosAutorizadosLogicAdditional(Connexion connexion)throws Exception {
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
	public  ChequesPagosAutorizadosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkChequesPagosAutorizadosToSave(ChequesPagosAutorizados chequespagosautorizados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkChequesPagosAutorizadosToSave(ChequesPagosAutorizados chequespagosautorizados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkChequesPagosAutorizadosToSaveAfter(ChequesPagosAutorizados chequespagosautorizados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkChequesPagosAutorizadosToSaves(List<ChequesPagosAutorizados> chequespagosautorizadoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkChequesPagosAutorizadosToSaves(List<ChequesPagosAutorizados> chequespagosautorizadoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkChequesPagosAutorizadosToSavesAfter(List<ChequesPagosAutorizados> chequespagosautorizadoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkChequesPagosAutorizadosToGet(ChequesPagosAutorizados chequespagosautorizados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkChequesPagosAutorizadosToGets(List<ChequesPagosAutorizados> chequespagosautorizadoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateChequesPagosAutorizadosToSave(ChequesPagosAutorizados chequespagosautorizados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateChequesPagosAutorizadosToGet(ChequesPagosAutorizados chequespagosautorizados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectChequesPagosAutorizadosActions(String sTipoJsonResponse,JSONObject jsonObjectChequesPagosAutorizados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonChequesPagosAutorizadosDataTable(String sTipoJsonResponse,ChequesPagosAutorizados chequespagosautorizados,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonChequesPagosAutorizadossDataTable(String sTipoJsonResponse,List<ChequesPagosAutorizados> chequespagosautorizadoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayChequesPagosAutorizadosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayChequesPagosAutorizadossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayChequesPagosAutorizadossColumns;
	}
	
	public static void updateJSONArrayChequesPagosAutorizadosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectChequesPagosAutorizados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosChequesPagosAutorizados(ChequesPagosAutorizados chequespagosautorizados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		chequespagosautorizados.setnombre_cliente(chequespagosautorizados.getnombre_cliente().trim());
		chequespagosautorizados.setnumero_factura(chequespagosautorizados.getnumero_factura().trim());
		chequespagosautorizados.setnombre_banco(chequespagosautorizados.getnombre_banco().trim());
		chequespagosautorizados.setnumero_cheque(chequespagosautorizados.getnumero_cheque().trim());
		chequespagosautorizados.setnumero_cuenta(chequespagosautorizados.getnumero_cuenta().trim());
	}
	
	public static void quitarEspaciosChequesPagosAutorizadoss(List<ChequesPagosAutorizados> chequespagosautorizadoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ChequesPagosAutorizados chequespagosautorizados: chequespagosautorizadoss) {
			chequespagosautorizados.setnombre_cliente(chequespagosautorizados.getnombre_cliente().trim());
			chequespagosautorizados.setnumero_factura(chequespagosautorizados.getnumero_factura().trim());
			chequespagosautorizados.setnombre_banco(chequespagosautorizados.getnombre_banco().trim());
			chequespagosautorizados.setnumero_cheque(chequespagosautorizados.getnumero_cheque().trim());
			chequespagosautorizados.setnumero_cuenta(chequespagosautorizados.getnumero_cuenta().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesChequesPagosAutorizados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ChequesPagosAutorizadosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ChequesPagosAutorizados> chequespagosautorizadoss,ChequesPagosAutorizados chequespagosautorizados,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ChequesPagosAutorizados chequespagosautorizadosAux: chequespagosautorizadoss) {
			if((chequespagosautorizadosAux.getId()==null && chequespagosautorizados.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(chequespagosautorizadosAux.getId()!=null && chequespagosautorizados.getId()!=null){
				if(chequespagosautorizadosAux.getId().equals(chequespagosautorizados.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaChequesPagosAutorizados(List<ChequesPagosAutorizados> chequespagosautorizadoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_mone_localTotal=0.0;
		Double valorTotal=0.0;
	
		for(ChequesPagosAutorizados chequespagosautorizados: chequespagosautorizadoss) {			
			debito_mone_localTotal+=chequespagosautorizados.getdebito_mone_local();
			valorTotal+=chequespagosautorizados.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ChequesPagosAutorizadosConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(ChequesPagosAutorizadosConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ChequesPagosAutorizadosConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ChequesPagosAutorizadosConstantesFunciones.LABEL_VALOR);
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