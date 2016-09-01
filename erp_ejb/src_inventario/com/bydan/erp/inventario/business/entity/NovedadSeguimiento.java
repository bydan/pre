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
//import com.bydan.erp.inventario.util.NovedadSeguimientoConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class NovedadSeguimiento extends NovedadSeguimientoAdditional implements Serializable ,Cloneable {//NovedadSeguimientoAdditional,GeneralEntity
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
	
	private NovedadSeguimiento novedadseguimientoOriginal;
	
	private Map<String, Object> mapNovedadSeguimiento;
			
	public Map<String, Object> getMapNovedadSeguimiento() {
		return mapNovedadSeguimiento;
	}

	public void setMapNovedadSeguimiento(Map<String, Object> mapNovedadSeguimiento) {
		this.mapNovedadSeguimiento = mapNovedadSeguimiento;
	}
	
	public void inicializarMapNovedadSeguimiento() {
		this.mapNovedadSeguimiento = new HashMap<String,Object>();
	}
	
	public void setMapNovedadSeguimientoValue(String sKey,Object oValue) {
		this.mapNovedadSeguimiento.put(sKey, oValue);
	}
	
	public Object getMapNovedadSeguimientoValue(String sKey) {
		return this.mapNovedadSeguimiento.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_detalle_movimiento_inventario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_novedad_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NovedadSeguimientoConstantesFunciones.SREGEXNUMERO_COMPROBANTE,message=NovedadSeguimientoConstantesFunciones.SMENSAJEREGEXNUMERO_COMPROBANTE)
	private String numero_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_novedad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_seguimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NovedadSeguimientoConstantesFunciones.SREGEXDESCRIPCION,message=NovedadSeguimientoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_novedad_seguimiento;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public DetalleMovimientoInventario detallemovimientoinventario;
	public NovedadProducto novedadproducto;
	public EstadoNovedadSeguimiento estadonovedadseguimiento;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String detallemovimientoinventario_descripcion;
	private String novedadproducto_descripcion;
	private String estadonovedadseguimiento_descripcion;
	
	
		
	public NovedadSeguimiento () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.novedadseguimientoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_detalle_movimiento_inventario=-1L;
 		this.id_novedad_producto=-1L;
 		this.numero_comprobante="";
 		this.fecha_novedad=new Date();
 		this.fecha_seguimiento=new Date();
 		this.descripcion="";
 		this.id_estado_novedad_seguimiento=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.detallemovimientoinventario=null;
		this.novedadproducto=null;
		this.estadonovedadseguimiento=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.detallemovimientoinventario_descripcion="";
		this.novedadproducto_descripcion="";
		this.estadonovedadseguimiento_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public NovedadSeguimiento (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_detalle_movimiento_inventario,Long id_novedad_producto,String numero_comprobante,Date fecha_novedad,Date fecha_seguimiento,String descripcion,Long id_estado_novedad_seguimiento) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.novedadseguimientoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_detalle_movimiento_inventario=id_detalle_movimiento_inventario;
 		this.id_novedad_producto=id_novedad_producto;
 		this.numero_comprobante=numero_comprobante;
 		this.fecha_novedad=fecha_novedad;
 		this.fecha_seguimiento=fecha_seguimiento;
 		this.descripcion=descripcion;
 		this.id_estado_novedad_seguimiento=id_estado_novedad_seguimiento;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public NovedadSeguimiento (Long id_empresa,Long id_sucursal,Long id_detalle_movimiento_inventario,Long id_novedad_producto,String numero_comprobante,Date fecha_novedad,Date fecha_seguimiento,String descripcion,Long id_estado_novedad_seguimiento) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.novedadseguimientoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_detalle_movimiento_inventario=id_detalle_movimiento_inventario;
 		this.id_novedad_producto=id_novedad_producto;
 		this.numero_comprobante=numero_comprobante;
 		this.fecha_novedad=fecha_novedad;
 		this.fecha_seguimiento=fecha_seguimiento;
 		this.descripcion=descripcion;
 		this.id_estado_novedad_seguimiento=id_estado_novedad_seguimiento;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		NovedadSeguimiento novedadseguimientoLocal=null;
		
		if(object!=null) {
			novedadseguimientoLocal=(NovedadSeguimiento)object;
			
			if(novedadseguimientoLocal!=null) {
				if(this.getId()!=null && novedadseguimientoLocal.getId()!=null) {
					if(this.getId().equals(novedadseguimientoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!NovedadSeguimientoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=NovedadSeguimientoConstantesFunciones.getNovedadSeguimientoDescripcion(this);
		} else {
			sDetalle=NovedadSeguimientoConstantesFunciones.getNovedadSeguimientoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public NovedadSeguimiento getNovedadSeguimientoOriginal() {
		return this.novedadseguimientoOriginal;
	}
	
	public void setNovedadSeguimientoOriginal(NovedadSeguimiento novedadseguimiento) {
		try {
			this.novedadseguimientoOriginal=novedadseguimiento;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected NovedadSeguimientoAdditional novedadseguimientoAdditional=null;
	
	public NovedadSeguimientoAdditional getNovedadSeguimientoAdditional() {
		return this.novedadseguimientoAdditional;
	}
	
	public void setNovedadSeguimientoAdditional(NovedadSeguimientoAdditional novedadseguimientoAdditional) {
		try {
			this.novedadseguimientoAdditional=novedadseguimientoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_detalle_movimiento_inventario() {
		return this.id_detalle_movimiento_inventario;
	}
    
	
	public Long getid_novedad_producto() {
		return this.id_novedad_producto;
	}
    
	
	public String getnumero_comprobante() {
		return this.numero_comprobante;
	}
    
	
	public Date getfecha_novedad() {
		return this.fecha_novedad;
	}
    
	
	public Date getfecha_seguimiento() {
		return this.fecha_seguimiento;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Long getid_estado_novedad_seguimiento() {
		return this.id_estado_novedad_seguimiento;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadSeguimiento:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadSeguimiento:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_detalle_movimiento_inventario(Long newid_detalle_movimiento_inventario)throws Exception
	{
		try {
			if(this.id_detalle_movimiento_inventario!=newid_detalle_movimiento_inventario) {
				if(newid_detalle_movimiento_inventario==null) {
					//newid_detalle_movimiento_inventario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadSeguimiento:Valor nulo no permitido en columna id_detalle_movimiento_inventario");
					}
				}

				this.id_detalle_movimiento_inventario=newid_detalle_movimiento_inventario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_novedad_producto(Long newid_novedad_producto)throws Exception
	{
		try {
			if(this.id_novedad_producto!=newid_novedad_producto) {
				if(newid_novedad_producto==null) {
					//newid_novedad_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadSeguimiento:Valor nulo no permitido en columna id_novedad_producto");
					}
				}

				this.id_novedad_producto=newid_novedad_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_comprobante(String newnumero_comprobante)throws Exception
	{
		try {
			if(this.numero_comprobante!=newnumero_comprobante) {
				if(newnumero_comprobante==null) {
					//newnumero_comprobante="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadSeguimiento:Valor nulo no permitido en columna numero_comprobante");
					}
				}

				if(newnumero_comprobante!=null&&newnumero_comprobante.length()>50) {
					newnumero_comprobante=newnumero_comprobante.substring(0,48);
					System.out.println("NovedadSeguimiento:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_comprobante");
				}

				this.numero_comprobante=newnumero_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_novedad(Date newfecha_novedad)throws Exception
	{
		try {
			if(this.fecha_novedad!=newfecha_novedad) {
				if(newfecha_novedad==null) {
					//newfecha_novedad=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadSeguimiento:Valor nulo no permitido en columna fecha_novedad");
					}
				}

				this.fecha_novedad=newfecha_novedad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_seguimiento(Date newfecha_seguimiento)throws Exception
	{
		try {
			if(this.fecha_seguimiento!=newfecha_seguimiento) {
				if(newfecha_seguimiento==null) {
					//newfecha_seguimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadSeguimiento:Valor nulo no permitido en columna fecha_seguimiento");
					}
				}

				this.fecha_seguimiento=newfecha_seguimiento;
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
						System.out.println("NovedadSeguimiento:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("NovedadSeguimiento:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_novedad_seguimiento(Long newid_estado_novedad_seguimiento)throws Exception
	{
		try {
			if(this.id_estado_novedad_seguimiento!=newid_estado_novedad_seguimiento) {
				if(newid_estado_novedad_seguimiento==null) {
					//newid_estado_novedad_seguimiento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NovedadSeguimiento:Valor nulo no permitido en columna id_estado_novedad_seguimiento");
					}
				}

				this.id_estado_novedad_seguimiento=newid_estado_novedad_seguimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public DetalleMovimientoInventario getDetalleMovimientoInventario() {
		return this.detallemovimientoinventario;
	}

	public NovedadProducto getNovedadProducto() {
		return this.novedadproducto;
	}

	public EstadoNovedadSeguimiento getEstadoNovedadSeguimiento() {
		return this.estadonovedadseguimiento;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getdetallemovimientoinventario_descripcion() {
		return this.detallemovimientoinventario_descripcion;
	}

	public String getnovedadproducto_descripcion() {
		return this.novedadproducto_descripcion;
	}

	public String getestadonovedadseguimiento_descripcion() {
		return this.estadonovedadseguimiento_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDetalleMovimientoInventario(DetalleMovimientoInventario detallemovimientoinventario) {
		try {
			this.detallemovimientoinventario=detallemovimientoinventario;
		} catch(Exception e) {
			;
		}
	}


	public  void  setNovedadProducto(NovedadProducto novedadproducto) {
		try {
			this.novedadproducto=novedadproducto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoNovedadSeguimiento(EstadoNovedadSeguimiento estadonovedadseguimiento) {
		try {
			this.estadonovedadseguimiento=estadonovedadseguimiento;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdetallemovimientoinventario_descripcion(String detallemovimientoinventario_descripcion) {
		try {
			this.detallemovimientoinventario_descripcion=detallemovimientoinventario_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setnovedadproducto_descripcion(String novedadproducto_descripcion) {
		try {
			this.novedadproducto_descripcion=novedadproducto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadonovedadseguimiento_descripcion(String estadonovedadseguimiento_descripcion) {
		try {
			this.estadonovedadseguimiento_descripcion=estadonovedadseguimiento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_detalle_movimiento_inventario_descripcion="";String id_novedad_producto_descripcion="";String id_estado_novedad_seguimiento_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_detalle_movimiento_inventario_descripcion() {
		return id_detalle_movimiento_inventario_descripcion;
	}
	public String getid_novedad_producto_descripcion() {
		return id_novedad_producto_descripcion;
	}
	public String getid_estado_novedad_seguimiento_descripcion() {
		return id_estado_novedad_seguimiento_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_detalle_movimiento_inventario_descripcion(String newid_detalle_movimiento_inventario_descripcion)throws Exception {
		try {
			this.id_detalle_movimiento_inventario_descripcion=newid_detalle_movimiento_inventario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_novedad_producto_descripcion(String newid_novedad_producto_descripcion)throws Exception {
		try {
			this.id_novedad_producto_descripcion=newid_novedad_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_novedad_seguimiento_descripcion(String newid_estado_novedad_seguimiento_descripcion)throws Exception {
		try {
			this.id_estado_novedad_seguimiento_descripcion=newid_estado_novedad_seguimiento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_detalle_movimiento_inventario_descripcion="";this.id_novedad_producto_descripcion="";this.id_estado_novedad_seguimiento_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

