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

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
//import java.util.ArrayList;
import com.bydan.framework.erp.util.*;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.logic.Pagination;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.presentation.web.ajax.jmaki.TreeAuxYahooExt;
import com.bydan.framework.erp.util.presentation.web.ajax.jmaki.TreeWidgetsExt;
import com.bydan.erp.seguridad.business.dataaccess.PerfilAccionDataAccess;
import com.bydan.erp.seguridad.business.entity.*;
//import com.bydan.erp.seguridad.business.interfaces.SistemaAdditionable;
import com.bydan.erp.seguridad.util.GrupoOpcionConstantesFunciones;
import com.bydan.erp.seguridad.util.ModuloConstantesFunciones;
import com.bydan.erp.seguridad.util.OpcionConstantesFunciones;
import com.bydan.erp.seguridad.util.PerfilAccionConstantesFunciones;
import com.bydan.erp.seguridad.util.PerfilOpcionConstantesFunciones;
import com.bydan.erp.seguridad.util.SistemaParameterReturnGeneral;
import com.bydan.erp.seguridad.util.SistemaSql;
import com.bydan.framework.erp.business.logic.DatosCliente;
//import com.bydan.framework.erp.util.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import com.bydan.framework.erp.business.logic.*;
//import java.sql.SQLException;
import com.bydan.framework.global.seguridad.logic.GlobalSeguridad;


@SuppressWarnings("unused")
final public class SistemaLogicAdditional extends SistemaLogic { // implements SistemaAdditionable{		
	final public  static String STODO="TODO";
	final public  static String SBUSQUEDA="BUSQUEDA";
	final public  static String SCONSULTA="CONSULTA";
	final public  static String SINGRESO="INGRESO";
	final public  static String SMODIFICACION="MODIFICACION";
	final public  static String SELIMINACION="ELIMINACION";
	
	
	private OpcionLogic opcionLogic;
	private ModuloLogic moduloLogic;
	
