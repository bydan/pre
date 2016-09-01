














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
import com.bydan.erp.contabilidad.util.DetalleAsientoContableCajaChicaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
//import com.bydan.erp.contabilidad.business.interfaces.DetalleAsientoContableCajaChicaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DetalleAsientoContableCajaChicaLogicAdditional extends DetalleAsientoContableCajaChicaLogic { // implements DetalleAsientoContableCajaChicaAdditionable{
	public  DetalleAsientoContableCajaChicaLogicAdditional(Connexion connexion)throws Exception {
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
	public  DetalleAsientoContableCajaChicaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetalleAsientoContableCajaChicaToSave(DetalleAsientoContableCajaChica detalleasientocontablecajachica,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetalleAsientoContableCajaChicaToSave(DetalleAsientoContableCajaChica detalleasientocontablecajachica,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetalleAsientoContableCajaChicaToSaveAfter(DetalleAsientoContableCajaChica detalleasientocontablecajachica,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetalleAsientoContableCajaChicaToSaves(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetalleAsientoContableCajaChicaToSaves(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetalleAsientoContableCajaChicaToSavesAfter(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetalleAsientoContableCajaChicaToGet(DetalleAsientoContableCajaChica detalleasientocontablecajachica,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetalleAsientoContableCajaChicaToGets(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetalleAsientoContableCajaChicaToSave(DetalleAsientoContableCajaChica detalleasientocontablecajachica,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetalleAsientoContableCajaChicaToGet(DetalleAsientoContableCajaChica detalleasientocontablecajachica,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetalleAsientoContableCajaChicaActions(String sTipoJsonResponse,JSONObject jsonObjectDetalleAsientoContableCajaChica,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetalleAsientoContableCajaChicaDataTable(String sTipoJsonResponse,DetalleAsientoContableCajaChica detalleasientocontablecajachica,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetalleAsientoContableCajaChicasDataTable(String sTipoJsonResponse,List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetalleAsientoContableCajaChicaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetalleAsientoContableCajaChicasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetalleAsientoContableCajaChicasColumns;
	}
	
	public static void updateJSONArrayDetalleAsientoContableCajaChicaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetalleAsientoContableCajaChica,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetalleAsientoContableCajaChica(DetalleAsientoContableCajaChica detalleasientocontablecajachica,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleasientocontablecajachica.setdetalle(detalleasientocontablecajachica.getdetalle().trim());
	}
	
	public static void quitarEspaciosDetalleAsientoContableCajaChicas(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleAsientoContableCajaChica detalleasientocontablecajachica: detalleasientocontablecajachicas) {
			detalleasientocontablecajachica.setdetalle(detalleasientocontablecajachica.getdetalle().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleAsientoContableCajaChica(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetalleAsientoContableCajaChicaConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DetalleAsientoContableCajaChicaConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(DetalleAsientoContableCajaChicaConstantesFunciones.IDMODULO);
		arrColumnasGlobales.add(DetalleAsientoContableCajaChicaConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(DetalleAsientoContableCajaChicaConstantesFunciones.IDPERIODO);
		
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