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
package com.bydan.erp.seguridad.business.entity;

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
//import com.bydan.erp.seguridad.util.AuditoriaDetalleConstantesFunciones;
import com.bydan.erp.seguridad.util.*;









@SuppressWarnings("unused")
public class AuditoriaDetalle extends AuditoriaDetalleAdditional implements Serializable ,Cloneable {//AuditoriaDetalleAdditional,GeneralEntity
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
	
	private AuditoriaDetalle auditoriadetalleOriginal;
	
	private Map<String, Object> mapAuditoriaDetalle;
			
	public Map<String, Object> getMapAuditoriaDetalle() {
		return mapAuditoriaDetalle;
	}

	public void setMapAuditoriaDetalle(Map<String, Object> mapAuditoriaDetalle) {
		this.mapAuditoriaDetalle = mapAuditoriaDetalle;
	}
	
	public void inicializarMapAuditoriaDetalle() {
		this.mapAuditoriaDetalle = new HashMap<String,Object>();
	}
	
	public void setMapAuditoriaDetalleValue(String sKey,Object oValue) {
		this.mapAuditoriaDetalle.put(sKey, oValue);
	}
	
	public Object getMapAuditoriaDetalleValue(String sKey) {
		return this.mapAuditoriaDetalle.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_auditoria;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AuditoriaDetalleConstantesFunciones.SREGEXNOMBRE_CAMPO,message=AuditoriaDetalleConstantesFunciones.SMENSAJEREGEXNOMBRE_CAMPO)
	private String nombre_campo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AuditoriaDetalleConstantesFunciones.SREGEXVALOR_ANTERIOR,message=AuditoriaDetalleConstantesFunciones.SMENSAJEREGEXVALOR_ANTERIOR)
	private String valor_anterior;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=AuditoriaDetalleConstantesFunciones.SREGEXVALOR_ACTUAL,message=AuditoriaDetalleConstantesFunciones.SMENSAJEREGEXVALOR_ACTUAL)
	private String valor_actual;
			
	
	public Auditoria auditoria;
	
	
	private String auditoria_descripcion;
	
	
		
	public AuditoriaDetalle () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.auditoriadetalleOriginal=this;
		
 		this.id_auditoria=-1L;
 		this.nombre_campo="";
 		this.valor_anterior="";
 		this.valor_actual="";
		
		
		this.auditoria=null;
		
		
		this.auditoria_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public AuditoriaDetalle (Long id,Date versionRow,Long id_auditoria,String nombre_campo,String valor_anterior,String valor_actual) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.auditoriadetalleOriginal=this;
		
 		this.id_auditoria=id_auditoria;
 		this.nombre_campo=nombre_campo;
 		this.valor_anterior=valor_anterior;
 		this.valor_actual=valor_actual;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public AuditoriaDetalle (Long id_auditoria,String nombre_campo,String valor_anterior,String valor_actual) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.auditoriadetalleOriginal=this;
		
 		this.id_auditoria=id_auditoria;
 		this.nombre_campo=nombre_campo;
 		this.valor_anterior=valor_anterior;
 		this.valor_actual=valor_actual;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		AuditoriaDetalle auditoriadetalleLocal=null;
		
		if(object!=null) {
			auditoriadetalleLocal=(AuditoriaDetalle)object;
			
			if(auditoriadetalleLocal!=null) {
				if(this.getId()!=null && auditoriadetalleLocal.getId()!=null) {
					if(this.getId().equals(auditoriadetalleLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!AuditoriaDetalleConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=AuditoriaDetalleConstantesFunciones.getAuditoriaDetalleDescripcion(this);
		} else {
			sDetalle=AuditoriaDetalleConstantesFunciones.getAuditoriaDetalleDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public AuditoriaDetalle getAuditoriaDetalleOriginal() {
		return this.auditoriadetalleOriginal;
	}
	
	public void setAuditoriaDetalleOriginal(AuditoriaDetalle auditoriadetalle) {
		try {
			this.auditoriadetalleOriginal=auditoriadetalle;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected AuditoriaDetalleAdditional auditoriadetalleAdditional=null;
	
	public AuditoriaDetalleAdditional getAuditoriaDetalleAdditional() {
		return this.auditoriadetalleAdditional;
	}
	
	public void setAuditoriaDetalleAdditional(AuditoriaDetalleAdditional auditoriadetalleAdditional) {
		try {
			this.auditoriadetalleAdditional=auditoriadetalleAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_auditoria() {
		return this.id_auditoria;
	}
    
	
	public String getnombre_campo() {
		return this.nombre_campo;
	}
    
	
	public String getvalor_anterior() {
		return this.valor_anterior;
	}
    
	
	public String getvalor_actual() {
		return this.valor_actual;
	}
	
    
	public void setid_auditoria(Long newid_auditoria)throws Exception
	{
		try {
			if(this.id_auditoria!=newid_auditoria) {
				if(newid_auditoria==null) {
					//newid_auditoria=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AuditoriaDetalle:Valor nulo no permitido en columna id_auditoria");
					}
				}

				this.id_auditoria=newid_auditoria;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_campo(String newnombre_campo)throws Exception
	{
		try {
			if(this.nombre_campo!=newnombre_campo) {
				if(newnombre_campo==null) {
					//newnombre_campo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AuditoriaDetalle:Valor nulo no permitido en columna nombre_campo");
					}
				}

				if(newnombre_campo!=null&&newnombre_campo.length()>150) {
					newnombre_campo=newnombre_campo.substring(0,148);
					System.out.println("AuditoriaDetalle:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_campo");
				}

				this.nombre_campo=newnombre_campo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_anterior(String newvalor_anterior)throws Exception
	{
		try {
			if(this.valor_anterior!=newvalor_anterior) {
				if(newvalor_anterior==null) {
					//newvalor_anterior="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AuditoriaDetalle:Valor nulo no permitido en columna valor_anterior");
					}
				}

				if(newvalor_anterior!=null&&newvalor_anterior.length()>250) {
					newvalor_anterior=newvalor_anterior.substring(0,248);
					System.out.println("AuditoriaDetalle:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna valor_anterior");
				}

				this.valor_anterior=newvalor_anterior;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_actual(String newvalor_actual)throws Exception
	{
		try {
			if(this.valor_actual!=newvalor_actual) {
				if(newvalor_actual==null) {
					//newvalor_actual="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AuditoriaDetalle:Valor nulo no permitido en columna valor_actual");
					}
				}

				if(newvalor_actual!=null&&newvalor_actual.length()>250) {
					newvalor_actual=newvalor_actual.substring(0,248);
					System.out.println("AuditoriaDetalle:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna valor_actual");
				}

				this.valor_actual=newvalor_actual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Auditoria getAuditoria() {
		return this.auditoria;
	}

	
	
	public String getauditoria_descripcion() {
		return this.auditoria_descripcion;
	}

	
	
	public  void  setAuditoria(Auditoria auditoria) {
		try {
			this.auditoria=auditoria;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setauditoria_descripcion(String auditoria_descripcion) {
		try {
			this.auditoria_descripcion=auditoria_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_auditoria_descripcion="";
	
	
	public String getid_auditoria_descripcion() {
		return id_auditoria_descripcion;
	}
	
	
	public void setid_auditoria_descripcion(String newid_auditoria_descripcion)throws Exception {
		try {
			this.id_auditoria_descripcion=newid_auditoria_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_auditoria_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

