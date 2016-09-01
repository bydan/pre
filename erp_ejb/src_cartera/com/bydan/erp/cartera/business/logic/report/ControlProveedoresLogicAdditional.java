










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
import com.bydan.erp.cartera.util.report.ControlProveedoresConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.ControlProveedoresAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ControlProveedoresLogicAdditional extends ControlProveedoresLogic{		
	
	public  ControlProveedoresLogicAdditional(Connexion connexion)throws Exception {
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
	public  ControlProveedoresLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkControlProveedoresToSave(ControlProveedores controlproveedores,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkControlProveedoresToSave(ControlProveedores controlproveedores,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkControlProveedoresToSaveAfter(ControlProveedores controlproveedores,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkControlProveedoresToSaves(List<ControlProveedores> controlproveedoress,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkControlProveedoresToSaves(List<ControlProveedores> controlproveedoress,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkControlProveedoresToSavesAfter(List<ControlProveedores> controlproveedoress,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkControlProveedoresToGet(ControlProveedores controlproveedores,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkControlProveedoresToGets(List<ControlProveedores> controlproveedoress,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateControlProveedoresToSave(ControlProveedores controlproveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateControlProveedoresToGet(ControlProveedores controlproveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectControlProveedoresActions(String sTipoJsonResponse,JSONObject jsonObjectControlProveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonControlProveedoresDataTable(String sTipoJsonResponse,ControlProveedores controlproveedores,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonControlProveedoressDataTable(String sTipoJsonResponse,List<ControlProveedores> controlproveedoress,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayControlProveedoresColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayControlProveedoressColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayControlProveedoressColumns;
	}
	
	public static void updateJSONArrayControlProveedoresActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectControlProveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosControlProveedores(ControlProveedores controlproveedores,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		controlproveedores.setnombre_zona(controlproveedores.getnombre_zona().trim());
		controlproveedores.setnombre_ciudad(controlproveedores.getnombre_ciudad().trim());
		controlproveedores.setnombre_grupo_cliente(controlproveedores.getnombre_grupo_cliente().trim());
		controlproveedores.setcodigo(controlproveedores.getcodigo().trim());
		controlproveedores.setnombre_cliente(controlproveedores.getnombre_cliente().trim());
		controlproveedores.setruc(controlproveedores.getruc().trim());
		controlproveedores.settelefonos(controlproveedores.gettelefonos().trim());
		controlproveedores.setdirecciones(controlproveedores.getdirecciones().trim());
		controlproveedores.setemails(controlproveedores.getemails().trim());
		controlproveedores.setnumero_factura(controlproveedores.getnumero_factura().trim());
	}
	
	public static void quitarEspaciosControlProveedoress(List<ControlProveedores> controlproveedoress,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ControlProveedores controlproveedores: controlproveedoress) {
			controlproveedores.setnombre_zona(controlproveedores.getnombre_zona().trim());
			controlproveedores.setnombre_ciudad(controlproveedores.getnombre_ciudad().trim());
			controlproveedores.setnombre_grupo_cliente(controlproveedores.getnombre_grupo_cliente().trim());
			controlproveedores.setcodigo(controlproveedores.getcodigo().trim());
			controlproveedores.setnombre_cliente(controlproveedores.getnombre_cliente().trim());
			controlproveedores.setruc(controlproveedores.getruc().trim());
			controlproveedores.settelefonos(controlproveedores.gettelefonos().trim());
			controlproveedores.setdirecciones(controlproveedores.getdirecciones().trim());
			controlproveedores.setemails(controlproveedores.getemails().trim());
			controlproveedores.setnumero_factura(controlproveedores.getnumero_factura().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesControlProveedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ControlProveedoresConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ControlProveedores> controlproveedoress,ControlProveedores controlproveedores,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ControlProveedores controlproveedoresAux: controlproveedoress) {
			if((controlproveedoresAux.getId()==null && controlproveedores.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(controlproveedoresAux.getId()!=null && controlproveedores.getId()!=null){
				if(controlproveedoresAux.getId().equals(controlproveedores.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaControlProveedores(List<ControlProveedores> controlproveedoress) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldoTotal=0.0;
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
	
		for(ControlProveedores controlproveedores: controlproveedoress) {			
			saldoTotal+=controlproveedores.getsaldo();
			debito_mone_localTotal+=controlproveedores.getdebito_mone_local();
			credito_mone_localTotal+=controlproveedores.getcredito_mone_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ControlProveedoresConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ControlProveedoresConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ControlProveedoresConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(ControlProveedoresConstantesFunciones.LABEL_CREDITOMONELOCAL);
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