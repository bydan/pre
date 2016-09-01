










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
import com.bydan.erp.contabilidad.util.report.ListadosPlanCuentasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
////import com.bydan.erp.contabilidad.business.interfaces.ListadosPlanCuentasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ListadosPlanCuentasLogicAdditional extends ListadosPlanCuentasLogic{		
	
	public  ListadosPlanCuentasLogicAdditional(Connexion connexion)throws Exception {
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
	public  ListadosPlanCuentasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkListadosPlanCuentasToSave(ListadosPlanCuentas listadosplancuentas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkListadosPlanCuentasToSave(ListadosPlanCuentas listadosplancuentas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkListadosPlanCuentasToSaveAfter(ListadosPlanCuentas listadosplancuentas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkListadosPlanCuentasToSaves(List<ListadosPlanCuentas> listadosplancuentass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkListadosPlanCuentasToSaves(List<ListadosPlanCuentas> listadosplancuentass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkListadosPlanCuentasToSavesAfter(List<ListadosPlanCuentas> listadosplancuentass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkListadosPlanCuentasToGet(ListadosPlanCuentas listadosplancuentas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkListadosPlanCuentasToGets(List<ListadosPlanCuentas> listadosplancuentass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateListadosPlanCuentasToSave(ListadosPlanCuentas listadosplancuentas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateListadosPlanCuentasToGet(ListadosPlanCuentas listadosplancuentas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectListadosPlanCuentasActions(String sTipoJsonResponse,JSONObject jsonObjectListadosPlanCuentas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonListadosPlanCuentasDataTable(String sTipoJsonResponse,ListadosPlanCuentas listadosplancuentas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonListadosPlanCuentassDataTable(String sTipoJsonResponse,List<ListadosPlanCuentas> listadosplancuentass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayListadosPlanCuentasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayListadosPlanCuentassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayListadosPlanCuentassColumns;
	}
	
	public static void updateJSONArrayListadosPlanCuentasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectListadosPlanCuentas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosListadosPlanCuentas(ListadosPlanCuentas listadosplancuentas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		listadosplancuentas.setnombre_moneda(listadosplancuentas.getnombre_moneda().trim());
		listadosplancuentas.setcodigo(listadosplancuentas.getcodigo().trim());
		listadosplancuentas.setnombre(listadosplancuentas.getnombre().trim());
		listadosplancuentas.setnombre_nivel_cuenta(listadosplancuentas.getnombre_nivel_cuenta().trim());
	}
	
	public static void quitarEspaciosListadosPlanCuentass(List<ListadosPlanCuentas> listadosplancuentass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ListadosPlanCuentas listadosplancuentas: listadosplancuentass) {
			listadosplancuentas.setnombre_moneda(listadosplancuentas.getnombre_moneda().trim());
			listadosplancuentas.setcodigo(listadosplancuentas.getcodigo().trim());
			listadosplancuentas.setnombre(listadosplancuentas.getnombre().trim());
			listadosplancuentas.setnombre_nivel_cuenta(listadosplancuentas.getnombre_nivel_cuenta().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesListadosPlanCuentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ListadosPlanCuentasConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ListadosPlanCuentas> listadosplancuentass,ListadosPlanCuentas listadosplancuentas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ListadosPlanCuentas listadosplancuentasAux: listadosplancuentass) {
			if((listadosplancuentasAux.getId()==null && listadosplancuentas.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(listadosplancuentasAux.getId()!=null && listadosplancuentas.getId()!=null){
				if(listadosplancuentasAux.getId().equals(listadosplancuentas.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaListadosPlanCuentas(List<ListadosPlanCuentas> listadosplancuentass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ListadosPlanCuentas listadosplancuentas: listadosplancuentass) {			
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