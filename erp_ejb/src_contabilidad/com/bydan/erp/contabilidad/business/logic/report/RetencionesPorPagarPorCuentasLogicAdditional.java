










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.contabilidad.business.logic.report;

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
import com.bydan.erp.contabilidad.util.report.RetencionesPorPagarPorCuentasConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
////import com.bydan.erp.contabilidad.business.interfaces.RetencionesPorPagarPorCuentasAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class RetencionesPorPagarPorCuentasLogicAdditional extends RetencionesPorPagarPorCuentasLogic{		
	
	public  RetencionesPorPagarPorCuentasLogicAdditional(Connexion connexion)throws Exception {
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
	public  RetencionesPorPagarPorCuentasLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkRetencionesPorPagarPorCuentasToSave(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkRetencionesPorPagarPorCuentasToSave(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkRetencionesPorPagarPorCuentasToSaveAfter(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkRetencionesPorPagarPorCuentasToSaves(List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkRetencionesPorPagarPorCuentasToSaves(List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkRetencionesPorPagarPorCuentasToSavesAfter(List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkRetencionesPorPagarPorCuentasToGet(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkRetencionesPorPagarPorCuentasToGets(List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateRetencionesPorPagarPorCuentasToSave(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateRetencionesPorPagarPorCuentasToGet(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectRetencionesPorPagarPorCuentasActions(String sTipoJsonResponse,JSONObject jsonObjectRetencionesPorPagarPorCuentas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonRetencionesPorPagarPorCuentasDataTable(String sTipoJsonResponse,RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonRetencionesPorPagarPorCuentassDataTable(String sTipoJsonResponse,List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayRetencionesPorPagarPorCuentasColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayRetencionesPorPagarPorCuentassColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayRetencionesPorPagarPorCuentassColumns;
	}
	
	public static void updateJSONArrayRetencionesPorPagarPorCuentasActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectRetencionesPorPagarPorCuentas,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosRetencionesPorPagarPorCuentas(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		retencionesporpagarporcuentas.setnombre_tipo_movimiento(retencionesporpagarporcuentas.getnombre_tipo_movimiento().trim());
		retencionesporpagarporcuentas.setnumero_mayor(retencionesporpagarporcuentas.getnumero_mayor().trim());
		retencionesporpagarporcuentas.setnombre_cuenta_contable_retencion(retencionesporpagarporcuentas.getnombre_cuenta_contable_retencion().trim());
		retencionesporpagarporcuentas.setnumero_pre_impreso_factura(retencionesporpagarporcuentas.getnumero_pre_impreso_factura().trim());
		retencionesporpagarporcuentas.setnumero(retencionesporpagarporcuentas.getnumero().trim());
		retencionesporpagarporcuentas.setnombre_benef(retencionesporpagarporcuentas.getnombre_benef().trim());
		retencionesporpagarporcuentas.setruc_benef(retencionesporpagarporcuentas.getruc_benef().trim());
		retencionesporpagarporcuentas.setnombre_cuenta_contable(retencionesporpagarporcuentas.getnombre_cuenta_contable().trim());
		retencionesporpagarporcuentas.setnombre_cuenta_contable_credito(retencionesporpagarporcuentas.getnombre_cuenta_contable_credito().trim());
	}
	
	public static void quitarEspaciosRetencionesPorPagarPorCuentass(List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas: retencionesporpagarporcuentass) {
			retencionesporpagarporcuentas.setnombre_tipo_movimiento(retencionesporpagarporcuentas.getnombre_tipo_movimiento().trim());
			retencionesporpagarporcuentas.setnumero_mayor(retencionesporpagarporcuentas.getnumero_mayor().trim());
			retencionesporpagarporcuentas.setnombre_cuenta_contable_retencion(retencionesporpagarporcuentas.getnombre_cuenta_contable_retencion().trim());
			retencionesporpagarporcuentas.setnumero_pre_impreso_factura(retencionesporpagarporcuentas.getnumero_pre_impreso_factura().trim());
			retencionesporpagarporcuentas.setnumero(retencionesporpagarporcuentas.getnumero().trim());
			retencionesporpagarporcuentas.setnombre_benef(retencionesporpagarporcuentas.getnombre_benef().trim());
			retencionesporpagarporcuentas.setruc_benef(retencionesporpagarporcuentas.getruc_benef().trim());
			retencionesporpagarporcuentas.setnombre_cuenta_contable(retencionesporpagarporcuentas.getnombre_cuenta_contable().trim());
			retencionesporpagarporcuentas.setnombre_cuenta_contable_credito(retencionesporpagarporcuentas.getnombre_cuenta_contable_credito().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRetencionesPorPagarPorCuentas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(RetencionesPorPagarPorCuentasConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(RetencionesPorPagarPorCuentasConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(RetencionesPorPagarPorCuentasConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(RetencionesPorPagarPorCuentasConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass,RetencionesPorPagarPorCuentas retencionesporpagarporcuentas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RetencionesPorPagarPorCuentas retencionesporpagarporcuentasAux: retencionesporpagarporcuentass) {
			if((retencionesporpagarporcuentasAux.getId()==null && retencionesporpagarporcuentas.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(retencionesporpagarporcuentasAux.getId()!=null && retencionesporpagarporcuentas.getId()!=null){
				if(retencionesporpagarporcuentasAux.getId().equals(retencionesporpagarporcuentas.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRetencionesPorPagarPorCuentas(List<RetencionesPorPagarPorCuentas> retencionesporpagarporcuentass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double base_imponibleTotal=0.0;
		Double valorTotal=0.0;
	
		for(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas: retencionesporpagarporcuentass) {			
			porcentajeTotal+=retencionesporpagarporcuentas.getporcentaje();
			base_imponibleTotal+=retencionesporpagarporcuentas.getbase_imponible();
			valorTotal+=retencionesporpagarporcuentas.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.BASEIMPONIBLE);
		datoGeneral.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_BASEIMPONIBLE);
		datoGeneral.setdValorDouble(base_imponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionesPorPagarPorCuentasConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(RetencionesPorPagarPorCuentasConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
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