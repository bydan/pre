










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.inventario.business.logic.report;

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
import com.bydan.erp.inventario.util.report.MovimientosResumidosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;
////import com.bydan.erp.inventario.business.interfaces.MovimientosResumidosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class MovimientosResumidosLogicAdditional extends MovimientosResumidosLogic{		
	
	public  MovimientosResumidosLogicAdditional(Connexion connexion)throws Exception {
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
	public  MovimientosResumidosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkMovimientosResumidosToSave(MovimientosResumidos movimientosresumidos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkMovimientosResumidosToSave(MovimientosResumidos movimientosresumidos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkMovimientosResumidosToSaveAfter(MovimientosResumidos movimientosresumidos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkMovimientosResumidosToSaves(List<MovimientosResumidos> movimientosresumidoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkMovimientosResumidosToSaves(List<MovimientosResumidos> movimientosresumidoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkMovimientosResumidosToSavesAfter(List<MovimientosResumidos> movimientosresumidoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkMovimientosResumidosToGet(MovimientosResumidos movimientosresumidos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkMovimientosResumidosToGets(List<MovimientosResumidos> movimientosresumidoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateMovimientosResumidosToSave(MovimientosResumidos movimientosresumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateMovimientosResumidosToGet(MovimientosResumidos movimientosresumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectMovimientosResumidosActions(String sTipoJsonResponse,JSONObject jsonObjectMovimientosResumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonMovimientosResumidosDataTable(String sTipoJsonResponse,MovimientosResumidos movimientosresumidos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonMovimientosResumidossDataTable(String sTipoJsonResponse,List<MovimientosResumidos> movimientosresumidoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayMovimientosResumidosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayMovimientosResumidossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayMovimientosResumidossColumns;
	}
	
	public static void updateJSONArrayMovimientosResumidosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectMovimientosResumidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosMovimientosResumidos(MovimientosResumidos movimientosresumidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		movimientosresumidos.setnombre_sucursal(movimientosresumidos.getnombre_sucursal().trim());
		movimientosresumidos.setnombre_completo_cliente(movimientosresumidos.getnombre_completo_cliente().trim());
		movimientosresumidos.setnombre_transaccion(movimientosresumidos.getnombre_transaccion().trim());
		movimientosresumidos.setnumero_comprobante(movimientosresumidos.getnumero_comprobante().trim());
		movimientosresumidos.setnumero_factura(movimientosresumidos.getnumero_factura().trim());
		movimientosresumidos.setnumero_secuencial(movimientosresumidos.getnumero_secuencial().trim());
	}
	
	public static void quitarEspaciosMovimientosResumidoss(List<MovimientosResumidos> movimientosresumidoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MovimientosResumidos movimientosresumidos: movimientosresumidoss) {
			movimientosresumidos.setnombre_sucursal(movimientosresumidos.getnombre_sucursal().trim());
			movimientosresumidos.setnombre_completo_cliente(movimientosresumidos.getnombre_completo_cliente().trim());
			movimientosresumidos.setnombre_transaccion(movimientosresumidos.getnombre_transaccion().trim());
			movimientosresumidos.setnumero_comprobante(movimientosresumidos.getnumero_comprobante().trim());
			movimientosresumidos.setnumero_factura(movimientosresumidos.getnumero_factura().trim());
			movimientosresumidos.setnumero_secuencial(movimientosresumidos.getnumero_secuencial().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMovimientosResumidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(MovimientosResumidosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(MovimientosResumidosConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MovimientosResumidos> movimientosresumidoss,MovimientosResumidos movimientosresumidos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MovimientosResumidos movimientosresumidosAux: movimientosresumidoss) {
			if((movimientosresumidosAux.getId()==null && movimientosresumidos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(movimientosresumidosAux.getId()!=null && movimientosresumidos.getId()!=null){
				if(movimientosresumidosAux.getId().equals(movimientosresumidos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMovimientosResumidos(List<MovimientosResumidos> movimientosresumidoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
		Double ivaTotal=0.0;
		Double total_descuentoTotal=0.0;
		Double iceTotal=0.0;
		Double retencionTotal=0.0;
		Double total_otroTotal=0.0;
	
		for(MovimientosResumidos movimientosresumidos: movimientosresumidoss) {			
			totalTotal+=movimientosresumidos.gettotal();
			ivaTotal+=movimientosresumidos.getiva();
			total_descuentoTotal+=movimientosresumidos.gettotal_descuento();
			iceTotal+=movimientosresumidos.getice();
			retencionTotal+=movimientosresumidos.getretencion();
			total_otroTotal+=movimientosresumidos.gettotal_otro();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosResumidosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosResumidosConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosResumidosConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosResumidosConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosResumidosConstantesFunciones.RETENCION);
		datoGeneral.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_RETENCION);
		datoGeneral.setdValorDouble(retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientosResumidosConstantesFunciones.TOTALOTRO);
		datoGeneral.setsDescripcion(MovimientosResumidosConstantesFunciones.LABEL_TOTALOTRO);
		datoGeneral.setdValorDouble(total_otroTotal);
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