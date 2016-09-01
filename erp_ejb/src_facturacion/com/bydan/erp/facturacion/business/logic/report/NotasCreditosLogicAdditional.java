










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
import com.bydan.erp.facturacion.util.report.NotasCreditosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;
////import com.bydan.erp.facturacion.business.interfaces.NotasCreditosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class NotasCreditosLogicAdditional extends NotasCreditosLogic{		
	
	public  NotasCreditosLogicAdditional(Connexion connexion)throws Exception {
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
	public  NotasCreditosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkNotasCreditosToSave(NotasCreditos notascreditos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkNotasCreditosToSave(NotasCreditos notascreditos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkNotasCreditosToSaveAfter(NotasCreditos notascreditos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkNotasCreditosToSaves(List<NotasCreditos> notascreditoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkNotasCreditosToSaves(List<NotasCreditos> notascreditoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkNotasCreditosToSavesAfter(List<NotasCreditos> notascreditoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkNotasCreditosToGet(NotasCreditos notascreditos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkNotasCreditosToGets(List<NotasCreditos> notascreditoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateNotasCreditosToSave(NotasCreditos notascreditos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateNotasCreditosToGet(NotasCreditos notascreditos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectNotasCreditosActions(String sTipoJsonResponse,JSONObject jsonObjectNotasCreditos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonNotasCreditosDataTable(String sTipoJsonResponse,NotasCreditos notascreditos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonNotasCreditossDataTable(String sTipoJsonResponse,List<NotasCreditos> notascreditoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayNotasCreditosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayNotasCreditossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayNotasCreditossColumns;
	}
	
	public static void updateJSONArrayNotasCreditosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectNotasCreditos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosNotasCreditos(NotasCreditos notascreditos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		notascreditos.setnombre_completo_cliente(notascreditos.getnombre_completo_cliente().trim());
		notascreditos.setnumero_pre_impreso_factura(notascreditos.getnumero_pre_impreso_factura().trim());
		notascreditos.setnumero_pre_impreso(notascreditos.getnumero_pre_impreso().trim());
		notascreditos.setnombre_estado_nota_credito(notascreditos.getnombre_estado_nota_credito().trim());
	}
	
	public static void quitarEspaciosNotasCreditoss(List<NotasCreditos> notascreditoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(NotasCreditos notascreditos: notascreditoss) {
			notascreditos.setnombre_completo_cliente(notascreditos.getnombre_completo_cliente().trim());
			notascreditos.setnumero_pre_impreso_factura(notascreditos.getnumero_pre_impreso_factura().trim());
			notascreditos.setnumero_pre_impreso(notascreditos.getnumero_pre_impreso().trim());
			notascreditos.setnombre_estado_nota_credito(notascreditos.getnombre_estado_nota_credito().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNotasCreditos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(NotasCreditosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<NotasCreditos> notascreditoss,NotasCreditos notascreditos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(NotasCreditos notascreditosAux: notascreditoss) {
			if((notascreditosAux.getId()==null && notascreditos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(notascreditosAux.getId()!=null && notascreditos.getId()!=null){
				if(notascreditosAux.getId().equals(notascreditos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNotasCreditos(List<NotasCreditos> notascreditoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ivaTotal=0.0;
		Double descuento_valorTotal=0.0;
		Double otro_valorTotal=0.0;
		Double sub_totalTotal=0.0;
		Double totalTotal=0.0;
	
		for(NotasCreditos notascreditos: notascreditoss) {			
			ivaTotal+=notascreditos.getiva();
			descuento_valorTotal+=notascreditos.getdescuento_valor();
			otro_valorTotal+=notascreditos.getotro_valor();
			sub_totalTotal+=notascreditos.getsub_total();
			totalTotal+=notascreditos.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotasCreditosConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotasCreditosConstantesFunciones.DESCUENTOVALOR);
		datoGeneral.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_DESCUENTOVALOR);
		datoGeneral.setdValorDouble(descuento_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotasCreditosConstantesFunciones.OTROVALOR);
		datoGeneral.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_OTROVALOR);
		datoGeneral.setdValorDouble(otro_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotasCreditosConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(NotasCreditosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(NotasCreditosConstantesFunciones.LABEL_TOTAL);
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