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
package com.bydan.erp.puntoventa.business.entity;

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
//import com.bydan.erp.puntoventa.util.TarjetaCreditoConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class TarjetaCredito extends TarjetaCreditoAdditional implements Serializable ,Cloneable {//TarjetaCreditoAdditional,GeneralEntity
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
	
	private TarjetaCredito tarjetacreditoOriginal;
	
	private Map<String, Object> mapTarjetaCredito;
			
	public Map<String, Object> getMapTarjetaCredito() {
		return mapTarjetaCredito;
	}

	public void setMapTarjetaCredito(Map<String, Object> mapTarjetaCredito) {
		this.mapTarjetaCredito = mapTarjetaCredito;
	}
	
	public void inicializarMapTarjetaCredito() {
		this.mapTarjetaCredito = new HashMap<String,Object>();
	}
	
	public void setMapTarjetaCreditoValue(String sKey,Object oValue) {
		this.mapTarjetaCredito.put(sKey, oValue);
	}
	
	public Object getMapTarjetaCreditoValue(String sKey) {
		return this.mapTarjetaCredito.get(sKey);
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
	private Long id_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TarjetaCreditoConstantesFunciones.SREGEXCODIGO,message=TarjetaCreditoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TarjetaCreditoConstantesFunciones.SREGEXNOMBRE,message=TarjetaCreditoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TarjetaCreditoConstantesFunciones.SREGEXNOMBRE_CORTO,message=TarjetaCreditoConstantesFunciones.SMENSAJEREGEXNOMBRE_CORTO)
	private String nombre_corto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer digito_valido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer digito_tarjeta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double comision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double interes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_minimo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double comision_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_retencion_redondeo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_pago_banco_redondeo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_comision_redondeo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_comision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formula_pago_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_diferencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formula_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formula_comision;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Banco banco;
	public TipoRetencion tiporetencion;
	public CuentaContable cuentacontable;
	public TipoRetencionIva tiporetencioniva;
	public CuentaContable cuentacontablecomision;
	public Formula formulapagobanco;
	public CuentaContable cuentacontablediferencia;
	public Formula formularetencion;
	public Formula formulacomision;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String banco_descripcion;
	private String tiporetencion_descripcion;
	private String cuentacontable_descripcion;
	private String tiporetencioniva_descripcion;
	private String cuentacontablecomision_descripcion;
	private String formulapagobanco_descripcion;
	private String cuentacontablediferencia_descripcion;
	private String formularetencion_descripcion;
	private String formulacomision_descripcion;
	
	
	public List<TarjetaCreditoConexion> tarjetacreditoconexions;
	public List<TarjetaCreditoDescuento> tarjetacreditodescuentos;
	public List<FormaPagoPuntoVenta> formapagopuntoventas;
		
	public TarjetaCredito () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tarjetacreditoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_banco=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.nombre_corto="";
 		this.digito_valido=0;
 		this.digito_tarjeta=0;
 		this.comision=0.0;
 		this.interes=0.0;
 		this.monto_minimo=0.0;
 		this.porcentaje_retencion=0.0;
 		this.comision_retencion=0.0;
 		this.es_retencion_redondeo=false;
 		this.es_pago_banco_redondeo=false;
 		this.es_comision_redondeo=false;
 		this.id_tipo_retencion=-1L;
 		this.id_cuenta_contable=-1L;
 		this.id_tipo_retencion_iva=-1L;
 		this.id_cuenta_contable_comision=-1L;
 		this.id_formula_pago_banco=-1L;
 		this.id_cuenta_contable_diferencia=-1L;
 		this.id_formula_retencion=-1L;
 		this.id_formula_comision=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.banco=null;
		this.tiporetencion=null;
		this.cuentacontable=null;
		this.tiporetencioniva=null;
		this.cuentacontablecomision=null;
		this.formulapagobanco=null;
		this.cuentacontablediferencia=null;
		this.formularetencion=null;
		this.formulacomision=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.banco_descripcion="";
		this.tiporetencion_descripcion="";
		this.cuentacontable_descripcion="";
		this.tiporetencioniva_descripcion="";
		this.cuentacontablecomision_descripcion="";
		this.formulapagobanco_descripcion="";
		this.cuentacontablediferencia_descripcion="";
		this.formularetencion_descripcion="";
		this.formulacomision_descripcion="";
		
		
		this.tarjetacreditoconexions=null;
		this.tarjetacreditodescuentos=null;
		this.formapagopuntoventas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TarjetaCredito (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_banco,String codigo,String nombre,String nombre_corto,Integer digito_valido,Integer digito_tarjeta,Double comision,Double interes,Double monto_minimo,Double porcentaje_retencion,Double comision_retencion,Boolean es_retencion_redondeo,Boolean es_pago_banco_redondeo,Boolean es_comision_redondeo,Long id_tipo_retencion,Long id_cuenta_contable,Long id_tipo_retencion_iva,Long id_cuenta_contable_comision,Long id_formula_pago_banco,Long id_cuenta_contable_diferencia,Long id_formula_retencion,Long id_formula_comision) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tarjetacreditoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_banco=id_banco;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nombre_corto=nombre_corto;
 		this.digito_valido=digito_valido;
 		this.digito_tarjeta=digito_tarjeta;
 		this.comision=comision;
 		this.interes=interes;
 		this.monto_minimo=monto_minimo;
 		this.porcentaje_retencion=porcentaje_retencion;
 		this.comision_retencion=comision_retencion;
 		this.es_retencion_redondeo=es_retencion_redondeo;
 		this.es_pago_banco_redondeo=es_pago_banco_redondeo;
 		this.es_comision_redondeo=es_comision_redondeo;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_tipo_retencion_iva=id_tipo_retencion_iva;
 		this.id_cuenta_contable_comision=id_cuenta_contable_comision;
 		this.id_formula_pago_banco=id_formula_pago_banco;
 		this.id_cuenta_contable_diferencia=id_cuenta_contable_diferencia;
 		this.id_formula_retencion=id_formula_retencion;
 		this.id_formula_comision=id_formula_comision;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TarjetaCredito (Long id_empresa,Long id_sucursal,Long id_banco,String codigo,String nombre,String nombre_corto,Integer digito_valido,Integer digito_tarjeta,Double comision,Double interes,Double monto_minimo,Double porcentaje_retencion,Double comision_retencion,Boolean es_retencion_redondeo,Boolean es_pago_banco_redondeo,Boolean es_comision_redondeo,Long id_tipo_retencion,Long id_cuenta_contable,Long id_tipo_retencion_iva,Long id_cuenta_contable_comision,Long id_formula_pago_banco,Long id_cuenta_contable_diferencia,Long id_formula_retencion,Long id_formula_comision) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tarjetacreditoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_banco=id_banco;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nombre_corto=nombre_corto;
 		this.digito_valido=digito_valido;
 		this.digito_tarjeta=digito_tarjeta;
 		this.comision=comision;
 		this.interes=interes;
 		this.monto_minimo=monto_minimo;
 		this.porcentaje_retencion=porcentaje_retencion;
 		this.comision_retencion=comision_retencion;
 		this.es_retencion_redondeo=es_retencion_redondeo;
 		this.es_pago_banco_redondeo=es_pago_banco_redondeo;
 		this.es_comision_redondeo=es_comision_redondeo;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_tipo_retencion_iva=id_tipo_retencion_iva;
 		this.id_cuenta_contable_comision=id_cuenta_contable_comision;
 		this.id_formula_pago_banco=id_formula_pago_banco;
 		this.id_cuenta_contable_diferencia=id_cuenta_contable_diferencia;
 		this.id_formula_retencion=id_formula_retencion;
 		this.id_formula_comision=id_formula_comision;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TarjetaCredito tarjetacreditoLocal=null;
		
		if(object!=null) {
			tarjetacreditoLocal=(TarjetaCredito)object;
			
			if(tarjetacreditoLocal!=null) {
				if(this.getId()!=null && tarjetacreditoLocal.getId()!=null) {
					if(this.getId().equals(tarjetacreditoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TarjetaCreditoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TarjetaCreditoConstantesFunciones.getTarjetaCreditoDescripcion(this);
		} else {
			sDetalle=TarjetaCreditoConstantesFunciones.getTarjetaCreditoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TarjetaCredito getTarjetaCreditoOriginal() {
		return this.tarjetacreditoOriginal;
	}
	
	public void setTarjetaCreditoOriginal(TarjetaCredito tarjetacredito) {
		try {
			this.tarjetacreditoOriginal=tarjetacredito;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TarjetaCreditoAdditional tarjetacreditoAdditional=null;
	
	public TarjetaCreditoAdditional getTarjetaCreditoAdditional() {
		return this.tarjetacreditoAdditional;
	}
	
	public void setTarjetaCreditoAdditional(TarjetaCreditoAdditional tarjetacreditoAdditional) {
		try {
			this.tarjetacreditoAdditional=tarjetacreditoAdditional;
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
    
	
	public Long getid_banco() {
		return this.id_banco;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getnombre_corto() {
		return this.nombre_corto;
	}
    
	
	public Integer getdigito_valido() {
		return this.digito_valido;
	}
    
	
	public Integer getdigito_tarjeta() {
		return this.digito_tarjeta;
	}
    
	
	public Double getcomision() {
		return this.comision;
	}
    
	
	public Double getinteres() {
		return this.interes;
	}
    
	
	public Double getmonto_minimo() {
		return this.monto_minimo;
	}
    
	
	public Double getporcentaje_retencion() {
		return this.porcentaje_retencion;
	}
    
	
	public Double getcomision_retencion() {
		return this.comision_retencion;
	}
    
	
	public Boolean getes_retencion_redondeo() {
		return this.es_retencion_redondeo;
	}
    
	
	public Boolean getes_pago_banco_redondeo() {
		return this.es_pago_banco_redondeo;
	}
    
	
	public Boolean getes_comision_redondeo() {
		return this.es_comision_redondeo;
	}
    
	
	public Long getid_tipo_retencion() {
		return this.id_tipo_retencion;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_tipo_retencion_iva() {
		return this.id_tipo_retencion_iva;
	}
    
	
	public Long getid_cuenta_contable_comision() {
		return this.id_cuenta_contable_comision;
	}
    
	
	public Long getid_formula_pago_banco() {
		return this.id_formula_pago_banco;
	}
    
	
	public Long getid_cuenta_contable_diferencia() {
		return this.id_cuenta_contable_diferencia;
	}
    
	
	public Long getid_formula_retencion() {
		return this.id_formula_retencion;
	}
    
	
	public Long getid_formula_comision() {
		return this.id_formula_comision;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_banco(Long newid_banco)throws Exception
	{
		try {
			if(this.id_banco!=newid_banco) {
				if(newid_banco==null) {
					//newid_banco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna id_banco");
					}
				}

				this.id_banco=newid_banco;
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
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TarjetaCredito:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TarjetaCredito:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_corto(String newnombre_corto)throws Exception
	{
		try {
			if(this.nombre_corto!=newnombre_corto) {
				if(newnombre_corto==null) {
					//newnombre_corto="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna nombre_corto");
					}
				}

				if(newnombre_corto!=null&&newnombre_corto.length()>50) {
					newnombre_corto=newnombre_corto.substring(0,48);
					System.out.println("TarjetaCredito:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_corto");
				}

				this.nombre_corto=newnombre_corto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdigito_valido(Integer newdigito_valido)throws Exception
	{
		try {
			if(this.digito_valido!=newdigito_valido) {
				if(newdigito_valido==null) {
					//newdigito_valido=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna digito_valido");
					}
				}

				this.digito_valido=newdigito_valido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdigito_tarjeta(Integer newdigito_tarjeta)throws Exception
	{
		try {
			if(this.digito_tarjeta!=newdigito_tarjeta) {
				if(newdigito_tarjeta==null) {
					//newdigito_tarjeta=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna digito_tarjeta");
					}
				}

				this.digito_tarjeta=newdigito_tarjeta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcomision(Double newcomision)throws Exception
	{
		try {
			if(this.comision!=newcomision) {
				if(newcomision==null) {
					//newcomision=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna comision");
					}
				}

				this.comision=newcomision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setinteres(Double newinteres)throws Exception
	{
		try {
			if(this.interes!=newinteres) {
				if(newinteres==null) {
					//newinteres=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna interes");
					}
				}

				this.interes=newinteres;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_minimo(Double newmonto_minimo)throws Exception
	{
		try {
			if(this.monto_minimo!=newmonto_minimo) {
				if(newmonto_minimo==null) {
					//newmonto_minimo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna monto_minimo");
					}
				}

				this.monto_minimo=newmonto_minimo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_retencion(Double newporcentaje_retencion)throws Exception
	{
		try {
			if(this.porcentaje_retencion!=newporcentaje_retencion) {
				if(newporcentaje_retencion==null) {
					//newporcentaje_retencion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna porcentaje_retencion");
					}
				}

				this.porcentaje_retencion=newporcentaje_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcomision_retencion(Double newcomision_retencion)throws Exception
	{
		try {
			if(this.comision_retencion!=newcomision_retencion) {
				if(newcomision_retencion==null) {
					//newcomision_retencion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna comision_retencion");
					}
				}

				this.comision_retencion=newcomision_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_retencion_redondeo(Boolean newes_retencion_redondeo)throws Exception
	{
		try {
			if(this.es_retencion_redondeo!=newes_retencion_redondeo) {
				if(newes_retencion_redondeo==null) {
					//newes_retencion_redondeo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna es_retencion_redondeo");
					}
				}

				this.es_retencion_redondeo=newes_retencion_redondeo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_pago_banco_redondeo(Boolean newes_pago_banco_redondeo)throws Exception
	{
		try {
			if(this.es_pago_banco_redondeo!=newes_pago_banco_redondeo) {
				if(newes_pago_banco_redondeo==null) {
					//newes_pago_banco_redondeo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna es_pago_banco_redondeo");
					}
				}

				this.es_pago_banco_redondeo=newes_pago_banco_redondeo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_comision_redondeo(Boolean newes_comision_redondeo)throws Exception
	{
		try {
			if(this.es_comision_redondeo!=newes_comision_redondeo) {
				if(newes_comision_redondeo==null) {
					//newes_comision_redondeo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna es_comision_redondeo");
					}
				}

				this.es_comision_redondeo=newes_comision_redondeo;
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
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna id_tipo_retencion");
					}
				}

				this.id_tipo_retencion=newid_tipo_retencion;
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
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_retencion_iva(Long newid_tipo_retencion_iva)throws Exception
	{
		try {
			if(this.id_tipo_retencion_iva!=newid_tipo_retencion_iva) {
				if(newid_tipo_retencion_iva==null) {
					//newid_tipo_retencion_iva=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna id_tipo_retencion_iva");
					}
				}

				this.id_tipo_retencion_iva=newid_tipo_retencion_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_comision(Long newid_cuenta_contable_comision)throws Exception
	{
		try {
			if(this.id_cuenta_contable_comision!=newid_cuenta_contable_comision) {
				if(newid_cuenta_contable_comision==null) {
					//newid_cuenta_contable_comision=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna id_cuenta_contable_comision");
					}
				}

				this.id_cuenta_contable_comision=newid_cuenta_contable_comision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formula_pago_banco(Long newid_formula_pago_banco)throws Exception
	{
		try {
			if(this.id_formula_pago_banco!=newid_formula_pago_banco) {
				if(newid_formula_pago_banco==null) {
					//newid_formula_pago_banco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna id_formula_pago_banco");
					}
				}

				this.id_formula_pago_banco=newid_formula_pago_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_diferencia(Long newid_cuenta_contable_diferencia)throws Exception
	{
		try {
			if(this.id_cuenta_contable_diferencia!=newid_cuenta_contable_diferencia) {
				if(newid_cuenta_contable_diferencia==null) {
					//newid_cuenta_contable_diferencia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna id_cuenta_contable_diferencia");
					}
				}

				this.id_cuenta_contable_diferencia=newid_cuenta_contable_diferencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formula_retencion(Long newid_formula_retencion)throws Exception
	{
		try {
			if(this.id_formula_retencion!=newid_formula_retencion) {
				if(newid_formula_retencion==null) {
					//newid_formula_retencion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna id_formula_retencion");
					}
				}

				this.id_formula_retencion=newid_formula_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formula_comision(Long newid_formula_comision)throws Exception
	{
		try {
			if(this.id_formula_comision!=newid_formula_comision) {
				if(newid_formula_comision==null) {
					//newid_formula_comision=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TarjetaCredito:Valor nulo no permitido en columna id_formula_comision");
					}
				}

				this.id_formula_comision=newid_formula_comision;
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

	public Banco getBanco() {
		return this.banco;
	}

	public TipoRetencion getTipoRetencion() {
		return this.tiporetencion;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public TipoRetencionIva getTipoRetencionIva() {
		return this.tiporetencioniva;
	}

	public CuentaContable getCuentaContableComision() {
		return this.cuentacontablecomision;
	}

	public Formula getFormulaPagoBanco() {
		return this.formulapagobanco;
	}

	public CuentaContable getCuentaContableDiferencia() {
		return this.cuentacontablediferencia;
	}

	public Formula getFormulaRetencion() {
		return this.formularetencion;
	}

	public Formula getFormulaComision() {
		return this.formulacomision;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getbanco_descripcion() {
		return this.banco_descripcion;
	}

	public String gettiporetencion_descripcion() {
		return this.tiporetencion_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String gettiporetencioniva_descripcion() {
		return this.tiporetencioniva_descripcion;
	}

	public String getcuentacontablecomision_descripcion() {
		return this.cuentacontablecomision_descripcion;
	}

	public String getformulapagobanco_descripcion() {
		return this.formulapagobanco_descripcion;
	}

	public String getcuentacontablediferencia_descripcion() {
		return this.cuentacontablediferencia_descripcion;
	}

	public String getformularetencion_descripcion() {
		return this.formularetencion_descripcion;
	}

	public String getformulacomision_descripcion() {
		return this.formulacomision_descripcion;
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


	public  void  setBanco(Banco banco) {
		try {
			this.banco=banco;
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


	public  void  setCuentaContable(CuentaContable cuentacontable) {
		try {
			this.cuentacontable=cuentacontable;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRetencionIva(TipoRetencionIva tiporetencioniva) {
		try {
			this.tiporetencioniva=tiporetencioniva;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableComision(CuentaContable cuentacontablecomision) {
		try {
			this.cuentacontablecomision=cuentacontablecomision;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormulaPagoBanco(Formula formulapagobanco) {
		try {
			this.formulapagobanco=formulapagobanco;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDiferencia(CuentaContable cuentacontablediferencia) {
		try {
			this.cuentacontablediferencia=cuentacontablediferencia;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormulaRetencion(Formula formularetencion) {
		try {
			this.formularetencion=formularetencion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormulaComision(Formula formulacomision) {
		try {
			this.formulacomision=formulacomision;
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


	public  void  setbanco_descripcion(String banco_descripcion) {
		try {
			this.banco_descripcion=banco_descripcion;
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


	public  void  setcuentacontable_descripcion(String cuentacontable_descripcion) {
		try {
			this.cuentacontable_descripcion=cuentacontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporetencioniva_descripcion(String tiporetencioniva_descripcion) {
		try {
			this.tiporetencioniva_descripcion=tiporetencioniva_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecomision_descripcion(String cuentacontablecomision_descripcion) {
		try {
			this.cuentacontablecomision_descripcion=cuentacontablecomision_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformulapagobanco_descripcion(String formulapagobanco_descripcion) {
		try {
			this.formulapagobanco_descripcion=formulapagobanco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablediferencia_descripcion(String cuentacontablediferencia_descripcion) {
		try {
			this.cuentacontablediferencia_descripcion=cuentacontablediferencia_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformularetencion_descripcion(String formularetencion_descripcion) {
		try {
			this.formularetencion_descripcion=formularetencion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformulacomision_descripcion(String formulacomision_descripcion) {
		try {
			this.formulacomision_descripcion=formulacomision_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<TarjetaCreditoConexion> getTarjetaCreditoConexions() {
		return this.tarjetacreditoconexions;
	}

	public List<TarjetaCreditoDescuento> getTarjetaCreditoDescuentos() {
		return this.tarjetacreditodescuentos;
	}

	public List<FormaPagoPuntoVenta> getFormaPagoPuntoVentas() {
		return this.formapagopuntoventas;
	}

	
	
	public  void  setTarjetaCreditoConexions(List<TarjetaCreditoConexion> tarjetacreditoconexions) {
		try {
			this.tarjetacreditoconexions=tarjetacreditoconexions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setTarjetaCreditoDescuentos(List<TarjetaCreditoDescuento> tarjetacreditodescuentos) {
		try {
			this.tarjetacreditodescuentos=tarjetacreditodescuentos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setFormaPagoPuntoVentas(List<FormaPagoPuntoVenta> formapagopuntoventas) {
		try {
			this.formapagopuntoventas=formapagopuntoventas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_banco_descripcion="";String es_retencion_redondeo_descripcion="";String es_pago_banco_redondeo_descripcion="";String es_comision_redondeo_descripcion="";String id_tipo_retencion_descripcion="";String id_cuenta_contable_descripcion="";String id_tipo_retencion_iva_descripcion="";String id_cuenta_contable_comision_descripcion="";String id_formula_pago_banco_descripcion="";String id_cuenta_contable_diferencia_descripcion="";String id_formula_retencion_descripcion="";String id_formula_comision_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_banco_descripcion() {
		return id_banco_descripcion;
	}
	public String getes_retencion_redondeo_descripcion() {
		return es_retencion_redondeo_descripcion;
	}
	public String getes_pago_banco_redondeo_descripcion() {
		return es_pago_banco_redondeo_descripcion;
	}
	public String getes_comision_redondeo_descripcion() {
		return es_comision_redondeo_descripcion;
	}
	public String getid_tipo_retencion_descripcion() {
		return id_tipo_retencion_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_tipo_retencion_iva_descripcion() {
		return id_tipo_retencion_iva_descripcion;
	}
	public String getid_cuenta_contable_comision_descripcion() {
		return id_cuenta_contable_comision_descripcion;
	}
	public String getid_formula_pago_banco_descripcion() {
		return id_formula_pago_banco_descripcion;
	}
	public String getid_cuenta_contable_diferencia_descripcion() {
		return id_cuenta_contable_diferencia_descripcion;
	}
	public String getid_formula_retencion_descripcion() {
		return id_formula_retencion_descripcion;
	}
	public String getid_formula_comision_descripcion() {
		return id_formula_comision_descripcion;
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
	public void setid_banco_descripcion(String newid_banco_descripcion)throws Exception {
		try {
			this.id_banco_descripcion=newid_banco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_retencion_redondeo_descripcion(String newes_retencion_redondeo_descripcion)throws Exception {
		try {
			this.es_retencion_redondeo_descripcion=newes_retencion_redondeo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_pago_banco_redondeo_descripcion(String newes_pago_banco_redondeo_descripcion)throws Exception {
		try {
			this.es_pago_banco_redondeo_descripcion=newes_pago_banco_redondeo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_comision_redondeo_descripcion(String newes_comision_redondeo_descripcion)throws Exception {
		try {
			this.es_comision_redondeo_descripcion=newes_comision_redondeo_descripcion;
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
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_retencion_iva_descripcion(String newid_tipo_retencion_iva_descripcion)throws Exception {
		try {
			this.id_tipo_retencion_iva_descripcion=newid_tipo_retencion_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_comision_descripcion(String newid_cuenta_contable_comision_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_comision_descripcion=newid_cuenta_contable_comision_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formula_pago_banco_descripcion(String newid_formula_pago_banco_descripcion)throws Exception {
		try {
			this.id_formula_pago_banco_descripcion=newid_formula_pago_banco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_diferencia_descripcion(String newid_cuenta_contable_diferencia_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_diferencia_descripcion=newid_cuenta_contable_diferencia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formula_retencion_descripcion(String newid_formula_retencion_descripcion)throws Exception {
		try {
			this.id_formula_retencion_descripcion=newid_formula_retencion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formula_comision_descripcion(String newid_formula_comision_descripcion)throws Exception {
		try {
			this.id_formula_comision_descripcion=newid_formula_comision_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_banco_descripcion="";this.es_retencion_redondeo_descripcion="";this.es_pago_banco_redondeo_descripcion="";this.es_comision_redondeo_descripcion="";this.id_tipo_retencion_descripcion="";this.id_cuenta_contable_descripcion="";this.id_tipo_retencion_iva_descripcion="";this.id_cuenta_contable_comision_descripcion="";this.id_formula_pago_banco_descripcion="";this.id_cuenta_contable_diferencia_descripcion="";this.id_formula_retencion_descripcion="";this.id_formula_comision_descripcion="";
	}
	
	
	Object tarjetacreditoconexionsDescripcionReporte;
	Object tarjetacreditodescuentosDescripcionReporte;
	Object formapagopuntoventasDescripcionReporte;
	
	
	public Object gettarjetacreditoconexionsDescripcionReporte() {
		return tarjetacreditoconexionsDescripcionReporte;
	}

	public Object gettarjetacreditodescuentosDescripcionReporte() {
		return tarjetacreditodescuentosDescripcionReporte;
	}

	public Object getformapagopuntoventasDescripcionReporte() {
		return formapagopuntoventasDescripcionReporte;
	}

	
	
	public  void  settarjetacreditoconexionsDescripcionReporte(Object tarjetacreditoconexions) {
		try {
			this.tarjetacreditoconexionsDescripcionReporte=tarjetacreditoconexions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settarjetacreditodescuentosDescripcionReporte(Object tarjetacreditodescuentos) {
		try {
			this.tarjetacreditodescuentosDescripcionReporte=tarjetacreditodescuentos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setformapagopuntoventasDescripcionReporte(Object formapagopuntoventas) {
		try {
			this.formapagopuntoventasDescripcionReporte=formapagopuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

