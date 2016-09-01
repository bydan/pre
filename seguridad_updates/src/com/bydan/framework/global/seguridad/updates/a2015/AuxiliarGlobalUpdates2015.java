package com.bydan.framework.global.seguridad.updates.a2015;

import java.util.ArrayList;

import com.bydan.framework.global.seguridad.updates.a2014.AuxiliarGlobalUpdates2014;
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
import com.bydan.framework.global.seguridad.updates.entity.ActualizacionUpdate;
import com.bydan.framework.global.seguridad.updates.entity.AnioUpdate;
import com.bydan.framework.global.seguridad.updates.entity.ArchivoUpdate;
import com.bydan.framework.global.seguridad.updates.entity.GeneralEntityUpdateAuxiliar;
import com.bydan.framework.global.seguridad.updates.entity.MesUpdate;
import com.bydan.framework.global.seguridad.updates.entity.ProcesoUpdate;

@SuppressWarnings("unused")
public class AuxiliarGlobalUpdates2015 extends GeneralEntityUpdateAuxiliar {
	public static ProcesoUpdate cargarProcesoUpdate2015() {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
		
		//ANIOS PARA PROCESAR UPDATES
		AnioUpdate anioUpdate=new AnioUpdate();		
		MesUpdate mesUpdate=new MesUpdate();
		ActualizacionUpdate actualizacionUpdate=new ActualizacionUpdate();
		
		anioUpdate=new AnioUpdate();
		anioUpdate.setAnio(2015);
			
		ArrayList<Integer> mesesAnio=MesUpdate.getMesesAnio();
		
		for(Integer mes:mesesAnio) {
			//MESES DEL ACTUAL ANIO PARA PROCESAR UPDATE
			mesUpdate=new MesUpdate();
			mesUpdate.setMes(mes);
				
				ArrayList<ArchivoUpdate> archivosUpdates=AuxiliarGlobalUpdates2015.getActualizacionesNombresArchivos(mesUpdate);
			
				for(ArchivoUpdate archivoUpdate:archivosUpdates) {
					//ACTUALIZACIONES		
					actualizacionUpdate=new ActualizacionUpdate();
					actualizacionUpdate.setCodigoArchivo(archivoUpdate.getNombreArchivo());
					actualizacionUpdate.inicializaValoresAutomaticos(anioUpdate,mesUpdate);		
						
					//ADD ACTUALIZACIONES
					mesUpdate.getActualizacionesUpdates().add(actualizacionUpdate);		
				}
				
			//ADD MESES
			if(archivosUpdates.size()>0){	
			anioUpdate.getMesessupdates().add(mesUpdate);
			}
		}
		
		//ADD ANIOS
		procesoUpdate.getAniosupdates().add(anioUpdate);
		
		return procesoUpdate;
	}
			
	public static ProcesoUpdate cargarProcesoUpdate(String sTipoAnioSql,String sNumeroProceso) throws Exception {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
			
		procesoUpdate=AuxiliarGlobalUpdates2015.cargarProcesoUpdate2015();
			
		return procesoUpdate;
	}
	
	public static ArrayList<ArchivoUpdate> getActualizacionesNombresArchivos(MesUpdate mesUpdate) {
		ArrayList<ArchivoUpdate> archivosUpdates=new ArrayList<ArchivoUpdate>();
		
		switch(mesUpdate.getMes()) {
			case 1:archivosUpdates=AuxiliarGlobalUpdates201501.getActualizacionesNombresArchivos();break;
			case 2:archivosUpdates=AuxiliarGlobalUpdates201502.getActualizacionesNombresArchivos();break;
			case 3:archivosUpdates=AuxiliarGlobalUpdates201503.getActualizacionesNombresArchivos();break;
			case 4:archivosUpdates=AuxiliarGlobalUpdates201504.getActualizacionesNombresArchivos();break;
			case 5:archivosUpdates=AuxiliarGlobalUpdates201505.getActualizacionesNombresArchivos();break;	
			case 6:archivosUpdates=AuxiliarGlobalUpdates201506.getActualizacionesNombresArchivos();break;
			case 7:archivosUpdates=AuxiliarGlobalUpdates201507.getActualizacionesNombresArchivos();break;
			case 8:archivosUpdates=AuxiliarGlobalUpdates201508.getActualizacionesNombresArchivos();break;
			case 9:archivosUpdates=AuxiliarGlobalUpdates201509.getActualizacionesNombresArchivos();break;
			case 10:archivosUpdates=AuxiliarGlobalUpdates201510.getActualizacionesNombresArchivos();break;
			case 11:archivosUpdates=AuxiliarGlobalUpdates201511.getActualizacionesNombresArchivos();break;
			case 12:archivosUpdates=AuxiliarGlobalUpdates201512.getActualizacionesNombresArchivos();break;			
			default:break;
		}
		
		return archivosUpdates;
	}
	
	public static ProcesoUpdate cargarProcesoUpdate2015Mes(Integer mes) {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
		
		//ANIOS PARA PROCESAR UPDATES
		AnioUpdate anioUpdate=new AnioUpdate();		
		MesUpdate mesUpdate=new MesUpdate();
		ActualizacionUpdate actualizacionUpdate=new ActualizacionUpdate();
		
			anioUpdate=new AnioUpdate();
			anioUpdate.setAnio(2015);
				
				mesUpdate=new MesUpdate();
				mesUpdate.setMes(mes);
					
				ArrayList<ArchivoUpdate> archivosUpdates=AuxiliarGlobalUpdates2015.getActualizacionesNombresArchivos(mesUpdate);
				
				for(ArchivoUpdate archivoUpdate:archivosUpdates) {
					//ACTUALIZACIONES		
					actualizacionUpdate=new ActualizacionUpdate();
					actualizacionUpdate.setCodigoArchivo(archivoUpdate.getNombreArchivo());
					actualizacionUpdate.inicializaValoresAutomaticos(anioUpdate,mesUpdate);		
							
					//ADD ACTUALIZACIONES
					mesUpdate.getActualizacionesUpdates().add(actualizacionUpdate);		
				}
					
			//ADD MESES
			if(archivosUpdates.size()>0){	
			anioUpdate.getMesessupdates().add(mesUpdate);
			}
		
		
		//ADD ANIOS
		procesoUpdate.getAniosupdates().add(anioUpdate);
		
		return procesoUpdate;
	}
}
