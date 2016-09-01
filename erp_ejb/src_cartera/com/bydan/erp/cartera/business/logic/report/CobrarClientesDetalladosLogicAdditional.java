










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
import com.bydan.erp.cartera.util.report.CobrarClientesDetalladosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.CobrarClientesDetalladosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class CobrarClientesDetalladosLogicAdditional extends CobrarClientesDetalladosLogic{		
	
	public  CobrarClientesDetalladosLogicAdditional(Connexion connexion)throws Exception {
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
	public  CobrarClientesDetalladosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCobrarClientesDetalladosToSave(CobrarClientesDetallados cobrarclientesdetallados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCobrarClientesDetalladosToSave(CobrarClientesDetallados cobrarclientesdetallados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCobrarClientesDetalladosToSaveAfter(CobrarClientesDetallados cobrarclientesdetallados,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCobrarClientesDetalladosToSaves(List<CobrarClientesDetallados> cobrarclientesdetalladoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCobrarClientesDetalladosToSaves(List<CobrarClientesDetallados> cobrarclientesdetalladoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCobrarClientesDetalladosToSavesAfter(List<CobrarClientesDetallados> cobrarclientesdetalladoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCobrarClientesDetalladosToGet(CobrarClientesDetallados cobrarclientesdetallados,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCobrarClientesDetalladosToGets(List<CobrarClientesDetallados> cobrarclientesdetalladoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCobrarClientesDetalladosToSave(CobrarClientesDetallados cobrarclientesdetallados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCobrarClientesDetalladosToGet(CobrarClientesDetallados cobrarclientesdetallados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCobrarClientesDetalladosActions(String sTipoJsonResponse,JSONObject jsonObjectCobrarClientesDetallados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCobrarClientesDetalladosDataTable(String sTipoJsonResponse,CobrarClientesDetallados cobrarclientesdetallados,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCobrarClientesDetalladossDataTable(String sTipoJsonResponse,List<CobrarClientesDetallados> cobrarclientesdetalladoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCobrarClientesDetalladosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCobrarClientesDetalladossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCobrarClientesDetalladossColumns;
	}
	
	public static void updateJSONArrayCobrarClientesDetalladosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCobrarClientesDetallados,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCobrarClientesDetallados(CobrarClientesDetallados cobrarclientesdetallados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarclientesdetallados.setnombre_ciudad(cobrarclientesdetallados.getnombre_ciudad().trim());
		cobrarclientesdetallados.setnombre_zona(cobrarclientesdetallados.getnombre_zona().trim());
		cobrarclientesdetallados.setnombre_grupo_cliente(cobrarclientesdetallados.getnombre_grupo_cliente().trim());
		cobrarclientesdetallados.setnombre_titulo_cliente(cobrarclientesdetallados.getnombre_titulo_cliente().trim());
		cobrarclientesdetallados.setcodigo(cobrarclientesdetallados.getcodigo().trim());
		cobrarclientesdetallados.setnombre(cobrarclientesdetallados.getnombre().trim());
		cobrarclientesdetallados.setapellido(cobrarclientesdetallados.getapellido().trim());
		cobrarclientesdetallados.setruc(cobrarclientesdetallados.getruc().trim());
		cobrarclientesdetallados.setnombre_contacto_cliente(cobrarclientesdetallados.getnombre_contacto_cliente().trim());
		cobrarclientesdetallados.setdireccion_direccion(cobrarclientesdetallados.getdireccion_direccion().trim());
		cobrarclientesdetallados.sete_mail_e_mail(cobrarclientesdetallados.gete_mail_e_mail().trim());
		cobrarclientesdetallados.settelefono_telefono(cobrarclientesdetallados.gettelefono_telefono().trim());
	}
	
	public static void quitarEspaciosCobrarClientesDetalladoss(List<CobrarClientesDetallados> cobrarclientesdetalladoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarClientesDetallados cobrarclientesdetallados: cobrarclientesdetalladoss) {
			cobrarclientesdetallados.setnombre_ciudad(cobrarclientesdetallados.getnombre_ciudad().trim());
			cobrarclientesdetallados.setnombre_zona(cobrarclientesdetallados.getnombre_zona().trim());
			cobrarclientesdetallados.setnombre_grupo_cliente(cobrarclientesdetallados.getnombre_grupo_cliente().trim());
			cobrarclientesdetallados.setnombre_titulo_cliente(cobrarclientesdetallados.getnombre_titulo_cliente().trim());
			cobrarclientesdetallados.setcodigo(cobrarclientesdetallados.getcodigo().trim());
			cobrarclientesdetallados.setnombre(cobrarclientesdetallados.getnombre().trim());
			cobrarclientesdetallados.setapellido(cobrarclientesdetallados.getapellido().trim());
			cobrarclientesdetallados.setruc(cobrarclientesdetallados.getruc().trim());
			cobrarclientesdetallados.setnombre_contacto_cliente(cobrarclientesdetallados.getnombre_contacto_cliente().trim());
			cobrarclientesdetallados.setdireccion_direccion(cobrarclientesdetallados.getdireccion_direccion().trim());
			cobrarclientesdetallados.sete_mail_e_mail(cobrarclientesdetallados.gete_mail_e_mail().trim());
			cobrarclientesdetallados.settelefono_telefono(cobrarclientesdetallados.gettelefono_telefono().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarClientesDetallados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CobrarClientesDetalladosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarClientesDetallados> cobrarclientesdetalladoss,CobrarClientesDetallados cobrarclientesdetallados,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarClientesDetallados cobrarclientesdetalladosAux: cobrarclientesdetalladoss) {
			if((cobrarclientesdetalladosAux.getId()==null && cobrarclientesdetallados.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cobrarclientesdetalladosAux.getId()!=null && cobrarclientesdetallados.getId()!=null){
				if(cobrarclientesdetalladosAux.getId().equals(cobrarclientesdetallados.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarClientesDetallados(List<CobrarClientesDetallados> cobrarclientesdetalladoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CobrarClientesDetallados cobrarclientesdetallados: cobrarclientesdetalladoss) {			
		}
		
		
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