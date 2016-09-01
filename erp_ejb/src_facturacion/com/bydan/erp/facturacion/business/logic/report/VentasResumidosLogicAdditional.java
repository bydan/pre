










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.facturacion.business.logic.report;

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
import com.bydan.erp.facturacion.util.report.VentasResumidosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;
////import com.bydan.erp.facturacion.business.interfaces.VentasResumidosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class VentasResumidosLogicAdditional extends VentasResumidosLogic{		
	
	public  VentasResumidosLogicAdditional(Connexion connexion)throws Exception {
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
	public  VentasResumidosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkVentasResumidosToSave(VentasResumidos ventasresumidos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkVentasResumidosToSave(VentasResumidos ventasresumidos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkVentasResumidosToSaveAfter(VentasResumidos ventasresumidos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkVentasResumidosToSaves(List<VentasResumidos> ventasresumidoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkVentasResumidosToSaves(List<VentasResumidos> ventasresumidoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkVentasResumidosToSavesAfter(List<VentasResumidos> ventasresumidoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkVentasResumidosToGet(VentasResumidos ventasresumidos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkVentasResumidosToGets(List<VentasResumidos> ventasresumidoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateVentasResumidosToSave(VentasResumidos ventasresumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateVentasResumidosToGet(VentasResumidos ventasresumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectVentasResumidosActions(String sTipoJsonResponse,JSONObject jsonObjectVentasResumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonVentasResumidosDataTable(String sTipoJsonResponse,VentasResumidos ventasresumidos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonVentasResumidossDataTable(String sTipoJsonResponse,List<VentasResumidos> ventasresumidoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayVentasResumidosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayVentasResumidossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayVentasResumidossColumns;
	}
	
	public static void updateJSONArrayVentasResumidosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectVentasResumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosVentasResumidos(VentasResumidos ventasresumidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventasresumidos.setnombre_completo(ventasresumidos.getnombre_completo().trim());
		ventasresumidos.setruc(ventasresumidos.getruc().trim());
		ventasresumidos.setnombre_producto(ventasresumidos.getnombre_producto().trim());
		ventasresumidos.setcodigo_producto(ventasresumidos.getcodigo_producto().trim());
	}
	
	public static void quitarEspaciosVentasResumidoss(List<VentasResumidos> ventasresumidoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasResumidos ventasresumidos: ventasresumidoss) {
			ventasresumidos.setnombre_completo(ventasresumidos.getnombre_completo().trim());
			ventasresumidos.setruc(ventasresumidos.getruc().trim());
			ventasresumidos.setnombre_producto(ventasresumidos.getnombre_producto().trim());
			ventasresumidos.setcodigo_producto(ventasresumidos.getcodigo_producto().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasResumidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(VentasResumidosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(VentasResumidosConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasResumidos> ventasresumidoss,VentasResumidos ventasresumidos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasResumidos ventasresumidosAux: ventasresumidoss) {
			if((ventasresumidosAux.getId()==null && ventasresumidos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(ventasresumidosAux.getId()!=null && ventasresumidos.getId()!=null){
				if(ventasresumidosAux.getId().equals(ventasresumidos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasResumidos(List<VentasResumidos> ventasresumidoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double montoTotal=0.0;
	
		for(VentasResumidos ventasresumidos: ventasresumidoss) {			
			precioTotal+=ventasresumidos.getprecio();
			montoTotal+=ventasresumidos.getmonto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidosConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(VentasResumidosConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidosConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(VentasResumidosConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
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