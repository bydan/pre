










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
import com.bydan.erp.cartera.util.report.CobrarMorosidadClientesDetalladosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.CobrarMorosidadClientesDetalladosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class CobrarMorosidadClientesDetalladosLogicAdditional extends CobrarMorosidadClientesDetalladosLogic{		
	
	public  CobrarMorosidadClientesDetalladosLogicAdditional(Connexion connexion)throws Exception {
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
	public  CobrarMorosidadClientesDetalladosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCobrarMorosidadClientesDetalladosToSave(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCobrarMorosidadClientesDetalladosToSave(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCobrarMorosidadClientesDetalladosToSaveAfter(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCobrarMorosidadClientesDetalladosToSaves(List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCobrarMorosidadClientesDetalladosToSaves(List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCobrarMorosidadClientesDetalladosToSavesAfter(List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCobrarMorosidadClientesDetalladosToGet(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCobrarMorosidadClientesDetalladosToGets(List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCobrarMorosidadClientesDetalladosToSave(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCobrarMorosidadClientesDetalladosToGet(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCobrarMorosidadClientesDetalladosActions(String sTipoJsonResponse,JSONObject jsonObjectCobrarMorosidadClientesDetallados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCobrarMorosidadClientesDetalladosDataTable(String sTipoJsonResponse,CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCobrarMorosidadClientesDetalladossDataTable(String sTipoJsonResponse,List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCobrarMorosidadClientesDetalladosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCobrarMorosidadClientesDetalladossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCobrarMorosidadClientesDetalladossColumns;
	}
	
	public static void updateJSONArrayCobrarMorosidadClientesDetalladosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCobrarMorosidadClientesDetallados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCobrarMorosidadClientesDetallados(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarmorosidadclientesdetallados.setcodigo(cobrarmorosidadclientesdetallados.getcodigo().trim());
		cobrarmorosidadclientesdetallados.setnombre_completo(cobrarmorosidadclientesdetallados.getnombre_completo().trim());
		cobrarmorosidadclientesdetallados.setnumero_pre_impreso_factura(cobrarmorosidadclientesdetallados.getnumero_pre_impreso_factura().trim());
	}
	
	public static void quitarEspaciosCobrarMorosidadClientesDetalladoss(List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados: cobrarmorosidadclientesdetalladoss) {
			cobrarmorosidadclientesdetallados.setcodigo(cobrarmorosidadclientesdetallados.getcodigo().trim());
			cobrarmorosidadclientesdetallados.setnombre_completo(cobrarmorosidadclientesdetallados.getnombre_completo().trim());
			cobrarmorosidadclientesdetallados.setnumero_pre_impreso_factura(cobrarmorosidadclientesdetallados.getnumero_pre_impreso_factura().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarMorosidadClientesDetallados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CobrarMorosidadClientesDetalladosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss,CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetalladosAux: cobrarmorosidadclientesdetalladoss) {
			if((cobrarmorosidadclientesdetalladosAux.getId()==null && cobrarmorosidadclientesdetallados.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cobrarmorosidadclientesdetalladosAux.getId()!=null && cobrarmorosidadclientesdetallados.getId()!=null){
				if(cobrarmorosidadclientesdetalladosAux.getId().equals(cobrarmorosidadclientesdetallados.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarMorosidadClientesDetallados(List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldo_vencidoTotal=0.0;
		Double saldo_vencerTotal=0.0;
	
		for(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados: cobrarmorosidadclientesdetalladoss) {			
			saldo_vencidoTotal+=cobrarmorosidadclientesdetallados.getsaldo_vencido();
			saldo_vencerTotal+=cobrarmorosidadclientesdetallados.getsaldo_vencer();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCIDO);
		datoGeneral.setsDescripcion(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_SALDOVENCIDO);
		datoGeneral.setdValorDouble(saldo_vencidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCER);
		datoGeneral.setsDescripcion(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_SALDOVENCER);
		datoGeneral.setdValorDouble(saldo_vencerTotal);
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