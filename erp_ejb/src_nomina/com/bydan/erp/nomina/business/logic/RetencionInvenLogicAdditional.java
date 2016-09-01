














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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.contabilidad.business.entity.TipoRetencion;
import com.bydan.erp.inventario.business.entity.Compra;
import com.bydan.erp.nomina.util.RetencionInvenConstantesFunciones;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.nomina.business.entity.*;
//import com.bydan.erp.nomina.business.interfaces.RetencionInvenAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class RetencionInvenLogicAdditional extends RetencionInvenLogic { // implements RetencionInvenAdditionable{
	public  RetencionInvenLogicAdditional(Connexion connexion)throws Exception {
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
	public  RetencionInvenLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkRetencionInvenToSave(RetencionInven retencioninven,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkRetencionInvenToSave(RetencionInven retencioninven,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkRetencionInvenToSaveAfter(RetencionInven retencioninven,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkRetencionInvenToSaves(List<RetencionInven> retencioninvens,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkRetencionInvenToSaves(List<RetencionInven> retencioninvens,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkRetencionInvenToSavesAfter(List<RetencionInven> retencioninvens,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkRetencionInvenToGet(RetencionInven retencioninven,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkRetencionInvenToGets(List<RetencionInven> retencioninvens,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateRetencionInvenToSave(RetencionInven retencioninven,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateRetencionInvenToGet(RetencionInven retencioninven,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectRetencionInvenActions(String sTipoJsonResponse,JSONObject jsonObjectRetencionInven,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonRetencionInvenDataTable(String sTipoJsonResponse,RetencionInven retencioninven,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonRetencionInvensDataTable(String sTipoJsonResponse,List<RetencionInven> retencioninvens,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayRetencionInvenColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayRetencionInvensColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayRetencionInvensColumns;
	}
	
	public static void updateJSONArrayRetencionInvenActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectRetencionInven,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosRetencionInven(RetencionInven retencioninven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		retencioninven.setcodigo(retencioninven.getcodigo().trim());
		retencioninven.setnumero_retencion(retencioninven.getnumero_retencion().trim());
	}
	
	public static void quitarEspaciosRetencionInvens(List<RetencionInven> retencioninvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RetencionInven retencioninven: retencioninvens) {
			retencioninven.setcodigo(retencioninven.getcodigo().trim());
			retencioninven.setnumero_retencion(retencioninven.getnumero_retencion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRetencionInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(RetencionInvenConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(RetencionInvenConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(RetencionInvenConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(RetencionInvenConstantesFunciones.IDPERIODO);
		
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
	
	public static void ActualizarRetencionInventario(Compra compra,RetencionInven retencionInven) throws Exception {
		
		TipoRetencion tipoRetencion=retencionInven.getTipoRetencion();
		Double retencion=0.0;
		
		
		//if(tipoRetencion!=null) {
			retencionInven.setporcentaje(tipoRetencion.getporcentaje());
			retencionInven.setid_cuenta_contable(tipoRetencion.getid_cuenta_contable());
			
			if(!tipoRetencion.getes_retencion_iva()) {
				
				retencionInven.setbase_imponible(compra.getsub_total());
				
				retencion=compra.getsub_total() * (tipoRetencion.getporcentaje()/100);
				
				retencion=Funciones2.Redondear(retencion, 2);
				
				retencionInven.setretencion(retencion);
				
			} else {
				
				retencionInven.setbase_imponible(compra.getiva());
				
				retencion=compra.getiva() * (tipoRetencion.getporcentaje()/100);
				
				retencion=Funciones2.Redondear(retencion, 2);
				
				retencionInven.setretencion(retencion);
			}
		//}
	}
}