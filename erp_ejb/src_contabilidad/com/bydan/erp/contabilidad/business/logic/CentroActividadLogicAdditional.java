













/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.contabilidad.business.logic;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;


import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.contabilidad.util.CentroActividadConstantesFunciones;
import com.bydan.erp.contabilidad.util.CentroActividadParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.CentroActividadReturnGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.contabilidad.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class CentroActividadLogicAdditional extends CentroActividadLogic { // implements CentroActividadAdditionable{
	
	public  CentroActividadLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19

			CentroActividadLogic centroActividadLogic=(CentroActividadLogic)generalEntityLogic;
			CentroActividadParameterReturnGeneral centroActividadReturnGeneral=(CentroActividadParameterReturnGeneral)generalEntityReturnGeneral;
			
			ParametroContabilidadDefecto parametroContabilidadDefecto=new ParametroContabilidadDefecto();
			ParametroContabilidadDefectoLogic parametroContabilidadDefectoLogic=new ParametroContabilidadDefectoLogic();						
			
			parametroContabilidadDefectoLogic.setConnexion(generalEntityLogic.getConnexion());
			
			
			String sFinalQuery="";
			
			if(controlTipo.equals(ControlTipo.FORM) && eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW)) {
				sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_sucursal="+parametroGeneralUsuario.getid_sucursal();
				
				parametroContabilidadDefectoLogic.getEntity(sFinalQuery);
				
				parametroContabilidadDefecto=parametroContabilidadDefectoLogic.getParametroContabilidadDefecto();
				
				if(parametroContabilidadDefecto!=null && parametroContabilidadDefecto.getId()>0) {
					centroActividadReturnGeneral.getCentroActividad().setid_tipo_movimiento(parametroContabilidadDefecto.getid_tipo_movimiento());
					
					/*
					centroActividadReturnGeneral.getCentroActividad().setid_grupo_centroActividad(parametroContabilidadDefecto.getid_grupo_centroActividad());										
					centroActividadReturnGeneral.getCentroActividad().setid_pais(parametroContabilidadDefecto.getid_pais());
					centroActividadReturnGeneral.getCentroActividad().setid_ciudad(parametroContabilidadDefecto.getid_ciudad());					
					centroActividadReturnGeneral.getCentroActividad().setid_calidad_centroActividad(parametroContabilidadDefecto.getid_calidad_centroActividad());																				
					centroActividadReturnGeneral.getCentroActividad().setid_tipo_identificacion(parametroContabilidadDefecto.getid_tipo_identificacion());
					centroActividadReturnGeneral.getCentroActividad().setid_pais_nacionalidad(parametroContabilidadDefecto.getid_pais_nacionalidad());
					centroActividadReturnGeneral.getCentroActividad().setid_estado_civil(parametroContabilidadDefecto.getid_estado_civil());
					*/
				} else {
					throw new Exception("DEBE CONFIGURAR PARAMETRO DEFECTOS");
				}
			}
			
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
	public  CentroActividadLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCentroActividadToSave(CentroActividad centroactividad,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCentroActividadToSave(CentroActividad centroactividad,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCentroActividadToSaveAfter(CentroActividad centroactividad,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCentroActividadToSaves(List<CentroActividad> centroactividads,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCentroActividadToSaves(List<CentroActividad> centroactividads,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCentroActividadToSavesAfter(List<CentroActividad> centroactividads,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCentroActividadToGet(CentroActividad centroactividad,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCentroActividadToGets(List<CentroActividad> centroactividads,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCentroActividadToSave(CentroActividad centroactividad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCentroActividadToGet(CentroActividad centroactividad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCentroActividadActions(String sTipoJsonResponse,JSONObject jsonObjectCentroActividad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCentroActividadDataTable(String sTipoJsonResponse,CentroActividad centroactividad,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCentroActividadsDataTable(String sTipoJsonResponse,List<CentroActividad> centroactividads,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCentroActividadColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCentroActividadsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCentroActividadsColumns;
	}
	
	public static void updateJSONArrayCentroActividadActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCentroActividad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCentroActividad(CentroActividad centroactividad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		centroactividad.setcodigo(centroactividad.getcodigo().trim());
		centroactividad.setnombre(centroactividad.getnombre().trim());
		centroactividad.setobservacion(centroactividad.getobservacion().trim());
	}
	
	public static void quitarEspaciosCentroActividads(List<CentroActividad> centroactividads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CentroActividad centroactividad: centroactividads) {
			centroactividad.setcodigo(centroactividad.getcodigo().trim());
			centroactividad.setnombre(centroactividad.getnombre().trim());
			centroactividad.setobservacion(centroactividad.getobservacion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCentroActividad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CentroActividad> centroactividads,CentroActividad centroactividad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CentroActividad centroactividadAux: centroactividads) {
			if((centroactividadAux.getId()==null && centroactividad.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(centroactividadAux.getId()!=null && centroactividad.getId()!=null){
				if(centroactividadAux.getId().equals(centroactividad.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCentroActividad(List<CentroActividad> centroactividads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CentroActividad centroactividad: centroactividads) {			
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