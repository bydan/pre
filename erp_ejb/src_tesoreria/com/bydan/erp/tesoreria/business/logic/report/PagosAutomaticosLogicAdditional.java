










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
import com.bydan.erp.tesoreria.util.report.PagosAutomaticosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;
////import com.bydan.erp.tesoreria.business.interfaces.PagosAutomaticosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class PagosAutomaticosLogicAdditional extends PagosAutomaticosLogic{		
	
	public  PagosAutomaticosLogicAdditional(Connexion connexion)throws Exception {
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
	public  PagosAutomaticosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkPagosAutomaticosToSave(PagosAutomaticos pagosautomaticos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkPagosAutomaticosToSave(PagosAutomaticos pagosautomaticos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkPagosAutomaticosToSaveAfter(PagosAutomaticos pagosautomaticos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkPagosAutomaticosToSaves(List<PagosAutomaticos> pagosautomaticoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkPagosAutomaticosToSaves(List<PagosAutomaticos> pagosautomaticoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkPagosAutomaticosToSavesAfter(List<PagosAutomaticos> pagosautomaticoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkPagosAutomaticosToGet(PagosAutomaticos pagosautomaticos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkPagosAutomaticosToGets(List<PagosAutomaticos> pagosautomaticoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updatePagosAutomaticosToSave(PagosAutomaticos pagosautomaticos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updatePagosAutomaticosToGet(PagosAutomaticos pagosautomaticos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectPagosAutomaticosActions(String sTipoJsonResponse,JSONObject jsonObjectPagosAutomaticos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonPagosAutomaticosDataTable(String sTipoJsonResponse,PagosAutomaticos pagosautomaticos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonPagosAutomaticossDataTable(String sTipoJsonResponse,List<PagosAutomaticos> pagosautomaticoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayPagosAutomaticosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayPagosAutomaticossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayPagosAutomaticossColumns;
	}
	
	public static void updateJSONArrayPagosAutomaticosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectPagosAutomaticos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosPagosAutomaticos(PagosAutomaticos pagosautomaticos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pagosautomaticos.setnombre_cliente(pagosautomaticos.getnombre_cliente().trim());
		pagosautomaticos.setnumero_factura(pagosautomaticos.getnumero_factura().trim());
		pagosautomaticos.setnombre_banco(pagosautomaticos.getnombre_banco().trim());
		pagosautomaticos.setnumero_cuenta(pagosautomaticos.getnumero_cuenta().trim());
		pagosautomaticos.setdescripcion(pagosautomaticos.getdescripcion().trim());
		pagosautomaticos.setestado(pagosautomaticos.getestado().trim());
		pagosautomaticos.setcodigo_cuenta_con_cliente(pagosautomaticos.getcodigo_cuenta_con_cliente().trim());
		pagosautomaticos.setcodigo_cuenta_con_banco(pagosautomaticos.getcodigo_cuenta_con_banco().trim());
	}
	
	public static void quitarEspaciosPagosAutomaticoss(List<PagosAutomaticos> pagosautomaticoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PagosAutomaticos pagosautomaticos: pagosautomaticoss) {
			pagosautomaticos.setnombre_cliente(pagosautomaticos.getnombre_cliente().trim());
			pagosautomaticos.setnumero_factura(pagosautomaticos.getnumero_factura().trim());
			pagosautomaticos.setnombre_banco(pagosautomaticos.getnombre_banco().trim());
			pagosautomaticos.setnumero_cuenta(pagosautomaticos.getnumero_cuenta().trim());
			pagosautomaticos.setdescripcion(pagosautomaticos.getdescripcion().trim());
			pagosautomaticos.setestado(pagosautomaticos.getestado().trim());
			pagosautomaticos.setcodigo_cuenta_con_cliente(pagosautomaticos.getcodigo_cuenta_con_cliente().trim());
			pagosautomaticos.setcodigo_cuenta_con_banco(pagosautomaticos.getcodigo_cuenta_con_banco().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPagosAutomaticos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PagosAutomaticosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PagosAutomaticos> pagosautomaticoss,PagosAutomaticos pagosautomaticos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PagosAutomaticos pagosautomaticosAux: pagosautomaticoss) {
			if((pagosautomaticosAux.getId()==null && pagosautomaticos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(pagosautomaticosAux.getId()!=null && pagosautomaticos.getId()!=null){
				if(pagosautomaticosAux.getId().equals(pagosautomaticos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPagosAutomaticos(List<PagosAutomaticos> pagosautomaticoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_por_pagarTotal=0.0;
		Double valor_canceladoTotal=0.0;
	
		for(PagosAutomaticos pagosautomaticos: pagosautomaticoss) {			
			valor_por_pagarTotal+=pagosautomaticos.getvalor_por_pagar();
			valor_canceladoTotal+=pagosautomaticos.getvalor_cancelado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagosAutomaticosConstantesFunciones.VALORPORPAGAR);
		datoGeneral.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_VALORPORPAGAR);
		datoGeneral.setdValorDouble(valor_por_pagarTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagosAutomaticosConstantesFunciones.VALORCANCELADO);
		datoGeneral.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_VALORCANCELADO);
		datoGeneral.setdValorDouble(valor_canceladoTotal);
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