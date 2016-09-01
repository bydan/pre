










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
import com.bydan.erp.inventario.util.report.ProductosServiciosDisponiblesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;
////import com.bydan.erp.inventario.business.interfaces.ProductosServiciosDisponiblesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ProductosServiciosDisponiblesLogicAdditional extends ProductosServiciosDisponiblesLogic{		
	
	public  ProductosServiciosDisponiblesLogicAdditional(Connexion connexion)throws Exception {
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
	public  ProductosServiciosDisponiblesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProductosServiciosDisponiblesToSave(ProductosServiciosDisponibles productosserviciosdisponibles,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProductosServiciosDisponiblesToSave(ProductosServiciosDisponibles productosserviciosdisponibles,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProductosServiciosDisponiblesToSaveAfter(ProductosServiciosDisponibles productosserviciosdisponibles,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProductosServiciosDisponiblesToSaves(List<ProductosServiciosDisponibles> productosserviciosdisponibless,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProductosServiciosDisponiblesToSaves(List<ProductosServiciosDisponibles> productosserviciosdisponibless,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProductosServiciosDisponiblesToSavesAfter(List<ProductosServiciosDisponibles> productosserviciosdisponibless,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProductosServiciosDisponiblesToGet(ProductosServiciosDisponibles productosserviciosdisponibles,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProductosServiciosDisponiblesToGets(List<ProductosServiciosDisponibles> productosserviciosdisponibless,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProductosServiciosDisponiblesToSave(ProductosServiciosDisponibles productosserviciosdisponibles,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProductosServiciosDisponiblesToGet(ProductosServiciosDisponibles productosserviciosdisponibles,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProductosServiciosDisponiblesActions(String sTipoJsonResponse,JSONObject jsonObjectProductosServiciosDisponibles,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProductosServiciosDisponiblesDataTable(String sTipoJsonResponse,ProductosServiciosDisponibles productosserviciosdisponibles,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProductosServiciosDisponiblessDataTable(String sTipoJsonResponse,List<ProductosServiciosDisponibles> productosserviciosdisponibless,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProductosServiciosDisponiblesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProductosServiciosDisponiblessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProductosServiciosDisponiblessColumns;
	}
	
	public static void updateJSONArrayProductosServiciosDisponiblesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProductosServiciosDisponibles,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosProductosServiciosDisponibles(ProductosServiciosDisponibles productosserviciosdisponibles,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productosserviciosdisponibles.setnombre_sucursal(productosserviciosdisponibles.getnombre_sucursal().trim());
		productosserviciosdisponibles.setnombre_linea(productosserviciosdisponibles.getnombre_linea().trim());
		productosserviciosdisponibles.setnombre_linea_grupo(productosserviciosdisponibles.getnombre_linea_grupo().trim());
		productosserviciosdisponibles.setnombre_linea_categoria(productosserviciosdisponibles.getnombre_linea_categoria().trim());
		productosserviciosdisponibles.setnombre_linea_marca(productosserviciosdisponibles.getnombre_linea_marca().trim());
		productosserviciosdisponibles.setcodigo(productosserviciosdisponibles.getcodigo().trim());
		productosserviciosdisponibles.setnombre(productosserviciosdisponibles.getnombre().trim());
		productosserviciosdisponibles.setnombre_tipo_producto_servicio(productosserviciosdisponibles.getnombre_tipo_producto_servicio().trim());
		productosserviciosdisponibles.setnombre_bodega(productosserviciosdisponibles.getnombre_bodega().trim());
		productosserviciosdisponibles.setnombre_unidad(productosserviciosdisponibles.getnombre_unidad().trim());
	}
	
	public static void quitarEspaciosProductosServiciosDisponibless(List<ProductosServiciosDisponibles> productosserviciosdisponibless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductosServiciosDisponibles productosserviciosdisponibles: productosserviciosdisponibless) {
			productosserviciosdisponibles.setnombre_sucursal(productosserviciosdisponibles.getnombre_sucursal().trim());
			productosserviciosdisponibles.setnombre_linea(productosserviciosdisponibles.getnombre_linea().trim());
			productosserviciosdisponibles.setnombre_linea_grupo(productosserviciosdisponibles.getnombre_linea_grupo().trim());
			productosserviciosdisponibles.setnombre_linea_categoria(productosserviciosdisponibles.getnombre_linea_categoria().trim());
			productosserviciosdisponibles.setnombre_linea_marca(productosserviciosdisponibles.getnombre_linea_marca().trim());
			productosserviciosdisponibles.setcodigo(productosserviciosdisponibles.getcodigo().trim());
			productosserviciosdisponibles.setnombre(productosserviciosdisponibles.getnombre().trim());
			productosserviciosdisponibles.setnombre_tipo_producto_servicio(productosserviciosdisponibles.getnombre_tipo_producto_servicio().trim());
			productosserviciosdisponibles.setnombre_bodega(productosserviciosdisponibles.getnombre_bodega().trim());
			productosserviciosdisponibles.setnombre_unidad(productosserviciosdisponibles.getnombre_unidad().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosServiciosDisponibles(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ProductosServiciosDisponiblesConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(ProductosServiciosDisponiblesConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductosServiciosDisponibles> productosserviciosdisponibless,ProductosServiciosDisponibles productosserviciosdisponibles,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductosServiciosDisponibles productosserviciosdisponiblesAux: productosserviciosdisponibless) {
			if((productosserviciosdisponiblesAux.getId()==null && productosserviciosdisponibles.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(productosserviciosdisponiblesAux.getId()!=null && productosserviciosdisponibles.getId()!=null){
				if(productosserviciosdisponiblesAux.getId().equals(productosserviciosdisponibles.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductosServiciosDisponibles(List<ProductosServiciosDisponibles> productosserviciosdisponibless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precio_compraTotal=0.0;
		Double precio_ventaTotal=0.0;
		Double costo_ultimoTotal=0.0;
	
		for(ProductosServiciosDisponibles productosserviciosdisponibles: productosserviciosdisponibless) {			
			precio_compraTotal+=productosserviciosdisponibles.getprecio_compra();
			precio_ventaTotal+=productosserviciosdisponibles.getprecio_venta();
			costo_ultimoTotal+=productosserviciosdisponibles.getcosto_ultimo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.PRECIOCOMPRA);
		datoGeneral.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_PRECIOCOMPRA);
		datoGeneral.setdValorDouble(precio_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.PRECIOVENTA);
		datoGeneral.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_PRECIOVENTA);
		datoGeneral.setdValorDouble(precio_ventaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosServiciosDisponiblesConstantesFunciones.COSTOULTIMO);
		datoGeneral.setsDescripcion(ProductosServiciosDisponiblesConstantesFunciones.LABEL_COSTOULTIMO);
		datoGeneral.setdValorDouble(costo_ultimoTotal);
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