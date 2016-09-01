










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
import com.bydan.erp.tesoreria.util.report.PosicionesBancariasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;
////import com.bydan.erp.tesoreria.business.interfaces.PosicionesBancariasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class PosicionesBancariasLogicAdditional extends PosicionesBancariasLogic{		
	
	public  PosicionesBancariasLogicAdditional(Connexion connexion)throws Exception {
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
	public  PosicionesBancariasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkPosicionesBancariasToSave(PosicionesBancarias posicionesbancarias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkPosicionesBancariasToSave(PosicionesBancarias posicionesbancarias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkPosicionesBancariasToSaveAfter(PosicionesBancarias posicionesbancarias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkPosicionesBancariasToSaves(List<PosicionesBancarias> posicionesbancariass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkPosicionesBancariasToSaves(List<PosicionesBancarias> posicionesbancariass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkPosicionesBancariasToSavesAfter(List<PosicionesBancarias> posicionesbancariass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkPosicionesBancariasToGet(PosicionesBancarias posicionesbancarias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkPosicionesBancariasToGets(List<PosicionesBancarias> posicionesbancariass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updatePosicionesBancariasToSave(PosicionesBancarias posicionesbancarias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updatePosicionesBancariasToGet(PosicionesBancarias posicionesbancarias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectPosicionesBancariasActions(String sTipoJsonResponse,JSONObject jsonObjectPosicionesBancarias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonPosicionesBancariasDataTable(String sTipoJsonResponse,PosicionesBancarias posicionesbancarias,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonPosicionesBancariassDataTable(String sTipoJsonResponse,List<PosicionesBancarias> posicionesbancariass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayPosicionesBancariasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayPosicionesBancariassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayPosicionesBancariassColumns;
	}
	
	public static void updateJSONArrayPosicionesBancariasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectPosicionesBancarias,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosPosicionesBancarias(PosicionesBancarias posicionesbancarias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		posicionesbancarias.settipo_documento(posicionesbancarias.gettipo_documento().trim());
		posicionesbancarias.setdetalle(posicionesbancarias.getdetalle().trim());
		posicionesbancarias.setcodigo_cuenta(posicionesbancarias.getcodigo_cuenta().trim());
		posicionesbancarias.setnombre_cuenta(posicionesbancarias.getnombre_cuenta().trim());
		posicionesbancarias.setnumero_mayor(posicionesbancarias.getnumero_mayor().trim());
		posicionesbancarias.settipo_movimiento(posicionesbancarias.gettipo_movimiento().trim());
		posicionesbancarias.setbeneficiario(posicionesbancarias.getbeneficiario().trim());
	}
	
	public static void quitarEspaciosPosicionesBancariass(List<PosicionesBancarias> posicionesbancariass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PosicionesBancarias posicionesbancarias: posicionesbancariass) {
			posicionesbancarias.settipo_documento(posicionesbancarias.gettipo_documento().trim());
			posicionesbancarias.setdetalle(posicionesbancarias.getdetalle().trim());
			posicionesbancarias.setcodigo_cuenta(posicionesbancarias.getcodigo_cuenta().trim());
			posicionesbancarias.setnombre_cuenta(posicionesbancarias.getnombre_cuenta().trim());
			posicionesbancarias.setnumero_mayor(posicionesbancarias.getnumero_mayor().trim());
			posicionesbancarias.settipo_movimiento(posicionesbancarias.gettipo_movimiento().trim());
			posicionesbancarias.setbeneficiario(posicionesbancarias.getbeneficiario().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPosicionesBancarias(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PosicionesBancariasConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(PosicionesBancariasConstantesFunciones.IDEJERCICIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PosicionesBancarias> posicionesbancariass,PosicionesBancarias posicionesbancarias,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PosicionesBancarias posicionesbancariasAux: posicionesbancariass) {
			if((posicionesbancariasAux.getId()==null && posicionesbancarias.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(posicionesbancariasAux.getId()!=null && posicionesbancarias.getId()!=null){
				if(posicionesbancariasAux.getId().equals(posicionesbancarias.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPosicionesBancarias(List<PosicionesBancarias> posicionesbancariass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
	
		for(PosicionesBancarias posicionesbancarias: posicionesbancariass) {			
			debito_localTotal+=posicionesbancarias.getdebito_local();
			credito_localTotal+=posicionesbancarias.getcredito_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PosicionesBancariasConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PosicionesBancariasConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(PosicionesBancariasConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
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