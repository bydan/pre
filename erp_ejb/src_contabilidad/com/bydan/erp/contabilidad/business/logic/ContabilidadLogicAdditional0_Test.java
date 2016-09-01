/*
* ============================================================================
* GNU Lesser General Public License
* ============================================================================
*
* BYDAN - Free Java BYDAN library.
* Copyright (C) 2008 
* 
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.
* 
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* Lesser General Public License for more details.
* 
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
* 
* BYDAN Corporation
*/
package com.bydan.erp.contabilidad.business.logic;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.erp.contabilidad.util.AsientoContableConstantesFuncionesAdditional;
import com.bydan.erp.contabilidad.util.ContabilidadConstantesFunciones;
import com.bydan.erp.contabilidad.util.ContabilidadConstantesFuncionesAdditional;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
import com.bydan.erp.contabilidad.business.logic.report.ProcesoMayorizarDiarioLogic;
import com.bydan.erp.contabilidad.business.logic.report.TotalSaldosLogic;
import com.bydan.erp.seguridad.business.entity.Modulo;
import com.bydan.erp.seguridad.business.entity.ParametroGeneralUsuario;
import com.bydan.erp.contabilidad.util.ContabilidadSql;
import com.bydan.erp.contabilidad.business.logic.report.*;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE

@SuppressWarnings("unused")
final public class ContabilidadLogicAdditional0_Test extends ContabilidadLogic  {		
	//CONTROL_INICIO
	protected List<ReporteTest> reporteTests;
	protected List<ProcesoTest> procesoTests;
	protected List<ProcesoMayorizarDiario> procesoMayorizarDiarios;
	protected List<ProcesoCierrePeriodo> procesocierreperiodos;
	protected List<DiarioGeneral> diariogenerals;
	
	//SOLO PROCESO
	protected List<ProcesoTotalizarSaldos> procesototalizarsaldos;
	
	public  ContabilidadLogicAdditional0_Test()throws Exception {
		super();
		
		this.reporteTests=new ArrayList<ReporteTest>();
		this.procesoTests=new ArrayList<ProcesoTest>();
		this.procesoMayorizarDiarios=new ArrayList<ProcesoMayorizarDiario>();
		this.procesocierreperiodos=new ArrayList<ProcesoCierrePeriodo>();
		this.procesototalizarsaldos=new ArrayList<ProcesoTotalizarSaldos>();
		this.diariogenerals=new ArrayList<DiarioGeneral>();
    }
	
