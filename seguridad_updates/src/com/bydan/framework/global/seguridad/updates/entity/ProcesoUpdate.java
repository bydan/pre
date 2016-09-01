package com.bydan.framework.global.seguridad.updates.entity;

import java.util.ArrayList;
import java.util.List;

import com.bydan.framework.global.seguridad.updates.a2015.AuxiliarGlobalUpdates2015;
import com.bydan.framework.global.seguridad.updates.a2015.m01.AuxiliarGlobalUpdates201501;
import com.bydan.framework.global.seguridad.updates.a2015.m02.AuxiliarGlobalUpdates201502;
import com.bydan.framework.global.seguridad.updates.a2015.m03.AuxiliarGlobalUpdates201503;
import com.bydan.framework.global.seguridad.updates.a2015.m04.AuxiliarGlobalUpdates201504;
import com.bydan.framework.global.seguridad.updates.a2015.m05.AuxiliarGlobalUpdates201505;
import com.bydan.framework.global.seguridad.updates.a2015.m06.AuxiliarGlobalUpdates201506;
import com.bydan.framework.global.seguridad.updates.a2015.m07.AuxiliarGlobalUpdates201507;
import com.bydan.framework.global.seguridad.updates.a2015.m08.AuxiliarGlobalUpdates201508;
import com.bydan.framework.global.seguridad.updates.a2015.m09.AuxiliarGlobalUpdates201509;
import com.bydan.framework.global.seguridad.updates.a2015.m10.AuxiliarGlobalUpdates201510;
import com.bydan.framework.global.seguridad.updates.a2015.m11.AuxiliarGlobalUpdates201511;
import com.bydan.framework.global.seguridad.updates.a2015.m12.AuxiliarGlobalUpdates201512;

import com.bydan.framework.global.seguridad.updates.a2014.AuxiliarGlobalUpdates2014;
import com.bydan.framework.global.seguridad.updates.a2014.m01.AuxiliarGlobalUpdates201401;
import com.bydan.framework.global.seguridad.updates.a2014.m02.AuxiliarGlobalUpdates201402;
import com.bydan.framework.global.seguridad.updates.a2014.m03.AuxiliarGlobalUpdates201403;
import com.bydan.framework.global.seguridad.updates.a2014.m04.AuxiliarGlobalUpdates201404;
import com.bydan.framework.global.seguridad.updates.a2014.m05.AuxiliarGlobalUpdates201405;
import com.bydan.framework.global.seguridad.updates.a2014.m06.AuxiliarGlobalUpdates201406;
import com.bydan.framework.global.seguridad.updates.a2014.m07.AuxiliarGlobalUpdates201407;
import com.bydan.framework.global.seguridad.updates.a2014.m08.AuxiliarGlobalUpdates201408;
import com.bydan.framework.global.seguridad.updates.a2014.m09.AuxiliarGlobalUpdates201409;
import com.bydan.framework.global.seguridad.updates.a2014.m10.AuxiliarGlobalUpdates201410;
import com.bydan.framework.global.seguridad.updates.a2014.m11.AuxiliarGlobalUpdates201411;
import com.bydan.framework.global.seguridad.updates.a2014.m12.AuxiliarGlobalUpdates201412;

//@SuppressWarnings("unused")
public class ProcesoUpdate extends GeneralEntityUpdate {
	
	/************GENERAL***********/
	public static Boolean EJECUTAR=true; 	 
	public static Boolean ES_ANUAL=false;
	public static Boolean ES_MENSUAL=true;
	public static Boolean ES_ACTIVAR_REINTENTAR=false; 
	public static Boolean ES_DESACTIVAR_TODO=false; 
	
	public static Boolean EJECUTAR_UN_SOLO_QUERY=false;	
	/************GENERAL***********/
	
	
	/************ARCHIVO SQL***********/
	//IDENTIFICA SQL
	//ES PROCESO ESPECIFICO
	//1.- CUANDO ES PROCESO ESPECIFICO, LA FECHA ANIO,MES ITENDIFICA EN QUE ARCHIVO SE VA CONSTRUIR Y EL PROCESO LO DIFERENCIA DE OTROS PROCESOS DEL MISMO DIA
	//2.- EL PRIMER ARCHIVO CARGADO SERA EL GUIA
	
	//PUEDE FUNCIONAR SOLO PARA PROCESO ANUAL
	//CONFIG SQL AUXILIAR--> ANIO=2014, MES=01, NUMERO_SQL=000,DIA=01, EL ARCHIVO ES EL UNICO CON 000 (000_01.sql)
	public static String ANIO_SQL="2014";
	
