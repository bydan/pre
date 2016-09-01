










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.tesoreria.business.logic.report;

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
import com.bydan.erp.tesoreria.util.report.DetallesIngresosFacturasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;
////import com.bydan.erp.tesoreria.business.interfaces.DetallesIngresosFacturasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class DetallesIngresosFacturasLogicAdditional extends DetallesIngresosFacturasLogic{		
	
	public  DetallesIngresosFacturasLogicAdditional(Connexion connexion)throws Exception {
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
	public  DetallesIngresosFacturasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetallesIngresosFacturasToSave(DetallesIngresosFacturas detallesingresosfacturas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetallesIngresosFacturasToSave(DetallesIngresosFacturas detallesingresosfacturas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetallesIngresosFacturasToSaveAfter(DetallesIngresosFacturas detallesingresosfacturas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetallesIngresosFacturasToSaves(List<DetallesIngresosFacturas> detallesingresosfacturass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetallesIngresosFacturasToSaves(List<DetallesIngresosFacturas> detallesingresosfacturass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetallesIngresosFacturasToSavesAfter(List<DetallesIngresosFacturas> detallesingresosfacturass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetallesIngresosFacturasToGet(DetallesIngresosFacturas detallesingresosfacturas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetallesIngresosFacturasToGets(List<DetallesIngresosFacturas> detallesingresosfacturass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetallesIngresosFacturasToSave(DetallesIngresosFacturas detallesingresosfacturas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetallesIngresosFacturasToGet(DetallesIngresosFacturas detallesingresosfacturas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetallesIngresosFacturasActions(String sTipoJsonResponse,JSONObject jsonObjectDetallesIngresosFacturas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetallesIngresosFacturasDataTable(String sTipoJsonResponse,DetallesIngresosFacturas detallesingresosfacturas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetallesIngresosFacturassDataTable(String sTipoJsonResponse,List<DetallesIngresosFacturas> detallesingresosfacturass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetallesIngresosFacturasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetallesIngresosFacturassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetallesIngresosFacturassColumns;
	}
	
	public static void updateJSONArrayDetallesIngresosFacturasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetallesIngresosFacturas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetallesIngresosFacturas(DetallesIngresosFacturas detallesingresosfacturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallesingresosfacturas.settipo_movimiento(detallesingresosfacturas.gettipo_movimiento().trim());
		detallesingresosfacturas.setnumero_mayor(detallesingresosfacturas.getnumero_mayor().trim());
		detallesingresosfacturas.setnumero_factura(detallesingresosfacturas.getnumero_factura().trim());
		detallesingresosfacturas.setnombre_cliente(detallesingresosfacturas.getnombre_cliente().trim());
		detallesingresosfacturas.setsiglas_pago(detallesingresosfacturas.getsiglas_pago().trim());
		detallesingresosfacturas.setnombre_pago(detallesingresosfacturas.getnombre_pago().trim());
		detallesingresosfacturas.setcodigo(detallesingresosfacturas.getcodigo().trim());
	}
	
	public static void quitarEspaciosDetallesIngresosFacturass(List<DetallesIngresosFacturas> detallesingresosfacturass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetallesIngresosFacturas detallesingresosfacturas: detallesingresosfacturass) {
			detallesingresosfacturas.settipo_movimiento(detallesingresosfacturas.gettipo_movimiento().trim());
			detallesingresosfacturas.setnumero_mayor(detallesingresosfacturas.getnumero_mayor().trim());
			detallesingresosfacturas.setnumero_factura(detallesingresosfacturas.getnumero_factura().trim());
			detallesingresosfacturas.setnombre_cliente(detallesingresosfacturas.getnombre_cliente().trim());
			detallesingresosfacturas.setsiglas_pago(detallesingresosfacturas.getsiglas_pago().trim());
			detallesingresosfacturas.setnombre_pago(detallesingresosfacturas.getnombre_pago().trim());
			detallesingresosfacturas.setcodigo(detallesingresosfacturas.getcodigo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallesIngresosFacturas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetallesIngresosFacturasConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DetallesIngresosFacturasConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(DetallesIngresosFacturasConstantesFunciones.IDEJERCICIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetallesIngresosFacturas> detallesingresosfacturass,DetallesIngresosFacturas detallesingresosfacturas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetallesIngresosFacturas detallesingresosfacturasAux: detallesingresosfacturass) {
			if((detallesingresosfacturasAux.getId()==null && detallesingresosfacturas.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(detallesingresosfacturasAux.getId()!=null && detallesingresosfacturas.getId()!=null){
				if(detallesingresosfacturasAux.getId().equals(detallesingresosfacturas.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetallesIngresosFacturas(List<DetallesIngresosFacturas> detallesingresosfacturass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double credito_mone_localTotal=0.0;
	
		for(DetallesIngresosFacturas detallesingresosfacturas: detallesingresosfacturass) {			
			credito_mone_localTotal+=detallesingresosfacturas.getcredito_mone_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallesIngresosFacturasConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(DetallesIngresosFacturasConstantesFunciones.LABEL_CREDITOMONELOCAL);
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