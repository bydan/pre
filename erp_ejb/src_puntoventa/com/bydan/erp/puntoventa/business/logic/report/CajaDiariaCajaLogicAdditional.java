










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
import com.bydan.erp.puntoventa.util.report.CajaDiariaCajaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;
////import com.bydan.erp.puntoventa.business.interfaces.CajaDiariaCajaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class CajaDiariaCajaLogicAdditional extends CajaDiariaCajaLogic{		
	
	public  CajaDiariaCajaLogicAdditional(Connexion connexion)throws Exception {
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
	public  CajaDiariaCajaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCajaDiariaCajaToSave(CajaDiariaCaja cajadiariacaja,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCajaDiariaCajaToSave(CajaDiariaCaja cajadiariacaja,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCajaDiariaCajaToSaveAfter(CajaDiariaCaja cajadiariacaja,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCajaDiariaCajaToSaves(List<CajaDiariaCaja> cajadiariacajas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCajaDiariaCajaToSaves(List<CajaDiariaCaja> cajadiariacajas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCajaDiariaCajaToSavesAfter(List<CajaDiariaCaja> cajadiariacajas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCajaDiariaCajaToGet(CajaDiariaCaja cajadiariacaja,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCajaDiariaCajaToGets(List<CajaDiariaCaja> cajadiariacajas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCajaDiariaCajaToSave(CajaDiariaCaja cajadiariacaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCajaDiariaCajaToGet(CajaDiariaCaja cajadiariacaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCajaDiariaCajaActions(String sTipoJsonResponse,JSONObject jsonObjectCajaDiariaCaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCajaDiariaCajaDataTable(String sTipoJsonResponse,CajaDiariaCaja cajadiariacaja,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCajaDiariaCajasDataTable(String sTipoJsonResponse,List<CajaDiariaCaja> cajadiariacajas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCajaDiariaCajaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCajaDiariaCajasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCajaDiariaCajasColumns;
	}
	
	public static void updateJSONArrayCajaDiariaCajaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCajaDiariaCaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCajaDiariaCaja(CajaDiariaCaja cajadiariacaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cajadiariacaja.setnombre_caja(cajadiariacaja.getnombre_caja().trim());
		cajadiariacaja.setsecuencial(cajadiariacaja.getsecuencial().trim());
		cajadiariacaja.setcodigo_cliente(cajadiariacaja.getcodigo_cliente().trim());
		cajadiariacaja.setnombre_cliente(cajadiariacaja.getnombre_cliente().trim());
	}
	
	public static void quitarEspaciosCajaDiariaCajas(List<CajaDiariaCaja> cajadiariacajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CajaDiariaCaja cajadiariacaja: cajadiariacajas) {
			cajadiariacaja.setnombre_caja(cajadiariacaja.getnombre_caja().trim());
			cajadiariacaja.setsecuencial(cajadiariacaja.getsecuencial().trim());
			cajadiariacaja.setcodigo_cliente(cajadiariacaja.getcodigo_cliente().trim());
			cajadiariacaja.setnombre_cliente(cajadiariacaja.getnombre_cliente().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaDiariaCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CajaDiariaCajaConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CajaDiariaCaja> cajadiariacajas,CajaDiariaCaja cajadiariacaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CajaDiariaCaja cajadiariacajaAux: cajadiariacajas) {
			if((cajadiariacajaAux.getId()==null && cajadiariacaja.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cajadiariacajaAux.getId()!=null && cajadiariacaja.getId()!=null){
				if(cajadiariacajaAux.getId().equals(cajadiariacaja.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCajaDiariaCaja(List<CajaDiariaCaja> cajadiariacajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double subtotalTotal=0.0;
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double financiamientoTotal=0.0;
		Double fleteTotal=0.0;
		Double iceTotal=0.0;
		Double totalTotal=0.0;
	
		for(CajaDiariaCaja cajadiariacaja: cajadiariacajas) {			
			subtotalTotal+=cajadiariacaja.getsubtotal();
			ivaTotal+=cajadiariacaja.getiva();
			descuentoTotal+=cajadiariacaja.getdescuento();
			financiamientoTotal+=cajadiariacaja.getfinanciamiento();
			fleteTotal+=cajadiariacaja.getflete();
			iceTotal+=cajadiariacaja.getice();
			totalTotal+=cajadiariacaja.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaCajaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaCajaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaCajaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaCajaConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaCajaConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaCajaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajaDiariaCajaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(CajaDiariaCajaConstantesFunciones.LABEL_TOTAL);
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
}