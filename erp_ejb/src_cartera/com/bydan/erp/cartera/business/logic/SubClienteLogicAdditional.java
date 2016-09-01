














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
package com.bydan.erp.cartera.business.logic;

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
//import com.bydan.erp.cartera.util.ClienteReturnGeneral;
import com.bydan.erp.cartera.util.SubClienteConstantesFunciones;
import com.bydan.erp.cartera.util.SubClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.SubClienteReturnGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.cartera.business.entity.*;
//import com.bydan.erp.cartera.business.interfaces.SubClienteAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class SubClienteLogicAdditional extends SubClienteLogic { // implements SubClienteAdditionable{
	public  SubClienteLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19
			SubClienteLogic subClienteLogic=(SubClienteLogic)generalEntityLogic;
			SubClienteParameterReturnGeneral subClienteReturnGeneral=(SubClienteParameterReturnGeneral)generalEntityReturnGeneral;
			
			ParametroCarteraDefecto parametroCarteraDefecto=new ParametroCarteraDefecto();
			ParametroCarteraDefectoLogic parametroCarteraDefectoLogic=new ParametroCarteraDefectoLogic();						
			
			parametroCarteraDefectoLogic.setConnexion(generalEntityLogic.getConnexion());
			
			
			String sFinalQuery="";
			
			if(controlTipo.equals(ControlTipo.FORM) && eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW)) {
				sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_sucursal="+parametroGeneralUsuario.getid_sucursal();
				
				parametroCarteraDefectoLogic.getEntity(sFinalQuery);
				
				parametroCarteraDefecto=parametroCarteraDefectoLogic.getParametroCarteraDefecto();
				
				if(parametroCarteraDefecto!=null && parametroCarteraDefecto.getId()>0) {
					subClienteReturnGeneral.getSubCliente().setid_tipo_identificacion(parametroCarteraDefecto.getid_tipo_identificacion());
					subClienteReturnGeneral.getSubCliente().setid_pais(parametroCarteraDefecto.getid_pais());
					subClienteReturnGeneral.getSubCliente().setid_ciudad(parametroCarteraDefecto.getid_ciudad());
					subClienteReturnGeneral.getSubCliente().setid_zona(parametroCarteraDefecto.getid_zona());
					subClienteReturnGeneral.getSubCliente().setid_pais_nacionalidad(parametroCarteraDefecto.getid_pais_nacionalidad());
					subClienteReturnGeneral.getSubCliente().setid_estado_civil(parametroCarteraDefecto.getid_estado_civil());
					subClienteReturnGeneral.getSubCliente().setid_tipo_genero(parametroCarteraDefecto.getid_tipo_genero());
					subClienteReturnGeneral.getSubCliente().setid_cuenta_contable(parametroCarteraDefecto.getid_cuenta_contable());
					subClienteReturnGeneral.getSubCliente().setid_tipo_nivel_edu(parametroCarteraDefecto.getid_tipo_nivel_edu());
					subClienteReturnGeneral.getSubCliente().setid_estado_legal(parametroCarteraDefecto.getid_estado_legal());
					
					/*										
					subClienteReturnGeneral.getSubCliente().setid_region(parametroCarteraDefecto.getid_region());
					subClienteReturnGeneral.getSubCliente().setid_provincia(parametroCarteraDefecto.getid_provincia());
					subClienteReturnGeneral.getSubCliente().setid_ruta(parametroCarteraDefecto.getid_ruta());
					subClienteReturnGeneral.getSubCliente().setid_vendedor(parametroCarteraDefecto.getid_vendedor());					
					subClienteReturnGeneral.getSubCliente().setid_dia(parametroCarteraDefecto.getid_dia());
					subClienteReturnGeneral.getSubCliente().setid_tipo_precio(parametroCarteraDefecto.getid_tipo_precio());
					subClienteReturnGeneral.getSubCliente().setid_tipo_lista_precio(parametroCarteraDefecto.getid_tipo_lista_precio());					
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
	public  SubClienteLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkSubClienteToSave(SubCliente subcliente,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkSubClienteToSave(SubCliente subcliente,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkSubClienteToSaveAfter(SubCliente subcliente,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkSubClienteToSaves(List<SubCliente> subclientes,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkSubClienteToSaves(List<SubCliente> subclientes,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkSubClienteToSavesAfter(List<SubCliente> subclientes,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkSubClienteToGet(SubCliente subcliente,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkSubClienteToGets(List<SubCliente> subclientes,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateSubClienteToSave(SubCliente subcliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception {	
		//CONTROL_9
		
		subcliente.setnombre_completo(subcliente.getapellido()+" "+subcliente.getnombre());
	}		
						
	public static void updateSubClienteToGet(SubCliente subcliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectSubClienteActions(String sTipoJsonResponse,JSONObject jsonObjectSubCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonSubClienteDataTable(String sTipoJsonResponse,SubCliente subcliente,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonSubClientesDataTable(String sTipoJsonResponse,List<SubCliente> subclientes,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArraySubClienteColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArraySubClientesColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArraySubClientesColumns;
	}
	
	public static void updateJSONArraySubClienteActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectSubCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosSubCliente(SubCliente subcliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		subcliente.setidentificacion(subcliente.getidentificacion().trim());
		subcliente.setnombre(subcliente.getnombre().trim());
		subcliente.setapellido(subcliente.getapellido().trim());
		subcliente.setdireccion(subcliente.getdireccion().trim());
		subcliente.settelefono(subcliente.gettelefono().trim());
		subcliente.setnumero_celular(subcliente.getnumero_celular().trim());
		subcliente.setmail(subcliente.getmail().trim());
		subcliente.setruc(subcliente.getruc().trim());
		subcliente.setpath_imagen_firma(subcliente.getpath_imagen_firma().trim());
		subcliente.setcodigo_contrato(subcliente.getcodigo_contrato().trim());
		subcliente.setobservacion(subcliente.getobservacion().trim());
	}
	
	public static void quitarEspaciosSubClientes(List<SubCliente> subclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SubCliente subcliente: subclientes) {
			subcliente.setidentificacion(subcliente.getidentificacion().trim());
			subcliente.setnombre(subcliente.getnombre().trim());
			subcliente.setapellido(subcliente.getapellido().trim());
			subcliente.setdireccion(subcliente.getdireccion().trim());
			subcliente.settelefono(subcliente.gettelefono().trim());
			subcliente.setnumero_celular(subcliente.getnumero_celular().trim());
			subcliente.setmail(subcliente.getmail().trim());
			subcliente.setruc(subcliente.getruc().trim());
			subcliente.setpath_imagen_firma(subcliente.getpath_imagen_firma().trim());
			subcliente.setcodigo_contrato(subcliente.getcodigo_contrato().trim());
			subcliente.setobservacion(subcliente.getobservacion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSubCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(SubClienteConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(SubClienteConstantesFunciones.IDSUCURSAL);
		
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