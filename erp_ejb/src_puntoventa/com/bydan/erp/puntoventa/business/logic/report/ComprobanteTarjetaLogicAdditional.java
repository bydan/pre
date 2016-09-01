










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
import com.bydan.erp.puntoventa.util.report.ComprobanteTarjetaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;
////import com.bydan.erp.puntoventa.business.interfaces.ComprobanteTarjetaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ComprobanteTarjetaLogicAdditional extends ComprobanteTarjetaLogic{		
	
	public  ComprobanteTarjetaLogicAdditional(Connexion connexion)throws Exception {
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
	public  ComprobanteTarjetaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkComprobanteTarjetaToSave(ComprobanteTarjeta comprobantetarjeta,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkComprobanteTarjetaToSave(ComprobanteTarjeta comprobantetarjeta,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkComprobanteTarjetaToSaveAfter(ComprobanteTarjeta comprobantetarjeta,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkComprobanteTarjetaToSaves(List<ComprobanteTarjeta> comprobantetarjetas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkComprobanteTarjetaToSaves(List<ComprobanteTarjeta> comprobantetarjetas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkComprobanteTarjetaToSavesAfter(List<ComprobanteTarjeta> comprobantetarjetas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkComprobanteTarjetaToGet(ComprobanteTarjeta comprobantetarjeta,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkComprobanteTarjetaToGets(List<ComprobanteTarjeta> comprobantetarjetas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateComprobanteTarjetaToSave(ComprobanteTarjeta comprobantetarjeta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateComprobanteTarjetaToGet(ComprobanteTarjeta comprobantetarjeta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectComprobanteTarjetaActions(String sTipoJsonResponse,JSONObject jsonObjectComprobanteTarjeta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonComprobanteTarjetaDataTable(String sTipoJsonResponse,ComprobanteTarjeta comprobantetarjeta,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonComprobanteTarjetasDataTable(String sTipoJsonResponse,List<ComprobanteTarjeta> comprobantetarjetas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayComprobanteTarjetaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayComprobanteTarjetasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayComprobanteTarjetasColumns;
	}
	
	public static void updateJSONArrayComprobanteTarjetaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectComprobanteTarjeta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosComprobanteTarjeta(ComprobanteTarjeta comprobantetarjeta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comprobantetarjeta.setnombre_caja(comprobantetarjeta.getnombre_caja().trim());
		comprobantetarjeta.setsecuencial(comprobantetarjeta.getsecuencial().trim());
		comprobantetarjeta.setcodigo_cliente(comprobantetarjeta.getcodigo_cliente().trim());
		comprobantetarjeta.setnombre_cliente(comprobantetarjeta.getnombre_cliente().trim());
		comprobantetarjeta.setnumero(comprobantetarjeta.getnumero().trim());
		comprobantetarjeta.settarjeta_habiente(comprobantetarjeta.gettarjeta_habiente().trim());
		comprobantetarjeta.setautorizacion(comprobantetarjeta.getautorizacion().trim());
		comprobantetarjeta.setvoucher(comprobantetarjeta.getvoucher().trim());
		comprobantetarjeta.setlote(comprobantetarjeta.getlote().trim());
	}
	
	public static void quitarEspaciosComprobanteTarjetas(List<ComprobanteTarjeta> comprobantetarjetas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComprobanteTarjeta comprobantetarjeta: comprobantetarjetas) {
			comprobantetarjeta.setnombre_caja(comprobantetarjeta.getnombre_caja().trim());
			comprobantetarjeta.setsecuencial(comprobantetarjeta.getsecuencial().trim());
			comprobantetarjeta.setcodigo_cliente(comprobantetarjeta.getcodigo_cliente().trim());
			comprobantetarjeta.setnombre_cliente(comprobantetarjeta.getnombre_cliente().trim());
			comprobantetarjeta.setnumero(comprobantetarjeta.getnumero().trim());
			comprobantetarjeta.settarjeta_habiente(comprobantetarjeta.gettarjeta_habiente().trim());
			comprobantetarjeta.setautorizacion(comprobantetarjeta.getautorizacion().trim());
			comprobantetarjeta.setvoucher(comprobantetarjeta.getvoucher().trim());
			comprobantetarjeta.setlote(comprobantetarjeta.getlote().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobanteTarjeta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ComprobanteTarjetaConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ComprobanteTarjetaConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComprobanteTarjeta> comprobantetarjetas,ComprobanteTarjeta comprobantetarjeta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComprobanteTarjeta comprobantetarjetaAux: comprobantetarjetas) {
			if((comprobantetarjetaAux.getId()==null && comprobantetarjeta.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(comprobantetarjetaAux.getId()!=null && comprobantetarjeta.getId()!=null){
				if(comprobantetarjetaAux.getId().equals(comprobantetarjeta.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComprobanteTarjeta(List<ComprobanteTarjeta> comprobantetarjetas) throws Exception  {
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
	
		for(ComprobanteTarjeta comprobantetarjeta: comprobantetarjetas) {			
			subtotalTotal+=comprobantetarjeta.getsubtotal();
			ivaTotal+=comprobantetarjeta.getiva();
			descuentoTotal+=comprobantetarjeta.getdescuento();
			financiamientoTotal+=comprobantetarjeta.getfinanciamiento();
			fleteTotal+=comprobantetarjeta.getflete();
			iceTotal+=comprobantetarjeta.getice();
			totalTotal+=comprobantetarjeta.gettotal();
			valorTotal+=comprobantetarjeta.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteTarjetaConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(ComprobanteTarjetaConstantesFunciones.LABEL_VALOR);
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