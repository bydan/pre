













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
import com.bydan.erp.contabilidad.util.MonedaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.MonedaReturnGeneral;
import com.bydan.erp.contabilidad.util.MonedaConstantesFunciones;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.contabilidad.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class MonedaLogicAdditional extends MonedaLogic { // implements MonedaAdditionable{
	
	public  MonedaLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19
			MonedaLogic monedaLogic=(MonedaLogic)generalEntityLogic;
			MonedaParameterReturnGeneral monedaReturnGeneral=(MonedaParameterReturnGeneral)generalEntityReturnGeneral;
			
			ParametroContabilidadDefecto parametroContabilidadDefecto=new ParametroContabilidadDefecto();
			ParametroContabilidadDefectoLogic parametroContabilidadDefectoLogic=new ParametroContabilidadDefectoLogic();						
			
			parametroContabilidadDefectoLogic.setConnexion(generalEntityLogic.getConnexion());
			
			
			String sFinalQuery="";
			
			if(controlTipo.equals(ControlTipo.FORM) && eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW)) {
				sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_sucursal="+parametroGeneralUsuario.getid_sucursal();
				
				parametroContabilidadDefectoLogic.getEntity(sFinalQuery);
				
				parametroContabilidadDefecto=parametroContabilidadDefectoLogic.getParametroContabilidadDefecto();
				
				if(parametroContabilidadDefecto!=null && parametroContabilidadDefecto.getId()>0) {
					//YA NO TIENE ESTE CAMPO 
					//monedaReturnGeneral.getMoneda().setid_tipo_moneda(parametroContabilidadDefecto.getid_tipo_moneda());
					
					
					/*
					monedaReturnGeneral.getMoneda().setid_grupo_moneda(parametroContabilidadDefecto.getid_grupo_moneda());										
					monedaReturnGeneral.getMoneda().setid_pais(parametroContabilidadDefecto.getid_pais());
					monedaReturnGeneral.getMoneda().setid_ciudad(parametroContabilidadDefecto.getid_ciudad());					
					monedaReturnGeneral.getMoneda().setid_calidad_moneda(parametroContabilidadDefecto.getid_calidad_moneda());																				
					monedaReturnGeneral.getMoneda().setid_tipo_identificacion(parametroContabilidadDefecto.getid_tipo_identificacion());
					monedaReturnGeneral.getMoneda().setid_pais_nacionalidad(parametroContabilidadDefecto.getid_pais_nacionalidad());
					monedaReturnGeneral.getMoneda().setid_estado_civil(parametroContabilidadDefecto.getid_estado_civil());
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
	public  MonedaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkMonedaToSave(Moneda moneda,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkMonedaToSave(Moneda moneda,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkMonedaToSaveAfter(Moneda moneda,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkMonedaToSaves(List<Moneda> monedas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkMonedaToSaves(List<Moneda> monedas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkMonedaToSavesAfter(List<Moneda> monedas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkMonedaToGet(Moneda moneda,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkMonedaToGets(List<Moneda> monedas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateMonedaToSave(Moneda moneda,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateMonedaToGet(Moneda moneda,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectMonedaActions(String sTipoJsonResponse,JSONObject jsonObjectMoneda,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonMonedaDataTable(String sTipoJsonResponse,Moneda moneda,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonMonedasDataTable(String sTipoJsonResponse,List<Moneda> monedas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayMonedaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayMonedasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayMonedasColumns;
	}
	
	public static void updateJSONArrayMonedaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectMoneda,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosMoneda(Moneda moneda,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		moneda.setnombre(moneda.getnombre().trim());
		moneda.setsigla(moneda.getsigla().trim());
		moneda.setsimbolo(moneda.getsimbolo().trim());
	}
	
	public static void quitarEspaciosMonedas(List<Moneda> monedas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Moneda moneda: monedas) {
			moneda.setnombre(moneda.getnombre().trim());
			moneda.setsigla(moneda.getsigla().trim());
			moneda.setsimbolo(moneda.getsimbolo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMoneda(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Moneda> monedas,Moneda moneda,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Moneda monedaAux: monedas) {
			if((monedaAux.getId()==null && moneda.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(monedaAux.getId()!=null && moneda.getId()!=null){
				if(monedaAux.getId().equals(moneda.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMoneda(List<Moneda> monedas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Moneda moneda: monedas) {			
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