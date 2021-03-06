










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
import com.bydan.erp.cartera.util.report.ListadoClientesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.ListadoClientesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ListadoClientesLogicAdditional extends ListadoClientesLogic{		
	
	public  ListadoClientesLogicAdditional(Connexion connexion)throws Exception {
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
	public  ListadoClientesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkListadoClientesToSave(ListadoClientes listadoclientes,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkListadoClientesToSave(ListadoClientes listadoclientes,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkListadoClientesToSaveAfter(ListadoClientes listadoclientes,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkListadoClientesToSaves(List<ListadoClientes> listadoclientess,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkListadoClientesToSaves(List<ListadoClientes> listadoclientess,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkListadoClientesToSavesAfter(List<ListadoClientes> listadoclientess,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkListadoClientesToGet(ListadoClientes listadoclientes,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkListadoClientesToGets(List<ListadoClientes> listadoclientess,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateListadoClientesToSave(ListadoClientes listadoclientes,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateListadoClientesToGet(ListadoClientes listadoclientes,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectListadoClientesActions(String sTipoJsonResponse,JSONObject jsonObjectListadoClientes,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonListadoClientesDataTable(String sTipoJsonResponse,ListadoClientes listadoclientes,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonListadoClientessDataTable(String sTipoJsonResponse,List<ListadoClientes> listadoclientess,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayListadoClientesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayListadoClientessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayListadoClientessColumns;
	}
	
	public static void updateJSONArrayListadoClientesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectListadoClientes,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosListadoClientes(ListadoClientes listadoclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		listadoclientes.setnombre_zona(listadoclientes.getnombre_zona().trim());
		listadoclientes.setnombre_ciudad(listadoclientes.getnombre_ciudad().trim());
		listadoclientes.setnombre_grupo_cliente(listadoclientes.getnombre_grupo_cliente().trim());
		listadoclientes.setcodigo(listadoclientes.getcodigo().trim());
		listadoclientes.setnombre(listadoclientes.getnombre().trim());
		listadoclientes.setapellido(listadoclientes.getapellido().trim());
		listadoclientes.setruc(listadoclientes.getruc().trim());
		listadoclientes.settelefonos(listadoclientes.gettelefonos().trim());
		listadoclientes.setdirecciones(listadoclientes.getdirecciones().trim());
		listadoclientes.setemails(listadoclientes.getemails().trim());
	}
	
	public static void quitarEspaciosListadoClientess(List<ListadoClientes> listadoclientess,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ListadoClientes listadoclientes: listadoclientess) {
			listadoclientes.setnombre_zona(listadoclientes.getnombre_zona().trim());
			listadoclientes.setnombre_ciudad(listadoclientes.getnombre_ciudad().trim());
			listadoclientes.setnombre_grupo_cliente(listadoclientes.getnombre_grupo_cliente().trim());
			listadoclientes.setcodigo(listadoclientes.getcodigo().trim());
			listadoclientes.setnombre(listadoclientes.getnombre().trim());
			listadoclientes.setapellido(listadoclientes.getapellido().trim());
			listadoclientes.setruc(listadoclientes.getruc().trim());
			listadoclientes.settelefonos(listadoclientes.gettelefonos().trim());
			listadoclientes.setdirecciones(listadoclientes.getdirecciones().trim());
			listadoclientes.setemails(listadoclientes.getemails().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesListadoClientes(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ListadoClientesConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ListadoClientes> listadoclientess,ListadoClientes listadoclientes,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ListadoClientes listadoclientesAux: listadoclientess) {
			if((listadoclientesAux.getId()==null && listadoclientes.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(listadoclientesAux.getId()!=null && listadoclientes.getId()!=null){
				if(listadoclientesAux.getId().equals(listadoclientes.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaListadoClientes(List<ListadoClientes> listadoclientess) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ListadoClientes listadoclientes: listadoclientess) {			
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