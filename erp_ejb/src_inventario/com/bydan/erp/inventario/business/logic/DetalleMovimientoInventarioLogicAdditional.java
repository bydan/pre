














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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.framework.erp.util.Constantes2;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.Funciones2;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.inventario.util.DetalleMovimientoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.InventarioSql;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.business.entity.*;
//import com.bydan.erp.inventario.business.interfaces.DetalleMovimientoInventarioAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DetalleMovimientoInventarioLogicAdditional extends DetalleMovimientoInventarioLogic { // implements DetalleMovimientoInventarioAdditionable{
	public  DetalleMovimientoInventarioLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

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
	public  DetalleMovimientoInventarioLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetalleMovimientoInventarioToSave(DetalleMovimientoInventario detallemovimientoinventario,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetalleMovimientoInventarioToSave(DetalleMovimientoInventario detallemovimientoinventario,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetalleMovimientoInventarioToSaveAfter(DetalleMovimientoInventario detallemovimientoinventario,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetalleMovimientoInventarioToSaves(List<DetalleMovimientoInventario> detallemovimientoinventarios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetalleMovimientoInventarioToSaves(List<DetalleMovimientoInventario> detallemovimientoinventarios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetalleMovimientoInventarioToSavesAfter(List<DetalleMovimientoInventario> detallemovimientoinventarios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetalleMovimientoInventarioToGet(DetalleMovimientoInventario detallemovimientoinventario,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetalleMovimientoInventarioToGets(List<DetalleMovimientoInventario> detallemovimientoinventarios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetalleMovimientoInventarioToSave(DetalleMovimientoInventario detallemovimientoinventario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetalleMovimientoInventarioToGet(DetalleMovimientoInventario detallemovimientoinventario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetalleMovimientoInventarioActions(String sTipoJsonResponse,JSONObject jsonObjectDetalleMovimientoInventario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetalleMovimientoInventarioDataTable(String sTipoJsonResponse,DetalleMovimientoInventario detallemovimientoinventario,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetalleMovimientoInventariosDataTable(String sTipoJsonResponse,List<DetalleMovimientoInventario> detallemovimientoinventarios,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetalleMovimientoInventarioColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetalleMovimientoInventariosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetalleMovimientoInventariosColumns;
	}
	
	public static void updateJSONArrayDetalleMovimientoInventarioActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetalleMovimientoInventario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetalleMovimientoInventario(DetalleMovimientoInventario detallemovimientoinventario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallemovimientoinventario.setnumero_comprobante(detallemovimientoinventario.getnumero_comprobante().trim());
		detallemovimientoinventario.setlote(detallemovimientoinventario.getlote().trim());
		detallemovimientoinventario.setdescripcion(detallemovimientoinventario.getdescripcion().trim());
		detallemovimientoinventario.setlote_cliente(detallemovimientoinventario.getlote_cliente().trim());
		detallemovimientoinventario.setserie(detallemovimientoinventario.getserie().trim());
	}
	
	public static void quitarEspaciosDetalleMovimientoInventarios(List<DetalleMovimientoInventario> detallemovimientoinventarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleMovimientoInventario detallemovimientoinventario: detallemovimientoinventarios) {
			detallemovimientoinventario.setnumero_comprobante(detallemovimientoinventario.getnumero_comprobante().trim());
			detallemovimientoinventario.setlote(detallemovimientoinventario.getlote().trim());
			detallemovimientoinventario.setdescripcion(detallemovimientoinventario.getdescripcion().trim());
			detallemovimientoinventario.setlote_cliente(detallemovimientoinventario.getlote_cliente().trim());
			detallemovimientoinventario.setserie(detallemovimientoinventario.getserie().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetalleMovimientoInventarioConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DetalleMovimientoInventarioConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(DetalleMovimientoInventarioConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(DetalleMovimientoInventarioConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
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
	
	public static void GetTotales(Transferencia transferencia,List<DetalleTransferencia> detalletransferencias) throws Exception {
		MovimientoInventario movimientoinventario=new MovimientoInventario();
		ArrayList<DetalleMovimientoInventario> detallemovimientoinventarios=new ArrayList<DetalleMovimientoInventario>(); 
		DetalleMovimientoInventario detallemovimientoinventario=new DetalleMovimientoInventario();
		
		//CARGAR PARAMETROS
		movimientoinventario.setporcentaje_descuento(transferencia.getporcentaje_descuento());
		movimientoinventario.setvalor_descuento(transferencia.getvalor_descuento());
		
		
		for(DetalleTransferencia detalletransferencia : detalletransferencias) {
			if(!detalletransferencia.getsType().equals(Constantes2.S_TOTALES)) {
				detallemovimientoinventario=new DetalleMovimientoInventario();
				
				detallemovimientoinventario.setcosto_total(detalletransferencia.getcosto_total());
				detallemovimientoinventario.setcantidad(detalletransferencia.getcantidad());
				//detallemovimientoinventario.setiva_valor(detalletransferencia.getiva_valor());
				
				detallemovimientoinventarios.add(detallemovimientoinventario);
			}
		}
		//CARGAR PARAMETROS-FIN
		
		
		DetalleMovimientoInventarioLogicAdditional.GetTotales(movimientoinventario,detallemovimientoinventarios);
		
		
		
		
		//ASIGNAR RESULTADOS
		transferencia.setporcentaje_descuento(movimientoinventario.getporcentaje_descuento());
		transferencia.setvalor_descuento(movimientoinventario.getvalor_descuento());
						
		transferencia.setsuman(movimientoinventario.getsuman());
		transferencia.setiva(movimientoinventario.getiva());
		//transferencia.setnumero_items(movimientoinventario.getnumero_items());
		transferencia.settotal_descuento(movimientoinventario.gettotal_descuento());
		transferencia.setsub_total(movimientoinventario.getsub_total());
		transferencia.settotal(movimientoinventario.gettotal());
		//ASIGNAR RESULTADOS-FIN
	}
	
	public static void GetTotales(Compra compra,List<DetalleCompra> detallecompras) throws Exception {
		MovimientoInventario movimientoinventario=new MovimientoInventario();
		ArrayList<DetalleMovimientoInventario> detallemovimientoinventarios=new ArrayList<DetalleMovimientoInventario>(); 
		DetalleMovimientoInventario detallemovimientoinventario=new DetalleMovimientoInventario();
		
		//CARGAR PARAMETROS
		movimientoinventario.setporcentaje_descuento(compra.getporcentaje_descuento());
		movimientoinventario.setvalor_descuento(compra.getvalor_descuento());
		
		
		for(DetalleCompra detallecompra : detallecompras) {
			if(!detallecompra.getsType().equals(Constantes2.S_TOTALES)) {
				detallemovimientoinventario=new DetalleMovimientoInventario();
				
				detallemovimientoinventario.setcosto_total(detallecompra.getcosto_total());
				detallemovimientoinventario.setcantidad(detallecompra.getcantidad());
				detallemovimientoinventario.setiva_valor(detallecompra.getiva_valor());
				
				detallemovimientoinventarios.add(detallemovimientoinventario);
			}
		}
		//CARGAR PARAMETROS-FIN
		
		
		DetalleMovimientoInventarioLogicAdditional.GetTotales(movimientoinventario,detallemovimientoinventarios);
		
		
		
		
		//ASIGNAR RESULTADOS
		compra.setporcentaje_descuento(movimientoinventario.getporcentaje_descuento());
		compra.setvalor_descuento(movimientoinventario.getvalor_descuento());
						
		compra.setsuman(movimientoinventario.getsuman());
		compra.setiva(movimientoinventario.getiva());
		compra.setnumero_items(movimientoinventario.getnumero_items());
		compra.settotal_descuento(movimientoinventario.gettotal_descuento());
		compra.setsub_total(movimientoinventario.getsub_total());
		compra.settotal(movimientoinventario.gettotal());
		//ASIGNAR RESULTADOS-FIN
	}
	
	public static void GetTotales(OrdenCompra ordencompra,List<DetalleOrdenCompra> detalleordencompras) throws Exception {
		MovimientoInventario movimientoinventario=new MovimientoInventario();
		ArrayList<DetalleMovimientoInventario> detallemovimientoinventarios=new ArrayList<DetalleMovimientoInventario>(); 
		DetalleMovimientoInventario detallemovimientoinventario=new DetalleMovimientoInventario();
		
		//CARGAR PARAMETROS
		movimientoinventario.setporcentaje_descuento(ordencompra.getporcentaje_descuento());
		movimientoinventario.setvalor_descuento(ordencompra.getvalor_descuento());
		
		
		for(DetalleOrdenCompra detalleordencompra : detalleordencompras) {
			if(!detalleordencompra.getsType().equals(Constantes2.S_TOTALES)) {
				detallemovimientoinventario=new DetalleMovimientoInventario();
				
				detallemovimientoinventario.setcosto_total(detalleordencompra.getcosto_total());
				detallemovimientoinventario.setcantidad(detalleordencompra.getcantidad());
				detallemovimientoinventario.setiva_valor(detalleordencompra.getiva_valor());
				
				detallemovimientoinventarios.add(detallemovimientoinventario);
			}
		}
		//CARGAR PARAMETROS-FIN
		
		
		DetalleMovimientoInventarioLogicAdditional.GetTotales(movimientoinventario,detallemovimientoinventarios);
		
		
		
		
		//ASIGNAR RESULTADOS
		ordencompra.setporcentaje_descuento(movimientoinventario.getporcentaje_descuento());
		ordencompra.setvalor_descuento(movimientoinventario.getvalor_descuento());
						
		ordencompra.setsuman(movimientoinventario.getsuman());
		ordencompra.setiva(movimientoinventario.getiva());
		//ordencompra.setnumero_items(movimientoinventario.getnumero_items());
		ordencompra.settotal_descuento(movimientoinventario.gettotal_descuento());
		ordencompra.setsub_total(movimientoinventario.getsub_total());
		ordencompra.settotal(movimientoinventario.gettotal());
		//ASIGNAR RESULTADOS-FIN
	}
	
	public static void GetTotales(MovimientoInventario movimientoinventario,List<DetalleMovimientoInventario> detallemovimientoinventarios) throws Exception {
		Double suman=0.0;
		Integer numero_items=0;
		
		Double sub_total=0.0;		
		Double iva=0.0;
		Double total=0.0;
		Double valor_descuento=0.0;
		
		for(DetalleMovimientoInventario detallemovimientoinventario : detallemovimientoinventarios) {
			if(!detallemovimientoinventario.getsType().equals(Constantes2.S_TOTALES)) {
				suman+=detallemovimientoinventario.getcosto_total();
				numero_items+=detallemovimientoinventario.getcantidad();
				iva+=detallemovimientoinventario.getiva_valor();
			}
		}
		
		movimientoinventario.setsuman(suman);
		movimientoinventario.setiva(iva);
		movimientoinventario.setnumero_items(numero_items);
		
		if(movimientoinventario.getporcentaje_descuento()>0) {
			valor_descuento=suman * (movimientoinventario.getporcentaje_descuento()/100);
			
			valor_descuento=Funciones2.Redondear(valor_descuento, 2);
			
			movimientoinventario.setvalor_descuento(valor_descuento);
			movimientoinventario.settotal_descuento(valor_descuento);
		}
		
		sub_total=movimientoinventario.getsuman() - movimientoinventario.getvalor_descuento();
		sub_total=Funciones2.Redondear(sub_total, 2);
		
		movimientoinventario.setsub_total(sub_total);
		
		total=sub_total + iva;
		total=Funciones2.Redondear(total, 2);
		
		movimientoinventario.settotal(total);
	}
	
	public static void GetCostoTotal(DetalleTransferencia detalletransferencia) throws Exception {
		Double costo_total=0.0;
		
		DetalleMovimientoInventario detallemovimientoinventario=new DetalleMovimientoInventario();
		
		detallemovimientoinventario.setcantidad(detalletransferencia.getcantidad()); 
		detallemovimientoinventario.setcosto_unitario(detalletransferencia.getcosto_unitario());
		//detallemovimientoinventario.setiva(detalletransferencia.getiva());
		
		DetalleMovimientoInventarioLogicAdditional.GetCostoTotal(detallemovimientoinventario);
		
		
		//detalletransferencia.setiva_valor(detallemovimientoinventario.getiva_valor());
		detalletransferencia.setcosto_total(detallemovimientoinventario.getcosto_total());
		
		
		//return detallemovimientoinventario;
	}
	
	public static void GetCostoTotal(DetalleRequisicionCompra detallerequisicioncompra) throws Exception {
		Double costo_total=0.0;
		
		DetalleMovimientoInventario detallemovimientoinventario=new DetalleMovimientoInventario();
		
		detallemovimientoinventario.setcantidad(detallerequisicioncompra.getcantidad_requisicion()); 
		detallemovimientoinventario.setcosto_unitario(detallerequisicioncompra.getcosto_unitario());
		//detallemovimientoinventario.setiva(detallerequisicioncompra.getiva());
		
		DetalleMovimientoInventarioLogicAdditional.GetCostoTotal(detallemovimientoinventario);
		
		
		//detallerequisicioncompra.setiva_valor(detallemovimientoinventario.getiva_valor());
		detallerequisicioncompra.setcosto_total(detallemovimientoinventario.getcosto_total());
		
		
		//return detallemovimientoinventario;
	}
	
	public static void GetCostoTotal(DetalleOrdenCompra detalleordencompra) throws Exception {
		Double costo_total=0.0;
		
		DetalleMovimientoInventario detallemovimientoinventario=new DetalleMovimientoInventario();
		
		detallemovimientoinventario.setcantidad(detalleordencompra.getcantidad()); 
		detallemovimientoinventario.setcosto_unitario(detalleordencompra.getcosto_unitario());
		detallemovimientoinventario.setiva(detalleordencompra.getiva());
		
		DetalleMovimientoInventarioLogicAdditional.GetCostoTotal(detallemovimientoinventario);
		
		
		detalleordencompra.setiva_valor(detallemovimientoinventario.getiva_valor());
		detalleordencompra.setcosto_total(detallemovimientoinventario.getcosto_total());
		
		
		//return detallemovimientoinventario;
	}
	
	public static void GetCostoTotal(DetallePedidoCompra detallepedidocompra) throws Exception {
		Double costo_total=0.0;
		
		DetalleMovimientoInventario detallemovimientoinventario=new DetalleMovimientoInventario();
		
		detallemovimientoinventario.setcantidad(detallepedidocompra.getcantidad_pedido()); 
		detallemovimientoinventario.setcosto_unitario(detallepedidocompra.getcosto_unitario());
		//detallemovimientoinventario.setiva(detallepedidocompra.getiva());
		
		DetalleMovimientoInventarioLogicAdditional.GetCostoTotal(detallemovimientoinventario);
		
		
		//detallepedidocompra.setiva_valor(detallemovimientoinventario.getiva_valor());
		detallepedidocompra.setcosto_total(detallemovimientoinventario.getcosto_total());
		
		
		//return detallemovimientoinventario;
	}
	
	public static void GetCostoTotal(DetalleCompra detallecompra) throws Exception {
		Double costo_total=0.0;
		
		DetalleMovimientoInventario detallemovimientoinventario=new DetalleMovimientoInventario();
		
		detallemovimientoinventario.setcantidad(detallecompra.getcantidad()); 
		detallemovimientoinventario.setcosto_unitario(detallecompra.getcosto_unitario());
		detallemovimientoinventario.setiva(detallecompra.getiva());
		
		DetalleMovimientoInventarioLogicAdditional.GetCostoTotal(detallemovimientoinventario);
		
		
		detallecompra.setiva_valor(detallemovimientoinventario.getiva_valor());
		detallecompra.setcosto_total(detallemovimientoinventario.getcosto_total());
		
		
		//return detallemovimientoinventario;
	}
	
	public static void GetCostoTotal(DetalleMovimientoInventario detallemovimientoinventario) throws Exception {
		Double costo_sub_total=0.0;
		Double costo_total=0.0;
		Double iva_valor=0.0;
		
		costo_sub_total=detallemovimientoinventario.getcantidad() * detallemovimientoinventario.getcosto_unitario();
		costo_sub_total=Funciones2.Redondear(costo_sub_total, 2);
				
		iva_valor=(costo_sub_total * detallemovimientoinventario.getiva())/100;
		iva_valor=Funciones2.Redondear(iva_valor, 2);
		
		costo_total=costo_sub_total + iva_valor;				
		costo_total=Funciones2.Redondear(costo_total, 2);
		
		
		detallemovimientoinventario.setiva_valor(iva_valor);
		detallemovimientoinventario.setcosto_total(costo_total);
		
		//return detallemovimientoinventario;
	}
	//GetCostoTotal
	
	public static DatoGeneral GetDisponibleYCosto(DetalleTransferencia detalletransferencia) throws Exception {
		DatoGeneral datoGeneral=new DatoGeneral();
		
		DetalleMovimientoInventario detallemovimientoinventario=new DetalleMovimientoInventario();
		
		detallemovimientoinventario.setid_empresa(detalletransferencia.getid_empresa());
		detallemovimientoinventario.setid_sucursal(detalletransferencia.getid_sucursal());
		detallemovimientoinventario.setid_bodega(detalletransferencia.getid_bodega());
		detallemovimientoinventario.setid_producto(detalletransferencia.getid_producto());
		
		
		datoGeneral=DetalleMovimientoInventarioLogicAdditional.GetDisponibleYCosto(detallemovimientoinventario,"TRANSFERENCIA");
		
		
		return datoGeneral;
	}
	
	public static DatoGeneral GetDisponibleYCosto(DetalleRequisicionCompra detallerequisicioncompra) throws Exception {
		DatoGeneral datoGeneral=new DatoGeneral();
		
		DetalleMovimientoInventario detallemovimientoinventario=new DetalleMovimientoInventario();
		
		detallemovimientoinventario.setid_empresa(detallerequisicioncompra.getid_empresa());
		detallemovimientoinventario.setid_sucursal(detallerequisicioncompra.getid_sucursal());
		detallemovimientoinventario.setid_bodega(detallerequisicioncompra.getid_bodega());
		detallemovimientoinventario.setid_producto(detallerequisicioncompra.getid_producto());
		
		
		datoGeneral=DetalleMovimientoInventarioLogicAdditional.GetDisponibleYCosto(detallemovimientoinventario,"COMPRA");
		
		
		return datoGeneral;
	}
	
	public static DatoGeneral GetDisponibleYCosto(DetalleOrdenCompra detalleordencompra) throws Exception {
		DatoGeneral datoGeneral=new DatoGeneral();
		
		DetalleMovimientoInventario detallemovimientoinventario=new DetalleMovimientoInventario();
		
		detallemovimientoinventario.setid_empresa(detalleordencompra.getid_empresa());
		detallemovimientoinventario.setid_sucursal(detalleordencompra.getid_sucursal());
		detallemovimientoinventario.setid_bodega(detalleordencompra.getid_bodega());
		detallemovimientoinventario.setid_producto(detalleordencompra.getid_producto());
		
		
		datoGeneral=DetalleMovimientoInventarioLogicAdditional.GetDisponibleYCosto(detallemovimientoinventario,"COMPRA");
		
		
		return datoGeneral;
	}
	
	public static DatoGeneral GetDisponibleYCosto(DetallePedidoCompra detallepedidocompra) throws Exception {
		DatoGeneral datoGeneral=new DatoGeneral();
		
		DetalleMovimientoInventario detallemovimientoinventario=new DetalleMovimientoInventario();
		
		detallemovimientoinventario.setid_empresa(detallepedidocompra.getid_empresa());
		detallemovimientoinventario.setid_sucursal(detallepedidocompra.getid_sucursal());
		detallemovimientoinventario.setid_bodega(detallepedidocompra.getid_bodega());
		detallemovimientoinventario.setid_producto(detallepedidocompra.getid_producto());
		
		
		datoGeneral=DetalleMovimientoInventarioLogicAdditional.GetDisponibleYCosto(detallemovimientoinventario,"COMPRA");
		
		
		return datoGeneral;
	}
	
	public static DatoGeneral GetDisponibleYCosto(DetalleCompra detallecompra) throws Exception {
		DatoGeneral datoGeneral=new DatoGeneral();
		
		DetalleMovimientoInventario detallemovimientoinventario=new DetalleMovimientoInventario();
		
		detallemovimientoinventario.setid_empresa(detallecompra.getid_empresa());
		detallemovimientoinventario.setid_sucursal(detallecompra.getid_sucursal());
		detallemovimientoinventario.setid_bodega(detallecompra.getid_bodega());
		detallemovimientoinventario.setid_producto(detallecompra.getid_producto());
		
		
		datoGeneral=DetalleMovimientoInventarioLogicAdditional.GetDisponibleYCosto(detallemovimientoinventario,"COMPRA");
		
		
		return datoGeneral;
	}
	
	public static DatoGeneral GetDisponibleYCosto(DetalleMovimientoInventario detallemovimientoinventario) throws Exception {
		DatoGeneral datoGeneral=new DatoGeneral();
		
		datoGeneral=DetalleMovimientoInventarioLogicAdditional.GetDisponibleYCosto(detallemovimientoinventario,"MOVIMIENTO_INVENTARIO");
		
		return datoGeneral;
	}
	
	public static DatoGeneral GetDisponibleYCosto(DetalleMovimientoInventario detallemovimientoinventario,String sTipo) throws Exception {
		String sFinalQuery="";
		String sFinalQueryCosto="";
		
		BodegaProductoLogic bodegaProductoLogic=new BodegaProductoLogic();
		ProductoLogic productoLogic=new ProductoLogic();
		CostoLogic costoLogic=new CostoLogic();
		
		Integer disponible=-1;
		Double valor_unitario=0.0;
		Double iva=0.0;
		
		DatoGeneral datoGeneral=new DatoGeneral();
		
		sFinalQuery=InventarioSql.GetBodegaProductoSqlWhere(detallemovimientoinventario.getid_empresa(), 
															detallemovimientoinventario.getid_bodega(), 
															detallemovimientoinventario.getid_producto());

		try {
			
			bodegaProductoLogic.getNewConnexionToDeep();
			
			costoLogic.setConnexion(bodegaProductoLogic.getConnexion());			
			productoLogic.setConnexion(bodegaProductoLogic.getConnexion());			
			
			if(sTipo=="COMPRA") {
				
				productoLogic.getEntity(detallemovimientoinventario.getid_producto());
				
				if(productoLogic.getProducto()!=null && productoLogic.getProducto().getId()>0) {
					if(productoLogic.getProducto().getiva()>0) {
						iva=productoLogic.getProducto().getiva();
					}
				}
			}
			
			
			bodegaProductoLogic.getEntity(sFinalQuery);
			
			if(bodegaProductoLogic.getBodegaProducto()!=null) {
				System.out.println("Bodega Producto="+bodegaProductoLogic.getBodegaProducto().getId());
				
				disponible=bodegaProductoLogic.getBodegaProducto().getcantidad_disponible();
				
				if(bodegaProductoLogic.getBodegaProducto().getiva()>0) {
					iva=bodegaProductoLogic.getBodegaProducto().getiva();
				}
			}
			
			
			//COSTO ACTUAL
			sFinalQueryCosto=InventarioSql.GetCostoSqlWhere(detallemovimientoinventario.getid_bodega(),
															detallemovimientoinventario.getid_producto(),
															detallemovimientoinventario.getid_empresa(),
															detallemovimientoinventario.getid_sucursal());


			costoLogic.getEntity(sFinalQueryCosto);
			
			
			if(costoLogic.getCosto()!=null) {
				valor_unitario=costoLogic.getCosto().getvalor_unitario();
			}
			
			bodegaProductoLogic.commitNewConnexionToDeep();
			
			
			
		} catch(Exception e) {
			bodegaProductoLogic.rollbackNewConnexionToDeep();
						
		} finally {
			bodegaProductoLogic.closeNewConnexionToDeep();
		}
		
		
		datoGeneral.setiValorInteger(disponible);
		datoGeneral.setdValorDouble(valor_unitario);
		datoGeneral.setdValorDouble2(iva);
		
		return datoGeneral;
	}
}