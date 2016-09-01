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

import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.util.DeepLoadType;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.contabilidad.util.CuentaContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.ProcesoSincronizarSaldosConstantesFunciones;
//import com.bydan.erp.contabilidad.util.report.ProcesoSincronizarSaldosReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.ProcesoSincronizarSaldosParameterGeneral;

import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.FuncionesJsp;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;
////import com.bydan.erp.contabilidad.business.interfaces.ProcesoSincronizarSaldosAdditionable;

//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.contabilidad.business.logic.ContabilidadLogicAdditional;
import com.bydan.erp.contabilidad.business.logic.CuentaContableLogic;
import com.bydan.erp.contabilidad.business.logic.PeriodoLogic;
import com.bydan.erp.contabilidad.business.logic.SaldoContableLogic;

@SuppressWarnings("unused")
final public class ProcesoSincronizarSaldosLogicAdditional extends ProcesoSincronizarSaldosLogic{		
	
	//CONTROL_INICIO
	public  ProcesoSincronizarSaldosLogicAdditional()throws Exception {
		super();
    }
	
	public static void checkProcesoSincronizarSaldosToSave(ProcesoSincronizarSaldos procesosincronizarsaldos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_1
	}
	
	public static void checkProcesoSincronizarSaldosToSave(ProcesoSincronizarSaldos procesosincronizarsaldos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_2
	}
	
	public static void checkProcesoSincronizarSaldosToSaveAfter(ProcesoSincronizarSaldos procesosincronizarsaldos,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_3
	}
	
	public static void checkProcesoSincronizarSaldosToSaves(List<ProcesoSincronizarSaldos> procesosincronizarsaldoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_4
	}
	
	public static void checkProcesoSincronizarSaldosToSaves(List<ProcesoSincronizarSaldos> procesosincronizarsaldoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_5
	}
	
	public static void checkProcesoSincronizarSaldosToSavesAfter(List<ProcesoSincronizarSaldos> procesosincronizarsaldoss,DatosCliente datosCliente,Connexion connexion,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_6
	}
	
	public static void checkProcesoSincronizarSaldosToGet(ProcesoSincronizarSaldos procesosincronizarsaldos,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_7
	}
	
	public static void checkProcesoSincronizarSaldosToGets(List<ProcesoSincronizarSaldos> procesosincronizarsaldoss,DatosCliente datosCliente,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_8
	}
	
	public static void updateProcesoSincronizarSaldosToSave(ProcesoSincronizarSaldos procesosincronizarsaldos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_9
	}		
						
	public static void updateProcesoSincronizarSaldosToGet(ProcesoSincronizarSaldos procesosincronizarsaldos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_10
	}	
	
	public static void updateJSONObjectProcesoSincronizarSaldosActions(String sTipoJsonResponse,JSONObject jsonObjectProcesoSincronizarSaldos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_11
	}
	
	public static String getJsonProcesoSincronizarSaldosDataTable(String sTipoJsonResponse,ProcesoSincronizarSaldos procesosincronizarsaldos,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_12
		
		return sJsonDataTable;
	}
	
	public static String getJsonProcesoSincronizarSaldossDataTable(String sTipoJsonResponse,List<ProcesoSincronizarSaldos> procesosincronizarsaldoss,ArrayList<DatoGeneral> arrDatoGeneral) {
		String sJsonDataTable="";
		
		//CONTROL_13
		
		return sJsonDataTable;
	}
	
	public static JSONArray getJsonArrayProcesoSincronizarSaldosColumnsDefaultTable(String sTipoJsonResponse,ArrayList<DatoGeneral> arrDatoGeneral)throws Exception {	
		JSONArray jsonArrayProcesoSincronizarSaldossColumns = new JSONArray();
		
		//CONTROL_14
		
		return jsonArrayProcesoSincronizarSaldossColumns;
	}
	
	public static void updateJSONArrayProcesoSincronizarSaldosActionsColumns(String sTipoJsonResponse,JSONArray jsonObjectProcesoSincronizarSaldos,ArrayList<DatoGeneral> arrDatoGeneral) {	
		//CONTROL_15
	}
	
