/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.inventario.business.logic;

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





import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.GeneralEntity;
//LOGIC NO DEBE APARECER EN DESKTOP ONLY
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.Constantes2;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoGlobalTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.contabilidad.business.logic.FormatoLogicAdditional;
import com.bydan.erp.inventario.util.RequisicionCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.RequisicionCompraReturnGeneral;
import com.bydan.erp.inventario.util.RequisicionCompraConstantesFunciones;
//import com.bydan.erp.inventario.util.RequisicionCompraReturnGeneral;
//import com.bydan.erp.inventario.util.RequisicionCompraParameterGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.logic.TransaccionLogicAdditional;



@SuppressWarnings("unused")
final public class RequisicionCompraLogicAdditional extends RequisicionCompraLogic{		
	
	//CONTROL_INICIO
	public  RequisicionCompraLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkRequisicionCompraToSave(RequisicionCompra requisicioncompra,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkRequisicionCompraToSave(RequisicionCompra requisicioncompra,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkRequisicionCompraToSaveAfter(RequisicionCompra requisicioncompra,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkRequisicionCompraToSaves(List<RequisicionCompra> requisicioncompras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkRequisicionCompraToSaves(List<RequisicionCompra> requisicioncompras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkRequisicionCompraToSavesAfter(List<RequisicionCompra> requisicioncompras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkRequisicionCompraToGet(RequisicionCompra requisicioncompra,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkRequisicionCompraToGets(List<RequisicionCompra> requisicioncompras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateRequisicionCompraToSave(RequisicionCompra requisicioncompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateRequisicionCompraToGet(RequisicionCompra requisicioncompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectRequisicionCompraActions(String sTipoJsonResponse,JSONObject jsonObjectRequisicionCompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonRequisicionCompraDataTable(String sTipoJsonResponse,RequisicionCompra requisicioncompra,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonRequisicionComprasDataTable(String sTipoJsonResponse,List<RequisicionCompra> requisicioncompras,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayRequisicionCompraColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayRequisicionComprasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayRequisicionComprasColumns;
	}
	
	public static void updateJSONArrayRequisicionCompraActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectRequisicionCompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	//PARA ACCIONES ADDITIONAL
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<RequisicionCompra> requisicioncompras) throws Exception  {
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
			RequisicionCompraParameterReturnGeneral requisicioncompraReturnGeneral=(RequisicionCompraParameterReturnGeneral)generalEntityReturnGeneral;
			RequisicionCompra requisicioncompra=requisicioncompraReturnGeneral.getRequisicionCompra();;
			RequisicionCompraLogic requisicioncompraLogic=(RequisicionCompraLogic)generalEntityLogic;
			//RequisicionCompra pedidoCompra=(RequisicionCompra)object;
			
			MovimientoInventarioLogicAdditional movimientoinventarioLogicAdditional=new MovimientoInventarioLogicAdditional();
			MovimientoInventario movimientoinventario=new MovimientoInventario();
			 
			/*
			 String sFinalQuery="";
			 Long id_formato=0L;			 
			 Long id_transaccion=0L;
			*/ 
			 //CONTROL_19
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
					&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
					&& sTipo.equals("FORM")) {															
					
					 try {
						 requisicioncompraLogic.getNewConnexionToDeep();
						 
						 requisicioncompra.setid_estado_requisicion_compra(1L);
							
						 /*
						 //GET FORMATO COMPRA
						 id_formato=FormatoLogicAdditional.TraerIdFormato(requisicioncompraLogic.getConnexion(), requisicioncompra.getid_empresa(),"REQUISICION");
						 requisicioncompra.setid_formato(id_formato);						 
						 
						 //GET TRANSACCION COMPRA
						 id_transaccion=TransaccionLogicAdditional.TraerIdTransaccion(requisicioncompraLogic.getConnexion(), requisicioncompra.getid_empresa(), requisicioncompra.getid_sucursal(),"REQUISICION");					 					 						 
						 movimientoinventario.setid_transaccion(id_transaccion);
						 */
						 
						 movimientoinventario.setid_empresa(requisicioncompra.getid_empresa());
						 movimientoinventario.setid_sucursal(requisicioncompra.getid_sucursal());
						 
						 //GET SECUENCIAL COMPRA
						 DatoGeneral datoGeneral=movimientoinventarioLogicAdditional.GetSecuencialFormatoMovimiento(requisicioncompra,movimientoinventario,requisicioncompraLogic.getConnexion(),false);						
						
						 requisicioncompra.setnumero_secuencial(datoGeneral.getsValorString());
						 requisicioncompra.setid_formato(datoGeneral.getlValorLong1());
							
						 
						 requisicioncompraLogic.commitNewConnexionToDeep();
						 
					 } catch(Exception e) {
						 requisicioncompraLogic.rollbackNewConnexionToDeep();
						 
						 throw e;
						 
					 } finally {
						 requisicioncompraLogic.closeNewConnexionToDeep();
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
	
	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) throws Exception {	
		//CONTROL_21
		String sFinalQuery="";
		String sFinalQueryDefinicion="";
				
				 
		RequisicionCompra requisicioncompra=(RequisicionCompra)generalEntity;		
		RequisicionCompraLogic requisicioncompraLogic=(RequisicionCompraLogic)generalEntityLogic;
		//TransaccionLogic transaccionLogic=new TransaccionLogic();
		DefinicionLogic definicionLogic=new DefinicionLogic();
				
		MovimientoInventario movimientoinventario=new MovimientoInventario();		
		MovimientoInventarioLogicAdditional movimientoinventarioLogicAdditional=new MovimientoInventarioLogicAdditional();
		DatoGeneral datoGeneral=new DatoGeneral();
				
		//transaccionLogic.setConnexion(movimientoInventarioLogic.getConnexion());
		definicionLogic.setConnexion(requisicioncompraLogic.getConnexion());
				
				
				
		if(requisicioncompra.getIsNew() || !requisicioncompra.getid_estado_requisicion_compra().equals(0L)) {
					
			requisicioncompra.setid_estado_requisicion_compra(2L);
					
			List<DetalleRequisicionCompra> detallerequisicioncompras=requisicioncompra.getDetalleRequisicionCompras();
					
			Integer iNumDetalle=0;
					
			for(DetalleRequisicionCompra detallerequisicioncompra:detallerequisicioncompras) {
				if(detallerequisicioncompra.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
			 			
				iNumDetalle++;
			}
					//1 ES DEL TOTAL			
			if(iNumDetalle<=0) {
				throw new Exception("Debe tener al menos 1 detalle");
			}
										
			datoGeneral=movimientoinventarioLogicAdditional.actualizarDefinicionSecuencialGeneral(requisicioncompraLogic.getConnexion(),definicionLogic,movimientoinventario,requisicioncompra.getid_empresa(),requisicioncompra.getid_sucursal(),"REQUISICION");
					
			requisicioncompra.setnumero_secuencial(datoGeneral.getsValorString());
			requisicioncompra.setid_formato(movimientoinventario.getid_formato());
					
		} else {
			if(requisicioncompra.getid_estado_requisicion_compra().equals(0L)) {
				throw new Exception("No se puede actualizar una orden compra Anulada o no Reversada");
			}
		}									
	}
	
	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {	
		//CONTROL_22
	}
	
	
	
	//CONTROL_FUNCION1
	
	
	
	
	//CONTROL_FUNCION2
}

