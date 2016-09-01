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
//import com.bydan.erp.inventario.util.AutoriConsepConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class AutoriConsep extends AutoriConsepAdditional implements Serializable ,Cloneable {//AutoriConsepAdditional,GeneralEntity
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
	
	private AutoriConsep autoriconsepOriginal;
	
	private Map<String, Object> mapAutoriConsep;
			
	public Map<String, Object> getMapAutoriConsep() {
		return mapAutoriConsep;
	}

	public void setMapAutoriConsep(Map<String, Object> mapAutoriConsep) {
		this.mapAutoriConsep = mapAutoriConsep;
	}
	
	public void inicializarMapAutoriConsep() {
		this.mapAutoriConsep = new HashMap<String,Object>();
	}
	
	public void setMapAutoriConsepValue(String sKey,Object oValue) {
		this.mapAutoriConsep.put(sKey, oValue);
	}
	
	public Object getMapAutoriConsepValue(String sKey) {
		return this.mapAutoriConsep.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=AutoriConsepConstantesFunciones.SREGEXNUMERO_AUTORIZACION,message=AutoriConsepConstantesFunciones.SMENSAJEREGEXNUMERO_AUTORIZACION)
	private String numero_autorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_autori_consep;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=AutoriConsepConstantesFunciones.SREGEXDESCRIPCION,message=AutoriConsepConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=AutoriConsepConstantesFunciones.SREGEXNOMBRE,message=AutoriConsepConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	public Empresa empresa;
	public Usuario usuario;
	public Cliente cliente;
	public TipoAutoriConsep tipoautoriconsep;
	public Empleado empleado;
	
	
	private String empresa_descripcion;
	private String usuario_descripcion;
	private String cliente_descripcion;
	private String tipoautoriconsep_descripcion;
	private String empleado_descripcion;
	
	
	public List<DetalleAutoriConsep> detalleautoriconseps;
		
	public AutoriConsep () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.autoriconsepOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_usuario=-1L;
 		this.es_empresa=false;
 		this.id_cliente=-1L;
 		this.numero_autorizacion="";
 		this.id_tipo_autori_consep=-1L;
 		this.id_empleado=-1L;
 		this.fecha_emision=new Date();
 		this.fecha_vencimiento=new Date();
 		this.fecha_ultima=new Date();
 		this.fecha=new Date();
 		this.descripcion="";
 		this.nombre="";
		
		
		this.empresa=null;
		this.usuario=null;
		this.cliente=null;
		this.tipoautoriconsep=null;
		this.empleado=null;
		
		
		this.empresa_descripcion="";
		this.usuario_descripcion="";
		this.cliente_descripcion="";
		this.tipoautoriconsep_descripcion="";
		this.empleado_descripcion="";
		
		
		this.detalleautoriconseps=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public AutoriConsep (Long id,Date versionRow,Long id_empresa,Long id_usuario,Boolean es_empresa,Long id_cliente,String numero_autorizacion,Long id_tipo_autori_consep,Long id_empleado,Date fecha_emision,Date fecha_vencimiento,Date fecha_ultima,Date fecha,String descripcion,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.autoriconsepOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_usuario=id_usuario;
 		this.es_empresa=es_empresa;
 		this.id_cliente=id_cliente;
 		this.numero_autorizacion=numero_autorizacion;
 		this.id_tipo_autori_consep=id_tipo_autori_consep;
 		this.id_empleado=id_empleado;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.fecha_ultima=fecha_ultima;
 		this.fecha=fecha;
 		this.descripcion=descripcion;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public AutoriConsep (Long id_empresa,Long id_usuario,Boolean es_empresa,Long id_cliente,String numero_autorizacion,Long id_tipo_autori_consep,Long id_empleado,Date fecha_emision,Date fecha_vencimiento,Date fecha_ultima,Date fecha,String descripcion,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.autoriconsepOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_usuario=id_usuario;
 		this.es_empresa=es_empresa;
 		this.id_cliente=id_cliente;
 		this.numero_autorizacion=numero_autorizacion;
 		this.id_tipo_autori_consep=id_tipo_autori_consep;
 		this.id_empleado=id_empleado;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.fecha_ultima=fecha_ultima;
 		this.fecha=fecha;
 		this.descripcion=descripcion;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		AutoriConsep autoriconsepLocal=null;
		
		if(object!=null) {
			autoriconsepLocal=(AutoriConsep)object;
			
			if(autoriconsepLocal!=null) {
				if(this.getId()!=null && autoriconsepLocal.getId()!=null) {
					if(this.getId().equals(autoriconsepLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!AutoriConsepConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=AutoriConsepConstantesFunciones.getAutoriConsepDescripcion(this);
		} else {
			sDetalle=AutoriConsepConstantesFunciones.getAutoriConsepDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public AutoriConsep getAutoriConsepOriginal() {
		return this.autoriconsepOriginal;
	}
	
	public void setAutoriConsepOriginal(AutoriConsep autoriconsep) {
		try {
			this.autoriconsepOriginal=autoriconsep;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected AutoriConsepAdditional autoriconsepAdditional=null;
	
	public AutoriConsepAdditional getAutoriConsepAdditional() {
		return this.autoriconsepAdditional;
	}
	
	public void setAutoriConsepAdditional(AutoriConsepAdditional autoriconsepAdditional) {
		try {
			this.autoriconsepAdditional=autoriconsepAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public Boolean getes_empresa() {
		return this.es_empresa;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public String getnumero_autorizacion() {
		return this.numero_autorizacion;
	}
    
	
	public Long getid_tipo_autori_consep() {
		return this.id_tipo_autori_consep;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_vencimiento() {
		return this.fecha_vencimiento;
	}
    
	
	public Date getfecha_ultima() {
		return this.fecha_ultima;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
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
						System.out.println("AutoriConsep:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(this.id_usuario!=newid_usuario) {
				if(newid_usuario==null) {
					//newid_usuario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriConsep:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_empresa(Boolean newes_empresa)throws Exception
	{
		try {
			if(this.es_empresa!=newes_empresa) {
				if(newes_empresa==null) {
					//newes_empresa=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriConsep:Valor nulo no permitido en columna es_empresa");
					}
				}

				this.es_empresa=newes_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriConsep:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_autorizacion(String newnumero_autorizacion)throws Exception
	{
		try {
			if(this.numero_autorizacion!=newnumero_autorizacion) {
				if(newnumero_autorizacion==null) {
					//newnumero_autorizacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriConsep:Valor nulo no permitido en columna numero_autorizacion");
					}
				}

				if(newnumero_autorizacion!=null&&newnumero_autorizacion.length()>50) {
					newnumero_autorizacion=newnumero_autorizacion.substring(0,48);
					System.out.println("AutoriConsep:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_autorizacion");
				}

				this.numero_autorizacion=newnumero_autorizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_autori_consep(Long newid_tipo_autori_consep)throws Exception
	{
		try {
			if(this.id_tipo_autori_consep!=newid_tipo_autori_consep) {
				if(newid_tipo_autori_consep==null) {
					//newid_tipo_autori_consep=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriConsep:Valor nulo no permitido en columna id_tipo_autori_consep");
					}
				}

				this.id_tipo_autori_consep=newid_tipo_autori_consep;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado(Long newid_empleado)throws Exception
	{
		try {
			if(this.id_empleado!=newid_empleado) {
				if(newid_empleado==null) {
					//newid_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriConsep:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision(Date newfecha_emision)throws Exception
	{
		try {
			if(this.fecha_emision!=newfecha_emision) {
				if(newfecha_emision==null) {
					//newfecha_emision=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriConsep:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento(Date newfecha_vencimiento)throws Exception
	{
		try {
			if(this.fecha_vencimiento!=newfecha_vencimiento) {
				if(newfecha_vencimiento==null) {
					//newfecha_vencimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriConsep:Valor nulo no permitido en columna fecha_vencimiento");
					}
				}

				this.fecha_vencimiento=newfecha_vencimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultima(Date newfecha_ultima)throws Exception
	{
		try {
			if(this.fecha_ultima!=newfecha_ultima) {
				if(newfecha_ultima==null) {
					//newfecha_ultima=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriConsep:Valor nulo no permitido en columna fecha_ultima");
					}
				}

				this.fecha_ultima=newfecha_ultima;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriConsep:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("AutoriConsep:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("AutoriConsep:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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
						System.out.println("AutoriConsep:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("AutoriConsep:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoAutoriConsep getTipoAutoriConsep() {
		return this.tipoautoriconsep;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipoautoriconsep_descripcion() {
		return this.tipoautoriconsep_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoAutoriConsep(TipoAutoriConsep tipoautoriconsep) {
		try {
			this.tipoautoriconsep=tipoautoriconsep;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
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


	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoautoriconsep_descripcion(String tipoautoriconsep_descripcion) {
		try {
			this.tipoautoriconsep_descripcion=tipoautoriconsep_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetalleAutoriConsep> getDetalleAutoriConseps() {
		return this.detalleautoriconseps;
	}

	
	
	public  void  setDetalleAutoriConseps(List<DetalleAutoriConsep> detalleautoriconseps) {
		try {
			this.detalleautoriconseps=detalleautoriconseps;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_usuario_descripcion="";String es_empresa_descripcion="";String id_cliente_descripcion="";String id_tipo_autori_consep_descripcion="";String id_empleado_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	public String getes_empresa_descripcion() {
		return es_empresa_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_tipo_autori_consep_descripcion() {
		return id_tipo_autori_consep_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_empresa_descripcion(String newes_empresa_descripcion)throws Exception {
		try {
			this.es_empresa_descripcion=newes_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_autori_consep_descripcion(String newid_tipo_autori_consep_descripcion)throws Exception {
		try {
			this.id_tipo_autori_consep_descripcion=newid_tipo_autori_consep_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_usuario_descripcion="";this.es_empresa_descripcion="";this.id_cliente_descripcion="";this.id_tipo_autori_consep_descripcion="";this.id_empleado_descripcion="";
	}
	
	
	Object detalleautoriconsepsDescripcionReporte;
	
	
	public Object getdetalleautoriconsepsDescripcionReporte() {
		return detalleautoriconsepsDescripcionReporte;
	}

	
	
	public  void  setdetalleautoriconsepsDescripcionReporte(Object detalleautoriconseps) {
		try {
			this.detalleautoriconsepsDescripcionReporte=detalleautoriconseps;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

