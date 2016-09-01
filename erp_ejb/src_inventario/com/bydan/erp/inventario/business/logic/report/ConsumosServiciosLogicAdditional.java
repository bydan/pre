










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
import com.bydan.erp.inventario.util.report.ConsumosServiciosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;
////import com.bydan.erp.inventario.business.interfaces.ConsumosServiciosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ConsumosServiciosLogicAdditional extends ConsumosServiciosLogic{		
	
	public  ConsumosServiciosLogicAdditional(Connexion connexion)throws Exception {
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
	public  ConsumosServiciosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkConsumosServiciosToSave(ConsumosServicios consumosservicios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkConsumosServiciosToSave(ConsumosServicios consumosservicios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkConsumosServiciosToSaveAfter(ConsumosServicios consumosservicios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkConsumosServiciosToSaves(List<ConsumosServicios> consumosservicioss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkConsumosServiciosToSaves(List<ConsumosServicios> consumosservicioss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkConsumosServiciosToSavesAfter(List<ConsumosServicios> consumosservicioss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkConsumosServiciosToGet(ConsumosServicios consumosservicios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkConsumosServiciosToGets(List<ConsumosServicios> consumosservicioss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateConsumosServiciosToSave(ConsumosServicios consumosservicios,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateConsumosServiciosToGet(ConsumosServicios consumosservicios,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectConsumosServiciosActions(String sTipoJsonResponse,JSONObject jsonObjectConsumosServicios,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonConsumosServiciosDataTable(String sTipoJsonResponse,ConsumosServicios consumosservicios,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonConsumosServiciossDataTable(String sTipoJsonResponse,List<ConsumosServicios> consumosservicioss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayConsumosServiciosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayConsumosServiciossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayConsumosServiciossColumns;
	}
	
	public static void updateJSONArrayConsumosServiciosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectConsumosServicios,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosConsumosServicios(ConsumosServicios consumosservicios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		consumosservicios.setnombre_unidad(consumosservicios.getnombre_unidad().trim());
		consumosservicios.setnombre_producto(consumosservicios.getnombre_producto().trim());
		consumosservicios.setnombre_linea(consumosservicios.getnombre_linea().trim());
		consumosservicios.setnombre_linea_grupo(consumosservicios.getnombre_linea_grupo().trim());
		consumosservicios.setnombre_linea_categoria(consumosservicios.getnombre_linea_categoria().trim());
		consumosservicios.setnombre_linea_marca(consumosservicios.getnombre_linea_marca().trim());
		consumosservicios.setcodigo(consumosservicios.getcodigo().trim());
	}
	
	public static void quitarEspaciosConsumosServicioss(List<ConsumosServicios> consumosservicioss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ConsumosServicios consumosservicios: consumosservicioss) {
			consumosservicios.setnombre_unidad(consumosservicios.getnombre_unidad().trim());
			consumosservicios.setnombre_producto(consumosservicios.getnombre_producto().trim());
			consumosservicios.setnombre_linea(consumosservicios.getnombre_linea().trim());
			consumosservicios.setnombre_linea_grupo(consumosservicios.getnombre_linea_grupo().trim());
			consumosservicios.setnombre_linea_categoria(consumosservicios.getnombre_linea_categoria().trim());
			consumosservicios.setnombre_linea_marca(consumosservicios.getnombre_linea_marca().trim());
			consumosservicios.setcodigo(consumosservicios.getcodigo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConsumosServicios(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ConsumosServiciosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ConsumosServicios> consumosservicioss,ConsumosServicios consumosservicios,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ConsumosServicios consumosserviciosAux: consumosservicioss) {
			if((consumosserviciosAux.getId()==null && consumosservicios.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(consumosserviciosAux.getId()!=null && consumosservicios.getId()!=null){
				if(consumosserviciosAux.getId().equals(consumosservicios.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConsumosServicios(List<ConsumosServicios> consumosservicioss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
	
		for(ConsumosServicios consumosservicios: consumosservicioss) {			
			totalTotal+=consumosservicios.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsumosServiciosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ConsumosServiciosConstantesFunciones.LABEL_TOTAL);
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