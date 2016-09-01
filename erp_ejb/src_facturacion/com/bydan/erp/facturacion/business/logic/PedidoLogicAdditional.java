














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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.facturacion.business.entity.Pedido;
import com.bydan.erp.facturacion.business.logic.PedidoLogic;
import com.bydan.erp.facturacion.util.PedidoConstantesFuncionesAdditional;
import com.bydan.erp.facturacion.util.PedidoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
//import com.bydan.erp.facturacion.business.interfaces.PedidoAdditionable;
import com.bydan.erp.inventario.business.entity.DetallePedido;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class PedidoLogicAdditional extends PedidoLogic { // implements PedidoAdditionable{
	public  PedidoLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19
			
			if(controlTipo.equals(ControlTipo.TEXTBOX) && eventoTipo.equals(EventoTipo.CHANGE) && eventoSubTipo.equals(EventoSubTipo.CHANGED)) {
				Pedido pedido=(Pedido)object;
				Double total=0.0;
				
				for(DetallePedido detallePedido:pedido.getDetallePedidos()) {
					detallePedido.setcantidad(20);
					detallePedido.setprecio(25.0);
					detallePedido.setdescuento_porcentaje(25.0);
					detallePedido.setdescuento_valor(30.0);
					detallePedido.setice(5.0);
					detallePedido.settotal(15.0);
					
					total+=detallePedido.gettotal();
				}
				
				pedido.settotal(total);
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
	public  PedidoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkPedidoToSave(Pedido pedido,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkPedidoToSave(Pedido pedido,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkPedidoToSaveAfter(Pedido pedido,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkPedidoToSaves(List<Pedido> pedidos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkPedidoToSaves(List<Pedido> pedidos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkPedidoToSavesAfter(List<Pedido> pedidos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkPedidoToGet(Pedido pedido,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkPedidoToGets(List<Pedido> pedidos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updatePedidoToSave(Pedido pedido,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updatePedidoToGet(Pedido pedido,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectPedidoActions(String sTipoJsonResponse,JSONObject jsonObjectPedido,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonPedidoDataTable(String sTipoJsonResponse,Pedido pedido,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonPedidosDataTable(String sTipoJsonResponse,List<Pedido> pedidos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayPedidoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayPedidosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayPedidosColumns;
	}
	
	public static void updateJSONArrayPedidoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectPedido,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosPedido(Pedido pedido,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pedido.setnumero(pedido.getnumero().trim());
		pedido.setdireccion(pedido.getdireccion().trim());
		pedido.setruc(pedido.getruc().trim());
		pedido.settelefono(pedido.gettelefono().trim());
		pedido.setdescripcion(pedido.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPedidos(List<Pedido> pedidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Pedido pedido: pedidos) {
			pedido.setnumero(pedido.getnumero().trim());
			pedido.setdireccion(pedido.getdireccion().trim());
			pedido.setruc(pedido.getruc().trim());
			pedido.settelefono(pedido.gettelefono().trim());
			pedido.setdescripcion(pedido.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPedido(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PedidoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(PedidoConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(PedidoConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(PedidoConstantesFunciones.IDPERIODO);
		arrColumnasGlobales.add(PedidoConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	//PARA ACCIONES NORMALES
	@SuppressWarnings("unchecked")
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {
		String sFinalQuery="";
		ArrayList<Classe> classes=new ArrayList<Classe>();
		Long id_estado_pedido=0L;
		List<Pedido> pedidos_final=new ArrayList<Pedido>();
		PedidoLogic pedidoLogic=(PedidoLogic) generalEntityLogic;
		EstadoPedidoLogic estadoPedidoLogic=new EstadoPedidoLogic();
		
		EstadoPedido estadoPedidoAutorizado=new EstadoPedido();
		EstadoPedido estadoPedidoAnulado=new EstadoPedido();
		
		List<Pedido> pedidos=(List<Pedido>)objects;
		
		try {

			estadoPedidoLogic.setConnexion(pedidoLogic.getConnexion());
			
			//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();

			Boolean estaProcesado=false;
			
			if(sProceso.equals("AUTORIZAR")) {
				id_estado_pedido=2L;
				
				sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_tipo_estado_pedido=2";
				estadoPedidoLogic.getEntity(sFinalQuery);
				estadoPedidoAutorizado=estadoPedidoLogic.getEstadoPedido();
				
				sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_tipo_estado_pedido=0";
				estadoPedidoLogic.getEntity(sFinalQuery);
				estadoPedidoAnulado=estadoPedidoLogic.getEstadoPedido();
				
				if((estadoPedidoAutorizado!=null && estadoPedidoAutorizado.getId()>0) && (estadoPedidoAnulado!=null && estadoPedidoAnulado.getId()>-1)) {				
					for(Pedido pedido:pedidos) {
						if(pedido.getIsSelected()) {
							if(!pedido.getid_estado_pedido().equals(estadoPedidoAutorizado.getId()) && 
									!pedido.getid_estado_pedido().equals(estadoPedidoAnulado.getId())) {
								
								pedido.setid_estado_pedido(estadoPedidoAutorizado.getId());												
								 
								pedidos_final.add(pedido);						
								estaProcesado=true;
							} else {
								if(pedido.getid_estado_pedido().equals(estadoPedidoAutorizado.getId())) {
									throw new Exception("PEDIDO YA AUTORIZADO:"+pedido.getnumero());
								
								} else if(pedido.getid_estado_pedido().equals(estadoPedidoAnulado.getId())) {
									throw new Exception("PEDIDO ANULADO, NO PUEDE AUTORIZAR:"+pedido.getnumero());
								}
							}
						}					
					}
				} else {
					throw new Exception("EL ESTADO PEDIDO AUTORIZADO O ANULADO NO ESTA CREADO PARA LA EMPRESA ACTUAL");
				}
			}
			
			pedidoLogic.setPedidos(pedidos_final);
			
			pedidoLogic.savePedidos();
			
			//pedidoLogic.getConnexion().commit();
			
			if(estaProcesado) {
				//generalEntityReturnGeneral.setConRetornoEstaProcesado(true);
				
				generalEntityReturnGeneral.setConMostrarMensaje(true);
				generalEntityReturnGeneral.setsLabelProceso("PROCESO "+sProceso);
				generalEntityReturnGeneral.setsMensajeProceso("PROCESO "+sProceso+" REALIZADO CORRECTAMENTE");
				generalEntityReturnGeneral.setsTipoMensaje("INFO");
				
				generalEntityReturnGeneral.setConRecargarInformacion(true);
				
			}
			
			return generalEntityReturnGeneral;

		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;

		} finally {

		}
	}

	//CONTROL_FUNCION2
}