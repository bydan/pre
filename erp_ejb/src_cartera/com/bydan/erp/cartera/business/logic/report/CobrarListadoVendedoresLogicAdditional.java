










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
import com.bydan.erp.cartera.util.report.CobrarListadoVendedoresConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.CobrarListadoVendedoresAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class CobrarListadoVendedoresLogicAdditional extends CobrarListadoVendedoresLogic{		
	
	public  CobrarListadoVendedoresLogicAdditional(Connexion connexion)throws Exception {
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
	public  CobrarListadoVendedoresLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCobrarListadoVendedoresToSave(CobrarListadoVendedores cobrarlistadovendedores,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCobrarListadoVendedoresToSave(CobrarListadoVendedores cobrarlistadovendedores,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCobrarListadoVendedoresToSaveAfter(CobrarListadoVendedores cobrarlistadovendedores,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCobrarListadoVendedoresToSaves(List<CobrarListadoVendedores> cobrarlistadovendedoress,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCobrarListadoVendedoresToSaves(List<CobrarListadoVendedores> cobrarlistadovendedoress,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCobrarListadoVendedoresToSavesAfter(List<CobrarListadoVendedores> cobrarlistadovendedoress,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCobrarListadoVendedoresToGet(CobrarListadoVendedores cobrarlistadovendedores,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCobrarListadoVendedoresToGets(List<CobrarListadoVendedores> cobrarlistadovendedoress,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCobrarListadoVendedoresToSave(CobrarListadoVendedores cobrarlistadovendedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCobrarListadoVendedoresToGet(CobrarListadoVendedores cobrarlistadovendedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCobrarListadoVendedoresActions(String sTipoJsonResponse,JSONObject jsonObjectCobrarListadoVendedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCobrarListadoVendedoresDataTable(String sTipoJsonResponse,CobrarListadoVendedores cobrarlistadovendedores,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCobrarListadoVendedoressDataTable(String sTipoJsonResponse,List<CobrarListadoVendedores> cobrarlistadovendedoress,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCobrarListadoVendedoresColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCobrarListadoVendedoressColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCobrarListadoVendedoressColumns;
	}
	
	public static void updateJSONArrayCobrarListadoVendedoresActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCobrarListadoVendedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCobrarListadoVendedores(CobrarListadoVendedores cobrarlistadovendedores,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarlistadovendedores.setnombre_vendedor(cobrarlistadovendedores.getnombre_vendedor().trim());
		cobrarlistadovendedores.setcodigo(cobrarlistadovendedores.getcodigo().trim());
		cobrarlistadovendedores.setnombre(cobrarlistadovendedores.getnombre().trim());
		cobrarlistadovendedores.setruc(cobrarlistadovendedores.getruc().trim());
		cobrarlistadovendedores.setdireccion_domicilio(cobrarlistadovendedores.getdireccion_domicilio().trim());
		cobrarlistadovendedores.settelefono(cobrarlistadovendedores.gettelefono().trim());
	}
	
	public static void quitarEspaciosCobrarListadoVendedoress(List<CobrarListadoVendedores> cobrarlistadovendedoress,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarListadoVendedores cobrarlistadovendedores: cobrarlistadovendedoress) {
			cobrarlistadovendedores.setnombre_vendedor(cobrarlistadovendedores.getnombre_vendedor().trim());
			cobrarlistadovendedores.setcodigo(cobrarlistadovendedores.getcodigo().trim());
			cobrarlistadovendedores.setnombre(cobrarlistadovendedores.getnombre().trim());
			cobrarlistadovendedores.setruc(cobrarlistadovendedores.getruc().trim());
			cobrarlistadovendedores.setdireccion_domicilio(cobrarlistadovendedores.getdireccion_domicilio().trim());
			cobrarlistadovendedores.settelefono(cobrarlistadovendedores.gettelefono().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarListadoVendedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CobrarListadoVendedoresConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(CobrarListadoVendedoresConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarListadoVendedores> cobrarlistadovendedoress,CobrarListadoVendedores cobrarlistadovendedores,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarListadoVendedores cobrarlistadovendedoresAux: cobrarlistadovendedoress) {
			if((cobrarlistadovendedoresAux.getId()==null && cobrarlistadovendedores.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cobrarlistadovendedoresAux.getId()!=null && cobrarlistadovendedores.getId()!=null){
				if(cobrarlistadovendedoresAux.getId().equals(cobrarlistadovendedores.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarListadoVendedores(List<CobrarListadoVendedores> cobrarlistadovendedoress) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CobrarListadoVendedores cobrarlistadovendedores: cobrarlistadovendedoress) {			
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