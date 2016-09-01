














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

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.cartera.util.ReferenciaComercialConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
//import com.bydan.erp.cartera.business.interfaces.ReferenciaComercialAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class ReferenciaComercialLogicAdditional extends ReferenciaComercialLogic { // implements ReferenciaComercialAdditionable{
	public  ReferenciaComercialLogicAdditional(Connexion connexion)throws Exception {
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
	public  ReferenciaComercialLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkReferenciaComercialToSave(ReferenciaComercial referenciacomercial,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkReferenciaComercialToSave(ReferenciaComercial referenciacomercial,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkReferenciaComercialToSaveAfter(ReferenciaComercial referenciacomercial,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkReferenciaComercialToSaves(List<ReferenciaComercial> referenciacomercials,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkReferenciaComercialToSaves(List<ReferenciaComercial> referenciacomercials,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkReferenciaComercialToSavesAfter(List<ReferenciaComercial> referenciacomercials,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkReferenciaComercialToGet(ReferenciaComercial referenciacomercial,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkReferenciaComercialToGets(List<ReferenciaComercial> referenciacomercials,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateReferenciaComercialToSave(ReferenciaComercial referenciacomercial,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateReferenciaComercialToGet(ReferenciaComercial referenciacomercial,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectReferenciaComercialActions(String sTipoJsonResponse,JSONObject jsonObjectReferenciaComercial,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonReferenciaComercialDataTable(String sTipoJsonResponse,ReferenciaComercial referenciacomercial,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonReferenciaComercialsDataTable(String sTipoJsonResponse,List<ReferenciaComercial> referenciacomercials,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayReferenciaComercialColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayReferenciaComercialsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayReferenciaComercialsColumns;
	}
	
	public static void updateJSONArrayReferenciaComercialActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectReferenciaComercial,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosReferenciaComercial(ReferenciaComercial referenciacomercial,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		referenciacomercial.setnombreempresa(referenciacomercial.getnombreempresa().trim());
		referenciacomercial.setdireccion(referenciacomercial.getdireccion().trim());
		referenciacomercial.settelefono(referenciacomercial.gettelefono().trim());
		referenciacomercial.settelefonomovil(referenciacomercial.gettelefonomovil().trim());
		referenciacomercial.settelefonocodigoarea(referenciacomercial.gettelefonocodigoarea().trim());
		referenciacomercial.setemail(referenciacomercial.getemail().trim());
	}
	
	public static void quitarEspaciosReferenciaComercials(List<ReferenciaComercial> referenciacomercials,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ReferenciaComercial referenciacomercial: referenciacomercials) {
			referenciacomercial.setnombreempresa(referenciacomercial.getnombreempresa().trim());
			referenciacomercial.setdireccion(referenciacomercial.getdireccion().trim());
			referenciacomercial.settelefono(referenciacomercial.gettelefono().trim());
			referenciacomercial.settelefonomovil(referenciacomercial.gettelefonomovil().trim());
			referenciacomercial.settelefonocodigoarea(referenciacomercial.gettelefonocodigoarea().trim());
			referenciacomercial.setemail(referenciacomercial.getemail().trim());
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesReferenciaComercial(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
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