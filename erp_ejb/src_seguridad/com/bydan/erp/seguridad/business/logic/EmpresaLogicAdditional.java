













/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.seguridad.business.logic;

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
import com.bydan.erp.seguridad.util.EmpresaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;
//import com.bydan.erp.seguridad.business.interfaces.EmpresaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
public class EmpresaLogicAdditional extends EmpresaLogic { // implements EmpresaAdditionable{
	public  EmpresaLogicAdditional(Connexion connexion)throws Exception {
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
	public  EmpresaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkEmpresaToSave(Empresa empresa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkEmpresaToSave(Empresa empresa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkEmpresaToSaveAfter(Empresa empresa,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkEmpresaToSaves(List<Empresa> empresas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkEmpresaToSaves(List<Empresa> empresas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkEmpresaToSavesAfter(List<Empresa> empresas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkEmpresaToGet(Empresa empresa,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkEmpresaToGets(List<Empresa> empresas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateEmpresaToSave(Empresa empresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateEmpresaToGet(Empresa empresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectEmpresaActions(String sTipoJsonResponse,JSONObject jsonObjectEmpresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonEmpresaDataTable(String sTipoJsonResponse,Empresa empresa,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonEmpresasDataTable(String sTipoJsonResponse,List<Empresa> empresas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayEmpresaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayEmpresasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayEmpresasColumns;
	}
	
	public static void updateJSONArrayEmpresaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectEmpresa,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosEmpresa(Empresa empresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		empresa.setnombre(empresa.getnombre().trim());
		empresa.setdireccion(empresa.getdireccion().trim());
		empresa.setruc(empresa.getruc().trim());
		empresa.setmail(empresa.getmail().trim());
		empresa.settelefono(empresa.gettelefono().trim());
		empresa.setfax(empresa.getfax().trim());
		empresa.setcodigo_postal(empresa.getcodigo_postal().trim());
		empresa.setrepresentante_nombre(empresa.getrepresentante_nombre().trim());
		empresa.setrepresentante_cedula(empresa.getrepresentante_cedula().trim());
		empresa.setcontador_nombre(empresa.getcontador_nombre().trim());
		empresa.setcontador_ruc(empresa.getcontador_ruc().trim());
		empresa.setcontador_licencia(empresa.getcontador_licencia().trim());
		empresa.setactividad_principal(empresa.getactividad_principal().trim());
		empresa.setactividad_secundaria(empresa.getactividad_secundaria().trim());
	}
	
	public static void quitarEspaciosEmpresas(List<Empresa> empresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Empresa empresa: empresas) {
			empresa.setnombre(empresa.getnombre().trim());
			empresa.setdireccion(empresa.getdireccion().trim());
			empresa.setruc(empresa.getruc().trim());
			empresa.setmail(empresa.getmail().trim());
			empresa.settelefono(empresa.gettelefono().trim());
			empresa.setfax(empresa.getfax().trim());
			empresa.setcodigo_postal(empresa.getcodigo_postal().trim());
			empresa.setrepresentante_nombre(empresa.getrepresentante_nombre().trim());
			empresa.setrepresentante_cedula(empresa.getrepresentante_cedula().trim());
			empresa.setcontador_nombre(empresa.getcontador_nombre().trim());
			empresa.setcontador_ruc(empresa.getcontador_ruc().trim());
			empresa.setcontador_licencia(empresa.getcontador_licencia().trim());
			empresa.setactividad_principal(empresa.getactividad_principal().trim());
			empresa.setactividad_secundaria(empresa.getactividad_secundaria().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Empresa> empresas,Empresa empresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Empresa empresaAux: empresas) {
			if((empresaAux.getId()==null && empresa.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(empresaAux.getId()!=null && empresa.getId()!=null){
				if(empresaAux.getId().equals(empresa.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpresa(List<Empresa> empresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ivaTotal=0.0;
	
		for(Empresa empresa: empresas) {			
			ivaTotal+=empresa.getiva();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EmpresaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(EmpresaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
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