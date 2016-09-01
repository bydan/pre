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
//import com.bydan.erp.nomina.util.RubroEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class RubroEmpleado extends RubroEmpleadoAdditional implements Serializable ,Cloneable {//RubroEmpleadoAdditional,GeneralEntity
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
	
	private RubroEmpleado rubroempleadoOriginal;
	
	private Map<String, Object> mapRubroEmpleado;
			
	public Map<String, Object> getMapRubroEmpleado() {
		return mapRubroEmpleado;
	}

	public void setMapRubroEmpleado(Map<String, Object> mapRubroEmpleado) {
		this.mapRubroEmpleado = mapRubroEmpleado;
	}
	
	public void inicializarMapRubroEmpleado() {
		this.mapRubroEmpleado = new HashMap<String,Object>();
	}
	
	public void setMapRubroEmpleadoValue(String sKey,Object oValue) {
		this.mapRubroEmpleado.put(sKey, oValue);
	}
	
	public Object getMapRubroEmpleadoValue(String sKey) {
		return this.mapRubroEmpleado.get(sKey);
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
	private Long id_rubro_emplea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_rubro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public RubroEmplea rubroemplea;
	public EstadoRubro estadorubro;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String rubroemplea_descripcion;
	private String estadorubro_descripcion;
	
	
		
	public RubroEmpleado () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.rubroempleadoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_rubro_emplea=-1L;
 		this.id_estado_rubro=-1L;
 		this.valor=0.0;
		
		
		this.empresa=null;
		this.empleado=null;
		this.rubroemplea=null;
		this.estadorubro=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.rubroemplea_descripcion="";
		this.estadorubro_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public RubroEmpleado (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_rubro_emplea,Long id_estado_rubro,Double valor) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.rubroempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_rubro_emplea=id_rubro_emplea;
 		this.id_estado_rubro=id_estado_rubro;
 		this.valor=valor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public RubroEmpleado (Long id_empresa,Long id_empleado,Long id_rubro_emplea,Long id_estado_rubro,Double valor) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.rubroempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_rubro_emplea=id_rubro_emplea;
 		this.id_estado_rubro=id_estado_rubro;
 		this.valor=valor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		RubroEmpleado rubroempleadoLocal=null;
		
		if(object!=null) {
			rubroempleadoLocal=(RubroEmpleado)object;
			
			if(rubroempleadoLocal!=null) {
				if(this.getId()!=null && rubroempleadoLocal.getId()!=null) {
					if(this.getId().equals(rubroempleadoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!RubroEmpleadoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=RubroEmpleadoConstantesFunciones.getRubroEmpleadoDescripcion(this);
		} else {
			sDetalle=RubroEmpleadoConstantesFunciones.getRubroEmpleadoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public RubroEmpleado getRubroEmpleadoOriginal() {
		return this.rubroempleadoOriginal;
	}
	
	public void setRubroEmpleadoOriginal(RubroEmpleado rubroempleado) {
		try {
			this.rubroempleadoOriginal=rubroempleado;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected RubroEmpleadoAdditional rubroempleadoAdditional=null;
	
	public RubroEmpleadoAdditional getRubroEmpleadoAdditional() {
		return this.rubroempleadoAdditional;
	}
	
	public void setRubroEmpleadoAdditional(RubroEmpleadoAdditional rubroempleadoAdditional) {
		try {
			this.rubroempleadoAdditional=rubroempleadoAdditional;
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
    
	
	public Long getid_rubro_emplea() {
		return this.id_rubro_emplea;
	}
    
	
	public Long getid_estado_rubro() {
		return this.id_estado_rubro;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmpleado:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("RubroEmpleado:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_rubro_emplea(Long newid_rubro_emplea)throws Exception
	{
		try {
			if(this.id_rubro_emplea!=newid_rubro_emplea) {
				if(newid_rubro_emplea==null) {
					//newid_rubro_emplea=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmpleado:Valor nulo no permitido en columna id_rubro_emplea");
					}
				}

				this.id_rubro_emplea=newid_rubro_emplea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_rubro(Long newid_estado_rubro)throws Exception
	{
		try {
			if(this.id_estado_rubro!=newid_estado_rubro) {
				if(newid_estado_rubro==null) {
					//newid_estado_rubro=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmpleado:Valor nulo no permitido en columna id_estado_rubro");
					}
				}

				this.id_estado_rubro=newid_estado_rubro;
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
						System.out.println("RubroEmpleado:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
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

	public RubroEmplea getRubroEmplea() {
		return this.rubroemplea;
	}

	public EstadoRubro getEstadoRubro() {
		return this.estadorubro;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getrubroemplea_descripcion() {
		return this.rubroemplea_descripcion;
	}

	public String getestadorubro_descripcion() {
		return this.estadorubro_descripcion;
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


	public  void  setRubroEmplea(RubroEmplea rubroemplea) {
		try {
			this.rubroemplea=rubroemplea;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoRubro(EstadoRubro estadorubro) {
		try {
			this.estadorubro=estadorubro;
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


	public  void  setrubroemplea_descripcion(String rubroemplea_descripcion) {
		try {
			this.rubroemplea_descripcion=rubroemplea_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadorubro_descripcion(String estadorubro_descripcion) {
		try {
			this.estadorubro_descripcion=estadorubro_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_rubro_emplea_descripcion="";String id_estado_rubro_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_rubro_emplea_descripcion() {
		return id_rubro_emplea_descripcion;
	}
	public String getid_estado_rubro_descripcion() {
		return id_estado_rubro_descripcion;
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
	public void setid_rubro_emplea_descripcion(String newid_rubro_emplea_descripcion)throws Exception {
		try {
			this.id_rubro_emplea_descripcion=newid_rubro_emplea_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_rubro_descripcion(String newid_estado_rubro_descripcion)throws Exception {
		try {
			this.id_estado_rubro_descripcion=newid_estado_rubro_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_rubro_emplea_descripcion="";this.id_estado_rubro_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

