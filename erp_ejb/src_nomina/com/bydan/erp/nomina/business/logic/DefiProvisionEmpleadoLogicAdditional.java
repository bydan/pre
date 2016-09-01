














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
import com.bydan.erp.nomina.util.DefiProvisionEmpleadoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
//import com.bydan.erp.nomina.business.interfaces.DefiProvisionEmpleadoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DefiProvisionEmpleadoLogicAdditional extends DefiProvisionEmpleadoLogic { // implements DefiProvisionEmpleadoAdditionable{
	public  DefiProvisionEmpleadoLogicAdditional(Connexion connexion)throws Exception {
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
	public  DefiProvisionEmpleadoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDefiProvisionEmpleadoToSave(DefiProvisionEmpleado defiprovisionempleado,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDefiProvisionEmpleadoToSave(DefiProvisionEmpleado defiprovisionempleado,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDefiProvisionEmpleadoToSaveAfter(DefiProvisionEmpleado defiprovisionempleado,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDefiProvisionEmpleadoToSaves(List<DefiProvisionEmpleado> defiprovisionempleados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDefiProvisionEmpleadoToSaves(List<DefiProvisionEmpleado> defiprovisionempleados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDefiProvisionEmpleadoToSavesAfter(List<DefiProvisionEmpleado> defiprovisionempleados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDefiProvisionEmpleadoToGet(DefiProvisionEmpleado defiprovisionempleado,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDefiProvisionEmpleadoToGets(List<DefiProvisionEmpleado> defiprovisionempleados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDefiProvisionEmpleadoToSave(DefiProvisionEmpleado defiprovisionempleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDefiProvisionEmpleadoToGet(DefiProvisionEmpleado defiprovisionempleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDefiProvisionEmpleadoActions(String sTipoJsonResponse,JSONObject jsonObjectDefiProvisionEmpleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDefiProvisionEmpleadoDataTable(String sTipoJsonResponse,DefiProvisionEmpleado defiprovisionempleado,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDefiProvisionEmpleadosDataTable(String sTipoJsonResponse,List<DefiProvisionEmpleado> defiprovisionempleados,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDefiProvisionEmpleadoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDefiProvisionEmpleadosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDefiProvisionEmpleadosColumns;
	}
	
	public static void updateJSONArrayDefiProvisionEmpleadoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDefiProvisionEmpleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDefiProvisionEmpleado(DefiProvisionEmpleado defiprovisionempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		defiprovisionempleado.setnombre(defiprovisionempleado.getnombre().trim());
		defiprovisionempleado.setdescripcion(defiprovisionempleado.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDefiProvisionEmpleados(List<DefiProvisionEmpleado> defiprovisionempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DefiProvisionEmpleado defiprovisionempleado: defiprovisionempleados) {
			defiprovisionempleado.setnombre(defiprovisionempleado.getnombre().trim());
			defiprovisionempleado.setdescripcion(defiprovisionempleado.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDefiProvisionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DefiProvisionEmpleadoConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DefiProvisionEmpleado> defiprovisionempleados,DefiProvisionEmpleado defiprovisionempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DefiProvisionEmpleado defiprovisionempleadoAux: defiprovisionempleados) {
			if((defiprovisionempleadoAux.getId()==null && defiprovisionempleado.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(defiprovisionempleadoAux.getId()!=null && defiprovisionempleado.getId()!=null){
				if(defiprovisionempleadoAux.getId().equals(defiprovisionempleado.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDefiProvisionEmpleado(List<DefiProvisionEmpleado> defiprovisionempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DefiProvisionEmpleado defiprovisionempleado: defiprovisionempleados) {			
		}
		
		
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