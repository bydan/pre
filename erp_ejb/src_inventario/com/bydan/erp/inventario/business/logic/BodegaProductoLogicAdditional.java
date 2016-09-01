














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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.erp.inventario.util.BodegaProductoConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
//import com.bydan.erp.inventario.business.interfaces.BodegaProductoAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class BodegaProductoLogicAdditional extends BodegaProductoLogic { // implements BodegaProductoAdditionable{
	public  BodegaProductoLogicAdditional(Connexion connexion)throws Exception {
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
	public  BodegaProductoLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkBodegaProductoToSave(BodegaProducto bodegaproducto,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkBodegaProductoToSave(BodegaProducto bodegaproducto,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkBodegaProductoToSaveAfter(BodegaProducto bodegaproducto,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkBodegaProductoToSaves(List<BodegaProducto> bodegaproductos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkBodegaProductoToSaves(List<BodegaProducto> bodegaproductos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkBodegaProductoToSavesAfter(List<BodegaProducto> bodegaproductos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkBodegaProductoToGet(BodegaProducto bodegaproducto,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkBodegaProductoToGets(List<BodegaProducto> bodegaproductos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateBodegaProductoToSave(BodegaProducto bodegaproducto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateBodegaProductoToGet(BodegaProducto bodegaproducto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectBodegaProductoActions(String sTipoJsonResponse,JSONObject jsonObjectBodegaProducto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonBodegaProductoDataTable(String sTipoJsonResponse,BodegaProducto bodegaproducto,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonBodegaProductosDataTable(String sTipoJsonResponse,List<BodegaProducto> bodegaproductos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayBodegaProductoColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayBodegaProductosColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayBodegaProductosColumns;
	}
	
	public static void updateJSONArrayBodegaProductoActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectBodegaProducto,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosBodegaProducto(BodegaProducto bodegaproducto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		bodegaproducto.setdescripcion(bodegaproducto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosBodegaProductos(List<BodegaProducto> bodegaproductos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(BodegaProducto bodegaproducto: bodegaproductos) {
			bodegaproducto.setdescripcion(bodegaproducto.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBodegaProducto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public  void recalcularStock(Long id_bodega,Long id_producto) throws Exception  {
		String sQuery="";
		String sQueryBase="";
		Integer i_total_ingresos=0;
		Integer i_total_egresos=0;
		Integer i_total_ingresos_transferencia=0;
		Integer i_cantidad_disponible=0;
		
		BodegaProductoLogic bodegaproductoLogic=new BodegaProductoLogic();
		bodegaproductoLogic.setConnexion(this.connexion);
		
		sQuery=" where id_bodega"+ id_bodega+" and id_producto"+id_producto;
		bodegaproductoLogic.getEntity(sQuery);
		
		
		//and df.es_ingreso_bodega=true
		
		sQueryBase="select sum(d.cantidad) ";
		sQueryBase+=" from inventario.movimiento_inventario m ";
		sQueryBase+=" inner join inventario.detalle_movimiento_inventario d on d.id_movimiento_inventario=m.id"; 
		sQueryBase+=" inner join inventario.definicion df on m.id_transaccion=df.id_transaccion";
		sQueryBase+=" where d.id_bodega=bp.id_bodega and d.id_producto=bp.id_producto";
		
		
		if(bodegaproductoLogic.getBodegaProducto()!=null && bodegaproductoLogic.getBodegaProducto().getId()>0) {						
			
			sQuery=sQueryBase;
			sQuery+=" and d.id_bodega="+id_bodega+" and d.id_producto"+id_producto;
			sQuery+=" and df.es_ingreso_bodega=true ";
			i_total_ingresos=DataAccessHelperBase.getIntegerValue(this.connexion, sQuery, "total");
			
			sQuery=sQueryBase;
			sQuery+=" and d.id_bodega="+id_bodega+" and d.id_producto"+id_producto;
			sQuery+=" and df.es_egreso_bodega=true ";
			i_total_egresos=DataAccessHelperBase.getIntegerValue(this.connexion, sQuery, "total");
			
			sQuery=sQueryBase;
			sQuery+=" and d.id_producto"+id_producto;
			sQuery+=" and df.es_egreso_bodega=true ";
			sQuery+=" and d.id_bodega_enviar="+id_bodega;
			i_total_ingresos_transferencia=DataAccessHelperBase.getIntegerValue(this.connexion, sQuery, "total");
			
			i_cantidad_disponible=i_total_ingresos+i_total_ingresos_transferencia-i_total_egresos;
			
				
			bodegaproductoLogic.saveBodegaProducto();
		}
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