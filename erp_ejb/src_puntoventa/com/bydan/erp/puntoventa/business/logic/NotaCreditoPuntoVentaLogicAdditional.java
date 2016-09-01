/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoGlobalTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.util.Funciones2;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.cartera.business.entity.Cliente;
import com.bydan.erp.contabilidad.business.logic.FormatoLogicAdditional;
import com.bydan.erp.puntoventa.util.NotaCreditoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.NotaCreditoPuntoVentaReturnGeneral;
import com.bydan.erp.puntoventa.util.NotaCreditoPuntoVentaConstantesFunciones;
//import com.bydan.erp.puntoventa.util.NotaCreditoPuntoVentaReturnGeneral;
//import com.bydan.erp.puntoventa.util.NotaCreditoPuntoVentaParameterGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.puntoventa.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class NotaCreditoPuntoVentaLogicAdditional extends NotaCreditoPuntoVentaLogic { // implements NotaCreditoPuntoVentaAdditionable{		
	
	//CONTROL_INICIO
	public  NotaCreditoPuntoVentaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkNotaCreditoPuntoVentaToSave(NotaCreditoPuntoVenta notacreditopuntoventa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkNotaCreditoPuntoVentaToSave(NotaCreditoPuntoVenta notacreditopuntoventa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkNotaCreditoPuntoVentaToSaveAfter(NotaCreditoPuntoVenta notacreditopuntoventa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkNotaCreditoPuntoVentaToSaves(List<NotaCreditoPuntoVenta> notacreditopuntoventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkNotaCreditoPuntoVentaToSaves(List<NotaCreditoPuntoVenta> notacreditopuntoventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkNotaCreditoPuntoVentaToSavesAfter(List<NotaCreditoPuntoVenta> notacreditopuntoventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkNotaCreditoPuntoVentaToGet(NotaCreditoPuntoVenta notacreditopuntoventa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkNotaCreditoPuntoVentaToGets(List<NotaCreditoPuntoVenta> notacreditopuntoventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateNotaCreditoPuntoVentaToSave(NotaCreditoPuntoVenta notacreditopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateNotaCreditoPuntoVentaToGet(NotaCreditoPuntoVenta notacreditopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectNotaCreditoPuntoVentaActions(String sTipoJsonResponse,JSONObject jsonObjectNotaCreditoPuntoVenta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonNotaCreditoPuntoVentaDataTable(String sTipoJsonResponse,NotaCreditoPuntoVenta notacreditopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonNotaCreditoPuntoVentasDataTable(String sTipoJsonResponse,List<NotaCreditoPuntoVenta> notacreditopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayNotaCreditoPuntoVentaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayNotaCreditoPuntoVentasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayNotaCreditoPuntoVentasColumns;
	}
	
	public static void updateJSONArrayNotaCreditoPuntoVentaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectNotaCreditoPuntoVenta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	//PARA ACCIONES ADDITIONAL
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<NotaCreditoPuntoVenta> notacreditopuntoventas) throws Exception  {
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
				
			
			 NotaCreditoPuntoVentaParameterReturnGeneral notacreditopuntoventaReturnGeneral=(NotaCreditoPuntoVentaParameterReturnGeneral)generalEntityReturnGeneral;
			 NotaCreditoPuntoVenta notacreditopuntoventa=notacreditopuntoventaReturnGeneral.getNotaCreditoPuntoVenta();;
			 NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic=(NotaCreditoPuntoVentaLogic)generalEntityLogic;
			 //NotaCreditoPuntoVenta pedidoNotaCreditoPuntoVenta=(NotaCreditoPuntoVenta)object;
							
			 CajeroTurnoLogic cajeroturnoLogic=new CajeroTurnoLogic();
			 CajaLogic cajaLogic=new CajaLogic();
				
			 String sFinalQuery="";
			 Long id_formato=0L;
			 String sTipoFuncionalidad="";
			 
			 //CONTROL_19
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
					&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
					&& sTipo.equals("FORM")) {															
					
					 try {
						 notacreditopuntoventaLogic.getNewConnexionToDeep();
						 
						 cajeroturnoLogic.setConnexion(notacreditopuntoventaLogic.getConnexion());
						 cajaLogic.setConnexion(notacreditopuntoventaLogic.getConnexion());
						 
						 notacreditopuntoventa.setid_estado_nota_credito_punto_venta(1L);
						 
						 //FORMATO 
						 sTipoFuncionalidad="NOTA_CREDITO_PUNTO_VENTA";
						 
						 id_formato=FormatoLogicAdditional.TraerIdFormato(notacreditopuntoventaLogic.getConnexion(), parametroGeneralUsuario.getid_empresa(),sTipoFuncionalidad);
							
						 if(id_formato > 0L) {
							 notacreditopuntoventa.setid_formato(id_formato);
						 }
						 
						 
						 //CAJERO						 
						 sFinalQuery=ErpSql.GetGeneralSqlWhere(true, parametroGeneralUsuario.getid_empresa(), parametroGeneralUsuario.getid_sucursal(), parametroGeneralUsuario.getid_usuario());
						 
						 cajeroturnoLogic.getEntity(sFinalQuery);
						 
						 if(cajeroturnoLogic.getCajeroTurno()!=null) {
							
							 notacreditopuntoventa.setid_caja(cajeroturnoLogic.getCajeroTurno().getid_caja());
							 notacreditopuntoventa.setid_mesa(cajeroturnoLogic.getCajeroTurno().getid_mesa());
							 notacreditopuntoventa.setid_vendedor(cajeroturnoLogic.getCajeroTurno().getid_vendedor());
							 							 
							 cajaLogic.getEntity(cajeroturnoLogic.getCajeroTurno().getid_caja());
							 
							 Long lSecuencial=cajaLogic.getCaja().getsecuencial_factura();
							 String sSecuencialFormato="";
							 String sTipoPuntoVenta="FACTURA_PUNTO_VENTA";
							 
							 lSecuencial++;
								
							 sSecuencialFormato=Funciones2.GenerarSecuencial(lSecuencial, 10, sTipoPuntoVenta);
							 
							 notacreditopuntoventa.setnumero_secuencial(sSecuencialFormato);
							 
						 } else {
							 throw new Exception("Debe configurar un cajero turno con el usuario actual");
						 }
						 /*
						 notacreditopuntoventa.setid_estado_orden_compra(1L);																			 						 						
						 notacreditopuntoventa.setnumero_secuencial(datoGeneral.getsValorString());
						 notacreditopuntoventa.setid_formato(datoGeneral.getlValorLong1());
						 */
						 						 
						 
						 notacreditopuntoventaLogic.commitNewConnexionToDeep();
						 
					 } catch(Exception e) {
						 notacreditopuntoventaLogic.rollbackNewConnexionToDeep();
						 
						 throw e;
						 
					 } finally {
						 notacreditopuntoventaLogic.closeNewConnexionToDeep();
					 }
			}
			
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
	
	public static void ActualizarValoresEvento(NotaCreditoPuntoVenta notacreditoPuntoVenta,String sTipo) throws Exception {
		if(sTipo.equals("id_clientePuntoVenta")) {
			Cliente cliente=notacreditoPuntoVenta.getCliente();
			
			if(cliente!=null) {
				notacreditoPuntoVenta.setcodigo_cliente(cliente.getcodigo());
				notacreditoPuntoVenta.setnombre_cliente(cliente.getnombre_completo());
				notacreditoPuntoVenta.setdireccion_cliente(cliente.getdireccion());			
				notacreditoPuntoVenta.settelefono_cliente(cliente.gettelefono());
				notacreditoPuntoVenta.setid_tipo_precio(cliente.getid_tipo_precio());
			}
		}		
	}
}

