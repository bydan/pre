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
//import com.bydan.erp.contabilidad.util.SecuencialConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class Secuencial extends SecuencialAdditional implements Serializable ,Cloneable {//SecuencialAdditional,GeneralEntity
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
	
	private Secuencial secuencialOriginal;
	
	private Map<String, Object> mapSecuencial;
			
	public Map<String, Object> getMapSecuencial() {
		return mapSecuencial;
	}

	public void setMapSecuencial(Map<String, Object> mapSecuencial) {
		this.mapSecuencial = mapSecuencial;
	}
	
	public void inicializarMapSecuencial() {
		this.mapSecuencial = new HashMap<String,Object>();
	}
	
	public void setMapSecuencialValue(String sKey,Object oValue) {
		this.mapSecuencial.put(sKey, oValue);
	}
	
	public Object getMapSecuencialValue(String sKey) {
		return this.mapSecuencial.get(sKey);
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
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long numero_asiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long numero_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long numero_egreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long numero_diario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long numero_retencion_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long numero_retencion_fuente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SecuencialConstantesFunciones.SREGEXNUMERO_ASIENTO_FORMATO,message=SecuencialConstantesFunciones.SMENSAJEREGEXNUMERO_ASIENTO_FORMATO)
	private String numero_asiento_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SecuencialConstantesFunciones.SREGEXNUMERO_INGRESO_FORMATO,message=SecuencialConstantesFunciones.SMENSAJEREGEXNUMERO_INGRESO_FORMATO)
	private String numero_ingreso_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SecuencialConstantesFunciones.SREGEXNUMERO_EGRESO_FORMATO,message=SecuencialConstantesFunciones.SMENSAJEREGEXNUMERO_EGRESO_FORMATO)
	private String numero_egreso_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SecuencialConstantesFunciones.SREGEXNUMERO_DIARIO_FORMATO,message=SecuencialConstantesFunciones.SMENSAJEREGEXNUMERO_DIARIO_FORMATO)
	private String numero_diario_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SecuencialConstantesFunciones.SREGEXNUMERO_RETENCION_FUENTE_FORMATO,message=SecuencialConstantesFunciones.SMENSAJEREGEXNUMERO_RETENCION_FUENTE_FORMATO)
	private String numero_retencion_fuente_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SecuencialConstantesFunciones.SREGEXNUMERO_RETENCION_IVA_FORMATO,message=SecuencialConstantesFunciones.SMENSAJEREGEXNUMERO_RETENCION_IVA_FORMATO)
	private String numero_retencion_iva_formato;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Anio anio;
	public Mes mes;
	public Modulo modulo;
	public TipoMovimientoModulo tipomovimientomodulo;
	public TipoDocumento tipodocumento;
	public TipoMovimiento tipomovimiento;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	private String modulo_descripcion;
	private String tipomovimientomodulo_descripcion;
	private String tipodocumento_descripcion;
	private String tipomovimiento_descripcion;
	
	
		
	public Secuencial () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.secuencialOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.id_modulo=-1L;
 		this.id_tipo_movimiento_modulo=-1L;
 		this.id_tipo_documento=-1L;
 		this.id_tipo_movimiento=-1L;
 		this.numero_asiento=0L;
 		this.numero_ingreso=0L;
 		this.numero_egreso=0L;
 		this.numero_diario=0L;
 		this.numero_retencion_iva=0L;
 		this.numero_retencion_fuente=0L;
 		this.numero_asiento_formato="";
 		this.numero_ingreso_formato="";
 		this.numero_egreso_formato="";
 		this.numero_diario_formato="";
 		this.numero_retencion_fuente_formato="";
 		this.numero_retencion_iva_formato="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.anio=null;
		this.mes=null;
		this.modulo=null;
		this.tipomovimientomodulo=null;
		this.tipodocumento=null;
		this.tipomovimiento=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.modulo_descripcion="";
		this.tipomovimientomodulo_descripcion="";
		this.tipodocumento_descripcion="";
		this.tipomovimiento_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Secuencial (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_modulo,Long id_tipo_movimiento_modulo,Long id_tipo_documento,Long id_tipo_movimiento,Long numero_asiento,Long numero_ingreso,Long numero_egreso,Long numero_diario,Long numero_retencion_iva,Long numero_retencion_fuente,String numero_asiento_formato,String numero_ingreso_formato,String numero_egreso_formato,String numero_diario_formato,String numero_retencion_fuente_formato,String numero_retencion_iva_formato) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.secuencialOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_modulo=id_modulo;
 		this.id_tipo_movimiento_modulo=id_tipo_movimiento_modulo;
 		this.id_tipo_documento=id_tipo_documento;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.numero_asiento=numero_asiento;
 		this.numero_ingreso=numero_ingreso;
 		this.numero_egreso=numero_egreso;
 		this.numero_diario=numero_diario;
 		this.numero_retencion_iva=numero_retencion_iva;
 		this.numero_retencion_fuente=numero_retencion_fuente;
 		this.numero_asiento_formato=numero_asiento_formato;
 		this.numero_ingreso_formato=numero_ingreso_formato;
 		this.numero_egreso_formato=numero_egreso_formato;
 		this.numero_diario_formato=numero_diario_formato;
 		this.numero_retencion_fuente_formato=numero_retencion_fuente_formato;
 		this.numero_retencion_iva_formato=numero_retencion_iva_formato;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Secuencial (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_modulo,Long id_tipo_movimiento_modulo,Long id_tipo_documento,Long id_tipo_movimiento,Long numero_asiento,Long numero_ingreso,Long numero_egreso,Long numero_diario,Long numero_retencion_iva,Long numero_retencion_fuente,String numero_asiento_formato,String numero_ingreso_formato,String numero_egreso_formato,String numero_diario_formato,String numero_retencion_fuente_formato,String numero_retencion_iva_formato) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.secuencialOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_modulo=id_modulo;
 		this.id_tipo_movimiento_modulo=id_tipo_movimiento_modulo;
 		this.id_tipo_documento=id_tipo_documento;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.numero_asiento=numero_asiento;
 		this.numero_ingreso=numero_ingreso;
 		this.numero_egreso=numero_egreso;
 		this.numero_diario=numero_diario;
 		this.numero_retencion_iva=numero_retencion_iva;
 		this.numero_retencion_fuente=numero_retencion_fuente;
 		this.numero_asiento_formato=numero_asiento_formato;
 		this.numero_ingreso_formato=numero_ingreso_formato;
 		this.numero_egreso_formato=numero_egreso_formato;
 		this.numero_diario_formato=numero_diario_formato;
 		this.numero_retencion_fuente_formato=numero_retencion_fuente_formato;
 		this.numero_retencion_iva_formato=numero_retencion_iva_formato;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Secuencial secuencialLocal=null;
		
		if(object!=null) {
			secuencialLocal=(Secuencial)object;
			
			if(secuencialLocal!=null) {
				if(this.getId()!=null && secuencialLocal.getId()!=null) {
					if(this.getId().equals(secuencialLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!SecuencialConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=SecuencialConstantesFunciones.getSecuencialDescripcion(this);
		} else {
			sDetalle=SecuencialConstantesFunciones.getSecuencialDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Secuencial getSecuencialOriginal() {
		return this.secuencialOriginal;
	}
	
	public void setSecuencialOriginal(Secuencial secuencial) {
		try {
			this.secuencialOriginal=secuencial;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected SecuencialAdditional secuencialAdditional=null;
	
	public SecuencialAdditional getSecuencialAdditional() {
		return this.secuencialAdditional;
	}
	
	public void setSecuencialAdditional(SecuencialAdditional secuencialAdditional) {
		try {
			this.secuencialAdditional=secuencialAdditional;
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
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_tipo_movimiento_modulo() {
		return this.id_tipo_movimiento_modulo;
	}
    
	
	public Long getid_tipo_documento() {
		return this.id_tipo_documento;
	}
    
	
	public Long getid_tipo_movimiento() {
		return this.id_tipo_movimiento;
	}
    
	
	public Long getnumero_asiento() {
		return this.numero_asiento;
	}
    
	
	public Long getnumero_ingreso() {
		return this.numero_ingreso;
	}
    
	
	public Long getnumero_egreso() {
		return this.numero_egreso;
	}
    
	
	public Long getnumero_diario() {
		return this.numero_diario;
	}
    
	
	public Long getnumero_retencion_iva() {
		return this.numero_retencion_iva;
	}
    
	
	public Long getnumero_retencion_fuente() {
		return this.numero_retencion_fuente;
	}
    
	
	public String getnumero_asiento_formato() {
		return this.numero_asiento_formato;
	}
    
	
	public String getnumero_ingreso_formato() {
		return this.numero_ingreso_formato;
	}
    
	
	public String getnumero_egreso_formato() {
		return this.numero_egreso_formato;
	}
    
	
	public String getnumero_diario_formato() {
		return this.numero_diario_formato;
	}
    
	
	public String getnumero_retencion_fuente_formato() {
		return this.numero_retencion_fuente_formato;
	}
    
	
	public String getnumero_retencion_iva_formato() {
		return this.numero_retencion_iva_formato;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Secuencial:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("Secuencial:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("Secuencial:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
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
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_movimiento_modulo(Long newid_tipo_movimiento_modulo)throws Exception
	{
		try {
			if(this.id_tipo_movimiento_modulo!=newid_tipo_movimiento_modulo) {
				if(newid_tipo_movimiento_modulo==null) {
					//newid_tipo_movimiento_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna id_tipo_movimiento_modulo");
					}
				}

				this.id_tipo_movimiento_modulo=newid_tipo_movimiento_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_documento(Long newid_tipo_documento)throws Exception
	{
		try {
			if(this.id_tipo_documento!=newid_tipo_documento) {
				if(newid_tipo_documento==null) {
					//newid_tipo_documento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna id_tipo_documento");
					}
				}

				this.id_tipo_documento=newid_tipo_documento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_movimiento(Long newid_tipo_movimiento)throws Exception
	{
		try {
			if(this.id_tipo_movimiento!=newid_tipo_movimiento) {
				if(newid_tipo_movimiento==null) {
					//newid_tipo_movimiento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna id_tipo_movimiento");
					}
				}

				this.id_tipo_movimiento=newid_tipo_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_asiento(Long newnumero_asiento)throws Exception
	{
		try {
			if(this.numero_asiento!=newnumero_asiento) {
				if(newnumero_asiento==null) {
					//newnumero_asiento=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna numero_asiento");
					}
				}

				this.numero_asiento=newnumero_asiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_ingreso(Long newnumero_ingreso)throws Exception
	{
		try {
			if(this.numero_ingreso!=newnumero_ingreso) {
				if(newnumero_ingreso==null) {
					//newnumero_ingreso=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna numero_ingreso");
					}
				}

				this.numero_ingreso=newnumero_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_egreso(Long newnumero_egreso)throws Exception
	{
		try {
			if(this.numero_egreso!=newnumero_egreso) {
				if(newnumero_egreso==null) {
					//newnumero_egreso=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna numero_egreso");
					}
				}

				this.numero_egreso=newnumero_egreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_diario(Long newnumero_diario)throws Exception
	{
		try {
			if(this.numero_diario!=newnumero_diario) {
				if(newnumero_diario==null) {
					//newnumero_diario=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna numero_diario");
					}
				}

				this.numero_diario=newnumero_diario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_retencion_iva(Long newnumero_retencion_iva)throws Exception
	{
		try {
			if(this.numero_retencion_iva!=newnumero_retencion_iva) {
				if(newnumero_retencion_iva==null) {
					//newnumero_retencion_iva=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna numero_retencion_iva");
					}
				}

				this.numero_retencion_iva=newnumero_retencion_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_retencion_fuente(Long newnumero_retencion_fuente)throws Exception
	{
		try {
			if(this.numero_retencion_fuente!=newnumero_retencion_fuente) {
				if(newnumero_retencion_fuente==null) {
					//newnumero_retencion_fuente=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna numero_retencion_fuente");
					}
				}

				this.numero_retencion_fuente=newnumero_retencion_fuente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_asiento_formato(String newnumero_asiento_formato)throws Exception
	{
		try {
			if(this.numero_asiento_formato!=newnumero_asiento_formato) {
				if(newnumero_asiento_formato==null) {
					//newnumero_asiento_formato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna numero_asiento_formato");
					}
				}

				if(newnumero_asiento_formato!=null&&newnumero_asiento_formato.length()>50) {
					newnumero_asiento_formato=newnumero_asiento_formato.substring(0,48);
					System.out.println("Secuencial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_asiento_formato");
				}

				this.numero_asiento_formato=newnumero_asiento_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_ingreso_formato(String newnumero_ingreso_formato)throws Exception
	{
		try {
			if(this.numero_ingreso_formato!=newnumero_ingreso_formato) {
				if(newnumero_ingreso_formato==null) {
					//newnumero_ingreso_formato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna numero_ingreso_formato");
					}
				}

				if(newnumero_ingreso_formato!=null&&newnumero_ingreso_formato.length()>20) {
					newnumero_ingreso_formato=newnumero_ingreso_formato.substring(0,18);
					System.out.println("Secuencial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_ingreso_formato");
				}

				this.numero_ingreso_formato=newnumero_ingreso_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_egreso_formato(String newnumero_egreso_formato)throws Exception
	{
		try {
			if(this.numero_egreso_formato!=newnumero_egreso_formato) {
				if(newnumero_egreso_formato==null) {
					//newnumero_egreso_formato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna numero_egreso_formato");
					}
				}

				if(newnumero_egreso_formato!=null&&newnumero_egreso_formato.length()>20) {
					newnumero_egreso_formato=newnumero_egreso_formato.substring(0,18);
					System.out.println("Secuencial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_egreso_formato");
				}

				this.numero_egreso_formato=newnumero_egreso_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_diario_formato(String newnumero_diario_formato)throws Exception
	{
		try {
			if(this.numero_diario_formato!=newnumero_diario_formato) {
				if(newnumero_diario_formato==null) {
					//newnumero_diario_formato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna numero_diario_formato");
					}
				}

				if(newnumero_diario_formato!=null&&newnumero_diario_formato.length()>20) {
					newnumero_diario_formato=newnumero_diario_formato.substring(0,18);
					System.out.println("Secuencial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_diario_formato");
				}

				this.numero_diario_formato=newnumero_diario_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_retencion_fuente_formato(String newnumero_retencion_fuente_formato)throws Exception
	{
		try {
			if(this.numero_retencion_fuente_formato!=newnumero_retencion_fuente_formato) {
				if(newnumero_retencion_fuente_formato==null) {
					//newnumero_retencion_fuente_formato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna numero_retencion_fuente_formato");
					}
				}

				if(newnumero_retencion_fuente_formato!=null&&newnumero_retencion_fuente_formato.length()>20) {
					newnumero_retencion_fuente_formato=newnumero_retencion_fuente_formato.substring(0,18);
					System.out.println("Secuencial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_retencion_fuente_formato");
				}

				this.numero_retencion_fuente_formato=newnumero_retencion_fuente_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_retencion_iva_formato(String newnumero_retencion_iva_formato)throws Exception
	{
		try {
			if(this.numero_retencion_iva_formato!=newnumero_retencion_iva_formato) {
				if(newnumero_retencion_iva_formato==null) {
					//newnumero_retencion_iva_formato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Secuencial:Valor nulo no permitido en columna numero_retencion_iva_formato");
					}
				}

				if(newnumero_retencion_iva_formato!=null&&newnumero_retencion_iva_formato.length()>20) {
					newnumero_retencion_iva_formato=newnumero_retencion_iva_formato.substring(0,18);
					System.out.println("Secuencial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_retencion_iva_formato");
				}

				this.numero_retencion_iva_formato=newnumero_retencion_iva_formato;
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

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public TipoMovimientoModulo getTipoMovimientoModulo() {
		return this.tipomovimientomodulo;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipodocumento;
	}

	public TipoMovimiento getTipoMovimiento() {
		return this.tipomovimiento;
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

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String gettipomovimientomodulo_descripcion() {
		return this.tipomovimientomodulo_descripcion;
	}

	public String gettipodocumento_descripcion() {
		return this.tipodocumento_descripcion;
	}

	public String gettipomovimiento_descripcion() {
		return this.tipomovimiento_descripcion;
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


	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoMovimientoModulo(TipoMovimientoModulo tipomovimientomodulo) {
		try {
			this.tipomovimientomodulo=tipomovimientomodulo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoDocumento(TipoDocumento tipodocumento) {
		try {
			this.tipodocumento=tipodocumento;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoMovimiento(TipoMovimiento tipomovimiento) {
		try {
			this.tipomovimiento=tipomovimiento;
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


	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipomovimientomodulo_descripcion(String tipomovimientomodulo_descripcion) {
		try {
			this.tipomovimientomodulo_descripcion=tipomovimientomodulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipodocumento_descripcion(String tipodocumento_descripcion) {
		try {
			this.tipodocumento_descripcion=tipodocumento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipomovimiento_descripcion(String tipomovimiento_descripcion) {
		try {
			this.tipomovimiento_descripcion=tipomovimiento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_modulo_descripcion="";String id_tipo_movimiento_modulo_descripcion="";String id_tipo_documento_descripcion="";String id_tipo_movimiento_descripcion="";
	
	
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
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_tipo_movimiento_modulo_descripcion() {
		return id_tipo_movimiento_modulo_descripcion;
	}
	public String getid_tipo_documento_descripcion() {
		return id_tipo_documento_descripcion;
	}
	public String getid_tipo_movimiento_descripcion() {
		return id_tipo_movimiento_descripcion;
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
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_movimiento_modulo_descripcion(String newid_tipo_movimiento_modulo_descripcion)throws Exception {
		try {
			this.id_tipo_movimiento_modulo_descripcion=newid_tipo_movimiento_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_documento_descripcion(String newid_tipo_documento_descripcion)throws Exception {
		try {
			this.id_tipo_documento_descripcion=newid_tipo_documento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_movimiento_descripcion(String newid_tipo_movimiento_descripcion)throws Exception {
		try {
			this.id_tipo_movimiento_descripcion=newid_tipo_movimiento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_modulo_descripcion="";this.id_tipo_movimiento_modulo_descripcion="";this.id_tipo_documento_descripcion="";this.id_tipo_movimiento_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

