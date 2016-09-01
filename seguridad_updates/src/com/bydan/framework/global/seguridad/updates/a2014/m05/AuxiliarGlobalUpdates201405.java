package com.bydan.framework.global.seguridad.updates.a2014.m05;

import java.util.ArrayList;

import com.bydan.framework.global.seguridad.updates.entity.ArchivoUpdate;
import com.bydan.framework.global.seguridad.updates.entity.GeneralEntityUpdateAuxiliar;

public class AuxiliarGlobalUpdates201405  extends GeneralEntityUpdateAuxiliar {
	public static ArrayList<ArchivoUpdate> getActualizacionesNombresArchivos() {
		ArrayList<ArchivoUpdate> archivosUpdates=new ArrayList<ArchivoUpdate>();
		ArchivoUpdate archivoUpdate=new ArchivoUpdate();
					
		archivoUpdate=new ArchivoUpdate("001_01.sql","001");				
		archivosUpdates.add(archivoUpdate);
		
		return archivosUpdates;
	}
}
