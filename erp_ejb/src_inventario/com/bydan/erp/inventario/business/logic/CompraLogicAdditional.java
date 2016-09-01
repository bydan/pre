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

import java.sql.SQLException;
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
import com.bydan.framework.erp.util.Connexion;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.DeepLoadType;
import com.bydan.framework.erp.util.EventoGlobalTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.util.Funciones2;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.cartera.business.logic.ClienteCoaLogic;
import com.bydan.erp.contabilidad.business.logic.FormatoLogic;
import com.bydan.erp.contabilidad.business.logic.FormatoLogicAdditional;
import com.bydan.erp.inventario.util.CompraConstantesFunciones;
import com.bydan.erp.inventario.util.CompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.CompraReturnGeneral;
//import com.bydan.erp.inventario.util.CompraParameterGeneral;
import com.bydan.erp.inventario.util.DetalleCompraConstantesFunciones;
import com.bydan.erp.inventario.util.DetallePedidoCompraConstantesFunciones;
import com.bydan.erp.inventario.util.PedidoCompraConstantesFunciones;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.logic.TransaccionLogic;
import com.bydan.erp.tesoreria.business.logic.TransaccionLogicAdditional;



@SuppressWarnings("unused")
final public class CompraLogicAdditional extends CompraLogic{		
	
