










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
import com.bydan.erp.inventario.util.report.DisponiblesCostosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;
////import com.bydan.erp.inventario.business.interfaces.DisponiblesCostosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class DisponiblesCostosLogicAdditional extends DisponiblesCostosLogic{		
	
	public  DisponiblesCostosLogicAdditional(Connexion connexion)throws Exception {
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
	public  DisponiblesCostosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDisponiblesCostosToSave(DisponiblesCostos disponiblescostos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDisponiblesCostosToSave(DisponiblesCostos disponiblescostos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDisponiblesCostosToSaveAfter(DisponiblesCostos disponiblescostos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDisponiblesCostosToSaves(List<DisponiblesCostos> disponiblescostoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDisponiblesCostosToSaves(List<DisponiblesCostos> disponiblescostoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDisponiblesCostosToSavesAfter(List<DisponiblesCostos> disponiblescostoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDisponiblesCostosToGet(DisponiblesCostos disponiblescostos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDisponiblesCostosToGets(List<DisponiblesCostos> disponiblescostoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDisponiblesCostosToSave(DisponiblesCostos disponiblescostos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDisponiblesCostosToGet(DisponiblesCostos disponiblescostos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDisponiblesCostosActions(String sTipoJsonResponse,JSONObject jsonObjectDisponiblesCostos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDisponiblesCostosDataTable(String sTipoJsonResponse,DisponiblesCostos disponiblescostos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDisponiblesCostossDataTable(String sTipoJsonResponse,List<DisponiblesCostos> disponiblescostoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDisponiblesCostosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDisponiblesCostossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDisponiblesCostossColumns;
	}
	
	public static void updateJSONArrayDisponiblesCostosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDisponiblesCostos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDisponiblesCostos(DisponiblesCostos disponiblescostos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		disponiblescostos.setnombre_sucursal(disponiblescostos.getnombre_sucursal().trim());
		disponiblescostos.setnombre_linea(disponiblescostos.getnombre_linea().trim());
		disponiblescostos.setnombre_linea_grupo(disponiblescostos.getnombre_linea_grupo().trim());
		disponiblescostos.setnombre_linea_categoria(disponiblescostos.getnombre_linea_categoria().trim());
		disponiblescostos.setnombre_linea_marca(disponiblescostos.getnombre_linea_marca().trim());
		disponiblescostos.setcodigo(disponiblescostos.getcodigo().trim());
		disponiblescostos.setnombre(disponiblescostos.getnombre().trim());
		disponiblescostos.setnombre_bodega(disponiblescostos.getnombre_bodega().trim());
		disponiblescostos.setnombre_unidad(disponiblescostos.getnombre_unidad().trim());
	}
	
	public static void quitarEspaciosDisponiblesCostoss(List<DisponiblesCostos> disponiblescostoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DisponiblesCostos disponiblescostos: disponiblescostoss) {
			disponiblescostos.setnombre_sucursal(disponiblescostos.getnombre_sucursal().trim());
			disponiblescostos.setnombre_linea(disponiblescostos.getnombre_linea().trim());
			disponiblescostos.setnombre_linea_grupo(disponiblescostos.getnombre_linea_grupo().trim());
			disponiblescostos.setnombre_linea_categoria(disponiblescostos.getnombre_linea_categoria().trim());
			disponiblescostos.setnombre_linea_marca(disponiblescostos.getnombre_linea_marca().trim());
			disponiblescostos.setcodigo(disponiblescostos.getcodigo().trim());
			disponiblescostos.setnombre(disponiblescostos.getnombre().trim());
			disponiblescostos.setnombre_bodega(disponiblescostos.getnombre_bodega().trim());
			disponiblescostos.setnombre_unidad(disponiblescostos.getnombre_unidad().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDisponiblesCostos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DisponiblesCostosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DisponiblesCostosConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DisponiblesCostos> disponiblescostoss,DisponiblesCostos disponiblescostos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DisponiblesCostos disponiblescostosAux: disponiblescostoss) {
			if((disponiblescostosAux.getId()==null && disponiblescostos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(disponiblescostosAux.getId()!=null && disponiblescostos.getId()!=null){
				if(disponiblescostosAux.getId().equals(disponiblescostos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDisponiblesCostos(List<DisponiblesCostos> disponiblescostoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ingresosTotal=0.0;
		Double egresosTotal=0.0;
		Double disponible_corteTotal=0.0;
		Double costoTotal=0.0;
		Double totalTotal=0.0;
	
		for(DisponiblesCostos disponiblescostos: disponiblescostoss) {			
			ingresosTotal+=disponiblescostos.getingresos();
			egresosTotal+=disponiblescostos.getegresos();
			disponible_corteTotal+=disponiblescostos.getdisponible_corte();
			costoTotal+=disponiblescostos.getcosto();
			totalTotal+=disponiblescostos.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DisponiblesCostosConstantesFunciones.INGRESOS);
		datoGeneral.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_INGRESOS);
		datoGeneral.setdValorDouble(ingresosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DisponiblesCostosConstantesFunciones.EGRESOS);
		datoGeneral.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_EGRESOS);
		datoGeneral.setdValorDouble(egresosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DisponiblesCostosConstantesFunciones.DISPONIBLECORTE);
		datoGeneral.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_DISPONIBLECORTE);
		datoGeneral.setdValorDouble(disponible_corteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DisponiblesCostosConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DisponiblesCostosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DisponiblesCostosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
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