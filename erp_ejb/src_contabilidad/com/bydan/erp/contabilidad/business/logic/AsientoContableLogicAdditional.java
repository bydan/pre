









/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.framework.erp.util.Connexion;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoGlobalTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.util.Funciones;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.cartera.business.entity.DetalleCliente;
import com.bydan.erp.cartera.business.entity.EstadoDetalleCliente;
import com.bydan.erp.cartera.business.logic.DetalleClienteLogic;
import com.bydan.erp.cartera.business.logic.EstadoDetalleClienteLogic;
import com.bydan.erp.contabilidad.util.AsientoContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.AsientoContableConstantesFuncionesAdditional;
import com.bydan.erp.contabilidad.util.AsientoContableParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.AsientoContableReturnGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.contabilidad.business.entity.*;
//import com.bydan.erp.contabilidad.business.interfaces.AsientoContableAdditionable;
import com.bydan.erp.facturacion.business.entity.EstadoFisicoFacturaEmpresa;
import com.bydan.erp.facturacion.business.entity.Factura;
import com.bydan.erp.facturacion.business.logic.EstadoFisicoFacturaEmpresaLogic;
import com.bydan.erp.facturacion.business.logic.FacturaLogic;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.util.ModuloConstantesFuncionesAdditional;


@SuppressWarnings("unused")
public class AsientoContableLogicAdditional extends AsientoContableLogic { // implements AsientoContableAdditionable{
	
	public  AsientoContableLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

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
	public  AsientoContableLogicAdditional()throws Exception {
		super();
    }		
	
