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
//import com.bydan.erp.cartera.util.RutaTransporteConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class RutaTransporte extends RutaTransporteAdditional implements Serializable ,Cloneable {//RutaTransporteAdditional,GeneralEntity
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
	
	private RutaTransporte rutatransporteOriginal;
	
	private Map<String, Object> mapRutaTransporte;
			
	public Map<String, Object> getMapRutaTransporte() {
		return mapRutaTransporte;
	}

	public void setMapRutaTransporte(Map<String, Object> mapRutaTransporte) {
		this.mapRutaTransporte = mapRutaTransporte;
	}
	
	public void inicializarMapRutaTransporte() {
		this.mapRutaTransporte = new HashMap<String,Object>();
	}
	
	public void setMapRutaTransporteValue(String sKey,Object oValue) {
		this.mapRutaTransporte.put(sKey, oValue);
	}
	
	public Object getMapRutaTransporteValue(String sKey) {
		return this.mapRutaTransporte.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RutaTransporteConstantesFunciones.SREGEXNOMBRE,message=RutaTransporteConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RutaTransporteConstantesFunciones.SREGEXORIGEN,message=RutaTransporteConstantesFunciones.SMENSAJEREGEXORIGEN)
	private String origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RutaTransporteConstantesFunciones.SREGEXDESTINO,message=RutaTransporteConstantesFunciones.SMENSAJEREGEXDESTINO)
	private String destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
	public List<Proforma> proformas;
	public List<Pedido> pedidos;
	public List<ServicioTransporte> serviciotransportes;
		
	public RutaTransporte () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.rutatransporteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre="";
 		this.origen="";
 		this.destino="";
 		this.precio=0.0;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		this.proformas=null;
		this.pedidos=null;
		this.serviciotransportes=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public RutaTransporte (Long id,Date versionRow,Long id_empresa,String nombre,String origen,String destino,Double precio) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.rutatransporteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.origen=origen;
 		this.destino=destino;
 		this.precio=precio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public RutaTransporte (Long id_empresa,String nombre,String origen,String destino,Double precio) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.rutatransporteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.origen=origen;
 		this.destino=destino;
 		this.precio=precio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		RutaTransporte rutatransporteLocal=null;
		
		if(object!=null) {
			rutatransporteLocal=(RutaTransporte)object;
			
			if(rutatransporteLocal!=null) {
				if(this.getId()!=null && rutatransporteLocal.getId()!=null) {
					if(this.getId().equals(rutatransporteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!RutaTransporteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=RutaTransporteConstantesFunciones.getRutaTransporteDescripcion(this);
		} else {
			sDetalle=RutaTransporteConstantesFunciones.getRutaTransporteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public RutaTransporte getRutaTransporteOriginal() {
		return this.rutatransporteOriginal;
	}
	
	public void setRutaTransporteOriginal(RutaTransporte rutatransporte) {
		try {
			this.rutatransporteOriginal=rutatransporte;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected RutaTransporteAdditional rutatransporteAdditional=null;
	
	public RutaTransporteAdditional getRutaTransporteAdditional() {
		return this.rutatransporteAdditional;
	}
	
	public void setRutaTransporteAdditional(RutaTransporteAdditional rutatransporteAdditional) {
		try {
			this.rutatransporteAdditional=rutatransporteAdditional;
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
    
	
	public String getorigen() {
		return this.origen;
	}
    
	
	public String getdestino() {
		return this.destino;
	}
    
	
	public Double getprecio() {
		return this.precio;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RutaTransporte:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("RutaTransporte:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("RutaTransporte:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setorigen(String neworigen)throws Exception
	{
		try {
			if(this.origen!=neworigen) {
				if(neworigen==null) {
					//neworigen="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RutaTransporte:Valor nulo no permitido en columna origen");
					}
				}

				if(neworigen!=null&&neworigen.length()>150) {
					neworigen=neworigen.substring(0,148);
					System.out.println("RutaTransporte:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna origen");
				}

				this.origen=neworigen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdestino(String newdestino)throws Exception
	{
		try {
			if(this.destino!=newdestino) {
				if(newdestino==null) {
					//newdestino="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RutaTransporte:Valor nulo no permitido en columna destino");
					}
				}

				if(newdestino!=null&&newdestino.length()>150) {
					newdestino=newdestino.substring(0,148);
					System.out.println("RutaTransporte:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna destino");
				}

				this.destino=newdestino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecio(Double newprecio)throws Exception
	{
		try {
			if(this.precio!=newprecio) {
				if(newprecio==null) {
					//newprecio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RutaTransporte:Valor nulo no permitido en columna precio");
					}
				}

				this.precio=newprecio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	
	
	public List<Proforma> getProformas() {
		return this.proformas;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public List<ServicioTransporte> getServicioTransportes() {
		return this.serviciotransportes;
	}

	
	
	public  void  setProformas(List<Proforma> proformas) {
		try {
			this.proformas=proformas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPedidos(List<Pedido> pedidos) {
		try {
			this.pedidos=pedidos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setServicioTransportes(List<ServicioTransporte> serviciotransportes) {
		try {
			this.serviciotransportes=serviciotransportes;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";
	}
	
	
	Object proformasDescripcionReporte;
	Object pedidosDescripcionReporte;
	Object serviciotransportesDescripcionReporte;
	
	
	public Object getproformasDescripcionReporte() {
		return proformasDescripcionReporte;
	}

	public Object getpedidosDescripcionReporte() {
		return pedidosDescripcionReporte;
	}

	public Object getserviciotransportesDescripcionReporte() {
		return serviciotransportesDescripcionReporte;
	}

	
	
	public  void  setproformasDescripcionReporte(Object proformas) {
		try {
			this.proformasDescripcionReporte=proformas;
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

	public  void  setserviciotransportesDescripcionReporte(Object serviciotransportes) {
		try {
			this.serviciotransportesDescripcionReporte=serviciotransportes;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

