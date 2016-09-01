










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
import com.bydan.erp.facturacion.util.report.InformesDevolucionesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;
////import com.bydan.erp.facturacion.business.interfaces.InformesDevolucionesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class InformesDevolucionesLogicAdditional extends InformesDevolucionesLogic{		
	
	public  InformesDevolucionesLogicAdditional(Connexion connexion)throws Exception {
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
	public  InformesDevolucionesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkInformesDevolucionesToSave(InformesDevoluciones informesdevoluciones,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkInformesDevolucionesToSave(InformesDevoluciones informesdevoluciones,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkInformesDevolucionesToSaveAfter(InformesDevoluciones informesdevoluciones,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkInformesDevolucionesToSaves(List<InformesDevoluciones> informesdevolucioness,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkInformesDevolucionesToSaves(List<InformesDevoluciones> informesdevolucioness,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkInformesDevolucionesToSavesAfter(List<InformesDevoluciones> informesdevolucioness,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkInformesDevolucionesToGet(InformesDevoluciones informesdevoluciones,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkInformesDevolucionesToGets(List<InformesDevoluciones> informesdevolucioness,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateInformesDevolucionesToSave(InformesDevoluciones informesdevoluciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateInformesDevolucionesToGet(InformesDevoluciones informesdevoluciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectInformesDevolucionesActions(String sTipoJsonResponse,JSONObject jsonObjectInformesDevoluciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonInformesDevolucionesDataTable(String sTipoJsonResponse,InformesDevoluciones informesdevoluciones,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonInformesDevolucionessDataTable(String sTipoJsonResponse,List<InformesDevoluciones> informesdevolucioness,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayInformesDevolucionesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayInformesDevolucionessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayInformesDevolucionessColumns;
	}
	
	public static void updateJSONArrayInformesDevolucionesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectInformesDevoluciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosInformesDevoluciones(InformesDevoluciones informesdevoluciones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		informesdevoluciones.setuser_name_usuario(informesdevoluciones.getuser_name_usuario().trim());
		informesdevoluciones.setnombre_completo_cliente(informesdevoluciones.getnombre_completo_cliente().trim());
		informesdevoluciones.setnumero_pre_impreso(informesdevoluciones.getnumero_pre_impreso().trim());
		informesdevoluciones.setnombre_bodega(informesdevoluciones.getnombre_bodega().trim());
		informesdevoluciones.setnombre_producto(informesdevoluciones.getnombre_producto().trim());
		informesdevoluciones.setnombre_tipo_devolucion_empresa(informesdevoluciones.getnombre_tipo_devolucion_empresa().trim());
		informesdevoluciones.setcodigo_producto(informesdevoluciones.getcodigo_producto().trim());
	}
	
	public static void quitarEspaciosInformesDevolucioness(List<InformesDevoluciones> informesdevolucioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(InformesDevoluciones informesdevoluciones: informesdevolucioness) {
			informesdevoluciones.setuser_name_usuario(informesdevoluciones.getuser_name_usuario().trim());
			informesdevoluciones.setnombre_completo_cliente(informesdevoluciones.getnombre_completo_cliente().trim());
			informesdevoluciones.setnumero_pre_impreso(informesdevoluciones.getnumero_pre_impreso().trim());
			informesdevoluciones.setnombre_bodega(informesdevoluciones.getnombre_bodega().trim());
			informesdevoluciones.setnombre_producto(informesdevoluciones.getnombre_producto().trim());
			informesdevoluciones.setnombre_tipo_devolucion_empresa(informesdevoluciones.getnombre_tipo_devolucion_empresa().trim());
			informesdevoluciones.setcodigo_producto(informesdevoluciones.getcodigo_producto().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesInformesDevoluciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(InformesDevolucionesConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(InformesDevolucionesConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<InformesDevoluciones> informesdevolucioness,InformesDevoluciones informesdevoluciones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(InformesDevoluciones informesdevolucionesAux: informesdevolucioness) {
			if((informesdevolucionesAux.getId()==null && informesdevoluciones.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(informesdevolucionesAux.getId()!=null && informesdevoluciones.getId()!=null){
				if(informesdevolucionesAux.getId().equals(informesdevoluciones.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaInformesDevoluciones(List<InformesDevoluciones> informesdevolucioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(InformesDevoluciones informesdevoluciones: informesdevolucioness) {			
		}
		
		
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