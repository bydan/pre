














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

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.contabilidad.util.DetalleFacturaProveedorConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
//import com.bydan.erp.contabilidad.business.interfaces.DetalleFacturaProveedorAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DetalleFacturaProveedorLogicAdditional extends DetalleFacturaProveedorLogic { // implements DetalleFacturaProveedorAdditionable{
	
	public  DetalleFacturaProveedorLogicAdditional(Connexion connexion)throws Exception {
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
	public  DetalleFacturaProveedorLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetalleFacturaProveedorToSave(DetalleFacturaProveedor detallefacturaproveedor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetalleFacturaProveedorToSave(DetalleFacturaProveedor detallefacturaproveedor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetalleFacturaProveedorToSaveAfter(DetalleFacturaProveedor detallefacturaproveedor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetalleFacturaProveedorToSaves(List<DetalleFacturaProveedor> detallefacturaproveedors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetalleFacturaProveedorToSaves(List<DetalleFacturaProveedor> detallefacturaproveedors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetalleFacturaProveedorToSavesAfter(List<DetalleFacturaProveedor> detallefacturaproveedors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetalleFacturaProveedorToGet(DetalleFacturaProveedor detallefacturaproveedor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetalleFacturaProveedorToGets(List<DetalleFacturaProveedor> detallefacturaproveedors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetalleFacturaProveedorToSave(DetalleFacturaProveedor detallefacturaproveedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetalleFacturaProveedorToGet(DetalleFacturaProveedor detallefacturaproveedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetalleFacturaProveedorActions(String sTipoJsonResponse,JSONObject jsonObjectDetalleFacturaProveedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetalleFacturaProveedorDataTable(String sTipoJsonResponse,DetalleFacturaProveedor detallefacturaproveedor,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetalleFacturaProveedorsDataTable(String sTipoJsonResponse,List<DetalleFacturaProveedor> detallefacturaproveedors,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetalleFacturaProveedorColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetalleFacturaProveedorsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetalleFacturaProveedorsColumns;
	}
	
	public static void updateJSONArrayDetalleFacturaProveedorActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetalleFacturaProveedor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetalleFacturaProveedor(DetalleFacturaProveedor detallefacturaproveedor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallefacturaproveedor.setnumero_comprobante(detallefacturaproveedor.getnumero_comprobante().trim());
		detallefacturaproveedor.setlote(detallefacturaproveedor.getlote().trim());
		detallefacturaproveedor.setdescripcion(detallefacturaproveedor.getdescripcion().trim());
		detallefacturaproveedor.setlote_cliente(detallefacturaproveedor.getlote_cliente().trim());
		detallefacturaproveedor.setserie(detallefacturaproveedor.getserie().trim());
	}
	
	public static void quitarEspaciosDetalleFacturaProveedors(List<DetalleFacturaProveedor> detallefacturaproveedors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleFacturaProveedor detallefacturaproveedor: detallefacturaproveedors) {
			detallefacturaproveedor.setnumero_comprobante(detallefacturaproveedor.getnumero_comprobante().trim());
			detallefacturaproveedor.setlote(detallefacturaproveedor.getlote().trim());
			detallefacturaproveedor.setdescripcion(detallefacturaproveedor.getdescripcion().trim());
			detallefacturaproveedor.setlote_cliente(detallefacturaproveedor.getlote_cliente().trim());
			detallefacturaproveedor.setserie(detallefacturaproveedor.getserie().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleFacturaProveedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetalleFacturaProveedorConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DetalleFacturaProveedorConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(DetalleFacturaProveedorConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(DetalleFacturaProveedorConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleFacturaProveedor> detallefacturaproveedors,DetalleFacturaProveedor detallefacturaproveedor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleFacturaProveedor detallefacturaproveedorAux: detallefacturaproveedors) {
			if((detallefacturaproveedorAux.getId()==null && detallefacturaproveedor.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(detallefacturaproveedorAux.getId()!=null && detallefacturaproveedor.getId()!=null){
				if(detallefacturaproveedorAux.getId().equals(detallefacturaproveedor.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleFacturaProveedor(List<DetalleFacturaProveedor> detallefacturaproveedors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double descuentoTotal=0.0;
		Double ivaTotal=0.0;
		Double costo_unitarioTotal=0.0;
		Double costo_totalTotal=0.0;
		Double iceTotal=0.0;
		Double descuento1Total=0.0;
		Double descuento2Total=0.0;
		Double precio_ventaTotal=0.0;
		Double disponibleTotal=0.0;
		Double ice_valorTotal=0.0;
	
		for(DetalleFacturaProveedor detallefacturaproveedor: detallefacturaproveedors) {			
			descuentoTotal+=detallefacturaproveedor.getdescuento();
			ivaTotal+=detallefacturaproveedor.getiva();
			costo_unitarioTotal+=detallefacturaproveedor.getcosto_unitario();
			costo_totalTotal+=detallefacturaproveedor.getcosto_total();
			iceTotal+=detallefacturaproveedor.getice();
			descuento1Total+=detallefacturaproveedor.getdescuento1();
			descuento2Total+=detallefacturaproveedor.getdescuento2();
			precio_ventaTotal+=detallefacturaproveedor.getprecio_venta();
			disponibleTotal+=detallefacturaproveedor.getdisponible();
			ice_valorTotal+=detallefacturaproveedor.getice_valor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.COSTOUNITARIO);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOUNITARIO);
		datoGeneral.setdValorDouble(costo_unitarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.DESCUENTO1);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO1);
		datoGeneral.setdValorDouble(descuento1Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.DESCUENTO2);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_DESCUENTO2);
		datoGeneral.setdValorDouble(descuento2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.PRECIOVENTA);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_PRECIOVENTA);
		datoGeneral.setdValorDouble(precio_ventaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.DISPONIBLE);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_DISPONIBLE);
		datoGeneral.setdValorDouble(disponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaProveedorConstantesFunciones.ICEVALOR);
		datoGeneral.setsDescripcion(DetalleFacturaProveedorConstantesFunciones.LABEL_ICEVALOR);
		datoGeneral.setdValorDouble(ice_valorTotal);
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