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
//import com.bydan.erp.contabilidad.util.FormularioRentaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class FormularioRenta extends FormularioRentaAdditional implements Serializable ,Cloneable {//FormularioRentaAdditional,GeneralEntity
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
	
	private FormularioRenta formulariorentaOriginal;
	
	private Map<String, Object> mapFormularioRenta;
			
	public Map<String, Object> getMapFormularioRenta() {
		return mapFormularioRenta;
	}

	public void setMapFormularioRenta(Map<String, Object> mapFormularioRenta) {
		this.mapFormularioRenta = mapFormularioRenta;
	}
	
	public void inicializarMapFormularioRenta() {
		this.mapFormularioRenta = new HashMap<String,Object>();
	}
	
	public void setMapFormularioRentaValue(String sKey,Object oValue) {
		this.mapFormularioRenta.put(sKey, oValue);
	}
	
	public Object getMapFormularioRentaValue(String sKey) {
		return this.mapFormularioRenta.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_dato_formulario_renta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_parametro_formulario_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_pagado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double impuesto_retenido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double base_impornible;
			
	
	public Empresa empresa;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public DatoFormularioRenta datoformulariorenta;
	public CuentaContable cuentacontable;
	public TipoRetencion tiporetencion;
	public ParametroFormularioIva parametroformularioiva;
	public Pais pais;
	
	
	private String empresa_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String datoformulariorenta_descripcion;
	private String cuentacontable_descripcion;
	private String tiporetencion_descripcion;
	private String parametroformularioiva_descripcion;
	private String pais_descripcion;
	
	
		
	public FormularioRenta () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.formulariorentaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_dato_formulario_renta=-1L;
 		this.id_cuenta_contable=-1L;
 		this.id_tipo_retencion=-1L;
 		this.id_parametro_formulario_iva=-1L;
 		this.id_pais=-1L;
 		this.valor_pagado=0.0;
 		this.impuesto_retenido=0.0;
 		this.base_impornible=0.0;
		
		
		this.empresa=null;
		this.ejercicio=null;
		this.periodo=null;
		this.datoformulariorenta=null;
		this.cuentacontable=null;
		this.tiporetencion=null;
		this.parametroformularioiva=null;
		this.pais=null;
		
		
		this.empresa_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.datoformulariorenta_descripcion="";
		this.cuentacontable_descripcion="";
		this.tiporetencion_descripcion="";
		this.parametroformularioiva_descripcion="";
		this.pais_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public FormularioRenta (Long id,Date versionRow,Long id_empresa,Long id_ejercicio,Long id_periodo,Long id_dato_formulario_renta,Long id_cuenta_contable,Long id_tipo_retencion,Long id_parametro_formulario_iva,Long id_pais,Double valor_pagado,Double impuesto_retenido,Double base_impornible) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formulariorentaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_dato_formulario_renta=id_dato_formulario_renta;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.id_parametro_formulario_iva=id_parametro_formulario_iva;
 		this.id_pais=id_pais;
 		this.valor_pagado=valor_pagado;
 		this.impuesto_retenido=impuesto_retenido;
 		this.base_impornible=base_impornible;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public FormularioRenta (Long id_empresa,Long id_ejercicio,Long id_periodo,Long id_dato_formulario_renta,Long id_cuenta_contable,Long id_tipo_retencion,Long id_parametro_formulario_iva,Long id_pais,Double valor_pagado,Double impuesto_retenido,Double base_impornible) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formulariorentaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_dato_formulario_renta=id_dato_formulario_renta;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.id_parametro_formulario_iva=id_parametro_formulario_iva;
 		this.id_pais=id_pais;
 		this.valor_pagado=valor_pagado;
 		this.impuesto_retenido=impuesto_retenido;
 		this.base_impornible=base_impornible;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		FormularioRenta formulariorentaLocal=null;
		
		if(object!=null) {
			formulariorentaLocal=(FormularioRenta)object;
			
			if(formulariorentaLocal!=null) {
				if(this.getId()!=null && formulariorentaLocal.getId()!=null) {
					if(this.getId().equals(formulariorentaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!FormularioRentaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=FormularioRentaConstantesFunciones.getFormularioRentaDescripcion(this);
		} else {
			sDetalle=FormularioRentaConstantesFunciones.getFormularioRentaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public FormularioRenta getFormularioRentaOriginal() {
		return this.formulariorentaOriginal;
	}
	
	public void setFormularioRentaOriginal(FormularioRenta formulariorenta) {
		try {
			this.formulariorentaOriginal=formulariorenta;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected FormularioRentaAdditional formulariorentaAdditional=null;
	
	public FormularioRentaAdditional getFormularioRentaAdditional() {
		return this.formulariorentaAdditional;
	}
	
	public void setFormularioRentaAdditional(FormularioRentaAdditional formulariorentaAdditional) {
		try {
			this.formulariorentaAdditional=formulariorentaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_dato_formulario_renta() {
		return this.id_dato_formulario_renta;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_tipo_retencion() {
		return this.id_tipo_retencion;
	}
    
	
	public Long getid_parametro_formulario_iva() {
		return this.id_parametro_formulario_iva;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Double getvalor_pagado() {
		return this.valor_pagado;
	}
    
	
	public Double getimpuesto_retenido() {
		return this.impuesto_retenido;
	}
    
	
	public Double getbase_impornible() {
		return this.base_impornible;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRenta:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ejercicio(Long newid_ejercicio)throws Exception
	{
		try {
			if(this.id_ejercicio!=newid_ejercicio) {
				if(newid_ejercicio==null) {
					//newid_ejercicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRenta:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo(Long newid_periodo)throws Exception
	{
		try {
			if(this.id_periodo!=newid_periodo) {
				if(newid_periodo==null) {
					//newid_periodo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRenta:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_dato_formulario_renta(Long newid_dato_formulario_renta)throws Exception
	{
		try {
			if(this.id_dato_formulario_renta!=newid_dato_formulario_renta) {
				if(newid_dato_formulario_renta==null) {
					//newid_dato_formulario_renta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRenta:Valor nulo no permitido en columna id_dato_formulario_renta");
					}
				}

				this.id_dato_formulario_renta=newid_dato_formulario_renta;
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
						System.out.println("FormularioRenta:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
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
						System.out.println("FormularioRenta:Valor nulo no permitido en columna id_tipo_retencion");
					}
				}

				this.id_tipo_retencion=newid_tipo_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_parametro_formulario_iva(Long newid_parametro_formulario_iva)throws Exception
	{
		try {
			if(this.id_parametro_formulario_iva!=newid_parametro_formulario_iva) {
				if(newid_parametro_formulario_iva==null) {
					//newid_parametro_formulario_iva=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRenta:Valor nulo no permitido en columna id_parametro_formulario_iva");
					}
				}

				this.id_parametro_formulario_iva=newid_parametro_formulario_iva;
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
						System.out.println("FormularioRenta:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_pagado(Double newvalor_pagado)throws Exception
	{
		try {
			if(this.valor_pagado!=newvalor_pagado) {
				if(newvalor_pagado==null) {
					//newvalor_pagado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRenta:Valor nulo no permitido en columna valor_pagado");
					}
				}

				this.valor_pagado=newvalor_pagado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setimpuesto_retenido(Double newimpuesto_retenido)throws Exception
	{
		try {
			if(this.impuesto_retenido!=newimpuesto_retenido) {
				if(newimpuesto_retenido==null) {
					//newimpuesto_retenido=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRenta:Valor nulo no permitido en columna impuesto_retenido");
					}
				}

				this.impuesto_retenido=newimpuesto_retenido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbase_impornible(Double newbase_impornible)throws Exception
	{
		try {
			if(this.base_impornible!=newbase_impornible) {
				if(newbase_impornible==null) {
					//newbase_impornible=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRenta:Valor nulo no permitido en columna base_impornible");
					}
				}

				this.base_impornible=newbase_impornible;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public DatoFormularioRenta getDatoFormularioRenta() {
		return this.datoformulariorenta;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public TipoRetencion getTipoRetencion() {
		return this.tiporetencion;
	}

	public ParametroFormularioIva getParametroFormularioIva() {
		return this.parametroformularioiva;
	}

	public Pais getPais() {
		return this.pais;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getdatoformulariorenta_descripcion() {
		return this.datoformulariorenta_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String gettiporetencion_descripcion() {
		return this.tiporetencion_descripcion;
	}

	public String getparametroformularioiva_descripcion() {
		return this.parametroformularioiva_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEjercicio(Ejercicio ejercicio) {
		try {
			this.ejercicio=ejercicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPeriodo(Periodo periodo) {
		try {
			this.periodo=periodo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDatoFormularioRenta(DatoFormularioRenta datoformulariorenta) {
		try {
			this.datoformulariorenta=datoformulariorenta;
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


	public  void  setTipoRetencion(TipoRetencion tiporetencion) {
		try {
			this.tiporetencion=tiporetencion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setParametroFormularioIva(ParametroFormularioIva parametroformularioiva) {
		try {
			this.parametroformularioiva=parametroformularioiva;
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


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setejercicio_descripcion(String ejercicio_descripcion) {
		try {
			this.ejercicio_descripcion=ejercicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setperiodo_descripcion(String periodo_descripcion) {
		try {
			this.periodo_descripcion=periodo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdatoformulariorenta_descripcion(String datoformulariorenta_descripcion) {
		try {
			this.datoformulariorenta_descripcion=datoformulariorenta_descripcion;
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


	public  void  settiporetencion_descripcion(String tiporetencion_descripcion) {
		try {
			this.tiporetencion_descripcion=tiporetencion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setparametroformularioiva_descripcion(String parametroformularioiva_descripcion) {
		try {
			this.parametroformularioiva_descripcion=parametroformularioiva_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_dato_formulario_renta_descripcion="";String id_cuenta_contable_descripcion="";String id_tipo_retencion_descripcion="";String id_parametro_formulario_iva_descripcion="";String id_pais_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_dato_formulario_renta_descripcion() {
		return id_dato_formulario_renta_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_tipo_retencion_descripcion() {
		return id_tipo_retencion_descripcion;
	}
	public String getid_parametro_formulario_iva_descripcion() {
		return id_parametro_formulario_iva_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ejercicio_descripcion(String newid_ejercicio_descripcion)throws Exception {
		try {
			this.id_ejercicio_descripcion=newid_ejercicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_periodo_descripcion(String newid_periodo_descripcion)throws Exception {
		try {
			this.id_periodo_descripcion=newid_periodo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_dato_formulario_renta_descripcion(String newid_dato_formulario_renta_descripcion)throws Exception {
		try {
			this.id_dato_formulario_renta_descripcion=newid_dato_formulario_renta_descripcion;
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
	public void setid_tipo_retencion_descripcion(String newid_tipo_retencion_descripcion)throws Exception {
		try {
			this.id_tipo_retencion_descripcion=newid_tipo_retencion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_parametro_formulario_iva_descripcion(String newid_parametro_formulario_iva_descripcion)throws Exception {
		try {
			this.id_parametro_formulario_iva_descripcion=newid_parametro_formulario_iva_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_dato_formulario_renta_descripcion="";this.id_cuenta_contable_descripcion="";this.id_tipo_retencion_descripcion="";this.id_parametro_formulario_iva_descripcion="";this.id_pais_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

