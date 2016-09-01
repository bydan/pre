














/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.importaciones.business.logic;

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
import com.bydan.erp.importaciones.util.DetallePedidoCompraImporConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;
//import com.bydan.erp.importaciones.business.interfaces.DetallePedidoCompraImporAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class DetallePedidoCompraImporLogicAdditional extends DetallePedidoCompraImporLogic { // implements DetallePedidoCompraImporAdditionable{
	public  DetallePedidoCompraImporLogicAdditional(Connexion connexion)throws Exception {
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
	public  DetallePedidoCompraImporLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetallePedidoCompraImporToSave(DetallePedidoCompraImpor detallepedidocompraimpor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetallePedidoCompraImporToSave(DetallePedidoCompraImpor detallepedidocompraimpor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetallePedidoCompraImporToSaveAfter(DetallePedidoCompraImpor detallepedidocompraimpor,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetallePedidoCompraImporToSaves(List<DetallePedidoCompraImpor> detallepedidocompraimpors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetallePedidoCompraImporToSaves(List<DetallePedidoCompraImpor> detallepedidocompraimpors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetallePedidoCompraImporToSavesAfter(List<DetallePedidoCompraImpor> detallepedidocompraimpors,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetallePedidoCompraImporToGet(DetallePedidoCompraImpor detallepedidocompraimpor,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetallePedidoCompraImporToGets(List<DetallePedidoCompraImpor> detallepedidocompraimpors,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetallePedidoCompraImporToSave(DetallePedidoCompraImpor detallepedidocompraimpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetallePedidoCompraImporToGet(DetallePedidoCompraImpor detallepedidocompraimpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetallePedidoCompraImporActions(String sTipoJsonResponse,JSONObject jsonObjectDetallePedidoCompraImpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetallePedidoCompraImporDataTable(String sTipoJsonResponse,DetallePedidoCompraImpor detallepedidocompraimpor,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetallePedidoCompraImporsDataTable(String sTipoJsonResponse,List<DetallePedidoCompraImpor> detallepedidocompraimpors,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetallePedidoCompraImporColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetallePedidoCompraImporsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetallePedidoCompraImporsColumns;
	}
	
	public static void updateJSONArrayDetallePedidoCompraImporActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetallePedidoCompraImpor,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetallePedidoCompraImpor(DetallePedidoCompraImpor detallepedidocompraimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallepedidocompraimpor.setlote(detallepedidocompraimpor.getlote().trim());
		detallepedidocompraimpor.setdescripcion(detallepedidocompraimpor.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetallePedidoCompraImpors(List<DetallePedidoCompraImpor> detallepedidocompraimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetallePedidoCompraImpor detallepedidocompraimpor: detallepedidocompraimpors) {
			detallepedidocompraimpor.setlote(detallepedidocompraimpor.getlote().trim());
			detallepedidocompraimpor.setdescripcion(detallepedidocompraimpor.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePedidoCompraImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetallePedidoCompraImporConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DetallePedidoCompraImporConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(DetallePedidoCompraImporConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(DetallePedidoCompraImporConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetallePedidoCompraImpor> detallepedidocompraimpors,DetallePedidoCompraImpor detallepedidocompraimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetallePedidoCompraImpor detallepedidocompraimporAux: detallepedidocompraimpors) {
			if((detallepedidocompraimporAux.getId()==null && detallepedidocompraimpor.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(detallepedidocompraimporAux.getId()!=null && detallepedidocompraimpor.getId()!=null){
				if(detallepedidocompraimporAux.getId().equals(detallepedidocompraimpor.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetallePedidoCompraImpor(List<DetallePedidoCompraImpor> detallepedidocompraimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double pesoTotal=0.0;
		Double precioTotal=0.0;
		Double porcentaje_arancelTotal=0.0;
		Double precio_unidad_auxiliarTotal=0.0;
		Double fobTotal=0.0;
		Double fob_exwTotal=0.0;
		Double totalTotal=0.0;
	
		for(DetallePedidoCompraImpor detallepedidocompraimpor: detallepedidocompraimpors) {			
			porcentajeTotal+=detallepedidocompraimpor.getporcentaje();
			pesoTotal+=detallepedidocompraimpor.getpeso();
			precioTotal+=detallepedidocompraimpor.getprecio();
			porcentaje_arancelTotal+=detallepedidocompraimpor.getporcentaje_arancel();
			precio_unidad_auxiliarTotal+=detallepedidocompraimpor.getprecio_unidad_auxiliar();
			fobTotal+=detallepedidocompraimpor.getfob();
			fob_exwTotal+=detallepedidocompraimpor.getfob_exw();
			totalTotal+=detallepedidocompraimpor.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.PESO);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_PESO);
		datoGeneral.setdValorDouble(pesoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.PORCENTAJEARANCEL);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_PORCENTAJEARANCEL);
		datoGeneral.setdValorDouble(porcentaje_arancelTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.PRECIOUNIDADAUXILIAR);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_PRECIOUNIDADAUXILIAR);
		datoGeneral.setdValorDouble(precio_unidad_auxiliarTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.FOB);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_FOB);
		datoGeneral.setdValorDouble(fobTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.FOBEXW);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_FOBEXW);
		datoGeneral.setdValorDouble(fob_exwTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_TOTAL);
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