/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.cartera.business.entity.report;

import java.io.Serializable;
import java.io.File;

import java.util.Calendar;
import java.sql.Timestamp;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;



import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.cartera.util.CobrarAnalisisCarterasConstantesFunciones;
import com.bydan.erp.cartera.util.*;



import com.bydan.erp.cartera.business.entity.*;






@SuppressWarnings("unused")
public class CobrarAnalisisCarteras extends CobrarAnalisisCarterasAdditional implements Serializable ,Cloneable {//CobrarAnalisisCarterasAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected boolean isNew;
	protected boolean isChanged;
	protected boolean isDeleted;
	protected boolean isSelected;
	protected Date versionRow;
	protected String sType;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long newId) {
		if(this.id!=newId) {
			this.isChanged=true;
		}
		
		this.id=newId;
		super.setId(newId);
	}
	
	
	
	public Date getVersionRow(){
		//ESTO SIEMPRE SE EJECUTA CUANDO SE CONSUME EJB
		return this.versionRow;
	}
	
	public void setVersionRow(Date newVersionRow){
		if(this.versionRow!=newVersionRow){
			//LE COMENTO PORQUE CUANDO HAGO GET SIEMPRE POR ESTO LE PONE isChanged=true
			//this.isChanged=true;
		}
		
		this.versionRow=newVersionRow;
		super.setVersionRow(newVersionRow);
	}
	
	
	public boolean getIsNew() {
		return this.isNew;
	}
	
	public void setIsNew(boolean newIsNew) {
		this.isNew=newIsNew;
		super.setIsNew(newIsNew);
	}
	
	public boolean getIsChanged() {
		return this.isChanged;
	}
	
	public void setIsChanged(boolean newIsChanged) {
		this.isChanged=newIsChanged;
		super.setIsChanged(newIsChanged);
	}
	
	public boolean getIsDeleted() {
		return this.isDeleted;
	}
	
	public void setIsDeleted(boolean newIsDeleted) {
		this.isDeleted=newIsDeleted;
		super.setIsDeleted(newIsDeleted);
	}
	
	public boolean getIsSelected() {
		return this.isSelected;
	}
	
	public void setIsSelected(boolean newIsSelected) {
		this.isSelected=newIsSelected;
		super.setIsSelected(newIsSelected);
	}
	
	public String getsType() {
		return this.sType;
	}
	
	public void setsType(String sType) {
		this.sType=sType;
		super.setsType(sType);
	}
	
	private CobrarAnalisisCarteras cobraranalisiscarterasOriginal;
	
	private Map<String, Object> mapCobrarAnalisisCarteras;
			
	public Map<String, Object> getMapCobrarAnalisisCarteras() {
		return mapCobrarAnalisisCarteras;
	}

	public void setMapCobrarAnalisisCarteras(Map<String, Object> mapCobrarAnalisisCarteras) {
		this.mapCobrarAnalisisCarteras = mapCobrarAnalisisCarteras;
	}
	
	public void inicializarMapCobrarAnalisisCarteras() {
		this.mapCobrarAnalisisCarteras = new HashMap<String,Object>();
	}
	
	public void setMapCobrarAnalisisCarterasValue(String sKey,Object oValue) {
		this.mapCobrarAnalisisCarteras.put(sKey, oValue);
	}
	
	public Object getMapCobrarAnalisisCarterasValue(String sKey) {
		return this.mapCobrarAnalisisCarteras.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarAnalisisCarterasConstantesFunciones.SREGEXNOMBRE_TIPO_RADIO_VENCI,message=CobrarAnalisisCarterasConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_RADIO_VENCI)
	private String nombre_tipo_radio_venci;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dia_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dia_hasta;
			
	
	
	
	
	
		
	public CobrarAnalisisCarteras () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cobraranalisiscarterasOriginal=this;
		
 		this.id_empresa=0L;
 		this.nombre_tipo_radio_venci="";
 		this.dia_desde=0;
 		this.dia_hasta=0;
		
		
		
		
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CobrarAnalisisCarteras (Long id,Date versionRow,String nombre_tipo_radio_venci,Integer dia_desde,Integer dia_hasta) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobraranalisiscarterasOriginal=this;
		
 		this.nombre_tipo_radio_venci=nombre_tipo_radio_venci;
 		this.dia_desde=dia_desde;
 		this.dia_hasta=dia_hasta;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CobrarAnalisisCarteras (String nombre_tipo_radio_venci,Integer dia_desde,Integer dia_hasta) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobraranalisiscarterasOriginal=this;
		
 		this.nombre_tipo_radio_venci=nombre_tipo_radio_venci;
 		this.dia_desde=dia_desde;
 		this.dia_hasta=dia_hasta;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public CobrarAnalisisCarteras getCobrarAnalisisCarterasOriginal() {
		return this.cobraranalisiscarterasOriginal;
	}
	
	public void setCobrarAnalisisCarterasOriginal(CobrarAnalisisCarteras cobraranalisiscarteras) {
		try {
			this.cobraranalisiscarterasOriginal=cobraranalisiscarteras;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CobrarAnalisisCarterasAdditional cobraranalisiscarterasAdditional=null;
	
	public CobrarAnalisisCarterasAdditional getCobrarAnalisisCarterasAdditional() {
		return this.cobraranalisiscarterasAdditional;
	}
	
	public void setCobrarAnalisisCarterasAdditional(CobrarAnalisisCarterasAdditional cobraranalisiscarterasAdditional) {
		try {
			this.cobraranalisiscarterasAdditional=cobraranalisiscarterasAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre_tipo_radio_venci() {
		return this.nombre_tipo_radio_venci;
	}
    
	
	public Integer getdia_desde() {
		return this.dia_desde;
	}
    
	
	public Integer getdia_hasta() {
		return this.dia_hasta;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarAnalisisCarteras:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tipo_radio_venci(String newnombre_tipo_radio_venci)throws Exception
	{
		try {
			if(this.nombre_tipo_radio_venci!=newnombre_tipo_radio_venci) {
				if(newnombre_tipo_radio_venci==null) {
					//newnombre_tipo_radio_venci="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarAnalisisCarteras:Valor nulo no permitido en columna nombre_tipo_radio_venci");
					}
				}

				if(newnombre_tipo_radio_venci!=null&&newnombre_tipo_radio_venci.length()>100) {
					newnombre_tipo_radio_venci=newnombre_tipo_radio_venci.substring(0,98);
					System.out.println("CobrarAnalisisCarteras:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_tipo_radio_venci");
				}

				this.nombre_tipo_radio_venci=newnombre_tipo_radio_venci;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdia_desde(Integer newdia_desde)throws Exception
	{
		try {
			if(this.dia_desde!=newdia_desde) {
				if(newdia_desde==null) {
					//newdia_desde=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarAnalisisCarteras:Valor nulo no permitido en columna dia_desde");
					}
				}

				this.dia_desde=newdia_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdia_hasta(Integer newdia_hasta)throws Exception
	{
		try {
			if(this.dia_hasta!=newdia_hasta) {
				if(newdia_hasta==null) {
					//newdia_hasta=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarAnalisisCarteras:Valor nulo no permitido en columna dia_hasta");
					}
				}

				this.dia_hasta=newdia_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

