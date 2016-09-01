














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





import javax.swing.JOptionPane;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.Constantes2;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.util.FuncionTipo;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.inventario.util.FormaPagoInvenConstantesFunciones;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.business.entity.*;
//import com.bydan.erp.inventario.business.interfaces.FormaPagoInvenAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class FormaPagoInvenLogicAdditional extends FormaPagoInvenLogic { // implements FormaPagoInvenAdditionable{
	public  FormaPagoInvenLogicAdditional(Connexion connexion)throws Exception {
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
	public  FormaPagoInvenLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkFormaPagoInvenToSave(FormaPagoInven formapagoinven,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkFormaPagoInvenToSave(FormaPagoInven formapagoinven,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkFormaPagoInvenToSaveAfter(FormaPagoInven formapagoinven,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkFormaPagoInvenToSaves(List<FormaPagoInven> formapagoinvens,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkFormaPagoInvenToSaves(List<FormaPagoInven> formapagoinvens,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkFormaPagoInvenToSavesAfter(List<FormaPagoInven> formapagoinvens,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkFormaPagoInvenToGet(FormaPagoInven formapagoinven,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkFormaPagoInvenToGets(List<FormaPagoInven> formapagoinvens,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateFormaPagoInvenToSave(FormaPagoInven formapagoinven,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateFormaPagoInvenToGet(FormaPagoInven formapagoinven,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectFormaPagoInvenActions(String sTipoJsonResponse,JSONObject jsonObjectFormaPagoInven,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonFormaPagoInvenDataTable(String sTipoJsonResponse,FormaPagoInven formapagoinven,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonFormaPagoInvensDataTable(String sTipoJsonResponse,List<FormaPagoInven> formapagoinvens,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayFormaPagoInvenColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayFormaPagoInvensColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayFormaPagoInvensColumns;
	}
	
	public static void updateJSONArrayFormaPagoInvenActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectFormaPagoInven,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosFormaPagoInven(FormaPagoInven formapagoinven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		formapagoinven.setdetalle(formapagoinven.getdetalle().trim());
	}
	
	public static void quitarEspaciosFormaPagoInvens(List<FormaPagoInven> formapagoinvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FormaPagoInven formapagoinven: formapagoinvens) {
			formapagoinven.setdetalle(formapagoinven.getdetalle().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFormaPagoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(FormaPagoInvenConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(FormaPagoInvenConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(FormaPagoInvenConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(FormaPagoInvenConstantesFunciones.IDPERIODO);
		
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
	
	public static void ProcesarEventosGeneral(FormaPagoInven formaPagoInven,String sTipo,List<FormaPagoInven> formaPagoInvens,Compra compra) throws Exception {
		
		if(sTipo.equals("numero_diasFormaPagoInven")) {
			formaPagoInven.setfecha_fin(Funciones2.AdicionarDiasFecha(formaPagoInven.getfecha_inicio(), formaPagoInven.getnumero_dias()));
		
		} else if(sTipo.equals("porcentajeFormaPagoInven")) {
			Double dValorFormaPago=0.0;
			Double dValorTotalFormaPago=0.0;
			
			
			for(FormaPagoInven formaPagoInvenFor : formaPagoInvens) {
				
				if(!formaPagoInvenFor.getId().equals(formaPagoInven.getId()) 
					&& !formaPagoInvenFor.getsType().equals(Constantes2.S_TOTALES)) {
					
					dValorTotalFormaPago+=formaPagoInvenFor.getvalor();
				}
			}
			
			dValorFormaPago=compra.gettotal() * (formaPagoInven.getporcentaje() / 100);
			
			dValorFormaPago=Funciones2.Redondear(dValorFormaPago, 2);
					
			if((dValorTotalFormaPago + dValorFormaPago) <= compra.gettotal()) {
				formaPagoInven.setvalor(dValorFormaPago);
			
			} else {
				Double dValorTotalExtraFormaPago=0.0;
				
				dValorTotalExtraFormaPago=dValorTotalFormaPago + dValorFormaPago;
				
				throw new Exception("Se sobrepasa valor Total="+compra.gettotal() + ", Forma Pago="+dValorTotalExtraFormaPago);
			}
		}
	}
}