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
package com.bydan.erp.facturacion.business.entity;

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
//import com.bydan.erp.facturacion.util.ConsultorConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.importaciones.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;




@SuppressWarnings("unused")
public class Consultor extends ConsultorAdditional implements Serializable ,Cloneable {//ConsultorAdditional,GeneralEntity
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
	
	private Consultor consultorOriginal;
	
	private Map<String, Object> mapConsultor;
			
	public Map<String, Object> getMapConsultor() {
		return mapConsultor;
	}

	public void setMapConsultor(Map<String, Object> mapConsultor) {
		this.mapConsultor = mapConsultor;
	}
	
	public void inicializarMapConsultor() {
		this.mapConsultor = new HashMap<String,Object>();
	}
	
	public void setMapConsultorValue(String sKey,Object oValue) {
		this.mapConsultor.put(sKey, oValue);
	}
	
	public Object getMapConsultorValue(String sKey) {
		return this.mapConsultor.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=25,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ConsultorConstantesFunciones.SREGEXIDENTIFICACION,message=ConsultorConstantesFunciones.SMENSAJEREGEXIDENTIFICACION)
	private String identificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ConsultorConstantesFunciones.SREGEXAPELLIDO,message=ConsultorConstantesFunciones.SMENSAJEREGEXAPELLIDO)
	private String apellido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ConsultorConstantesFunciones.SREGEXNOMBRE,message=ConsultorConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ConsultorConstantesFunciones.SREGEXNOMBRE_COMPLETO,message=ConsultorConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO)
	private String nombre_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ConsultorConstantesFunciones.SREGEXTELEFONO,message=ConsultorConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ConsultorConstantesFunciones.SREGEXE_MAIL,message=ConsultorConstantesFunciones.SMENSAJEREGEXE_MAIL)
	private String e_mail;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ConsultorConstantesFunciones.SREGEXDIRECCION,message=ConsultorConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ConsultorConstantesFunciones.SREGEXDESCRIPCION,message=ConsultorConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
	public List<GuiaRemision> guiaremisions;
	public List<PedidoExpor> pedidoexpors;
	public List<Pedido> pedidos;
		
	public Consultor () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.consultorOriginal=this;
		
 		this.id_empresa=-1L;
 		this.identificacion="";
 		this.apellido="";
 		this.nombre="";
 		this.nombre_completo="";
 		this.telefono="";
 		this.e_mail="";
 		this.direccion="";
 		this.descripcion="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		this.guiaremisions=null;
		this.pedidoexpors=null;
		this.pedidos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Consultor (Long id,Date versionRow,Long id_empresa,String identificacion,String apellido,String nombre,String nombre_completo,String telefono,String e_mail,String direccion,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.consultorOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.identificacion=identificacion;
 		this.apellido=apellido;
 		this.nombre=nombre;
 		this.nombre_completo=nombre_completo;
 		this.telefono=telefono;
 		this.e_mail=e_mail;
 		this.direccion=direccion;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Consultor (Long id_empresa,String identificacion,String apellido,String nombre,String nombre_completo,String telefono,String e_mail,String direccion,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.consultorOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.identificacion=identificacion;
 		this.apellido=apellido;
 		this.nombre=nombre;
 		this.nombre_completo=nombre_completo;
 		this.telefono=telefono;
 		this.e_mail=e_mail;
 		this.direccion=direccion;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Consultor consultorLocal=null;
		
		if(object!=null) {
			consultorLocal=(Consultor)object;
			
			if(consultorLocal!=null) {
				if(this.getId()!=null && consultorLocal.getId()!=null) {
					if(this.getId().equals(consultorLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ConsultorConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ConsultorConstantesFunciones.getConsultorDescripcion(this);
		} else {
			sDetalle=ConsultorConstantesFunciones.getConsultorDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Consultor getConsultorOriginal() {
		return this.consultorOriginal;
	}
	
	public void setConsultorOriginal(Consultor consultor) {
		try {
			this.consultorOriginal=consultor;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ConsultorAdditional consultorAdditional=null;
	
	public ConsultorAdditional getConsultorAdditional() {
		return this.consultorAdditional;
	}
	
	public void setConsultorAdditional(ConsultorAdditional consultorAdditional) {
		try {
			this.consultorAdditional=consultorAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getidentificacion() {
		return this.identificacion;
	}
    
	
	public String getapellido() {
		return this.apellido;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getnombre_completo() {
		return this.nombre_completo;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String gete_mail() {
		return this.e_mail;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Consultor:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidentificacion(String newidentificacion)throws Exception
	{
		try {
			if(this.identificacion!=newidentificacion) {
				if(newidentificacion==null) {
					//newidentificacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Consultor:Valor nulo no permitido en columna identificacion");
					}
				}

				if(newidentificacion!=null&&newidentificacion.length()>25) {
					newidentificacion=newidentificacion.substring(0,23);
					System.out.println("Consultor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=25 en columna identificacion");
				}

				this.identificacion=newidentificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setapellido(String newapellido)throws Exception
	{
		try {
			if(this.apellido!=newapellido) {
				if(newapellido==null) {
					//newapellido="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Consultor:Valor nulo no permitido en columna apellido");
					}
				}

				if(newapellido!=null&&newapellido.length()>100) {
					newapellido=newapellido.substring(0,98);
					System.out.println("Consultor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna apellido");
				}

				this.apellido=newapellido;
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
						System.out.println("Consultor:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("Consultor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_completo(String newnombre_completo)throws Exception
	{
		try {
			if(this.nombre_completo!=newnombre_completo) {
				if(newnombre_completo==null) {
					//newnombre_completo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Consultor:Valor nulo no permitido en columna nombre_completo");
					}
				}

				if(newnombre_completo!=null&&newnombre_completo.length()>150) {
					newnombre_completo=newnombre_completo.substring(0,148);
					System.out.println("Consultor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo");
				}

				this.nombre_completo=newnombre_completo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono(String newtelefono)throws Exception
	{
		try {
			if(this.telefono!=newtelefono) {
				if(newtelefono==null) {
					//newtelefono="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Consultor:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>100) {
					newtelefono=newtelefono.substring(0,98);
					System.out.println("Consultor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sete_mail(String newe_mail)throws Exception
	{
		try {
			if(this.e_mail!=newe_mail) {
				if(newe_mail==null) {
					//newe_mail="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Consultor:Valor nulo no permitido en columna e_mail");
					}
				}

				if(newe_mail!=null&&newe_mail.length()>200) {
					newe_mail=newe_mail.substring(0,198);
					System.out.println("Consultor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna e_mail");
				}

				this.e_mail=newe_mail;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion(String newdireccion)throws Exception
	{
		try {
			if(this.direccion!=newdireccion) {
				if(newdireccion==null) {
					//newdireccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Consultor:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>200) {
					newdireccion=newdireccion.substring(0,198);
					System.out.println("Consultor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna direccion");
				}

				this.direccion=newdireccion;
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
						System.out.println("Consultor:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("Consultor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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


	
	
	public List<GuiaRemision> getGuiaRemisions() {
		return this.guiaremisions;
	}

	public List<PedidoExpor> getPedidoExpors() {
		return this.pedidoexpors;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	
	
	public  void  setGuiaRemisions(List<GuiaRemision> guiaremisions) {
		try {
			this.guiaremisions=guiaremisions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPedidoExpors(List<PedidoExpor> pedidoexpors) {
		try {
			this.pedidoexpors=pedidoexpors;
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
	
	
	Object guiaremisionsDescripcionReporte;
	Object pedidoexporsDescripcionReporte;
	Object pedidosDescripcionReporte;
	
	
	public Object getguiaremisionsDescripcionReporte() {
		return guiaremisionsDescripcionReporte;
	}

	public Object getpedidoexporsDescripcionReporte() {
		return pedidoexporsDescripcionReporte;
	}

	public Object getpedidosDescripcionReporte() {
		return pedidosDescripcionReporte;
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

	public  void  setpedidosDescripcionReporte(Object pedidos) {
		try {
			this.pedidosDescripcionReporte=pedidos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