	//COMPLETA PARA PROCESO POR ARCHIVO/S
	public static String MES_SQL="05";
	public static String NUMERO_SQL="000";
	public static String DIA_SQL="01";	
	
	//NO USAR, YA QUE EL ID COMPUESTO SE GUARDA EN DB, Y AL DETALLAR MUCHO, SE TENDRIA ID TEMPORALES O UPDATTES FALSOS, LA UNIDAD DE PROCESO O UPDATE ES UN ARCHIVO, TRABAJAR POR ANIO Y MES
	public static String NUMERO_PROCESO_SQL="";
	//IDENTIFICA SQL
	/************ARCHIVO SQL***********/
	
	
	/************CONTROL PROCESO***********/
	//IDENTIFICA PROCESO Y EN PARTE SQL 
	public static String ANIO="2010";
	public static String MES="09";
	public static String DIA="08";
	public static String HORA="07";
	public static String MINUTO="05";
	//IDENTIFICA PROCESO Y EN PARTE SQL
	public static String NUMERO_PROCESO="";
	/************CONTROL PROCESO***********/
		
	
	public static String CODIGO_PROCESO=ANIO+"-"+MES+"-"+DIA+" "+HORA+":"+MINUTO+"";
	public static String CODIGO_SQL=ANIO_SQL+"-"+MES_SQL+"_"+NUMERO_SQL+"";
	
	private List<AnioUpdate> aniosupdates;

	public List<AnioUpdate> getAniosupdates() {
		return aniosupdates;
	}

	public void setAniosupdates(List<AnioUpdate> aniosupdates) {
		this.aniosupdates = aniosupdates;
	}

	public ProcesoUpdate(List<AnioUpdate> aniosupdates) {
		super();
		this.aniosupdates = aniosupdates;
	}
	
	public ProcesoUpdate( ) {		
		super();
		
		this.aniosupdates=new ArrayList<AnioUpdate>();
	}
	
	public static ProcesoUpdate cargarProcesoQuerysUpdatePorMesAnio() throws Exception {
		return ProcesoUpdate.cargarProcesoQuerysUpdatePorMesAnio(ProcesoUpdate.ANIO_SQL,ProcesoUpdate.MES_SQL,ProcesoUpdate.NUMERO_PROCESO_SQL);
	}
	
	public static ProcesoUpdate cargarProcesoQuerysUpdatePorMesAnio(String sTipoAnioSql,String sTipoMesSql,String sNumeroProceso) throws Exception {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();		
		
		//CARGA Y DEFINE QUE ARCHIVOS QUERY SE VAN A EJECUTAR
		procesoUpdate=ProcesoUpdate.cargarProcesoUpdatePorMesAnio(sTipoAnioSql,sTipoMesSql,sNumeroProceso);
		
		//CARGA LOS QUERYS DIVIDIDOS EN "BLOQUE"
		ProcesoUpdate.cargarQuerysUpdatePorMesAnio(sTipoAnioSql,sTipoMesSql,sNumeroProceso,procesoUpdate);
		
		return procesoUpdate;
	}
	
	public static void cargarQuerysUpdatePorMesAnio(String sTipoAnioSql,String sTipoMesSql,String sNumeroProceso,ProcesoUpdate procesoUpdate) throws Exception {
		GeneralEntityUpdateAuxiliar.cargarQuerysUpdate(sTipoAnioSql,sTipoMesSql,sNumeroProceso,procesoUpdate);
	}
	
