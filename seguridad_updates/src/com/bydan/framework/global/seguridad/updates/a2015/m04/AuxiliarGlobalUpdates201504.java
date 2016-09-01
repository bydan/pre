package com.bydan.framework.global.seguridad.updates.a2015.m04;

import java.util.ArrayList;

import com.bydan.framework.global.seguridad.updates.entity.ActualizacionUpdate;
import com.bydan.framework.global.seguridad.updates.entity.AnioUpdate;
import com.bydan.framework.global.seguridad.updates.entity.ArchivoUpdate;
import com.bydan.framework.global.seguridad.updates.entity.GeneralEntityUpdateAuxiliar;
import com.bydan.framework.global.seguridad.updates.entity.MesUpdate;
import com.bydan.framework.global.seguridad.updates.entity.ProcesoUpdate;

@SuppressWarnings("unused")
public class AuxiliarGlobalUpdates201504  extends GeneralEntityUpdateAuxiliar {
	public static ArrayList<ArchivoUpdate> getActualizacionesNombresArchivos() {
		ArrayList<ArchivoUpdate> archivosUpdates=new ArrayList<ArchivoUpdate>();
		ArchivoUpdate archivoUpdate=new ArchivoUpdate();
					
		archivoUpdate=new ArchivoUpdate("001_02.sql","001");
		archivosUpdates.add(archivoUpdate);
		
		return archivosUpdates;
	}
}
