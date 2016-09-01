














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.ProvisionEmpleadoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
//import com.bydan.erp.nomina.business.interfaces.ProvisionEmpleadoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class ProvisionEmpleadoLogicAdditional extends ProvisionEmpleadoLogic { // implements ProvisionEmpleadoAdditionable{
	public  ProvisionEmpleadoLogicAdditional(Connexion connexion)throws Exception {
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
	public  ProvisionEmpleadoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProvisionEmpleadoToSave(ProvisionEmpleado provisionempleado,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProvisionEmpleadoToSave(ProvisionEmpleado provisionempleado,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProvisionEmpleadoToSaveAfter(ProvisionEmpleado provisionempleado,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProvisionEmpleadoToSaves(List<ProvisionEmpleado> provisionempleados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProvisionEmpleadoToSaves(List<ProvisionEmpleado> provisionempleados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProvisionEmpleadoToSavesAfter(List<ProvisionEmpleado> provisionempleados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProvisionEmpleadoToGet(ProvisionEmpleado provisionempleado,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProvisionEmpleadoToGets(List<ProvisionEmpleado> provisionempleados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProvisionEmpleadoToSave(ProvisionEmpleado provisionempleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProvisionEmpleadoToGet(ProvisionEmpleado provisionempleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProvisionEmpleadoActions(String sTipoJsonResponse,JSONObject jsonObjectProvisionEmpleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProvisionEmpleadoDataTable(String sTipoJsonResponse,ProvisionEmpleado provisionempleado,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProvisionEmpleadosDataTable(String sTipoJsonResponse,List<ProvisionEmpleado> provisionempleados,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProvisionEmpleadoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProvisionEmpleadosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProvisionEmpleadosColumns;
	}
	
	public static void updateJSONArrayProvisionEmpleadoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProvisionEmpleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosProvisionEmpleado(ProvisionEmpleado provisionempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProvisionEmpleados(List<ProvisionEmpleado> provisionempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProvisionEmpleado provisionempleado: provisionempleados) {
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProvisionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ProvisionEmpleadoConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProvisionEmpleado> provisionempleados,ProvisionEmpleado provisionempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProvisionEmpleado provisionempleadoAux: provisionempleados) {
			if((provisionempleadoAux.getId()==null && provisionempleado.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(provisionempleadoAux.getId()!=null && provisionempleado.getId()!=null){
				if(provisionempleadoAux.getId().equals(provisionempleado.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProvisionEmpleado(List<ProvisionEmpleado> provisionempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_mesTotal=0.0;
		Double valor_pagaTotal=0.0;
		Double valor_vacacionTotal=0.0;
		Double valor_liquidacionTotal=0.0;
	
		for(ProvisionEmpleado provisionempleado: provisionempleados) {			
			valor_mesTotal+=provisionempleado.getvalor_mes();
			valor_pagaTotal+=provisionempleado.getvalor_paga();
			valor_vacacionTotal+=provisionempleado.getvalor_vacacion();
			valor_liquidacionTotal+=provisionempleado.getvalor_liquidacion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProvisionEmpleadoConstantesFunciones.VALORMES);
		datoGeneral.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_VALORMES);
		datoGeneral.setdValorDouble(valor_mesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProvisionEmpleadoConstantesFunciones.VALORPAGA);
		datoGeneral.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_VALORPAGA);
		datoGeneral.setdValorDouble(valor_pagaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProvisionEmpleadoConstantesFunciones.VALORVACACION);
		datoGeneral.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_VALORVACACION);
		datoGeneral.setdValorDouble(valor_vacacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProvisionEmpleadoConstantesFunciones.VALORLIQUIDACION);
		datoGeneral.setsDescripcion(ProvisionEmpleadoConstantesFunciones.LABEL_VALORLIQUIDACION);
		datoGeneral.setdValorDouble(valor_liquidacionTotal);
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