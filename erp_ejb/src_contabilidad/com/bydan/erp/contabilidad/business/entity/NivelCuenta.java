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
//import com.bydan.erp.contabilidad.util.NivelCuentaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;









@SuppressWarnings("unused")
public class NivelCuenta extends NivelCuentaAdditional implements Serializable ,Cloneable {//NivelCuentaAdditional,GeneralEntity
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
	
	private NivelCuenta nivelcuentaOriginal;
	
	private Map<String, Object> mapNivelCuenta;
			
	public Map<String, Object> getMapNivelCuenta() {
		return mapNivelCuenta;
	}

	public void setMapNivelCuenta(Map<String, Object> mapNivelCuenta) {
		this.mapNivelCuenta = mapNivelCuenta;
	}
	
	public void inicializarMapNivelCuenta() {
		this.mapNivelCuenta = new HashMap<String,Object>();
	}
	
	public void setMapNivelCuentaValue(String sKey,Object oValue) {
		this.mapNivelCuenta.put(sKey, oValue);
	}
	
	public Object getMapNivelCuentaValue(String sKey) {
		return this.mapNivelCuenta.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NivelCuentaConstantesFunciones.SREGEXNOMBRE,message=NivelCuentaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
	public List<CuentaContable> cuentacontables;
		
	public NivelCuenta () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.nivelcuentaOriginal=this;
		
 		this.nombre="";
		
		
		
		
		
		
		this.cuentacontables=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public NivelCuenta (Long id,Date versionRow,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.nivelcuentaOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public NivelCuenta (String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.nivelcuentaOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		NivelCuenta nivelcuentaLocal=null;
		
		if(object!=null) {
			nivelcuentaLocal=(NivelCuenta)object;
			
			if(nivelcuentaLocal!=null) {
				if(this.getId()!=null && nivelcuentaLocal.getId()!=null) {
					if(this.getId().equals(nivelcuentaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!NivelCuentaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=NivelCuentaConstantesFunciones.getNivelCuentaDescripcion(this);
		} else {
			sDetalle=NivelCuentaConstantesFunciones.getNivelCuentaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public NivelCuenta getNivelCuentaOriginal() {
		return this.nivelcuentaOriginal;
	}
	
	public void setNivelCuentaOriginal(NivelCuenta nivelcuenta) {
		try {
			this.nivelcuentaOriginal=nivelcuenta;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected NivelCuentaAdditional nivelcuentaAdditional=null;
	
	public NivelCuentaAdditional getNivelCuentaAdditional() {
		return this.nivelcuentaAdditional;
	}
	
	public void setNivelCuentaAdditional(NivelCuentaAdditional nivelcuentaAdditional) {
		try {
			this.nivelcuentaAdditional=nivelcuentaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NivelCuenta:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("NivelCuenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<CuentaContable> getCuentaContables() {
		return this.cuentacontables;
	}

	
	
	public  void  setCuentaContables(List<CuentaContable> cuentacontables) {
		try {
			this.cuentacontables=cuentacontables;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object cuentacontablesDescripcionReporte;
	
	
	public Object getcuentacontablesDescripcionReporte() {
		return cuentacontablesDescripcionReporte;
	}

	
	
	public  void  setcuentacontablesDescripcionReporte(Object cuentacontables) {
		try {
			this.cuentacontablesDescripcionReporte=cuentacontables;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

