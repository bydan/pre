










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.activosfijos.business.logic.report;

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
import com.bydan.erp.activosfijos.util.report.ConsolidadosDetalleConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;
////import com.bydan.erp.activosfijos.business.interfaces.ConsolidadosDetalleAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ConsolidadosDetalleLogicAdditional extends ConsolidadosDetalleLogic{		
	
	public  ConsolidadosDetalleLogicAdditional(Connexion connexion)throws Exception {
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
	public  ConsolidadosDetalleLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkConsolidadosDetalleToSave(ConsolidadosDetalle consolidadosdetalle,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkConsolidadosDetalleToSave(ConsolidadosDetalle consolidadosdetalle,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkConsolidadosDetalleToSaveAfter(ConsolidadosDetalle consolidadosdetalle,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkConsolidadosDetalleToSaves(List<ConsolidadosDetalle> consolidadosdetalles,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkConsolidadosDetalleToSaves(List<ConsolidadosDetalle> consolidadosdetalles,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkConsolidadosDetalleToSavesAfter(List<ConsolidadosDetalle> consolidadosdetalles,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkConsolidadosDetalleToGet(ConsolidadosDetalle consolidadosdetalle,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkConsolidadosDetalleToGets(List<ConsolidadosDetalle> consolidadosdetalles,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateConsolidadosDetalleToSave(ConsolidadosDetalle consolidadosdetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateConsolidadosDetalleToGet(ConsolidadosDetalle consolidadosdetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectConsolidadosDetalleActions(String sTipoJsonResponse,JSONObject jsonObjectConsolidadosDetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonConsolidadosDetalleDataTable(String sTipoJsonResponse,ConsolidadosDetalle consolidadosdetalle,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonConsolidadosDetallesDataTable(String sTipoJsonResponse,List<ConsolidadosDetalle> consolidadosdetalles,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayConsolidadosDetalleColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayConsolidadosDetallesColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayConsolidadosDetallesColumns;
	}
	
	public static void updateJSONArrayConsolidadosDetalleActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectConsolidadosDetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosConsolidadosDetalle(ConsolidadosDetalle consolidadosdetalle,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		consolidadosdetalle.setnombre_empresa(consolidadosdetalle.getnombre_empresa().trim());
		consolidadosdetalle.setnombre_sucursal(consolidadosdetalle.getnombre_sucursal().trim());
		consolidadosdetalle.setcodigo_sub_grupo(consolidadosdetalle.getcodigo_sub_grupo().trim());
		consolidadosdetalle.setnombre_sub_grupo(consolidadosdetalle.getnombre_sub_grupo().trim());
		consolidadosdetalle.setcodigo_detalle_grupo(consolidadosdetalle.getcodigo_detalle_grupo().trim());
		consolidadosdetalle.setnombre_detalle_grupo(consolidadosdetalle.getnombre_detalle_grupo().trim());
		consolidadosdetalle.setclave(consolidadosdetalle.getclave().trim());
		consolidadosdetalle.setnombre(consolidadosdetalle.getnombre().trim());
	}
	
	public static void quitarEspaciosConsolidadosDetalles(List<ConsolidadosDetalle> consolidadosdetalles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ConsolidadosDetalle consolidadosdetalle: consolidadosdetalles) {
			consolidadosdetalle.setnombre_empresa(consolidadosdetalle.getnombre_empresa().trim());
			consolidadosdetalle.setnombre_sucursal(consolidadosdetalle.getnombre_sucursal().trim());
			consolidadosdetalle.setcodigo_sub_grupo(consolidadosdetalle.getcodigo_sub_grupo().trim());
			consolidadosdetalle.setnombre_sub_grupo(consolidadosdetalle.getnombre_sub_grupo().trim());
			consolidadosdetalle.setcodigo_detalle_grupo(consolidadosdetalle.getcodigo_detalle_grupo().trim());
			consolidadosdetalle.setnombre_detalle_grupo(consolidadosdetalle.getnombre_detalle_grupo().trim());
			consolidadosdetalle.setclave(consolidadosdetalle.getclave().trim());
			consolidadosdetalle.setnombre(consolidadosdetalle.getnombre().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConsolidadosDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ConsolidadosDetalleConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ConsolidadosDetalle> consolidadosdetalles,ConsolidadosDetalle consolidadosdetalle,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ConsolidadosDetalle consolidadosdetalleAux: consolidadosdetalles) {
			if((consolidadosdetalleAux.getId()==null && consolidadosdetalle.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(consolidadosdetalleAux.getId()!=null && consolidadosdetalle.getId()!=null){
				if(consolidadosdetalleAux.getId().equals(consolidadosdetalle.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConsolidadosDetalle(List<ConsolidadosDetalle> consolidadosdetalles) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
	
		for(ConsolidadosDetalle consolidadosdetalle: consolidadosdetalles) {			
			vida_utilTotal+=consolidadosdetalle.getvida_util();
			costo_de_compraTotal+=consolidadosdetalle.getcosto_de_compra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsolidadosDetalleConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsolidadosDetalleConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(ConsolidadosDetalleConstantesFunciones.LABEL_COSTODECOMPRA);
		datoGeneral.setdValorDouble(costo_de_compraTotal);
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