/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.contabilidad.business.logic;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.util.Funciones;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.contabilidad.util.FacturaProveedorConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
//import com.bydan.erp.contabilidad.business.interfaces.FacturaProveedorAdditionable;
import com.bydan.erp.seguridad.business.entity.Modulo;
import com.bydan.erp.seguridad.business.entity.Opcion;
import com.bydan.erp.seguridad.business.entity.ParametroGeneralUsuario;
import com.bydan.erp.seguridad.business.entity.Usuario;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
final public class FacturaProveedorLogicAdditional extends FacturaProveedorLogic { // implements FacturaProveedorAdditionable{		
	
	//CONTROL_INICIO
	public  FacturaProveedorLogicAdditional()throws Exception {
		super();
    }
	
	public static void updateRelacionesToSave(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_21
	}


	public static void updateRelacionesToSaveAfter(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_22
	}
	
	public static Boolean validarSaveRelaciones(GeneralEntity generalEntity,GeneralEntityLogic generalEntityLogic) {
		//CONTROL_20
		Boolean validado=true;

		return validado;	
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

		
	public static void checkFacturaProveedorToSave(FacturaProveedor facturaproveedor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkFacturaProveedorToSave(FacturaProveedor facturaproveedor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkFacturaProveedorToSaveAfter(FacturaProveedor facturaproveedor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkFacturaProveedorToSaves(List<FacturaProveedor> facturaproveedors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkFacturaProveedorToSaves(List<FacturaProveedor> facturaproveedors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkFacturaProveedorToSavesAfter(List<FacturaProveedor> facturaproveedors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkFacturaProveedorToGet(FacturaProveedor facturaproveedor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkFacturaProveedorToGets(List<FacturaProveedor> facturaproveedors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateFacturaProveedorToSave(FacturaProveedor facturaproveedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateFacturaProveedorToGet(FacturaProveedor facturaproveedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectFacturaProveedorActions(String sTipoJsonResponse,JSONObject jsonObjectFacturaProveedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonFacturaProveedorDataTable(String sTipoJsonResponse,FacturaProveedor facturaproveedor,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonFacturaProveedorsDataTable(String sTipoJsonResponse,List<FacturaProveedor> facturaproveedors,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayFacturaProveedorColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayFacturaProveedorsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayFacturaProveedorsColumns;
	}
	
	public static void updateJSONArrayFacturaProveedorActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectFacturaProveedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosFacturaProveedor(FacturaProveedor facturaproveedor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturaproveedor.setnumero_factura(facturaproveedor.getnumero_factura().trim());
		facturaproveedor.setdetalle(facturaproveedor.getdetalle().trim());
		facturaproveedor.setnumero_retencion(facturaproveedor.getnumero_retencion().trim());
		facturaproveedor.setnumero_serie(facturaproveedor.getnumero_serie().trim());
		facturaproveedor.setnumero_autorizacion(facturaproveedor.getnumero_autorizacion().trim());
		facturaproveedor.setnumero_mayor(facturaproveedor.getnumero_mayor().trim());
		facturaproveedor.setcodigo_asiento(facturaproveedor.getcodigo_asiento().trim());
		facturaproveedor.setanexo_numero_autorizacion(facturaproveedor.getanexo_numero_autorizacion().trim());
		facturaproveedor.setanexo_numeso_serie(facturaproveedor.getanexo_numeso_serie().trim());
		facturaproveedor.setgasto_nombre(facturaproveedor.getgasto_nombre().trim());
		facturaproveedor.setruc(facturaproveedor.getruc().trim());
		facturaproveedor.setdescripcion(facturaproveedor.getdescripcion().trim());
	}
	
	public static void quitarEspaciosFacturaProveedors(List<FacturaProveedor> facturaproveedors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturaProveedor facturaproveedor: facturaproveedors) {
			facturaproveedor.setnumero_factura(facturaproveedor.getnumero_factura().trim());
			facturaproveedor.setdetalle(facturaproveedor.getdetalle().trim());
			facturaproveedor.setnumero_retencion(facturaproveedor.getnumero_retencion().trim());
			facturaproveedor.setnumero_serie(facturaproveedor.getnumero_serie().trim());
			facturaproveedor.setnumero_autorizacion(facturaproveedor.getnumero_autorizacion().trim());
			facturaproveedor.setnumero_mayor(facturaproveedor.getnumero_mayor().trim());
			facturaproveedor.setcodigo_asiento(facturaproveedor.getcodigo_asiento().trim());
			facturaproveedor.setanexo_numero_autorizacion(facturaproveedor.getanexo_numero_autorizacion().trim());
			facturaproveedor.setanexo_numeso_serie(facturaproveedor.getanexo_numeso_serie().trim());
			facturaproveedor.setgasto_nombre(facturaproveedor.getgasto_nombre().trim());
			facturaproveedor.setruc(facturaproveedor.getruc().trim());
			facturaproveedor.setdescripcion(facturaproveedor.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturaProveedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(FacturaProveedorConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(FacturaProveedorConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(FacturaProveedorConstantesFunciones.IDMODULO);
		arrColumnasGlobales.add(FacturaProveedorConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(FacturaProveedorConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturaProveedor> facturaproveedors,FacturaProveedor facturaproveedor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturaProveedor facturaproveedorAux: facturaproveedors) {
			if((facturaproveedorAux.getId()==null && facturaproveedor.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(facturaproveedorAux.getId()!=null && facturaproveedor.getId()!=null){
				if(facturaproveedorAux.getId().equals(facturaproveedor.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturaProveedor(List<FacturaProveedor> facturaproveedors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_bienes12Total=0.0;
		Double valor_bienes0Total=0.0;
		Double bienes_iceTotal=0.0;
		Double bienes_ivaTotal=0.0;
		Double valor_servicios12Total=0.0;
		Double valor_servicios0Total=0.0;
		Double servicios_iceTotal=0.0;
		Double servicios_ivaTotal=0.0;
		Double total_valor12Total=0.0;
		Double total_valor0Total=0.0;
		Double total_iceTotal=0.0;
		Double total_ivaTotal=0.0;
		Double iva_porcentajeTotal=0.0;
		Double totalTotal=0.0;
		Double ret_fuente1_porcentajeTotal=0.0;
		Double ret_fuente1_baseTotal=0.0;
		Double ret_fuente1_retenidoTotal=0.0;
		Double ret_fuente2_porcentajeTotal=0.0;
		Double ret_fuente2_baseTotal=0.0;
		Double ret_fuente2_retenidoTotal=0.0;
		Double ret_iva_bien_porcentajeTotal=0.0;
		Double ret_iva_bien_baseTotal=0.0;
		Double ret_iva_bien_retenidoTotal=0.0;
		Double ret_iva_servicio_porcentajeTotal=0.0;
		Double ret_iva_servicio_baseTotal=0.0;
		Double ret_iva_servicio_retenidoTotal=0.0;
		Double credito_fiscal_bienesTotal=0.0;
		Double credito_fiscal_serviciosTotal=0.0;
		Double gasto_valorTotal=0.0;
	
		for(FacturaProveedor facturaproveedor: facturaproveedors) {			
			valor_bienes12Total+=facturaproveedor.getvalor_bienes12();
			valor_bienes0Total+=facturaproveedor.getvalor_bienes0();
			bienes_iceTotal+=facturaproveedor.getbienes_ice();
			bienes_ivaTotal+=facturaproveedor.getbienes_iva();
			valor_servicios12Total+=facturaproveedor.getvalor_servicios12();
			valor_servicios0Total+=facturaproveedor.getvalor_servicios0();
			servicios_iceTotal+=facturaproveedor.getservicios_ice();
			servicios_ivaTotal+=facturaproveedor.getservicios_iva();
			total_valor12Total+=facturaproveedor.gettotal_valor12();
			total_valor0Total+=facturaproveedor.gettotal_valor0();
			total_iceTotal+=facturaproveedor.gettotal_ice();
			total_ivaTotal+=facturaproveedor.gettotal_iva();
			iva_porcentajeTotal+=facturaproveedor.getiva_porcentaje();
			totalTotal+=facturaproveedor.gettotal();
			ret_fuente1_porcentajeTotal+=facturaproveedor.getret_fuente1_porcentaje();
			ret_fuente1_baseTotal+=facturaproveedor.getret_fuente1_base();
			ret_fuente1_retenidoTotal+=facturaproveedor.getret_fuente1_retenido();
			ret_fuente2_porcentajeTotal+=facturaproveedor.getret_fuente2_porcentaje();
			ret_fuente2_baseTotal+=facturaproveedor.getret_fuente2_base();
			ret_fuente2_retenidoTotal+=facturaproveedor.getret_fuente2_retenido();
			ret_iva_bien_porcentajeTotal+=facturaproveedor.getret_iva_bien_porcentaje();
			ret_iva_bien_baseTotal+=facturaproveedor.getret_iva_bien_base();
			ret_iva_bien_retenidoTotal+=facturaproveedor.getret_iva_bien_retenido();
			ret_iva_servicio_porcentajeTotal+=facturaproveedor.getret_iva_servicio_porcentaje();
			ret_iva_servicio_baseTotal+=facturaproveedor.getret_iva_servicio_base();
			ret_iva_servicio_retenidoTotal+=facturaproveedor.getret_iva_servicio_retenido();
			gasto_valorTotal+=facturaproveedor.getgasto_valor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.VALORBIENES12);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_VALORBIENES12);
		datoGeneral.setdValorDouble(valor_bienes12Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.VALORBIENES0);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_VALORBIENES0);
		datoGeneral.setdValorDouble(valor_bienes0Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.BIENESICE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_BIENESICE);
		datoGeneral.setdValorDouble(bienes_iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.BIENESIVA);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_BIENESIVA);
		datoGeneral.setdValorDouble(bienes_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.VALORSERVICIOS12);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_VALORSERVICIOS12);
		datoGeneral.setdValorDouble(valor_servicios12Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.VALORSERVICIOS0);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_VALORSERVICIOS0);
		datoGeneral.setdValorDouble(valor_servicios0Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.SERVICIOSICE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_SERVICIOSICE);
		datoGeneral.setdValorDouble(servicios_iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.SERVICIOSIVA);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_SERVICIOSIVA);
		datoGeneral.setdValorDouble(servicios_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.TOTALVALOR12);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_TOTALVALOR12);
		datoGeneral.setdValorDouble(total_valor12Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.TOTALVALOR0);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_TOTALVALOR0);
		datoGeneral.setdValorDouble(total_valor0Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.TOTALICE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_TOTALICE);
		datoGeneral.setdValorDouble(total_iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.IVAPORCENTAJE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_IVAPORCENTAJE);
		datoGeneral.setdValorDouble(iva_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETFUENTE1PORCENTAJE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1PORCENTAJE);
		datoGeneral.setdValorDouble(ret_fuente1_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETFUENTE1BASE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1BASE);
		datoGeneral.setdValorDouble(ret_fuente1_baseTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETFUENTE1RETENIDO);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE1RETENIDO);
		datoGeneral.setdValorDouble(ret_fuente1_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETFUENTE2PORCENTAJE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2PORCENTAJE);
		datoGeneral.setdValorDouble(ret_fuente2_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETFUENTE2BASE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2BASE);
		datoGeneral.setdValorDouble(ret_fuente2_baseTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETFUENTE2RETENIDO);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETFUENTE2RETENIDO);
		datoGeneral.setdValorDouble(ret_fuente2_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETIVABIENPORCENTAJE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVABIENPORCENTAJE);
		datoGeneral.setdValorDouble(ret_iva_bien_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETIVABIENBASE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVABIENBASE);
		datoGeneral.setdValorDouble(ret_iva_bien_baseTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETIVABIENRETENIDO);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVABIENRETENIDO);
		datoGeneral.setdValorDouble(ret_iva_bien_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETIVASERVICIOPORCENTAJE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIOPORCENTAJE);
		datoGeneral.setdValorDouble(ret_iva_servicio_porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETIVASERVICIOBASE);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIOBASE);
		datoGeneral.setdValorDouble(ret_iva_servicio_baseTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.RETIVASERVICIORETENIDO);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_RETIVASERVICIORETENIDO);
		datoGeneral.setdValorDouble(ret_iva_servicio_retenidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
						
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturaProveedorConstantesFunciones.GASTOVALOR);
		datoGeneral.setsDescripcion(FacturaProveedorConstantesFunciones.LABEL_GASTOVALOR);
		datoGeneral.setdValorDouble(gasto_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	//PARA ACCIONES NORMALES
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {
			try {

				//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();


				return generalEntityReturnGeneral;

			} catch(Exception e) {
				Funciones.manageException(logger,e);
				throw e;

			} finally {

			}
	}
		
	//CONTROL_FUNCION2
}