	//PARA ACCIONES ADDITIONAL
	public Boolean ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,String sProceso,List<ProcesoSincronizarSaldos> procesosincronizarsaldoss) throws Exception  {
		//CONTROL_16
		Boolean esProcesado=true;
		
		try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
		
			this.connexion.commit();
			
		} catch(Exception e) {
			this.connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		this.connexion.close();			
		}
		
		return esProcesado;
	}		
	
	//PARA ACCIONES NORMALES		
	public static GeneralEntityParameterReturnGeneral procesarAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral)throws Exception {				
		//CONTROL_17
		
		 try {	
			
			
			//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();
				
			
			return generalEntityReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	//ACCION TABLA PROCESO DESDE BUSQUEDA
	public static GeneralEntityParameterReturnGeneral ProcesarAccion(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcion,Usuario usuario,GeneralEntityLogic generalEntityLogic,String sProceso,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral) throws Exception  {
		//CONTROL_18
		//GeneralEntityParameterReturnGeneral generalEntityReturnGeneral=new GeneralEntityParameterReturnGeneral();
			
		try {	
			//this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();			
		
			//this.connexion.commit();
			
		} catch(Exception e) {
			//this.connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
      		//this.connexion.close();			
		}
		
		return generalEntityReturnGeneral;
	}
	
	
	
	
	public Boolean ProcesarInformacionProcesoSincronizarSaldos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,List<ProcesoSincronizarSaldos> procesosincronizarsaldoss,String sTipoBusqueda,Long id_ejercicioBusquedaProcesoSincronizarSaldos,Long id_periodoBusquedaProcesoSincronizarSaldos) throws Exception {
		Boolean procesado=false;

		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}

		return procesado;
	}

	
	public static GeneralEntityParameterReturnGeneral ProcesarInformacionProcesoSincronizarSaldos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,GeneralEntityLogic generalEntityLogic,Object objects,GeneralEntityParameterGeneral generalEntityParameterGeneral,GeneralEntityParameterReturnGeneral generalEntityReturnGeneral,String sTipoBusqueda,Long id_ejercicioBusquedaProcesoSincronizarSaldos,Long id_periodoBusquedaProcesoSincronizarSaldos) throws Exception {

		String sFinalQuery="";
		String sQueryExecute="";
		String sQuerySelect="";
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		try {
			SaldoContableLogic saldoContableLogic=new SaldoContableLogic();
			VistaTotalSaldosLogic vistaTotalSaldosLogic=new VistaTotalSaldosLogic();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			CuentaContableLogic cuentaContableLogic=new CuentaContableLogic();
			List<CuentaContable> cuentacontablesPadres= new ArrayList<CuentaContable>();
			
			saldoContableLogic.setConnexion(generalEntityLogic.getConnexion());
			vistaTotalSaldosLogic.setConnexion(generalEntityLogic.getConnexion());
			periodoLogic.setConnexion(generalEntityLogic.getConnexion());
			cuentaContableLogic.setConnexion(generalEntityLogic.getConnexion());
			
			sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_ejercicio="+id_ejercicioBusquedaProcesoSincronizarSaldos+" and id_periodo="+id_periodoBusquedaProcesoSincronizarSaldos;
			
			sQueryExecute="update contabilidad.saldo_contable set debito_mone_local=0,credito_mone_local=0,saldo_mone_local=0,debito_mone_extra=0,credito_mone_extra=0,saldo_mone_extra=0 "+sFinalQuery;
			saldoContableLogic.executeQuery(sQueryExecute);
			
			sQuerySelect="select id_cuenta_contable,sum(d.debito_local) as total_debito_moneda_local,sum(d.credito_local) as total_credito_moneda_local,sum(d.debito_extran) as total_debito_moneda_extran,sum(d.credito_extran) as total_credito_moneda_extran ";
			sQuerySelect+=" from contabilidad.asiento_contable a inner join contabilidad.detalle_asiento_contable d on";
			sQuerySelect+=" a.id=d.id_asiento_contable ";
			
			sFinalQuery=" where a.id_empresa="+parametroGeneralUsuario.getid_empresa()+" and a.id_ejercicio="+id_ejercicioBusquedaProcesoSincronizarSaldos+" and a.id_periodo="+id_periodoBusquedaProcesoSincronizarSaldos+" group by id_cuenta_contable";
			
			vistaTotalSaldosLogic.getEntities(sQuerySelect, sFinalQuery);
			
			classes.add(new Classe(CuentaContable.class));
			vistaTotalSaldosLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(VistaTotalSaldos vistaTotalSaldos:vistaTotalSaldosLogic.getVistaTotalSaldoss()) {				
				ProcesoSincronizarSaldosLogicAdditional.AgregarSaldoContable(saldoContableLogic,vistaTotalSaldos,periodoLogic,parametroGeneralUsuario,id_ejercicioBusquedaProcesoSincronizarSaldos,id_periodoBusquedaProcesoSincronizarSaldos);
				
				//AGRUPA PADRES CUENTAS CONTABLES
				if(vistaTotalSaldos.getCuentaContable().getid_cuenta_contable()!=null && !vistaTotalSaldos.getCuentaContable().getid_cuenta_contable().equals(vistaTotalSaldos.getCuentaContable().getId()) 
						&& vistaTotalSaldos.getCuentaContable().getid_cuenta_contable()>0) {
					cuentaContableLogic.getEntity(vistaTotalSaldos.getCuentaContable().getid_cuenta_contable());
					
					if(!CuentaContableConstantesFunciones.ExisteEnLista(cuentacontablesPadres, cuentaContableLogic.getCuentaContable(), false)) {
						cuentacontablesPadres.add(cuentaContableLogic.getCuentaContable());
					}
					
				}
			}
			
			//TOTALIZA CUENTAS CONTABLES PADRES 1er NIVEL
			if(cuentacontablesPadres.size()>0) {
				ProcesoSincronizarSaldosLogicAdditional.TotalizarSaldoContablesPadres(cuentacontablesPadres,cuentaContableLogic,vistaTotalSaldosLogic,saldoContableLogic,periodoLogic,parametroGeneralUsuario,id_ejercicioBusquedaProcesoSincronizarSaldos,id_periodoBusquedaProcesoSincronizarSaldos);
			}
			
			/*
			for(CuentaContable cuentaContablePadre:cuentacontablesPadres) {
				sQuerySelect="select c.id_cuenta_contable,sum(s.debito_mone_local) as total_debito_moneda_local,sum(s.credito_mone_local) as total_credito_moneda_local,sum(s.debito_mone_extra) as total_debito_moneda_extran,sum(s.credito_mone_extra) as total_credito_moneda_extran ";
				sQuerySelect+=" from contabilidad.saldo_contable s inner join contabilidad.cuenta_contable c on";
				sQuerySelect+=" c.id=s.id_cuenta_contable ";
				
				sFinalQuery=" where s.id_empresa="+parametroGeneralUsuario.getid_empresa()+" and s.id_ejercicio="+id_ejercicioBusquedaProcesoSincronizarSaldos+" and s.id_periodo="+id_periodoBusquedaProcesoSincronizarSaldos;
				sFinalQuery+=" and c.id_cuenta_contable="+cuentaContablePadre.getId();
				sFinalQuery+=" group by c.id_cuenta_contable";
				
				vistaTotalSaldosLogic.getEntities(sQuerySelect, sFinalQuery);
				
				classes.add(new Classe(CuentaContable.class));
				vistaTotalSaldosLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
				
				for(VistaTotalSaldos vistaTotalSaldos:vistaTotalSaldosLogic.getVistaTotalSaldoss()) {				
					ProcesoSincronizarSaldosLogicAdditional.AgregarSaldoContable(saldoContableLogic,vistaTotalSaldos,periodoLogic,parametroGeneralUsuario,id_ejercicioBusquedaProcesoSincronizarSaldos,id_periodoBusquedaProcesoSincronizarSaldos);					
				}
			}
			*/
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}

		return generalEntityReturnGeneral;
	}
	
	public static void TotalizarSaldoContablesPadres(List<CuentaContable> cuentacontablesPadres,CuentaContableLogic cuentaContableLogic,VistaTotalSaldosLogic vistaTotalSaldosLogic,SaldoContableLogic saldoContableLogic,PeriodoLogic periodoLogic,ParametroGeneralUsuario parametroGeneralUsuario,Long id_ejercicioBusquedaProcesoSincronizarSaldos,Long id_periodoBusquedaProcesoSincronizarSaldos) throws Exception {
		List<CuentaContable> cuentacontablesAbuelos= new ArrayList<CuentaContable>();
		String sQuerySelect="";
		String sFinalQuery="";
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		for(CuentaContable cuentaContablePadre:cuentacontablesPadres) {
			sQuerySelect="select c.id_cuenta_contable,sum(s.debito_mone_local) as total_debito_moneda_local,sum(s.credito_mone_local) as total_credito_moneda_local,sum(s.debito_mone_extra) as total_debito_moneda_extran,sum(s.credito_mone_extra) as total_credito_moneda_extran ";
			sQuerySelect+=" from contabilidad.saldo_contable s inner join contabilidad.cuenta_contable c on";
			sQuerySelect+=" c.id=s.id_cuenta_contable ";
			
			sFinalQuery=" where s.id_empresa="+parametroGeneralUsuario.getid_empresa()+" and s.id_ejercicio="+id_ejercicioBusquedaProcesoSincronizarSaldos+" and s.id_periodo="+id_periodoBusquedaProcesoSincronizarSaldos;
			sFinalQuery+=" and c.id_cuenta_contable="+cuentaContablePadre.getId();
			sFinalQuery+=" group by c.id_cuenta_contable";
			
			vistaTotalSaldosLogic.getEntities(sQuerySelect, sFinalQuery);
			
			classes.add(new Classe(CuentaContable.class));
			vistaTotalSaldosLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
		
			for(VistaTotalSaldos vistaTotalSaldos:vistaTotalSaldosLogic.getVistaTotalSaldoss()) {				
				ProcesoSincronizarSaldosLogicAdditional.AgregarSaldoContable(saldoContableLogic,vistaTotalSaldos,periodoLogic,parametroGeneralUsuario,id_ejercicioBusquedaProcesoSincronizarSaldos,id_periodoBusquedaProcesoSincronizarSaldos);
				
				//AGRUPA PADRES CUENTAS CONTABLES
				if(vistaTotalSaldos.getCuentaContable().getid_cuenta_contable()!=null && !vistaTotalSaldos.getCuentaContable().getid_cuenta_contable().equals(vistaTotalSaldos.getCuentaContable().getId()) 
						&& vistaTotalSaldos.getCuentaContable().getid_cuenta_contable()>0) {
					cuentaContableLogic.getEntity(vistaTotalSaldos.getCuentaContable().getid_cuenta_contable());
					
					if(!CuentaContableConstantesFunciones.ExisteEnLista(cuentacontablesAbuelos, cuentaContableLogic.getCuentaContable(), false)) {
						cuentacontablesAbuelos.add(cuentaContableLogic.getCuentaContable());
					}					
				}
			}						
		}
		
		if(cuentacontablesAbuelos.size()>0) {
			ProcesoSincronizarSaldosLogicAdditional.TotalizarSaldoContablesPadres(cuentacontablesAbuelos,cuentaContableLogic,vistaTotalSaldosLogic,saldoContableLogic,periodoLogic,parametroGeneralUsuario,id_ejercicioBusquedaProcesoSincronizarSaldos,id_periodoBusquedaProcesoSincronizarSaldos);
		}
	}
	
	public static void AgregarSaldoContable(SaldoContableLogic saldoContableLogic,VistaTotalSaldos vistaTotalSaldos,PeriodoLogic periodoLogic,ParametroGeneralUsuario parametroGeneralUsuario,Long id_ejercicioBusquedaProcesoSincronizarSaldos,Long id_periodoBusquedaProcesoSincronizarSaldos) throws Exception {
		String sFinalQuery=" where id_empresa="+parametroGeneralUsuario.getid_empresa()+" and id_ejercicio="+id_ejercicioBusquedaProcesoSincronizarSaldos+" and id_periodo="+id_periodoBusquedaProcesoSincronizarSaldos +" and id_cuenta_contable="+vistaTotalSaldos.getid_cuenta_contable();
		
		saldoContableLogic.getEntity(sFinalQuery);
	
		if(saldoContableLogic.getSaldoContable()!=null  && saldoContableLogic.getSaldoContable().getId()>0) {
			saldoContableLogic.getSaldoContable().setdebito_mone_local(vistaTotalSaldos.gettotal_debito_moneda_local());
			saldoContableLogic.getSaldoContable().setcredito_mone_local(vistaTotalSaldos.gettotal_credito_moneda_local());
			saldoContableLogic.getSaldoContable().setsaldo_mone_local(saldoContableLogic.getSaldoContable().getdebito_mone_local() - saldoContableLogic.getSaldoContable().getcredito_mone_local());
			
			saldoContableLogic.getSaldoContable().setdebito_mone_extra(vistaTotalSaldos.gettotal_debito_moneda_extran());
			saldoContableLogic.getSaldoContable().setcredito_mone_extra(vistaTotalSaldos.gettotal_credito_moneda_extran());
			saldoContableLogic.getSaldoContable().setsaldo_mone_extra(saldoContableLogic.getSaldoContable().getdebito_mone_extra() - saldoContableLogic.getSaldoContable().getcredito_mone_extra());
			
			saldoContableLogic.saveSaldoContable();
		} else {
			saldoContableLogic.setSaldoContable(new SaldoContable());
			
			periodoLogic.getEntity(id_periodoBusquedaProcesoSincronizarSaldos);
			
			//BASICO
			saldoContableLogic.getSaldoContable().setid_empresa(parametroGeneralUsuario.getid_empresa());
			saldoContableLogic.getSaldoContable().setid_sucursal(parametroGeneralUsuario.getid_sucursal());
			saldoContableLogic.getSaldoContable().setid_ejercicio(id_ejercicioBusquedaProcesoSincronizarSaldos);
			saldoContableLogic.getSaldoContable().setid_periodo(id_periodoBusquedaProcesoSincronizarSaldos);
			
			//ANIO MES
			saldoContableLogic.getSaldoContable().setid_anio(periodoLogic.getPeriodo().getid_anio());
			saldoContableLogic.getSaldoContable().setid_mes(periodoLogic.getPeriodo().getid_mes());
			
			//VALORES
			saldoContableLogic.getSaldoContable().setid_cuenta_contable(vistaTotalSaldos.getid_cuenta_contable());
			
			saldoContableLogic.getSaldoContable().setdebito_mone_local(vistaTotalSaldos.gettotal_debito_moneda_local());
			saldoContableLogic.getSaldoContable().setcredito_mone_local(vistaTotalSaldos.gettotal_credito_moneda_local());
			saldoContableLogic.getSaldoContable().setsaldo_mone_local(saldoContableLogic.getSaldoContable().getdebito_mone_local() - saldoContableLogic.getSaldoContable().getcredito_mone_local());
			
			saldoContableLogic.getSaldoContable().setdebito_mone_extra(vistaTotalSaldos.gettotal_debito_moneda_extran());
			saldoContableLogic.getSaldoContable().setcredito_mone_extra(vistaTotalSaldos.gettotal_credito_moneda_extran());
			saldoContableLogic.getSaldoContable().setsaldo_mone_extra(saldoContableLogic.getSaldoContable().getdebito_mone_extra() - saldoContableLogic.getSaldoContable().getcredito_mone_extra());
			
			saldoContableLogic.saveSaldoContable();
		}
	}
	//CONTROL_FUNCION1		
		
	//CONTROL_FUNCION2
}

