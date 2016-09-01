










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.tesoreria.business.logic.report;

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
import com.bydan.erp.tesoreria.util.report.PresupuestosFlujosCajaConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;
////import com.bydan.erp.tesoreria.business.interfaces.PresupuestosFlujosCajaAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class PresupuestosFlujosCajaLogicAdditional extends PresupuestosFlujosCajaLogic{		
	
	public  PresupuestosFlujosCajaLogicAdditional(Connexion connexion)throws Exception {
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
	public  PresupuestosFlujosCajaLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkPresupuestosFlujosCajaToSave(PresupuestosFlujosCaja presupuestosflujoscaja,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkPresupuestosFlujosCajaToSave(PresupuestosFlujosCaja presupuestosflujoscaja,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkPresupuestosFlujosCajaToSaveAfter(PresupuestosFlujosCaja presupuestosflujoscaja,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkPresupuestosFlujosCajaToSaves(List<PresupuestosFlujosCaja> presupuestosflujoscajas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkPresupuestosFlujosCajaToSaves(List<PresupuestosFlujosCaja> presupuestosflujoscajas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkPresupuestosFlujosCajaToSavesAfter(List<PresupuestosFlujosCaja> presupuestosflujoscajas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkPresupuestosFlujosCajaToGet(PresupuestosFlujosCaja presupuestosflujoscaja,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkPresupuestosFlujosCajaToGets(List<PresupuestosFlujosCaja> presupuestosflujoscajas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updatePresupuestosFlujosCajaToSave(PresupuestosFlujosCaja presupuestosflujoscaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updatePresupuestosFlujosCajaToGet(PresupuestosFlujosCaja presupuestosflujoscaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectPresupuestosFlujosCajaActions(String sTipoJsonResponse,JSONObject jsonObjectPresupuestosFlujosCaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonPresupuestosFlujosCajaDataTable(String sTipoJsonResponse,PresupuestosFlujosCaja presupuestosflujoscaja,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonPresupuestosFlujosCajasDataTable(String sTipoJsonResponse,List<PresupuestosFlujosCaja> presupuestosflujoscajas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayPresupuestosFlujosCajaColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayPresupuestosFlujosCajasColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayPresupuestosFlujosCajasColumns;
	}
	
	public static void updateJSONArrayPresupuestosFlujosCajaActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectPresupuestosFlujosCaja,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosPresupuestosFlujosCaja(PresupuestosFlujosCaja presupuestosflujoscaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		presupuestosflujoscaja.setcodigo_cuenta(presupuestosflujoscaja.getcodigo_cuenta().trim());
		presupuestosflujoscaja.setcodigo(presupuestosflujoscaja.getcodigo().trim());
		presupuestosflujoscaja.setnombre(presupuestosflujoscaja.getnombre().trim());
		presupuestosflujoscaja.setnombre_modulo(presupuestosflujoscaja.getnombre_modulo().trim());
	}
	
	public static void quitarEspaciosPresupuestosFlujosCajas(List<PresupuestosFlujosCaja> presupuestosflujoscajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresupuestosFlujosCaja presupuestosflujoscaja: presupuestosflujoscajas) {
			presupuestosflujoscaja.setcodigo_cuenta(presupuestosflujoscaja.getcodigo_cuenta().trim());
			presupuestosflujoscaja.setcodigo(presupuestosflujoscaja.getcodigo().trim());
			presupuestosflujoscaja.setnombre(presupuestosflujoscaja.getnombre().trim());
			presupuestosflujoscaja.setnombre_modulo(presupuestosflujoscaja.getnombre_modulo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestosFlujosCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(PresupuestosFlujosCajaConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresupuestosFlujosCaja> presupuestosflujoscajas,PresupuestosFlujosCaja presupuestosflujoscaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresupuestosFlujosCaja presupuestosflujoscajaAux: presupuestosflujoscajas) {
			if((presupuestosflujoscajaAux.getId()==null && presupuestosflujoscaja.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(presupuestosflujoscajaAux.getId()!=null && presupuestosflujoscaja.getId()!=null){
				if(presupuestosflujoscajaAux.getId().equals(presupuestosflujoscaja.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresupuestosFlujosCaja(List<PresupuestosFlujosCaja> presupuestosflujoscajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor1Total=0.0;
		Double valor2Total=0.0;
		Double valor3Total=0.0;
		Double valor4Total=0.0;
		Double valor5Total=0.0;
		Double valor6Total=0.0;
		Double valor7Total=0.0;
		Double valor8Total=0.0;
		Double valor9Total=0.0;
		Double valor10Total=0.0;
		Double valor11Total=0.0;
		Double valor12Total=0.0;
		Double totalTotal=0.0;
	
		for(PresupuestosFlujosCaja presupuestosflujoscaja: presupuestosflujoscajas) {			
			valor1Total+=presupuestosflujoscaja.getvalor1();
			valor2Total+=presupuestosflujoscaja.getvalor2();
			valor3Total+=presupuestosflujoscaja.getvalor3();
			valor4Total+=presupuestosflujoscaja.getvalor4();
			valor5Total+=presupuestosflujoscaja.getvalor5();
			valor6Total+=presupuestosflujoscaja.getvalor6();
			valor7Total+=presupuestosflujoscaja.getvalor7();
			valor8Total+=presupuestosflujoscaja.getvalor8();
			valor9Total+=presupuestosflujoscaja.getvalor9();
			valor10Total+=presupuestosflujoscaja.getvalor10();
			valor11Total+=presupuestosflujoscaja.getvalor11();
			valor12Total+=presupuestosflujoscaja.getvalor12();
			totalTotal+=presupuestosflujoscaja.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR1);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR1);
		datoGeneral.setdValorDouble(valor1Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR2);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR2);
		datoGeneral.setdValorDouble(valor2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR3);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR3);
		datoGeneral.setdValorDouble(valor3Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR4);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR4);
		datoGeneral.setdValorDouble(valor4Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR5);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR5);
		datoGeneral.setdValorDouble(valor5Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR6);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR6);
		datoGeneral.setdValorDouble(valor6Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR7);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR7);
		datoGeneral.setdValorDouble(valor7Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR8);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR8);
		datoGeneral.setdValorDouble(valor8Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR9);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR9);
		datoGeneral.setdValorDouble(valor9Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR10);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR10);
		datoGeneral.setdValorDouble(valor10Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR11);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR11);
		datoGeneral.setdValorDouble(valor11Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.VALOR12);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_VALOR12);
		datoGeneral.setdValorDouble(valor12Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestosFlujosCajaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(PresupuestosFlujosCajaConstantesFunciones.LABEL_TOTAL);
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