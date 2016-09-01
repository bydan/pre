














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.activosfijos.business.logic;

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
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.activosfijos.util.DepreciacionActivoFijoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
//import com.bydan.erp.activosfijos.business.interfaces.DepreciacionActivoFijoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DepreciacionActivoFijoLogicAdditional extends DepreciacionActivoFijoLogic { // implements DepreciacionActivoFijoAdditionable{
	
	public  DepreciacionActivoFijoLogicAdditional(Connexion connexion)throws Exception {
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


	public static Boolean validarSaveRelaciones(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_20
		Boolean validado=true;

		return validado;	
	}


	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}

	//CONTROL_INICIO
	public  DepreciacionActivoFijoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDepreciacionActivoFijoToSave(DepreciacionActivoFijo depreciacionactivofijo,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDepreciacionActivoFijoToSave(DepreciacionActivoFijo depreciacionactivofijo,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDepreciacionActivoFijoToSaveAfter(DepreciacionActivoFijo depreciacionactivofijo,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDepreciacionActivoFijoToSaves(List<DepreciacionActivoFijo> depreciacionactivofijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDepreciacionActivoFijoToSaves(List<DepreciacionActivoFijo> depreciacionactivofijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDepreciacionActivoFijoToSavesAfter(List<DepreciacionActivoFijo> depreciacionactivofijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDepreciacionActivoFijoToGet(DepreciacionActivoFijo depreciacionactivofijo,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDepreciacionActivoFijoToGets(List<DepreciacionActivoFijo> depreciacionactivofijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDepreciacionActivoFijoToSave(DepreciacionActivoFijo depreciacionactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDepreciacionActivoFijoToGet(DepreciacionActivoFijo depreciacionactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDepreciacionActivoFijoActions(String sTipoJsonResponse,JSONObject jsonObjectDepreciacionActivoFijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDepreciacionActivoFijoDataTable(String sTipoJsonResponse,DepreciacionActivoFijo depreciacionactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDepreciacionActivoFijosDataTable(String sTipoJsonResponse,List<DepreciacionActivoFijo> depreciacionactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDepreciacionActivoFijoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDepreciacionActivoFijosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDepreciacionActivoFijosColumns;
	}
	
	public static void updateJSONArrayDepreciacionActivoFijoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDepreciacionActivoFijo,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDepreciacionActivoFijo(DepreciacionActivoFijo depreciacionactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosDepreciacionActivoFijos(List<DepreciacionActivoFijo> depreciacionactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DepreciacionActivoFijo depreciacionactivofijo: depreciacionactivofijos) {
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDepreciacionActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DepreciacionActivoFijoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DepreciacionActivoFijoConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DepreciacionActivoFijo> depreciacionactivofijos,DepreciacionActivoFijo depreciacionactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DepreciacionActivoFijo depreciacionactivofijoAux: depreciacionactivofijos) {
			if((depreciacionactivofijoAux.getId()==null && depreciacionactivofijo.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(depreciacionactivofijoAux.getId()!=null && depreciacionactivofijo.getId()!=null){
				if(depreciacionactivofijoAux.getId().equals(depreciacionactivofijo.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDepreciacionActivoFijo(List<DepreciacionActivoFijo> depreciacionactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_acumuladoTotal=0.0;
		Double valor_totalTotal=0.0;
		Double valor_gastoTotal=0.0;
	
		for(DepreciacionActivoFijo depreciacionactivofijo: depreciacionactivofijos) {			
			valor_acumuladoTotal+=depreciacionactivofijo.getvalor_acumulado();
			valor_totalTotal+=depreciacionactivofijo.getvalor_total();
			valor_gastoTotal+=depreciacionactivofijo.getvalor_gasto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionActivoFijoConstantesFunciones.VALORACUMULADO);
		datoGeneral.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_VALORACUMULADO);
		datoGeneral.setdValorDouble(valor_acumuladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionActivoFijoConstantesFunciones.VALORTOTAL);
		datoGeneral.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_VALORTOTAL);
		datoGeneral.setdValorDouble(valor_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionActivoFijoConstantesFunciones.VALORGASTO);
		datoGeneral.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_VALORGASTO);
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