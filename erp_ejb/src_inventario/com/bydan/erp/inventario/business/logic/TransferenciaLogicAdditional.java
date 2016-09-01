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
import com.bydan.erp.inventario.util.TransferenciaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TransferenciaReturnGeneral;
import com.bydan.erp.inventario.util.TransferenciaConstantesFunciones;
//import com.bydan.erp.inventario.util.TransferenciaReturnGeneral;
//import com.bydan.erp.inventario.util.TransferenciaParameterGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.logic.TransaccionLogicAdditional;



@SuppressWarnings("unused")
final public class TransferenciaLogicAdditional extends TransferenciaLogic{		
	
	//CONTROL_INICIO
	public  TransferenciaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkTransferenciaToSave(Transferencia transferencia,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkTransferenciaToSave(Transferencia transferencia,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkTransferenciaToSaveAfter(Transferencia transferencia,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkTransferenciaToSaves(List<Transferencia> transferencias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkTransferenciaToSaves(List<Transferencia> transferencias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkTransferenciaToSavesAfter(List<Transferencia> transferencias,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkTransferenciaToGet(Transferencia transferencia,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkTransferenciaToGets(List<Transferencia> transferencias,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateTransferenciaToSave(Transferencia transferencia,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateTransferenciaToGet(Transferencia transferencia,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectTransferenciaActions(String sTipoJsonResponse,JSONObject jsonObjectTransferencia,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonTransferenciaDataTable(String sTipoJsonResponse,Transferencia transferencia,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonTransferenciasDataTable(String sTipoJsonResponse,List<Transferencia> transferencias,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayTransferenciaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayTransferenciasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayTransferenciasColumns;
	}
	
	public static void updateJSONArrayTransferenciaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectTransferencia,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	//PARA ACCIONES ADDITIONAL
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<Transferencia> transferencias) throws Exception  {
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
			 	TransferenciaParameterReturnGeneral transferenciaReturnGeneral=(TransferenciaParameterReturnGeneral)generalEntityReturnGeneral;
				Transferencia transferencia=transferenciaReturnGeneral.getTransferencia();;
				TransferenciaLogic transferenciaLogic=(TransferenciaLogic)generalEntityLogic;
				//Transferencia pedidoCompra=(Transferencia)object;
				
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
							 transferenciaLogic.getNewConnexionToDeep();
							 
							 transferencia.setid_estado_inventario(1L);
								
							 /*
							 //GET FORMATO COMPRA
							 id_formato=FormatoLogicAdditional.TraerIdFormato(transferenciaLogic.getConnexion(), transferencia.getid_empresa(),"TRANSFERENCIA");
							 transferencia.setid_formato(id_formato);
							 							 
							 //GET TRANSACCION COMPRA
							 id_transaccion=TransaccionLogicAdditional.TraerIdTransaccion(transferenciaLogic.getConnexion(), transferencia.getid_empresa(), transferencia.getid_sucursal(),"TRANSFERENCIA");					 					 						 
							 movimientoinventario.setid_transaccion(id_transaccion);
							 */
							 
							 movimientoinventario.setid_empresa(transferencia.getid_empresa());
							 movimientoinventario.setid_sucursal(transferencia.getid_sucursal());
							 
							 //GET SECUENCIAL COMPRA
							 DatoGeneral datoGeneral=movimientoinventarioLogicAdditional.GetSecuencialFormatoMovimiento(transferencia,movimientoinventario,transferenciaLogic.getConnexion(),false);						
							 
							 transferencia.setnumero_secuencial(datoGeneral.getsValorString());
							 transferencia.setid_formato(datoGeneral.getlValorLong1());
								
							 
							 transferenciaLogic.commitNewConnexionToDeep();
							 
						 } catch(Exception e) {
							 transferenciaLogic.rollbackNewConnexionToDeep();
							 
							 throw e;
							 
						 } finally {
							 transferenciaLogic.closeNewConnexionToDeep();
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
				
				 
		Transferencia transferencia=(Transferencia)generalEntity;		
		TransferenciaLogic transferenciaLogic=(TransferenciaLogic)generalEntityLogic;
		//TransaccionLogic transaccionLogic=new TransaccionLogic();
		DefinicionLogic definicionLogic=new DefinicionLogic();
				
		MovimientoInventario movimientoinventario=new MovimientoInventario();		
		MovimientoInventarioLogicAdditional movimientoinventarioLogicAdditional=new MovimientoInventarioLogicAdditional();
		DatoGeneral datoGeneral=new DatoGeneral();
				
		//transaccionLogic.setConnexion(movimientoInventarioLogic.getConnexion());
		definicionLogic.setConnexion(transferenciaLogic.getConnexion());
				
				
				
		if(transferencia.getIsNew() || !transferencia.getid_estado_inventario().equals(0L)) {
					
			transferencia.setid_estado_inventario(2L);
					
			List<DetalleTransferencia> detalletransferencias=transferencia.getDetalleTransferencias();
					
			Integer iNumDetalle=0;
					
			for(DetalleTransferencia detalletransferencia:detalletransferencias) {
				if(detalletransferencia.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
			 			
				iNumDetalle++;
			}
					//1 ES DEL TOTAL			
			if(iNumDetalle<=0) {
				throw new Exception("Debe tener al menos 1 detalle");
			}
										
			datoGeneral=movimientoinventarioLogicAdditional.actualizarDefinicionSecuencialGeneral(transferenciaLogic.getConnexion(),definicionLogic,movimientoinventario,transferencia.getid_empresa(),transferencia.getid_sucursal(),"TRANSFERENCIA");
					
			transferencia.setnumero_secuencial(datoGeneral.getsValorString());
			transferencia.setid_formato(movimientoinventario.getid_formato());
					
		} else {
			if(transferencia.getid_estado_inventario().equals(0L)) {
				throw new Exception("No se puede actualizar una transferencia Anulada o no Reversada");
			}
		}									

	}
	
	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {	
		//CONTROL_22
	}
	
	
	
	//CONTROL_FUNCION1
	
	
	
	
	//CONTROL_FUNCION2
}

