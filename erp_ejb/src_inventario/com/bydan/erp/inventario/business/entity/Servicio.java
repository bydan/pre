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
package com.bydan.erp.inventario.business.entity;

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
//import com.bydan.erp.inventario.util.ServicioConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class Servicio extends ServicioAdditional implements Serializable ,Cloneable {//ServicioAdditional,GeneralEntity
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
	
	private Servicio servicioOriginal;
	
	private Map<String, Object> mapServicio;
			
	public Map<String, Object> getMapServicio() {
		return mapServicio;
	}

	public void setMapServicio(Map<String, Object> mapServicio) {
		this.mapServicio = mapServicio;
	}
	
	public void inicializarMapServicio() {
		this.mapServicio = new HashMap<String,Object>();
	}
	
	public void setMapServicioValue(String sKey,Object oValue) {
		this.mapServicio.put(sKey, oValue);
	}
	
	public Object getMapServicioValue(String sKey) {
		return this.mapServicio.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_servicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ServicioConstantesFunciones.SREGEXCODIGO,message=ServicioConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ServicioConstantesFunciones.SREGEXNOMBRE,message=ServicioConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=18,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_bien;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_servicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ServicioConstantesFunciones.SREGEXDESCRIPCION,message=ServicioConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_gasto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_fiscal;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_fiscal2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_retencion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_retencion2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_iva;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_iva2;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_credito;
			
	
	public Empresa empresa;
	public TipoServicio tiposervicio;
	public EstadoServicio estadoservicio;
	public CuentaContable cuentacontablegasto;
	public CuentaContable cuentacontablefiscal;
	public CuentaContable cuentacontablefiscal2;
	public CuentaContable cuentacontableretencion;
	public CuentaContable cuentacontableretencion2;
	public CuentaContable cuentacontableiva;
	public CuentaContable cuentacontableiva2;
	public CuentaContable cuentacontablecredito;
	
	
	private String empresa_descripcion;
	private String tiposervicio_descripcion;
	private String estadoservicio_descripcion;
	private String cuentacontablegasto_descripcion;
	private String cuentacontablefiscal_descripcion;
	private String cuentacontablefiscal2_descripcion;
	private String cuentacontableretencion_descripcion;
	private String cuentacontableretencion2_descripcion;
	private String cuentacontableiva_descripcion;
	private String cuentacontableiva2_descripcion;
	private String cuentacontablecredito_descripcion;
	
	
		
	public Servicio () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.servicioOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_tipo_servicio=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.iva=0.0;
 		this.ice=0.0;
 		this.es_bien=false;
 		this.id_estado_servicio=-1L;
 		this.descripcion="";
 		this.id_cuenta_contable_gasto=-1L;
 		this.id_cuenta_contable_fiscal=-1L;
 		this.id_cuenta_contable_fiscal2=null;
 		this.id_cuenta_contable_retencion=-1L;
 		this.id_cuenta_contable_retencion2=null;
 		this.id_cuenta_contable_iva=-1L;
 		this.id_cuenta_contable_iva2=null;
 		this.id_cuenta_contable_credito=null;
		
		
		this.empresa=null;
		this.tiposervicio=null;
		this.estadoservicio=null;
		this.cuentacontablegasto=null;
		this.cuentacontablefiscal=null;
		this.cuentacontablefiscal2=null;
		this.cuentacontableretencion=null;
		this.cuentacontableretencion2=null;
		this.cuentacontableiva=null;
		this.cuentacontableiva2=null;
		this.cuentacontablecredito=null;
		
		
		this.empresa_descripcion="";
		this.tiposervicio_descripcion="";
		this.estadoservicio_descripcion="";
		this.cuentacontablegasto_descripcion="";
		this.cuentacontablefiscal_descripcion="";
		this.cuentacontablefiscal2_descripcion="";
		this.cuentacontableretencion_descripcion="";
		this.cuentacontableretencion2_descripcion="";
		this.cuentacontableiva_descripcion="";
		this.cuentacontableiva2_descripcion="";
		this.cuentacontablecredito_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Servicio (Long id,Date versionRow,Long id_empresa,Long id_tipo_servicio,String codigo,String nombre,Double iva,Double ice,Boolean es_bien,Long id_estado_servicio,String descripcion,Long id_cuenta_contable_gasto,Long id_cuenta_contable_fiscal,Long id_cuenta_contable_fiscal2,Long id_cuenta_contable_retencion,Long id_cuenta_contable_retencion2,Long id_cuenta_contable_iva,Long id_cuenta_contable_iva2,Long id_cuenta_contable_credito) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.servicioOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_servicio=id_tipo_servicio;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.iva=iva;
 		this.ice=ice;
 		this.es_bien=es_bien;
 		this.id_estado_servicio=id_estado_servicio;
 		this.descripcion=descripcion;
 		this.id_cuenta_contable_gasto=id_cuenta_contable_gasto;
 		this.id_cuenta_contable_fiscal=id_cuenta_contable_fiscal;
 		this.id_cuenta_contable_fiscal2=id_cuenta_contable_fiscal2;
 		this.id_cuenta_contable_retencion=id_cuenta_contable_retencion;
 		this.id_cuenta_contable_retencion2=id_cuenta_contable_retencion2;
 		this.id_cuenta_contable_iva=id_cuenta_contable_iva;
 		this.id_cuenta_contable_iva2=id_cuenta_contable_iva2;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Servicio (Long id_empresa,Long id_tipo_servicio,String codigo,String nombre,Double iva,Double ice,Boolean es_bien,Long id_estado_servicio,String descripcion,Long id_cuenta_contable_gasto,Long id_cuenta_contable_fiscal,Long id_cuenta_contable_fiscal2,Long id_cuenta_contable_retencion,Long id_cuenta_contable_retencion2,Long id_cuenta_contable_iva,Long id_cuenta_contable_iva2,Long id_cuenta_contable_credito) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.servicioOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_servicio=id_tipo_servicio;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.iva=iva;
 		this.ice=ice;
 		this.es_bien=es_bien;
 		this.id_estado_servicio=id_estado_servicio;
 		this.descripcion=descripcion;
 		this.id_cuenta_contable_gasto=id_cuenta_contable_gasto;
 		this.id_cuenta_contable_fiscal=id_cuenta_contable_fiscal;
 		this.id_cuenta_contable_fiscal2=id_cuenta_contable_fiscal2;
 		this.id_cuenta_contable_retencion=id_cuenta_contable_retencion;
 		this.id_cuenta_contable_retencion2=id_cuenta_contable_retencion2;
 		this.id_cuenta_contable_iva=id_cuenta_contable_iva;
 		this.id_cuenta_contable_iva2=id_cuenta_contable_iva2;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Servicio servicioLocal=null;
		
		if(object!=null) {
			servicioLocal=(Servicio)object;
			
			if(servicioLocal!=null) {
				if(this.getId()!=null && servicioLocal.getId()!=null) {
					if(this.getId().equals(servicioLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ServicioConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ServicioConstantesFunciones.getServicioDescripcion(this);
		} else {
			sDetalle=ServicioConstantesFunciones.getServicioDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Servicio getServicioOriginal() {
		return this.servicioOriginal;
	}
	
	public void setServicioOriginal(Servicio servicio) {
		try {
			this.servicioOriginal=servicio;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ServicioAdditional servicioAdditional=null;
	
	public ServicioAdditional getServicioAdditional() {
		return this.servicioAdditional;
	}
	
	public void setServicioAdditional(ServicioAdditional servicioAdditional) {
		try {
			this.servicioAdditional=servicioAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_tipo_servicio() {
		return this.id_tipo_servicio;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public Boolean getes_bien() {
		return this.es_bien;
	}
    
	
	public Long getid_estado_servicio() {
		return this.id_estado_servicio;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Long getid_cuenta_contable_gasto() {
		return this.id_cuenta_contable_gasto;
	}
    
	
	public Long getid_cuenta_contable_fiscal() {
		return this.id_cuenta_contable_fiscal;
	}
    
	
	public Long getid_cuenta_contable_fiscal2() {
		return this.id_cuenta_contable_fiscal2;
	}
    
	
	public Long getid_cuenta_contable_retencion() {
		return this.id_cuenta_contable_retencion;
	}
    
	
	public Long getid_cuenta_contable_retencion2() {
		return this.id_cuenta_contable_retencion2;
	}
    
	
	public Long getid_cuenta_contable_iva() {
		return this.id_cuenta_contable_iva;
	}
    
	
	public Long getid_cuenta_contable_iva2() {
		return this.id_cuenta_contable_iva2;
	}
    
	
	public Long getid_cuenta_contable_credito() {
		return this.id_cuenta_contable_credito;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Servicio:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_servicio(Long newid_tipo_servicio)throws Exception
	{
		try {
			if(this.id_tipo_servicio!=newid_tipo_servicio) {
				if(newid_tipo_servicio==null) {
					//newid_tipo_servicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Servicio:Valor nulo no permitido en columna id_tipo_servicio");
					}
				}

				this.id_tipo_servicio=newid_tipo_servicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Servicio:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>100) {
					newcodigo=newcodigo.substring(0,98);
					System.out.println("Servicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna codigo");
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
						System.out.println("Servicio:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("Servicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiva(Double newiva)throws Exception
	{
		try {
			if(this.iva!=newiva) {
				if(newiva==null) {
					//newiva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Servicio:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setice(Double newice)throws Exception
	{
		try {
			if(this.ice!=newice) {
				if(newice==null) {
					//newice=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Servicio:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_bien(Boolean newes_bien)throws Exception
	{
		try {
			if(this.es_bien!=newes_bien) {
				if(newes_bien==null) {
					//newes_bien=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Servicio:Valor nulo no permitido en columna es_bien");
					}
				}

				this.es_bien=newes_bien;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_servicio(Long newid_estado_servicio)throws Exception
	{
		try {
			if(this.id_estado_servicio!=newid_estado_servicio) {
				if(newid_estado_servicio==null) {
					//newid_estado_servicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Servicio:Valor nulo no permitido en columna id_estado_servicio");
					}
				}

				this.id_estado_servicio=newid_estado_servicio;
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
						System.out.println("Servicio:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("Servicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_gasto(Long newid_cuenta_contable_gasto)throws Exception
	{
		try {
			if(this.id_cuenta_contable_gasto!=newid_cuenta_contable_gasto) {
				if(newid_cuenta_contable_gasto==null) {
					//newid_cuenta_contable_gasto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Servicio:Valor nulo no permitido en columna id_cuenta_contable_gasto");
					}
				}

				this.id_cuenta_contable_gasto=newid_cuenta_contable_gasto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_fiscal(Long newid_cuenta_contable_fiscal)throws Exception
	{
		try {
			if(this.id_cuenta_contable_fiscal!=newid_cuenta_contable_fiscal) {
				if(newid_cuenta_contable_fiscal==null) {
					//newid_cuenta_contable_fiscal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Servicio:Valor nulo no permitido en columna id_cuenta_contable_fiscal");
					}
				}

				this.id_cuenta_contable_fiscal=newid_cuenta_contable_fiscal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_fiscal2(Long newid_cuenta_contable_fiscal2) {
		if(this.id_cuenta_contable_fiscal2==null&&newid_cuenta_contable_fiscal2!=null) {
			this.id_cuenta_contable_fiscal2=newid_cuenta_contable_fiscal2;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_fiscal2!=null&&!this.id_cuenta_contable_fiscal2.equals(newid_cuenta_contable_fiscal2)) {

			this.id_cuenta_contable_fiscal2=newid_cuenta_contable_fiscal2;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_retencion(Long newid_cuenta_contable_retencion)throws Exception
	{
		try {
			if(this.id_cuenta_contable_retencion!=newid_cuenta_contable_retencion) {
				if(newid_cuenta_contable_retencion==null) {
					//newid_cuenta_contable_retencion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Servicio:Valor nulo no permitido en columna id_cuenta_contable_retencion");
					}
				}

				this.id_cuenta_contable_retencion=newid_cuenta_contable_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_retencion2(Long newid_cuenta_contable_retencion2) {
		if(this.id_cuenta_contable_retencion2==null&&newid_cuenta_contable_retencion2!=null) {
			this.id_cuenta_contable_retencion2=newid_cuenta_contable_retencion2;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_retencion2!=null&&!this.id_cuenta_contable_retencion2.equals(newid_cuenta_contable_retencion2)) {

			this.id_cuenta_contable_retencion2=newid_cuenta_contable_retencion2;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_iva(Long newid_cuenta_contable_iva)throws Exception
	{
		try {
			if(this.id_cuenta_contable_iva!=newid_cuenta_contable_iva) {
				if(newid_cuenta_contable_iva==null) {
					//newid_cuenta_contable_iva=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Servicio:Valor nulo no permitido en columna id_cuenta_contable_iva");
					}
				}

				this.id_cuenta_contable_iva=newid_cuenta_contable_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_iva2(Long newid_cuenta_contable_iva2) {
		if(this.id_cuenta_contable_iva2==null&&newid_cuenta_contable_iva2!=null) {
			this.id_cuenta_contable_iva2=newid_cuenta_contable_iva2;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_iva2!=null&&!this.id_cuenta_contable_iva2.equals(newid_cuenta_contable_iva2)) {

			this.id_cuenta_contable_iva2=newid_cuenta_contable_iva2;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_credito(Long newid_cuenta_contable_credito) {
		if(this.id_cuenta_contable_credito==null&&newid_cuenta_contable_credito!=null) {
			this.id_cuenta_contable_credito=newid_cuenta_contable_credito;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_credito!=null&&!this.id_cuenta_contable_credito.equals(newid_cuenta_contable_credito)) {

			this.id_cuenta_contable_credito=newid_cuenta_contable_credito;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoServicio getTipoServicio() {
		return this.tiposervicio;
	}

	public EstadoServicio getEstadoServicio() {
		return this.estadoservicio;
	}

	public CuentaContable getCuentaContableGasto() {
		return this.cuentacontablegasto;
	}

	public CuentaContable getCuentaContableFiscal() {
		return this.cuentacontablefiscal;
	}

	public CuentaContable getCuentaContableFiscal2() {
		return this.cuentacontablefiscal2;
	}

	public CuentaContable getCuentaContableRetencion() {
		return this.cuentacontableretencion;
	}

	public CuentaContable getCuentaContableRetencion2() {
		return this.cuentacontableretencion2;
	}

	public CuentaContable getCuentaContableIva() {
		return this.cuentacontableiva;
	}

	public CuentaContable getCuentaContableIva2() {
		return this.cuentacontableiva2;
	}

	public CuentaContable getCuentaContableCredito() {
		return this.cuentacontablecredito;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettiposervicio_descripcion() {
		return this.tiposervicio_descripcion;
	}

	public String getestadoservicio_descripcion() {
		return this.estadoservicio_descripcion;
	}

	public String getcuentacontablegasto_descripcion() {
		return this.cuentacontablegasto_descripcion;
	}

	public String getcuentacontablefiscal_descripcion() {
		return this.cuentacontablefiscal_descripcion;
	}

	public String getcuentacontablefiscal2_descripcion() {
		return this.cuentacontablefiscal2_descripcion;
	}

	public String getcuentacontableretencion_descripcion() {
		return this.cuentacontableretencion_descripcion;
	}

	public String getcuentacontableretencion2_descripcion() {
		return this.cuentacontableretencion2_descripcion;
	}

	public String getcuentacontableiva_descripcion() {
		return this.cuentacontableiva_descripcion;
	}

	public String getcuentacontableiva2_descripcion() {
		return this.cuentacontableiva2_descripcion;
	}

	public String getcuentacontablecredito_descripcion() {
		return this.cuentacontablecredito_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoServicio(TipoServicio tiposervicio) {
		try {
			this.tiposervicio=tiposervicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoServicio(EstadoServicio estadoservicio) {
		try {
			this.estadoservicio=estadoservicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableGasto(CuentaContable cuentacontablegasto) {
		try {
			this.cuentacontablegasto=cuentacontablegasto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableFiscal(CuentaContable cuentacontablefiscal) {
		try {
			this.cuentacontablefiscal=cuentacontablefiscal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableFiscal2(CuentaContable cuentacontablefiscal2) {
		try {
			this.cuentacontablefiscal2=cuentacontablefiscal2;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableRetencion(CuentaContable cuentacontableretencion) {
		try {
			this.cuentacontableretencion=cuentacontableretencion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableRetencion2(CuentaContable cuentacontableretencion2) {
		try {
			this.cuentacontableretencion2=cuentacontableretencion2;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableIva(CuentaContable cuentacontableiva) {
		try {
			this.cuentacontableiva=cuentacontableiva;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableIva2(CuentaContable cuentacontableiva2) {
		try {
			this.cuentacontableiva2=cuentacontableiva2;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCredito(CuentaContable cuentacontablecredito) {
		try {
			this.cuentacontablecredito=cuentacontablecredito;
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


	public  void  settiposervicio_descripcion(String tiposervicio_descripcion) {
		try {
			this.tiposervicio_descripcion=tiposervicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadoservicio_descripcion(String estadoservicio_descripcion) {
		try {
			this.estadoservicio_descripcion=estadoservicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablegasto_descripcion(String cuentacontablegasto_descripcion) {
		try {
			this.cuentacontablegasto_descripcion=cuentacontablegasto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablefiscal_descripcion(String cuentacontablefiscal_descripcion) {
		try {
			this.cuentacontablefiscal_descripcion=cuentacontablefiscal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablefiscal2_descripcion(String cuentacontablefiscal2_descripcion) {
		try {
			this.cuentacontablefiscal2_descripcion=cuentacontablefiscal2_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableretencion_descripcion(String cuentacontableretencion_descripcion) {
		try {
			this.cuentacontableretencion_descripcion=cuentacontableretencion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableretencion2_descripcion(String cuentacontableretencion2_descripcion) {
		try {
			this.cuentacontableretencion2_descripcion=cuentacontableretencion2_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableiva_descripcion(String cuentacontableiva_descripcion) {
		try {
			this.cuentacontableiva_descripcion=cuentacontableiva_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableiva2_descripcion(String cuentacontableiva2_descripcion) {
		try {
			this.cuentacontableiva2_descripcion=cuentacontableiva2_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecredito_descripcion(String cuentacontablecredito_descripcion) {
		try {
			this.cuentacontablecredito_descripcion=cuentacontablecredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_servicio_descripcion="";String es_bien_descripcion="";String id_estado_servicio_descripcion="";String id_cuenta_contable_gasto_descripcion="";String id_cuenta_contable_fiscal_descripcion="";String id_cuenta_contable_fiscal2_descripcion="";String id_cuenta_contable_retencion_descripcion="";String id_cuenta_contable_retencion2_descripcion="";String id_cuenta_contable_iva_descripcion="";String id_cuenta_contable_iva2_descripcion="";String id_cuenta_contable_credito_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_servicio_descripcion() {
		return id_tipo_servicio_descripcion;
	}
	public String getes_bien_descripcion() {
		return es_bien_descripcion;
	}
	public String getid_estado_servicio_descripcion() {
		return id_estado_servicio_descripcion;
	}
	public String getid_cuenta_contable_gasto_descripcion() {
		return id_cuenta_contable_gasto_descripcion;
	}
	public String getid_cuenta_contable_fiscal_descripcion() {
		return id_cuenta_contable_fiscal_descripcion;
	}
	public String getid_cuenta_contable_fiscal2_descripcion() {
		return id_cuenta_contable_fiscal2_descripcion;
	}
	public String getid_cuenta_contable_retencion_descripcion() {
		return id_cuenta_contable_retencion_descripcion;
	}
	public String getid_cuenta_contable_retencion2_descripcion() {
		return id_cuenta_contable_retencion2_descripcion;
	}
	public String getid_cuenta_contable_iva_descripcion() {
		return id_cuenta_contable_iva_descripcion;
	}
	public String getid_cuenta_contable_iva2_descripcion() {
		return id_cuenta_contable_iva2_descripcion;
	}
	public String getid_cuenta_contable_credito_descripcion() {
		return id_cuenta_contable_credito_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_servicio_descripcion(String newid_tipo_servicio_descripcion)throws Exception {
		try {
			this.id_tipo_servicio_descripcion=newid_tipo_servicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_bien_descripcion(String newes_bien_descripcion)throws Exception {
		try {
			this.es_bien_descripcion=newes_bien_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_servicio_descripcion(String newid_estado_servicio_descripcion)throws Exception {
		try {
			this.id_estado_servicio_descripcion=newid_estado_servicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_gasto_descripcion(String newid_cuenta_contable_gasto_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_gasto_descripcion=newid_cuenta_contable_gasto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_fiscal_descripcion(String newid_cuenta_contable_fiscal_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_fiscal_descripcion=newid_cuenta_contable_fiscal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_fiscal2_descripcion(String newid_cuenta_contable_fiscal2_descripcion) {
		this.id_cuenta_contable_fiscal2_descripcion=newid_cuenta_contable_fiscal2_descripcion;
	}
	public void setid_cuenta_contable_retencion_descripcion(String newid_cuenta_contable_retencion_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_retencion_descripcion=newid_cuenta_contable_retencion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_retencion2_descripcion(String newid_cuenta_contable_retencion2_descripcion) {
		this.id_cuenta_contable_retencion2_descripcion=newid_cuenta_contable_retencion2_descripcion;
	}
	public void setid_cuenta_contable_iva_descripcion(String newid_cuenta_contable_iva_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_iva_descripcion=newid_cuenta_contable_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_iva2_descripcion(String newid_cuenta_contable_iva2_descripcion) {
		this.id_cuenta_contable_iva2_descripcion=newid_cuenta_contable_iva2_descripcion;
	}
	public void setid_cuenta_contable_credito_descripcion(String newid_cuenta_contable_credito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_credito_descripcion=newid_cuenta_contable_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_servicio_descripcion="";this.es_bien_descripcion="";this.id_estado_servicio_descripcion="";this.id_cuenta_contable_gasto_descripcion="";this.id_cuenta_contable_fiscal_descripcion="";this.id_cuenta_contable_fiscal2_descripcion="";this.id_cuenta_contable_retencion_descripcion="";this.id_cuenta_contable_retencion2_descripcion="";this.id_cuenta_contable_iva_descripcion="";this.id_cuenta_contable_iva2_descripcion="";this.id_cuenta_contable_credito_descripcion="";
	}
	
	
	Object parametrogenericosDescripcionReporte;
	
	
	public Object getparametrogenericosDescripcionReporte() {
		return parametrogenericosDescripcionReporte;
	}

	
	
	public  void  setparametrogenericosDescripcionReporte(Object parametrogenericos) {
		try {
			this.parametrogenericosDescripcionReporte=parametrogenericos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

