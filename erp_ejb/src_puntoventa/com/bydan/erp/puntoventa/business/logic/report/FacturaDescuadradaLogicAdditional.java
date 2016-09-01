










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
import com.bydan.erp.puntoventa.util.report.FacturaDescuadradaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;
////import com.bydan.erp.puntoventa.business.interfaces.FacturaDescuadradaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class FacturaDescuadradaLogicAdditional extends FacturaDescuadradaLogic{		
	
	public  FacturaDescuadradaLogicAdditional(Connexion connexion)throws Exception {
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
	public  FacturaDescuadradaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkFacturaDescuadradaToSave(FacturaDescuadrada facturadescuadrada,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkFacturaDescuadradaToSave(FacturaDescuadrada facturadescuadrada,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkFacturaDescuadradaToSaveAfter(FacturaDescuadrada facturadescuadrada,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkFacturaDescuadradaToSaves(List<FacturaDescuadrada> facturadescuadradas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkFacturaDescuadradaToSaves(List<FacturaDescuadrada> facturadescuadradas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkFacturaDescuadradaToSavesAfter(List<FacturaDescuadrada> facturadescuadradas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkFacturaDescuadradaToGet(FacturaDescuadrada facturadescuadrada,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkFacturaDescuadradaToGets(List<FacturaDescuadrada> facturadescuadradas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateFacturaDescuadradaToSave(FacturaDescuadrada facturadescuadrada,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateFacturaDescuadradaToGet(FacturaDescuadrada facturadescuadrada,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectFacturaDescuadradaActions(String sTipoJsonResponse,JSONObject jsonObjectFacturaDescuadrada,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonFacturaDescuadradaDataTable(String sTipoJsonResponse,FacturaDescuadrada facturadescuadrada,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonFacturaDescuadradasDataTable(String sTipoJsonResponse,List<FacturaDescuadrada> facturadescuadradas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayFacturaDescuadradaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayFacturaDescuadradasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayFacturaDescuadradasColumns;
	}
	
	public static void updateJSONArrayFacturaDescuadradaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectFacturaDescuadrada,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosFacturaDescuadrada(FacturaDescuadrada facturadescuadrada,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturadescuadrada.setsecuencial(facturadescuadrada.getsecuencial().trim());
	}
	
	public static void quitarEspaciosFacturaDescuadradas(List<FacturaDescuadrada> facturadescuadradas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturaDescuadrada facturadescuadrada: facturadescuadradas) {
			facturadescuadrada.setsecuencial(facturadescuadrada.getsecuencial().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturaDescuadrada(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(FacturaDescuadradaConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturaDescuadrada> facturadescuadradas,FacturaDescuadrada facturadescuadrada,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturaDescuadrada facturadescuadradaAux: facturadescuadradas) {
			if((facturadescuadradaAux.getId()==null && facturadescuadrada.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(facturadescuadradaAux.getId()!=null && facturadescuadrada.getId()!=null){
				if(facturadescuadradaAux.getId().equals(facturadescuadrada.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturaDescuadrada(List<FacturaDescuadrada> facturadescuadradas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double subtotalTotal=0.0;
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double financiamientoTotal=0.0;
		Double fleteTotal=0.0;
		Double iceTotal=0.0;
		Double totalTotal=0.0;
		Double total_formas_pagoTotal=0.0;
		Double descuento_realTotal=0.0;
	
		for(FacturaDescuadrada facturadescuadrada: facturadescuadradas) {			
			subtotalTotal+=facturadescuadrada.getsubtotal();
			ivaTotal+=facturadescuadrada.getiva();
			descuentoTotal+=facturadescuadrada.getdescuento();
			financiamientoTotal+=facturadescuadrada.getfinanciamiento();
			fleteTotal+=facturadescuadrada.getflete();
			iceTotal+=facturadescuadrada.getice();
			totalTotal+=facturadescuadrada.gettotal();
			total_formas_pagoTotal+=facturadescuadrada.gettotal_formas_pago();
			descuento_realTotal+=facturadescuadrada.getdescuento_real();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.TOTALFORMASPAGO);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_TOTALFORMASPAGO);
		datoGeneral.setdValorDouble(total_formas_pagoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaDescuadradaConstantesFunciones.DESCUENTOREAL);
		datoGeneral.setsDescripcion(FacturaDescuadradaConstantesFunciones.LABEL_DESCUENTOREAL);
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