	public  SistemaLogicAdditional()throws Exception {
		super();
		this.opcionLogic=new OpcionLogic();
		this.moduloLogic=new ModuloLogic();
    }
	
	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_22
	}
	
	public static Boolean validarSaveRelaciones(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_20
		Boolean validado=true;

		return validado;	
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
		
	public static void updateSistemaToSave(Sistema sistema,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}		
						
	public static void updateSistemaToGet(Sistema sistema,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}	
	
	public static void updateJSONObjectSistemaActions(String sTipoJsonResponse,JSONObject jsonObjectSistema,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}

	public static void checkSistemaToSave(Sistema sistema,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkSistemaToSave(Sistema sistema,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkSistemaToSaveAfter(Sistema sistema,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkSistemaToSaves(List<Sistema> sistemas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkSistemaToSaves(List<Sistema> sistemas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkSistemaToSavesAfter(List<Sistema> sistemas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkSistemaToGet(Sistema sistema,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkSistemaToGets(List<Sistema> sistemas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static String getJsonSistemaDataTable(String sTipoJsonResponse,Sistema sistema,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		return sJsonDataTable;
	}
	
	public static String getJsonSistemasDataTable(String sTipoJsonResponse,List<Sistema> sistemas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArraySistemaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArraySistemasColumns = new JSONArray();
		
		return jsonArraySistemasColumns;
	}
	
	public static void updateJSONArraySistemaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectSistema,ArrayList<DatoGeneral> arrDatoGeneral) {	
	
	}

	public void getNewConnexionConnectionToValidarSeguridad()throws Exception {
		try	{
			this.connexion=connexion.getNewConnexion();
			
		}  catch(Exception e) {
			//Funciones.logShowExceptionMessages(logger,e);
			throw e;
		}
	}
	
	//CONTROL_FUNCION2
	//PARA ACCIONES NORMALES
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterReturnGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {
			try {

				//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();


				return generalEntityReturnGeneral;

			} catch(Exception e) {
				//Funciones.manageException(logger,e);
				throw e;

			} finally {

			}
	}
		
	public Boolean validarLicenciaCliente(DatosCliente datosCliente) throws Exception {
		Boolean isValidado=true;
		
		try	{
		   
			String sUsuarioPCServer=datosCliente.getsUsuarioPCServer();
			String sNamePCServer=datosCliente.getsNamePCServer();
			String sIPPCServer=datosCliente.getsIPPCServer();
			String sMacAddressPCServer=datosCliente.getsMacAddressPCServer();
			Date dFechaServer=datosCliente.getdFechaServer();
			Long idUsuario=datosCliente.getIdUsuario();
			Boolean isClienteWeb=datosCliente.getIsClienteWeb();
			String sClaveSistema=datosCliente.getsClaveSistema();
			
			isValidado=GlobalSeguridad.validarLicenciaCliente(sUsuarioPCServer, sNamePCServer, sIPPCServer, sMacAddressPCServer, dFechaServer, idUsuario, isClienteWeb, sClaveSistema);
		    
		    return isValidado;
			
		} catch(Exception e) {
			//this.connexion.rollback();			
			
			throw e;
			
		} finally {
			this.connexion.close();	
		}
	}
	
	public Boolean validarLicenciaCliente(DatosCliente datosCliente,Modulo moduloActual,Usuario usuarioActual) throws Exception {
		Boolean isValidado=true;
		
		try	{
		   
			String sUsuarioPCServer=datosCliente.getsUsuarioPCServer();
			String sNamePCServer=datosCliente.getsNamePCServer();
			String sIPPCServer=datosCliente.getsIPPCServer();
			String sMacAddressPCServer=datosCliente.getsMacAddressPCServer();
			Date dFechaServer=datosCliente.getdFechaServer();
			Long idUsuario=datosCliente.getIdUsuario();
			Boolean isClienteWeb=datosCliente.getIsClienteWeb();
			String sClaveSistema=datosCliente.getsClaveSistema();			
			String sNombreModuloActual=moduloActual.getnombre().trim();
			String sNombreUsuarioActual=usuarioActual.getuser_name().trim();
			
			isValidado=GlobalSeguridad.validarLicenciaCliente(sUsuarioPCServer, sNamePCServer, sIPPCServer, sMacAddressPCServer, dFechaServer, idUsuario, isClienteWeb, sClaveSistema,sNombreModuloActual,sNombreUsuarioActual);
		    
		    return isValidado;
			
		} catch(Exception e) {
			//this.connexion.rollback();			
			
			throw e;
			
		} finally {
			//this.connexion.close();	
		}
	}
	
	public SistemaParameterReturnGeneral validarCargarSesionUsuarioActual(Usuario usuarioActual,DatosCliente datosCliente,ResumenUsuario resumenUsuarioActual,Long lIdSistema,String sPagina,Opcion opcionActual,Boolean esGuardarRelacionado,Boolean conGuardarRelaciones,ArrayList<String> arrPaginas) throws Exception {
		return this.validarCargarSesionUsuarioActualBase(usuarioActual,datosCliente,resumenUsuarioActual,lIdSistema,sPagina,opcionActual,esGuardarRelacionado,conGuardarRelaciones,arrPaginas,false);
	}
	
	public SistemaParameterReturnGeneral validarCargarSesionUsuarioActualWithConnection(Usuario usuarioActual,DatosCliente datosCliente,ResumenUsuario resumenUsuarioActual,Long lIdSistema,String sPagina,Opcion opcionActual,Boolean esGuardarRelacionado,Boolean conGuardarRelaciones,ArrayList<String> arrPaginas) throws Exception {
		return this.validarCargarSesionUsuarioActualBase(usuarioActual,datosCliente,resumenUsuarioActual,lIdSistema,sPagina,opcionActual,esGuardarRelacionado,conGuardarRelaciones,arrPaginas,true);
	}
	
	public SistemaParameterReturnGeneral validarCargarSesionUsuarioActualBase(Usuario usuarioActual,DatosCliente datosCliente,ResumenUsuario resumenUsuarioActual,Long lIdSistema,String sPagina,Opcion opcionActual,Boolean esGuardarRelacionado,Boolean conGuardarRelaciones,ArrayList<String> arrPaginas,Boolean conConexion) throws Exception {
		Boolean isValidado=true;
		String sFinalQuery="";
		
		SistemaParameterReturnGeneral sistemaReturnGeneral=new SistemaParameterReturnGeneral();
		
		PerfilOpcion perfilOpcionUsuario=new PerfilOpcion();
		List<Accion> accions=new ArrayList<Accion>();
		List<Accion> accionsFormulario=new ArrayList<Accion>();
		List<Opcion> opcionsRelacionadas=new ArrayList<Opcion>();
		
		try	{
			
			if(conConexion) {
				this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-validarCargarSesionUsuarioActualWithConnection");this.connexion.begin();
			}
			
			ResumenUsuarioLogic resumenUsuarioLogic=new ResumenUsuarioLogic();
			
			resumenUsuarioLogic.setConnexion(this.connexion);
			
			resumenUsuarioLogic.setDatosCliente(datosCliente);
			
			//CARGAR ISVALIDADO
			sFinalQuery=" where id_usuario="+usuarioActual.getId();
			
    		resumenUsuarioLogic.getEntity(sFinalQuery);
    		
    		if(resumenUsuarioLogic.getResumenUsuario()!=null && resumenUsuarioLogic.getResumenUsuario().getId()>0) {
	    		if(!resumenUsuarioActual.getnumero_reinicios().equals(resumenUsuarioLogic.getResumenUsuario().getnumero_reinicios())) {
	    			isValidado=false;
	    		}
    		} else {
    			isValidado=false;
    		}
			
    		sistemaReturnGeneral.setEsValidado(isValidado);
    		
    		
    		//CARGAR PERFILOPCION
    		perfilOpcionUsuario=this.traerPermisosPaginaWebPerfilOpcion(usuarioActual,lIdSistema,sPagina,opcionActual.getId(),false);
    		
    		sistemaReturnGeneral.setPerfilOpcion(perfilOpcionUsuario);
    		
    		
    		//CARGAR ACCIONES PRINCIPAL Y FORMULARIO
    		accions=this.getAccionesUsuario(usuarioActual,opcionActual,false,false);
    		
    		sistemaReturnGeneral.setAccions(accions);
    		
    		//ACCIONES FORMULARIO	
    		accionsFormulario=this.getAccionesUsuario(usuarioActual,opcionActual,true,false);
    		
    		sistemaReturnGeneral.setAccionsFormulario(accionsFormulario);
    		
    		
    		
    		//CARGAR PERMISOS RELACIONADOS
    		if(!esGuardarRelacionado || (esGuardarRelacionado && conGuardarRelaciones)) {
    			
    			opcionsRelacionadas=this.tienePermisosOpcionesEnPaginaWeb(usuarioActual,lIdSistema,arrPaginas,false);;
    		}
    		
    		
    		sistemaReturnGeneral.setOpcionsRelacionadas(opcionsRelacionadas);
    		
    		
    		if(conConexion) {
    			this.connexion.commit();    		
    		}
    		
		    return sistemaReturnGeneral;//isValidado;
			
		} catch(Exception e) {
			//this.connexion.rollback();			
			
			if(conConexion) {
				this.connexion.rollback();
			}
			
			throw e;
			
		} finally {
			if(conConexion) {
				this.connexion.close();
			}
		}
	}
	
	public Boolean validarSesionUsuarioActual(Usuario usuarioActual,DatosCliente datosCliente,ResumenUsuario resumenUsuarioActual) throws Exception {
		Boolean isValidado=true;
		String sFinalQuery="";
		
		try	{
			ResumenUsuarioLogic resumenUsuarioLogic=new ResumenUsuarioLogic();
			
			resumenUsuarioLogic.setDatosCliente(datosCliente);
			
			sFinalQuery=" where id_usuario="+usuarioActual.getId();
			
    		resumenUsuarioLogic.getEntityWithConnection(sFinalQuery);
    		
    		if(resumenUsuarioLogic.getResumenUsuario()!=null && resumenUsuarioLogic.getResumenUsuario().getId()>0) {
	    		if(!resumenUsuarioActual.getnumero_reinicios().equals(resumenUsuarioLogic.getResumenUsuario().getnumero_reinicios())) {
	    			isValidado=false;
	    		}
    		} else {
    			isValidado=false;
    		}
			
		    return isValidado;
			
		} catch(Exception e) {
			//this.connexion.rollback();			
			
			throw e;
			
		} finally {
			//this.connexion.close();	
		}
	}
	
	public List<Opcion> getOpcionesUsuario(Usuario usuario,Long lIdSistema) throws Exception	{	
		return this.getOpcionesUsuario(usuario,lIdSistema,true,false,false);
	}
	
	public List<Opcion> getOpcionesUsuario(Usuario usuario,Long lIdSistema,Boolean conConnexion,Boolean paraPrecargar,Boolean paraPrecargarPorUsuario) throws Exception	{	
		try	{
			
			if(conConnexion) {
				this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();
			}
			
			PerfilUsuarioLogic perfilUsuarioLogic=new PerfilUsuarioLogic();
			this.opcionLogic=new OpcionLogic();
			
			perfilUsuarioLogic.setConnexion(this.connexion);
			this.opcionLogic.setConnexion(this.connexion);
			
			//perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuarioWithConnection("",new Pagination(), usuario.getId());
			perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuario("",new Pagination(), usuario.getId());
			
			String sPerfiles=new String();
			Boolean esPrimero=true;
		
			for(PerfilUsuario perfilusuario:perfilUsuarioLogic.getPerfilUsuarios()) {
				if(esPrimero) {
					esPrimero=false;
				} else {
					sPerfiles+=",";
				}
				
				sPerfiles+=perfilusuario.getid_perfil().toString();		
			}
			
			StringBuilder sbTableAjax=new StringBuilder();
				
			opcionLogic.setOpcions(new ArrayList<Opcion>());
			
			/*
			 	select distinct * from Opcion O inner join perfilopcion PO on PO.idOpcion=O.id
			 	where O.idSistema=2 and PO.idPerfil in (1,2,3);
			*/
							
			String sSelect=SistemaSql.GetSelectOpcionesUsuario(this.connexionType,this.parameterDbType);//" select distinct opcion from "+OpcionConstantesFunciones.SPERSISTENCENAME+" opcion ";
			
			String sFinal=SistemaSql.GetFinalOpcionesUsuario(this.connexionType,this.parameterDbType,lIdSistema,sPerfiles,paraPrecargar,paraPrecargarPorUsuario,usuario);
			
			/*" inner join opcion.perfilOpcions perfilopcion where opcion.id_modulo="+lIdSistema.toString();
			sFinal+=" and perfilopcion.id_perfil in ("+sPerfiles+") ";
			sFinal+=" and opcion.es_para_menu=true and opcion.estado=true order by opcion.posicion asc ";
			*/
			
			//opcion.field_lIdOpcion is null and 
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setInitialQuery("");
			queryWhereSelectParameters.setFinalQuery(sFinal);
					
			//opcionLogic.getEntitiesWithConnection(sSelect, queryWhereSelectParameters);
			opcionLogic.getEntities(sSelect, queryWhereSelectParameters);
			
			
			if(conConnexion) {
				this.connexion.commit();
			}
			
		} catch(Exception ex) {
			if(conConnexion) {
				this.connexion.rollback();
			}
			
			throw ex;
			
		}  finally {
			if(conConnexion) {
				this.connexion.close();
			}
		}
		

		return  opcionLogic.getOpcions();
	}
	
	public List<Modulo> getModulosUsuario(Usuario usuario,Long lIdSistema) throws Exception	{
		try	{
		
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getModulosUsuario");this.connexion.begin();			
				
			PerfilUsuarioLogic perfilUsuarioLogic=new PerfilUsuarioLogic();
			perfilUsuarioLogic.setConnexion(this.connexion);
			
			this.moduloLogic=new ModuloLogic();
			this.moduloLogic.setConnexion(this.connexion);
			
			//perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuarioWithConnection("",new Pagination(), usuario.getId());
			perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuario("",new Pagination(), usuario.getId());
			
			
			String sPerfiles=new String();
			Boolean esPrimero=true;
		
			for(PerfilUsuario perfilusuario:perfilUsuarioLogic.getPerfilUsuarios()) {
				if(esPrimero) {
					esPrimero=false;
				} else {
					sPerfiles+=",";
				}
				
				sPerfiles+=perfilusuario.getid_perfil().toString();		
			}
			
			StringBuilder sbTableAjax=new StringBuilder();
				
			this.moduloLogic.setModulos(new ArrayList<Modulo>());
			
			/*
			 	select distinct * from Opcion O inner join perfilopcion PO on PO.idOpcion=O.id
			 	where O.idSistema=2 and PO.idPerfil in (1,2,3);
			*/
							
			String sSelect=SistemaSql.GetWhereModulos(this.connexionType,this.parameterDbType);//" select distinct modulo from "+ModuloConstantesFunciones.SPERSISTENCENAME+" modulo ";
			
			String sFinal="";
			
			/*		
			sFinal=" inner join opcion.perfilOpcions perfilopcion where opcion.id_modulo="+lIdSistema.toString();
			sFinal+=" and perfilopcion.id_perfil in ("+sPerfiles+") ";
			sFinal+=" and opcion.es_para_menu=true and opcion.estado=true order by opcion.posicion asc ";
			*/
					
			//opcion.field_lIdOpcion is null and 
			
			sFinal=" where estado=true order by orden "; 
			 
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setInitialQuery("");
			queryWhereSelectParameters.setFinalQuery(sFinal);
					
			//this.moduloLogic.getEntitiesWithConnection(sSelect, queryWhereSelectParameters);
			this.moduloLogic.getEntities(sSelect, queryWhereSelectParameters);
				
			this.connexion.commit();
			
		} catch(Exception ex) {
			this.connexion.rollback();
			
			throw ex;
			
		} finally {
			this.connexion.close();	
		}
		

		return  moduloLogic.getModulos();
	}
	
	public SistemaParameterReturnGeneral getGrupoOpcionsYOpcionsUsuario(Usuario usuario,Long lIdModulo) throws Exception	{
		SistemaParameterReturnGeneral sistemaReturnGeneral=new SistemaParameterReturnGeneral();
		
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getGrupoOpcionsYOpcionsUsuario");connexion.begin();
			
			List<GrupoOpcion> grupoopcions=this.getGrupoOpcionsUsuario(usuario,lIdModulo,false);
			
			List<Opcion> opcions=this.getOpcionesUsuario(usuario,lIdModulo,false,false,false);
			
			sistemaReturnGeneral.setOpcions(opcions);
			
			sistemaReturnGeneral.setGrupoopcions(grupoopcions);
			
			this.connexion.commit();
			
		} catch(Exception ex) {
			this.connexion.rollback();
			
			throw ex;
			
		}  finally {
			this.connexion.close();
		}
		
		return sistemaReturnGeneral;
	}
	
	public List<GrupoOpcion> getGrupoOpcionsUsuario(Usuario usuario,Long lIdModulo) throws Exception	{
		return this.getGrupoOpcionsUsuario(usuario,lIdModulo,true); 
	}
	
	public List<GrupoOpcion> getGrupoOpcionsUsuario(Usuario usuario,Long lIdModulo,Boolean conConnexion) throws Exception	{
		GrupoOpcionLogic grupo_opcionLogic=new GrupoOpcionLogic();
		
		try	{
			
			if(conConnexion) {
				this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
			}
			
			grupo_opcionLogic.setConnexion(this.connexion);
			
			StringBuilder sbTableAjax=new StringBuilder();					
							
			String sSelect="";
			
			//" select distinct grupo_opcion from "+GrupoOpcionConstantesFunciones.SPERSISTENCENAME+" grupo_opcion ";
			//sSelect+=" where id_modulo = "+lIdModulo;
			
			sSelect=SistemaSql.GetWhereGrupoOpcionUsuario(this.connexionType,this.parameterDbType,lIdModulo);
			
			String sFinal="";
			
			/*		
			sFinal=" inner join opcion.perfilOpcions perfilopcion where opcion.id_modulo="+lIdSistema.toString();
			sFinal+=" and perfilopcion.id_perfil in ("+sPerfiles+") ";
			sFinal+=" and opcion.es_para_menu=true and opcion.estado=true order by opcion.posicion asc ";
			*/
					
			//opcion.field_lIdOpcion is null and 
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setInitialQuery("");
			queryWhereSelectParameters.setFinalQuery(sFinal);
					
			//grupo_opcionLogic.getEntitiesWithConnection(sSelect, queryWhereSelectParameters);
			grupo_opcionLogic.getEntities(sSelect, queryWhereSelectParameters);
			
			if(conConnexion) {
				this.connexion.commit();
			}
			
		} catch(Exception ex) {
			if(conConnexion) {
				this.connexion.rollback();
			}
			
			throw ex;
			
		}  finally {
			if(conConnexion) {
				this.connexion.close();
			}
		}
		

		return  grupo_opcionLogic.getGrupoOpcions();
	}
	
	
	public String generarArbolTemas(Usuario usuario,Long lIdSistema) throws Exception	{	
		PerfilUsuarioLogic perfilUsuarioLogic=new PerfilUsuarioLogic();
		perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuarioWithConnection("",new Pagination(), usuario.getId());
		
		String sPerfiles=new String();
		Boolean esPrimero=true;
		
		
		JSONObject jsonObjectWidget=new JSONObject();
		/*
		jsonObjectWidget.put(ConstantesJsp.SJMAKIUUID, "trvOpciones");
		jsonObjectWidget.put(ConstantesJsp.SJMAKINAME, ConstantesJsp.SJMAKIDOJODIJITTREE);
		jsonObjectWidget.put(ConstantesJsp.SJMAKIWIDGETDIR, ConstantesJsp.SJMAKIDOJODIJITTREEDIR);
		*/
		
		JSONObject jsonObjectTree=new JSONObject();	
		
		JSONArray jsonArrayNodes = new JSONArray();					
		JSONObject jsonObjectRootNode=new JSONObject();	
		jsonObjectRootNode.put(ConstantesJsp.SJMAKILABEL, "SISTEMA");
		jsonObjectRootNode.put(ConstantesJsp.SJMAKIEXPANDED, true);
		
		for(PerfilUsuario perfilusuario:perfilUsuarioLogic.getPerfilUsuarios()) {
			if(esPrimero) {
				esPrimero=false;
			} else {
				sPerfiles+=",";
			}
			
			sPerfiles+=perfilusuario.getid_perfil().toString();		
		}
		
		StringBuilder sbTableAjax=new StringBuilder();
			
		opcionLogic.setOpcions(new ArrayList<Opcion>());
		//ArrayList<Opcion> opciones=new ArrayList<Opcion>();
		
		/*
		 	select distinct * from Opcion O inner join perfilopcion PO on PO.idOpcion=O.id
		 	where O.idSistema=2 and PO.idPerfil in (1,2,3);
		*/
						
		String sSelect=" select distinct * from "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+" opcion ";
		String sFinal=" inner join "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+" perfil_opcion on perfil_opcion.id_opcion=opcion.id where opcion.id_sistema="+lIdSistema.toString();
		sFinal+=" and perfil_opcion.id_perfil in ("+sPerfiles+") ";
		sFinal+=" and opcion.id_opcion is null and opcion.es_para_menu=true and opcion.estado=true order by opcion.posicion asc ";
				
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setInitialQuery("");
		queryWhereSelectParameters.setFinalQuery(sFinal);
				
		opcionLogic.getEntitiesWithConnection(sSelect, queryWhereSelectParameters);
		
		try	{
							
			this.getEntityWithConnection(lIdSistema);
			
			TreeWidgetsExt treeWidgetsExt= new TreeWidgetsExt();
			treeWidgetsExt.setTitle(this.getSistema().getnombre_principal());
			treeWidgetsExt.setExpanded(true);		
			
			treeWidgetsExt.startCreateTree(sbTableAjax) ;	
			sbTableAjax.append(treeWidgetsExt.getStartChildren());
			
			this.getTreeAuxYahooExtHijosPrimeNivel(opcionLogic.getOpcions(),sbTableAjax,lIdSistema,sPerfiles,jsonArrayNodes);						
		
			sbTableAjax.append(treeWidgetsExt.getEndChildren());	
			treeWidgetsExt.endCreateTree(sbTableAjax) ;
			
		} catch(Exception ex) {
			throw ex;
		}
		
		jsonObjectRootNode.put(ConstantesJsp.SJMAKICHILDREN, jsonArrayNodes);
		
		//jsonObjectTree.put(ConstantesJsp.SJMAKIROOT,jsonObjectRootNode);
		//jsonObjectWidget.put(ConstantesJsp.SJMAKIVALUE,jsonObjectTree);
		
		jsonObjectWidget.put(ConstantesJsp.SJMAKIROOT,jsonObjectRootNode);
		
		//return sbTableAjax.toString();
		return  Funciones.validarJson(jsonObjectWidget.toString(),"");
	}
	
	public String generarJavaScriptUltimasOpciones(Usuario usuario,Long lIdSistema) throws Exception {	
		PerfilUsuarioLogic perfilUsuarioLogic=new PerfilUsuarioLogic();
		perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuario("",new Pagination(), usuario.getId());
		
		String sPerfiles=new String();
		Boolean esPrimero=true;
		
		for(PerfilUsuario perfilusuario:perfilUsuarioLogic.getPerfilUsuarios()) {
			if(esPrimero) {
				esPrimero=false;
			} else {
				sPerfiles+=",";
			}
			
			sPerfiles+=perfilusuario.getid_perfil().toString();		
		}
		
		StringBuilder sbTableAjax=new StringBuilder();
			
		opcionLogic.setOpcions(new ArrayList<Opcion>());
		List<Opcion> opciones=new ArrayList<Opcion>();
		
		/*
		 	select distinct * from Opcion O inner join perfilopcion PO on PO.idOpcion=O.id
		 	where O.idSistema=2 and PO.idPerfil in (1,2,3);
		*/
						
		String sSelect=" select distinct * from "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+" opcion ";
		String sFinal=" inner join "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+" perfil_opcion on perfil_opcion.id_opcion=opcion.id where opcion.id_modulo="+lIdSistema.toString();
		sFinal+=" and perfil_opcion.id_perfil in ("+sPerfiles+") ";
		sFinal+=" and opcion.es_para_menu=true and opcion.estado=true order by posicion asc ";
		
		//O.idOpcion is null and
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setInitialQuery("");
		queryWhereSelectParameters.setFinalQuery(sFinal);	
		
		opcionLogic.getEntities(sSelect, queryWhereSelectParameters);
				
		try	{				
			opciones=opcionLogic.getOpcions();	
			
			for(Opcion opcion:opciones) {
				this.traerJavaScriptUltimasOpciones(opciones,opcion,sbTableAjax);
			}
			
		} catch(Exception ex) {
			throw ex;
		}
		
		return sbTableAjax.toString();
	}
	
	public void traerJavaScriptUltimasOpciones(List<Opcion> opciones,Opcion opcion,StringBuilder sbTableAjax) throws Exception {
		Boolean isEsPadre=false;
		String sPathPagina="";
		
		for(Opcion opcionLocal:opciones) {
			if(opcion.getId().equals(opcionLocal.getid_opcion())) {
				isEsPadre=true;
				break;
			}
		}
		
		if(!isEsPadre) {
			if(opcion.getpaquete()==null) {
				opcion.setpaquete("");
			}
			
			sPathPagina=/*this.getRelativePathUrl(opcion)+*/Constantes.SCARPETAPAGINAS.trim()+"/"+ opcion.getpaquete().trim()+opcion.getnombre_clase().trim();
			
			if(sbTableAjax.toString().length()>10) {
				sbTableAjax.append("\n\telse if(args.message.targetId=='"+sPathPagina+"')");
				sbTableAjax.append("\n\t{");
				sbTableAjax.append("\n\t\tpagina='"+sPathPagina+"';");
				sbTableAjax.append("\n\t}");
			} else {
				sbTableAjax.append("\n\tif(args.message.targetId=='"+sPathPagina+"')");
				sbTableAjax.append("\n\t{");
				sbTableAjax.append("\n\t\tpagina='"+sPathPagina+"';");
				sbTableAjax.append("\n\t}");
			}		
		}
	}
	
	public void getTreeAuxYahooExtHijosPrimeNivel(List<Opcion> opcionesPadres,StringBuilder sbTableAjax,Long lIdSistema,String sPerfiles,JSONArray jsonArrayNodes) throws Exception {
		try {
			//TreeAuxYahooExt auxTreeYahoo=new TreeAuxYahooExt();	
			//TreeAuxYahooExt auxTreeYahooHijo=new TreeAuxYahooExt();				
			//ArrayList<TreeAuxYahooExt> auxTreesYahooHijos=new ArrayList<TreeAuxYahooExt>();
			//ArrayList<Opcion> temas=new ArrayList<Opcion>();
			String strPaquete="";
			
			List<Opcion> temasHijos=new ArrayList<Opcion>();
										
			Integer iCount=1;
			
			JSONObject jsonObjectNode=null;
			JSONObject jsonObjectMessage=null;	
			JSONObject jsonObjectTargetId=null;	
			
			for(Opcion tema:opcionesPadres)	{
				strPaquete="";
				
				temasHijos=new ArrayList<Opcion>();	
				setTitle(tema,sbTableAjax);				
				
				jsonObjectNode=new JSONObject();
				jsonObjectMessage=new JSONObject();
				jsonObjectTargetId=new JSONObject();	
				
				if(tema.getpaquete()!=null) {
					strPaquete=tema.getpaquete();
				}
				
				jsonObjectTargetId.put(ConstantesJsp.SJMAKITARGETID, strPaquete+tema.getnombre_clase());
				jsonObjectMessage.put(ConstantesJsp.SJMAKIMESSAGE, jsonObjectTargetId);
				
				jsonObjectNode.put(ConstantesJsp.SJMAKILABEL,Funciones.validarCampoJson(tema.getnombre().toString(),""));	
				jsonObjectNode.put(ConstantesJsp.SJMAKIEXPANDED,true);
				jsonObjectNode.put(ConstantesJsp.SJMAKIACTION,jsonObjectMessage);	
				
				temasHijos=this.getOpcionesHijos(tema,lIdSistema,sPerfiles);
										
				if(temasHijos.size()>0)	{
							
					sbTableAjax.append(",");
					sbTableAjax.append(TreeAuxYahooExt.getStartChildren());	
					
					Integer iCountHijo=1;			
					
					for(Opcion temaHijo:temasHijos)	{																	
						
						this.getTreeAuxYahooExtItem(temaHijo,sbTableAjax,false,lIdSistema,sPerfiles,jsonObjectNode);
						
						if(!iCountHijo.equals(temasHijos.size())) {
							sbTableAjax.append(",");											
						}
									
						iCountHijo++;
					}
					
					sbTableAjax.append(TreeAuxYahooExt.getEndChildren());
				}
							
				sbTableAjax.append(TreeAuxYahooExt.getEndKey());
			   
				
				if(!iCount.equals(opcionesPadres.size())) {
					sbTableAjax.append(",");	
				}
				
				iCount++;	
				
				jsonArrayNodes.put(jsonObjectNode);
			}//for
			
		} catch(Exception ex) {
			throw ex;
		}				
	}
	
	public void setUrl(Opcion tema,StringBuilder sbTableAjax) throws Exception {				
		try	{							
			sbTableAjax.append(",");
			sbTableAjax.append("action : {topic:'/foo/select',message : {targetId : '");
			//this.setRelativePathUrl(tema,sbTableAjax);
			sbTableAjax.append(Constantes.SCARPETAPAGINAS.trim()+"/");
			sbTableAjax.append(tema.getpaquete().trim());
			sbTableAjax.append(tema.getnombre_clase().trim());
			sbTableAjax.append(TreeAuxYahooExt.getEndItem());
			sbTableAjax.append(TreeAuxYahooExt.getEndKey());
			sbTableAjax.append(TreeAuxYahooExt.getEndKey());
		
		} catch(Exception ex) {
			throw ex;
		}		
	}
	
	public void setRelativePathUrl(Opcion opcion,StringBuilder sbTableAjax) throws Exception {				
		try	{								
			sbTableAjax.append(this.getRelativePathUrl(opcion));
			
		} catch(Exception ex) {
			throw ex;
		}			
	}
	
	public String getRelativePathUrl(Opcion opcion) throws Exception {			
		String sRelativePath="";
		String sRelativePathCarpetaPaginas="../";
		
		try	{		
			String[] sCarpetas= opcion.getpaquete().trim().split("/");
			
			for(String sCarpeta:sCarpetas) {
				if(!sCarpeta.equals("")) {
					sRelativePath+="../";
				}
			}

			return sRelativePathCarpetaPaginas+sRelativePath;
			
		} catch(Exception ex) {
			throw ex;
		}				
	}
	
	public void setTitle(Opcion tema,StringBuilder sbTableAjax) throws Exception {				
		try	{
			TreeAuxYahooExt auxTreeYahoo=new TreeAuxYahooExt();	
			auxTreeYahoo.setExpanded(true);
			
			sbTableAjax.append(TreeAuxYahooExt.getStartTreeTitle());
			sbTableAjax.append(" * "+tema.getnombre());
			sbTableAjax.append(TreeAuxYahooExt.getEndItem());	
			
		} catch(Exception ex) {
			throw ex;
		}		
	}
	
	public List<Opcion> getOpcionesHijos(Opcion opcionPadre,Long lIdSistema,String sPerfiles) throws Exception {		
		String sSelect=" select distinct * from "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+" opcion ";
		String sFinal=" inner join "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+" perfil_opcion on perfil_opcion.id_opcion=opcion.id where opcion.id_sistema="+lIdSistema.toString();
		sFinal+=" and perfil_opcion.id_perfil in ("+sPerfiles+") and opcion.id_opcion="+opcionPadre.getId().toString();
		sFinal+=" and opcion.es_para_menu=true and opcion.estado=true order by opcion.posicion asc ";
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setInitialQuery("");
		queryWhereSelectParameters.setFinalQuery(sFinal);
		
		opcionLogic.setOpcions(new ArrayList<Opcion>());
		opcionLogic.getEntitiesWithConnection(sSelect, queryWhereSelectParameters);
		
		return opcionLogic.getOpcions();
	}
	
	public void getTreeAuxYahooExtItem(Opcion tema,StringBuilder sbTableAjax,Boolean teniaHermanos,Long lIdSistema,String sPerfiles,JSONObject jsonObjectNode) throws Exception	{		
		try	{					
			List<Opcion> opcionesHijos=new ArrayList<Opcion>();
			
			this.setTitle(tema,sbTableAjax);				
			this.setUrl(tema,sbTableAjax);
			
			JSONObject jsonObjectMessage=null;	
			JSONObject jsonObjectTargetId=null;	
			
			jsonObjectMessage=new JSONObject();
			jsonObjectTargetId=new JSONObject();	
			
			jsonObjectTargetId.put(ConstantesJsp.SJMAKITARGETID, tema.getpaquete()+tema.getnombre_clase());
			jsonObjectMessage.put(ConstantesJsp.SJMAKIMESSAGE, jsonObjectTargetId);
			
			jsonObjectNode.put(ConstantesJsp.SJMAKILABEL,Funciones.validarCampoJson(tema.getnombre().toString(),""));	
			jsonObjectNode.put(ConstantesJsp.SJMAKIEXPANDED,true);
			jsonObjectNode.put(ConstantesJsp.SJMAKIACTION,jsonObjectMessage);	
			
			
			opcionesHijos=this.getOpcionesHijos(tema,lIdSistema,sPerfiles);
			
			Integer iCount=1;		
			
			if(opcionesHijos.size()>0) {
				
				sbTableAjax.append(",");
				sbTableAjax.append(TreeAuxYahooExt.getStartChildren());	
				
				Integer iCountHijo=1;			
				JSONObject jsonObjectNodeHijo=null;
				JSONObject jsonObjectMessageHijo=null;	
				JSONObject jsonObjectTargetIdHijo=null;	
				
				JSONArray jsonArrayNodes = new JSONArray();	
				
				for(Opcion temaHijo:opcionesHijos) {
					
					
					jsonObjectNodeHijo=new JSONObject();
					
					/*
					jsonObjectMessageHijo=new JSONObject();
					jsonObjectTargetIdHijo=new JSONObject();	
					
					jsonObjectTargetIdHijo.put(ConstantesJsp.SJMAKITARGETID, tema.getpaquete()+tema.getnombre_clase());
					jsonObjectMessageHijo.put(ConstantesJsp.SJMAKIMESSAGE, jsonObjectTargetIdHijo);
					
					jsonObjectNodeHijo.put(ConstantesJsp.SJMAKILABEL,Funciones.validarCampoJson(tema.getnombre().toString(),""));	
					jsonObjectNodeHijo.put(ConstantesJsp.SJMAKIEXPANDED,true);
					jsonObjectNodeHijo.put(ConstantesJsp.SJMAKIACTION,jsonObjectMessageHijo);	
					*/
					
					if(!iCountHijo.equals(opcionesHijos.size()))	{
						this.getTreeAuxYahooExtItem(temaHijo,sbTableAjax,true,lIdSistema,sPerfiles,jsonObjectNodeHijo);
						
						sbTableAjax.append(",");
						
					} else {	
						this.getTreeAuxYahooExtItem(temaHijo,sbTableAjax,false,lIdSistema,sPerfiles,jsonObjectNodeHijo);
					}
					
					iCountHijo++;
					
					jsonArrayNodes.put(jsonObjectNodeHijo);
				}	
				
				jsonObjectNode.put(ConstantesJsp.SJMAKICHILDREN, jsonArrayNodes);
					
				sbTableAjax.append(TreeAuxYahooExt.getEndChildren());
			}
						
			sbTableAjax.append(TreeAuxYahooExt.getEndKey());
			
			if(teniaHermanos) {
				sbTableAjax.append(",");
			}
			
			iCount++;		
			
		} catch(Exception ex) {
			throw ex;
		}				
	}
	
	public Boolean tienePermisosEnPaginaWeb(Usuario usuario,Long lIdSistema,String sPagina) throws Exception {
		Boolean isTienePermisos=false;
		
		try	{
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);this.connexion.begin();						
			
			PerfilOpcionLogic perfilOpcionLogic=new PerfilOpcionLogic();						
			PerfilUsuarioLogic perfilUsuarioLogic=new PerfilUsuarioLogic();
			
			perfilUsuarioLogic.setConnexion(this.connexion);
			perfilOpcionLogic.setConnexion(this.connexion);
			
			//perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuarioWithConnection("",new Pagination(), usuario.getId());
			perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuario("",new Pagination(), usuario.getId());
			
			String sPerfiles=new String();
			Boolean esPrimero=true;
			
			for(PerfilUsuario perfilusuario:perfilUsuarioLogic.getPerfilUsuarios())	{
				if(esPrimero) {
					esPrimero=false;
				} else {
					sPerfiles+=",";
				}
				
				sPerfiles+=perfilusuario.getid_perfil().toString();		
			}
			
			//StringBuilder sbPermisos=new StringBuilder();
				
			opcionLogic.setOpcions(new ArrayList<Opcion>());
			//ArrayList<Opcion> opciones=new ArrayList<Opcion>();
			
			/*
			 	select distinct * from Opcion O inner join perfilopcion PO on PO.idOpcion=O.id
			 	where O.idSistema=2 and PO.idPerfil in (1,2,3);
			*/
							
			String sSelect=" select distinct * from "+PerfilOpcionConstantesFunciones.SCHEMA+".perfil_opcion perfil_opcion";
			String sFinal="  inner join "+OpcionConstantesFunciones.SCHEMA+".opcion opcion on perfil_opcion.id_opcion=opcion.id";		
			sFinal+=" where opcion.id_sistema="+lIdSistema.toString();
			sFinal+=" and perfil_opcion.id_perfil in ("+sPerfiles+") and opcion.nombre_clase = '"+sPagina+"'";
			sFinal+=" and perfil_opcion.estado=true ";
					
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setInitialQuery("");
			queryWhereSelectParameters.setFinalQuery(sFinal);
				
				
			//perfilOpcionLogic.getEntitiesWithConnection(sSelect, queryWhereSelectParameters);
			perfilOpcionLogic.getEntities(sSelect, queryWhereSelectParameters);
									
			if(perfilOpcionLogic.getPerfilOpcions()!=null&&perfilOpcionLogic.getPerfilOpcions().size()>0) {			
				isTienePermisos=true;					
			}		
									
			this.connexion.commit();
			
		} catch(Exception ex) {
			this.connexion.rollback();
			
			throw ex;
			
		} finally {
			connexion.close();	
		}
		
		return isTienePermisos;
	}
	
	public ArrayList<String> tienePermisosEnPaginaWeb(Usuario usuario,Long lIdSistema,ArrayList<String> arrPaginas) throws Exception {
		//Boolean isTienePermisos=false;
		ArrayList<String> arrPaginasFinal=new ArrayList<String>();
		
		try	{
			
			if(arrPaginas.size()<=0) {
				return arrPaginasFinal;
			}
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-tienePermisosEnPaginaWeb");this.connexion.begin();						
			
			
			
			PerfilOpcionLogic perfilOpcionLogic=new PerfilOpcionLogic();						
			PerfilUsuarioLogic perfilUsuarioLogic=new PerfilUsuarioLogic();
			this.opcionLogic=new OpcionLogic();
			
			perfilUsuarioLogic.setConnexion(this.connexion);
			perfilOpcionLogic.setConnexion(this.connexion);
			this.opcionLogic.setConnexion(this.connexion);
			
			//perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuarioWithConnection("",new Pagination(), usuario.getId());
			perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuario("",new Pagination(), usuario.getId());
			
			String sPerfiles=new String();
			Boolean esPrimero=true;
			
			for(PerfilUsuario perfilusuario:perfilUsuarioLogic.getPerfilUsuarios())	{
				if(esPrimero) {
					esPrimero=false;
				} else {
					sPerfiles+=",";
				}
				
				sPerfiles+=perfilusuario.getid_perfil().toString();		
			}
			
			
			String sPaginas=new String();
			esPrimero=true;
			
			for(String sPagina:arrPaginas)	{
				if(esPrimero) {
					esPrimero=false;
				} else {
					sPaginas+=",";
				}
				
				sPaginas+="'"+sPagina+"'";		
			}
			
			//StringBuilder sbPermisos=new StringBuilder();
				
			opcionLogic.setOpcions(new ArrayList<Opcion>());
			
			/*				
			String sSelect=" select distinct * from "+PerfilOpcionConstantesFunciones.SCHEMA+".perfil_opcion ";
			String sFinal="  inner join "+OpcionConstantesFunciones.SCHEMA+".opcion opcion on perfil_opcion.id_opcion=opcion.id";		
			sFinal+=" where opcion.id_sistema="+lIdSistema.toString();
			sFinal+=" and perfil_opcion.id_perfil in ("+sPerfiles+") and opcion.nombre_clase = '"+sPagina+"'";
			sFinal+=" and perfil_opcion.estado=true ";
					
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setInitialQuery("");
			queryWhereSelectParameters.setFinalQuery(sFinal);
				
				
			//perfilOpcionLogic.getEntitiesWithConnection(sSelect, queryWhereSelectParameters);
			perfilOpcionLogic.getEntities(sSelect, queryWhereSelectParameters);
									
			if(perfilOpcionLogic.getPerfilOpcions()!=null&&perfilOpcionLogic.getPerfilOpcions().size()>0) {			
				isTienePermisos=true;					
			}		
			*/
			
			String sSelect=" select distinct * from "+OpcionConstantesFunciones.SCHEMA+".opcion opcion";
			String sFinal="  inner join "+PerfilOpcionConstantesFunciones.SCHEMA+".perfil_opcion perfil_opcion on perfil_opcion.id_opcion=opcion.id";		
			sFinal+=" where opcion.id_sistema="+lIdSistema.toString();
			sFinal+=" and perfil_opcion.id_perfil in ("+sPerfiles+") and opcion.nombre_clase in ("+sPaginas+")";
			sFinal+=" and perfil_opcion.estado=true ";
					
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setInitialQuery("");
			queryWhereSelectParameters.setFinalQuery(sFinal);
				
				
			this.opcionLogic.getEntities(sSelect, queryWhereSelectParameters);
			
			for(Opcion opcion:this.opcionLogic.getOpcions()) {
				arrPaginasFinal.add(opcion.getnombre_clase());
			}
			
			this.connexion.commit();
			
		} catch(Exception ex) {
			this.connexion.rollback();
			
			throw ex;
			
		} finally {
			connexion.close();	
		}
		
		return arrPaginasFinal;
	}
	
	public ArrayList<Opcion> tienePermisosOpcionesEnPaginaWeb(Usuario usuario,Long lIdSistema,ArrayList<String> arrPaginas) throws Exception {
		return tienePermisosOpcionesEnPaginaWeb(usuario,lIdSistema,arrPaginas,true);
	}
	
	public ArrayList<Opcion> tienePermisosOpcionesEnPaginaWeb(Usuario usuario,Long lIdSistema,ArrayList<String> arrPaginas,Boolean conConnexion) throws Exception {
		//Boolean isTienePermisos=false;
		ArrayList<Opcion> opcionsFinal=new ArrayList<Opcion>();
		
		try	{
			
			if(arrPaginas.size()<=0) {
				return opcionsFinal;
			}
			
			if(conConnexion) {
				this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-tienePermisosOpcionesEnPaginaWeb");this.connexion.begin();						
			}
			
			
			PerfilOpcionLogic perfilOpcionLogic=new PerfilOpcionLogic();						
			PerfilUsuarioLogic perfilUsuarioLogic=new PerfilUsuarioLogic();
			this.opcionLogic=new OpcionLogic();
			
			perfilUsuarioLogic.setConnexion(this.connexion);
			perfilOpcionLogic.setConnexion(this.connexion);
			this.opcionLogic.setConnexion(this.connexion);
			
			//perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuarioWithConnection("",new Pagination(), usuario.getId());
			perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuario("",new Pagination(), usuario.getId());
			
			String sPerfiles=new String();
			Boolean esPrimero=true;
			
			for(PerfilUsuario perfilusuario:perfilUsuarioLogic.getPerfilUsuarios())	{
				if(esPrimero) {
					esPrimero=false;
				} else {
					sPerfiles+=",";
				}
				
				sPerfiles+=perfilusuario.getid_perfil().toString();		
			}
			
			
			String sPaginas=new String();
			esPrimero=true;
			
			for(String sPagina:arrPaginas)	{
				if(esPrimero) {
					esPrimero=false;
				} else {
					sPaginas+=",";
				}
				
				sPaginas+="'"+sPagina+"'";		
			}
			
			//StringBuilder sbPermisos=new StringBuilder();
				
			opcionLogic.setOpcions(new ArrayList<Opcion>());
			
			/*				
			String sSelect=" select distinct * from "+PerfilOpcionConstantesFunciones.SCHEMA+".perfil_opcion ";
			String sFinal="  inner join "+OpcionConstantesFunciones.SCHEMA+".opcion opcion on perfil_opcion.id_opcion=opcion.id";		
			sFinal+=" where opcion.id_sistema="+lIdSistema.toString();
			sFinal+=" and perfil_opcion.id_perfil in ("+sPerfiles+") and opcion.nombre_clase = '"+sPagina+"'";
			sFinal+=" and perfil_opcion.estado=true ";
					
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setInitialQuery("");
			queryWhereSelectParameters.setFinalQuery(sFinal);
				
				
			//perfilOpcionLogic.getEntitiesWithConnection(sSelect, queryWhereSelectParameters);
			perfilOpcionLogic.getEntities(sSelect, queryWhereSelectParameters);
									
			if(perfilOpcionLogic.getPerfilOpcions()!=null&&perfilOpcionLogic.getPerfilOpcions().size()>0) {			
				isTienePermisos=true;					
			}		
			*/
			
			String sSelect=" select distinct * from "+OpcionConstantesFunciones.SCHEMA+".opcion opcion";
			String sFinal="  inner join "+PerfilOpcionConstantesFunciones.SCHEMA+".perfil_opcion perfil_opcion on perfil_opcion.id_opcion=opcion.id";		
			sFinal+=" where opcion.id_sistema="+lIdSistema.toString();
			sFinal+=" and perfil_opcion.id_perfil in ("+sPerfiles+") and opcion.nombre_clase in ("+sPaginas+")";
			sFinal+=" and perfil_opcion.estado=true ";
					
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setInitialQuery("");
			queryWhereSelectParameters.setFinalQuery(sFinal);
				
				
			this.opcionLogic.getEntities(sSelect, queryWhereSelectParameters);
			
			for(Opcion opcion:this.opcionLogic.getOpcions()) {
				opcionsFinal.add(opcion);
			}
			
			if(conConnexion) {
				this.connexion.commit();
			}
			
		} catch(Exception ex) {
			if(conConnexion) {
				this.connexion.rollback();
			}
			
			throw ex;
			
		} finally {
			if(conConnexion) {
				connexion.close();
			}
		}
		
		return opcionsFinal;
	}
	
	public String traerPermisosPaginaWeb(Usuario usuario,Long lIdSistema,String sPagina) throws Exception {	
		PerfilOpcionLogic perfilOpcionLogic=new PerfilOpcionLogic();
		
		PerfilUsuarioLogic perfilUsuarioLogic=new PerfilUsuarioLogic();
		perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuarioWithConnection("",new Pagination(), usuario.getId());
		
		String sPerfiles=new String();
		Boolean esPrimero=true;
		
		for(PerfilUsuario perfilusuario:perfilUsuarioLogic.getPerfilUsuarios())	{
			if(esPrimero) {
				esPrimero=false;
			} else {
				sPerfiles+=",";
			}
			
			sPerfiles+=perfilusuario.getid_perfil().toString();		
		}
		
		StringBuilder sbPermisos=new StringBuilder();
			
		opcionLogic.setOpcions(new ArrayList<Opcion>());
		//ArrayList<Opcion> opciones=new ArrayList<Opcion>();
		
		/*
		 	select distinct * from Opcion O inner join perfilopcion PO on PO.idOpcion=O.id
		 	where O.idSistema=2 and PO.idPerfil in (1,2,3);
		*/
						
		String sSelect=" select distinct * from "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+" perfil_opcion ";
		String sFinal="  inner join "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+" opcion on perfil_opcion.id_opcion=opcion.id where opcion.id_sistema="+lIdSistema.toString();
		sFinal+=" and perfil_opcion.id_perfil in ("+sPerfiles+") and opcion.nombre_clase= '"+sPagina+"'";
		sFinal+=" and perfil_opcion.estado=true ";
				
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setInitialQuery("");
		queryWhereSelectParameters.setFinalQuery(sFinal);
				
		try	{			
			perfilOpcionLogic.getEntitiesWithConnection(sSelect, queryWhereSelectParameters);
					
			if(perfilOpcionLogic.getPerfilOpcions()!=null) {
				
				for(PerfilOpcion perfilopcion:perfilOpcionLogic.getPerfilOpcions())	{
					
					if(perfilopcion.gettodo())	{
						sbPermisos.append(SistemaLogicAdditional.STODO);
					}
					
					if(perfilopcion.getbusqueda())	{
						if(sbPermisos.length()>0)	{
							sbPermisos.append(",");
						}
						
						sbPermisos.append(SistemaLogicAdditional.SBUSQUEDA);
					}
					
					if(perfilopcion.getconsulta())	{
						if(sbPermisos.length()>0)	{
							sbPermisos.append(",");
						}
						
						sbPermisos.append(SistemaLogicAdditional.SCONSULTA);
					}
					
					if(perfilopcion.getingreso()) {
						if(sbPermisos.length()>0)	{
							sbPermisos.append(",");
						}
						
						sbPermisos.append(SistemaLogicAdditional.SINGRESO);
					}
					
					if(perfilopcion.getmodificacion())	{
						if(sbPermisos.length()>0)	{
							sbPermisos.append(",");
						}
						
						sbPermisos.append(SistemaLogicAdditional.SMODIFICACION);
					}
					
					if(perfilopcion.geteliminacion()) {
						if(sbPermisos.length()>0) {
							sbPermisos.append(",");
						}
						
						sbPermisos.append(SistemaLogicAdditional.SELIMINACION);
					}
					
					break;
				}
			}				
		} catch(Exception ex) {
			throw ex;
		}
		
		return sbPermisos.toString();
	}
	
	public PerfilOpcion traerPermisosPaginaWebPerfilOpcion(Usuario usuario,Long lIdSistema,String sPagina,Long id_opcion) throws Exception {
		return traerPermisosPaginaWebPerfilOpcion(usuario,lIdSistema,sPagina,id_opcion,true) ;
	}
	
	public PerfilOpcion traerPermisosPaginaWebPerfilOpcion(Usuario usuario,Long lIdSistema,String sPagina,Long id_opcion,Boolean conConnexion) throws Exception {
		PerfilOpcion perfilOpcionDeUsuario=new PerfilOpcion();
		
		try {
			
			if(conConnexion) {
				this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-traerPermisosPaginaWebPerfilOpcion");this.connexion.begin();						
			}
			
			PerfilOpcionLogic perfilOpcionLogic=new PerfilOpcionLogic();			
			PerfilUsuarioLogic perfilUsuarioLogic=new PerfilUsuarioLogic();
			
			
			perfilUsuarioLogic.setConnexion(this.connexion);
			perfilOpcionLogic.setConnexion(this.connexion);
			
			
			perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuario("",new Pagination(), usuario.getId());
			
			String sPerfiles=new String();
			Boolean esPrimero=true;
			
			for(PerfilUsuario perfilusuario:perfilUsuarioLogic.getPerfilUsuarios())	{
				if(esPrimero) {
					esPrimero=false;
				} else {
					sPerfiles+=",";
				}
				
				sPerfiles+=perfilusuario.getid_perfil().toString();		
			}
			
			opcionLogic.setOpcions(new ArrayList<Opcion>());
			//ArrayList<Opcion> opciones=new ArrayList<Opcion>();
			
			/*
			 	select distinct * from Opcion O inner join perfilopcion PO on PO.idOpcion=O.id
			 	where O.idSistema=2 and PO.idPerfil in (1,2,3);
			*/
							
			String sSelect=" select distinct * from "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+" perfil_opcion";
			String sFinal="  inner join "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+" opcion on perfil_opcion.id_opcion=opcion.id where opcion.id_sistema="+lIdSistema.toString();
			sFinal+=" and perfil_opcion.id_perfil in ("+sPerfiles+")";
			
			if(id_opcion!=null && id_opcion>0) {
				sFinal+=" and opcion.id= "+id_opcion;
			} else {
				sFinal+=" and opcion.nombre_clase= '"+sPagina+"'";
			}
			
			sFinal+=" and perfil_opcion.estado=true ";
					
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setInitialQuery("");
			queryWhereSelectParameters.setFinalQuery(sFinal);
					
			try	{			
				perfilOpcionLogic.getEntities(sSelect, queryWhereSelectParameters);
						
				if(perfilOpcionLogic.getPerfilOpcions()!=null) {
					
					for(PerfilOpcion perfilopcion:perfilOpcionLogic.getPerfilOpcions())	{					
						perfilOpcionDeUsuario=perfilopcion;					
						break;
					}
				}				
			} catch(Exception ex) {
				throw ex;
			}
			
			if(conConnexion) {
				this.connexion.commit();
			}
			
		} catch(Exception e) {
			if(conConnexion) {
				this.connexion.rollback();
			}
			
			throw e;
			
		}  finally {
			
			if(conConnexion) {
				connexion.close();	
			}
		}
		
		return perfilOpcionDeUsuario;
	}
	
	public String traerPermisosAccionesPaginaWeb(Usuario usuario,Long lIdSistema,String sPagina,Long id_opcion) throws Exception {	
		PerfilOpcionLogic perfilOpcionLogic=new PerfilOpcionLogic();
		
		PerfilUsuarioLogic perfilUsuarioLogic=new PerfilUsuarioLogic();
		perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuarioWithConnection("",new Pagination(), usuario.getId());
		
		PerfilAccionLogic perfilAccionLogic=new PerfilAccionLogic();
		AccionLogic accionLogic=new AccionLogic();
		
		String sPerfiles=new String();
		Boolean esPrimero=true;
		
		for(PerfilUsuario perfilusuario:perfilUsuarioLogic.getPerfilUsuarios())	{
			if(esPrimero) {
				esPrimero=false;
			} else {
				sPerfiles+=",";
			}
			
			sPerfiles+=perfilusuario.getid_perfil().toString();		
		}
		
		StringBuilder sbPermisosAcciones=new StringBuilder();
			
		opcionLogic.setOpcions(new ArrayList<Opcion>());
		//ArrayList<Opcion> opciones=new ArrayList<Opcion>();
		
		/*
		 	select distinct * from Opcion O inner join perfilopcion PO on perfilopcion.idOpcion=opcion.id
		 	where opcion.idSistema=2 and perfilopcion.idPerfil in (1,2,3);
		*/
						
		String sSelect=" select distinct * from "+PerfilOpcionConstantesFunciones.SCHEMA+"."+PerfilOpcionConstantesFunciones.TABLENAME+" perfil_opcion ";
		String sFinal="  inner join "+OpcionConstantesFunciones.SCHEMA+"."+OpcionConstantesFunciones.TABLENAME+" opcion where opcion.id_sistema="+lIdSistema.toString();
		sFinal+=" and perfil_opcion.id_perfil in ("+sPerfiles+") ";
		
		if(id_opcion!=null && id_opcion>0) {
			sFinal+="and opcion.id= "+id_opcion;
		} else {
			sFinal+="and opcion.nombre_clase= '"+sPagina+"'";
		}
		
		sFinal+=" and perfil_opcion.estado=true ";
				
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		queryWhereSelectParameters.setInitialQuery("");
		queryWhereSelectParameters.setFinalQuery(sFinal);
			
		try {		
			perfilOpcionLogic.getEntitiesWithConnection(sSelect, queryWhereSelectParameters);
			
			Boolean isEsPerfilAccionPrimero=false;
			
			if(perfilOpcionLogic.getPerfilOpcions()!=null) {
				
				for(PerfilOpcion perfilopcion:perfilOpcionLogic.getPerfilOpcions())	{
					
					accionLogic.getAccionsFK_IdOpcionWithConnection("",new Pagination(), perfilopcion.getid_opcion());
					
					isEsPerfilAccionPrimero=false;
					
					for(Accion accion:accionLogic.getAccions())	{
						queryWhereSelectParameters=new QueryWhereSelectParameters();
						queryWhereSelectParameters.setInitialQuery("");
						queryWhereSelectParameters.setFinalQuery(" where "+PerfilAccionConstantesFunciones.IDPERFIL+"="+perfilopcion.getid_perfil()+" and "+PerfilAccionConstantesFunciones.IDACCION+"="+accion.getId());
						
						perfilAccionLogic.setPerfilAccions(new ArrayList<PerfilAccion>());
						perfilAccionLogic.getEntitiesSimpleQueryBuildWithConnection(PerfilAccionDataAccess.QUERYSELECT, queryWhereSelectParameters);
						
						for(PerfilAccion perfilAccion:perfilAccionLogic.getPerfilAccions())	{
							if(!isEsPerfilAccionPrimero) {
								isEsPerfilAccionPrimero=true;
								sbPermisosAcciones.append(accion.getcodigo());
							} else	{
								sbPermisosAcciones.append(",");								
								sbPermisosAcciones.append(accion.getcodigo());
							}
						}
					}	
					
					break;
				}
			}			
			
		} catch(Exception ex) {
			throw ex;
		}
		
		return sbPermisosAcciones.toString();
	}
	
	public List<Accion> getAccionesUsuario(Usuario usuario,Opcion opcion) throws Exception {
		List<Accion> accionesUsuario=new ArrayList<Accion>();
		
		accionesUsuario=this.getAccionesUsuario(usuario,opcion,false);
				
		return accionesUsuario;
	}
	
	public List<Accion> getAccionesUsuario(Usuario usuario,Opcion opcion,Boolean soloParaFormulario) throws Exception {
		return this.getAccionesUsuario(usuario,opcion,soloParaFormulario,true);
	}
	
	public List<Accion> getAccionesUsuario(Usuario usuario,Opcion opcion,Boolean soloParaFormulario,Boolean conConnexion) throws Exception {
		ArrayList<Accion> accionesUsuario=new ArrayList<Accion>();
		
		try {
			
			if(conConnexion) {
				this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getAccionesUsuario");connexion.begin();
			}
			
			//PerfilOpcionLogic perfilOpcionLogic=new PerfilOpcionLogic();			
			PerfilUsuarioLogic perfilUsuarioLogic=new PerfilUsuarioLogic();
			AccionLogic accionLogic=new AccionLogic();
			//PerfilAccionLogic perfilAccionLogic=new PerfilAccionLogic();
			
			perfilUsuarioLogic.setConnexion(this.connexion);
			//perfilOpcionLogic.setConnexion(this.connexion);
			accionLogic.setConnexion(this.connexion);
			//perfilAccionLogic.setConnexion(this.connexion);
			
			//perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuarioWithConnection("",new Pagination(), usuario.getId());
			perfilUsuarioLogic.getPerfilUsuariosFK_IdUsuario("",new Pagination(), usuario.getId());
			
			
			
						
			String sPerfiles=new String();
			String sFinalQuery="";
			String sFinalQuerySoloParaFormulario="";
			String sQueryPerfil="";
			Boolean esPrimero=true;
			
			for(PerfilUsuario perfilusuario:perfilUsuarioLogic.getPerfilUsuarios())	{
				if(esPrimero) {
					esPrimero=false;
				} else {
					sPerfiles+=",";
				}
				
				sPerfiles+=perfilusuario.getid_perfil().toString();		
			}
			
			StringBuilder sbPermisosAcciones=new StringBuilder();
				
			opcionLogic.setOpcions(new ArrayList<Opcion>());
			//ArrayList<Opcion> opciones=new ArrayList<Opcion>();
			
			/*
			 	select distinct * from Opcion O inner join perfilopcion PO on perfilopcion.idOpcion=opcion.id
			 	where opcion.idSistema=2 and perfilopcion.idPerfil in (1,2,3);
			*/
						
			
			/*
			String sSelect=" select distinct * from "+PerfilOpcionConstantesFunciones.SCHEMA+".perfil_opcion ";
			String sFinal="  inner join "+OpcionConstantesFunciones.SCHEMA+".opcion on perfil_opcion.id_opcion=opcion.id where opcion.id_sistema="+opcion.getid_sistema();
			sFinal+=" and perfil_opcion.id_perfil in ("+sPerfiles+") and opcion.id= "+opcion.getId()+"";
			sFinal+=" and perfil_opcion.estado=true ";
					
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setInitialQuery("");
			queryWhereSelectParameters.setFinalQuery(sFinal);
			
				
			//perfilOpcionLogic.getEntitiesWithConnection(sSelect, queryWhereSelectParameters);
			perfilOpcionLogic.getEntities(sSelect, queryWhereSelectParameters);
			
			
			Boolean isEsPerfilAccionPrimero=false;
			
			if(perfilOpcionLogic.getPerfilOpcions()!=null) {
				
				for(PerfilOpcion perfilopcion:perfilOpcionLogic.getPerfilOpcions())	{
					
					//accionLogic.getAccionsFK_IdOpcionWithConnection("",new Pagination(), perfilopcion.getid_opcion());
					
					sFinalQuery=" where id_opcion="+perfilopcion.getid_opcion() +" order by orden asc";
					
					//accionLogic.getEntitiesWithConnection(sFinalQuery);
					accionLogic.getEntities(sFinalQuery);
					
					isEsPerfilAccionPrimero=false;
					
					for(Accion accion:accionLogic.getAccions())	{
						queryWhereSelectParameters=new QueryWhereSelectParameters();
						queryWhereSelectParameters.setInitialQuery("");
						queryWhereSelectParameters.setFinalQuery(" where "+PerfilAccionDataAccess.getColumnNameidPerfil()+"="+perfilopcion.getid_perfil()+" and "+PerfilAccionDataAccess.getColumnNameidAccion()+"="+accion.getId());
						
						perfilAccionLogic.setPerfilAccions(new ArrayList<PerfilAccion>());
						//perfilAccionLogic.getEntitiesSimpleQueryBuildWithConnection(PerfilAccionDataAccess.QUERYSELECTNATIVE, queryWhereSelectParameters);
						perfilAccionLogic.getEntitiesSimpleQueryBuild(PerfilAccionDataAccess.QUERYSELECTNATIVE, queryWhereSelectParameters);						
						
						for(PerfilAccion perfilAccion:perfilAccionLogic.getPerfilAccions())	{
							if(perfilAccion.getejecusion() && perfilAccion.getestado()) {
								accionesUsuario.add(accion);
							}
							break;
						}						
					}						
					break;
				}
			}		
			*/
			
			if(soloParaFormulario) {
				sFinalQuerySoloParaFormulario=" and solo_form=true ";
			}
			
			if(!sPerfiles.equals("")) {
				sQueryPerfil=" and perfil_accion.id_perfil in ("+sPerfiles+") ";				
			} else {
				sQueryPerfil=" and perfil_accion.id_perfil in (-1) ";	
			}
			
			sFinalQuery=" inner join "+PerfilAccionConstantesFunciones.SCHEMA+"."+PerfilAccionConstantesFunciones.TABLENAME+" perfil_accion on perfil_accion.id_accion=accion.id ";
			sFinalQuery+=" where accion.id_opcion="+opcion.getId()+sQueryPerfil;
			sFinalQuery+=" and perfil_accion.ejecusion=true and accion.estado=true"+sFinalQuerySoloParaFormulario+" order by accion.orden asc";
			
			accionLogic.getEntities(sFinalQuery);
			
			accionesUsuario.addAll(accionLogic.getAccions());
			
			if(conConnexion) {
				this.connexion.commit();
			}
			
		} catch(Exception ex) {
			if(conConnexion) {
				this.connexion.rollback();
			}
			
			throw ex;
			
		} finally {
			if(conConnexion) {
				this.connexion.close();
			}
		}
		
		return accionesUsuario;
	}
	
	public Boolean existePermisoEnPermisosAccionesPaginaWeb(Usuario usuario,Long lIdSistema,String sPagina,String sPermiso,Long id_opcion) throws Exception {	
		 String sPermisos=this.traerPermisosAccionesPaginaWeb(usuario, lIdSistema, sPagina,id_opcion);
		 String arrPermisos[]=sPermisos.split(",");
		 Boolean isExiste=false;
		 
		 for(String sArrPermiso:arrPermisos) {
			 if(sArrPermiso.equals(sPermiso)) {
				 isExiste=true;
				 break;
			 }
		 }
		 
		 return isExiste;
	}
}

