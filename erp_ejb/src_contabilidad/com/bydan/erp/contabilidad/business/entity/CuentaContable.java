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
//import com.bydan.erp.contabilidad.util.CuentaContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class CuentaContable extends CuentaContableAdditional implements Serializable ,Cloneable {//CuentaContableAdditional,GeneralEntity
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
	
	private CuentaContable cuentacontableOriginal;
	
	private Map<String, Object> mapCuentaContable;
			
	public Map<String, Object> getMapCuentaContable() {
		return mapCuentaContable;
	}

	public void setMapCuentaContable(Map<String, Object> mapCuentaContable) {
		this.mapCuentaContable = mapCuentaContable;
	}
	
	public void inicializarMapCuentaContable() {
		this.mapCuentaContable = new HashMap<String,Object>();
	}
	
	public void setMapCuentaContableValue(String sKey,Object oValue) {
		this.mapCuentaContable.put(sKey, oValue);
	}
	
	public Object getMapCuentaContableValue(String sKey) {
		return this.mapCuentaContable.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CuentaContableConstantesFunciones.SREGEXCODIGO,message=CuentaContableConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CuentaContableConstantesFunciones.SREGEXNOMBRE,message=CuentaContableConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CuentaContableConstantesFunciones.SREGEXCODIGO_EXTRANJERO,message=CuentaContableConstantesFunciones.SMENSAJEREGEXCODIGO_EXTRANJERO)
	private String codigo_extranjero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CuentaContableConstantesFunciones.SREGEXNOMBRE_EXTRANJERO,message=CuentaContableConstantesFunciones.SMENSAJEREGEXNOMBRE_EXTRANJERO)
	private String nombre_extranjero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_nivel_cuenta;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CuentaContableConstantesFunciones.SREGEXDESCRIPCION,message=CuentaContableConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_centro_actividad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_activo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_relacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_para_f52;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_intervalo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_flujo_efectivo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_debito;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer orden;
			
	
	public Empresa empresa;
	public NivelCuenta nivelcuenta;
	public CuentaContable cuentacontable;
	public CentroCosto centrocosto;
	public Modulo modulo;
	public Moneda moneda;
	public TipoIntervalo tipointervalo;
	public TipoFlujoEfectivo tipoflujoefectivo;
	public CuentaContable cuentacontabledebito;
	public CuentaContable cuentacontablecredito;
	
	
	private String empresa_descripcion;
	private String nivelcuenta_descripcion;
	private String cuentacontable_descripcion;
	private String centrocosto_descripcion;
	private String modulo_descripcion;
	private String moneda_descripcion;
	private String tipointervalo_descripcion;
	private String tipoflujoefectivo_descripcion;
	private String cuentacontabledebito_descripcion;
	private String cuentacontablecredito_descripcion;
	
	
		
	public CuentaContable () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cuentacontableOriginal=this;
		
 		this.id_empresa=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.codigo_extranjero="";
 		this.nombre_extranjero="";
 		this.id_nivel_cuenta=-1L;
 		this.id_cuenta_contable=null;
 		this.id_centro_costo=null;
 		this.id_modulo=-1L;
 		this.descripcion="";
 		this.es_movimiento=false;
 		this.es_centro_costo=false;
 		this.es_centro_actividad=false;
 		this.es_activo=false;
 		this.es_relacion=false;
 		this.es_para_f52=false;
 		this.id_moneda=-1L;
 		this.id_tipo_intervalo=-1L;
 		this.id_tipo_flujo_efectivo=null;
 		this.id_cuenta_contable_debito=null;
 		this.id_cuenta_contable_credito=null;
 		this.orden=0;
		
		
		this.empresa=null;
		this.nivelcuenta=null;
		this.centrocosto=null;
		this.modulo=null;
		this.moneda=null;
		this.tipointervalo=null;
		this.tipoflujoefectivo=null;
		
		
		this.empresa_descripcion="";
		this.nivelcuenta_descripcion="";
		this.centrocosto_descripcion="";
		this.modulo_descripcion="";
		this.moneda_descripcion="";
		this.tipointervalo_descripcion="";
		this.tipoflujoefectivo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CuentaContable (Long id,Date versionRow,Long id_empresa,String codigo,String nombre,String codigo_extranjero,String nombre_extranjero,Long id_nivel_cuenta,Long id_cuenta_contable,Long id_centro_costo,Long id_modulo,String descripcion,Boolean es_movimiento,Boolean es_centro_costo,Boolean es_centro_actividad,Boolean es_activo,Boolean es_relacion,Boolean es_para_f52,Long id_moneda,Long id_tipo_intervalo,Long id_tipo_flujo_efectivo,Long id_cuenta_contable_debito,Long id_cuenta_contable_credito,Integer orden) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuentacontableOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.codigo_extranjero=codigo_extranjero;
 		this.nombre_extranjero=nombre_extranjero;
 		this.id_nivel_cuenta=id_nivel_cuenta;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_centro_costo=id_centro_costo;
 		this.id_modulo=id_modulo;
 		this.descripcion=descripcion;
 		this.es_movimiento=es_movimiento;
 		this.es_centro_costo=es_centro_costo;
 		this.es_centro_actividad=es_centro_actividad;
 		this.es_activo=es_activo;
 		this.es_relacion=es_relacion;
 		this.es_para_f52=es_para_f52;
 		this.id_moneda=id_moneda;
 		this.id_tipo_intervalo=id_tipo_intervalo;
 		this.id_tipo_flujo_efectivo=id_tipo_flujo_efectivo;
 		this.id_cuenta_contable_debito=id_cuenta_contable_debito;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.orden=orden;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CuentaContable (Long id_empresa,String codigo,String nombre,String codigo_extranjero,String nombre_extranjero,Long id_nivel_cuenta,Long id_cuenta_contable,Long id_centro_costo,Long id_modulo,String descripcion,Boolean es_movimiento,Boolean es_centro_costo,Boolean es_centro_actividad,Boolean es_activo,Boolean es_relacion,Boolean es_para_f52,Long id_moneda,Long id_tipo_intervalo,Long id_tipo_flujo_efectivo,Long id_cuenta_contable_debito,Long id_cuenta_contable_credito,Integer orden) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuentacontableOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.codigo_extranjero=codigo_extranjero;
 		this.nombre_extranjero=nombre_extranjero;
 		this.id_nivel_cuenta=id_nivel_cuenta;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_centro_costo=id_centro_costo;
 		this.id_modulo=id_modulo;
 		this.descripcion=descripcion;
 		this.es_movimiento=es_movimiento;
 		this.es_centro_costo=es_centro_costo;
 		this.es_centro_actividad=es_centro_actividad;
 		this.es_activo=es_activo;
 		this.es_relacion=es_relacion;
 		this.es_para_f52=es_para_f52;
 		this.id_moneda=id_moneda;
 		this.id_tipo_intervalo=id_tipo_intervalo;
 		this.id_tipo_flujo_efectivo=id_tipo_flujo_efectivo;
 		this.id_cuenta_contable_debito=id_cuenta_contable_debito;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.orden=orden;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CuentaContable cuentacontableLocal=null;
		
		if(object!=null) {
			cuentacontableLocal=(CuentaContable)object;
			
			if(cuentacontableLocal!=null) {
				if(this.getId()!=null && cuentacontableLocal.getId()!=null) {
					if(this.getId().equals(cuentacontableLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CuentaContableConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CuentaContableConstantesFunciones.getCuentaContableDescripcion(this);
		} else {
			sDetalle=CuentaContableConstantesFunciones.getCuentaContableDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CuentaContable getCuentaContableOriginal() {
		return this.cuentacontableOriginal;
	}
	
	public void setCuentaContableOriginal(CuentaContable cuentacontable) {
		try {
			this.cuentacontableOriginal=cuentacontable;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CuentaContableAdditional cuentacontableAdditional=null;
	
	public CuentaContableAdditional getCuentaContableAdditional() {
		return this.cuentacontableAdditional;
	}
	
	public void setCuentaContableAdditional(CuentaContableAdditional cuentacontableAdditional) {
		try {
			this.cuentacontableAdditional=cuentacontableAdditional;
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
    
	
	public String getcodigo_extranjero() {
		return this.codigo_extranjero;
	}
    
	
	public String getnombre_extranjero() {
		return this.nombre_extranjero;
	}
    
	
	public Long getid_nivel_cuenta() {
		return this.id_nivel_cuenta;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Boolean getes_movimiento() {
		return this.es_movimiento;
	}
    
	
	public Boolean getes_centro_costo() {
		return this.es_centro_costo;
	}
    
	
	public Boolean getes_centro_actividad() {
		return this.es_centro_actividad;
	}
    
	
	public Boolean getes_activo() {
		return this.es_activo;
	}
    
	
	public Boolean getes_relacion() {
		return this.es_relacion;
	}
    
	
	public Boolean getes_para_f52() {
		return this.es_para_f52;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public Long getid_tipo_intervalo() {
		return this.id_tipo_intervalo;
	}
    
	
	public Long getid_tipo_flujo_efectivo() {
		return this.id_tipo_flujo_efectivo;
	}
    
	
	public Long getid_cuenta_contable_debito() {
		return this.id_cuenta_contable_debito;
	}
    
	
	public Long getid_cuenta_contable_credito() {
		return this.id_cuenta_contable_credito;
	}
    
	
	public Integer getorden() {
		return this.orden;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContable:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("CuentaContable:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("CuentaContable:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("CuentaContable:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("CuentaContable:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_extranjero(String newcodigo_extranjero)throws Exception
	{
		try {
			if(this.codigo_extranjero!=newcodigo_extranjero) {
				if(newcodigo_extranjero==null) {
					//newcodigo_extranjero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContable:Valor nulo no permitido en columna codigo_extranjero");
					}
				}

				if(newcodigo_extranjero!=null&&newcodigo_extranjero.length()>50) {
					newcodigo_extranjero=newcodigo_extranjero.substring(0,48);
					System.out.println("CuentaContable:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_extranjero");
				}

				this.codigo_extranjero=newcodigo_extranjero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_extranjero(String newnombre_extranjero)throws Exception
	{
		try {
			if(this.nombre_extranjero!=newnombre_extranjero) {
				if(newnombre_extranjero==null) {
					//newnombre_extranjero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContable:Valor nulo no permitido en columna nombre_extranjero");
					}
				}

				if(newnombre_extranjero!=null&&newnombre_extranjero.length()>150) {
					newnombre_extranjero=newnombre_extranjero.substring(0,148);
					System.out.println("CuentaContable:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_extranjero");
				}

				this.nombre_extranjero=newnombre_extranjero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_nivel_cuenta(Long newid_nivel_cuenta)throws Exception
	{
		try {
			if(this.id_nivel_cuenta!=newid_nivel_cuenta) {
				if(newid_nivel_cuenta==null) {
					//newid_nivel_cuenta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContable:Valor nulo no permitido en columna id_nivel_cuenta");
					}
				}

				this.id_nivel_cuenta=newid_nivel_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable(Long newid_cuenta_contable) {
		if(this.id_cuenta_contable==null&&newid_cuenta_contable!=null) {
			this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable!=null&&!this.id_cuenta_contable.equals(newid_cuenta_contable)) {

			this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
		}
	}
    
	public void setid_centro_costo(Long newid_centro_costo) {
		if(this.id_centro_costo==null&&newid_centro_costo!=null) {
			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}

		if(this.id_centro_costo!=null&&!this.id_centro_costo.equals(newid_centro_costo)) {

			this.id_centro_costo=newid_centro_costo;
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
						System.out.println("CuentaContable:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
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
						System.out.println("CuentaContable:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("CuentaContable:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_movimiento(Boolean newes_movimiento)throws Exception
	{
		try {
			if(this.es_movimiento!=newes_movimiento) {
				if(newes_movimiento==null) {
					//newes_movimiento=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContable:Valor nulo no permitido en columna es_movimiento");
					}
				}

				this.es_movimiento=newes_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_centro_costo(Boolean newes_centro_costo)throws Exception
	{
		try {
			if(this.es_centro_costo!=newes_centro_costo) {
				if(newes_centro_costo==null) {
					//newes_centro_costo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContable:Valor nulo no permitido en columna es_centro_costo");
					}
				}

				this.es_centro_costo=newes_centro_costo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_centro_actividad(Boolean newes_centro_actividad)throws Exception
	{
		try {
			if(this.es_centro_actividad!=newes_centro_actividad) {
				if(newes_centro_actividad==null) {
					//newes_centro_actividad=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContable:Valor nulo no permitido en columna es_centro_actividad");
					}
				}

				this.es_centro_actividad=newes_centro_actividad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_activo(Boolean newes_activo)throws Exception
	{
		try {
			if(this.es_activo!=newes_activo) {
				if(newes_activo==null) {
					//newes_activo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContable:Valor nulo no permitido en columna es_activo");
					}
				}

				this.es_activo=newes_activo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_relacion(Boolean newes_relacion)throws Exception
	{
		try {
			if(this.es_relacion!=newes_relacion) {
				if(newes_relacion==null) {
					//newes_relacion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContable:Valor nulo no permitido en columna es_relacion");
					}
				}

				this.es_relacion=newes_relacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_para_f52(Boolean newes_para_f52)throws Exception
	{
		try {
			if(this.es_para_f52!=newes_para_f52) {
				if(newes_para_f52==null) {
					//newes_para_f52=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContable:Valor nulo no permitido en columna es_para_f52");
					}
				}

				this.es_para_f52=newes_para_f52;
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
						System.out.println("CuentaContable:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_intervalo(Long newid_tipo_intervalo)throws Exception
	{
		try {
			if(this.id_tipo_intervalo!=newid_tipo_intervalo) {
				if(newid_tipo_intervalo==null) {
					//newid_tipo_intervalo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContable:Valor nulo no permitido en columna id_tipo_intervalo");
					}
				}

				this.id_tipo_intervalo=newid_tipo_intervalo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_flujo_efectivo(Long newid_tipo_flujo_efectivo) {
		if(this.id_tipo_flujo_efectivo==null&&newid_tipo_flujo_efectivo!=null) {
			this.id_tipo_flujo_efectivo=newid_tipo_flujo_efectivo;
				this.setIsChanged(true);
		}

		if(this.id_tipo_flujo_efectivo!=null&&!this.id_tipo_flujo_efectivo.equals(newid_tipo_flujo_efectivo)) {

			this.id_tipo_flujo_efectivo=newid_tipo_flujo_efectivo;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_debito(Long newid_cuenta_contable_debito) {
		if(this.id_cuenta_contable_debito==null&&newid_cuenta_contable_debito!=null) {
			this.id_cuenta_contable_debito=newid_cuenta_contable_debito;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_debito!=null&&!this.id_cuenta_contable_debito.equals(newid_cuenta_contable_debito)) {

			this.id_cuenta_contable_debito=newid_cuenta_contable_debito;
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
    
	public void setorden(Integer neworden)throws Exception
	{
		try {
			if(this.orden!=neworden) {
				if(neworden==null) {
					//neworden=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContable:Valor nulo no permitido en columna orden");
					}
				}

				this.orden=neworden;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public NivelCuenta getNivelCuenta() {
		return this.nivelcuenta;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public TipoIntervalo getTipoIntervalo() {
		return this.tipointervalo;
	}

	public TipoFlujoEfectivo getTipoFlujoEfectivo() {
		return this.tipoflujoefectivo;
	}

	public CuentaContable getCuentaContableDebito() {
		return this.cuentacontabledebito;
	}

	public CuentaContable getCuentaContableCredito() {
		return this.cuentacontablecredito;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getnivelcuenta_descripcion() {
		return this.nivelcuenta_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String gettipointervalo_descripcion() {
		return this.tipointervalo_descripcion;
	}

	public String gettipoflujoefectivo_descripcion() {
		return this.tipoflujoefectivo_descripcion;
	}

	public String getcuentacontabledebito_descripcion() {
		return this.cuentacontabledebito_descripcion;
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


	public  void  setNivelCuenta(NivelCuenta nivelcuenta) {
		try {
			this.nivelcuenta=nivelcuenta;
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


	public  void  setCentroCosto(CentroCosto centrocosto) {
		try {
			this.centrocosto=centrocosto;
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


	public  void  setMoneda(Moneda moneda) {
		try {
			this.moneda=moneda;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoIntervalo(TipoIntervalo tipointervalo) {
		try {
			this.tipointervalo=tipointervalo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoFlujoEfectivo(TipoFlujoEfectivo tipoflujoefectivo) {
		try {
			this.tipoflujoefectivo=tipoflujoefectivo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDebito(CuentaContable cuentacontabledebito) {
		try {
			this.cuentacontabledebito=cuentacontabledebito;
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


	public  void  setnivelcuenta_descripcion(String nivelcuenta_descripcion) {
		try {
			this.nivelcuenta_descripcion=nivelcuenta_descripcion;
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


	public  void  setcentrocosto_descripcion(String centrocosto_descripcion) {
		try {
			this.centrocosto_descripcion=centrocosto_descripcion;
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


	public  void  setmoneda_descripcion(String moneda_descripcion) {
		try {
			this.moneda_descripcion=moneda_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipointervalo_descripcion(String tipointervalo_descripcion) {
		try {
			this.tipointervalo_descripcion=tipointervalo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoflujoefectivo_descripcion(String tipoflujoefectivo_descripcion) {
		try {
			this.tipoflujoefectivo_descripcion=tipoflujoefectivo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledebito_descripcion(String cuentacontabledebito_descripcion) {
		try {
			this.cuentacontabledebito_descripcion=cuentacontabledebito_descripcion;
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
	String id_empresa_descripcion="";String id_nivel_cuenta_descripcion="";String id_cuenta_contable_descripcion="";String id_centro_costo_descripcion="";String id_modulo_descripcion="";String es_movimiento_descripcion="";String es_centro_costo_descripcion="";String es_centro_actividad_descripcion="";String es_activo_descripcion="";String es_relacion_descripcion="";String es_para_f52_descripcion="";String id_moneda_descripcion="";String id_tipo_intervalo_descripcion="";String id_tipo_flujo_efectivo_descripcion="";String id_cuenta_contable_debito_descripcion="";String id_cuenta_contable_credito_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_nivel_cuenta_descripcion() {
		return id_nivel_cuenta_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getes_movimiento_descripcion() {
		return es_movimiento_descripcion;
	}
	public String getes_centro_costo_descripcion() {
		return es_centro_costo_descripcion;
	}
	public String getes_centro_actividad_descripcion() {
		return es_centro_actividad_descripcion;
	}
	public String getes_activo_descripcion() {
		return es_activo_descripcion;
	}
	public String getes_relacion_descripcion() {
		return es_relacion_descripcion;
	}
	public String getes_para_f52_descripcion() {
		return es_para_f52_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getid_tipo_intervalo_descripcion() {
		return id_tipo_intervalo_descripcion;
	}
	public String getid_tipo_flujo_efectivo_descripcion() {
		return id_tipo_flujo_efectivo_descripcion;
	}
	public String getid_cuenta_contable_debito_descripcion() {
		return id_cuenta_contable_debito_descripcion;
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
	public void setid_nivel_cuenta_descripcion(String newid_nivel_cuenta_descripcion)throws Exception {
		try {
			this.id_nivel_cuenta_descripcion=newid_nivel_cuenta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion) {
		this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
	}
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion)throws Exception {
		try {
			this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
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
	public void setes_movimiento_descripcion(String newes_movimiento_descripcion)throws Exception {
		try {
			this.es_movimiento_descripcion=newes_movimiento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_centro_costo_descripcion(String newes_centro_costo_descripcion)throws Exception {
		try {
			this.es_centro_costo_descripcion=newes_centro_costo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_centro_actividad_descripcion(String newes_centro_actividad_descripcion)throws Exception {
		try {
			this.es_centro_actividad_descripcion=newes_centro_actividad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_activo_descripcion(String newes_activo_descripcion)throws Exception {
		try {
			this.es_activo_descripcion=newes_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_relacion_descripcion(String newes_relacion_descripcion)throws Exception {
		try {
			this.es_relacion_descripcion=newes_relacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_para_f52_descripcion(String newes_para_f52_descripcion)throws Exception {
		try {
			this.es_para_f52_descripcion=newes_para_f52_descripcion;
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
	public void setid_tipo_intervalo_descripcion(String newid_tipo_intervalo_descripcion)throws Exception {
		try {
			this.id_tipo_intervalo_descripcion=newid_tipo_intervalo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_flujo_efectivo_descripcion(String newid_tipo_flujo_efectivo_descripcion)throws Exception {
		try {
			this.id_tipo_flujo_efectivo_descripcion=newid_tipo_flujo_efectivo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_debito_descripcion(String newid_cuenta_contable_debito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_debito_descripcion=newid_cuenta_contable_debito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_credito_descripcion(String newid_cuenta_contable_credito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_credito_descripcion=newid_cuenta_contable_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_nivel_cuenta_descripcion="";this.id_cuenta_contable_descripcion="";this.id_centro_costo_descripcion="";this.id_modulo_descripcion="";this.es_movimiento_descripcion="";this.es_centro_costo_descripcion="";this.es_centro_actividad_descripcion="";this.es_activo_descripcion="";this.es_relacion_descripcion="";this.es_para_f52_descripcion="";this.id_moneda_descripcion="";this.id_tipo_intervalo_descripcion="";this.id_tipo_flujo_efectivo_descripcion="";this.id_cuenta_contable_debito_descripcion="";this.id_cuenta_contable_credito_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

