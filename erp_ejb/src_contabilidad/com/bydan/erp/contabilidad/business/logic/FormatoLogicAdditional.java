














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


import com.bydan.framework.erp.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.Connexion;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.contabilidad.util.FormatoConstantesFunciones;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.contabilidad.business.entity.*;
//import com.bydan.erp.contabilidad.business.interfaces.FormatoAdditionable;
import com.bydan.erp.inventario.util.InventarioSql;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class FormatoLogicAdditional extends FormatoLogic { // implements FormatoAdditionable{
	public  FormatoLogicAdditional(Connexion connexion)throws Exception {
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
	public  FormatoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkFormatoToSave(Formato formato,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkFormatoToSave(Formato formato,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkFormatoToSaveAfter(Formato formato,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkFormatoToSaves(List<Formato> formatos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkFormatoToSaves(List<Formato> formatos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkFormatoToSavesAfter(List<Formato> formatos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkFormatoToGet(Formato formato,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkFormatoToGets(List<Formato> formatos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateFormatoToSave(Formato formato,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateFormatoToGet(Formato formato,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectFormatoActions(String sTipoJsonResponse,JSONObject jsonObjectFormato,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonFormatoDataTable(String sTipoJsonResponse,Formato formato,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonFormatosDataTable(String sTipoJsonResponse,List<Formato> formatos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayFormatoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayFormatosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayFormatosColumns;
	}
	
	public static void updateJSONArrayFormatoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectFormato,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosFormato(Formato formato,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		formato.setnombre(formato.getnombre().trim());
		formato.setubicacion(formato.getubicacion().trim());
	}
	
	public static void quitarEspaciosFormatos(List<Formato> formatos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Formato formato: formatos) {
			formato.setnombre(formato.getnombre().trim());
			formato.setubicacion(formato.getubicacion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFormato(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(FormatoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(FormatoConstantesFunciones.IDMODULO);
		
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
	
	public static Long TraerIdFormato(Connexion connexionP,Long id_empresa,String sTipo) throws Exception {
		 //TRANSACCON COMPRA	
		 FormatoLogic formatoLogic=new FormatoLogic();
		
		 Long id_formato=0L;
		 
		 String sFinalQueryFormato="";
		 
		 formatoLogic.setConnexion(connexionP);
		 
		 sFinalQueryFormato=InventarioSql.GetFormatoSqlWhere(id_empresa,sTipo);
			
		 formatoLogic.getEntity(sFinalQueryFormato);
			
			
		 if(formatoLogic.getFormato()!=null && formatoLogic.getFormato().getId()>0) {
			//movimientoinventario.setid_formato(formatoLogic.getFormato().getId());
			 id_formato=formatoLogic.getFormato().getId();
			 
		 } else {
			throw new Exception("Formato de "+sTipo+" No Definida");
		 }
		 //TRANSACCON COMPRA-FIN 
		 
		 return id_formato;
	}
}