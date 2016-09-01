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
package com.bydan.erp.cartera.business.entity;

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
//import com.bydan.erp.cartera.util.InformacionFinancieraConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class InformacionFinanciera extends InformacionFinancieraAdditional implements Serializable ,Cloneable {//InformacionFinancieraAdditional,GeneralEntity
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
	
	private InformacionFinanciera informacionfinancieraOriginal;
	
	private Map<String, Object> mapInformacionFinanciera;
			
	public Map<String, Object> getMapInformacionFinanciera() {
		return mapInformacionFinanciera;
	}

	public void setMapInformacionFinanciera(Map<String, Object> mapInformacionFinanciera) {
		this.mapInformacionFinanciera = mapInformacionFinanciera;
	}
	
	public void inicializarMapInformacionFinanciera() {
		this.mapInformacionFinanciera = new HashMap<String,Object>();
	}
	
	public void setMapInformacionFinancieraValue(String sKey,Object oValue) {
		this.mapInformacionFinanciera.put(sKey, oValue);
	}
	
	public Object getMapInformacionFinancieraValue(String sKey) {
		return this.mapInformacionFinanciera.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idcliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idvalorclientemovimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=InformacionFinancieraConstantesFunciones.SREGEXDESCRIPCION,message=InformacionFinancieraConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esactivo;
			
	
	public Empresa empresa;
	public Cliente cliente;
	public TipoMoviFinan tipomovifinan;
	
	
	private String empresa_descripcion;
	private String cliente_descripcion;
	private String tipomovifinan_descripcion;
	
	
		
	public InformacionFinanciera () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.informacionfinancieraOriginal=this;
		
 		this.id_empresa=-1L;
 		this.idcliente=-1L;
 		this.idvalorclientemovimiento=-1L;
 		this.valor=0.0;
 		this.descripcion="";
 		this.esactivo=false;
		
		
		this.empresa=null;
		this.cliente=null;
		this.tipomovifinan=null;
		
		
		this.empresa_descripcion="";
		this.cliente_descripcion="";
		this.tipomovifinan_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public InformacionFinanciera (Long id,Date versionRow,Long id_empresa,Long idcliente,Long idvalorclientemovimiento,Double valor,String descripcion,Boolean esactivo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.informacionfinancieraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.idcliente=idcliente;
 		this.idvalorclientemovimiento=idvalorclientemovimiento;
 		this.valor=valor;
 		this.descripcion=descripcion;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public InformacionFinanciera (Long id_empresa,Long idcliente,Long idvalorclientemovimiento,Double valor,String descripcion,Boolean esactivo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.informacionfinancieraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.idcliente=idcliente;
 		this.idvalorclientemovimiento=idvalorclientemovimiento;
 		this.valor=valor;
 		this.descripcion=descripcion;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		InformacionFinanciera informacionfinancieraLocal=null;
		
		if(object!=null) {
			informacionfinancieraLocal=(InformacionFinanciera)object;
			
			if(informacionfinancieraLocal!=null) {
				if(this.getId()!=null && informacionfinancieraLocal.getId()!=null) {
					if(this.getId().equals(informacionfinancieraLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!InformacionFinancieraConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=InformacionFinancieraConstantesFunciones.getInformacionFinancieraDescripcion(this);
		} else {
			sDetalle=InformacionFinancieraConstantesFunciones.getInformacionFinancieraDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public InformacionFinanciera getInformacionFinancieraOriginal() {
		return this.informacionfinancieraOriginal;
	}
	
	public void setInformacionFinancieraOriginal(InformacionFinanciera informacionfinanciera) {
		try {
			this.informacionfinancieraOriginal=informacionfinanciera;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected InformacionFinancieraAdditional informacionfinancieraAdditional=null;
	
	public InformacionFinancieraAdditional getInformacionFinancieraAdditional() {
		return this.informacionfinancieraAdditional;
	}
	
	public void setInformacionFinancieraAdditional(InformacionFinancieraAdditional informacionfinancieraAdditional) {
		try {
			this.informacionfinancieraAdditional=informacionfinancieraAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getidcliente() {
		return this.idcliente;
	}
    
	
	public Long getidvalorclientemovimiento() {
		return this.idvalorclientemovimiento;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Boolean getesactivo() {
		return this.esactivo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionFinanciera:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidcliente(Long newidcliente)throws Exception
	{
		try {
			if(this.idcliente!=newidcliente) {
				if(newidcliente==null) {
					//newidcliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionFinanciera:Valor nulo no permitido en columna idcliente");
					}
				}

				this.idcliente=newidcliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidvalorclientemovimiento(Long newidvalorclientemovimiento)throws Exception
	{
		try {
			if(this.idvalorclientemovimiento!=newidvalorclientemovimiento) {
				if(newidvalorclientemovimiento==null) {
					//newidvalorclientemovimiento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionFinanciera:Valor nulo no permitido en columna idvalorclientemovimiento");
					}
				}

				this.idvalorclientemovimiento=newidvalorclientemovimiento;
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
						System.out.println("InformacionFinanciera:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
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
						System.out.println("InformacionFinanciera:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("InformacionFinanciera:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesactivo(Boolean newesactivo)throws Exception
	{
		try {
			if(this.esactivo!=newesactivo) {
				if(newesactivo==null) {
					//newesactivo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformacionFinanciera:Valor nulo no permitido en columna esactivo");
					}
				}

				this.esactivo=newesactivo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoMoviFinan getTipoMoviFinan() {
		return this.tipomovifinan;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipomovifinan_descripcion() {
		return this.tipomovifinan_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoMoviFinan(TipoMoviFinan tipomovifinan) {
		try {
			this.tipomovifinan=tipomovifinan;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipomovifinan_descripcion(String tipomovifinan_descripcion) {
		try {
			this.tipomovifinan_descripcion=tipomovifinan_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String idcliente_descripcion="";String idvalorclientemovimiento_descripcion="";String esactivo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getidcliente_descripcion() {
		return idcliente_descripcion;
	}
	public String getidvalorclientemovimiento_descripcion() {
		return idvalorclientemovimiento_descripcion;
	}
	public String getesactivo_descripcion() {
		return esactivo_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidcliente_descripcion(String newidcliente_descripcion)throws Exception {
		try {
			this.idcliente_descripcion=newidcliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidvalorclientemovimiento_descripcion(String newidvalorclientemovimiento_descripcion)throws Exception {
		try {
			this.idvalorclientemovimiento_descripcion=newidvalorclientemovimiento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesactivo_descripcion(String newesactivo_descripcion)throws Exception {
		try {
			this.esactivo_descripcion=newesactivo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.idcliente_descripcion="";this.idvalorclientemovimiento_descripcion="";this.esactivo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