	public void getDiarioGeneralsBusquedaReporteWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Long id_ejercicio,Long id_periodo,Long id_modulo,Long id_tipo_movimiento,Long id_tipo_documento,Date fecha_inicio,Date fecha_fin)throws Exception {
		DiarioGeneralLogic diariogeneralLogic=new DiarioGeneralLogic();

		try {
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			

			diariogeneralLogic.setConnexion(this.connexion);
			
			String sQuerySelect="";
			String sFinalQueryFinal="";
			
			sQuerySelect=ContabilidadSql.GetSelecSqlDiarioGeneral(this.connexionType,this.parameterDbType,sFinalQuery,pagination,parametroGeneralUsuario,moduloActual,id_ejercicio,id_periodo,id_modulo,id_tipo_movimiento,id_tipo_documento,fecha_inicio,fecha_fin);
			
			diariogeneralLogic.getEntities(sQuerySelect, sFinalQueryFinal);
			
			this.diariogenerals=diariogeneralLogic.getDiarioGenerals();
			
			this.connexion.commit();

		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			this.connexion.close();
		}
	}
	
	public void getTodosReporteTestsWithConnection(String finalQuery, Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual) {
		
	}
	
	
	
	public void getReporteTestsBusquedaPorIdEmpresaPorIdModuloWithConnection(String finalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Long id_empresaBusquedaPorIdEmpresaPorIdModulo,Long id_moduloBusquedaPorIdEmpresaPorIdModulo,String nombreBusquedaPorIdEmpresaPorIdModulo,String ubicacionBusquedaPorIdEmpresaPorIdModulo) {
	
	}

	public void getTodosProcesoTestsWithConnection(String finalQuery, Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual) {
	
	}
	

	public void getProcesoTestsBusquedaPorIdEmpresaPorIdModuloWithConnection(String finalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Long id_empresaBusquedaPorIdEmpresaPorIdModulo,Long id_moduloBusquedaPorIdEmpresaPorIdModulo,String nombreBusquedaPorIdEmpresaPorIdModulo) {
		
	}
	
	public List<DiarioGeneral> getDiarioGenerals() throws Exception {		
		return diariogenerals;
	}
	
	public void setDiarioGenerals(List<DiarioGeneral> newdiariogenerals) {
		this.diariogenerals = newdiariogenerals;
	}
	
	public List<ProcesoCierrePeriodo> getProcesoCierrePeriodos() throws Exception {		
		return procesocierreperiodos;
	}
	
	public void setProcesoCierrePeriodos(List<ProcesoCierrePeriodo> newProcesoCierrePeriodos) {
		this.procesocierreperiodos = newProcesoCierrePeriodos;
	}
	
	public List<ProcesoTotalizarSaldos> getProcesoTotalizarSaldoss() {
		return procesototalizarsaldos;
	}

	public void setProcesoTotalizarSaldoss(ArrayList<ProcesoTotalizarSaldos> procesototalizarsaldos) {
		this.procesototalizarsaldos = procesototalizarsaldos;
	}

	
	public List<ProcesoTest> getProcesoTests() {
		return procesoTests;
	}


	public void setProcesoTests(ArrayList<ProcesoTest> procesoTests) {
		this.procesoTests = procesoTests;
	}


	public List<ProcesoMayorizarDiario> getProcesoMayorizarDiarios() {
		return procesoMayorizarDiarios;
	}


	public void setProcesoMayorizarDiarios(
			List<ProcesoMayorizarDiario> procesoMayorizarDiarios) {
		this.procesoMayorizarDiarios = procesoMayorizarDiarios;
	}


	public List<ReporteTest> getReporteTests() {
		return reporteTests;
	}

	public void setReporteTests(ArrayList<ReporteTest> reporteTests) {
		this.reporteTests = reporteTests;
	}
	public void getProcesoCierrePeriodosBusquedaPorIdEjercicioPorIdPeriodoPorEstadoWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Long id_ejercicio,Long id_periodo,Long id_estado_periodo)throws Exception {
		try
		{
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}
	
	public  void  getTodosProcesoMayorizarDiariosWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual)throws Exception {
		this.procesoMayorizarDiarios = new  ArrayList<ProcesoMayorizarDiario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			//ProcesoMayorizarDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//procesomayorizardiarios=procesomayorizardiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			connexion.commit();			
			
		} catch(Exception e) {	
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}		
	}
	
	public void getProcesoMayorizarDiariosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual, String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			//ProcesoMayorizarDiarioConstantesFunciones.GetQueryProcesoMayorizarDiariosBusquedaPorCodigo(queryWhereSelectParameters,sFinalQuery,codigo);

			//procesomayorizardiarios=procesomayorizardiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

			//ProcesoMayorizarDiarioConstantesFunciones.CargarTablasRelacionesBusquedaPorCodigo(procesomayorizardiarios,codigo);

			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}
	
	public void getProcesoMayorizarDiariosBusquedaPorFechaInicioFechaFinWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Date fecha_inicio,Date fecha_fin)throws Exception {
		try
		{
			ProcesoMayorizarDiarioLogic procesoMayorizarDiarioLogic=new ProcesoMayorizarDiarioLogic();
			
			//connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			String sQuerySelect="";
			
			sQuerySelect=ContabilidadSql.GetSqlConWhereAsientosContablesParaMayorizar(this.connexionType,this.parameterDbType,parametroGeneralUsuario,moduloActual,fecha_inicio,fecha_fin);
			
			procesoMayorizarDiarioLogic.getEntitiesWithConnection(sQuerySelect, queryWhereSelectParameters);
			
			procesoMayorizarDiarios=procesoMayorizarDiarioLogic.getProcesoMayorizarDiarios();
			
			
			//connexion.commit();
			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			//connexion.close();
		}
	}
	
	public void getProcesoMayorizarDiariosBusquedaPorTipoMovimientoWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Long id_tipo_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			//parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,ProcesoMayorizarDiarioDataAccess.getColumnNameidTipoMovimiento(),ParameterTypeOperator.NONE);
			//queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			//ProcesoMayorizarDiarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			//procesomayorizardiarios=procesomayorizardiarioDataAccess.getEntities(connexion,queryWhereSelectParameters);

			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}
	public void ProcesarInformacionProcesoTest(List<ProcesoTest> procesoTests,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual) {
		
	}
	
	public void ProcesarInformacionProcesoCierrePeriodo(List<ProcesoCierrePeriodo> procesoCierrePeriodos,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual) {
		System.out.println(parametroGeneralUsuario.getid_empresa()+"-->"+parametroGeneralUsuario.getid_sucursal());
	}
	
	
	public void ProcesarInformacionProcesoMayorizarDiario(List<ProcesoMayorizarDiario> procesomayorizardiarios,String sTipoProceso,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual) throws SQLException, Exception {
		AsientoContableLogic asientocontableLogic=new AsientoContableLogic();

		try {
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			

			asientocontableLogic.setConnexion(this.connexion);
			
			if(sTipoProceso.equals(ContabilidadConstantes.PROCESO_MAYORIZAR_DIARIO)) {
				for(ProcesoMayorizarDiario procesomayorizardiario:procesomayorizardiarios) {
					if(procesomayorizardiario.getIsSelected()) {
						Long idAsientoContable=procesomayorizardiario.getId();
						
						
						asientocontableLogic.getEntity(idAsientoContable);
	
						asientocontableLogic.getAsientoContable().setid_estado_asiento_contable(AsientoContableConstantesFuncionesAdditional.LID_ESTADO_MAYORIZADO);
						
						asientocontableLogic.saveAsientoContable();
					}
				}
			} else if(sTipoProceso.equals(ContabilidadConstantes.PROCESO_DESMAYORIZAR_DIARIO)) {
				for(ProcesoMayorizarDiario procesomayorizardiario:procesomayorizardiarios) {
					if(procesomayorizardiario.getIsSelected()) {
						Long idAsientoContable=procesomayorizardiario.getId();
						asientocontableLogic.getEntity(idAsientoContable);
	
						asientocontableLogic.getAsientoContable().setid_estado_asiento_contable(AsientoContableConstantesFuncionesAdditional.LID_ESTADO_DESMAYORIZADO);
						
						asientocontableLogic.saveAsientoContable();
					}
				}
			} else if(sTipoProceso.equals(ContabilidadConstantes.PROCESO_ANULAR_DIARIO)) {
				for(ProcesoMayorizarDiario procesomayorizardiario:procesomayorizardiarios) {
					if(procesomayorizardiario.getIsSelected()) {
						Long idAsientoContable=procesomayorizardiario.getId();
						asientocontableLogic.getEntity(idAsientoContable);
	
						asientocontableLogic.getAsientoContable().setid_estado_asiento_contable(AsientoContableConstantesFuncionesAdditional.LID_ESTADO_ANULADO);
						
						asientocontableLogic.saveAsientoContable();
					}
				}
			}
			
			//this.connexion.commit();

		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			this.connexion.close();
		}
		/*String sTemp="temporal";
		
		for(ProcesoMayorizarDiario procesoMayorizarDiario:procesoMayorizarDiarios) {
			System.out.println(procesoMayorizarDiario.getId()+"->"+procesoMayorizarDiario.getIsSelected());
		}
		
		System.out.println(sTemp);
		*/	
	}
	
	public void getProcesoTotalizarSaldossBusquedaPorEjercicioPorPeriodoWithConnection(String sFinalQuery,Pagination pagination,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Long id_ejercicio,Long id_periodo)throws Exception {
		SaldoContableLogic saldocontableLogic=new SaldoContableLogic();

		try {
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
			//TO_REPLACE

			String sFinalQueryAux="";
			String sSelectQueryAux="";
			
			saldocontableLogic.setConnexion(this.connexion);
			
			saldocontableLogic.getEntities(sFinalQueryAux);
			
			for(SaldoContable saldocontable:saldocontableLogic.getSaldoContables()) {
				saldocontable.setdebito_mone_local(0.0);
				saldocontable.setcredito_mone_local(0.0);
				saldocontable.setsaldo_mone_local(0.0);
				saldocontable.setdebito_mone_extra(0.0);
				saldocontable.setcredito_mone_extra(0.0);
				saldocontable.setsaldo_mone_extra(0.0);
			}
			
						
			TotalSaldosLogic totalsaldosLogic=new TotalSaldosLogic();
			totalsaldosLogic.setConnexion(this.connexion);
			
			sFinalQueryAux="";
			sSelectQueryAux="";
			
			totalsaldosLogic.getEntities(sSelectQueryAux,sFinalQueryAux);
			
						
			for(TotalSaldos totalsaldos:totalsaldosLogic.getTotalSaldoss()) {
				if(!ExisteAsignaSaldoTotal(totalsaldos,saldocontableLogic.getSaldoContables())) {
					SaldoContable saldocontable= new SaldoContable();

					saldocontable.setid_empresa(parametroGeneralUsuario.getid_empresa());
					saldocontable.setid_sucursal(parametroGeneralUsuario.getid_sucursal());
					saldocontable.setid_ejercicio(id_ejercicio);
					saldocontable.setid_periodo(id_periodo);
					saldocontable.setid_cuenta_contable(totalsaldos.getid_cuenta_contable());
					saldocontable.setdebito_mone_local(totalsaldos.gettotal_debito());
					saldocontable.setcredito_mone_local(totalsaldos.gettotal_credito());
					saldocontable.setsaldo_mone_local(totalsaldos.gettotal_debito());
					saldocontable.setdebito_mone_extra(totalsaldos.gettotal_debito_extranjero());
					saldocontable.setcredito_mone_extra(totalsaldos.gettotal_credito_extranjero());
					saldocontable.setsaldo_mone_extra(totalsaldos.gettotal_credito());
					
					//FALTA REASIGNAR
					saldocontable.setid_anio(parametroGeneralUsuario.getid_anio());
					saldocontable.setid_mes(parametroGeneralUsuario.getid_mes());

					saldocontableLogic.getSaldoContables().add(saldocontable);
				}
			}
			
			saldocontableLogic.saveSaldoContables();
			
			this.connexion.commit();

		} catch(Exception e) {
			this.connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			this.connexion.close();
		}
	}
	
	public Boolean ExisteAsignaSaldoTotal(TotalSaldos totalsaldos,List<SaldoContable> saldocontables) throws Exception {
		Boolean existe=false;
		
		for(SaldoContable saldocontable:saldocontables) {
			if(saldocontable.getid_cuenta_contable().equals(totalsaldos.getid_cuenta_contable())) {
				existe=true;
				
				saldocontable.setdebito_mone_local(totalsaldos.gettotal_debito());
				saldocontable.setcredito_mone_local(totalsaldos.gettotal_credito());
				saldocontable.setsaldo_mone_local(totalsaldos.gettotal_debito());
				saldocontable.setdebito_mone_extra(totalsaldos.gettotal_debito_extranjero());
				saldocontable.setcredito_mone_extra(totalsaldos.gettotal_credito_extranjero());
				saldocontable.setsaldo_mone_extra(totalsaldos.gettotal_credito());
				
				break;
			}
		}
		
		return existe;
	}

	public void ProcesarInformacionProcesoTotalizarSaldos(List<ProcesoTotalizarSaldos> procesototalizarsaldo,ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual) throws SQLException, Exception {
		
	}
	
	public static void checkContabilidadToSave(Contabilidad contabilidad,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkContabilidadToSave(Contabilidad contabilidad,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkContabilidadToSaveAfter(Contabilidad contabilidad,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkContabilidadToSaves(List<Contabilidad> contabilidads,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkContabilidadToSaves(List<Contabilidad> contabilidads,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkContabilidadToSavesAfter(List<Contabilidad> contabilidads,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkContabilidadToGet(Contabilidad contabilidad,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkContabilidadToGets(List<Contabilidad> contabilidads,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateContabilidadToSave(Contabilidad contabilidad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateContabilidadToGet(Contabilidad contabilidad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectContabilidadActions(String sTipoJsonResponse,JSONObject jsonObjectContabilidad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonContabilidadDataTable(String sTipoJsonResponse,Contabilidad contabilidad,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonContabilidadsDataTable(String sTipoJsonResponse,List<Contabilidad> contabilidads,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayContabilidadColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayContabilidadsColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayContabilidadsColumns;
	}
	
	public static void updateJSONArrayContabilidadActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectContabilidad,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	
	//CONTROL_FUNCION1
	
	
	
	
	public static void quitarEspaciosContabilidad(Contabilidad contabilidad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		contabilidad.setcodigo(contabilidad.getcodigo().trim());
	}
	
	public static void quitarEspaciosContabilidads(List<Contabilidad> contabilidads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Contabilidad contabilidad: contabilidads) {
			contabilidad.setcodigo(contabilidad.getcodigo().trim());
		
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesContabilidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	//CONTROL_FUNCION2
}

