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
//import com.bydan.erp.nomina.util.EmpleadoConstanteConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class EmpleadoConstante extends EmpleadoConstanteAdditional implements Serializable ,Cloneable {//EmpleadoConstanteAdditional,GeneralEntity
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
	
	private EmpleadoConstante empleadoconstanteOriginal;
	
	private Map<String, Object> mapEmpleadoConstante;
			
	public Map<String, Object> getMapEmpleadoConstante() {
		return mapEmpleadoConstante;
	}

	public void setMapEmpleadoConstante(Map<String, Object> mapEmpleadoConstante) {
		this.mapEmpleadoConstante = mapEmpleadoConstante;
	}
	
	public void inicializarMapEmpleadoConstante() {
		this.mapEmpleadoConstante = new HashMap<String,Object>();
	}
	
	public void setMapEmpleadoConstanteValue(String sKey,Object oValue) {
		this.mapEmpleadoConstante.put(sKey, oValue);
	}
	
	public Object getMapEmpleadoConstanteValue(String sKey) {
		return this.mapEmpleadoConstante.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_constante_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_activo;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public ConstanteNomi constantenomi;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String constantenomi_descripcion;
	
	
		
	public EmpleadoConstante () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.empleadoconstanteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_constante_nomi=-1L;
 		this.valor=0.0;
 		this.esta_activo=false;
		
		
		this.empresa=null;
		this.empleado=null;
		this.constantenomi=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.constantenomi_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EmpleadoConstante (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_constante_nomi,Double valor,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empleadoconstanteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_constante_nomi=id_constante_nomi;
 		this.valor=valor;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EmpleadoConstante (Long id_empresa,Long id_empleado,Long id_constante_nomi,Double valor,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empleadoconstanteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_constante_nomi=id_constante_nomi;
 		this.valor=valor;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EmpleadoConstante empleadoconstanteLocal=null;
		
		if(object!=null) {
			empleadoconstanteLocal=(EmpleadoConstante)object;
			
			if(empleadoconstanteLocal!=null) {
				if(this.getId()!=null && empleadoconstanteLocal.getId()!=null) {
					if(this.getId().equals(empleadoconstanteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EmpleadoConstanteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EmpleadoConstanteConstantesFunciones.getEmpleadoConstanteDescripcion(this);
		} else {
			sDetalle=EmpleadoConstanteConstantesFunciones.getEmpleadoConstanteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EmpleadoConstante getEmpleadoConstanteOriginal() {
		return this.empleadoconstanteOriginal;
	}
	
	public void setEmpleadoConstanteOriginal(EmpleadoConstante empleadoconstante) {
		try {
			this.empleadoconstanteOriginal=empleadoconstante;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EmpleadoConstanteAdditional empleadoconstanteAdditional=null;
	
	public EmpleadoConstanteAdditional getEmpleadoConstanteAdditional() {
		return this.empleadoconstanteAdditional;
	}
	
	public void setEmpleadoConstanteAdditional(EmpleadoConstanteAdditional empleadoconstanteAdditional) {
		try {
			this.empleadoconstanteAdditional=empleadoconstanteAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_constante_nomi() {
		return this.id_constante_nomi;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Boolean getesta_activo() {
		return this.esta_activo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoConstante:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado(Long newid_empleado)throws Exception
	{
		try {
			if(this.id_empleado!=newid_empleado) {
				if(newid_empleado==null) {
					//newid_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoConstante:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_constante_nomi(Long newid_constante_nomi)throws Exception
	{
		try {
			if(this.id_constante_nomi!=newid_constante_nomi) {
				if(newid_constante_nomi==null) {
					//newid_constante_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoConstante:Valor nulo no permitido en columna id_constante_nomi");
					}
				}

				this.id_constante_nomi=newid_constante_nomi;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoConstante:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesta_activo(Boolean newesta_activo)throws Exception
	{
		try {
			if(this.esta_activo!=newesta_activo) {
				if(newesta_activo==null) {
					//newesta_activo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoConstante:Valor nulo no permitido en columna esta_activo");
					}
				}

				this.esta_activo=newesta_activo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public ConstanteNomi getConstanteNomi() {
		return this.constantenomi;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getconstantenomi_descripcion() {
		return this.constantenomi_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setConstanteNomi(ConstanteNomi constantenomi) {
		try {
			this.constantenomi=constantenomi;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setconstantenomi_descripcion(String constantenomi_descripcion) {
		try {
			this.constantenomi_descripcion=constantenomi_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_constante_nomi_descripcion="";String esta_activo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_constante_nomi_descripcion() {
		return id_constante_nomi_descripcion;
	}
	public String getesta_activo_descripcion() {
		return esta_activo_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_constante_nomi_descripcion(String newid_constante_nomi_descripcion)throws Exception {
		try {
			this.id_constante_nomi_descripcion=newid_constante_nomi_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesta_activo_descripcion(String newesta_activo_descripcion)throws Exception {
		try {
			this.esta_activo_descripcion=newesta_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_constante_nomi_descripcion="";this.esta_activo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

