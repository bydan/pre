













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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Set;

import org.json.JSONObject;
import org.json.JSONArray;
//import java.util.ArrayList;
import com.bydan.erp.seguridad.business.dataaccess.AuditoriaDataAccess;
import com.bydan.erp.seguridad.business.entity.*;
//import com.bydan.erp.seguridad.business.interfaces.AuditoriaAdditionable;
import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
//import com.bydan.framework.auditoria.util.*;
//import com.bydan.auditoria.business.dataaccess.*;
//import com.bydan.auditoria.business.logic.*;
//import com.bydan.framework.auditoria.business.logic.*;
//import java.sql.SQLException;
import com.bydan.framework.erp.util.*;
import com.bydan.framework.erp.util.Connexion;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.util.Funciones;


@SuppressWarnings("unused")
public class AuditoriaLogicAdditional extends AuditoriaLogic { // implements AuditoriaAdditionable{
	public  AuditoriaLogicAdditional()throws Exception {
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
		
	public static void checkAuditoriaToSave(Auditoria auditoria,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
public static void checkAuditoriaToSave(Auditoria auditoria,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkAuditoriaToSaveAfter(Auditoria auditoria,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkAuditoriaToSaves(List<Auditoria> auditorias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
public static void checkAuditoriaToSaves(List<Auditoria> auditorias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkAuditoriaToSavesAfter(List<Auditoria> auditorias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkAuditoriaToGet(Auditoria auditoria,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkAuditoriaToGets(List<Auditoria> auditorias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void updateAuditoriaToSave(Auditoria auditoria,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}		
						
	public static void updateAuditoriaToGet(Auditoria auditoria,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}	
	
	public static void updateJSONObjectAuditoriaActions(String sTipoJsonResponse,JSONObject jsonObjectAuditoria,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static JSONArray getJsonArrayAuditoriaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayAuditoriasColumns = new JSONArray();
		
		return jsonArrayAuditoriasColumns;
	}
	
	public static String getJsonAuditoriaDataTable(String sTipoJsonResponse,Auditoria auditoria,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		return sJsonDataTable;
	}
	
	public static String getJsonAuditoriasDataTable(String sTipoJsonResponse,List<Auditoria> auditorias,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		return sJsonDataTable;
	}
	
	public static void updateJSONArrayAuditoriaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectAuditoria,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
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
		
	public void registrarNuevaAuditoria(Long bigIdSistemaAux ,	Long bigIdUsuario ,	String strNombretabla ,	Long bigIdfila ,	String strAccion ,	String strProceso ,String strUsuariopc ,		String strNombrepc ,	String strIppc ,	Date dtFechahora ,	String strObservaciones 	)throws Exception
	{									//Sistema.getTableName(), sistema.getId(), Constantes.getStrAuditoriaInsertar(),idUsuario,strUsuarioPC,strNamePC,strIPPC
		try 
		{		
			connexion=connexion.getNewConnexion();connexion.begin();
			
	    	auditoria= new Auditoria();
	    	auditoria.setAuditoriaDetalles(null);
	    	auditoria.setid_usuario(bigIdUsuario);	
			auditoria.setnombre_tabla(strNombretabla);	
			auditoria.setid_fila(bigIdfila);	
			auditoria.setaccion(strAccion);	
			auditoria.setproceso(strProceso);	
			auditoria.setnombre_p_c(strNombrepc);	
			auditoria.setip_pc(strIppc);	
			auditoria.setusuario_p_c(strUsuariopc);	
			auditoria.setfecha_hora(new Timestamp(dtFechahora.getTime()));	
			auditoria.setobservacion(strObservaciones);	
			
			AuditoriaLogicAdditional.updateAuditoriaToSave(auditoria,this.arrDatoGeneral);
	   		AuditoriaDataAccess.save(auditoria, connexion);
	    	
			//AuditoriaLogic.RegistrarAuditoria(idUsuario,auditoria,strUsuarioPC,strNamePC,strIPPC);
			
			connexion.commit();	
			
	   	} catch(Exception e) {
			//Funciones.manageException(logger,e);
			connexion.rollback();
			throw e;
			
      	} finally {
			connexion.close();	
		}
	}	
	
	public void registrarNuevaAuditoriaBusqueda(Long bigIdSistemaAux ,	Long bigIdUsuario ,	String strNombretabla ,	Long bigIdfila ,	String strAccion ,	String strProceso ,String strUsuariopc ,		String strNombrepc ,	String strIppc ,	Date dtFechahora ,	String strObservaciones 	)throws Exception
	{									//Sistema.getTableName(), sistema.getId(), Constantes.getStrAuditoriaInsertar(),idUsuario,strUsuarioPC,strNamePC,strIPPC
		try 
		{		
			if(!(bigIdSistemaAux<=0||bigIdUsuario<=0)) {
				
				connexion=connexion.getNewConnexion();connexion.begin();
				
				QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
				String sFinalQuery=" where id_usuario="+bigIdUsuario+" and nombre_tabla='"+strNombretabla+"' and accion='"+Constantes.SAUDITORIABUSCAR+"'"+ " and proceso='"+strProceso+"'";
				
				queryWhereSelectParameters.setFinalQuery(sFinalQuery);
				
				this.getEntities(queryWhereSelectParameters);
				
				if(this.getAuditorias().size()<=0) {
			    	auditoria= new Auditoria();
			    	auditoria.setAuditoriaDetalles(null);
			    	auditoria.setid_usuario(bigIdUsuario);	
					auditoria.setnombre_tabla(strNombretabla);	
					auditoria.setid_fila(bigIdfila);	
					auditoria.setaccion(strAccion);	
					auditoria.setproceso(strProceso);	
					auditoria.setnombre_p_c(strNombrepc);	
					auditoria.setip_pc(strIppc);	
					auditoria.setusuario_p_c(strUsuariopc);	
					auditoria.setfecha_hora(new Timestamp(dtFechahora.getTime()));	
					auditoria.setobservacion(strObservaciones);																
					
					AuditoriaLogicAdditional.updateAuditoriaToSave(auditoria,this.arrDatoGeneral);
			   		AuditoriaDataAccess.save(auditoria, connexion);
				
				} else {
					for(Auditoria auditoriaAux:this.getAuditorias()) {
						auditoriaAux.setnombre_p_c(strNombrepc);	
						auditoriaAux.setip_pc(strIppc);	
						auditoriaAux.setusuario_p_c(strUsuariopc);	
						auditoriaAux.setfecha_hora(new Timestamp(dtFechahora.getTime()));	
						auditoriaAux.setobservacion(strObservaciones);	
						
						AuditoriaDataAccess.save(auditoriaAux, connexion);
					}
					
					
				}
				
				//AuditoriaLogic.RegistrarAuditoria(idUsuario,auditoria,strUsuarioPC,strNamePC,strIPPC);
				
				connexion.commit();	
			
			}
	   	} catch(Exception e) {
			//Funciones.manageException(logger,e);
			connexion.rollback();
			throw e;
			
      	} finally {
			connexion.close();	
		}
	}	
}