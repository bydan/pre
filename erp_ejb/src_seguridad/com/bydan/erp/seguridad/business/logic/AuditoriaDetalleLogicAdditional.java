













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

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
//import java.util.ArrayList;
import com.bydan.erp.seguridad.business.dataaccess.AuditoriaDetalleDataAccess;
import com.bydan.erp.seguridad.business.entity.*;
//import com.bydan.erp.seguridad.business.interfaces.AuditoriaDetalleAdditionable;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.Connexion;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.*;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
//import com.bydan.framework.auditoria.util.*;
//import com.bydan.auditoria.business.dataaccess.*;
//import com.bydan.auditoria.business.logic.*;
//import com.bydan.framework.auditoria.business.logic.*;
//import java.sql.SQLException;
import com.bydan.framework.erp.util.Funciones;



@SuppressWarnings("unused")
public class AuditoriaDetalleLogicAdditional extends AuditoriaDetalleLogic { // implements AuditoriaDetalleAdditionable{
	public  AuditoriaDetalleLogicAdditional()throws Exception {
		super();
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
		
	public static void checkAuditoriaDetalleToSave(AuditoriaDetalle auditoriadetalle,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkAuditoriaDetalleToSave(AuditoriaDetalle auditoriadetalle,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkAuditoriaDetalleToSaveAfter(AuditoriaDetalle auditoriadetalle,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkAuditoriaDetalleToSaves(List<AuditoriaDetalle> auditoriadetalles,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
public static void checkAuditoriaDetalleToSaves(List<AuditoriaDetalle> auditoriadetalles,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkAuditoriaDetalleToSavesAfter(List<AuditoriaDetalle> auditoriadetalles,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkAuditoriaDetalleToGet(AuditoriaDetalle auditoriadetalle,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkAuditoriaDetalleToGets(List<AuditoriaDetalle> auditoriadetalles,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void updateAuditoriaDetalleToSave(AuditoriaDetalle auditoriadetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}		
						
	public static void updateAuditoriaDetalleToGet(AuditoriaDetalle auditoriadetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}	
	
	public static void updateJSONObjectAuditoriaDetalleActions(String sTipoJsonResponse,JSONObject jsonObjectAuditoriaDetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static String getJsonAuditoriaDetalleDataTable(String sTipoJsonResponse,AuditoriaDetalle auditoriadetalle,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		return sJsonDataTable;
	}
	
	public static String getJsonAuditoriaDetallesDataTable(String sTipoJsonResponse,List<AuditoriaDetalle> auditoriadetalles,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		return sJsonDataTable;
	}
	
	
	public static JSONArray getJsonArrayAuditoriaDetalleColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayAuditoriaDetallesColumns = new JSONArray();
		
		return jsonArrayAuditoriaDetallesColumns;
	}
	
	public static void updateJSONArrayAuditoriaDetalleActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectAuditoriaDetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	//CONTROL_FUNCION2
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
		
	public void registrarNuevaAuditoriaDetalle( 	 	 	 	Long bigIdAuditoria ,	String strNombrecampo ,	String strValoranterior ,	String strValoractual 	)throws Exception {			
	    try {		
			connexion=connexion.getNewConnexion();connexion.begin();
			
	    	auditoriadetalle= new AuditoriaDetalle();
		
	    	auditoriadetalle.setAuditoria(null);
			auditoriadetalle.setid_auditoria(bigIdAuditoria);	
			auditoriadetalle.setnombre_campo(strNombrecampo);	
			auditoriadetalle.setvalor_anterior(strValoranterior);	
			auditoriadetalle.setvalor_actual(strValoractual);	
			
			AuditoriaDetalleLogicAdditional.updateAuditoriaDetalleToSave(auditoriadetalle,this.arrDatoGeneral);
	   		
			AuditoriaDetalleDataAccess.save(auditoriadetalle, connexion);
	    	
			//AuditoriaDetalleLogic.RegistrarAuditoria(idUsuario,auditoriadetalle,strUsuarioPC,strNamePC,strIPPC);
			
			connexion.commit();	
			
	   	} catch(Exception ex) {
			connexion.rollback();
			throw ex;
			
      	} finally {
			connexion.close();	
		}	
	}
}