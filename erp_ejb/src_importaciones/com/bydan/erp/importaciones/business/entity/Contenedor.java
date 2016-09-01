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
package com.bydan.erp.importaciones.business.entity;

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
//import com.bydan.erp.importaciones.util.ContenedorConstantesFunciones;
import com.bydan.erp.importaciones.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class Contenedor extends ContenedorAdditional implements Serializable ,Cloneable {//ContenedorAdditional,GeneralEntity
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
	
	private Contenedor contenedorOriginal;
	
	private Map<String, Object> mapContenedor;
			
	public Map<String, Object> getMapContenedor() {
		return mapContenedor;
	}

	public void setMapContenedor(Map<String, Object> mapContenedor) {
		this.mapContenedor = mapContenedor;
	}
	
	public void inicializarMapContenedor() {
		this.mapContenedor = new HashMap<String,Object>();
	}
	
	public void setMapContenedorValue(String sKey,Object oValue) {
		this.mapContenedor.put(sKey, oValue);
	}
	
	public Object getMapContenedorValue(String sKey) {
		return this.mapContenedor.get(sKey);
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
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ContenedorConstantesFunciones.SREGEXNUMERO,message=ContenedorConstantesFunciones.SMENSAJEREGEXNUMERO)
	private String numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ContenedorConstantesFunciones.SREGEXNUMERO_BL,message=ContenedorConstantesFunciones.SMENSAJEREGEXNUMERO_BL)
	private String numero_bl;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ContenedorConstantesFunciones.SREGEXDESCRIPCION,message=ContenedorConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Pedido pedido;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String pedido_descripcion;
	
	
		
	public Contenedor () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.contenedorOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_pedido=-1L;
 		this.numero="";
 		this.numero_bl="";
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.pedido=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.pedido_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Contenedor (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_pedido,String numero,String numero_bl,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.contenedorOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_pedido=id_pedido;
 		this.numero=numero;
 		this.numero_bl=numero_bl;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Contenedor (Long id_empresa,Long id_sucursal,Long id_pedido,String numero,String numero_bl,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.contenedorOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_pedido=id_pedido;
 		this.numero=numero;
 		this.numero_bl=numero_bl;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Contenedor contenedorLocal=null;
		
		if(object!=null) {
			contenedorLocal=(Contenedor)object;
			
			if(contenedorLocal!=null) {
				if(this.getId()!=null && contenedorLocal.getId()!=null) {
					if(this.getId().equals(contenedorLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ContenedorConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ContenedorConstantesFunciones.getContenedorDescripcion(this);
		} else {
			sDetalle=ContenedorConstantesFunciones.getContenedorDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Contenedor getContenedorOriginal() {
		return this.contenedorOriginal;
	}
	
	public void setContenedorOriginal(Contenedor contenedor) {
		try {
			this.contenedorOriginal=contenedor;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ContenedorAdditional contenedorAdditional=null;
	
	public ContenedorAdditional getContenedorAdditional() {
		return this.contenedorAdditional;
	}
	
	public void setContenedorAdditional(ContenedorAdditional contenedorAdditional) {
		try {
			this.contenedorAdditional=contenedorAdditional;
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
    
	
	public Long getid_pedido() {
		return this.id_pedido;
	}
    
	
	public String getnumero() {
		return this.numero;
	}
    
	
	public String getnumero_bl() {
		return this.numero_bl;
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
						System.out.println("Contenedor:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Contenedor:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pedido(Long newid_pedido)throws Exception
	{
		try {
			if(this.id_pedido!=newid_pedido) {
				if(newid_pedido==null) {
					//newid_pedido=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Contenedor:Valor nulo no permitido en columna id_pedido");
					}
				}

				this.id_pedido=newid_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero(String newnumero)throws Exception
	{
		try {
			if(this.numero!=newnumero) {
				if(newnumero==null) {
					//newnumero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Contenedor:Valor nulo no permitido en columna numero");
					}
				}

				if(newnumero!=null&&newnumero.length()>50) {
					newnumero=newnumero.substring(0,48);
					System.out.println("Contenedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero");
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_bl(String newnumero_bl)throws Exception
	{
		try {
			if(this.numero_bl!=newnumero_bl) {
				if(newnumero_bl==null) {
					//newnumero_bl="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Contenedor:Valor nulo no permitido en columna numero_bl");
					}
				}

				if(newnumero_bl!=null&&newnumero_bl.length()>50) {
					newnumero_bl=newnumero_bl.substring(0,48);
					System.out.println("Contenedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_bl");
				}

				this.numero_bl=newnumero_bl;
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
						System.out.println("Contenedor:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("Contenedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
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

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getpedido_descripcion() {
		return this.pedido_descripcion;
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


	public  void  setPedido(Pedido pedido) {
		try {
			this.pedido=pedido;
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


	public  void  setpedido_descripcion(String pedido_descripcion) {
		try {
			this.pedido_descripcion=pedido_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_pedido_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_pedido_descripcion() {
		return id_pedido_descripcion;
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
	public void setid_pedido_descripcion(String newid_pedido_descripcion)throws Exception {
		try {
			this.id_pedido_descripcion=newid_pedido_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_pedido_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

