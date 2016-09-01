










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
import com.bydan.erp.cartera.util.report.CobrarListadosMovimientosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.CobrarListadosMovimientosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class CobrarListadosMovimientosLogicAdditional extends CobrarListadosMovimientosLogic{		
	
	public  CobrarListadosMovimientosLogicAdditional(Connexion connexion)throws Exception {
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
	public  CobrarListadosMovimientosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCobrarListadosMovimientosToSave(CobrarListadosMovimientos cobrarlistadosmovimientos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCobrarListadosMovimientosToSave(CobrarListadosMovimientos cobrarlistadosmovimientos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCobrarListadosMovimientosToSaveAfter(CobrarListadosMovimientos cobrarlistadosmovimientos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCobrarListadosMovimientosToSaves(List<CobrarListadosMovimientos> cobrarlistadosmovimientoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCobrarListadosMovimientosToSaves(List<CobrarListadosMovimientos> cobrarlistadosmovimientoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCobrarListadosMovimientosToSavesAfter(List<CobrarListadosMovimientos> cobrarlistadosmovimientoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCobrarListadosMovimientosToGet(CobrarListadosMovimientos cobrarlistadosmovimientos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCobrarListadosMovimientosToGets(List<CobrarListadosMovimientos> cobrarlistadosmovimientoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCobrarListadosMovimientosToSave(CobrarListadosMovimientos cobrarlistadosmovimientos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCobrarListadosMovimientosToGet(CobrarListadosMovimientos cobrarlistadosmovimientos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCobrarListadosMovimientosActions(String sTipoJsonResponse,JSONObject jsonObjectCobrarListadosMovimientos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCobrarListadosMovimientosDataTable(String sTipoJsonResponse,CobrarListadosMovimientos cobrarlistadosmovimientos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCobrarListadosMovimientossDataTable(String sTipoJsonResponse,List<CobrarListadosMovimientos> cobrarlistadosmovimientoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCobrarListadosMovimientosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCobrarListadosMovimientossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCobrarListadosMovimientossColumns;
	}
	
	public static void updateJSONArrayCobrarListadosMovimientosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCobrarListadosMovimientos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCobrarListadosMovimientos(CobrarListadosMovimientos cobrarlistadosmovimientos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarlistadosmovimientos.setcodigo(cobrarlistadosmovimientos.getcodigo().trim());
		cobrarlistadosmovimientos.setnombre_completo(cobrarlistadosmovimientos.getnombre_completo().trim());
		cobrarlistadosmovimientos.setnombre_transaccion(cobrarlistadosmovimientos.getnombre_transaccion().trim());
		cobrarlistadosmovimientos.setnumero_comprobante(cobrarlistadosmovimientos.getnumero_comprobante().trim());
		cobrarlistadosmovimientos.setnumero_factura(cobrarlistadosmovimientos.getnumero_factura().trim());
		cobrarlistadosmovimientos.setdescripcion(cobrarlistadosmovimientos.getdescripcion().trim());
	}
	
	public static void quitarEspaciosCobrarListadosMovimientoss(List<CobrarListadosMovimientos> cobrarlistadosmovimientoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarListadosMovimientos cobrarlistadosmovimientos: cobrarlistadosmovimientoss) {
			cobrarlistadosmovimientos.setcodigo(cobrarlistadosmovimientos.getcodigo().trim());
			cobrarlistadosmovimientos.setnombre_completo(cobrarlistadosmovimientos.getnombre_completo().trim());
			cobrarlistadosmovimientos.setnombre_transaccion(cobrarlistadosmovimientos.getnombre_transaccion().trim());
			cobrarlistadosmovimientos.setnumero_comprobante(cobrarlistadosmovimientos.getnumero_comprobante().trim());
			cobrarlistadosmovimientos.setnumero_factura(cobrarlistadosmovimientos.getnumero_factura().trim());
			cobrarlistadosmovimientos.setdescripcion(cobrarlistadosmovimientos.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarListadosMovimientos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CobrarListadosMovimientosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarListadosMovimientos> cobrarlistadosmovimientoss,CobrarListadosMovimientos cobrarlistadosmovimientos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarListadosMovimientos cobrarlistadosmovimientosAux: cobrarlistadosmovimientoss) {
			if((cobrarlistadosmovimientosAux.getId()==null && cobrarlistadosmovimientos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cobrarlistadosmovimientosAux.getId()!=null && cobrarlistadosmovimientos.getId()!=null){
				if(cobrarlistadosmovimientosAux.getId().equals(cobrarlistadosmovimientos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarListadosMovimientos(List<CobrarListadosMovimientos> cobrarlistadosmovimientoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
	
		for(CobrarListadosMovimientos cobrarlistadosmovimientos: cobrarlistadosmovimientoss) {			
			debito_mone_localTotal+=cobrarlistadosmovimientos.getdebito_mone_local();
			credito_mone_localTotal+=cobrarlistadosmovimientos.getcredito_mone_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarListadosMovimientosConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarListadosMovimientosConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(CobrarListadosMovimientosConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
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