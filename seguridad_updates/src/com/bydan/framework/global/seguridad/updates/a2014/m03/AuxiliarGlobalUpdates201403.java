package com.bydan.framework.global.seguridad.updates.a2014.m03;

import java.util.ArrayList;

import com.bydan.framework.global.seguridad.updates.entity.ActualizacionUpdate;
import com.bydan.framework.global.seguridad.updates.entity.AnioUpdate;
import com.bydan.framework.global.seguridad.updates.entity.ArchivoUpdate;
import com.bydan.framework.global.seguridad.updates.entity.GeneralEntityUpdateAuxiliar;
import com.bydan.framework.global.seguridad.updates.entity.MesUpdate;
import com.bydan.framework.global.seguridad.updates.entity.ProcesoUpdate;

public class AuxiliarGlobalUpdates201403  extends GeneralEntityUpdateAuxiliar {

	public static ProcesoUpdate cargarProcesoUpdate2014_03_02() {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
		
		//ANIOS PARA PROCESAR UPDATES
		AnioUpdate anioUpdate=new AnioUpdate();		
		anioUpdate.setAnio(2014);
				
		//MESES DEL ACTUAL ANIO PARA PROCESAR UPDATE
		MesUpdate mesUpdate=new MesUpdate();
		mesUpdate.setMes(3);
				
						
		ActualizacionUpdate actualizacionUpdate=new ActualizacionUpdate();
		
		//NO SE RESTRINGE A UN ARCHIVO, PUEDE TENER VARIOS, POR ESO SE CREA MANUALMENTE
		/*
		actualizacionUpdate.setCodigoArchivo(ProcesoUpdate.NUMERO_SQL+"_"+ProcesoUpdate.DIA_SQL+".sql");
		actualizacionUpdate.setCodigo(ProcesoUpdate.CODIGO_SQL);//"001_02.sql"
		*/
		
		actualizacionUpdate.setCodigoArchivo("001_02.sql");
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
			case "2014_03_02":
				procesoUpdate=AuxiliarGlobalUpdates201403.cargarProcesoUpdate2014_03_02();
				break;
		
			default:
				break;							
		}
		
		return procesoUpdate;
	}
	
	public static ArrayList<ArchivoUpdate> getActualizacionesNombresArchivos() {
		ArrayList<ArchivoUpdate> archivosUpdates=new ArrayList<ArchivoUpdate>();
		ArchivoUpdate archivoUpdate=new ArchivoUpdate();
					
		archivoUpdate=new ArchivoUpdate("001_01.sql","001");				
		archivosUpdates.add(archivoUpdate);
		
		archivoUpdate=new ArchivoUpdate("002_02.sql","002");				
		archivosUpdates.add(archivoUpdate);
		
		return archivosUpdates;
	}
}
