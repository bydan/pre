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
package com.bydan.erp.contabilidad.business.entity;

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
//import com.bydan.erp.contabilidad.util.TipoParametroFormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class TipoParametroFormularioIva extends TipoParametroFormularioIvaAdditional implements Serializable ,Cloneable {//TipoParametroFormularioIvaAdditional,GeneralEntity
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
	
	private TipoParametroFormularioIva tipoparametroformularioivaOriginal;
	
	private Map<String, Object> mapTipoParametroFormularioIva;
			
	public Map<String, Object> getMapTipoParametroFormularioIva() {
		return mapTipoParametroFormularioIva;
	}

	public void setMapTipoParametroFormularioIva(Map<String, Object> mapTipoParametroFormularioIva) {
		this.mapTipoParametroFormularioIva = mapTipoParametroFormularioIva;
	}
	
	public void inicializarMapTipoParametroFormularioIva() {
		this.mapTipoParametroFormularioIva = new HashMap<String,Object>();
	}
	
	public void setMapTipoParametroFormularioIvaValue(String sKey,Object oValue) {
		this.mapTipoParametroFormularioIva.put(sKey, oValue);
	}
	
	public Object getMapTipoParametroFormularioIvaValue(String sKey) {
		return this.mapTipoParametroFormularioIva.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoParametroFormularioIvaConstantesFunciones.SREGEXNOMBRE,message=TipoParametroFormularioIvaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoParametroFormularioIvaConstantesFunciones.SREGEXCODIGO_SRI,message=TipoParametroFormularioIvaConstantesFunciones.SMENSAJEREGEXCODIGO_SRI)
	private String codigo_sri;
			
	
	
	
	
	
	public List<ParametroFormularioIva> parametroformularioivas;
		
	public TipoParametroFormularioIva () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipoparametroformularioivaOriginal=this;
		
 		this.nombre="";
 		this.codigo_sri="";
		
		
		
		
		
		
		this.parametroformularioivas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoParametroFormularioIva (Long id,Date versionRow,String nombre,String codigo_sri) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoparametroformularioivaOriginal=this;
		
 		this.nombre=nombre;
 		this.codigo_sri=codigo_sri;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoParametroFormularioIva (String nombre,String codigo_sri) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoparametroformularioivaOriginal=this;
		
 		this.nombre=nombre;
 		this.codigo_sri=codigo_sri;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoParametroFormularioIva tipoparametroformularioivaLocal=null;
		
		if(object!=null) {
			tipoparametroformularioivaLocal=(TipoParametroFormularioIva)object;
			
			if(tipoparametroformularioivaLocal!=null) {
				if(this.getId()!=null && tipoparametroformularioivaLocal.getId()!=null) {
					if(this.getId().equals(tipoparametroformularioivaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoParametroFormularioIvaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoParametroFormularioIvaConstantesFunciones.getTipoParametroFormularioIvaDescripcion(this);
		} else {
			sDetalle=TipoParametroFormularioIvaConstantesFunciones.getTipoParametroFormularioIvaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoParametroFormularioIva getTipoParametroFormularioIvaOriginal() {
		return this.tipoparametroformularioivaOriginal;
	}
	
	public void setTipoParametroFormularioIvaOriginal(TipoParametroFormularioIva tipoparametroformularioiva) {
		try {
			this.tipoparametroformularioivaOriginal=tipoparametroformularioiva;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoParametroFormularioIvaAdditional tipoparametroformularioivaAdditional=null;
	
	public TipoParametroFormularioIvaAdditional getTipoParametroFormularioIvaAdditional() {
		return this.tipoparametroformularioivaAdditional;
	}
	
	public void setTipoParametroFormularioIvaAdditional(TipoParametroFormularioIvaAdditional tipoparametroformularioivaAdditional) {
		try {
			this.tipoparametroformularioivaAdditional=tipoparametroformularioivaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getcodigo_sri() {
		return this.codigo_sri;
	}
	
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoParametroFormularioIva:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoParametroFormularioIva:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_sri(String newcodigo_sri)throws Exception
	{
		try {
			if(this.codigo_sri!=newcodigo_sri) {
				if(newcodigo_sri==null) {
					//newcodigo_sri="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoParametroFormularioIva:Valor nulo no permitido en columna codigo_sri");
					}
				}

				if(newcodigo_sri!=null&&newcodigo_sri.length()>50) {
					newcodigo_sri=newcodigo_sri.substring(0,48);
					System.out.println("TipoParametroFormularioIva:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_sri");
				}

				this.codigo_sri=newcodigo_sri;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<ParametroFormularioIva> getParametroFormularioIvas() {
		return this.parametroformularioivas;
	}

	
	
	public  void  setParametroFormularioIvas(List<ParametroFormularioIva> parametroformularioivas) {
		try {
			this.parametroformularioivas=parametroformularioivas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object parametroformularioivasDescripcionReporte;
	
	
	public Object getparametroformularioivasDescripcionReporte() {
		return parametroformularioivasDescripcionReporte;
	}

	
	
	public  void  setparametroformularioivasDescripcionReporte(Object parametroformularioivas) {
		try {
			this.parametroformularioivasDescripcionReporte=parametroformularioivas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

