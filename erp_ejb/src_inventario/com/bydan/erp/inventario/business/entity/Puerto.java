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
//import com.bydan.erp.inventario.util.PuertoConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class Puerto extends PuertoAdditional implements Serializable ,Cloneable {//PuertoAdditional,GeneralEntity
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
	
	private Puerto puertoOriginal;
	
	private Map<String, Object> mapPuerto;
			
	public Map<String, Object> getMapPuerto() {
		return mapPuerto;
	}

	public void setMapPuerto(Map<String, Object> mapPuerto) {
		this.mapPuerto = mapPuerto;
	}
	
	public void inicializarMapPuerto() {
		this.mapPuerto = new HashMap<String,Object>();
	}
	
	public void setMapPuertoValue(String sKey,Object oValue) {
		this.mapPuerto.put(sKey, oValue);
	}
	
	public Object getMapPuertoValue(String sKey) {
		return this.mapPuerto.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_puerto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PuertoConstantesFunciones.SREGEXNOMBRE,message=PuertoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=PuertoConstantesFunciones.SREGEXDESCRIPCION,message=PuertoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public TipoPuerto tipopuerto;
	public Pais pais;
	
	
	private String tipopuerto_descripcion;
	private String pais_descripcion;
	
	
	public List<PedidoCompraImpor> pedidocompraimpors;
	public List<LiquidacionImpor> liquidacionimpors;
	public List<Embarcador> embarcadors;
		
	public Puerto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.puertoOriginal=this;
		
 		this.id_tipo_puerto=-1L;
 		this.id_pais=-1L;
 		this.nombre="";
 		this.es_local=false;
 		this.descripcion="";
		
		
		this.tipopuerto=null;
		this.pais=null;
		
		
		this.tipopuerto_descripcion="";
		this.pais_descripcion="";
		
		
		this.pedidocompraimpors=null;
		this.liquidacionimpors=null;
		this.embarcadors=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Puerto (Long id,Date versionRow,Long id_tipo_puerto,Long id_pais,String nombre,Boolean es_local,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.puertoOriginal=this;
		
 		this.id_tipo_puerto=id_tipo_puerto;
 		this.id_pais=id_pais;
 		this.nombre=nombre;
 		this.es_local=es_local;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Puerto (Long id_tipo_puerto,Long id_pais,String nombre,Boolean es_local,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.puertoOriginal=this;
		
 		this.id_tipo_puerto=id_tipo_puerto;
 		this.id_pais=id_pais;
 		this.nombre=nombre;
 		this.es_local=es_local;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Puerto puertoLocal=null;
		
		if(object!=null) {
			puertoLocal=(Puerto)object;
			
			if(puertoLocal!=null) {
				if(this.getId()!=null && puertoLocal.getId()!=null) {
					if(this.getId().equals(puertoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PuertoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PuertoConstantesFunciones.getPuertoDescripcion(this);
		} else {
			sDetalle=PuertoConstantesFunciones.getPuertoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Puerto getPuertoOriginal() {
		return this.puertoOriginal;
	}
	
	public void setPuertoOriginal(Puerto puerto) {
		try {
			this.puertoOriginal=puerto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PuertoAdditional puertoAdditional=null;
	
	public PuertoAdditional getPuertoAdditional() {
		return this.puertoAdditional;
	}
	
	public void setPuertoAdditional(PuertoAdditional puertoAdditional) {
		try {
			this.puertoAdditional=puertoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_tipo_puerto() {
		return this.id_tipo_puerto;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Boolean getes_local() {
		return this.es_local;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_tipo_puerto(Long newid_tipo_puerto)throws Exception
	{
		try {
			if(this.id_tipo_puerto!=newid_tipo_puerto) {
				if(newid_tipo_puerto==null) {
					//newid_tipo_puerto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Puerto:Valor nulo no permitido en columna id_tipo_puerto");
					}
				}

				this.id_tipo_puerto=newid_tipo_puerto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Puerto:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
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
						System.out.println("Puerto:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>200) {
					newnombre=newnombre.substring(0,198);
					System.out.println("Puerto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_local(Boolean newes_local)throws Exception
	{
		try {
			if(this.es_local!=newes_local) {
				if(newes_local==null) {
					//newes_local=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Puerto:Valor nulo no permitido en columna es_local");
					}
				}

				this.es_local=newes_local;
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
						System.out.println("Puerto:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("Puerto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public TipoPuerto getTipoPuerto() {
		return this.tipopuerto;
	}

	public Pais getPais() {
		return this.pais;
	}

	
	
	public String gettipopuerto_descripcion() {
		return this.tipopuerto_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	
	
	public  void  setTipoPuerto(TipoPuerto tipopuerto) {
		try {
			this.tipopuerto=tipopuerto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  settipopuerto_descripcion(String tipopuerto_descripcion) {
		try {
			this.tipopuerto_descripcion=tipopuerto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpais_descripcion(String pais_descripcion) {
		try {
			this.pais_descripcion=pais_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<PedidoCompraImpor> getPedidoCompraImpors() {
		return this.pedidocompraimpors;
	}

	public List<LiquidacionImpor> getLiquidacionImpors() {
		return this.liquidacionimpors;
	}

	public List<Embarcador> getEmbarcadors() {
		return this.embarcadors;
	}

	
	
	public  void  setPedidoCompraImpors(List<PedidoCompraImpor> pedidocompraimpors) {
		try {
			this.pedidocompraimpors=pedidocompraimpors;
		} catch(Exception e) {
			;
		}
	}

	public  void  setLiquidacionImpors(List<LiquidacionImpor> liquidacionimpors) {
		try {
			this.liquidacionimpors=liquidacionimpors;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmbarcadors(List<Embarcador> embarcadors) {
		try {
			this.embarcadors=embarcadors;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_tipo_puerto_descripcion="";String id_pais_descripcion="";String es_local_descripcion="";
	
	
	public String getid_tipo_puerto_descripcion() {
		return id_tipo_puerto_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getes_local_descripcion() {
		return es_local_descripcion;
	}
	
	
	public void setid_tipo_puerto_descripcion(String newid_tipo_puerto_descripcion)throws Exception {
		try {
			this.id_tipo_puerto_descripcion=newid_tipo_puerto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_local_descripcion(String newes_local_descripcion)throws Exception {
		try {
			this.es_local_descripcion=newes_local_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_tipo_puerto_descripcion="";this.id_pais_descripcion="";this.es_local_descripcion="";
	}
	
	
	Object pedidocompraimporsDescripcionReporte;
	Object liquidacionimporsDescripcionReporte;
	Object embarcadorsDescripcionReporte;
	
	
	public Object getpedidocompraimporsDescripcionReporte() {
		return pedidocompraimporsDescripcionReporte;
	}

	public Object getliquidacionimporsDescripcionReporte() {
		return liquidacionimporsDescripcionReporte;
	}

	public Object getembarcadorsDescripcionReporte() {
		return embarcadorsDescripcionReporte;
	}

	
	
	public  void  setpedidocompraimporsDescripcionReporte(Object pedidocompraimpors) {
		try {
			this.pedidocompraimporsDescripcionReporte=pedidocompraimpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setliquidacionimporsDescripcionReporte(Object liquidacionimpors) {
		try {
			this.liquidacionimporsDescripcionReporte=liquidacionimpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setembarcadorsDescripcionReporte(Object embarcadors) {
		try {
			this.embarcadorsDescripcionReporte=embarcadors;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

