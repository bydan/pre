










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
import com.bydan.erp.tesoreria.util.report.PagosAutorizadosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;
////import com.bydan.erp.tesoreria.business.interfaces.PagosAutorizadosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class PagosAutorizadosLogicAdditional extends PagosAutorizadosLogic{		
	
	public  PagosAutorizadosLogicAdditional(Connexion connexion)throws Exception {
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
	public  PagosAutorizadosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkPagosAutorizadosToSave(PagosAutorizados pagosautorizados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkPagosAutorizadosToSave(PagosAutorizados pagosautorizados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkPagosAutorizadosToSaveAfter(PagosAutorizados pagosautorizados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkPagosAutorizadosToSaves(List<PagosAutorizados> pagosautorizadoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkPagosAutorizadosToSaves(List<PagosAutorizados> pagosautorizadoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkPagosAutorizadosToSavesAfter(List<PagosAutorizados> pagosautorizadoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkPagosAutorizadosToGet(PagosAutorizados pagosautorizados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkPagosAutorizadosToGets(List<PagosAutorizados> pagosautorizadoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updatePagosAutorizadosToSave(PagosAutorizados pagosautorizados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updatePagosAutorizadosToGet(PagosAutorizados pagosautorizados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectPagosAutorizadosActions(String sTipoJsonResponse,JSONObject jsonObjectPagosAutorizados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonPagosAutorizadosDataTable(String sTipoJsonResponse,PagosAutorizados pagosautorizados,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonPagosAutorizadossDataTable(String sTipoJsonResponse,List<PagosAutorizados> pagosautorizadoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayPagosAutorizadosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayPagosAutorizadossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayPagosAutorizadossColumns;
	}
	
	public static void updateJSONArrayPagosAutorizadosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectPagosAutorizados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosPagosAutorizados(PagosAutorizados pagosautorizados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pagosautorizados.setnombre_cliente(pagosautorizados.getnombre_cliente().trim());
		pagosautorizados.setnumero_factura(pagosautorizados.getnumero_factura().trim());
		pagosautorizados.setnombre_banco(pagosautorizados.getnombre_banco().trim());
		pagosautorizados.setnumero_cuenta(pagosautorizados.getnumero_cuenta().trim());
		pagosautorizados.setdescripcion(pagosautorizados.getdescripcion().trim());
		pagosautorizados.setestado(pagosautorizados.getestado().trim());
		pagosautorizados.setcodigo_cuenta_con_cliente(pagosautorizados.getcodigo_cuenta_con_cliente().trim());
		pagosautorizados.setcodigo_cuenta_con_banco(pagosautorizados.getcodigo_cuenta_con_banco().trim());
	}
	
	public static void quitarEspaciosPagosAutorizadoss(List<PagosAutorizados> pagosautorizadoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PagosAutorizados pagosautorizados: pagosautorizadoss) {
			pagosautorizados.setnombre_cliente(pagosautorizados.getnombre_cliente().trim());
			pagosautorizados.setnumero_factura(pagosautorizados.getnumero_factura().trim());
			pagosautorizados.setnombre_banco(pagosautorizados.getnombre_banco().trim());
			pagosautorizados.setnumero_cuenta(pagosautorizados.getnumero_cuenta().trim());
			pagosautorizados.setdescripcion(pagosautorizados.getdescripcion().trim());
			pagosautorizados.setestado(pagosautorizados.getestado().trim());
			pagosautorizados.setcodigo_cuenta_con_cliente(pagosautorizados.getcodigo_cuenta_con_cliente().trim());
			pagosautorizados.setcodigo_cuenta_con_banco(pagosautorizados.getcodigo_cuenta_con_banco().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPagosAutorizados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PagosAutorizadosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PagosAutorizados> pagosautorizadoss,PagosAutorizados pagosautorizados,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PagosAutorizados pagosautorizadosAux: pagosautorizadoss) {
			if((pagosautorizadosAux.getId()==null && pagosautorizados.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(pagosautorizadosAux.getId()!=null && pagosautorizados.getId()!=null){
				if(pagosautorizadosAux.getId().equals(pagosautorizados.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPagosAutorizados(List<PagosAutorizados> pagosautorizadoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_por_pagarTotal=0.0;
		Double valor_canceladoTotal=0.0;
	
		for(PagosAutorizados pagosautorizados: pagosautorizadoss) {			
			valor_por_pagarTotal+=pagosautorizados.getvalor_por_pagar();
			valor_canceladoTotal+=pagosautorizados.getvalor_cancelado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagosAutorizadosConstantesFunciones.VALORPORPAGAR);
		datoGeneral.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_VALORPORPAGAR);
		datoGeneral.setdValorDouble(valor_por_pagarTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagosAutorizadosConstantesFunciones.VALORCANCELADO);
		datoGeneral.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_VALORCANCELADO);
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