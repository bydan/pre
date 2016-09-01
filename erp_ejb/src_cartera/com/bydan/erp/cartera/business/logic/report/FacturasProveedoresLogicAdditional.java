










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
import com.bydan.erp.cartera.util.report.FacturasProveedoresConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.FacturasProveedoresAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class FacturasProveedoresLogicAdditional extends FacturasProveedoresLogic{		
	
	public  FacturasProveedoresLogicAdditional(Connexion connexion)throws Exception {
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
	public  FacturasProveedoresLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkFacturasProveedoresToSave(FacturasProveedores facturasproveedores,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkFacturasProveedoresToSave(FacturasProveedores facturasproveedores,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkFacturasProveedoresToSaveAfter(FacturasProveedores facturasproveedores,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkFacturasProveedoresToSaves(List<FacturasProveedores> facturasproveedoress,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkFacturasProveedoresToSaves(List<FacturasProveedores> facturasproveedoress,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkFacturasProveedoresToSavesAfter(List<FacturasProveedores> facturasproveedoress,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkFacturasProveedoresToGet(FacturasProveedores facturasproveedores,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkFacturasProveedoresToGets(List<FacturasProveedores> facturasproveedoress,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateFacturasProveedoresToSave(FacturasProveedores facturasproveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateFacturasProveedoresToGet(FacturasProveedores facturasproveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectFacturasProveedoresActions(String sTipoJsonResponse,JSONObject jsonObjectFacturasProveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonFacturasProveedoresDataTable(String sTipoJsonResponse,FacturasProveedores facturasproveedores,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonFacturasProveedoressDataTable(String sTipoJsonResponse,List<FacturasProveedores> facturasproveedoress,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayFacturasProveedoresColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayFacturasProveedoressColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayFacturasProveedoressColumns;
	}
	
	public static void updateJSONArrayFacturasProveedoresActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectFacturasProveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosFacturasProveedores(FacturasProveedores facturasproveedores,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturasproveedores.setcodigo_cliente(facturasproveedores.getcodigo_cliente().trim());
		facturasproveedores.setnombre_cliente(facturasproveedores.getnombre_cliente().trim());
		facturasproveedores.setnumero_factura(facturasproveedores.getnumero_factura().trim());
		facturasproveedores.setnumero_pre_impreso(facturasproveedores.getnumero_pre_impreso().trim());
	}
	
	public static void quitarEspaciosFacturasProveedoress(List<FacturasProveedores> facturasproveedoress,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturasProveedores facturasproveedores: facturasproveedoress) {
			facturasproveedores.setcodigo_cliente(facturasproveedores.getcodigo_cliente().trim());
			facturasproveedores.setnombre_cliente(facturasproveedores.getnombre_cliente().trim());
			facturasproveedores.setnumero_factura(facturasproveedores.getnumero_factura().trim());
			facturasproveedores.setnumero_pre_impreso(facturasproveedores.getnumero_pre_impreso().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturasProveedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(FacturasProveedoresConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturasProveedores> facturasproveedoress,FacturasProveedores facturasproveedores,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturasProveedores facturasproveedoresAux: facturasproveedoress) {
			if((facturasproveedoresAux.getId()==null && facturasproveedores.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(facturasproveedoresAux.getId()!=null && facturasproveedores.getId()!=null){
				if(facturasproveedoresAux.getId().equals(facturasproveedores.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturasProveedores(List<FacturasProveedores> facturasproveedoress) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
	
		for(FacturasProveedores facturasproveedores: facturasproveedoress) {			
			totalTotal+=facturasproveedores.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasProveedoresConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(FacturasProveedoresConstantesFunciones.LABEL_TOTAL);
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