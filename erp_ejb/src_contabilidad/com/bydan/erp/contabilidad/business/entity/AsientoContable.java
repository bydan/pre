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
//import com.bydan.erp.contabilidad.util.AsientoContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class AsientoContable extends AsientoContableAdditional implements Serializable ,Cloneable {//AsientoContableAdditional,GeneralEntity
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
	
	private AsientoContable asientocontableOriginal;
	
	private Map<String, Object> mapAsientoContable;
			
	public Map<String, Object> getMapAsientoContable() {
		return mapAsientoContable;
	}

	public void setMapAsientoContable(Map<String, Object> mapAsientoContable) {
		this.mapAsientoContable = mapAsientoContable;
	}
	
	public void inicializarMapAsientoContable() {
		this.mapAsientoContable = new HashMap<String,Object>();
	}
	
	public void setMapAsientoContableValue(String sKey,Object oValue) {
		this.mapAsientoContable.put(sKey, oValue);
	}
	
	public Object getMapAsientoContableValue(String sKey) {
		return this.mapAsientoContable.get(sKey);
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
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=AsientoContableConstantesFunciones.SREGEXCODIGO,message=AsientoContableConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=AsientoContableConstantesFunciones.SREGEXNUMERO_MAYOR,message=AsientoContableConstantesFunciones.SMENSAJEREGEXNUMERO_MAYOR)
	private String numero_mayor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=AsientoContableConstantesFunciones.SREGEXNUMERO_RETENCION,message=AsientoContableConstantesFunciones.SMENSAJEREGEXNUMERO_RETENCION)
	private String numero_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_retencion_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=AsientoContableConstantesFunciones.SREGEXNUMERO_RETENCION_IVA,message=AsientoContableConstantesFunciones.SMENSAJEREGEXNUMERO_RETENCION_IVA)
	private String numero_retencion_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cotizacion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_descripcion_asiento;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=AsientoContableConstantesFunciones.SREGEXBENEFICIARIO,message=AsientoContableConstantesFunciones.SMENSAJEREGEXBENEFICIARIO)
	private String beneficiario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=AsientoContableConstantesFunciones.SREGEXDESCRIPCION,message=AsientoContableConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_finalizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento_modulo;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Anio anio;
	public Mes mes;
	public Modulo modulo;
	public Usuario usuario;
	public TipoDocumento tipodocumento;
	public TipoMovimiento tipomovimiento;
	public Moneda moneda;
	public Cliente cliente;
	public TipoDescripcionAsiento tipodescripcionasiento;
	public Formato formato;
	public EstadoAsientoContable estadoasientocontable;
	public TipoMovimientoModulo tipomovimientomodulo;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	private String modulo_descripcion;
	private String usuario_descripcion;
	private String tipodocumento_descripcion;
	private String tipomovimiento_descripcion;
	private String moneda_descripcion;
	private String cliente_descripcion;
	private String tipodescripcionasiento_descripcion;
	private String formato_descripcion;
	private String estadoasientocontable_descripcion;
	private String tipomovimientomodulo_descripcion;
	
	
	public List<Sri> sris;
	public List<ImportarExportar> importarexportars;
	public List<DetalleMoviClienProve> detallemoviclienproves;
	public List<Prestamo> prestamos;
	public List<DetalleAsientoContable> detalleasientocontables;
	public List<Retencion> retencions;
		
	public AsientoContable () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.asientocontableOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.id_modulo=-1L;
 		this.id_usuario=-1L;
 		this.id_tipo_documento=-1L;
 		this.codigo="";
 		this.fecha=new Date();
 		this.id_tipo_movimiento=-1L;
 		this.numero_mayor="";
 		this.id_moneda=-1L;
 		this.es_retencion=false;
 		this.numero_retencion="";
 		this.valor=0.0;
 		this.es_retencion_iva=false;
 		this.numero_retencion_iva="";
 		this.cotizacion=0.0;
 		this.id_cliente=null;
 		this.id_tipo_descripcion_asiento=-1L;
 		this.id_formato=null;
 		this.beneficiario="";
 		this.descripcion="";
 		this.fecha_emision=new Date();
 		this.fecha_finalizacion=new Date();
 		this.id_estado_asiento_contable=1L;
 		this.id_tipo_movimiento_modulo=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.anio=null;
		this.mes=null;
		this.modulo=null;
		this.usuario=null;
		this.tipodocumento=null;
		this.tipomovimiento=null;
		this.moneda=null;
		this.cliente=null;
		this.tipodescripcionasiento=null;
		this.formato=null;
		this.estadoasientocontable=null;
		this.tipomovimientomodulo=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.modulo_descripcion="";
		this.usuario_descripcion="";
		this.tipodocumento_descripcion="";
		this.tipomovimiento_descripcion="";
		this.moneda_descripcion="";
		this.cliente_descripcion="";
		this.tipodescripcionasiento_descripcion="";
		this.formato_descripcion="";
		this.estadoasientocontable_descripcion="";
		this.tipomovimientomodulo_descripcion="";
		
		
		this.sris=null;
		this.importarexportars=null;
		this.detallemoviclienproves=null;
		this.prestamos=null;
		this.detalleasientocontables=null;
		this.retencions=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public AsientoContable (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_modulo,Long id_usuario,Long id_tipo_documento,String codigo,Date fecha,Long id_tipo_movimiento,String numero_mayor,Long id_moneda,Boolean es_retencion,String numero_retencion,Double valor,Boolean es_retencion_iva,String numero_retencion_iva,Double cotizacion,Long id_cliente,Long id_tipo_descripcion_asiento,Long id_formato,String beneficiario,String descripcion,Date fecha_emision,Date fecha_finalizacion,Long id_estado_asiento_contable,Long id_tipo_movimiento_modulo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.asientocontableOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_modulo=id_modulo;
 		this.id_usuario=id_usuario;
 		this.id_tipo_documento=id_tipo_documento;
 		this.codigo=codigo;
 		this.fecha=fecha;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.numero_mayor=numero_mayor;
 		this.id_moneda=id_moneda;
 		this.es_retencion=es_retencion;
 		this.numero_retencion=numero_retencion;
 		this.valor=valor;
 		this.es_retencion_iva=es_retencion_iva;
 		this.numero_retencion_iva=numero_retencion_iva;
 		this.cotizacion=cotizacion;
 		this.id_cliente=id_cliente;
 		this.id_tipo_descripcion_asiento=id_tipo_descripcion_asiento;
 		this.id_formato=id_formato;
 		this.beneficiario=beneficiario;
 		this.descripcion=descripcion;
 		this.fecha_emision=fecha_emision;
 		this.fecha_finalizacion=fecha_finalizacion;
 		this.id_estado_asiento_contable=id_estado_asiento_contable;
 		this.id_tipo_movimiento_modulo=id_tipo_movimiento_modulo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public AsientoContable (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_modulo,Long id_usuario,Long id_tipo_documento,String codigo,Date fecha,Long id_tipo_movimiento,String numero_mayor,Long id_moneda,Boolean es_retencion,String numero_retencion,Double valor,Boolean es_retencion_iva,String numero_retencion_iva,Double cotizacion,Long id_cliente,Long id_tipo_descripcion_asiento,Long id_formato,String beneficiario,String descripcion,Date fecha_emision,Date fecha_finalizacion,Long id_estado_asiento_contable,Long id_tipo_movimiento_modulo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.asientocontableOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_modulo=id_modulo;
 		this.id_usuario=id_usuario;
 		this.id_tipo_documento=id_tipo_documento;
 		this.codigo=codigo;
 		this.fecha=fecha;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.numero_mayor=numero_mayor;
 		this.id_moneda=id_moneda;
 		this.es_retencion=es_retencion;
 		this.numero_retencion=numero_retencion;
 		this.valor=valor;
 		this.es_retencion_iva=es_retencion_iva;
 		this.numero_retencion_iva=numero_retencion_iva;
 		this.cotizacion=cotizacion;
 		this.id_cliente=id_cliente;
 		this.id_tipo_descripcion_asiento=id_tipo_descripcion_asiento;
 		this.id_formato=id_formato;
 		this.beneficiario=beneficiario;
 		this.descripcion=descripcion;
 		this.fecha_emision=fecha_emision;
 		this.fecha_finalizacion=fecha_finalizacion;
 		this.id_estado_asiento_contable=id_estado_asiento_contable;
 		this.id_tipo_movimiento_modulo=id_tipo_movimiento_modulo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		AsientoContable asientocontableLocal=null;
		
		if(object!=null) {
			asientocontableLocal=(AsientoContable)object;
			
			if(asientocontableLocal!=null) {
				if(this.getId()!=null && asientocontableLocal.getId()!=null) {
					if(this.getId().equals(asientocontableLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!AsientoContableConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=AsientoContableConstantesFunciones.getAsientoContableDescripcion(this);
		} else {
			sDetalle=AsientoContableConstantesFunciones.getAsientoContableDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public AsientoContable getAsientoContableOriginal() {
		return this.asientocontableOriginal;
	}
	
	public void setAsientoContableOriginal(AsientoContable asientocontable) {
		try {
			this.asientocontableOriginal=asientocontable;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected AsientoContableAdditional asientocontableAdditional=null;
	
	public AsientoContableAdditional getAsientoContableAdditional() {
		return this.asientocontableAdditional;
	}
	
	public void setAsientoContableAdditional(AsientoContableAdditional asientocontableAdditional) {
		try {
			this.asientocontableAdditional=asientocontableAdditional;
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
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public Long getid_tipo_documento() {
		return this.id_tipo_documento;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Long getid_tipo_movimiento() {
		return this.id_tipo_movimiento;
	}
    
	
	public String getnumero_mayor() {
		return this.numero_mayor;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public Boolean getes_retencion() {
		return this.es_retencion;
	}
    
	
	public String getnumero_retencion() {
		return this.numero_retencion;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Boolean getes_retencion_iva() {
		return this.es_retencion_iva;
	}
    
	
	public String getnumero_retencion_iva() {
		return this.numero_retencion_iva;
	}
    
	
	public Double getcotizacion() {
		return this.cotizacion;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_tipo_descripcion_asiento() {
		return this.id_tipo_descripcion_asiento;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public String getbeneficiario() {
		return this.beneficiario;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_finalizacion() {
		return this.fecha_finalizacion;
	}
    
	
	public Long getid_estado_asiento_contable() {
		return this.id_estado_asiento_contable;
	}
    
	
	public Long getid_tipo_movimiento_modulo() {
		return this.id_tipo_movimiento_modulo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsientoContable:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("AsientoContable:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("AsientoContable:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("AsientoContable:Valor nulo no permitido en columna id_periodo");
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
						System.out.println("AsientoContable:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(this.id_usuario!=newid_usuario) {
				if(newid_usuario==null) {
					//newid_usuario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsientoContable:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
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
						System.out.println("AsientoContable:Valor nulo no permitido en columna id_tipo_documento");
					}
				}

				this.id_tipo_documento=newid_tipo_documento;
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
						System.out.println("AsientoContable:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("AsientoContable:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsientoContable:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("AsientoContable:Valor nulo no permitido en columna id_tipo_movimiento");
					}
				}

				this.id_tipo_movimiento=newid_tipo_movimiento;
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
						System.out.println("AsientoContable:Valor nulo no permitido en columna numero_mayor");
					}
				}

				if(newnumero_mayor!=null&&newnumero_mayor.length()>100) {
					newnumero_mayor=newnumero_mayor.substring(0,98);
					System.out.println("AsientoContable:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna numero_mayor");
				}

				this.numero_mayor=newnumero_mayor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_moneda(Long newid_moneda)throws Exception
	{
		try {
			if(this.id_moneda!=newid_moneda) {
				if(newid_moneda==null) {
					//newid_moneda=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsientoContable:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_retencion(Boolean newes_retencion)throws Exception
	{
		try {
			if(this.es_retencion!=newes_retencion) {
				if(newes_retencion==null) {
					//newes_retencion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsientoContable:Valor nulo no permitido en columna es_retencion");
					}
				}

				this.es_retencion=newes_retencion;
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
						System.out.println("AsientoContable:Valor nulo no permitido en columna numero_retencion");
					}
				}

				if(newnumero_retencion!=null&&newnumero_retencion.length()>50) {
					newnumero_retencion=newnumero_retencion.substring(0,48);
					System.out.println("AsientoContable:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_retencion");
				}

				this.numero_retencion=newnumero_retencion;
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
						System.out.println("AsientoContable:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_retencion_iva(Boolean newes_retencion_iva)throws Exception
	{
		try {
			if(this.es_retencion_iva!=newes_retencion_iva) {
				if(newes_retencion_iva==null) {
					//newes_retencion_iva=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsientoContable:Valor nulo no permitido en columna es_retencion_iva");
					}
				}

				this.es_retencion_iva=newes_retencion_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_retencion_iva(String newnumero_retencion_iva)throws Exception
	{
		try {
			if(this.numero_retencion_iva!=newnumero_retencion_iva) {
				if(newnumero_retencion_iva==null) {
					//newnumero_retencion_iva="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsientoContable:Valor nulo no permitido en columna numero_retencion_iva");
					}
				}

				if(newnumero_retencion_iva!=null&&newnumero_retencion_iva.length()>50) {
					newnumero_retencion_iva=newnumero_retencion_iva.substring(0,48);
					System.out.println("AsientoContable:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_retencion_iva");
				}

				this.numero_retencion_iva=newnumero_retencion_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcotizacion(Double newcotizacion)throws Exception
	{
		try {
			if(this.cotizacion!=newcotizacion) {
				if(newcotizacion==null) {
					//newcotizacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsientoContable:Valor nulo no permitido en columna cotizacion");
					}
				}

				this.cotizacion=newcotizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente) {
		if(this.id_cliente==null&&newid_cliente!=null) {
			this.id_cliente=newid_cliente;
				this.setIsChanged(true);
		}

		if(this.id_cliente!=null&&!this.id_cliente.equals(newid_cliente)) {

			this.id_cliente=newid_cliente;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_descripcion_asiento(Long newid_tipo_descripcion_asiento)throws Exception
	{
		try {
			if(this.id_tipo_descripcion_asiento!=newid_tipo_descripcion_asiento) {
				if(newid_tipo_descripcion_asiento==null) {
					//newid_tipo_descripcion_asiento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsientoContable:Valor nulo no permitido en columna id_tipo_descripcion_asiento");
					}
				}

				this.id_tipo_descripcion_asiento=newid_tipo_descripcion_asiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato(Long newid_formato) {
		if(this.id_formato==null&&newid_formato!=null) {
			this.id_formato=newid_formato;
				this.setIsChanged(true);
		}

		if(this.id_formato!=null&&!this.id_formato.equals(newid_formato)) {

			this.id_formato=newid_formato;
				this.setIsChanged(true);
		}
	}
    
	public void setbeneficiario(String newbeneficiario)throws Exception
	{
		try {
			if(this.beneficiario!=newbeneficiario) {
				if(newbeneficiario==null) {
					//newbeneficiario="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsientoContable:Valor nulo no permitido en columna beneficiario");
					}
				}

				if(newbeneficiario!=null&&newbeneficiario.length()>200) {
					newbeneficiario=newbeneficiario.substring(0,198);
					System.out.println("AsientoContable:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna beneficiario");
				}

				this.beneficiario=newbeneficiario;
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
						System.out.println("AsientoContable:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>250) {
					newdescripcion=newdescripcion.substring(0,248);
					System.out.println("AsientoContable:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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
						System.out.println("AsientoContable:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_finalizacion(Date newfecha_finalizacion)throws Exception
	{
		try {
			if(this.fecha_finalizacion!=newfecha_finalizacion) {
				if(newfecha_finalizacion==null) {
					//newfecha_finalizacion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsientoContable:Valor nulo no permitido en columna fecha_finalizacion");
					}
				}

				this.fecha_finalizacion=newfecha_finalizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_asiento_contable(Long newid_estado_asiento_contable)throws Exception
	{
		try {
			if(this.id_estado_asiento_contable!=newid_estado_asiento_contable) {
				if(newid_estado_asiento_contable==null) {
					//newid_estado_asiento_contable=1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsientoContable:Valor nulo no permitido en columna id_estado_asiento_contable");
					}
				}

				this.id_estado_asiento_contable=newid_estado_asiento_contable;
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
						System.out.println("AsientoContable:Valor nulo no permitido en columna id_tipo_movimiento_modulo");
					}
				}

				this.id_tipo_movimiento_modulo=newid_tipo_movimiento_modulo;
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipodocumento;
	}

	public TipoMovimiento getTipoMovimiento() {
		return this.tipomovimiento;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoDescripcionAsiento getTipoDescripcionAsiento() {
		return this.tipodescripcionasiento;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public EstadoAsientoContable getEstadoAsientoContable() {
		return this.estadoasientocontable;
	}

	public TipoMovimientoModulo getTipoMovimientoModulo() {
		return this.tipomovimientomodulo;
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

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String gettipodocumento_descripcion() {
		return this.tipodocumento_descripcion;
	}

	public String gettipomovimiento_descripcion() {
		return this.tipomovimiento_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipodescripcionasiento_descripcion() {
		return this.tipodescripcionasiento_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String getestadoasientocontable_descripcion() {
		return this.estadoasientocontable_descripcion;
	}

	public String gettipomovimientomodulo_descripcion() {
		return this.tipomovimientomodulo_descripcion;
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


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
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


	public  void  setMoneda(Moneda moneda) {
		try {
			this.moneda=moneda;
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


	public  void  setTipoDescripcionAsiento(TipoDescripcionAsiento tipodescripcionasiento) {
		try {
			this.tipodescripcionasiento=tipodescripcionasiento;
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


	public  void  setEstadoAsientoContable(EstadoAsientoContable estadoasientocontable) {
		try {
			this.estadoasientocontable=estadoasientocontable;
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


	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
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


	public  void  setmoneda_descripcion(String moneda_descripcion) {
		try {
			this.moneda_descripcion=moneda_descripcion;
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


	public  void  settipodescripcionasiento_descripcion(String tipodescripcionasiento_descripcion) {
		try {
			this.tipodescripcionasiento_descripcion=tipodescripcionasiento_descripcion;
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


	public  void  setestadoasientocontable_descripcion(String estadoasientocontable_descripcion) {
		try {
			this.estadoasientocontable_descripcion=estadoasientocontable_descripcion;
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


	
	
	public List<Sri> getSris() {
		return this.sris;
	}

	public List<ImportarExportar> getImportarExportars() {
		return this.importarexportars;
	}

	public List<DetalleMoviClienProve> getDetalleMoviClienProves() {
		return this.detallemoviclienproves;
	}

	public List<Prestamo> getPrestamos() {
		return this.prestamos;
	}

	public List<DetalleAsientoContable> getDetalleAsientoContables() {
		return this.detalleasientocontables;
	}

	public List<Retencion> getRetencions() {
		return this.retencions;
	}

	
	
	public  void  setSris(List<Sri> sris) {
		try {
			this.sris=sris;
		} catch(Exception e) {
			;
		}
	}

	public  void  setImportarExportars(List<ImportarExportar> importarexportars) {
		try {
			this.importarexportars=importarexportars;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetalleMoviClienProves(List<DetalleMoviClienProve> detallemoviclienproves) {
		try {
			this.detallemoviclienproves=detallemoviclienproves;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPrestamos(List<Prestamo> prestamos) {
		try {
			this.prestamos=prestamos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetalleAsientoContables(List<DetalleAsientoContable> detalleasientocontables) {
		try {
			this.detalleasientocontables=detalleasientocontables;
		} catch(Exception e) {
			;
		}
	}

	public  void  setRetencions(List<Retencion> retencions) {
		try {
			this.retencions=retencions;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_modulo_descripcion="";String id_usuario_descripcion="";String id_tipo_documento_descripcion="";String id_tipo_movimiento_descripcion="";String id_moneda_descripcion="";String es_retencion_descripcion="";String es_retencion_iva_descripcion="";String id_cliente_descripcion="";String id_tipo_descripcion_asiento_descripcion="";String id_formato_descripcion="";String id_estado_asiento_contable_descripcion="";String id_tipo_movimiento_modulo_descripcion="";
	
	
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
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	public String getid_tipo_documento_descripcion() {
		return id_tipo_documento_descripcion;
	}
	public String getid_tipo_movimiento_descripcion() {
		return id_tipo_movimiento_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getes_retencion_descripcion() {
		return es_retencion_descripcion;
	}
	public String getes_retencion_iva_descripcion() {
		return es_retencion_iva_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_tipo_descripcion_asiento_descripcion() {
		return id_tipo_descripcion_asiento_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getid_estado_asiento_contable_descripcion() {
		return id_estado_asiento_contable_descripcion;
	}
	public String getid_tipo_movimiento_modulo_descripcion() {
		return id_tipo_movimiento_modulo_descripcion;
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
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
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
	public void setid_moneda_descripcion(String newid_moneda_descripcion)throws Exception {
		try {
			this.id_moneda_descripcion=newid_moneda_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_retencion_descripcion(String newes_retencion_descripcion)throws Exception {
		try {
			this.es_retencion_descripcion=newes_retencion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_retencion_iva_descripcion(String newes_retencion_iva_descripcion)throws Exception {
		try {
			this.es_retencion_iva_descripcion=newes_retencion_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_descripcion_asiento_descripcion(String newid_tipo_descripcion_asiento_descripcion)throws Exception {
		try {
			this.id_tipo_descripcion_asiento_descripcion=newid_tipo_descripcion_asiento_descripcion;
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
	public void setid_estado_asiento_contable_descripcion(String newid_estado_asiento_contable_descripcion)throws Exception {
		try {
			this.id_estado_asiento_contable_descripcion=newid_estado_asiento_contable_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_modulo_descripcion="";this.id_usuario_descripcion="";this.id_tipo_documento_descripcion="";this.id_tipo_movimiento_descripcion="";this.id_moneda_descripcion="";this.es_retencion_descripcion="";this.es_retencion_iva_descripcion="";this.id_cliente_descripcion="";this.id_tipo_descripcion_asiento_descripcion="";this.id_formato_descripcion="";this.id_estado_asiento_contable_descripcion="";this.id_tipo_movimiento_modulo_descripcion="";
	}
	
	
	Object srisDescripcionReporte;
	Object importarexportarsDescripcionReporte;
	Object detallemoviclienprovesDescripcionReporte;
	Object prestamosDescripcionReporte;
	Object detalleasientocontablesDescripcionReporte;
	Object retencionsDescripcionReporte;
	
	
	public Object getsrisDescripcionReporte() {
		return srisDescripcionReporte;
	}

	public Object getimportarexportarsDescripcionReporte() {
		return importarexportarsDescripcionReporte;
	}

	public Object getdetallemoviclienprovesDescripcionReporte() {
		return detallemoviclienprovesDescripcionReporte;
	}

	public Object getprestamosDescripcionReporte() {
		return prestamosDescripcionReporte;
	}

	public Object getdetalleasientocontablesDescripcionReporte() {
		return detalleasientocontablesDescripcionReporte;
	}

	public Object getretencionsDescripcionReporte() {
		return retencionsDescripcionReporte;
	}

	
	
	public  void  setsrisDescripcionReporte(Object sris) {
		try {
			this.srisDescripcionReporte=sris;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setimportarexportarsDescripcionReporte(Object importarexportars) {
		try {
			this.importarexportarsDescripcionReporte=importarexportars;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallemoviclienprovesDescripcionReporte(Object detallemoviclienproves) {
		try {
			this.detallemoviclienprovesDescripcionReporte=detallemoviclienproves;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setprestamosDescripcionReporte(Object prestamos) {
		try {
			this.prestamosDescripcionReporte=prestamos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleasientocontablesDescripcionReporte(Object detalleasientocontables) {
		try {
			this.detalleasientocontablesDescripcionReporte=detalleasientocontables;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setretencionsDescripcionReporte(Object retencions) {
		try {
			this.retencionsDescripcionReporte=retencions;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

