










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
import com.bydan.erp.tesoreria.util.report.RemesasTransitoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;
////import com.bydan.erp.tesoreria.business.interfaces.RemesasTransitoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class RemesasTransitoLogicAdditional extends RemesasTransitoLogic{		
	
	public  RemesasTransitoLogicAdditional(Connexion connexion)throws Exception {
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
	public  RemesasTransitoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkRemesasTransitoToSave(RemesasTransito remesastransito,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkRemesasTransitoToSave(RemesasTransito remesastransito,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkRemesasTransitoToSaveAfter(RemesasTransito remesastransito,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkRemesasTransitoToSaves(List<RemesasTransito> remesastransitos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkRemesasTransitoToSaves(List<RemesasTransito> remesastransitos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkRemesasTransitoToSavesAfter(List<RemesasTransito> remesastransitos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkRemesasTransitoToGet(RemesasTransito remesastransito,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkRemesasTransitoToGets(List<RemesasTransito> remesastransitos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateRemesasTransitoToSave(RemesasTransito remesastransito,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateRemesasTransitoToGet(RemesasTransito remesastransito,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectRemesasTransitoActions(String sTipoJsonResponse,JSONObject jsonObjectRemesasTransito,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonRemesasTransitoDataTable(String sTipoJsonResponse,RemesasTransito remesastransito,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonRemesasTransitosDataTable(String sTipoJsonResponse,List<RemesasTransito> remesastransitos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayRemesasTransitoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayRemesasTransitosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayRemesasTransitosColumns;
	}
	
	public static void updateJSONArrayRemesasTransitoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectRemesasTransito,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosRemesasTransito(RemesasTransito remesastransito,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		remesastransito.setnombre_banco(remesastransito.getnombre_banco().trim());
		remesastransito.setnombre_girador(remesastransito.getnombre_girador().trim());
		remesastransito.setnumero_cuenta(remesastransito.getnumero_cuenta().trim());
		remesastransito.setnumero_cheque(remesastransito.getnumero_cheque().trim());
		remesastransito.setnumero_mayor(remesastransito.getnumero_mayor().trim());
		remesastransito.setcodigo(remesastransito.getcodigo().trim());
	}
	
	public static void quitarEspaciosRemesasTransitos(List<RemesasTransito> remesastransitos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RemesasTransito remesastransito: remesastransitos) {
			remesastransito.setnombre_banco(remesastransito.getnombre_banco().trim());
			remesastransito.setnombre_girador(remesastransito.getnombre_girador().trim());
			remesastransito.setnumero_cuenta(remesastransito.getnumero_cuenta().trim());
			remesastransito.setnumero_cheque(remesastransito.getnumero_cheque().trim());
			remesastransito.setnumero_mayor(remesastransito.getnumero_mayor().trim());
			remesastransito.setcodigo(remesastransito.getcodigo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRemesasTransito(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(RemesasTransitoConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RemesasTransito> remesastransitos,RemesasTransito remesastransito,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RemesasTransito remesastransitoAux: remesastransitos) {
			if((remesastransitoAux.getId()==null && remesastransito.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(remesastransitoAux.getId()!=null && remesastransito.getId()!=null){
				if(remesastransitoAux.getId().equals(remesastransito.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRemesasTransito(List<RemesasTransito> remesastransitos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_montoTotal=0.0;
		Double valorTotal=0.0;
	
		for(RemesasTransito remesastransito: remesastransitos) {			
			valor_montoTotal+=remesastransito.getvalor_monto();
			valorTotal+=remesastransito.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RemesasTransitoConstantesFunciones.VALORMONTO);
		datoGeneral.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_VALORMONTO);
		datoGeneral.setdValorDouble(valor_montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RemesasTransitoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_VALOR);
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