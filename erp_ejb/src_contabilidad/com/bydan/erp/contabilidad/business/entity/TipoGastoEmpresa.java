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
//import com.bydan.erp.contabilidad.util.TipoGastoEmpresaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class TipoGastoEmpresa extends TipoGastoEmpresaAdditional implements Serializable ,Cloneable {//TipoGastoEmpresaAdditional,GeneralEntity
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
	
	private TipoGastoEmpresa tipogastoempresaOriginal;
	
	private Map<String, Object> mapTipoGastoEmpresa;
			
	public Map<String, Object> getMapTipoGastoEmpresa() {
		return mapTipoGastoEmpresa;
	}

	public void setMapTipoGastoEmpresa(Map<String, Object> mapTipoGastoEmpresa) {
		this.mapTipoGastoEmpresa = mapTipoGastoEmpresa;
	}
	
	public void inicializarMapTipoGastoEmpresa() {
		this.mapTipoGastoEmpresa = new HashMap<String,Object>();
	}
	
	public void setMapTipoGastoEmpresaValue(String sKey,Object oValue) {
		this.mapTipoGastoEmpresa.put(sKey, oValue);
	}
	
	public Object getMapTipoGastoEmpresaValue(String sKey) {
		return this.mapTipoGastoEmpresa.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoGastoEmpresaConstantesFunciones.SREGEXNOMBRE,message=TipoGastoEmpresaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=TipoGastoEmpresaConstantesFunciones.SREGEXDESCRIPCION,message=TipoGastoEmpresaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_gasto;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_fiscal_bien;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_fiscal_servicio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_retencion_bien;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_retencion_servicio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_iva_bien;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_iva_servicio;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Formato formato;
	public CuentaContable cuentacontablegasto;
	public CuentaContable cuentacontablefiscalbien;
	public CuentaContable cuentacontablefiscalservicio;
	public CuentaContable cuentacontableretencionbien;
	public CuentaContable cuentacontableretencionservicio;
	public CuentaContable cuentacontableivabien;
	public CuentaContable cuentacontableivaservicio;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String formato_descripcion;
	private String cuentacontablegasto_descripcion;
	private String cuentacontablefiscalbien_descripcion;
	private String cuentacontablefiscalservicio_descripcion;
	private String cuentacontableretencionbien_descripcion;
	private String cuentacontableretencionservicio_descripcion;
	private String cuentacontableivabien_descripcion;
	private String cuentacontableivaservicio_descripcion;
	
	
		
	public TipoGastoEmpresa () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipogastoempresaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.nombre="";
 		this.id_formato=-1L;
 		this.descripcion="";
 		this.id_cuenta_contable_gasto=null;
 		this.id_cuenta_contable_fiscal_bien=null;
 		this.id_cuenta_contable_fiscal_servicio=null;
 		this.id_cuenta_contable_retencion_bien=null;
 		this.id_cuenta_contable_retencion_servicio=null;
 		this.id_cuenta_contable_iva_bien=null;
 		this.id_cuenta_contable_iva_servicio=null;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.formato=null;
		this.cuentacontablegasto=null;
		this.cuentacontablefiscalbien=null;
		this.cuentacontablefiscalservicio=null;
		this.cuentacontableretencionbien=null;
		this.cuentacontableretencionservicio=null;
		this.cuentacontableivabien=null;
		this.cuentacontableivaservicio=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.formato_descripcion="";
		this.cuentacontablegasto_descripcion="";
		this.cuentacontablefiscalbien_descripcion="";
		this.cuentacontablefiscalservicio_descripcion="";
		this.cuentacontableretencionbien_descripcion="";
		this.cuentacontableretencionservicio_descripcion="";
		this.cuentacontableivabien_descripcion="";
		this.cuentacontableivaservicio_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoGastoEmpresa (Long id,Date versionRow,Long id_empresa,Long id_sucursal,String nombre,Long id_formato,String descripcion,Long id_cuenta_contable_gasto,Long id_cuenta_contable_fiscal_bien,Long id_cuenta_contable_fiscal_servicio,Long id_cuenta_contable_retencion_bien,Long id_cuenta_contable_retencion_servicio,Long id_cuenta_contable_iva_bien,Long id_cuenta_contable_iva_servicio) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipogastoempresaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.nombre=nombre;
 		this.id_formato=id_formato;
 		this.descripcion=descripcion;
 		this.id_cuenta_contable_gasto=id_cuenta_contable_gasto;
 		this.id_cuenta_contable_fiscal_bien=id_cuenta_contable_fiscal_bien;
 		this.id_cuenta_contable_fiscal_servicio=id_cuenta_contable_fiscal_servicio;
 		this.id_cuenta_contable_retencion_bien=id_cuenta_contable_retencion_bien;
 		this.id_cuenta_contable_retencion_servicio=id_cuenta_contable_retencion_servicio;
 		this.id_cuenta_contable_iva_bien=id_cuenta_contable_iva_bien;
 		this.id_cuenta_contable_iva_servicio=id_cuenta_contable_iva_servicio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoGastoEmpresa (Long id_empresa,Long id_sucursal,String nombre,Long id_formato,String descripcion,Long id_cuenta_contable_gasto,Long id_cuenta_contable_fiscal_bien,Long id_cuenta_contable_fiscal_servicio,Long id_cuenta_contable_retencion_bien,Long id_cuenta_contable_retencion_servicio,Long id_cuenta_contable_iva_bien,Long id_cuenta_contable_iva_servicio) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipogastoempresaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.nombre=nombre;
 		this.id_formato=id_formato;
 		this.descripcion=descripcion;
 		this.id_cuenta_contable_gasto=id_cuenta_contable_gasto;
 		this.id_cuenta_contable_fiscal_bien=id_cuenta_contable_fiscal_bien;
 		this.id_cuenta_contable_fiscal_servicio=id_cuenta_contable_fiscal_servicio;
 		this.id_cuenta_contable_retencion_bien=id_cuenta_contable_retencion_bien;
 		this.id_cuenta_contable_retencion_servicio=id_cuenta_contable_retencion_servicio;
 		this.id_cuenta_contable_iva_bien=id_cuenta_contable_iva_bien;
 		this.id_cuenta_contable_iva_servicio=id_cuenta_contable_iva_servicio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoGastoEmpresa tipogastoempresaLocal=null;
		
		if(object!=null) {
			tipogastoempresaLocal=(TipoGastoEmpresa)object;
			
			if(tipogastoempresaLocal!=null) {
				if(this.getId()!=null && tipogastoempresaLocal.getId()!=null) {
					if(this.getId().equals(tipogastoempresaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoGastoEmpresaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoGastoEmpresaConstantesFunciones.getTipoGastoEmpresaDescripcion(this);
		} else {
			sDetalle=TipoGastoEmpresaConstantesFunciones.getTipoGastoEmpresaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoGastoEmpresa getTipoGastoEmpresaOriginal() {
		return this.tipogastoempresaOriginal;
	}
	
	public void setTipoGastoEmpresaOriginal(TipoGastoEmpresa tipogastoempresa) {
		try {
			this.tipogastoempresaOriginal=tipogastoempresa;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoGastoEmpresaAdditional tipogastoempresaAdditional=null;
	
	public TipoGastoEmpresaAdditional getTipoGastoEmpresaAdditional() {
		return this.tipogastoempresaAdditional;
	}
	
	public void setTipoGastoEmpresaAdditional(TipoGastoEmpresaAdditional tipogastoempresaAdditional) {
		try {
			this.tipogastoempresaAdditional=tipogastoempresaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Long getid_cuenta_contable_gasto() {
		return this.id_cuenta_contable_gasto;
	}
    
	
	public Long getid_cuenta_contable_fiscal_bien() {
		return this.id_cuenta_contable_fiscal_bien;
	}
    
	
	public Long getid_cuenta_contable_fiscal_servicio() {
		return this.id_cuenta_contable_fiscal_servicio;
	}
    
	
	public Long getid_cuenta_contable_retencion_bien() {
		return this.id_cuenta_contable_retencion_bien;
	}
    
	
	public Long getid_cuenta_contable_retencion_servicio() {
		return this.id_cuenta_contable_retencion_servicio;
	}
    
	
	public Long getid_cuenta_contable_iva_bien() {
		return this.id_cuenta_contable_iva_bien;
	}
    
	
	public Long getid_cuenta_contable_iva_servicio() {
		return this.id_cuenta_contable_iva_servicio;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoGastoEmpresa:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoGastoEmpresa:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("TipoGastoEmpresa:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("TipoGastoEmpresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato(Long newid_formato)throws Exception
	{
		try {
			if(this.id_formato!=newid_formato) {
				if(newid_formato==null) {
					//newid_formato=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoGastoEmpresa:Valor nulo no permitido en columna id_formato");
					}
				}

				this.id_formato=newid_formato;
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
						System.out.println("TipoGastoEmpresa:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("TipoGastoEmpresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_gasto(Long newid_cuenta_contable_gasto) {
		if(this.id_cuenta_contable_gasto==null&&newid_cuenta_contable_gasto!=null) {
			this.id_cuenta_contable_gasto=newid_cuenta_contable_gasto;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_gasto!=null&&!this.id_cuenta_contable_gasto.equals(newid_cuenta_contable_gasto)) {

			this.id_cuenta_contable_gasto=newid_cuenta_contable_gasto;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_fiscal_bien(Long newid_cuenta_contable_fiscal_bien) {
		if(this.id_cuenta_contable_fiscal_bien==null&&newid_cuenta_contable_fiscal_bien!=null) {
			this.id_cuenta_contable_fiscal_bien=newid_cuenta_contable_fiscal_bien;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_fiscal_bien!=null&&!this.id_cuenta_contable_fiscal_bien.equals(newid_cuenta_contable_fiscal_bien)) {

			this.id_cuenta_contable_fiscal_bien=newid_cuenta_contable_fiscal_bien;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_fiscal_servicio(Long newid_cuenta_contable_fiscal_servicio) {
		if(this.id_cuenta_contable_fiscal_servicio==null&&newid_cuenta_contable_fiscal_servicio!=null) {
			this.id_cuenta_contable_fiscal_servicio=newid_cuenta_contable_fiscal_servicio;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_fiscal_servicio!=null&&!this.id_cuenta_contable_fiscal_servicio.equals(newid_cuenta_contable_fiscal_servicio)) {

			this.id_cuenta_contable_fiscal_servicio=newid_cuenta_contable_fiscal_servicio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_retencion_bien(Long newid_cuenta_contable_retencion_bien) {
		if(this.id_cuenta_contable_retencion_bien==null&&newid_cuenta_contable_retencion_bien!=null) {
			this.id_cuenta_contable_retencion_bien=newid_cuenta_contable_retencion_bien;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_retencion_bien!=null&&!this.id_cuenta_contable_retencion_bien.equals(newid_cuenta_contable_retencion_bien)) {

			this.id_cuenta_contable_retencion_bien=newid_cuenta_contable_retencion_bien;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_retencion_servicio(Long newid_cuenta_contable_retencion_servicio) {
		if(this.id_cuenta_contable_retencion_servicio==null&&newid_cuenta_contable_retencion_servicio!=null) {
			this.id_cuenta_contable_retencion_servicio=newid_cuenta_contable_retencion_servicio;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_retencion_servicio!=null&&!this.id_cuenta_contable_retencion_servicio.equals(newid_cuenta_contable_retencion_servicio)) {

			this.id_cuenta_contable_retencion_servicio=newid_cuenta_contable_retencion_servicio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_iva_bien(Long newid_cuenta_contable_iva_bien) {
		if(this.id_cuenta_contable_iva_bien==null&&newid_cuenta_contable_iva_bien!=null) {
			this.id_cuenta_contable_iva_bien=newid_cuenta_contable_iva_bien;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_iva_bien!=null&&!this.id_cuenta_contable_iva_bien.equals(newid_cuenta_contable_iva_bien)) {

			this.id_cuenta_contable_iva_bien=newid_cuenta_contable_iva_bien;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_iva_servicio(Long newid_cuenta_contable_iva_servicio) {
		if(this.id_cuenta_contable_iva_servicio==null&&newid_cuenta_contable_iva_servicio!=null) {
			this.id_cuenta_contable_iva_servicio=newid_cuenta_contable_iva_servicio;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_iva_servicio!=null&&!this.id_cuenta_contable_iva_servicio.equals(newid_cuenta_contable_iva_servicio)) {

			this.id_cuenta_contable_iva_servicio=newid_cuenta_contable_iva_servicio;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public CuentaContable getCuentaContableGasto() {
		return this.cuentacontablegasto;
	}

	public CuentaContable getCuentaContableFiscalBien() {
		return this.cuentacontablefiscalbien;
	}

	public CuentaContable getCuentaContableFiscalServicio() {
		return this.cuentacontablefiscalservicio;
	}

	public CuentaContable getCuentaContableRetencionBien() {
		return this.cuentacontableretencionbien;
	}

	public CuentaContable getCuentaContableRetencionServicio() {
		return this.cuentacontableretencionservicio;
	}

	public CuentaContable getCuentaContableIvaBien() {
		return this.cuentacontableivabien;
	}

	public CuentaContable getCuentaContableIvaServicio() {
		return this.cuentacontableivaservicio;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String getcuentacontablegasto_descripcion() {
		return this.cuentacontablegasto_descripcion;
	}

	public String getcuentacontablefiscalbien_descripcion() {
		return this.cuentacontablefiscalbien_descripcion;
	}

	public String getcuentacontablefiscalservicio_descripcion() {
		return this.cuentacontablefiscalservicio_descripcion;
	}

	public String getcuentacontableretencionbien_descripcion() {
		return this.cuentacontableretencionbien_descripcion;
	}

	public String getcuentacontableretencionservicio_descripcion() {
		return this.cuentacontableretencionservicio_descripcion;
	}

	public String getcuentacontableivabien_descripcion() {
		return this.cuentacontableivabien_descripcion;
	}

	public String getcuentacontableivaservicio_descripcion() {
		return this.cuentacontableivaservicio_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormato(Formato formato) {
		try {
			this.formato=formato;
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


	public  void  setCuentaContableFiscalBien(CuentaContable cuentacontablefiscalbien) {
		try {
			this.cuentacontablefiscalbien=cuentacontablefiscalbien;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableFiscalServicio(CuentaContable cuentacontablefiscalservicio) {
		try {
			this.cuentacontablefiscalservicio=cuentacontablefiscalservicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableRetencionBien(CuentaContable cuentacontableretencionbien) {
		try {
			this.cuentacontableretencionbien=cuentacontableretencionbien;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableRetencionServicio(CuentaContable cuentacontableretencionservicio) {
		try {
			this.cuentacontableretencionservicio=cuentacontableretencionservicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableIvaBien(CuentaContable cuentacontableivabien) {
		try {
			this.cuentacontableivabien=cuentacontableivabien;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableIvaServicio(CuentaContable cuentacontableivaservicio) {
		try {
			this.cuentacontableivaservicio=cuentacontableivaservicio;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformato_descripcion(String formato_descripcion) {
		try {
			this.formato_descripcion=formato_descripcion;
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


	public  void  setcuentacontablefiscalbien_descripcion(String cuentacontablefiscalbien_descripcion) {
		try {
			this.cuentacontablefiscalbien_descripcion=cuentacontablefiscalbien_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablefiscalservicio_descripcion(String cuentacontablefiscalservicio_descripcion) {
		try {
			this.cuentacontablefiscalservicio_descripcion=cuentacontablefiscalservicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableretencionbien_descripcion(String cuentacontableretencionbien_descripcion) {
		try {
			this.cuentacontableretencionbien_descripcion=cuentacontableretencionbien_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableretencionservicio_descripcion(String cuentacontableretencionservicio_descripcion) {
		try {
			this.cuentacontableretencionservicio_descripcion=cuentacontableretencionservicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableivabien_descripcion(String cuentacontableivabien_descripcion) {
		try {
			this.cuentacontableivabien_descripcion=cuentacontableivabien_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableivaservicio_descripcion(String cuentacontableivaservicio_descripcion) {
		try {
			this.cuentacontableivaservicio_descripcion=cuentacontableivaservicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_formato_descripcion="";String id_cuenta_contable_gasto_descripcion="";String id_cuenta_contable_fiscal_bien_descripcion="";String id_cuenta_contable_fiscal_servicio_descripcion="";String id_cuenta_contable_retencion_bien_descripcion="";String id_cuenta_contable_retencion_servicio_descripcion="";String id_cuenta_contable_iva_bien_descripcion="";String id_cuenta_contable_iva_servicio_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getid_cuenta_contable_gasto_descripcion() {
		return id_cuenta_contable_gasto_descripcion;
	}
	public String getid_cuenta_contable_fiscal_bien_descripcion() {
		return id_cuenta_contable_fiscal_bien_descripcion;
	}
	public String getid_cuenta_contable_fiscal_servicio_descripcion() {
		return id_cuenta_contable_fiscal_servicio_descripcion;
	}
	public String getid_cuenta_contable_retencion_bien_descripcion() {
		return id_cuenta_contable_retencion_bien_descripcion;
	}
	public String getid_cuenta_contable_retencion_servicio_descripcion() {
		return id_cuenta_contable_retencion_servicio_descripcion;
	}
	public String getid_cuenta_contable_iva_bien_descripcion() {
		return id_cuenta_contable_iva_bien_descripcion;
	}
	public String getid_cuenta_contable_iva_servicio_descripcion() {
		return id_cuenta_contable_iva_servicio_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_descripcion(String newid_formato_descripcion)throws Exception {
		try {
			this.id_formato_descripcion=newid_formato_descripcion;
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
	public void setid_cuenta_contable_fiscal_bien_descripcion(String newid_cuenta_contable_fiscal_bien_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_fiscal_bien_descripcion=newid_cuenta_contable_fiscal_bien_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_fiscal_servicio_descripcion(String newid_cuenta_contable_fiscal_servicio_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_fiscal_servicio_descripcion=newid_cuenta_contable_fiscal_servicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_retencion_bien_descripcion(String newid_cuenta_contable_retencion_bien_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_retencion_bien_descripcion=newid_cuenta_contable_retencion_bien_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_retencion_servicio_descripcion(String newid_cuenta_contable_retencion_servicio_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_retencion_servicio_descripcion=newid_cuenta_contable_retencion_servicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_iva_bien_descripcion(String newid_cuenta_contable_iva_bien_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_iva_bien_descripcion=newid_cuenta_contable_iva_bien_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_iva_servicio_descripcion(String newid_cuenta_contable_iva_servicio_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_iva_servicio_descripcion=newid_cuenta_contable_iva_servicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_formato_descripcion="";this.id_cuenta_contable_gasto_descripcion="";this.id_cuenta_contable_fiscal_bien_descripcion="";this.id_cuenta_contable_fiscal_servicio_descripcion="";this.id_cuenta_contable_retencion_bien_descripcion="";this.id_cuenta_contable_retencion_servicio_descripcion="";this.id_cuenta_contable_iva_bien_descripcion="";this.id_cuenta_contable_iva_servicio_descripcion="";
	}
	
	
	Object detalleasientocontablecajachicasDescripcionReporte;
	
	
	public Object getdetalleasientocontablecajachicasDescripcionReporte() {
		return detalleasientocontablecajachicasDescripcionReporte;
	}

	
	
	public  void  setdetalleasientocontablecajachicasDescripcionReporte(Object detalleasientocontablecajachicas) {
		try {
			this.detalleasientocontablecajachicasDescripcionReporte=detalleasientocontablecajachicas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

