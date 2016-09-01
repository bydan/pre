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
//import com.bydan.erp.inventario.util.NovedadProductoConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class NovedadProducto extends NovedadProductoAdditional implements Serializable ,Cloneable {//NovedadProductoAdditional,GeneralEntity
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
	
	private NovedadProducto novedadproductoOriginal;
	
	private Map<String, Object> mapNovedadProducto;
			
	public Map<String, Object> getMapNovedadProducto() {
		return mapNovedadProducto;
	}

	public void setMapNovedadProducto(Map<String, Object> mapNovedadProducto) {
		this.mapNovedadProducto = mapNovedadProducto;
	}
	
	public void inicializarMapNovedadProducto() {
		this.mapNovedadProducto = new HashMap<String,Object>();
	}
	
	public void setMapNovedadProductoValue(String sKey,Object oValue) {
		this.mapNovedadProducto.put(sKey, oValue);
	}
	
	public Object getMapNovedadProductoValue(String sKey) {
		return this.mapNovedadProducto.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NovedadProductoConstantesFunciones.SREGEXCODIGO,message=NovedadProductoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NovedadProductoConstantesFunciones.SREGEXNOMBRE,message=NovedadProductoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
	public List<DetalleFacturaProveedor> detallefacturaproveedors;
	public List<NovedadSeguimiento> novedadseguimientos;
	public List<DetalleTransferencia> detalletransferencias;
	public List<DetalleMovimientoInventario> detallemovimientoinventarios;
	public List<DetalleOrdenCompra> detalleordencompras;
		
	public NovedadProducto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.novedadproductoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.codigo="";
 		this.nombre="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		this.detallefacturaproveedors=null;
		this.novedadseguimientos=null;
		this.detalletransferencias=null;
		this.detallemovimientoinventarios=null;
		this.detalleordencompras=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public NovedadProducto (Long id,Date versionRow,Long id_empresa,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.novedadproductoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public NovedadProducto (Long id_empresa,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.novedadproductoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		NovedadProducto novedadproductoLocal=null;
		
		if(object!=null) {
			novedadproductoLocal=(NovedadProducto)object;
			
			if(novedadproductoLocal!=null) {
				if(this.getId()!=null && novedadproductoLocal.getId()!=null) {
					if(this.getId().equals(novedadproductoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!NovedadProductoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=NovedadProductoConstantesFunciones.getNovedadProductoDescripcion(this);
		} else {
			sDetalle=NovedadProductoConstantesFunciones.getNovedadProductoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public NovedadProducto getNovedadProductoOriginal() {
		return this.novedadproductoOriginal;
	}
	
	public void setNovedadProductoOriginal(NovedadProducto novedadproducto) {
		try {
			this.novedadproductoOriginal=novedadproducto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected NovedadProductoAdditional novedadproductoAdditional=null;
	
	public NovedadProductoAdditional getNovedadProductoAdditional() {
		return this.novedadproductoAdditional;
	}
	
	public void setNovedadProductoAdditional(NovedadProductoAdditional novedadproductoAdditional) {
		try {
			this.novedadproductoAdditional=novedadproductoAdditional;
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
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadProducto:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("NovedadProducto:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("NovedadProducto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("NovedadProducto:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("NovedadProducto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
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


	
	
	public List<DetalleFacturaProveedor> getDetalleFacturaProveedors() {
		return this.detallefacturaproveedors;
	}

	public List<NovedadSeguimiento> getNovedadSeguimientos() {
		return this.novedadseguimientos;
	}

	public List<DetalleTransferencia> getDetalleTransferencias() {
		return this.detalletransferencias;
	}

	public List<DetalleMovimientoInventario> getDetalleMovimientoInventarios() {
		return this.detallemovimientoinventarios;
	}

	public List<DetalleOrdenCompra> getDetalleOrdenCompras() {
		return this.detalleordencompras;
	}

	
	
	public  void  setDetalleFacturaProveedors(List<DetalleFacturaProveedor> detallefacturaproveedors) {
		try {
			this.detallefacturaproveedors=detallefacturaproveedors;
		} catch(Exception e) {
			;
		}
	}

	public  void  setNovedadSeguimientos(List<NovedadSeguimiento> novedadseguimientos) {
		try {
			this.novedadseguimientos=novedadseguimientos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetalleTransferencias(List<DetalleTransferencia> detalletransferencias) {
		try {
			this.detalletransferencias=detalletransferencias;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetalleMovimientoInventarios(List<DetalleMovimientoInventario> detallemovimientoinventarios) {
		try {
			this.detallemovimientoinventarios=detallemovimientoinventarios;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetalleOrdenCompras(List<DetalleOrdenCompra> detalleordencompras) {
		try {
			this.detalleordencompras=detalleordencompras;
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
	
	
	Object detallefacturaproveedorsDescripcionReporte;
	Object novedadseguimientosDescripcionReporte;
	Object detallecomprasDescripcionReporte;
	Object detalletransferenciasDescripcionReporte;
	Object detallemovimientoinventariosDescripcionReporte;
	Object detalleordencomprasDescripcionReporte;
	
	
	public Object getdetallefacturaproveedorsDescripcionReporte() {
		return detallefacturaproveedorsDescripcionReporte;
	}

	public Object getnovedadseguimientosDescripcionReporte() {
		return novedadseguimientosDescripcionReporte;
	}

	public Object getdetallecomprasDescripcionReporte() {
		return detallecomprasDescripcionReporte;
	}

	public Object getdetalletransferenciasDescripcionReporte() {
		return detalletransferenciasDescripcionReporte;
	}

	public Object getdetallemovimientoinventariosDescripcionReporte() {
		return detallemovimientoinventariosDescripcionReporte;
	}

	public Object getdetalleordencomprasDescripcionReporte() {
		return detalleordencomprasDescripcionReporte;
	}

	
	
	public  void  setdetallefacturaproveedorsDescripcionReporte(Object detallefacturaproveedors) {
		try {
			this.detallefacturaproveedorsDescripcionReporte=detallefacturaproveedors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnovedadseguimientosDescripcionReporte(Object novedadseguimientos) {
		try {
			this.novedadseguimientosDescripcionReporte=novedadseguimientos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallecomprasDescripcionReporte(Object detallecompras) {
		try {
			this.detallecomprasDescripcionReporte=detallecompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalletransferenciasDescripcionReporte(Object detalletransferencias) {
		try {
			this.detalletransferenciasDescripcionReporte=detalletransferencias;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallemovimientoinventariosDescripcionReporte(Object detallemovimientoinventarios) {
		try {
			this.detallemovimientoinventariosDescripcionReporte=detallemovimientoinventarios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleordencomprasDescripcionReporte(Object detalleordencompras) {
		try {
			this.detalleordencomprasDescripcionReporte=detalleordencompras;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

