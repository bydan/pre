














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.produccion.business.logic;

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
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMaquinaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;
//import com.bydan.erp.produccion.business.interfaces.ProductoOrdenDetaProduMaquinaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class ProductoOrdenDetaProduMaquinaLogicAdditional extends ProductoOrdenDetaProduMaquinaLogic { // implements ProductoOrdenDetaProduMaquinaAdditionable{
	public  ProductoOrdenDetaProduMaquinaLogicAdditional(Connexion connexion)throws Exception {
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
	public  ProductoOrdenDetaProduMaquinaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProductoOrdenDetaProduMaquinaToSave(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProductoOrdenDetaProduMaquinaToSave(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProductoOrdenDetaProduMaquinaToSaveAfter(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProductoOrdenDetaProduMaquinaToSaves(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProductoOrdenDetaProduMaquinaToSaves(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProductoOrdenDetaProduMaquinaToSavesAfter(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProductoOrdenDetaProduMaquinaToGet(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProductoOrdenDetaProduMaquinaToGets(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProductoOrdenDetaProduMaquinaToSave(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProductoOrdenDetaProduMaquinaToGet(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProductoOrdenDetaProduMaquinaActions(String sTipoJsonResponse,JSONObject jsonObjectProductoOrdenDetaProduMaquina,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProductoOrdenDetaProduMaquinaDataTable(String sTipoJsonResponse,ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProductoOrdenDetaProduMaquinasDataTable(String sTipoJsonResponse,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProductoOrdenDetaProduMaquinaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProductoOrdenDetaProduMaquinasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProductoOrdenDetaProduMaquinasColumns;
	}
	
	public static void updateJSONArrayProductoOrdenDetaProduMaquinaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProductoOrdenDetaProduMaquina,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosProductoOrdenDetaProduMaquina(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		productoordendetaprodumaquina.setdescripcion(productoordendetaprodumaquina.getdescripcion().trim());
	}
	
	public static void quitarEspaciosProductoOrdenDetaProduMaquinas(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina: productoordendetaprodumaquinas) {
			productoordendetaprodumaquina.setdescripcion(productoordendetaprodumaquina.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProductoOrdenDetaProduMaquina(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,ProductoOrdenDetaProduMaquina productoordendetaprodumaquina,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquinaAux: productoordendetaprodumaquinas) {
			if((productoordendetaprodumaquinaAux.getId()==null && productoordendetaprodumaquina.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(productoordendetaprodumaquinaAux.getId()!=null && productoordendetaprodumaquina.getId()!=null){
				if(productoordendetaprodumaquinaAux.getId().equals(productoordendetaprodumaquina.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProductoOrdenDetaProduMaquina(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
		Double costo_totalTotal=0.0;
	
		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina: productoordendetaprodumaquinas) {			
			costoTotal+=productoordendetaprodumaquina.getcosto();
			costo_totalTotal+=productoordendetaprodumaquina.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProductoOrdenDetaProduMaquinaConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ProductoOrdenDetaProduMaquinaConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
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