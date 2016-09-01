










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.cartera.business.logic.report;

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
import com.bydan.erp.cartera.util.report.CobrarEstadosCuentasPorFacturaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.CobrarEstadosCuentasPorFacturaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class CobrarEstadosCuentasPorFacturaLogicAdditional extends CobrarEstadosCuentasPorFacturaLogic{		
	
	public  CobrarEstadosCuentasPorFacturaLogicAdditional(Connexion connexion)throws Exception {
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
	public  CobrarEstadosCuentasPorFacturaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCobrarEstadosCuentasPorFacturaToSave(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCobrarEstadosCuentasPorFacturaToSave(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCobrarEstadosCuentasPorFacturaToSaveAfter(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCobrarEstadosCuentasPorFacturaToSaves(List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCobrarEstadosCuentasPorFacturaToSaves(List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCobrarEstadosCuentasPorFacturaToSavesAfter(List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCobrarEstadosCuentasPorFacturaToGet(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCobrarEstadosCuentasPorFacturaToGets(List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCobrarEstadosCuentasPorFacturaToSave(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCobrarEstadosCuentasPorFacturaToGet(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCobrarEstadosCuentasPorFacturaActions(String sTipoJsonResponse,JSONObject jsonObjectCobrarEstadosCuentasPorFactura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCobrarEstadosCuentasPorFacturaDataTable(String sTipoJsonResponse,CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCobrarEstadosCuentasPorFacturasDataTable(String sTipoJsonResponse,List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCobrarEstadosCuentasPorFacturaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCobrarEstadosCuentasPorFacturasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCobrarEstadosCuentasPorFacturasColumns;
	}
	
	public static void updateJSONArrayCobrarEstadosCuentasPorFacturaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCobrarEstadosCuentasPorFactura,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCobrarEstadosCuentasPorFactura(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarestadoscuentasporfactura.setnombre_cuenta_contable(cobrarestadoscuentasporfactura.getnombre_cuenta_contable().trim());
		cobrarestadoscuentasporfactura.setnombre_ciudad(cobrarestadoscuentasporfactura.getnombre_ciudad().trim());
		cobrarestadoscuentasporfactura.setnombre_zona(cobrarestadoscuentasporfactura.getnombre_zona().trim());
		cobrarestadoscuentasporfactura.setnombre_completo(cobrarestadoscuentasporfactura.getnombre_completo().trim());
		cobrarestadoscuentasporfactura.setruc(cobrarestadoscuentasporfactura.getruc().trim());
		cobrarestadoscuentasporfactura.setrepresentante(cobrarestadoscuentasporfactura.getrepresentante().trim());
		cobrarestadoscuentasporfactura.sethora_pago(cobrarestadoscuentasporfactura.gethora_pago());
		cobrarestadoscuentasporfactura.setobservacion(cobrarestadoscuentasporfactura.getobservacion().trim());
		cobrarestadoscuentasporfactura.setnombre_transaccion(cobrarestadoscuentasporfactura.getnombre_transaccion().trim());
		cobrarestadoscuentasporfactura.setnumero_comprobante(cobrarestadoscuentasporfactura.getnumero_comprobante().trim());
		cobrarestadoscuentasporfactura.setnumero_factura(cobrarestadoscuentasporfactura.getnumero_factura().trim());
		cobrarestadoscuentasporfactura.setdireccion_direccion(cobrarestadoscuentasporfactura.getdireccion_direccion().trim());
		cobrarestadoscuentasporfactura.settelefono_telefono(cobrarestadoscuentasporfactura.gettelefono_telefono().trim());
	}
	
	public static void quitarEspaciosCobrarEstadosCuentasPorFacturas(List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura: cobrarestadoscuentasporfacturas) {
			cobrarestadoscuentasporfactura.setnombre_cuenta_contable(cobrarestadoscuentasporfactura.getnombre_cuenta_contable().trim());
			cobrarestadoscuentasporfactura.setnombre_ciudad(cobrarestadoscuentasporfactura.getnombre_ciudad().trim());
			cobrarestadoscuentasporfactura.setnombre_zona(cobrarestadoscuentasporfactura.getnombre_zona().trim());
			cobrarestadoscuentasporfactura.setnombre_completo(cobrarestadoscuentasporfactura.getnombre_completo().trim());
			cobrarestadoscuentasporfactura.setruc(cobrarestadoscuentasporfactura.getruc().trim());
			cobrarestadoscuentasporfactura.setrepresentante(cobrarestadoscuentasporfactura.getrepresentante().trim());
			cobrarestadoscuentasporfactura.sethora_pago(cobrarestadoscuentasporfactura.gethora_pago());
			cobrarestadoscuentasporfactura.setobservacion(cobrarestadoscuentasporfactura.getobservacion().trim());
			cobrarestadoscuentasporfactura.setnombre_transaccion(cobrarestadoscuentasporfactura.getnombre_transaccion().trim());
			cobrarestadoscuentasporfactura.setnumero_comprobante(cobrarestadoscuentasporfactura.getnumero_comprobante().trim());
			cobrarestadoscuentasporfactura.setnumero_factura(cobrarestadoscuentasporfactura.getnumero_factura().trim());
			cobrarestadoscuentasporfactura.setdireccion_direccion(cobrarestadoscuentasporfactura.getdireccion_direccion().trim());
			cobrarestadoscuentasporfactura.settelefono_telefono(cobrarestadoscuentasporfactura.gettelefono_telefono().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarEstadosCuentasPorFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CobrarEstadosCuentasPorFacturaConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas,CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfacturaAux: cobrarestadoscuentasporfacturas) {
			if((cobrarestadoscuentasporfacturaAux.getId()==null && cobrarestadoscuentasporfactura.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cobrarestadoscuentasporfacturaAux.getId()!=null && cobrarestadoscuentasporfactura.getId()!=null){
				if(cobrarestadoscuentasporfacturaAux.getId().equals(cobrarestadoscuentasporfactura.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarEstadosCuentasPorFactura(List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
	
		for(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura: cobrarestadoscuentasporfacturas) {			
			debito_mone_localTotal+=cobrarestadoscuentasporfactura.getdebito_mone_local();
			credito_mone_localTotal+=cobrarestadoscuentasporfactura.getcredito_mone_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
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