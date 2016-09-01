










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.activosfijos.business.logic.report;

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
import com.bydan.erp.activosfijos.util.report.DepreciacionesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;
////import com.bydan.erp.activosfijos.business.interfaces.DepreciacionesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class DepreciacionesLogicAdditional extends DepreciacionesLogic{		
	
	public  DepreciacionesLogicAdditional(Connexion connexion)throws Exception {
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
	public  DepreciacionesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDepreciacionesToSave(Depreciaciones depreciaciones,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDepreciacionesToSave(Depreciaciones depreciaciones,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDepreciacionesToSaveAfter(Depreciaciones depreciaciones,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDepreciacionesToSaves(List<Depreciaciones> depreciacioness,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDepreciacionesToSaves(List<Depreciaciones> depreciacioness,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDepreciacionesToSavesAfter(List<Depreciaciones> depreciacioness,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDepreciacionesToGet(Depreciaciones depreciaciones,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDepreciacionesToGets(List<Depreciaciones> depreciacioness,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDepreciacionesToSave(Depreciaciones depreciaciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDepreciacionesToGet(Depreciaciones depreciaciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDepreciacionesActions(String sTipoJsonResponse,JSONObject jsonObjectDepreciaciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDepreciacionesDataTable(String sTipoJsonResponse,Depreciaciones depreciaciones,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDepreciacionessDataTable(String sTipoJsonResponse,List<Depreciaciones> depreciacioness,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDepreciacionesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDepreciacionessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDepreciacionessColumns;
	}
	
	public static void updateJSONArrayDepreciacionesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDepreciaciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDepreciaciones(Depreciaciones depreciaciones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		depreciaciones.setcodigo_sub_grupo(depreciaciones.getcodigo_sub_grupo().trim());
		depreciaciones.setnombre_sub_grupo(depreciaciones.getnombre_sub_grupo().trim());
		depreciaciones.setcodigo_detalle_grupo(depreciaciones.getcodigo_detalle_grupo().trim());
		depreciaciones.setnombre_detalle_grupo(depreciaciones.getnombre_detalle_grupo().trim());
		depreciaciones.setclave(depreciaciones.getclave().trim());
		depreciaciones.setnombre(depreciaciones.getnombre().trim());
	}
	
	public static void quitarEspaciosDepreciacioness(List<Depreciaciones> depreciacioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Depreciaciones depreciaciones: depreciacioness) {
			depreciaciones.setcodigo_sub_grupo(depreciaciones.getcodigo_sub_grupo().trim());
			depreciaciones.setnombre_sub_grupo(depreciaciones.getnombre_sub_grupo().trim());
			depreciaciones.setcodigo_detalle_grupo(depreciaciones.getcodigo_detalle_grupo().trim());
			depreciaciones.setnombre_detalle_grupo(depreciaciones.getnombre_detalle_grupo().trim());
			depreciaciones.setclave(depreciaciones.getclave().trim());
			depreciaciones.setnombre(depreciaciones.getnombre().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDepreciaciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DepreciacionesConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Depreciaciones> depreciacioness,Depreciaciones depreciaciones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Depreciaciones depreciacionesAux: depreciacioness) {
			if((depreciacionesAux.getId()==null && depreciaciones.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(depreciacionesAux.getId()!=null && depreciaciones.getId()!=null){
				if(depreciacionesAux.getId().equals(depreciaciones.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDepreciaciones(List<Depreciaciones> depreciacioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
		Double valor_acumuladoTotal=0.0;
		Double valor_gastoTotal=0.0;
	
		for(Depreciaciones depreciaciones: depreciacioness) {			
			vida_utilTotal+=depreciaciones.getvida_util();
			costo_de_compraTotal+=depreciaciones.getcosto_de_compra();
			valor_acumuladoTotal+=depreciaciones.getvalor_acumulado();
			valor_gastoTotal+=depreciaciones.getvalor_gasto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionesConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionesConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_COSTODECOMPRA);
		datoGeneral.setdValorDouble(costo_de_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionesConstantesFunciones.VALORACUMULADO);
		datoGeneral.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_VALORACUMULADO);
		datoGeneral.setdValorDouble(valor_acumuladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionesConstantesFunciones.VALORGASTO);
		datoGeneral.setsDescripcion(DepreciacionesConstantesFunciones.LABEL_VALORGASTO);
		datoGeneral.setdValorDouble(valor_gastoTotal);
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