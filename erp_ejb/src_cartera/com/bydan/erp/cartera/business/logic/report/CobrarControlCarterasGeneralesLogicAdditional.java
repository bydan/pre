










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
import com.bydan.erp.cartera.util.report.CobrarControlCarterasGeneralesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.CobrarControlCarterasGeneralesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class CobrarControlCarterasGeneralesLogicAdditional extends CobrarControlCarterasGeneralesLogic{		
	
	public  CobrarControlCarterasGeneralesLogicAdditional(Connexion connexion)throws Exception {
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
	public  CobrarControlCarterasGeneralesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCobrarControlCarterasGeneralesToSave(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCobrarControlCarterasGeneralesToSave(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCobrarControlCarterasGeneralesToSaveAfter(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCobrarControlCarterasGeneralesToSaves(List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCobrarControlCarterasGeneralesToSaves(List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCobrarControlCarterasGeneralesToSavesAfter(List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCobrarControlCarterasGeneralesToGet(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCobrarControlCarterasGeneralesToGets(List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCobrarControlCarterasGeneralesToSave(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCobrarControlCarterasGeneralesToGet(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCobrarControlCarterasGeneralesActions(String sTipoJsonResponse,JSONObject jsonObjectCobrarControlCarterasGenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCobrarControlCarterasGeneralesDataTable(String sTipoJsonResponse,CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCobrarControlCarterasGeneralessDataTable(String sTipoJsonResponse,List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCobrarControlCarterasGeneralesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCobrarControlCarterasGeneralessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCobrarControlCarterasGeneralessColumns;
	}
	
	public static void updateJSONArrayCobrarControlCarterasGeneralesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCobrarControlCarterasGenerales,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCobrarControlCarterasGenerales(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarcontrolcarterasgenerales.setnombre_ciudad(cobrarcontrolcarterasgenerales.getnombre_ciudad().trim());
		cobrarcontrolcarterasgenerales.setnombre_zona(cobrarcontrolcarterasgenerales.getnombre_zona().trim());
		cobrarcontrolcarterasgenerales.setnombre_vendedor(cobrarcontrolcarterasgenerales.getnombre_vendedor().trim());
		cobrarcontrolcarterasgenerales.setcodigo(cobrarcontrolcarterasgenerales.getcodigo().trim());
		cobrarcontrolcarterasgenerales.setnombre_completo(cobrarcontrolcarterasgenerales.getnombre_completo().trim());
		cobrarcontrolcarterasgenerales.setrepresentante(cobrarcontrolcarterasgenerales.getrepresentante().trim());
		cobrarcontrolcarterasgenerales.setnumero_comprobante(cobrarcontrolcarterasgenerales.getnumero_comprobante().trim());
		cobrarcontrolcarterasgenerales.setnumero_factura(cobrarcontrolcarterasgenerales.getnumero_factura().trim());
		cobrarcontrolcarterasgenerales.setdireccion_direccion(cobrarcontrolcarterasgenerales.getdireccion_direccion().trim());
		cobrarcontrolcarterasgenerales.settelefono_telefono(cobrarcontrolcarterasgenerales.gettelefono_telefono().trim());
		cobrarcontrolcarterasgenerales.sethora_pago(cobrarcontrolcarterasgenerales.gethora_pago());
	}
	
	public static void quitarEspaciosCobrarControlCarterasGeneraless(List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales: cobrarcontrolcarterasgeneraless) {
			cobrarcontrolcarterasgenerales.setnombre_ciudad(cobrarcontrolcarterasgenerales.getnombre_ciudad().trim());
			cobrarcontrolcarterasgenerales.setnombre_zona(cobrarcontrolcarterasgenerales.getnombre_zona().trim());
			cobrarcontrolcarterasgenerales.setnombre_vendedor(cobrarcontrolcarterasgenerales.getnombre_vendedor().trim());
			cobrarcontrolcarterasgenerales.setcodigo(cobrarcontrolcarterasgenerales.getcodigo().trim());
			cobrarcontrolcarterasgenerales.setnombre_completo(cobrarcontrolcarterasgenerales.getnombre_completo().trim());
			cobrarcontrolcarterasgenerales.setrepresentante(cobrarcontrolcarterasgenerales.getrepresentante().trim());
			cobrarcontrolcarterasgenerales.setnumero_comprobante(cobrarcontrolcarterasgenerales.getnumero_comprobante().trim());
			cobrarcontrolcarterasgenerales.setnumero_factura(cobrarcontrolcarterasgenerales.getnumero_factura().trim());
			cobrarcontrolcarterasgenerales.setdireccion_direccion(cobrarcontrolcarterasgenerales.getdireccion_direccion().trim());
			cobrarcontrolcarterasgenerales.settelefono_telefono(cobrarcontrolcarterasgenerales.gettelefono_telefono().trim());
			cobrarcontrolcarterasgenerales.sethora_pago(cobrarcontrolcarterasgenerales.gethora_pago());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarControlCarterasGenerales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CobrarControlCarterasGeneralesConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless,CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarControlCarterasGenerales cobrarcontrolcarterasgeneralesAux: cobrarcontrolcarterasgeneraless) {
			if((cobrarcontrolcarterasgeneralesAux.getId()==null && cobrarcontrolcarterasgenerales.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cobrarcontrolcarterasgeneralesAux.getId()!=null && cobrarcontrolcarterasgenerales.getId()!=null){
				if(cobrarcontrolcarterasgeneralesAux.getId().equals(cobrarcontrolcarterasgenerales.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarControlCarterasGenerales(List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double limite_creditoTotal=0.0;
		Double saldoTotal=0.0;
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
	
		for(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales: cobrarcontrolcarterasgeneraless) {			
			limite_creditoTotal+=cobrarcontrolcarterasgenerales.getlimite_credito();
			saldoTotal+=cobrarcontrolcarterasgenerales.getsaldo();
			debito_mone_localTotal+=cobrarcontrolcarterasgenerales.getdebito_mone_local();
			credito_mone_localTotal+=cobrarcontrolcarterasgenerales.getcredito_mone_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LIMITECREDITO);
		datoGeneral.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_LIMITECREDITO);
		datoGeneral.setdValorDouble(limite_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_CREDITOMONELOCAL);
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