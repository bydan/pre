













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


import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.ControlTipo;
import com.bydan.framework.erp.util.EventoSubTipo;
import com.bydan.framework.erp.util.EventoTipo;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.contabilidad.util.CuentaContableConstantesFunciones;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.logic.ParametroContabilidadDefectoLogic;
import com.bydan.erp.contabilidad.business.logic.CuentaContableLogic;
import com.bydan.erp.contabilidad.util.CuentaContableParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.CuentaContableReturnGeneral;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class CuentaContableLogicAdditional extends CuentaContableLogic { // implements CuentaContableAdditionable{
	
	public  CuentaContableLogicAdditional(Connexion connexion)throws Exception {
		super(connexion);

	}
	//PARA EVENTOS GENERALES
	public static GeneralEntityParameterReturnGeneral procesarEventos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,Object objects,Object object,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,Boolean isEsNuevo,ArrayList<Classe> classes)throws Exception {
		try {
		//CONTROL_19
			CuentaContableLogic cuentaContableLogic=(CuentaContableLogic)generalEntityLogic;
			CuentaContableParameterReturnGeneral cuentaContableReturnGeneral=(CuentaContableParameterReturnGeneral)generalEntityReturnGeneral;
			
			ParametroContabilidadDefecto parametroContabilidadDefecto=new ParametroContabilidadDefecto();
			ParametroContabilidadDefectoLogic parametroContabilidadDefectoLogic=new ParametroContabilidadDefectoLogic();						
			
			parametroContabilidadDefectoLogic.setConnexion(generalEntityLogic.getConnexion());
			
			
			String sFinalQuery="";
			
			if(controlTipo.equals(ControlTipo.FORM) && eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW)) {
				sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_sucursal="+parametroGeneralUsuario.getid_sucursal();
				
				parametroContabilidadDefectoLogic.getEntity(sFinalQuery);
				
				parametroContabilidadDefecto=parametroContabilidadDefectoLogic.getParametroContabilidadDefecto();
				
				if(parametroContabilidadDefecto!=null && parametroContabilidadDefecto.getId()>0) {
					cuentaContableReturnGeneral.getCuentaContable().setid_moneda(parametroContabilidadDefecto.getid_moneda());
					cuentaContableReturnGeneral.getCuentaContable().setid_modulo(parametroContabilidadDefecto.getid_modulo());
					cuentaContableReturnGeneral.getCuentaContable().setid_tipo_intervalo(parametroContabilidadDefecto.getid_tipo_intervalo());
					
					/*
					cuentaContableReturnGeneral.getCuentaContable().setid_grupo_cuentaContable(parametroContabilidadDefecto.getid_grupo_cuentaContable());										
					cuentaContableReturnGeneral.getCuentaContable().setid_pais(parametroContabilidadDefecto.getid_pais());
					cuentaContableReturnGeneral.getCuentaContable().setid_ciudad(parametroContabilidadDefecto.getid_ciudad());					
					cuentaContableReturnGeneral.getCuentaContable().setid_calidad_cuentaContable(parametroContabilidadDefecto.getid_calidad_cuentaContable());																				
					cuentaContableReturnGeneral.getCuentaContable().setid_tipo_identificacion(parametroContabilidadDefecto.getid_tipo_identificacion());
					cuentaContableReturnGeneral.getCuentaContable().setid_pais_nacionalidad(parametroContabilidadDefecto.getid_pais_nacionalidad());
					cuentaContableReturnGeneral.getCuentaContable().setid_estado_civil(parametroContabilidadDefecto.getid_estado_civil());
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
	public  CuentaContableLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCuentaContableToSave(CuentaContable cuentacontable,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCuentaContableToSave(CuentaContable cuentacontable,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCuentaContableToSaveAfter(CuentaContable cuentacontable,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCuentaContableToSaves(List<CuentaContable> cuentacontables,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCuentaContableToSaves(List<CuentaContable> cuentacontables,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCuentaContableToSavesAfter(List<CuentaContable> cuentacontables,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCuentaContableToGet(CuentaContable cuentacontable,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCuentaContableToGets(List<CuentaContable> cuentacontables,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCuentaContableToSave(CuentaContable cuentacontable,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCuentaContableToGet(CuentaContable cuentacontable,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCuentaContableActions(String sTipoJsonResponse,JSONObject jsonObjectCuentaContable,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCuentaContableDataTable(String sTipoJsonResponse,CuentaContable cuentacontable,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCuentaContablesDataTable(String sTipoJsonResponse,List<CuentaContable> cuentacontables,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCuentaContableColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCuentaContablesColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCuentaContablesColumns;
	}
	
	public static void updateJSONArrayCuentaContableActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCuentaContable,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCuentaContable(CuentaContable cuentacontable,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cuentacontable.setcodigo(cuentacontable.getcodigo().trim());
		cuentacontable.setnombre(cuentacontable.getnombre().trim());
		cuentacontable.setcodigo_extranjero(cuentacontable.getcodigo_extranjero().trim());
		cuentacontable.setnombre_extranjero(cuentacontable.getnombre_extranjero().trim());
	}
	
	public static void quitarEspaciosCuentaContables(List<CuentaContable> cuentacontables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CuentaContable cuentacontable: cuentacontables) {
			cuentacontable.setcodigo(cuentacontable.getcodigo().trim());
			cuentacontable.setnombre(cuentacontable.getnombre().trim());
			cuentacontable.setcodigo_extranjero(cuentacontable.getcodigo_extranjero().trim());
			cuentacontable.setnombre_extranjero(cuentacontable.getnombre_extranjero().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CuentaContable> cuentacontables,CuentaContable cuentacontable,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CuentaContable cuentacontableAux: cuentacontables) {
			if((cuentacontableAux.getId()==null && cuentacontable.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cuentacontableAux.getId()!=null && cuentacontable.getId()!=null){
				if(cuentacontableAux.getId().equals(cuentacontable.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCuentaContable(List<CuentaContable> cuentacontables) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CuentaContable cuentacontable: cuentacontables) {			
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