	//CONTROL_INICIO
	public  CompraLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCompraToSave(Compra compra,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCompraToSave(Compra compra,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCompraToSaveAfter(Compra compra,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCompraToSaves(List<Compra> compras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCompraToSaves(List<Compra> compras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCompraToSavesAfter(List<Compra> compras,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCompraToGet(Compra compra,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCompraToGets(List<Compra> compras,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCompraToSave(Compra compra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCompraToGet(Compra compra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCompraActions(String sTipoJsonResponse,JSONObject jsonObjectCompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCompraDataTable(String sTipoJsonResponse,Compra compra,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonComprasDataTable(String sTipoJsonResponse,List<Compra> compras,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCompraColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayComprasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayComprasColumns;
	}
	
	public static void updateJSONArrayCompraActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCompra,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	//PARA ACCIONES ADDITIONAL
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<Compra> compras) throws Exception  {
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
	@SuppressWarnings("unchecked")
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {				
		//CONTROL_17
		
		 try {	
			
			
			//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();
				
			CompraLogic compraLogic=(CompraLogic)generalEntityLogic;
			CompraParameterReturnGeneral compraReturnGeneral=(CompraParameterReturnGeneral)generalEntityReturnGeneral;
			
			Boolean isConDeepOriginal=compraLogic.getIsConDeep();
			
			if(isConDeepOriginal) {
				compraLogic.setIsConDeep(false);
			}
			
			
			if(sProceso!=null && (sProceso.equals("ANULAR") || sProceso.equals("REVERSAR"))) {
				
				ArrayList<Compra> compras=(ArrayList<Compra>)objects;
				ArrayList<Compra> comprasProcesar=new ArrayList<Compra>();
				
				DetalleCompraLogic detalleCompraLogic=new DetalleCompraLogic(compraLogic.getConnexion());
				MovimientoInventarioLogic movimientoInventarioLogic=new MovimientoInventarioLogic(compraLogic.getConnexion());
				DetalleMovimientoInventarioLogic detalleMovimientoInventarioLogic=new DetalleMovimientoInventarioLogic(compraLogic.getConnexion());
				CostoLogic costoLogic=new CostoLogic(compraLogic.getConnexion());
				
				Integer iCount=0;
				String sFinalQuery="";
				
				
				for(Compra compra:compras) {
					if(compra.getIsSelected()) {
						iCount++;
						
						if(iCount>1) {
							throw new Exception("Solo debe escoger 1 Registro");
						}
						
						if(compra.getid_estado_inventario().equals(0L)) {
							throw new Exception("Compra ya Anulada");
						}
						
						comprasProcesar.add(compra);
					}
				}
					
				
				for(Compra compra:comprasProcesar) {
					if(compra.getIsSelected()) {						
						
						sFinalQuery=" where id_compra="+compra.getId();
						movimientoInventarioLogic.getEntity(sFinalQuery);
						
						if(movimientoInventarioLogic.getMovimientoInventario()!=null) {
							sFinalQuery=" where id_movimiento_inventario="+movimientoInventarioLogic.getMovimientoInventario().getId();
							detalleMovimientoInventarioLogic.getEntities(sFinalQuery);
							
							if(detalleMovimientoInventarioLogic.getDetalleMovimientoInventarios().size()>0) {
								//ACTUALIZAR DISPONIBLE
								movimientoInventarioLogic.getMovimientoInventario().setDetalleMovimientoInventarios(detalleMovimientoInventarioLogic.getDetalleMovimientoInventarios());
								MovimientoInventarioLogicAdditional.EgresoProductos(movimientoInventarioLogic,movimientoInventarioLogic.getMovimientoInventario(),false,false);
								//ACTUALIZAR DISPONIBLE-FIN
								
								for(DetalleMovimientoInventario detalleMovimientoInventario:detalleMovimientoInventarioLogic.getDetalleMovimientoInventarios()) {
									sFinalQuery=" where id_detalle_movimiento_inventario="+detalleMovimientoInventario.getId();
									costoLogic.getEntity(sFinalQuery);
									
									if(costoLogic.getCosto()!=null) {
										costoLogic.getCosto().setIsDeleted(true);
										costoLogic.saveCosto();
									}
									
									detalleMovimientoInventario.setIsDeleted(true);
								}
								
								detalleMovimientoInventarioLogic.saveDetalleMovimientoInventarios();
							}
							
							movimientoInventarioLogic.getMovimientoInventario().setIsDeleted(true);
							movimientoInventarioLogic.saveMovimientoInventario();
							
							
							if(sProceso.equals("ANULAR")) {
								sFinalQuery=" where id_compra="+compra.getId();							
								detalleCompraLogic.getEntities(sFinalQuery);
								
								if(detalleCompraLogic.getDetalleCompras().size()>0) {
									for(DetalleCompra detalleCompra:detalleCompraLogic.getDetalleCompras()) {
										detalleCompra.setid_estado_detalle_inventario(0L);
										DetalleCompraConstantesFunciones.InicializarValoresDetalleCompra(detalleCompra,true);
									}
									
									detalleCompraLogic.saveDetalleCompras();
								}
							
							
								compra.setid_estado_inventario(0L);
							
								CompraConstantesFunciones.InicializarValoresCompra(compra,true);
								
							} else {
								compra.setid_estado_inventario(3L);
							}
							
							compraLogic.setCompra(compra);
							compraLogic.saveCompra();
							
							if(isConDeepOriginal) {
								compraLogic.setIsConDeep(true);
							}
							
							compraReturnGeneral.setConMostrarMensaje(true);
							compraReturnGeneral.setsLabelProceso(sProceso);
							compraReturnGeneral.setsMensajeProceso("Proceso "+sProceso+" Realizado Correctamente");
						}
					}										
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
			
			 CompraParameterReturnGeneral compraReturnGeneral=(CompraParameterReturnGeneral)generalEntityReturnGeneral;
			 Compra compra=compraReturnGeneral.getCompra();;
			 CompraLogic compraLogic=(CompraLogic)generalEntityLogic;
			 	
			 MovimientoInventarioLogicAdditional movimientoinventarioLogicAdditional=new MovimientoInventarioLogicAdditional();
			 MovimientoInventario movimientoinventario=new MovimientoInventario();
			
			 /*
			 String sFinalQuery="";
			 Long id_formato=0L;			 
			 Long id_transaccion=0L;
			 */
			 
			 if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
						&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
						&& sTipo.equals("FORM")) {
						
				 try {
					 compraLogic.getNewConnexionToDeep();
					 
					 compra.setid_estado_inventario(1L);					 
					 
					 /*
					 //GET FORMATO COMPRA
					 id_formato=FormatoLogicAdditional.TraerIdFormato(compraLogic.getConnexion(), compra.getid_empresa(),"COMPRA");
					 compra.setid_formato(id_formato);
					 					 
					 //GET TRANSACCION COMPRA
					 id_transaccion=TransaccionLogicAdditional.TraerIdTransaccion(compraLogic.getConnexion(), compra.getid_empresa(), compra.getid_sucursal(),"COMPRA");					 					 						 
					 movimientoinventario.setid_transaccion(id_transaccion);
					 */
					 
					 movimientoinventario.setid_empresa(compra.getid_empresa());
					 movimientoinventario.setid_sucursal(compra.getid_sucursal());
					
					 //GET SECUENCIAL COMPRA
					 DatoGeneral datoGeneral=movimientoinventarioLogicAdditional.GetSecuencialFormatoMovimiento(compra,movimientoinventario,compraLogic.getConnexion(),false);						
					 
					 compra.setnumero_secuencial(datoGeneral.getsValorString());
					 compra.setid_formato(datoGeneral.getlValorLong1());					 
					 
					 compraLogic.commitNewConnexionToDeep();
					 
				 } catch(Exception e) {
					 compraLogic.rollbackNewConnexionToDeep();
					 
				 } finally {
					 compraLogic.closeNewConnexionToDeep();
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
		
		Compra compra=(Compra)generalEntity;
		
		if(compra.getIsNew() || !compra.getid_estado_inventario().equals(0L)) {
			compra.setid_estado_inventario(2L);
			
			List<FormaPagoInven> formaPagoInvens=compra.getFormaPagoInvens();
			
			Double dValorFormaPago=0.0;
			
			for(FormaPagoInven formaPagoInven:formaPagoInvens) {
				if(!formaPagoInven.getsType().equals(Constantes2.S_TOTALES)) {
					dValorFormaPago+=formaPagoInven.getvalor();
				}
			}
			
			if(dValorFormaPago<compra.gettotal()) {
				throw new Exception("El Total y las formas de Pago deben Coincidir");
			}
		} else {
			if(compra.getid_estado_inventario().equals(0L)) {
				throw new Exception("No se puede actualizar una compra Anulada o no Reversada");
			}
		}
	}
	
	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) throws SQLException, Exception {	
		//CONTROL_22
		Compra compra=(Compra)generalEntity;
		CompraLogic compraLogic=(CompraLogic)generalEntityLogic;
		
		MovimientoInventario movimientoinventario=new MovimientoInventario();
		MovimientoInventarioLogic movimientoinventarioLogic=new MovimientoInventarioLogic();
		MovimientoInventarioLogicAdditional movimientoinventarioLogicAdditional=new MovimientoInventarioLogicAdditional();
		//DefinicionLogic definicionLogic=new DefinicionLogic();
		
		DetalleMovimientoInventario detallemovimientoinventario=new DetalleMovimientoInventario();
		List<DetalleMovimientoInventario> detallemovimientoinventarios=new ArrayList<DetalleMovimientoInventario>();
		DetalleMovimientoInventarioLogic detallemovimientoinventarioLogic=new DetalleMovimientoInventarioLogic();
		
		DatoGeneral datoGeneral=new DatoGeneral();
				
		//String sFinalQueryDefinicion="";
		String sSecuencialFormato="";
		
		Long id_transaccion=0L;
		
		movimientoinventarioLogic.setConnexion(compraLogic.getConnexion());
		movimientoinventarioLogicAdditional.setConnexion(compraLogic.getConnexion());
		detallemovimientoinventarioLogic.setConnexion(compraLogic.getConnexion());
		//definicionLogic.setConnexion(compraLogic.getConnexion());
		
				
		movimientoinventario.setid_empresa(compra.getid_empresa());
 		movimientoinventario.setid_sucursal(compra.getid_sucursal());
 		movimientoinventario.setid_modulo(compra.getid_modulo());
 		movimientoinventario.setid_ejercicio(compra.getid_ejercicio());
 		movimientoinventario.setid_periodo(compra.getid_periodo());
 		movimientoinventario.setid_anio(compra.getid_anio());
 		movimientoinventario.setid_mes(compra.getid_mes());
 		movimientoinventario.setid_usuario(compra.getid_usuario());
 		movimientoinventario.setid_compra(compra.getId());
 		movimientoinventario.setgenerico_id(compra.getId());
 		movimientoinventario.settipo_id("COMPRA");
 		
 		movimientoinventario.setfecha_emision(compra.getfecha_emision());
 		movimientoinventario.setfecha_entrega(compra.getfecha_entrega());
 		
 		
 		//SECUENCIAL
 		id_transaccion=TransaccionLogicAdditional.TraerIdTransaccion(compraLogic.getConnexion(), compra.getid_empresa(), compra.getid_sucursal(),"COMPRA");					 					 						 
 		movimientoinventario.setid_transaccion(id_transaccion);//FALTA
 		
 		//sFinalQueryDefinicion=InventarioSql.GetDefinicionSqlWhere(id_transaccion);			
		//definicionLogic.getEntity(sFinalQueryDefinicion);
			
			
		//if(definicionLogic.getDefinicion()!=null) {
				
		datoGeneral=movimientoinventarioLogicAdditional.GetSecuencialFormatoMovimiento(compra,movimientoinventario,compraLogic.getConnexion(),true);
				
			//definicionLogic.getDefinicion().setsecuencial(datoGeneralMinimo.getlValorLong());
			//definicionLogic.getDefinicion().setsecuencial_formato(datoGeneralMinimo.getsValorString());
				
			//definicionLogic.saveDefinicion();
				
		//} else {
		//	throw new Exception("Definicion no definida para esta Transacción");
		//}	
 		
 				 	
 		movimientoinventario.setnumero_secuencial(datoGeneral.getsValorString());
 		
 		//SECUENCIAL-FIN
 		
 		
 		movimientoinventario.setid_moneda(compra.getid_moneda());
 		movimientoinventario.setid_tipo_cambio(compra.getid_tipo_cambio());
 		movimientoinventario.setid_estado_movimiento_inventario(2L);
 		movimientoinventario.setid_formato(compra.getid_formato());
 		movimientoinventario.setid_empleado(compra.getid_empleado());
 		movimientoinventario.setnumero_factura(compra.getnumero_factura());
 		movimientoinventario.setid_transportista(compra.getid_transportista());
 		movimientoinventario.setdescripcion(compra.getdescripcion());
 		movimientoinventario.setporcentaje_descuento(compra.getporcentaje_descuento());
 		movimientoinventario.setsuman(compra.getsuman());
 		movimientoinventario.setice(compra.getice());
 		movimientoinventario.setvalor_descuento(compra.getvalor_descuento());
 		movimientoinventario.settotal_descuento(compra.gettotal_descuento());
 		movimientoinventario.setiva(compra.getiva());
 		movimientoinventario.setstock(compra.getstock());
 		movimientoinventario.setsub_total(compra.getsub_total());
 		movimientoinventario.settotal_otro(compra.gettotal_otro());
 		movimientoinventario.setultimo_costo(compra.getultimo_costo());
 		movimientoinventario.setnumero_items(compra.getnumero_items());
 		movimientoinventario.setretencion(compra.getretencion());
 		movimientoinventario.settotal(compra.gettotal());
 		movimientoinventario.setflete(compra.getflete());
 		movimientoinventario.setimpuesto(compra.getimpuesto());
 		movimientoinventario.setid_tipo_transaccion_modulo(compra.getid_tipo_transaccion_modulo());
 		movimientoinventario.setid_asiento_contable(compra.getid_asiento_contable());
 		movimientoinventario.setnumero_comprobante(compra.getnumero_comprobante());
 		movimientoinventario.setfecha(compra.getfecha());
 		 		
 		movimientoinventarioLogic.setMovimientoInventario(movimientoinventario);
 		
 		movimientoinventarioLogic.saveMovimientoInventario();
 		
 		
 		for(DetalleCompra detallecompra:compra.getDetalleCompras()) {
 			if(detallecompra.getsType().contains(Constantes2.S_TOTALES)) {
 				continue;
 			}
 			
 			detallemovimientoinventario=new DetalleMovimientoInventario();
 			
 			
 			detallemovimientoinventario.setid_movimiento_inventario(movimientoinventario.getId());
 	 		detallemovimientoinventario.setid_empresa(detallecompra.getid_empresa());
 	 		detallemovimientoinventario.setid_sucursal(detallecompra.getid_sucursal());
 	 		detallemovimientoinventario.setid_ejercicio(detallecompra.getid_ejercicio());
 	 		detallemovimientoinventario.setid_periodo(detallecompra.getid_periodo());
 	 		detallemovimientoinventario.setid_anio(detallecompra.getid_anio());
 	 		detallemovimientoinventario.setid_mes(detallecompra.getid_mes());
 	 		detallemovimientoinventario.setid_estado_detalle_movimiento_inventario(2L);
 	 		detallemovimientoinventario.setid_bodega(detallecompra.getid_bodega());
 	 		detallemovimientoinventario.setid_producto(detallecompra.getid_producto());
 	 		detallemovimientoinventario.setid_unidad(detallecompra.getid_unidad());
 	 		detallemovimientoinventario.setdescripcion(detallecompra.getdescripcion());
 	 		detallemovimientoinventario.setcantidad(detallecompra.getcantidad());
 	 		detallemovimientoinventario.setdescuento(detallecompra.getdescuento());
 	 		detallemovimientoinventario.setcosto_unitario(detallecompra.getcosto_unitario());
 	 		detallemovimientoinventario.setcosto_total(detallecompra.getcosto_total());
 	 		detallemovimientoinventario.setdisponible(detallecompra.getdisponible());
 	 		detallemovimientoinventario.setiva(detallecompra.getiva());
 	 		detallemovimientoinventario.setiva_valor(detallecompra.getiva_valor());
 	 		detallemovimientoinventario.setcosto_iva(detallecompra.getcosto_iva());
 	 		detallemovimientoinventario.setice(detallecompra.getice());
 	 		detallemovimientoinventario.setice_valor(detallecompra.getice_valor());
 	 		detallemovimientoinventario.setdescuento1(detallecompra.getdescuento1());
 	 		detallemovimientoinventario.setdescuento2(detallecompra.getdescuento2());
 	 		detallemovimientoinventario.setserie(detallecompra.getserie());
 	 		detallemovimientoinventario.setlote(detallecompra.getlote());
 	 		detallemovimientoinventario.setfecha_elaboracion_lote(detallecompra.getfecha_elaboracion_lote());
 	 		detallemovimientoinventario.setfecha_caducidad_lote(detallecompra.getfecha_caducidad_lote());
 	 		detallemovimientoinventario.setid_novedad_producto(detallecompra.getid_novedad_producto());
 	 		detallemovimientoinventario.setid_centro_costo(detallecompra.getid_centro_costo());
 	 		detallemovimientoinventario.setid_cuenta_contable_costo(detallecompra.getid_cuenta_contable_costo());
 	 		detallemovimientoinventario.setnumero_comprobante(detallecompra.getnumero_comprobante());
 	 		detallemovimientoinventario.setlote_cliente(detallecompra.getlote());
 	 		detallemovimientoinventario.setid_tipo_detalle_movimiento_inventario(1L);
 	 		
 	 		
 			detallemovimientoinventarios.add(detallemovimientoinventario);
 		}
 		
 		
 		detallemovimientoinventarioLogic.setDetalleMovimientoInventarios(detallemovimientoinventarios);
 		detallemovimientoinventarioLogic.saveDetalleMovimientoInventarios();
 		
 		movimientoinventarioLogic.getMovimientoInventario().setDetalleMovimientoInventarios(detallemovimientoinventarios);
 		
 		MovimientoInventarioLogicAdditional.IngresoProductos(movimientoinventarioLogic,movimientoinventarioLogic.getMovimientoInventario(),true,true);
 		
	}
	
	
	
	//CONTROL_FUNCION1
	
	
	
	
	//CONTROL_FUNCION2
	
	public static void ActualizarCompra(Compra compra,String sTipo) throws Exception {
		
		//Boolean b1=compraLogic.getConnexion().getConnection().isClosed();
		CompraLogic compraLogic=new CompraLogic();
		ClienteCoaLogic clienteCoaLogic=new ClienteCoaLogic();
		String sFinalQuery="";
		
		try {
			compraLogic.getNewConnexionToDeep();
			
			clienteCoaLogic.setConnexion(compraLogic.getConnexion());
			
			if(sTipo.equals("id_clienteCompra")) {
				sFinalQuery=" where id_cliente="+compra.getid_cliente();
				
				clienteCoaLogic.getEntity(sFinalQuery);
				
				if(clienteCoaLogic.getClienteCoa()!=null) {
					compra.setautori_usuario(clienteCoaLogic.getClienteCoa().getautori_usuario());
					compra.setfactura_inicial(clienteCoaLogic.getClienteCoa().getnum_factura_ini());
					compra.setfactura_final(clienteCoaLogic.getClienteCoa().getnum_factura_fin());
					compra.setservicio_documento(clienteCoaLogic.getClienteCoa().getserie_docu());
					compra.setfecha_valor(clienteCoaLogic.getClienteCoa().getfecha_vali());
				
				} else {
					compra.setautori_usuario("");
					compra.setfactura_inicial("");
					compra.setfactura_final("");
					compra.setservicio_documento("");
					compra.setfecha_valor(new Date());
				}
			}
		
			compraLogic.commitNewConnexionToDeep();
			
		} catch(Exception e) {
			compraLogic.rollbackNewConnexionToDeep();
			
			throw e;
			
		} finally {
			compraLogic.closeNewConnexionToDeep();
		}						
	}
	
	public static void RecargarCompraDesdeRelacionado(Compra compra,String sTipo) throws Exception {
		CompraLogic compraLogic=new CompraLogic();
		DetalleCompra detallecompra=new DetalleCompra();
		ArrayList<DetalleCompra> detallecompras=new ArrayList<DetalleCompra>();
		
		PedidoCompraLogic pedidoCompraLogic=new PedidoCompraLogic();
		PedidoCompra pedidocompra=new PedidoCompra();
		
		DetallePedidoCompraLogic detallePedidoCompraLogic=new DetallePedidoCompraLogic();
		String sFinalQuery="";
		
		ArrayList<Classe> classes=new ArrayList<Classe>();
		DatosDeep datosDeep=new DatosDeep();
		DatosCliente datosCliente=new DatosCliente();
		
		try {
			
			compraLogic.getNewConnexionToDeep();
			
			pedidoCompraLogic.setConnexion(compraLogic.getConnexion());
			detallePedidoCompraLogic.setConnexion(compraLogic.getConnexion());
			
												
			datosDeep=new DatosDeep();
			datosDeep.setIsDeep(false);
			datosDeep.setDeepLoadType(DeepLoadType.INCLUDE);
			
			datosCliente.setIsConDeep(true);			
			datosCliente.setIsConExportar(false);
			
			
			if(sTipo.equals("PedidoCompra") && compra.getid_pedido_compra()!=null) {
				classes=PedidoCompraConstantesFunciones.getClassesForeignKeysOfPedidoCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
				
				datosDeep.setClases(classes);
				
				datosCliente.setDatosDeepParametros(false, DeepLoadType.INCLUDE, classes, "");
								
				pedidoCompraLogic.setDatosCliente(datosCliente);
				pedidoCompraLogic.setDatosDeep(datosDeep);
				pedidoCompraLogic.setIsConDeep(true);
								
				pedidoCompraLogic.getPedidoCompraDataAccess().setIsForForeingsKeysDataRelationships(true);
				
				
				sFinalQuery=" where id="+compra.getid_pedido_compra();
				
				pedidoCompraLogic.getEntity(sFinalQuery);
				
				
				pedidocompra=pedidoCompraLogic.getPedidoCompra();
				
				
				if(pedidocompra!=null) {
							
					compra.setfecha_emision(pedidocompra.getfecha_emision());	
					compra.setfecha_entrega(pedidocompra.getfecha_entrega());	
					
					compra.setid_moneda(pedidocompra.getid_moneda());
					compra.setMoneda(pedidocompra.getMoneda());	
					compra.setmoneda_descripcion(pedidocompra.getmoneda_descripcion());	
					
					if(pedidocompra.getid_tipo_cambio()!=null && pedidocompra.getid_tipo_cambio()>0L) {
						compra.setid_tipo_cambio(pedidocompra.getid_tipo_cambio());
					} else {
						compra.setid_tipo_cambio(null);
					}

					compra.setTipoCambio(pedidocompra.getTipoCambio());	
					compra.settipocambio_descripcion(pedidocompra.gettipocambio_descripcion());	
					
					compra.setid_cliente(pedidocompra.getid_cliente());					
					compra.setCliente(pedidocompra.getCliente());	
					compra.setcliente_descripcion(pedidocompra.getcliente_descripcion());	
					
					compra.setid_formato(pedidocompra.getid_formato());
					compra.setFormato(pedidocompra.getFormato());	
					compra.setformato_descripcion(pedidocompra.getformato_descripcion());	
					
					compra.setid_empleado(pedidocompra.getid_empleado());
					compra.setEmpleado(pedidocompra.getEmpleado());
					compra.setempleado_descripcion(pedidocompra.getempleado_descripcion());
					
					compra.setdescripcion(pedidocompra.getdescripcion());	
					compra.settotal(pedidocompra.gettotal());	
					compra.setfecha(pedidocompra.getfecha());	
					
					
					
					
					
					
					
					
					
					
					
					
					classes=DetallePedidoCompraConstantesFunciones.getClassesForeignKeysOfDetallePedidoCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					
					datosDeep.setClases(classes);
					
					datosCliente.setDatosDeepParametros(false, DeepLoadType.INCLUDE, classes, "");
									
					detallePedidoCompraLogic.setDatosCliente(datosCliente);
					detallePedidoCompraLogic.setDatosDeep(datosDeep);
					detallePedidoCompraLogic.setIsConDeep(true);
									
					detallePedidoCompraLogic.getDetallePedidoCompraDataAccess().setIsForForeingsKeysDataRelationships(true);
					
					
					sFinalQuery=" where id_pedido_compra="+compra.getid_pedido_compra();
					
					detallePedidoCompraLogic.getEntities(sFinalQuery);
					
					if(detallePedidoCompraLogic.getDetallePedidoCompras().size()>0) {
						System.out.println("Ok");
						
						for(DetallePedidoCompra detallepedidocompra:detallePedidoCompraLogic.getDetallePedidoCompras()) {
							detallecompra=new DetalleCompra();
							
							detallecompra.setid_empresa(detallepedidocompra.getid_empresa());
							detallecompra.setEmpresa(detallepedidocompra.getEmpresa());
							detallecompra.setempresa_descripcion(detallepedidocompra.getempresa_descripcion());	
							
							detallecompra.setid_sucursal(detallepedidocompra.getid_sucursal());
							detallecompra.setSucursal(detallepedidocompra.getSucursal());
							detallecompra.setsucursal_descripcion(detallepedidocompra.getsucursal_descripcion());	
							
							detallecompra.setid_ejercicio(detallepedidocompra.getid_ejercicio());
							detallecompra.setEjercicio(detallepedidocompra.getEjercicio());
							detallecompra.setejercicio_descripcion(detallepedidocompra.getejercicio_descripcion());	
							
							detallecompra.setid_periodo(detallepedidocompra.getid_periodo());
							detallecompra.setPeriodo(detallepedidocompra.getPeriodo());
							detallecompra.setperiodo_descripcion(detallepedidocompra.getperiodo_descripcion());	
							
							detallecompra.setid_anio(detallepedidocompra.getid_anio());
							detallecompra.setAnio(detallepedidocompra.getAnio());
							detallecompra.setanio_descripcion(detallepedidocompra.getanio_descripcion());	
							
							detallecompra.setid_mes(detallepedidocompra.getid_mes());
							detallecompra.setMes(detallepedidocompra.getMes());
							detallecompra.setmes_descripcion(detallepedidocompra.getmes_descripcion());	
							
							detallecompra.setid_bodega(detallepedidocompra.getid_bodega());
							detallecompra.setBodega(detallepedidocompra.getBodega());
							detallecompra.setbodega_descripcion(detallepedidocompra.getbodega_descripcion());	
							
							detallecompra.setid_producto(detallepedidocompra.getid_producto());
							detallecompra.setProducto(detallepedidocompra.getProducto());
							detallecompra.setproducto_descripcion(detallepedidocompra.getproducto_descripcion());	
							
							detallecompra.setid_unidad(detallepedidocompra.getid_unidad());
							detallecompra.setUnidad(detallepedidocompra.getUnidad());
							detallecompra.setunidad_descripcion(detallepedidocompra.getunidad_descripcion());	
							detallecompra.setdescripcion(detallepedidocompra.getdescripcion());	
							
							if(detallepedidocompra.getid_centro_costo()!=null && detallepedidocompra.getid_centro_costo()>0L) {
								detallecompra.setid_centro_costo(detallepedidocompra.getid_centro_costo());
							} else {
								detallecompra.setid_centro_costo(null);
							}

							detallecompra.setCentroCosto(detallepedidocompra.getCentroCosto());
							detallecompra.setcentrocosto_descripcion(detallepedidocompra.getcentrocosto_descripcion());	
							
							
							//VALORES MANUAL
							detallecompra.setcantidad(detallepedidocompra.getcantidad_pedido());
							detallecompra.setcosto_unitario(detallepedidocompra.getcosto_unitario());
							
							DetalleMovimientoInventarioLogicAdditional.GetCostoTotal(detallecompra);
							
							detallecompras.add(detallecompra);
						}
						
						
						DetalleMovimientoInventarioLogicAdditional.GetTotales(compra, detallecompras);
						
						compra.setDetalleCompras(detallecompras);
						
					} else {
						
						DetalleMovimientoInventarioLogicAdditional.GetTotales(compra, detallecompras);						
						compra.setDetalleCompras(detallecompras);
					}
					
				} else {
					
					DetalleMovimientoInventarioLogicAdditional.GetTotales(compra, detallecompras);					
					compra.setDetalleCompras(detallecompras);
				}
				
			} else {
				
				DetalleMovimientoInventarioLogicAdditional.GetTotales(compra, detallecompras);
				compra.setDetalleCompras(detallecompras);
			}
		
			compraLogic.commitNewConnexionToDeep();
			
		} catch(Exception e) {
			compraLogic.rollbackNewConnexionToDeep();
			
			throw e;
			
		} finally {
			compraLogic.closeNewConnexionToDeep();
		}	
	}
}

