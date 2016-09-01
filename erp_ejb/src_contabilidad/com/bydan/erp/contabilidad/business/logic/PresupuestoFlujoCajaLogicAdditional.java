














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

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.contabilidad.util.PresupuestoFlujoCajaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
//import com.bydan.erp.contabilidad.business.interfaces.PresupuestoFlujoCajaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class PresupuestoFlujoCajaLogicAdditional extends PresupuestoFlujoCajaLogic { // implements PresupuestoFlujoCajaAdditionable{
	public  PresupuestoFlujoCajaLogicAdditional(Connexion connexion)throws Exception {
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
	public  PresupuestoFlujoCajaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkPresupuestoFlujoCajaToSave(PresupuestoFlujoCaja presupuestoflujocaja,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkPresupuestoFlujoCajaToSave(PresupuestoFlujoCaja presupuestoflujocaja,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkPresupuestoFlujoCajaToSaveAfter(PresupuestoFlujoCaja presupuestoflujocaja,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkPresupuestoFlujoCajaToSaves(List<PresupuestoFlujoCaja> presupuestoflujocajas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkPresupuestoFlujoCajaToSaves(List<PresupuestoFlujoCaja> presupuestoflujocajas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkPresupuestoFlujoCajaToSavesAfter(List<PresupuestoFlujoCaja> presupuestoflujocajas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkPresupuestoFlujoCajaToGet(PresupuestoFlujoCaja presupuestoflujocaja,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkPresupuestoFlujoCajaToGets(List<PresupuestoFlujoCaja> presupuestoflujocajas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updatePresupuestoFlujoCajaToSave(PresupuestoFlujoCaja presupuestoflujocaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updatePresupuestoFlujoCajaToGet(PresupuestoFlujoCaja presupuestoflujocaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectPresupuestoFlujoCajaActions(String sTipoJsonResponse,JSONObject jsonObjectPresupuestoFlujoCaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonPresupuestoFlujoCajaDataTable(String sTipoJsonResponse,PresupuestoFlujoCaja presupuestoflujocaja,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonPresupuestoFlujoCajasDataTable(String sTipoJsonResponse,List<PresupuestoFlujoCaja> presupuestoflujocajas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayPresupuestoFlujoCajaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayPresupuestoFlujoCajasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayPresupuestoFlujoCajasColumns;
	}
	
	public static void updateJSONArrayPresupuestoFlujoCajaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectPresupuestoFlujoCaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosPresupuestoFlujoCaja(PresupuestoFlujoCaja presupuestoflujocaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		presupuestoflujocaja.setobservacion(presupuestoflujocaja.getobservacion().trim());
	}
	
	public static void quitarEspaciosPresupuestoFlujoCajas(List<PresupuestoFlujoCaja> presupuestoflujocajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresupuestoFlujoCaja presupuestoflujocaja: presupuestoflujocajas) {
			presupuestoflujocaja.setobservacion(presupuestoflujocaja.getobservacion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestoFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PresupuestoFlujoCajaConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(PresupuestoFlujoCajaConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(PresupuestoFlujoCajaConstantesFunciones.IDPERIODO);
		
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