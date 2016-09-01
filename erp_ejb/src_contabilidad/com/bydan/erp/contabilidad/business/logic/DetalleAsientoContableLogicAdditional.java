













/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.DetalleAsientoContableConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
//import com.bydan.erp.contabilidad.business.interfaces.DetalleAsientoContableAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleAsientoContableLogicAdditional extends DetalleAsientoContableLogic { // implements DetalleAsientoContableAdditionable{
	
	public  DetalleAsientoContableLogicAdditional(Connexion connexion)throws Exception {
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
	public  DetalleAsientoContableLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkDetalleAsientoContableToSave(DetalleAsientoContable detalleasientocontable,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkDetalleAsientoContableToSave(DetalleAsientoContable detalleasientocontable,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkDetalleAsientoContableToSaveAfter(DetalleAsientoContable detalleasientocontable,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkDetalleAsientoContableToSaves(List<DetalleAsientoContable> detalleasientocontables,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkDetalleAsientoContableToSaves(List<DetalleAsientoContable> detalleasientocontables,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkDetalleAsientoContableToSavesAfter(List<DetalleAsientoContable> detalleasientocontables,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkDetalleAsientoContableToGet(DetalleAsientoContable detalleasientocontable,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkDetalleAsientoContableToGets(List<DetalleAsientoContable> detalleasientocontables,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateDetalleAsientoContableToSave(DetalleAsientoContable detalleasientocontable,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateDetalleAsientoContableToGet(DetalleAsientoContable detalleasientocontable,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectDetalleAsientoContableActions(String sTipoJsonResponse,JSONObject jsonObjectDetalleAsientoContable,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonDetalleAsientoContableDataTable(String sTipoJsonResponse,DetalleAsientoContable detalleasientocontable,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonDetalleAsientoContablesDataTable(String sTipoJsonResponse,List<DetalleAsientoContable> detalleasientocontables,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayDetalleAsientoContableColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayDetalleAsientoContablesColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayDetalleAsientoContablesColumns;
	}
	
	public static void updateJSONArrayDetalleAsientoContableActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectDetalleAsientoContable,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosDetalleAsientoContable(DetalleAsientoContable detalleasientocontable,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleasientocontable.setnumero_documento(detalleasientocontable.getnumero_documento().trim());
		detalleasientocontable.setdetalle(detalleasientocontable.getdetalle().trim());
		detalleasientocontable.setnumero_deposito(detalleasientocontable.getnumero_deposito().trim());
	}
	
	public static void quitarEspaciosDetalleAsientoContables(List<DetalleAsientoContable> detalleasientocontables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleAsientoContable detalleasientocontable: detalleasientocontables) {
			detalleasientocontable.setnumero_documento(detalleasientocontable.getnumero_documento().trim());
			detalleasientocontable.setdetalle(detalleasientocontable.getdetalle().trim());
			detalleasientocontable.setnumero_deposito(detalleasientocontable.getnumero_deposito().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleAsientoContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(DetalleAsientoContableConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(DetalleAsientoContableConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(DetalleAsientoContableConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(DetalleAsientoContableConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleAsientoContable> detalleasientocontables,DetalleAsientoContable detalleasientocontable,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleAsientoContable detalleasientocontableAux: detalleasientocontables) {
			if((detalleasientocontableAux.getId()==null && detalleasientocontable.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(detalleasientocontableAux.getId()!=null && detalleasientocontable.getId()!=null){
				if(detalleasientocontableAux.getId().equals(detalleasientocontable.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleAsientoContable(List<DetalleAsientoContable> detalleasientocontables) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
		Double debito_extranTotal=0.0;
		Double credito_extranTotal=0.0;
		Double valor_tipo_cambioTotal=0.0;
	
		for(DetalleAsientoContable detalleasientocontable: detalleasientocontables) {			
			debito_localTotal+=detalleasientocontable.getdebito_local();
			credito_localTotal+=detalleasientocontable.getcredito_local();
			debito_extranTotal+=detalleasientocontable.getdebito_extran();
			credito_extranTotal+=detalleasientocontable.getcredito_extran();
			valor_tipo_cambioTotal+=detalleasientocontable.getcotizacion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableConstantesFunciones.DEBITOEXTRAN);
		datoGeneral.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_DEBITOEXTRAN);
		datoGeneral.setdValorDouble(debito_extranTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableConstantesFunciones.CREDITOEXTRAN);
		datoGeneral.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_CREDITOEXTRAN);
		datoGeneral.setdValorDouble(credito_extranTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableConstantesFunciones.COTIZACION);
		datoGeneral.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_COTIZACION);
		datoGeneral.setdValorDouble(valor_tipo_cambioTotal);
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