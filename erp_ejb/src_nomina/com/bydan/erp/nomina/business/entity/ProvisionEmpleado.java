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
//import com.bydan.erp.nomina.util.ProvisionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ProvisionEmpleado extends ProvisionEmpleadoAdditional implements Serializable ,Cloneable {//ProvisionEmpleadoAdditional,GeneralEntity
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
	
	private ProvisionEmpleado provisionempleadoOriginal;
	
	private Map<String, Object> mapProvisionEmpleado;
			
	public Map<String, Object> getMapProvisionEmpleado() {
		return mapProvisionEmpleado;
	}

	public void setMapProvisionEmpleado(Map<String, Object> mapProvisionEmpleado) {
		this.mapProvisionEmpleado = mapProvisionEmpleado;
	}
	
	public void inicializarMapProvisionEmpleado() {
		this.mapProvisionEmpleado = new HashMap<String,Object>();
	}
	
	public void setMapProvisionEmpleadoValue(String sKey,Object oValue) {
		this.mapProvisionEmpleado.put(sKey, oValue);
	}
	
	public Object getMapProvisionEmpleadoValue(String sKey) {
		return this.mapProvisionEmpleado.get(sKey);
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
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_provision_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_defi_provision_empleado;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_liquidacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_paga;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_vacacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_liquidacion;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public Estructura estructura;
	public TipoProvisionEmpleado tipoprovisionempleado;
	public DefiProvisionEmpleado defiprovisionempleado;
	public Anio anio;
	public Mes mes;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String estructura_descripcion;
	private String tipoprovisionempleado_descripcion;
	private String defiprovisionempleado_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	
	
		
	public ProvisionEmpleado () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.provisionempleadoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_estructura=-1L;
 		this.id_tipo_provision_empleado=-1L;
 		this.id_defi_provision_empleado=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.fecha=new Date();
 		this.fecha_liquidacion=new Date();
 		this.valor_mes=0.0;
 		this.valor_paga=0.0;
 		this.valor_vacacion=0.0;
 		this.valor_liquidacion=0.0;
		
		
		this.empresa=null;
		this.empleado=null;
		this.estructura=null;
		this.tipoprovisionempleado=null;
		this.defiprovisionempleado=null;
		this.anio=null;
		this.mes=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.estructura_descripcion="";
		this.tipoprovisionempleado_descripcion="";
		this.defiprovisionempleado_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ProvisionEmpleado (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_estructura,Long id_tipo_provision_empleado,Long id_defi_provision_empleado,Long id_anio,Long id_mes,Date fecha,Date fecha_liquidacion,Double valor_mes,Double valor_paga,Double valor_vacacion,Double valor_liquidacion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.provisionempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_estructura=id_estructura;
 		this.id_tipo_provision_empleado=id_tipo_provision_empleado;
 		this.id_defi_provision_empleado=id_defi_provision_empleado;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.fecha=fecha;
 		this.fecha_liquidacion=fecha_liquidacion;
 		this.valor_mes=valor_mes;
 		this.valor_paga=valor_paga;
 		this.valor_vacacion=valor_vacacion;
 		this.valor_liquidacion=valor_liquidacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ProvisionEmpleado (Long id_empresa,Long id_empleado,Long id_estructura,Long id_tipo_provision_empleado,Long id_defi_provision_empleado,Long id_anio,Long id_mes,Date fecha,Date fecha_liquidacion,Double valor_mes,Double valor_paga,Double valor_vacacion,Double valor_liquidacion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.provisionempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_estructura=id_estructura;
 		this.id_tipo_provision_empleado=id_tipo_provision_empleado;
 		this.id_defi_provision_empleado=id_defi_provision_empleado;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.fecha=fecha;
 		this.fecha_liquidacion=fecha_liquidacion;
 		this.valor_mes=valor_mes;
 		this.valor_paga=valor_paga;
 		this.valor_vacacion=valor_vacacion;
 		this.valor_liquidacion=valor_liquidacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ProvisionEmpleado provisionempleadoLocal=null;
		
		if(object!=null) {
			provisionempleadoLocal=(ProvisionEmpleado)object;
			
			if(provisionempleadoLocal!=null) {
				if(this.getId()!=null && provisionempleadoLocal.getId()!=null) {
					if(this.getId().equals(provisionempleadoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ProvisionEmpleadoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ProvisionEmpleadoConstantesFunciones.getProvisionEmpleadoDescripcion(this);
		} else {
			sDetalle=ProvisionEmpleadoConstantesFunciones.getProvisionEmpleadoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ProvisionEmpleado getProvisionEmpleadoOriginal() {
		return this.provisionempleadoOriginal;
	}
	
	public void setProvisionEmpleadoOriginal(ProvisionEmpleado provisionempleado) {
		try {
			this.provisionempleadoOriginal=provisionempleado;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProvisionEmpleadoAdditional provisionempleadoAdditional=null;
	
	public ProvisionEmpleadoAdditional getProvisionEmpleadoAdditional() {
		return this.provisionempleadoAdditional;
	}
	
	public void setProvisionEmpleadoAdditional(ProvisionEmpleadoAdditional provisionempleadoAdditional) {
		try {
			this.provisionempleadoAdditional=provisionempleadoAdditional;
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
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Long getid_tipo_provision_empleado() {
		return this.id_tipo_provision_empleado;
	}
    
	
	public Long getid_defi_provision_empleado() {
		return this.id_defi_provision_empleado;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Date getfecha_liquidacion() {
		return this.fecha_liquidacion;
	}
    
	
	public Double getvalor_mes() {
		return this.valor_mes;
	}
    
	
	public Double getvalor_paga() {
		return this.valor_paga;
	}
    
	
	public Double getvalor_vacacion() {
		return this.valor_vacacion;
	}
    
	
	public Double getvalor_liquidacion() {
		return this.valor_liquidacion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProvisionEmpleado:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ProvisionEmpleado:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estructura(Long newid_estructura)throws Exception
	{
		try {
			if(this.id_estructura!=newid_estructura) {
				if(newid_estructura==null) {
					//newid_estructura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProvisionEmpleado:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_provision_empleado(Long newid_tipo_provision_empleado)throws Exception
	{
		try {
			if(this.id_tipo_provision_empleado!=newid_tipo_provision_empleado) {
				if(newid_tipo_provision_empleado==null) {
					//newid_tipo_provision_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProvisionEmpleado:Valor nulo no permitido en columna id_tipo_provision_empleado");
					}
				}

				this.id_tipo_provision_empleado=newid_tipo_provision_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_defi_provision_empleado(Long newid_defi_provision_empleado)throws Exception
	{
		try {
			if(this.id_defi_provision_empleado!=newid_defi_provision_empleado) {
				if(newid_defi_provision_empleado==null) {
					//newid_defi_provision_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProvisionEmpleado:Valor nulo no permitido en columna id_defi_provision_empleado");
					}
				}

				this.id_defi_provision_empleado=newid_defi_provision_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_anio(Long newid_anio) {
		if(this.id_anio==null&&newid_anio!=null) {
			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}

		if(this.id_anio!=null&&!this.id_anio.equals(newid_anio)) {

			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_mes(Long newid_mes) {
		if(this.id_mes==null&&newid_mes!=null) {
			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}

		if(this.id_mes!=null&&!this.id_mes.equals(newid_mes)) {

			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProvisionEmpleado:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_liquidacion(Date newfecha_liquidacion)throws Exception
	{
		try {
			if(this.fecha_liquidacion!=newfecha_liquidacion) {
				if(newfecha_liquidacion==null) {
					//newfecha_liquidacion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProvisionEmpleado:Valor nulo no permitido en columna fecha_liquidacion");
					}
				}

				this.fecha_liquidacion=newfecha_liquidacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_mes(Double newvalor_mes)throws Exception
	{
		try {
			if(this.valor_mes!=newvalor_mes) {
				if(newvalor_mes==null) {
					//newvalor_mes=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProvisionEmpleado:Valor nulo no permitido en columna valor_mes");
					}
				}

				this.valor_mes=newvalor_mes;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_paga(Double newvalor_paga)throws Exception
	{
		try {
			if(this.valor_paga!=newvalor_paga) {
				if(newvalor_paga==null) {
					//newvalor_paga=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProvisionEmpleado:Valor nulo no permitido en columna valor_paga");
					}
				}

				this.valor_paga=newvalor_paga;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_vacacion(Double newvalor_vacacion)throws Exception
	{
		try {
			if(this.valor_vacacion!=newvalor_vacacion) {
				if(newvalor_vacacion==null) {
					//newvalor_vacacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProvisionEmpleado:Valor nulo no permitido en columna valor_vacacion");
					}
				}

				this.valor_vacacion=newvalor_vacacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_liquidacion(Double newvalor_liquidacion)throws Exception
	{
		try {
			if(this.valor_liquidacion!=newvalor_liquidacion) {
				if(newvalor_liquidacion==null) {
					//newvalor_liquidacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProvisionEmpleado:Valor nulo no permitido en columna valor_liquidacion");
					}
				}

				this.valor_liquidacion=newvalor_liquidacion;
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

	public Estructura getEstructura() {
		return this.estructura;
	}

	public TipoProvisionEmpleado getTipoProvisionEmpleado() {
		return this.tipoprovisionempleado;
	}

	public DefiProvisionEmpleado getDefiProvisionEmpleado() {
		return this.defiprovisionempleado;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String gettipoprovisionempleado_descripcion() {
		return this.tipoprovisionempleado_descripcion;
	}

	public String getdefiprovisionempleado_descripcion() {
		return this.defiprovisionempleado_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
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


	public  void  setEstructura(Estructura estructura) {
		try {
			this.estructura=estructura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoProvisionEmpleado(TipoProvisionEmpleado tipoprovisionempleado) {
		try {
			this.tipoprovisionempleado=tipoprovisionempleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDefiProvisionEmpleado(DefiProvisionEmpleado defiprovisionempleado) {
		try {
			this.defiprovisionempleado=defiprovisionempleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAnio(Anio anio) {
		try {
			this.anio=anio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMes(Mes mes) {
		try {
			this.mes=mes;
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


	public  void  setestructura_descripcion(String estructura_descripcion) {
		try {
			this.estructura_descripcion=estructura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoprovisionempleado_descripcion(String tipoprovisionempleado_descripcion) {
		try {
			this.tipoprovisionempleado_descripcion=tipoprovisionempleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdefiprovisionempleado_descripcion(String defiprovisionempleado_descripcion) {
		try {
			this.defiprovisionempleado_descripcion=defiprovisionempleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setanio_descripcion(String anio_descripcion) {
		try {
			this.anio_descripcion=anio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmes_descripcion(String mes_descripcion) {
		try {
			this.mes_descripcion=mes_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_estructura_descripcion="";String id_tipo_provision_empleado_descripcion="";String id_defi_provision_empleado_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_tipo_provision_empleado_descripcion() {
		return id_tipo_provision_empleado_descripcion;
	}
	public String getid_defi_provision_empleado_descripcion() {
		return id_defi_provision_empleado_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
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
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_provision_empleado_descripcion(String newid_tipo_provision_empleado_descripcion)throws Exception {
		try {
			this.id_tipo_provision_empleado_descripcion=newid_tipo_provision_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_defi_provision_empleado_descripcion(String newid_defi_provision_empleado_descripcion)throws Exception {
		try {
			this.id_defi_provision_empleado_descripcion=newid_defi_provision_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_anio_descripcion(String newid_anio_descripcion)throws Exception {
		try {
			this.id_anio_descripcion=newid_anio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_descripcion(String newid_mes_descripcion)throws Exception {
		try {
			this.id_mes_descripcion=newid_mes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_estructura_descripcion="";this.id_tipo_provision_empleado_descripcion="";this.id_defi_provision_empleado_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

