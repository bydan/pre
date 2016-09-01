










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
import com.bydan.erp.facturacion.util.report.FacturasDescuentosLineasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;
////import com.bydan.erp.facturacion.business.interfaces.FacturasDescuentosLineasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class FacturasDescuentosLineasLogicAdditional extends FacturasDescuentosLineasLogic{		
	
	public  FacturasDescuentosLineasLogicAdditional(Connexion connexion)throws Exception {
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
	public  FacturasDescuentosLineasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkFacturasDescuentosLineasToSave(FacturasDescuentosLineas facturasdescuentoslineas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkFacturasDescuentosLineasToSave(FacturasDescuentosLineas facturasdescuentoslineas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkFacturasDescuentosLineasToSaveAfter(FacturasDescuentosLineas facturasdescuentoslineas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkFacturasDescuentosLineasToSaves(List<FacturasDescuentosLineas> facturasdescuentoslineass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkFacturasDescuentosLineasToSaves(List<FacturasDescuentosLineas> facturasdescuentoslineass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkFacturasDescuentosLineasToSavesAfter(List<FacturasDescuentosLineas> facturasdescuentoslineass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkFacturasDescuentosLineasToGet(FacturasDescuentosLineas facturasdescuentoslineas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkFacturasDescuentosLineasToGets(List<FacturasDescuentosLineas> facturasdescuentoslineass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateFacturasDescuentosLineasToSave(FacturasDescuentosLineas facturasdescuentoslineas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateFacturasDescuentosLineasToGet(FacturasDescuentosLineas facturasdescuentoslineas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectFacturasDescuentosLineasActions(String sTipoJsonResponse,JSONObject jsonObjectFacturasDescuentosLineas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonFacturasDescuentosLineasDataTable(String sTipoJsonResponse,FacturasDescuentosLineas facturasdescuentoslineas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonFacturasDescuentosLineassDataTable(String sTipoJsonResponse,List<FacturasDescuentosLineas> facturasdescuentoslineass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayFacturasDescuentosLineasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayFacturasDescuentosLineassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayFacturasDescuentosLineassColumns;
	}
	
	public static void updateJSONArrayFacturasDescuentosLineasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectFacturasDescuentosLineas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosFacturasDescuentosLineas(FacturasDescuentosLineas facturasdescuentoslineas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturasdescuentoslineas.setnombre(facturasdescuentoslineas.getnombre().trim());
		facturasdescuentoslineas.setnombre_completo_cliente(facturasdescuentoslineas.getnombre_completo_cliente().trim());
		facturasdescuentoslineas.setnombre_tipo_factura(facturasdescuentoslineas.getnombre_tipo_factura().trim());
		facturasdescuentoslineas.setnumero_pre_impreso(facturasdescuentoslineas.getnumero_pre_impreso().trim());
	}
	
	public static void quitarEspaciosFacturasDescuentosLineass(List<FacturasDescuentosLineas> facturasdescuentoslineass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturasDescuentosLineas facturasdescuentoslineas: facturasdescuentoslineass) {
			facturasdescuentoslineas.setnombre(facturasdescuentoslineas.getnombre().trim());
			facturasdescuentoslineas.setnombre_completo_cliente(facturasdescuentoslineas.getnombre_completo_cliente().trim());
			facturasdescuentoslineas.setnombre_tipo_factura(facturasdescuentoslineas.getnombre_tipo_factura().trim());
			facturasdescuentoslineas.setnumero_pre_impreso(facturasdescuentoslineas.getnumero_pre_impreso().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturasDescuentosLineas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(FacturasDescuentosLineasConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(FacturasDescuentosLineasConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturasDescuentosLineas> facturasdescuentoslineass,FacturasDescuentosLineas facturasdescuentoslineas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturasDescuentosLineas facturasdescuentoslineasAux: facturasdescuentoslineass) {
			if((facturasdescuentoslineasAux.getId()==null && facturasdescuentoslineas.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(facturasdescuentoslineasAux.getId()!=null && facturasdescuentoslineas.getId()!=null){
				if(facturasdescuentoslineasAux.getId().equals(facturasdescuentoslineas.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturasDescuentosLineas(List<FacturasDescuentosLineas> facturasdescuentoslineass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_descuentoTotal=0.0;
		Double total_otroTotal=0.0;
		Double sub_totalTotal=0.0;
		Double totalTotal=0.0;
		Double ivaTotal=0.0;
	
		for(FacturasDescuentosLineas facturasdescuentoslineas: facturasdescuentoslineass) {			
			total_descuentoTotal+=facturasdescuentoslineas.gettotal_descuento();
			total_otroTotal+=facturasdescuentoslineas.gettotal_otro();
			sub_totalTotal+=facturasdescuentoslineas.getsub_total();
			totalTotal+=facturasdescuentoslineas.gettotal();
			ivaTotal+=facturasdescuentoslineas.getiva();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasDescuentosLineasConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasDescuentosLineasConstantesFunciones.TOTALOTRO);
		datoGeneral.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_TOTALOTRO);
		datoGeneral.setdValorDouble(total_otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasDescuentosLineasConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasDescuentosLineasConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasDescuentosLineasConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
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