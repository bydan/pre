














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
import com.bydan.erp.nomina.util.TipoProvisionEmpleadoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
//import com.bydan.erp.nomina.business.interfaces.TipoProvisionEmpleadoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class TipoProvisionEmpleadoLogicAdditional extends TipoProvisionEmpleadoLogic { // implements TipoProvisionEmpleadoAdditionable{
	public  TipoProvisionEmpleadoLogicAdditional(Connexion connexion)throws Exception {
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
	public  TipoProvisionEmpleadoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkTipoProvisionEmpleadoToSave(TipoProvisionEmpleado tipoprovisionempleado,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkTipoProvisionEmpleadoToSave(TipoProvisionEmpleado tipoprovisionempleado,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkTipoProvisionEmpleadoToSaveAfter(TipoProvisionEmpleado tipoprovisionempleado,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkTipoProvisionEmpleadoToSaves(List<TipoProvisionEmpleado> tipoprovisionempleados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkTipoProvisionEmpleadoToSaves(List<TipoProvisionEmpleado> tipoprovisionempleados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkTipoProvisionEmpleadoToSavesAfter(List<TipoProvisionEmpleado> tipoprovisionempleados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkTipoProvisionEmpleadoToGet(TipoProvisionEmpleado tipoprovisionempleado,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkTipoProvisionEmpleadoToGets(List<TipoProvisionEmpleado> tipoprovisionempleados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateTipoProvisionEmpleadoToSave(TipoProvisionEmpleado tipoprovisionempleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateTipoProvisionEmpleadoToGet(TipoProvisionEmpleado tipoprovisionempleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectTipoProvisionEmpleadoActions(String sTipoJsonResponse,JSONObject jsonObjectTipoProvisionEmpleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonTipoProvisionEmpleadoDataTable(String sTipoJsonResponse,TipoProvisionEmpleado tipoprovisionempleado,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonTipoProvisionEmpleadosDataTable(String sTipoJsonResponse,List<TipoProvisionEmpleado> tipoprovisionempleados,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayTipoProvisionEmpleadoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayTipoProvisionEmpleadosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayTipoProvisionEmpleadosColumns;
	}
	
	public static void updateJSONArrayTipoProvisionEmpleadoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectTipoProvisionEmpleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosTipoProvisionEmpleado(TipoProvisionEmpleado tipoprovisionempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoprovisionempleado.setcodigo(tipoprovisionempleado.getcodigo().trim());
		tipoprovisionempleado.setnombre(tipoprovisionempleado.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoProvisionEmpleados(List<TipoProvisionEmpleado> tipoprovisionempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoProvisionEmpleado tipoprovisionempleado: tipoprovisionempleados) {
			tipoprovisionempleado.setcodigo(tipoprovisionempleado.getcodigo().trim());
			tipoprovisionempleado.setnombre(tipoprovisionempleado.getnombre().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoProvisionEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoProvisionEmpleado> tipoprovisionempleados,TipoProvisionEmpleado tipoprovisionempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoProvisionEmpleado tipoprovisionempleadoAux: tipoprovisionempleados) {
			if((tipoprovisionempleadoAux.getId()==null && tipoprovisionempleado.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(tipoprovisionempleadoAux.getId()!=null && tipoprovisionempleado.getId()!=null){
				if(tipoprovisionempleadoAux.getId().equals(tipoprovisionempleado.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoProvisionEmpleado(List<TipoProvisionEmpleado> tipoprovisionempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoProvisionEmpleado tipoprovisionempleado: tipoprovisionempleados) {			
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