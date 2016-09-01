














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

import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;







import com.bydan.framework.erp.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoGlobalTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.util.Funciones2;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.cartera.business.entity.Cliente;
import com.bydan.erp.cartera.business.entity.Direccion;
import com.bydan.erp.inventario.business.entity.MovimientoInventario;
import com.bydan.erp.puntoventa.business.entity.PedidoPuntoVenta;
import com.bydan.erp.inventario.business.logic.MovimientoInventarioLogicAdditional;
import com.bydan.erp.puntoventa.business.logic.PedidoPuntoVentaLogic;
import com.bydan.erp.puntoventa.util.PedidoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.PedidoPuntoVentaReturnGeneral;
import com.bydan.erp.puntoventa.util.PedidoPuntoVentaConstantesFunciones;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.puntoventa.business.entity.*;
//import com.bydan.erp.puntoventa.business.interfaces.PedidoPuntoVentaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class PedidoPuntoVentaLogicAdditional extends PedidoPuntoVentaLogic { // implements PedidoPuntoVentaAdditionable{
	public  PedidoPuntoVentaLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19

			 PedidoPuntoVentaParameterReturnGeneral pedidopuntoventaReturnGeneral=(PedidoPuntoVentaParameterReturnGeneral)generalEntityReturnGeneral;
			 PedidoPuntoVenta pedidopuntoventa=pedidopuntoventaReturnGeneral.getPedidoPuntoVenta();;
			 PedidoPuntoVentaLogic pedidopuntoventaLogic=(PedidoPuntoVentaLogic)generalEntityLogic;
			 //PedidoPuntoVenta pedidoPedidoPuntoVenta=(PedidoPuntoVenta)object;
							
			 CajeroTurnoLogic cajeroturnoLogic=new CajeroTurnoLogic();
			 CajaLogic cajaLogic=new CajaLogic();
				
			 String sFinalQuery="";
			 
			 //CONTROL_19
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
					&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
					&& sTipo.equals("FORM")) {															
					
					 try {
						 pedidopuntoventaLogic.getNewConnexionToDeep();
						 
						 cajeroturnoLogic.setConnexion(pedidopuntoventaLogic.getConnexion());
						 cajaLogic.setConnexion(pedidopuntoventaLogic.getConnexion());
						 
						 pedidopuntoventa.setid_estado_pedido_punto_venta(1L);
						 
						 sFinalQuery=ErpSql.GetGeneralSqlWhere(true, parametroGeneralUsuario.getid_empresa(), parametroGeneralUsuario.getid_sucursal(), parametroGeneralUsuario.getid_usuario());
						 
						 cajeroturnoLogic.getEntity(sFinalQuery);
						 
						 if(cajeroturnoLogic.getCajeroTurno()!=null) {
							
							 pedidopuntoventa.setid_caja(cajeroturnoLogic.getCajeroTurno().getid_caja());
							 pedidopuntoventa.setid_mesa(cajeroturnoLogic.getCajeroTurno().getid_mesa());
							 pedidopuntoventa.setid_vendedor(cajeroturnoLogic.getCajeroTurno().getid_vendedor());
							 							 
							 cajaLogic.getEntity(cajeroturnoLogic.getCajeroTurno().getid_caja());
							 
							 Long lSecuencial=cajaLogic.getCaja().getsecuencial_pedido();
							 String sSecuencialFormato="";
							 String sTipoPuntoVenta="PEDIDO_PUNTO_VENTA";
							 
							 lSecuencial++;
								
							 sSecuencialFormato=Funciones2.GenerarSecuencial(lSecuencial, 10, sTipoPuntoVenta);
							 
							 pedidopuntoventa.setnumero_secuencial(sSecuencialFormato);
							 
						 } else {
							 throw new Exception("Debe configurar un cajero turno con el usuario actual");
						 }
						 /*
						 pedidopuntoventa.setid_estado_orden_compra(1L);																			 						 						
						 pedidopuntoventa.setnumero_secuencial(datoGeneral.getsValorString());
						 pedidopuntoventa.setid_formato(datoGeneral.getlValorLong1());
						 */
						 						 
						 
						 pedidopuntoventaLogic.commitNewConnexionToDeep();
						 
					 } catch(Exception e) {
						 pedidopuntoventaLogic.rollbackNewConnexionToDeep();
						 
						 throw e;
						 
					 } finally {
						 pedidopuntoventaLogic.closeNewConnexionToDeep();
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


	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}

	//CONTROL_INICIO
	public  PedidoPuntoVentaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkPedidoPuntoVentaToSave(PedidoPuntoVenta pedidopuntoventa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkPedidoPuntoVentaToSave(PedidoPuntoVenta pedidopuntoventa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkPedidoPuntoVentaToSaveAfter(PedidoPuntoVenta pedidopuntoventa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkPedidoPuntoVentaToSaves(List<PedidoPuntoVenta> pedidopuntoventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkPedidoPuntoVentaToSaves(List<PedidoPuntoVenta> pedidopuntoventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkPedidoPuntoVentaToSavesAfter(List<PedidoPuntoVenta> pedidopuntoventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkPedidoPuntoVentaToGet(PedidoPuntoVenta pedidopuntoventa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkPedidoPuntoVentaToGets(List<PedidoPuntoVenta> pedidopuntoventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updatePedidoPuntoVentaToSave(PedidoPuntoVenta pedidopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updatePedidoPuntoVentaToGet(PedidoPuntoVenta pedidopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectPedidoPuntoVentaActions(String sTipoJsonResponse,JSONObject jsonObjectPedidoPuntoVenta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonPedidoPuntoVentaDataTable(String sTipoJsonResponse,PedidoPuntoVenta pedidopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonPedidoPuntoVentasDataTable(String sTipoJsonResponse,List<PedidoPuntoVenta> pedidopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayPedidoPuntoVentaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayPedidoPuntoVentasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayPedidoPuntoVentasColumns;
	}
	
	public static void updateJSONArrayPedidoPuntoVentaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectPedidoPuntoVenta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosPedidoPuntoVenta(PedidoPuntoVenta pedidopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pedidopuntoventa.setnumero_secuencial(pedidopuntoventa.getnumero_secuencial().trim());
		pedidopuntoventa.setcodigo_cliente(pedidopuntoventa.getcodigo_cliente().trim());
		pedidopuntoventa.setnombre_cliente(pedidopuntoventa.getnombre_cliente().trim());
		pedidopuntoventa.setdireccion_cliente(pedidopuntoventa.getdireccion_cliente().trim());
		pedidopuntoventa.settelefono_cliente(pedidopuntoventa.gettelefono_cliente().trim());
		pedidopuntoventa.settarjeta_cliente(pedidopuntoventa.gettarjeta_cliente().trim());
	}
	
	public static void quitarEspaciosPedidoPuntoVentas(List<PedidoPuntoVenta> pedidopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PedidoPuntoVenta pedidopuntoventa: pedidopuntoventas) {
			pedidopuntoventa.setnumero_secuencial(pedidopuntoventa.getnumero_secuencial().trim());
			pedidopuntoventa.setcodigo_cliente(pedidopuntoventa.getcodigo_cliente().trim());
			pedidopuntoventa.setnombre_cliente(pedidopuntoventa.getnombre_cliente().trim());
			pedidopuntoventa.setdireccion_cliente(pedidopuntoventa.getdireccion_cliente().trim());
			pedidopuntoventa.settelefono_cliente(pedidopuntoventa.gettelefono_cliente().trim());
			pedidopuntoventa.settarjeta_cliente(pedidopuntoventa.gettarjeta_cliente().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPedidoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PedidoPuntoVentaConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(PedidoPuntoVentaConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(PedidoPuntoVentaConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PedidoPuntoVenta> pedidopuntoventas,PedidoPuntoVenta pedidopuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PedidoPuntoVenta pedidopuntoventaAux: pedidopuntoventas) {
			if((pedidopuntoventaAux.getId()==null && pedidopuntoventa.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(pedidopuntoventaAux.getId()!=null && pedidopuntoventa.getId()!=null){
				if(pedidopuntoventaAux.getId().equals(pedidopuntoventa.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPedidoPuntoVenta(List<PedidoPuntoVenta> pedidopuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double sub_totalTotal=0.0;
		Double ivaTotal=0.0;
		Double iceTotal=0.0;
		Double descuentoTotal=0.0;
		Double totalTotal=0.0;
	
		for(PedidoPuntoVenta pedidopuntoventa: pedidopuntoventas) {			
			sub_totalTotal+=pedidopuntoventa.getsub_total();
			ivaTotal+=pedidopuntoventa.getiva();
			iceTotal+=pedidopuntoventa.getice();
			descuentoTotal+=pedidopuntoventa.getdescuento();
			totalTotal+=pedidopuntoventa.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoPuntoVentaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoPuntoVentaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoPuntoVentaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoPuntoVentaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PedidoPuntoVentaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(PedidoPuntoVentaConstantesFunciones.LABEL_TOTAL);
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
	
	public static void ActualizarValoresEvento(PedidoPuntoVenta pedidoPuntoVenta,String sTipo) throws Exception {
		if(sTipo.equals("id_clientePedidoPuntoVenta")) {
			Cliente cliente=pedidoPuntoVenta.getCliente();
			
			if(cliente!=null) {
				pedidoPuntoVenta.setcodigo_cliente(cliente.getcodigo());
				pedidoPuntoVenta.setnombre_cliente(cliente.getnombre_completo());
				pedidoPuntoVenta.setdireccion_cliente(cliente.getdireccion());			
				pedidoPuntoVenta.settelefono_cliente(cliente.gettelefono());
				pedidoPuntoVenta.setid_tipo_precio(cliente.getid_tipo_precio());
			}
		}		
	}
	
}