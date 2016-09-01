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
package com.bydan.erp.inventario.business.entity;

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
//import com.bydan.erp.inventario.util.RecargoCompraConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class RecargoCompra extends RecargoCompraAdditional implements Serializable ,Cloneable {//RecargoCompraAdditional,GeneralEntity
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
	
	private RecargoCompra recargocompraOriginal;
	
	private Map<String, Object> mapRecargoCompra;
			
	public Map<String, Object> getMapRecargoCompra() {
		return mapRecargoCompra;
	}

	public void setMapRecargoCompra(Map<String, Object> mapRecargoCompra) {
		this.mapRecargoCompra = mapRecargoCompra;
	}
	
	public void inicializarMapRecargoCompra() {
		this.mapRecargoCompra = new HashMap<String,Object>();
	}
	
	public void setMapRecargoCompraValue(String sKey,Object oValue) {
		this.mapRecargoCompra.put(sKey, oValue);
	}
	
	public Object getMapRecargoCompraValue(String sKey) {
		return this.mapRecargoCompra.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RecargoCompraConstantesFunciones.SREGEXNOMBRE,message=RecargoCompraConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_debito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_servicio;
			
	
	public Empresa empresa;
	public CuentaContable cuentacontabledebito;
	public CuentaContable cuentacontablecredito;
	
	
	private String empresa_descripcion;
	private String cuentacontabledebito_descripcion;
	private String cuentacontablecredito_descripcion;
	
	
		
	public RecargoCompra () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.recargocompraOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre="";
 		this.id_cuenta_contable_debito=-1L;
 		this.id_cuenta_contable_credito=-1L;
 		this.es_servicio=false;
		
		
		this.empresa=null;
		this.cuentacontabledebito=null;
		this.cuentacontablecredito=null;
		
		
		this.empresa_descripcion="";
		this.cuentacontabledebito_descripcion="";
		this.cuentacontablecredito_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public RecargoCompra (Long id,Date versionRow,Long id_empresa,String nombre,Long id_cuenta_contable_debito,Long id_cuenta_contable_credito,Boolean es_servicio) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.recargocompraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.id_cuenta_contable_debito=id_cuenta_contable_debito;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.es_servicio=es_servicio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public RecargoCompra (Long id_empresa,String nombre,Long id_cuenta_contable_debito,Long id_cuenta_contable_credito,Boolean es_servicio) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.recargocompraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.id_cuenta_contable_debito=id_cuenta_contable_debito;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.es_servicio=es_servicio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		RecargoCompra recargocompraLocal=null;
		
		if(object!=null) {
			recargocompraLocal=(RecargoCompra)object;
			
			if(recargocompraLocal!=null) {
				if(this.getId()!=null && recargocompraLocal.getId()!=null) {
					if(this.getId().equals(recargocompraLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!RecargoCompraConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=RecargoCompraConstantesFunciones.getRecargoCompraDescripcion(this);
		} else {
			sDetalle=RecargoCompraConstantesFunciones.getRecargoCompraDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public RecargoCompra getRecargoCompraOriginal() {
		return this.recargocompraOriginal;
	}
	
	public void setRecargoCompraOriginal(RecargoCompra recargocompra) {
		try {
			this.recargocompraOriginal=recargocompra;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected RecargoCompraAdditional recargocompraAdditional=null;
	
	public RecargoCompraAdditional getRecargoCompraAdditional() {
		return this.recargocompraAdditional;
	}
	
	public void setRecargoCompraAdditional(RecargoCompraAdditional recargocompraAdditional) {
		try {
			this.recargocompraAdditional=recargocompraAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Long getid_cuenta_contable_debito() {
		return this.id_cuenta_contable_debito;
	}
    
	
	public Long getid_cuenta_contable_credito() {
		return this.id_cuenta_contable_credito;
	}
    
	
	public Boolean getes_servicio() {
		return this.es_servicio;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RecargoCompra:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("RecargoCompra:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("RecargoCompra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("RecargoCompra:Valor nulo no permitido en columna id_cuenta_contable_debito");
					}
				}

				this.id_cuenta_contable_debito=newid_cuenta_contable_debito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_credito(Long newid_cuenta_contable_credito)throws Exception
	{
		try {
			if(this.id_cuenta_contable_credito!=newid_cuenta_contable_credito) {
				if(newid_cuenta_contable_credito==null) {
					//newid_cuenta_contable_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RecargoCompra:Valor nulo no permitido en columna id_cuenta_contable_credito");
					}
				}

				this.id_cuenta_contable_credito=newid_cuenta_contable_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_servicio(Boolean newes_servicio)throws Exception
	{
		try {
			if(this.es_servicio!=newes_servicio) {
				if(newes_servicio==null) {
					//newes_servicio=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RecargoCompra:Valor nulo no permitido en columna es_servicio");
					}
				}

				this.es_servicio=newes_servicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
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
	String id_empresa_descripcion="";String id_cuenta_contable_debito_descripcion="";String id_cuenta_contable_credito_descripcion="";String es_servicio_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cuenta_contable_debito_descripcion() {
		return id_cuenta_contable_debito_descripcion;
	}
	public String getid_cuenta_contable_credito_descripcion() {
		return id_cuenta_contable_credito_descripcion;
	}
	public String getes_servicio_descripcion() {
		return es_servicio_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setes_servicio_descripcion(String newes_servicio_descripcion)throws Exception {
		try {
			this.es_servicio_descripcion=newes_servicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cuenta_contable_debito_descripcion="";this.id_cuenta_contable_credito_descripcion="";this.es_servicio_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

