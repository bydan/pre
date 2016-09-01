










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.contabilidad.business.logic.report;

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
import com.bydan.erp.contabilidad.util.report.MayooresGeneralesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
////import com.bydan.erp.contabilidad.business.interfaces.MayooresGeneralesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class MayooresGeneralesLogicAdditional extends MayooresGeneralesLogic{		
	
	public  MayooresGeneralesLogicAdditional(Connexion connexion)throws Exception {
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
	public  MayooresGeneralesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkMayooresGeneralesToSave(MayooresGenerales mayooresgenerales,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkMayooresGeneralesToSave(MayooresGenerales mayooresgenerales,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkMayooresGeneralesToSaveAfter(MayooresGenerales mayooresgenerales,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkMayooresGeneralesToSaves(List<MayooresGenerales> mayooresgeneraless,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkMayooresGeneralesToSaves(List<MayooresGenerales> mayooresgeneraless,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkMayooresGeneralesToSavesAfter(List<MayooresGenerales> mayooresgeneraless,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkMayooresGeneralesToGet(MayooresGenerales mayooresgenerales,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkMayooresGeneralesToGets(List<MayooresGenerales> mayooresgeneraless,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateMayooresGeneralesToSave(MayooresGenerales mayooresgenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateMayooresGeneralesToGet(MayooresGenerales mayooresgenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectMayooresGeneralesActions(String sTipoJsonResponse,JSONObject jsonObjectMayooresGenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonMayooresGeneralesDataTable(String sTipoJsonResponse,MayooresGenerales mayooresgenerales,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonMayooresGeneralessDataTable(String sTipoJsonResponse,List<MayooresGenerales> mayooresgeneraless,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayMayooresGeneralesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayMayooresGeneralessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayMayooresGeneralessColumns;
	}
	
	public static void updateJSONArrayMayooresGeneralesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectMayooresGenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosMayooresGenerales(MayooresGenerales mayooresgenerales,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		mayooresgenerales.setnombre_sucursal(mayooresgenerales.getnombre_sucursal().trim());
		mayooresgenerales.setcodigo(mayooresgenerales.getcodigo().trim());
		mayooresgenerales.setbeneficiario(mayooresgenerales.getbeneficiario().trim());
		mayooresgenerales.setdetalle(mayooresgenerales.getdetalle().trim());
		mayooresgenerales.setcodigo_tipo_movimiento(mayooresgenerales.getcodigo_tipo_movimiento().trim());
		mayooresgenerales.setnumero_mayor(mayooresgenerales.getnumero_mayor().trim());
		mayooresgenerales.setnombre_cuenta_contable(mayooresgenerales.getnombre_cuenta_contable().trim());
		mayooresgenerales.setdetalle_detalle_asiento_contable(mayooresgenerales.getdetalle_detalle_asiento_contable().trim());
		mayooresgenerales.setcodigo_cuenta_contable(mayooresgenerales.getcodigo_cuenta_contable().trim());
	}
	
	public static void quitarEspaciosMayooresGeneraless(List<MayooresGenerales> mayooresgeneraless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MayooresGenerales mayooresgenerales: mayooresgeneraless) {
			mayooresgenerales.setnombre_sucursal(mayooresgenerales.getnombre_sucursal().trim());
			mayooresgenerales.setcodigo(mayooresgenerales.getcodigo().trim());
			mayooresgenerales.setbeneficiario(mayooresgenerales.getbeneficiario().trim());
			mayooresgenerales.setdetalle(mayooresgenerales.getdetalle().trim());
			mayooresgenerales.setcodigo_tipo_movimiento(mayooresgenerales.getcodigo_tipo_movimiento().trim());
			mayooresgenerales.setnumero_mayor(mayooresgenerales.getnumero_mayor().trim());
			mayooresgenerales.setnombre_cuenta_contable(mayooresgenerales.getnombre_cuenta_contable().trim());
			mayooresgenerales.setdetalle_detalle_asiento_contable(mayooresgenerales.getdetalle_detalle_asiento_contable().trim());
			mayooresgenerales.setcodigo_cuenta_contable(mayooresgenerales.getcodigo_cuenta_contable().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMayooresGenerales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(MayooresGeneralesConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(MayooresGeneralesConstantesFunciones.IDEJERCICIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MayooresGenerales> mayooresgeneraless,MayooresGenerales mayooresgenerales,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MayooresGenerales mayooresgeneralesAux: mayooresgeneraless) {
			if((mayooresgeneralesAux.getId()==null && mayooresgenerales.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(mayooresgeneralesAux.getId()!=null && mayooresgenerales.getId()!=null){
				if(mayooresgeneralesAux.getId().equals(mayooresgenerales.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMayooresGenerales(List<MayooresGenerales> mayooresgeneraless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
		Double saldoTotal=0.0;
	
		for(MayooresGenerales mayooresgenerales: mayooresgeneraless) {			
			debito_localTotal+=mayooresgenerales.getdebito_local();
			credito_localTotal+=mayooresgenerales.getcredito_local();
			saldoTotal+=mayooresgenerales.getsaldo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MayooresGeneralesConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MayooresGeneralesConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MayooresGeneralesConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(MayooresGeneralesConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
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