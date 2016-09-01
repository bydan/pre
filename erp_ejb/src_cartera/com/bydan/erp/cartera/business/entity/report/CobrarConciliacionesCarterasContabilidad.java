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
package com.bydan.erp.cartera.business.entity.report;

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
//import com.bydan.erp.cartera.util.CobrarConciliacionesCarterasContabilidadConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class CobrarConciliacionesCarterasContabilidad extends CobrarConciliacionesCarterasContabilidadAdditional implements Serializable ,Cloneable {//CobrarConciliacionesCarterasContabilidadAdditional,GeneralEntity
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
	
	private CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidadOriginal;
	
	private Map<String, Object> mapCobrarConciliacionesCarterasContabilidad;
			
	public Map<String, Object> getMapCobrarConciliacionesCarterasContabilidad() {
		return mapCobrarConciliacionesCarterasContabilidad;
	}

	public void setMapCobrarConciliacionesCarterasContabilidad(Map<String, Object> mapCobrarConciliacionesCarterasContabilidad) {
		this.mapCobrarConciliacionesCarterasContabilidad = mapCobrarConciliacionesCarterasContabilidad;
	}
	
	public void inicializarMapCobrarConciliacionesCarterasContabilidad() {
		this.mapCobrarConciliacionesCarterasContabilidad = new HashMap<String,Object>();
	}
	
	public void setMapCobrarConciliacionesCarterasContabilidadValue(String sKey,Object oValue) {
		this.mapCobrarConciliacionesCarterasContabilidad.put(sKey, oValue);
	}
	
	public Object getMapCobrarConciliacionesCarterasContabilidadValue(String sKey) {
		return this.mapCobrarConciliacionesCarterasContabilidad.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarConciliacionesCarterasContabilidadConstantesFunciones.SREGEXCODIGO,message=CobrarConciliacionesCarterasContabilidadConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarConciliacionesCarterasContabilidadConstantesFunciones.SREGEXCODIGO_TIPO_MOVIMIENTO,message=CobrarConciliacionesCarterasContabilidadConstantesFunciones.SMENSAJEREGEXCODIGO_TIPO_MOVIMIENTO)
	private String codigo_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarConciliacionesCarterasContabilidadConstantesFunciones.SREGEXNUMERO_MAYOR,message=CobrarConciliacionesCarterasContabilidadConstantesFunciones.SMENSAJEREGEXNUMERO_MAYOR)
	private String numero_mayor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double debito_asiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_asiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double debito_cuentas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_cuentas;
			
	
	public Empresa empresa;
	public CuentaContable cuentacontable;
	
	
	private String empresa_descripcion;
	private String cuentacontable_descripcion;
	
	
		
	public CobrarConciliacionesCarterasContabilidad () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cobrarconciliacionescarterascontabilidadOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cuenta_contable=-1L;
 		this.fecha_desde=new Date();
 		this.fecha_hasta=new Date();
 		this.codigo="";
 		this.codigo_tipo_movimiento="";
 		this.numero_mayor="";
 		this.debito_asiento=0.0;
 		this.credito_asiento=0.0;
 		this.debito_cuentas=0.0;
 		this.credito_cuentas=0.0;
		
		
		this.empresa=null;
		this.cuentacontable=null;
		
		
		this.empresa_descripcion="";
		this.cuentacontable_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CobrarConciliacionesCarterasContabilidad (Long id,Date versionRow,String codigo,String codigo_tipo_movimiento,String numero_mayor,Double debito_asiento,Double credito_asiento,Double debito_cuentas,Double credito_cuentas) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarconciliacionescarterascontabilidadOriginal=this;
		
 		this.codigo=codigo;
 		this.codigo_tipo_movimiento=codigo_tipo_movimiento;
 		this.numero_mayor=numero_mayor;
 		this.debito_asiento=debito_asiento;
 		this.credito_asiento=credito_asiento;
 		this.debito_cuentas=debito_cuentas;
 		this.credito_cuentas=credito_cuentas;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CobrarConciliacionesCarterasContabilidad (String codigo,String codigo_tipo_movimiento,String numero_mayor,Double debito_asiento,Double credito_asiento,Double debito_cuentas,Double credito_cuentas) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarconciliacionescarterascontabilidadOriginal=this;
		
 		this.codigo=codigo;
 		this.codigo_tipo_movimiento=codigo_tipo_movimiento;
 		this.numero_mayor=numero_mayor;
 		this.debito_asiento=debito_asiento;
 		this.credito_asiento=credito_asiento;
 		this.debito_cuentas=debito_cuentas;
 		this.credito_cuentas=credito_cuentas;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public CobrarConciliacionesCarterasContabilidad getCobrarConciliacionesCarterasContabilidadOriginal() {
		return this.cobrarconciliacionescarterascontabilidadOriginal;
	}
	
	public void setCobrarConciliacionesCarterasContabilidadOriginal(CobrarConciliacionesCarterasContabilidad cobrarconciliacionescarterascontabilidad) {
		try {
			this.cobrarconciliacionescarterascontabilidadOriginal=cobrarconciliacionescarterascontabilidad;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CobrarConciliacionesCarterasContabilidadAdditional cobrarconciliacionescarterascontabilidadAdditional=null;
	
	public CobrarConciliacionesCarterasContabilidadAdditional getCobrarConciliacionesCarterasContabilidadAdditional() {
		return this.cobrarconciliacionescarterascontabilidadAdditional;
	}
	
	public void setCobrarConciliacionesCarterasContabilidadAdditional(CobrarConciliacionesCarterasContabilidadAdditional cobrarconciliacionescarterascontabilidadAdditional) {
		try {
			this.cobrarconciliacionescarterascontabilidadAdditional=cobrarconciliacionescarterascontabilidadAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Date getfecha_desde() {
		return this.fecha_desde;
	}
    
	
	public Date getfecha_hasta() {
		return this.fecha_hasta;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getcodigo_tipo_movimiento() {
		return this.codigo_tipo_movimiento;
	}
    
	
	public String getnumero_mayor() {
		return this.numero_mayor;
	}
    
	
	public Double getdebito_asiento() {
		return this.debito_asiento;
	}
    
	
	public Double getcredito_asiento() {
		return this.credito_asiento;
	}
    
	
	public Double getdebito_cuentas() {
		return this.debito_cuentas;
	}
    
	
	public Double getcredito_cuentas() {
		return this.credito_cuentas;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarConciliacionesCarterasContabilidad:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("CobrarConciliacionesCarterasContabilidad:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_desde(Date newfecha_desde)throws Exception
	{
		try {
			if(this.fecha_desde!=newfecha_desde) {
				if(newfecha_desde==null) {
					//newfecha_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarConciliacionesCarterasContabilidad:Valor nulo no permitido en columna fecha_desde");
					}
				}

				this.fecha_desde=newfecha_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_hasta(Date newfecha_hasta)throws Exception
	{
		try {
			if(this.fecha_hasta!=newfecha_hasta) {
				if(newfecha_hasta==null) {
					//newfecha_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarConciliacionesCarterasContabilidad:Valor nulo no permitido en columna fecha_hasta");
					}
				}

				this.fecha_hasta=newfecha_hasta;
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
						System.out.println("CobrarConciliacionesCarterasContabilidad:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("CobrarConciliacionesCarterasContabilidad:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_tipo_movimiento(String newcodigo_tipo_movimiento)throws Exception
	{
		try {
			if(this.codigo_tipo_movimiento!=newcodigo_tipo_movimiento) {
				if(newcodigo_tipo_movimiento==null) {
					//newcodigo_tipo_movimiento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarConciliacionesCarterasContabilidad:Valor nulo no permitido en columna codigo_tipo_movimiento");
					}
				}

				if(newcodigo_tipo_movimiento!=null&&newcodigo_tipo_movimiento.length()>50) {
					newcodigo_tipo_movimiento=newcodigo_tipo_movimiento.substring(0,48);
					System.out.println("CobrarConciliacionesCarterasContabilidad:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_tipo_movimiento");
				}

				this.codigo_tipo_movimiento=newcodigo_tipo_movimiento;
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
						System.out.println("CobrarConciliacionesCarterasContabilidad:Valor nulo no permitido en columna numero_mayor");
					}
				}

				if(newnumero_mayor!=null&&newnumero_mayor.length()>100) {
					newnumero_mayor=newnumero_mayor.substring(0,98);
					System.out.println("CobrarConciliacionesCarterasContabilidad:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna numero_mayor");
				}

				this.numero_mayor=newnumero_mayor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdebito_asiento(Double newdebito_asiento)throws Exception
	{
		try {
			if(this.debito_asiento!=newdebito_asiento) {
				if(newdebito_asiento==null) {
					//newdebito_asiento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarConciliacionesCarterasContabilidad:Valor nulo no permitido en columna debito_asiento");
					}
				}

				this.debito_asiento=newdebito_asiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcredito_asiento(Double newcredito_asiento)throws Exception
	{
		try {
			if(this.credito_asiento!=newcredito_asiento) {
				if(newcredito_asiento==null) {
					//newcredito_asiento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarConciliacionesCarterasContabilidad:Valor nulo no permitido en columna credito_asiento");
					}
				}

				this.credito_asiento=newcredito_asiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdebito_cuentas(Double newdebito_cuentas)throws Exception
	{
		try {
			if(this.debito_cuentas!=newdebito_cuentas) {
				if(newdebito_cuentas==null) {
					//newdebito_cuentas=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarConciliacionesCarterasContabilidad:Valor nulo no permitido en columna debito_cuentas");
					}
				}

				this.debito_cuentas=newdebito_cuentas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcredito_cuentas(Double newcredito_cuentas)throws Exception
	{
		try {
			if(this.credito_cuentas!=newcredito_cuentas) {
				if(newcredito_cuentas==null) {
					//newcredito_cuentas=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarConciliacionesCarterasContabilidad:Valor nulo no permitido en columna credito_cuentas");
					}
				}

				this.credito_cuentas=newcredito_cuentas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cuenta_contable_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cuenta_contable_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

