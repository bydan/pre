










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.inventario.business.logic.report;

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
import com.bydan.erp.inventario.util.report.ExistenciasCostosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;
////import com.bydan.erp.inventario.business.interfaces.ExistenciasCostosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ExistenciasCostosLogicAdditional extends ExistenciasCostosLogic{		
	
	public  ExistenciasCostosLogicAdditional(Connexion connexion)throws Exception {
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
	public  ExistenciasCostosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkExistenciasCostosToSave(ExistenciasCostos existenciascostos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkExistenciasCostosToSave(ExistenciasCostos existenciascostos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkExistenciasCostosToSaveAfter(ExistenciasCostos existenciascostos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkExistenciasCostosToSaves(List<ExistenciasCostos> existenciascostoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkExistenciasCostosToSaves(List<ExistenciasCostos> existenciascostoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkExistenciasCostosToSavesAfter(List<ExistenciasCostos> existenciascostoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkExistenciasCostosToGet(ExistenciasCostos existenciascostos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkExistenciasCostosToGets(List<ExistenciasCostos> existenciascostoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateExistenciasCostosToSave(ExistenciasCostos existenciascostos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateExistenciasCostosToGet(ExistenciasCostos existenciascostos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectExistenciasCostosActions(String sTipoJsonResponse,JSONObject jsonObjectExistenciasCostos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonExistenciasCostosDataTable(String sTipoJsonResponse,ExistenciasCostos existenciascostos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonExistenciasCostossDataTable(String sTipoJsonResponse,List<ExistenciasCostos> existenciascostoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayExistenciasCostosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayExistenciasCostossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayExistenciasCostossColumns;
	}
	
	public static void updateJSONArrayExistenciasCostosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectExistenciasCostos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosExistenciasCostos(ExistenciasCostos existenciascostos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		existenciascostos.setnombre_producto(existenciascostos.getnombre_producto().trim());
		existenciascostos.setnombre_unidad(existenciascostos.getnombre_unidad().trim());
		existenciascostos.setnombre_linea(existenciascostos.getnombre_linea().trim());
		existenciascostos.setnombre_linea_grupo(existenciascostos.getnombre_linea_grupo().trim());
		existenciascostos.setnombre_linea_categoria(existenciascostos.getnombre_linea_categoria().trim());
		existenciascostos.setnombre_linea_marca(existenciascostos.getnombre_linea_marca().trim());
		existenciascostos.setcodigo(existenciascostos.getcodigo().trim());
	}
	
	public static void quitarEspaciosExistenciasCostoss(List<ExistenciasCostos> existenciascostoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ExistenciasCostos existenciascostos: existenciascostoss) {
			existenciascostos.setnombre_producto(existenciascostos.getnombre_producto().trim());
			existenciascostos.setnombre_unidad(existenciascostos.getnombre_unidad().trim());
			existenciascostos.setnombre_linea(existenciascostos.getnombre_linea().trim());
			existenciascostos.setnombre_linea_grupo(existenciascostos.getnombre_linea_grupo().trim());
			existenciascostos.setnombre_linea_categoria(existenciascostos.getnombre_linea_categoria().trim());
			existenciascostos.setnombre_linea_marca(existenciascostos.getnombre_linea_marca().trim());
			existenciascostos.setcodigo(existenciascostos.getcodigo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesExistenciasCostos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ExistenciasCostosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ExistenciasCostos> existenciascostoss,ExistenciasCostos existenciascostos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ExistenciasCostos existenciascostosAux: existenciascostoss) {
			if((existenciascostosAux.getId()==null && existenciascostos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(existenciascostosAux.getId()!=null && existenciascostos.getId()!=null){
				if(existenciascostosAux.getId().equals(existenciascostos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaExistenciasCostos(List<ExistenciasCostos> existenciascostoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_totalTotal=0.0;
	
		for(ExistenciasCostos existenciascostos: existenciascostoss) {			
			costo_totalTotal+=existenciascostos.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ExistenciasCostosConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ExistenciasCostosConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
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