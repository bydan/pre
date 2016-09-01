














/*
* ============================================================================
* GNU Lesser General Public License
* ============================================================================
*
* BYDAN - Free Java BYDAN library.
* Copyright (C) 2008 
* 
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.
* 
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* Lesser General Public License for more details.
* 
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
* 
* BYDAN Corporation
*/
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.inventario.util.ServicioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ServicioReturnGeneral;
import com.bydan.erp.inventario.util.ServicioConstantesFunciones;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.business.entity.*;
//import com.bydan.erp.inventario.business.interfaces.ServicioAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class ServicioLogicAdditional extends ServicioLogic { // implements ServicioAdditionable{
	public  ServicioLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19
			ServicioLogic servicioLogic=(ServicioLogic)generalEntityLogic;
			ServicioParameterReturnGeneral servicioReturnGeneral=(ServicioParameterReturnGeneral)generalEntityReturnGeneral;
			
			ParametroInventarioDefecto parametroInventarioDefecto=new ParametroInventarioDefecto();
			ParametroInventarioDefectoLogic parametroInventarioDefectoLogic=new ParametroInventarioDefectoLogic();						
			
			parametroInventarioDefectoLogic.setConnexion(generalEntityLogic.getConnexion());
			
			
			String sFinalQuery="";
			
			if(controlTipo.equals(ControlTipo.FORM) && eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW)) {
				sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_sucursal="+parametroGeneralUsuario.getid_sucursal();
				
				parametroInventarioDefectoLogic.getEntity(sFinalQuery);
				
				parametroInventarioDefecto=parametroInventarioDefectoLogic.getParametroInventarioDefecto();
				
				if(parametroInventarioDefecto!=null && parametroInventarioDefecto.getId()>0) {
					servicioReturnGeneral.getServicio().setid_tipo_servicio(parametroInventarioDefecto.getid_tipo_servicio());
					
					/*
					servicioReturnGeneral.getServicio().setid_grupo_servicio(parametroInventarioDefecto.getid_grupo_servicio());										
					servicioReturnGeneral.getServicio().setid_pais(parametroInventarioDefecto.getid_pais());
					servicioReturnGeneral.getServicio().setid_ciudad(parametroInventarioDefecto.getid_ciudad());					
					servicioReturnGeneral.getServicio().setid_calidad_producto(parametroInventarioDefecto.getid_calidad_producto());																				
					servicioReturnGeneral.getServicio().setid_tipo_identificacion(parametroInventarioDefecto.getid_tipo_identificacion());
					servicioReturnGeneral.getServicio().setid_pais_nacionalidad(parametroInventarioDefecto.getid_pais_nacionalidad());
					servicioReturnGeneral.getServicio().setid_estado_civil(parametroInventarioDefecto.getid_estado_civil());
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
	public  ServicioLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkServicioToSave(Servicio servicio,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkServicioToSave(Servicio servicio,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkServicioToSaveAfter(Servicio servicio,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkServicioToSaves(List<Servicio> servicios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkServicioToSaves(List<Servicio> servicios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkServicioToSavesAfter(List<Servicio> servicios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkServicioToGet(Servicio servicio,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkServicioToGets(List<Servicio> servicios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateServicioToSave(Servicio servicio,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateServicioToGet(Servicio servicio,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectServicioActions(String sTipoJsonResponse,JSONObject jsonObjectServicio,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonServicioDataTable(String sTipoJsonResponse,Servicio servicio,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonServiciosDataTable(String sTipoJsonResponse,List<Servicio> servicios,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayServicioColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayServiciosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayServiciosColumns;
	}
	
	public static void updateJSONArrayServicioActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectServicio,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosServicio(Servicio servicio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		servicio.setcodigo(servicio.getcodigo().trim());
		servicio.setnombre(servicio.getnombre().trim());
		servicio.setdescripcion(servicio.getdescripcion().trim());
	}
	
	public static void quitarEspaciosServicios(List<Servicio> servicios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Servicio servicio: servicios) {
			servicio.setcodigo(servicio.getcodigo().trim());
			servicio.setnombre(servicio.getnombre().trim());
			servicio.setdescripcion(servicio.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesServicio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ServicioConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
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