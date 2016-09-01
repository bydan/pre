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
package com.bydan.erp.sris.business.entity;

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
//import com.bydan.erp.sris.util.RetencionVentaConstantesFunciones;
import com.bydan.erp.sris.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class RetencionVenta extends RetencionVentaAdditional implements Serializable ,Cloneable {//RetencionVentaAdditional,GeneralEntity
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
	
	private RetencionVenta retencionventaOriginal;
	
	private Map<String, Object> mapRetencionVenta;
			
	public Map<String, Object> getMapRetencionVenta() {
		return mapRetencionVenta;
	}

	public void setMapRetencionVenta(Map<String, Object> mapRetencionVenta) {
		this.mapRetencionVenta = mapRetencionVenta;
	}
	
	public void inicializarMapRetencionVenta() {
		this.mapRetencionVenta = new HashMap<String,Object>();
	}
	
	public void setMapRetencionVentaValue(String sKey,Object oValue) {
		this.mapRetencionVenta.put(sKey, oValue);
	}
	
	public Object getMapRetencionVentaValue(String sKey) {
		return this.mapRetencionVenta.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo_declara;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RetencionVentaConstantesFunciones.SREGEXRUC,message=RetencionVentaConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RetencionVentaConstantesFunciones.SREGEXNUMERO_RETENCION,message=RetencionVentaConstantesFunciones.SMENSAJEREGEXNUMERO_RETENCION)
	private String numero_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double base_imponible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_debito;
			
	
	public Empresa empresa;
	public PeriodoDeclara periododeclara;
	public TipoRetencion tiporetencion;
	
	
	private String empresa_descripcion;
	private String periododeclara_descripcion;
	private String tiporetencion_descripcion;
	
	
		
	public RetencionVenta () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.retencionventaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_periodo_declara=-1L;
 		this.id_tipo_retencion=-1L;
 		this.ruc="";
 		this.numero_retencion="";
 		this.base_imponible=0.0;
 		this.porcentaje=0.0;
 		this.valor=0.0;
 		this.es_debito=false;
		
		
		this.empresa=null;
		this.periododeclara=null;
		this.tiporetencion=null;
		
		
		this.empresa_descripcion="";
		this.periododeclara_descripcion="";
		this.tiporetencion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public RetencionVenta (Long id,Date versionRow,Long id_empresa,Long id_periodo_declara,Long id_tipo_retencion,String ruc,String numero_retencion,Double base_imponible,Double porcentaje,Double valor,Boolean es_debito) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.retencionventaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_periodo_declara=id_periodo_declara;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.ruc=ruc;
 		this.numero_retencion=numero_retencion;
 		this.base_imponible=base_imponible;
 		this.porcentaje=porcentaje;
 		this.valor=valor;
 		this.es_debito=es_debito;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public RetencionVenta (Long id_empresa,Long id_periodo_declara,Long id_tipo_retencion,String ruc,String numero_retencion,Double base_imponible,Double porcentaje,Double valor,Boolean es_debito) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.retencionventaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_periodo_declara=id_periodo_declara;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.ruc=ruc;
 		this.numero_retencion=numero_retencion;
 		this.base_imponible=base_imponible;
 		this.porcentaje=porcentaje;
 		this.valor=valor;
 		this.es_debito=es_debito;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		RetencionVenta retencionventaLocal=null;
		
		if(object!=null) {
			retencionventaLocal=(RetencionVenta)object;
			
			if(retencionventaLocal!=null) {
				if(this.getId()!=null && retencionventaLocal.getId()!=null) {
					if(this.getId().equals(retencionventaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!RetencionVentaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=RetencionVentaConstantesFunciones.getRetencionVentaDescripcion(this);
		} else {
			sDetalle=RetencionVentaConstantesFunciones.getRetencionVentaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public RetencionVenta getRetencionVentaOriginal() {
		return this.retencionventaOriginal;
	}
	
	public void setRetencionVentaOriginal(RetencionVenta retencionventa) {
		try {
			this.retencionventaOriginal=retencionventa;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected RetencionVentaAdditional retencionventaAdditional=null;
	
	public RetencionVentaAdditional getRetencionVentaAdditional() {
		return this.retencionventaAdditional;
	}
	
	public void setRetencionVentaAdditional(RetencionVentaAdditional retencionventaAdditional) {
		try {
			this.retencionventaAdditional=retencionventaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_periodo_declara() {
		return this.id_periodo_declara;
	}
    
	
	public Long getid_tipo_retencion() {
		return this.id_tipo_retencion;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String getnumero_retencion() {
		return this.numero_retencion;
	}
    
	
	public Double getbase_imponible() {
		return this.base_imponible;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Boolean getes_debito() {
		return this.es_debito;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionVenta:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo_declara(Long newid_periodo_declara)throws Exception
	{
		try {
			if(this.id_periodo_declara!=newid_periodo_declara) {
				if(newid_periodo_declara==null) {
					//newid_periodo_declara=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionVenta:Valor nulo no permitido en columna id_periodo_declara");
					}
				}

				this.id_periodo_declara=newid_periodo_declara;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_retencion(Long newid_tipo_retencion)throws Exception
	{
		try {
			if(this.id_tipo_retencion!=newid_tipo_retencion) {
				if(newid_tipo_retencion==null) {
					//newid_tipo_retencion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionVenta:Valor nulo no permitido en columna id_tipo_retencion");
					}
				}

				this.id_tipo_retencion=newid_tipo_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc(String newruc)throws Exception
	{
		try {
			if(this.ruc!=newruc) {
				if(newruc==null) {
					//newruc="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionVenta:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>20) {
					newruc=newruc.substring(0,18);
					System.out.println("RetencionVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_retencion(String newnumero_retencion)throws Exception
	{
		try {
			if(this.numero_retencion!=newnumero_retencion) {
				if(newnumero_retencion==null) {
					//newnumero_retencion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionVenta:Valor nulo no permitido en columna numero_retencion");
					}
				}

				if(newnumero_retencion!=null&&newnumero_retencion.length()>50) {
					newnumero_retencion=newnumero_retencion.substring(0,48);
					System.out.println("RetencionVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_retencion");
				}

				this.numero_retencion=newnumero_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbase_imponible(Double newbase_imponible)throws Exception
	{
		try {
			if(this.base_imponible!=newbase_imponible) {
				if(newbase_imponible==null) {
					//newbase_imponible=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionVenta:Valor nulo no permitido en columna base_imponible");
					}
				}

				this.base_imponible=newbase_imponible;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje(Double newporcentaje)throws Exception
	{
		try {
			if(this.porcentaje!=newporcentaje) {
				if(newporcentaje==null) {
					//newporcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionVenta:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
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
						System.out.println("RetencionVenta:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_debito(Boolean newes_debito)throws Exception
	{
		try {
			if(this.es_debito!=newes_debito) {
				if(newes_debito==null) {
					//newes_debito=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionVenta:Valor nulo no permitido en columna es_debito");
					}
				}

				this.es_debito=newes_debito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public PeriodoDeclara getPeriodoDeclara() {
		return this.periododeclara;
	}

	public TipoRetencion getTipoRetencion() {
		return this.tiporetencion;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getperiododeclara_descripcion() {
		return this.periododeclara_descripcion;
	}

	public String gettiporetencion_descripcion() {
		return this.tiporetencion_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPeriodoDeclara(PeriodoDeclara periododeclara) {
		try {
			this.periododeclara=periododeclara;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRetencion(TipoRetencion tiporetencion) {
		try {
			this.tiporetencion=tiporetencion;
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


	public  void  setperiododeclara_descripcion(String periododeclara_descripcion) {
		try {
			this.periododeclara_descripcion=periododeclara_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporetencion_descripcion(String tiporetencion_descripcion) {
		try {
			this.tiporetencion_descripcion=tiporetencion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_periodo_declara_descripcion="";String id_tipo_retencion_descripcion="";String es_debito_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_periodo_declara_descripcion() {
		return id_periodo_declara_descripcion;
	}
	public String getid_tipo_retencion_descripcion() {
		return id_tipo_retencion_descripcion;
	}
	public String getes_debito_descripcion() {
		return es_debito_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_periodo_declara_descripcion(String newid_periodo_declara_descripcion)throws Exception {
		try {
			this.id_periodo_declara_descripcion=newid_periodo_declara_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_retencion_descripcion(String newid_tipo_retencion_descripcion)throws Exception {
		try {
			this.id_tipo_retencion_descripcion=newid_tipo_retencion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_debito_descripcion(String newes_debito_descripcion)throws Exception {
		try {
			this.es_debito_descripcion=newes_debito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_periodo_declara_descripcion="";this.id_tipo_retencion_descripcion="";this.es_debito_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

