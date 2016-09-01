










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.puntoventa.business.logic.report;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.puntoventa.util.report.ComprobanteFacturaDetalleConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;
////import com.bydan.erp.puntoventa.business.interfaces.ComprobanteFacturaDetalleAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ComprobanteFacturaDetalleLogicAdditional extends ComprobanteFacturaDetalleLogic{		
	
	public  ComprobanteFacturaDetalleLogicAdditional(Connexion connexion)throws Exception {
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

	//CONTROL_INICIO
	public  ComprobanteFacturaDetalleLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkComprobanteFacturaDetalleToSave(ComprobanteFacturaDetalle comprobantefacturadetalle,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkComprobanteFacturaDetalleToSave(ComprobanteFacturaDetalle comprobantefacturadetalle,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkComprobanteFacturaDetalleToSaveAfter(ComprobanteFacturaDetalle comprobantefacturadetalle,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkComprobanteFacturaDetalleToSaves(List<ComprobanteFacturaDetalle> comprobantefacturadetalles,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkComprobanteFacturaDetalleToSaves(List<ComprobanteFacturaDetalle> comprobantefacturadetalles,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkComprobanteFacturaDetalleToSavesAfter(List<ComprobanteFacturaDetalle> comprobantefacturadetalles,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkComprobanteFacturaDetalleToGet(ComprobanteFacturaDetalle comprobantefacturadetalle,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkComprobanteFacturaDetalleToGets(List<ComprobanteFacturaDetalle> comprobantefacturadetalles,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateComprobanteFacturaDetalleToSave(ComprobanteFacturaDetalle comprobantefacturadetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateComprobanteFacturaDetalleToGet(ComprobanteFacturaDetalle comprobantefacturadetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectComprobanteFacturaDetalleActions(String sTipoJsonResponse,JSONObject jsonObjectComprobanteFacturaDetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonComprobanteFacturaDetalleDataTable(String sTipoJsonResponse,ComprobanteFacturaDetalle comprobantefacturadetalle,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonComprobanteFacturaDetallesDataTable(String sTipoJsonResponse,List<ComprobanteFacturaDetalle> comprobantefacturadetalles,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayComprobanteFacturaDetalleColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayComprobanteFacturaDetallesColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayComprobanteFacturaDetallesColumns;
	}
	
	public static void updateJSONArrayComprobanteFacturaDetalleActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectComprobanteFacturaDetalle,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosComprobanteFacturaDetalle(ComprobanteFacturaDetalle comprobantefacturadetalle,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comprobantefacturadetalle.setsecuencial(comprobantefacturadetalle.getsecuencial().trim());
		comprobantefacturadetalle.setnombre_cliente(comprobantefacturadetalle.getnombre_cliente().trim());
		comprobantefacturadetalle.setnombre_bodega(comprobantefacturadetalle.getnombre_bodega().trim());
		comprobantefacturadetalle.setnombre_producto(comprobantefacturadetalle.getnombre_producto().trim());
		comprobantefacturadetalle.setserie(comprobantefacturadetalle.getserie().trim());
		comprobantefacturadetalle.setdescripcion(comprobantefacturadetalle.getdescripcion().trim());
	}
	
	public static void quitarEspaciosComprobanteFacturaDetalles(List<ComprobanteFacturaDetalle> comprobantefacturadetalles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComprobanteFacturaDetalle comprobantefacturadetalle: comprobantefacturadetalles) {
			comprobantefacturadetalle.setsecuencial(comprobantefacturadetalle.getsecuencial().trim());
			comprobantefacturadetalle.setnombre_cliente(comprobantefacturadetalle.getnombre_cliente().trim());
			comprobantefacturadetalle.setnombre_bodega(comprobantefacturadetalle.getnombre_bodega().trim());
			comprobantefacturadetalle.setnombre_producto(comprobantefacturadetalle.getnombre_producto().trim());
			comprobantefacturadetalle.setserie(comprobantefacturadetalle.getserie().trim());
			comprobantefacturadetalle.setdescripcion(comprobantefacturadetalle.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobanteFacturaDetalle(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ComprobanteFacturaDetalleConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ComprobanteFacturaDetalleConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComprobanteFacturaDetalle> comprobantefacturadetalles,ComprobanteFacturaDetalle comprobantefacturadetalle,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComprobanteFacturaDetalle comprobantefacturadetalleAux: comprobantefacturadetalles) {
			if((comprobantefacturadetalleAux.getId()==null && comprobantefacturadetalle.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(comprobantefacturadetalleAux.getId()!=null && comprobantefacturadetalle.getId()!=null){
				if(comprobantefacturadetalleAux.getId().equals(comprobantefacturadetalle.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComprobanteFacturaDetalle(List<ComprobanteFacturaDetalle> comprobantefacturadetalles) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double descuentoTotal=0.0;
		Double subtotalTotal=0.0;
		Double totalTotal=0.0;
		Double precioTotal=0.0;
		Double descuento_productoTotal=0.0;
		Double ivaTotal=0.0;
	
		for(ComprobanteFacturaDetalle comprobantefacturadetalle: comprobantefacturadetalles) {			
			descuentoTotal+=comprobantefacturadetalle.getdescuento();
			subtotalTotal+=comprobantefacturadetalle.getsubtotal();
			totalTotal+=comprobantefacturadetalle.gettotal();
			precioTotal+=comprobantefacturadetalle.getprecio();
			descuento_productoTotal+=comprobantefacturadetalle.getdescuento_producto();
			ivaTotal+=comprobantefacturadetalle.getiva();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.DESCUENTOPRODUCTO);
		datoGeneral.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_DESCUENTOPRODUCTO);
		datoGeneral.setdValorDouble(descuento_productoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaDetalleConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(ComprobanteFacturaDetalleConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
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