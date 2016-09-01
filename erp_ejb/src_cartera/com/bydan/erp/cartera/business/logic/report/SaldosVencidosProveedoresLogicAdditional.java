










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
import com.bydan.erp.cartera.util.report.SaldosVencidosProveedoresConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.SaldosVencidosProveedoresAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
final public class SaldosVencidosProveedoresLogicAdditional extends SaldosVencidosProveedoresLogic{		
	
	public  SaldosVencidosProveedoresLogicAdditional(Connexion connexion)throws Exception {
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
	public  SaldosVencidosProveedoresLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkSaldosVencidosProveedoresToSave(SaldosVencidosProveedores saldosvencidosproveedores,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkSaldosVencidosProveedoresToSave(SaldosVencidosProveedores saldosvencidosproveedores,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkSaldosVencidosProveedoresToSaveAfter(SaldosVencidosProveedores saldosvencidosproveedores,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkSaldosVencidosProveedoresToSaves(List<SaldosVencidosProveedores> saldosvencidosproveedoress,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkSaldosVencidosProveedoresToSaves(List<SaldosVencidosProveedores> saldosvencidosproveedoress,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkSaldosVencidosProveedoresToSavesAfter(List<SaldosVencidosProveedores> saldosvencidosproveedoress,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkSaldosVencidosProveedoresToGet(SaldosVencidosProveedores saldosvencidosproveedores,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkSaldosVencidosProveedoresToGets(List<SaldosVencidosProveedores> saldosvencidosproveedoress,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateSaldosVencidosProveedoresToSave(SaldosVencidosProveedores saldosvencidosproveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateSaldosVencidosProveedoresToGet(SaldosVencidosProveedores saldosvencidosproveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectSaldosVencidosProveedoresActions(String sTipoJsonResponse,JSONObject jsonObjectSaldosVencidosProveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonSaldosVencidosProveedoresDataTable(String sTipoJsonResponse,SaldosVencidosProveedores saldosvencidosproveedores,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonSaldosVencidosProveedoressDataTable(String sTipoJsonResponse,List<SaldosVencidosProveedores> saldosvencidosproveedoress,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArraySaldosVencidosProveedoresColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArraySaldosVencidosProveedoressColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArraySaldosVencidosProveedoressColumns;
	}
	
	public static void updateJSONArraySaldosVencidosProveedoresActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectSaldosVencidosProveedores,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosSaldosVencidosProveedores(SaldosVencidosProveedores saldosvencidosproveedores,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		saldosvencidosproveedores.setnumero_factura(saldosvencidosproveedores.getnumero_factura().trim());
		saldosvencidosproveedores.setnombre_moneda(saldosvencidosproveedores.getnombre_moneda().trim());
		saldosvencidosproveedores.setnombre_cliente(saldosvencidosproveedores.getnombre_cliente().trim());
		saldosvencidosproveedores.setnombre_grupo_cliente(saldosvencidosproveedores.getnombre_grupo_cliente().trim());
	}
	
	public static void quitarEspaciosSaldosVencidosProveedoress(List<SaldosVencidosProveedores> saldosvencidosproveedoress,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SaldosVencidosProveedores saldosvencidosproveedores: saldosvencidosproveedoress) {
			saldosvencidosproveedores.setnumero_factura(saldosvencidosproveedores.getnumero_factura().trim());
			saldosvencidosproveedores.setnombre_moneda(saldosvencidosproveedores.getnombre_moneda().trim());
			saldosvencidosproveedores.setnombre_cliente(saldosvencidosproveedores.getnombre_cliente().trim());
			saldosvencidosproveedores.setnombre_grupo_cliente(saldosvencidosproveedores.getnombre_grupo_cliente().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSaldosVencidosProveedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(SaldosVencidosProveedoresConstantesFunciones.IDEMPRESA);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SaldosVencidosProveedores> saldosvencidosproveedoress,SaldosVencidosProveedores saldosvencidosproveedores,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SaldosVencidosProveedores saldosvencidosproveedoresAux: saldosvencidosproveedoress) {
			if((saldosvencidosproveedoresAux.getId()==null && saldosvencidosproveedores.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(saldosvencidosproveedoresAux.getId()!=null && saldosvencidosproveedores.getId()!=null){
				if(saldosvencidosproveedoresAux.getId().equals(saldosvencidosproveedores.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSaldosVencidosProveedores(List<SaldosVencidosProveedores> saldosvencidosproveedoress) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldoTotal=0.0;
		Double saldo_extraTotal=0.0;
	
		for(SaldosVencidosProveedores saldosvencidosproveedores: saldosvencidosproveedoress) {			
			saldoTotal+=saldosvencidosproveedores.getsaldo();
			saldo_extraTotal+=saldosvencidosproveedores.getsaldo_extra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosVencidosProveedoresConstantesFunciones.SALDOEXTRA);
		datoGeneral.setsDescripcion(SaldosVencidosProveedoresConstantesFunciones.LABEL_SALDOEXTRA);
		datoGeneral.setdValorDouble(saldo_extraTotal);
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