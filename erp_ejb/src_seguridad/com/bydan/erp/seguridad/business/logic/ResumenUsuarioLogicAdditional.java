



/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.seguridad.business.logic;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;


import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ConstantesMensajes;
import com.bydan.framework.erp.util.Funciones;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.seguridad.util.ResumenUsuarioConstantesFunciones;
import com.bydan.erp.seguridad.util.ResumenUsuarioParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ResumenUsuarioReturnGeneral;
//import com.bydan.erp.seguridad.util.ResumenUsuarioParameterGeneral;
import com.bydan.erp.seguridad.util.SeguridadSql;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.seguridad.business.dataaccess.ResumenUsuarioDataAccess;
import com.bydan.erp.seguridad.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ResumenUsuarioLogicAdditional extends ResumenUsuarioLogic { // implements ResumenUsuarioAdditionable{		
	
	public ResumenUsuarioParameterReturnGeneral validarUsuarioCerrarUsuarioAutomaticoWithConnection(String sUsuario,String sPassword,Boolean esDeveloping)throws Exception {//Boolean paraCerrarSessionDesdeLogin
		Boolean esErrorIngreso=false;
		Boolean isValidado=false;
		ResumenUsuarioParameterReturnGeneral resumenUsuarioReturnGeneral=new ResumenUsuarioParameterReturnGeneral();
		
		resumenUsuarioReturnGeneral.setEsValidado(isValidado);
		resumenUsuarioReturnGeneral.setEsError(esErrorIngreso);
		
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-validarUsuarioCerrarUsuarioAutomaticoWithConnection");connexion.begin();			
		
			UsuarioLogicAdditional usuarioLogicAdditional=new UsuarioLogicAdditional();
			Usuario usuarioActual=new Usuario();
			
			usuarioLogicAdditional.setConnexion(this.connexion);
			
			usuarioActual=usuarioLogicAdditional.validarUsuario(sUsuario,sPassword,false);
			
			if(usuarioActual!=null && usuarioActual.getId()>0) {
				isValidado=true;
				resumenUsuarioReturnGeneral.setEsValidado(isValidado);
			}
			
			if(isValidado) {
				esErrorIngreso=this.manejarResumenUsuarioAutomaticoWithConnection(usuarioActual.getId(),true,esDeveloping,false);//paraCerrarSessionDesdeLogin
				
				resumenUsuarioReturnGeneral.setEsError(esErrorIngreso);
				
				if(!esErrorIngreso) {
					//NO HACE NADA					
				}
				
			}
			
			/*
			else {
				throw new Exception("USUARIO O PASSWORD INCORRECTO");
			}
			*/
						
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return resumenUsuarioReturnGeneral;
	}
	
	public ResumenUsuarioParameterReturnGeneral validarUsuarioLoginUsuarioAutomaticoWithConnection(String sUsuario,String sPassword,Boolean esDeveloping)throws Exception {//Boolean paraCerrarSessionDesdeLogin,
		Boolean esErrorIngreso=false;
		Boolean isValidado=false;
		String sFinalQuery="";
		
		ResumenUsuarioParameterReturnGeneral resumenUsuarioReturnGeneral=new ResumenUsuarioParameterReturnGeneral();
		
		resumenUsuarioReturnGeneral.setEsValidado(isValidado);
		resumenUsuarioReturnGeneral.setEsError(esErrorIngreso);
		
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-validarUsuarioLoginUsuarioAutomaticoWithConnection");connexion.begin();			
		
			UsuarioLogicAdditional usuarioLogicAdditional=new UsuarioLogicAdditional();
			ParametroGeneralUsuarioLogic parametroGeneralUsuarioLogic=new ParametroGeneralUsuarioLogic();
			ParametroGeneralSgLogic parametroGeneralSgLogic=new ParametroGeneralSgLogic();
			
			Usuario usuarioActual=new Usuario();
			ParametroGeneralUsuario parametroGeneralUsuario=new ParametroGeneralUsuario();
			ParametroGeneralSg parametroGeneralSg=new ParametroGeneralSg();
			
			usuarioLogicAdditional.setConnexion(this.connexion);
			parametroGeneralUsuarioLogic.setConnexion(this.connexion);
			parametroGeneralSgLogic.setConnexion(this.connexion);
			
			usuarioActual=usuarioLogicAdditional.validarUsuario(sUsuario,sPassword,false);
			
			if(usuarioActual!=null && usuarioActual.getId()>0) {
				isValidado=true;
				resumenUsuarioReturnGeneral.setEsValidado(isValidado);
				resumenUsuarioReturnGeneral.setUsuarioActual(usuarioActual);
			}
			
			if(isValidado) {
				esErrorIngreso=this.manejarResumenUsuarioAutomaticoWithConnection(usuarioActual.getId(),false,esDeveloping,false);//paraCerrarSessionDesdeLogin
				
				resumenUsuarioReturnGeneral.setEsError(esErrorIngreso);
				resumenUsuarioReturnGeneral.setResumenUsuario(this.resumenusuario);
				
				if(!esErrorIngreso) {
					//NO HACE NADA					
				}

				//CARGAR PARAMETRO GENERAL USUARIO
				//parametroGeneralUsuarioLogic.setDatosCliente(this.datosCliente);
								
								
				parametroGeneralUsuarioLogic.getEntity(usuarioActual.getId());
					
				if(parametroGeneralUsuarioLogic.getParametroGeneralUsuario()!=null && parametroGeneralUsuarioLogic.getParametroGeneralUsuario().getId()>0) {
					parametroGeneralUsuario=parametroGeneralUsuarioLogic.getParametroGeneralUsuario();
					//System.out.println(this.parametroGeneralUsuarioLogic.getParametroGeneralUsuario().getnombre_empresa());
				} else {
					parametroGeneralUsuario= new ParametroGeneralUsuario();
				}		
				
				resumenUsuarioReturnGeneral.setParametroGeneralUsuario(parametroGeneralUsuario);
				
				
				//CARGAR PARAMETRO GENERAL SG
				parametroGeneralSgLogic.setDatosCliente(this.datosCliente);
								
				sFinalQuery=SeguridadSql.GetWhereParametroGeneralActivo(parametroGeneralSgLogic.getConnexionType(), parametroGeneralSgLogic.getParameterDbType());
								
				parametroGeneralSgLogic.getEntity(sFinalQuery);
					
				if(parametroGeneralSgLogic.getParametroGeneralSg()!=null && parametroGeneralSgLogic.getParametroGeneralSg().getId()>0) {
					parametroGeneralSg=parametroGeneralSgLogic.getParametroGeneralSg();
						//System.out.println(this.parametroGeneralSgLogic.getParametroGeneralSg().getnombre_empresa());
				} else {
					parametroGeneralSg= new ParametroGeneralSg();
				}		
				
				resumenUsuarioReturnGeneral.setParametroGeneralSg(parametroGeneralSg);
			}
			
			
			/*
			else {
				throw new Exception("USUARIO O PASSWORD INCORRECTO");
			}
			*/
						
			connexion.commit();
			
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return resumenUsuarioReturnGeneral;
	}
	
	public Boolean manejarResumenUsuarioAutomaticoWithConnection(Long idUsuario,Boolean paraCerrarSessionDesdeLogin,Boolean esDeveloping)throws Exception {
		Boolean esErrorIngreso=false;
		
		esErrorIngreso=this.manejarResumenUsuarioAutomaticoWithConnection(idUsuario,paraCerrarSessionDesdeLogin,esDeveloping,true);
		
		return esErrorIngreso;
	}
	
	public Boolean manejarResumenUsuarioAutomaticoWithConnection(Long idUsuario,Boolean paraCerrarSessionDesdeLogin,Boolean esDeveloping,Boolean conConnexion)throws Exception {
		Boolean esErrorIngreso=false;
		
		try {	
			
			if(conConnexion) {
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			}
			
			String sFinalQuery=" where id_usuario="+idUsuario;
			
			
			this.getEntity(sFinalQuery);
    		
			
			if(this.resumenusuario!=null && this.resumenusuario.getId()>0) {
				
				if(!paraCerrarSessionDesdeLogin) {
				
	    			this.resumenusuario.setnumero_ingresos(this.resumenusuario.getnumero_ingresos()+1);
	    			this.resumenusuario.setnumero_intentos(this.resumenusuario.getnumero_intentos()+1);
	    			
	    			if(this.resumenusuario.getnumero_ingreso_actual()<=0) {
	    				this.resumenusuario.setnumero_ingreso_actual(this.resumenusuario.getnumero_ingreso_actual()+1);
	    				
	    				this.resumenusuario.setfecha_ultimo_ingreso(new Date());
	    				this.resumenusuario.setfecha_ultimo_intento(new Date());
	    				
	    			} else {
	    				this.resumenusuario.setnumero_error_ingreso(this.resumenusuario.getnumero_error_ingreso()+1);
	    				this.resumenusuario.setfecha_ultimo_error_ingreso(new Date()); 
	    				
	    				if(!esDeveloping) {
	    					esErrorIngreso=true;
	    				}
	    			}
				} else {
					this.resumenusuario.setnumero_reinicios(this.resumenusuario.getnumero_reinicios()+1);
	    			this.resumenusuario.setnumero_ingreso_actual(0L);
				}
				
    		} else {
    			this.resumenusuario=new ResumenUsuario();
    			
    			if(!paraCerrarSessionDesdeLogin) {
	    			this.resumenusuario.setid_usuario(idUsuario);
	    			this.resumenusuario.setnumero_ingresos(this.resumenusuario.getnumero_ingresos()+1);
	    			this.resumenusuario.setnumero_intentos(this.resumenusuario.getnumero_intentos()+1);
	    			this.resumenusuario.setnumero_ingreso_actual(this.resumenusuario.getnumero_ingreso_actual()+1);    				
					this.resumenusuario.setfecha_ultimo_ingreso(new Date());
					this.resumenusuario.setfecha_ultimo_intento(new Date());
					
    			} else {
    				this.resumenusuario.setid_usuario(idUsuario);
	    			//this.resumenusuario.setnumero_ingresos(this.resumenusuario.getnumero_ingresos()+1);
	    			//this.resumenusuario.setnumero_intentos(this.resumenusuario.getnumero_intentos()+1);
	    			this.resumenusuario.setnumero_reinicios(this.resumenusuario.getnumero_reinicios()+1);
	    			this.resumenusuario.setnumero_ingreso_actual(0L);    			
    			}
    		}
    		
    		
			this.saveResumenUsuario();
			
			if(conConnexion) {
				connexion.commit();
			}
			
		} catch(Exception e) {
			if(conConnexion) {
				connexion.rollback();
			}
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		if(conConnexion) {
      			connexion.close();
      		}
		}
		
		return esErrorIngreso;
	}
	
	
	public void cerrarSesionUsuarioWithConnection(Long idUsuario)throws Exception {
		try {
		
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			String sFinalQuery=" where id_usuario="+idUsuario;
    		
			this.getEntity(sFinalQuery);
	    	
	    					    		
    		if(this.resumenusuario!=null && this.resumenusuario.getId()>0) {
    			//this.resumenusuario.setnumero_ingresos(this.resumenusuario.getnumero_ingresos()+1);
    			//this.resumenusuario.setnumero_intentos(this.resumenusuario.getnumero_intentos()+1);
    			
    			/*
    			if(this.resumenusuario.getnumero_ingreso_actual()<=0) {
    				this.resumenusuario.setnumero_ingreso_actual(this.resumenusuario.getnumero_ingreso_actual()+1);
    				
    				this.resumenusuario.setfecha_ultimo_ingreso(new Date());
    				this.resumenusuario.setfecha_ultimo_intento(new Date());
    				
    			} else {
    				this.resumenusuario.setnumero_error_ingreso(this.resumenusuario.getnumero_error_ingreso()+1);
    				this.resumenusuario.setfecha_ultimo_error_ingreso(new Date());
    				
    				esErrorIngreso=true;	    				
    			}
    			*/
    			
    			this.resumenusuario.setnumero_cierres(this.resumenusuario.getnumero_cierres()+1);
    			this.resumenusuario.setnumero_ingreso_actual(0L);
    			
    		} else {
    			this.resumenusuario=new ResumenUsuario();
    			
    			this.resumenusuario.setid_usuario(idUsuario);
    			//this.resumenusuario.setnumero_ingresos(this.resumenusuario.getnumero_ingresos()+1);
    			//this.resumenusuario.setnumero_intentos(this.resumenusuario.getnumero_intentos()+1);
    			this.resumenusuario.setnumero_cierres(this.resumenusuario.getnumero_cierres()+1);
    			this.resumenusuario.setnumero_ingreso_actual(0L);    				
				//this.resumenusuario.setfecha_ultimo_ingreso(new Date());
				//this.resumenusuario.setfecha_ultimo_intento(new Date());    				
    		}
    		
    		
    		this.saveResumenUsuario();
	    		
    		connexion.commit();	
    		
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
	  	} finally {
			connexion.close();			
		}
	}
	
	public void registrarErrorLoginSesionUsuarioWithConnection(String sUsuario)throws Exception {
		try {
		
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			
			UsuarioLogic usuarioLogic=new UsuarioLogic();
    		
			Usuario usuarioActual=new Usuario(); 
			
			usuarioLogic.setConnexion(this.connexion);
    		
			String sFinalQuery=" where user_name='"+sUsuario+"'";
    		
    		//usuarioLogic.setDatosCliente(this.datosCliente);
			
	    	usuarioLogic.getEntity(sFinalQuery);
	    	usuarioActual=usuarioLogic.getUsuario();
	    					 
    		
    		if(usuarioActual!=null && usuarioActual.getId()>0) {
	    			
				//this.setDatosCliente(this.datosCliente);
    			
    			sFinalQuery=" where id_usuario="+usuarioActual.getId();
    			
		    	this.getEntity(sFinalQuery);
		    	
		    	resumenusuario=this.getResumenUsuario();
		    						
	    		
	    		if(resumenusuario!=null && resumenusuario.getId()>0) {
	    			//resumenusuario.setnumero_ingresos(resumenusuario.getnumero_ingresos()+1);
	    			resumenusuario.setnumero_intentos(resumenusuario.getnumero_intentos()+1);
	    			
	    			//if(resumenusuario.getnumero_ingreso_actual()<=0) {
	    				//resumenusuario.setnumero_ingreso_actual(resumenusuario.getnumero_ingreso_actual()+1);
	    				
	    				//resumenusuario.setfecha_ultimo_ingreso(new Date());
	    				//resumenusuario.setfecha_ultimo_intento(new Date());
	    				
	    			//} else {
	    				resumenusuario.setnumero_error_ingreso(resumenusuario.getnumero_error_ingreso()+1);
	    				resumenusuario.setfecha_ultimo_error_ingreso(new Date());
	    				
	    				//throw new Exception("YA SE ENCUENTRA EN USO ESTE USUARIO EN EL SISTEMA, CIERRE LA SESSION DEL USUARIO PARA INTENTAR DE NUEVO");
	    			//}
	    		} else {
	    			resumenusuario=new ResumenUsuario();
	    			
	    			resumenusuario.setid_usuario(usuarioActual.getId());
	    			//resumenusuario.setnumero_ingresos(resumenusuario.getnumero_ingresos()+1);
	    			resumenusuario.setnumero_error_ingreso(resumenusuario.getnumero_error_ingreso()+1);
	    			resumenusuario.setnumero_intentos(resumenusuario.getnumero_intentos()+1);
	    			//resumenusuario.setnumero_ingreso_actual(resumenusuario.getnumero_ingreso_actual()+1);    				
    				//resumenusuario.setfecha_ultimo_ingreso(new Date());
    				resumenusuario.setfecha_ultimo_intento(new Date()); 
    				resumenusuario.setfecha_ultimo_error_ingreso(new Date());
	    		}
	    		
	    		//this.setResumenUsuario(resumenusuario);
	    		
		    	this.saveResumenUsuario();
		    						
    		}
	    		
    		connexion.commit();	
    		
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
	  	} finally {
			connexion.close();			
		}
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
	public  ResumenUsuarioLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkResumenUsuarioToSave(ResumenUsuario resumenusuario,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkResumenUsuarioToSave(ResumenUsuario resumenusuario,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkResumenUsuarioToSaveAfter(ResumenUsuario resumenusuario,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkResumenUsuarioToSaves(List<ResumenUsuario> resumenusuarios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkResumenUsuarioToSaves(List<ResumenUsuario> resumenusuarios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkResumenUsuarioToSavesAfter(List<ResumenUsuario> resumenusuarios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkResumenUsuarioToGet(ResumenUsuario resumenusuario,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkResumenUsuarioToGets(List<ResumenUsuario> resumenusuarios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateResumenUsuarioToSave(ResumenUsuario resumenusuario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateResumenUsuarioToGet(ResumenUsuario resumenusuario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectResumenUsuarioActions(String sTipoJsonResponse,JSONObject jsonObjectResumenUsuario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonResumenUsuarioDataTable(String sTipoJsonResponse,ResumenUsuario resumenusuario,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonResumenUsuariosDataTable(String sTipoJsonResponse,List<ResumenUsuario> resumenusuarios,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayResumenUsuarioColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayResumenUsuariosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayResumenUsuariosColumns;
	}
	
	public static void updateJSONArrayResumenUsuarioActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectResumenUsuario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	//PARA ACCIONES ADDITIONAL
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<ResumenUsuario> resumenusuarios) throws Exception  {
		//CONTROL_16
		Boolean esProcesado=true;
		
		try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
		
			this.connexion.commit();
			
		} catch(Exception e) {
			this.connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		this.connexion.close();			
		}
		
		return esProcesado;
	}
	
	//PARA ACCIONES NORMALES		
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterReturnGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {				
		 try {	
			
			//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();
				
			
			return generalEntityReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	//CONTROL_FUNCION1
	
	
	
	
	//CONTROL_FUNCION2
}