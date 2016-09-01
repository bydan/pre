














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

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;















import com.bydan.framework.erp.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.logic.TransaccionLogicAdditional;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.Connexion;
import com.bydan.framework.erp.util.Constantes2;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoGlobalTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.util.Funciones2;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.contabilidad.business.logic.FormatoLogicAdditional;
//import com.bydan.erp.inventario.util.CompraReturnGeneral;
import com.bydan.erp.inventario.util.PedidoCompraConstantesFunciones;
import com.bydan.erp.inventario.util.PedidoCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.PedidoCompraReturnGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.business.entity.*;
//import com.bydan.erp.inventario.business.interfaces.PedidoCompraAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class PedidoCompraLogicAdditional extends PedidoCompraLogic { // implements PedidoCompraAdditionable{
	public  PedidoCompraLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
			 PedidoCompraParameterReturnGeneral pedidocompraReturnGeneral=(PedidoCompraParameterReturnGeneral)generalEntityReturnGeneral;
			 PedidoCompra pedidocompra=pedidocompraReturnGeneral.getPedidoCompra();;
			 PedidoCompraLogic pedidocompraLogic=(PedidoCompraLogic)generalEntityLogic;
			// PedidoCompra pedidoCompra=(PedidoCompra)object;
					
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
						 pedidocompraLogic.getNewConnexionToDeep();
						 
						 pedidocompra.setid_estado_pedido_compra(1L);
							
						 /*
						 //GET FORMATO COMPRA
						 id_formato=FormatoLogicAdditional.TraerIdFormato(pedidocompraLogic.getConnexion(), pedidocompra.getid_empresa(),"PEDIDO_COMPRA");
						 pedidocompra.setid_formato(id_formato);
						 						 
						 //GET TRANSACCION COMPRA
						 id_transaccion=TransaccionLogicAdditional.TraerIdTransaccion(pedidocompraLogic.getConnexion(), pedidocompra.getid_empresa(), pedidocompra.getid_sucursal(),"PEDIDO_COMPRA");					 					 						 
						 movimientoinventario.setid_transaccion(id_transaccion);
						 */
						 
						 movimientoinventario.setid_empresa(pedidocompra.getid_empresa());
						 movimientoinventario.setid_sucursal(pedidocompra.getid_sucursal());
						 
						 //GET SECUENCIAL COMPRA
						 DatoGeneral datoGeneral=movimientoinventarioLogicAdditional.GetSecuencialFormatoMovimiento(pedidocompra,movimientoinventario,pedidocompraLogic.getConnexion(),false);						
						
						 pedidocompra.setnumero_secuencial(datoGeneral.getsValorString());
						 pedidocompra.setid_formato(datoGeneral.getlValorLong1());
						 
						 pedidocompraLogic.commitNewConnexionToDeep();
						 
					 } catch(Exception e) {
						 pedidocompraLogic.rollbackNewConnexionToDeep();
						 
					 } finally {
						 pedidocompraLogic.closeNewConnexionToDeep();
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
		
		 
		PedidoCompra pedidocompra=(PedidoCompra)generalEntity;		
		PedidoCompraLogic pedidocompraLogic=(PedidoCompraLogic)generalEntityLogic;
		//TransaccionLogic transaccionLogic=new TransaccionLogic();
		DefinicionLogic definicionLogic=new DefinicionLogic();
		
		MovimientoInventario movimientoinventario=new MovimientoInventario();		
		MovimientoInventarioLogicAdditional movimientoinventarioLogicAdditional=new MovimientoInventarioLogicAdditional();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		//transaccionLogic.setConnexion(movimientoInventarioLogic.getConnexion());
		definicionLogic.setConnexion(pedidocompraLogic.getConnexion());
		
		
		
		if(pedidocompra.getIsNew() || !pedidocompra.getid_estado_pedido_compra().equals(0L)) {
			
			pedidocompra.setid_estado_pedido_compra(2L);
			
			List<DetallePedidoCompra> detallepedidocompras=pedidocompra.getDetallePedidoCompras();
			
			Integer iNumDetalle=0;
			
			for(DetallePedidoCompra detallepedidocompra:detallepedidocompras) {
	 			if(detallepedidocompra.getsType().contains(Constantes2.S_TOTALES)) {
	 				continue;
	 			}
	 			
	 			iNumDetalle++;
			}
			//1 ES DEL TOTAL			
			if(iNumDetalle<=0) {
				throw new Exception("Debe tener al menos 1 detalle");
			}
								
			datoGeneral=movimientoinventarioLogicAdditional.actualizarDefinicionSecuencialGeneral(pedidocompraLogic.getConnexion(),definicionLogic,movimientoinventario,pedidocompra.getid_empresa(),pedidocompra.getid_sucursal(),"PEDIDO_COMPRA");
			
			pedidocompra.setnumero_secuencial(datoGeneral.getsValorString());
			pedidocompra.setid_formato(movimientoinventario.getid_formato());
			
		} else {
			if(pedidocompra.getid_estado_pedido_compra().equals(0L)) {
				throw new Exception("No se puede actualizar un pedido de compra Anulada o no Reversada");
			}
		}
	}


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) throws SQLException, Exception {
		//CONTROL_21

		
		
		
	}

	//CONTROL_INICIO
	public  PedidoCompraLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkPedidoCompraToSave(PedidoCompra pedidocompra,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkPedidoCompraToSave(PedidoCompra pedidocompra,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkPedidoCompraToSaveAfter(PedidoCompra pedidocompra,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkPedidoCompraToSaves(List<PedidoCompra> pedidocompras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkPedidoCompraToSaves(List<PedidoCompra> pedidocompras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkPedidoCompraToSavesAfter(List<PedidoCompra> pedidocompras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkPedidoCompraToGet(PedidoCompra pedidocompra,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkPedidoCompraToGets(List<PedidoCompra> pedidocompras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updatePedidoCompraToSave(PedidoCompra pedidocompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updatePedidoCompraToGet(PedidoCompra pedidocompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectPedidoCompraActions(String sTipoJsonResponse,JSONObject jsonObjectPedidoCompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonPedidoCompraDataTable(String sTipoJsonResponse,PedidoCompra pedidocompra,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonPedidoComprasDataTable(String sTipoJsonResponse,List<PedidoCompra> pedidocompras,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayPedidoCompraColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayPedidoComprasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayPedidoComprasColumns;
	}
	
	public static void updateJSONArrayPedidoCompraActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectPedidoCompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosPedidoCompra(PedidoCompra pedidocompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pedidocompra.setnumero_secuencial(pedidocompra.getnumero_secuencial().trim());
		pedidocompra.setresponsable(pedidocompra.getresponsable().trim());
		pedidocompra.setsolicitado_por(pedidocompra.getsolicitado_por().trim());
		pedidocompra.setmotivo_solicitud(pedidocompra.getmotivo_solicitud().trim());
		pedidocompra.setarea_solicitud(pedidocompra.getarea_solicitud().trim());
		pedidocompra.setpara_uso_de(pedidocompra.getpara_uso_de().trim());
		pedidocompra.setlugar_entrega(pedidocompra.getlugar_entrega().trim());
		pedidocompra.setdescripcion(pedidocompra.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPedidoCompras(List<PedidoCompra> pedidocompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PedidoCompra pedidocompra: pedidocompras) {
			pedidocompra.setnumero_secuencial(pedidocompra.getnumero_secuencial().trim());
			pedidocompra.setresponsable(pedidocompra.getresponsable().trim());
			pedidocompra.setsolicitado_por(pedidocompra.getsolicitado_por().trim());
			pedidocompra.setmotivo_solicitud(pedidocompra.getmotivo_solicitud().trim());
			pedidocompra.setarea_solicitud(pedidocompra.getarea_solicitud().trim());
			pedidocompra.setpara_uso_de(pedidocompra.getpara_uso_de().trim());
			pedidocompra.setlugar_entrega(pedidocompra.getlugar_entrega().trim());
			pedidocompra.setdescripcion(pedidocompra.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PedidoCompraConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(PedidoCompraConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(PedidoCompraConstantesFunciones.IDMODULO);
		arrColumnasGlobales.add(PedidoCompraConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(PedidoCompraConstantesFunciones.IDPERIODO);
		arrColumnasGlobales.add(PedidoCompraConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PedidoCompra> pedidocompras,PedidoCompra pedidocompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PedidoCompra pedidocompraAux: pedidocompras) {
			if((pedidocompraAux.getId()==null && pedidocompra.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(pedidocompraAux.getId()!=null && pedidocompra.getId()!=null){
				if(pedidocompraAux.getId().equals(pedidocompra.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPedidoCompra(List<PedidoCompra> pedidocompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
	
		for(PedidoCompra pedidocompra: pedidocompras) {			
			totalTotal+=pedidocompra.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoCompraConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(PedidoCompraConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
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