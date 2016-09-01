package com.bydan.framework.global.seguridad.updates.entity;

import java.util.ArrayList;
import java.util.List;

public class MesUpdate extends GeneralEntityUpdate{
	private List<ActualizacionUpdate> actualizacionesUpdates;
			
	public List<ActualizacionUpdate> getActualizacionesUpdates() {
		return actualizacionesUpdates;
	}

	public void setActualizacionesUpdates(
			List<ActualizacionUpdate> actualizacionesUpdates) {
		this.actualizacionesUpdates = actualizacionesUpdates;
	}

	private Integer mes=0;

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public MesUpdate(Integer mes,ArrayList<ActualizacionUpdate> actualizacionesUpdates) {
		super();
		this.mes = mes;
		this.actualizacionesUpdates=actualizacionesUpdates;
	}
	
	public MesUpdate() {
		super();
		this.mes = 0;
		
		this.actualizacionesUpdates=new ArrayList<ActualizacionUpdate>(); 
	}
	
	public static ArrayList<Integer> getMesesAnio() {
		ArrayList<Integer> mesesAnio=new ArrayList<Integer>();
		
		mesesAnio.add(1);
		mesesAnio.add(2);
		mesesAnio.add(3);
		mesesAnio.add(4);
		mesesAnio.add(5);
		mesesAnio.add(6);
		mesesAnio.add(7);
		mesesAnio.add(8);
		mesesAnio.add(9);
		mesesAnio.add(10);
		mesesAnio.add(11);
		mesesAnio.add(12);
		return mesesAnio;
	}
	
	public String getMesString() {
		String sMes=MesUpdate.getMesStringGeneral(this.getMes());
		
		return sMes;
	}
	
	public static String getMesStringGeneral(Integer mes) {
		String sMes="01";
		
		switch(mes) {
			case 1:
				sMes="01";
				break;
				
			case 2:
				sMes="02";
				break;
				
			case 3:
				sMes="03";
				break;
				
			case 4:
				sMes="04";
				break;
				
			case 5:
				sMes="05";
				break;
				
			case 6:
				sMes="06";
				break;
				
			case 7:
				sMes="07";
				break;
				
			case 8:
				sMes="08";
				break;
				
			case 9:
				sMes="09";
				break;
				
			case 10:
				sMes="10";
				break;
				
			case 11:
				sMes="11";
				break;
				
			case 12:
				sMes="12";
				break;
				
			default:
				sMes=mes.toString();
				break;
		}
		
		return sMes;
	}
}
