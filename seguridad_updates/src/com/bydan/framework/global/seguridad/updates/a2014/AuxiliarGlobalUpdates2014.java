package com.bydan.framework.global.seguridad.updates.a2014;

import java.util.ArrayList;

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
import com.bydan.framework.global.seguridad.updates.a2015.AuxiliarGlobalUpdates2015;
import com.bydan.framework.global.seguridad.updates.entity.ActualizacionUpdate;
import com.bydan.framework.global.seguridad.updates.entity.AnioUpdate;
import com.bydan.framework.global.seguridad.updates.entity.ArchivoUpdate;
import com.bydan.framework.global.seguridad.updates.entity.GeneralEntityUpdateAuxiliar;
import com.bydan.framework.global.seguridad.updates.entity.MesUpdate;
import com.bydan.framework.global.seguridad.updates.entity.ProcesoUpdate;

@SuppressWarnings("unused")
public class AuxiliarGlobalUpdates2014  extends GeneralEntityUpdateAuxiliar {
	public static ProcesoUpdate cargarProcesoUpdate2014() {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
		
		//ANIOS PARA PROCESAR UPDATES
		AnioUpdate anioUpdate=new AnioUpdate();		
		MesUpdate mesUpdate=new MesUpdate();
		ActualizacionUpdate actualizacionUpdate=new ActualizacionUpdate();
		
		anioUpdate=new AnioUpdate();
		anioUpdate.setAnio(2014);
			
		ArrayList<Integer> mesesAnio=MesUpdate.getMesesAnio();
		
		for(Integer mes:mesesAnio) {
			//MESES DEL ACTUAL ANIO PARA PROCESAR UPDATE
			mesUpdate=new MesUpdate();
			mesUpdate.setMes(mes);
				
				ArrayList<ArchivoUpdate> archivosUpdates=AuxiliarGlobalUpdates2014.getActualizacionesNombresArchivos(mesUpdate);
				
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
			
		procesoUpdate=AuxiliarGlobalUpdates2014.cargarProcesoUpdate2014();
			
		return procesoUpdate;
	}
	
	public static ArrayList<ArchivoUpdate> getActualizacionesNombresArchivos(MesUpdate mesUpdate) {
		ArrayList<ArchivoUpdate> archivosUpdates=new ArrayList<ArchivoUpdate>();
		
		switch(mesUpdate.getMes()) {
			case 1:archivosUpdates=AuxiliarGlobalUpdates201401.getActualizacionesNombresArchivos();break;
			case 2:archivosUpdates=AuxiliarGlobalUpdates201402.getActualizacionesNombresArchivos();break;
			case 3:archivosUpdates=AuxiliarGlobalUpdates201403.getActualizacionesNombresArchivos();break;
			case 4:archivosUpdates=AuxiliarGlobalUpdates201404.getActualizacionesNombresArchivos();break;
			case 5:archivosUpdates=AuxiliarGlobalUpdates201405.getActualizacionesNombresArchivos();break;	
			case 6:archivosUpdates=AuxiliarGlobalUpdates201406.getActualizacionesNombresArchivos();break;
			case 7:archivosUpdates=AuxiliarGlobalUpdates201407.getActualizacionesNombresArchivos();break;
			case 8:archivosUpdates=AuxiliarGlobalUpdates201408.getActualizacionesNombresArchivos();break;
			case 9:archivosUpdates=AuxiliarGlobalUpdates201409.getActualizacionesNombresArchivos();break;
			case 10:archivosUpdates=AuxiliarGlobalUpdates201410.getActualizacionesNombresArchivos();break;
			case 11:archivosUpdates=AuxiliarGlobalUpdates201411.getActualizacionesNombresArchivos();break;
			case 12:archivosUpdates=AuxiliarGlobalUpdates201412.getActualizacionesNombresArchivos();break;			
			default:break;
		}		
		
		return archivosUpdates;
	}
	
	public static ProcesoUpdate cargarProcesoUpdate2014Mes(Integer mes) {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
		
		//ANIOS PARA PROCESAR UPDATES
		AnioUpdate anioUpdate=new AnioUpdate();		
		MesUpdate mesUpdate=new MesUpdate();
		ActualizacionUpdate actualizacionUpdate=new ActualizacionUpdate();
		
			anioUpdate=new AnioUpdate();
			anioUpdate.setAnio(2014);
				
				mesUpdate=new MesUpdate();
				mesUpdate.setMes(mes);
					
				ArrayList<ArchivoUpdate> archivosUpdates=AuxiliarGlobalUpdates2014.getActualizacionesNombresArchivos(mesUpdate);
				
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
