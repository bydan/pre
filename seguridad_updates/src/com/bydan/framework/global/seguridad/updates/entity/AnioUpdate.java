package com.bydan.framework.global.seguridad.updates.entity;

import java.util.ArrayList;
import java.util.List;

public class AnioUpdate extends GeneralEntityUpdate{

	private Integer anio=0; 
	
	
	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	private List<MesUpdate> mesessupdates;

	public List<MesUpdate> getMesessupdates() {
		return mesessupdates;
	}

	public void setMesessupdates(List<MesUpdate> mesessupdates) {
		this.mesessupdates = mesessupdates;
	}

	public AnioUpdate(List<MesUpdate> mesessupdates,Integer anio) {
		super();
		this.mesessupdates = mesessupdates;
		this.anio=anio;
	}
	
	public AnioUpdate() {
		super();
		this.mesessupdates = new ArrayList<MesUpdate>();
		this.anio=0;
	}
	
	public String getAnioString() {
		String sAnio=AnioUpdate.getAnioStringGeneral(this.getAnio());				
		
		return sAnio;
	}
	
	public static String getAnioStringGeneral(Integer anio) {
		String sAnio="";
		
		switch(anio) {
			case 2014:
				sAnio="2014";
				break;
				
			case 2015:
				sAnio="2015";
				break;
				
			default:
				sAnio=anio.toString();
				break;
		}
		
		return sAnio;
	}
}
