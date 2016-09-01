










/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.cartera.business.logic.report;

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
import com.bydan.erp.cartera.util.report.CobrarSaldosVencidosConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.CobrarSaldosVencidosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class CobrarSaldosVencidosLogicAdditional extends CobrarSaldosVencidosLogic{		
	
	public  CobrarSaldosVencidosLogicAdditional(Connexion connexion)throws Exception {
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
	public  CobrarSaldosVencidosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkCobrarSaldosVencidosToSave(CobrarSaldosVencidos cobrarsaldosvencidos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkCobrarSaldosVencidosToSave(CobrarSaldosVencidos cobrarsaldosvencidos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkCobrarSaldosVencidosToSaveAfter(CobrarSaldosVencidos cobrarsaldosvencidos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkCobrarSaldosVencidosToSaves(List<CobrarSaldosVencidos> cobrarsaldosvencidoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkCobrarSaldosVencidosToSaves(List<CobrarSaldosVencidos> cobrarsaldosvencidoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkCobrarSaldosVencidosToSavesAfter(List<CobrarSaldosVencidos> cobrarsaldosvencidoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkCobrarSaldosVencidosToGet(CobrarSaldosVencidos cobrarsaldosvencidos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkCobrarSaldosVencidosToGets(List<CobrarSaldosVencidos> cobrarsaldosvencidoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateCobrarSaldosVencidosToSave(CobrarSaldosVencidos cobrarsaldosvencidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateCobrarSaldosVencidosToGet(CobrarSaldosVencidos cobrarsaldosvencidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectCobrarSaldosVencidosActions(String sTipoJsonResponse,JSONObject jsonObjectCobrarSaldosVencidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonCobrarSaldosVencidosDataTable(String sTipoJsonResponse,CobrarSaldosVencidos cobrarsaldosvencidos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonCobrarSaldosVencidossDataTable(String sTipoJsonResponse,List<CobrarSaldosVencidos> cobrarsaldosvencidoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayCobrarSaldosVencidosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayCobrarSaldosVencidossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayCobrarSaldosVencidossColumns;
	}
	
	public static void updateJSONArrayCobrarSaldosVencidosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectCobrarSaldosVencidos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosCobrarSaldosVencidos(CobrarSaldosVencidos cobrarsaldosvencidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarsaldosvencidos.setnumero_factura(cobrarsaldosvencidos.getnumero_factura().trim());
		cobrarsaldosvencidos.setnombre_grupo_cliente(cobrarsaldosvencidos.getnombre_grupo_cliente().trim());
		cobrarsaldosvencidos.setcodigo(cobrarsaldosvencidos.getcodigo().trim());
		cobrarsaldosvencidos.setnombre(cobrarsaldosvencidos.getnombre().trim());
		cobrarsaldosvencidos.settelefono_telefono(cobrarsaldosvencidos.gettelefono_telefono().trim());
		cobrarsaldosvencidos.setdescripcion(cobrarsaldosvencidos.getdescripcion().trim());
	}
	
	public static void quitarEspaciosCobrarSaldosVencidoss(List<CobrarSaldosVencidos> cobrarsaldosvencidoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarSaldosVencidos cobrarsaldosvencidos: cobrarsaldosvencidoss) {
			cobrarsaldosvencidos.setnumero_factura(cobrarsaldosvencidos.getnumero_factura().trim());
			cobrarsaldosvencidos.setnombre_grupo_cliente(cobrarsaldosvencidos.getnombre_grupo_cliente().trim());
			cobrarsaldosvencidos.setcodigo(cobrarsaldosvencidos.getcodigo().trim());
			cobrarsaldosvencidos.setnombre(cobrarsaldosvencidos.getnombre().trim());
			cobrarsaldosvencidos.settelefono_telefono(cobrarsaldosvencidos.gettelefono_telefono().trim());
			cobrarsaldosvencidos.setdescripcion(cobrarsaldosvencidos.getdescripcion().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarSaldosVencidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(CobrarSaldosVencidosConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarSaldosVencidos> cobrarsaldosvencidoss,CobrarSaldosVencidos cobrarsaldosvencidos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarSaldosVencidos cobrarsaldosvencidosAux: cobrarsaldosvencidoss) {
			if((cobrarsaldosvencidosAux.getId()==null && cobrarsaldosvencidos.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(cobrarsaldosvencidosAux.getId()!=null && cobrarsaldosvencidos.getId()!=null){
				if(cobrarsaldosvencidosAux.getId().equals(cobrarsaldosvencidos.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarSaldosVencidos(List<CobrarSaldosVencidos> cobrarsaldosvencidoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldoTotal=0.0;
	
		for(CobrarSaldosVencidos cobrarsaldosvencidos: cobrarsaldosvencidoss) {			
			saldoTotal+=cobrarsaldosvencidos.getsaldo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarSaldosVencidosConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(CobrarSaldosVencidosConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
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