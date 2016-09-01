










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
import com.bydan.erp.contabilidad.util.report.RetencionesPorPagarPorRetencionesConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
////import com.bydan.erp.contabilidad.business.interfaces.RetencionesPorPagarPorRetencionesAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class RetencionesPorPagarPorRetencionesLogicAdditional extends RetencionesPorPagarPorRetencionesLogic{		
	
	public  RetencionesPorPagarPorRetencionesLogicAdditional(Connexion connexion)throws Exception {
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
	public  RetencionesPorPagarPorRetencionesLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkRetencionesPorPagarPorRetencionesToSave(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkRetencionesPorPagarPorRetencionesToSave(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkRetencionesPorPagarPorRetencionesToSaveAfter(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkRetencionesPorPagarPorRetencionesToSaves(List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkRetencionesPorPagarPorRetencionesToSaves(List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkRetencionesPorPagarPorRetencionesToSavesAfter(List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkRetencionesPorPagarPorRetencionesToGet(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkRetencionesPorPagarPorRetencionesToGets(List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateRetencionesPorPagarPorRetencionesToSave(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateRetencionesPorPagarPorRetencionesToGet(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectRetencionesPorPagarPorRetencionesActions(String sTipoJsonResponse,JSONObject jsonObjectRetencionesPorPagarPorRetenciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonRetencionesPorPagarPorRetencionesDataTable(String sTipoJsonResponse,RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonRetencionesPorPagarPorRetencionessDataTable(String sTipoJsonResponse,List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayRetencionesPorPagarPorRetencionesColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayRetencionesPorPagarPorRetencionessColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayRetencionesPorPagarPorRetencionessColumns;
	}
	
	public static void updateJSONArrayRetencionesPorPagarPorRetencionesActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectRetencionesPorPagarPorRetenciones,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosRetencionesPorPagarPorRetenciones(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		retencionesporpagarporretenciones.setnombre_tipo_movimiento(retencionesporpagarporretenciones.getnombre_tipo_movimiento().trim());
		retencionesporpagarporretenciones.setnumero_mayor(retencionesporpagarporretenciones.getnumero_mayor().trim());
		retencionesporpagarporretenciones.setnombre_cuenta_contable_retencion(retencionesporpagarporretenciones.getnombre_cuenta_contable_retencion().trim());
		retencionesporpagarporretenciones.setnumero_pre_impreso_factura(retencionesporpagarporretenciones.getnumero_pre_impreso_factura().trim());
		retencionesporpagarporretenciones.setnumero(retencionesporpagarporretenciones.getnumero().trim());
		retencionesporpagarporretenciones.setnombre_benef(retencionesporpagarporretenciones.getnombre_benef().trim());
		retencionesporpagarporretenciones.setruc_benef(retencionesporpagarporretenciones.getruc_benef().trim());
		retencionesporpagarporretenciones.setnombre_cuenta_contable(retencionesporpagarporretenciones.getnombre_cuenta_contable().trim());
		retencionesporpagarporretenciones.setnombre_cuenta_contable_credito(retencionesporpagarporretenciones.getnombre_cuenta_contable_credito().trim());
	}
	
	public static void quitarEspaciosRetencionesPorPagarPorRetencioness(List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones: retencionesporpagarporretencioness) {
			retencionesporpagarporretenciones.setnombre_tipo_movimiento(retencionesporpagarporretenciones.getnombre_tipo_movimiento().trim());
			retencionesporpagarporretenciones.setnumero_mayor(retencionesporpagarporretenciones.getnumero_mayor().trim());
			retencionesporpagarporretenciones.setnombre_cuenta_contable_retencion(retencionesporpagarporretenciones.getnombre_cuenta_contable_retencion().trim());
			retencionesporpagarporretenciones.setnumero_pre_impreso_factura(retencionesporpagarporretenciones.getnumero_pre_impreso_factura().trim());
			retencionesporpagarporretenciones.setnumero(retencionesporpagarporretenciones.getnumero().trim());
			retencionesporpagarporretenciones.setnombre_benef(retencionesporpagarporretenciones.getnombre_benef().trim());
			retencionesporpagarporretenciones.setruc_benef(retencionesporpagarporretenciones.getruc_benef().trim());
			retencionesporpagarporretenciones.setnombre_cuenta_contable(retencionesporpagarporretenciones.getnombre_cuenta_contable().trim());
			retencionesporpagarporretenciones.setnombre_cuenta_contable_credito(retencionesporpagarporretenciones.getnombre_cuenta_contable_credito().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRetencionesPorPagarPorRetenciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(RetencionesPorPagarPorRetencionesConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(RetencionesPorPagarPorRetencionesConstantesFunciones.IDSUCURSAL);
		arrColumnasGlobales.add(RetencionesPorPagarPorRetencionesConstantesFunciones.IDEJERCICIO);
		arrColumnasGlobales.add(RetencionesPorPagarPorRetencionesConstantesFunciones.IDPERIODO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness,RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RetencionesPorPagarPorRetenciones retencionesporpagarporretencionesAux: retencionesporpagarporretencioness) {
			if((retencionesporpagarporretencionesAux.getId()==null && retencionesporpagarporretenciones.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(retencionesporpagarporretencionesAux.getId()!=null && retencionesporpagarporretenciones.getId()!=null){
				if(retencionesporpagarporretencionesAux.getId().equals(retencionesporpagarporretenciones.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRetencionesPorPagarPorRetenciones(List<RetencionesPorPagarPorRetenciones> retencionesporpagarporretencioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double base_imponibleTotal=0.0;
		Double valorTotal=0.0;
	
		for(RetencionesPorPagarPorRetenciones retencionesporpagarporretenciones: retencionesporpagarporretencioness) {			
			porcentajeTotal+=retencionesporpagarporretenciones.getporcentaje();
			base_imponibleTotal+=retencionesporpagarporretenciones.getbase_imponible();
			valorTotal+=retencionesporpagarporretenciones.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.BASEIMPONIBLE);
		datoGeneral.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_BASEIMPONIBLE);
		datoGeneral.setdValorDouble(base_imponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RetencionesPorPagarPorRetencionesConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(RetencionesPorPagarPorRetencionesConstantesFunciones.LABEL_VALOR);
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