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
//import com.bydan.erp.contabilidad.util.PlantillaFacturaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class PlantillaFactura extends PlantillaFacturaAdditional implements Serializable ,Cloneable {//PlantillaFacturaAdditional,GeneralEntity
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
	
	private PlantillaFactura plantillafacturaOriginal;
	
	private Map<String, Object> mapPlantillaFactura;
			
	public Map<String, Object> getMapPlantillaFactura() {
		return mapPlantillaFactura;
	}

	public void setMapPlantillaFactura(Map<String, Object> mapPlantillaFactura) {
		this.mapPlantillaFactura = mapPlantillaFactura;
	}
	
	public void inicializarMapPlantillaFactura() {
		this.mapPlantillaFactura = new HashMap<String,Object>();
	}
	
	public void setMapPlantillaFacturaValue(String sKey,Object oValue) {
		this.mapPlantillaFactura.put(sKey, oValue);
	}
	
	public Object getMapPlantillaFacturaValue(String sKey) {
		return this.mapPlantillaFactura.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PlantillaFacturaConstantesFunciones.SREGEXCODIGO,message=PlantillaFacturaConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PlantillaFacturaConstantesFunciones.SREGEXNOMBRE,message=PlantillaFacturaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=PlantillaFacturaConstantesFunciones.SREGEXDESCRIPCION,message=PlantillaFacturaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_proveedor;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_aplicada;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_credito_bien;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_credito_servicio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_tipo_retencion_fuente_bien;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_tipo_retencion_fuente_servicio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_tipo_retencion_iva_bien;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_tipo_retencion_iva_servicio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_gasto;
			
	
	public Empresa empresa;
	public CuentaContable cuentacontableaplicada;
	public CuentaContable cuentacontablecreditobien;
	public CuentaContable cuentacontablecreditoservicio;
	public TipoRetencion tiporetencionfuentebien;
	public TipoRetencion tiporetencionfuenteservicio;
	public TipoRetencion tiporetencionivabien;
	public TipoRetencion tiporetencionivaservicio;
	public CuentaContable cuentacontablegasto;
	
	
	private String empresa_descripcion;
	private String cuentacontableaplicada_descripcion;
	private String cuentacontablecreditobien_descripcion;
	private String cuentacontablecreditoservicio_descripcion;
	private String tiporetencionfuentebien_descripcion;
	private String tiporetencionfuenteservicio_descripcion;
	private String tiporetencionivabien_descripcion;
	private String tiporetencionivaservicio_descripcion;
	private String cuentacontablegasto_descripcion;
	
	
		
	public PlantillaFactura () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.plantillafacturaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.descripcion="";
 		this.es_proveedor=false;
 		this.id_cuenta_contable_aplicada=null;
 		this.id_cuenta_contable_credito_bien=null;
 		this.id_cuenta_contable_credito_servicio=null;
 		this.id_tipo_retencion_fuente_bien=null;
 		this.id_tipo_retencion_fuente_servicio=null;
 		this.id_tipo_retencion_iva_bien=null;
 		this.id_tipo_retencion_iva_servicio=null;
 		this.id_cuenta_contable_gasto=null;
		
		
		this.empresa=null;
		this.cuentacontableaplicada=null;
		this.cuentacontablecreditobien=null;
		this.cuentacontablecreditoservicio=null;
		this.tiporetencionfuentebien=null;
		this.tiporetencionfuenteservicio=null;
		this.tiporetencionivabien=null;
		this.tiporetencionivaservicio=null;
		this.cuentacontablegasto=null;
		
		
		this.empresa_descripcion="";
		this.cuentacontableaplicada_descripcion="";
		this.cuentacontablecreditobien_descripcion="";
		this.cuentacontablecreditoservicio_descripcion="";
		this.tiporetencionfuentebien_descripcion="";
		this.tiporetencionfuenteservicio_descripcion="";
		this.tiporetencionivabien_descripcion="";
		this.tiporetencionivaservicio_descripcion="";
		this.cuentacontablegasto_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PlantillaFactura (Long id,Date versionRow,Long id_empresa,String codigo,String nombre,String descripcion,Boolean es_proveedor,Long id_cuenta_contable_aplicada,Long id_cuenta_contable_credito_bien,Long id_cuenta_contable_credito_servicio,Long id_tipo_retencion_fuente_bien,Long id_tipo_retencion_fuente_servicio,Long id_tipo_retencion_iva_bien,Long id_tipo_retencion_iva_servicio,Long id_cuenta_contable_gasto) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.plantillafacturaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
 		this.es_proveedor=es_proveedor;
 		this.id_cuenta_contable_aplicada=id_cuenta_contable_aplicada;
 		this.id_cuenta_contable_credito_bien=id_cuenta_contable_credito_bien;
 		this.id_cuenta_contable_credito_servicio=id_cuenta_contable_credito_servicio;
 		this.id_tipo_retencion_fuente_bien=id_tipo_retencion_fuente_bien;
 		this.id_tipo_retencion_fuente_servicio=id_tipo_retencion_fuente_servicio;
 		this.id_tipo_retencion_iva_bien=id_tipo_retencion_iva_bien;
 		this.id_tipo_retencion_iva_servicio=id_tipo_retencion_iva_servicio;
 		this.id_cuenta_contable_gasto=id_cuenta_contable_gasto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PlantillaFactura (Long id_empresa,String codigo,String nombre,String descripcion,Boolean es_proveedor,Long id_cuenta_contable_aplicada,Long id_cuenta_contable_credito_bien,Long id_cuenta_contable_credito_servicio,Long id_tipo_retencion_fuente_bien,Long id_tipo_retencion_fuente_servicio,Long id_tipo_retencion_iva_bien,Long id_tipo_retencion_iva_servicio,Long id_cuenta_contable_gasto) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.plantillafacturaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
 		this.es_proveedor=es_proveedor;
 		this.id_cuenta_contable_aplicada=id_cuenta_contable_aplicada;
 		this.id_cuenta_contable_credito_bien=id_cuenta_contable_credito_bien;
 		this.id_cuenta_contable_credito_servicio=id_cuenta_contable_credito_servicio;
 		this.id_tipo_retencion_fuente_bien=id_tipo_retencion_fuente_bien;
 		this.id_tipo_retencion_fuente_servicio=id_tipo_retencion_fuente_servicio;
 		this.id_tipo_retencion_iva_bien=id_tipo_retencion_iva_bien;
 		this.id_tipo_retencion_iva_servicio=id_tipo_retencion_iva_servicio;
 		this.id_cuenta_contable_gasto=id_cuenta_contable_gasto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PlantillaFactura plantillafacturaLocal=null;
		
		if(object!=null) {
			plantillafacturaLocal=(PlantillaFactura)object;
			
			if(plantillafacturaLocal!=null) {
				if(this.getId()!=null && plantillafacturaLocal.getId()!=null) {
					if(this.getId().equals(plantillafacturaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PlantillaFacturaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PlantillaFacturaConstantesFunciones.getPlantillaFacturaDescripcion(this);
		} else {
			sDetalle=PlantillaFacturaConstantesFunciones.getPlantillaFacturaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PlantillaFactura getPlantillaFacturaOriginal() {
		return this.plantillafacturaOriginal;
	}
	
	public void setPlantillaFacturaOriginal(PlantillaFactura plantillafactura) {
		try {
			this.plantillafacturaOriginal=plantillafactura;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PlantillaFacturaAdditional plantillafacturaAdditional=null;
	
	public PlantillaFacturaAdditional getPlantillaFacturaAdditional() {
		return this.plantillafacturaAdditional;
	}
	
	public void setPlantillaFacturaAdditional(PlantillaFacturaAdditional plantillafacturaAdditional) {
		try {
			this.plantillafacturaAdditional=plantillafacturaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Boolean getes_proveedor() {
		return this.es_proveedor;
	}
    
	
	public Long getid_cuenta_contable_aplicada() {
		return this.id_cuenta_contable_aplicada;
	}
    
	
	public Long getid_cuenta_contable_credito_bien() {
		return this.id_cuenta_contable_credito_bien;
	}
    
	
	public Long getid_cuenta_contable_credito_servicio() {
		return this.id_cuenta_contable_credito_servicio;
	}
    
	
	public Long getid_tipo_retencion_fuente_bien() {
		return this.id_tipo_retencion_fuente_bien;
	}
    
	
	public Long getid_tipo_retencion_fuente_servicio() {
		return this.id_tipo_retencion_fuente_servicio;
	}
    
	
	public Long getid_tipo_retencion_iva_bien() {
		return this.id_tipo_retencion_iva_bien;
	}
    
	
	public Long getid_tipo_retencion_iva_servicio() {
		return this.id_tipo_retencion_iva_servicio;
	}
    
	
	public Long getid_cuenta_contable_gasto() {
		return this.id_cuenta_contable_gasto;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlantillaFactura:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("PlantillaFactura:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("PlantillaFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("PlantillaFactura:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>200) {
					newnombre=newnombre.substring(0,198);
					System.out.println("PlantillaFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("PlantillaFactura:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>250) {
					newdescripcion=newdescripcion.substring(0,248);
					System.out.println("PlantillaFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_proveedor(Boolean newes_proveedor)throws Exception
	{
		try {
			if(this.es_proveedor!=newes_proveedor) {
				if(newes_proveedor==null) {
					//newes_proveedor=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlantillaFactura:Valor nulo no permitido en columna es_proveedor");
					}
				}

				this.es_proveedor=newes_proveedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_aplicada(Long newid_cuenta_contable_aplicada) {
		if(this.id_cuenta_contable_aplicada==null&&newid_cuenta_contable_aplicada!=null) {
			this.id_cuenta_contable_aplicada=newid_cuenta_contable_aplicada;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_aplicada!=null&&!this.id_cuenta_contable_aplicada.equals(newid_cuenta_contable_aplicada)) {

			this.id_cuenta_contable_aplicada=newid_cuenta_contable_aplicada;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_credito_bien(Long newid_cuenta_contable_credito_bien) {
		if(this.id_cuenta_contable_credito_bien==null&&newid_cuenta_contable_credito_bien!=null) {
			this.id_cuenta_contable_credito_bien=newid_cuenta_contable_credito_bien;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_credito_bien!=null&&!this.id_cuenta_contable_credito_bien.equals(newid_cuenta_contable_credito_bien)) {

			this.id_cuenta_contable_credito_bien=newid_cuenta_contable_credito_bien;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_credito_servicio(Long newid_cuenta_contable_credito_servicio) {
		if(this.id_cuenta_contable_credito_servicio==null&&newid_cuenta_contable_credito_servicio!=null) {
			this.id_cuenta_contable_credito_servicio=newid_cuenta_contable_credito_servicio;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_credito_servicio!=null&&!this.id_cuenta_contable_credito_servicio.equals(newid_cuenta_contable_credito_servicio)) {

			this.id_cuenta_contable_credito_servicio=newid_cuenta_contable_credito_servicio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_retencion_fuente_bien(Long newid_tipo_retencion_fuente_bien) {
		if(this.id_tipo_retencion_fuente_bien==null&&newid_tipo_retencion_fuente_bien!=null) {
			this.id_tipo_retencion_fuente_bien=newid_tipo_retencion_fuente_bien;
				this.setIsChanged(true);
		}

		if(this.id_tipo_retencion_fuente_bien!=null&&!this.id_tipo_retencion_fuente_bien.equals(newid_tipo_retencion_fuente_bien)) {

			this.id_tipo_retencion_fuente_bien=newid_tipo_retencion_fuente_bien;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_retencion_fuente_servicio(Long newid_tipo_retencion_fuente_servicio) {
		if(this.id_tipo_retencion_fuente_servicio==null&&newid_tipo_retencion_fuente_servicio!=null) {
			this.id_tipo_retencion_fuente_servicio=newid_tipo_retencion_fuente_servicio;
				this.setIsChanged(true);
		}

		if(this.id_tipo_retencion_fuente_servicio!=null&&!this.id_tipo_retencion_fuente_servicio.equals(newid_tipo_retencion_fuente_servicio)) {

			this.id_tipo_retencion_fuente_servicio=newid_tipo_retencion_fuente_servicio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_retencion_iva_bien(Long newid_tipo_retencion_iva_bien) {
		if(this.id_tipo_retencion_iva_bien==null&&newid_tipo_retencion_iva_bien!=null) {
			this.id_tipo_retencion_iva_bien=newid_tipo_retencion_iva_bien;
				this.setIsChanged(true);
		}

		if(this.id_tipo_retencion_iva_bien!=null&&!this.id_tipo_retencion_iva_bien.equals(newid_tipo_retencion_iva_bien)) {

			this.id_tipo_retencion_iva_bien=newid_tipo_retencion_iva_bien;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_retencion_iva_servicio(Long newid_tipo_retencion_iva_servicio) {
		if(this.id_tipo_retencion_iva_servicio==null&&newid_tipo_retencion_iva_servicio!=null) {
			this.id_tipo_retencion_iva_servicio=newid_tipo_retencion_iva_servicio;
				this.setIsChanged(true);
		}

		if(this.id_tipo_retencion_iva_servicio!=null&&!this.id_tipo_retencion_iva_servicio.equals(newid_tipo_retencion_iva_servicio)) {

			this.id_tipo_retencion_iva_servicio=newid_tipo_retencion_iva_servicio;
				this.setIsChanged(true);
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
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public CuentaContable getCuentaContableAplicada() {
		return this.cuentacontableaplicada;
	}

	public CuentaContable getCuentaContableCreditoBien() {
		return this.cuentacontablecreditobien;
	}

	public CuentaContable getCuentaContableCreditoServicio() {
		return this.cuentacontablecreditoservicio;
	}

	public TipoRetencion getTipoRetencionFuenteBien() {
		return this.tiporetencionfuentebien;
	}

	public TipoRetencion getTipoRetencionFuenteServicio() {
		return this.tiporetencionfuenteservicio;
	}

	public TipoRetencion getTipoRetencionIvaBien() {
		return this.tiporetencionivabien;
	}

	public TipoRetencion getTipoRetencionIvaServicio() {
		return this.tiporetencionivaservicio;
	}

	public CuentaContable getCuentaContableGasto() {
		return this.cuentacontablegasto;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcuentacontableaplicada_descripcion() {
		return this.cuentacontableaplicada_descripcion;
	}

	public String getcuentacontablecreditobien_descripcion() {
		return this.cuentacontablecreditobien_descripcion;
	}

	public String getcuentacontablecreditoservicio_descripcion() {
		return this.cuentacontablecreditoservicio_descripcion;
	}

	public String gettiporetencionfuentebien_descripcion() {
		return this.tiporetencionfuentebien_descripcion;
	}

	public String gettiporetencionfuenteservicio_descripcion() {
		return this.tiporetencionfuenteservicio_descripcion;
	}

	public String gettiporetencionivabien_descripcion() {
		return this.tiporetencionivabien_descripcion;
	}

	public String gettiporetencionivaservicio_descripcion() {
		return this.tiporetencionivaservicio_descripcion;
	}

	public String getcuentacontablegasto_descripcion() {
		return this.cuentacontablegasto_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableAplicada(CuentaContable cuentacontableaplicada) {
		try {
			this.cuentacontableaplicada=cuentacontableaplicada;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCreditoBien(CuentaContable cuentacontablecreditobien) {
		try {
			this.cuentacontablecreditobien=cuentacontablecreditobien;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCreditoServicio(CuentaContable cuentacontablecreditoservicio) {
		try {
			this.cuentacontablecreditoservicio=cuentacontablecreditoservicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRetencionFuenteBien(TipoRetencion tiporetencionfuentebien) {
		try {
			this.tiporetencionfuentebien=tiporetencionfuentebien;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRetencionFuenteServicio(TipoRetencion tiporetencionfuenteservicio) {
		try {
			this.tiporetencionfuenteservicio=tiporetencionfuenteservicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRetencionIvaBien(TipoRetencion tiporetencionivabien) {
		try {
			this.tiporetencionivabien=tiporetencionivabien;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRetencionIvaServicio(TipoRetencion tiporetencionivaservicio) {
		try {
			this.tiporetencionivaservicio=tiporetencionivaservicio;
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


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableaplicada_descripcion(String cuentacontableaplicada_descripcion) {
		try {
			this.cuentacontableaplicada_descripcion=cuentacontableaplicada_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecreditobien_descripcion(String cuentacontablecreditobien_descripcion) {
		try {
			this.cuentacontablecreditobien_descripcion=cuentacontablecreditobien_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecreditoservicio_descripcion(String cuentacontablecreditoservicio_descripcion) {
		try {
			this.cuentacontablecreditoservicio_descripcion=cuentacontablecreditoservicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporetencionfuentebien_descripcion(String tiporetencionfuentebien_descripcion) {
		try {
			this.tiporetencionfuentebien_descripcion=tiporetencionfuentebien_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporetencionfuenteservicio_descripcion(String tiporetencionfuenteservicio_descripcion) {
		try {
			this.tiporetencionfuenteservicio_descripcion=tiporetencionfuenteservicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporetencionivabien_descripcion(String tiporetencionivabien_descripcion) {
		try {
			this.tiporetencionivabien_descripcion=tiporetencionivabien_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporetencionivaservicio_descripcion(String tiporetencionivaservicio_descripcion) {
		try {
			this.tiporetencionivaservicio_descripcion=tiporetencionivaservicio_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String es_proveedor_descripcion="";String id_cuenta_contable_aplicada_descripcion="";String id_cuenta_contable_credito_bien_descripcion="";String id_cuenta_contable_credito_servicio_descripcion="";String id_tipo_retencion_fuente_bien_descripcion="";String id_tipo_retencion_fuente_servicio_descripcion="";String id_tipo_retencion_iva_bien_descripcion="";String id_tipo_retencion_iva_servicio_descripcion="";String id_cuenta_contable_gasto_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getes_proveedor_descripcion() {
		return es_proveedor_descripcion;
	}
	public String getid_cuenta_contable_aplicada_descripcion() {
		return id_cuenta_contable_aplicada_descripcion;
	}
	public String getid_cuenta_contable_credito_bien_descripcion() {
		return id_cuenta_contable_credito_bien_descripcion;
	}
	public String getid_cuenta_contable_credito_servicio_descripcion() {
		return id_cuenta_contable_credito_servicio_descripcion;
	}
	public String getid_tipo_retencion_fuente_bien_descripcion() {
		return id_tipo_retencion_fuente_bien_descripcion;
	}
	public String getid_tipo_retencion_fuente_servicio_descripcion() {
		return id_tipo_retencion_fuente_servicio_descripcion;
	}
	public String getid_tipo_retencion_iva_bien_descripcion() {
		return id_tipo_retencion_iva_bien_descripcion;
	}
	public String getid_tipo_retencion_iva_servicio_descripcion() {
		return id_tipo_retencion_iva_servicio_descripcion;
	}
	public String getid_cuenta_contable_gasto_descripcion() {
		return id_cuenta_contable_gasto_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_proveedor_descripcion(String newes_proveedor_descripcion)throws Exception {
		try {
			this.es_proveedor_descripcion=newes_proveedor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_aplicada_descripcion(String newid_cuenta_contable_aplicada_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_aplicada_descripcion=newid_cuenta_contable_aplicada_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_credito_bien_descripcion(String newid_cuenta_contable_credito_bien_descripcion) {
		this.id_cuenta_contable_credito_bien_descripcion=newid_cuenta_contable_credito_bien_descripcion;
	}
	public void setid_cuenta_contable_credito_servicio_descripcion(String newid_cuenta_contable_credito_servicio_descripcion) {
		this.id_cuenta_contable_credito_servicio_descripcion=newid_cuenta_contable_credito_servicio_descripcion;
	}
	public void setid_tipo_retencion_fuente_bien_descripcion(String newid_tipo_retencion_fuente_bien_descripcion) {
		this.id_tipo_retencion_fuente_bien_descripcion=newid_tipo_retencion_fuente_bien_descripcion;
	}
	public void setid_tipo_retencion_fuente_servicio_descripcion(String newid_tipo_retencion_fuente_servicio_descripcion) {
		this.id_tipo_retencion_fuente_servicio_descripcion=newid_tipo_retencion_fuente_servicio_descripcion;
	}
	public void setid_tipo_retencion_iva_bien_descripcion(String newid_tipo_retencion_iva_bien_descripcion) {
		this.id_tipo_retencion_iva_bien_descripcion=newid_tipo_retencion_iva_bien_descripcion;
	}
	public void setid_tipo_retencion_iva_servicio_descripcion(String newid_tipo_retencion_iva_servicio_descripcion) {
		this.id_tipo_retencion_iva_servicio_descripcion=newid_tipo_retencion_iva_servicio_descripcion;
	}
	public void setid_cuenta_contable_gasto_descripcion(String newid_cuenta_contable_gasto_descripcion) {
		this.id_cuenta_contable_gasto_descripcion=newid_cuenta_contable_gasto_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.es_proveedor_descripcion="";this.id_cuenta_contable_aplicada_descripcion="";this.id_cuenta_contable_credito_bien_descripcion="";this.id_cuenta_contable_credito_servicio_descripcion="";this.id_tipo_retencion_fuente_bien_descripcion="";this.id_tipo_retencion_fuente_servicio_descripcion="";this.id_tipo_retencion_iva_bien_descripcion="";this.id_tipo_retencion_iva_servicio_descripcion="";this.id_cuenta_contable_gasto_descripcion="";
	}
	
	
	Object facturaproveedorsDescripcionReporte;
	
	
	public Object getfacturaproveedorsDescripcionReporte() {
		return facturaproveedorsDescripcionReporte;
	}

	
	
	public  void  setfacturaproveedorsDescripcionReporte(Object facturaproveedors) {
		try {
			this.facturaproveedorsDescripcionReporte=facturaproveedors;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

