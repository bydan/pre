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
package com.bydan.erp.nomina.business.entity;

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
//import com.bydan.erp.nomina.util.TipoVariableNomiConstantesFunciones;
import com.bydan.erp.nomina.util.*;









@SuppressWarnings("unused")
public class TipoVariableNomi extends TipoVariableNomiAdditional implements Serializable ,Cloneable {//TipoVariableNomiAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected Long idOriginal;
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
	
	public Long getIdOriginal() {
		return this.idOriginal;
	}
	
	public void setIdOriginal(Long newIdOriginal) {		
		this.idOriginal=newIdOriginal;
		super.setIdOriginal(newIdOriginal);
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
	
	private TipoVariableNomi tipovariablenomiOriginal;
	
	private Map<String, Object> mapTipoVariableNomi;
			
	public Map<String, Object> getMapTipoVariableNomi() {
		return mapTipoVariableNomi;
	}

	public void setMapTipoVariableNomi(Map<String, Object> mapTipoVariableNomi) {
		this.mapTipoVariableNomi = mapTipoVariableNomi;
	}
	
	public void inicializarMapTipoVariableNomi() {
		this.mapTipoVariableNomi = new HashMap<String,Object>();
	}
	
	public void setMapTipoVariableNomiValue(String sKey,Object oValue) {
		this.mapTipoVariableNomi.put(sKey, oValue);
	}
	
	public Object getMapTipoVariableNomiValue(String sKey) {
		return this.mapTipoVariableNomi.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoVariableNomiConstantesFunciones.SREGEXCODIGO,message=TipoVariableNomiConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoVariableNomiConstantesFunciones.SREGEXNOMBRE,message=TipoVariableNomiConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
	public List<VariableNomi> variablenomis;
		
	public TipoVariableNomi () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipovariablenomiOriginal=this;
		
 		this.codigo="";
 		this.nombre="";
		
		
		
		
		
		
		this.variablenomis=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoVariableNomi (Long id,Date versionRow,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipovariablenomiOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoVariableNomi (String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipovariablenomiOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoVariableNomi tipovariablenomiLocal=null;
		
		if(object!=null) {
			tipovariablenomiLocal=(TipoVariableNomi)object;
			
			if(tipovariablenomiLocal!=null) {
				if(this.getId()!=null && tipovariablenomiLocal.getId()!=null) {
					if(this.getId().equals(tipovariablenomiLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoVariableNomiConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoVariableNomiConstantesFunciones.getTipoVariableNomiDescripcion(this);
		} else {
			sDetalle=TipoVariableNomiConstantesFunciones.getTipoVariableNomiDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoVariableNomi getTipoVariableNomiOriginal() {
		return this.tipovariablenomiOriginal;
	}
	
	public void setTipoVariableNomiOriginal(TipoVariableNomi tipovariablenomi) {
		try {
			this.tipovariablenomiOriginal=tipovariablenomi;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoVariableNomiAdditional tipovariablenomiAdditional=null;
	
	public TipoVariableNomiAdditional getTipoVariableNomiAdditional() {
		return this.tipovariablenomiAdditional;
	}
	
	public void setTipoVariableNomiAdditional(TipoVariableNomiAdditional tipovariablenomiAdditional) {
		try {
			this.tipovariablenomiAdditional=tipovariablenomiAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoVariableNomi:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoVariableNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoVariableNomi:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("TipoVariableNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<VariableNomi> getVariableNomis() {
		return this.variablenomis;
	}

	
	
	public  void  setVariableNomis(List<VariableNomi> variablenomis) {
		try {
			this.variablenomis=variablenomis;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object variablenomisDescripcionReporte;
	
	
	public Object getvariablenomisDescripcionReporte() {
		return variablenomisDescripcionReporte;
	}

	
	
	public  void  setvariablenomisDescripcionReporte(Object variablenomis) {
		try {
			this.variablenomisDescripcionReporte=variablenomis;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

