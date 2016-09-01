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
//import com.bydan.erp.cartera.util.TipoIdentificacionConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class TipoIdentificacion extends TipoIdentificacionAdditional implements Serializable ,Cloneable {//TipoIdentificacionAdditional,GeneralEntity
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
	
	private TipoIdentificacion tipoidentificacionOriginal;
	
	private Map<String, Object> mapTipoIdentificacion;
			
	public Map<String, Object> getMapTipoIdentificacion() {
		return mapTipoIdentificacion;
	}

	public void setMapTipoIdentificacion(Map<String, Object> mapTipoIdentificacion) {
		this.mapTipoIdentificacion = mapTipoIdentificacion;
	}
	
	public void inicializarMapTipoIdentificacion() {
		this.mapTipoIdentificacion = new HashMap<String,Object>();
	}
	
	public void setMapTipoIdentificacionValue(String sKey,Object oValue) {
		this.mapTipoIdentificacion.put(sKey, oValue);
	}
	
	public Object getMapTipoIdentificacionValue(String sKey) {
		return this.mapTipoIdentificacion.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoIdentificacionConstantesFunciones.SREGEXCODIGO,message=TipoIdentificacionConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoIdentificacionConstantesFunciones.SREGEXNOMBRE,message=TipoIdentificacionConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
	public List<Conyuge> conyuges;
	public List<Cobrador> cobradors;
	public List<RepresentanteLegal> representantelegals;
	public List<SubCliente> subclientes;
	public List<Accionista> accionistas;
	public List<Cliente> clientes;
	public List<ParametroCarteraDefecto> parametrocarteradefectos;
		
	public TipoIdentificacion () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipoidentificacionOriginal=this;
		
 		this.codigo="";
 		this.nombre="";
		
		
		
		
		
		
		this.conyuges=null;
		this.cobradors=null;
		this.representantelegals=null;
		this.subclientes=null;
		this.accionistas=null;
		this.clientes=null;
		this.parametrocarteradefectos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoIdentificacion (Long id,Date versionRow,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoidentificacionOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoIdentificacion (String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoidentificacionOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoIdentificacion tipoidentificacionLocal=null;
		
		if(object!=null) {
			tipoidentificacionLocal=(TipoIdentificacion)object;
			
			if(tipoidentificacionLocal!=null) {
				if(this.getId()!=null && tipoidentificacionLocal.getId()!=null) {
					if(this.getId().equals(tipoidentificacionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoIdentificacionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcion(this);
		} else {
			sDetalle=TipoIdentificacionConstantesFunciones.getTipoIdentificacionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoIdentificacion getTipoIdentificacionOriginal() {
		return this.tipoidentificacionOriginal;
	}
	
	public void setTipoIdentificacionOriginal(TipoIdentificacion tipoidentificacion) {
		try {
			this.tipoidentificacionOriginal=tipoidentificacion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoIdentificacionAdditional tipoidentificacionAdditional=null;
	
	public TipoIdentificacionAdditional getTipoIdentificacionAdditional() {
		return this.tipoidentificacionAdditional;
	}
	
	public void setTipoIdentificacionAdditional(TipoIdentificacionAdditional tipoidentificacionAdditional) {
		try {
			this.tipoidentificacionAdditional=tipoidentificacionAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoIdentificacion:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoIdentificacion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("TipoIdentificacion:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoIdentificacion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<Conyuge> getConyuges() {
		return this.conyuges;
	}

	public List<Cobrador> getCobradors() {
		return this.cobradors;
	}

	public List<RepresentanteLegal> getRepresentanteLegals() {
		return this.representantelegals;
	}

	public List<SubCliente> getSubClientes() {
		return this.subclientes;
	}

	public List<Accionista> getAccionistas() {
		return this.accionistas;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public List<ParametroCarteraDefecto> getParametroCarteraDefectos() {
		return this.parametrocarteradefectos;
	}

	
	
	public  void  setConyuges(List<Conyuge> conyuges) {
		try {
			this.conyuges=conyuges;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCobradors(List<Cobrador> cobradors) {
		try {
			this.cobradors=cobradors;
		} catch(Exception e) {
			;
		}
	}

	public  void  setRepresentanteLegals(List<RepresentanteLegal> representantelegals) {
		try {
			this.representantelegals=representantelegals;
		} catch(Exception e) {
			;
		}
	}

	public  void  setSubClientes(List<SubCliente> subclientes) {
		try {
			this.subclientes=subclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setAccionistas(List<Accionista> accionistas) {
		try {
			this.accionistas=accionistas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setClientes(List<Cliente> clientes) {
		try {
			this.clientes=clientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setParametroCarteraDefectos(List<ParametroCarteraDefecto> parametrocarteradefectos) {
		try {
			this.parametrocarteradefectos=parametrocarteradefectos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object conyugesDescripcionReporte;
	Object cobradorsDescripcionReporte;
	Object representantelegalsDescripcionReporte;
	Object subclientesDescripcionReporte;
	Object accionistasDescripcionReporte;
	Object clientesDescripcionReporte;
	Object parametrocarteradefectosDescripcionReporte;
	
	
	public Object getconyugesDescripcionReporte() {
		return conyugesDescripcionReporte;
	}

	public Object getcobradorsDescripcionReporte() {
		return cobradorsDescripcionReporte;
	}

	public Object getrepresentantelegalsDescripcionReporte() {
		return representantelegalsDescripcionReporte;
	}

	public Object getsubclientesDescripcionReporte() {
		return subclientesDescripcionReporte;
	}

	public Object getaccionistasDescripcionReporte() {
		return accionistasDescripcionReporte;
	}

	public Object getclientesDescripcionReporte() {
		return clientesDescripcionReporte;
	}

	public Object getparametrocarteradefectosDescripcionReporte() {
		return parametrocarteradefectosDescripcionReporte;
	}

	
	
	public  void  setconyugesDescripcionReporte(Object conyuges) {
		try {
			this.conyugesDescripcionReporte=conyuges;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcobradorsDescripcionReporte(Object cobradors) {
		try {
			this.cobradorsDescripcionReporte=cobradors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setrepresentantelegalsDescripcionReporte(Object representantelegals) {
		try {
			this.representantelegalsDescripcionReporte=representantelegals;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setsubclientesDescripcionReporte(Object subclientes) {
		try {
			this.subclientesDescripcionReporte=subclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setaccionistasDescripcionReporte(Object accionistas) {
		try {
			this.accionistasDescripcionReporte=accionistas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setclientesDescripcionReporte(Object clientes) {
		try {
			this.clientesDescripcionReporte=clientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrocarteradefectosDescripcionReporte(Object parametrocarteradefectos) {
		try {
			this.parametrocarteradefectosDescripcionReporte=parametrocarteradefectos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

