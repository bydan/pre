










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
import com.bydan.erp.facturacion.util.report.VentasResumidasMontosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;
////import com.bydan.erp.facturacion.business.interfaces.VentasResumidasMontosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class VentasResumidasMontosLogicAdditional extends VentasResumidasMontosLogic{		
	
	public  VentasResumidasMontosLogicAdditional(Connexion connexion)throws Exception {
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
	public  VentasResumidasMontosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkVentasResumidasMontosToSave(VentasResumidasMontos ventasresumidasmontos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkVentasResumidasMontosToSave(VentasResumidasMontos ventasresumidasmontos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkVentasResumidasMontosToSaveAfter(VentasResumidasMontos ventasresumidasmontos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkVentasResumidasMontosToSaves(List<VentasResumidasMontos> ventasresumidasmontoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkVentasResumidasMontosToSaves(List<VentasResumidasMontos> ventasresumidasmontoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkVentasResumidasMontosToSavesAfter(List<VentasResumidasMontos> ventasresumidasmontoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkVentasResumidasMontosToGet(VentasResumidasMontos ventasresumidasmontos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkVentasResumidasMontosToGets(List<VentasResumidasMontos> ventasresumidasmontoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateVentasResumidasMontosToSave(VentasResumidasMontos ventasresumidasmontos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateVentasResumidasMontosToGet(VentasResumidasMontos ventasresumidasmontos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectVentasResumidasMontosActions(String sTipoJsonResponse,JSONObject jsonObjectVentasResumidasMontos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonVentasResumidasMontosDataTable(String sTipoJsonResponse,VentasResumidasMontos ventasresumidasmontos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonVentasResumidasMontossDataTable(String sTipoJsonResponse,List<VentasResumidasMontos> ventasresumidasmontoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayVentasResumidasMontosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayVentasResumidasMontossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayVentasResumidasMontossColumns;
	}
	
	public static void updateJSONArrayVentasResumidasMontosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectVentasResumidasMontos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosVentasResumidasMontos(VentasResumidasMontos ventasresumidasmontos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventasresumidasmontos.setnombre_completo(ventasresumidasmontos.getnombre_completo().trim());
		ventasresumidasmontos.setnombre_vendedor(ventasresumidasmontos.getnombre_vendedor().trim());
		ventasresumidasmontos.setnombre_tipo_factura(ventasresumidasmontos.getnombre_tipo_factura().trim());
		ventasresumidasmontos.setnumero_pre_impreso(ventasresumidasmontos.getnumero_pre_impreso().trim());
		ventasresumidasmontos.setdescripcion(ventasresumidasmontos.getdescripcion().trim());
	}
	
	public static void quitarEspaciosVentasResumidasMontoss(List<VentasResumidasMontos> ventasresumidasmontoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasResumidasMontos ventasresumidasmontos: ventasresumidasmontoss) {
			ventasresumidasmontos.setnombre_completo(ventasresumidasmontos.getnombre_completo().trim());
			ventasresumidasmontos.setnombre_vendedor(ventasresumidasmontos.getnombre_vendedor().trim());
			ventasresumidasmontos.setnombre_tipo_factura(ventasresumidasmontos.getnombre_tipo_factura().trim());
			ventasresumidasmontos.setnumero_pre_impreso(ventasresumidasmontos.getnumero_pre_impreso().trim());
			ventasresumidasmontos.setdescripcion(ventasresumidasmontos.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasResumidasMontos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(VentasResumidasMontosConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(VentasResumidasMontosConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasResumidasMontos> ventasresumidasmontoss,VentasResumidasMontos ventasresumidasmontos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasResumidasMontos ventasresumidasmontosAux: ventasresumidasmontoss) {
			if((ventasresumidasmontosAux.getId()==null && ventasresumidasmontos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(ventasresumidasmontosAux.getId()!=null && ventasresumidasmontos.getId()!=null){
				if(ventasresumidasmontosAux.getId().equals(ventasresumidasmontos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasResumidasMontos(List<VentasResumidasMontos> ventasresumidasmontoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_ivaTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double total_descuentoTotal=0.0;
		Double total_otroTotal=0.0;
		Double sub_totalTotal=0.0;
		Double totalTotal=0.0;
		Double ivaTotal=0.0;
	
		for(VentasResumidasMontos ventasresumidasmontos: ventasresumidasmontoss) {			
			total_ivaTotal+=ventasresumidasmontos.gettotal_iva();
			total_sin_ivaTotal+=ventasresumidasmontos.gettotal_sin_iva();
			total_descuentoTotal+=ventasresumidasmontos.gettotal_descuento();
			total_otroTotal+=ventasresumidasmontos.gettotal_otro();
			sub_totalTotal+=ventasresumidasmontos.getsub_total();
			totalTotal+=ventasresumidasmontos.gettotal();
			ivaTotal+=ventasresumidasmontos.getiva();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidasMontosConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidasMontosConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidasMontosConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidasMontosConstantesFunciones.TOTALOTRO);
		datoGeneral.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_TOTALOTRO);
		datoGeneral.setdValorDouble(total_otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidasMontosConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidasMontosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidasMontosConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_IVA);
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