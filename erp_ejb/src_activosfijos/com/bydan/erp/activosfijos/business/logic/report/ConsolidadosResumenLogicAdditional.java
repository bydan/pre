










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
import com.bydan.erp.activosfijos.util.report.ConsolidadosResumenConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;
////import com.bydan.erp.activosfijos.business.interfaces.ConsolidadosResumenAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ConsolidadosResumenLogicAdditional extends ConsolidadosResumenLogic{		
	
	public  ConsolidadosResumenLogicAdditional(Connexion connexion)throws Exception {
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
	public  ConsolidadosResumenLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkConsolidadosResumenToSave(ConsolidadosResumen consolidadosresumen,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkConsolidadosResumenToSave(ConsolidadosResumen consolidadosresumen,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkConsolidadosResumenToSaveAfter(ConsolidadosResumen consolidadosresumen,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkConsolidadosResumenToSaves(List<ConsolidadosResumen> consolidadosresumens,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkConsolidadosResumenToSaves(List<ConsolidadosResumen> consolidadosresumens,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkConsolidadosResumenToSavesAfter(List<ConsolidadosResumen> consolidadosresumens,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkConsolidadosResumenToGet(ConsolidadosResumen consolidadosresumen,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkConsolidadosResumenToGets(List<ConsolidadosResumen> consolidadosresumens,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateConsolidadosResumenToSave(ConsolidadosResumen consolidadosresumen,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateConsolidadosResumenToGet(ConsolidadosResumen consolidadosresumen,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectConsolidadosResumenActions(String sTipoJsonResponse,JSONObject jsonObjectConsolidadosResumen,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonConsolidadosResumenDataTable(String sTipoJsonResponse,ConsolidadosResumen consolidadosresumen,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonConsolidadosResumensDataTable(String sTipoJsonResponse,List<ConsolidadosResumen> consolidadosresumens,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayConsolidadosResumenColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayConsolidadosResumensColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayConsolidadosResumensColumns;
	}
	
	public static void updateJSONArrayConsolidadosResumenActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectConsolidadosResumen,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosConsolidadosResumen(ConsolidadosResumen consolidadosresumen,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		consolidadosresumen.setnombre_empresa(consolidadosresumen.getnombre_empresa().trim());
		consolidadosresumen.setnombre_sucursal(consolidadosresumen.getnombre_sucursal().trim());
		consolidadosresumen.setcodigo_sub_grupo(consolidadosresumen.getcodigo_sub_grupo().trim());
		consolidadosresumen.setnombre_sub_grupo(consolidadosresumen.getnombre_sub_grupo().trim());
		consolidadosresumen.setcodigo_detalle_grupo(consolidadosresumen.getcodigo_detalle_grupo().trim());
		consolidadosresumen.setnombre_detalle_grupo(consolidadosresumen.getnombre_detalle_grupo().trim());
		consolidadosresumen.setclave(consolidadosresumen.getclave().trim());
		consolidadosresumen.setnombre(consolidadosresumen.getnombre().trim());
	}
	
	public static void quitarEspaciosConsolidadosResumens(List<ConsolidadosResumen> consolidadosresumens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ConsolidadosResumen consolidadosresumen: consolidadosresumens) {
			consolidadosresumen.setnombre_empresa(consolidadosresumen.getnombre_empresa().trim());
			consolidadosresumen.setnombre_sucursal(consolidadosresumen.getnombre_sucursal().trim());
			consolidadosresumen.setcodigo_sub_grupo(consolidadosresumen.getcodigo_sub_grupo().trim());
			consolidadosresumen.setnombre_sub_grupo(consolidadosresumen.getnombre_sub_grupo().trim());
			consolidadosresumen.setcodigo_detalle_grupo(consolidadosresumen.getcodigo_detalle_grupo().trim());
			consolidadosresumen.setnombre_detalle_grupo(consolidadosresumen.getnombre_detalle_grupo().trim());
			consolidadosresumen.setclave(consolidadosresumen.getclave().trim());
			consolidadosresumen.setnombre(consolidadosresumen.getnombre().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConsolidadosResumen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ConsolidadosResumenConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ConsolidadosResumen> consolidadosresumens,ConsolidadosResumen consolidadosresumen,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ConsolidadosResumen consolidadosresumenAux: consolidadosresumens) {
			if((consolidadosresumenAux.getId()==null && consolidadosresumen.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(consolidadosresumenAux.getId()!=null && consolidadosresumen.getId()!=null){
				if(consolidadosresumenAux.getId().equals(consolidadosresumen.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConsolidadosResumen(List<ConsolidadosResumen> consolidadosresumens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double vida_utilTotal=0.0;
		Double costo_de_compraTotal=0.0;
	
		for(ConsolidadosResumen consolidadosresumen: consolidadosresumens) {			
			vida_utilTotal+=consolidadosresumen.getvida_util();
			costo_de_compraTotal+=consolidadosresumen.getcosto_de_compra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsolidadosResumenConstantesFunciones.VIDAUTIL);
		datoGeneral.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_VIDAUTIL);
		datoGeneral.setdValorDouble(vida_utilTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsolidadosResumenConstantesFunciones.COSTODECOMPRA);
		datoGeneral.setsDescripcion(ConsolidadosResumenConstantesFunciones.LABEL_COSTODECOMPRA);
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