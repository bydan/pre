














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
import com.bydan.framework.erp.util.Constantes2;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.Funciones2;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.puntoventa.business.entity.DetallePedidoPuntoVenta;
import com.bydan.erp.puntoventa.business.entity.PedidoPuntoVenta;
import com.bydan.erp.puntoventa.util.DetallePedidoPuntoVentaConstantesFunciones;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.puntoventa.business.entity.*;
//import com.bydan.erp.puntoventa.business.interfaces.DetallePedidoPuntoVentaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DetallePedidoPuntoVentaLogicAdditional extends DetallePedidoPuntoVentaLogic { // implements DetallePedidoPuntoVentaAdditionable{
	public  DetallePedidoPuntoVentaLogicAdditional(Connexion connexion)throws Exception {
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
	public  DetallePedidoPuntoVentaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetallePedidoPuntoVentaToSave(DetallePedidoPuntoVenta detallepedidopuntoventa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetallePedidoPuntoVentaToSave(DetallePedidoPuntoVenta detallepedidopuntoventa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetallePedidoPuntoVentaToSaveAfter(DetallePedidoPuntoVenta detallepedidopuntoventa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetallePedidoPuntoVentaToSaves(List<DetallePedidoPuntoVenta> detallepedidopuntoventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetallePedidoPuntoVentaToSaves(List<DetallePedidoPuntoVenta> detallepedidopuntoventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetallePedidoPuntoVentaToSavesAfter(List<DetallePedidoPuntoVenta> detallepedidopuntoventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetallePedidoPuntoVentaToGet(DetallePedidoPuntoVenta detallepedidopuntoventa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetallePedidoPuntoVentaToGets(List<DetallePedidoPuntoVenta> detallepedidopuntoventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetallePedidoPuntoVentaToSave(DetallePedidoPuntoVenta detallepedidopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetallePedidoPuntoVentaToGet(DetallePedidoPuntoVenta detallepedidopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetallePedidoPuntoVentaActions(String sTipoJsonResponse,JSONObject jsonObjectDetallePedidoPuntoVenta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetallePedidoPuntoVentaDataTable(String sTipoJsonResponse,DetallePedidoPuntoVenta detallepedidopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetallePedidoPuntoVentasDataTable(String sTipoJsonResponse,List<DetallePedidoPuntoVenta> detallepedidopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetallePedidoPuntoVentaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetallePedidoPuntoVentasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetallePedidoPuntoVentasColumns;
	}
	
	public static void updateJSONArrayDetallePedidoPuntoVentaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetallePedidoPuntoVenta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetallePedidoPuntoVenta(DetallePedidoPuntoVenta detallepedidopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallepedidopuntoventa.setserie(detallepedidopuntoventa.getserie().trim());
	}
	
	public static void quitarEspaciosDetallePedidoPuntoVentas(List<DetallePedidoPuntoVenta> detallepedidopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetallePedidoPuntoVenta detallepedidopuntoventa: detallepedidopuntoventas) {
			detallepedidopuntoventa.setserie(detallepedidopuntoventa.getserie().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePedidoPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetallePedidoPuntoVentaConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DetallePedidoPuntoVentaConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetallePedidoPuntoVenta> detallepedidopuntoventas,DetallePedidoPuntoVenta detallepedidopuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetallePedidoPuntoVenta detallepedidopuntoventaAux: detallepedidopuntoventas) {
			if((detallepedidopuntoventaAux.getId()==null && detallepedidopuntoventa.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(detallepedidopuntoventaAux.getId()!=null && detallepedidopuntoventa.getId()!=null){
				if(detallepedidopuntoventaAux.getId().equals(detallepedidopuntoventa.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetallePedidoPuntoVenta(List<DetallePedidoPuntoVenta> detallepedidopuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double descuentoTotal=0.0;
		Double ivaTotal=0.0;
		Double iceTotal=0.0;
	
		for(DetallePedidoPuntoVenta detallepedidopuntoventa: detallepedidopuntoventas) {			
			precioTotal+=detallepedidopuntoventa.getprecio();
			descuentoTotal+=detallepedidopuntoventa.getdescuento();
			ivaTotal+=detallepedidopuntoventa.getiva();
			iceTotal+=detallepedidopuntoventa.getice();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoPuntoVentaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(DetallePedidoPuntoVentaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
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
	
	/*
	public static void GetTotales(PedidoPuntoVenta pedidopuntoventa,List<DetallePedidoPuntoVenta> detallepedidopuntoventas) throws Exception {
		Double suman=0.0;
		
		Double iva=0.0;
		Double ice=0.0;
		Double descuento=0.0;
		
		Double sub_total=0.0;				
		Double total=0.0;
		
		
		for(DetallePedidoPuntoVenta detallepedidopuntoventa : detallepedidopuntoventas) {
			if(!detallepedidopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				//suman+=detallepedidopuntoventa.getprecio();
				
				iva+=detallepedidopuntoventa.getiva_valor();
				ice+=detallepedidopuntoventa.getice_valor();
				descuento+=detallepedidopuntoventa.getdescuento_valor();
				
				
				sub_total+=detallepedidopuntoventa.getsub_total();
				total+=detallepedidopuntoventa.gettotal();
			}
		}
		
		//pedidopuntoventa.setsuman(suman);
		pedidopuntoventa.setiva(iva);
		pedidopuntoventa.setice(ice);
		pedidopuntoventa.setdescuento(descuento);
		
		
		pedidopuntoventa.setsub_total(sub_total);
		pedidopuntoventa.settotal(total);		
	}
	*/
}