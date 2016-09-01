










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
import com.bydan.erp.activosfijos.util.report.MantenimientoeActivoFijosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.report.*;
////import com.bydan.erp.activosfijos.business.interfaces.MantenimientoeActivoFijosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class MantenimientoeActivoFijosLogicAdditional extends MantenimientoeActivoFijosLogic{		
	
	public  MantenimientoeActivoFijosLogicAdditional(Connexion connexion)throws Exception {
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
	public  MantenimientoeActivoFijosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkMantenimientoeActivoFijosToSave(MantenimientoeActivoFijos mantenimientoeactivofijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkMantenimientoeActivoFijosToSave(MantenimientoeActivoFijos mantenimientoeactivofijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkMantenimientoeActivoFijosToSaveAfter(MantenimientoeActivoFijos mantenimientoeactivofijos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkMantenimientoeActivoFijosToSaves(List<MantenimientoeActivoFijos> mantenimientoeactivofijoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkMantenimientoeActivoFijosToSaves(List<MantenimientoeActivoFijos> mantenimientoeactivofijoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkMantenimientoeActivoFijosToSavesAfter(List<MantenimientoeActivoFijos> mantenimientoeactivofijoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkMantenimientoeActivoFijosToGet(MantenimientoeActivoFijos mantenimientoeactivofijos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkMantenimientoeActivoFijosToGets(List<MantenimientoeActivoFijos> mantenimientoeactivofijoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateMantenimientoeActivoFijosToSave(MantenimientoeActivoFijos mantenimientoeactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateMantenimientoeActivoFijosToGet(MantenimientoeActivoFijos mantenimientoeactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectMantenimientoeActivoFijosActions(String sTipoJsonResponse,JSONObject jsonObjectMantenimientoeActivoFijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonMantenimientoeActivoFijosDataTable(String sTipoJsonResponse,MantenimientoeActivoFijos mantenimientoeactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonMantenimientoeActivoFijossDataTable(String sTipoJsonResponse,List<MantenimientoeActivoFijos> mantenimientoeactivofijoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayMantenimientoeActivoFijosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayMantenimientoeActivoFijossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayMantenimientoeActivoFijossColumns;
	}
	
	public static void updateJSONArrayMantenimientoeActivoFijosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectMantenimientoeActivoFijos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosMantenimientoeActivoFijos(MantenimientoeActivoFijos mantenimientoeactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		mantenimientoeactivofijos.setnumero_documento(mantenimientoeactivofijos.getnumero_documento().trim());
		mantenimientoeactivofijos.setcausa(mantenimientoeactivofijos.getcausa().trim());
		mantenimientoeactivofijos.setreferencia(mantenimientoeactivofijos.getreferencia().trim());
		mantenimientoeactivofijos.settaller(mantenimientoeactivofijos.gettaller().trim());
		mantenimientoeactivofijos.setresponsable(mantenimientoeactivofijos.getresponsable().trim());
		mantenimientoeactivofijos.setobservacion(mantenimientoeactivofijos.getobservacion().trim());
		mantenimientoeactivofijos.settipo_movimiento(mantenimientoeactivofijos.gettipo_movimiento().trim());
		mantenimientoeactivofijos.setclave(mantenimientoeactivofijos.getclave().trim());
		mantenimientoeactivofijos.setnombre(mantenimientoeactivofijos.getnombre().trim());
		mantenimientoeactivofijos.setcodigo_detalle_grupo(mantenimientoeactivofijos.getcodigo_detalle_grupo().trim());
		mantenimientoeactivofijos.setnombre_detalle_grupo(mantenimientoeactivofijos.getnombre_detalle_grupo().trim());
	}
	
	public static void quitarEspaciosMantenimientoeActivoFijoss(List<MantenimientoeActivoFijos> mantenimientoeactivofijoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MantenimientoeActivoFijos mantenimientoeactivofijos: mantenimientoeactivofijoss) {
			mantenimientoeactivofijos.setnumero_documento(mantenimientoeactivofijos.getnumero_documento().trim());
			mantenimientoeactivofijos.setcausa(mantenimientoeactivofijos.getcausa().trim());
			mantenimientoeactivofijos.setreferencia(mantenimientoeactivofijos.getreferencia().trim());
			mantenimientoeactivofijos.settaller(mantenimientoeactivofijos.gettaller().trim());
			mantenimientoeactivofijos.setresponsable(mantenimientoeactivofijos.getresponsable().trim());
			mantenimientoeactivofijos.setobservacion(mantenimientoeactivofijos.getobservacion().trim());
			mantenimientoeactivofijos.settipo_movimiento(mantenimientoeactivofijos.gettipo_movimiento().trim());
			mantenimientoeactivofijos.setclave(mantenimientoeactivofijos.getclave().trim());
			mantenimientoeactivofijos.setnombre(mantenimientoeactivofijos.getnombre().trim());
			mantenimientoeactivofijos.setcodigo_detalle_grupo(mantenimientoeactivofijos.getcodigo_detalle_grupo().trim());
			mantenimientoeactivofijos.setnombre_detalle_grupo(mantenimientoeactivofijos.getnombre_detalle_grupo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMantenimientoeActivoFijos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(MantenimientoeActivoFijosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MantenimientoeActivoFijos> mantenimientoeactivofijoss,MantenimientoeActivoFijos mantenimientoeactivofijos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MantenimientoeActivoFijos mantenimientoeactivofijosAux: mantenimientoeactivofijoss) {
			if((mantenimientoeactivofijosAux.getId()==null && mantenimientoeactivofijos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(mantenimientoeactivofijosAux.getId()!=null && mantenimientoeactivofijos.getId()!=null){
				if(mantenimientoeactivofijosAux.getId().equals(mantenimientoeactivofijos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMantenimientoeActivoFijos(List<MantenimientoeActivoFijos> mantenimientoeactivofijoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
	
		for(MantenimientoeActivoFijos mantenimientoeactivofijos: mantenimientoeactivofijoss) {			
			costoTotal+=mantenimientoeactivofijos.getcosto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MantenimientoeActivoFijosConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(MantenimientoeActivoFijosConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
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