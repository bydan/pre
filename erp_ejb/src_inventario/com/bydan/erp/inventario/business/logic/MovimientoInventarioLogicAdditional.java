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

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;






















import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.DeepLoadType;
import com.bydan.framework.erp.util.EventoGlobalTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.util.Funciones;
import com.bydan.framework.erp.util.Funciones2;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.cartera.business.entity.DetalleProve;
import com.bydan.erp.cartera.business.logic.DetalleProveLogic;
import com.bydan.erp.cartera.util.DetalleProveConstantesFunciones;
import com.bydan.erp.contabilidad.business.logic.AsientoContableLogic;
import com.bydan.erp.contabilidad.business.logic.FormatoLogicAdditional;
//import com.bydan.erp.contabilidad.util.AsientoContableReturnGeneral;
import com.bydan.erp.facturacion.business.logic.RetencionLogic;
import com.bydan.erp.facturacion.util.RetencionConstantesFunciones;
import com.bydan.erp.inventario.util.BodegaProductoConstantesFunciones;
import com.bydan.erp.inventario.util.CostoConstantesFunciones;
import com.bydan.erp.inventario.util.CostoConstantesFuncionesAdditional;
import com.bydan.erp.inventario.util.DetalleMovimientoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleOrdenCompraConstantesFunciones;
import com.bydan.erp.inventario.util.InventarioSql;
import com.bydan.erp.inventario.util.MovimientoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.MovimientoInventarioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.MovimientoInventarioReturnGeneral;
import com.bydan.erp.inventario.util.OrdenCompraConstantesFunciones;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.business.entity.*;
//import com.bydan.erp.inventario.business.interfaces.MovimientoInventarioAdditionable;
import com.bydan.erp.nomina.business.entity.Empleado;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.Transaccion;
import com.bydan.erp.tesoreria.business.logic.TransaccionLogic;
import com.bydan.erp.tesoreria.business.logic.TransaccionLogicAdditional;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
final public class MovimientoInventarioLogicAdditional extends MovimientoInventarioLogic { // implements MovimientoInventarioAdditionable{		
	//CONTROL_INICIO
	public  MovimientoInventarioLogicAdditional()throws Exception {
		super();
    }
	
	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) throws Exception {
		//CONTROL_21
		
		String sFinalQuery="";
		String sFinalQueryDefinicion="";
		
		MovimientoInventarioLogic movimientoInventarioLogic=(MovimientoInventarioLogic)generalEntityLogic;
		//TransaccionLogic transaccionLogic=new TransaccionLogic();
		DefinicionLogic definicionLogic=new DefinicionLogic();
		
		
		//transaccionLogic.setConnexion(movimientoInventarioLogic.getConnexion());
		definicionLogic.setConnexion(movimientoInventarioLogic.getConnexion());
		
		
		
		MovimientoInventario movimientoInventario=movimientoInventarioLogic.getMovimientoInventario();

		
		ArrayList<Classe> classes=new ArrayList<Classe>();
		String sSecuencialFormato="";
		
		//classes=MovimientoInventarioConstantesFunciones.getClassesForeignKeysOfMovimientoInventario(new ArrayList<Classe>(),DeepLoadType.NONE);
		
		classes.add(new Classe(Transaccion.class));

		
		//TRAE TODOS CAMPOS
		movimientoInventarioLogic.getMovimientoInventarioDataAccess().setIsForForeingsKeysDataRelationships(false);
		
		movimientoInventarioLogic.deepLoad(false,DeepLoadType.INCLUDE,classes,"");
		
						
		
		if(movimientoInventario.getDetalleMovimientoInventarios().size()>0) {
			if(movimientoInventario.getTransaccion().getid_tipo_transaccion_modulo().equals(35L) 
				|| movimientoInventario.getTransaccion().getid_tipo_transaccion_modulo().equals(43L) 
				|| movimientoInventario.getTransaccion().getid_tipo_transaccion_modulo().equals(44L)				
			) {
				
				sFinalQuery=InventarioSql.GetDefinicionSqlWhere(movimientoInventario.getid_transaccion());
				
				definicionLogic.getEntity(sFinalQuery);
				
				
				if(definicionLogic.getDefinicion()!=null && definicionLogic.getDefinicion().getid_tipo_definicion().equals(1L)) {
					
					//INGRESOS SIMPLES
					for(DetalleMovimientoInventario detalleMovimientoInventario : movimientoInventario.getDetalleMovimientoInventarios()) {
						detalleMovimientoInventario.setid_tipo_detalle_movimiento_inventario(2L);
					}
					
				} else if(definicionLogic.getDefinicion()!=null && definicionLogic.getDefinicion().getid_tipo_definicion().equals(2L)){
					
					//EGRESOS SIMPLES
					for(DetalleMovimientoInventario detalleMovimientoInventario : movimientoInventario.getDetalleMovimientoInventarios()) {
						detalleMovimientoInventario.setid_tipo_detalle_movimiento_inventario(2L);
					}
				}																					
				
			} else {
				throw new Exception("Este tipo de Transaccion no se realiza en esta pantalla");
			}
		} else {
			throw new Exception("Debe tener al menos un detalle");
		}
		
	}

	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) throws SQLException, Exception {
		//CONTROL_22
		
		String sFinalQuery="";
		String sFinalQueryDefinicion="";
		
		MovimientoInventarioLogic movimientoInventarioLogic=(MovimientoInventarioLogic)generalEntityLogic;
		//TransaccionLogic transaccionLogic=new TransaccionLogic();
		DefinicionLogic definicionLogic=new DefinicionLogic();
		
		
		//transaccionLogic.setConnexion(movimientoInventarioLogic.getConnexion());
		definicionLogic.setConnexion(movimientoInventarioLogic.getConnexion());
		
		
		
		MovimientoInventario movimientoInventario=movimientoInventarioLogic.getMovimientoInventario();

		
		ArrayList<Classe> classes=new ArrayList<Classe>();
		String sSecuencialFormato="";
		
		//classes=MovimientoInventarioConstantesFunciones.getClassesForeignKeysOfMovimientoInventario(new ArrayList<Classe>(),DeepLoadType.NONE);
		
		classes.add(new Classe(Transaccion.class));

		
		//TRAE TODOS CAMPOS
		movimientoInventarioLogic.getMovimientoInventarioDataAccess().setIsForForeingsKeysDataRelationships(false);
		
		movimientoInventarioLogic.deepLoad(false,DeepLoadType.INCLUDE,classes,"");
		
						
		
		if(movimientoInventario.getDetalleMovimientoInventarios().size()>0) {
			if(movimientoInventario.getTransaccion().getid_tipo_transaccion_modulo().equals(35L) 
				|| movimientoInventario.getTransaccion().getid_tipo_transaccion_modulo().equals(43L) 
				|| movimientoInventario.getTransaccion().getid_tipo_transaccion_modulo().equals(44L)				
			) {
				
				sFinalQuery=InventarioSql.GetDefinicionSqlWhere(movimientoInventario.getid_transaccion());
				
				definicionLogic.getEntity(sFinalQuery);
				
				
				//System.out.println(movimientoInventarioLogic.getMovimientoInventario().getTransaccion().getId());
				//System.out.println(definicionLogic.getDefinicion().getId());
				
				
				//if(movimientoInventario.getTransaccion().getid_tipo_transaccion_modulo().equals(35L)
				//		|| movimientoInventario.getTransaccion().getid_tipo_transaccion_modulo().equals(43L)
				
				
				
				
				if(definicionLogic.getDefinicion()!=null && definicionLogic.getDefinicion().getid_tipo_definicion().equals(1L)) {
					
					//INGRESOS SIMPLES
					MovimientoInventarioLogicAdditional.IngresoProductos(movimientoInventarioLogic,movimientoInventarioLogic.getMovimientoInventario(),true,true);
				
				} else if(definicionLogic.getDefinicion()!=null && definicionLogic.getDefinicion().getid_tipo_definicion().equals(2L)){
					
					//EGRESOS SIMPLES
					MovimientoInventarioLogicAdditional.EgresoProductos(movimientoInventarioLogic,movimientoInventarioLogic.getMovimientoInventario(),true,true);
				}
				
				
				
				if(definicionLogic.getDefinicion()!=null) {
						
					Long lSecuencial=definicionLogic.getDefinicion().getsecuencial();
						
					lSecuencial++;
					
					sSecuencialFormato=Funciones2.GenerarSecuencial(lSecuencial, 10, "MOVIMIENTO_INVENTARIO");
					
					definicionLogic.getDefinicion().setsecuencial(lSecuencial);
					definicionLogic.getDefinicion().setsecuencial_formato(sSecuencialFormato);
					
					definicionLogic.saveDefinicion();
					
				} else {
					throw new Exception("Definicion no definida para esta Transacción");
				}	
				
				
			} else {
				throw new Exception("Este tipo de Transaccion no se realiza en esta pantalla");
			}
		} else {
			throw new Exception("Debe tener al menos un detalle");
		}
	}
	
	public static void EgresoProductos(GeneralEntityLogic generalEntityLogic,MovimientoInventario movimientoInventario,Boolean generarCosto,Boolean actualizarEstadoMovimiento) throws SQLException, Exception {
		/*
		String sFinalQuery="";
		Integer cantidad_disponible=0;
		Integer total_egresos=0;
		
		BodegaProductoLogic bodegaProductoLogic=new BodegaProductoLogic();
		//BodegaProducto bodegaProductoActual=new BodegaProducto();
				
		bodegaProductoLogic.setConnexion(generalEntityLogic.getConnexion());		
		*/
		
		for(DetalleMovimientoInventario detalleMovimientoInventario : movimientoInventario.getDetalleMovimientoInventarios()) {
			//sFinalQuery=" where "+BodegaProductoConstantesFunciones.IDEMPRESA+"="+movimientoInventario.getid_empresa()+" and "+BodegaProductoConstantesFunciones.IDBODEGA+"="+detalleMovimientoInventario.getid_bodega()+" and "+BodegaProductoConstantesFunciones.IDPRODUCTO+"="+detalleMovimientoInventario.getid_producto();		
		
			MovimientoInventarioLogicAdditional.EgresoProducto(generalEntityLogic,movimientoInventario,detalleMovimientoInventario,generarCosto);
			
			/*
			detalleMovimientoInventario.setid_tipo_detalle_movimiento_inventario(2L);
			
			sFinalQuery=InventarioSql.GetBodegaProductoSqlWhere(movimientoInventario.getid_empresa(),
																detalleMovimientoInventario.getid_bodega(),
																detalleMovimientoInventario.getid_producto());
			
			bodegaProductoLogic.getEntity(sFinalQuery);
			
			
			cantidad_disponible=bodegaProductoLogic.getBodegaProducto().getcantidad_disponible();
			total_egresos=bodegaProductoLogic.getBodegaProducto().gettotal_egresos();
			
			
			if(cantidad_disponible >= detalleMovimientoInventario.getcantidad()) {
				
				cantidad_disponible=cantidad_disponible - detalleMovimientoInventario.getcantidad();
				total_egresos=total_egresos + detalleMovimientoInventario.getcantidad();
				
				bodegaProductoLogic.getBodegaProducto().setfecha_egreso(new Date());
				
				bodegaProductoLogic.getBodegaProducto().setcantidad_disponible(cantidad_disponible);
				bodegaProductoLogic.getBodegaProducto().settotal_egresos(total_egresos);
				//bodegaProductoLogic.getBodegaProducto().sett
				
				bodegaProductoLogic.saveBodegaProducto();
				
				if(generarCosto) {
					MovimientoInventarioLogicAdditional.CostoEgresoProducto(generalEntityLogic,
																		movimientoInventario,
																		detalleMovimientoInventario,bodegaProductoLogic.getBodegaProducto());
				}
			} else {
				throw new Exception("Cantidad Egresada mayor a la Disponible. (Total Disponible="+cantidad_disponible+")");
			}
			*/
		}
		
		if(actualizarEstadoMovimiento) {
			movimientoInventario.setid_estado_movimiento_inventario(2L);
		}
		
		//bodegaProductoActual=bodegaProductoLogic.getBodegaProducto();
		
		
	}
	
	public static void EgresoProducto(GeneralEntityLogic generalEntityLogic,MovimientoInventario movimientoInventario,DetalleMovimientoInventario detalleMovimientoInventario,Boolean generarCosto) throws SQLException, Exception {
		String sFinalQuery="";
		Integer cantidad_disponible=0;
		Integer total_egresos=0;
		
		BodegaProductoLogic bodegaProductoLogic=new BodegaProductoLogic();
		//BodegaProducto bodegaProductoActual=new BodegaProducto();
				
		bodegaProductoLogic.setConnexion(generalEntityLogic.getConnexion());		
		
		
		//sFinalQuery=" where "+BodegaProductoConstantesFunciones.IDEMPRESA+"="+movimientoInventario.getid_empresa()+" and "+BodegaProductoConstantesFunciones.IDBODEGA+"="+detalleMovimientoInventario.getid_bodega()+" and "+BodegaProductoConstantesFunciones.IDPRODUCTO+"="+detalleMovimientoInventario.getid_producto();		
		
		detalleMovimientoInventario.setid_tipo_detalle_movimiento_inventario(2L);
			
		sFinalQuery=InventarioSql.GetBodegaProductoSqlWhere(movimientoInventario.getid_empresa(),
																detalleMovimientoInventario.getid_bodega(),
																detalleMovimientoInventario.getid_producto());
			
		bodegaProductoLogic.getEntity(sFinalQuery);
			
			
		cantidad_disponible=bodegaProductoLogic.getBodegaProducto().getcantidad_disponible();
		total_egresos=bodegaProductoLogic.getBodegaProducto().gettotal_egresos();
			
			
		if(cantidad_disponible >= detalleMovimientoInventario.getcantidad()) {
				
			cantidad_disponible=cantidad_disponible - detalleMovimientoInventario.getcantidad();
			total_egresos=total_egresos + detalleMovimientoInventario.getcantidad();
				
			bodegaProductoLogic.getBodegaProducto().setfecha_egreso(new Date());
				
			bodegaProductoLogic.getBodegaProducto().setcantidad_disponible(cantidad_disponible);
			bodegaProductoLogic.getBodegaProducto().settotal_egresos(total_egresos);
			//bodegaProductoLogic.getBodegaProducto().sett
				
			bodegaProductoLogic.saveBodegaProducto();
				
			if(generarCosto) {
				MovimientoInventarioLogicAdditional.CostoEgresoProducto(generalEntityLogic,
																		movimientoInventario,
																		detalleMovimientoInventario,bodegaProductoLogic.getBodegaProducto());
			}
		} else {
			throw new Exception("Cantidad Egresada mayor a la Disponible. (Total Disponible="+cantidad_disponible+")");
		}
					
		//bodegaProductoActual=bodegaProductoLogic.getBodegaProducto();
	}
	
	public static void CostoIngresoProducto(GeneralEntityLogic generalEntityLogic,MovimientoInventario movimientoInventario,DetalleMovimientoInventario detalleMovimientoInventario,BodegaProducto bodegaProducto) throws SQLException, Exception {
		
		String sFinalQuery="";
		String sFinalQueryCosto="";
		
		//BodegaProductoLogic bodegaProductoLogic=new BodegaProductoLogic();
		CostoLogic costoLogic=new CostoLogic();
		
		Costo costo=new Costo();
		
		//BodegaProducto bodegaProductoActual=new BodegaProducto();
				

		//bodegaProductoLogic.setConnexion(generalEntityLogic.getConnexion());		
		costoLogic.setConnexion(generalEntityLogic.getConnexion());
		
		Integer cantidad_disponible=0;
		
		//for(DetalleMovimientoInventario detalleMovimiento : movimientoInventario.getDetalleMovimientoInventarios()) {
			//BODEGA PRODUCTO			
			//sFinalQuery=" where "+BodegaProductoConstantesFunciones.IDEMPRESA+"="+movimientoInventario.getid_empresa()+" and "+BodegaProductoConstantesFunciones.IDBODEGA+"="+detalleMovimiento.getid_bodega()+" and "+BodegaProductoConstantesFunciones.IDPRODUCTO+"="+detalleMovimiento.getid_producto();		
			
			/*
			sFinalQuery=InventarioSql.GetBodegaProductoSqlWhere(movimientoInventario.getid_empresa(),
																detalleMovimientoInventario.getid_bodega(),
																detalleMovimientoInventario.getid_producto());
			
			bodegaProductoLogic.getEntity(sFinalQuery);
			*/				
						
			
			//COSTO
			sFinalQueryCosto=InventarioSql.GetCostoSqlWhere(detalleMovimientoInventario.getid_bodega(),
															detalleMovimientoInventario.getid_producto(),
															movimientoInventario.getid_empresa(),
															movimientoInventario.getid_sucursal());
			
			
			costoLogic.getEntity(sFinalQueryCosto);
			
			
			
			Double valor_unitario_detalle_movimiento=0.0;
			Double valor_total_detalle_movimiento=0.0;
			Integer cantidad_movimiento=0;
			
			Double valor_total=0.0;
			Double valor_unitario=0.0;
			
			//cantidad_disponible=costoLogic.getCosto().getcantidad() - detalleMovimiento.getcantidad();
				
			if(costoLogic.getCosto()!=null) {
				
				cantidad_disponible=bodegaProducto.getcantidad_disponible();
								
				
				//DETALLE MOVIMIENTO
				cantidad_movimiento=detalleMovimientoInventario.getcantidad();
				
				valor_unitario_detalle_movimiento=detalleMovimientoInventario.getcosto_unitario();
					
				valor_total_detalle_movimiento=cantidad_movimiento * valor_unitario_detalle_movimiento;
				//DETALLE MOVIMIENTO
				
				
				//CALCULO VALOR UNITARIO
				valor_total=valor_total_detalle_movimiento + costoLogic.getCosto().getvalor_total();
				
				valor_unitario= valor_total / cantidad_disponible;
				
				valor_unitario=Funciones2.Redondear(valor_unitario, 2);
				
				//CALCULO VALOR UNITARIO
				
				
				costo=new Costo();
				
				MovimientoInventarioLogicAdditional.SetValoresCosto(movimientoInventario,detalleMovimientoInventario,costo,bodegaProducto,cantidad_disponible,valor_unitario,valor_total,CostoConstantesFuncionesAdditional.ID_TIPO_COSTO_INGRESO);				
									
				costoLogic.setCosto(costo);
				
				costoLogic.saveCosto();
			
			} else {
				
				
				cantidad_disponible=bodegaProducto.getcantidad_disponible();
								
				
				//DETALLE MOVIMIENTO
				cantidad_movimiento=detalleMovimientoInventario.getcantidad();
				
				valor_unitario_detalle_movimiento=detalleMovimientoInventario.getcosto_unitario();
					
				valor_total_detalle_movimiento=cantidad_movimiento * valor_unitario_detalle_movimiento;
				//DETALLE MOVIMIENTO
				
				
				//CALCULO VALOR UNITARIO
				
				valor_unitario= detalleMovimientoInventario.getcosto_unitario();
				
				valor_total=valor_unitario * cantidad_disponible;
				
				//CALCULO VALOR UNITARIO
				
				
				costo=new Costo();
				
				MovimientoInventarioLogicAdditional.SetValoresCosto(movimientoInventario,detalleMovimientoInventario,costo,bodegaProducto,cantidad_disponible,valor_unitario,valor_total,CostoConstantesFuncionesAdditional.ID_TIPO_COSTO_INGRESO);				
									
				costoLogic.setCosto(costo);
				
				costoLogic.saveCosto();
			}
			
			
		//}
		
		//bodegaProductoActual=bodegaProductoLogic.getBodegaProducto();				
	}

	public static void CostoEgresoProducto(GeneralEntityLogic generalEntityLogic,MovimientoInventario movimientoInventario,DetalleMovimientoInventario detalleMovimientoInventario,BodegaProducto bodegaProducto) throws SQLException, Exception {
		
		String sFinalQuery="";
		String sFinalQueryCosto="";
		
		//BodegaProductoLogic bodegaProductoLogic=new BodegaProductoLogic();
		CostoLogic costoLogic=new CostoLogic();
		
		Costo costo=new Costo();
		
		//BodegaProducto bodegaProductoActual=new BodegaProducto();
				

		//bodegaProductoLogic.setConnexion(generalEntityLogic.getConnexion());		
		costoLogic.setConnexion(generalEntityLogic.getConnexion());
		
		Integer cantidad_disponible=0;
		
		for(DetalleMovimientoInventario detalleMovimiento : movimientoInventario.getDetalleMovimientoInventarios()) {
			//BODEGA PRODUCTO			
			//sFinalQuery=" where "+BodegaProductoConstantesFunciones.IDEMPRESA+"="+movimientoInventario.getid_empresa()+" and "+BodegaProductoConstantesFunciones.IDBODEGA+"="+detalleMovimiento.getid_bodega()+" and "+BodegaProductoConstantesFunciones.IDPRODUCTO+"="+detalleMovimiento.getid_producto();		
			
			/*
			sFinalQuery=InventarioSql.GetBodegaProductoSqlWhere(movimientoInventario.getid_empresa(),
																detalleMovimientoInventario.getid_bodega(),
																detalleMovimientoInventario.getid_producto());
			
			bodegaProductoLogic.getEntity(sFinalQuery);
			*/				
						
			
			//COSTO
			sFinalQueryCosto=InventarioSql.GetCostoSqlWhere(detalleMovimiento.getid_bodega(),
															detalleMovimiento.getid_producto(),
															movimientoInventario.getid_empresa(),
															movimientoInventario.getid_sucursal());
			
			
			costoLogic.getEntity(sFinalQueryCosto);
			
			
			
			if(costoLogic.getCosto()!=null) {
				
				//cantidad_disponible=costoLogic.getCosto().getcantidad() - detalleMovimiento.getcantidad();
				
				cantidad_disponible=bodegaProducto.getcantidad_disponible();
				
				
				Double valor_unitario=0.0;
				Double valor_total=0.0;
				
				valor_unitario=costoLogic.getCosto().getvalor_unitario();
				
				valor_total=cantidad_disponible * valor_unitario;
								
				
				costo=new Costo();
				
				MovimientoInventarioLogicAdditional.SetValoresCosto(movimientoInventario,detalleMovimientoInventario,costo,bodegaProducto,cantidad_disponible,valor_unitario,valor_total,CostoConstantesFuncionesAdditional.ID_TIPO_COSTO_EGRESO);
				
				costoLogic.setCosto(costo);
								
				costoLogic.saveCosto();
				
			} else {
				
				
				cantidad_disponible=bodegaProducto.getcantidad_disponible();
				
				costo=new Costo();
			
				
				Double valor_unitario=0.0;
				Double valor_total=0.0;
				
				valor_unitario=0.0 / cantidad_disponible;
				
				valor_total=cantidad_disponible * valor_unitario;
												
				MovimientoInventarioLogicAdditional.SetValoresCosto(movimientoInventario,detalleMovimientoInventario,costo,bodegaProducto,cantidad_disponible,valor_unitario,valor_total,CostoConstantesFuncionesAdditional.ID_TIPO_COSTO_EGRESO);
					 						
		 		costoLogic.setCosto(costo);
		 		
		 		costoLogic.saveCosto();
			}
								
		}
		
		//bodegaProductoActual=bodegaProductoLogic.getBodegaProducto();				
	}

	public static void SetValoresCosto(MovimientoInventario movimientoInventario,DetalleMovimientoInventario detalleMovimientoInventario,Costo costo,BodegaProducto bodegaProducto,Integer cantidad_disponible,Double valor_unitario,Double valor_total,Long idTipoCosto) throws Exception {
		
		costo.setid_tipo_costo(idTipoCosto);
		costo.setid_empresa(movimientoInventario.getid_empresa());
 		costo.setid_sucursal(movimientoInventario.getid_sucursal());
 		costo.setid_bodega(bodegaProducto.getid_bodega());
 		costo.setid_producto(bodegaProducto.getid_producto());
 		costo.setid_periodo(movimientoInventario.getid_periodo());
 		costo.setid_ejercicio(movimientoInventario.getid_ejercicio());
 		costo.setid_detalle_movimiento_inventario(detalleMovimientoInventario.getId());
 		costo.setnumero_comprobante(0L);
 		costo.setfecha(new Date());
 		costo.setcantidad(cantidad_disponible);
 		costo.setvalor_unitario(valor_unitario);
 		costo.setvalor_total(valor_total);
 		costo.setid_anio(movimientoInventario.getid_anio());
 		costo.setid_mes(movimientoInventario.getid_mes());
	}
	
	public static void IngresoProductos(GeneralEntityLogic generalEntityLogic,MovimientoInventario movimientoInventario,Boolean generarCosto,Boolean actualizarEstadoMovimiento) throws SQLException, Exception {
		/*
		String sFinalQuery="";
		Integer cantidad_disponible=0;
		Integer total_ingresos=0;
		
		
		BodegaProductoLogic bodegaProductoLogic=new BodegaProductoLogic();
		
		//BodegaProducto bodegaProductoActual=new BodegaProducto();
				

		bodegaProductoLogic.setConnexion(generalEntityLogic.getConnexion());		
		*/
		
		for(DetalleMovimientoInventario detalleMovimientoInventario : movimientoInventario.getDetalleMovimientoInventarios()) {
			
			MovimientoInventarioLogicAdditional.IngresoProducto(generalEntityLogic,movimientoInventario,detalleMovimientoInventario,generarCosto);
			
			/*
			detalleMovimientoInventario.setid_tipo_detalle_movimiento_inventario(1L);
			
			sFinalQuery=InventarioSql.GetBodegaProductoSqlWhere(movimientoInventario.getid_empresa(),
																detalleMovimientoInventario.getid_bodega(),
																detalleMovimientoInventario.getid_producto());
			
			bodegaProductoLogic.getEntity(sFinalQuery);
			
			
			cantidad_disponible=bodegaProductoLogic.getBodegaProducto().getcantidad_disponible();
			total_ingresos=bodegaProductoLogic.getBodegaProducto().gettotal_ingresos();
			
			cantidad_disponible=cantidad_disponible + detalleMovimientoInventario.getcantidad();
			total_ingresos=total_ingresos + detalleMovimientoInventario.getcantidad();
			
			bodegaProductoLogic.getBodegaProducto().setcantidad_disponible(cantidad_disponible);
			bodegaProductoLogic.getBodegaProducto().settotal_ingresos(total_ingresos);
			
			bodegaProductoLogic.saveBodegaProducto();
			
			if(generarCosto) {
				MovimientoInventarioLogicAdditional.CostoIngresoProducto(generalEntityLogic,
																		movimientoInventario,
																		detalleMovimientoInventario,bodegaProductoLogic.getBodegaProducto());
			}
			*/
		}
		
		if(actualizarEstadoMovimiento) {
			movimientoInventario.setid_estado_movimiento_inventario(2L);
		}
		
		//bodegaProductoActual=bodegaProductoLogic.getBodegaProducto();
	}
		
	public static void IngresoProducto(GeneralEntityLogic generalEntityLogic,MovimientoInventario movimientoInventario,DetalleMovimientoInventario detalleMovimientoInventario,Boolean generarCosto) throws SQLException, Exception {
		String sFinalQuery="";
		Integer cantidad_disponible=0;
		Integer total_ingresos=0;
		
		BodegaProductoLogic bodegaProductoLogic=new BodegaProductoLogic();
		//BodegaProducto bodegaProductoActual=new BodegaProducto();
				

		bodegaProductoLogic.setConnexion(generalEntityLogic.getConnexion());
		
		detalleMovimientoInventario.setid_tipo_detalle_movimiento_inventario(1L);
		
		sFinalQuery=InventarioSql.GetBodegaProductoSqlWhere(movimientoInventario.getid_empresa(),
															detalleMovimientoInventario.getid_bodega(),
															detalleMovimientoInventario.getid_producto());
		
		bodegaProductoLogic.getEntity(sFinalQuery);
		
		
		cantidad_disponible=bodegaProductoLogic.getBodegaProducto().getcantidad_disponible();
		total_ingresos=bodegaProductoLogic.getBodegaProducto().gettotal_ingresos();
		
		cantidad_disponible=cantidad_disponible + detalleMovimientoInventario.getcantidad();
		total_ingresos=total_ingresos + detalleMovimientoInventario.getcantidad();
		
		bodegaProductoLogic.getBodegaProducto().setcantidad_disponible(cantidad_disponible);
		bodegaProductoLogic.getBodegaProducto().settotal_ingresos(total_ingresos);
		
		bodegaProductoLogic.saveBodegaProducto();
		
		if(generarCosto) {
			MovimientoInventarioLogicAdditional.CostoIngresoProducto(generalEntityLogic,
																	movimientoInventario,
																	detalleMovimientoInventario,bodegaProductoLogic.getBodegaProducto());
		}
	}
	
	
	public static Boolean validarSaveRelaciones(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_20
		Boolean validado=true;

		return validado;	
	}
	
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
			try {
			//CONTROL_19

				MovimientoInventarioLogic movimientoInventarioLogic=(MovimientoInventarioLogic)generalEntityLogic;
				MovimientoInventarioParameterReturnGeneral movimientoInventarioReturnGeneral=(MovimientoInventarioParameterReturnGeneral)generalEntityReturnGeneral;
				
				
				if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
						&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
						&& sTipo.equals("FORM")) {
					
					movimientoInventarioReturnGeneral.getMovimientoInventario().setid_estado_movimiento_inventario(1L);									
				}
				
				return generalEntityReturnGeneral;

			} catch(Exception e) {
				Funciones.manageException(logger,e);
				throw e;

			} finally {

			}
		}
		
	public static void checkMovimientoInventarioToSave(MovimientoInventario movimientoinventario,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkMovimientoInventarioToSave(MovimientoInventario movimientoinventario,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkMovimientoInventarioToSaveAfter(MovimientoInventario movimientoinventario,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkMovimientoInventarioToSaves(List<MovimientoInventario> movimientoinventarios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkMovimientoInventarioToSaves(List<MovimientoInventario> movimientoinventarios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkMovimientoInventarioToSavesAfter(List<MovimientoInventario> movimientoinventarios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkMovimientoInventarioToGet(MovimientoInventario movimientoinventario,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkMovimientoInventarioToGets(List<MovimientoInventario> movimientoinventarios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateMovimientoInventarioToSave(MovimientoInventario movimientoinventario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateMovimientoInventarioToGet(MovimientoInventario movimientoinventario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectMovimientoInventarioActions(String sTipoJsonResponse,JSONObject jsonObjectMovimientoInventario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonMovimientoInventarioDataTable(String sTipoJsonResponse,MovimientoInventario movimientoinventario,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonMovimientoInventariosDataTable(String sTipoJsonResponse,List<MovimientoInventario> movimientoinventarios,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayMovimientoInventarioColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayMovimientoInventariosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayMovimientoInventariosColumns;
	}
	
	public static void updateJSONArrayMovimientoInventarioActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectMovimientoInventario,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosMovimientoInventario(MovimientoInventario movimientoinventario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		movimientoinventario.setnumero_comprobante(movimientoinventario.getnumero_comprobante().trim());
		movimientoinventario.setnumero_secuencial(movimientoinventario.getnumero_secuencial().trim());
		movimientoinventario.setdescripcion(movimientoinventario.getdescripcion().trim());
	}
	
	public static void quitarEspaciosMovimientoInventarios(List<MovimientoInventario> movimientoinventarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MovimientoInventario movimientoinventario: movimientoinventarios) {
			movimientoinventario.setnumero_comprobante(movimientoinventario.getnumero_comprobante().trim());
			movimientoinventario.setnumero_secuencial(movimientoinventario.getnumero_secuencial().trim());
			movimientoinventario.setdescripcion(movimientoinventario.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMovimientoInventario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(MovimientoInventarioConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(MovimientoInventarioConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(MovimientoInventarioConstantesFunciones.IDMODULO);
		arrColumnasGlobales.add(MovimientoInventarioConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(MovimientoInventarioConstantesFunciones.IDPERIODO);
		arrColumnasGlobales.add(MovimientoInventarioConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	/*
	 * FALTA FUNCIONES ENCERAR VALORES DECIMALES
	*/
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<MovimientoInventario> movimientoinventarios) throws Exception  {
		Boolean esProcesado=true;
		String sNumeroComprobante="";
		Long idAsientoContable=0L;
		
		OrdenCompraLogic ordencompraLogic=new OrdenCompraLogic();
		DetalleOrdenCompraLogic detalleordencompraLogic=new DetalleOrdenCompraLogic();
		DefinicionLogic definicionLogic=new DefinicionLogic();
		MovimientoInventarioLogic movimientoinventarioLogic=new MovimientoInventarioLogic();
		DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic=new DetalleMovimientoInventarioLogic();
		DetalleProveLogic detalleproveLogic=new DetalleProveLogic();
		RetencionLogic retencionLogic=new RetencionLogic();
		BodegaProductoLogicAdditional bodegaproductoLogicAdditional=new BodegaProductoLogicAdditional();
		
		String sFinalQuery="";
		ArrayList<Classe> classes=new ArrayList<Classe>();
		
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
		
			ordencompraLogic.setConnexion(this.connexion);
			definicionLogic.setConnexion(this.connexion);
			movimientoinventarioLogic.setConnexion(this.connexion);
			detallemovimientoinventarioLogic.setConnexion(this.connexion);
			detalleproveLogic.setConnexion(this.connexion);
			retencionLogic.setConnexion(this.connexion);
			detalleordencompraLogic.setConnexion(this.connexion);
			bodegaproductoLogicAdditional.setConnexion(this.connexion);
						
			if(sProceso.equals("ANULARMOVIMIENTO")) {
				for(MovimientoInventario movimientoinventario:movimientoinventarios) {
					if(movimientoinventario.getIsSelected()) {
						sNumeroComprobante=movimientoinventario.getnumero_comprobante();
						
						
						/*
						ordencompraLogic.getEntity(movimientoinventario.getid_orden_compra());
												
						if(ordencompraLogic.getOrdenCompra()!=null && ordencompraLogic.getOrdenCompra().getId()>0L) {
							definicionLogic.getEntity(ordencompraLogic.getOrdenCompra().getId());
							
							if(definicionLogic.getDefinicion()!=null && definicionLogic.getDefinicion().getId()>0) {
								if(definicionLogic.getDefinicion().getcon_anticipo()) {
									//OTRA VALIDACION									
									continue;
								}
								
								classes=new ArrayList<Classe>();								
								classes.add(new Classe(DetalleOrdenCompra.class));
									
								ordencompraLogic.deepLoad(false, DeepLoadType.INCLUDE, classes,"");
								
								if(ordencompraLogic.getOrdenCompra().getDetalleOrdenCompras().size()>0) {
									continue;
								}
							}
							
							OrdenCompraConstantesFunciones.InicializarValoresOrdenCompra(ordencompraLogic.getOrdenCompra(),true);
							ordencompraLogic.getOrdenCompra().setid_estado_orden_compra(0L);
							ordencompraLogic.saveOrdenCompra();
							
							classes=new ArrayList<Classe>();
							classes.add(new Classe(DetalleOrdenCompra.class));

							ordencompraLogic.deepLoad(false, DeepLoadType.INCLUDE, classes,"");
							
							DetalleOrdenCompraConstantesFunciones.InicializarValoresDetalleOrdenCompras(ordencompraLogic.getOrdenCompra().getDetalleOrdenCompras(),true);
							
							detalleordencompraLogic.setDetalleOrdenCompras(ordencompraLogic.getOrdenCompra().getDetalleOrdenCompras());
							
							for(DetalleOrdenCompra detalleordencompra:detalleordencompraLogic.getDetalleOrdenCompras()) {
								detalleordencompra.setid_estado_detalle_orden_compra(0L);
							}
							
							detalleordencompraLogic.saveDetalleOrdenCompras();
						}
						*/
						
						movimientoinventarioLogic.getEntity(movimientoinventario.getId());
						MovimientoInventarioConstantesFunciones.InicializarValoresMovimientoInventario(movimientoinventarioLogic.getMovimientoInventario(),true);
						movimientoinventarioLogic.getMovimientoInventario().setid_estado_movimiento_inventario(0L);
						movimientoinventarioLogic.saveMovimientoInventario();
						
						//CARGAR DETALLE MOVIMIENTOS
						classes=new ArrayList<Classe>();
						classes.add(new Classe(DetalleMovimientoInventario.class));

						movimientoinventarioLogic.deepLoad(false, DeepLoadType.INCLUDE, classes,"");
						
						detallemovimientoinventarioLogic.setDetalleMovimientoInventarios(movimientoinventarioLogic.getMovimientoInventario().getDetalleMovimientoInventarios());												
						
						DetalleMovimientoInventarioConstantesFunciones.InicializarValoresDetalleMovimientoInventarios(detallemovimientoinventarioLogic.getDetalleMovimientoInventarios(),true);
						
						//ENCERA CANTIDADES
						for(DetalleMovimientoInventario detallemovimientoinventarios:detallemovimientoinventarioLogic.getDetalleMovimientoInventarios()) {
							detallemovimientoinventarios.setid_estado_detalle_movimiento_inventario(0L);
						}
						
						detallemovimientoinventarioLogic.saveDetalleMovimientoInventarios();
						
						//RECALCULA STOCK CON ENCERACIONES
						for(DetalleMovimientoInventario detallemovimientoinventarios:detallemovimientoinventarioLogic.getDetalleMovimientoInventarios()) {
							bodegaproductoLogicAdditional.recalcularStock(detallemovimientoinventarios.getid_bodega(),detallemovimientoinventarios.getid_producto());
						}
						
						//FALTA ANULAR SERIES
						
						//CARGAR DETALLE PROVEEDORES
						/*
						sFinalQuery=" where id_orden_compra="+movimientoinventario.getid_orden_compra()+"";
						detalleproveLogic.getEntities(sFinalQuery);
						
						DetalleProveConstantesFunciones.InicializarValoresDetalleProves(detalleproveLogic.getDetalleProves(),true);
												
						for(DetalleProve detalleprove:detalleproveLogic.getDetalleProves()) {
							detalleprove.setid_estado_detalle_cliente(0L);
						}

						detalleproveLogic.saveDetalleProves();	
						
						//CARGAR RETENCIONES
						sFinalQuery=" where id_asiento_contable="+movimientoinventario.getid_asiento_contable();
						retencionLogic.getEntities(sFinalQuery);
						
						RetencionConstantesFunciones.InicializarValoresRetencions(retencionLogic.getRetencions(),true);
	
						retencionLogic.saveRetencions();	
						*/
					}
				}
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return esProcesado;
	}
	
	//PARA ACCIONES NORMALES
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {
			try {

				//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();


				return generalEntityReturnGeneral;

			} catch(Exception e) {
				Funciones.manageException(logger,e);
				throw e;

			} finally {

			}
	}
	//CONTROL_FUNCION2
	public DatoGeneral GetSecuencialFormatoMovimiento(Transferencia transferencia,MovimientoInventario movimientoinventario,Connexion connexion,Boolean conGuardarSecuencial) throws Exception {
		String sSecuencialFormato="";
		
		DatoGeneral datoGeneral=this.GetSecuencialFormatoMovimiento(movimientoinventario,"TRANSFERENCIA",connexion,conGuardarSecuencial);
				
		return datoGeneral;//sSecuencialFormato;
	}
	
	public DatoGeneral GetSecuencialFormatoMovimiento(RequisicionCompra requisicioncompra,MovimientoInventario movimientoinventario,Connexion connexion,Boolean conGuardarSecuencial) throws Exception {
		String sSecuencialFormato="";
		
		DatoGeneral datoGeneral=this.GetSecuencialFormatoMovimiento(movimientoinventario,"REQUISICION",connexion,conGuardarSecuencial);
				
		return datoGeneral;//sSecuencialFormato;
	}
	
	public DatoGeneral GetSecuencialFormatoMovimiento(Requisicion requisicion,MovimientoInventario movimientoinventario,Connexion connexion,Boolean conGuardarSecuencial) throws Exception {
		String sSecuencialFormato="";
		
		DatoGeneral datoGeneral=this.GetSecuencialFormatoMovimiento(movimientoinventario,"REQUISICION_BODEGA",connexion,conGuardarSecuencial);
				
		return datoGeneral;//sSecuencialFormato;
	}
	
	public DatoGeneral GetSecuencialFormatoMovimiento(OrdenCompra ordencompra,MovimientoInventario movimientoinventario,Connexion connexion,Boolean conGuardarSecuencial) throws Exception {
		String sSecuencialFormato="";
		
		DatoGeneral datoGeneral=this.GetSecuencialFormatoMovimiento(movimientoinventario,"ORDEN_COMPRA",connexion,conGuardarSecuencial);
				
		return datoGeneral;//sSecuencialFormato;
	}
	
	public DatoGeneral GetSecuencialFormatoMovimiento(PedidoCompra pedidocompra,MovimientoInventario movimientoinventario,Connexion connexion,Boolean conGuardarSecuencial) throws Exception {
		String sSecuencialFormato="";
		
		DatoGeneral datoGeneral=this.GetSecuencialFormatoMovimiento(movimientoinventario,"PEDIDO_COMPRA",connexion,conGuardarSecuencial);
				
		return datoGeneral;//sSecuencialFormato;
	}
	
	
	public DatoGeneral GetSecuencialFormatoMovimiento(Compra compra,MovimientoInventario movimientoinventario,Connexion connexion,Boolean conGuardarSecuencial) throws Exception {
		String sSecuencialFormato="";
		
		DatoGeneral datoGeneral=this.GetSecuencialFormatoMovimiento(movimientoinventario,"COMPRA",connexion,conGuardarSecuencial);
				
		return datoGeneral;//sSecuencialFormato;
	}
	
	public DatoGeneral GetSecuencialFormatoMovimiento(MovimientoInventario movimientoInventario) throws Exception {
		String sSecuencialFormato="";
				
		DatoGeneral datoGeneral=this.GetSecuencialFormatoMovimiento(movimientoInventario,"MOVIMIENTO_INVENTARIO",null,false);
		
		return datoGeneral;//sSecuencialFormato;
	}
	
	public DatoGeneral GetSecuencialFormatoMovimiento(MovimientoInventario movimientoInventario,String sTipo,Connexion connexionP,Boolean conGuardarSecuencial) throws Exception {

		
		String sSecuencialFormato="";					
		String sFinalQueryDefinicion="";		
		
		ArrayList<Classe> classes=new ArrayList<Classe>();
		
		DefinicionLogic definicionLogic=new DefinicionLogic();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		
		try {
			
			if(connexionP==null) {
				this.getNewConnexionToDeep();
				
			} else {
				this.setConnexion(connexionP);
			}
			
			
			
			definicionLogic.setConnexion(this.getConnexion());
			
			classes.add(new Classe(Transaccion.class));
	
			
			if(sTipo!="MOVIMIENTO_INVENTARIO") {
				Long id_formato=0L;
				Long id_transaccion=0L;
				
				 //GET FORMATO COMPRA
				id_formato=FormatoLogicAdditional.TraerIdFormato(this.getConnexion(), movimientoInventario.getid_empresa(),sTipo);
				movimientoinventario.setid_formato(id_formato); 
				movimientoInventario.setid_formato(id_formato); 
				
				 //GET TRANSACCION COMPRA
				id_transaccion=TransaccionLogicAdditional.TraerIdTransaccion(this.getConnexion(), movimientoInventario.getid_empresa(), movimientoInventario.getid_sucursal(),sTipo);					 					 						 
				movimientoinventario.setid_transaccion(id_transaccion);
				movimientoInventario.setid_transaccion(id_transaccion);
				 
				/*
				TransaccionLogic transaccionLogic=new TransaccionLogic();
				String sFinalQueryTransaccion="";	
				
				transaccionLogic.setConnexion(this.getConnexion());
				
				sFinalQueryTransaccion=" where id_modulo=5 and id_tipo_transaccion_modulo=36 ";
				
				transaccionLogic.getEntity(sFinalQueryTransaccion);
				
				
				if(transaccionLogic.getTransaccion()!=null && transaccionLogic.getTransaccion().getId()>0) {
					movimientoInventario.setid_transaccion(transaccionLogic.getTransaccion().getId());
					
				} else {
					throw new Exception("Transaccion de Compra No Definida");
				}
				*/
			}
			
			//TRAE TODOS CAMPOS
			
			this.setMovimientoInventario(movimientoInventario);
			
			this.getMovimientoInventarioDataAccess().setIsForForeingsKeysDataRelationships(false);
			
			
			this.deepLoad(false,DeepLoadType.INCLUDE,classes,"");
			
			
			if(this.getMovimientoInventario().getid_transaccion()!=null && this.getMovimientoInventario().getid_transaccion()>0) {
					
				sFinalQueryDefinicion=InventarioSql.GetDefinicionSqlWhere(this.getMovimientoInventario().getid_transaccion());
					
				definicionLogic.getEntity(sFinalQueryDefinicion);
					
					
				if(definicionLogic.getDefinicion()!=null) {
						
					Long lSecuencial=definicionLogic.getDefinicion().getsecuencial();
						
					lSecuencial++;
					
					sSecuencialFormato=Funciones2.GenerarSecuencial(lSecuencial, 10, sTipo);
					
					datoGeneral.setsValorString(sSecuencialFormato);
					datoGeneral.setlValorLong(lSecuencial);
					
					datoGeneral.setlValorLong1(movimientoinventario.getid_formato());
					datoGeneral.setlValorLong2(movimientoinventario.getid_transaccion());
					
					if(conGuardarSecuencial) {
						definicionLogic.getDefinicion().setsecuencial(lSecuencial);
						definicionLogic.getDefinicion().setsecuencial_formato(sSecuencialFormato);
						
						definicionLogic.saveDefinicion();
					}
					
				} else {
					throw new Exception("Definicion no definida para esta Transacción");
				}			
			}
			
			if(connexionP==null) {
				this.commitNewConnexionToDeep();
			}
			
		} catch(Exception e) {
			
			if(connexionP==null) {
				this.rollbackNewConnexionToDeep();
			}
			
			throw e;
			
		} finally {
			if(connexionP==null) {
				this.closeNewConnexionToDeep();
			}
		}
		
		return datoGeneral;//sSecuencialFormato;
		
	}

	public DatoGeneral actualizarDefinicionSecuencialGeneral(Connexion connexion,DefinicionLogic definicionLogic,MovimientoInventario movimientoinventario,Long id_empresa,Long id_sucursal,String sTipo) throws Exception {
		//TRAER Y ACTUALIZAR SECUENCIAL
		//GET FORMATO COMPRA
		Long id_formato=0L;			 
		Long id_transaccion=0L;
		
		String sFinalQuery="";
		
		DatoGeneral datoGeneral=new DatoGeneral();
		
		id_formato=FormatoLogicAdditional.TraerIdFormato(connexion, id_empresa,sTipo);
		movimientoinventario.setid_formato(id_formato);
		//pedidocompra.setid_formato(id_formato);
		 		 
		 //GET TRANSACCION COMPRA
		id_transaccion=TransaccionLogicAdditional.TraerIdTransaccion(connexion, id_empresa, id_sucursal,sTipo);					 					 						 
		movimientoinventario.setid_transaccion(id_transaccion);
		 		
		datoGeneral=this.GetSecuencialFormatoMovimiento(movimientoinventario,sTipo,connexion,false);						
		
		//pedidocompra.setnumero_secuencial(datoGeneralMinimo.getsValorString());
		
		//DEFINICION ACTUALIZAR
		sFinalQuery=InventarioSql.GetDefinicionSqlWhere(id_transaccion);
		
		definicionLogic.getEntity(sFinalQuery);
		
		
		if(definicionLogic.getDefinicion()!=null) {
			
			Long lSecuencial=definicionLogic.getDefinicion().getsecuencial();
				
			lSecuencial++;
			
			String sSecuencialFormato=Funciones2.GenerarSecuencial(lSecuencial, 10, sTipo);
			
			definicionLogic.getDefinicion().setsecuencial(lSecuencial);
			definicionLogic.getDefinicion().setsecuencial_formato(sSecuencialFormato);
			
			definicionLogic.saveDefinicion();
			
		} else {
			throw new Exception("Definicion no definida para esta Transacción");
		}	
		//TRAER Y ACTUALIZAR SECUENCIAL FIN
		
		return datoGeneral;
	}
}

