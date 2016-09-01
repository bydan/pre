














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
import com.bydan.erp.nomina.util.EstadoGastoEmpleadoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
//import com.bydan.erp.nomina.business.interfaces.EstadoGastoEmpleadoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class EstadoGastoEmpleadoLogicAdditional extends EstadoGastoEmpleadoLogic { // implements EstadoGastoEmpleadoAdditionable{
	public  EstadoGastoEmpleadoLogicAdditional(Connexion connexion)throws Exception {
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
	public  EstadoGastoEmpleadoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkEstadoGastoEmpleadoToSave(EstadoGastoEmpleado estadogastoempleado,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkEstadoGastoEmpleadoToSave(EstadoGastoEmpleado estadogastoempleado,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkEstadoGastoEmpleadoToSaveAfter(EstadoGastoEmpleado estadogastoempleado,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkEstadoGastoEmpleadoToSaves(List<EstadoGastoEmpleado> estadogastoempleados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkEstadoGastoEmpleadoToSaves(List<EstadoGastoEmpleado> estadogastoempleados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkEstadoGastoEmpleadoToSavesAfter(List<EstadoGastoEmpleado> estadogastoempleados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkEstadoGastoEmpleadoToGet(EstadoGastoEmpleado estadogastoempleado,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkEstadoGastoEmpleadoToGets(List<EstadoGastoEmpleado> estadogastoempleados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateEstadoGastoEmpleadoToSave(EstadoGastoEmpleado estadogastoempleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateEstadoGastoEmpleadoToGet(EstadoGastoEmpleado estadogastoempleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectEstadoGastoEmpleadoActions(String sTipoJsonResponse,JSONObject jsonObjectEstadoGastoEmpleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonEstadoGastoEmpleadoDataTable(String sTipoJsonResponse,EstadoGastoEmpleado estadogastoempleado,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonEstadoGastoEmpleadosDataTable(String sTipoJsonResponse,List<EstadoGastoEmpleado> estadogastoempleados,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayEstadoGastoEmpleadoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayEstadoGastoEmpleadosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayEstadoGastoEmpleadosColumns;
	}
	
	public static void updateJSONArrayEstadoGastoEmpleadoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectEstadoGastoEmpleado,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosEstadoGastoEmpleado(EstadoGastoEmpleado estadogastoempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadogastoempleado.setcodigo(estadogastoempleado.getcodigo().trim());
		estadogastoempleado.setnombre(estadogastoempleado.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoGastoEmpleados(List<EstadoGastoEmpleado> estadogastoempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoGastoEmpleado estadogastoempleado: estadogastoempleados) {
			estadogastoempleado.setcodigo(estadogastoempleado.getcodigo().trim());
			estadogastoempleado.setnombre(estadogastoempleado.getnombre().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoGastoEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoGastoEmpleado> estadogastoempleados,EstadoGastoEmpleado estadogastoempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoGastoEmpleado estadogastoempleadoAux: estadogastoempleados) {
			if((estadogastoempleadoAux.getId()==null && estadogastoempleado.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(estadogastoempleadoAux.getId()!=null && estadogastoempleado.getId()!=null){
				if(estadogastoempleadoAux.getId().equals(estadogastoempleado.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoGastoEmpleado(List<EstadoGastoEmpleado> estadogastoempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoGastoEmpleado estadogastoempleado: estadogastoempleados) {			
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