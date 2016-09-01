














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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.facturacion.util.ResponsableConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
//import com.bydan.erp.facturacion.business.interfaces.ResponsableAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class ResponsableLogicAdditional extends ResponsableLogic { // implements ResponsableAdditionable{
	public  ResponsableLogicAdditional(Connexion connexion)throws Exception {
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
	public  ResponsableLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkResponsableToSave(Responsable responsable,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkResponsableToSave(Responsable responsable,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkResponsableToSaveAfter(Responsable responsable,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkResponsableToSaves(List<Responsable> responsables,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkResponsableToSaves(List<Responsable> responsables,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkResponsableToSavesAfter(List<Responsable> responsables,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkResponsableToGet(Responsable responsable,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkResponsableToGets(List<Responsable> responsables,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateResponsableToSave(Responsable responsable,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception {	
		//CONTROL_9
		responsable.setnombre_completo(responsable.getapellido()+" "+responsable.getnombre());
	}		
						
	public static void updateResponsableToGet(Responsable responsable,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectResponsableActions(String sTipoJsonResponse,JSONObject jsonObjectResponsable,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonResponsableDataTable(String sTipoJsonResponse,Responsable responsable,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonResponsablesDataTable(String sTipoJsonResponse,List<Responsable> responsables,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayResponsableColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayResponsablesColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayResponsablesColumns;
	}
	
	public static void updateJSONArrayResponsableActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectResponsable,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosResponsable(Responsable responsable,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		responsable.setidentificacion(responsable.getidentificacion().trim());
		responsable.setnombre(responsable.getnombre().trim());
		responsable.setapellido(responsable.getapellido().trim());
		responsable.setruc(responsable.getruc().trim());
		responsable.setdireccion(responsable.getdireccion().trim());
		responsable.setemail(responsable.getemail().trim());
		responsable.settelefono(responsable.gettelefono().trim());
		responsable.settelefono_celular(responsable.gettelefono_celular().trim());
		responsable.setfax(responsable.getfax().trim());
		responsable.setobservacion(responsable.getobservacion().trim());
	}
	
	public static void quitarEspaciosResponsables(List<Responsable> responsables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Responsable responsable: responsables) {
			responsable.setidentificacion(responsable.getidentificacion().trim());
			responsable.setnombre(responsable.getnombre().trim());
			responsable.setapellido(responsable.getapellido().trim());
			responsable.setruc(responsable.getruc().trim());
			responsable.setdireccion(responsable.getdireccion().trim());
			responsable.setemail(responsable.getemail().trim());
			responsable.settelefono(responsable.gettelefono().trim());
			responsable.settelefono_celular(responsable.gettelefono_celular().trim());
			responsable.setfax(responsable.getfax().trim());
			responsable.setobservacion(responsable.getobservacion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesResponsable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ResponsableConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ResponsableConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(ResponsableConstantesFunciones.IDUSUARIO);
		
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