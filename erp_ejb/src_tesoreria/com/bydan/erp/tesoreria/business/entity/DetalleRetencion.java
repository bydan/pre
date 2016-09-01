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
//import com.bydan.erp.tesoreria.util.DetalleRetencionConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class DetalleRetencion extends DetalleRetencionAdditional implements Serializable ,Cloneable {//DetalleRetencionAdditional,GeneralEntity
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
	
	private DetalleRetencion detalleretencionOriginal;
	
	private Map<String, Object> mapDetalleRetencion;
			
	public Map<String, Object> getMapDetalleRetencion() {
		return mapDetalleRetencion;
	}

	public void setMapDetalleRetencion(Map<String, Object> mapDetalleRetencion) {
		this.mapDetalleRetencion = mapDetalleRetencion;
	}
	
	public void inicializarMapDetalleRetencion() {
		this.mapDetalleRetencion = new HashMap<String,Object>();
	}
	
	public void setMapDetalleRetencionValue(String sKey,Object oValue) {
		this.mapDetalleRetencion.put(sKey, oValue);
	}
	
	public Object getMapDetalleRetencionValue(String sKey) {
		return this.mapDetalleRetencion.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleRetencionConstantesFunciones.SREGEXDESCRIPCION,message=DetalleRetencionConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_minimo;
			
	
	public Empresa empresa;
	public Empresa empresadestino;
	public CuentaContable cuentacontable;
	public CuentaContable cuentacontablecredito;
	
	
	private String empresa_descripcion;
	private String empresadestino_descripcion;
	private String cuentacontable_descripcion;
	private String cuentacontablecredito_descripcion;
	
	
		
	public DetalleRetencion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalleretencionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empresa_destino=-1L;
 		this.id_cuenta_contable=-1L;
 		this.id_cuenta_contable_credito=-1L;
 		this.descripcion="";
 		this.porcentaje=0.0;
 		this.monto_minimo=0.0;
		
		
		this.empresa=null;
		this.empresadestino=null;
		this.cuentacontable=null;
		this.cuentacontablecredito=null;
		
		
		this.empresa_descripcion="";
		this.empresadestino_descripcion="";
		this.cuentacontable_descripcion="";
		this.cuentacontablecredito_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleRetencion (Long id,Date versionRow,Long id_empresa,Long id_empresa_destino,Long id_cuenta_contable,Long id_cuenta_contable_credito,String descripcion,Double porcentaje,Double monto_minimo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleretencionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empresa_destino=id_empresa_destino;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.descripcion=descripcion;
 		this.porcentaje=porcentaje;
 		this.monto_minimo=monto_minimo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleRetencion (Long id_empresa,Long id_empresa_destino,Long id_cuenta_contable,Long id_cuenta_contable_credito,String descripcion,Double porcentaje,Double monto_minimo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleretencionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empresa_destino=id_empresa_destino;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.descripcion=descripcion;
 		this.porcentaje=porcentaje;
 		this.monto_minimo=monto_minimo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleRetencion detalleretencionLocal=null;
		
		if(object!=null) {
			detalleretencionLocal=(DetalleRetencion)object;
			
			if(detalleretencionLocal!=null) {
				if(this.getId()!=null && detalleretencionLocal.getId()!=null) {
					if(this.getId().equals(detalleretencionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleRetencionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleRetencionConstantesFunciones.getDetalleRetencionDescripcion(this);
		} else {
			sDetalle=DetalleRetencionConstantesFunciones.getDetalleRetencionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleRetencion getDetalleRetencionOriginal() {
		return this.detalleretencionOriginal;
	}
	
	public void setDetalleRetencionOriginal(DetalleRetencion detalleretencion) {
		try {
			this.detalleretencionOriginal=detalleretencion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleRetencionAdditional detalleretencionAdditional=null;
	
	public DetalleRetencionAdditional getDetalleRetencionAdditional() {
		return this.detalleretencionAdditional;
	}
	
	public void setDetalleRetencionAdditional(DetalleRetencionAdditional detalleretencionAdditional) {
		try {
			this.detalleretencionAdditional=detalleretencionAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_empresa_destino() {
		return this.id_empresa_destino;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_cuenta_contable_credito() {
		return this.id_cuenta_contable_credito;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getmonto_minimo() {
		return this.monto_minimo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleRetencion:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa_destino(Long newid_empresa_destino)throws Exception
	{
		try {
			if(this.id_empresa_destino!=newid_empresa_destino) {
				if(newid_empresa_destino==null) {
					//newid_empresa_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleRetencion:Valor nulo no permitido en columna id_empresa_destino");
					}
				}

				this.id_empresa_destino=newid_empresa_destino;
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
						System.out.println("DetalleRetencion:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
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
						System.out.println("DetalleRetencion:Valor nulo no permitido en columna id_cuenta_contable_credito");
					}
				}

				this.id_cuenta_contable_credito=newid_cuenta_contable_credito;
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
						System.out.println("DetalleRetencion:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("DetalleRetencion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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
						System.out.println("DetalleRetencion:Valor nulo no permitido en columna porcentaje");
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
						System.out.println("DetalleRetencion:Valor nulo no permitido en columna monto_minimo");
					}
				}

				this.monto_minimo=newmonto_minimo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Empresa getEmpresaDestino() {
		return this.empresadestino;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public CuentaContable getCuentaContableCredito() {
		return this.cuentacontablecredito;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempresadestino_descripcion() {
		return this.empresadestino_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
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


	public  void  setEmpresaDestino(Empresa empresadestino) {
		try {
			this.empresadestino=empresadestino;
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


	public  void  setempresadestino_descripcion(String empresadestino_descripcion) {
		try {
			this.empresadestino_descripcion=empresadestino_descripcion;
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


	public  void  setcuentacontablecredito_descripcion(String cuentacontablecredito_descripcion) {
		try {
			this.cuentacontablecredito_descripcion=cuentacontablecredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empresa_destino_descripcion="";String id_cuenta_contable_descripcion="";String id_cuenta_contable_credito_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empresa_destino_descripcion() {
		return id_empresa_destino_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
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
	public void setid_empresa_destino_descripcion(String newid_empresa_destino_descripcion)throws Exception {
		try {
			this.id_empresa_destino_descripcion=newid_empresa_destino_descripcion;
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
	public void setid_cuenta_contable_credito_descripcion(String newid_cuenta_contable_credito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_credito_descripcion=newid_cuenta_contable_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empresa_destino_descripcion="";this.id_cuenta_contable_descripcion="";this.id_cuenta_contable_credito_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

