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
//import com.bydan.erp.contabilidad.util.TipoTransaccionModuloConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.sris.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.sris.business.entity.*;




@SuppressWarnings("unused")
public class TipoTransaccionModulo extends TipoTransaccionModuloAdditional implements Serializable ,Cloneable {//TipoTransaccionModuloAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected Long idOriginal;
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
	
	public Long getIdOriginal() {
		return this.idOriginal;
	}
	
	public void setIdOriginal(Long newIdOriginal) {		
		this.idOriginal=newIdOriginal;
		super.setIdOriginal(newIdOriginal);
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
	
	private TipoTransaccionModulo tipotransaccionmoduloOriginal;
	
	private Map<String, Object> mapTipoTransaccionModulo;
			
	public Map<String, Object> getMapTipoTransaccionModulo() {
		return mapTipoTransaccionModulo;
	}

	public void setMapTipoTransaccionModulo(Map<String, Object> mapTipoTransaccionModulo) {
		this.mapTipoTransaccionModulo = mapTipoTransaccionModulo;
	}
	
	public void inicializarMapTipoTransaccionModulo() {
		this.mapTipoTransaccionModulo = new HashMap<String,Object>();
	}
	
	public void setMapTipoTransaccionModuloValue(String sKey,Object oValue) {
		this.mapTipoTransaccionModulo.put(sKey, oValue);
	}
	
	public Object getMapTipoTransaccionModuloValue(String sKey) {
		return this.mapTipoTransaccionModulo.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoTransaccionModuloConstantesFunciones.SREGEXNOMBRE,message=TipoTransaccionModuloConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoTransaccionModuloConstantesFunciones.SREGEXSIGLAS,message=TipoTransaccionModuloConstantesFunciones.SMENSAJEREGEXSIGLAS)
	private String siglas;
			
	
	public Modulo modulo;
	
	
	private String modulo_descripcion;
	
	
		
	public TipoTransaccionModulo () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipotransaccionmoduloOriginal=this;
		
 		this.id_modulo=-1L;
 		this.nombre="";
 		this.siglas="";
		
		
		this.modulo=null;
		
		
		this.modulo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoTransaccionModulo (Long id,Date versionRow,Long id_modulo,String nombre,String siglas) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipotransaccionmoduloOriginal=this;
		
 		this.id_modulo=id_modulo;
 		this.nombre=nombre;
 		this.siglas=siglas;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoTransaccionModulo (Long id_modulo,String nombre,String siglas) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipotransaccionmoduloOriginal=this;
		
 		this.id_modulo=id_modulo;
 		this.nombre=nombre;
 		this.siglas=siglas;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoTransaccionModulo tipotransaccionmoduloLocal=null;
		
		if(object!=null) {
			tipotransaccionmoduloLocal=(TipoTransaccionModulo)object;
			
			if(tipotransaccionmoduloLocal!=null) {
				if(this.getId()!=null && tipotransaccionmoduloLocal.getId()!=null) {
					if(this.getId().equals(tipotransaccionmoduloLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoTransaccionModuloConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(this);
		} else {
			sDetalle=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoTransaccionModulo getTipoTransaccionModuloOriginal() {
		return this.tipotransaccionmoduloOriginal;
	}
	
	public void setTipoTransaccionModuloOriginal(TipoTransaccionModulo tipotransaccionmodulo) {
		try {
			this.tipotransaccionmoduloOriginal=tipotransaccionmodulo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoTransaccionModuloAdditional tipotransaccionmoduloAdditional=null;
	
	public TipoTransaccionModuloAdditional getTipoTransaccionModuloAdditional() {
		return this.tipotransaccionmoduloAdditional;
	}
	
	public void setTipoTransaccionModuloAdditional(TipoTransaccionModuloAdditional tipotransaccionmoduloAdditional) {
		try {
			this.tipotransaccionmoduloAdditional=tipotransaccionmoduloAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getsiglas() {
		return this.siglas;
	}
	
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoTransaccionModulo:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
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
						System.out.println("TipoTransaccionModulo:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoTransaccionModulo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsiglas(String newsiglas)throws Exception
	{
		try {
			if(this.siglas!=newsiglas) {
				if(newsiglas==null) {
					//newsiglas="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoTransaccionModulo:Valor nulo no permitido en columna siglas");
					}
				}

				if(newsiglas!=null&&newsiglas.length()>20) {
					newsiglas=newsiglas.substring(0,18);
					System.out.println("TipoTransaccionModulo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna siglas");
				}

				this.siglas=newsiglas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Modulo getModulo() {
		return this.modulo;
	}

	
	
	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	
	
	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_modulo_descripcion="";
	
	
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	
	
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_modulo_descripcion="";
	}
	
	
	Object detalleclientesDescripcionReporte;
	Object movimientoinventariosDescripcionReporte;
	Object formapagosDescripcionReporte;
	Object comprasDescripcionReporte;
	Object facturaproveedorserviciosDescripcionReporte;
	Object detalledocumentosDescripcionReporte;
	Object asientocontablecajachicasDescripcionReporte;
	Object tipoformapagosDescripcionReporte;
	Object definicionsDescripcionReporte;
	Object parametroproductosDescripcionReporte;
	Object detalleasientocontablecajachicasDescripcionReporte;
	Object facturaproveedorsDescripcionReporte;
	Object detalleprovesDescripcionReporte;
	Object transaccionsDescripcionReporte;
	Object ordencomprasDescripcionReporte;
	Object cuentaporcobrarsDescripcionReporte;
	Object detallemoviclienprovesDescripcionReporte;
	Object transferenciasDescripcionReporte;
	
	
	public Object getdetalleclientesDescripcionReporte() {
		return detalleclientesDescripcionReporte;
	}

	public Object getmovimientoinventariosDescripcionReporte() {
		return movimientoinventariosDescripcionReporte;
	}

	public Object getformapagosDescripcionReporte() {
		return formapagosDescripcionReporte;
	}

	public Object getcomprasDescripcionReporte() {
		return comprasDescripcionReporte;
	}

	public Object getfacturaproveedorserviciosDescripcionReporte() {
		return facturaproveedorserviciosDescripcionReporte;
	}

	public Object getdetalledocumentosDescripcionReporte() {
		return detalledocumentosDescripcionReporte;
	}

	public Object getasientocontablecajachicasDescripcionReporte() {
		return asientocontablecajachicasDescripcionReporte;
	}

	public Object gettipoformapagosDescripcionReporte() {
		return tipoformapagosDescripcionReporte;
	}

	public Object getdefinicionsDescripcionReporte() {
		return definicionsDescripcionReporte;
	}

	public Object getparametroproductosDescripcionReporte() {
		return parametroproductosDescripcionReporte;
	}

	public Object getdetalleasientocontablecajachicasDescripcionReporte() {
		return detalleasientocontablecajachicasDescripcionReporte;
	}

	public Object getfacturaproveedorsDescripcionReporte() {
		return facturaproveedorsDescripcionReporte;
	}

	public Object getdetalleprovesDescripcionReporte() {
		return detalleprovesDescripcionReporte;
	}

	public Object gettransaccionsDescripcionReporte() {
		return transaccionsDescripcionReporte;
	}

	public Object getordencomprasDescripcionReporte() {
		return ordencomprasDescripcionReporte;
	}

	public Object getcuentaporcobrarsDescripcionReporte() {
		return cuentaporcobrarsDescripcionReporte;
	}

	public Object getdetallemoviclienprovesDescripcionReporte() {
		return detallemoviclienprovesDescripcionReporte;
	}

	public Object gettransferenciasDescripcionReporte() {
		return transferenciasDescripcionReporte;
	}

	
	
	public  void  setdetalleclientesDescripcionReporte(Object detalleclientes) {
		try {
			this.detalleclientesDescripcionReporte=detalleclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setmovimientoinventariosDescripcionReporte(Object movimientoinventarios) {
		try {
			this.movimientoinventariosDescripcionReporte=movimientoinventarios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setformapagosDescripcionReporte(Object formapagos) {
		try {
			this.formapagosDescripcionReporte=formapagos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomprasDescripcionReporte(Object compras) {
		try {
			this.comprasDescripcionReporte=compras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfacturaproveedorserviciosDescripcionReporte(Object facturaproveedorservicios) {
		try {
			this.facturaproveedorserviciosDescripcionReporte=facturaproveedorservicios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalledocumentosDescripcionReporte(Object detalledocumentos) {
		try {
			this.detalledocumentosDescripcionReporte=detalledocumentos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setasientocontablecajachicasDescripcionReporte(Object asientocontablecajachicas) {
		try {
			this.asientocontablecajachicasDescripcionReporte=asientocontablecajachicas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settipoformapagosDescripcionReporte(Object tipoformapagos) {
		try {
			this.tipoformapagosDescripcionReporte=tipoformapagos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdefinicionsDescripcionReporte(Object definicions) {
		try {
			this.definicionsDescripcionReporte=definicions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametroproductosDescripcionReporte(Object parametroproductos) {
		try {
			this.parametroproductosDescripcionReporte=parametroproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleasientocontablecajachicasDescripcionReporte(Object detalleasientocontablecajachicas) {
		try {
			this.detalleasientocontablecajachicasDescripcionReporte=detalleasientocontablecajachicas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfacturaproveedorsDescripcionReporte(Object facturaproveedors) {
		try {
			this.facturaproveedorsDescripcionReporte=facturaproveedors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleprovesDescripcionReporte(Object detalleproves) {
		try {
			this.detalleprovesDescripcionReporte=detalleproves;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settransaccionsDescripcionReporte(Object transaccions) {
		try {
			this.transaccionsDescripcionReporte=transaccions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setordencomprasDescripcionReporte(Object ordencompras) {
		try {
			this.ordencomprasDescripcionReporte=ordencompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcuentaporcobrarsDescripcionReporte(Object cuentaporcobrars) {
		try {
			this.cuentaporcobrarsDescripcionReporte=cuentaporcobrars;
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

	public  void  settransferenciasDescripcionReporte(Object transferencias) {
		try {
			this.transferenciasDescripcionReporte=transferencias;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

