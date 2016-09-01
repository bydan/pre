










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.puntoventa.business.logic.report;

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
import com.bydan.erp.puntoventa.util.report.VentaGeneralConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;
////import com.bydan.erp.puntoventa.business.interfaces.VentaGeneralAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class VentaGeneralLogicAdditional extends VentaGeneralLogic{		
	
	public  VentaGeneralLogicAdditional(Connexion connexion)throws Exception {
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
	public  VentaGeneralLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkVentaGeneralToSave(VentaGeneral ventageneral,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkVentaGeneralToSave(VentaGeneral ventageneral,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkVentaGeneralToSaveAfter(VentaGeneral ventageneral,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkVentaGeneralToSaves(List<VentaGeneral> ventagenerals,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkVentaGeneralToSaves(List<VentaGeneral> ventagenerals,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkVentaGeneralToSavesAfter(List<VentaGeneral> ventagenerals,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkVentaGeneralToGet(VentaGeneral ventageneral,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkVentaGeneralToGets(List<VentaGeneral> ventagenerals,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateVentaGeneralToSave(VentaGeneral ventageneral,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateVentaGeneralToGet(VentaGeneral ventageneral,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectVentaGeneralActions(String sTipoJsonResponse,JSONObject jsonObjectVentaGeneral,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonVentaGeneralDataTable(String sTipoJsonResponse,VentaGeneral ventageneral,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonVentaGeneralsDataTable(String sTipoJsonResponse,List<VentaGeneral> ventagenerals,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayVentaGeneralColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayVentaGeneralsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayVentaGeneralsColumns;
	}
	
	public static void updateJSONArrayVentaGeneralActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectVentaGeneral,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosVentaGeneral(VentaGeneral ventageneral,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventageneral.setnombre_producto(ventageneral.getnombre_producto().trim());
		ventageneral.setnombre_cliente(ventageneral.getnombre_cliente().trim());
		ventageneral.setsecuencial(ventageneral.getsecuencial().trim());
	}
	
	public static void quitarEspaciosVentaGenerals(List<VentaGeneral> ventagenerals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentaGeneral ventageneral: ventagenerals) {
			ventageneral.setnombre_producto(ventageneral.getnombre_producto().trim());
			ventageneral.setnombre_cliente(ventageneral.getnombre_cliente().trim());
			ventageneral.setsecuencial(ventageneral.getsecuencial().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentaGeneral(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(VentaGeneralConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(VentaGeneralConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentaGeneral> ventagenerals,VentaGeneral ventageneral,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentaGeneral ventageneralAux: ventagenerals) {
			if((ventageneralAux.getId()==null && ventageneral.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(ventageneralAux.getId()!=null && ventageneral.getId()!=null){
				if(ventageneralAux.getId().equals(ventageneral.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentaGeneral(List<VentaGeneral> ventagenerals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cantidadTotal=0.0;
		Double precioTotal=0.0;
		Double descuentoTotal=0.0;
		Double ivaTotal=0.0;
		Double iceTotal=0.0;
	
		for(VentaGeneral ventageneral: ventagenerals) {			
			cantidadTotal+=ventageneral.getcantidad();
			precioTotal+=ventageneral.getprecio();
			descuentoTotal+=ventageneral.getdescuento();
			ivaTotal+=ventageneral.getiva();
			iceTotal+=ventageneral.getice();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaGeneralConstantesFunciones.CANTIDAD);
		datoGeneral.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_CANTIDAD);
		datoGeneral.setdValorDouble(cantidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaGeneralConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaGeneralConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaGeneralConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaGeneralConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(VentaGeneralConstantesFunciones.LABEL_ICE);
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