	//PARA EVENTOS GENERALES
		public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
			try {
				//CONTROL_19
				AsientoContableLogic asientoContableLogic=(AsientoContableLogic)generalEntityLogic;
				AsientoContableParameterReturnGeneral asientoContableReturnGeneral=(AsientoContableParameterReturnGeneral)generalEntityReturnGeneral;
					
				ContabilidadLogicAdditional contabilidadLogicAdditional=new ContabilidadLogicAdditional();
				
				
				Double dCotizacion=0.0;
				String sFinalQuery="";
				
				if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
							&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
							&& sTipo.equals("FORM")) {
										
					
					ParametroContabilidadDefecto parametroContabilidadDefecto=new ParametroContabilidadDefecto();
					ParametroContabilidadDefectoLogic parametroContabilidadDefectoLogic=new ParametroContabilidadDefectoLogic();						
					
					parametroContabilidadDefectoLogic.setConnexion(generalEntityLogic.getConnexion());
					
					
					contabilidadLogicAdditional.setConnexion(generalEntityLogic.getConnexion());
					
					
					if(controlTipo.equals(ControlTipo.FORM) && eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW)) {
						sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_sucursal="+parametroGeneralUsuario.getid_sucursal();
						
						parametroContabilidadDefectoLogic.getEntity(sFinalQuery);
						
						parametroContabilidadDefecto=parametroContabilidadDefectoLogic.getParametroContabilidadDefecto();
						
						if(parametroContabilidadDefecto!=null && parametroContabilidadDefecto.getId()>0) {
							asientoContableReturnGeneral.getAsientoContable().setid_tipo_movimiento(parametroContabilidadDefecto.getid_tipo_movimiento());						
							asientoContableReturnGeneral.getAsientoContable().setid_tipo_documento(parametroContabilidadDefecto.getid_tipo_documento());
							asientoContableReturnGeneral.getAsientoContable().setid_estado_asiento_contable(parametroContabilidadDefecto.getid_estado_asiento_contable());
							
							dCotizacion=contabilidadLogicAdditional.getCotizacion(asientoContableReturnGeneral.getAsientoContable().getid_moneda(),asientoContableReturnGeneral.getAsientoContable().getfecha_emision(),generalEntityLogic.getConnexion());
							
							asientoContableReturnGeneral.getAsientoContable().setcotizacion(dCotizacion);
							
							//MONEDA ESTA EN PARAMETRO GENERAL USUARIO
							//asientoContableReturnGeneral.getAsientoContable().setid_moneda(parametroContabilidadDefecto.getid_moneda());
							
							
							/*
							asientoContableReturnGeneral.getAsientoContable().setid_grupo_asientoContable(parametroContabilidadDefecto.getid_grupo_asientoContable());										
							asientoContableReturnGeneral.getAsientoContable().setid_pais(parametroContabilidadDefecto.getid_pais());
							asientoContableReturnGeneral.getAsientoContable().setid_ciudad(parametroContabilidadDefecto.getid_ciudad());					
							asientoContableReturnGeneral.getAsientoContable().setid_calidad_asientoContable(parametroContabilidadDefecto.getid_calidad_asientoContable());																				
							asientoContableReturnGeneral.getAsientoContable().setid_tipo_identificacion(parametroContabilidadDefecto.getid_tipo_identificacion());
							asientoContableReturnGeneral.getAsientoContable().setid_pais_nacionalidad(parametroContabilidadDefecto.getid_pais_nacionalidad());
							asientoContableReturnGeneral.getAsientoContable().setid_estado_civil(parametroContabilidadDefecto.getid_estado_civil());
							*/
						} else {
							throw new Exception("DEBE CONFIGURAR PARAMETRO DEFECTOS");
						}
					}
	
				} else if(eventoGlobalTipo.equals(EventoGlobalTipo.CONTROL_CHANGE) && controlTipo.equals(ControlTipo.CHECKBOX) 
						&& eventoTipo.equals(EventoTipo.CLIC) && eventoSubTipo.equals(EventoSubTipo.CLICKED) 
						) { //&& sTipo.equals("CHECKBOX")
					
					SecuencialLogic secuencialLogic=new SecuencialLogic();
					
					secuencialLogic.setConnexion(generalEntityLogic.getConnexion());
					
					generalEntityReturnGeneral.setConRecargarPropiedades(true);
					
					if(sTipo.equals("es_retencionAsientoContable")) {
						if(asientoContableReturnGeneral.getAsientoContable().getes_retencion()) {
							sFinalQuery=" where id_empresa="+asientoContableReturnGeneral.getAsientoContable().getid_empresa()+" and id_sucursal="+asientoContableReturnGeneral.getAsientoContable().getid_sucursal();
							sFinalQuery+=" order by id asc";
							
							secuencialLogic.getEntity(sFinalQuery);
							
							if(secuencialLogic.getSecuencial()!=null) {
								asientoContableReturnGeneral.getAsientoContable().setnumero_retencion(secuencialLogic.getSecuencial().getnumero_retencion_fuente().toString());
							
							} else {
								asientoContableReturnGeneral.getAsientoContable().setnumero_retencion("");
							}
							
						} else {
							asientoContableReturnGeneral.getAsientoContable().setnumero_retencion("");
						}
						
					} else if(sTipo.equals("es_retencion_ivaAsientoContable")) {
						sFinalQuery=" where id_empresa="+asientoContableReturnGeneral.getAsientoContable().getid_empresa()+" and id_sucursal="+asientoContableReturnGeneral.getAsientoContable().getid_sucursal();
						sFinalQuery+=" order by id asc";
						
						secuencialLogic.getEntity(sFinalQuery);
												
						if(asientoContableReturnGeneral.getAsientoContable().getes_retencion_iva()) {
							if(secuencialLogic.getSecuencial()!=null) {
								asientoContableReturnGeneral.getAsientoContable().setnumero_retencion_iva(secuencialLogic.getSecuencial().getnumero_retencion_iva().toString());
							} else {
								asientoContableReturnGeneral.getAsientoContable().setnumero_retencion("");
							}
							
						} else {
							asientoContableReturnGeneral.getAsientoContable().setnumero_retencion_iva("");
						}
					}
					
					
				} else if(eventoGlobalTipo.equals(EventoGlobalTipo.CONTROL_CHANGE) && controlTipo.equals(ControlTipo.DATE) 
						&& eventoTipo.equals(EventoTipo.CHANGE) && eventoSubTipo.equals(EventoSubTipo.CHANGED) 
						) { //&& sTipo.equals("DATE")
					
					generalEntityReturnGeneral.setConRecargarPropiedades(true);
					
					asientoContableReturnGeneral.getAsientoContable().setnumero_retencion_iva("1051-1051-1051");
					
				}  else if(eventoGlobalTipo.equals(EventoGlobalTipo.CONTROL_CHANGE) && controlTipo.equals(ControlTipo.COMBOBOX) 
						&& eventoTipo.equals(EventoTipo.CHANGE) && eventoSubTipo.equals(EventoSubTipo.CHANGED) 
						) { //&& sTipo.equals("DATE")
					
					generalEntityReturnGeneral.setConRecargarPropiedades(true);
					
					dCotizacion=contabilidadLogicAdditional.getCotizacion(asientoContableReturnGeneral.getAsientoContable().getid_moneda(),asientoContableReturnGeneral.getAsientoContable().getfecha_emision(),generalEntityLogic.getConnexion());
					
					asientoContableReturnGeneral.getAsientoContable().setcotizacion(dCotizacion);
				}
			
			
				return generalEntityReturnGeneral;

			} catch(Exception e) {
				Funciones.manageException(logger,e);
				throw e;

			} finally {

			}
		}
		
	public static void checkAsientoContableToSave(AsientoContable asientocontable,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkAsientoContableToSave(AsientoContable asientocontable,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkAsientoContableToSaveAfter(AsientoContable asientocontable,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkAsientoContableToSaves(List<AsientoContable> asientocontables,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkAsientoContableToSaves(List<AsientoContable> asientocontables,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkAsientoContableToSavesAfter(List<AsientoContable> asientocontables,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkAsientoContableToGet(AsientoContable asientocontable,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkAsientoContableToGets(List<AsientoContable> asientocontables,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateAsientoContableToSave(AsientoContable asientocontable,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateAsientoContableToGet(AsientoContable asientocontable,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectAsientoContableActions(String sTipoJsonResponse,JSONObject jsonObjectAsientoContable,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonAsientoContableDataTable(String sTipoJsonResponse,AsientoContable asientocontable,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonAsientoContablesDataTable(String sTipoJsonResponse,List<AsientoContable> asientocontables,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayAsientoContableColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayAsientoContablesColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayAsientoContablesColumns;
	}
	
	public static void updateJSONArrayAsientoContableActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectAsientoContable,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<AsientoContable> asientocontables) throws Exception  {
		//CONTROL_16
		Boolean esProcesado=true;
		
		/*
		String sFinalQuery="";
		ArrayList<Classe> classes=new ArrayList<Classe>();
		Long id_estado_asiento_contable=0L;
		List<AsientoContable> asientocontables_final=new ArrayList<AsientoContable>();
		
		
		try {	
			
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
		
			if(sProceso.equals("MAYORIZAR")) {
				id_estado_asiento_contable=2L;
				
				for(AsientoContable asientocontable:asientocontables) {
					if(asientocontable.getIsSelected()) {
						asientocontable.setid_estado_asiento_contable(id_estado_asiento_contable);
						
						asientocontables_final.add(asientocontable);
					}					
				}
			} else if(sProceso.equals("DESMAYORIZAR")) {
				id_estado_asiento_contable=3L;
				
				for(AsientoContable asientocontable:asientocontables) {
					if(asientocontable.getIsSelected()) {
						asientocontable.setid_estado_asiento_contable(id_estado_asiento_contable);
						
						asientocontables_final.add(asientocontable);
					}					
				}
			} else if(sProceso.equals("ANULAR")) {
				id_estado_asiento_contable=0L;
				
				for(AsientoContable asientocontable:asientocontables) {
					if(asientocontable.getIsSelected()) {
						asientocontable.setid_estado_asiento_contable(id_estado_asiento_contable);
						
						asientocontables_final.add(asientocontable);
					}					
				}
			}
			
			this.setAsientoContables(asientocontables_final);
			
			this.saveAsientoContables();
			
			this.connexion.commit();
			
		} catch(Exception e) {
			this.connexion.rollback();			
			
			//Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		this.connexion.close();			
		}
		*/
		
		return esProcesado;
	}
	
	
	
	//CONTROL_FUNCION1
	
	
	
	
	//PARA ACCIONES NORMALES
	@SuppressWarnings("unchecked")
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {
		String sFinalQuery="";
		ArrayList<Classe> classes=new ArrayList<Classe>();
		
		AsientoContableLogic asientoContableLogic=(AsientoContableLogic) generalEntityLogic;
		List<AsientoContable> asientocontables=(List<AsientoContable>)objects;
		List<AsientoContable> asientocontables_final=new ArrayList<AsientoContable>();
		
		
		DetalleAsientoContableLogic detalleAsientoContableLogic=new DetalleAsientoContableLogic();		
		
		FacturaLogic facturaLogic=new FacturaLogic();		
		DetalleClienteLogic detalleClienteLogic=new DetalleClienteLogic();
		
		//try {

			//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			//this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
		
			detalleAsientoContableLogic.setConnexion(asientoContableLogic.getConnexion());
			facturaLogic.setConnexion(asientoContableLogic.getConnexion());
			detalleClienteLogic.setConnexion(asientoContableLogic.getConnexion());
			
			Boolean estaProcesado=false;
			
			if(modulo.getId().equals(ModuloConstantesFuncionesAdditional.LID_MODULO_CONTABILIDAD)) {		
				if(sProceso.equals("MAYORIZAR")) {					
					for(AsientoContable asientocontable:asientocontables) {
						AsientoContableLogicAdditional.MayorizarAsientoContable(asientocontable,asientocontables_final,estaProcesado);
					}
				} else if(sProceso.equals("DESMAYORIZAR")) {				
					for(AsientoContable asientocontable:asientocontables) {
						AsientoContableLogicAdditional.DesmayorizarAsientoContable(asientocontable,asientocontables_final,estaProcesado);
					}
				} else if(sProceso.equals("ANULAR")) {					
					for(AsientoContable asientocontable:asientocontables) {
						AsientoContableLogicAdditional.AnularAsientoContable(asientocontable,parametroGeneralUsuario,asientocontables_final,estaProcesado,detalleAsientoContableLogic,facturaLogic,detalleClienteLogic,modulo);
					}
				}
				
				//GUARDAR EN LOTE ASIENTOS CONTABLES
				asientoContableLogic.setAsientoContables(asientocontables_final);				
				asientoContableLogic.saveAsientoContables();
				
				//asientoContableLogic.getConnexion().commit();
				
				if(estaProcesado) {
					GeneralEntityParameterReturnGeneral.ConfigurarConMensajeConRecargar(generalEntityReturnGeneral, sProceso);					
				}
				
			} else if(modulo.getId().equals(ModuloConstantesFuncionesAdditional.LID_MODULO_FACTURACION)) {
				if(sProceso.equals("DESMAYORIZAR") || sProceso.equals("ANULAR")) {
					for(AsientoContable asientocontable:asientocontables) {
						AsientoContableLogicAdditional.AnularAsientoContable(asientocontable,parametroGeneralUsuario,asientocontables_final,estaProcesado,detalleAsientoContableLogic,facturaLogic,detalleClienteLogic,modulo);
					}
				}
			}
			
			return generalEntityReturnGeneral;

		/*
		} catch(Exception e) {
			asientoContableLogic.getConnexion().rollback();
			//Funciones.manageException(logger,e);
			throw e;

		} finally {
			asientoContableLogic.getConnexion().close();	
		}
		*/
	}
	
	public static void MayorizarAsientoContable(AsientoContable asientocontable,List<AsientoContable> asientocontables_final,Boolean estaProcesado) throws Exception {
		if(asientocontable.getIsSelected()) {
			if(!asientocontable.getid_estado_asiento_contable().equals(AsientoContableConstantesFuncionesAdditional.LID_ESTADO_MAYORIZADO) && 
					!asientocontable.getid_estado_asiento_contable().equals(AsientoContableConstantesFuncionesAdditional.LID_ESTADO_ANULADO)) {
				
				asientocontable.setid_estado_asiento_contable(AsientoContableConstantesFuncionesAdditional.LID_ESTADO_MAYORIZADO);												
				 
				asientocontables_final.add(asientocontable);						
				estaProcesado=true;
			} else {
				if(asientocontable.getid_estado_asiento_contable().equals(AsientoContableConstantesFuncionesAdditional.LID_ESTADO_MAYORIZADO)) {
					throw new Exception("ASIENTO YA MAYORIZADO:"+asientocontable.getcodigo());
				
				} else if(asientocontable.getid_estado_asiento_contable().equals(AsientoContableConstantesFuncionesAdditional.LID_ESTADO_ANULADO)) {
					throw new Exception("ASIENTO ANULADO, NO PUEDE MAYORIZAR:"+asientocontable.getcodigo());
				}
			}
		}		
	}
	
	public static void DesmayorizarAsientoContable(AsientoContable asientocontable,List<AsientoContable> asientocontables_final,Boolean estaProcesado) throws Exception {
		if(asientocontable.getIsSelected()) {
			if(!asientocontable.getid_estado_asiento_contable().equals(AsientoContableConstantesFuncionesAdditional.LID_ESTADO_DESMAYORIZADO) && 
			   !asientocontable.getid_estado_asiento_contable().equals(AsientoContableConstantesFuncionesAdditional.LID_ESTADO_ANULADO)) {
				
				asientocontable.setid_estado_asiento_contable(AsientoContableConstantesFuncionesAdditional.LID_ESTADO_DESMAYORIZADO);
				
				asientocontables_final.add(asientocontable);
				estaProcesado=true;
			} else {
				if(asientocontable.getid_estado_asiento_contable().equals(AsientoContableConstantesFuncionesAdditional.LID_ESTADO_DESMAYORIZADO)) {
					throw new Exception("ASIENTO YA DESMAYORIZADO:"+asientocontable.getcodigo());
				
				} else if(asientocontable.getid_estado_asiento_contable().equals(AsientoContableConstantesFuncionesAdditional.LID_ESTADO_ANULADO)) {
					throw new Exception("ASIENTO ANULADO, NO PUEDE DESMAYORIZAR:"+asientocontable.getcodigo());
				}
			}
		}
	}
	
	public static void AnularAsientoContable(AsientoContable asientocontable,ParametroGeneralUsuario parametroGeneralUsuario,List<AsientoContable> asientocontables_final,Boolean estaProcesado,DetalleAsientoContableLogic detalleAsientoContableLogic,FacturaLogic facturaLogic,DetalleClienteLogic detalleClienteLogic,Modulo modulo) throws Exception {
		String sFinalQuery="";
		String sDetalle="";
		
		EstadoFisicoFacturaEmpresa estadoFisicoFacturaEmpresaAnulado=new EstadoFisicoFacturaEmpresa();
		EstadoFisicoFacturaEmpresaLogic estadoFisicoFacturaEmpresaLogic=new EstadoFisicoFacturaEmpresaLogic();
		
		EstadoDetalleCliente estadoDetalleClienteAnulado=new EstadoDetalleCliente();
		EstadoDetalleClienteLogic estadoDetalleClienteLogic=new EstadoDetalleClienteLogic();
		
		
		estadoFisicoFacturaEmpresaLogic.setConnexion(detalleAsientoContableLogic.getConnexion());
		estadoDetalleClienteLogic.setConnexion(detalleAsientoContableLogic.getConnexion());
		
		
		//ESTADO FACTURA ANULADO		
		sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa() + " and id_estado_fisico_factura=0";		
		estadoFisicoFacturaEmpresaLogic.getEntity(sFinalQuery);
		
		if(estadoFisicoFacturaEmpresaLogic.getEstadoFisicoFacturaEmpresa()==null || estadoFisicoFacturaEmpresaLogic.getEstadoFisicoFacturaEmpresa().getId()<0) {
			throw new Exception("ESTADO FACTURA ANULADO NO CONFIGURADO PARA ESTA EMPRESA");
		} else {
			estadoFisicoFacturaEmpresaAnulado=estadoFisicoFacturaEmpresaLogic.getEstadoFisicoFacturaEmpresa();
		}
		
		
		//ESTADO DETALLE CLIENTE ANULADO		
		sFinalQuery=" where id=0";		
		estadoDetalleClienteLogic.getEntity(sFinalQuery);
				
		if(estadoDetalleClienteLogic.getEstadoDetalleCliente()==null || estadoDetalleClienteLogic.getEstadoDetalleCliente().getId()<0) {
			throw new Exception("ESTADO DETALLE CLIENTE ANULADO NO CONFIGURADO");
		} else {
			estadoDetalleClienteAnulado=estadoDetalleClienteLogic.getEstadoDetalleCliente();
		}
		
		
		if(asientocontable.getIsSelected()) {
			if(!asientocontable.getid_estado_asiento_contable().equals(AsientoContableConstantesFuncionesAdditional.LID_ESTADO_ANULADO)) {
				if(asientocontable.getIsSelected()) {
					asientocontable.setid_estado_asiento_contable(AsientoContableConstantesFuncionesAdditional.LID_ESTADO_ANULADO);
					asientocontable.setdescripcion(asientocontable.getdescripcion()+"->ANULADO:Valor ="+asientocontable.getvalor());					
					asientocontable.setvalor(0.0);															
					asientocontables_final.add(asientocontable);
					estaProcesado=true;
					
					sFinalQuery="where id_asiento_contable="+asientocontable.getId();
					detalleAsientoContableLogic.getEntities(sFinalQuery);
					
					for(DetalleAsientoContable detalleasientocontable:detalleAsientoContableLogic.getDetalleAsientoContables()) {
						detalleasientocontable.setdebito_local(0.0);
						detalleasientocontable.setcredito_local(0.0);
						detalleasientocontable.setdebito_extran(0.0);
						detalleasientocontable.setcredito_extran(0.0);
						detalleasientocontable.setcotizacion(0.0);
						
						sDetalle=detalleasientocontable.getdetalle()+"->ANULADO:Debito Local ="+detalleasientocontable.getdebito_local()+",Credito Local ="+detalleasientocontable.getcredito_local();
						sDetalle+="Debito Extranjero ="+detalleasientocontable.getdebito_extran()+",Credito Extranjero ="+detalleasientocontable.getcredito_extran();
						
						detalleasientocontable.setdetalle(sDetalle);
					}
					
					detalleAsientoContableLogic.saveDetalleAsientoContables();
					
					
					if(modulo.getId().equals(ModuloConstantesFuncionesAdditional.LID_MODULO_FACTURACION)) {
						sFinalQuery="where id_asiento_contable="+asientocontable.getId();
						facturaLogic.getEntities(sFinalQuery);
												
						for(Factura factura:facturaLogic.getFacturas()) {
							factura.setid_estado_fisico_factura_empresa(estadoFisicoFacturaEmpresaAnulado.getId());
						}
						
						facturaLogic.saveFacturas();
						
						
						sFinalQuery="where id_asiento_contable="+asientocontable.getId();
						detalleClienteLogic.getEntities(sFinalQuery);
						
						for(DetalleCliente detalleCliente:detalleClienteLogic.getDetalleClientes()) {
							detalleCliente.setid_estado_detalle_cliente(estadoDetalleClienteAnulado.getId());
						}
						
						detalleClienteLogic.saveDetalleClientes();
					}
				}
			} else {
				throw new Exception("ASIENTO YA ANULADO:"+asientocontable.getcodigo());
			}
		}
	}

	//CONTROL_FUNCION2
}