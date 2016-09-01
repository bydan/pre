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
//import com.bydan.erp.cartera.util.ParametroCarteraDefectoConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class ParametroCarteraDefecto extends ParametroCarteraDefectoAdditional implements Serializable ,Cloneable {//ParametroCarteraDefectoAdditional,GeneralEntity
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
	
	private ParametroCarteraDefecto parametrocarteradefectoOriginal;
	
	private Map<String, Object> mapParametroCarteraDefecto;
			
	public Map<String, Object> getMapParametroCarteraDefecto() {
		return mapParametroCarteraDefecto;
	}

	public void setMapParametroCarteraDefecto(Map<String, Object> mapParametroCarteraDefecto) {
		this.mapParametroCarteraDefecto = mapParametroCarteraDefecto;
	}
	
	public void inicializarMapParametroCarteraDefecto() {
		this.mapParametroCarteraDefecto = new HashMap<String,Object>();
	}
	
	public void setMapParametroCarteraDefectoValue(String sKey,Object oValue) {
		this.mapParametroCarteraDefecto.put(sKey, oValue);
	}
	
	public Object getMapParametroCarteraDefectoValue(String sKey) {
		return this.mapParametroCarteraDefecto.get(sKey);
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
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_region;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_provincia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_zona;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_identificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_nivel_edu;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais_nacionalidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_genero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_civil;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_legal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ruta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_dia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_lista_precio;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Pais pais;
	public Region region;
	public Provincia provincia;
	public Ciudad ciudad;
	public Zona zona;
	public TipoIdentificacion tipoidentificacion;
	public TipoNivelEdu tiponiveledu;
	public Pais paisnacionalidad;
	public TipoGenero tipogenero;
	public EstadoCivil estadocivil;
	public EstadoLegal estadolegal;
	public CuentaContable cuentacontable;
	public Vendedor vendedor;
	public Ruta ruta;
	public Dia dia;
	public TipoPrecio tipoprecio;
	public TipoListaPrecio tipolistaprecio;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String pais_descripcion;
	private String region_descripcion;
	private String provincia_descripcion;
	private String ciudad_descripcion;
	private String zona_descripcion;
	private String tipoidentificacion_descripcion;
	private String tiponiveledu_descripcion;
	private String paisnacionalidad_descripcion;
	private String tipogenero_descripcion;
	private String estadocivil_descripcion;
	private String estadolegal_descripcion;
	private String cuentacontable_descripcion;
	private String vendedor_descripcion;
	private String ruta_descripcion;
	private String dia_descripcion;
	private String tipoprecio_descripcion;
	private String tipolistaprecio_descripcion;
	
	
		
	public ParametroCarteraDefecto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrocarteradefectoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_pais=-1L;
 		this.id_region=-1L;
 		this.id_provincia=-1L;
 		this.id_ciudad=-1L;
 		this.id_zona=-1L;
 		this.id_tipo_identificacion=-1L;
 		this.id_tipo_nivel_edu=-1L;
 		this.id_pais_nacionalidad=-1L;
 		this.id_tipo_genero=-1L;
 		this.id_estado_civil=-1L;
 		this.id_estado_legal=-1L;
 		this.id_cuenta_contable=-1L;
 		this.id_vendedor=-1L;
 		this.id_ruta=-1L;
 		this.id_dia=-1L;
 		this.id_tipo_precio=-1L;
 		this.id_tipo_lista_precio=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.pais=null;
		this.region=null;
		this.provincia=null;
		this.ciudad=null;
		this.zona=null;
		this.tipoidentificacion=null;
		this.tiponiveledu=null;
		this.paisnacionalidad=null;
		this.tipogenero=null;
		this.estadocivil=null;
		this.estadolegal=null;
		this.cuentacontable=null;
		this.vendedor=null;
		this.ruta=null;
		this.dia=null;
		this.tipoprecio=null;
		this.tipolistaprecio=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.pais_descripcion="";
		this.region_descripcion="";
		this.provincia_descripcion="";
		this.ciudad_descripcion="";
		this.zona_descripcion="";
		this.tipoidentificacion_descripcion="";
		this.tiponiveledu_descripcion="";
		this.paisnacionalidad_descripcion="";
		this.tipogenero_descripcion="";
		this.estadocivil_descripcion="";
		this.estadolegal_descripcion="";
		this.cuentacontable_descripcion="";
		this.vendedor_descripcion="";
		this.ruta_descripcion="";
		this.dia_descripcion="";
		this.tipoprecio_descripcion="";
		this.tipolistaprecio_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroCarteraDefecto (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_pais,Long id_region,Long id_provincia,Long id_ciudad,Long id_zona,Long id_tipo_identificacion,Long id_tipo_nivel_edu,Long id_pais_nacionalidad,Long id_tipo_genero,Long id_estado_civil,Long id_estado_legal,Long id_cuenta_contable,Long id_vendedor,Long id_ruta,Long id_dia,Long id_tipo_precio,Long id_tipo_lista_precio) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrocarteradefectoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_pais=id_pais;
 		this.id_region=id_region;
 		this.id_provincia=id_provincia;
 		this.id_ciudad=id_ciudad;
 		this.id_zona=id_zona;
 		this.id_tipo_identificacion=id_tipo_identificacion;
 		this.id_tipo_nivel_edu=id_tipo_nivel_edu;
 		this.id_pais_nacionalidad=id_pais_nacionalidad;
 		this.id_tipo_genero=id_tipo_genero;
 		this.id_estado_civil=id_estado_civil;
 		this.id_estado_legal=id_estado_legal;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_vendedor=id_vendedor;
 		this.id_ruta=id_ruta;
 		this.id_dia=id_dia;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_tipo_lista_precio=id_tipo_lista_precio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroCarteraDefecto (Long id_empresa,Long id_sucursal,Long id_pais,Long id_region,Long id_provincia,Long id_ciudad,Long id_zona,Long id_tipo_identificacion,Long id_tipo_nivel_edu,Long id_pais_nacionalidad,Long id_tipo_genero,Long id_estado_civil,Long id_estado_legal,Long id_cuenta_contable,Long id_vendedor,Long id_ruta,Long id_dia,Long id_tipo_precio,Long id_tipo_lista_precio) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrocarteradefectoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_pais=id_pais;
 		this.id_region=id_region;
 		this.id_provincia=id_provincia;
 		this.id_ciudad=id_ciudad;
 		this.id_zona=id_zona;
 		this.id_tipo_identificacion=id_tipo_identificacion;
 		this.id_tipo_nivel_edu=id_tipo_nivel_edu;
 		this.id_pais_nacionalidad=id_pais_nacionalidad;
 		this.id_tipo_genero=id_tipo_genero;
 		this.id_estado_civil=id_estado_civil;
 		this.id_estado_legal=id_estado_legal;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_vendedor=id_vendedor;
 		this.id_ruta=id_ruta;
 		this.id_dia=id_dia;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_tipo_lista_precio=id_tipo_lista_precio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroCarteraDefecto parametrocarteradefectoLocal=null;
		
		if(object!=null) {
			parametrocarteradefectoLocal=(ParametroCarteraDefecto)object;
			
			if(parametrocarteradefectoLocal!=null) {
				if(this.getId()!=null && parametrocarteradefectoLocal.getId()!=null) {
					if(this.getId().equals(parametrocarteradefectoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroCarteraDefectoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroCarteraDefectoConstantesFunciones.getParametroCarteraDefectoDescripcion(this);
		} else {
			sDetalle=ParametroCarteraDefectoConstantesFunciones.getParametroCarteraDefectoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroCarteraDefecto getParametroCarteraDefectoOriginal() {
		return this.parametrocarteradefectoOriginal;
	}
	
	public void setParametroCarteraDefectoOriginal(ParametroCarteraDefecto parametrocarteradefecto) {
		try {
			this.parametrocarteradefectoOriginal=parametrocarteradefecto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroCarteraDefectoAdditional parametrocarteradefectoAdditional=null;
	
	public ParametroCarteraDefectoAdditional getParametroCarteraDefectoAdditional() {
		return this.parametrocarteradefectoAdditional;
	}
	
	public void setParametroCarteraDefectoAdditional(ParametroCarteraDefectoAdditional parametrocarteradefectoAdditional) {
		try {
			this.parametrocarteradefectoAdditional=parametrocarteradefectoAdditional;
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
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_region() {
		return this.id_region;
	}
    
	
	public Long getid_provincia() {
		return this.id_provincia;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public Long getid_zona() {
		return this.id_zona;
	}
    
	
	public Long getid_tipo_identificacion() {
		return this.id_tipo_identificacion;
	}
    
	
	public Long getid_tipo_nivel_edu() {
		return this.id_tipo_nivel_edu;
	}
    
	
	public Long getid_pais_nacionalidad() {
		return this.id_pais_nacionalidad;
	}
    
	
	public Long getid_tipo_genero() {
		return this.id_tipo_genero;
	}
    
	
	public Long getid_estado_civil() {
		return this.id_estado_civil;
	}
    
	
	public Long getid_estado_legal() {
		return this.id_estado_legal;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public Long getid_ruta() {
		return this.id_ruta;
	}
    
	
	public Long getid_dia() {
		return this.id_dia;
	}
    
	
	public Long getid_tipo_precio() {
		return this.id_tipo_precio;
	}
    
	
	public Long getid_tipo_lista_precio() {
		return this.id_tipo_lista_precio;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_region(Long newid_region)throws Exception
	{
		try {
			if(this.id_region!=newid_region) {
				if(newid_region==null) {
					//newid_region=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_region");
					}
				}

				this.id_region=newid_region;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_provincia(Long newid_provincia)throws Exception
	{
		try {
			if(this.id_provincia!=newid_provincia) {
				if(newid_provincia==null) {
					//newid_provincia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_provincia");
					}
				}

				this.id_provincia=newid_provincia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ciudad(Long newid_ciudad)throws Exception
	{
		try {
			if(this.id_ciudad!=newid_ciudad) {
				if(newid_ciudad==null) {
					//newid_ciudad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_ciudad");
					}
				}

				this.id_ciudad=newid_ciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_zona(Long newid_zona)throws Exception
	{
		try {
			if(this.id_zona!=newid_zona) {
				if(newid_zona==null) {
					//newid_zona=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_zona");
					}
				}

				this.id_zona=newid_zona;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_identificacion(Long newid_tipo_identificacion)throws Exception
	{
		try {
			if(this.id_tipo_identificacion!=newid_tipo_identificacion) {
				if(newid_tipo_identificacion==null) {
					//newid_tipo_identificacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_tipo_identificacion");
					}
				}

				this.id_tipo_identificacion=newid_tipo_identificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_nivel_edu(Long newid_tipo_nivel_edu)throws Exception
	{
		try {
			if(this.id_tipo_nivel_edu!=newid_tipo_nivel_edu) {
				if(newid_tipo_nivel_edu==null) {
					//newid_tipo_nivel_edu=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_tipo_nivel_edu");
					}
				}

				this.id_tipo_nivel_edu=newid_tipo_nivel_edu;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pais_nacionalidad(Long newid_pais_nacionalidad)throws Exception
	{
		try {
			if(this.id_pais_nacionalidad!=newid_pais_nacionalidad) {
				if(newid_pais_nacionalidad==null) {
					//newid_pais_nacionalidad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_pais_nacionalidad");
					}
				}

				this.id_pais_nacionalidad=newid_pais_nacionalidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_genero(Long newid_tipo_genero)throws Exception
	{
		try {
			if(this.id_tipo_genero!=newid_tipo_genero) {
				if(newid_tipo_genero==null) {
					//newid_tipo_genero=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_tipo_genero");
					}
				}

				this.id_tipo_genero=newid_tipo_genero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_civil(Long newid_estado_civil)throws Exception
	{
		try {
			if(this.id_estado_civil!=newid_estado_civil) {
				if(newid_estado_civil==null) {
					//newid_estado_civil=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_estado_civil");
					}
				}

				this.id_estado_civil=newid_estado_civil;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_legal(Long newid_estado_legal)throws Exception
	{
		try {
			if(this.id_estado_legal!=newid_estado_legal) {
				if(newid_estado_legal==null) {
					//newid_estado_legal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_estado_legal");
					}
				}

				this.id_estado_legal=newid_estado_legal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable(Long newid_cuenta_contable)throws Exception
	{
		try {
			if(this.id_cuenta_contable!=newid_cuenta_contable) {
				if(newid_cuenta_contable==null) {
					//newid_cuenta_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_vendedor(Long newid_vendedor)throws Exception
	{
		try {
			if(this.id_vendedor!=newid_vendedor) {
				if(newid_vendedor==null) {
					//newid_vendedor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_vendedor");
					}
				}

				this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ruta(Long newid_ruta)throws Exception
	{
		try {
			if(this.id_ruta!=newid_ruta) {
				if(newid_ruta==null) {
					//newid_ruta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_ruta");
					}
				}

				this.id_ruta=newid_ruta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_dia(Long newid_dia)throws Exception
	{
		try {
			if(this.id_dia!=newid_dia) {
				if(newid_dia==null) {
					//newid_dia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_dia");
					}
				}

				this.id_dia=newid_dia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_precio(Long newid_tipo_precio)throws Exception
	{
		try {
			if(this.id_tipo_precio!=newid_tipo_precio) {
				if(newid_tipo_precio==null) {
					//newid_tipo_precio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_tipo_precio");
					}
				}

				this.id_tipo_precio=newid_tipo_precio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_lista_precio(Long newid_tipo_lista_precio)throws Exception
	{
		try {
			if(this.id_tipo_lista_precio!=newid_tipo_lista_precio) {
				if(newid_tipo_lista_precio==null) {
					//newid_tipo_lista_precio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroCarteraDefecto:Valor nulo no permitido en columna id_tipo_lista_precio");
					}
				}

				this.id_tipo_lista_precio=newid_tipo_lista_precio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Region getRegion() {
		return this.region;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public Zona getZona() {
		return this.zona;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return this.tipoidentificacion;
	}

	public TipoNivelEdu getTipoNivelEdu() {
		return this.tiponiveledu;
	}

	public Pais getPaisNacionalidad() {
		return this.paisnacionalidad;
	}

	public TipoGenero getTipoGenero() {
		return this.tipogenero;
	}

	public EstadoCivil getEstadoCivil() {
		return this.estadocivil;
	}

	public EstadoLegal getEstadoLegal() {
		return this.estadolegal;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public Ruta getRuta() {
		return this.ruta;
	}

	public Dia getDia() {
		return this.dia;
	}

	public TipoPrecio getTipoPrecio() {
		return this.tipoprecio;
	}

	public TipoListaPrecio getTipoListaPrecio() {
		return this.tipolistaprecio;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getregion_descripcion() {
		return this.region_descripcion;
	}

	public String getprovincia_descripcion() {
		return this.provincia_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	public String getzona_descripcion() {
		return this.zona_descripcion;
	}

	public String gettipoidentificacion_descripcion() {
		return this.tipoidentificacion_descripcion;
	}

	public String gettiponiveledu_descripcion() {
		return this.tiponiveledu_descripcion;
	}

	public String getpaisnacionalidad_descripcion() {
		return this.paisnacionalidad_descripcion;
	}

	public String gettipogenero_descripcion() {
		return this.tipogenero_descripcion;
	}

	public String getestadocivil_descripcion() {
		return this.estadocivil_descripcion;
	}

	public String getestadolegal_descripcion() {
		return this.estadolegal_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
	}

	public String getruta_descripcion() {
		return this.ruta_descripcion;
	}

	public String getdia_descripcion() {
		return this.dia_descripcion;
	}

	public String gettipoprecio_descripcion() {
		return this.tipoprecio_descripcion;
	}

	public String gettipolistaprecio_descripcion() {
		return this.tipolistaprecio_descripcion;
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


	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
		} catch(Exception e) {
			;
		}
	}


	public  void  setRegion(Region region) {
		try {
			this.region=region;
		} catch(Exception e) {
			;
		}
	}


	public  void  setProvincia(Provincia provincia) {
		try {
			this.provincia=provincia;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCiudad(Ciudad ciudad) {
		try {
			this.ciudad=ciudad;
		} catch(Exception e) {
			;
		}
	}


	public  void  setZona(Zona zona) {
		try {
			this.zona=zona;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoIdentificacion(TipoIdentificacion tipoidentificacion) {
		try {
			this.tipoidentificacion=tipoidentificacion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoNivelEdu(TipoNivelEdu tiponiveledu) {
		try {
			this.tiponiveledu=tiponiveledu;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPaisNacionalidad(Pais paisnacionalidad) {
		try {
			this.paisnacionalidad=paisnacionalidad;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoGenero(TipoGenero tipogenero) {
		try {
			this.tipogenero=tipogenero;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoCivil(EstadoCivil estadocivil) {
		try {
			this.estadocivil=estadocivil;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoLegal(EstadoLegal estadolegal) {
		try {
			this.estadolegal=estadolegal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContable(CuentaContable cuentacontable) {
		try {
			this.cuentacontable=cuentacontable;
		} catch(Exception e) {
			;
		}
	}


	public  void  setVendedor(Vendedor vendedor) {
		try {
			this.vendedor=vendedor;
		} catch(Exception e) {
			;
		}
	}


	public  void  setRuta(Ruta ruta) {
		try {
			this.ruta=ruta;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDia(Dia dia) {
		try {
			this.dia=dia;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoPrecio(TipoPrecio tipoprecio) {
		try {
			this.tipoprecio=tipoprecio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoListaPrecio(TipoListaPrecio tipolistaprecio) {
		try {
			this.tipolistaprecio=tipolistaprecio;
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


	public  void  setpais_descripcion(String pais_descripcion) {
		try {
			this.pais_descripcion=pais_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setregion_descripcion(String region_descripcion) {
		try {
			this.region_descripcion=region_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setprovincia_descripcion(String provincia_descripcion) {
		try {
			this.provincia_descripcion=provincia_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setciudad_descripcion(String ciudad_descripcion) {
		try {
			this.ciudad_descripcion=ciudad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setzona_descripcion(String zona_descripcion) {
		try {
			this.zona_descripcion=zona_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoidentificacion_descripcion(String tipoidentificacion_descripcion) {
		try {
			this.tipoidentificacion_descripcion=tipoidentificacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiponiveledu_descripcion(String tiponiveledu_descripcion) {
		try {
			this.tiponiveledu_descripcion=tiponiveledu_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpaisnacionalidad_descripcion(String paisnacionalidad_descripcion) {
		try {
			this.paisnacionalidad_descripcion=paisnacionalidad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipogenero_descripcion(String tipogenero_descripcion) {
		try {
			this.tipogenero_descripcion=tipogenero_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadocivil_descripcion(String estadocivil_descripcion) {
		try {
			this.estadocivil_descripcion=estadocivil_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadolegal_descripcion(String estadolegal_descripcion) {
		try {
			this.estadolegal_descripcion=estadolegal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontable_descripcion(String cuentacontable_descripcion) {
		try {
			this.cuentacontable_descripcion=cuentacontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setvendedor_descripcion(String vendedor_descripcion) {
		try {
			this.vendedor_descripcion=vendedor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setruta_descripcion(String ruta_descripcion) {
		try {
			this.ruta_descripcion=ruta_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdia_descripcion(String dia_descripcion) {
		try {
			this.dia_descripcion=dia_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoprecio_descripcion(String tipoprecio_descripcion) {
		try {
			this.tipoprecio_descripcion=tipoprecio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipolistaprecio_descripcion(String tipolistaprecio_descripcion) {
		try {
			this.tipolistaprecio_descripcion=tipolistaprecio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_pais_descripcion="";String id_region_descripcion="";String id_provincia_descripcion="";String id_ciudad_descripcion="";String id_zona_descripcion="";String id_tipo_identificacion_descripcion="";String id_tipo_nivel_edu_descripcion="";String id_pais_nacionalidad_descripcion="";String id_tipo_genero_descripcion="";String id_estado_civil_descripcion="";String id_estado_legal_descripcion="";String id_cuenta_contable_descripcion="";String id_vendedor_descripcion="";String id_ruta_descripcion="";String id_dia_descripcion="";String id_tipo_precio_descripcion="";String id_tipo_lista_precio_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_region_descripcion() {
		return id_region_descripcion;
	}
	public String getid_provincia_descripcion() {
		return id_provincia_descripcion;
	}
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	public String getid_zona_descripcion() {
		return id_zona_descripcion;
	}
	public String getid_tipo_identificacion_descripcion() {
		return id_tipo_identificacion_descripcion;
	}
	public String getid_tipo_nivel_edu_descripcion() {
		return id_tipo_nivel_edu_descripcion;
	}
	public String getid_pais_nacionalidad_descripcion() {
		return id_pais_nacionalidad_descripcion;
	}
	public String getid_tipo_genero_descripcion() {
		return id_tipo_genero_descripcion;
	}
	public String getid_estado_civil_descripcion() {
		return id_estado_civil_descripcion;
	}
	public String getid_estado_legal_descripcion() {
		return id_estado_legal_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
	}
	public String getid_ruta_descripcion() {
		return id_ruta_descripcion;
	}
	public String getid_dia_descripcion() {
		return id_dia_descripcion;
	}
	public String getid_tipo_precio_descripcion() {
		return id_tipo_precio_descripcion;
	}
	public String getid_tipo_lista_precio_descripcion() {
		return id_tipo_lista_precio_descripcion;
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
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_region_descripcion(String newid_region_descripcion)throws Exception {
		try {
			this.id_region_descripcion=newid_region_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_provincia_descripcion(String newid_provincia_descripcion)throws Exception {
		try {
			this.id_provincia_descripcion=newid_provincia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ciudad_descripcion(String newid_ciudad_descripcion)throws Exception {
		try {
			this.id_ciudad_descripcion=newid_ciudad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_zona_descripcion(String newid_zona_descripcion)throws Exception {
		try {
			this.id_zona_descripcion=newid_zona_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_identificacion_descripcion(String newid_tipo_identificacion_descripcion)throws Exception {
		try {
			this.id_tipo_identificacion_descripcion=newid_tipo_identificacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_nivel_edu_descripcion(String newid_tipo_nivel_edu_descripcion)throws Exception {
		try {
			this.id_tipo_nivel_edu_descripcion=newid_tipo_nivel_edu_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_pais_nacionalidad_descripcion(String newid_pais_nacionalidad_descripcion)throws Exception {
		try {
			this.id_pais_nacionalidad_descripcion=newid_pais_nacionalidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_genero_descripcion(String newid_tipo_genero_descripcion)throws Exception {
		try {
			this.id_tipo_genero_descripcion=newid_tipo_genero_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_civil_descripcion(String newid_estado_civil_descripcion)throws Exception {
		try {
			this.id_estado_civil_descripcion=newid_estado_civil_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_legal_descripcion(String newid_estado_legal_descripcion)throws Exception {
		try {
			this.id_estado_legal_descripcion=newid_estado_legal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_vendedor_descripcion(String newid_vendedor_descripcion)throws Exception {
		try {
			this.id_vendedor_descripcion=newid_vendedor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ruta_descripcion(String newid_ruta_descripcion)throws Exception {
		try {
			this.id_ruta_descripcion=newid_ruta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_dia_descripcion(String newid_dia_descripcion)throws Exception {
		try {
			this.id_dia_descripcion=newid_dia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_precio_descripcion(String newid_tipo_precio_descripcion)throws Exception {
		try {
			this.id_tipo_precio_descripcion=newid_tipo_precio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_lista_precio_descripcion(String newid_tipo_lista_precio_descripcion)throws Exception {
		try {
			this.id_tipo_lista_precio_descripcion=newid_tipo_lista_precio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_pais_descripcion="";this.id_region_descripcion="";this.id_provincia_descripcion="";this.id_ciudad_descripcion="";this.id_zona_descripcion="";this.id_tipo_identificacion_descripcion="";this.id_tipo_nivel_edu_descripcion="";this.id_pais_nacionalidad_descripcion="";this.id_tipo_genero_descripcion="";this.id_estado_civil_descripcion="";this.id_estado_legal_descripcion="";this.id_cuenta_contable_descripcion="";this.id_vendedor_descripcion="";this.id_ruta_descripcion="";this.id_dia_descripcion="";this.id_tipo_precio_descripcion="";this.id_tipo_lista_precio_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