	public static ProcesoUpdate cargarProcesoUpdatePorMesAnio(String sTipoAnioSql,String sTipoMesSql, String sNumeroProceso) throws Exception {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
		String sTipoAnioMes=sTipoAnioSql+"_"+sTipoMesSql;		
		
		switch(sTipoAnioMes) {
			//2014
			case "2014_01": procesoUpdate=AuxiliarGlobalUpdates2014.cargarProcesoUpdate2014Mes(1);break;
			case "2014_02": procesoUpdate=AuxiliarGlobalUpdates2014.cargarProcesoUpdate2014Mes(2);break;
			case "2014_03": procesoUpdate=AuxiliarGlobalUpdates2014.cargarProcesoUpdate2014Mes(3);break;
			case "2014_04": procesoUpdate=AuxiliarGlobalUpdates2014.cargarProcesoUpdate2014Mes(4);break;
			case "2014_05": procesoUpdate=AuxiliarGlobalUpdates2014.cargarProcesoUpdate2014Mes(5);break;
			case "2014_06": procesoUpdate=AuxiliarGlobalUpdates2014.cargarProcesoUpdate2014Mes(6);break;
			case "2014_07": procesoUpdate=AuxiliarGlobalUpdates2014.cargarProcesoUpdate2014Mes(7);break;
			case "2014_08": procesoUpdate=AuxiliarGlobalUpdates2014.cargarProcesoUpdate2014Mes(8);break;
			case "2014_09": procesoUpdate=AuxiliarGlobalUpdates2014.cargarProcesoUpdate2014Mes(9);break;
			case "2014_10": procesoUpdate=AuxiliarGlobalUpdates2014.cargarProcesoUpdate2014Mes(10);break;
			case "2014_11": procesoUpdate=AuxiliarGlobalUpdates2014.cargarProcesoUpdate2014Mes(11);break;
			case "2014_12": procesoUpdate=AuxiliarGlobalUpdates2014.cargarProcesoUpdate2014Mes(12);break;
			
			//2015
			case "2015_01": procesoUpdate=AuxiliarGlobalUpdates2015.cargarProcesoUpdate2015Mes(1);break;
			case "2015_02": procesoUpdate=AuxiliarGlobalUpdates2015.cargarProcesoUpdate2015Mes(2);break;
			case "2015_03": procesoUpdate=AuxiliarGlobalUpdates2015.cargarProcesoUpdate2015Mes(3);break;
			case "2015_04": procesoUpdate=AuxiliarGlobalUpdates2015.cargarProcesoUpdate2015Mes(4);break;
			case "2015_05": procesoUpdate=AuxiliarGlobalUpdates2015.cargarProcesoUpdate2015Mes(5);break;
			case "2015_06": procesoUpdate=AuxiliarGlobalUpdates2015.cargarProcesoUpdate2015Mes(6);break;
			case "2015_07": procesoUpdate=AuxiliarGlobalUpdates2015.cargarProcesoUpdate2015Mes(7);break;
			case "2015_08": procesoUpdate=AuxiliarGlobalUpdates2015.cargarProcesoUpdate2015Mes(8);break;
			case "2015_09": procesoUpdate=AuxiliarGlobalUpdates2015.cargarProcesoUpdate2015Mes(9);break;
			case "2015_10": procesoUpdate=AuxiliarGlobalUpdates2015.cargarProcesoUpdate2015Mes(10);break;
			case "2015_11": procesoUpdate=AuxiliarGlobalUpdates2015.cargarProcesoUpdate2015Mes(11);break;
			case "2015_12": procesoUpdate=AuxiliarGlobalUpdates2015.cargarProcesoUpdate2015Mes(12);break;
			
			default:
				break;							
		}
		
		return procesoUpdate;
	}
	
	public static ProcesoUpdate cargarProcesoQuerysUpdatePorAnio() throws Exception {
		return ProcesoUpdate.cargarProcesoQuerysUpdatePorAnio(ProcesoUpdate.ANIO_SQL,ProcesoUpdate.NUMERO_PROCESO_SQL);
	}
	
	public static ProcesoUpdate cargarProcesoQuerysUpdatePorAnio(String sTipoAnioSql,String sNumeroProceso) throws Exception {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();		
		
		//CARGA Y DEFINE QUE ARCHIVOS QUERY SE VAN A EJECUTAR
		procesoUpdate=ProcesoUpdate.cargarProcesoUpdatePorAnio(sTipoAnioSql,sNumeroProceso);
		
		//CARGA LOS QUERYS DIVIDIDOS EN "BLOQUE"
		ProcesoUpdate.cargarQuerysUpdatePorAnio(sTipoAnioSql,sNumeroProceso,procesoUpdate);
		
		return procesoUpdate;
	}
	
	public static ProcesoUpdate cargarProcesoUpdatePorAnio(String sTipoAnioSql, String sNumeroProceso) throws Exception {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
	
		switch(sTipoAnioSql) {
			case "2014": procesoUpdate=AuxiliarGlobalUpdates2014.cargarProcesoUpdate(sTipoAnioSql,sNumeroProceso);break;
			case "2015": procesoUpdate=AuxiliarGlobalUpdates2015.cargarProcesoUpdate(sTipoAnioSql,sNumeroProceso);break;
			
			default:
				break;							
		}
		
		return procesoUpdate;
	}
	
	public static void cargarQuerysUpdatePorAnio(String sTipoAnioSql,String sNumeroProceso,ProcesoUpdate procesoUpdate) throws Exception {
		GeneralEntityUpdateAuxiliar.cargarQuerysUpdate(sTipoAnioSql,sNumeroProceso,procesoUpdate);
		/*
		switch(sTipoAnioSql) {
			case "2014": AuxiliarGlobalUpdates2014.cargarQuerysUpdate(sTipoAnioSql,sNumeroProceso,procesoUpdate);break;//,AuxiliarGlobalUpdates2014.class			
			case "2015": AuxiliarGlobalUpdates2015.cargarQuerysUpdate(sTipoAnioSql,sNumeroProceso,procesoUpdate);break;//,AuxiliarGlobalUpdates2015.class
			
			default:break;							
		}
		*/
	}
	
