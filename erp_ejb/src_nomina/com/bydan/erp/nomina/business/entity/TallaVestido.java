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
//import com.bydan.erp.nomina.util.TallaVestidoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class TallaVestido extends TallaVestidoAdditional implements Serializable ,Cloneable {//TallaVestidoAdditional,GeneralEntity
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
	
	private TallaVestido tallavestidoOriginal;
	
	private Map<String, Object> mapTallaVestido;
			
	public Map<String, Object> getMapTallaVestido() {
		return mapTallaVestido;
	}

	public void setMapTallaVestido(Map<String, Object> mapTallaVestido) {
		this.mapTallaVestido = mapTallaVestido;
	}
	
	public void inicializarMapTallaVestido() {
		this.mapTallaVestido = new HashMap<String,Object>();
	}
	
	public void setMapTallaVestidoValue(String sKey,Object oValue) {
		this.mapTallaVestido.put(sKey, oValue);
	}
	
	public Object getMapTallaVestidoValue(String sKey) {
		return this.mapTallaVestido.get(sKey);
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
	private Long id_vestimenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double talla;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TallaVestidoConstantesFunciones.SREGEXDESCRIPCION,message=TallaVestidoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public Vestimenta vestimenta;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String vestimenta_descripcion;
	
	
		
	public TallaVestido () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tallavestidoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_vestimenta=-1L;
 		this.talla=0.0;
 		this.cantidad=0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.empleado=null;
		this.vestimenta=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.vestimenta_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TallaVestido (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_vestimenta,Double talla,Integer cantidad,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tallavestidoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_vestimenta=id_vestimenta;
 		this.talla=talla;
 		this.cantidad=cantidad;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TallaVestido (Long id_empresa,Long id_empleado,Long id_vestimenta,Double talla,Integer cantidad,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tallavestidoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_vestimenta=id_vestimenta;
 		this.talla=talla;
 		this.cantidad=cantidad;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TallaVestido tallavestidoLocal=null;
		
		if(object!=null) {
			tallavestidoLocal=(TallaVestido)object;
			
			if(tallavestidoLocal!=null) {
				if(this.getId()!=null && tallavestidoLocal.getId()!=null) {
					if(this.getId().equals(tallavestidoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TallaVestidoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TallaVestidoConstantesFunciones.getTallaVestidoDescripcion(this);
		} else {
			sDetalle=TallaVestidoConstantesFunciones.getTallaVestidoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TallaVestido getTallaVestidoOriginal() {
		return this.tallavestidoOriginal;
	}
	
	public void setTallaVestidoOriginal(TallaVestido tallavestido) {
		try {
			this.tallavestidoOriginal=tallavestido;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TallaVestidoAdditional tallavestidoAdditional=null;
	
	public TallaVestidoAdditional getTallaVestidoAdditional() {
		return this.tallavestidoAdditional;
	}
	
	public void setTallaVestidoAdditional(TallaVestidoAdditional tallavestidoAdditional) {
		try {
			this.tallavestidoAdditional=tallavestidoAdditional;
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
    
	
	public Long getid_vestimenta() {
		return this.id_vestimenta;
	}
    
	
	public Double gettalla() {
		return this.talla;
	}
    
	
	public Integer getcantidad() {
		return this.cantidad;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TallaVestido:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("TallaVestido:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_vestimenta(Long newid_vestimenta)throws Exception
	{
		try {
			if(this.id_vestimenta!=newid_vestimenta) {
				if(newid_vestimenta==null) {
					//newid_vestimenta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TallaVestido:Valor nulo no permitido en columna id_vestimenta");
					}
				}

				this.id_vestimenta=newid_vestimenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settalla(Double newtalla)throws Exception
	{
		try {
			if(this.talla!=newtalla) {
				if(newtalla==null) {
					//newtalla=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TallaVestido:Valor nulo no permitido en columna talla");
					}
				}

				this.talla=newtalla;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad(Integer newcantidad)throws Exception
	{
		try {
			if(this.cantidad!=newcantidad) {
				if(newcantidad==null) {
					//newcantidad=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TallaVestido:Valor nulo no permitido en columna cantidad");
					}
				}

				this.cantidad=newcantidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TallaVestido:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("TallaVestido:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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

	public Vestimenta getVestimenta() {
		return this.vestimenta;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getvestimenta_descripcion() {
		return this.vestimenta_descripcion;
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


	public  void  setVestimenta(Vestimenta vestimenta) {
		try {
			this.vestimenta=vestimenta;
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


	public  void  setvestimenta_descripcion(String vestimenta_descripcion) {
		try {
			this.vestimenta_descripcion=vestimenta_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_vestimenta_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_vestimenta_descripcion() {
		return id_vestimenta_descripcion;
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
	public void setid_vestimenta_descripcion(String newid_vestimenta_descripcion)throws Exception {
		try {
			this.id_vestimenta_descripcion=newid_vestimenta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_vestimenta_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

