














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
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.facturacion.util.DetalleGuiaRemisionConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
//import com.bydan.erp.facturacion.business.interfaces.DetalleGuiaRemisionAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DetalleGuiaRemisionLogicAdditional extends DetalleGuiaRemisionLogic { // implements DetalleGuiaRemisionAdditionable{
	
	public  DetalleGuiaRemisionLogicAdditional(Connexion connexion)throws Exception {
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
	public  DetalleGuiaRemisionLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetalleGuiaRemisionToSave(DetalleGuiaRemision detalleguiaremision,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetalleGuiaRemisionToSave(DetalleGuiaRemision detalleguiaremision,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetalleGuiaRemisionToSaveAfter(DetalleGuiaRemision detalleguiaremision,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetalleGuiaRemisionToSaves(List<DetalleGuiaRemision> detalleguiaremisions,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetalleGuiaRemisionToSaves(List<DetalleGuiaRemision> detalleguiaremisions,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetalleGuiaRemisionToSavesAfter(List<DetalleGuiaRemision> detalleguiaremisions,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetalleGuiaRemisionToGet(DetalleGuiaRemision detalleguiaremision,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetalleGuiaRemisionToGets(List<DetalleGuiaRemision> detalleguiaremisions,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetalleGuiaRemisionToSave(DetalleGuiaRemision detalleguiaremision,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetalleGuiaRemisionToGet(DetalleGuiaRemision detalleguiaremision,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetalleGuiaRemisionActions(String sTipoJsonResponse,JSONObject jsonObjectDetalleGuiaRemision,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetalleGuiaRemisionDataTable(String sTipoJsonResponse,DetalleGuiaRemision detalleguiaremision,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetalleGuiaRemisionsDataTable(String sTipoJsonResponse,List<DetalleGuiaRemision> detalleguiaremisions,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetalleGuiaRemisionColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetalleGuiaRemisionsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetalleGuiaRemisionsColumns;
	}
	
	public static void updateJSONArrayDetalleGuiaRemisionActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetalleGuiaRemision,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetalleGuiaRemision(DetalleGuiaRemision detalleguiaremision,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleguiaremision.setlote(detalleguiaremision.getlote().trim());
		detalleguiaremision.setlote_cliente(detalleguiaremision.getlote_cliente().trim());
		detalleguiaremision.setorden_compra(detalleguiaremision.getorden_compra().trim());
		detalleguiaremision.setarea(detalleguiaremision.getarea().trim());
		detalleguiaremision.setmedidas(detalleguiaremision.getmedidas().trim());
		detalleguiaremision.setacabado(detalleguiaremision.getacabado().trim());
		detalleguiaremision.setacabado2(detalleguiaremision.getacabado2().trim());
	}
	
	public static void quitarEspaciosDetalleGuiaRemisions(List<DetalleGuiaRemision> detalleguiaremisions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleGuiaRemision detalleguiaremision: detalleguiaremisions) {
			detalleguiaremision.setlote(detalleguiaremision.getlote().trim());
			detalleguiaremision.setlote_cliente(detalleguiaremision.getlote_cliente().trim());
			detalleguiaremision.setorden_compra(detalleguiaremision.getorden_compra().trim());
			detalleguiaremision.setarea(detalleguiaremision.getarea().trim());
			detalleguiaremision.setmedidas(detalleguiaremision.getmedidas().trim());
			detalleguiaremision.setacabado(detalleguiaremision.getacabado().trim());
			detalleguiaremision.setacabado2(detalleguiaremision.getacabado2().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleGuiaRemision(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetalleGuiaRemisionConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DetalleGuiaRemisionConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(DetalleGuiaRemisionConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(DetalleGuiaRemisionConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleGuiaRemision> detalleguiaremisions,DetalleGuiaRemision detalleguiaremision,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleGuiaRemision detalleguiaremisionAux: detalleguiaremisions) {
			if((detalleguiaremisionAux.getId()==null && detalleguiaremision.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(detalleguiaremisionAux.getId()!=null && detalleguiaremision.getId()!=null){
				if(detalleguiaremisionAux.getId().equals(detalleguiaremision.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleGuiaRemision(List<DetalleGuiaRemision> detalleguiaremisions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
		Double precioTotal=0.0;
		Double porcentaje_descuentoTotal=0.0;
		Double descuentoTotal=0.0;
		Double descuento2Total=0.0;
		Double descuento3Total=0.0;
		Double porcentaje_ivaTotal=0.0;
		Double ivaTotal=0.0;
		Double total_descuentoTotal=0.0;
		Double total_impuestoTotal=0.0;
	
		for(DetalleGuiaRemision detalleguiaremision: detalleguiaremisions) {			
			montoTotal+=detalleguiaremision.getmonto();
			precioTotal+=detalleguiaremision.getprecio();
			porcentaje_descuentoTotal+=detalleguiaremision.getporcentaje_descuento();
			descuentoTotal+=detalleguiaremision.getdescuento();
			descuento2Total+=detalleguiaremision.getdescuento2();
			descuento3Total+=detalleguiaremision.getdescuento3();
			porcentaje_ivaTotal+=detalleguiaremision.getporcentaje_iva();
			ivaTotal+=detalleguiaremision.getiva();
			total_descuentoTotal+=detalleguiaremision.gettotal_descuento();
			total_impuestoTotal+=detalleguiaremision.gettotal_impuesto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.PORCENTAJEDESCUENTO);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
		datoGeneral.setdValorDouble(porcentaje_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.DESCUENTO2);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO2);
		datoGeneral.setdValorDouble(descuento2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.DESCUENTO3);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_DESCUENTO3);
		datoGeneral.setdValorDouble(descuento3Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.PORCENTAJEIVA);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_PORCENTAJEIVA);
		datoGeneral.setdValorDouble(porcentaje_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleGuiaRemisionConstantesFunciones.TOTALIMPUESTO);
		datoGeneral.setsDescripcion(DetalleGuiaRemisionConstantesFunciones.LABEL_TOTALIMPUESTO);
		datoGeneral.setdValorDouble(total_impuestoTotal);
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