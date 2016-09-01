










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
import com.bydan.erp.puntoventa.util.report.ComprobanteFormaPagoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;
////import com.bydan.erp.puntoventa.business.interfaces.ComprobanteFormaPagoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ComprobanteFormaPagoLogicAdditional extends ComprobanteFormaPagoLogic{		
	
	public  ComprobanteFormaPagoLogicAdditional(Connexion connexion)throws Exception {
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
	public  ComprobanteFormaPagoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkComprobanteFormaPagoToSave(ComprobanteFormaPago comprobanteformapago,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkComprobanteFormaPagoToSave(ComprobanteFormaPago comprobanteformapago,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkComprobanteFormaPagoToSaveAfter(ComprobanteFormaPago comprobanteformapago,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkComprobanteFormaPagoToSaves(List<ComprobanteFormaPago> comprobanteformapagos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkComprobanteFormaPagoToSaves(List<ComprobanteFormaPago> comprobanteformapagos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkComprobanteFormaPagoToSavesAfter(List<ComprobanteFormaPago> comprobanteformapagos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkComprobanteFormaPagoToGet(ComprobanteFormaPago comprobanteformapago,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkComprobanteFormaPagoToGets(List<ComprobanteFormaPago> comprobanteformapagos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateComprobanteFormaPagoToSave(ComprobanteFormaPago comprobanteformapago,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateComprobanteFormaPagoToGet(ComprobanteFormaPago comprobanteformapago,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectComprobanteFormaPagoActions(String sTipoJsonResponse,JSONObject jsonObjectComprobanteFormaPago,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonComprobanteFormaPagoDataTable(String sTipoJsonResponse,ComprobanteFormaPago comprobanteformapago,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonComprobanteFormaPagosDataTable(String sTipoJsonResponse,List<ComprobanteFormaPago> comprobanteformapagos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayComprobanteFormaPagoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayComprobanteFormaPagosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayComprobanteFormaPagosColumns;
	}
	
	public static void updateJSONArrayComprobanteFormaPagoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectComprobanteFormaPago,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosComprobanteFormaPago(ComprobanteFormaPago comprobanteformapago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comprobanteformapago.setnombre_caja(comprobanteformapago.getnombre_caja().trim());
		comprobanteformapago.setsecuencial(comprobanteformapago.getsecuencial().trim());
		comprobanteformapago.setcodigo_cliente(comprobanteformapago.getcodigo_cliente().trim());
		comprobanteformapago.setnombre_cliente(comprobanteformapago.getnombre_cliente().trim());
		comprobanteformapago.settipo(comprobanteformapago.gettipo().trim());
		comprobanteformapago.setnumero_cuenta(comprobanteformapago.getnumero_cuenta().trim());
		comprobanteformapago.setnumero_cheque(comprobanteformapago.getnumero_cheque().trim());
		comprobanteformapago.setgirador(comprobanteformapago.getgirador().trim());
		comprobanteformapago.setnumero_tarjeta(comprobanteformapago.getnumero_tarjeta().trim());
		comprobanteformapago.setautorizacion(comprobanteformapago.getautorizacion().trim());
		comprobanteformapago.setlote(comprobanteformapago.getlote().trim());
	}
	
	public static void quitarEspaciosComprobanteFormaPagos(List<ComprobanteFormaPago> comprobanteformapagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComprobanteFormaPago comprobanteformapago: comprobanteformapagos) {
			comprobanteformapago.setnombre_caja(comprobanteformapago.getnombre_caja().trim());
			comprobanteformapago.setsecuencial(comprobanteformapago.getsecuencial().trim());
			comprobanteformapago.setcodigo_cliente(comprobanteformapago.getcodigo_cliente().trim());
			comprobanteformapago.setnombre_cliente(comprobanteformapago.getnombre_cliente().trim());
			comprobanteformapago.settipo(comprobanteformapago.gettipo().trim());
			comprobanteformapago.setnumero_cuenta(comprobanteformapago.getnumero_cuenta().trim());
			comprobanteformapago.setnumero_cheque(comprobanteformapago.getnumero_cheque().trim());
			comprobanteformapago.setgirador(comprobanteformapago.getgirador().trim());
			comprobanteformapago.setnumero_tarjeta(comprobanteformapago.getnumero_tarjeta().trim());
			comprobanteformapago.setautorizacion(comprobanteformapago.getautorizacion().trim());
			comprobanteformapago.setlote(comprobanteformapago.getlote().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobanteFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ComprobanteFormaPagoConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ComprobanteFormaPagoConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComprobanteFormaPago> comprobanteformapagos,ComprobanteFormaPago comprobanteformapago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComprobanteFormaPago comprobanteformapagoAux: comprobanteformapagos) {
			if((comprobanteformapagoAux.getId()==null && comprobanteformapago.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(comprobanteformapagoAux.getId()!=null && comprobanteformapago.getId()!=null){
				if(comprobanteformapagoAux.getId().equals(comprobanteformapago.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComprobanteFormaPago(List<ComprobanteFormaPago> comprobanteformapagos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double subtotalTotal=0.0;
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double financiamientoTotal=0.0;
		Double fleteTotal=0.0;
		Double iceTotal=0.0;
		Double totalTotal=0.0;
		Double valorTotal=0.0;
	
		for(ComprobanteFormaPago comprobanteformapago: comprobanteformapagos) {			
			subtotalTotal+=comprobanteformapago.getsubtotal();
			ivaTotal+=comprobanteformapago.getiva();
			descuentoTotal+=comprobanteformapago.getdescuento();
			financiamientoTotal+=comprobanteformapago.getfinanciamiento();
			fleteTotal+=comprobanteformapago.getflete();
			iceTotal+=comprobanteformapago.getice();
			totalTotal+=comprobanteformapago.gettotal();
			valorTotal+=comprobanteformapago.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFormaPagoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ComprobanteFormaPagoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
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