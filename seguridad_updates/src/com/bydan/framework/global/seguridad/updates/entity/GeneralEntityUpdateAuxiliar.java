package com.bydan.framework.global.seguridad.updates.entity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

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
import com.bydan.framework.global.seguridad.updates.util.ConstantesUpdate;


abstract public class GeneralEntityUpdateAuxiliar implements Cloneable  {

	public Object clone() {
		Object object =new Object();
        try {
        	object =super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return object;
    }
	
	
	private Long id;
	//private Boolean isActive;
	//private Boolean isExpired;
	public Date versionRow;
	private boolean isNew;
	private boolean isChanged;
	protected boolean isChangedAuxiliar;
	private boolean isDeleted;
	private boolean isSelected;
	
	//COLUMNAS AUXILIARES
	private String sType;
	//PARA REPORTES
	private String sDescripcionGeneralEntityReporte1;
	private String sDescripcionGeneralEntityReporte2;
	private String sDescripcionGeneralEntityReporte3;
	private String sDescripcionGeneralEntityReporte4;
	private String sDescripcionGeneralEntityReporte5;
	
	private String sDetalleGeneralEntityReporte;
	
	public GeneralEntityUpdateAuxiliar() {
		id=0L;
		//isActive=true;
		//isExpired=true;	
		versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();

		isNew=true;
		isChanged=false;
		isChangedAuxiliar=isChanged;
		isDeleted=false;	
		isSelected=false;
		
		//COLUMNAS AUXILIARES
		this.sType="NONE";
		this.sDescripcionGeneralEntityReporte1="";
		this.sDescripcionGeneralEntityReporte2="";
		this.sDescripcionGeneralEntityReporte3="";
		this.sDescripcionGeneralEntityReporte4="";
		this.sDescripcionGeneralEntityReporte5="";
		this.sDetalleGeneralEntityReporte="";
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long newId) {
		if(this.id!=newId) {
			this.isChanged=true;
		}
		
		this.id=newId;
	}

	public void setVersionRow(Date newVersionRow){
		if(this.versionRow!=newVersionRow){
			this.isChanged=true;
		}
		
		this.versionRow=newVersionRow;
	}
	
	public boolean getIsNew() {
		return isNew;
	}
	
	public void setIsNew(boolean newIsNew) {
		this.isNew=newIsNew;
	}
		
	public boolean getIsChanged() {
		return isChanged;
	}
	
	public void setIsChanged(boolean newIsChanged) {
		this.isChanged=newIsChanged;
	}

	public boolean getIsChangedAuxiliar() {
		return isChangedAuxiliar;
	}
	
	public void setIsChangedAuxiliar(boolean newIsChangedAuxiliar) {
		this.isChangedAuxiliar=newIsChangedAuxiliar;
	}
	
	public boolean getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(boolean newIsDeleted) {
		this.isDeleted=newIsDeleted;
	}

	public boolean getIsSelected() {
		return isSelected;
	}
	
	public void setIsSelected(boolean newIsSelected) {
		this.isSelected=newIsSelected;
	}
	
		
	
	//COLUMNAS AUXILIARES
	public String getsType() {
		return this.sType;
	}
	
	public void setsType(String sType) {
		this.sType=sType;
	}
	
	//PARA REPORTES
	public String getsDescripcionGeneralEntityReporte1() {
		return this.sDescripcionGeneralEntityReporte1;
	}
	
	public void setsDescripcionGeneralEntityReporte1(String sDescripcionGeneralEntityReporte1) {
		this.sDescripcionGeneralEntityReporte1=sDescripcionGeneralEntityReporte1;
	}
	
	public String getsDescripcionGeneralEntityReporte2() {
		return this.sDescripcionGeneralEntityReporte2;
	}
	
	public void setsDescripcionGeneralEntityReporte2(String sDescripcionGeneralEntityReporte2) {
		this.sDescripcionGeneralEntityReporte2=sDescripcionGeneralEntityReporte2;
	}
	
	public String getsDescripcionGeneralEntityReporte3() {
		return this.sDescripcionGeneralEntityReporte3;
	}
	
	public void setsDescripcionGeneralEntityReporte3(String sDescripcionGeneralEntityReporte3) {
		this.sDescripcionGeneralEntityReporte3=sDescripcionGeneralEntityReporte3;
	}
	
	public String getsDescripcionGeneralEntityReporte4() {
		return this.sDescripcionGeneralEntityReporte4;
	}
	
	public void setsDescripcionGeneralEntityReporte4(String sDescripcionGeneralEntityReporte4) {
		this.sDescripcionGeneralEntityReporte4=sDescripcionGeneralEntityReporte4;
	}
	
	public String getsDescripcionGeneralEntityReporte5() {
		return this.sDescripcionGeneralEntityReporte5;
	}
	
	public void setsDescripcionGeneralEntityReporte5(String sDescripcionGeneralEntityReporte5) {
		this.sDescripcionGeneralEntityReporte5=sDescripcionGeneralEntityReporte5;
	}
	
	public String getsDetalleGeneralEntityReporte() {
		return this.sDetalleGeneralEntityReporte;
	}
	
	public void setsDetalleGeneralEntityReporte(String sDetalleGeneralEntityReporte) {
		this.sDetalleGeneralEntityReporte=sDetalleGeneralEntityReporte;
	}		
	
	public static ProcesoUpdate cargarProcesoUpdate(String sTipoAnioSql,String sTipoMesSql,String sTipoDiaSql,String sNumeroSql,String sNumeroProceso) throws Exception {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
		
		return procesoUpdate;
	}
	
	public static ProcesoUpdate cargarProcesoUpdate(String sTipoAnioSql,String sTipoMesSql,String sNumeroProceso) throws Exception {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
		
		return procesoUpdate;
	}
	
	public static ProcesoUpdate cargarProcesoUpdate(String sTipoAnioSql, String sNumeroProceso) throws Exception {
		ProcesoUpdate procesoUpdate=new ProcesoUpdate();
		
		return procesoUpdate;
	}
	
	public static void cargarCodigosActualizaciones() throws Exception {
	
	}
	
	//PARA UPDATES ANIO,MES,DIA,NUMERO_SQL
	public static void cargarQuerysUpdate(String sTipoAnioSql,String sTipoMesSql,String sTipoDiaSql,String sNumeroSql,String sNumeroProceso,ProcesoUpdate procesoUpdate) throws Exception {//,Class<?> classe		
		InputStream inputStreamSql =null;
		String sQueryTotal ="";
		String[] arrQueries=new String[1];
		QueryUpdate queryUpdate=new QueryUpdate();
		Integer count=1;
		String sNombreResource="";
		
		Class<?> classe=GeneralEntityUpdateAuxiliar.class;
		
		
		
		for(AnioUpdate anioUpdate:procesoUpdate.getAniosupdates()) {
			for(MesUpdate mesUpdate:anioUpdate.getMesessupdates()) {
				
				classe=GeneralEntityUpdateAuxiliar.getClassFromAnioMes(anioUpdate.getAnio(),mesUpdate.getMes());
				
				for(ActualizacionUpdate actualizacionUpdate:mesUpdate.getActualizacionesUpdates()) {
					//inputStreamSql = AuxiliarGlobalUpdates201404.class.getResourceAsStream(actualizacionUpdate.getCodigo().trim());
					
					sNombreResource=actualizacionUpdate.getCodigoArchivo().trim();//actualizacionUpdate.getCodigo().trim();
					
					inputStreamSql = classe.getResourceAsStream(sNombreResource);															
					
					count=1;
					
					if(ProcesoUpdate.EJECUTAR_UN_SOLO_QUERY) { 
						sQueryTotal = new Scanner(inputStreamSql,ConstantesUpdate.S_UTF8).useDelimiter(ConstantesUpdate.S_DELIMITER).next();
						actualizacionUpdate.setQueryTotal(sQueryTotal);
						
						queryUpdate=new QueryUpdate();			
						queryUpdate.setQuery(sQueryTotal);
												
						queryUpdate.setCodigo(actualizacionUpdate.getCodigo()+"_"+count);
						queryUpdate.setOrden(count);
						actualizacionUpdate.getQuerysUpdates().add(queryUpdate);
						
					} else	{												
						
						BufferedReader bufferedReaderSql = new BufferedReader(new InputStreamReader(inputStreamSql));
						 
						StringBuilder stringBuilderQuery = new StringBuilder();
						StringBuilder stringBuilderQueryTotal = new StringBuilder();
				        String sLine="";
				       
				        while ((sLine = bufferedReaderSql.readLine()) != null) {	
				        	
				        	if(sLine.contains(ConstantesUpdate.S_DELIMITER_QUERIES) 
				        			&& !stringBuilderQuery.toString().trim().equals("")) {
				        		
				        		queryUpdate=new QueryUpdate();	
				        		
								queryUpdate.setQuery(stringBuilderQuery.toString());
								
								queryUpdate.setCodigo(actualizacionUpdate.getCodigo()+"_"+count);
								queryUpdate.setOrden(count);								
								actualizacionUpdate.getQuerysUpdates().add(queryUpdate);								
								count++;
								
				        		stringBuilderQuery = new StringBuilder();
				        	}
				        	
				        	stringBuilderQuery.append(sLine+"\r\n");	
				        	stringBuilderQueryTotal.append(sLine+"\r\n");
				        }
				        
				        //ULTIMO BLOQUE SIN FINALIZAR CON /*BLOQUE*/
				        if(!stringBuilderQuery.toString().trim().equals("")) {
				        	queryUpdate=new QueryUpdate();	
			        		
							queryUpdate.setQuery(stringBuilderQuery.toString());
							
							queryUpdate.setCodigo(actualizacionUpdate.getCodigo()+"_"+count);
							queryUpdate.setOrden(count);								
							actualizacionUpdate.getQuerysUpdates().add(queryUpdate);								
							count++;
							
			        		stringBuilderQuery = new StringBuilder();
				        }
				        
				        actualizacionUpdate.setQueryTotal(stringBuilderQueryTotal.toString());
				        
				        /*
				        arrQueries=sQueryTotal.split(ConstantesUpdate.S_DELIMITER_QUERIES);
				        
						for(String sQuery:arrQueries) {
							queryUpdate=new QueryUpdate();
							
							queryUpdate.setQuery(sQuery);
							
							queryUpdate.setCodigo(actualizacionUpdate.getCodigo()+"_"+count);
							queryUpdate.setOrden(count++);
							
							actualizacionUpdate.getQuerysUpdates().add(queryUpdate);
						}
						*/
					}
				}
			}
		}
		
		
		if(arrQueries!=null) {
			System.out.println("nothing="+arrQueries.length);
		}
		
	}
	
	//PARA UPDATES ANIO,MES,DIA,NUMERO_SQL
	public static void cargarQuerysUpdate(String sTipoAnioSql,String sNumeroProceso,ProcesoUpdate procesoUpdate) throws Exception {//,Class<?> classe
		String sTipoMesSql="";
		String sTipoDiaSql="";
		String sNumeroSql="";
		
		GeneralEntityUpdateAuxiliar.cargarQuerysUpdate(sTipoAnioSql, sTipoMesSql, sTipoDiaSql, sNumeroSql, sNumeroProceso, procesoUpdate);//, classe				
	}
	
	public static void cargarQuerysUpdate(String sTipoAnioSql,String sTipoMesSql,String sNumeroProceso,ProcesoUpdate procesoUpdate) throws Exception {//,Class<?> classe
		String sTipoDiaSql="";
		String sNumeroSql="";
		
		GeneralEntityUpdateAuxiliar.cargarQuerysUpdate(sTipoAnioSql, sTipoMesSql, sTipoDiaSql, sNumeroSql, sNumeroProceso, procesoUpdate);//, classe				
	}
	
	public static Class<?> getClassFromAnioMes(Integer anio,Integer mes) {
		Class<?> classe=GeneralEntityUpdateAuxiliar.class;
		
		if(anio.equals(2014)) {
			switch(mes) {
				case 1:classe=AuxiliarGlobalUpdates201401.class;break;
				case 2:classe=AuxiliarGlobalUpdates201402.class;break;
				case 3:classe=AuxiliarGlobalUpdates201403.class;break;
				case 4:classe=AuxiliarGlobalUpdates201404.class;break;
				case 5:classe=AuxiliarGlobalUpdates201405.class;break;
				case 6:classe=AuxiliarGlobalUpdates201406.class;break;
				case 7:classe=AuxiliarGlobalUpdates201407.class;break;
				case 8:classe=AuxiliarGlobalUpdates201408.class;break;
				case 9:classe=AuxiliarGlobalUpdates201409.class;break;
				case 10:classe=AuxiliarGlobalUpdates201410.class;break;
				case 11:classe=AuxiliarGlobalUpdates201411.class;break;
				case 12:classe=AuxiliarGlobalUpdates201412.class;break;				
				default: break;
			}
			
		} else if(anio.equals(2015)) {
			switch(mes) {
				case 1:classe=AuxiliarGlobalUpdates201501.class;break;
				case 2:classe=AuxiliarGlobalUpdates201502.class;break;
				case 3:classe=AuxiliarGlobalUpdates201503.class;break;
				case 4:classe=AuxiliarGlobalUpdates201504.class;break;
				case 5:classe=AuxiliarGlobalUpdates201505.class;break;
				case 6:classe=AuxiliarGlobalUpdates201506.class;break;
				case 7:classe=AuxiliarGlobalUpdates201507.class;break;
				case 8:classe=AuxiliarGlobalUpdates201508.class;break;
				case 9:classe=AuxiliarGlobalUpdates201509.class;break;
				case 10:classe=AuxiliarGlobalUpdates201510.class;break;
				case 11:classe=AuxiliarGlobalUpdates201511.class;break;
				case 12:classe=AuxiliarGlobalUpdates201512.class;break;				
				default: break;
			}
		}
		
		return classe;
	}
}
