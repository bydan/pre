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
package com.bydan.erp.tesoreria.business.entity;

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
//import com.bydan.erp.tesoreria.util.TablaRetencionConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class TablaRetencion extends TablaRetencionAdditional implements Serializable ,Cloneable {//TablaRetencionAdditional,GeneralEntity
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
	
	private TablaRetencion tablaretencionOriginal;
	
	private Map<String, Object> mapTablaRetencion;
			
	public Map<String, Object> getMapTablaRetencion() {
		return mapTablaRetencion;
	}

	public void setMapTablaRetencion(Map<String, Object> mapTablaRetencion) {
		this.mapTablaRetencion = mapTablaRetencion;
	}
	
	public void inicializarMapTablaRetencion() {
		this.mapTablaRetencion = new HashMap<String,Object>();
	}
	
	public void setMapTablaRetencionValue(String sKey,Object oValue) {
		this.mapTablaRetencion.put(sKey, oValue);
	}
	
	public Object getMapTablaRetencionValue(String sKey) {
		return this.mapTablaRetencion.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TablaRetencionConstantesFunciones.SREGEXCODIGO,message=TablaRetencionConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TablaRetencionConstantesFunciones.SREGEXNOMBRE,message=TablaRetencionConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_minimo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_debito;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_debito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_retencion_fuente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_sub_total_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_iva_factura;
			
	
	public Empresa empresa;
	public TipoRetencion tiporetencion;
	public CuentaContable cuentacontabledebito;
	public CuentaContable cuentacontablecredito;
	
	
	private String empresa_descripcion;
	private String tiporetencion_descripcion;
	private String cuentacontabledebito_descripcion;
	private String cuentacontablecredito_descripcion;
	
	
		
	public TablaRetencion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tablaretencionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.porcentaje=0.0;
 		this.monto_minimo=0.0;
 		this.id_tipo_retencion=-1L;
 		this.id_cuenta_contable_debito=-1L;
 		this.id_cuenta_contable_credito=null;
 		this.es_debito=false;
 		this.es_retencion_fuente=false;
 		this.con_secuencial=false;
 		this.con_sub_total_factura=false;
 		this.con_iva_factura=false;
		
		
		this.empresa=null;
		this.tiporetencion=null;
		this.cuentacontabledebito=null;
		this.cuentacontablecredito=null;
		
		
		this.empresa_descripcion="";
		this.tiporetencion_descripcion="";
		this.cuentacontabledebito_descripcion="";
		this.cuentacontablecredito_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TablaRetencion (Long id,Date versionRow,Long id_empresa,String codigo,String nombre,Double porcentaje,Double monto_minimo,Long id_tipo_retencion,Long id_cuenta_contable_debito,Long id_cuenta_contable_credito,Boolean es_debito,Boolean es_retencion_fuente,Boolean con_secuencial,Boolean con_sub_total_factura,Boolean con_iva_factura) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tablaretencionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.porcentaje=porcentaje;
 		this.monto_minimo=monto_minimo;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.id_cuenta_contable_debito=id_cuenta_contable_debito;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.es_debito=es_debito;
 		this.es_retencion_fuente=es_retencion_fuente;
 		this.con_secuencial=con_secuencial;
 		this.con_sub_total_factura=con_sub_total_factura;
 		this.con_iva_factura=con_iva_factura;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TablaRetencion (Long id_empresa,String codigo,String nombre,Double porcentaje,Double monto_minimo,Long id_tipo_retencion,Long id_cuenta_contable_debito,Long id_cuenta_contable_credito,Boolean es_debito,Boolean es_retencion_fuente,Boolean con_secuencial,Boolean con_sub_total_factura,Boolean con_iva_factura) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tablaretencionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.porcentaje=porcentaje;
 		this.monto_minimo=monto_minimo;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.id_cuenta_contable_debito=id_cuenta_contable_debito;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.es_debito=es_debito;
 		this.es_retencion_fuente=es_retencion_fuente;
 		this.con_secuencial=con_secuencial;
 		this.con_sub_total_factura=con_sub_total_factura;
 		this.con_iva_factura=con_iva_factura;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TablaRetencion tablaretencionLocal=null;
		
		if(object!=null) {
			tablaretencionLocal=(TablaRetencion)object;
			
			if(tablaretencionLocal!=null) {
				if(this.getId()!=null && tablaretencionLocal.getId()!=null) {
					if(this.getId().equals(tablaretencionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TablaRetencionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TablaRetencionConstantesFunciones.getTablaRetencionDescripcion(this);
		} else {
			sDetalle=TablaRetencionConstantesFunciones.getTablaRetencionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TablaRetencion getTablaRetencionOriginal() {
		return this.tablaretencionOriginal;
	}
	
	public void setTablaRetencionOriginal(TablaRetencion tablaretencion) {
		try {
			this.tablaretencionOriginal=tablaretencion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TablaRetencionAdditional tablaretencionAdditional=null;
	
	public TablaRetencionAdditional getTablaRetencionAdditional() {
		return this.tablaretencionAdditional;
	}
	
	public void setTablaRetencionAdditional(TablaRetencionAdditional tablaretencionAdditional) {
		try {
			this.tablaretencionAdditional=tablaretencionAdditional;
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
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getmonto_minimo() {
		return this.monto_minimo;
	}
    
	
	public Long getid_tipo_retencion() {
		return this.id_tipo_retencion;
	}
    
	
	public Long getid_cuenta_contable_debito() {
		return this.id_cuenta_contable_debito;
	}
    
	
	public Long getid_cuenta_contable_credito() {
		return this.id_cuenta_contable_credito;
	}
    
	
	public Boolean getes_debito() {
		return this.es_debito;
	}
    
	
	public Boolean getes_retencion_fuente() {
		return this.es_retencion_fuente;
	}
    
	
	public Boolean getcon_secuencial() {
		return this.con_secuencial;
	}
    
	
	public Boolean getcon_sub_total_factura() {
		return this.con_sub_total_factura;
	}
    
	
	public Boolean getcon_iva_factura() {
		return this.con_iva_factura;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TablaRetencion:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("TablaRetencion:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TablaRetencion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("TablaRetencion:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("TablaRetencion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("TablaRetencion:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
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
						System.out.println("TablaRetencion:Valor nulo no permitido en columna monto_minimo");
					}
				}

				this.monto_minimo=newmonto_minimo;
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
						System.out.println("TablaRetencion:Valor nulo no permitido en columna id_tipo_retencion");
					}
				}

				this.id_tipo_retencion=newid_tipo_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_debito(Long newid_cuenta_contable_debito)throws Exception
	{
		try {
			if(this.id_cuenta_contable_debito!=newid_cuenta_contable_debito) {
				if(newid_cuenta_contable_debito==null) {
					//newid_cuenta_contable_debito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TablaRetencion:Valor nulo no permitido en columna id_cuenta_contable_debito");
					}
				}

				this.id_cuenta_contable_debito=newid_cuenta_contable_debito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
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
    
	public void setes_debito(Boolean newes_debito)throws Exception
	{
		try {
			if(this.es_debito!=newes_debito) {
				if(newes_debito==null) {
					//newes_debito=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TablaRetencion:Valor nulo no permitido en columna es_debito");
					}
				}

				this.es_debito=newes_debito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_retencion_fuente(Boolean newes_retencion_fuente)throws Exception
	{
		try {
			if(this.es_retencion_fuente!=newes_retencion_fuente) {
				if(newes_retencion_fuente==null) {
					//newes_retencion_fuente=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TablaRetencion:Valor nulo no permitido en columna es_retencion_fuente");
					}
				}

				this.es_retencion_fuente=newes_retencion_fuente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_secuencial(Boolean newcon_secuencial)throws Exception
	{
		try {
			if(this.con_secuencial!=newcon_secuencial) {
				if(newcon_secuencial==null) {
					//newcon_secuencial=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TablaRetencion:Valor nulo no permitido en columna con_secuencial");
					}
				}

				this.con_secuencial=newcon_secuencial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_sub_total_factura(Boolean newcon_sub_total_factura)throws Exception
	{
		try {
			if(this.con_sub_total_factura!=newcon_sub_total_factura) {
				if(newcon_sub_total_factura==null) {
					//newcon_sub_total_factura=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TablaRetencion:Valor nulo no permitido en columna con_sub_total_factura");
					}
				}

				this.con_sub_total_factura=newcon_sub_total_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_iva_factura(Boolean newcon_iva_factura)throws Exception
	{
		try {
			if(this.con_iva_factura!=newcon_iva_factura) {
				if(newcon_iva_factura==null) {
					//newcon_iva_factura=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TablaRetencion:Valor nulo no permitido en columna con_iva_factura");
					}
				}

				this.con_iva_factura=newcon_iva_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoRetencion getTipoRetencion() {
		return this.tiporetencion;
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

	public String gettiporetencion_descripcion() {
		return this.tiporetencion_descripcion;
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


	public  void  setTipoRetencion(TipoRetencion tiporetencion) {
		try {
			this.tiporetencion=tiporetencion;
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


	public  void  settiporetencion_descripcion(String tiporetencion_descripcion) {
		try {
			this.tiporetencion_descripcion=tiporetencion_descripcion;
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
	String id_empresa_descripcion="";String id_tipo_retencion_descripcion="";String id_cuenta_contable_debito_descripcion="";String id_cuenta_contable_credito_descripcion="";String es_debito_descripcion="";String es_retencion_fuente_descripcion="";String con_secuencial_descripcion="";String con_sub_total_factura_descripcion="";String con_iva_factura_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_retencion_descripcion() {
		return id_tipo_retencion_descripcion;
	}
	public String getid_cuenta_contable_debito_descripcion() {
		return id_cuenta_contable_debito_descripcion;
	}
	public String getid_cuenta_contable_credito_descripcion() {
		return id_cuenta_contable_credito_descripcion;
	}
	public String getes_debito_descripcion() {
		return es_debito_descripcion;
	}
	public String getes_retencion_fuente_descripcion() {
		return es_retencion_fuente_descripcion;
	}
	public String getcon_secuencial_descripcion() {
		return con_secuencial_descripcion;
	}
	public String getcon_sub_total_factura_descripcion() {
		return con_sub_total_factura_descripcion;
	}
	public String getcon_iva_factura_descripcion() {
		return con_iva_factura_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_cuenta_contable_debito_descripcion(String newid_cuenta_contable_debito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_debito_descripcion=newid_cuenta_contable_debito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_credito_descripcion(String newid_cuenta_contable_credito_descripcion) {
		this.id_cuenta_contable_credito_descripcion=newid_cuenta_contable_credito_descripcion;
	}
	public void setes_debito_descripcion(String newes_debito_descripcion)throws Exception {
		try {
			this.es_debito_descripcion=newes_debito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_retencion_fuente_descripcion(String newes_retencion_fuente_descripcion)throws Exception {
		try {
			this.es_retencion_fuente_descripcion=newes_retencion_fuente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_secuencial_descripcion(String newcon_secuencial_descripcion)throws Exception {
		try {
			this.con_secuencial_descripcion=newcon_secuencial_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_sub_total_factura_descripcion(String newcon_sub_total_factura_descripcion)throws Exception {
		try {
			this.con_sub_total_factura_descripcion=newcon_sub_total_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_iva_factura_descripcion(String newcon_iva_factura_descripcion)throws Exception {
		try {
			this.con_iva_factura_descripcion=newcon_iva_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_retencion_descripcion="";this.id_cuenta_contable_debito_descripcion="";this.id_cuenta_contable_credito_descripcion="";this.es_debito_descripcion="";this.es_retencion_fuente_descripcion="";this.con_secuencial_descripcion="";this.con_sub_total_factura_descripcion="";this.con_iva_factura_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

