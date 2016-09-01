














/*
* ============================================================================
* GNU Lesser General Public License
* ============================================================================
*
* BYDAN - Free Java BYDAN library.
* Copyright (C) 2008 
* 
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.
* 
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* Lesser General Public License for more details.
* 
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
* 
* BYDAN Corporation
*/
package com.bydan.erp.inventario.business.logic;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;


import com.bydan.framework.erp.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.inventario.util.PrecioConstantesFunciones;
import com.bydan.erp.inventario.util.PrecioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.PrecioReturnGeneral;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.inventario.business.entity.*;
//import com.bydan.erp.inventario.business.interfaces.PrecioAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class PrecioLogicAdditional extends PrecioLogic { // implements PrecioAdditionable{
	public  PrecioLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19
			PrecioLogic precioLogic=(PrecioLogic)generalEntityLogic;
			PrecioParameterReturnGeneral precioReturnGeneral=(PrecioParameterReturnGeneral)generalEntityReturnGeneral;
			
			ParametroInventarioDefecto parametroInventarioDefecto=new ParametroInventarioDefecto();
			ParametroInventarioDefectoLogic parametroInventarioDefectoLogic=new ParametroInventarioDefectoLogic();						
			
			parametroInventarioDefectoLogic.setConnexion(generalEntityLogic.getConnexion());
			
			
			String sFinalQuery="";
			
			if(controlTipo.equals(ControlTipo.FORM) && eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW)) {
				sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_sucursal="+parametroGeneralUsuario.getid_sucursal();
				
				parametroInventarioDefectoLogic.getEntity(sFinalQuery);
				
				parametroInventarioDefecto=parametroInventarioDefectoLogic.getParametroInventarioDefecto();
				
				if(parametroInventarioDefecto!=null && parametroInventarioDefecto.getId()>0) {
					precioReturnGeneral.getPrecio().setid_rango_unidad_venta(parametroInventarioDefecto.getid_rango_unidad_venta());
					
					/*
					precioReturnGeneral.getPrecio().setid_grupo_precio(parametroInventarioDefecto.getid_grupo_precio());										
					precioReturnGeneral.getPrecio().setid_pais(parametroInventarioDefecto.getid_pais());
					precioReturnGeneral.getPrecio().setid_ciudad(parametroInventarioDefecto.getid_ciudad());					
					precioReturnGeneral.getPrecio().setid_calidad_precio(parametroInventarioDefecto.getid_calidad_precio());																				
					precioReturnGeneral.getPrecio().setid_tipo_identificacion(parametroInventarioDefecto.getid_tipo_identificacion());
					precioReturnGeneral.getPrecio().setid_pais_nacionalidad(parametroInventarioDefecto.getid_pais_nacionalidad());
					precioReturnGeneral.getPrecio().setid_estado_civil(parametroInventarioDefecto.getid_estado_civil());
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
	public  PrecioLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkPrecioToSave(Precio precio,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkPrecioToSave(Precio precio,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) throws SQLException, Exception {	
		//CONTROL_2
		
		PrecioLogicAdditional.actualizarLineasPrecio(connexion,precio);
	}
	
	public static void checkPrecioToSaveAfter(Precio precio,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkPrecioToSaves(List<Precio> precios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkPrecioToSaves(List<Precio> precios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception {	
		//CONTROL_5
		for(Precio precio:precios) {
			PrecioLogicAdditional.actualizarLineasPrecio(connexion,precio);
		}
	}
	
	public static void checkPrecioToSavesAfter(List<Precio> precios,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkPrecioToGet(Precio precio,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkPrecioToGets(List<Precio> precios,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updatePrecioToSave(Precio precio,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updatePrecioToGet(Precio precio,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectPrecioActions(String sTipoJsonResponse,JSONObject jsonObjectPrecio,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonPrecioDataTable(String sTipoJsonResponse,Precio precio,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonPreciosDataTable(String sTipoJsonResponse,List<Precio> precios,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayPrecioColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayPreciosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayPreciosColumns;
	}
	
	public static void updateJSONArrayPrecioActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectPrecio,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosPrecio(Precio precio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosPrecios(List<Precio> precios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Precio precio: precios) {
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPrecio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PrecioConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(PrecioConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
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
	
	public static void actualizarLineasPrecio(Connexion connexion,Precio precio) throws Exception {
		ProductoLogic productoLogic=new ProductoLogic();
		Producto producto=null;
		productoLogic.setConnexion(connexion);
		
		if(!precio.getIsDeleted()) {
			productoLogic.getEntity(precio.getid_producto());
			producto=productoLogic.getProducto();
					
			if(producto!=null && producto.getId()>0) {
				precio.setid_linea(producto.getid_linea());
				precio.setid_linea_grupo(producto.getid_linea_grupo());
				precio.setid_linea_categoria(producto.getid_linea_categoria());
				precio.setid_linea_marca(producto.getid_linea_marca());
			}	
		}
	}
}