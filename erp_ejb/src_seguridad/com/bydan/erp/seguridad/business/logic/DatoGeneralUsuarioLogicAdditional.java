













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
package com.bydan.erp.seguridad.business.logic;

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
import com.bydan.erp.seguridad.util.DatoGeneralUsuarioConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;
//import com.bydan.erp.seguridad.business.interfaces.DatoGeneralUsuarioAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DatoGeneralUsuarioLogicAdditional extends DatoGeneralUsuarioLogic { // implements DatoGeneralUsuarioAdditionable{
	public  DatoGeneralUsuarioLogicAdditional(Connexion connexion)throws Exception {
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
	public  DatoGeneralUsuarioLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDatoGeneralUsuarioToSave(DatoGeneralUsuario datogeneralusuario,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDatoGeneralUsuarioToSave(DatoGeneralUsuario datogeneralusuario,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDatoGeneralUsuarioToSaveAfter(DatoGeneralUsuario datogeneralusuario,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDatoGeneralUsuarioToSaves(List<DatoGeneralUsuario> datogeneralusuarios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDatoGeneralUsuarioToSaves(List<DatoGeneralUsuario> datogeneralusuarios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDatoGeneralUsuarioToSavesAfter(List<DatoGeneralUsuario> datogeneralusuarios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDatoGeneralUsuarioToGet(DatoGeneralUsuario datogeneralusuario,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDatoGeneralUsuarioToGets(List<DatoGeneralUsuario> datogeneralusuarios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDatoGeneralUsuarioToSave(DatoGeneralUsuario datogeneralusuario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDatoGeneralUsuarioToGet(DatoGeneralUsuario datogeneralusuario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDatoGeneralUsuarioActions(String sTipoJsonResponse,JSONObject jsonObjectDatoGeneralUsuario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDatoGeneralUsuarioDataTable(String sTipoJsonResponse,DatoGeneralUsuario datogeneralusuario,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDatoGeneralUsuariosDataTable(String sTipoJsonResponse,List<DatoGeneralUsuario> datogeneralusuarios,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDatoGeneralUsuarioColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDatoGeneralUsuariosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDatoGeneralUsuariosColumns;
	}
	
	public static void updateJSONArrayDatoGeneralUsuarioActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDatoGeneralUsuario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDatoGeneralUsuario(DatoGeneralUsuario datogeneralusuario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		datogeneralusuario.setcedula(datogeneralusuario.getcedula().trim());
		datogeneralusuario.setapellidos(datogeneralusuario.getapellidos().trim());
		datogeneralusuario.setnombres(datogeneralusuario.getnombres().trim());
		datogeneralusuario.settelefono(datogeneralusuario.gettelefono().trim());
		datogeneralusuario.settelefono_movil(datogeneralusuario.gettelefono_movil().trim());
		datogeneralusuario.sete_mail(datogeneralusuario.gete_mail().trim());
		datogeneralusuario.seturl(datogeneralusuario.geturl().trim());
		datogeneralusuario.setdireccion(datogeneralusuario.getdireccion().trim());
	}
	
	public static void quitarEspaciosDatoGeneralUsuarios(List<DatoGeneralUsuario> datogeneralusuarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DatoGeneralUsuario datogeneralusuario: datogeneralusuarios) {
			datogeneralusuario.setcedula(datogeneralusuario.getcedula().trim());
			datogeneralusuario.setapellidos(datogeneralusuario.getapellidos().trim());
			datogeneralusuario.setnombres(datogeneralusuario.getnombres().trim());
			datogeneralusuario.settelefono(datogeneralusuario.gettelefono().trim());
			datogeneralusuario.settelefono_movil(datogeneralusuario.gettelefono_movil().trim());
			datogeneralusuario.sete_mail(datogeneralusuario.gete_mail().trim());
			datogeneralusuario.seturl(datogeneralusuario.geturl().trim());
			datogeneralusuario.setdireccion(datogeneralusuario.getdireccion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDatoGeneralUsuario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
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