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
package com.bydan.erp.contabilidad.business.entity.report;

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
//import com.bydan.erp.contabilidad.util.RetencionesPorPagarPorCuentasConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class RetencionesPorPagarPorCuentas extends RetencionesPorPagarPorCuentasAdditional implements Serializable ,Cloneable {//RetencionesPorPagarPorCuentasAdditional,GeneralEntity
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
	
	private RetencionesPorPagarPorCuentas retencionesporpagarporcuentasOriginal;
	
	private Map<String, Object> mapRetencionesPorPagarPorCuentas;
			
	public Map<String, Object> getMapRetencionesPorPagarPorCuentas() {
		return mapRetencionesPorPagarPorCuentas;
	}

	public void setMapRetencionesPorPagarPorCuentas(Map<String, Object> mapRetencionesPorPagarPorCuentas) {
		this.mapRetencionesPorPagarPorCuentas = mapRetencionesPorPagarPorCuentas;
	}
	
	public void inicializarMapRetencionesPorPagarPorCuentas() {
		this.mapRetencionesPorPagarPorCuentas = new HashMap<String,Object>();
	}
	
	public void setMapRetencionesPorPagarPorCuentasValue(String sKey,Object oValue) {
		this.mapRetencionesPorPagarPorCuentas.put(sKey, oValue);
	}
	
	public Object getMapRetencionesPorPagarPorCuentasValue(String sKey) {
		return this.mapRetencionesPorPagarPorCuentas.get(sKey);
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
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_debito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=RetencionesPorPagarPorCuentasConstantesFunciones.SREGEXNOMBRE_TIPO_MOVIMIENTO,message=RetencionesPorPagarPorCuentasConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_MOVIMIENTO)
	private String nombre_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=RetencionesPorPagarPorCuentasConstantesFunciones.SREGEXNUMERO_MAYOR,message=RetencionesPorPagarPorCuentasConstantesFunciones.SMENSAJEREGEXNUMERO_MAYOR)
	private String numero_mayor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=RetencionesPorPagarPorCuentasConstantesFunciones.SREGEXNOMBRE_CUENTA_CONTABLE_RETENCION,message=RetencionesPorPagarPorCuentasConstantesFunciones.SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE_RETENCION)
	private String nombre_cuenta_contable_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=RetencionesPorPagarPorCuentasConstantesFunciones.SREGEXNUMERO_PRE_IMPRESO_FACTURA,message=RetencionesPorPagarPorCuentasConstantesFunciones.SMENSAJEREGEXNUMERO_PRE_IMPRESO_FACTURA)
	private String numero_pre_impreso_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double base_imponible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=RetencionesPorPagarPorCuentasConstantesFunciones.SREGEXNUMERO,message=RetencionesPorPagarPorCuentasConstantesFunciones.SMENSAJEREGEXNUMERO)
	private String numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=RetencionesPorPagarPorCuentasConstantesFunciones.SREGEXNOMBRE_BENEF,message=RetencionesPorPagarPorCuentasConstantesFunciones.SMENSAJEREGEXNOMBRE_BENEF)
	private String nombre_benef;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=RetencionesPorPagarPorCuentasConstantesFunciones.SREGEXRUC_BENEF,message=RetencionesPorPagarPorCuentasConstantesFunciones.SMENSAJEREGEXRUC_BENEF)
	private String ruc_benef;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=RetencionesPorPagarPorCuentasConstantesFunciones.SREGEXNOMBRE_CUENTA_CONTABLE,message=RetencionesPorPagarPorCuentasConstantesFunciones.SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE)
	private String nombre_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=RetencionesPorPagarPorCuentasConstantesFunciones.SREGEXNOMBRE_CUENTA_CONTABLE_CREDITO,message=RetencionesPorPagarPorCuentasConstantesFunciones.SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE_CREDITO)
	private String nombre_cuenta_contable_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_debito_dato;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public TipoRetencion tiporetencion;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String tiporetencion_descripcion;
	
	
		
	public RetencionesPorPagarPorCuentas () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.retencionesporpagarporcuentasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_tipo_retencion=-1L;
 		this.es_debito=false;
 		this.fecha_emision=new Date();
 		this.nombre_tipo_movimiento="";
 		this.numero_mayor="";
 		this.nombre_cuenta_contable_retencion="";
 		this.numero_pre_impreso_factura="";
 		this.porcentaje=0.0;
 		this.base_imponible=0.0;
 		this.valor=0.0;
 		this.numero="";
 		this.nombre_benef="";
 		this.ruc_benef="";
 		this.nombre_cuenta_contable="";
 		this.nombre_cuenta_contable_credito="";
 		this.es_debito_dato=false;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.tiporetencion=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.tiporetencion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public RetencionesPorPagarPorCuentas (Long id,Date versionRow,Date fecha_emision,String nombre_tipo_movimiento,String numero_mayor,String nombre_cuenta_contable_retencion,String numero_pre_impreso_factura,Double porcentaje,Double base_imponible,Double valor,String numero,String nombre_benef,String ruc_benef,String nombre_cuenta_contable,String nombre_cuenta_contable_credito,Boolean es_debito_dato) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.retencionesporpagarporcuentasOriginal=this;
		
 		this.fecha_emision=fecha_emision;
 		this.nombre_tipo_movimiento=nombre_tipo_movimiento;
 		this.numero_mayor=numero_mayor;
 		this.nombre_cuenta_contable_retencion=nombre_cuenta_contable_retencion;
 		this.numero_pre_impreso_factura=numero_pre_impreso_factura;
 		this.porcentaje=porcentaje;
 		this.base_imponible=base_imponible;
 		this.valor=valor;
 		this.numero=numero;
 		this.nombre_benef=nombre_benef;
 		this.ruc_benef=ruc_benef;
 		this.nombre_cuenta_contable=nombre_cuenta_contable;
 		this.nombre_cuenta_contable_credito=nombre_cuenta_contable_credito;
 		this.es_debito_dato=es_debito_dato;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public RetencionesPorPagarPorCuentas (Date fecha_emision,String nombre_tipo_movimiento,String numero_mayor,String nombre_cuenta_contable_retencion,String numero_pre_impreso_factura,Double porcentaje,Double base_imponible,Double valor,String numero,String nombre_benef,String ruc_benef,String nombre_cuenta_contable,String nombre_cuenta_contable_credito,Boolean es_debito_dato) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.retencionesporpagarporcuentasOriginal=this;
		
 		this.fecha_emision=fecha_emision;
 		this.nombre_tipo_movimiento=nombre_tipo_movimiento;
 		this.numero_mayor=numero_mayor;
 		this.nombre_cuenta_contable_retencion=nombre_cuenta_contable_retencion;
 		this.numero_pre_impreso_factura=numero_pre_impreso_factura;
 		this.porcentaje=porcentaje;
 		this.base_imponible=base_imponible;
 		this.valor=valor;
 		this.numero=numero;
 		this.nombre_benef=nombre_benef;
 		this.ruc_benef=ruc_benef;
 		this.nombre_cuenta_contable=nombre_cuenta_contable;
 		this.nombre_cuenta_contable_credito=nombre_cuenta_contable_credito;
 		this.es_debito_dato=es_debito_dato;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public RetencionesPorPagarPorCuentas getRetencionesPorPagarPorCuentasOriginal() {
		return this.retencionesporpagarporcuentasOriginal;
	}
	
	public void setRetencionesPorPagarPorCuentasOriginal(RetencionesPorPagarPorCuentas retencionesporpagarporcuentas) {
		try {
			this.retencionesporpagarporcuentasOriginal=retencionesporpagarporcuentas;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected RetencionesPorPagarPorCuentasAdditional retencionesporpagarporcuentasAdditional=null;
	
	public RetencionesPorPagarPorCuentasAdditional getRetencionesPorPagarPorCuentasAdditional() {
		return this.retencionesporpagarporcuentasAdditional;
	}
	
	public void setRetencionesPorPagarPorCuentasAdditional(RetencionesPorPagarPorCuentasAdditional retencionesporpagarporcuentasAdditional) {
		try {
			this.retencionesporpagarporcuentasAdditional=retencionesporpagarporcuentasAdditional;
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
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_tipo_retencion() {
		return this.id_tipo_retencion;
	}
    
	
	public Boolean getes_debito() {
		return this.es_debito;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public String getnombre_tipo_movimiento() {
		return this.nombre_tipo_movimiento;
	}
    
	
	public String getnumero_mayor() {
		return this.numero_mayor;
	}
    
	
	public String getnombre_cuenta_contable_retencion() {
		return this.nombre_cuenta_contable_retencion;
	}
    
	
	public String getnumero_pre_impreso_factura() {
		return this.numero_pre_impreso_factura;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getbase_imponible() {
		return this.base_imponible;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public String getnumero() {
		return this.numero;
	}
    
	
	public String getnombre_benef() {
		return this.nombre_benef;
	}
    
	
	public String getruc_benef() {
		return this.ruc_benef;
	}
    
	
	public String getnombre_cuenta_contable() {
		return this.nombre_cuenta_contable;
	}
    
	
	public String getnombre_cuenta_contable_credito() {
		return this.nombre_cuenta_contable_credito;
	}
    
	
	public Boolean getes_debito_dato() {
		return this.es_debito_dato;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
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
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna id_tipo_retencion");
					}
				}

				this.id_tipo_retencion=newid_tipo_retencion;
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
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna es_debito");
					}
				}

				this.es_debito=newes_debito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision(Date newfecha_emision)throws Exception
	{
		try {
			if(this.fecha_emision!=newfecha_emision) {
				if(newfecha_emision==null) {
					//newfecha_emision=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tipo_movimiento(String newnombre_tipo_movimiento)throws Exception
	{
		try {
			if(this.nombre_tipo_movimiento!=newnombre_tipo_movimiento) {
				if(newnombre_tipo_movimiento==null) {
					//newnombre_tipo_movimiento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna nombre_tipo_movimiento");
					}
				}

				if(newnombre_tipo_movimiento!=null&&newnombre_tipo_movimiento.length()>100) {
					newnombre_tipo_movimiento=newnombre_tipo_movimiento.substring(0,98);
					System.out.println("RetencionesPorPagarPorCuentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_tipo_movimiento");
				}

				this.nombre_tipo_movimiento=newnombre_tipo_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_mayor(String newnumero_mayor)throws Exception
	{
		try {
			if(this.numero_mayor!=newnumero_mayor) {
				if(newnumero_mayor==null) {
					//newnumero_mayor="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna numero_mayor");
					}
				}

				if(newnumero_mayor!=null&&newnumero_mayor.length()>100) {
					newnumero_mayor=newnumero_mayor.substring(0,98);
					System.out.println("RetencionesPorPagarPorCuentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna numero_mayor");
				}

				this.numero_mayor=newnumero_mayor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_cuenta_contable_retencion(String newnombre_cuenta_contable_retencion)throws Exception
	{
		try {
			if(this.nombre_cuenta_contable_retencion!=newnombre_cuenta_contable_retencion) {
				if(newnombre_cuenta_contable_retencion==null) {
					//newnombre_cuenta_contable_retencion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna nombre_cuenta_contable_retencion");
					}
				}

				if(newnombre_cuenta_contable_retencion!=null&&newnombre_cuenta_contable_retencion.length()>150) {
					newnombre_cuenta_contable_retencion=newnombre_cuenta_contable_retencion.substring(0,148);
					System.out.println("RetencionesPorPagarPorCuentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cuenta_contable_retencion");
				}

				this.nombre_cuenta_contable_retencion=newnombre_cuenta_contable_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_pre_impreso_factura(String newnumero_pre_impreso_factura)throws Exception
	{
		try {
			if(this.numero_pre_impreso_factura!=newnumero_pre_impreso_factura) {
				if(newnumero_pre_impreso_factura==null) {
					//newnumero_pre_impreso_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna numero_pre_impreso_factura");
					}
				}

				if(newnumero_pre_impreso_factura!=null&&newnumero_pre_impreso_factura.length()>50) {
					newnumero_pre_impreso_factura=newnumero_pre_impreso_factura.substring(0,48);
					System.out.println("RetencionesPorPagarPorCuentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_pre_impreso_factura");
				}

				this.numero_pre_impreso_factura=newnumero_pre_impreso_factura;
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
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
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
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna base_imponible");
					}
				}

				this.base_imponible=newbase_imponible;
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
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero(String newnumero)throws Exception
	{
		try {
			if(this.numero!=newnumero) {
				if(newnumero==null) {
					//newnumero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna numero");
					}
				}

				if(newnumero!=null&&newnumero.length()>50) {
					newnumero=newnumero.substring(0,48);
					System.out.println("RetencionesPorPagarPorCuentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero");
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_benef(String newnombre_benef)throws Exception
	{
		try {
			if(this.nombre_benef!=newnombre_benef) {
				if(newnombre_benef==null) {
					//newnombre_benef="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna nombre_benef");
					}
				}

				if(newnombre_benef!=null&&newnombre_benef.length()>150) {
					newnombre_benef=newnombre_benef.substring(0,148);
					System.out.println("RetencionesPorPagarPorCuentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_benef");
				}

				this.nombre_benef=newnombre_benef;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc_benef(String newruc_benef)throws Exception
	{
		try {
			if(this.ruc_benef!=newruc_benef) {
				if(newruc_benef==null) {
					//newruc_benef="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna ruc_benef");
					}
				}

				if(newruc_benef!=null&&newruc_benef.length()>15) {
					newruc_benef=newruc_benef.substring(0,13);
					System.out.println("RetencionesPorPagarPorCuentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna ruc_benef");
				}

				this.ruc_benef=newruc_benef;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_cuenta_contable(String newnombre_cuenta_contable)throws Exception
	{
		try {
			if(this.nombre_cuenta_contable!=newnombre_cuenta_contable) {
				if(newnombre_cuenta_contable==null) {
					//newnombre_cuenta_contable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna nombre_cuenta_contable");
					}
				}

				if(newnombre_cuenta_contable!=null&&newnombre_cuenta_contable.length()>150) {
					newnombre_cuenta_contable=newnombre_cuenta_contable.substring(0,148);
					System.out.println("RetencionesPorPagarPorCuentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cuenta_contable");
				}

				this.nombre_cuenta_contable=newnombre_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_cuenta_contable_credito(String newnombre_cuenta_contable_credito)throws Exception
	{
		try {
			if(this.nombre_cuenta_contable_credito!=newnombre_cuenta_contable_credito) {
				if(newnombre_cuenta_contable_credito==null) {
					//newnombre_cuenta_contable_credito="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna nombre_cuenta_contable_credito");
					}
				}

				if(newnombre_cuenta_contable_credito!=null&&newnombre_cuenta_contable_credito.length()>150) {
					newnombre_cuenta_contable_credito=newnombre_cuenta_contable_credito.substring(0,148);
					System.out.println("RetencionesPorPagarPorCuentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cuenta_contable_credito");
				}

				this.nombre_cuenta_contable_credito=newnombre_cuenta_contable_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_debito_dato(Boolean newes_debito_dato)throws Exception
	{
		try {
			if(this.es_debito_dato!=newes_debito_dato) {
				if(newes_debito_dato==null) {
					//newes_debito_dato=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RetencionesPorPagarPorCuentas:Valor nulo no permitido en columna es_debito_dato");
					}
				}

				this.es_debito_dato=newes_debito_dato;
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

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public TipoRetencion getTipoRetencion() {
		return this.tiporetencion;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
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


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
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


	public  void  settiporetencion_descripcion(String tiporetencion_descripcion) {
		try {
			this.tiporetencion_descripcion=tiporetencion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_tipo_retencion_descripcion="";String es_debito_descripcion="";String es_debito_dato_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_tipo_retencion_descripcion() {
		return id_tipo_retencion_descripcion;
	}
	public String getes_debito_descripcion() {
		return es_debito_descripcion;
	}
	public String getes_debito_dato_descripcion() {
		return es_debito_dato_descripcion;
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
	public void setes_debito_dato_descripcion(String newes_debito_dato_descripcion)throws Exception {
		try {
			this.es_debito_dato_descripcion=newes_debito_dato_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_tipo_retencion_descripcion="";this.es_debito_descripcion="";this.es_debito_dato_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

