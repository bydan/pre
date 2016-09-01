










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
import com.bydan.erp.cartera.util.report.DetalleFacturasProveedoresConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.DetalleFacturasProveedoresAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class DetalleFacturasProveedoresLogicAdditional extends DetalleFacturasProveedoresLogic{		
	
	public  DetalleFacturasProveedoresLogicAdditional(Connexion connexion)throws Exception {
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
	public  DetalleFacturasProveedoresLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetalleFacturasProveedoresToSave(DetalleFacturasProveedores detallefacturasproveedores,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetalleFacturasProveedoresToSave(DetalleFacturasProveedores detallefacturasproveedores,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetalleFacturasProveedoresToSaveAfter(DetalleFacturasProveedores detallefacturasproveedores,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetalleFacturasProveedoresToSaves(List<DetalleFacturasProveedores> detallefacturasproveedoress,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetalleFacturasProveedoresToSaves(List<DetalleFacturasProveedores> detallefacturasproveedoress,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetalleFacturasProveedoresToSavesAfter(List<DetalleFacturasProveedores> detallefacturasproveedoress,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetalleFacturasProveedoresToGet(DetalleFacturasProveedores detallefacturasproveedores,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetalleFacturasProveedoresToGets(List<DetalleFacturasProveedores> detallefacturasproveedoress,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetalleFacturasProveedoresToSave(DetalleFacturasProveedores detallefacturasproveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetalleFacturasProveedoresToGet(DetalleFacturasProveedores detallefacturasproveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetalleFacturasProveedoresActions(String sTipoJsonResponse,JSONObject jsonObjectDetalleFacturasProveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetalleFacturasProveedoresDataTable(String sTipoJsonResponse,DetalleFacturasProveedores detallefacturasproveedores,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetalleFacturasProveedoressDataTable(String sTipoJsonResponse,List<DetalleFacturasProveedores> detallefacturasproveedoress,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetalleFacturasProveedoresColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetalleFacturasProveedoressColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetalleFacturasProveedoressColumns;
	}
	
	public static void updateJSONArrayDetalleFacturasProveedoresActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetalleFacturasProveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetalleFacturasProveedores(DetalleFacturasProveedores detallefacturasproveedores,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallefacturasproveedores.setnombre_cliente(detallefacturasproveedores.getnombre_cliente().trim());
	}
	
	public static void quitarEspaciosDetalleFacturasProveedoress(List<DetalleFacturasProveedores> detallefacturasproveedoress,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleFacturasProveedores detallefacturasproveedores: detallefacturasproveedoress) {
			detallefacturasproveedores.setnombre_cliente(detallefacturasproveedores.getnombre_cliente().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleFacturasProveedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetalleFacturasProveedoresConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleFacturasProveedores> detallefacturasproveedoress,DetalleFacturasProveedores detallefacturasproveedores,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleFacturasProveedores detallefacturasproveedoresAux: detallefacturasproveedoress) {
			if((detallefacturasproveedoresAux.getId()==null && detallefacturasproveedores.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(detallefacturasproveedoresAux.getId()!=null && detallefacturasproveedores.getId()!=null){
				if(detallefacturasproveedoresAux.getId().equals(detallefacturasproveedores.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleFacturasProveedores(List<DetalleFacturasProveedores> detallefacturasproveedoress) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_valorTotal=0.0;
	
		for(DetalleFacturasProveedores detallefacturasproveedores: detallefacturasproveedoress) {			
			total_valorTotal+=detallefacturasproveedores.gettotal_valor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturasProveedoresConstantesFunciones.TOTALVALOR);
		datoGeneral.setsDescripcion(DetalleFacturasProveedoresConstantesFunciones.LABEL_TOTALVALOR);
		datoGeneral.setdValorDouble(total_valorTotal);
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