










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
import com.bydan.erp.facturacion.util.report.ProductosPendientesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;
////import com.bydan.erp.facturacion.business.interfaces.ProductosPendientesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class ProductosPendientesLogicAdditional extends ProductosPendientesLogic{		
	
	public  ProductosPendientesLogicAdditional(Connexion connexion)throws Exception {
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
	public  ProductosPendientesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProductosPendientesToSave(ProductosPendientes productospendientes,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProductosPendientesToSave(ProductosPendientes productospendientes,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProductosPendientesToSaveAfter(ProductosPendientes productospendientes,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProductosPendientesToSaves(List<ProductosPendientes> productospendientess,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProductosPendientesToSaves(List<ProductosPendientes> productospendientess,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProductosPendientesToSavesAfter(List<ProductosPendientes> productospendientess,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProductosPendientesToGet(ProductosPendientes productospendientes,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProductosPendientesToGets(List<ProductosPendientes> productospendientess,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProductosPendientesToSave(ProductosPendientes productospendientes,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProductosPendientesToGet(ProductosPendientes productospendientes,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProductosPendientesActions(String sTipoJsonResponse,JSONObject jsonObjectProductosPendientes,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProductosPendientesDataTable(String sTipoJsonResponse,ProductosPendientes productospendientes,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProductosPendientessDataTable(String sTipoJsonResponse,List<ProductosPendientes> productospendientess,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProductosPendientesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProductosPendientessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProductosPendientessColumns;
	}
	
	public static void updateJSONArrayProductosPendientesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProductosPendientes,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosProductosPendientes(ProductosPendientes productospendientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productospendientes.setnombre_empresa(productospendientes.getnombre_empresa().trim());
		productospendientes.setruc_empresa(productospendientes.getruc_empresa().trim());
		productospendientes.setnombre_producto(productospendientes.getnombre_producto().trim());
		productospendientes.setnombre_unidad(productospendientes.getnombre_unidad().trim());
		productospendientes.setcodigo_producto(productospendientes.getcodigo_producto().trim());
	}
	
	public static void quitarEspaciosProductosPendientess(List<ProductosPendientes> productospendientess,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductosPendientes productospendientes: productospendientess) {
			productospendientes.setnombre_empresa(productospendientes.getnombre_empresa().trim());
			productospendientes.setruc_empresa(productospendientes.getruc_empresa().trim());
			productospendientes.setnombre_producto(productospendientes.getnombre_producto().trim());
			productospendientes.setnombre_unidad(productospendientes.getnombre_unidad().trim());
			productospendientes.setcodigo_producto(productospendientes.getcodigo_producto().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductosPendientes(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(ProductosPendientesConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductosPendientes> productospendientess,ProductosPendientes productospendientes,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductosPendientes productospendientesAux: productospendientess) {
			if((productospendientesAux.getId()==null && productospendientes.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(productospendientesAux.getId()!=null && productospendientes.getId()!=null){
				if(productospendientesAux.getId().equals(productospendientes.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductosPendientes(List<ProductosPendientes> productospendientess) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double totalTotal=0.0;
	
		for(ProductosPendientes productospendientes: productospendientess) {			
			precioTotal+=productospendientes.getprecio();
			totalTotal+=productospendientes.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosPendientesConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductosPendientesConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ProductosPendientesConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
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