













/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.ProformaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
//import com.bydan.erp.facturacion.business.interfaces.ProformaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ProformaLogicAdditional extends ProformaLogic { // implements ProformaAdditionable{
	
	public  ProformaLogicAdditional(Connexion connexion)throws Exception {
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


	public static Boolean validarSaveRelaciones(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_20
		Boolean validado=true;

		return validado;	
	}


	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}

	//CONTROL_INICIO
	public  ProformaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProformaToSave(Proforma proforma,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProformaToSave(Proforma proforma,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProformaToSaveAfter(Proforma proforma,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProformaToSaves(List<Proforma> proformas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProformaToSaves(List<Proforma> proformas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProformaToSavesAfter(List<Proforma> proformas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProformaToGet(Proforma proforma,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProformaToGets(List<Proforma> proformas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProformaToSave(Proforma proforma,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProformaToGet(Proforma proforma,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProformaActions(String sTipoJsonResponse,JSONObject jsonObjectProforma,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProformaDataTable(String sTipoJsonResponse,Proforma proforma,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProformasDataTable(String sTipoJsonResponse,List<Proforma> proformas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProformaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProformasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProformasColumns;
	}
	
	public static void updateJSONArrayProformaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProforma,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosProforma(Proforma proforma,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		proforma.setnumero_pre_impreso(proforma.getnumero_pre_impreso().trim());
		proforma.setdireccion(proforma.getdireccion().trim());
		proforma.setruc(proforma.getruc().trim());
		proforma.settelefono(proforma.gettelefono().trim());
		proforma.setdescripcion(proforma.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProformas(List<Proforma> proformas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Proforma proforma: proformas) {
			proforma.setnumero_pre_impreso(proforma.getnumero_pre_impreso().trim());
			proforma.setdireccion(proforma.getdireccion().trim());
			proforma.setruc(proforma.getruc().trim());
			proforma.settelefono(proforma.gettelefono().trim());
			proforma.setdescripcion(proforma.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProforma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ProformaConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ProformaConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(ProformaConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(ProformaConstantesFunciones.IDPERIODO);
		arrColumnasGlobales.add(ProformaConstantesFunciones.IDUSUARIO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Proforma> proformas,Proforma proforma,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Proforma proformaAux: proformas) {
			if((proformaAux.getId()==null && proforma.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(proformaAux.getId()!=null && proforma.getId()!=null){
				if(proformaAux.getId().equals(proforma.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProforma(List<Proforma> proformas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double subtotalTotal=0.0;
		Double ivaTotal=0.0;
		Double descuento_porcentajeTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double fleteTotal=0.0;
		Double otroTotal=0.0;
		Double iceTotal=0.0;
		Double financiamientoTotal=0.0;
		Double totalTotal=0.0;
		Double total_con_ivaTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double monto_retencionTotal=0.0;
		Double cotizacionTotal=0.0;
	
		for(Proforma proforma: proformas) {			
			subtotalTotal+=proforma.getsubtotal();
			ivaTotal+=proforma.getiva();
			descuento_porcentajeTotal+=proforma.getdescuento_porcentaje();
			descuento_valorTotal+=proforma.getdescuento_valor();
			fleteTotal+=proforma.getflete();
			otroTotal+=proforma.getotros_cargos();
			iceTotal+=proforma.getice();
			financiamientoTotal+=proforma.getfinanciamiento();
			totalTotal+=proforma.gettotal();
			total_con_ivaTotal+=proforma.getmonto_con_iva();
			total_sin_ivaTotal+=proforma.getmonto_sin_iva();
			monto_retencionTotal+=proforma.getmonto_retencion();
			cotizacionTotal+=proforma.getcotizacion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.DESCUENTOPORCENTAJE);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_DESCUENTOPORCENTAJE);
		datoGeneral.setdValorDouble(descuento_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.OTROSCARGOS);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_OTROSCARGOS);
		datoGeneral.setdValorDouble(otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.MONTOCONIVA);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_MONTOCONIVA);
		datoGeneral.setdValorDouble(total_con_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.MONTOSINIVA);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_MONTOSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.MONTORETENCION);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_MONTORETENCION);
		datoGeneral.setdValorDouble(monto_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProformaConstantesFunciones.COTIZACION);
		datoGeneral.setsDescripcion(ProformaConstantesFunciones.LABEL_COTIZACION);
		datoGeneral.setdValorDouble(cotizacionTotal);
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