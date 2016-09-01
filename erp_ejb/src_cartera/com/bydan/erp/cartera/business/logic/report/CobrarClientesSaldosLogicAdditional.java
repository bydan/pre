










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.cartera.business.logic.report;

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
import com.bydan.erp.cartera.util.report.CobrarClientesSaldosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.CobrarClientesSaldosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class CobrarClientesSaldosLogicAdditional extends CobrarClientesSaldosLogic{		
	
	public  CobrarClientesSaldosLogicAdditional(Connexion connexion)throws Exception {
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
	public  CobrarClientesSaldosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCobrarClientesSaldosToSave(CobrarClientesSaldos cobrarclientessaldos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCobrarClientesSaldosToSave(CobrarClientesSaldos cobrarclientessaldos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCobrarClientesSaldosToSaveAfter(CobrarClientesSaldos cobrarclientessaldos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCobrarClientesSaldosToSaves(List<CobrarClientesSaldos> cobrarclientessaldoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCobrarClientesSaldosToSaves(List<CobrarClientesSaldos> cobrarclientessaldoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCobrarClientesSaldosToSavesAfter(List<CobrarClientesSaldos> cobrarclientessaldoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCobrarClientesSaldosToGet(CobrarClientesSaldos cobrarclientessaldos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCobrarClientesSaldosToGets(List<CobrarClientesSaldos> cobrarclientessaldoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCobrarClientesSaldosToSave(CobrarClientesSaldos cobrarclientessaldos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCobrarClientesSaldosToGet(CobrarClientesSaldos cobrarclientessaldos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCobrarClientesSaldosActions(String sTipoJsonResponse,JSONObject jsonObjectCobrarClientesSaldos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCobrarClientesSaldosDataTable(String sTipoJsonResponse,CobrarClientesSaldos cobrarclientessaldos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCobrarClientesSaldossDataTable(String sTipoJsonResponse,List<CobrarClientesSaldos> cobrarclientessaldoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCobrarClientesSaldosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCobrarClientesSaldossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCobrarClientesSaldossColumns;
	}
	
	public static void updateJSONArrayCobrarClientesSaldosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCobrarClientesSaldos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCobrarClientesSaldos(CobrarClientesSaldos cobrarclientessaldos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarclientessaldos.setcodigo(cobrarclientessaldos.getcodigo().trim());
		cobrarclientessaldos.setnombre_completo(cobrarclientessaldos.getnombre_completo().trim());
		cobrarclientessaldos.setnombre_comercial(cobrarclientessaldos.getnombre_comercial().trim());
		cobrarclientessaldos.setnombre_garantia(cobrarclientessaldos.getnombre_garantia().trim());
	}
	
	public static void quitarEspaciosCobrarClientesSaldoss(List<CobrarClientesSaldos> cobrarclientessaldoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarClientesSaldos cobrarclientessaldos: cobrarclientessaldoss) {
			cobrarclientessaldos.setcodigo(cobrarclientessaldos.getcodigo().trim());
			cobrarclientessaldos.setnombre_completo(cobrarclientessaldos.getnombre_completo().trim());
			cobrarclientessaldos.setnombre_comercial(cobrarclientessaldos.getnombre_comercial().trim());
			cobrarclientessaldos.setnombre_garantia(cobrarclientessaldos.getnombre_garantia().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesSaldos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CobrarClientesSaldosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(CobrarClientesSaldosConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(CobrarClientesSaldosConstantesFunciones.IDEJERCICIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarClientesSaldos> cobrarclientessaldoss,CobrarClientesSaldos cobrarclientessaldos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarClientesSaldos cobrarclientessaldosAux: cobrarclientessaldoss) {
			if((cobrarclientessaldosAux.getId()==null && cobrarclientessaldos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cobrarclientessaldosAux.getId()!=null && cobrarclientessaldos.getId()!=null){
				if(cobrarclientessaldosAux.getId().equals(cobrarclientessaldos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarClientesSaldos(List<CobrarClientesSaldos> cobrarclientessaldoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double limite_creditoTotal=0.0;
		Double total_pedidosTotal=0.0;
		Double total_saldosTotal=0.0;
		Double total_chequesTotal=0.0;
	
		for(CobrarClientesSaldos cobrarclientessaldos: cobrarclientessaldoss) {			
			limite_creditoTotal+=cobrarclientessaldos.getlimite_credito();
			total_pedidosTotal+=cobrarclientessaldos.gettotal_pedidos();
			total_saldosTotal+=cobrarclientessaldos.gettotal_saldos();
			total_chequesTotal+=cobrarclientessaldos.gettotal_cheques();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarClientesSaldosConstantesFunciones.LIMITECREDITO);
		datoGeneral.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_LIMITECREDITO);
		datoGeneral.setdValorDouble(limite_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarClientesSaldosConstantesFunciones.TOTALPEDIDOS);
		datoGeneral.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_TOTALPEDIDOS);
		datoGeneral.setdValorDouble(total_pedidosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarClientesSaldosConstantesFunciones.TOTALSALDOS);
		datoGeneral.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_TOTALSALDOS);
		datoGeneral.setdValorDouble(total_saldosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarClientesSaldosConstantesFunciones.TOTALCHEQUES);
		datoGeneral.setsDescripcion(CobrarClientesSaldosConstantesFunciones.LABEL_TOTALCHEQUES);
		datoGeneral.setdValorDouble(total_chequesTotal);
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