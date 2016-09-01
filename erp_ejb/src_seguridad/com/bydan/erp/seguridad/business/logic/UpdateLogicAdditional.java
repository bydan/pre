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

import java.sql.Time;
import java.sql.Timestamp;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;


import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.Funciones;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.seguridad.util.SeguridadSql;
import com.bydan.erp.seguridad.util.UpdateConstantesFunciones;
//import com.bydan.erp.seguridad.util.UpdateReturnGeneral;
//import com.bydan.erp.seguridad.util.UpdateParameterGeneral;

import com.bydan.erp.seguridad.util.UpdateParameterReturnGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.seguridad.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class UpdateLogicAdditional extends UpdateLogic { // implements UpdateAdditionable{		
	
	//CONTROL_INICIO
	public  UpdateLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkUpdateToSave(Update update,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkUpdateToSave(Update update,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkUpdateToSaveAfter(Update update,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkUpdateToSaves(List<Update> updates,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkUpdateToSaves(List<Update> updates,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkUpdateToSavesAfter(List<Update> updates,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkUpdateToGet(Update update,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkUpdateToGets(List<Update> updates,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateUpdateToSave(Update update,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateUpdateToGet(Update update,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectUpdateActions(String sTipoJsonResponse,JSONObject jsonObjectUpdate,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonUpdateDataTable(String sTipoJsonResponse,Update update,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonUpdatesDataTable(String sTipoJsonResponse,List<Update> updates,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayUpdateColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayUpdatesColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayUpdatesColumns;
	}
	
	public static void updateJSONArrayUpdateActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectUpdate,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	//PARA ACCIONES ADDITIONAL
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<Update> updates) throws Exception  {
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
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {				
		//CONTROL_17
		
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
	
	//ACCION TABLA PROCESO DESDE BUSQUEDA
	public static GeneralEntityParameterReturnGeneral ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral) throws Exception  {
		//CONTROL_18
		//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();
			
		try {	
			//this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
		
			//this.connexion.commit();
			
		} catch(Exception e) {
			//this.connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		//this.connexion.close();			
		}
		
		return generalEntityReturnGeneral;
	}
	
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevoUpdate,ArrayList<Classe> clases)throws Exception {				
		//CONTROL_19		
		 try {	
				
			
			return generalEntityReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
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
		//CONTROL_22
	}
	
	
	
	//CONTROL_FUNCION1
	
	
	
	
	//CONTROL_FUNCION2
	
	public UpdateParameterReturnGeneral procesarUpdates(List<Update> updates,Boolean esAnual,Boolean esMensual,Boolean esActivarReintentar,Boolean esDesactivarTodo,UpdateParameterReturnGeneral updateParameterGeneral)throws Exception {
		UpdateParameterReturnGeneral  updateReturnGeneral =new UpdateParameterReturnGeneral ();
		ParametroGeneralSgLogic parametroGeneralSgLogic=new ParametroGeneralSgLogic();
		UpdateDetalleLogic updateDetalleLogic=new UpdateDetalleLogic();
		UpdateDetalleLogic updateDetalleLogicWithConnection=new UpdateDetalleLogic();
		
		String sCodigoProceso="";
		String sFinalQuery="";
		String sQueryExecute="";
		Boolean estaEjecutadoDetalle=false;
		Boolean permiteEjecutarDetalle=false;
		
		Boolean estaEjecutadoTotal=false;
		
		Integer iNumeroIntento=1;
		
		try	{
			
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
		
			parametroGeneralSgLogic.setConnexion(this.connexion);
			updateDetalleLogic.setConnexion(this.connexion);						
			
			//EJECUTAR UPDATE
			/*
			for(Update update : updates) {
				for(UpdateDetalle updateDetalle : update.getUpdateDetalles()) {
					sQueryExecute=updateDetalle.getsDescripcionGeneralEntityReporte1();
					
					try {
						updateDetalleLogicWithConnection.executeQueryWithConnection(sQueryExecute);
						
					} catch(Exception e) {
						System.out.println(e);
						
						//System.out.println(e.getMessage());
					}
				}
			}
			*/
			//EJECUTAR UPDATE
			
			
			if(esActivarReintentar || esDesactivarTodo) {
				Long idAnioActual=0L;
				Long idMesActual=0L;
				
				String sEstaActivo="";
				String sEjecutado="";
				
				if(esActivarReintentar) {
					sEstaActivo="true";
					sEjecutado="false";
					
				} else {
					sEstaActivo="false";
					sEjecutado="true";
				}
				
				if(esAnual) {					
					for(Update update : updates) {
						idAnioActual=update.getid_anio();
						break;
					}
					
					if(idAnioActual>0) {
						sQueryExecute="update seguridad.update set esta_activo="+sEstaActivo+",ejecutado="+sEjecutado+" where id_anio="+idAnioActual+";";
						sQueryExecute+="\r\nupdate seguridad.update_detalle set esta_activo=true,ejecutado=false where id_anio="+idAnioActual+";";
						
						this.executeQuery(sQueryExecute);						
					}
				} else if(esMensual) {
					for(Update update : updates) {
						idAnioActual=update.getid_anio();
						idMesActual=update.getid_mes();
						break;
					}
										
					if(idAnioActual>0 && idMesActual>0) {
						sQueryExecute="update seguridad.update set esta_activo="+sEstaActivo+",ejecutado="+sEjecutado+" where id_anio="+idAnioActual+" and id_mes="+idMesActual+";";
						sQueryExecute+="\r\nupdate seguridad.update_detalle set esta_activo=true,ejecutado=false where id_anio="+idAnioActual+" and id_mes="+idMesActual+";";
						
						this.executeQuery(sQueryExecute);						
					}
					
				} else {
					for(Update update : updates) {
						//NO USA CODIGO PARA QUE QUEDE IGUAL CON DETALLE
						sQueryExecute="update seguridad.update set esta_activo="+sEstaActivo+",ejecutado="+sEjecutado+" where id_anio="+update.getid_anio()+" and id_mes="+update.getid_mes() +" and id="+update.getId()+";";//codigo='"+update.getcodigo().trim()+"';";
						sQueryExecute+="\r\nupdate seguridad.update_detalle set esta_activo=true,ejecutado=false where id_anio="+update.getid_anio()+" and id_mes="+update.getid_mes() +" and id_update="+update.getId()+";";
						
						this.executeQuery(sQueryExecute);	
					}
				}
			}
			
			if(!esDesactivarTodo) {
				//INGRESAR NUEVO O ACTUALIZAR INFORMACION DE UPDATE
				for(Update update : updates) {
					estaEjecutadoTotal=true;
					
					if(sCodigoProceso.equals("")) {
						sCodigoProceso=update.getcodigo_proceso();
					}
					
					sFinalQuery=" where codigo='"+update.getcodigo().trim()+"'";
					this.getEntity(sFinalQuery);
					
					if(this.getUpdate()==null || this.getUpdate().getId()<=0) {
						this.setUpdate(new Update());
						
						this.getUpdate().setId(update.getId());
						
					} else {
						if(this.getUpdate().getejecutado() && !this.getUpdate().getesta_activo() ) {
							continue;
						}
					}
					
					//this.getUpdate().setId(update.getId());
					this.getUpdate().setid_anio(update.getid_anio());
					this.getUpdate().setid_mes(update.getid_mes());
					this.getUpdate().setcodigo(update.getcodigo());
					this.getUpdate().setcodigo_proceso(update.getcodigo_proceso());
					this.getUpdate().setquery_resumen(update.getquery_resumen());
					this.getUpdate().setdescripcion(update.getdescripcion());
					this.getUpdate().setfecha(update.getfecha());
					this.getUpdate().setfecha_archivo(update.getfecha_archivo());
					this.getUpdate().setorden(update.getorden());					
					this.getUpdate().setejecutado(true);//update.getejecutado());
					this.getUpdate().setesta_activo(false);//update.getesta_activo());
					
					iNumeroIntento=this.getUpdate().getnumero_intento();
					iNumeroIntento++;
					this.getUpdate().setnumero_intento(iNumeroIntento);
					
					//this.setUpdate(update);
					this.saveUpdate();
									
					
					for(UpdateDetalle updateDetalle : update.getUpdateDetalles()) {																				
						permiteEjecutarDetalle=false;
						estaEjecutadoDetalle=false;
						
						sFinalQuery=" where codigo='"+updateDetalle.getcodigo().trim()+"'";
						updateDetalleLogic.getEntity(sFinalQuery);
						
						if(updateDetalleLogic.getUpdateDetalle()==null || updateDetalleLogic.getUpdateDetalle().getId()<=0) {
							updateDetalleLogic.setUpdateDetalle(new UpdateDetalle());
							
							updateDetalleLogic.getUpdateDetalle().setId(updateDetalle.getId());
							
							permiteEjecutarDetalle=true;
							
						} else {
							if(updateDetalleLogic.getUpdateDetalle().getejecutado() 
								&& !updateDetalleLogic.getUpdateDetalle().getesta_activo() ) {
								continue;
							} else {
								permiteEjecutarDetalle=true;
							}									
						}
						
						if(permiteEjecutarDetalle) {
							//EJECUTAR UPDATE												
							sQueryExecute=updateDetalle.getsDescripcionGeneralEntityReporte1();
							
							try {
								
								updateDetalleLogicWithConnection.executeQueryWithConnection(sQueryExecute);
								
								estaEjecutadoDetalle=true;
								
							} catch(Exception e) {
								System.out.println(e);//System.out.println(e.getMessage());												
							}
							//EJECUTAR UPDATE
						}
						
						if(!estaEjecutadoDetalle) {
							estaEjecutadoTotal=false;						
						}
						
						//updateDetalleLogic.getUpdateDetalle().setId(updateDetalle.getId());
						updateDetalleLogic.getUpdateDetalle().setid_update(updateDetalle.getid_update());
						updateDetalleLogic.getUpdateDetalle().setid_anio(updateDetalle.getid_anio());
						updateDetalleLogic.getUpdateDetalle().setid_mes(updateDetalle.getid_mes());
						updateDetalleLogic.getUpdateDetalle().setcodigo(updateDetalle.getcodigo());
						updateDetalleLogic.getUpdateDetalle().setcodigo_proceso(update.getcodigo_proceso());
						updateDetalleLogic.getUpdateDetalle().setquery_resumen(updateDetalle.getquery_resumen());
						updateDetalleLogic.getUpdateDetalle().setdescripcion(updateDetalle.getdescripcion());
						
						updateDetalleLogic.getUpdateDetalle().setfecha(updateDetalle.getfecha());
						updateDetalleLogic.getUpdateDetalle().setfecha_archivo(updateDetalle.getfecha_archivo());
						updateDetalleLogic.getUpdateDetalle().setorden(updateDetalle.getorden());
						updateDetalleLogic.getUpdateDetalle().setejecutado(estaEjecutadoDetalle);//updateDetalle.getejecutado());
						
						if(estaEjecutadoDetalle) {
							updateDetalleLogic.getUpdateDetalle().setesta_activo(false);//updateDetalle.getesta_activo());
						} else {
							updateDetalleLogic.getUpdateDetalle().setesta_activo(true);
						}
						
						iNumeroIntento=updateDetalleLogic.getUpdateDetalle().getnumero_intento();
						iNumeroIntento++;
						updateDetalleLogic.getUpdateDetalle().setnumero_intento(iNumeroIntento);
						
						updateDetalleLogic.saveUpdateDetalle();
						
						//updateDetalle.setid_update(update.getId());
					}
					
					
					if(!estaEjecutadoTotal) {
						sQueryExecute="update seguridad.update set ejecutado=false and esta_activo=true where id="+this.getUpdate().getId()+"";
						
						this.executeQuery(sQueryExecute);	
					}
					
					//updateDetalleLogic.setUpdateDetalles(update.getUpdateDetalles());
					//updateDetalleLogic.saveUpdateDetalles();
				}
				//INGRESAR NUEVO O ACTUALIZAR INFORMACION DE UPDATE
			}
			
			//SIEMPRE DEBE EJECUTARSE, SINO SE EJECUTA CADA VEZ EL PROCESO
			//ACTUALIZAR CODIGO DEL PROCESO
			
			String finalQuery="";						
			
			finalQuery=SeguridadSql.GetWhereParametroGeneralActivo(this.getConnexionType(), this.getParameterDbType());
			parametroGeneralSgLogic.getEntity(finalQuery);
				
			if(parametroGeneralSgLogic.getParametroGeneralSg()!=null && parametroGeneralSgLogic.getParametroGeneralSg().getId()>=0) {
				parametroGeneralSgLogic.getParametroGeneralSg().setcodigo_proceso_actualizacion(sCodigoProceso);
				parametroGeneralSgLogic.saveParametroGeneralSg();
			} else {
				throw new Exception("DEBE CONFIGURAR PARAMETRO GENERAL SEGURIDAD");
			}
			
			
			//ACTUALIZAR CODIGO DEL PROCESO						
			
			
			this.connexion.commit();		
			
		} catch(Exception e) {
			this.connexion.rollback();
			
			Funciones.logShowExceptionMessages(logger,e);
			
			throw e;
			
		} finally {
			this.connexion.close();	
		}
		
		return updateReturnGeneral;
	}
}

