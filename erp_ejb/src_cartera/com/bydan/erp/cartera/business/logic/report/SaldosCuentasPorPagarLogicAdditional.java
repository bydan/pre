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

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.Constantes2;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.Funciones;
import com.bydan.framework.erp.util.Funciones2;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.erp.cartera.resources.general.AuxiliarGeneral;
import com.bydan.erp.cartera.util.CarteraSqlReporte;
import com.bydan.erp.cartera.util.report.SaldosCuentasPorPagarConstantesFunciones;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;
////import com.bydan.erp.cartera.business.interfaces.SaldosCuentasPorPagarAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.business.logic.AccionLogic;


@SuppressWarnings({"unused","resource"})
final public class SaldosCuentasPorPagarLogicAdditional extends SaldosCuentasPorPagarLogic{		
	
	//CONTROL_INICIO
	public  SaldosCuentasPorPagarLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkSaldosCuentasPorPagarToSave(SaldosCuentasPorPagar saldoscuentasporpagar,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkSaldosCuentasPorPagarToSave(SaldosCuentasPorPagar saldoscuentasporpagar,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkSaldosCuentasPorPagarToSaveAfter(SaldosCuentasPorPagar saldoscuentasporpagar,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkSaldosCuentasPorPagarToSaves(List<SaldosCuentasPorPagar> saldoscuentasporpagars,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkSaldosCuentasPorPagarToSaves(List<SaldosCuentasPorPagar> saldoscuentasporpagars,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkSaldosCuentasPorPagarToSavesAfter(List<SaldosCuentasPorPagar> saldoscuentasporpagars,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkSaldosCuentasPorPagarToGet(SaldosCuentasPorPagar saldoscuentasporpagar,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkSaldosCuentasPorPagarToGets(List<SaldosCuentasPorPagar> saldoscuentasporpagars,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateSaldosCuentasPorPagarToSave(SaldosCuentasPorPagar saldoscuentasporpagar,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateSaldosCuentasPorPagarToGet(SaldosCuentasPorPagar saldoscuentasporpagar,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectSaldosCuentasPorPagarActions(String sTipoJsonResponse,JSONObject jsonObjectSaldosCuentasPorPagar,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonSaldosCuentasPorPagarDataTable(String sTipoJsonResponse,SaldosCuentasPorPagar saldoscuentasporpagar,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonSaldosCuentasPorPagarsDataTable(String sTipoJsonResponse,List<SaldosCuentasPorPagar> saldoscuentasporpagars,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArraySaldosCuentasPorPagarColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArraySaldosCuentasPorPagarsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArraySaldosCuentasPorPagarsColumns;
	}
	
	public static void updateJSONArraySaldosCuentasPorPagarActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectSaldosCuentasPorPagar,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	
	
	public void BusquedaSaldosCuentasPorPagar(Connexion connexion,ConnexionType connexionType,ParameterDbType parameterDbType,String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,Long id_zona,Long id_grupo_cliente,Long id_cliente,Date fecha_emision_hasta)throws Exception {
		String sSql="";
		String sSqlWhere="";
		Boolean existeWhere=false;
		String sFinalQueryFinal="";
		
		if(connexionType.equals(ConnexionType.HIBERNATE)) {

		} else if(connexionType.equals(ConnexionType.JDBC32)) {
			if(parameterDbType.equals(ParameterDbType.MYSQL)) {

			} else if(parameterDbType.equals(ParameterDbType.POSTGRES)) {
				InputStream inputStreamCreateSql = AuxiliarGeneral.class.getResourceAsStream("SaldosCuentasPorPagar_Create_Postgres.sql");				
				InputStream inputStreamSql = AuxiliarGeneral.class.getResourceAsStream("SaldosCuentasPorPagar_1_Postgres.sql");
				
				String sCreateQuery = new Scanner(inputStreamCreateSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();
				String sSelectQuery = new Scanner(inputStreamSql,Constantes2.S_UTF8).useDelimiter(Constantes2.S_DELIMITER).next();

				if(Constantes.ISDEVELOPING) {
					System.out.println(sCreateQuery);
				}
				
				this.executeQuery(connexion,sCreateQuery);
				
				
				if(parametroGeneralUsuario.getid_empresa()!= null && parametroGeneralUsuario.getid_empresa()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" c.id_empresa="+parametroGeneralUsuario.getid_empresa();
					existeWhere=true;
				}


				if(parametroGeneralUsuario.getid_sucursal()!= null && parametroGeneralUsuario.getid_sucursal()>0) {
					if(existeWhere) {
						sSqlWhere+=" and";
					}
					sSqlWhere+=" c.id_sucursal="+parametroGeneralUsuario.getid_sucursal();
					existeWhere=true;
				}
				

				if(id_zona!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_zona = "+id_zona.toString();
					existeWhere=true;
				}

				if(id_grupo_cliente!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" c.id_grupo_cliente = "+id_grupo_cliente.toString();
					existeWhere=true;
				}

				if(id_cliente!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.id_cliente = "+id_cliente.toString();
					existeWhere=true;
				}

				/*
				if(fecha_emision_desde!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.fecha_emision between "+"'"+Funciones2.getStringPostgresDate(fecha_emision_desde)+"'";
					existeWhere=true;
				}
				*/
				
				if(fecha_emision_hasta!= null) {
					if(existeWhere) {sSqlWhere+=" and ";}
					sSqlWhere+=" d.fecha_emision <= '"+Funciones2.getStringPostgresDate(fecha_emision_hasta)+"'";
					existeWhere=true;
				}

				if(existeWhere) {
					sSqlWhere=" where "+sSqlWhere;
				}

				if(sSelectQuery.contains(Constantes2.S_KEYWHERE)) {
					sSql=sSelectQuery.replace(Constantes2.S_KEYWHERE,sSqlWhere);
				} else {
					sSql=sSelectQuery+sSqlWhere;
				}

				if(Constantes.ISDEVELOPING) {
					System.out.println(sSql);
				}
				
				
				
				this.getEntities(sSql, sFinalQueryFinal);
				
				double dSaldoDebito=0.0;
				
				for(SaldosCuentasPorPagar saldoscuentasporpagar:this.getSaldosCuentasPorPagars()) {
					saldoscuentasporpagar.setIsNew(true);
					
					dSaldoDebito=saldoscuentasporpagar.getdebito_mone_local()-saldoscuentasporpagar.getcredito_mone_local();
					
					//SE DEFINE EL SALDO DEBITO O CREDITO
					if(dSaldoDebito>=0) {
						saldoscuentasporpagar.setsaldo_debito(dSaldoDebito);
					} else {
						saldoscuentasporpagar.setsaldo_credito(dSaldoDebito * -1);
					}
					
					//NO SE TOMARA EN CUENTA EL SALDO ANTERIOR
				}
				
				this.saveSaldosCuentasPorPagars();
				
				//TEST DataAccessHelperBase.getXXXValue
				/*
				//CONTADOR
				String sValueQuery="select count(*) as contador from saldos_cuentas_por_pagar";
				String sAlias="contador";
				Integer iValue=DataAccessHelperBase.getIntegerValue(connexion, sValueQuery, sAlias);
				
				if(Constantes.ISDEVELOPING) {
					System.out.println("Contador Test="+iValue);
				}
				
				//SUM
				sValueQuery="select sum(debito_mone_local) as total from saldos_cuentas_por_pagar";
				sAlias="total";
				Double dValue=DataAccessHelperBase.getDoubleValue(connexion, sValueQuery, sAlias);
				
				if(Constantes.ISDEVELOPING) {
					System.out.println("Suma Test="+dValue);
				}
				
				//MAX
				sValueQuery="select max(codigo) as total from saldos_cuentas_por_pagar";
				sAlias="total";
				String sValue=DataAccessHelperBase.getStringValue(connexion, sValueQuery, sAlias);
				
				if(Constantes.ISDEVELOPING) {
					System.out.println("Max Test="+sValue);
				}
				*/
				
				
				//TRAER CUALQUIER QUERY Y GUARDARLO EN OBJETO MAP
				/*
				AccionLogic accionLogic=new AccionLogic();
				accionLogic.setConnexion(connexion);
				
				ArrayList<String> listColumns=new ArrayList<String>();
				listColumns.add("codigo");
				listColumns.add("nombre_completo");
				listColumns.add("debito_mone_local");
				listColumns.add("credito_mone_local");
				listColumns.add("saldo_debito");
				listColumns.add("saldo_Credito");
				
				accionLogic.getEntities(sSql, new QueryWhereSelectParameters(), listColumns, true);
				
				for(Accion accion:accionLogic.getAccions())
				
				  
				  { 
					System.out.println(accion.getMapAccion().get("codigo"));
					System.out.println(accion.getMapAccion().get("nombre_completo"));
					System.out.println(accion.getMapAccion().get("debito_mone_local"));
					System.out.println(accion.getMapAccion().get("credito_mone_local"));
					System.out.println(accion.getMapAccion().get("saldo_debito"));
					System.out.println(accion.getMapAccion().get("saldo_Credito"));
				}
				*/
				
				
				//TRAER CUALQUIER QUERY QUE SE ADAPTE A ESTRUCTURA CLASE
				/*
				AccionLogic accionLogic=new AccionLogic();
				accionLogic.setConnexion(connexion);
				
				ArrayList<String> listColumns=new ArrayList<String>();
				listColumns.add("codigo");
				listColumns.add("nombre");
				listColumns.add("credito_mone_local");
				//listColumns.add("credito_mone_local2");//NO EXISTE
				
				sSql=sSql.replace("c.nombre_completo,", "c.nombre_completo as nombre,");
				
				accionLogic.getEntities(sSql, new QueryWhereSelectParameters(), listColumns, false);
				
				for(Accion accion:accionLogic.getAccions())  { 
					System.out.println(accion.getcodigo());
					System.out.println(accion.getnombre());
					System.out.println(accion.getcredito_mone_local());
				}
				*/
				
				
				
				
				
				//LO MISMO PERO PROBANDO FUNCIONES DE ESTA CLASE DE REPORTES
				
				//TRAER CUALQUIER QUERY Y GUARDARLO EN OBJETO MAP
				/*
				SaldosCuentasPorPagarLogic saldosCuentasPorPagarLogic=new SaldosCuentasPorPagarLogic();
				saldosCuentasPorPagarLogic.setConnexion(connexion);
				
				ArrayList<String> listColumns=new ArrayList<String>();
				listColumns.add("codigo");
				listColumns.add("nombre_completo");
				listColumns.add("debito_mone_local");
				listColumns.add("credito_mone_local");
				listColumns.add("saldo_debito");
				listColumns.add("saldo_Credito");
				
				saldosCuentasPorPagarLogic.getEntities(sSql, new QueryWhereSelectParameters(), listColumns, true);
				
				for(SaldosCuentasPorPagar saldosCuentasPorPagar:saldosCuentasPorPagarLogic.getSaldosCuentasPorPagars()) { 
					System.out.println(saldosCuentasPorPagar.getMapSaldosCuentasPorPagar().get("codigo"));
					System.out.println(saldosCuentasPorPagar.getMapSaldosCuentasPorPagar().get("nombre_completo"));
					System.out.println(saldosCuentasPorPagar.getMapSaldosCuentasPorPagar().get("debito_mone_local"));
					System.out.println(saldosCuentasPorPagar.getMapSaldosCuentasPorPagar().get("credito_mone_local"));
					System.out.println(saldosCuentasPorPagar.getMapSaldosCuentasPorPagar().get("saldo_debito"));
					System.out.println(saldosCuentasPorPagar.getMapSaldosCuentasPorPagar().get("saldo_Credito"));
				}
				*/
				
				
				//TRAER CUALQUIER QUERY QUE SE ADAPTE A ESTRUCTURA CLASE
				/*
				SaldosCuentasPorPagarLogic saldosCuentasPorPagarLogic=new SaldosCuentasPorPagarLogic();
				saldosCuentasPorPagarLogic.setConnexion(connexion);
				
				ArrayList<String> listColumns=new ArrayList<String>();
				listColumns.add("codigo");
				listColumns.add("nombre_completo");
				listColumns.add("credito_mone_local");
				//listColumns.add("credito_mone_local2");//NO EXISTE
				
				
				saldosCuentasPorPagarLogic.getEntities(sSql, new QueryWhereSelectParameters(), listColumns, false);
				
				for(SaldosCuentasPorPagar saldosCuentasPorPagar:saldosCuentasPorPagarLogic.getSaldosCuentasPorPagars()) { 
					System.out.println(saldosCuentasPorPagar.getcodigo());
					System.out.println(saldosCuentasPorPagar.getnombre_completo());
					System.out.println(saldosCuentasPorPagar.getcredito_mone_local());
				}
				*/
				
			}
		}
	}
	
	//CONTROL_FUNCION1
	
	
	
	
	
	public static void quitarEspaciosSaldosCuentasPorPagar(SaldosCuentasPorPagar saldoscuentasporpagar,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		saldoscuentasporpagar.setcodigo(saldoscuentasporpagar.getcodigo().trim());
		saldoscuentasporpagar.setnombre_completo(saldoscuentasporpagar.getnombre_completo().trim());
	}
	
	public static void quitarEspaciosSaldosCuentasPorPagars(List<SaldosCuentasPorPagar> saldoscuentasporpagars,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SaldosCuentasPorPagar saldoscuentasporpagar: saldoscuentasporpagars) {
			saldoscuentasporpagar.setcodigo(saldoscuentasporpagar.getcodigo().trim());
			saldoscuentasporpagar.setnombre_completo(saldoscuentasporpagar.getnombre_completo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSaldosCuentasPorPagar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(SaldosCuentasPorPagarConstantesFunciones.IDEMPRESA);
		arrColumnasGlobales.add(SaldosCuentasPorPagarConstantesFunciones.IDSUCURSAL);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SaldosCuentasPorPagar> saldoscuentasporpagars,SaldosCuentasPorPagar saldoscuentasporpagar,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SaldosCuentasPorPagar saldoscuentasporpagarAux: saldoscuentasporpagars) {
			if((saldoscuentasporpagarAux.getId()==null && saldoscuentasporpagar.getId()==null) && conIdNulo) {
				existe=true;
				break;
				
			} else if(saldoscuentasporpagarAux.getId()!=null && saldoscuentasporpagar.getId()!=null){
				if(saldoscuentasporpagarAux.getId().equals(saldoscuentasporpagar.getId())) {
					existe=true;
					break;
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSaldosCuentasPorPagar(List<SaldosCuentasPorPagar> saldoscuentasporpagars) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
		Double saldo_anteriorTotal=0.0;
		Double saldo_debitoTotal=0.0;
		Double saldo_creditoTotal=0.0;
	
		for(SaldosCuentasPorPagar saldoscuentasporpagar: saldoscuentasporpagars) {			
			debito_mone_localTotal+=saldoscuentasporpagar.getdebito_mone_local();
			credito_mone_localTotal+=saldoscuentasporpagar.getcredito_mone_local();
			saldo_anteriorTotal+=saldoscuentasporpagar.getsaldo_anterior();
			saldo_debitoTotal+=saldoscuentasporpagar.getsaldo_debito();
			saldo_creditoTotal+=saldoscuentasporpagar.getsaldo_credito();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.SALDOANTERIOR);
		datoGeneral.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDOANTERIOR);
		datoGeneral.setdValorDouble(saldo_anteriorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.SALDODEBITO);
		datoGeneral.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDODEBITO);
		datoGeneral.setdValorDouble(saldo_debitoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SaldosCuentasPorPagarConstantesFunciones.SALDOCREDITO);
		datoGeneral.setsDescripcion(SaldosCuentasPorPagarConstantesFunciones.LABEL_SALDOCREDITO);
		datoGeneral.setdValorDouble(saldo_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	//PARA ACCIONES NORMALES
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {
			try {

				//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();


				return generalEntityReturnGeneral;

			} catch(Exception e) {
				Funciones.manageException(logger,e);
				throw e;

			} finally {

			}
	}
		
	//CONTROL_FUNCION2
}

