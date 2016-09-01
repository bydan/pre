package com.bydan.framework.global.seguridad.updates.a2014.m01;

import java.util.ArrayList;

import com.bydan.framework.global.seguridad.updates.a2014.AuxiliarGlobalUpdates2014;
import com.bydan.framework.global.seguridad.updates.a2014.m03.AuxiliarGlobalUpdates201403;
import com.bydan.framework.global.seguridad.updates.a2015.AuxiliarGlobalUpdates2015;
import com.bydan.framework.global.seguridad.updates.entity.ActualizacionUpdate;
import com.bydan.framework.global.seguridad.updates.entity.AnioUpdate;
import com.bydan.framework.global.seguridad.updates.entity.ArchivoUpdate;
import com.bydan.framework.global.seguridad.updates.entity.GeneralEntityUpdateAuxiliar;
import com.bydan.framework.global.seguridad.updates.entity.MesUpdate;
import com.bydan.framework.global.seguridad.updates.entity.ProcesoUpdate;

@SuppressWarnings("unused")
public class AuxiliarGlobalUpdates201401  extends GeneralEntityUpdateAuxiliar {
	public static ProcesoUpdate cargarProcesoUpdate2014_01_01() {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
		
		//ANIOS PARA PROCESAR UPDATES
		AnioUpdate anioUpdate=new AnioUpdate();		
		anioUpdate.setAnio(2014);
				
		//MESES DEL ACTUAL ANIO PARA PROCESAR UPDATE
		MesUpdate mesUpdate=new MesUpdate();
		mesUpdate.setMes(1);
				
						
		ActualizacionUpdate actualizacionUpdate=new ActualizacionUpdate();
		
		//NO SE RESTRINGE A UN ARCHIVO, PUEDE TENER VARIOS, POR ESO SE CREA MANUALMENTE
		/*
		actualizacionUpdate.setCodigoArchivo(ProcesoUpdate.NUMERO_SQL+"_"+ProcesoUpdate.DIA_SQL+".sql");
		actualizacionUpdate.setCodigo(ProcesoUpdate.CODIGO_SQL);//"001_02.sql"
		*/
		
		actualizacionUpdate.setCodigoArchivo("000_01.sql");
		actualizacionUpdate.inicializaValoresAutomaticos(anioUpdate,mesUpdate);
		
		//actualizacionUpdate.setNumeroArchivoSql("001");
		//actualizacionUpdate.setCodigo("2014-03_001");//"001_02.sql"		
		
		//ADD ACTUALIZACIONES
		mesUpdate.getActualizacionesUpdates().add(actualizacionUpdate);		
		//ADD MESES
		anioUpdate.getMesessupdates().add(mesUpdate);		
		//ADD ANIOS
		procesoUpdate.getAniosupdates().add(anioUpdate);
		
		return procesoUpdate;
	}
			
	public static ProcesoUpdate cargarProcesoUpdate(String sTipoAnioSql,String sTipoMesSql,String sTipoDiaSql,String sNumeroSql,String sNumeroProceso) throws Exception {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
		
		String sTipoAnioMesDiaProceso=sTipoAnioSql+"_"+sTipoMesSql+"_"+sTipoDiaSql;
		
		if(!sNumeroProceso.equals("")) {
			sTipoAnioMesDiaProceso+="_"+sNumeroProceso;
		}
		
		
		switch(sTipoAnioMesDiaProceso) {
			case "2014_01_01":
				procesoUpdate=AuxiliarGlobalUpdates201401.cargarProcesoUpdate2014_01_01();
				break;
		
			default:
				break;							
		}
		
		return procesoUpdate;
	}
	
	public static ArrayList<ArchivoUpdate> getActualizacionesNombresArchivos() {
		ArrayList<ArchivoUpdate> archivosUpdates=new ArrayList<ArchivoUpdate>();
		//ArchivoUpdate archivoUpdate=new ArchivoUpdate();
			
		//OJO ESTE NO TOMAR EN CUENTA NUNCA 000, ES ESPECIAL
		//archivoUpdate=new ArchivoUpdate("000_01.sql","000");				
		//archivosUpdates.add(archivoUpdate);
		
		return archivosUpdates;
	}
}
