












/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.inventario.business.logic;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.io.InputStream;
import java.util.Scanner;
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
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.inventario.util.ProductoConstantesFunciones;
import com.bydan.erp.inventario.util.ProductoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ProductoReturnGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.business.entity.*;
//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ProductoLogicAdditional extends ProductoLogic { // implements ProductoAdditionable{
	
	public  ProductoLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19
			ProductoLogic productoLogic=(ProductoLogic)generalEntityLogic;
			ProductoParameterReturnGeneral productoReturnGeneral=(ProductoParameterReturnGeneral)generalEntityReturnGeneral;
			
			ParametroInventarioDefecto parametroInventarioDefecto=new ParametroInventarioDefecto();
			ParametroInventarioDefectoLogic parametroInventarioDefectoLogic=new ParametroInventarioDefectoLogic();						
			
			parametroInventarioDefectoLogic.setConnexion(generalEntityLogic.getConnexion());
			
			
			String sFinalQuery="";
			
			if(controlTipo.equals(ControlTipo.FORM) && eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW)) {
				sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_sucursal="+parametroGeneralUsuario.getid_sucursal();
				
				parametroInventarioDefectoLogic.getEntity(sFinalQuery);
				
				parametroInventarioDefecto=parametroInventarioDefectoLogic.getParametroInventarioDefecto();
				
				if(parametroInventarioDefecto!=null && parametroInventarioDefecto.getId()>0) {
					productoReturnGeneral.getProducto().setid_tipo_producto(parametroInventarioDefecto.getid_tipo_producto());
					productoReturnGeneral.getProducto().setid_tipo_producto_servicio(parametroInventarioDefecto.getid_tipo_producto_servicio());
					productoReturnGeneral.getProducto().setid_tipo_producto_servicio_inven(parametroInventarioDefecto.getid_tipo_producto_servicio_inven());
					productoReturnGeneral.getProducto().setid_tipo_costeo(parametroInventarioDefecto.getid_tipo_costeo());
					
					productoReturnGeneral.getProducto().setid_color_producto(parametroInventarioDefecto.getid_color_producto());
					productoReturnGeneral.getProducto().setid_clase_producto(parametroInventarioDefecto.getid_clase_producto());
					productoReturnGeneral.getProducto().setid_efecto_producto(parametroInventarioDefecto.getid_efecto_producto());
					productoReturnGeneral.getProducto().setid_marca_producto(parametroInventarioDefecto.getid_marca_producto());
					productoReturnGeneral.getProducto().setid_modelo_producto(parametroInventarioDefecto.getid_modelo_producto());
					productoReturnGeneral.getProducto().setid_material_producto(parametroInventarioDefecto.getid_material_producto());
					productoReturnGeneral.getProducto().setid_segmento_producto(parametroInventarioDefecto.getid_segmento_producto());
					productoReturnGeneral.getProducto().setid_talla_producto(parametroInventarioDefecto.getid_talla_producto());
					
					
					/*
					productoReturnGeneral.getProducto().setid_grupo_producto(parametroInventarioDefecto.getid_grupo_producto());										
					productoReturnGeneral.getProducto().setid_pais(parametroInventarioDefecto.getid_pais());
					productoReturnGeneral.getProducto().setid_ciudad(parametroInventarioDefecto.getid_ciudad());					
					productoReturnGeneral.getProducto().setid_calidad_producto(parametroInventarioDefecto.getid_calidad_producto());																				
					productoReturnGeneral.getProducto().setid_tipo_identificacion(parametroInventarioDefecto.getid_tipo_identificacion());
					productoReturnGeneral.getProducto().setid_pais_nacionalidad(parametroInventarioDefecto.getid_pais_nacionalidad());
					productoReturnGeneral.getProducto().setid_estado_civil(parametroInventarioDefecto.getid_estado_civil());
					*/
				} else {
					throw new Exception("DEBE CONFIGURAR PARAMETRO DEFECTOS");
				}
			}

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
	public  ProductoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProductoToSave(Producto producto,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProductoToSave(Producto producto,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProductoToSaveAfter(Producto producto,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProductoToSaves(List<Producto> productos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProductoToSaves(List<Producto> productos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProductoToSavesAfter(List<Producto> productos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProductoToGet(Producto producto,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProductoToGets(List<Producto> productos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProductoToSave(Producto producto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProductoToGet(Producto producto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProductoActions(String sTipoJsonResponse,JSONObject jsonObjectProducto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProductoDataTable(String sTipoJsonResponse,Producto producto,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProductosDataTable(String sTipoJsonResponse,List<Producto> productos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProductoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProductosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProductosColumns;
	}
	
	public static void updateJSONArrayProductoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProducto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<Producto> productos) throws Exception  {
		//CONTROL_16
		Boolean esProcesado=true;
		
		try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
		
			this.connexion.commit();
			
		} catch(Exception e) {
			this.connexion.rollback();			
			
			//Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		this.connexion.close();			
		}
		
		return esProcesado;
	}
	
	
	
	//CONTROL_FUNCION1
	
	
	
	
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