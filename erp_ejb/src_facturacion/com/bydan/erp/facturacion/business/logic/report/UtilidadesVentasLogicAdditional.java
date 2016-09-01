










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
import com.bydan.erp.facturacion.util.report.UtilidadesVentasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;
////import com.bydan.erp.facturacion.business.interfaces.UtilidadesVentasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class UtilidadesVentasLogicAdditional extends UtilidadesVentasLogic{		
	
	public  UtilidadesVentasLogicAdditional(Connexion connexion)throws Exception {
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
	public  UtilidadesVentasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkUtilidadesVentasToSave(UtilidadesVentas utilidadesventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkUtilidadesVentasToSave(UtilidadesVentas utilidadesventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkUtilidadesVentasToSaveAfter(UtilidadesVentas utilidadesventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkUtilidadesVentasToSaves(List<UtilidadesVentas> utilidadesventass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkUtilidadesVentasToSaves(List<UtilidadesVentas> utilidadesventass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkUtilidadesVentasToSavesAfter(List<UtilidadesVentas> utilidadesventass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkUtilidadesVentasToGet(UtilidadesVentas utilidadesventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkUtilidadesVentasToGets(List<UtilidadesVentas> utilidadesventass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateUtilidadesVentasToSave(UtilidadesVentas utilidadesventas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateUtilidadesVentasToGet(UtilidadesVentas utilidadesventas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectUtilidadesVentasActions(String sTipoJsonResponse,JSONObject jsonObjectUtilidadesVentas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonUtilidadesVentasDataTable(String sTipoJsonResponse,UtilidadesVentas utilidadesventas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonUtilidadesVentassDataTable(String sTipoJsonResponse,List<UtilidadesVentas> utilidadesventass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayUtilidadesVentasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayUtilidadesVentassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayUtilidadesVentassColumns;
	}
	
	public static void updateJSONArrayUtilidadesVentasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectUtilidadesVentas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosUtilidadesVentas(UtilidadesVentas utilidadesventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		utilidadesventas.setnombre_completo_cliente(utilidadesventas.getnombre_completo_cliente().trim());
		utilidadesventas.setnombre_tipo_factura(utilidadesventas.getnombre_tipo_factura().trim());
		utilidadesventas.setnumero_documento(utilidadesventas.getnumero_documento().trim());
		utilidadesventas.settipo(utilidadesventas.gettipo().trim());
	}
	
	public static void quitarEspaciosUtilidadesVentass(List<UtilidadesVentas> utilidadesventass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(UtilidadesVentas utilidadesventas: utilidadesventass) {
			utilidadesventas.setnombre_completo_cliente(utilidadesventas.getnombre_completo_cliente().trim());
			utilidadesventas.setnombre_tipo_factura(utilidadesventas.getnombre_tipo_factura().trim());
			utilidadesventas.setnumero_documento(utilidadesventas.getnumero_documento().trim());
			utilidadesventas.settipo(utilidadesventas.gettipo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesUtilidadesVentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(UtilidadesVentasConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(UtilidadesVentasConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<UtilidadesVentas> utilidadesventass,UtilidadesVentas utilidadesventas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(UtilidadesVentas utilidadesventasAux: utilidadesventass) {
			if((utilidadesventasAux.getId()==null && utilidadesventas.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(utilidadesventasAux.getId()!=null && utilidadesventas.getId()!=null){
				if(utilidadesventasAux.getId().equals(utilidadesventas.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaUtilidadesVentas(List<UtilidadesVentas> utilidadesventass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ventaTotal=0.0;
		Double costoTotal=0.0;
		Double utilidadTotal=0.0;
		Double porcentajeTotal=0.0;
	
		for(UtilidadesVentas utilidadesventas: utilidadesventass) {			
			ventaTotal+=utilidadesventas.getventa();
			costoTotal+=utilidadesventas.getcosto();
			utilidadTotal+=utilidadesventas.getutilidad();
			porcentajeTotal+=utilidadesventas.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadesVentasConstantesFunciones.VENTA);
		datoGeneral.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_VENTA);
		datoGeneral.setdValorDouble(ventaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadesVentasConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadesVentasConstantesFunciones.UTILIDAD);
		datoGeneral.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_UTILIDAD);
		datoGeneral.setdValorDouble(utilidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadesVentasConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(UtilidadesVentasConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
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