













/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.framework.erp.util.Constantes2;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoGlobalTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.contabilidad.business.logic.FormatoLogicAdditional;
import com.bydan.erp.inventario.util.OrdenCompraConstantesFunciones;
//import com.bydan.erp.inventario.util.CompraReturnGeneral;
import com.bydan.erp.inventario.util.OrdenCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.OrdenCompraReturnGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.logic.TransaccionLogicAdditional;


@SuppressWarnings("unused")
public class OrdenCompraLogicAdditional extends OrdenCompraLogic { // implements OrdenCompraAdditionable{
	
	public  OrdenCompraLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19

			 OrdenCompraParameterReturnGeneral ordencompraReturnGeneral=(OrdenCompraParameterReturnGeneral)generalEntityReturnGeneral;
			 OrdenCompra ordencompra=ordencompraReturnGeneral.getOrdenCompra();;
			 OrdenCompraLogic ordencompraLogic=(OrdenCompraLogic)generalEntityLogic;
			 //OrdenCompra pedidoOrdenCompra=(OrdenCompra)object;
				
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
						 ordencompraLogic.getNewConnexionToDeep();
						 
						 ordencompra.setid_estado_orden_compra(1L);
							
						 /*
						 //GET FORMATO COMPRA
						 id_formato=FormatoLogicAdditional.TraerIdFormato(ordencompraLogic.getConnexion(), ordencompra.getid_empresa(),"ORDEN_COMPRA");
						 ordencompra.setid_formato(id_formato);
						 						  
						 //GET TRANSACCION COMPRA
						 id_transaccion=TransaccionLogicAdditional.TraerIdTransaccion(ordencompraLogic.getConnexion(), ordencompra.getid_empresa(), ordencompra.getid_sucursal(),"ORDEN_COMPRA");					 					 						 
						 movimientoinventario.setid_transaccion(id_transaccion);
						 */
						 						 
						 movimientoinventario.setid_empresa(ordencompra.getid_empresa());
						 movimientoinventario.setid_sucursal(ordencompra.getid_sucursal());
						 						 
						 //GET SECUENCIAL COMPRA
						 DatoGeneral datoGeneral=movimientoinventarioLogicAdditional.GetSecuencialFormatoMovimiento(ordencompra,movimientoinventario,ordencompraLogic.getConnexion(),false);						
						 
						 ordencompra.setnumero_secuencial(datoGeneral.getsValorString());
						 ordencompra.setid_formato(datoGeneral.getlValorLong1());
						 						 
						 ordencompraLogic.commitNewConnexionToDeep();
						 
					 } catch(Exception e) {
						 ordencompraLogic.rollbackNewConnexionToDeep();
						 
					 } finally {
						 ordencompraLogic.closeNewConnexionToDeep();
					 }
			}

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


	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) throws Exception {
		//CONTROL_21
		String sFinalQuery="";
		String sFinalQueryDefinicion="";
				
				 
		OrdenCompra ordencompra=(OrdenCompra)generalEntity;		
		OrdenCompraLogic ordencompraLogic=(OrdenCompraLogic)generalEntityLogic;
		//TransaccionLogic transaccionLogic=new TransaccionLogic();
		DefinicionLogic definicionLogic=new DefinicionLogic();
				
		MovimientoInventario movimientoinventario=new MovimientoInventario();		
		MovimientoInventarioLogicAdditional movimientoinventarioLogicAdditional=new MovimientoInventarioLogicAdditional();
		DatoGeneral datoGeneral=new DatoGeneral();
				
		//transaccionLogic.setConnexion(movimientoInventarioLogic.getConnexion());
		definicionLogic.setConnexion(ordencompraLogic.getConnexion());
				
				
				
		if(ordencompra.getIsNew() || !ordencompra.getid_estado_orden_compra().equals(0L)) {
					
			ordencompra.setid_estado_orden_compra(2L);
					
			List<DetalleOrdenCompra> detalleordencompras=ordencompra.getDetalleOrdenCompras();
					
			Integer iNumDetalle=0;
					
			for(DetalleOrdenCompra detalleordencompra:detalleordencompras) {
				if(detalleordencompra.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
			 			
				iNumDetalle++;
			}
					//1 ES DEL TOTAL			
			if(iNumDetalle<=0) {
				throw new Exception("Debe tener al menos 1 detalle");
			}
										
			datoGeneral=movimientoinventarioLogicAdditional.actualizarDefinicionSecuencialGeneral(ordencompraLogic.getConnexion(),definicionLogic,movimientoinventario,ordencompra.getid_empresa(),ordencompra.getid_sucursal(),"ORDEN_COMPRA");
					
			ordencompra.setnumero_secuencial(datoGeneral.getsValorString());
			ordencompra.setid_formato(movimientoinventario.getid_formato());
					
		} else {
			if(ordencompra.getid_estado_orden_compra().equals(0L)) {
				throw new Exception("No se puede actualizar una orden compra Anulada o no Reversada");
			}
		}							
	}


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}

	//CONTROL_INICIO
	public  OrdenCompraLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkOrdenCompraToSave(OrdenCompra ordencompra,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkOrdenCompraToSave(OrdenCompra ordencompra,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkOrdenCompraToSaveAfter(OrdenCompra ordencompra,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkOrdenCompraToSaves(List<OrdenCompra> ordencompras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkOrdenCompraToSaves(List<OrdenCompra> ordencompras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkOrdenCompraToSavesAfter(List<OrdenCompra> ordencompras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkOrdenCompraToGet(OrdenCompra ordencompra,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkOrdenCompraToGets(List<OrdenCompra> ordencompras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateOrdenCompraToSave(OrdenCompra ordencompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateOrdenCompraToGet(OrdenCompra ordencompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectOrdenCompraActions(String sTipoJsonResponse,JSONObject jsonObjectOrdenCompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonOrdenCompraDataTable(String sTipoJsonResponse,OrdenCompra ordencompra,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonOrdenComprasDataTable(String sTipoJsonResponse,List<OrdenCompra> ordencompras,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayOrdenCompraColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayOrdenComprasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayOrdenComprasColumns;
	}
	
	public static void updateJSONArrayOrdenCompraActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectOrdenCompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<OrdenCompra> ordencompras) throws Exception  {
		//CONTROL_16
		Boolean esProcesado=true;
		
		return esProcesado;
	}
	
	
	
	//CONTROL_FUNCION1
	
	
	
	
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

	//CONTROL_FUNCION2
}