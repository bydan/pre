














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.Constantes2;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.puntoventa.util.DetalleFacturaPuntoVentaConstantesFunciones;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.puntoventa.business.entity.*;
//import com.bydan.erp.puntoventa.business.interfaces.DetalleFacturaPuntoVentaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DetalleFacturaPuntoVentaLogicAdditional extends DetalleFacturaPuntoVentaLogic { // implements DetalleFacturaPuntoVentaAdditionable{
	public  DetalleFacturaPuntoVentaLogicAdditional(Connexion connexion)throws Exception {
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
	public  DetalleFacturaPuntoVentaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetalleFacturaPuntoVentaToSave(DetalleFacturaPuntoVenta detallefacturapuntoventa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetalleFacturaPuntoVentaToSave(DetalleFacturaPuntoVenta detallefacturapuntoventa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetalleFacturaPuntoVentaToSaveAfter(DetalleFacturaPuntoVenta detallefacturapuntoventa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetalleFacturaPuntoVentaToSaves(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetalleFacturaPuntoVentaToSaves(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetalleFacturaPuntoVentaToSavesAfter(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetalleFacturaPuntoVentaToGet(DetalleFacturaPuntoVenta detallefacturapuntoventa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetalleFacturaPuntoVentaToGets(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetalleFacturaPuntoVentaToSave(DetalleFacturaPuntoVenta detallefacturapuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetalleFacturaPuntoVentaToGet(DetalleFacturaPuntoVenta detallefacturapuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetalleFacturaPuntoVentaActions(String sTipoJsonResponse,JSONObject jsonObjectDetalleFacturaPuntoVenta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetalleFacturaPuntoVentaDataTable(String sTipoJsonResponse,DetalleFacturaPuntoVenta detallefacturapuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetalleFacturaPuntoVentasDataTable(String sTipoJsonResponse,List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetalleFacturaPuntoVentaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetalleFacturaPuntoVentasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetalleFacturaPuntoVentasColumns;
	}
	
	public static void updateJSONArrayDetalleFacturaPuntoVentaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetalleFacturaPuntoVenta,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetalleFacturaPuntoVenta(DetalleFacturaPuntoVenta detallefacturapuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallefacturapuntoventa.setserie(detallefacturapuntoventa.getserie().trim());
		detallefacturapuntoventa.setdescripcion(detallefacturapuntoventa.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetalleFacturaPuntoVentas(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleFacturaPuntoVenta detallefacturapuntoventa: detallefacturapuntoventas) {
			detallefacturapuntoventa.setserie(detallefacturapuntoventa.getserie().trim());
			detallefacturapuntoventa.setdescripcion(detallefacturapuntoventa.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleFacturaPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetalleFacturaPuntoVentaConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DetalleFacturaPuntoVentaConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas,DetalleFacturaPuntoVenta detallefacturapuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleFacturaPuntoVenta detallefacturapuntoventaAux: detallefacturapuntoventas) {
			if((detallefacturapuntoventaAux.getId()==null && detallefacturapuntoventa.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(detallefacturapuntoventaAux.getId()!=null && detallefacturapuntoventa.getId()!=null){
				if(detallefacturapuntoventaAux.getId().equals(detallefacturapuntoventa.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleFacturaPuntoVenta(List<DetalleFacturaPuntoVenta> detallefacturapuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double descuentoTotal=0.0;
		Double ivaTotal=0.0;
		Double iceTotal=0.0;
	
		for(DetalleFacturaPuntoVenta detallefacturapuntoventa: detallefacturapuntoventas) {			
			precioTotal+=detallefacturapuntoventa.getprecio();
			descuentoTotal+=detallefacturapuntoventa.getdescuento();
			ivaTotal+=detallefacturapuntoventa.getiva();
			iceTotal+=detallefacturapuntoventa.getice();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturaPuntoVentaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(DetalleFacturaPuntoVentaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
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