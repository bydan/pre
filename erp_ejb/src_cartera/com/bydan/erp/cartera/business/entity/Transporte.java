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
package com.bydan.erp.cartera.business.entity;

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
//import com.bydan.erp.cartera.util.TransporteConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class Transporte extends TransporteAdditional implements Serializable ,Cloneable {//TransporteAdditional,GeneralEntity
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
	
	private Transporte transporteOriginal;
	
	private Map<String, Object> mapTransporte;
			
	public Map<String, Object> getMapTransporte() {
		return mapTransporte;
	}

	public void setMapTransporte(Map<String, Object> mapTransporte) {
		this.mapTransporte = mapTransporte;
	}
	
	public void inicializarMapTransporte() {
		this.mapTransporte = new HashMap<String,Object>();
	}
	
	public void setMapTransporteValue(String sKey,Object oValue) {
		this.mapTransporte.put(sKey, oValue);
	}
	
	public Object getMapTransporteValue(String sKey) {
		return this.mapTransporte.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_via_transporte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TransporteConstantesFunciones.SREGEXCODIGO,message=TransporteConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TransporteConstantesFunciones.SREGEXNOMBRE,message=TransporteConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	public Empresa empresa;
	public TipoViaTransporte tipoviatransporte;
	
	
	private String empresa_descripcion;
	private String tipoviatransporte_descripcion;
	
	
		
	public Transporte () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.transporteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_tipo_via_transporte=-1L;
 		this.codigo="";
 		this.nombre="";
		
		
		this.empresa=null;
		this.tipoviatransporte=null;
		
		
		this.empresa_descripcion="";
		this.tipoviatransporte_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Transporte (Long id,Date versionRow,Long id_empresa,Long id_tipo_via_transporte,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.transporteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_via_transporte=id_tipo_via_transporte;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Transporte (Long id_empresa,Long id_tipo_via_transporte,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.transporteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_via_transporte=id_tipo_via_transporte;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Transporte transporteLocal=null;
		
		if(object!=null) {
			transporteLocal=(Transporte)object;
			
			if(transporteLocal!=null) {
				if(this.getId()!=null && transporteLocal.getId()!=null) {
					if(this.getId().equals(transporteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TransporteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TransporteConstantesFunciones.getTransporteDescripcion(this);
		} else {
			sDetalle=TransporteConstantesFunciones.getTransporteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Transporte getTransporteOriginal() {
		return this.transporteOriginal;
	}
	
	public void setTransporteOriginal(Transporte transporte) {
		try {
			this.transporteOriginal=transporte;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TransporteAdditional transporteAdditional=null;
	
	public TransporteAdditional getTransporteAdditional() {
		return this.transporteAdditional;
	}
	
	public void setTransporteAdditional(TransporteAdditional transporteAdditional) {
		try {
			this.transporteAdditional=transporteAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_tipo_via_transporte() {
		return this.id_tipo_via_transporte;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transporte:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_via_transporte(Long newid_tipo_via_transporte)throws Exception
	{
		try {
			if(this.id_tipo_via_transporte!=newid_tipo_via_transporte) {
				if(newid_tipo_via_transporte==null) {
					//newid_tipo_via_transporte=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transporte:Valor nulo no permitido en columna id_tipo_via_transporte");
					}
				}

				this.id_tipo_via_transporte=newid_tipo_via_transporte;
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
						System.out.println("Transporte:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Transporte:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Transporte:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("Transporte:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoViaTransporte getTipoViaTransporte() {
		return this.tipoviatransporte;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipoviatransporte_descripcion() {
		return this.tipoviatransporte_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoViaTransporte(TipoViaTransporte tipoviatransporte) {
		try {
			this.tipoviatransporte=tipoviatransporte;
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


	public  void  settipoviatransporte_descripcion(String tipoviatransporte_descripcion) {
		try {
			this.tipoviatransporte_descripcion=tipoviatransporte_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_via_transporte_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_via_transporte_descripcion() {
		return id_tipo_via_transporte_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_via_transporte_descripcion(String newid_tipo_via_transporte_descripcion)throws Exception {
		try {
			this.id_tipo_via_transporte_descripcion=newid_tipo_via_transporte_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_via_transporte_descripcion="";
	}
	
	
	Object notacreditosolisDescripcionReporte;
	Object politicasclientesDescripcionReporte;
	Object guiaremisionsDescripcionReporte;
	Object pedidoexporsDescripcionReporte;
	Object proformasDescripcionReporte;
	Object facturasDescripcionReporte;
	Object pedidosDescripcionReporte;
	Object consignacionsDescripcionReporte;
	Object notacreditosDescripcionReporte;
	
	
	public Object getnotacreditosolisDescripcionReporte() {
		return notacreditosolisDescripcionReporte;
	}

	public Object getpoliticasclientesDescripcionReporte() {
		return politicasclientesDescripcionReporte;
	}

	public Object getguiaremisionsDescripcionReporte() {
		return guiaremisionsDescripcionReporte;
	}

	public Object getpedidoexporsDescripcionReporte() {
		return pedidoexporsDescripcionReporte;
	}

	public Object getproformasDescripcionReporte() {
		return proformasDescripcionReporte;
	}

	public Object getfacturasDescripcionReporte() {
		return facturasDescripcionReporte;
	}

	public Object getpedidosDescripcionReporte() {
		return pedidosDescripcionReporte;
	}

	public Object getconsignacionsDescripcionReporte() {
		return consignacionsDescripcionReporte;
	}

	public Object getnotacreditosDescripcionReporte() {
		return notacreditosDescripcionReporte;
	}

	
	
	public  void  setnotacreditosolisDescripcionReporte(Object notacreditosolis) {
		try {
			this.notacreditosolisDescripcionReporte=notacreditosolis;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpoliticasclientesDescripcionReporte(Object politicasclientes) {
		try {
			this.politicasclientesDescripcionReporte=politicasclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setguiaremisionsDescripcionReporte(Object guiaremisions) {
		try {
			this.guiaremisionsDescripcionReporte=guiaremisions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidoexporsDescripcionReporte(Object pedidoexpors) {
		try {
			this.pedidoexporsDescripcionReporte=pedidoexpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproformasDescripcionReporte(Object proformas) {
		try {
			this.proformasDescripcionReporte=proformas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfacturasDescripcionReporte(Object facturas) {
		try {
			this.facturasDescripcionReporte=facturas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidosDescripcionReporte(Object pedidos) {
		try {
			this.pedidosDescripcionReporte=pedidos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setconsignacionsDescripcionReporte(Object consignacions) {
		try {
			this.consignacionsDescripcionReporte=consignacions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnotacreditosDescripcionReporte(Object notacreditos) {
		try {
			this.notacreditosDescripcionReporte=notacreditos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

