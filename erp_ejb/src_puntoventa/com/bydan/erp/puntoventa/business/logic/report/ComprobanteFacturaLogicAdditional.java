










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
import com.bydan.erp.puntoventa.util.report.ComprobanteFacturaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;
////import com.bydan.erp.puntoventa.business.interfaces.ComprobanteFacturaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ComprobanteFacturaLogicAdditional extends ComprobanteFacturaLogic{		
	
	public  ComprobanteFacturaLogicAdditional(Connexion connexion)throws Exception {
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
	public  ComprobanteFacturaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkComprobanteFacturaToSave(ComprobanteFactura comprobantefactura,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkComprobanteFacturaToSave(ComprobanteFactura comprobantefactura,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkComprobanteFacturaToSaveAfter(ComprobanteFactura comprobantefactura,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkComprobanteFacturaToSaves(List<ComprobanteFactura> comprobantefacturas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkComprobanteFacturaToSaves(List<ComprobanteFactura> comprobantefacturas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkComprobanteFacturaToSavesAfter(List<ComprobanteFactura> comprobantefacturas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkComprobanteFacturaToGet(ComprobanteFactura comprobantefactura,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkComprobanteFacturaToGets(List<ComprobanteFactura> comprobantefacturas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateComprobanteFacturaToSave(ComprobanteFactura comprobantefactura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateComprobanteFacturaToGet(ComprobanteFactura comprobantefactura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectComprobanteFacturaActions(String sTipoJsonResponse,JSONObject jsonObjectComprobanteFactura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonComprobanteFacturaDataTable(String sTipoJsonResponse,ComprobanteFactura comprobantefactura,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonComprobanteFacturasDataTable(String sTipoJsonResponse,List<ComprobanteFactura> comprobantefacturas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayComprobanteFacturaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayComprobanteFacturasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayComprobanteFacturasColumns;
	}
	
	public static void updateJSONArrayComprobanteFacturaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectComprobanteFactura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosComprobanteFactura(ComprobanteFactura comprobantefactura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comprobantefactura.setnombre_caja(comprobantefactura.getnombre_caja().trim());
		comprobantefactura.setsecuencial(comprobantefactura.getsecuencial().trim());
		comprobantefactura.setcodigo_cliente(comprobantefactura.getcodigo_cliente().trim());
		comprobantefactura.setnombre_cliente(comprobantefactura.getnombre_cliente().trim());
	}
	
	public static void quitarEspaciosComprobanteFacturas(List<ComprobanteFactura> comprobantefacturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComprobanteFactura comprobantefactura: comprobantefacturas) {
			comprobantefactura.setnombre_caja(comprobantefactura.getnombre_caja().trim());
			comprobantefactura.setsecuencial(comprobantefactura.getsecuencial().trim());
			comprobantefactura.setcodigo_cliente(comprobantefactura.getcodigo_cliente().trim());
			comprobantefactura.setnombre_cliente(comprobantefactura.getnombre_cliente().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobanteFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ComprobanteFacturaConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComprobanteFactura> comprobantefacturas,ComprobanteFactura comprobantefactura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComprobanteFactura comprobantefacturaAux: comprobantefacturas) {
			if((comprobantefacturaAux.getId()==null && comprobantefactura.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(comprobantefacturaAux.getId()!=null && comprobantefactura.getId()!=null){
				if(comprobantefacturaAux.getId().equals(comprobantefactura.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComprobanteFactura(List<ComprobanteFactura> comprobantefacturas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double subtotalTotal=0.0;
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double financiamientoTotal=0.0;
		Double fleteTotal=0.0;
		Double iceTotal=0.0;
		Double totalTotal=0.0;
		Double descuento_realTotal=0.0;
	
		for(ComprobanteFactura comprobantefactura: comprobantefacturas) {			
			subtotalTotal+=comprobantefactura.getsubtotal();
			ivaTotal+=comprobantefactura.getiva();
			descuentoTotal+=comprobantefactura.getdescuento();
			financiamientoTotal+=comprobantefactura.getfinanciamiento();
			fleteTotal+=comprobantefactura.getflete();
			iceTotal+=comprobantefactura.getice();
			totalTotal+=comprobantefactura.gettotal();
			descuento_realTotal+=comprobantefactura.getdescuento_real();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.DESCUENTOREAL);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_DESCUENTOREAL);
		datoGeneral.setdValorDouble(descuento_realTotal);
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