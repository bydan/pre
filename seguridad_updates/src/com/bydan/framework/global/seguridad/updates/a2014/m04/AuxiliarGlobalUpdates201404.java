package com.bydan.framework.global.seguridad.updates.a2014.m04;


import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

import com.bydan.framework.global.seguridad.updates.entity.ActualizacionUpdate;
import com.bydan.framework.global.seguridad.updates.entity.AnioUpdate;
import com.bydan.framework.global.seguridad.updates.entity.ArchivoUpdate;
import com.bydan.framework.global.seguridad.updates.entity.GeneralEntityUpdateAuxiliar;
import com.bydan.framework.global.seguridad.updates.entity.MesUpdate;
import com.bydan.framework.global.seguridad.updates.entity.ProcesoUpdate;
import com.bydan.framework.global.seguridad.updates.entity.QueryUpdate;
import com.bydan.framework.global.seguridad.updates.util.ConstantesUpdate;

@SuppressWarnings("unused")
public class AuxiliarGlobalUpdates201404  extends GeneralEntityUpdateAuxiliar {
	public static ArrayList<String> CODIGOS_ACTUALIZACIONES=new ArrayList<String>();
	
	public static ProcesoUpdate cargarProcesoUpdate2014_04_02() {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
		
		//ANIOS PARA PROCESAR UPDATES
		AnioUpdate anioUpdate=new AnioUpdate();		
		anioUpdate.setAnio(2014);
				
		//MESES DEL ACTUAL ANIO PARA PROCESAR UPDATE
		MesUpdate mesUpdate=new MesUpdate();
		mesUpdate.setMes(4);
				
						
		ActualizacionUpdate actualizacionUpdate=new ActualizacionUpdate();
		actualizacionUpdate.setCodigo("001_02.sql");
				
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
			case "2014_04_02":
				procesoUpdate=AuxiliarGlobalUpdates201404.cargarProcesoUpdate2014_04_02();
				break;
		
			default:
				break;							
		}
		
		return procesoUpdate;
	}
	
	//public static void cargarQuerysUpdate(String sTipoAnio,String sTipoMes,String sTipoDia,String sNumeroProceso,ProcesoUpdate procesoUpdate) throws Exception {
		
		//GeneralEntityUpdateAuxiliar.cargarQuerysUpdate(sTipoAnio, sTipoMes, sTipoDia, sNumeroProceso, procesoUpdate, AuxiliarGlobalUpdates201404.class);
		
		/*
		InputStream inputStreamSql =null;
		String sQueryTotal ="";
		String[] arrQueries=null;
		QueryUpdate queryUpdate=new QueryUpdate();
		Integer count=1;
		
		for(AnioUpdate anioUpdate:procesoUpdate.getAniosupdates()) {
			for(MesUpdate mesUpdate:anioUpdate.getMesessupdates()) {
				for(ActualizacionUpdate actualizacionUpdate:mesUpdate.getActualizacionesUpdates()) {
					inputStreamSql = AuxiliarGlobalUpdates201404.class.getResourceAsStream(actualizacionUpdate.getCodigo().trim());
					sQueryTotal = new Scanner(inputStreamSql,ConstantesUpdate.S_UTF8).useDelimiter(ConstantesUpdate.S_DELIMITER).next();
					arrQueries=sQueryTotal.split(ConstantesUpdate.S_DELIMITER_QUERIES);
					
					for(String sQuery:arrQueries) {
						queryUpdate=new QueryUpdate();
						
						queryUpdate.setQuery(sQuery);
						
						queryUpdate.setCodigo(actualizacionUpdate.getCodigo()+"_"+count);
						queryUpdate.setOrden(count++);
						
						actualizacionUpdate.getQuerysUpdates().add(queryUpdate);
					}
				}
			}
		}
		
		if(arrQueries!=null) {
			
		}
		*/
	//}
	
	public static void cargarCodigosActualizaciones() throws Exception {
		CODIGOS_ACTUALIZACIONES.add("001_02.sql");
	}
	
	public static ArrayList<ArchivoUpdate> getActualizacionesNombresArchivos() {
		ArrayList<ArchivoUpdate> archivosUpdates=new ArrayList<ArchivoUpdate>();
		/*
		ArchivoUpdate archivoUpdate=new ArchivoUpdate();
		
		archivoUpdate=new ArchivoUpdate("001_02.sql","001");				
		archivosUpdates.add(archivoUpdate);
		*/				
		
		return archivosUpdates;
	}
}
