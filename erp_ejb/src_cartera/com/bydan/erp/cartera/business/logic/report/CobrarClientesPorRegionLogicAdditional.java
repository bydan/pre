










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
import com.bydan.erp.cartera.util.report.CobrarClientesPorRegionConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.CobrarClientesPorRegionAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class CobrarClientesPorRegionLogicAdditional extends CobrarClientesPorRegionLogic{		
	
	public  CobrarClientesPorRegionLogicAdditional(Connexion connexion)throws Exception {
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
	public  CobrarClientesPorRegionLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCobrarClientesPorRegionToSave(CobrarClientesPorRegion cobrarclientesporregion,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCobrarClientesPorRegionToSave(CobrarClientesPorRegion cobrarclientesporregion,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCobrarClientesPorRegionToSaveAfter(CobrarClientesPorRegion cobrarclientesporregion,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCobrarClientesPorRegionToSaves(List<CobrarClientesPorRegion> cobrarclientesporregions,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCobrarClientesPorRegionToSaves(List<CobrarClientesPorRegion> cobrarclientesporregions,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCobrarClientesPorRegionToSavesAfter(List<CobrarClientesPorRegion> cobrarclientesporregions,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCobrarClientesPorRegionToGet(CobrarClientesPorRegion cobrarclientesporregion,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCobrarClientesPorRegionToGets(List<CobrarClientesPorRegion> cobrarclientesporregions,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCobrarClientesPorRegionToSave(CobrarClientesPorRegion cobrarclientesporregion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCobrarClientesPorRegionToGet(CobrarClientesPorRegion cobrarclientesporregion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCobrarClientesPorRegionActions(String sTipoJsonResponse,JSONObject jsonObjectCobrarClientesPorRegion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCobrarClientesPorRegionDataTable(String sTipoJsonResponse,CobrarClientesPorRegion cobrarclientesporregion,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCobrarClientesPorRegionsDataTable(String sTipoJsonResponse,List<CobrarClientesPorRegion> cobrarclientesporregions,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCobrarClientesPorRegionColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCobrarClientesPorRegionsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCobrarClientesPorRegionsColumns;
	}
	
	public static void updateJSONArrayCobrarClientesPorRegionActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCobrarClientesPorRegion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCobrarClientesPorRegion(CobrarClientesPorRegion cobrarclientesporregion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarclientesporregion.setnombre_region(cobrarclientesporregion.getnombre_region().trim());
		cobrarclientesporregion.setnombre_provincia(cobrarclientesporregion.getnombre_provincia().trim());
		cobrarclientesporregion.setnombre_ciudad(cobrarclientesporregion.getnombre_ciudad().trim());
		cobrarclientesporregion.setnombre_zona(cobrarclientesporregion.getnombre_zona().trim());
		cobrarclientesporregion.setnombre_ruta(cobrarclientesporregion.getnombre_ruta().trim());
		cobrarclientesporregion.setnombre_vendedor(cobrarclientesporregion.getnombre_vendedor().trim());
		cobrarclientesporregion.setcodigo(cobrarclientesporregion.getcodigo().trim());
		cobrarclientesporregion.setnombre(cobrarclientesporregion.getnombre().trim());
		cobrarclientesporregion.setapellido(cobrarclientesporregion.getapellido().trim());
		cobrarclientesporregion.setdireccion_direccion(cobrarclientesporregion.getdireccion_direccion().trim());
		cobrarclientesporregion.settelefono_telefono(cobrarclientesporregion.gettelefono_telefono().trim());
	}
	
	public static void quitarEspaciosCobrarClientesPorRegions(List<CobrarClientesPorRegion> cobrarclientesporregions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarClientesPorRegion cobrarclientesporregion: cobrarclientesporregions) {
			cobrarclientesporregion.setnombre_region(cobrarclientesporregion.getnombre_region().trim());
			cobrarclientesporregion.setnombre_provincia(cobrarclientesporregion.getnombre_provincia().trim());
			cobrarclientesporregion.setnombre_ciudad(cobrarclientesporregion.getnombre_ciudad().trim());
			cobrarclientesporregion.setnombre_zona(cobrarclientesporregion.getnombre_zona().trim());
			cobrarclientesporregion.setnombre_ruta(cobrarclientesporregion.getnombre_ruta().trim());
			cobrarclientesporregion.setnombre_vendedor(cobrarclientesporregion.getnombre_vendedor().trim());
			cobrarclientesporregion.setcodigo(cobrarclientesporregion.getcodigo().trim());
			cobrarclientesporregion.setnombre(cobrarclientesporregion.getnombre().trim());
			cobrarclientesporregion.setapellido(cobrarclientesporregion.getapellido().trim());
			cobrarclientesporregion.setdireccion_direccion(cobrarclientesporregion.getdireccion_direccion().trim());
			cobrarclientesporregion.settelefono_telefono(cobrarclientesporregion.gettelefono_telefono().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesPorRegion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CobrarClientesPorRegionConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(CobrarClientesPorRegionConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarClientesPorRegion> cobrarclientesporregions,CobrarClientesPorRegion cobrarclientesporregion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarClientesPorRegion cobrarclientesporregionAux: cobrarclientesporregions) {
			if((cobrarclientesporregionAux.getId()==null && cobrarclientesporregion.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cobrarclientesporregionAux.getId()!=null && cobrarclientesporregion.getId()!=null){
				if(cobrarclientesporregionAux.getId().equals(cobrarclientesporregion.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarClientesPorRegion(List<CobrarClientesPorRegion> cobrarclientesporregions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CobrarClientesPorRegion cobrarclientesporregion: cobrarclientesporregions) {			
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