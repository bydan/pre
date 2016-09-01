package com.bydan.framework.global.seguridad.updates.a2015.m05;

import java.util.ArrayList;

import com.bydan.framework.global.seguridad.updates.entity.ActualizacionUpdate;
import com.bydan.framework.global.seguridad.updates.entity.AnioUpdate;
import com.bydan.framework.global.seguridad.updates.entity.ArchivoUpdate;
import com.bydan.framework.global.seguridad.updates.entity.GeneralEntityUpdateAuxiliar;
import com.bydan.framework.global.seguridad.updates.entity.MesUpdate;
import com.bydan.framework.global.seguridad.updates.entity.ProcesoUpdate;

public class AuxiliarGlobalUpdates201505  extends GeneralEntityUpdateAuxiliar {
	public static ProcesoUpdate cargarProcesoUpdate2015_05_04_5() {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
		
		//ANIOS PARA PROCESAR UPDATES
		AnioUpdate anioUpdate=new AnioUpdate();		
		anioUpdate.setAnio(2015);
				
		//MESES DEL ACTUAL ANIO PARA PROCESAR UPDATE
		MesUpdate mesUpdate=new MesUpdate();
		mesUpdate.setMes(5);
				
						
		ActualizacionUpdate actualizacionUpdate=new ActualizacionUpdate();
		actualizacionUpdate.setCodigoArchivo("002_04.sql");
				
		actualizacionUpdate.inicializaValoresAutomaticos(anioUpdate, mesUpdate);
		
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
			case "2015_05_04":
				procesoUpdate=AuxiliarGlobalUpdates201505.cargarProcesoUpdate2015_05_04_5();
				break;
		
			default:
				break;							
		}
		
		return procesoUpdate;
	}
	
	public static ArrayList<ArchivoUpdate> getActualizacionesNombresArchivos() {
		ArrayList<ArchivoUpdate> archivosUpdates=new ArrayList<ArchivoUpdate>();
		//ArchivoUpdate archivoUpdate=new ArchivoUpdate();
					
		//archivoUpdate=new ArchivoUpdate("001_02.sql","001");				
		//archivosUpdates.add(archivoUpdate);
		
		return archivosUpdates;
	}
}
