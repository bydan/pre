














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
import com.bydan.framework.erp.util.Constantes2;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.Funciones2;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.facturacion.util.DetalleFacturaConstantesFunciones;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.DetalleFacturaPuntoVenta;
import com.bydan.erp.puntoventa.business.entity.DetalleNotaCreditoPuntoVenta;
//import com.bydan.erp.facturacion.business.interfaces.DetalleFacturaAdditionable;
import com.bydan.erp.puntoventa.business.entity.DetallePedidoPuntoVenta;
import com.bydan.erp.puntoventa.business.entity.DetallePedidoPuntoVenta;
import com.bydan.erp.puntoventa.business.entity.FacturaPuntoVenta;
import com.bydan.erp.puntoventa.business.entity.NotaCreditoPuntoVenta;
import com.bydan.erp.puntoventa.business.entity.PedidoPuntoVenta;
import com.bydan.erp.facturacion.business.entity.DetalleFactura;
import com.bydan.erp.inventario.business.logic.BodegaProductoLogic;
import com.bydan.erp.inventario.business.logic.PrecioLogic;
import com.bydan.erp.inventario.business.logic.PrecioLogic;
import com.bydan.erp.facturacion.business.logic.DetalleFacturaLogicAdditional;
import com.bydan.erp.inventario.util.InventarioSql;
import com.bydan.erp.inventario.business.logic.ProductoLogic;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DetalleFacturaLogicAdditional extends DetalleFacturaLogic { // implements DetalleFacturaAdditionable{
	public  DetalleFacturaLogicAdditional(Connexion connexion)throws Exception {
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
	public  DetalleFacturaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetalleFacturaToSave(DetalleFactura detallefactura,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetalleFacturaToSave(DetalleFactura detallefactura,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetalleFacturaToSaveAfter(DetalleFactura detallefactura,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetalleFacturaToSaves(List<DetalleFactura> detallefacturas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetalleFacturaToSaves(List<DetalleFactura> detallefacturas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetalleFacturaToSavesAfter(List<DetalleFactura> detallefacturas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetalleFacturaToGet(DetalleFactura detallefactura,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetalleFacturaToGets(List<DetalleFactura> detallefacturas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetalleFacturaToSave(DetalleFactura detallefactura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetalleFacturaToGet(DetalleFactura detallefactura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetalleFacturaActions(String sTipoJsonResponse,JSONObject jsonObjectDetalleFactura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetalleFacturaDataTable(String sTipoJsonResponse,DetalleFactura detallefactura,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetalleFacturasDataTable(String sTipoJsonResponse,List<DetalleFactura> detallefacturas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetalleFacturaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetalleFacturasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetalleFacturasColumns;
	}
	
	public static void updateJSONArrayDetalleFacturaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetalleFactura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetalleFactura(DetalleFactura detallefactura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallefactura.setnombre(detallefactura.getnombre().trim());
		detallefactura.setcodigo_lote(detallefactura.getcodigo_lote().trim());
		detallefactura.setdescripcion(detallefactura.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetalleFacturas(List<DetalleFactura> detallefacturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleFactura detallefactura: detallefacturas) {
			detallefactura.setnombre(detallefactura.getnombre().trim());
			detallefactura.setcodigo_lote(detallefactura.getcodigo_lote().trim());
			detallefactura.setdescripcion(detallefactura.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetalleFacturaConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DetalleFacturaConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(DetalleFacturaConstantesFunciones.IDPERIODO);
		arrColumnasGlobales.add(DetalleFacturaConstantesFunciones.IDEJERCICIO);
		
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

	
	
	public static void GetPrecioTotal(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa) throws Exception {
		Double precio_total=0.0;
		
		DetalleFactura detallefactura=new DetalleFactura();
		
		detallefactura.setcantidad(detallenotacreditopuntoventa.getcantidad()); 
		detallefactura.setprecio(detallenotacreditopuntoventa.getprecio());
		detallefactura.setiva(detallenotacreditopuntoventa.getiva());
		detallefactura.setice(detallenotacreditopuntoventa.getice());
		detallefactura.setdescuento(detallenotacreditopuntoventa.getdescuento());
		
		DetalleFacturaLogicAdditional.GetPrecioTotal(detallefactura);
		
		
		detallenotacreditopuntoventa.setprecio(detallefactura.getprecio());
		detallenotacreditopuntoventa.setiva_valor(detallefactura.getiva_valor());
		detallenotacreditopuntoventa.setice_valor(detallefactura.getice_valor());
		detallenotacreditopuntoventa.setdescuento_valor(detallefactura.getdescuento_valor());
		
		detallenotacreditopuntoventa.setsub_total(detallefactura.getsub_total());
		detallenotacreditopuntoventa.settotal(detallefactura.gettotal());
		
		//return detallefactura;
	}
	
	public static void GetPrecioTotal(DetalleFacturaPuntoVenta detallefacturapuntoventa) throws Exception {
		Double precio_total=0.0;
		
		DetalleFactura detallefactura=new DetalleFactura();
		
		detallefactura.setcantidad(detallefacturapuntoventa.getcantidad()); 
		detallefactura.setprecio(detallefacturapuntoventa.getprecio());
		detallefactura.setiva(detallefacturapuntoventa.getiva());
		detallefactura.setice(detallefacturapuntoventa.getice());
		detallefactura.setdescuento(detallefacturapuntoventa.getdescuento());
		
		DetalleFacturaLogicAdditional.GetPrecioTotal(detallefactura);
		
		
		detallefacturapuntoventa.setprecio(detallefactura.getprecio());
		detallefacturapuntoventa.setiva_valor(detallefactura.getiva_valor());
		detallefacturapuntoventa.setice_valor(detallefactura.getice_valor());
		detallefacturapuntoventa.setdescuento_valor(detallefactura.getdescuento_valor());
		
		detallefacturapuntoventa.setsub_total(detallefactura.getsub_total());
		detallefacturapuntoventa.settotal(detallefactura.gettotal());
		
		//return detallefactura;
	}
	
	public static void GetPrecioTotal(DetallePedidoPuntoVenta detallepedidopuntoventa) throws Exception {
		Double precio_total=0.0;
		
		DetalleFactura detallefactura=new DetalleFactura();
		
		detallefactura.setcantidad(detallepedidopuntoventa.getcantidad()); 
		detallefactura.setprecio(detallepedidopuntoventa.getprecio());
		detallefactura.setiva(detallepedidopuntoventa.getiva());
		detallefactura.setice(detallepedidopuntoventa.getice());
		detallefactura.setdescuento(detallepedidopuntoventa.getdescuento());
		
		DetalleFacturaLogicAdditional.GetPrecioTotal(detallefactura);
		
		
		detallepedidopuntoventa.setprecio(detallefactura.getprecio());
		detallepedidopuntoventa.setiva_valor(detallefactura.getiva_valor());
		detallepedidopuntoventa.setice_valor(detallefactura.getice_valor());
		detallepedidopuntoventa.setdescuento_valor(detallefactura.getdescuento_valor());
		
		detallepedidopuntoventa.setsub_total(detallefactura.getsub_total());
		detallepedidopuntoventa.settotal(detallefactura.gettotal());
		
		//return detallefactura;
	}
	
	public static void GetPrecioTotal(DetalleFactura detallefactura) throws Exception {
		Double precio_sub_total=0.0;
		Double precio_total=0.0;
		Double iva_valor=0.0;
		Double ice_valor=0.0;
		Double descuento_valor=0.0;
		
		//SubTotal
		precio_sub_total=detallefactura.getcantidad() * detallefactura.getprecio();
		precio_sub_total=Funciones2.Redondear(precio_sub_total, 2);
				
		//Iva
		iva_valor=(precio_sub_total * detallefactura.getiva())/100;
		iva_valor=Funciones2.Redondear(iva_valor, 2);
		
		//Ice
		ice_valor=(precio_sub_total * detallefactura.getice())/100;
		ice_valor=Funciones2.Redondear(ice_valor, 2);
		
		//Descuento
		descuento_valor=(precio_sub_total * detallefactura.getdescuento())/100;
		descuento_valor=Funciones2.Redondear(descuento_valor, 2);
		
		
		//Total
		precio_total=precio_sub_total + iva_valor + ice_valor - descuento_valor;				
		precio_total=Funciones2.Redondear(precio_total, 2);
		
		
		//Actualizar Valores
		detallefactura.setiva_valor(iva_valor);
		detallefactura.setice_valor(ice_valor);
		detallefactura.setdescuento_valor(descuento_valor);
		
		//Actualizar Total
		detallefactura.setsub_total(precio_sub_total);
		detallefactura.settotal(precio_total);				
	}
	
	
	
	public static DatoGeneral GetPrecio(DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa) throws Exception {
		DatoGeneral datoGeneral=new DatoGeneral();
		
		//CAMPOS DIRECTOS
		DetalleFactura detallefactura=new DetalleFactura();
				
		detallefactura.setid_empresa(detallenotacreditopuntoventa.getid_empresa());
		detallefactura.setid_sucursal(detallenotacreditopuntoventa.getid_sucursal());
		detallefactura.setid_bodega(detallenotacreditopuntoventa.getid_bodega());
		detallefactura.setid_producto(detallenotacreditopuntoventa.getid_producto());
		
		//CAMPOS CABECERA
		NotaCreditoPuntoVenta notacreditoPuntoVenta=detallenotacreditopuntoventa.getNotaCreditoPuntoVenta();		
		Factura facturaAux=new Factura();
		
		facturaAux.setid_tipo_precio(notacreditoPuntoVenta.getid_tipo_precio());
		detallefactura.setFactura(facturaAux);
		
		//PROCESO
		datoGeneral=DetalleFacturaLogicAdditional.GetPrecio(detallefactura,"PEDIDO_PUNTO_VENTA");
		
		
		return datoGeneral;
	}
	
	public static DatoGeneral GetPrecio(DetalleFacturaPuntoVenta detallefacturapuntoventa) throws Exception {
		DatoGeneral datoGeneral=new DatoGeneral();
		
		//CAMPOS DIRECTOS
		DetalleFactura detallefactura=new DetalleFactura();
				
		detallefactura.setid_empresa(detallefacturapuntoventa.getid_empresa());
		detallefactura.setid_sucursal(detallefacturapuntoventa.getid_sucursal());
		detallefactura.setid_bodega(detallefacturapuntoventa.getid_bodega());
		detallefactura.setid_producto(detallefacturapuntoventa.getid_producto());
		
		//CAMPOS CABECERA
		FacturaPuntoVenta pedidoPuntoVenta=detallefacturapuntoventa.getFacturaPuntoVenta();		
		Factura facturaAux=new Factura();
		
		facturaAux.setid_tipo_precio(pedidoPuntoVenta.getid_tipo_precio());
		detallefactura.setFactura(facturaAux);
		
		//PROCESO
		datoGeneral=DetalleFacturaLogicAdditional.GetPrecio(detallefactura,"PEDIDO_PUNTO_VENTA");
		
		
		return datoGeneral;
	}
	
	public static DatoGeneral GetPrecio(DetallePedidoPuntoVenta detallepedidopuntoventa) throws Exception {
		DatoGeneral datoGeneral=new DatoGeneral();
		
		//CAMPOS DIRECTOS
		DetalleFactura detallefactura=new DetalleFactura();
				
		detallefactura.setid_empresa(detallepedidopuntoventa.getid_empresa());
		detallefactura.setid_sucursal(detallepedidopuntoventa.getid_sucursal());
		detallefactura.setid_bodega(detallepedidopuntoventa.getid_bodega());
		detallefactura.setid_producto(detallepedidopuntoventa.getid_producto());
		
		//CAMPOS CABECERA
		PedidoPuntoVenta pedidoPuntoVenta=detallepedidopuntoventa.getPedidoPuntoVenta();		
		Factura facturaAux=new Factura();
		
		facturaAux.setid_tipo_precio(pedidoPuntoVenta.getid_tipo_precio());
		detallefactura.setFactura(facturaAux);
		
		//PROCESO
		datoGeneral=DetalleFacturaLogicAdditional.GetPrecio(detallefactura,"PEDIDO_PUNTO_VENTA");
		
		
		return datoGeneral;
	}
	
	public static DatoGeneral GetPrecio(DetalleFactura detallefactura,String sTipo) throws Exception {
		String sFinalQuery="";
		String sFinalQueryPrecio="";
		
		BodegaProductoLogic bodegaProductoLogic=new BodegaProductoLogic();
		ProductoLogic productoLogic=new ProductoLogic();
		PrecioLogic precioLogic=new PrecioLogic();
		
		Integer disponible=-1;
		Double precio=0.0;
		Double iva=0.0;
		Double ice=0.0;
		Double descuento=0.0;
		
		DatoGeneral datoGeneral=new DatoGeneral();
		
		sFinalQuery=InventarioSql.GetBodegaProductoSqlWhere(detallefactura.getid_empresa(), 
															detallefactura.getid_bodega(), 
															detallefactura.getid_producto());

		try {
			
			bodegaProductoLogic.getNewConnexionToDeep();
			
			precioLogic.setConnexion(bodegaProductoLogic.getConnexion());			
			productoLogic.setConnexion(bodegaProductoLogic.getConnexion());			
			
			
			
			productoLogic.getEntity(detallefactura.getid_producto());
				
			
			
			if(productoLogic.getProducto()!=null && productoLogic.getProducto().getId()>0) {
				precio=productoLogic.getProducto().getprecio();
				iva=productoLogic.getProducto().getiva();
				ice=productoLogic.getProducto().getice();
				descuento=productoLogic.getProducto().getdescuento();
				
			}								
			
		
			
			bodegaProductoLogic.getEntity(sFinalQuery);
			
			if(bodegaProductoLogic.getBodegaProducto()!=null) {
				System.out.println("Bodega Producto="+bodegaProductoLogic.getBodegaProducto().getId());
				
				disponible=bodegaProductoLogic.getBodegaProducto().getcantidad_disponible();
				
				if(bodegaProductoLogic.getBodegaProducto().getiva()>0) {
					precio=bodegaProductoLogic.getBodegaProducto().getprecio();
					iva=bodegaProductoLogic.getBodegaProducto().getiva();
					ice=bodegaProductoLogic.getBodegaProducto().getice();
					descuento=bodegaProductoLogic.getBodegaProducto().getdescuento();
				}
			}
			
			
			//PRECIO ACTUAL
			sFinalQueryPrecio=InventarioSql.GetPrecioSqlWhere(detallefactura.getid_bodega(),
															detallefactura.getid_producto(),
															detallefactura.getid_empresa(),
															detallefactura.getid_sucursal(),
															detallefactura.getFactura().getid_tipo_precio());


			precioLogic.getEntity(sFinalQueryPrecio);
			
			
			if(precioLogic.getPrecio()!=null) {
				precio=precioLogic.getPrecio().getprecio();
			}
			
			bodegaProductoLogic.commitNewConnexionToDeep();
			
			
			
		} catch(Exception e) {
			bodegaProductoLogic.rollbackNewConnexionToDeep();
						
		} finally {
			bodegaProductoLogic.closeNewConnexionToDeep();
		}
		
		
		datoGeneral.setiValorInteger(disponible);
		datoGeneral.setdValorDouble(precio);
		datoGeneral.setdValorDouble2(iva);
		datoGeneral.setdValorDouble3(ice);
		datoGeneral.setdValorDouble4(descuento);
		
		return datoGeneral;
	}
	
	public static void GetTotales(PedidoPuntoVenta pedidopuntoventa,List<DetallePedidoPuntoVenta> detallepedidopuntoventas) throws Exception {
		Factura factura=new Factura();
		ArrayList<DetalleFactura> detallefacturas=new ArrayList<DetalleFactura>();
		DetalleFactura detallefactura=new DetalleFactura();
		
		for(DetallePedidoPuntoVenta detallepedidopuntoventa : detallepedidopuntoventas) {
			detallefactura=new DetalleFactura();
			
			detallefactura.setsType(detallepedidopuntoventa.getsType());
			
			detallefactura.setiva_valor(detallepedidopuntoventa.getiva_valor());
			detallefactura.setice_valor(detallepedidopuntoventa.getice_valor());
			detallefactura.setdescuento_valor(detallepedidopuntoventa.getdescuento_valor());
			
			detallefactura.setsub_total(detallepedidopuntoventa.getsub_total());
			detallefactura.settotal(detallepedidopuntoventa.gettotal());
			
			detallefacturas.add(detallefactura);
		}
		
		DetalleFacturaLogicAdditional.GetTotales(factura,detallefacturas,"PEDIDO_PUNTO_VENTA");
		
		
		pedidopuntoventa.setiva(factura.getiva());
		pedidopuntoventa.setice(factura.getice());
		pedidopuntoventa.setdescuento(factura.getdescuento());
		
		
		pedidopuntoventa.setsub_total(factura.getsub_total());
		pedidopuntoventa.settotal(factura.gettotal());
		
	}
	
	public static void GetTotales(FacturaPuntoVenta facturapuntoventa,List<DetalleFacturaPuntoVenta> detallefacturapuntoventas) throws Exception {
		Factura factura=new Factura();
		ArrayList<DetalleFactura> detallefacturas=new ArrayList<DetalleFactura>();
		DetalleFactura detallefactura=new DetalleFactura();
		
		for(DetalleFacturaPuntoVenta detallefacturapuntoventa : detallefacturapuntoventas) {
			detallefactura=new DetalleFactura();
			
			detallefactura.setsType(detallefacturapuntoventa.getsType());
			
			detallefactura.setiva_valor(detallefacturapuntoventa.getiva_valor());
			detallefactura.setice_valor(detallefacturapuntoventa.getice_valor());
			detallefactura.setdescuento_valor(detallefacturapuntoventa.getdescuento_valor());
			
			detallefactura.setsub_total(detallefacturapuntoventa.getsub_total());
			detallefactura.settotal(detallefacturapuntoventa.gettotal());
			
			detallefacturas.add(detallefactura);
		}
		
		DetalleFacturaLogicAdditional.GetTotales(factura,detallefacturas,"FACTURA_PUNTO_VENTA");
		
		
		facturapuntoventa.setiva(factura.getiva());
		facturapuntoventa.setice(factura.getice());
		facturapuntoventa.setdescuento(factura.getdescuento());
		
		
		facturapuntoventa.setsub_total(factura.getsub_total());
		facturapuntoventa.settotal(factura.gettotal());
		
	}
	
	public static void GetTotales(Factura factura,List<DetalleFactura> detallefacturas,String sTipo) throws Exception {
		Double suman=0.0;
		
		Double iva=0.0;
		Double ice=0.0;
		Double descuento=0.0;
		
		Double sub_total=0.0;				
		Double total=0.0;
		
		
		for(DetalleFactura detallefactura : detallefacturas) {
			if(!detallefactura.getsType().equals(Constantes2.S_TOTALES)) {
				//suman+=detallefactura.getprecio();
				
				iva+=detallefactura.getiva_valor();
				ice+=detallefactura.getice_valor();
				descuento+=detallefactura.getdescuento_valor();
				
				
				sub_total+=detallefactura.getsub_total();
				total+=detallefactura.gettotal();
			}
		}
		
		//factura.setsuman(suman);
		factura.setiva(iva);
		factura.setice(ice);
		factura.setdescuento(descuento);
		
		
		factura.setsub_total(sub_total);
		factura.settotal(total);
		
		/*
		if(factura.getporcentaje_descuento()>0) {
			valor_descuento=suman * (factura.getporcentaje_descuento()/100);
			
			valor_descuento=Funciones2.Redondear(valor_descuento, 2);
			
			factura.setvalor_descuento(valor_descuento);
			factura.settotal_descuento(valor_descuento);
		}
		*/
		
		/*
		sub_total=factura.getsub_total() - factura.getvalor_descuento();
		sub_total=Funciones2.Redondear(sub_total, 2);
		
		factura.setsub_total(sub_total);
		
		total=sub_total + iva;
		total=Funciones2.Redondear(total, 2);
		*/				
	}
}