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
//import com.bydan.erp.cartera.util.ClienteCoaConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ClienteCoa extends ClienteCoaAdditional implements Serializable ,Cloneable {//ClienteCoaAdditional,GeneralEntity
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
	
	private ClienteCoa clientecoaOriginal;
	
	private Map<String, Object> mapClienteCoa;
			
	public Map<String, Object> getMapClienteCoa() {
		return mapClienteCoa;
	}

	public void setMapClienteCoa(Map<String, Object> mapClienteCoa) {
		this.mapClienteCoa = mapClienteCoa;
	}
	
	public void inicializarMapClienteCoa() {
		this.mapClienteCoa = new HashMap<String,Object>();
	}
	
	public void setMapClienteCoaValue(String sKey,Object oValue) {
		this.mapClienteCoa.put(sKey, oValue);
	}
	
	public Object getMapClienteCoaValue(String sKey) {
		return this.mapClienteCoa.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ClienteCoaConstantesFunciones.SREGEXAUTORI_IMPRENTA,message=ClienteCoaConstantesFunciones.SMENSAJEREGEXAUTORI_IMPRENTA)
	private String autori_imprenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ClienteCoaConstantesFunciones.SREGEXAUTORI_USUARIO,message=ClienteCoaConstantesFunciones.SMENSAJEREGEXAUTORI_USUARIO)
	private String autori_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ClienteCoaConstantesFunciones.SREGEXNUM_FACTURA_INI,message=ClienteCoaConstantesFunciones.SMENSAJEREGEXNUM_FACTURA_INI)
	private String num_factura_ini;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ClienteCoaConstantesFunciones.SREGEXNUM_FACTURA_FIN,message=ClienteCoaConstantesFunciones.SMENSAJEREGEXNUM_FACTURA_FIN)
	private String num_factura_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ClienteCoaConstantesFunciones.SREGEXSERIE_DOCU,message=ClienteCoaConstantesFunciones.SMENSAJEREGEXSERIE_DOCU)
	private String serie_docu;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vali;
			
	
	public Empresa empresa;
	public Cliente cliente;
	public Usuario usuario;
	
	
	private String empresa_descripcion;
	private String cliente_descripcion;
	private String usuario_descripcion;
	
	
		
	public ClienteCoa () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.clientecoaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cliente=-1L;
 		this.id_usuario=-1L;
 		this.autori_imprenta="";
 		this.autori_usuario="";
 		this.num_factura_ini="";
 		this.num_factura_fin="";
 		this.serie_docu="";
 		this.fecha_vali=new Date();
		
		
		this.empresa=null;
		this.cliente=null;
		this.usuario=null;
		
		
		this.empresa_descripcion="";
		this.cliente_descripcion="";
		this.usuario_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ClienteCoa (Long id,Date versionRow,Long id_empresa,Long id_cliente,Long id_usuario,String autori_imprenta,String autori_usuario,String num_factura_ini,String num_factura_fin,String serie_docu,Date fecha_vali) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.clientecoaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.id_usuario=id_usuario;
 		this.autori_imprenta=autori_imprenta;
 		this.autori_usuario=autori_usuario;
 		this.num_factura_ini=num_factura_ini;
 		this.num_factura_fin=num_factura_fin;
 		this.serie_docu=serie_docu;
 		this.fecha_vali=fecha_vali;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ClienteCoa (Long id_empresa,Long id_cliente,Long id_usuario,String autori_imprenta,String autori_usuario,String num_factura_ini,String num_factura_fin,String serie_docu,Date fecha_vali) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.clientecoaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.id_usuario=id_usuario;
 		this.autori_imprenta=autori_imprenta;
 		this.autori_usuario=autori_usuario;
 		this.num_factura_ini=num_factura_ini;
 		this.num_factura_fin=num_factura_fin;
 		this.serie_docu=serie_docu;
 		this.fecha_vali=fecha_vali;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ClienteCoa clientecoaLocal=null;
		
		if(object!=null) {
			clientecoaLocal=(ClienteCoa)object;
			
			if(clientecoaLocal!=null) {
				if(this.getId()!=null && clientecoaLocal.getId()!=null) {
					if(this.getId().equals(clientecoaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ClienteCoaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ClienteCoaConstantesFunciones.getClienteCoaDescripcion(this);
		} else {
			sDetalle=ClienteCoaConstantesFunciones.getClienteCoaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ClienteCoa getClienteCoaOriginal() {
		return this.clientecoaOriginal;
	}
	
	public void setClienteCoaOriginal(ClienteCoa clientecoa) {
		try {
			this.clientecoaOriginal=clientecoa;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ClienteCoaAdditional clientecoaAdditional=null;
	
	public ClienteCoaAdditional getClienteCoaAdditional() {
		return this.clientecoaAdditional;
	}
	
	public void setClienteCoaAdditional(ClienteCoaAdditional clientecoaAdditional) {
		try {
			this.clientecoaAdditional=clientecoaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public String getautori_imprenta() {
		return this.autori_imprenta;
	}
    
	
	public String getautori_usuario() {
		return this.autori_usuario;
	}
    
	
	public String getnum_factura_ini() {
		return this.num_factura_ini;
	}
    
	
	public String getnum_factura_fin() {
		return this.num_factura_fin;
	}
    
	
	public String getserie_docu() {
		return this.serie_docu;
	}
    
	
	public Date getfecha_vali() {
		return this.fecha_vali;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteCoa:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("ClienteCoa:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
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
						System.out.println("ClienteCoa:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setautori_imprenta(String newautori_imprenta)throws Exception
	{
		try {
			if(this.autori_imprenta!=newautori_imprenta) {
				if(newautori_imprenta==null) {
					//newautori_imprenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteCoa:Valor nulo no permitido en columna autori_imprenta");
					}
				}

				if(newautori_imprenta!=null&&newautori_imprenta.length()>50) {
					newautori_imprenta=newautori_imprenta.substring(0,48);
					System.out.println("ClienteCoa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna autori_imprenta");
				}

				this.autori_imprenta=newautori_imprenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setautori_usuario(String newautori_usuario)throws Exception
	{
		try {
			if(this.autori_usuario!=newautori_usuario) {
				if(newautori_usuario==null) {
					//newautori_usuario="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteCoa:Valor nulo no permitido en columna autori_usuario");
					}
				}

				if(newautori_usuario!=null&&newautori_usuario.length()>50) {
					newautori_usuario=newautori_usuario.substring(0,48);
					System.out.println("ClienteCoa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna autori_usuario");
				}

				this.autori_usuario=newautori_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnum_factura_ini(String newnum_factura_ini)throws Exception
	{
		try {
			if(this.num_factura_ini!=newnum_factura_ini) {
				if(newnum_factura_ini==null) {
					//newnum_factura_ini="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteCoa:Valor nulo no permitido en columna num_factura_ini");
					}
				}

				if(newnum_factura_ini!=null&&newnum_factura_ini.length()>50) {
					newnum_factura_ini=newnum_factura_ini.substring(0,48);
					System.out.println("ClienteCoa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna num_factura_ini");
				}

				this.num_factura_ini=newnum_factura_ini;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnum_factura_fin(String newnum_factura_fin)throws Exception
	{
		try {
			if(this.num_factura_fin!=newnum_factura_fin) {
				if(newnum_factura_fin==null) {
					//newnum_factura_fin="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteCoa:Valor nulo no permitido en columna num_factura_fin");
					}
				}

				if(newnum_factura_fin!=null&&newnum_factura_fin.length()>50) {
					newnum_factura_fin=newnum_factura_fin.substring(0,48);
					System.out.println("ClienteCoa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna num_factura_fin");
				}

				this.num_factura_fin=newnum_factura_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setserie_docu(String newserie_docu)throws Exception
	{
		try {
			if(this.serie_docu!=newserie_docu) {
				if(newserie_docu==null) {
					//newserie_docu="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteCoa:Valor nulo no permitido en columna serie_docu");
					}
				}

				if(newserie_docu!=null&&newserie_docu.length()>50) {
					newserie_docu=newserie_docu.substring(0,48);
					System.out.println("ClienteCoa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna serie_docu");
				}

				this.serie_docu=newserie_docu;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vali(Date newfecha_vali)throws Exception
	{
		try {
			if(this.fecha_vali!=newfecha_vali) {
				if(newfecha_vali==null) {
					//newfecha_vali=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteCoa:Valor nulo no permitido en columna fecha_vali");
					}
				}

				this.fecha_vali=newfecha_vali;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cliente_descripcion="";String id_usuario_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cliente_descripcion="";this.id_usuario_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

