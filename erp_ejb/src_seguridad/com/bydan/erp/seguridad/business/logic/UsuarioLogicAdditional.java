






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

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import com.bydan.framework.erp.business.entity.*;
//import java.util.ArrayList;
import com.bydan.framework.erp.business.logic.Pagination;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.seguridad.business.entity.*;
//import com.bydan.erp.seguridad.business.interfaces.UsuarioAdditionable;
import com.bydan.erp.seguridad.util.UsuarioSql;
import com.bydan.framework.erp.business.logic.DatosCliente;
//import com.bydan.framework.erp.util.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import com.bydan.framework.erp.business.logic.*;
//import java.sql.SQLException;


@SuppressWarnings("unused")
final public class UsuarioLogicAdditional extends UsuarioLogic { // implements UsuarioAdditionable{		
	public  UsuarioLogicAdditional()throws Exception {
		super();
    }
	
	
	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_22
	}
	
	public static Boolean validarSaveRelaciones(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_20
		Boolean validado=true;

		return validado;	
	}
	

	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
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
		
	public static void updateUsuarioToSave(Usuario usuario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception {	
		String sEncript="";
		
		if(!usuario.getIsDeleted()) {
			if(usuario.getIsChanged()) {
				if(usuario.getIsNew()) {
					//System.out.println(usuario.getId()+"es new");
					sEncript=SHA1Encrypte.SHA1(usuario.getclave().trim());
					usuario.setclave(sEncript);
				} else {
					//System.out.println(usuario.getId()+"es change");
					if(usuario.getUsuarioOriginal()!=null&&usuario.getUsuarioOriginal().getId()>0) {
						System.out.println(usuario.getUsuarioOriginal().getclave()+"--CLAVE ANTERIOR");						
						//System.out.println(usuario.getclave()+"--NUEVA CLAVE");
						
						//if(!usuario.getclave().equals(usuario.getUsuarioOriginal().getclave())) {
							sEncript=SHA1Encrypte.SHA1(usuario.getclave().trim());
							usuario.setclave(sEncript);
							//System.out.println(usuario.getId()+"CAMBIO DE CLAVE");
						//} else {
							//System.out.println(usuario.getId()+"clave igual");
						//}
					} else {
						//System.out.println(usuario.getId()+"no original");
					}
				}
			} else {
				//System.out.println(usuario.getId()+"no change");
			}
		} else {
			//System.out.println(usuario.getId()+"delete");
		}
		
	}		
						

	
	public static void updateUsuarioToGet(Usuario usuario,ArrayList<DatoGeneral> arrDatoGeneral) {
		
		if(usuario!=null) {
			String sClaveNormal=usuario.getclave();
			String sEncript=sClaveNormal;
			//String strEncript="xxxxx";
			
			try {
				usuario.setclave(sEncript);
			} catch(Exception e) {
				//throw e;
			}
		}
	}	
	
	public static void updateJSONObjectUsuarioActions(String sTipoJsonResponse,JSONObject jsonObjectUsuario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}

	public static void checkUsuarioToSave(Usuario usuario,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkUsuarioToSave(Usuario usuario,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkUsuarioToSaveAfter(Usuario usuario,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkUsuarioToSaves(List<Usuario> usuarios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkUsuarioToSaves(List<Usuario> usuarios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) throws SQLException, Exception {	
		for(Usuario usuario:usuarios) {
			
			if(!usuario.getIsDeleted()) {
				if(!usuario.getIsNew()) {
					if(usuario.getIsChanged()) {
						HistorialCambioClaveLogic historialcambioclaveLogic=new HistorialCambioClaveLogic();
						historialcambioclaveLogic.setConnexion(connexion);
						historialcambioclaveLogic.setDatosCliente(datosCliente);
						
						HistorialCambioClave historialcambioclave=new HistorialCambioClave();
						historialcambioclave.setid_usuario(usuario.getId());
						historialcambioclave.setnombre("AUTO-USUARIOLOGIC");
						historialcambioclave.setobservacion("SE HA REALIZADO UN CAMBIO DE CLAVE");
						historialcambioclave.setfecha_hora(new Timestamp((new Date()).getTime()));
						
						historialcambioclaveLogic.getHistorialCambioClaves().add(historialcambioclave);
						
						
						if(usuario.getIsNew()){	
							//SI PASARA NUEVO NO ESTA DEFINIDO ID Y POR LO TANTO ERROR
							//historialcambioclaveLogic.saveHistorialCambioClaves();
							
						} else {	
							if(usuario.getUsuarioOriginal()!=null&&usuario.getUsuarioOriginal().getId()>0) {
								
								//if(!usuario.getclave().equals(usuario.getUsuarioOriginal().getclave())) {
									historialcambioclaveLogic.saveHistorialCambioClaves();
								//} else {
									//System.out.println(usuario.getId()+"clave igual");
								//}
							} else {
								//PORSI IGUAL GUARDAR DE TODAS FORMAS
								historialcambioclaveLogic.saveHistorialCambioClaves();
							}
						}			
					}	
				} 
			} else {
				continue;
			}						
		}
	}
	
	public static void checkUsuarioToSavesAfter(List<Usuario> usuarios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) throws SQLException, Exception {	
		//NO PERMITIR INGRESAR AUTOMATICAMENTE YA QUE PARA ELIMINAR NECESITA ESTAR VACION Y NUNCA SE ELIMINARIA
		/*
		for(Usuario usuario:usuarios) {			
				if(usuario.getId()>0) {
						HistorialCambioClaveLogic historialcambioclaveLogic=new HistorialCambioClaveLogic();
						historialcambioclaveLogic.setConnexion(connexion);
						historialcambioclaveLogic.setDatosCliente(datosCliente);
						
						historialcambioclaveLogic.getHistorialCambioClavesFK_IdUsuario("", new Pagination(-1,-1), usuario.getId());
						
						
						if(historialcambioclaveLogic.getHistorialCambioClaves().size()<=0) {					
							HistorialCambioClave historialcambioclave=new HistorialCambioClave();
							historialcambioclave.setField_lIdUsuario(usuario.getId());
							historialcambioclave.setNombre("AUTO-USUARIOLOGIC");
							historialcambioclave.setObservacion("SE HA REALIZADO UN CAMBIO DE CLAVE");
							historialcambioclave.setField_timFechaHora(new Timestamp((new Date()).getTime()));
							
							historialcambioclaveLogic.setHistorialCambioClaves(new ArrayList<HistorialCambioClave>());
							
							historialcambioclaveLogic.getHistorialCambioClaves().add(historialcambioclave);
																								
							//GUARDAR AUTOMATICAMENTE SI NO TIENE NI UN HISTORIAL(EJM EN NUEVO USUARIO) CAMBIO DE CONTRASENA
							historialcambioclaveLogic.saveHistorialCambioClaves();
						}
					}			
						
		}
		*/
	}
	
	public static void checkUsuarioToGet(Usuario usuario,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static void checkUsuarioToGets(List<Usuario> usuarios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	public static String getJsonUsuarioDataTable(String sTipoJsonResponse,Usuario usuario,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		return sJsonDataTable;
	}
	
	public static String getJsonUsuariosDataTable(String sTipoJsonResponse,List<Usuario> usuarios,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayUsuarioColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayUsuariosColumns = new JSONArray();
		
		return jsonArrayUsuariosColumns;
	}
	
	public static void updateJSONArrayUsuarioActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectUsuario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		
	}
	
	//CONTROL_FUNCION2
	//PARA ACCIONES NORMALES
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {
			try {

				//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();


				return generalEntityReturnGeneral;

			} catch(Exception e) {
				Funciones.manageException(logger,e);
				throw e;

			} finally {

			}
	}
		
	public Usuario validarUsuarioWithConnection(String sLogin,String sClave)throws Exception {	
		Usuario usuario=new Usuario();
		
		usuario=this.validarUsuario(sLogin,sClave,true);
		
		return usuario;
	}
	
	public Usuario validarUsuario(String sLogin,String sClave,Boolean conConnexion)throws Exception {	
		Usuario usuario=new Usuario();
			
		try	{
			
			if(conConnexion) {
				this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
			}
			
			String sClaveDesencriptada="";
			
			sClaveDesencriptada=sClave;
				
			sClaveDesencriptada=SHA1Encrypte.SHA1(sClave);			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setInitialQuery("");
			queryWhereSelectParameters.setFinalQuery(UsuarioSql.GetWhereValidarUsuario(this.connexionType,this.parameterDbType,sLogin,sClaveDesencriptada));// " where user_name='"+sLogin+"'"+" and clave='"+sClaveDesencriptada+"'");
			
			//this.getEntitiesWithConnection(queryWhereSelectParameters);
			this.getEntities(queryWhereSelectParameters);
			
			if(this.getUsuarios().size()>0) {
				usuario=(Usuario)this.getUsuarios().toArray()[0];
			}
			
			if(conConnexion) {
				this.connexion.commit();
			}
			
		} catch(Exception e) {
			
			if(conConnexion) {
				this.connexion.rollback();
			}
			
			Funciones.logShowExceptionMessages(logger,e);
			
			throw e;
			
		} finally {
			
			if(conConnexion) {
				this.connexion.close();
			}
		}
		
		return usuario;
	}
	
	public Boolean validarUsuarioSeguridad(String sUsuario,String sClave) throws Exception {
		Boolean isValidado=false;
		
		try	{
		    String DB_CONN_STRING = "jdbc:mysql://localhost:3306";
		  
		    String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
		    String USER_NAME = sUsuario;
		    String PASSWORD = sClave;
		    
		    Connection connection = null;
		    
		    try {
		       Class.forName(DRIVER_CLASS_NAME).newInstance();
		    }
		    catch (Exception ex){
		       System.out.println("No se puede cargar el driver : " + DRIVER_CLASS_NAME);
		       throw new Exception("No se puede cargar el driver : " + DRIVER_CLASS_NAME);
		    }

		    try {
		    	connection = DriverManager.getConnection(DB_CONN_STRING, USER_NAME, PASSWORD);
		    }
		    catch (Exception e){
		    	System.out.println( "No se puede conectar a la base de datos: " + DB_CONN_STRING);
		    	//throw new Exception("No se puede conectar a la base de datos: " + DB_CONN_STRING);
		    	isValidado=false;
		    }
		    
		    if(connection!=null) {
			    if(connection.isValid(30)) {
			    	isValidado=true;
			    	connection.close();
			    	
			    } else {
			    	isValidado=false;
			    }
		    }
		    
		    return isValidado;
			
		} catch(Exception e) {
			//this.connexion.rollback();			
			
			throw e;
			
		} finally {
			this.connexion.close();	
		}
	}
	
	public Boolean validarUsuarioCambioClave(Usuario usuario) throws Exception {
		Boolean isValidado=false;
		
		try	{
		    
			HistorialCambioClaveLogic historialcambioclaveLogic=new HistorialCambioClaveLogic();
		    
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setInitialQuery("");
			queryWhereSelectParameters.setFinalQuery(UsuarioSql.GetWhereValidarUsuarioCambioClave(this.connexionType,this.parameterDbType,usuario.getId()));// " where id_usuario="+usuario.getId()+" order by fecha_hora desc ");
			
			historialcambioclaveLogic.getEntitiesWithConnection(queryWhereSelectParameters);
			
			HistorialCambioClave historialcambioclaveUltima=new HistorialCambioClave();
			
			if(historialcambioclaveLogic.getHistorialCambioClaves().size()>0) {
				for(HistorialCambioClave historialcambioclave:historialcambioclaveLogic.getHistorialCambioClaves()) {
					historialcambioclaveUltima=historialcambioclave;					
					break;
				}
				
				long lTiempoMilisegundosDiferencia=(new Date()).getTime()-historialcambioclaveUltima.getfecha_hora().getTime();
				
				long lDiasdiferencia=lTiempoMilisegundosDiferencia/(3600*24*1000);
				
				if(lDiasdiferencia<32) {
					isValidado=true;
				}				
			}
			
		    return isValidado;
			
		} catch(Exception e) {
			
			throw e;
			
		} finally {
			
		}
	}
}