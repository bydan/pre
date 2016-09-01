














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
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.business.entity.ParametroTesoreriaDefecto;
import com.bydan.erp.tesoreria.business.logic.ParametroTesoreriaDefectoLogic;
import com.bydan.erp.tesoreria.business.logic.CuentaBancoLogic;
import com.bydan.erp.tesoreria.util.CuentaBancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.CuentaBancoReturnGeneral;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.tesoreria.util.CuentaBancoConstantesFunciones;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.tesoreria.business.entity.*;
//import com.bydan.erp.tesoreria.business.interfaces.CuentaBancoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class CuentaBancoLogicAdditional extends CuentaBancoLogic { // implements CuentaBancoAdditionable{
	public  CuentaBancoLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19
			
			CuentaBancoLogic cuentaBancoLogic=(CuentaBancoLogic)generalEntityLogic;
			CuentaBancoParameterReturnGeneral cuentaBancoReturnGeneral=(CuentaBancoParameterReturnGeneral)generalEntityReturnGeneral;
			
			ParametroTesoreriaDefecto parametroTesoreriaDefecto=new ParametroTesoreriaDefecto();
			ParametroTesoreriaDefectoLogic parametroTesoreriaDefectoLogic=new ParametroTesoreriaDefectoLogic();						
			
			parametroTesoreriaDefectoLogic.setConnexion(generalEntityLogic.getConnexion());
			
			
			String sFinalQuery="";
			
			if(controlTipo.equals(ControlTipo.FORM) && eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW)) {
				sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_sucursal="+parametroGeneralUsuario.getid_sucursal();
				
				parametroTesoreriaDefectoLogic.getEntity(sFinalQuery);
				
				parametroTesoreriaDefecto=parametroTesoreriaDefectoLogic.getParametroTesoreriaDefecto();
				
				if(parametroTesoreriaDefecto!=null && parametroTesoreriaDefecto.getId()>0) {
					cuentaBancoReturnGeneral.getCuentaBanco().setid_tipo_cuenta_banco_global(parametroTesoreriaDefecto.getid_tipo_cuenta_banco_global());
					//cuentaBancoReturnGeneral.getCuentaBanco().setid_estado_cuenta_banco(parametroTesoreriaDefecto.getid_estado_cuenta_banco());
					
					
					
					
					/*
					cuentaBancoReturnGeneral.getCuentaBanco().setid_pais(parametroTesoreriaDefecto.getid_pais());
					cuentaBancoReturnGeneral.getCuentaBanco().setid_ciudad(parametroTesoreriaDefecto.getid_ciudad());
					cuentaBancoReturnGeneral.getCuentaBanco().setid_zona(parametroTesoreriaDefecto.getid_zona());
					cuentaBancoReturnGeneral.getCuentaBanco().setid_tipo_identificacion(parametroTesoreriaDefecto.getid_tipo_identificacion());
					cuentaBancoReturnGeneral.getCuentaBanco().setid_pais_nacionalidad(parametroTesoreriaDefecto.getid_pais_nacionalidad());
					cuentaBancoReturnGeneral.getCuentaBanco().setid_estado_civil(parametroTesoreriaDefecto.getid_estado_civil());
					cuentaBancoReturnGeneral.getCuentaBanco().setid_tipo_genero(parametroTesoreriaDefecto.getid_tipo_genero());
					cuentaBancoReturnGeneral.getCuentaBanco().setid_cuenta_contable(parametroTesoreriaDefecto.getid_cuenta_contable());
					cuentaBancoReturnGeneral.getCuentaBanco().setid_tipo_nivel_edu(parametroTesoreriaDefecto.getid_tipo_nivel_edu());
					cuentaBancoReturnGeneral.getCuentaBanco().setid_estado_legal(parametroTesoreriaDefecto.getid_estado_legal());																		
					cuentaBancoReturnGeneral.getCuentaBanco().setid_region(parametroTesoreriaDefecto.getid_region());
					cuentaBancoReturnGeneral.getCuentaBanco().setid_provincia(parametroTesoreriaDefecto.getid_provincia());
					cuentaBancoReturnGeneral.getCuentaBanco().setid_ruta(parametroTesoreriaDefecto.getid_ruta());
					//cuentaBancoReturnGeneral.getCuentaBanco().setid_cuentaBanco(parametroTesoreriaDefecto.getid_cuentaBanco());					
					cuentaBancoReturnGeneral.getCuentaBanco().setid_dia(parametroTesoreriaDefecto.getid_dia());
					cuentaBancoReturnGeneral.getCuentaBanco().setid_tipo_precio(parametroTesoreriaDefecto.getid_tipo_precio());
					cuentaBancoReturnGeneral.getCuentaBanco().setid_tipo_lista_precio(parametroTesoreriaDefecto.getid_tipo_lista_precio());
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
	public  CuentaBancoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCuentaBancoToSave(CuentaBanco cuentabanco,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCuentaBancoToSave(CuentaBanco cuentabanco,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCuentaBancoToSaveAfter(CuentaBanco cuentabanco,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCuentaBancoToSaves(List<CuentaBanco> cuentabancos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCuentaBancoToSaves(List<CuentaBanco> cuentabancos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCuentaBancoToSavesAfter(List<CuentaBanco> cuentabancos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCuentaBancoToGet(CuentaBanco cuentabanco,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCuentaBancoToGets(List<CuentaBanco> cuentabancos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCuentaBancoToSave(CuentaBanco cuentabanco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCuentaBancoToGet(CuentaBanco cuentabanco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCuentaBancoActions(String sTipoJsonResponse,JSONObject jsonObjectCuentaBanco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCuentaBancoDataTable(String sTipoJsonResponse,CuentaBanco cuentabanco,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCuentaBancosDataTable(String sTipoJsonResponse,List<CuentaBanco> cuentabancos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCuentaBancoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCuentaBancosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCuentaBancosColumns;
	}
	
	public static void updateJSONArrayCuentaBancoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCuentaBanco,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCuentaBanco(CuentaBanco cuentabanco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cuentabanco.setcodigo(cuentabanco.getcodigo().trim());
		cuentabanco.setnumero_cuenta(cuentabanco.getnumero_cuenta().trim());
		cuentabanco.setnumero_cheque(cuentabanco.getnumero_cheque().trim());
		cuentabanco.setnumero_cheque_auxiliar(cuentabanco.getnumero_cheque_auxiliar().trim());
		cuentabanco.setprocedencia(cuentabanco.getprocedencia().trim());
		cuentabanco.setdestino(cuentabanco.getdestino().trim());
	}
	
	public static void quitarEspaciosCuentaBancos(List<CuentaBanco> cuentabancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CuentaBanco cuentabanco: cuentabancos) {
			cuentabanco.setcodigo(cuentabanco.getcodigo().trim());
			cuentabanco.setnumero_cuenta(cuentabanco.getnumero_cuenta().trim());
			cuentabanco.setnumero_cheque(cuentabanco.getnumero_cheque().trim());
			cuentabanco.setnumero_cheque_auxiliar(cuentabanco.getnumero_cheque_auxiliar().trim());
			cuentabanco.setprocedencia(cuentabanco.getprocedencia().trim());
			cuentabanco.setdestino(cuentabanco.getdestino().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CuentaBancoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(CuentaBancoConstantesFunciones.IDSUCURSAL);
		
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