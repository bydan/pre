














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
import com.bydan.erp.contabilidad.business.logic.FormatoLogicAdditional;
import com.bydan.erp.puntoventa.util.FacturaPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.FacturaPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.FacturaPuntoVentaReturnGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.puntoventa.business.entity.*;
//import com.bydan.erp.puntoventa.business.interfaces.FacturaPuntoVentaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class FacturaPuntoVentaLogicAdditional extends FacturaPuntoVentaLogic { // implements FacturaPuntoVentaAdditionable{
	
	public  FacturaPuntoVentaLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19

			 FacturaPuntoVentaParameterReturnGeneral facturapuntoventaReturnGeneral=(FacturaPuntoVentaParameterReturnGeneral)generalEntityReturnGeneral;
			 FacturaPuntoVenta facturapuntoventa=facturapuntoventaReturnGeneral.getFacturaPuntoVenta();;
			 FacturaPuntoVentaLogic facturapuntoventaLogic=(FacturaPuntoVentaLogic)generalEntityLogic;
			 //FacturaPuntoVenta pedidoFacturaPuntoVenta=(FacturaPuntoVenta)object;
							
			 CajeroTurnoLogic cajeroturnoLogic=new CajeroTurnoLogic();
			 CajaLogic cajaLogic=new CajaLogic();
				
			 String sFinalQuery="";
			 Long id_formato=0L;
			 String sTipoFuncionalidad="";
			 Boolean esFactura=false;
			 
			 //CONTROL_19
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
					&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
					&& sTipo.equals("FORM")) {															
					
					 try {
						 facturapuntoventaLogic.getNewConnexionToDeep();
						 
						 cajeroturnoLogic.setConnexion(facturapuntoventaLogic.getConnexion());
						 cajaLogic.setConnexion(facturapuntoventaLogic.getConnexion());
						 
						 facturapuntoventa.setid_estado_factura_punto_venta(1L);
						 
						 //FORMATO 
						 if(opcion.getcodigo().equals("FACTURAPUNTOVENTA")) {
							 esFactura=true;
							 
						 }
						 
						 
						 if(esFactura) {
							 sTipoFuncionalidad="FACTURA_PUNTO_VENTA";
							 facturapuntoventa.setid_tipo_factura_punto_venta(1L);
							 
						 } else {
							 sTipoFuncionalidad="NOTA_VENTA_PUNTO_VENTA";
							 facturapuntoventa.setid_tipo_factura_punto_venta(2L);
						 }
						 
						 id_formato=FormatoLogicAdditional.TraerIdFormato(facturapuntoventaLogic.getConnexion(), parametroGeneralUsuario.getid_empresa(),sTipoFuncionalidad);
							
						 if(id_formato > 0L) {
							 facturapuntoventa.setid_formato(id_formato);
						 }
						 
						 
						 //CAJERO						 
						 sFinalQuery=ErpSql.GetGeneralSqlWhere(true, parametroGeneralUsuario.getid_empresa(), parametroGeneralUsuario.getid_sucursal(), parametroGeneralUsuario.getid_usuario());
						 
						 cajeroturnoLogic.getEntity(sFinalQuery);
						 
						 if(cajeroturnoLogic.getCajeroTurno()!=null) {
							
							 facturapuntoventa.setid_caja(cajeroturnoLogic.getCajeroTurno().getid_caja());
							 facturapuntoventa.setid_mesa(cajeroturnoLogic.getCajeroTurno().getid_mesa());
							 facturapuntoventa.setid_vendedor(cajeroturnoLogic.getCajeroTurno().getid_vendedor());
							 							 
							 cajaLogic.getEntity(cajeroturnoLogic.getCajeroTurno().getid_caja());
							 
							 Long lSecuencial=0L;
							 String sSecuencialFormato="";
							 
							 if(esFactura) {
								 lSecuencial=cajaLogic.getCaja().getsecuencial_factura();
							 } else {
								 lSecuencial=cajaLogic.getCaja().getsecuencial_nota_venta();
							 }
							 
							 lSecuencial++;
								
							 sSecuencialFormato=Funciones2.GenerarSecuencial(lSecuencial, 10, sTipoFuncionalidad);
							 
							 facturapuntoventa.setnumero_secuencial(sSecuencialFormato);
							 
						 } else {
							 throw new Exception("Debe configurar un cajero turno con el usuario actual");
						 }
						 /*
						 facturapuntoventa.setid_estado_orden_compra(1L);																			 						 						
						 facturapuntoventa.setnumero_secuencial(datoGeneral.getsValorString());
						 facturapuntoventa.setid_formato(datoGeneral.getlValorLong1());
						 */
						 						 
						 
						 facturapuntoventaLogic.commitNewConnexionToDeep();
						 
					 } catch(Exception e) {
						 facturapuntoventaLogic.rollbackNewConnexionToDeep();
						 
						 throw e;
						 
					 } finally {
						 facturapuntoventaLogic.closeNewConnexionToDeep();
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
	public  FacturaPuntoVentaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkFacturaPuntoVentaToSave(FacturaPuntoVenta facturapuntoventa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkFacturaPuntoVentaToSave(FacturaPuntoVenta facturapuntoventa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkFacturaPuntoVentaToSaveAfter(FacturaPuntoVenta facturapuntoventa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkFacturaPuntoVentaToSaves(List<FacturaPuntoVenta> facturapuntoventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkFacturaPuntoVentaToSaves(List<FacturaPuntoVenta> facturapuntoventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkFacturaPuntoVentaToSavesAfter(List<FacturaPuntoVenta> facturapuntoventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkFacturaPuntoVentaToGet(FacturaPuntoVenta facturapuntoventa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkFacturaPuntoVentaToGets(List<FacturaPuntoVenta> facturapuntoventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateFacturaPuntoVentaToSave(FacturaPuntoVenta facturapuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateFacturaPuntoVentaToGet(FacturaPuntoVenta facturapuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectFacturaPuntoVentaActions(String sTipoJsonResponse,JSONObject jsonObjectFacturaPuntoVenta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonFacturaPuntoVentaDataTable(String sTipoJsonResponse,FacturaPuntoVenta facturapuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonFacturaPuntoVentasDataTable(String sTipoJsonResponse,List<FacturaPuntoVenta> facturapuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayFacturaPuntoVentaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayFacturaPuntoVentasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayFacturaPuntoVentasColumns;
	}
	
	public static void updateJSONArrayFacturaPuntoVentaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectFacturaPuntoVenta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosFacturaPuntoVenta(FacturaPuntoVenta facturapuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturapuntoventa.setnumero_secuencial(facturapuntoventa.getnumero_secuencial().trim());
		facturapuntoventa.setcodigo_cliente(facturapuntoventa.getcodigo_cliente().trim());
		facturapuntoventa.setnombre_cliente(facturapuntoventa.getnombre_cliente().trim());
		facturapuntoventa.settarjeta_cliente(facturapuntoventa.gettarjeta_cliente().trim());
		facturapuntoventa.setdireccion_cliente(facturapuntoventa.getdireccion_cliente().trim());
		facturapuntoventa.settelefono_cliente(facturapuntoventa.gettelefono_cliente().trim());
	}
	
	public static void quitarEspaciosFacturaPuntoVentas(List<FacturaPuntoVenta> facturapuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturaPuntoVenta facturapuntoventa: facturapuntoventas) {
			facturapuntoventa.setnumero_secuencial(facturapuntoventa.getnumero_secuencial().trim());
			facturapuntoventa.setcodigo_cliente(facturapuntoventa.getcodigo_cliente().trim());
			facturapuntoventa.setnombre_cliente(facturapuntoventa.getnombre_cliente().trim());
			facturapuntoventa.settarjeta_cliente(facturapuntoventa.gettarjeta_cliente().trim());
			facturapuntoventa.setdireccion_cliente(facturapuntoventa.getdireccion_cliente().trim());
			facturapuntoventa.settelefono_cliente(facturapuntoventa.gettelefono_cliente().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(FacturaPuntoVentaConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(FacturaPuntoVentaConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(FacturaPuntoVentaConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturaPuntoVenta> facturapuntoventas,FacturaPuntoVenta facturapuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturaPuntoVenta facturapuntoventaAux: facturapuntoventas) {
			if((facturapuntoventaAux.getId()==null && facturapuntoventa.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(facturapuntoventaAux.getId()!=null && facturapuntoventa.getId()!=null){
				if(facturapuntoventaAux.getId().equals(facturapuntoventa.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturaPuntoVenta(List<FacturaPuntoVenta> facturapuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double subtotalTotal=0.0;
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double financiamientoTotal=0.0;
		Double fleteTotal=0.0;
		Double iceTotal=0.0;
		Double otrosTotal=0.0;
		Double totalTotal=0.0;
	
		for(FacturaPuntoVenta facturapuntoventa: facturapuntoventas) {			
			subtotalTotal+=facturapuntoventa.getsub_total();
			ivaTotal+=facturapuntoventa.getiva();
			descuentoTotal+=facturapuntoventa.getdescuento();
			financiamientoTotal+=facturapuntoventa.getfinanciamiento();
			fleteTotal+=facturapuntoventa.getflete();
			iceTotal+=facturapuntoventa.getice();
			otrosTotal+=facturapuntoventa.getotros();
			totalTotal+=facturapuntoventa.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.OTROS);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_OTROS);
		datoGeneral.setdValorDouble(otrosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaPuntoVentaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(FacturaPuntoVentaConstantesFunciones.LABEL_TOTAL);
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
	
	public static void ActualizarValoresEvento(FacturaPuntoVenta facturaPuntoVenta,String sTipo) throws Exception {
		if(sTipo.equals("id_clienteFacturaPuntoVenta")) {
			Cliente cliente=facturaPuntoVenta.getCliente();
			
			if(cliente!=null) {
				facturaPuntoVenta.setcodigo_cliente(cliente.getcodigo());
				facturaPuntoVenta.setnombre_cliente(cliente.getnombre_completo());
				facturaPuntoVenta.setdireccion_cliente(cliente.getdireccion());			
				facturaPuntoVenta.settelefono_cliente(cliente.gettelefono());
				facturaPuntoVenta.setid_tipo_precio(cliente.getid_tipo_precio());
			}
		}		
	}
}