	public static ProcesoUpdate cargarProcesoQuerysUpdatePorSqls() throws Exception {
		return ProcesoUpdate.cargarProcesoQuerysUpdatePorSqls(ProcesoUpdate.ANIO_SQL,ProcesoUpdate.MES_SQL,ProcesoUpdate.DIA_SQL,ProcesoUpdate.NUMERO_SQL,ProcesoUpdate.NUMERO_PROCESO_SQL);
	}
	
	public static ProcesoUpdate cargarProcesoQuerysUpdatePorSqls(String sTipoAnioSql,String sTipoMesSql,String sTipoDiaSql,String sNumeroSql,String sNumeroProceso) throws Exception {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();		
		
		//CARGA Y DEFINE QUE ARCHIVOS QUERY SE VAN A EJECUTAR
		procesoUpdate=ProcesoUpdate.cargarProcesoUpdatePorSqls(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);
		
		//CARGA LOS QUERYS DIVIDIDOS EN "BLOQUE"
		ProcesoUpdate.cargarQuerysUpdatePorSqls(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso,procesoUpdate);
		
		return procesoUpdate;
	}
	
	public static ProcesoUpdate cargarProcesoUpdatePorSqls(String sTipoAnioSql,String sTipoMesSql,String sTipoDiaSql,String sNumeroSql,String sNumeroProceso) throws Exception {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
		
		String sTipoAnioMes=sTipoAnioSql+"_"+sTipoMesSql;		
		
		/*
		String sTipoAnioMesDiaProceso=sTipoAnio+"_"+sTipoMes+"_"+sTipoDia;
		
		if(!sNumeroProceso.equals("")) {
			sTipoAnioMesDiaProceso+="_"+sNumeroProceso;
		}
		*/
		
		switch(sTipoAnioMes) {//sTipoAnioMesDiaProceso
			/*
			case "2014_04_02":
				procesoUpdate=AuxiliarGlobalUpdates201504.cargarProcesoUpdate2014_04_02();
				break;
			*/
			//2014
			case "2014_01": procesoUpdate=AuxiliarGlobalUpdates201401.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2014_02": procesoUpdate=AuxiliarGlobalUpdates201402.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2014_03": procesoUpdate=AuxiliarGlobalUpdates201403.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2014_04": procesoUpdate=AuxiliarGlobalUpdates201404.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2014_05": procesoUpdate=AuxiliarGlobalUpdates201405.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2014_06": procesoUpdate=AuxiliarGlobalUpdates201406.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2014_07": procesoUpdate=AuxiliarGlobalUpdates201407.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2014_08": procesoUpdate=AuxiliarGlobalUpdates201408.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2014_09": procesoUpdate=AuxiliarGlobalUpdates201409.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2014_10": procesoUpdate=AuxiliarGlobalUpdates201410.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2014_11": procesoUpdate=AuxiliarGlobalUpdates201411.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2014_12": procesoUpdate=AuxiliarGlobalUpdates201412.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			
			//2015
			case "2015_01": procesoUpdate=AuxiliarGlobalUpdates201501.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2015_02": procesoUpdate=AuxiliarGlobalUpdates201502.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2015_03": procesoUpdate=AuxiliarGlobalUpdates201503.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2015_04": procesoUpdate=AuxiliarGlobalUpdates201504.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2015_05": procesoUpdate=AuxiliarGlobalUpdates201505.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2015_06": procesoUpdate=AuxiliarGlobalUpdates201506.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2015_07": procesoUpdate=AuxiliarGlobalUpdates201507.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2015_08": procesoUpdate=AuxiliarGlobalUpdates201508.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2015_09": procesoUpdate=AuxiliarGlobalUpdates201509.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2015_10": procesoUpdate=AuxiliarGlobalUpdates201510.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2015_11": procesoUpdate=AuxiliarGlobalUpdates201511.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
			case "2015_12": procesoUpdate=AuxiliarGlobalUpdates201512.cargarProcesoUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso);break;
									
			default:
				break;							
		}
		
		return procesoUpdate;
	}
	
	public static void cargarQuerysUpdatePorSqls(String sTipoAnioSql,String sTipoMesSql,String sTipoDiaSql,String sNumeroSql,String sNumeroProceso,ProcesoUpdate procesoUpdate) throws Exception {
		GeneralEntityUpdateAuxiliar.cargarQuerysUpdate(sTipoAnioSql,sTipoMesSql,sTipoDiaSql,sNumeroSql,sNumeroProceso,procesoUpdate);		
	}
}
