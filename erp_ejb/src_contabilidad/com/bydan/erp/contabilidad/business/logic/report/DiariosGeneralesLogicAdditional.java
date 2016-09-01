










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
import com.bydan.erp.contabilidad.util.report.DiariosGeneralesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
////import com.bydan.erp.contabilidad.business.interfaces.DiariosGeneralesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class DiariosGeneralesLogicAdditional extends DiariosGeneralesLogic{		
	
	public  DiariosGeneralesLogicAdditional(Connexion connexion)throws Exception {
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
	public  DiariosGeneralesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDiariosGeneralesToSave(DiariosGenerales diariosgenerales,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDiariosGeneralesToSave(DiariosGenerales diariosgenerales,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDiariosGeneralesToSaveAfter(DiariosGenerales diariosgenerales,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDiariosGeneralesToSaves(List<DiariosGenerales> diariosgeneraless,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDiariosGeneralesToSaves(List<DiariosGenerales> diariosgeneraless,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDiariosGeneralesToSavesAfter(List<DiariosGenerales> diariosgeneraless,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDiariosGeneralesToGet(DiariosGenerales diariosgenerales,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDiariosGeneralesToGets(List<DiariosGenerales> diariosgeneraless,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDiariosGeneralesToSave(DiariosGenerales diariosgenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDiariosGeneralesToGet(DiariosGenerales diariosgenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDiariosGeneralesActions(String sTipoJsonResponse,JSONObject jsonObjectDiariosGenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDiariosGeneralesDataTable(String sTipoJsonResponse,DiariosGenerales diariosgenerales,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDiariosGeneralessDataTable(String sTipoJsonResponse,List<DiariosGenerales> diariosgeneraless,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDiariosGeneralesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDiariosGeneralessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDiariosGeneralessColumns;
	}
	
	public static void updateJSONArrayDiariosGeneralesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDiariosGenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDiariosGenerales(DiariosGenerales diariosgenerales,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		diariosgenerales.setcodigo(diariosgenerales.getcodigo().trim());
		diariosgenerales.setcodigo_tipo_movimiento(diariosgenerales.getcodigo_tipo_movimiento().trim());
		diariosgenerales.setnumero_mayor(diariosgenerales.getnumero_mayor().trim());
		diariosgenerales.setnombre_cuenta_contable(diariosgenerales.getnombre_cuenta_contable().trim());
		diariosgenerales.setdetalle(diariosgenerales.getdetalle().trim());
		diariosgenerales.setcodigo_cuenta_contable(diariosgenerales.getcodigo_cuenta_contable().trim());
	}
	
	public static void quitarEspaciosDiariosGeneraless(List<DiariosGenerales> diariosgeneraless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DiariosGenerales diariosgenerales: diariosgeneraless) {
			diariosgenerales.setcodigo(diariosgenerales.getcodigo().trim());
			diariosgenerales.setcodigo_tipo_movimiento(diariosgenerales.getcodigo_tipo_movimiento().trim());
			diariosgenerales.setnumero_mayor(diariosgenerales.getnumero_mayor().trim());
			diariosgenerales.setnombre_cuenta_contable(diariosgenerales.getnombre_cuenta_contable().trim());
			diariosgenerales.setdetalle(diariosgenerales.getdetalle().trim());
			diariosgenerales.setcodigo_cuenta_contable(diariosgenerales.getcodigo_cuenta_contable().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDiariosGenerales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DiariosGeneralesConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DiariosGeneralesConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(DiariosGeneralesConstantesFunciones.IDEJERCICIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DiariosGenerales> diariosgeneraless,DiariosGenerales diariosgenerales,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DiariosGenerales diariosgeneralesAux: diariosgeneraless) {
			if((diariosgeneralesAux.getId()==null && diariosgenerales.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(diariosgeneralesAux.getId()!=null && diariosgenerales.getId()!=null){
				if(diariosgeneralesAux.getId().equals(diariosgenerales.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDiariosGenerales(List<DiariosGenerales> diariosgeneraless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
	
		for(DiariosGenerales diariosgenerales: diariosgeneraless) {			
			debito_localTotal+=diariosgenerales.getdebito_local();
			credito_localTotal+=diariosgenerales.getcredito_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiariosGeneralesConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiariosGeneralesConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_CREDITOLOCAL);
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